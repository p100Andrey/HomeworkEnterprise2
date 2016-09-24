package com.company;

import org.junit.Before;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExecutorImplTest {

    ExecutorImpl<Number> executor;

    @Before
    public void testBefore() {
        executor = new ExecutorImpl<>();
    }

    @org.junit.Test
    public void testAddTask1() throws Exception {
        executor.addTask(new LongTask(5L));
        assertEquals(5, (long) executor.allTasks.get(0).getResult());
    }

    @org.junit.Test
    public void testAddTask2() throws Exception {
        executor.addTask(new LongTask(0));
        assertEquals(0, (long) executor.allTasks.get(0).getResult());
    }

    @org.junit.Test
    public void testAddTask3() throws Exception {
        executor.addTask(new LongTask(-3L));
        assertEquals(-3, (long) executor.allTasks.get(0).getResult());
    }

    @org.junit.Test
    public void testExecuteValidResults() throws Exception {
        Task<Number> task = new LongTask<>(10L);
        executor.addTask(new LongTask(10L), new NumberValidator());
        executor.allTasks.add(task);
        executor.execute();
        assertEquals(10, (long) executor.getValidResults().get(0));
    }

    @org.junit.Test
    public void testExecuteInvalidResults() throws Exception {
        Task<Number> task = new LongTask<>(15L);
        executor.addTask(new LongTask(10L), new NumberValidator());
        executor.allTasks.add(task);
        executor.execute();
        assertEquals(15, (long) executor.getInvalidResults().get(0));
    }
}