package com.epam.figure.repository.impl;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Point;
import com.epam.figure.entity.Specification;
import com.epam.figure.entity.Sphere;
import com.epam.figure.factory.FigureFactory;
import org.apache.logging.log4j.Level;
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
        boolean check = false;
        try {
            Sphere sphere = (Sphere) figure;
            check = sphere.getPoint().equals(point);
        } catch (CloneNotSupportedException ignored) {
            LOGGER.log(Level.ERROR, "CloneNotSupportedException with obj: " + figure);
        }
        return check;
    }
}
