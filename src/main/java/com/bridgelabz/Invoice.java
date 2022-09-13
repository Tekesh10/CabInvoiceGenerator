package com.bridgelabz;
import java.util.Objects;
public class Invoice {
    private final double totalFare;
    private final double totalRides;
    private final double averageFare;
    public Invoice(double totalFare, double totalRides, double averageFare) {
        this.totalFare = totalFare;
        this.totalRides = totalRides;
        this.averageFare = averageFare;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Invoice invoice = (Invoice)object;
        return Double.compare(invoice.totalFare, totalFare) == 0 && totalRides == invoice.totalRides && Double.compare(invoice.averageFare, averageFare) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(totalFare, totalRides, averageFare);
    }
}