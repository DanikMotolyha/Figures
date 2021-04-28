package com.epam.figure.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FigureParser {
    private static final Logger LOGGER = LogManager.getLogger(FigureParser.class);

    public double[] parse(String line) {
        String[] arrayLine = line.trim().split(" ");
        double[] doubles = Arrays.stream(arrayLine)
                .mapToDouble(Double::parseDouble).toArray();
        LOGGER.log(Level.INFO, "parse line : {}", line);
        return doubles;
    }
}
