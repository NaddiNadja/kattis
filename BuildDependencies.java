
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BuildDependencies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        DiGraph isDependent = new DiGraph(n);
        DiGraph notDependent = new DiGraph(n);
        HashMap<String, Integer> files = new HashMap<>();
        Pair[] filesArr = new Pair[n];

        for (int i = 0; i<n; i++) {
            String[] input = sc.nextLine().split(":");
            String[] dependencies = input[i].trim().split(" ");
            filesArr[i] = new Pair(input[0], dependencies);
            files.put(input[0], i);
        }

        for (int i = 0; i<n; i++) {
            for (String s : filesArr[i].dependencies) {
                isDependent.addDependency(i, files.get(s));
                notDependent.addDependency(files.get(s), i);
            }
        }

        String c = sc.nextLine();
        int pos = files.get(c);

        StringBuilder sb = new StringBuilder();

    }

    private static StringBuilder sb;

    private static void addDependencies(String[] dependencies) {
        for (String s : dependencies) {
            sb.append(s).append("\n");
        }
    }

    private static class Pair {
        String f;
        String[] dependencies;
        public Pair(String f, String[] d) {
            this.f = f;
            this.dependencies = d;
        }
    }

    private static class DiGraph {
        int size;
        List<Integer>[] adj;

        public DiGraph(int V) {
            this.size = V;
            adj = new List[V];
            for (int i = 0; i<V; i++)
                adj[i] = new ArrayList<>();
        }

        public void addDependency(int i, int j) {
            adj[i].add(j);
        }

        public List<Integer> getDependencies(int i) {
            return adj[i];
        }
    }
}
