package com.epam.parser;

import com.epam.figure.parser.FigureParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFigureParser {
    @DataProvider(name = "FigureParserTestData")
    public Object[][] figureParserTestData() {
        return new Object[][]{
                {"1.0 23 15 48 34 12", new double[]{1.0, 23.0, 15.0, 48.0, 34.0, 12.0}},
                {"15 21 15 21 -1 51", new double[]{15.0, 21.0, 15.0, 21.0, -1.0, 51.0}},
                {"21 15 64 158 4 8", new double[]{21.0, 15.0, 64.0, 158.0, 4.0, 8.0}}
        };
    }

    @Test(dataProvider = "FigureParserTestData")
    public void figureParserTestData(String file, double[] expected) {
        FigureParser parser = new FigureParser();
        double[] parameters = parser.parse(file);
        Assert.assertEquals(parameters, expected);
    }
}