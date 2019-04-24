package org.courses.data.DAO.hbm;

import org.courses.data.DAO.UnNamedDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public abstract class UnNamedBaseDao<TEntity extends EntityWithID, TKey> extends BaseDao<TEntity, TKey> implements UnNamedDao<TEntity, TKey> {
    protected UnNamedBaseDao(SessionFactory factory, Class<TEntity> entityType) {
        super(factory, entityType);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Collection<TEntity> entities) {
        Session session = factory.getCurrentSession();
        for (TEntity entity : entities) {
            session.saveOrUpdate(entity);
        }
    }
}