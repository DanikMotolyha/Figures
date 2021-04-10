package com.epam.figure.factory;

import com.epam.figure.entity.Figure;
import com.epam.figure.entity.Point;
import com.epam.figure.entity.Sphere;
import com.epam.figure.exception.FigureException;
import com.epam.figure.validator.FigureFactoryValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureFactory {
    private final static Logger LOGGER = LogManager.getLogger(FigureFactory.class);

    public FigureFactory() {
    }

    public Figure create(double... params) {
        try {
            FigureFactoryValidator.validateSphereParameters(params);
            Point point = new Point(params[0], params[1], params[2]);
            return new Sphere(point, params[3]);
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }
        return null;
    }
}
