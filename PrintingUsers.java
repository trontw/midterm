import java.security.cert.LDAPCertStoreParameters;
import java.util.Scanner;
import java.lang.Integer;
import java.io.*;

public class PrintingUsers {

    HashNode[] table;
    private static int numelements;
    int size;

    public PrintingUsers() {
        size = 100;
        numelements = 0;
        table = new HashNode[size];
    }

    public static void main(String[] args) {

        try {
            Scanner sk = new Scanner(System.in);
            HashSet x = new HashSet();
            // Download the input file and get the names
            // System.out.println("-----------------");
            while (sk.hasNext()) {
                String person = sk.next();
                if (x.find(person)) {
                    // System.out.println("Found " + person);
                    // Remove them from the hash table then continue
                    x.remove(person);
                    // continue;
                } else {
                    // One by one, until we get to a "Print", we hash the username
                    // and insert them into the hash table
                    x.insert(person);
                    if (person.equals("PRINT")) {
                        x.remove(person);
                        System.out.println("-----------------");
                        person = sk.nextLine();
                        x.print();
                    }
                }
                // System.out.println(person);
                // x.print();
            }
            // x.print();
            // sk.close();
            // Scanner st = new Scanner(System.in);
            // System.out.println("We are getting to the second scanner");
            while (sk.hasNext()) {
                String person = sk.next();
                System.out.println("Inside second WHILE, person is " + person);
                // If person already there, then remove
                // them from the list
                if (x.find(person))
                    System.out.println("Found " + person);
            }
            sk.close();
        } catch (IllegalAccessError e) {
            System.out.println("Cannot open file ");
            System.out.println(e);
        }
    }
}
