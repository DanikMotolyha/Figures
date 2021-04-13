package com.epam.figure.entity;

public abstract class AbstractFigure {
    private static long id;
    private final long figureId;

    public AbstractFigure() {
        figureId = id++;
    }

    public long getFigureId() {
        return figureId;
    }

    public long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure figure = (AbstractFigure) o;
        return figureId == figure.figureId;
    }

    @Override
    public int hashCode() {
        return (int) (31 * figureId);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Figure{")
                .append("figureId=").append(figureId)
                .append('}').toString();
    }
}
