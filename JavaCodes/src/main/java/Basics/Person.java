package Basics;

public class Person {
    private int age;

    public void setAge(int a){
        this.age=a;
    }
    public int getAge(){
        return age;
    }

    public static void main(String[] args) {
        Person p=new Person();
        p.setAge(20);
        System.out.println(p.getAge());
    }
}
