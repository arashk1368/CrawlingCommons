/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v2;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v2.RawCrawledService;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class RawCrawledServiceDAO extends BaseDAO {

    public void addCrawledService(RawCrawledService crawledService) throws DAOException {
        super.save(crawledService);
    }
    
    public RawCrawledService findByUrl(String url) throws DAOException {
        Query query = super.getSession().createQuery("from RawCrawledService where url = :para1 ");
        query.setParameter("para1", url);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return (RawCrawledService) list.get(0);
        } else {
            throw new DAOException("Duplicate tuples for url = " + url);
        }
    }
}
