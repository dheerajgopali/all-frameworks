package com.dheeraj.learning.datastructures.timer;

public class TimeDecorator implements TimeDecoratorAbstract {
    TimeDecoratorAbstract timeDecoratorAbstract;

    public TimeDecorator(TimeDecoratorAbstract timeDecoratorAbstract) {
        this.timeDecoratorAbstract = timeDecoratorAbstract;
    }

    @Override
    public String execute() {
        long startTime = System.nanoTime();
        String str = timeDecoratorAbstract.execute();
        long endTime = System.nanoTime();
        System.out.println("Total time taken: "+(endTime-startTime));
        return str;
    }
}
