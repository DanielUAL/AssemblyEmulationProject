import java.lang.reflect.Array;

/**
 * Lexical Analyzer is a pattern matcher. This code takes the given input string, then sorts
 * between each case and sorts accordingly, printing out the token and lexeme value associated
 * with the token for each input.
 * @author dnaja
 * @version 1.0
 */
public class BonusLexicalAnalyzer {
    /**
     * charClass allows for Strings and Ints to be sorted accordingly. Normally just reading a token
     * is enough for the nextChar. But for strings such as 'sum', the code needs to add 3 tokens into
     * the lexeme before outputting the value.
     */

    /**
     * global declarations:
     * charClass is used for organizing LETTER and DIGIT combinations. Lexeme is a char array that contains each
     * processed char. nextChar assigns itself to the current first value of the char array. Needed so that the compiler
     * can read each lexeme value and act accordingly. lexLen is the size of the lexeme. Int token is there just in case a token
     * alone is needed. nextToken does similar action as the nextChar but deals with the raw tokens that get processed and outputted
     * as lexeme value. Count is a size tracker for later use when dealing with the char array.
     */
    int charClass;
    char lexeme[]; //in c it was char lexeme[100] but a char array is just a string , this might have to be a string array
    char nextChar;
    int lexLen; //size  lexeme
    int token;
    int nextToken;
    int count; // size size
    int instructcount;
    String lexinstuct1;
    String lexinstuct2;
    String lexinstuct3;

    /**character classes
     *  These need to be final int for the sake of the case switch later. EOF just represents an empty 'file' which tells the
     *  compiler to stop reading. LETTER is used in isAlthebetical for combination of char that needs to be processed.
     *  Digit is used in isDigit for combination or single digits that need to be processed. INT_LIT gives the actual token
     *  value for when a digit appears. IDENT gives the actual token value for when a string like char combination appears.
     *  UNKNOWN is needed for any normal case. Such as values that will always be a single char value. Like '+'.
     */
    final int EOF = -1; 	//The output is making it seem like i have to make ASCII code token interpetation
    final int LETTER = 0; 	//need to use isAlthebetical for letters //why is this int and not string
    final int DIGIT = 1; 	//need to use isDigit
    final int REGISTER = 2;

    final int NEGATIVE = 3;
    final int UNKNOWN = 99; //booleans? //ignore
    final int INT_LIT = 10;	  //int number combination
    final int IDENT = 11;	  //string, whatever name

    /**Special Cases
     * The compiler needs to be able to recognize when a combination of LETTER is an actual reserved word. If it is, they need
     * to output a different token value rather than the standard 11 token.
     */
    char halt_code = 30;
    char move_code = 31;
    char interrupt_code = 32;
    char and_code = 33;
    char or_code = 34;
    char xor_code = 35;
    char not_code = 36;
    char leftshift_code = 37;
    char rightshift_code = 38;
    char add_code = 39;
    char subtract_code = 40;
    char multiply_code = 41;

    /**
     * For the loop up function, for the UNKNOWN case. When ever a given char operator or paranthese is given
     * the correct token will be outputted.
     */
    char add_op = 21;
    char sub_op = 22;
    char mult_op = 23;
    char div_op = 24;
    char register_code = 25;
    char negative_code = 26;

    /**
     * The constructor that is needed so that the driver can input a str to be read by the lexical analyzer
     */
    String userinput;
    public BonusLexicalAnalyzer()
    {
        this.userinput = "";
    }

    /**
     * Overloading the constructor, also allocates the userinput, and count values, and lexeme for later use.
     * @param userinput
     */
    public BonusLexicalAnalyzer(String userinput)
    {
        this.userinput = userinput;
        count = 0;
        lexeme = new char[100];
    }

