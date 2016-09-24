package com.company;

public class LongTask<Long> implements Task {
    private long result;

    public LongTask(long l) {
        this.result = l;
    }

    @Override
    public void execute() {
        System.out.println(result);
    }

    @Override
    public long getResult() {
        return result;
    }
}
