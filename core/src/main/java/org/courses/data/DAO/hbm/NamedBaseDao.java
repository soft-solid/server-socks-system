package org.courses.data.DAO.hbm;

import org.courses.data.DAO.NamedDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Hashtable;

public abstract class NamedBaseDao<TEntity extends EntityWithName, TKey> extends BaseDao<TEntity, TKey> implements NamedDao<TEntity, TKey>{
    protected NamedBaseDao(SessionFactory factory, Class<TEntity> entityType) {
        super (factory,entityType);
    }

    @Transactional(rollbackFor = Exception.class)
    public Hashtable<String, Integer> save(Collection<TEntity> entities) {
        Session session = factory.getCurrentSession();
        Hashtable<String, Integer> resultDc = new Hashtable<>();

        for (TEntity entity : entities) {
            if (entity.getId() < 1)
                resultDc.put(entity.getName(), 0);

            session.saveOrUpdate(entity);

            if (resultDc.containsKey(entity.getName()))
                resultDc.replace(entity.getName(), entity.getId());
        }
        return resultDc;
    }
}
