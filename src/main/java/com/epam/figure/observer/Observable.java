package com.epam.figure.observer;

public interface Observable {
    void attach(Observer observer);

    void detach();

    void notifyObservers();
}
