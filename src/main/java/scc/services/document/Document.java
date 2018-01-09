package scc.services.document;

import java.util.List;

public class Document {
    private List<String[]> deliveredDataContent;
    private String[] headers;

    public Document(List<String[]> deliveredDataContent, String[] headers) {
        this.deliveredDataContent = deliveredDataContent;
        this.headers = headers;
    }

    public List<String[]> getDeliveredDataContent( ) {
        return deliveredDataContent;
    }

    public String[] getHeaders( ) {
        return headers;
    }
}
