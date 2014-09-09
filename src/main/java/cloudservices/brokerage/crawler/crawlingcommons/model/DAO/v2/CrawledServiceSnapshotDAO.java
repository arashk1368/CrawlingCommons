/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v2;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v2.CrawledServiceSnapshot;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class CrawledServiceSnapshotDAO extends BaseDAO {

    public void addSnapshot(CrawledServiceSnapshot snapshot) throws DAOException {
        super.save(snapshot);
    }
}
