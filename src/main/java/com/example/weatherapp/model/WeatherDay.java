package com.example.weatherapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherDay {
    private int high;
    private int low;
    private String condition;
}
