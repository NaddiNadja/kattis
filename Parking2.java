public class Parking2 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int a = io.getInt();
        int b = io.getInt();
        int c = io.getInt();
        int[] parking = new int[101];
        for (int i = 0; i<3; i++) {
            int x = io.getInt();
            int y = io.getInt();
            for (int j = x; j<y; j++) {
                parking[j]++;
            }
        }
        int price = 0;
        for (int i = 0; i<101; i++) {
            if (parking[i] == 3) price+=3*c;
            else if (parking[i] == 2) price+=2*b;
            else if (parking[i] == 1) price+=a;
        }
        System.out.println(price);
    }
}
