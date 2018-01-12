package scc.services.formatter;

import scc.services.document.Document;

import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {
    private static final String scopeName = "objects";
    private static final String elementName = "object";

    @Override
    public String getFormattedData(Document document) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        String[] headers = document.getHeaders();
        int headersAmount = headers.length;
        List<String[]> documentContent = document.getDeliveredDataContent();

        setXmlVersion(stringBuilder);
        openSpace(stringBuilder, scopeName);

        for (String[] row : documentContent) {
            openSpace(stringBuilder, elementName);
            int columnsCount = row.length;
            int propertiesAmount = headersAmount > columnsCount ? columnsCount : headersAmount;

            for (int i = 0; i < propertiesAmount; i++) {
                String header = headers[i];
                String value = row[i];

                openSpace(stringBuilder, header);
                stringBuilder.append(value);
                closeSpace(stringBuilder, header);
            }

            closeSpace(stringBuilder, elementName);
        }
        closeSpace(stringBuilder, scopeName);

        return stringBuilder.toString();
    }

    private void setXmlVersion(StringBuilder stringBuilder) {
        String sentence = "?xml version=\"1.0\" encoding=\"UTF-8\"?";
        openSpace(stringBuilder, sentence);
    }

    private void openSpace(StringBuilder stringBuilder, String sentence) {
        stringBuilder.append("<").append(sentence).append(">");
    }

    private void closeSpace(StringBuilder stringBuilder, String sentence) {
        stringBuilder.append("</").append(sentence).append(">");
    }
}
