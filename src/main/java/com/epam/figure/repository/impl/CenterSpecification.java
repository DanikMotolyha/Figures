package com.epam.figure.repository.impl;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Point;
import com.epam.figure.entity.Specification;
import com.epam.figure.entity.Sphere;
import com.epam.figure.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CenterSpecification implements Specification {
    private final static Logger LOGGER = LogManager.getLogger(FigureFactory.class);

    private Point point;

    public CenterSpecification(Point point) {
        this.point = point;
    }


    @Override
    public boolean specify(AbstractFigure figure) {
        Sphere sphere = (Sphere) figure;
        return sphere.getPoint().equals(point);
    }
}
