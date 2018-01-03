package scc.converterFunctionality.services;

import java.util.Iterator;

public class JsonOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(Iterator<String> data) {
        System.out.println("JSON output formatter");
    }
}
