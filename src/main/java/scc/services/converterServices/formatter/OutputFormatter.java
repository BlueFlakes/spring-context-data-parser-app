package scc.services.converterServices.formatter;

import java.util.Iterator;

public interface OutputFormatter {
    String getFormattedData(Iterator<String[]> data);
}
