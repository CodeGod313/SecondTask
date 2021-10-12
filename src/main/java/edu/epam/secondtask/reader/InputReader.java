package edu.epam.secondtask.reader;

import edu.epam.secondtask.exception.WrongFilePathException;

import java.nio.file.Path;
import java.util.List;

public interface InputReader {
    List<String> readStringsFromFile(Path filePath) throws WrongFilePathException;
}
