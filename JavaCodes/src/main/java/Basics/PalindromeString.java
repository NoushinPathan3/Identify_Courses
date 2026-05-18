package Basics;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        String temp=str;
        char[] arr=str.toCharArray();
        int left=0;
        int right=str.length()-1;
        while(left<right){
            char t=arr[left];
            arr[right]=arr[left];
            arr[left]=t;
            left+=1;
            right-=1;
        }
        if(temp==str){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}
