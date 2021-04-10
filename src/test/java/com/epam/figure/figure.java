package com.epam.figure;

import com.epam.figure.entity.Sphere;
import com.epam.figure.exception.FigureException;
import com.epam.figure.factory.FigureFactory;
import com.epam.figure.service.impl.SphereCalculationService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class figure {

    @DataProvider(name = "testJwdData")
    public Object[][] testJwdData() {
        return new Object[][]{
                {new int[]{1, 6, 11, 4}},
                {new int[]{5, 0, 4, 5}},
                {new int[]{2, -6, 65, 5}},
                {new int[]{2, -50, 10, 5}},
                {new int[]{5, 44, 7, 5}},
                {new int[]{2, 3, -44, 5}},
                {new int[]{2, 48, 8, -6}},
                {new int[]{2, 3, 15, 5}},
                {new int[]{2, -2, 10, 5}},
                {new int[]{15, 3, -50, 5}}
        };
    }

    @Test()
    public void testJwd(){
        FigureFactory factory = new FigureFactory();
        Sphere sphere = (Sphere) factory.create(8, 0, 5);
        Sphere sphere2 = (Sphere) factory.create(8, 8, 0, -5);
        /*Sphere sphere = (Sphere) factory.create(8, 8, 0, 5);
        SphereCalculationService service = new SphereCalculationService();
        System.out.println(service.planeIntersection(sphere, 0,"xy"));
        System.out.println(service.planeIntersection(sphere, 0,"xz"));
        System.out.println(service.planeIntersection(sphere, 2,"xz"));
        System.out.println(service.planeIntersection(sphere, 3,"xz"));
        System.out.println(service.planeIntersection(sphere, 4,"xz"));
        System.out.println(service.planeIntersection(sphere, 14,"xz"));
        System.out.println(service.planeIntersection(sphere, 0,"yz"));
        System.out.println("*****");
        Sphere sphere2 = (Sphere) factory.create(-8, -8, 0, 5);
        System.out.println(service.planeIntersection(sphere, 0,"xy"));
        System.out.println(service.planeIntersection(sphere, 0,"xz"));
        System.out.println(service.planeIntersection(sphere, 0,"yz"));
        System.out.println(service.planeIntersection(sphere, 5,"xy"));
        System.out.println(service.planeIntersection(sphere, 6,"xy"));
        System.out.println(service.planeIntersection(sphere, -5,"xy"));
        System.out.println(service.planeIntersection(sphere, -6,"xy"));
        System.out.println("*****");
        System.out.println(service.planeIntersection(sphere2, -2,"xz"));
        System.out.println(service.planeIntersection(sphere2,-3,"xz"));

        System.out.println(service.planeIntersection(sphere2, -2,"yz"));
        System.out.println(service.planeIntersection(sphere2, -3,"yz"));*/

    }
}
