package com.adevinta;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class WordSearcherTest {

	@Test
	public void readContentFromEmptyFile() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("empty.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "sometext");
		assertTrue(String.format("Expected  matches from a empty file is 0 but found %f", result),result==0);
	}
	@Test
	public void fullMatch() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file1.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "test a file");
		assertTrue(String.format("Expected 100%% match from file but found %f%%", result),result==100);
	}
	@Test
	public void partialMatch() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file1.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "test a file completed");
		assertTrue(String.format("Expected 75%%  match from file but found %f%%", result),result==75);
	}
	@Test
	public void partialMatchCase() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file1.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "TEST A FILE");
		assertTrue(String.format("Expected 100%% case insensitive match from file but found %f%%", result),result==100);
	}

	@Test
	public void noMatchCase() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file1.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "not match");
		assertTrue(String.format("Expected 0%% match from file but found %f%%", result),result==0);
	}

	@Test
	public void duplicateWordInFile() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file2.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "duplicate");
		assertTrue(String.format("Expected 100%% match from file but found %f%%", result),result==100);
	}
	@Test
	public void duplicateWordInFileFromPhrase() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file2.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "Test duplicate word");
		assertTrue(String.format("Expected 100%% match from file but found %f%%", result),result==100);
	}
	@Test
	public void duplicateWordInSearch() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file3.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		float result = ws.readContent(path, "duplicate duplicate");
		assertTrue(String.format("Expected 100%% match from file but found %f%%", result),result==100);
	}
	@Test(expected = NullPointerException.class)
	public void noFile() throws IOException {
		WordSearcher ws = new WordSearcher();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("notExists.txt").getFile());
		Path path = Paths.get(file.getAbsolutePath());
		ws.readContent(path, "not match");
	}
}