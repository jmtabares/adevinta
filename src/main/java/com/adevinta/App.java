package com.adevinta;

import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No directory given to index.");
        }
        Scanner scanner = new Scanner(System.in);
        FileSearchEngine fileSearchEngine;
        while (true) {
            DisplayResults.displayPrompt();
            String search = scanner.nextLine();
            if (":quit".equalsIgnoreCase(search)) {
                DisplayResults.displayMessageQuit();
                break;
            }
            fileSearchEngine = new FileSearchEngine();
            Map<String, Float> result = fileSearchEngine.getListOfMatches(args[0],search);
            if (result.size()==0) DisplayResults.displayNoMatchFoundMessage();
            else
                DisplayResults.displayNItemsDescendingOrderResult(result,10);

        }
    }
}
