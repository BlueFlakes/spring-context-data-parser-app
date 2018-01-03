package scc.converterFunctionality;

import scc.utils.enums.EnumUtils;

import java.util.Optional;

public enum OutputFormat {
    JSON,
    XML,
    TABLE;

    private static EnumUtils<OutputFormat> enumUtils = new EnumUtils<>();

    public static Optional<OutputFormat> getByName(String name) {
        return enumUtils.getValue(OutputFormat.class, name);
    }
}
