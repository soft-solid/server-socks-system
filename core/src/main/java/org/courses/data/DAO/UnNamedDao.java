package org.courses.data.DAO;

import java.util.Collection;

public interface UnNamedDao<TEntity, TKey> extends DAO<TEntity, TKey> {
    void save(Collection<TEntity> entities);
}
