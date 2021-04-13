package com.epam.figure.reader;

import com.epam.figure.exception.FigureException;
import com.epam.figure.validator.FigureFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.processing.FilerException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FigureReader {
    private final static Logger LOGGER = LogManager.getLogger(FigureReader.class);

    public List<String> read(String file) throws FigureException {
        try {
            List<String> list = Files.lines(Paths.get(file), StandardCharsets.UTF_8)
                    .filter(FigureFileValidator::validate)
                    .collect(Collectors.toList());
            LOGGER.log(Level.INFO, new StringBuilder()
                    .append("read file : ")
                    .append(file).toString());
            if(list.isEmpty()){
                throw new FilerException("No valid lines found");
            }
            return list;
        } catch (IOException ex) {
            throw new FigureException("Cannot read the file" + file);
        }
    }
}
