package ru.netology;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ru.netology.Main.parseCSV;

public class ParseCSVTest {

    @Test
    public void parseCSVEmptyResult_test() throws CsvValidationException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "src/test/sourses/dataEmpty.csv";
        List<Employee> result = parseCSV(columnMapping, fileName);

        Assertions.assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/sourses/dataNotExist.csv", "src/test/sourses/dataInvalid.csv"})
    public void parseBadCSV_success(String fileName) throws CsvValidationException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        Assertions.assertAll("parseCSVFileNotExist_success",
                () -> Assertions.assertDoesNotThrow( () ->
                        parseCSV(columnMapping, fileName)),
                () -> Assertions.assertEquals(null,parseCSV(columnMapping, fileName))
        );
    }

    @Test
    public void badMappingParseCSV_success() throws CsvValidationException {
        String[] columnMapping = {"ad", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> result = parseCSV(columnMapping, fileName);

        Assertions.assertAll("parseCSVFileNotExist_success",
                () -> Assertions.assertFalse(result.isEmpty()),
                () -> Assertions.assertNotNull(result.get(0).getId())
        );
    }
}
