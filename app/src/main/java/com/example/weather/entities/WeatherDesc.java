package com.example.weather.entities;

public class WeatherDesc{
    public String value;

    @Override
    public String toString() {
        return "WeatherDesc{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public WeatherDesc(String value) {
        this.value = value;
    }
}
