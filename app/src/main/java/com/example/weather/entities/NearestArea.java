package com.example.weather.entities;

import java.util.List;

public class NearestArea{
    public List<AreaName> areaName;
    public List<Country> country;
    public String latitude;
    public String longitude;
    public String population;
    public List<Region> region;
    public List<WeatherUrl> weatherUrl;

    @Override
    public String toString() {
        return "NearestArea{" +
                "areaName=" + areaName +
                ", country=" + country +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", population='" + population + '\'' +
                ", region=" + region +
                ", weatherUrl=" + weatherUrl +
                '}';
    }

    public List<AreaName> getAreaName() {
        return areaName;
    }

    public void setAreaName(List<AreaName> areaName) {
        this.areaName = areaName;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<Region> getRegion() {
        return region;
    }

    public void setRegion(List<Region> region) {
        this.region = region;
    }

    public List<WeatherUrl> getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(List<WeatherUrl> weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public NearestArea(List<AreaName> areaName, List<Country> country, String latitude, String longitude, String population, List<Region> region, List<WeatherUrl> weatherUrl) {
        this.areaName = areaName;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.region = region;
        this.weatherUrl = weatherUrl;
    }
}
