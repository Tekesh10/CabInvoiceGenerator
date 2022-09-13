package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTimeForNormalRideShouldReturnTotalFare(){
        double totalFare = CabInvoiceGenerator.calculateNormalFare(9 , 10);
        Assertions.assertEquals(100, totalFare);
    }
    @Test
    public void givenDistanceAndTimeForNormalRideShouldReturnMinimumFare() {
        double totalFare = CabInvoiceGenerator.calculateNormalFare(0.1 , 1);
        Assertions.assertEquals(5,totalFare);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateTotalFare() {
        Ride[] rides = {new Ride(9,10), new Ride(0.1,1),
                new Ride(17,20), new Ride(0.4,1), new Ride(27, 30)};
        double totalFare = CabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(600,totalFare);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        Ride[] rides = {new Ride(9,10), new Ride(0.1,1),
                new Ride(17,20), new Ride(0.4,1), new Ride(27, 30)};
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(600,5,120);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenUserIDShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(9,10), new Ride(0.1,1), new Ride(17,20),
                new Ride(0.4,1), new Ride(27, 30)};
        Ride[] rides2 = {new Ride(5,5), new Ride(0.1,1), new Ride(19,15),
                new Ride(0.4,1), new Ride(21, 20)};
        RideRepository.customerList.add(new Customer(1,rides1));
        RideRepository.customerList.add(new Customer(2,rides2));
//        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(1);
//        Invoice expectedInvoice = new Invoice(600,5,120);
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(500,5,100);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenDistanceAndTimeForPremiumRideShouldReturnTotalFare(){
        double totalFare = CabInvoiceGenerator.calculatePremiumFare(9 , 10);
        Assertions.assertEquals(155, totalFare);
    }
    @Test
    public void givenDistanceAndTimeForPremiumRideShouldReturnMinimumFare() {
        double totalFare = CabInvoiceGenerator.calculatePremiumFare(0.1 , 1);
        Assertions.assertEquals(20,totalFare);
    }
    @Test
    public void givenRideCategoryShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(9,10, RideCategory.NORMAL), new Ride(0.1,1, RideCategory.NORMAL),
                new Ride(17,20, RideCategory.PREMIUM), new Ride(0.4,1, RideCategory.NORMAL),
                new Ride(27, 30, RideCategory.PREMIUM)};
        Ride[] rides2 = {new Ride(4,5, RideCategory.PREMIUM), new Ride(0.1,1, RideCategory.NORMAL),
                new Ride(19,15, RideCategory.PREMIUM), new Ride(0.4,1, RideCategory.NORMAL),
                new Ride(21, 20, RideCategory.PREMIUM)};
        RideRepository.customerList.add(new Customer(1,rides1));
        RideRepository.customerList.add(new Customer(2,rides2));
//        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(1);
//        Invoice expectedInvoice = new Invoice(870,5,174);
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(750,5,150);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}