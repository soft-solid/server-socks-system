package org.courses.data.DAO;

import java.util.Collection;

public interface DAO<TEntity, TKey> {
   TEntity read(TKey id);

   Collection<TEntity> readAll(boolean onlyActive);

   Collection<TEntity> find(String filter);

   void delete(TKey id);
}
