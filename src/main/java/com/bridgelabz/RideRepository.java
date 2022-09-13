package com.bridgelabz;
import java.util.List;
import java.util.ArrayList;
public class RideRepository {
    static List<Customer> customerList = new ArrayList<>();
    public static Invoice generateInvoiceByUserId(int userId) {
        for (Customer customer : customerList) {
            if (customer.getId() == userId)
                return CabInvoiceGenerator.generateInvoice(customer.getRides());
        }
        return null;
    }
}