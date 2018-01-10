package scc.services.printer;

import scc.utils.enums.EnumUtils;

public enum PrinterType {
    PRINT_TO_CONSOLE;

    private static EnumUtils<PrinterType> enumUtils = new EnumUtils<>();

    public static PrinterType getByName(String name) {
        return enumUtils.getValue(PrinterType.class, name);
    }
}
