package scc.interfaces;

import scc.dao.DataLoader;

public interface ReaderSettingsHandler {
    DataLoader getInstanceWithSettledProperties();
}
