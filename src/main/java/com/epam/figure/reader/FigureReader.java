package com.epam.figure.reader;

import com.epam.figure.exception.FigureException;
import com.epam.figure.validator.FigureFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.processing.FilerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FigureReader {
    private static final Logger LOGGER = LogManager.getLogger(FigureReader.class);

    public List<String> read(String file) throws FigureException {
        LOGGER.log(Level.INFO, "read file {}", file);
        try (Stream<String> input = Files.lines(Paths.get(file))){
            List<String> list = input
                    .filter(FigureFileValidator::validate)
                    .collect(Collectors.toList());
            if(list.isEmpty()){
                throw new FilerException("No valid lines found");
            }
            return list;
        } catch (IOException ex) {
            throw new FigureException("Cannot read the file" + file);
        }
    }
}
