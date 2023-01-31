package reader;

import entity.ParameterList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleReader {

    public static final Logger rootLogger = LogManager.getRootLogger();

    private static final String IN_ASCENDING_PARAMETER = "-a";
    private static final String IN_DESCENDING_PARAMETER = "-d";
    private static final String STRING_SORTING = "-s";
    private static final String INTEGER_SORTING = "-i";
    private static final String TXT_FILE_FORMAT = ".txt";
    private static final String IS_PARAMETER = "-";
    private static final String GAP = " ";
    private static final int OUTPUT_FILE_INDEX = 0;

    public static ParameterList readFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ParameterList parameterList = new ParameterList();

        try {
            String[] strings = br.readLine().split(GAP);
            List<String> params = Arrays.stream(strings).filter(s -> s.startsWith(IS_PARAMETER)).toList();
            List<String> inFileNames = Arrays.stream(strings).filter(s -> s.endsWith(TXT_FILE_FORMAT)).toList();
            String outFileName = inFileNames.get(OUTPUT_FILE_INDEX);
            List<String> mutableInFileNames = new ArrayList<>(inFileNames);
            mutableInFileNames.remove(outFileName);

            parameterList.setOutFileName(outFileName);
            parameterList.setInFileNames(mutableInFileNames);

            for (String param : params) {

                switch (param) {

                    case (IN_ASCENDING_PARAMETER): {
                        parameterList.setAscending(true);
                        break;
                    }

                    case (IN_DESCENDING_PARAMETER): {
                        parameterList.setAscending(false);
                        break;
                    }

                    case (STRING_SORTING): {
                        parameterList.setInteger(false);
                        break;
                    }

                    case (INTEGER_SORTING): {
                        parameterList.setInteger(true);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            rootLogger.log(Level.ERROR, "IOException");
        }

        return parameterList;

    }

}
