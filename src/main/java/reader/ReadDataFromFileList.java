package reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFileList {

    public static final Logger logger = LogManager.getLogger();

    public static final String PATH_TO_FILE = "src/main/resources/txt/";

    public static List<List<String>> getDataFromFileList(List<String> inFileNames) {

        List<List<String>> resultListWithAllData = new ArrayList<>();

        for (String inFileName : inFileNames) {

            List<String> dataFromFile = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_FILE + inFileName))) {

                String line = br.readLine();
                while (line != null) {
                    dataFromFile.add(line);
                    line = br.readLine();
                }

            } catch (FileNotFoundException e) {
                logger.log(Level.ERROR, "No such file, try read the next");
            } catch (IOException e) {
                logger.log(Level.ERROR, "IOException");
                break;
            }

            resultListWithAllData.add(dataFromFile);

        }

        return resultListWithAllData;
    }

}
