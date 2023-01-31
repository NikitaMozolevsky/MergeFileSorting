package main;

import entity.ResultOfSorting;
import reader.ConsoleReader;
import entity.ParameterList;
import reader.ReadDataFromFileList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Service;

import java.util.List;

public class Starter {

    public static final Logger logger = LogManager.getLogger();

    public static Service service = Service.getInstance();

    public static void main(String[] args) {

        logger.log(Level.INFO, "Start");

        //получение объекта параметров, с которыми нужно работать
        ParameterList parameterList = ConsoleReader.readFromConsole();

        //получение списка имен файлов для обработки
        List<String> inFileNames = parameterList.getInFileNames();

        //получение листа внутри которого листы с полученными данными
        List<List<String>> listFromListsInWhichData = ReadDataFromFileList.getDataFromFileList(inFileNames);

        //преобразование листов в данными в один неотсортированный лист с данными
        List<String> listWithAllData = service.mergeToOneList(listFromListsInWhichData);



        /*List<List<String>> filesDataStream = inFileNames
                .stream().map(ReadDataFromFile::getDataFromAllInFiles)
                .toList();*/

        ResultOfSorting resultList = service.sortData(parameterList.isInteger(), parameterList.isAscending(), listWithAllData);

    }

}
