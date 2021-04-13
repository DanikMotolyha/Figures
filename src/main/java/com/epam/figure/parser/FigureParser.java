package com.epam.figure.parser;

import com.epam.figure.validator.FigureFactoryValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FigureParser {
    private final static Logger LOGGER = LogManager.getLogger(FigureFactoryValidator.class);

    public double[] parse(String line) {
        String[] arrayLine = line.trim().split(" ");
        double[] doubles = Arrays.stream(arrayLine)
                .mapToDouble(Double::parseDouble).toArray();
        LOGGER.log(Level.INFO, new StringBuilder()
                .append("parse line : ")
                .append(line).toString());
        return doubles;
    }
}
