package com.example.speedcounter;

/**
 * Created by J16012 on 2018/01/18.
 */

public class RouteData {
    private double s_longitude,s_latitude,e_longitude,e_latitude;
    private String s_Name,e_Name;
    RouteData(double s_longitude,double s_latitude,double e_longitude,double e_latitude,String s_Name,String e_Name){
        this.s_longitude=s_longitude;
        this.s_latitude=s_latitude;
        this.e_longitude=e_longitude;
        this.e_latitude=e_latitude;
        this.s_Name=s_Name;
        this.e_Name=e_Name;
    }

}
