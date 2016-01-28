/**
 * Created by sharatv on 1/26/16.
 */

import java.util.*;
import java.io.*;

public class LexicalAnalyzer {

    public static void main(String[] args) {


        //array of reserved words
        String[] reserved = {"bool", "char", "else", "for", "if", "int", "printf", "return", "string", "void", "while", "true", "false"};

        //symbols
        String[] symbols = {"\\+", "-", "\\*", "/", "%", "<", "<=", ">", ">=", "==", "!=", "=", ";", ",", "\\)", "\\(", "}", "\\{"};

        //corresponding tokens for each symbol
        String[] symbol_strings = {"ADD", "SUB", "MUL", "DIV", "MOD", "LESS", "LESSEQUAL", "GREATER", "GREATEREQUAL", "EQUAL", "NOTEQUAL", "ASSIGN", "SEMICOLON", "COMMA", "RPAREN", "LPAREN", "RBRACE", "LBRACE"};


        /*
         * regex that matches all integer constants:
         * sequence of digits that must have at least one digit
         */
        String intconstant = "\\d+";

        /*
         * regex that matches all string constants:
         * sequence of characters contained within quotes.
         */
        String stringconstant = "\".*\"";


        /*
         * regex that matches all identifiers with the form:
         * sequence of letters, digits, and underscores
         * must begin with letter
         */
        String identifier = "(\\b(?!\\bSTRINGCONSTANT\\b|\\bbool\\b|\\bchar\\b|\\belse\\b|\\bfor\\b|\\bif\\b|\\bint\\b|\\bprintf\\b" +
                "|\\breturn\\b|\\bstring\\b|\\bvoid\\b|\\bwhile\\b|\\btrue\\b|\\bfalse\\b))([a-zA-Z][_a-zA-Z0-9]*)";


        String filename = "input.txt";
        File file = new File(filename);

        Scanner fileScanner;

        try {
            fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String s = line;

                s = s.replaceAll(stringconstant, "STRINGCONSTANT ");
                s = s.replaceAll(identifier, "ID ");

                for(int i = 0; i < reserved.length; i++)
                    s = s.replaceAll("\\b" + reserved[i] + "\\b", reserved[i].toUpperCase() + " ");

                for(int j = 0; j < symbols.length; j++)
                    s = s.replaceAll(symbols[j], symbol_strings[j] + " ");

                s = s.replaceAll(intconstant, "INTCONSTANT ");
                System.out.println(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}