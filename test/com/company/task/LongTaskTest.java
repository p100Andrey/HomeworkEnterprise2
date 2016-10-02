package com.company.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongTaskTest {

    @Test
    public void TestGetResult() throws Exception {
        Task longTask = new LongTask<>(15L);
        assertEquals((Long) 15L, longTask.getResult());
    }

    @Test
    public void TestGetResultZero() throws Exception {
        Task longTask = new LongTask<>(0L);
        assertEquals((Long) 0L, longTask.getResult());
    }

    @Test
    public void TestGetResultNegative() throws Exception {
        Task longTask = new LongTask<>(-15L);
        assertEquals((Long) (-15L), longTask.getResult());
    }
}