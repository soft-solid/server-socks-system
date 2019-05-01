package org.courses.data.DAO.hbm;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.sqliteconvertion.DateConverter;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

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
    public Collection<TEntity> readAll(boolean onlyActive) {

        Session session = factory.getCurrentSession();
        String query;
        if (onlyActive)//Были разные варианты разграничения этого (новый метод / необязательный пвраметр / вынести в базовый класс), но остановился на этом. Интресно какой наиболее приемлимый?
            query = String.format("from %s WHERE active = 1", entityType.getSimpleName());
        else
            query = String.format("from %s", entityType.getSimpleName());
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
