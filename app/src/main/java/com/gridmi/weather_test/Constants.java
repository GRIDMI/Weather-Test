package com.gridmi.weather_test;

public class Constants {

    public static String API = "http://api.openweathermap.org/data/2.5/";
    public static String KEY = "6c06ce1180b3f0229c83e7051c647988";

    public static String getHandler(String endpoint) {
        return API.concat(endpoint);
    }

}
