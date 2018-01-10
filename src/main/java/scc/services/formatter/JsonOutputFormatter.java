package scc.services.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import scc.services.document.Document;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonOutputFormatter implements OutputFormatter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getFormattedData(Document document) throws Exception {

        String[] headers = document.getHeaders();
        int headersAmount = headers.length;

        List<String[]> table = document.getDeliveredDataContent();
        List<Map<String, String>> mappedRecords = new ArrayList<>();

        for (String[] row : table) {
            Map<String, String> map = new LinkedHashMap<>();

            for (int i = 0; i < headersAmount; i++) {
                String header = headers[i];
                String body = row[i];

                map.put(header, body);
            }

            mappedRecords.add(map);
        }

        return objectMapper.writeValueAsString(mappedRecords);
    }
}
