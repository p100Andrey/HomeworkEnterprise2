package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyExecutor implements Executor<Number>, Validator {

    List<Task> allTasks = new ArrayList<>();
    List<Number> validResults = new ArrayList<>();
    List<Number> invalidResults = new ArrayList<>();
    Integer validator;

    @Override
    public void addTask(Task task) {
        allTasks.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) {
        allTasks.add(task);
        this.validator = (Integer) task.getResult();
    }

    @Override
    public void execute() {
        for (Task task : allTasks) {
            if (isValid(task)) {
                validResults.add((Number) task.getResult());
            } else {
                invalidResults.add((Number) task.getResult());
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

    @Override
    public boolean isValid(Task result) {
        if ((Integer) result.getResult() % validator == 0) {
            return true;
        }
        return false;
    }
}
