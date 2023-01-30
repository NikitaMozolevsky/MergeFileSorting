package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataSorter {

    public static List<String> dataSorter(boolean isInteger, boolean inAscending, List<String>... lists) {

        List<String> resultList = new ArrayList<>();

        // TODO: 1/30/2023 May be incorrect!!!
        List<String> stringList = Arrays.stream(lists).flatMap(Collection::stream).toList();

        for (List<String> list : lists) {
            for (String s : list) {
                if (inAscending && isInteger) {

                }
            }
        }

        return resultList;

    }

}
