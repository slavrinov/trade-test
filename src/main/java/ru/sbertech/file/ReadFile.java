package ru.sbertech.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Сергей on 07.07.2017.
 */
public class ReadFile {

    /*
    * Считываем данные из файла
    * @param String filename имя файла
    * */
    public static List read(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            return stream
                    //.filter(line -> line.endsWith("txt"))
                    .map(String::toUpperCase)
                    .sequential()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}
