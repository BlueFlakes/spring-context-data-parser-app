package scc.converterFunctionality.services;

import java.util.Iterator;

public class XmlOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(Iterator<String> data) {
        System.out.println("XML output formatter");
    }
}
