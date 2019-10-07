import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import ex1.BinaryTreeSet;
import ex1.HashTableSet;
import ex1.LinkedListSet;
import ex2.BaseSortingHelper;
import ex3.GraphHelper;
import ex4.GraphTraversal;

import static ex2.BaseSortingHelper.SortType.HEAP_SORT;
import static ex2.BaseSortingHelper.SortType.SELECTION_SORT;

public class Solution {

    private static final String PATTERN = "[a-zA-Z0-9]+";
    private static final String FILE_PATH_1 = "/Users/pengxiaolve/Documents/02_UCI/Courses/quater_1/241P/exercise" +
            "/pride-and-prejudice.txt";
    private static final String FILE_PATH_2 = "/Users/pengxiaolve/Documents/02_UCI/Courses/quater_1/241P/exercise" +
            "/words-shuffled.txt";

    private LinkedListSet linkedListSet;
    private BinaryTreeSet binaryTreeSet;
    private HashTableSet hashTableSet;

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.executeEx1();
        solution.executeEx2();
    }

    enum SetType {
        LINKED_LIST_SET,
        BINARY_TREE_SET,
        HASH_TABLE_SET
    }

    private String[] parseFile(String path) {
        String content = readFile(path);
        String[] words = content.replaceAll("\\s+", " ").split(" ");
        return words;
    }

    private void executeEx1() {
        String[] content = parseFile(FILE_PATH_1);
        String[] words = parseFile(FILE_PATH_2);

        int linkedSize = insert(content, SetType.LINKED_LIST_SET);
        int linkedMiss = query(words, SetType.LINKED_LIST_SET);

        int treeSize = insert(content, SetType.BINARY_TREE_SET);
        int treeMiss = query(words, SetType.BINARY_TREE_SET);

        int hashSize = insert(content, SetType.HASH_TABLE_SET);
        int hashMiss = query(words, SetType.HASH_TABLE_SET);

        System.out.println("linkedSize = " + linkedSize + " linkedMiss = " + linkedMiss + " treeSize = " + treeSize
                + " treeMiss = " + treeMiss + " hashSize = " + hashSize + " hashMiss = " + hashMiss);
    }

    private void executeEx2() {
        String[] words = parseFile(FILE_PATH_1);

        for (int i = HEAP_SORT.value(); i <= SELECTION_SORT.value(); i++ ) {
//            if (i == 1) {
                BaseSortingHelper sortHelper = BaseSortingHelper.newInstance(BaseSortingHelper.SortType.valueOf(i));

                long startTime = System.currentTimeMillis();
                sortHelper.sort(words);
                long endTime = System.currentTimeMillis();

                long duration = endTime - startTime;

                System.out.println("The duration of " + BaseSortingHelper.SortType.valueOf(i).name() + " is " + duration);

//            }
        }

    }

    private void executeEx3() {
        GraphHelper graphHelper = new GraphHelper();
        List<Integer>[] table = graphHelper.table2matrix(graphHelper.ajMatrix, 6);
        int[][] res = graphHelper.table2inmatrix(table, 6, 9);
        List<Integer>[] tableRes = graphHelper.inmatrix2table(res, 6, 9);
    }

    private void executeEx4() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.dfs();
        graphTraversal.bfs();
    }

    private int insert(String[] words, SetType type) {
        int size = 0;
        long start, end = 0;
        switch (type) {
            case LINKED_LIST_SET:
                linkedListSet = new LinkedListSet();
                for (String word : words) {
                    start = System.currentTimeMillis();
                    linkedListSet.add(word);
                    end = System.currentTimeMillis();
                    System.out.println(end - start);
                }
                size = linkedListSet.size();
                break;
            case BINARY_TREE_SET:
                binaryTreeSet = new BinaryTreeSet();
                for (String word : words) {
                    start = System.currentTimeMillis();
                    binaryTreeSet.add(word);
                    end = System.currentTimeMillis();
                    System.out.println(end - start);
                }
                size = binaryTreeSet.size();
                break;
            case HASH_TABLE_SET:
                hashTableSet = new HashTableSet();
                for (String word : words) {
                    start = System.currentTimeMillis();
                    hashTableSet.add(word);
                    end = System.currentTimeMillis();
                    System.out.println(end - start);
                }
                size = hashTableSet.size();
                break;
            default:
                break;
        }

        return size;
    }

    private int query(String[] words, SetType type) {
        int count = 0;

        switch (type) {
            case LINKED_LIST_SET:
                for (String word : words) {
                    if (!linkedListSet.contains(word)) {
                        count++;
                    }
                }
                break;
            case BINARY_TREE_SET:
                for (String word : words) {
                    if (!binaryTreeSet.contains(word)) {
                        count++;
                    }
                }
                break;
            case HASH_TABLE_SET:
                for (String word : words) {
                    if (!hashTableSet.contains(word)) {
                        count++;
                    }
                }
                break;
            default:
                break;
        }

        return count;
    }

    private String readFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);
        Reader reader;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (!((char) tempchar + "").matches(PATTERN)) {
                    tempchar = ' ';
                }

                stringBuilder.append((char) tempchar);

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
