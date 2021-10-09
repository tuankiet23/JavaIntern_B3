package Bai7;

import java.util.Scanner;

public class Subject {
    private static int iDAuto=100;
    public int iD;
    public String subject;
    public int total;
    public int theory;

    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Subject.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int price;
    public  Subject(){
        this.iD=iDAuto++;
    }

    public Subject(int iD, String subject, int total, int theory, int price) {
        this.iD = iD;
        this.subject = subject;
        this.total = total;
        this.theory = theory;
        this.price = price;
    }

    public void InputSubject(){
        Scanner sc=new Scanner(System.in);
        this.setiD(iDAuto);
        System.out.println("Nhap ten môn hoc:");
        this.setSubject(sc.nextLine());
        System.out.println("Tổng số tiết học:");
        this.setTotal(sc.nextInt());
        System.out.println("Số tiết lý thuyết:");
        boolean flag=false;
        int a;
        do {
            a = sc.nextInt();
            if (a > this.getTotal()) {
                System.out.println("so tiết lý thuyết không hợp lệ:");
                flag = true;
            }
            else flag=false;
        }while (flag);
        this.setTheory(a);
        System.out.println("Học phí");
        this.setPrice(sc.nextInt());
    }
    public String toString(){
        return "Subject{" +
                "id=" + iD +
                ", subject='" + subject + '\'' +
                ", total=" + total +'\'' +
                ", theory='" + theory + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


}
