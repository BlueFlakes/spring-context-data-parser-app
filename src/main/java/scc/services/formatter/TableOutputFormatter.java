package scc.services.formatter;

import java.util.List;

public class TableOutputFormatter implements OutputFormatter {
    @Override
    public String getFormattedData(List<String[]> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] values : data) {
            for (String value : values) {
                stringBuilder.append(value).append(" | ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
