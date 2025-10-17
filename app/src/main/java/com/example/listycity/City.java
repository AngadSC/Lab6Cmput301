package com.example.listycity;

/**
 * this is a class that defines a City
 */

public class City implements Comparable {
    private String city;
    private String province;

    City(String city, String province){
        this.city = city;
        this.province = province;
    }


    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
    @Override
    public boolean equals(Object object) {
        if (this ==object) return true;
        if(!(object instanceof City)) return false;
        City other = (City) object;
        return city.equals(other.city) && province.equals(other.province);
    }
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31* result+province.hashCode();
        return result;
    }
}

