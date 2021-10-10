package Bai28;

import java.util.Scanner;

public class Phone implements Task {
    private static int iDAuto=9999;
    public int iD;
    public String manufacturer;
    public String model;
    public int price;

    public Phone(){
        this.iD=iDAuto++;
    }

    public Phone(int iD, String manufacturer, String model, int price) {
        this.iD = iD;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Phone.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void input() {
        Scanner sc=new Scanner(System.in);
        this.setiD(iDAuto);
        System.out.println("Hãng sản xuất");
        this.setManufacturer(sc.nextLine());
        System.out.println("Model:");
        this.setModel(sc.nextLine());
        System.out.printf("Đơn giá:");
        this.setPrice(sc.nextInt());
    }

    @Override
    public void output() {
        System.out.println("Phone{id:"+iD+", hãng sản xuất:"+manufacturer+", model:"+model+", đơn giá:"+price+"}");
    }
}
