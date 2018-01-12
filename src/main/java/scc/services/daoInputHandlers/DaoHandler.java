package scc.services.daoInputHandlers;

import scc.exception.DAOException;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.services.document.Document;

public interface DaoHandler {
    Document prepareData(OrdersProvider ordersProvider) throws DAOException, ImproperArgumentException;
}
