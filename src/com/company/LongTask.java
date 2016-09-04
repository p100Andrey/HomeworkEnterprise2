package com.company;

public class LongTask implements Task<Integer> {
    private Integer result;

    public LongTask(long l) {
        this.result = (int) l;
    }

    @Override
    public void execute() {

    }

    @Override
    public Integer getResult() {
        return result;
    }
}
