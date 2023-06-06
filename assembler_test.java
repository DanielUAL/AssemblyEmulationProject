public class assembler_test {
    /**
     * Tests out the Assembler, creates new Strings for each tested operation
     */
    public static void runAssemblerTest() {
        String HaltTest[] = new String[]{"halt"};
        String MoveTest[] = new String[]{"move", "R2", "10"};
        String MoveNegTest[] = new String[]{"move", "R15", "-1"};
        String InterruptMemTest[] = new String[]{"interrupt", "0"};
        String InterruptRegTest[] = new String[]{"interrupt", "1"};

        String ANDTest[] = new String[]{"and", "R4", "R12"};
        String ORTest[] = new String[]{"or", "R5", "R3"};
        String XORTest[] = new String[]{"xor", "R3", "R6"};
        String NOTTest[] = new String[]{"not", "R8", "R7"};
        String leftShiftTest[] = new String[]{"leftshift", "R3", "R6"};
        String rightShiftTest[] = new String[]{"rightshift", "R12", "R14"};
        String addTest[] = new String[]{"add", "R15", "R2"};
        String subTest[] = new String[]{"subtract", "R12", "R6"};
        String multTest[] = new String[]{"multiply", "R2", "R2"};

        String BranchLessThan[] = new String[]{"BranchLessThan","1"}; //register
        String BranchGreaterThan[] = new String[]{"BranchGreaterThan","2"}; //register
        String BranchLessThanOrEqual[] = new String[]{"BranchLessThanOrEqual","3"}; //register
        String BranchGreaterThanOrEqual[] = new String[]{"BranchGreaterThanOrEqual","4"}; //register

        String Command = "";

        Command = HumbleAssembler.assemble(HaltTest);
        System.out.println("Expected Value: 0000000000000000");
        System.out.println("Halt Command:   " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(MoveTest);
        System.out.println("Expected Value: 0001001000001010");
        System.out.println("Move Command:   " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(MoveNegTest);
        System.out.println("Expected Value:        0001111111111111");
        System.out.println("Move Negative Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(InterruptMemTest);
        System.out.println("Expected Value:       0010000000000000");
        System.out.println("InterruptMem Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(InterruptRegTest);
        System.out.println("Expected Value:       0010000000000001");
        System.out.println("InterruptReg Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(ANDTest);
        System.out.println("Expected Value: 1000010011000000");
        System.out.println("AND Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(ORTest);
        System.out.println("Expected Value: 1001010100110000");
        System.out.println("OR Command:     " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(XORTest);
        System.out.println("Expected Value: 1010001101100000");
        System.out.println("XOR Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(NOTTest);
        System.out.println("Expected Value: 1011100001110000");
        System.out.println("NOT Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(leftShiftTest);
        System.out.println("Expected Value:    1100001101100000");
        System.out.println("LeftShift Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(rightShiftTest);
        System.out.println("Expected Value:     1101110011100000");
        System.out.println("RightShift Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(addTest);
        System.out.println("Expected Value: 1110111100100000");
        System.out.println("Add Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(subTest);
        System.out.println("Expected Value:   1111110001100000");
        System.out.println("Subtract Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(multTest);
        System.out.println("Expected Value:   0111001000100000");
        System.out.println("Multiply Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(BranchLessThan);
        System.out.println("Expected Value:   0101001000000000");
        System.out.println("BranchLessThan Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(BranchGreaterThan);
        System.out.println("Expected Value:   0101010000000000");
        System.out.println("BranchGreaterThan Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(BranchLessThanOrEqual);
        System.out.println("Expected Value:   0101101000000000");
        System.out.println("BranchLessThanOrEqual Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(BranchGreaterThanOrEqual);
        System.out.println("Expected Value:   0101110000000000");
        System.out.println("BranchGreaterThanOrEqual Command: " + Command);
        System.out.println("");
    }
}

