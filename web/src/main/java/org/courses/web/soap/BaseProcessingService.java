package org.courses.web.soap;

public interface BaseProcessingService<TEntity> {
    TEntity Read(int id);

    void delete(int id);
}
