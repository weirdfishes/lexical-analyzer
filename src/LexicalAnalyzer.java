/**
 * Created by sharatv on 1/26/16.
 */

import java.util.*;
import java.io.*;
public class LexicalAnalyzer {
    public static void main(String[] args) {
        //array of reserved words
        String[] reserved = {"bool", "char", "else", "for", "if", "int",
                "printf", "return", "string", "void", "while", "true", "false"};

        //symbols
        String[] symbols = {"\\+", "-", "\\*", "/", "%", "<", "<=", ">",
                ">=", "==", "!=", "=", ";", ",", "\\)", "\\(", "}", "\\{"};

        //corresponding tokens for each symbol
        String[] symbol_strings = {"ADD", "SUB", "MUL", "DIV", "MOD", "LESS", "LESSEQUAL",
                "GREATER", "GREATEREQUAL", "EQUAL", "NOTEQUAL", "ASSIGN", "SEMICOLON", "COMMA",
                "RPAREN", "LPAREN", "RBRACE", "LBRACE"};

        // regex to match single line comments
        String single_line_comment_regex = "//.*";

        // regex to match block comments
        String block_comment_regex = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";

        /*
         * regex that matches all integer constants:
         * sequence of digits that must have at least one digit
         */
        String int_constant_regex = "[0][xX]([0-9a-fA-F]{1,8})|[\\d+]";

        /*
         * regex that matches all string constants:
         * sequence of characters contained within quotes.
         */
        String string_constant_regex = "\".*\"";

        /*
         * regex that matches all identifiers with the form:
         * sequence of letters, digits, and underscores
         * must begin with letter
         */
        String identifier_regex = "(\\b(?!\\bSTRINGCONSTANT\\b|\\bbool\\b|\\bchar\\b|\\belse\\b|\\bfor\\b|" +
                "\\bif\\b|\\bint\\b|\\bprintf\\b|\\breturn\\b|\\bstring\\b|\\bvoid\\b|\\bwhile\\b|" +
                "\\btrue\\b|\\bfalse\\b))([a-zA-Z][_a-zA-Z0-9]*)";

        String filename = "input.txt";
        File file = new File(filename);
        Scanner fileScanner;
        Scanner blockCommentScanner;
        String input = "";



        /*
         * Try catch block to read entire file into 'input' String
         * All block comments in 'input' are then removed
         * 'input' is then read through by another scanner and can
         * be tokenized line by line.
         */
        try {
            blockCommentScanner = new Scanner(file);

            while(blockCommentScanner.hasNextLine()) {
                input = input.concat(blockCommentScanner.nextLine() + "\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        input = input.replaceAll(block_comment_regex, "");

        /*
         * Try-catch block to tokenize the 'input' String line by line
         */

        try {
            fileScanner = new Scanner(input);

            while(fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String s = line;

                s = s.replaceAll(single_line_comment_regex, "");

                s = s.replaceAll("[ \t]", "");
                //replace all string constant matches with token
                s = s.replaceAll(string_constant_regex, "STRINGCONSTANT ");

                //replace all identifier matches with the token
                s = s.replaceAll(identifier_regex, "ID ");

                //iterate through reserved words and replace any occurrence of each whole word
                for(int i = 0; i < reserved.length; i++)
                    s = s.replaceAll("\\b" + reserved[i] + "\\b", reserved[i].toUpperCase() + " ");

                //iterate through symbols and replace each symbol with the corresponding symbol token
                for(int j = 0; j < symbols.length; j++)
                    s = s.replaceAll(symbols[j], symbol_strings[j] + " ");

                //replace all matches to integer constants with the token
                s = s.replaceAll(int_constant_regex, "INTCONSTANT ");

                if(!s.equals(""))
                    System.out.println(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}