package com.example.weather.entities;

public class WeatherUrl{
    public String value;

    public WeatherUrl(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WeatherUrl{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
