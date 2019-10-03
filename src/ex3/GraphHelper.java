package ex3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphHelper {

    public int[][] ajMatrix = new int[][]{
            {0,1,1,1,1,0},
            {1,0,0,0,1,0},
            {1,0,0,0,1,1},
            {1,0,0,0,0,1},
            {1,1,1,0,0,1},
            {0,0,1,1,1,0}
    };

    public List[] table2matrix(int[][] graph, int n) {
        List<Integer>[] v = new List[n];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0 ; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    if (v[i] == null) {
                        v[i] = new ArrayList();
                    }
                    v[i].add(j);
                }
            }
        }

        return v;
    }

    public int[][] table2inmatrix(List<Integer>[] graph, int n, int m) {
        int[][] res = new int[n][m];
        int index = 0;
        Set<String> edgeSet = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int v = graph[i].get(j);
                String edge = i + "" + v;
                if (!edgeSet.contains(edge)) {
                    res[i][index] = 1;
                    res[v][index] = 1;
                    index++;
                    edgeSet.add(edge);
                    edgeSet.add(v + "" + i);
                }
            }
        }

        return res;
    }

    public List<Integer>[] inmatrix2table(int[][] matrix, int n, int m) {
        List<Integer>[] res = new ArrayList[n];
        int cnt = 0;
        List<Integer> edge = new ArrayList<>();

        for (int i = 0; i < m; i++) { //i:edge
            for (int j = 0; j < n; j++) {//j: vertex
                if (matrix[j][i] == 1) {
                    cnt++;
                    if (res[j] == null) {
                        res[j] = new ArrayList<>();
                    }

                    edge.add(j);
                }

                if (cnt == 2) {
                    res[edge.get(0)].add(edge.get(1));
                    res[edge.get(1)].add(edge.get(0));
                    cnt = 0;
                    edge.clear();
                }
            }
        }

        return res;
    }
}
