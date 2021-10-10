package Bai28;

import java.util.Scanner;

public class Customer extends Person implements Task {
    public String customerGroup;

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }


    public Customer() {
    }

    public Customer(int iD, String name, String adress, String phone, String customerGroup) {
        super(iD, name, adress, phone);
        this.customerGroup = customerGroup;
    }


    @Override
    public void input() {
        super.input();
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhóm khách:");
        String[] arr = {"Mua lẻ", "Mua buôn", "Mua qua mạng"};

        boolean check = true;
        do {
            check = true;
            int a = 0;
            System.out.println("Chon nhóm khách hàng:");
            System.out.println("1.Mua lẻ:");
            System.out.println("2.Mua buôn");
            System.out.println("3.Mua qua mạng");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    this.setCustomerGroup(arr[0]);
                    break;
                case 2:
                    this.setCustomerGroup(arr[1]);
                    break;
                case 3:
                    this.setCustomerGroup(arr[2]);
                    break;
                default:
                    System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                    check = false;
                    break;
            }
        }
        while (!check) ;
    }

    @Override
    public void output() {
            super.output();
            System.out.println(customerGroup+"}");
    }
}
