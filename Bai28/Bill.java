package Bai28;

import java.util.Arrays;

public class Bill implements Task{
    public Customer customer;
    public Phone[] phones;
    public int[] quantity;

    public Bill(){};
    public Bill(Customer customer, Phone[] phones, int[] quantity) {
        this.customer = customer;
        this.phones = phones;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    @Override
    public void input() {

    }

    @Override
    public void output() {
        System.out.println("Bill{" +"Customer=" + customer +
                ", Phone=" + Arrays.toString(phones) +
                ", Quantity=" + Arrays.toString(quantity) +
                "}");
    }

}
