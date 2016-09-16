package com.company;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<N extends Number> implements Executor<N> {

    List<Task> allTasks = new ArrayList<>();
    List<Number> validResults = new ArrayList<>();
    List<Number> invalidResults = new ArrayList<>();
    NumberValidator numberValidator;

    @Override
    public void addTask(Task task) {
        allTasks.add(task);
    }

    @Override
    public void addTask(Task task, Validator<Number> validator) {
        allTasks.add(task);
        this.numberValidator = (NumberValidator) validator;
        this.numberValidator.validator = task.getResult();
    }

    @Override
    public void execute() {
        for (Task task : allTasks) {
            if (numberValidator.isValid(task)) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }
        }
    }

    @Override
    public List<Number> getValidResults() {
        return validResults;
    }

    @Override
    public List<Number> getInvalidResults() {
        return invalidResults;
    }

}
