package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongTaskTest {

    @Test
    public void TestGetResult() throws Exception {
        Task longTask = new LongTask<>(15L);
        assertEquals(15L, longTask.getResult());
    }

    @Test
    public void TestGetResultZero() throws Exception {
        Task longTask = new LongTask<>(0L);
        assertEquals(0, longTask.getResult());
    }

    @Test
    public void TestGetResultNegative() throws Exception {
        Task longTask = new LongTask<>(-15L);
        assertEquals(-15, longTask.getResult());
    }
}