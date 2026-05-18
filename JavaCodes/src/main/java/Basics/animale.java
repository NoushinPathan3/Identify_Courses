package Basics;

interface animale {
    void sound();
}
class cat implements animale{
    public void sound(){
        System.out.println("cat is making sound");
    }

    public static void main(String[] args) {
        cat c=new cat();
        c.sound();
    }
}
