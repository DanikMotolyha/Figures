package com.epam.figure.entity;

public abstract class Figure {
    private static long id;
    private final long figureId;

    public Figure() {
        figureId = id++;
    }

    public long getFigureId() {
        return figureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
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
