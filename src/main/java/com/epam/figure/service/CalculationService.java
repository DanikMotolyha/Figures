package com.epam.figure.service;

import com.epam.figure.entity.Figure;
import com.epam.figure.exception.FigureException;

public interface CalculationService {

    double area(Figure figure);

    double squareSurface(Figure figure);

    boolean planeIntersection(Figure figure, double height, String coordinatePlanes) throws FigureException;

    double spaceRatioFromCoordinatePlane(Figure figure, double height, String coordinatePlanes) throws FigureException;
}
