package com.uniyaz.payment.service;

import com.uniyaz.customer.domain.Customer;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilter;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import com.uniyaz.rental.service.RentalService;
import com.uniyaz.staff.domain.Staff;
import org.junit.Test;

import java.util.List;

public class PaymentServiceTest {
    @Test
    public void findAllTest() {

        PaymentService paymentService = new PaymentService();
        List<Payment> paymentList = paymentService.findAll();
        for (Payment payment : paymentList) {
            System.out.println(payment);
        }
    }
    @Test
    public void findAllTestQueryFilter() {

        PaymentService paymentService = new PaymentService();
        PaymentQueryFilter paymentQueryFilter = new PaymentQueryFilter();
        Customer customer = new Customer();
          customer.setFirstName("MARY");
          paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setCustomer(customer);
        Staff staff = new Staff();
        staff.setFirstName("Mike");
        paymentQueryFilter.setStaff(staff);
        List<Payment> paymentList = paymentService.findAllByQueryFilterDto(paymentQueryFilter);
        for (Payment payment : paymentList) {
            System.out.println(payment);
        }
    }
}
