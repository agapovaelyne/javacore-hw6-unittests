package ru.netology;

import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static ru.netology.Main.jsonToList;
import static ru.netology.Main.parseXML;

public class HamcrestTestsNew {

    @ParameterizedTest
    @ValueSource(strings = {"src/test/sourses/dataNotExist.xml", "src/test/sourses/dataInvalid1.xml", "src/test/sourses/dataInvalid2.xml","src/test/sourses/dataInvalid3.xml","src/test/sourses/dataEmpty.xml", "src/test/sourses/data.json"})
    public void parseXMLBadFiles_success(String filename) {
        List<Employee> list = parseXML(filename);
        assertThat(list, empty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}"})
    public void jsonToListBadStrings_success (String jsonString) {
        List<Employee> list = jsonToList(jsonString);
        assertThat(list.size(), Matchers.greaterThanOrEqualTo(0));
    }
}
