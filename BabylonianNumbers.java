import java.util.Scanner;

public class BabylonianNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i<n; i++) {
            String in = sc.nextLine();
            double res = 0;
            int pow = 0;
            if (in.charAt(in.length()-1) == ',') in += ".";
            String[] nums = in.split(",");
            for (int j = nums.length-1; j>=0; j--) {
                if (!nums[j].equals("") && !nums[j].equals(".")) {
                    res += Integer.parseInt(nums[j]) * Math.pow(60, pow);
                }
                pow++;
            }
            long ires = (long) res;
            sb.append(ires);
            if (i != n-1) sb.append("\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }
}

