/**
 * Testing class. Without testing, there is no way to know if code is actually working properly in all cases
 * @author dnaja
 *
 */
public class memory_test {

    /**
     *  This method runs the methods created for testing HumbleMemory.
     */
    public static void runMemTests(){
        HumbleLongWord address = new HumbleLongWord();
        HumbleLongWord value = new HumbleLongWord();
        HumbleMemory computermem = new HumbleMemory();

        address.set(1);
        value.set(15);
        computermem.write(address, value);
        System.out.println("Address 1");
        System.out.println("Expected Value 00000000000000000000000000001111");
        System.out.println(computermem.read(address));
        System.out.println(" ");

        address.set(1);
        value.set(2526);
        computermem.write(address, value);
        System.out.println("Address 1");
        System.out.println("Expected Value 00000000000000000000100111011110");
        System.out.println(computermem.read(address));
        address.set(240);
        System.out.println("Address 240");
        System.out.println("Expected Value 00000000000000000000000000000000");
        System.out.println(computermem.read(address));
        System.out.println(" ");

        address.set(26);
        value.set(99999);
        computermem.write(address, value);
        System.out.println("Address 26");
        System.out.println("Expected Value 00000000000000011000011010011111");
        System.out.println(computermem.read(address));
        address.set(1);
        System.out.println("Address 1");
        System.out.println("Expected Value 00000000000000000000100111011110");
        System.out.println(computermem.read(address));
        address.set(26);
        System.out.println("Address 26");
        System.out.println("Expected Value 00000000000000011000011010011111");
        System.out.println(computermem.read(address));
        address.set(240);
        System.out.println("Address 240");
        System.out.println("Expected Value 00000000000000000000000000000000");
        System.out.println(computermem.read(address));
        System.out.println(" ");

        address.set(12);
        value.set(16);
        computermem.write(address, value);
        System.out.println("Address 12");
        System.out.println("Expected Value 00000000000000000000000000010000");
        System.out.println(computermem.read(address));
        address.set(13);
        value.set(777777);
        computermem.write(address, value);
        System.out.println("Address 13");
        System.out.println("Expected Value 00000000000010111101111000110001");
        System.out.println(computermem.read(address));
        address.set(14);
        value.set(4241131);
        computermem.write(address, value);
        System.out.println("Address 14");
        System.out.println("Expected Value 00000000010000001011011011101011");
        System.out.println(computermem.read(address));
        address.set(15);
        value.set(1);
        computermem.write(address, value);
        System.out.println("Address 15");
        System.out.println("Expected Value 00000000000000000000000000000001");
        System.out.println(computermem.read(address));
        address.set(16);
        System.out.println("Address 16");
        System.out.println("Expected Value 00000000000000000000000000000000");
        System.out.println(computermem.read(address));
        System.out.println(" ");

    }

}
