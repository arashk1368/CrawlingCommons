/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO;

import cloudservices.brokerage.crawler.crawlingcommons.model.entities.WSDL;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class WSDLDAO extends BaseDAO {

    public void addWSDL(WSDL wsdl) throws DAOException {
        super.save(wsdl);
    }

    public boolean URLExists(String url) throws DAOException {
        Query query = super.getSession().createQuery("from WSDL where url = :para1 ");
        query.setParameter("para1", url);
        List list = query.list();
        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
