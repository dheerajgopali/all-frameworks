package com.dheeraj.learning.designpatterns.headfirst.compound;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Flock duckFlock = new Flock();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        duckFlock.add(mallardDuck);
        duckFlock.add(redheadDuck);
        duckFlock.add(duckCall);
        duckFlock.add(rubberDuck);

        Observer observer = new Quackologist();

        Flock geeseFlock = new Flock();
        Quackable geeseDuck = new GooseAdapter(new Goose());
        Quackable duckCall2 = duckFactory.createDuckCall();
        geeseFlock.add(geeseDuck);
        geeseFlock.add(duckCall2);

        duckFlock.add(geeseFlock);

        duckFlock.registerObserver(observer);

        System.out.println("\nDuck Simulator Parent");
        simulate(duckFlock);
        System.out.println("Quack Count: " + QuackCounter.getQuackCounter());

        System.out.println("\nDuck Simulator Child");
        simulate(geeseFlock);
        System.out.println("Quack Count: " + QuackCounter.getQuackCounter());
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}