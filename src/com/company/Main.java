package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task<Integer>> intTasks = new ArrayList<Task<Integer>>();
        intTasks.add(new LongTask(10L));
        intTasks.add(new LongTask(15L));
        intTasks.add(new LongTask(20L));
        intTasks.add(new LongTask(25L));
        System.out.println("All tasks:");
        for (Task task : intTasks) {
            task.execute();
        }
        test(intTasks);
    }

    public static void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
