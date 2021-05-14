package com.example.weather.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Hourly implements Serializable {
    @JsonProperty("DewPointC")
    public String dewPointC;
    @JsonProperty("DewPointF")
    public String dewPointF;
    @JsonProperty("FeelsLikeC")
    public String feelsLikeC;
    @JsonProperty("FeelsLikeF")
    public String feelsLikeF;
    @JsonProperty("HeatIndexC")
    public String heatIndexC;
    @JsonProperty("HeatIndexF")
    public String heatIndexF;
    @JsonProperty("WindChillC")
    public String windChillC;
    @JsonProperty("WindChillF")
    public String windChillF;
    @JsonProperty("WindGustKmph")
    public String windGustKmph;
    @JsonProperty("WindGustMiles")
    public String windGustMiles;
    public String chanceoffog;
    public String chanceoffrost;
    public String chanceofhightemp;
    public String chanceofovercast;
    public String chanceofrain;
    public String chanceofremdry;
    public String chanceofsnow;
    public String chanceofsunshine;
    public String chanceofthunder;
    public String chanceofwindy;
    public String cloudcover;
    public String humidity;
    public List<LangVi> lang_vi;
    public String precipInches;
    public String precipMM;
    public String pressure;
    public String pressureInches;
    public String tempC;
    public String tempF;
    public String time;
    public String uvIndex;
    public String visibility;
    public String visibilityMiles;
    public String weatherCode;
    public List<WeatherDesc> weatherDesc;
    public List<WeatherIconUrl> weatherIconUrl;
    public String winddir16Point;
    public String winddirDegree;
    public String windspeedKmph;
    public String windspeedMiles;

    @Override
    public String toString() {
        return "Hourly{" +
                "dewPointC='" + dewPointC + '\'' +
                ", dewPointF='" + dewPointF + '\'' +
                ", feelsLikeC='" + feelsLikeC + '\'' +
                ", feelsLikeF='" + feelsLikeF + '\'' +
                ", heatIndexC='" + heatIndexC + '\'' +
                ", heatIndexF='" + heatIndexF + '\'' +
                ", windChillC='" + windChillC + '\'' +
                ", windChillF='" + windChillF + '\'' +
                ", windGustKmph='" + windGustKmph + '\'' +
                ", windGustMiles='" + windGustMiles + '\'' +
                ", chanceoffog='" + chanceoffog + '\'' +
                ", chanceoffrost='" + chanceoffrost + '\'' +
                ", chanceofhightemp='" + chanceofhightemp + '\'' +
                ", chanceofovercast='" + chanceofovercast + '\'' +
                ", chanceofrain='" + chanceofrain + '\'' +
                ", chanceofremdry='" + chanceofremdry + '\'' +
                ", chanceofsnow='" + chanceofsnow + '\'' +
                ", chanceofsunshine='" + chanceofsunshine + '\'' +
                ", chanceofthunder='" + chanceofthunder + '\'' +
                ", chanceofwindy='" + chanceofwindy + '\'' +
                ", cloudcover='" + cloudcover + '\'' +
                ", humidity='" + humidity + '\'' +
                ", lang_vi=" + lang_vi +
                ", precipInches='" + precipInches + '\'' +
                ", precipMM='" + precipMM + '\'' +
                ", pressure='" + pressure + '\'' +
                ", pressureInches='" + pressureInches + '\'' +
                ", tempC='" + tempC + '\'' +
                ", tempF='" + tempF + '\'' +
                ", time='" + time + '\'' +
                ", uvIndex='" + uvIndex + '\'' +
                ", visibility='" + visibility + '\'' +
                ", visibilityMiles='" + visibilityMiles + '\'' +
                ", weatherCode='" + weatherCode + '\'' +
                ", weatherDesc=" + weatherDesc +
                ", weatherIconUrl=" + weatherIconUrl +
                ", winddir16Point='" + winddir16Point + '\'' +
                ", winddirDegree='" + winddirDegree + '\'' +
                ", windspeedKmph='" + windspeedKmph + '\'' +
                ", windspeedMiles='" + windspeedMiles + '\'' +
                '}';
    }

    public String getDewPointC() {
        return dewPointC;
    }

    public void setDewPointC(String dewPointC) {
        this.dewPointC = dewPointC;
    }

    public String getDewPointF() {
        return dewPointF;
    }

    public void setDewPointF(String dewPointF) {
        this.dewPointF = dewPointF;
    }

    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    public String getHeatIndexC() {
        return heatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    public String getHeatIndexF() {
        return heatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        this.heatIndexF = heatIndexF;
    }

    public String getWindChillC() {
        return windChillC;
    }

    public void setWindChillC(String windChillC) {
        this.windChillC = windChillC;
    }

    public String getWindChillF() {
        return windChillF;
    }

    public void setWindChillF(String windChillF) {
        this.windChillF = windChillF;
    }

    public String getWindGustKmph() {
        return windGustKmph;
    }

    public void setWindGustKmph(String windGustKmph) {
        this.windGustKmph = windGustKmph;
    }

    public String getWindGustMiles() {
        return windGustMiles;
    }

    public void setWindGustMiles(String windGustMiles) {
        this.windGustMiles = windGustMiles;
    }

    public String getChanceoffog() {
        return chanceoffog;
    }

    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public String getChanceoffrost() {
        return chanceoffrost;
    }

    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public String getChanceofovercast() {
        return chanceofovercast;
    }

    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public String getChanceofrain() {
        return chanceofrain;
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public String getChanceofremdry() {
        return chanceofremdry;
    }

    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public String getChanceofsnow() {
        return chanceofsnow;
    }

    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public String getChanceofthunder() {
        return chanceofthunder;
    }

    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    public String getChanceofwindy() {
        return chanceofwindy;
    }

    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public List<LangVi> getLang_vi() {
        return lang_vi;
    }

    public void setLang_vi(List<LangVi> lang_vi) {
        this.lang_vi = lang_vi;
    }

    public String getPrecipInches() {
        return precipInches;
    }

    public void setPrecipInches(String precipInches) {
        this.precipInches = precipInches;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPressureInches() {
        return pressureInches;
    }

    public void setPressureInches(String pressureInches) {
        this.pressureInches = pressureInches;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibilityMiles() {
        return visibilityMiles;
    }

    public void setVisibilityMiles(String visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public Hourly(String dewPointC, String dewPointF, String feelsLikeC, String feelsLikeF, String heatIndexC, String heatIndexF, String windChillC, String windChillF, String windGustKmph, String windGustMiles, String chanceoffog, String chanceoffrost, String chanceofhightemp, String chanceofovercast, String chanceofrain, String chanceofremdry, String chanceofsnow, String chanceofsunshine, String chanceofthunder, String chanceofwindy, String cloudcover, String humidity, List<LangVi> lang_vi, String precipInches, String precipMM, String pressure, String pressureInches, String tempC, String tempF, String time, String uvIndex, String visibility, String visibilityMiles, String weatherCode, List<WeatherDesc> weatherDesc, List<WeatherIconUrl> weatherIconUrl, String winddir16Point, String winddirDegree, String windspeedKmph, String windspeedMiles) {
        this.dewPointC = dewPointC;
        this.dewPointF = dewPointF;
        this.feelsLikeC = feelsLikeC;
        this.feelsLikeF = feelsLikeF;
        this.heatIndexC = heatIndexC;
        this.heatIndexF = heatIndexF;
        this.windChillC = windChillC;
        this.windChillF = windChillF;
        this.windGustKmph = windGustKmph;
        this.windGustMiles = windGustMiles;
        this.chanceoffog = chanceoffog;
        this.chanceoffrost = chanceoffrost;
        this.chanceofhightemp = chanceofhightemp;
        this.chanceofovercast = chanceofovercast;
        this.chanceofrain = chanceofrain;
        this.chanceofremdry = chanceofremdry;
        this.chanceofsnow = chanceofsnow;
        this.chanceofsunshine = chanceofsunshine;
        this.chanceofthunder = chanceofthunder;
        this.chanceofwindy = chanceofwindy;
        this.cloudcover = cloudcover;
        this.humidity = humidity;
        this.lang_vi = lang_vi;
        this.precipInches = precipInches;
        this.precipMM = precipMM;
        this.pressure = pressure;
        this.pressureInches = pressureInches;
        this.tempC = tempC;
        this.tempF = tempF;
        this.time = time;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.visibilityMiles = visibilityMiles;
        this.weatherCode = weatherCode;
        this.weatherDesc = weatherDesc;
        this.weatherIconUrl = weatherIconUrl;
        this.winddir16Point = winddir16Point;
        this.winddirDegree = winddirDegree;
        this.windspeedKmph = windspeedKmph;
        this.windspeedMiles = windspeedMiles;
    }
}