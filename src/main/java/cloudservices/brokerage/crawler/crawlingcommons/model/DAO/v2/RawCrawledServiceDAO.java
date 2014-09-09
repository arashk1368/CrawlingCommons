/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v2;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v2.RawCrawledService;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class RawCrawledServiceDAO extends BaseDAO {

    public void addCrawledService(RawCrawledService crawledService) throws DAOException {
        super.save(crawledService);
    }
}
