public class BonusSyntaxAnalyzer {
    BonusLexicalAnalyzer lexcode = new BonusLexicalAnalyzer();
    int nextToken;

    /**
     * 	There are three main methods that recurse and call themselves and goes
     * through all the lexical inputs.
     *		group 1	//enter expr, if not + | -  else use term method
     *		group 2	//enter term, if not * | / else use factor
     *		group 3   //enter factor, if not string number ( ), go to expr
     *		These groups repeat until '-1' token comes to signify empty calls each other
     *		*, /, +, -, LETTER, DIGIT, (, ), are only things
     *	dealt with tokens wise. there are three groupings.
     */
    public BonusSyntaxAnalyzer(BonusLexicalAnalyzer lexcode) {
        lexcode.getChar();

        do {
            this.nextToken = lexcode.lex();
            expr();
        }while(lexcode.nextToken != -1);
    }



    /**
     * The <expr> will check to see if the lexcode token is either an addition sign or subtraction sign.
     * If it is neither, it will call the <term> method.
     */
    public void expr()
    {
        System.out.println("Enter <expr>");
        term();

        while(lexcode.nextToken == lexcode.add_op || lexcode.nextToken == lexcode.sub_op)
        {
            lexcode.lex();
            term();
        }
        System.out.println("Exit <expr>");

    }

    /**
     * The <term> will check to see if the lexcode token is either an multiplication sign or division sign.
     * If it is neither, it will call the <factor> method.
     */
    public void term()
    {
        System.out.println("Enter <term>");
        factor();

        while(lexcode.nextToken == lexcode.mult_op || lexcode.nextToken == lexcode.div_op)
        {
            lexcode.lex();
            factor();
        }
        System.out.println("Exit <term>");

    }

    /**
     * The <factor> will check to see if the lexcode token is either a left paran, right paran
     * LETTER or DIGIT. If it is none, it will call the <expr> method.
     */
    public void factor()
    {

        System.out.println("Enter <factor>");

        if(lexcode.nextToken == lexcode.IDENT || lexcode.nextToken == lexcode.INT_LIT) {
            lexcode.lex();
        }
        else
        {
            if(lexcode.nextToken == lexcode.register_code) {
                lexcode.lex();
                expr();

                if(lexcode.nextToken == lexcode.negative_code) {
                    lexcode.lex();
                }

                else
                {
                    System.out.println("SyntaxAnalyzerError");
                }}else{
            }
        }
    }
}
