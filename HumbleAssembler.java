/**
 * Allows for the user to input Strings to do commands instead of manually inputting an entire collection of bits
 */
public class HumbleAssembler {

    private static final String HALT = "0000";
    private static final String MOVE = "0001";
    private static final String INTERRUPT = "0010";

    private static final String AND = "1000";
    private static final String OR = "1001";
    private static final String XOR = "1010";
    private static final String NOT = "1011";
    private static final String LEFTSHIFT = "1100";
    private static final String RIGHTSHIFT = "1101";
    private static final String ADD = "1110";
    private static final String SUBTRACT = "1111";
    private static final String MULTIPLY = "0111";

    /**
     * This will interpret all inputs from user, convert from the inputted String to the binary equivalent for each part. Then all of these binary
     * Strings will be assembled together, to be used.
     * @param Inputs Seperates each instruction so that the methods can act accordingly.
     * @return Returns the String output for the preload to use.
     * @throws IllegalStateException Throws an exception in cases where user puts in the wrong register index, or opcode string name.
     */
    public static String assemble(String[] Inputs) throws IllegalStateException {

        String AssembledString = "";

        switch (Inputs[0]) {

            case "halt":
                AssembledString = AssembledString + HALT + "000000000000";
                break;

            case "move":
                AssembledString = AssembledString + MOVE;

                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                }else{
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String StringValue = Inputs[2];
                    int IntValue = Integer.parseInt(StringValue);
                    HumbleLongWord LongWordValue = new HumbleLongWord();
                    LongWordValue.set(IntValue);

                    if (LongWordValue.getBit(7).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(6).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(5).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(4).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(3).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(2).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(1).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }

                    if (LongWordValue.getBit(0).getValue()) {
                        AssembledString = AssembledString + "1";
                    } else {
                        AssembledString = AssembledString + "0";
                    }
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                break;

            case "interrupt":
                AssembledString = AssembledString + INTERRUPT;
                if ("0".equals(Inputs[1])) {
                    AssembledString = AssembledString + "000000000000";
                } else {
                    AssembledString = AssembledString + "000000000001";
                }
                break;

            case "and":
                AssembledString = AssembledString + AND;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "or":
                AssembledString = AssembledString + OR;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "xor":
                AssembledString = AssembledString + XOR;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "not":
                AssembledString = AssembledString + NOT;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "leftshift":
                AssembledString = AssembledString + LEFTSHIFT;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "rightshift":
                AssembledString = AssembledString + RIGHTSHIFT;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "add":
                AssembledString = AssembledString + ADD;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "subtract":
                AssembledString = AssembledString + SUBTRACT;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;

            case "multiply":
                AssembledString = AssembledString + MULTIPLY;
                if (Inputs[1] != null) {
                    String inputtemp = Inputs[1];
                    AssembledString = AssembledString + Inputs1Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                if (Inputs[2] != null) {
                    String inputtemp = Inputs[2];
                    AssembledString = AssembledString + Inputs2Switch(inputtemp, AssembledString);
                } else {
                    throw new IllegalStateException("Unexpected value: " + null);
                }
                AssembledString = AssembledString + "0000";
                break;
        }
        return AssembledString;
    }

    /**
     * The Register to binary conversion is needed a lot, so to avoid rewriting the same code, a method is created that can be called.
     * @param inputtemp Arbitrary temp variable used so the switch statement knows to u se the Input[1] from the user
     * @param Input1AssembledString Arbitrary String value, but will contain the binary equivalent of a register number.
     * @return The binary equivalent of the register number, that will be added to the AssembledString.
     */
    public static String Inputs1Switch(String inputtemp, String Input1AssembledString) {
        Input1AssembledString = "";
        switch (inputtemp) {
            case "R0":
                Input1AssembledString = Input1AssembledString + "0000";
            break;
            case "R1":
                Input1AssembledString = Input1AssembledString + "0001";
            break;
            case "R2":
                Input1AssembledString = Input1AssembledString + "0010";
            break;
            case "R3":
                Input1AssembledString = Input1AssembledString + "0011";
            break;
            case "R4":
                Input1AssembledString = Input1AssembledString + "0100";
            break;
            case "R5":
                Input1AssembledString = Input1AssembledString + "0101";
                break;
            case "R6":
                Input1AssembledString = Input1AssembledString + "0110";
                break;
            case "R7":
                Input1AssembledString = Input1AssembledString + "0111";
                break;
            case "R8":
                Input1AssembledString = Input1AssembledString + "1000";
                break;
            case "R9":
                Input1AssembledString = Input1AssembledString + "1001";
                break;
            case "R10":
                Input1AssembledString = Input1AssembledString + "1010";
                break;
            case "R11":
                Input1AssembledString = Input1AssembledString + "1011";
                break;
            case "R12":
                Input1AssembledString = Input1AssembledString + "1100";
                break;
            case "R13":
                Input1AssembledString = Input1AssembledString + "1101";
                break;
            case "R14":
                Input1AssembledString = Input1AssembledString + "1110";
                break;
            case "R15":
                Input1AssembledString = Input1AssembledString + "1111";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputtemp);
        }
        return Input1AssembledString;
    }

    /**
     * The Register to binary conversion is needed a lot, so to avoid rewriting the same code, a method is created that can be called.
     * @param inputtemp Arbitrary temp variable used so the switch statement knows to u se the Input[2] from the user
     * @param Input2AssembledString Arbitrary String value, but will contain the binary equivalent of a register number.
     * @return The binary equivalent of the register number, that will be added to the AssembledString.
     */
    public static String Inputs2Switch(String inputtemp, String Input2AssembledString) {
        Input2AssembledString = "";
        switch (inputtemp) {
            case "R0":
                Input2AssembledString = Input2AssembledString + "0000";
                break;
            case "R1":
                Input2AssembledString = Input2AssembledString + "0001";
                break;
            case "R2":
                Input2AssembledString = Input2AssembledString + "0010";
                break;
            case "R3":
                Input2AssembledString = Input2AssembledString + "0011";
                break;
            case "R4":
                Input2AssembledString = Input2AssembledString + "0100";
                break;
            case "R5":
                Input2AssembledString = Input2AssembledString + "0101";
                break;
            case "R6":
                Input2AssembledString = Input2AssembledString + "0110";
                break;
            case "R7":
                Input2AssembledString = Input2AssembledString + "0111";
                break;
            case "R8":
                Input2AssembledString = Input2AssembledString + "1000";
                break;
            case "R9":
                Input2AssembledString = Input2AssembledString + "1001";
                break;
            case "R10":
                Input2AssembledString = Input2AssembledString + "1010";
                break;
            case "R11":
                Input2AssembledString = Input2AssembledString + "1011";
                break;
            case "R12":
                Input2AssembledString = Input2AssembledString + "1100";
                break;
            case "R13":
                Input2AssembledString = Input2AssembledString + "1101";
                break;
            case "R14":
                Input2AssembledString = Input2AssembledString + "1110";
                break;
            case "R15":
                Input2AssembledString = Input2AssembledString + "1111";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputtemp);
        }
        return Input2AssembledString;
    }

}


