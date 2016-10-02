package com.company.task;

public interface Task<N> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    N getResult();
}
