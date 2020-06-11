package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by pourush.sinha on 01/07/18.
 */

/*
* Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse
* process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.
* Check below link
* ransient is a Java keyword which marks a member variable not to be serialized when it is persisted to streams of bytes. When an
* object is transferred through the network, the object needs to be 'serialized'. Serialization converts the object state to serial bytes.
* https://docs.google.com/document/d/1k0VAPFKx-FMYg846DE5HP5-CCnmhHLi_18jkCXvifTg/edit
*/
class Emp implements Serializable{

    private static final long serialversionUID =
            129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    // Default constructor
    public Emp(String name, int age, int a, int b)
    {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }

}
public class SerializationTest  {

    public static void printdata(Emp object1)
    {

        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String[] args) throws IOException {

        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "java_concept/shubham.txt";

        // Serialization
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printdata(object);

            // value of static variable changed
            object.b = 2000;
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (filename);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            object = (Emp)in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(object);

            // System.out.println("z = " + object1.z);
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }
}
