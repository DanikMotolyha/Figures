package com.epam.figure.entity;

public class Point implements Cloneable {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 + x + y + z);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Point{ x=").append(x)
                .append(", y=").append(y)
                .append(", z=").append(z)
                .append('}').toString();
    }
}
