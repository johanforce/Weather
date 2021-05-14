package com.example.weather.entities;

public class AreaName{
    public String value;

    @Override
    public String toString() {
        return "AreaName{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AreaName(String value) {
        this.value = value;
    }
}