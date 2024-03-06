package com.example.crud.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetUtilsTest {


    @Test
    void itShouldConvertStringToSet() {
        //given
        String set = "[1,2,3]";
        //when
        Set<Integer> setResponse = SetUtils.stringToSet(set);
        //then
        assertNotNull(setResponse);
        assertEquals(3, setResponse.size());
        assertEquals(1, setResponse.stream().findFirst().get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1,2,3]"})
    void itShouldNotConvertStringToSet(String input) {
        //when
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Set<Integer> setResponse = SetUtils.stringToSet(input);
        });
        String expectedErrorMessage = "For input string: \"\"";
        String actualMessage = exception.getMessage();

        //then
        assertEquals(actualMessage, expectedErrorMessage);
    }

    @Test
    void itShouldConvertSetToString() {
        //given
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        //when
        String stringSetResponse = SetUtils.setToString(set);

        //then
        assertEquals(stringSetResponse.charAt(0),'[');
        assertEquals(stringSetResponse.charAt(stringSetResponse.length()-1),']');
    }

    @Test
    void itShouldConvertSetToEmptyString() {
        //given
        Set<Integer> set = new HashSet<>();
        //when
        String stringSetResponse = SetUtils.setToString(set);
        //then
        assertEquals(stringSetResponse,"[]");
    }
}