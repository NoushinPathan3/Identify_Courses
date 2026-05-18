package Basics;

public class Animals {
    void sound(){
        System.out.println("Animals are making sound");
    }
}
class Dogs extends Animals{
    @Override
    void sound(){
        System.out.println("Dog is barking");
    }

    public static void main(String[] args) {
        Animals d=new Dogs();
        d.sound();
    }
}
