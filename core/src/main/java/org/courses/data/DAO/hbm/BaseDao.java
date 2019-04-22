package org.courses.data.DAO.hbm;

import org.courses.data.DAO.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public abstract class BaseDao<TEntity, TKey> implements DAO<TEntity, TKey> {
    protected Class<TEntity> entityType;
    protected SessionFactory factory;

    protected BaseDao(SessionFactory factory, Class<TEntity> entityType) {
        this.entityType = entityType;
        this.factory = factory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TEntity read(TKey id) {
        Session session = factory.getCurrentSession();
        return session.find(entityType, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<TEntity> readAll() {
        String query = String.format("from %s", entityType.getSimpleName());
        Session session = factory.getCurrentSession();
        return session
                .createQuery(query)
                .list();
    }

    @Override
    public abstract Collection<TEntity> find(String filter);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TKey id) {
        Session session = factory.getCurrentSession();
        TEntity entity = session.find(entityType, id);

        session.delete(entity);
    }
}
