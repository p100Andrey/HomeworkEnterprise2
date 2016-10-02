package com.company.executor;

import com.company.task.Task;
import com.company.validator.NumberValidator;
import com.company.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<N extends Number> implements Executor<N> {

    public List<Task<? extends N>> allTasks = new ArrayList<>();
    public List<N> validResults = new ArrayList<>();
    public List<N> invalidResults = new ArrayList<>();
    public static Validator validator;

    @Override
    public void addTask(Task<? extends N> task) {
        allTasks.add(task);
    }

    @Override
    public void addTask(Task<? extends N> task, Validator<? super N> validator) {
        this.validator = validator;
    }

    @Override
    public void execute() {
        System.out.println("All tasks:");
        for (Task<? extends N> task : allTasks) {
            System.out.println(task.getResult());
            task.execute();
            if (validator.isValid(task.getResult())) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }
        }
    }

    @Override
    public List<N> getValidResults() {
        try {
            if (validResults.isEmpty()) {
                new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Valid results aren't!");
        }
        return validResults;
    }

    @Override
    public List<N> getInvalidResults() {
        try {
            if (invalidResults.isEmpty()) {
                new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid results aren't!");
        }
        return invalidResults;
    }

}
