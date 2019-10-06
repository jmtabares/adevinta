package com.adevinta;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.*;

public class FileSearchEngineTest {

	@Test
	public void getListOfMatches() {
		FileSearchEngine fse=new FileSearchEngine();
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Map<String, Float> searchResult = fse.getListOfMatches(absolutePath,"test a file");
		assertTrue(String.format("%d",searchResult.keySet().size()),searchResult.keySet().size()==1);
	}
}