package Basics;

import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        //with temp variable
//        int temp=b;
//        b=a;
//        a=temp;
//        System.out.println(a + " "+ b);

        //without temp variable
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a + " "+ b);
    }
}
