package com.company.executor;

import com.company.task.LongTask;
import com.company.task.Task;
import com.company.validator.NumberValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExecutorImplTest {

    ExecutorImpl<Number> executor;

    @Before
    public void testBefore() {
        executor = new ExecutorImpl<>();
    }

    @Test
    public void testAddTask() throws Exception {
        executor.addTask(new LongTask(25L));
        assertEquals(25L, executor.allTasks.get(0).getResult());
    }

    @Test
    public void testExecuteValidResults() throws Exception {
        Task<Integer> task = new LongTask<>(10L);
        executor.addTask(new LongTask(10L), new NumberValidator());
        executor.allTasks.add(task);
        executor.execute();
        assertEquals(20L, executor.getValidResults().get(0));
    }

    @Test
    public void testExecuteInvalidResults() throws Exception {
        Task<Integer> task = new LongTask<>(-15L);
        executor.addTask(new LongTask(10L), new NumberValidator());
        executor.allTasks.add(task);
        executor.execute();
        assertEquals(-30L, executor.getInvalidResults().get(0));
    }
}