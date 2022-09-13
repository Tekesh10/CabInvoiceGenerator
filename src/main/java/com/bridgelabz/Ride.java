package com.bridgelabz;
enum RideCategory {NORMAL, PREMIUM}
public class Ride {
    private RideCategory RideCategory;
    private final double distance;
    private final double time;
    public Ride(double distance, double time ) {
        this.distance = distance;
        this.time = time;
    }
    public Ride(double distance, double time, RideCategory RideCategory) {
        this.distance = distance;
        this.time = time;
        this.RideCategory = RideCategory;
    }
    public double getDistance() { return distance; }
    public double getTime() { return time; }
    public RideCategory getRideCategory() { return RideCategory; }
}