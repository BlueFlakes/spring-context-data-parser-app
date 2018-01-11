package scc.services.printer;

import scc.interfaces.Flag;
import scc.utils.enums.EnumUtils;

public enum PrinterType implements Flag {
    PRINT_TO_CONSOLE(null),
    PRINT_TO_FILE("flag");

    private final String flag;

    PrinterType(String flag) {
        this.flag = flag;
    }

    @Override
    public String getEnumFlag( ) {
        return this.flag;
    }

    private static EnumUtils<PrinterType> enumUtils = new EnumUtils<>();

    public static PrinterType getByName(String name) {
        return enumUtils.getValue(PrinterType.class, name);
    }
}
