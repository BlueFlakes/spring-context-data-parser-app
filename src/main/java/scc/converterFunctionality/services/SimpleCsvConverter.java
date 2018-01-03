package scc.converterFunctionality.services;

import scc.converterFunctionality.OutputFormat;

import java.io.File;

public class SimpleCsvConverter {
    public void convert(File file, OutputFormat outputFormat) {
        System.out.println("I convert CSV to Output format");
    }

    public void convert(File file) {
        System.out.println("I convert CSV to Output format(DEFAULT)");
    }
}
