package com.example.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages customers and their orders.
 */
public class CustomerOrderManager {

    private static final Logger LOGGER = Logger.getLogger(CustomerOrderManager.class.getName());

    private final List<String> customerList;
    private final List<String> orderList;

    /**
     * Constructor to initialize the lists.
     */
    public CustomerOrderManager() {
        this.customerList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    /**
     * Adds a new customer to the system.
     *
     * @param customerName the name of the customer
     */
    public void addCustomer(final String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            LOGGER.warning("Customer name is null or empty.");
            return;
        }

        customerList.add(customerName);
        LOGGER.info("Added customer: " + customerName);
    }

    /**
     * Adds a new order to the system.
     *
     * @param order the order identifier or details
     */
    public void addOrder(final String order) {
        if (order == null || order.trim().isEmpty()) {
            LOGGER.warning("Order is null or empty.");
            return;
        }

        orderList.add(order);
        LOGGER.info("Order added: " + order);
    }

    /**
     * Processes all orders for a given customer.
     *
     * @param customerName the name of the customer
     */
    public void processOrdersForCustomer(final String customerName) {
        if (!customerList.contains(customerName)) {
            LOGGER.warning("Customer not found: " + customerName);
            return;
        }

        LOGGER.info("Processing orders for: " + customerName);
        for (final String order : orderList) {
            LOGGER.info("Processing order: " + order);
        }
    }

    /**
     * Generates a summary report of all customers.
     */
    public void generateCustomerReport() {
        LOGGER.info("Customer Report:");
        for (final String customer : customerList) {
            LOGGER.info("Customer: " + customer);
        }
    }

    /**
     * Generates a summary report of all orders.
     */
    public void generateOrderReport() {
        LOGGER.info("Order Report:");
        for (final String order : orderList) {
            LOGGER.info("Order: " + order);
        }
    }

    /**
     * Entry point for demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        final CustomerOrderManager manager = new CustomerOrderManager();

        manager.addCustomer("John Doe");
        manager.addCustomer("Jane Smith");

        manager.addOrder("Order1");
        manager.addOrder("Order2");

        manager.processOrdersForCustomer("John Doe");

        manager.generateCustomerReport();
        manager.generateOrderReport();
    }
}
