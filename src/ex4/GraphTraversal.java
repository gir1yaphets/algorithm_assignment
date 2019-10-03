package ex4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {
    public List<Integer>[] table1 = new ArrayList[10];

    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("A", 0);
        map.put("B", 1);
        map.put("C", 2);
        map.put("D", 3);
        map.put("E", 4);
        map.put("F", 5);
        map.put("G", 6);
        map.put("H", 7);
        map.put("I", 8);
        map.put("J", 9);
    }

    public GraphTraversal() {
        init();
    }

    public void init() {
        for (int i = 0; i < table1.length; i++) {
            if (table1[i] == null) {
                table1[i] = new ArrayList<>();
            }

            switch (i) {
                //A
                case 0:
                    table1[i].add(map.get("D"));
                    table1[i].add(map.get("B"));
                    table1[i].add(map.get("I"));
                    break;
                //B
                case 1:
                    table1[i].add(map.get("A"));
                    table1[i].add(map.get("C"));
                    table1[i].add(map.get("D"));
                    table1[i].add(map.get("E"));
                    break;
                //C
                case 2:
                    table1[i].add(map.get("B"));
                    table1[i].add(map.get("E"));
                    table1[i].add(map.get("F"));
                    break;
                //D
                case 3:
                    table1[i].add(map.get("A"));
                    table1[i].add(map.get("B"));
                    table1[i].add(map.get("E"));
                    table1[i].add(map.get("G"));
                    break;
                //E
                case 4:
                    table1[i].add(map.get("B"));
                    table1[i].add(map.get("C"));
                    table1[i].add(map.get("D"));
                    table1[i].add(map.get("F"));
                    table1[i].add(map.get("G"));
                    table1[i].add(map.get("H"));
                    break;
                //F
                case 5:
                    table1[i].add(map.get("C"));
                    table1[i].add(map.get("E"));
                    table1[i].add(map.get("H"));
                    break;
                //G
                case 6:
                    table1[i].add(map.get("D"));
                    table1[i].add(map.get("E"));
                    table1[i].add(map.get("H"));
                    table1[i].add(map.get("I"));
                    table1[i].add(map.get("J"));
                    break;
                //H
                case 7:
                    table1[i].add(map.get("E"));
                    table1[i].add(map.get("F"));
                    table1[i].add(map.get("G"));
                    table1[i].add(map.get("J"));
                    break;
                //I
                case 8:
                    table1[i].add(map.get("A"));
                    table1[i].add(map.get("G"));
                    table1[i].add(map.get("J"));
                    break;
                //J
                case 9:
                    table1[i].add(map.get("G"));
                    table1[i].add(map.get("H"));
                    table1[i].add(map.get("I"));
                    break;
                default:
                    break;

            }
        }
    }

    public void bfs() {
        System.out.println("BFS");
        int root = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();
        queue.offer(root);
        System.out.println((char)(root + 'A'));
        dist.put(root, 0);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            int d = dist.get(v) + 1;

            table1[v].sort(Comparator.naturalOrder());
            for (int nb : table1[v]) {
                if (!dist.containsKey(nb)) {
                    queue.offer(nb);
                    System.out.println((char)(nb + 'A'));
                    dist.put(nb, d);
                }
            }
        }
    }

    public void dfs() {
        System.out.println("DFS");
        int root = 0;
        Set<Integer> visited = new HashSet<>();

        visited.add(root);
        dfsHelper(root, visited);
    }

    private void dfsHelper(int v, Set<Integer> visited) {
        System.out.println((char)(v + 'A'));

        table1[v].sort(Comparator.naturalOrder());
        for (int nb : table1[v]) {
            if (!visited.contains(nb)) {
                visited.add(nb);
                dfsHelper(nb, visited);
            }
        }
    }
}
