package Bai28;

import java.util.Scanner;

public class Manager {
    public static Customer[] customers;
    public  static Phone[] phones;
    public static Bill[] bills;

    public void run(){
        while (true) {
            System.out.println("Danh sach chuc nang:");
            System.out.println("1.Them khách hàng");
            System.out.println("2.In ra danh khách hàng");
            System.out.println("3.Them điện thoại");
            System.out.println("4.In ra danh điện thoại");
            System.out.println("5.Nhap hoa don");
            System.out.println("6.Sx theo ten kh");
            System.out.println("7.Sx theo so lượng");
            System.out.println("8.Hiển thị hóa đơn");
            boolean flag = true;
            do {
                flag = true;
                int chosse = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Chon chuc nang");
                chosse = scanner.nextInt();
                switch (chosse) {
                    case 1:
                        CreateCustomer();
                        break;
                    case 2:
                        DisplayCustomer();
                        break;
                    case 3:
                        CreatePhone();
                        break;
                    case 4:
                        DisplayPhone();
                        break;
                    case 5:
                        Purchase();
                        break;
                    case 6:
                        SortName();
                        break;
                    case 7:
                        SortQuantity();
                        break;
                    case 8:
                        Display();
                        break;
                    default:
                        System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                        flag = false;
                        break;
                }
            }
            while (!flag);
        }
    }
    public void CreateCustomer(){
        Scanner scanner=new Scanner(System.in);
        int a;
        System.out.println("Nhập số lượng khách:");
        a= scanner.nextByte();
        customers=new Customer[a];
        for(int i=0; i<a; i++){
            Customer customer=new Customer();
            customer.input();
            customers[i]=customer;
        }
    }
    public void CreatePhone(){
        Scanner scanner=new Scanner(System.in);
        int a;
        System.out.println("Nhập số lượng dòng điện thoại:");
        a= scanner.nextByte();
        phones=new Phone[a];
        for(int i=0; i<a; i++){
            Phone phone=new Phone();
            phone.input();
            phones[i]=phone;
        }
    }
    public void DisplayCustomer(){
        for(Customer customer: customers){
            customer.output();
        }
    }
    public void DisplayPhone(){
        for(Phone phone: phones)
        {
            phone.output();
        }
    }
    public Customer SearchCustomer(int id){
        for(int i=0; i<customers.length; i++)
        {
            if(customers[i].getiD()==id)
            {
                return customers[i];
            }
        }
        return null;

    }
    public Phone SearchPhone(int id){
        for(Phone phone: phones){
            if(phone.getiD()==id)
                return phone;
        }
        return null;
    }
    public void Purchase(){
        if(phones==null || customers==null)
        {
            System.out.println("Nhạp danh sách điện thoại và khách hàng trước.");
        }
        else
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhap so khach hang:");
            boolean flag=false;
            int a;
            do {
                a = sc.nextInt();
                if (a > customers.length) {
                    System.out.println("nhập lại số kh:");
                    flag = true;
                }
                else flag=false;
            }while (flag);
            bills=new Bill[a];
            for(int i=0; i<a; i++){
                System.out.println("Nhap id khách hàng:");
                int d;
                Customer customer;
                boolean check=false;
                do{
                    d=sc.nextInt();
                    customer=SearchCustomer(d);
                    if(customer==null){
                        System.out.println("nhap lại id:");
                        check=true;
                    }
                    else
                        check=false;
                }while (check);
                System.out.println("Nhap so lương dòng điện thoại muốn mua:");
                int b;
                do {
                    b=sc.nextInt();
                    if( b>phones.length){
                        System.out.println("nhap lại so lương dòng điện thoại muốn mua:");
                        flag=true;
                    }
                    else
                        flag=false;
                }while (flag);
                Phone[] phones=new Phone[b];
                int []ListQuantity=new int [b];
                for(int j=0; j<b; j++){
                    System.out.println("Nhập id điện thoại muốn mua");
                    Phone phone;
                    int id;
                    do {
                        id=sc.nextInt();
                        phone=SearchPhone(id);
                        if(phone==null){
                            System.out.println("nhap lại id:");
                            flag=true;
                        }
                        else
                            flag=false;
                    }while (flag);
                    int c;
                    System.out.println("Nhập số lượng cần mua:");
                    c=sc.nextInt();
                    ListQuantity[j]=c;
                    phones[j]=phone;
                }
                Bill bill=new Bill(customer, phones, ListQuantity);
                bills[i]=bill;
            }
        }
    }
    public void Display(){
        System.out.println("Danh sach:");
        for(Bill bill: bills)
        {
            bill.customer.output();
            for(int i=0; i<bill.quantity.length;i++){
                bill.phones[i].output();
                System.out.println("So luong"+bill.quantity[i]);
            }
            System.out.println("---------------------");
        }
    }
    public void SortName(){
        Bill tam=new Bill();
        for(int i=0; i<bills.length-1; i++){
            for(int j=0; j<bills.length; j++){
                if(bills[i].customer.getName().compareTo(bills[j].customer.getName())>0)
                {
                    tam=bills[i];
                    bills[i]=bills[j];
                    bills[j]=tam;
                }
            }
        }
    }
    public void SortQuantity() {
        Bill tam = new Bill();
        for (int i = 0; i < bills.length - 1; i++) {
            for (int j = 0; j < bills.length; j++) {
                if(SumQuantity(i)>SumQuantity(j))
                {
                    tam = bills[i];
                    bills[i] = bills[j];
                    bills[j] = tam;
                }
            }
        }
    }
    public int SumQuantity(int a){
            int sum=0;
            for(int i=0; i<bills[a].quantity.length; i++){
                sum=sum+bills[a].quantity[i];
            }
            return sum;
    }
    public void Total(){

        for (int i = 0; i < bills.length - 1; i++){
            int sum=0;
            for(int j=0; i<bills[i].quantity.length; j++){
                sum=sum+(bills[i].quantity[j]*bills[i].phones[j].getPrice());
            }
            System.out.println(bills[i].customer.getiD()+" "+bills[i].customer.getName()+ "  "+sum);
        }
    }


}