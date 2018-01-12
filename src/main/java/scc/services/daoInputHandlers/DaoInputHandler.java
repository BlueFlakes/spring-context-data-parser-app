package scc.services.daoInputHandlers;

import scc.exception.DAOException;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersInterpreter;
import scc.services.document.Document;

public interface DaoInputHandler {
    Document prepareData(OrdersInterpreter ordersInterpreter) throws DAOException, ImproperArgumentException;
}
