/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO;

import cloudservices.brokerage.crawler.crawlingcommons.model.entities.Seed;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class SeedDAO extends BaseDAO {

    public void addSeed(Seed seed) throws DAOException {
        super.save(seed);
    }
}
