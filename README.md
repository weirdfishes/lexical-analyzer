# lexical-analyzer
lexical analyzer written in Java to tokenize a C-like language



### compile

    $ javac LexicalAnalyzer.java


### run

    $ java LexicalAnalyzer filename.txt



### input

input file must be in the same directory as the java class, and must have the following syntax rules:
see input.txt for sample syntax.


### output

Int constants tokenized as INTCONSTANT, String constant as STRINGCONSTANT.
All symbols and reserved words are also tokenized.
Block and single-line comments are removed.

example output of input.txt:
     ID LPAREN ID RPAREN 
     LBRACE 
     IF LPAREN ID EQUAL INTCONSTANT RPAREN 
     LBRACE 
     ID SEMICOLON 
     RBRACE 
     ID LPAREN ID SUB INTCONSTANT RPAREN SEMICOLON 
     RBRACE 
     ID LPAREN RPAREN LBRACE 
     ID ASSIGN INTCONSTANT INTCONSTANT SEMICOLON 
     PRINTF LPAREN COMMA ID LPAREN ID RPAREN RPAREN SEMICOLON 
     RBRACE 
