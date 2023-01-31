package service;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    public static Service service = Service.getInstance();

    @Test
    void sortData() {

    }

    @Test
    void sortInteger() {
        List<Integer> actualList = new ArrayList<>(List.of(1, 14, 2, 155, 43));
        List<Integer> correctList = List.of(1, 2, 14, 43, 155);
        actualList = service.sortIntegerInAscending(actualList);
        Assertions.assertEquals(correctList, actualList);
    }

    @Test
    void mergeToOneList() {
        List<List<String>> listList = new ArrayList<>();

        List<String> firstList = new ArrayList<>(List.of("2", "-1", "66"));
        List<String> secondList = new ArrayList<>(List.of("10", "55", "66", "3"));

        listList.add(firstList);
        listList.add(secondList);

        List<String> correctList = service.mergeToOneList(listList);

        List<String> actualList = List.of("2", "-1", "66", "10", "55", "66", "3");

        assertEquals(correctList, actualList);
    }
}