import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import ex1.BinaryTreeSet;
import ex1.HashTableSet;
import ex1.LinkedListSet;
import ex3.GraphHelper;
import ex4.GraphTraversal;

public class Solution {

    private static final String PATTERN = "[\\sa-zA-Z0-9_.-]+";
    private static final String FILE_PATH_1 = "/Users/pengxiaolve/Documents/02_UCI/Courses/quater_1/241P/exercise/pride-and-prejudice.txt";
    private static final String FILE_PATH_2 = "/Users/pengxiaolve/Documents/02_UCI/Courses/quater_1/241P/exercise/words-shuffled.txt";

    private LinkedListSet linkedListSet;
    private BinaryTreeSet binaryTreeSet;
    private HashTableSet hashTableSet;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.executeEx1();
    }

    enum SetType {
        LINKED_LIST_SET,
        BINARY_TREE_SET,
        HASH_TABLE_SET
    }

    private void executeEx1() {
        String content = readFile1();

        int linkedSize = insert(content, SetType.LINKED_LIST_SET);
        int linkedMiss = query(SetType.LINKED_LIST_SET);

        System.out.println("linkedSize = " + linkedSize + " linkedMiss = " + linkedMiss);

//        int treeSize = insert(content, SetType.BINARY_TREE_SET);
//        int treeMiss = query(SetType.BINARY_TREE_SET);
//
//        int hashSize = insert(content, SetType.HASH_TABLE_SET);
//        int hashMiss = query(SetType.HASH_TABLE_SET);
//
//        System.out.println("linkedSize = " + linkedSize + " linkedMiss = " + linkedMiss + " treeSize = " + treeSize + " treeMiss = " + treeMiss + " hashSize = " + hashSize + " hashMiss = " + hashMiss);
    }

    private void executeEx2() {

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

    private int insert(String content, SetType type) {
        String after = content.replaceAll("\\s+", " ");

        String[] words = after.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        int size = 0;
        switch (type) {
            case LINKED_LIST_SET:
                linkedListSet = new LinkedListSet();
                for (String word : words) {
                    linkedListSet.add(word);
                }
                size = linkedListSet.size();
                break;
            case BINARY_TREE_SET:
                binaryTreeSet = new BinaryTreeSet();
                for (String word : words) {
                    binaryTreeSet.add(word);
                }
                size = binaryTreeSet.size();
                break;
            case HASH_TABLE_SET:
                hashTableSet = new HashTableSet();
                for (String word : words) {
                    hashTableSet.add(word);
                }
                size = hashTableSet.size();
                break;
            default:
                break;
        }

        return size;
    }

    private int query(SetType type) {
        String content = readFile2();
        String[] words = content.split(" ");

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

    private String readFile2() {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_PATH_2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (fileReader == null) {
            return "";
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        try {
            line = bufferedReader.readLine();
            stringBuilder.append(line);
            stringBuilder.append(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
            try {
                line = bufferedReader.readLine();
                stringBuilder.append(line);
                stringBuilder.append(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private String readFile1() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(FILE_PATH_1);
        Reader reader;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r'
                        && ((char)tempchar + "").matches(PATTERN)) {
                    switch ((char)tempchar) {
                        case '\n':
                        case '.':
                        case '-':
                            tempchar = ' ';
                            break;
                    }
                    stringBuilder.append((char)tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
