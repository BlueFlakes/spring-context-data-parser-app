package scc.services.formatter;

import scc.exception.ImproperArgumentException;
import scc.models.ArgsInterpreter;
import scc.models.BasicArgsInterpreter;


public class OutputFormatterFactory {
    public OutputFormatter createByFormat(ArgsInterpreter argsInterpreter) throws ImproperArgumentException {
        BasicArgsInterpreter basicArgsInterpreter = new BasicArgsInterpreter(argsInterpreter);
//        OutputFormat outputFormat = basicArgsInterpreter.getOutputFormat();
        OutputFormat outputFormat = OutputFormat.TABLE;
        
        if (outputFormat != null) {
            switch (outputFormat) {
                case XML:
                    return new XmlOutputFormatter();

                case JSON:
                    return new JsonOutputFormatter();

                case TABLE:
                    return new TableOutputFormatter();
            }
        }

        return new TableOutputFormatter();
    }
}
