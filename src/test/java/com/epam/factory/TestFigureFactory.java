package com.epam.factory;

import com.epam.figure.exception.FigureException;
import com.epam.figure.factory.FigureFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFigureFactory {

    @DataProvider(name = "figureFactoryTestData")
    public Object[][] figureFactoryTestData() {
        return new Object[][]{
                {1, 1, 1, 4},
                {10, 12, 32, 5},
                {-1, 0, 12, 3},
                {2, 3, 4, 1},
                {10, -65, 44, 3}
        };
    }

    @DataProvider(name = "figureFactoryTestFailData")
    public Object[][] figureFactoryTestFailData() {
        return new Object[][]{
                {1, 1, 1, 0},
                {10, 12, 5},
                {-1, 3},
                {2,},
                {10, -65, 44, 344, 344, 344, 344, 3}
        };
    }

    @Test(dataProvider = "figureFactoryTestData")
    public void figureFactoryTest(double... params) throws FigureException {
        FigureFactory factory = new FigureFactory();
        Assert.assertNotNull(factory.create(params));
    }

    @Test(dataProvider = "figureFactoryTestFailData")
    public void figureFactoryTestFail(double... params) {
        FigureFactory factory = new FigureFactory();
        Assert.expectThrows(FigureException.class,
                () -> {
                    factory.create(params);
                });
    }
}
