package scc.services.daoInputHandlers;

import scc.exception.DAOException;
import scc.models.ArgsInterpreter;
import scc.services.document.Document;

public interface DaoInputHandler {
    Document prepareData(ArgsInterpreter argsInterpreter) throws DAOException;
}
