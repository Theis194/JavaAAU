import java.util.*;

public class Test {
    public static String myString = "Hello World!";

    public static void main(String[] args) {
        System.out.println(myString);

        LinkedList<String> myList = new LinkedList<String>();

        myList.add("myString1");
        myList.add("myString2");
        myList.add("myString3");

        System.out.println(myList);
    }
}