    /**
     * The lookup method is needed to give the UNKNOWN case a token output. Each case is the only times
     * that the loopup will be needed. If none of these UNKNOWN values are present, then the program
     * will return the -1 token which signifies the end of the file. Stopping the lexical analyzer.
     * @param ch
     * @return nextToken The number value that is associated with whatever case that was met.
     */
    int lookup(char ch) {

        // lexeme[0] == 'o' && lexeme[1] == 'r'

        if (ch == 'L') {

        } else {
            addChar();
            nextToken = -1; //will this make it encounter EOF
        }
        return nextToken;
    }


    /**
     * addChar is needed to assign the lexeme with value, without it the lex() would not
     * work since it would have no way to gain the nextChar value. If lexLen is too big,
     * the error will be printed out and stop the program with the nextToken = -1.
     */
    public void addChar()
    {

        if(lexLen  <= 98)
        {
            lexeme[lexLen++] = nextChar;
            lexeme[lexLen] = 0;
        }
        else
        {
            System.out.println("Error - lexeme is too long");
            nextToken = -1;
        }
    }

    //Gets the 'token', puts it in char class
    /**
     * This function gets the 'token' and puts it into the charClass.
     * charClass is the organization identifier. The code before the organization
     * takes place is created to avoid StringIndexOutOfBounds exception that appears
     * when using charAt. When using charAt the index is 1 ahead of the lexeme size
     * causing an OutOfBounds error no matter the size of the given input. But that is why
     * userinput needs to be compared with count to make sure this does not happen casted an int.. The actual
     * charClasses are LETTER, DIGIT, UNKNOWN, and EOF. LETTER is for when there is an alphabetic
     * character is inputed. Digit is for numbers, unknown is for anything else. EOF prints when
     * the there is nothing to input anymore from the userinput.
     */
    public void getChar()
    {

        char keepstrack[] = this.userinput.toCharArray();
        if(count < this.userinput.length())
        {
            if((int)(nextChar = Array.getChar(keepstrack, count)) != 0)
            {
                count++;

                // if(nextChar != EOF){
                if(Character.isAlphabetic(nextChar) && !Character.isUpperCase((nextChar)))
                {
                    charClass = LETTER;
                    //count++;
                }
                else if(Character.isDigit(nextChar))
                {
                    charClass = DIGIT;
                }
                else if(Character.isUpperCase(nextChar)){
                    charClass = REGISTER;
                }
                else if(nextChar == '-'){
                    charClass = NEGATIVE;
                }
                else
                {
                    charClass = UNKNOWN;
                }
            }
            else
                charClass = EOF;
        }
        else
        {
            charClass = EOF;
        }
    }
    /**
     * A function to call getChar until it returns a non whitespace character
     */
    public void getNonBlank(){
        while (nextChar == ' ')
            getChar();
    }


