package com.bridgelabz;
public class CabInvoiceGenerator {
    private static final double NORMAL_COST_PER_KM = 10;
    private static final double NORMAL_COST_PER_MIN = 1;
    private static final double PREMIUM_COST_PER_KM = 15;
    private static final double PREMIUM_COST_PER_MIN = 2;
    public static double calculateNormalFare(double distance, double time) {
        double totalFare = NORMAL_COST_PER_KM*distance + NORMAL_COST_PER_MIN*time;
        return totalFare<=5 ? 5 : totalFare;
    }
    public static double calculatePremiumFare(double distance, double time) {
        double totalFare = PREMIUM_COST_PER_KM*distance + PREMIUM_COST_PER_MIN*time;
        return totalFare<=20 ? 20 : totalFare;
    }
    public static double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride:rides) {
            if ( ride.getRideCategory()==null ||ride.getRideCategory().equals(RideCategory.NORMAL))
                aggregateFare += calculateNormalFare(ride.getDistance(),ride.getTime());
            else
                aggregateFare += calculatePremiumFare(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }
    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalRides = rides.length;
        double averageFare = totalFare/totalRides;
        return new Invoice(totalFare,totalRides,averageFare);
    }
}