package com.epam.figure.repository.impl;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Specification;
import com.epam.figure.entity.Sphere;
import com.epam.figure.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RadiusSpecification implements Specification {

    private double radius;

    public RadiusSpecification(double radius) {
        this.radius = radius;
    }


    @Override
    public boolean specify(AbstractFigure figure) {
        Sphere sphere = (Sphere) figure;
        return sphere.getRadius() == radius;
    }
}
