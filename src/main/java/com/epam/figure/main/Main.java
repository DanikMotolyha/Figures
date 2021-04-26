package com.epam.figure.main;

import com.epam.figure.entity.Point;
import com.epam.figure.entity.Sphere;
import com.epam.figure.entity.Warehouse;
import com.epam.figure.exception.FigureException;
import com.epam.figure.factory.FigureFactory;
import com.epam.figure.observer.impl.SphereObserver;
import com.epam.figure.parser.FigureParser;
import com.epam.figure.reader.FigureReader;
import com.epam.figure.repository.SphereRepository;
import com.epam.figure.repository.impl.CenterSpecification;
import com.epam.figure.service.impl.SphereCalculationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, FigureException {
        FigureParser parser = new FigureParser();
        FigureReader reader = new FigureReader();
        List<String> lines = reader.read("src/main/resources/data/import.txt");
        List<double[]> list = new ArrayList<>();
        for (String line : lines) {
            list.add(parser.parse(line));
        }
        FigureFactory factory = new FigureFactory();
        List<Sphere> spheres = new ArrayList<>();
        list.forEach(elem -> {
            try {
                spheres.add((Sphere) factory.create(elem));
            } catch (FigureException e) {
                System.out.println(e.getMessage());
            }
            Arrays.stream(elem).forEach(elem2 -> System.out.print(elem2 + " "));
        });
        Sphere sphere1 = spheres.get(0);
        Sphere clone = sphere1.clone();
        System.out.println("--------------------");
        System.out.println(clone);
        System.out.println(sphere1);
        System.out.println(sphere1.equals(clone));
        System.out.println("GOOD FIGURES");
        spheres.forEach(System.out::println);

        SphereRepository repository = SphereRepository.getInstance();
        for (Sphere sphere : spheres) {
            repository.create(sphere);
        }
        System.out.println(repository.getAll());
        System.out.println("--------------------");
        System.out.println(repository.update(0, new Sphere(new Point(10, 10, 10), 10)));
        System.out.println(repository.get(0));
        System.out.println("specification center");
        CenterSpecification specification = new CenterSpecification(new Point(0, 0, 0));

        System.out.println(repository.query(specification));
        System.out.println("------------");
        Sphere.CoordinateXComparator comparator = new Sphere.CoordinateXComparator();
        List<Sphere> sphereList = repository.sort(comparator);
        for (Sphere sphere : sphereList) {
            System.out.println(sphere);
        }
        System.out.println("------------");
        Sphere.RadiusComparator radiusComparator = new Sphere.RadiusComparator();
        List<Sphere> sphereList2 = repository.sort(radiusComparator);
        for (Sphere sphere : sphereList2) {
            System.out.println(sphere);
        }
        SphereCalculationService service = new SphereCalculationService();
        Sphere sphere = (Sphere) factory.create(10,10,10,10);
        Warehouse warehouse = Warehouse.getInstance();
        sphere.attach(new SphereObserver());
        double area = service.squareSurface(sphere);
        double volume = service.volume(sphere);
        warehouse.putFigureInfo(sphere.getFigureId(), area, volume);
        sphere.setRadius(10);
        System.out.println("------------");
        System.out.println(warehouse.getAllFigureInfo());
        sphere.setRadius(1);
        System.out.println("------------after change");
        System.out.println(warehouse.getAllFigureInfo());
    }
}
