package scc.enums;

import scc.utils.enums.EnumUtils;

public enum OutputFormat {
    JSON,
    XML,
    TABLE;

    private static EnumUtils<OutputFormat> enumUtils = new EnumUtils<>();

    public static OutputFormat getByName(String name) {
        return enumUtils.getValue(OutputFormat.class, name);
    }
}