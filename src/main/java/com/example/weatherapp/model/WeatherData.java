package com.example.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private WeatherDetails details;
    @JsonProperty("days")
    private Map<String, WeatherDay> days;

    @JsonAnySetter
    public void setDays(String key, WeatherDay value) {
        if (this.days == null) {
            this.days = new java.util.HashMap<>();
        }
        this.days.put(key, value);
    }
}
