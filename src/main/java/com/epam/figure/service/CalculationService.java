package com.epam.figure.service;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.exception.FigureException;

public interface CalculationService {

    double volume(AbstractFigure figure);

    double squareSurface(AbstractFigure figure);

    boolean planeIntersection(AbstractFigure figure, double height, String coordinatePlanes) throws FigureException, CloneNotSupportedException;

    double spaceRatio(AbstractFigure figure, double height, String coordinatePlanes) throws FigureException, CloneNotSupportedException;
}
