package com.company;

public class LongTask<N extends Number> implements Task {
    private Long result;

    public LongTask(long l) {
        this.result = l;
    }

    @Override
    public void execute() {

    }

    @Override
    public Long getResult() {
        return result;
    }
}
