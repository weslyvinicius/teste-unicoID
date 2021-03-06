package br.com.test_unico.unicotest.adapter_in.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return JacksonUtils.getObjectMapper();
    }
}
