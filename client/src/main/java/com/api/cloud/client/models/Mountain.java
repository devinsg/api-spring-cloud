package com.api.cloud.client.models;

public class Mountain {
    private long id;
    private String name;
    private String range;
    private String country;
    private String firstAscent;

    public Mountain() {
        super();
    }

    public Mountain(long id, String name, String range, String country) {
        this.id = id;
        this.name = name;
        this.range = range;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstAscent() {
        return firstAscent;
    }

    public void setFirstAscent(String firstAscent) {
        this.firstAscent = firstAscent;
    }
}
