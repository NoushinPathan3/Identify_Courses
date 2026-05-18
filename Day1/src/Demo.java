/*class TestClass {
    int n;
    void print() {
        System.out.println("test data");
    }

    void display(int i) {
        n = i;
        System.out.println(n);
    }
}


public class Demo {
    public static void main(String[] args) {
        TestClass obj1 = new TestClass();
        TestClass obj2 = new TestClass();

        obj1.display(50);
        obj1.print();

        obj2.print();
    }
}*/

package Exception;

public class ThrowsExample {

    // Method declares it may throw an exception
    static void checkNumber() throws Exception { // tell that chances of error is possible
        System.out.println("Inside checkNumber()");
        // int n=5/0;
        throw new Exception("Manually thrown exception!");// custom error msg passed
    }

    public static void main(String[] args) {
        try {
            checkNumber();   // Exception propagated to main()
        }
        catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage()); // dusplay the custom error message
        }

        System.out.println("Program continues...");
    }
}


