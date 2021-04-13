package com.epam.figure.entity;

import com.epam.figure.exception.FigureException;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private final Map<Long, FigureInfo> figureMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putFigureInfo(Long id, double area, double volume) {
        FigureInfo info = new FigureInfo(area, volume);
        figureMap.put(id, info);
    }

    public FigureInfo getFigureInfo(Long id) throws FigureException {
        FigureInfo info = figureMap.get(id);
        if (info == null) {
            throw new FigureException("Object was null");
        }
        return info;
    }

    public Map<Long, FigureInfo> getAllFigureInfo() {
        Map<Long, FigureInfo> map = new HashMap<>();
        figureMap.forEach(map::put);
        return map;
    }

    public void updateFigureInfo(Long id, double area, double volume) throws FigureException {
        FigureInfo info = figureMap.get(id);
        if (info == null) {
            throw new FigureException("Object was null");
        }
        info.setArea(area);
        info.setVolume(volume);
    }
}
