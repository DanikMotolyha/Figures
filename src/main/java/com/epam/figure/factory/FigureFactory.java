package com.epam.figure.factory;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Point;
import com.epam.figure.entity.Sphere;
import com.epam.figure.exception.FigureException;
import com.epam.figure.validator.FigureFactoryValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(FigureFactory.class);


    public FigureFactory() {
        // init factory
    }

    public AbstractFigure create(double... params) throws FigureException {
        try {
            FigureFactoryValidator.validateSphereParameters(params);
            Point point = new Point(params[0], params[1], params[2]);
            LOGGER.log(Level.INFO, new StringBuilder()
                    .append("Creating object with :").append(point)
                    .append(" radius :").append(params[3]));
            return new Sphere(point, params[3]);
        } catch (FigureException e) {
            throw new FigureException(e.getMessage());
        }
    }
}
