package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.siegmar.fastcsv.writer.CsvWriter;

public class CsvUtils {

    public static final String EXPORT_CSV_PATH = "./set.csv";


    public static void print(List<List<String >> data) {
        File file = new File(EXPORT_CSV_PATH);
        CsvWriter csvWriter = new CsvWriter();

        try {
            Collection<String[]> result = new ArrayList<>();

            for (List<String> line : data) {
                result.add(new String[]{line.get(0), line.get(1)});
            }

            csvWriter.write(file, StandardCharsets.UTF_8, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
