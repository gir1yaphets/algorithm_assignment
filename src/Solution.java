import java.util.Arrays;
import java.util.List;

import ex1.BaseSet;
import ex2.BaseSortingHelper;
import ex3.GraphHelper;
import ex4.GraphTraversal;
import utils.FileUtils;

import static ex1.BaseSet.SetType.HASH_TABLE_SET;
import static ex1.BaseSet.SetType.LINKED_LIST_SET;
import static ex2.BaseSortingHelper.SortType.HEAP_SORT;
import static ex2.BaseSortingHelper.SortType.SELECTION_SORT;
import static utils.FileUtils.FILE_PATH_1;
import static utils.FileUtils.FILE_PATH_2;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.executeEx2();
    }

    private void executeEx1() {
        String[] content = FileUtils.parseFile(FILE_PATH_1);
        String[] words = FileUtils.parseFile(FILE_PATH_2);

        for (int i = LINKED_LIST_SET.value(); i <= HASH_TABLE_SET.value(); i++) {
            BaseSet set = BaseSet.newInstance(BaseSet.SetType.valueOf(i));
            int size = set.insert(content);
            int miss = set.query(words);

            System.out.println("Total size in " + BaseSet.SetType.valueOf(i).name() + " is " + size);
            System.out.println("Missing number in " + BaseSet.SetType.valueOf(i).name() + " is " + miss + "\n");
        }
    }

    private void executeEx2() {
        String[] words = FileUtils.parseFile(FILE_PATH_1);

        for (int i = HEAP_SORT.value(); i <= SELECTION_SORT.value(); i++) {
            BaseSortingHelper sortHelper = BaseSortingHelper.newInstance(BaseSortingHelper.SortType.valueOf(i));

            //use a new array to sort
            String[] wordsForSort = Arrays.copyOf(words, words.length);

            long startTime = System.currentTimeMillis();
            sortHelper.sort(wordsForSort);
            long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;

            System.out.println("The duration of " + BaseSortingHelper.SortType.valueOf(i).name() + " is " + duration);
        }

    }

    private void executeEx3() {
        GraphHelper graphHelper = new GraphHelper();
        List<Integer>[] table = graphHelper.matrix2table(graphHelper.ajMatrix);
        int[][] res = graphHelper.table2inmatrix(table);
        List<Integer>[] tableRes = graphHelper.inmatrix2table(res);
    }

    private void executeEx4() {
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.dfs();
        graphTraversal.bfs();
    }
}
