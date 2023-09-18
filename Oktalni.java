import java.util.Scanner;

public class Oktalni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(convert(sc.nextLine()));
        sc.close();
    }

    static String[] octal = new String[] {"000", "001", "010", "011", "100", "101", "110", "111"};

    static String convert(String binary) {
        StringBuilder sb = new StringBuilder();
        if (binary.length() % 3 == 2) binary = "0" + binary;
        else if (binary.length() % 3 == 1) binary = "00" + binary;
        for (int i = 0; i<binary.length(); i+=3) {
            sb.append(getOctal(binary.substring(i,i+3)));

        }
        return sb.toString();
    }

    static int getOctal(String s) {
        for (int i = 0; i<8; i++) {
            if (octal[i].equals(s)) return i;
        }
        return 0;
    }
}