package com.portafolio.reservas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portafolio.reservas.model.Appointment;
import com.portafolio.reservas.model.ServiceEntity;
import com.portafolio.reservas.model.User;
import com.portafolio.reservas.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:mysql://localhost:3306/reservas_db",
    "spring.datasource.username=root",
    "spring.datasource.password=Nachoc04042017@"
})
@AutoConfigureMockMvc
public class FlowIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        userRepository.deleteAll();
        // Crear un usuario de prueba para el login
        User testUser = new User();
        testUser.setUsername("admin");
        testUser.setPassword("123456");
        testUser.setRole("ROLE_ADMIN");
        userRepository.save(testUser);
    }

    @Test
    public void testFullFlow() throws Exception {
        // --- PASO 1: LOGIN ---
        Map<String, String> loginReq = new HashMap<>();
        loginReq.put("username", "admin");
        loginReq.put("password", "123456");

        MvcResult authResult = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginReq)))
                .andExpect(status().isOk())
                .andReturn();

        // Extraer el token del JSON de respuesta
        String responseContent = authResult.getResponse().getContentAsString();
        Map<String, String> responseMap = objectMapper.readValue(responseContent, Map.class);
        String token = responseMap.get("token");

        // --- PASO 2: CREAR SERVICIO ---
        ServiceEntity service = new ServiceEntity();
        service.setName("Masaje Relajante");
        service.setPrice(100.0);
        service.setDurationMinutes(60);

        MvcResult serviceResult = mockMvc.perform(post("/api/services")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(service)))
                .andExpect(status().isOk())
                .andReturn();

        ServiceEntity savedService = objectMapper.readValue(
                serviceResult.getResponse().getContentAsString(), ServiceEntity.class);

        // --- PASO 3: CREAR CITA ---
        Appointment appointment = new Appointment();
        appointment.setClientName("Juan Perez");
        appointment.setClientEmail("juan@example.com");
        appointment.setDateTime(LocalDateTime.now().plusDays(2));
        appointment.setService(savedService);

        mockMvc.perform(post("/api/appointments")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointment)))
                .andExpect(status().isOk());
                
        System.out.println("¡FLUJO COMPLETADO CON ÉXITO!");
    }
}