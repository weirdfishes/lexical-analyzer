/**
 * Created by sharatv on 1/26/16.
 */

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        String[] reserved = {"bool", "char", "else", "for", "if", "int", "printf", "return", "string", "void", "while", "true", "false"};
        String[] operators = {"+", "-", "*", "/", "%", "<", "<=", ">", ">=", "==", "!=", "=", ";", ",", ")", "(", "}", "{"};
        ArrayList<String> tokens = new ArrayList<>();


        ArrayList res = new ArrayList<>(Arrays.asList(reserved));
        ArrayList op = new ArrayList<>(Arrays.asList(operators));

        System.out.println("Specify a file");
        String fileName = kb.nextLine();

        File file = new File(fileName);

        Scanner read;

        try {
            read = new Scanner(file);


            while(read.hasNext()) {
                String temp = read.next();

            }

        } catch(Exception e) {
            e.printStackTrace();
        }




    }

}