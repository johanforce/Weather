package com.example.weather.entities;

public class Country{
    public String value;

    @Override
    public String toString() {
        return "Country{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Country(String value) {
        this.value = value;
    }
}
