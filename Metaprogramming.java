import java.util.Scanner;
import java.util.HashMap;

public class Metaprogramming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();
        while(sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            if (input.length == 3) {
                hm.put(input[2], Integer.parseInt(input[1]));
            } else {
                if (!hm.containsKey(input[1]) || !hm.containsKey(input[3])) 
                    System.out.println("undefined");
                else {
                    int in1 = hm.get(input[1]);
                    int in2 = hm.get(input[3]);
                    if (input[2].charAt(0) == '<')
                        System.out.println(in1 < in2);
                    else if (input[2].charAt(0) == '>')
                        System.out.println(in1 > in2);
                    else
                        System.out.println(in1 == in2);
                }
            }
        }
        sc.close();
    }
}
