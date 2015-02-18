/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.ServiceDescription;
import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionType;
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

    public List<ServiceDescription> getAllWithType(ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where type = :para1");
        query.setParameter("para1", type);
        return query.list();
    }

    public List<ServiceDescription> getBothTimesNull(ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where type = :para1 and lastAvailableTime is null and lastUnavailableTime is null");
        query.setParameter("para1", type);
        return query.list();
    }

    public List<ServiceDescription> getNeverAvailable(ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where type = :para1 and lastAvailableTime is null");
        query.setParameter("para1", type);
        return query.list();
    }

    public List<ServiceDescription> getUpdated(ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where type = :para1 and updated = :para2");
        query.setParameter("para1", type);
        query.setParameter("para2", true);
        return query.list();
    }

    public List<ServiceDescription> getUnavailable(ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescription where type = :para1 and wasAvailable = :para2");
        query.setParameter("para1", type);
        query.setParameter("para2", false);
        return query.list();
    }

}
