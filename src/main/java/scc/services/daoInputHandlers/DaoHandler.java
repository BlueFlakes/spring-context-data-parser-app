package scc.services.daoInputHandlers;

import org.springframework.stereotype.Component;
import scc.exception.DAOException;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.services.document.Document;
@Component
public interface DaoHandler {
    Document prepareData(OrdersProvider ordersProvider) throws DAOException, ImproperArgumentException;
}
