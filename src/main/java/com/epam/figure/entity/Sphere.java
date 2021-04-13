package com.epam.figure.entity;

import com.epam.figure.exception.FigureException;
import com.epam.figure.observer.Observable;
import com.epam.figure.observer.Observer;
import com.epam.figure.observer.SphereEvent;
import com.epam.figure.validator.FigureFactoryValidator;

import java.util.Comparator;
import java.util.Objects;

public class Sphere extends AbstractFigure implements Cloneable, Observable {
    private Point point;
    private double radius;
    private Observer observer;

    public Sphere(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() throws CloneNotSupportedException {
        return point.clone();
    }

    public void setPoint(Point point) {
        this.point = point;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws FigureException {
        if(radius < 0){
            throw new FigureException("new radius cannot be less then 0");
        }
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public Sphere clone() throws CloneNotSupportedException {
        return (Sphere) super.clone();
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

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        SphereEvent event = new SphereEvent(this);
        if (observer != null) {
            observer.parameterChanged(event);
        }
    }

    public static class RadiusComparator implements Comparator<Sphere> {
        @Override
        public int compare(Sphere sphere, Sphere sphere2) {
            return Double.compare(sphere.getRadius(), sphere2.getRadius());
        }
    }

    public static class CoordinateXComparator implements Comparator<Sphere> {
        @Override
        public int compare(Sphere sphere, Sphere sphere2) {
            double x = sphere.point.getX();
            double y = sphere2.point.getX();
            return Double.compare(x, y);
        }
    }
}
