/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.ServiceDescription;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.ServiceDescriptionSnapshot;
import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionType;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class ServiceDescriptionSnapshotDAO extends BaseDAO {

    public void addSnapshot(ServiceDescriptionSnapshot snapshot) throws DAOException {
        super.save(snapshot);
    }

    public ServiceDescriptionSnapshot getLast(ServiceDescription description, ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescriptionSnapshot where type = :para1 and serviceDescription = :para2 order by accessedTime desc");
        query.setParameter("para1", type);
        query.setParameter("para2", description);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (ServiceDescriptionSnapshot) list.get(0);
        }
    }

    public List<ServiceDescriptionSnapshot> getAll(long startingId, long endingId, ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescriptionSnapshot where type = :para1"
                + " and id >= :para2 and id <= :para3");
        query.setParameter("para1", type);
        query.setParameter("para2", startingId);
        query.setParameter("para3", endingId);
        return query.list();
    }

    public List<ServiceDescriptionSnapshot> getContexClassified(long startingId, long endingId, ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescriptionSnapshot where type = :para1"
                + " and id >= :para2 and id <= :para3 and primaryCategoryWithCtx is not null");
        query.setParameter("para1", type);
        query.setParameter("para2", startingId);
        query.setParameter("para3", endingId);
        return query.list();
    }

    public List<ServiceDescriptionSnapshot> getNotClassified(long startingId, long endingId, ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescriptionSnapshot where type = :para1"
                + " and id >= :para2 and id <= :para3 and primaryCategoryPlain is null and primaryCategoryWithCtx is null");
        query.setParameter("para1", type);
        query.setParameter("para2", startingId);
        query.setParameter("para3", endingId);
        return query.list();
    }

    public List<ServiceDescriptionSnapshot> getPlainClassified(long startingId, long endingId, ServiceDescriptionType type) throws DAOException {
        Query query = super.getSession().createQuery("from ServiceDescriptionSnapshot where type = :para1"
                + " and id >= :para2 and id <= :para3 and primaryCategoryPlain is not null");
        query.setParameter("para1", type);
        query.setParameter("para2", startingId);
        query.setParameter("para3", endingId);
        return query.list();
    }
}