    //Starts the actual lexical analyzer
    /**
     * Starts the actual lexical analyzer. Uses all the methods that were created and acts accordingly
     * to every case. Including special characters that gets taken care of in the LETTER case. charClass
     * is switched for every case so that the proper token value can be assigned to each lexeme that passes
     * through the lex() function.
     */
    int lex()
    {
        lexLen = 0;
        getNonBlank();

        /**
         * Needed to properly organize the tokens.
         */
        switch (charClass){
            /**
             *  Parse identifiers. The function adds each Char until there is no more letters in the input, when there is no more
             *characters to input the function assigns this artificial string as the lexeme value that will be the output.
             */
            case LETTER:
                //System.out.println("LETTER Case");
                addChar();
                getChar();
                while(charClass == LETTER) //|| charClass == DIGIT)
                {
                    addChar ();
                    getChar ();
                }

                /**
                 * Special Cases. If the lexeme has a specific combination of characters
                 * then the program will not give the default LETTER token association and will
                 * provide the correct special nextToken value.
                 */
                if(lexeme[0] == 'h' && lexeme[1] == 'a' && lexeme[2] == 'l' && lexeme[3] == 't')
                {
                    nextToken = halt_code;
                }
                else if(lexeme[0] == 'm' && lexeme[1] == 'o' && lexeme[2] == 'v' && lexeme[3] == 'e')
                {
                    nextToken = move_code;
                }
                else if(lexeme[0] == 'i' && lexeme[1] == 'n' && lexeme[2] == 't' && lexeme[3] == 'e' && lexeme[4] == 'r' && lexeme[5] == 'r' && lexeme[6] == 'u' && lexeme[7] == 'p' && lexeme[8] == 't')
                {
                    nextToken = interrupt_code;
                }
                else if(lexeme[0] == 'a' && lexeme[1] == 'n' && lexeme[2] == 'd')
                {
                    nextToken = and_code;
                }
                else if(lexeme[0] == 'o' && lexeme[1] == 'r')
                {
                    nextToken = or_code;
                }
                else if(lexeme[0] == 'x' && lexeme[1] == 'o' && lexeme[2] == 'r')
                {
                    nextToken = xor_code;
                }
                else if(lexeme[0] == 'n' && lexeme[1] == 'o' && lexeme[2] == 't')
                {
                    nextToken = not_code;
                }
                else if(lexeme[0] == 'l' && lexeme[1] == 'e' && lexeme[2] == 'f' && lexeme[3] == 't' && lexeme[4] == 's'&& lexeme[5] == 'h' && lexeme[6] == 'i' && lexeme[7] == 'f' && lexeme[8] == 't')
                {
                    nextToken = leftshift_code;
                }
                else if(lexeme[0] == 'r' && lexeme[1] == 'i' && lexeme[2] == 'g' && lexeme[3] == 'h' && lexeme[4] == 't'&& lexeme[5] == 's' && lexeme[6] == 'h' && lexeme[7] == 'i' && lexeme[8] == 'f' && lexeme[9] == 't' )
                {
                    nextToken = rightshift_code;
                }
                //R
                else {
                    nextToken = IDENT;
                }
                break;

            /**
             *  Parse integer literals. Does the same while condition as the LETTER for groups of numbers that are greater than 9.
             */
            case DIGIT:
                // System.out.println("DIGIT Case");
                addChar();
                getChar();
                while(charClass == DIGIT)
                {
                    addChar();
                    getChar();
                }
                nextToken = INT_LIT;
                break;

            /**
             *  First prints R then. Parses integer literals. Does the same while condition as the LETTER for groups of numbers that are greater than 9.
             *  This will result in R + the digit or digits after.
             */
            case REGISTER:
                addChar();
                getChar();
                while(charClass == DIGIT)
                {
                    addChar();
                    getChar();
                }
                nextToken = register_code;
                break;

            /**
             *  First prints - then. Parses integer literals. Does the same while condition as the LETTER for groups of numbers that are greater than 9.
             */
            case NEGATIVE:
                addChar();
                getChar();
                while(charClass == DIGIT)
                {
                    addChar();
                    getChar();
                }
                nextToken = negative_code;
                break;

            /**
             *  Parentheses and operators get proccessed with this case.
             */
            case UNKNOWN:
                //System.out.println("Unknown Case");
                lookup(nextChar);
                getChar();
                break;

            /**
             *  EOF , signifies the End Of File.
             */
            case EOF:
                // System.out.println("EOF Case");

                lookup(nextChar);
                getChar();
                lexeme[0] = 'E';
                lexeme[1] = 'O';
                lexeme[2] = 'F';
                lexeme[3] = 0;
                break;
        }

        /**
         * Outputs the lexical analyzer code.
         */
        if(nextToken != -1)
        {
            System.out.println("Next token is: " + nextToken + " Next Lexeme is: " + String.valueOf(lexeme, 0, lexLen));

            if(instructcount == 0){
                lexinstuct1 = String.valueOf(lexeme, 0, lexLen);
                instructcount++;
            }
            else if(instructcount == 1) {
                lexinstuct2 = String.valueOf(lexeme, 0, lexLen);
                instructcount++;
            }
            else if(instructcount == 2){
                lexinstuct3 = String.valueOf(lexeme, 0, lexLen);
                instructcount++;
            }
        }
        else {
            System.out.println("Next token is: " + nextToken + " Next Lexeme is: " + lexeme[0] + lexeme[1] + lexeme[2]);
        }

        return 0;
    }
}