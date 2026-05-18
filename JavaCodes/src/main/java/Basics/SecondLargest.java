package Basics;

import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int lar=arr[0];
        int secLar=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>lar){
                lar=arr[i];
                if(arr[i]>secLar && arr[i]!=lar){
                    secLar=arr[i];
                }
            }
        }
        System.out.println(secLar);
    }
}
