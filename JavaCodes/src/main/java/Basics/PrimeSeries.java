package Basics;

import java.util.Scanner;

public class PrimeSeries {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int i=0;
        for(i=2;i<=n;i++){
            boolean found=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    found=false;
                    break;
                }
            }
            if(found==true){
                System.out.println(i);
            }
        }

    }
}
