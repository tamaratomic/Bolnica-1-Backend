package raf.bolnica1.patient.config.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class UserServiceClientConfig {
        @Bean
        @Qualifier("userRestTemplate")
        public RestTemplate userServiceRestTemplate() {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8080/api/auth"));
            return restTemplate;
        }

        @Bean
        @Qualifier("employeeRestTemplate")
        public RestTemplate employeeServiceRestTemplate() {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8080/api/employee"));
            return restTemplate;
        }

}
