package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherData getWeather() {
        return weatherService.getWeatherData();
    }

    @GetMapping("/average-high")
    public double getAverageHigh() {
        return weatherService.getAverageHighTemperature();
    }

    @GetMapping("/average-low")
    public double getAverageLow() {
        return weatherService.getAverageLowTemperature();
    }

    @GetMapping("/missing-temperatures")
    public List<Integer> getMissingTemperatures() {
        return weatherService.getMissingTemperatures();
    }
}