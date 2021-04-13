package com.epam.figure.repository;

import com.epam.figure.entity.Specification;
import com.epam.figure.entity.Sphere;
import com.epam.figure.factory.FigureFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SphereRepository {
    private final static Logger LOGGER = LogManager.getLogger(SphereRepository.class);
    private final static SphereRepository instance = new SphereRepository();
    private final List<Sphere> storage = new ArrayList<>();

    private SphereRepository() {

    }

    public static SphereRepository getInstance() {
        return instance;
    }

    public boolean create(Sphere sphere) {
        LOGGER.log(Level.INFO, "Add obj :" + sphere);
        return storage.add(sphere);
    }

    public Sphere get(int id) throws CloneNotSupportedException {
        LOGGER.log(Level.INFO, "get obj with id:" + id);
        return storage.get(id).clone();
    }

    public List<Sphere> getAll() {
        LOGGER.log(Level.INFO, "get all obj");
        return new ArrayList<>(storage);
    }

    public Sphere update(int id, Sphere sphere) {
        LOGGER.log(Level.INFO, "update with id:" + id + " obj :" +sphere);
        return storage.set(id, sphere);
    }

    public boolean delete(int id) {
        LOGGER.log(Level.INFO, "delete with id" + id);
        return storage.remove(storage.get(id));
    }

    public List<Sphere> sort(Comparator<? super Sphere> comparator) {
        LOGGER.log(Level.INFO, "sort with comparator" +
                comparator.getClass().getSimpleName());
        return storage.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Sphere> query(Specification specification) {
        LOGGER.log(Level.INFO, "query with specification" +
                specification.getClass().getSimpleName());
        return storage.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
