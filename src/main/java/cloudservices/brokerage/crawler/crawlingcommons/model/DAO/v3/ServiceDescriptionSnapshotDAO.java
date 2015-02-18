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
}
