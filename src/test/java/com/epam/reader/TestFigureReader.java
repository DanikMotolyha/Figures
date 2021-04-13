package com.epam.reader;

import com.epam.figure.exception.FigureException;
import com.epam.figure.factory.FigureFactory;
import com.epam.figure.reader.FigureReader;
import com.epam.parser.TestFigureParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFigureReader {
    @DataProvider(name = "FigureReaderTestData")
    public Object[][] figureFactoryTestFailData() {
        return new Object[][]{
                {"src/main/resources/data/import.txt",
                        new ArrayList<>(
                                Arrays.asList(
                                        "1.0 23 15 48 34 12",
                                        "15 21 15 21 -1 51",
                                        "21 15 64 158 4 8",
                                        "1 5 -5 4 -48",
                                        "1 5 32 4",
                                        "0 0 0 5",
                                        "2 0 0 5",
                                        "1 0 0 5"))}
        };
    }

    @Test(dataProvider = "FigureReaderTestData")
    public void figureReaderTestData(String file, List<String> expected) throws FigureException {
        FigureReader reader = new FigureReader();
        List<String> lines = reader.read(file);
        Assert.assertEquals(lines, expected);
    }
}
