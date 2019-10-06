package com.adevinta;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

class DisplayResults {
	static void displayNItemsDescendingOrderResult(Map<String, Float> result, int limit) {
		Map<String, Float> sorted = result
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(
						toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
								LinkedHashMap::new));
		List<String> keys = sorted.keySet().stream()
				.limit(limit)
				.collect(Collectors.toList());
		for (String key: keys){
			System.out.println(String.format("File %s:%f%%", key, sorted.get(key)));
		}

	}
	static void displayNoMatchFoundMessage() {
		simpleDisplay("No matches found");
	}

	static void displayMessageQuit() {
		simpleDisplay("Exiting...");
	}

	static void displayPrompt() {
		simpleDisplay("search>:");
	}
	private static void simpleDisplay(String message){
		System.out.print(message);
	}
}

