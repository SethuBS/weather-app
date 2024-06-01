package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.model.WeatherDay;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Service
public class WeatherService {

    private WeatherData weatherData;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.weatherData = mapper.readValue(new File("src/main/resources/static/weather_results.json"), WeatherData.class);
    }

    public List<Integer> getHighTemperatures() {
        return weatherData.getDays().values().stream().map(WeatherDay::getHigh).collect(Collectors.toList());
    }

    public List<Integer> getLowTemperatures() {
        return weatherData.getDays().values().stream().map(WeatherDay::getLow).collect(Collectors.toList());
    }

    public double getAverageHighTemperature() {
        return getHighTemperatures().stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public double getAverageLowTemperature() {
        return getLowTemperatures().stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
