package com.company;

public interface Task<N> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    long getResult();
}
