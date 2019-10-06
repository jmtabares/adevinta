package com.adevinta;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class FileSearchEngine {
    private WordSearcher ws =  new WordSearcher();
    Map<String, Float> getListOfMatches(String path, String search) {
        Map<String, Float> matches =  new HashMap<String,Float>();
        try(Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath) && (filePath.toString().endsWith(".txt"))) {
                    try {
                        float test  = ws.readContent(filePath,search);
                        if (test>0)
                            matches.put(filePath.toString(),test);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }
}