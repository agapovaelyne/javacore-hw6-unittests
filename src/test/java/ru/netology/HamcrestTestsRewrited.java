package ru.netology;

import com.opencsv.exceptions.CsvValidationException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.netology.Main.listToJson;
import static ru.netology.Main.parseCSV;

public class HamcrestTestsRewrited {

    @Test
    public void parseCSVEmptyResult_HamcrestRewrited_test() throws CsvValidationException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "src/test/sourses/dataEmpty.csv";
        List<Employee> result = parseCSV(columnMapping, fileName);
        assertThat(result, empty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/src/test/sourses/dataNotExist.csv", "src/test/sourses/dataInvalid.csv"})
    public void parseBadCSV_HamcrestRewrited_success(String fileName) throws CsvValidationException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        assertThat(parseCSV(columnMapping, fileName),equalTo(null));
    }

    @Test
    public void badMappingParseCSV_HamcrestRewrited_success() throws CsvValidationException {
        String[] columnMapping = {"ad", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> result = parseCSV(columnMapping, fileName);

        assertThat(result.size(), greaterThan(0));
        assertThat(result.get(0), hasProperty("id"));
    }

    @ParameterizedTest
    @EmptySource
    public void emptyListResult_HamcrestRewrited_success(List<Employee> list) {
        String expected = "[]";
        String actual = listToJson(list);
        assertThat(expected, Matchers.equalTo(actual));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void nullArgsResult_HamcrestRewrited_success(List<Employee> list) {
        String actual = listToJson(list);

        if (list == null) {
            assertThat(actual, nullValue());
        } else {
            assertThat(actual.substring(1, actual.length()-1), isEmptyString());
        }
    }

}
