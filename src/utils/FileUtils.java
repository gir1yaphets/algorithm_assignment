package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileUtils {
    private static final String PATTERN = "[a-zA-Z0-9]+";
    public static final String FILE_PATH_1 = "./pride-and-prejudice.txt";
    public static final String FILE_PATH_2 = "./words-shuffled.txt";

    public static String readFile(String path) {
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

    public static String[] parseFile(String path) {
        String content = readFile(path);
        String[] words = content.replaceAll("\\s+", " ").split(" ");
        return words;
    }
}
