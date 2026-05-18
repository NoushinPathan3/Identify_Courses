package Basics;

import java.util.Scanner;

public class ReverseString {
    //----char array and swapping-------
//    public static void main(String[] args){
//        Scanner s=new Scanner(System.in);
//        String str=s.nextLine();
//        int left=0;
//        int right=str.length()-1;
//        char[] arr=str.toCharArray();
//        while(left<right){
//            char temp=arr[left];
//            arr[left]=arr[right];
//            arr[right]=temp;
//            left+=1;
//            right-=1;
//        }
//        System.out.println(new String(arr));
//    }

    //-------String builder-------
//    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
//        String str=s.nextLine();
//        StringBuilder b=new StringBuilder(str);
//        System.out.println(b.reverse());
//    }

    //----for loop and concatenate
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        String rev="";
        for(int c=str.length()-1;c>=0;c--){
            rev+=str.charAt(c);
        }
        System.out.println(rev);
    }
}
