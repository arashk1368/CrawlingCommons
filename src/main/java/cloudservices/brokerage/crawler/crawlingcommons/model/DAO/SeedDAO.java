/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO;

import cloudservices.brokerage.crawler.crawlingcommons.model.entities.WSDL;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class SeedDAO extends BaseDAO {

    public void addWSDL(WSDL wsdl) throws DAOException {
        super.save(wsdl);
    }
}
