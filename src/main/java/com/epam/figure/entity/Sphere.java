package com.epam.figure.entity;

import java.util.Objects;

public class Sphere extends Figure {
    private final Point point;
    private final double radius;

    public Sphere(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                Objects.equals(point, sphere.point);
    }

    @Override
    public int hashCode() {
        return (int) ((point.getX() + point.getY() + point.getZ())
                * super.getFigureId() + radius);
    }

    @Override
    public String toString() {
        return new StringBuilder().append('[')
                .append(super.toString())
                .append("Sphere{").append(point)
                .append(", radius=").append(radius)
                .append("}]").toString();
    }
}
