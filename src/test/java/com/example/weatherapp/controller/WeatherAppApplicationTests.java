package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.model.WeatherDay;
import com.example.weatherapp.model.WeatherDetails;
import com.example.weatherapp.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class WeatherControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    void testGetWeather() throws Exception {
        // Prepare mock data
        var weatherData = new WeatherData();
        WeatherDay day1 = new WeatherDay();
        day1.setHigh(30);
        day1.setLow(13);
        day1.setCondition("Clear");

        WeatherDay day2 = new WeatherDay();
        day2.setHigh(19);
        day2.setLow(12);
        day2.setCondition("Partly Cloudy");

        Map<String, WeatherDay> days = new HashMap<>();
        days.put("day1", day1);
        days.put("day2", day2);

        weatherData.setDetails(new WeatherDetails());
        weatherData.getDetails().setLocation("Cape Town");
        weatherData.getDetails().setLastModified("2016-05-17");
        weatherData.setDays(days);
        when(weatherService.getWeatherData()).thenReturn(weatherData);

        mockMvc.perform(get("/weather"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"details\":{\"location\":\"Cape Town\",\"lastModified\":\"2016-05-17\"},\"days\":{\"day1\":{\"high\":30,\"low\":13,\"condition\":\"Clear\"},\"day2\":{\"high\":19,\"low\":12,\"condition\":\"Partly Cloudy\"}}}"));
    }


    @Test
    void getAverageHigh() throws Exception {
        when(weatherService.getAverageHighTemperature()).thenReturn(21.2);

        mockMvc.perform(get("/average-high")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("21.2"));
    }

    @Test
    void getAverageLow() throws Exception {
        when(weatherService.getAverageLowTemperature()).thenReturn(11.0);

        mockMvc.perform(get("/average-low")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("11.0"));
    }

    @Test
    void getMissingTemperatures() throws Exception {
        when(weatherService.getMissingTemperatures()).thenReturn(Arrays.asList(9, 10, 14, 15, 16, 18));

        mockMvc.perform(get("/missing-temperatures")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]", is(9)))
                .andExpect(jsonPath("$[1]", is(10)))
                .andExpect(jsonPath("$[2]", is(14)));
    }
}
