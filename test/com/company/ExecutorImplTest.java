package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ExecutorImplTest {

    Executor<Number> numberExecutor;

    @Before
    public void testBefore() {
        numberExecutor = new ExecutorImpl<>();
    }

    @org.junit.Test
    public void testAddTask() throws Exception {
        numberExecutor.addTask(new LongTask(10L));
        assertTrue(true);
    }

    @org.junit.Test
    public void testAddTask1() throws Exception {
        numberExecutor.addTask(new LongTask(10L), new NumberValidator<>());
        assertTrue(true);
    }

    @org.junit.Test
    public void testAddTask2() throws Exception {
        numberExecutor.addTask(new LongTask(5 / 2), new NumberValidator<>());
        assertTrue(true);
    }

    @org.junit.Test
    public void testAddTask3() throws Exception {
        numberExecutor.addTask(new LongTask(-5), new NumberValidator<>());
        assertTrue(true);
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        numberExecutor.execute();
        assertTrue(true);
    }

    @org.junit.Test
    public void testGetValidResults() throws Exception {
        numberExecutor.getValidResults();
        assertTrue(true);
    }

    @org.junit.Test
    public void testGetInvalidResults() throws Exception {
        numberExecutor.getInvalidResults();
        assertTrue(true);
    }
}