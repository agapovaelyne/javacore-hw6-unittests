package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static ru.netology.Main.listToJson;

public class listToJsonTest {

    @ParameterizedTest
    @EmptySource
    public void emptyListResult_success(List<Employee> list) {
        String expected = "[]";
        String actual = listToJson(list);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void nullArgsResult_success(List<Employee> list) {
        String actual = listToJson(list);
        String expectedEmpty = "[]";

        if (list == null) {
            Assertions.assertNull(actual);
        } else {
            Assertions.assertEquals(expectedEmpty, actual);
        }
    }

}
