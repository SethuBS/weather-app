package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.model.WeatherDay;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
@Service
public class WeatherService {

    private final WeatherData weatherData;

    @Autowired
    public WeatherService(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public double getAverageHighTemperature() {
        return weatherData.getDays().values().stream()
                .mapToInt(WeatherDay::getHigh)
                .average()
                .orElse(0);
    }

    public double getAverageLowTemperature() {
        return weatherData.getDays().values().stream()
                .mapToInt(WeatherDay::getLow)
                .average()
                .orElse(0);
    }

    public List<Integer> getMissingTemperatures() {
        int min = weatherData.getDays().values().stream()
                .mapToInt(WeatherDay::getLow)
                .min()
                .orElse(0);
        int max = weatherData.getDays().values().stream()
                .mapToInt(WeatherDay::getHigh)
                .max()
                .orElse(0);
        return Stream.of(min, max).filter(t -> false).collect(Collectors.toList());
    }
}