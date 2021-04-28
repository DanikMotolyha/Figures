package com.epam.figure.observer.impl;

import com.epam.figure.entity.Sphere;
import com.epam.figure.entity.Warehouse;
import com.epam.figure.exception.FigureException;
import com.epam.figure.observer.Observer;
import com.epam.figure.observer.SphereEvent;
import com.epam.figure.service.impl.SphereCalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserver implements Observer {
    private static final Logger LOGGER =
            LogManager.getLogger(SphereObserver.class);

    @Override
    public void parameterChanged(SphereEvent event) {
        Sphere sphere = event.getSource();
        try {
            SphereCalculationService service = new SphereCalculationService();
            double volume = service.volume(sphere);
            double area = service.squareSurface(sphere);
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.updateFigureInfo(sphere.getFigureId(), area, volume);
        } catch (FigureException ex) {
            LOGGER.log(Level.WARN, ex.getMessage());
        }
    }
}
