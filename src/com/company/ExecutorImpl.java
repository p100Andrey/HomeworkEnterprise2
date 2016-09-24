package com.company;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<N extends Number> implements Executor<N> {

    List<Task<Number>> allTasks = new ArrayList<>();
    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();
    static NumberValidator numberValidator;

    @Override
    public void addTask(Task task) {
        allTasks.add(task);
    }

    @Override
    public void addTask(Task task, Validator<Long> validator) {
        NumberValidator numberValidator = new NumberValidator(task.getResult());
        this.numberValidator = (NumberValidator) validator;
    }

    @Override
    public void execute() {
        for (Task task : allTasks) {
            if (numberValidator.isValid(task.getResult())) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }
        }
    }

    @Override
    public List<Long> getValidResults() {
        try {
            if (validResults == null) new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Valid results aren't!");
        }
        return validResults;
    }

    @Override
    public List<Long> getInvalidResults() {
        try {
            if (invalidResults == null) new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Invalid results aren't!");
        }
        return invalidResults;
    }

}
