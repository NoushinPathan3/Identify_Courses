package Basics;

import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int num=s.nextInt();
        boolean found=true;
        for(int i=2;i<num;i++){
            if(num%i==0){
                found=false;
                break;
            }

        }
        if(found){
            System.out.println("Prime");
        }else{
            System.out.println("Not Prime");
        }
    }
}
