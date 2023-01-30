package file_reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFile {

    public static final Logger logger = LogManager.getLogger();

    public static final String PATH_TO_FILE = "src/main/resources/txt/";

    public static List<String> fileForDataSorting(String fileName) {

        List<String> dataForSorting = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_FILE + fileName))) {

            String line = br.readLine();
            while (line != null) {
                dataForSorting.add(line);
                line = br.readLine();
            }

            logger.log(Level.INFO, dataForSorting);
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "No such file");
        } catch (IOException e) {
            logger.log(Level.ERROR, "IOException");
        }

        return dataForSorting;
    }

}
