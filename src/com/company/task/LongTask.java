package com.company.task;

public class LongTask<N extends Number> implements Task<N> {
    public Long result;

    public LongTask(Long l) {
        this.result = l;
    }

    @Override
    public void execute() {
        result = result * 2;
    }

    @Override
    public N getResult() {
        return (N) result;
    }
}
