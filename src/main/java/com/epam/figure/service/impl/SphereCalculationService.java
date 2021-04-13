package com.epam.figure.service.impl;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Sphere;
import com.epam.figure.exception.FigureException;
import com.epam.figure.service.CalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereCalculationService implements CalculationService {
    private final static Logger LOGGER = LogManager.getLogger(SphereCalculationService.class);

    @Override
    public double volume(AbstractFigure figure) {
        Sphere sphere = (Sphere) figure;
        LOGGER.log(Level.INFO, "function area take obj :" + figure);
        return Math.round((double) 4 / 3 * Math.PI * Math.pow(sphere.getRadius(), 3));
    }

    @Override
    public double squareSurface(AbstractFigure figure) {
        Sphere sphere = (Sphere) figure;
        LOGGER.log(Level.INFO, "function squareSurface take obj :" + figure);
        return Math.round(4 * Math.PI * Math.pow(sphere.getRadius(), 2));
    }

    @Override
    public boolean planeIntersection(AbstractFigure figure, double height, String coordinatePlane) throws FigureException, CloneNotSupportedException {
        Sphere sphere = (Sphere) figure;
        double coordinateFigure = currentCoordinateFigure(sphere, coordinatePlane);
        double radius = sphere.getRadius();
        double min = coordinateFigure - radius;
        double max = coordinateFigure + radius;
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("function planeIntersection take obj : ").append(figure)
                .append(" with height : ").append(height)
                .append(" coordinate plane : ").append(coordinateFigure).toString());
        return (min != max || max != 0) && (min <= height && max >= height);
    }

    @Override
    public double spaceRatio(AbstractFigure figure, double height, String coordinatePlane) throws FigureException, CloneNotSupportedException {
        Sphere sphere = (Sphere) figure;
        if (!planeIntersection(figure, height, coordinatePlane)) {
            throw new FigureException(
                    new StringBuilder()
                            .append("the sphere :").append(sphere)
                            .append(" does not intersect with the plane :")
                            .append(coordinatePlane)
                            .append(" on height :").append(height).toString());
        }
        if(height == sphere.getRadius()){
            throw new FigureException(new StringBuilder()
                    .append("cannot ratio segment with this coordinate plane").append(figure)
                    .append(" plane with height : ").append(height)
                    .append(" by two axis : ").append(coordinatePlane).toString());
        }
        double spaceRatio;
        double coordinateFigure = currentCoordinateFigure(sphere, coordinatePlane);
        double segmentHeight = height >= coordinateFigure
                ? Math.abs(Math.abs(height) - Math.abs(coordinateFigure + sphere.getRadius()))
                : Math.abs(Math.abs(height) - Math.abs(coordinateFigure - sphere.getRadius()));
        double segmentArea = areaSphereSegment(segmentHeight, sphere.getRadius());
        double biggerSegmentArea = volume(figure) - segmentArea;
        spaceRatio = Math.round(biggerSegmentArea / segmentArea);
        return spaceRatio;
    }

    /**
     * @param sphere          figure with (x,y,z) centre
     * @param coordinatePlane coordinate plane by two axis
     * @return current coordinate x or y or z from Point within coordinate plane
     */
    private double currentCoordinateFigure(Sphere sphere, String coordinatePlane) throws FigureException, CloneNotSupportedException {
        double coordinateFigure;
        switch (coordinatePlane) {
            case "yx":
            case "xy": {
                coordinateFigure = sphere.getPoint().getZ();
            }
            break;
            case "zx":
            case "xz": {
                coordinateFigure = sphere.getPoint().getY();

            }
            break;
            case "zy":
            case "yz": {
                coordinateFigure = sphere.getPoint().getX();
            }
            break;
            default: {
                LOGGER.log(Level.ERROR, "Invalid coordinate plane :" + coordinatePlane);
                throw new FigureException("Invalid coordinate plane");
            }
        }
        return coordinateFigure;
    }


    /**
     * @param height height of sphere segment
     * @param radius radius of sphere
     * @return area of sphere segment
     */
    private double areaSphereSegment(double height, double radius) {
        return Math.PI * Math.pow(height, 2) * (radius - (double) 1 / 3 * height);
    }
}
