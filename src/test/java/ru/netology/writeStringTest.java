package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static ru.netology.Main.writeString;

public class writeStringTest {

    @ParameterizedTest
    @NullSource
    public void nullString_success(String json) {
        Assertions.assertDoesNotThrow(() -> writeString(json, "result.json"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void badFileName_success(String fileName) {
        String json = "";
        Assertions.assertDoesNotThrow(() -> writeString(json, fileName));
    }

}
