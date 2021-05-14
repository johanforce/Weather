package com.example.weather.entities;

public class WeatherIconUrl{
    public String value;

    @Override
    public String toString() {
        return "WeatherIconUrl{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public WeatherIconUrl(String value) {
        this.value = value;
    }
}