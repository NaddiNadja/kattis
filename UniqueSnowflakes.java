import java.util.HashMap;

public class UniqueSnowflakes {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        StringBuilder sb = new StringBuilder();
        int t = io.getInt();
        for (int i = 0; i<t; i++) {
            int n = io.getInt();
            HashMap<Long, Integer> hm = new HashMap<>();
            int maxSize = 0;
            int size = 0;
            int currentIndex = 0;
            for (int j = 0; j<n; j++) {
                long snowflake = io.getLong();
                Integer oldValue = hm.put(snowflake, j);
                if (oldValue == null || oldValue < currentIndex) {
                    size++;
                } else {
                    if (size > maxSize) maxSize = size;
                    size -= oldValue-currentIndex;
                    currentIndex = oldValue+1;
                }
            }
            if (size > maxSize) maxSize = size;
            sb.append(maxSize);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/*

1 10
1
2
3
4
3
2
10
11
4
12

*/