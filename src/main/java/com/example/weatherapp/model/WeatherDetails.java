package com.example.weatherapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherDetails {
    private String location;
    private String lastModified;
}
