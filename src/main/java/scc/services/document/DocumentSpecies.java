package scc.services.document;

import scc.interfaces.Flag;

public enum DocumentSpecies implements Flag {
    HEADERS_AT_FIRST_ROW("+h");

    private final String flag;

    DocumentSpecies(String flag) {
        this.flag = flag;
    }

    @Override
    public String getEnumFlag() {
        return this.flag;
    }
}
