package com.epam.figure.entity;

@FunctionalInterface
public interface Specification {
    boolean specify(AbstractFigure figure);
}
