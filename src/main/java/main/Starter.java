package main;

import console_reader.ConsoleReader;
import entity.ParameterList;
import file_reader.ReadDataFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Starter {

    public static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.log(Level.INFO, "Start");

        ParameterList parameterList = ConsoleReader.readFromConsole();

        logger.log(Level.INFO, parameterList);

        List<String> inFileNames = parameterList.getInFileNames();

        String firstInFileName = inFileNames.get(0);

        List<String> fileData = ReadDataFromFile.fileForDataSorting(firstInFileName);

    }

}
