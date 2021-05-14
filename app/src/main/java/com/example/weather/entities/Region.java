package com.example.weather.entities;

public class Region{
    public String value;

    public Region(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Region{" +
                "value='" + value + '\'' +
                '}';
    }
}