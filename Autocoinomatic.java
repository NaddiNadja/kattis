import java.util.*;

public class Autocoinomatic {
  static int n, m;
  static ArrayList<Integer> coins = new ArrayList<Integer>();
  static Set<Integer> coinset = new HashSet<Integer>();

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    n = io.getInt();
    m = io.getInt();
    for (int i = 0; i < n; i++) {
      int x = io.getInt();
      coins.add(x);
      coinset.add(x);
    }
    Collections.sort(coins);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      String c = io.getWord();
      int d = io.getInt();
      if (c.equals("Q")) {
        Pair res = solve(d);
        sb.append(res.length);
        sb.append("\n");
      } else {
        coinset.remove(d);
      }
    }

    System.out.println(sb.toString().trim());
    io.close();
  }

  static Map<Integer, Pair> opt = new HashMap<Integer, Pair>();

  public static int bisearch(int x) {
    int lo = 0, hi = coins.size();
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (coins.get(mid) < x) lo = mid + 1;
      else hi = mid;
    }
    return lo;
  }

  public static Pair solve(int i) {
    if (i == 0) {
      return new Pair(0, new ArrayList<Integer>());
    }
    if (opt.containsKey(i)) {
      var dsbahj = opt.get(i);
      if (dsbahj.length != -1) return dsbahj;
      if (dsbahj.coins.stream().allMatch(coinset::contains)) return dsbahj;
      else opt.remove(i);
    }
    if (coinset.contains(i)) {
      Pair p = new Pair(1, new ArrayList<Integer>(List.of(i)));
      opt.put(i, p);
      return p;
    }

    int hi = bisearch(i);
    if (hi == 0) {
      Pair p = new Pair(-1, new ArrayList<Integer>());
      opt.put(i, p);
      return p;
    }

    for (int j = hi-1; j >= 0; j--) {
      if (!coinset.contains(coins.get(j))) continue;
      int next = i - coins.get(j);
      Pair res = solve(next);
      if (res.length != -1) {
        res.length++;
        res.coins.add(coins.get(j));
        opt.put(i, res);
        return new Pair(res.length, res.coins);
      }
    }

    Pair p = new Pair(-1, new ArrayList<Integer>());
    opt.put(i, p);
    return p;
  }

  public static class Pair {
    int length;
    ArrayList<Integer> coins;

    public Pair(int first, ArrayList<Integer> second) {
      this.length = first;
      this.coins = second;
    }
  }
}