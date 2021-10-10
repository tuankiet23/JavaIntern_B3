package Bai28;

import java.util.Scanner;

public class Person implements Task {
    private static int iDAuto=9999;
    public int iD;
    public String name;
    public String adress;
    public String phone;



    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Person.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Person(){

        this.iD=iDAuto++;
    }
    public Person(int iD, String name, String adress, String phone) {
        this.iD = iD;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }

    @Override
    public void input() {
        Scanner sc=new Scanner(System.in);
        this.setiD(iDAuto);
        System.out.println("Nhap ho ten:");
        this.setName(sc.nextLine());
        System.out.println("Địa chỉ:");
        this.setAdress(sc.nextLine());
        System.out.println("SĐT:");
        this.setPhone(sc.nextLine());
    }

    @Override
    public void output() {
        System.out.println("Person{" +
                "id=" + iD +
                ", name='" + name + '\'' +
                ", address=" + adress +
                ", phone='" + phone + '\'');
    }


}
