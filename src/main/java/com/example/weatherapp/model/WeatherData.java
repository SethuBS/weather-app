package com.example.weatherapp.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherData {
    private WeatherDetails details;
    private Map<String, WeatherDay> days;
}
