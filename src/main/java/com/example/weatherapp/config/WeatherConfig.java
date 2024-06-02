package com.example.weatherapp.config;

import com.example.weatherapp.model.WeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class WeatherConfig {
    @Bean
    public WeatherData weatherData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new ClassPathResource("weather_results.json").getFile(), WeatherData.class);

    }
}
