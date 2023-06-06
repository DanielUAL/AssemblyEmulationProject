public class bonus_test {
    String haltinstruct;
    String moveinstruct1;
    String moveinstruct2;
    String moveinstruct3;
    String negmoveinstruct1;
    String negmoveinstruct2;
    String negmoveinstruct3;
    String interruptmeminstruct1;
    String interruptmeminstruct2;
    String interruptreginstruct1;
    String interruptreginstruct2;
    String ANDinstruct1;
    String ANDinstruct2;
    String ANDinstruct3;
    String ORinstruct1;
    String ORinstruct2;
    String ORinstruct3;
    String XORinstruct1;
    String XORinstruct2;
    String XORinstruct3;
    String NOTinstruct1;
    String NOTinstruct2;
    String NOTinstruct3;
    String leftshiftinstruct1;
    String leftshiftinstruct2;
    String leftshiftinstruct3;
    String rightshiftinstruct1;
    String rightshiftinstruct2;
    String rightshiftinstruct3;
    String addinstruct1;
    String addinstruct2;
    String addinstruct3;
    String subtractinstruct1;
    String subtractinstruct2;
    String subtractinstruct3;
    String multiplyinstruct1;
    String multiplyinstruct2;
    String multiplyinstruct3;

    /**
     * Runs the LexicalAnalyzer and SyntaxAnalzer for every string that is going to be tested in the assembler. One string input is separated into however
     * much String instructs are needed for the assembler.
     */
    public void runBonus() {
        {
            System.out.println("__________________________________________________Halt Lexical__________________________________________________");
            halt();
            System.out.println("__________________________________________________Move Lexical__________________________________________________");
            move();
            System.out.println("__________________________________________________NegMove Lexical__________________________________________________");
            negmove();
            System.out.println("__________________________________________________InterruptMem Lexical__________________________________________________");
            interruptmem();
            System.out.println("__________________________________________________InterruptReg Lexical__________________________________________________");
            interruptreg();
            System.out.println("__________________________________________________AND Lexical__________________________________________________");
            and();
            System.out.println("__________________________________________________OR Lexical__________________________________________________");
            or();
            System.out.println("__________________________________________________XOR Lexical__________________________________________________");
            xor();
            System.out.println("__________________________________________________NOT Lexical__________________________________________________");
            not();
            System.out.println("__________________________________________________LeftShift Lexical__________________________________________________");
            leftshift();
            System.out.println("__________________________________________________RightShift Lexical__________________________________________________");
            rightshift();
            System.out.println("__________________________________________________Add Lexical__________________________________________________");
            add();
            System.out.println("__________________________________________________Subtract Lexical__________________________________________________");
            subtract();
            System.out.println("__________________________________________________Multiply Lexical__________________________________________________");
            multiply();
        }
    }

    /**
     * The string input "halt" goes into the parser. Then the output string halt is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string.
     */
    public void halt(){
        {
            String input = "halt";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            haltinstruct = lexcode.lexinstuct1;
        }
    }

    /**
     * The string input "move R2 10" goes into the parser. Then the output string move, R2, and 10 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void move(){
        {
            String input = "move R2 10";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            moveinstruct1 = lexcode.lexinstuct1;
            moveinstruct2 = lexcode.lexinstuct2;
            moveinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "move R15 -1" goes into the parser. Then the output string move, R15, and -1 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void negmove(){
        {
            String input = "move R15 -1";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

             negmoveinstruct1 = lexcode.lexinstuct1;
             negmoveinstruct2 = lexcode.lexinstuct2;
             negmoveinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "interrupt 0" goes into the parser. Then the output string interrupt and 0 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void interruptmem(){
        {
            String input = "interrupt 0";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            interruptmeminstruct1 = lexcode.lexinstuct1;
            interruptmeminstruct2 = lexcode.lexinstuct2;
        }
    }

    /**
     * The string input "interrupt 1" goes into the parser. Then the output string interrupt and 1 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void interruptreg(){
        {
            String input = "interrupt 1";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            interruptreginstruct1 = lexcode.lexinstuct1;
            interruptreginstruct2 = lexcode.lexinstuct2;
        }
    }

    /**
     * The string input "and R4 R12" goes into the parser. Then the output string and, R4, and R12 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void and(){
        {
            String input = "and R4 R12";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            ANDinstruct1 = lexcode.lexinstuct1;
            ANDinstruct2 = lexcode.lexinstuct2;
            ANDinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "or R5 R3" goes into the parser. Then the output string or, R5, and R3 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void or(){
        {
            String input = "or R5 R3";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            ORinstruct1 = lexcode.lexinstuct1;
            ORinstruct2 = lexcode.lexinstuct2;
            ORinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "xor R3 R6" goes into the parser. Then the output string xor, R3, and R6 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void xor(){
        {
            String input = "xor R3 R6";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            XORinstruct1 = lexcode.lexinstuct1;
            XORinstruct2 = lexcode.lexinstuct2;
            XORinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "not R8 R7" goes into the parser. Then the output string not, R8, and R7 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void not(){
        {
            String input = "not R8 R7";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            NOTinstruct1 = lexcode.lexinstuct1;
            NOTinstruct2 = lexcode.lexinstuct2;
            NOTinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "leftshift R3 R6" goes into the parser. Then the output string leftshift, R3, and R6 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void leftshift(){
        {
            String input = "leftshift R3 R6";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            leftshiftinstruct1 = lexcode.lexinstuct1;
            leftshiftinstruct2 = lexcode.lexinstuct2;
            leftshiftinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "rightshift R12 R14" goes into the parser. Then the output string rightshift, R12, and R14 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void rightshift(){
        {
            String input = "rightshift R12 R14";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            rightshiftinstruct1 = lexcode.lexinstuct1;
            rightshiftinstruct2 = lexcode.lexinstuct2;
            rightshiftinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "add R15 R2" goes into the parser. Then the output string add, R15, and R2 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void add(){
        {
            String input = "add R15 R2";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            addinstruct1 = lexcode.lexinstuct1;
            addinstruct2 = lexcode.lexinstuct2;
            addinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "subtract R12 R6" goes into the parser. Then the output string subtract, R12, and R6 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void subtract(){
        {
            String input = "subtract R12 R6";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            subtractinstruct1 = lexcode.lexinstuct1;
            subtractinstruct2 = lexcode.lexinstuct2;
            subtractinstruct3 = lexcode.lexinstuct3;
        }
    }

    /**
     * The string input "multiply R2 R2" goes into the parser. Then the output string multiply, R2, and R2 is given. The string is gone through one character at a time
     * Separating into tokens, that are put together as a string. Deciding which string is string based on the spaces between the input.
     */
    public void multiply(){
        {
            String input = "multiply R2 R2";

            BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer(input);
            lexcode.getChar();
            while (lexcode.nextToken != -1) {
                lexcode.lex();
            }
            System.out.println("lexical analyzer done");
            BonusSyntaxAnalyzer syntax = new BonusSyntaxAnalyzer(new BonusLexicalAnalyzer(input));
            System.out.println("syntax analyzer done");

            multiplyinstruct1 = lexcode.lexinstuct1;
            multiplyinstruct2 = lexcode.lexinstuct2;
            multiplyinstruct3 = lexcode.lexinstuct3;
        }
    }
}
