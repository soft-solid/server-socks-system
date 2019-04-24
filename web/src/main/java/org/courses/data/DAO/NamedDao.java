package org.courses.data.DAO;

import java.util.Collection;
import java.util.Map;

public interface NamedDao<TEntity, TKey> extends DAO<TEntity, TKey> {
    Map<String, Integer> save(Collection<TEntity> entities);
    }
