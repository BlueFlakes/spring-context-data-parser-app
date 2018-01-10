package scc.services.formatter;

import scc.services.document.Document;

public interface OutputFormatter {
    String getFormattedData(Document document) throws Exception;
}
