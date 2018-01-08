package scc.dao;

import scc.exception.DAOException;

import java.util.List;

public interface DataLoader {
    List<String[]> getResourceContent() throws DAOException;
}