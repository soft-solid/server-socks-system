package org.courses.web.soap;

import javax.jws.WebService;
import java.util.Collection;
import java.util.Hashtable;


public interface BaseDictionaryService<TEntity> {
    Hashtable<String, Integer> Save(Collection<TEntity> entities);

    Collection<TEntity> ReadAll(boolean onlyActive);

    void Deactivate(Collection<Integer> ArrayID);
}
