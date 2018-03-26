package com.dheeraj.learning.designpatterns.composite;

/**
 * Composite Design Pattern : The intent of a composite is to 'compose' objects into tree structures to represent
 * part-whole hierarchies. It allows you to have a tree structure and ask each node in the tree structure to perform a task.
 *
 * The Composite Pattern has four participants:
 Component – Component declares the interface for objects in the composition and for accessing and managing its child
 components. It also implements default behavior for the interface common to all classes as appropriate.
 Leaf – Leaf defines behavior for primitive objects in the composition. It represents leaf objects in the composition.
 Composite – Composite stores child components and implements child related operations in the component interface.
 Client – Client manipulates the objects in the composition through the component interface.
 Client use the component class interface to interact with objects in the composition structure. If recipient is a leaf
 then request is handled directly. If recipient is a composite, then it usually forwards request to its child components,
 possibly performing additional operations before and after forwarding.

 Component is either leaf or Composite. Here computer is constructed into tree structure. Each leaf of component has its
 specific task to do.

 */
public class Exec {
    public static void main(String[] args) {
        Component hd = new Leaf(3000,"Hard drive");
        Component ram = new Leaf(1000,"RAM");
        Component mb = new Leaf(5000,"Mother board");
        Component mouse = new Leaf(2000,"Mouse");
        Component monitor = new Leaf(8000,"Monitor");

        Composite cabin = new Composite("Cabin");
        cabin.addComponent(hd);
        cabin.addComponent(ram);
        cabin.addComponent(mb);

        Composite peripheral = new Composite("Peripheral");
        peripheral.addComponent(mouse);
        peripheral.addComponent(monitor);

        Composite computer = new Composite("Computer");
        computer.addComponent(cabin);
        computer.addComponent(peripheral);

        computer.showPrice();


    }

}
