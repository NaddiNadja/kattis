public class Homework {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String[] inp = io.getWord().split(";");
        int total = 0;
        for (String s : inp) {
            String[] range = s.split("-");
            total++;
            if (range.length == 2)  total += Integer.parseInt(range[1])-Integer.parseInt(range[0]);
        }
        System.out.println(total);
    }
}
