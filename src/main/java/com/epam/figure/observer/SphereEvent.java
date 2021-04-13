package com.epam.figure.observer;

import com.epam.figure.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    public SphereEvent(Object source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}
