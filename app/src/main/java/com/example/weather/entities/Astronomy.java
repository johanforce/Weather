package com.example.weather.entities;

public class Astronomy{
    public String moon_illumination;
    public String moon_phase;
    public String moonrise;
    public String moonset;
    public String sunrise;
    public String sunset;

    @Override
    public String toString() {
        return "Astronomy{" +
                "moon_illumination='" + moon_illumination + '\'' +
                ", moon_phase='" + moon_phase + '\'' +
                ", moonrise='" + moonrise + '\'' +
                ", moonset='" + moonset + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }

    public String getMoon_illumination() {
        return moon_illumination;
    }

    public void setMoon_illumination(String moon_illumination) {
        this.moon_illumination = moon_illumination;
    }

    public String getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(String moon_phase) {
        this.moon_phase = moon_phase;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Astronomy(String moon_illumination, String moon_phase, String moonrise, String moonset, String sunrise, String sunset) {
        this.moon_illumination = moon_illumination;
        this.moon_phase = moon_phase;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}