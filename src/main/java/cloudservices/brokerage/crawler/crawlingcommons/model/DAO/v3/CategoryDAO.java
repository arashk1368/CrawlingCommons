/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.DAO.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.BaseDAO;
import cloudservices.brokerage.crawler.crawlingcommons.model.DAO.DAOException;
import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3.Category;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class CategoryDAO extends BaseDAO {

    public void addCategory(Category category) throws DAOException {
        super.save(category);
    }

    public Category findByName(String name) throws DAOException {
        Query query = super.getSession().createQuery("from Category where name = :para1 ");
        query.setParameter("para1", name);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return (Category) list.get(0);
        } else {
            throw new DAOException("Duplicate tuples for name = " + name);
        }
    }
}
