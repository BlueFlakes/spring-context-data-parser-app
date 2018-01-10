package scc.services.formatter;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import scc.exception.DataFormatException;
import scc.services.document.Document;

public class TableOutputFormatter implements OutputFormatter {
    @Override
    public String getFormattedData(Document document) throws Exception {
        AsciiTable asciiTable = new AsciiTable();

        addNextRow(document.getHeaders(), asciiTable);

        for (String[] row : document.getDeliveredDataContent()) {
            addNextRow(row, asciiTable);
        }

        asciiTable.addRule();
        asciiTable.setTextAlignment(TextAlignment.CENTER);
        asciiTable.getContext().setGrid(A7_Grids.minusBarPlusEquals());

        return asciiTable.render();
    }

    private void addNextRow(String[] row, AsciiTable asciiTable) {
        asciiTable.addRule();
        asciiTable.addRow(row);
    }
}
