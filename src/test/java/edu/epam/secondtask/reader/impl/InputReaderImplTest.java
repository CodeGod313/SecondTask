package edu.epam.secondtask.reader.impl;

import edu.epam.secondtask.exception.WrongFilePathException;
import edu.epam.secondtask.reader.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputReaderImplTest {

    InputReader inputReader;

    @BeforeAll
    public void setUp() {
        inputReader = new InputReaderImpl();
    }

    @Test
    public void testReadStringsFromFile() throws WrongFilePathException {
        Path path = Paths.get("src/test/resources/input/testData.txt");
        List<String> expected = List.of("123 456 kkkk", "ddd b");
        List<String> actual = inputReader.readStringsFromFile(path);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testReadStingsFromFileWrongPathException() {
        Path path = Paths.get("hello world---");
        Assertions.assertThrows(WrongFilePathException.class, () -> {
            inputReader.readStringsFromFile(path);
        });
    }
}