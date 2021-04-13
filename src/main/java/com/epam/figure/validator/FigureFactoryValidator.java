package com.epam.figure.validator;

import com.epam.figure.exception.FigureException;

public class FigureFactoryValidator {


    public static void validateSphereParameters(double... params) throws FigureException {
        if (params.length != 4) {
            throw new FigureException("wrong number of parameters : " + params.length);
        }
        if (params[3] <= 0) {
            throw new FigureException("radius cannot be less then 0 [four parameter]. radius : " + params[3]);
        }
    }
}
