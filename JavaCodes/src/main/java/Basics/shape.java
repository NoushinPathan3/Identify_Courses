package Basics;

abstract class shape {
    abstract void shape();
}
class circle extends shape{
    void shape(){
        System.out.println("drawing a circle");
    }

    public static void main(String[] args) {
        circle c=new circle();
        c.shape();
    }
}
