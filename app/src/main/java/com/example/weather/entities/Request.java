package com.example.weather.entities;

public class Request{
    public String query;
    public String type;

    @Override
    public String toString() {
        return "Request{" +
                "query='" + query + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Request(String query, String type) {
        this.query = query;
        this.type = type;
    }
}