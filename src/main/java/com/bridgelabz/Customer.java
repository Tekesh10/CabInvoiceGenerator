package com.bridgelabz;
public class Customer {
    private final int id;
    private final Ride[] rides;
    public Customer(int id, Ride[] rides) {
        this.id = id;
        this.rides = rides;
    }
    public Ride[] getRides() { return rides; }
    public int getId() { return id; }
}