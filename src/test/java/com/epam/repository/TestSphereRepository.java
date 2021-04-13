package com.epam.repository;

import com.epam.figure.entity.Point;
import com.epam.figure.entity.Sphere;
import com.epam.figure.repository.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSphereRepository {

    @DataProvider(name = "CreateSphereRepositoryTestData")
    public Object[][] sphereRepositoryTestData() {
        return new Object[][]{
                {new Sphere(new Point(10, 10, 10), 10)},
                {new Sphere(new Point(5, -1, -2.2), 8)},
                {new Sphere(new Point(12, 0, 80), 7)}
        };
    }

    @DataProvider(name = "UpdateSphereRepositoryTestData")
    public Object[][] updateSphereRepositoryTestData() {
        return new Object[][]{
                {0, new Sphere(new Point(2, 2, 2), 1)},
                {1, new Sphere(new Point(3, 3, 3), 8)},
                {2, new Sphere(new Point(4, 4, 4), 7)}
        };
    }

    @DataProvider(name = "GetSphereRepositoryTestData")
    public Object[][] getSphereRepositoryTestData() {
        return new Object[][]{{0}, {1}, {2}
        };
    }

    @Test(dataProvider = "CreateSphereRepositoryTestData")
    public void createSphereRepositoryTestData(Sphere sphere) {
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertTrue(repository.create(sphere));
    }

    @Test(dataProvider = "UpdateSphereRepositoryTestData", dependsOnMethods = "createSphereRepositoryTestData")
    public void updateSphereRepositoryTestData(int id, Sphere sphere) {
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertNotNull(repository.update(id, sphere));
    }

    @Test(dataProvider = "GetSphereRepositoryTestData", dependsOnMethods = "updateSphereRepositoryTestData")
    public void getSphereRepositoryTestData(int id) throws CloneNotSupportedException {
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertNotNull(repository.get(id));
    }

    @Test(dependsOnMethods = "getSphereRepositoryTestData")
    public void getAllSphereRepositoryTestData() {
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertNotNull(repository.getAll());
    }
}
