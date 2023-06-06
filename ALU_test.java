public class ALU_test {
    /**
     * Runs ALU Testing
     */
    public static void runALUTests(){
        HumbleLongWord number1 = new HumbleLongWord();
        HumbleLongWord number2 = new HumbleLongWord();

        HumbleBit[] operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(false) ,new HumbleBit(false) ,new HumbleBit(true)}; //1000
        number1.set(15);
        number2.set(7);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000000111");
        System.out.println("AND Operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(false) ,new HumbleBit(false) ,new HumbleBit(true)}; //1001
        number1.set(15);
        number2.set(7);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000001111");
        System.out.println("OR operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(true) ,new HumbleBit(false) ,new HumbleBit(true)}; //1010
        number1.set(15);
        number2.set(7);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000001000");
        System.out.println("XOR operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(false) ,new HumbleBit(true)}; //1011
        number1.set(15);
        number2.set(7);
        System.out.println(number1);
        System.out.println("Expected value: 11111111111111111111111111110000");
        System.out.println("NOT operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(false) ,new HumbleBit(true) ,new HumbleBit(true)}; //1100
        number1.set(88888888);
        number2.set(4);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 01010100110001010110001110000000");
        System.out.println("Left Shift operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(false) ,new HumbleBit(true) ,new HumbleBit(true)}; //1101
        number1.set(88888888);
        number2.set(4);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000010101001100010101100011");
        System.out.println("Right Shift operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(false)}; //1110
        number1.set(15);
        number2.set(4);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000010011");
        System.out.println("Add operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(true)}; //1110
        number1.set(15);
        number2.set(4);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000001011");
        System.out.println("Subtract operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");

        operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(true)}; //0111
        number1.set(15);
        number2.set(4);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println("Expected value: 00000000000000000000000000111100");
        System.out.println("Multiplier operator: " + HumbleALU.doOp(operation, number1, number2));
        System.out.println(" ");
    }
}