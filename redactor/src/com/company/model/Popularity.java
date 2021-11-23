package com.company.model;

import java.util.Objects;

public class Popularity {

    private String city;
    private int point;

    public Popularity() {
    }

    public Popularity(String city, int point) {
        this.city = city;
        this.point = point;
    }

    public String getCity() {
        return city;
    }

    public int getPoint() {
        return point;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularity that = (Popularity) o;
        return point == that.point && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, point);
    }
}
