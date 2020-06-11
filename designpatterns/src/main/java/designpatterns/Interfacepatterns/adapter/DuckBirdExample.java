package designpatterns.Interfacepatterns.adapter;

/*
This pattern is easy to understand as the real world is full of adapters.
For example consider a USB to Ethernet adapter. We need this when we have an Ethernet interface
on one end and USB on the other. Since they are incompatible with each other.
we use an adapter that converts one to other. This example is pretty analogous to Object Oriented Adapters.
In design, adapters are used when we have a class (Client) expecting some type of object and we have an object
(Adaptee) offering the same features but exposing a different interface.

To use an adapter:

The client makes a request to the adapter by calling a method on it using the target interface.
The adapter translates that request on the adaptee using the adaptee interface.
Client receive the results of the call and is unaware of adapter’s presence.
Definition:

The adapter pattern convert the interface of a class into another interface clients expect.
Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.






The client sees only the target interface and not the adapter. The adapter implements the target interface.
Adapter delegates all requests to Adaptee.

Example:

Suppose you have a Bird class with fly() , and makeSound()methods. And also a ToyDuck class with squeak() method.
Let’s assume that you are short on ToyDuck objects and you would like to use Bird objects in their place. Birds have some
similar functionality but implement a different interface, so we can’t use them directly. So we will use adapter pattern.
 Here our client would be ToyDuck and adaptee would be Bird.

Below is Java implementation of it.
* */

/**
 * Created by pourush.sinha on 16/06/18.
 */

// Java implementation of Adapter pattern

interface Bird
{
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void fly();
    public void makeSound();
}

class Sparrow implements Bird
{
    // a concrete implementation of bird
    public void fly()
    {
        System.out.println("Flying");
    }
    public void makeSound()
    {
        System.out.println("Chirp Chirp");
    }
}

interface ToyDuck
{
    // target interface
    // toyducks dont fly they just make
    // squeaking sound
    public void squeak();
}

class PlasticToyDuck implements ToyDuck
{
    public void squeak()
    {
        System.out.println("Squeak");
    }
}

class BirdAdapter implements ToyDuck
{
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdAdapter(Bird bird)
    {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }

    public void squeak()
    {
        // translate the methods appropriately
        bird.makeSound();
    }
}
public class DuckBirdExample {
    public static void main(String args[])
    {
        Sparrow sparrow = new Sparrow();
        PlasticToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // bird behaving like a toy duck
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
