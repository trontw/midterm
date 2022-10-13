import java.util.Scanner;
import java.io.*;

public class text_trim {

    public static void main(String[] args) {
        String text = null;
        Scanner kb = new Scanner(System.in);
        while (kb.hasNext()) {
            text = kb.next();
            text = text.replaceAll("\\r\\n|\\r|\\n", "X");
            System.out.println(text);
        }

    }

}
