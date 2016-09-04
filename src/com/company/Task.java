package com.company;

public interface Task<Integer> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    Integer getResult();

}
