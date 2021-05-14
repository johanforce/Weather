package com.example.weather.entities;

import java.util.List;

public class Root{
    public List<CurrentCondition> current_condition;
    public List<NearestArea> nearest_area;
    public List<Request> request;
    public List<Weather> weather;

    @Override
    public String toString() {
        return "Root{" +
                "current_condition=" + current_condition +
                ", nearest_area=" + nearest_area +
                ", request=" + request +
                ", weather=" + weather +
                '}';
    }

    public List<CurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(List<CurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public List<NearestArea> getNearest_area() {
        return nearest_area;
    }

    public void setNearest_area(List<NearestArea> nearest_area) {
        this.nearest_area = nearest_area;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Root(List<CurrentCondition> current_condition, List<NearestArea> nearest_area, List<Request> request, List<Weather> weather) {
        this.current_condition = current_condition;
        this.nearest_area = nearest_area;
        this.request = request;
        this.weather = weather;
    }
}