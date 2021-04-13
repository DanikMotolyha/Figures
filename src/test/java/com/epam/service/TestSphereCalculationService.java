package com.epam.service;

import com.epam.figure.entity.AbstractFigure;
import com.epam.figure.entity.Point;
import com.epam.figure.entity.Sphere;
import com.epam.figure.exception.FigureException;
import com.epam.figure.service.impl.SphereCalculationService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSphereCalculationService {
    @DataProvider(name = "AreaTestData")
    public Object[][] areaTestData() {
        return new Object[][]{
                {new Sphere(new Point(1, 1, 1), 4), 268.0},
                {new Sphere(new Point(2, 3, 4), 5), 524.0},
                {new Sphere(new Point(-4, 41, 10), 12), 7238.0},
                {new Sphere(new Point(0, 1, 8), 3), 113.0},
                {new Sphere(new Point(11, 5, -5), 44), 356818.0}
        };
    }

    @DataProvider(name = "SquareSurfaceTestData")
    public Object[][] squareSurfaceTestData() {
        return new Object[][]{
                {new Sphere(new Point(1, 1, 1), 4), 201.0},
                {new Sphere(new Point(2, 3, 4), 5), 314.0},
                {new Sphere(new Point(-4, 41, 10), 12), 1810.0},
                {new Sphere(new Point(0, 1, 8), 3), 113.0},
                {new Sphere(new Point(11, 5, -5), 44), 24328.0}
        };
    }

    @DataProvider(name = "PlaneIntersectionTestData")
    public Object[][] planeIntersectionTestData() {
        return new Object[][]{
                {new Sphere(new Point(1, 1, 1), 4), 3, "xy"},
                {new Sphere(new Point(2, 3, 4), 5), 0, "yx"},
                {new Sphere(new Point(-4, 41, 10), 12), 4, "yz"},
                {new Sphere(new Point(0, 1, 8), 4), 4, "zy"},
                {new Sphere(new Point(11, 5, -5), 44), 4, "zx"}
        };
    }
    @DataProvider(name = "SpaceRatioTestData")
    public Object[][] spaceRatioTestData() {
        return new Object[][]{
                {new Sphere(new Point(1, 1, 1), 4), 1, "xy", 1.0},
                {new Sphere(new Point(2, 3, 4), 5), 0, "yx", 35.0},
                {new Sphere(new Point(-4, 41, 10), 12), 4, "yz", 12.0},
                {new Sphere(new Point(0, 1, 8), 4), 3, "zy", 22.0},
                {new Sphere(new Point(11, 5, -5), 44), 4, "zx", 2.0}
        };
    }

    @Test(dataProvider = "AreaTestData")
    public void AreaTest(AbstractFigure figure, double expected) {
        SphereCalculationService service = new SphereCalculationService();
        Assert.assertEquals(service.volume(figure), expected);
    }

    @Test(dataProvider = "SquareSurfaceTestData")
    public void squareSurfaceTest(AbstractFigure figure, double expected) {
        SphereCalculationService service = new SphereCalculationService();
        Assert.assertEquals(service.squareSurface(figure), expected);
    }

    @Test(dataProvider = "PlaneIntersectionTestData")
    public void planeIntersectionTest(AbstractFigure figure, double height, String coordinatePlane) throws FigureException, CloneNotSupportedException {
        SphereCalculationService service = new SphereCalculationService();
        Assert.assertTrue(service.planeIntersection(figure, height, coordinatePlane));
    }

    @Test(dataProvider = "SpaceRatioTestData")
    public void spaceRatioTest(AbstractFigure figure, double height, String coordinatePlane, double expected) throws FigureException, CloneNotSupportedException {
        SphereCalculationService service = new SphereCalculationService();
        Assert.assertEquals(service.spaceRatio(figure, height, coordinatePlane), expected);
    }

}
