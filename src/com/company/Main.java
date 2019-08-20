/*Project Documentation :
This project using Factory methode design pattern to parse "json" and "xml" files and print there contents in a file called "result.txt".

Be carefull ! change the paths of your intended files in both XMLFileParser and JSONFileParser classes and the path of
              result file to where you want to create it.
*/
package com.company;
import com.google.common.io.Files;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter file name with extension please : ");
        Scanner sc1 = new Scanner(System.in);
        String filename = sc1.nextLine();
        String filetype = Files.getFileExtension(filename);
        FileParser p = new FileParser();
        p.getParser(filename,filetype);

    }
}
