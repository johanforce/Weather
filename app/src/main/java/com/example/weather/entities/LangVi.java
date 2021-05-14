package com.example.weather.entities;

public class LangVi{
    public String value;

    public LangVi(String value) {
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
        return "LangVi{" +
                "value='" + value + '\'' +
                '}';
    }
}
