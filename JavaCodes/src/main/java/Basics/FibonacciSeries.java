package Basics;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a=0;
        int b=1;
        System.out.println(a);
        System.out.println(b);
        for(int i=2;i<n;i++){
            int nextnum=a+b;
            System.out.println(nextnum);
            a=b;
            b=nextnum;
        }
    }
}
