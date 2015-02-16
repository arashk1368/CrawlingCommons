/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.ServiceDescription;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class ServiceDescriptionDAO extends BaseDAO {

    public void addServiceDescription(ServiceDescription serviceDescription) throws DAOException {
        super.save(serviceDescription);
    }

    public ServiceDescription findByUrl(String url) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where url = :para1 ");
        query.setParameter("para1", url);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return (ServiceDescription) list.get(0);
        } else {
            throw new DAOException("Duplicate tuples for url = " + url);
        }
    }

    public List<ServiceDescription> getWithoutProvider() throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where serviceProvider is null");
        return query.list();
    }
}
