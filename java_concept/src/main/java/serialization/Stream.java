package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
A stream  - is a method to sequentially access a file. I/O Stream means an input source or output destination representing different
types of sources e.g. disk files.The java.io package provides classes that allow you to convert between Unicode character streams
and byte streams of non-Unicode text.

 A stream is a way of sequentially accessing a file. A byte stream access the file byte by byte. A byte stream is suitable for any
kind of file, however not quite appropriate for text files. For example, if the file is using a unicode encoding and a character
is represented with two bytes, the byte stream will treat these separately and you will need to do the conversion yourself.

A character stream will read a file character by character. A character stream needs to be given the file's encoding in order to
work properly.

Byte oriented reads byte by byte.  A byte stream is suitable for processing raw data like binary files.

In Java, characters are stored using Unicode conventions. Character stream is useful when we want to process text files.
These text files can be processed character by character. A character size is typically 16 bits.

Stream – A sequence of data.
Input Stream: reads data from source.
Output Stream: writes data to destination.



Unicode  - The Unicode Standard provides a unique number for every character, no matter what platform, device, application or language.
It has been adopted by all modern software providers and now allows data to be transported through many different platforms, devices
and applications without corruption. Support of Unicode forms the foundation for the representation of languages and symbols in all
major operating systems, search engines, browsers, laptops, and smart phones—plus the Internet and World Wide Web
 (URLs, HTML, XML, CSS, JSON, etc.). Supporting Unicode is the best way to implement ISO/IEC 10646.

The emergence of the Unicode Standard and the availability of tools supporting it are among the most significant recent global
software technology trends.


ASCII has just 127 characters.


Unicode
is a set of characters used around the world
UTF-8
a character encoding capable of encoding all possible characters (called code points) in Unicode.
code unit is 8-bits
use one to four code units to encode Unicode
00100100 for "$" (one 8-bits);11000010 10100010 for "¢" (two 8-bits);11100010 10000010 10101100 for "€" (three 8-bits)
UTF-16
another character encoding
code unit is 16-bits
use one to two code units to encode Unicode
00000000 00100100 for "$" (one 16-bits);11011000 01010010 11011111 01100010 for "𤭢" (two 16-bits)


In ASCII or ISO 8859, each character is represented by one byte
In UTF-32, each character is represented by 4 bytes
In UTF-8, each character uses between 1 and 4 bytes
In ISO 2022, it's much more complicated
* */


//
/**
 * Created by pourush.sinha on 01/07/18.
 */
public class Stream {

    public static void byteStreamOperation() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("java_concept/test.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

           /* c = in.read();
            out.write(c);*/

            while ((c = in.read()) != -1) {
                System.out.println(c);
                out.write(c);
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
    private static void characterStreamOperation() throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("java_concept/test.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.println(c);
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        byteStreamOperation();

        System.out.println("-------------------");
        characterStreamOperation();

    }


}
