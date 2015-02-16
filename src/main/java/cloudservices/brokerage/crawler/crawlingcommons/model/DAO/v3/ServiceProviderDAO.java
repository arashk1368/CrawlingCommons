/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.ServiceProvider;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class ServiceProviderDAO extends BaseDAO {

    public void addServiceProvider(ServiceProvider serviceProvider) throws DAOException {
        super.save(serviceProvider);
    }

    public ServiceProvider findByUrl(String url) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceProvider where url = :para1 ");
        query.setParameter("para1", url);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return (ServiceProvider) list.get(0);
        } else {
            throw new DAOException("Duplicate tuples for url = " + url);
        }
    }

    public ServiceProvider findByName(String name) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceProvider where name = :para1 ");
        query.setParameter("para1", name);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return (ServiceProvider) list.get(0);
        } else {
            throw new DAOException("Duplicate tuples for name = " + name);
        }
    }
}
