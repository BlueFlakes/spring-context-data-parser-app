package scc.services.formatter;

import scc.interfaces.Flag;
import scc.utils.enums.EnumUtils;

public enum OutputFormat implements Flag {
    JSON(null),
    XML(null),
    TABLE(null);

    private final String flag;

    OutputFormat(String flag) {
        this.flag = flag;
    }

    private static EnumUtils<OutputFormat> enumUtils = new EnumUtils<>();

    public static OutputFormat getByName(String name) {
        return enumUtils.getValue(OutputFormat.class, name);
    }

    @Override
    public String getEnumFlag( ) {
        return this.flag;
    }
}