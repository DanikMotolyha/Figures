package com.epam.figure.entity;

public class FigureInfo {
    private double area;
    private double volume;


    public FigureInfo(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FigureInfo that = (FigureInfo) o;
        return Double.compare(that.area, area) == 0
                && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 + area + volume);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("FigureInfo{")
                .append("area= ").append(area)
                .append(", volume=").append(volume)
                .append('}').toString();
    }
}
