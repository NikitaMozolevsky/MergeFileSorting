package service;

import entity.ResultOfSorting;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public static final Logger logger = LogManager.getLogger();

    public static Service service = new Service();

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public ResultOfSorting sortData(boolean isInteger, boolean inAscending, List<String> listWithAllData) {

        ResultOfSorting resultOfSorting = new ResultOfSorting();
        List<String> resultList = new ArrayList<>();
        List<String> incorrectData = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        // TODO: 1/30/2023 May be incorrect!!!
        /*List<String> stringList = Arrays.stream(lists).flatMap(Collection::stream).toList();*/


        if (isInteger && inAscending) {

            for (String string : listWithAllData) {
                try {
                    int integer = Integer.parseInt(string);
                    integerList.add(integer);

                } catch (NumberFormatException e) {
                    logger.log(Level.INFO, e);
                    incorrectData.add(string);
                }

            }

            resultList = sortIntegerInAscending(integerList).stream().map(String::valueOf).collect(Collectors.toList());

            resultOfSorting.setStringResult(resultList);
            resultOfSorting.setIncorrectData(incorrectData);

            return resultOfSorting;

        }

        if (isInteger) {

            for (String string : listWithAllData) {
                try {
                    int integer = Integer.parseInt(string);
                    integerList.add(integer);

                } catch (NumberFormatException e) {
                    logger.log(Level.INFO, e);
                    incorrectData.add(string);
                }

            }

            resultList = sortIntegerInDescending(integerList).stream().map(String::valueOf).collect(Collectors.toList());

            resultOfSorting.setStringResult(resultList);
            resultOfSorting.setIncorrectData(incorrectData);

            return resultOfSorting;

        }

        return new ResultOfSorting();

    }

    public List<Integer> sortIntegerInAscending(List<Integer> integerList) {

        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < integerList.size() - j; i++) {
                if (integerList.get(i) > integerList.get(i + 1)) {
                    tmp = integerList.get(i);
                    integerList.set(i, integerList.get(i + 1));
                    integerList.set(i + 1, tmp);
                    swapped = true;
                }
            }
        }

        return integerList;

    }

    public List<Integer> sortIntegerInDescending(List<Integer> integerList) {

        integerList = sortIntegerInAscending(integerList);

        for (int i = 0, j = integerList.size() - 1, tmp; i < j; i++, j--) {
            tmp = integerList.get(i);
            integerList.set(i, integerList.get(j));
            integerList.set(j, tmp);
        }

        return integerList;
    }

    public List<String> mergeToOneList(List<List<String>> listList) {

        return listList.stream().flatMap(List::stream).collect(Collectors.toList());

    }

}
