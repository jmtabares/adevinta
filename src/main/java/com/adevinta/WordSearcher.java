package com.adevinta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordSearcher {

	float readContent(Path filePath, String search) throws IOException {
		List<String> fileList = Files.readAllLines(filePath);
		List<String> words = Arrays.asList(search.split(" "));
		int count = 0;
		int total = words.size();
		for(String word:words){
			for (String line: fileList)
				if (isContain(line, word)) count++;
		}
		return (count>0)  ? count*100 /total : 0;
	}
	private boolean isContain(String source, String subItem){
		String pattern = "\\b"+subItem+"\\b";
		Pattern p=Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher m=p.matcher(source);
		return m.find();
	}
}
