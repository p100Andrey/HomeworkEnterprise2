package com.company.executor;

import com.company.task.Task;
import com.company.validator.Validator;

import java.util.List;

public interface Executor<N> {

    // Добавить таск на выполнение. Результат таска будет доступен через
    // метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends N> task);

    // Добавить таск на выполнение и валидатор результата.
    // Результат таска будет записан в ValidResults если validator.isValid
    // вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid
    // вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends N> task, Validator<? super N> validator);

    // Выполнить все добавленые таски
    void execute();

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()

    List<N> getValidResults();

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<N> getInvalidResults();
}
