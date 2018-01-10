package scc.services.formatter;

import scc.services.document.Document;

import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {
    private static final String scopeName = "objects";
    private static final String elementName = "object";
    private static final int indentLength = 4;

    @Override
    public String getFormattedData(Document document) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] headers = document.getHeaders();
        int headersAmount = headers.length;
        List<String[]> documentContent = document.getDeliveredDataContent();
        String indentation = getIndent();

        setXmlVersion(stringBuilder);
        openSpaceWithNextLine(stringBuilder, scopeName);

        for (String[] row : documentContent) {
            openSpaceWithNextLine(stringBuilder, elementName);
            int columnsCount = row.length;
            int propertiesAmount = headersAmount > columnsCount ? columnsCount : headersAmount;

            for (int i = 0; i < propertiesAmount; i++) {
                String header = headers[i];
                String value = row[i];

                stringBuilder.append(indentation);

                openSpace(stringBuilder, header);
                stringBuilder.append(value);
                closeSpaceWithNextLine(stringBuilder, header);
            }

            closeSpaceWithNextLine(stringBuilder, elementName);
        }
        closeSpace(stringBuilder, scopeName);

        return stringBuilder.toString();
    }

    private void setXmlVersion(StringBuilder stringBuilder) {
        String sentence = "?xml version=\"1.0\" encoding=\"UTF-8\"?";
        openSpaceWithNextLine(stringBuilder, sentence);
    }

    private void openSpaceWithNextLine(StringBuilder stringBuilder, String sentence) {
        openSpace(stringBuilder, sentence).append("\n");
    }

    private void closeSpaceWithNextLine(StringBuilder stringBuilder, String sentence) {
        closeSpace(stringBuilder, sentence).append("\n");
    }

    private StringBuilder openSpace(StringBuilder stringBuilder, String sentence) {
        return stringBuilder.append("<").append(sentence).append(">");
    }

    private StringBuilder closeSpace(StringBuilder stringBuilder, String sentence) {
        return stringBuilder.append("</").append(sentence).append(">");
    }

    private String getIndent( ) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indentLength; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
