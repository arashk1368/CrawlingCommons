/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.crawler.crawlingcommons.utils.db_utils;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IncrementGenerator;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
public class UseExistingOrGenerateIdGenerator extends IncrementGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object)
                        throws HibernateException {
        Serializable id = session.getEntityPersister(null, object)
                      .getClassMetadata().getIdentifier(object, session);
        return id != null ? id : super.generate(session, object);
    }
}
