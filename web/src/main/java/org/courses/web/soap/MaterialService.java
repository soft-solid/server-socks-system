package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Material;

import java.util.Collection;

@WebService
public interface MaterialService {
    void save(Collection<Material> entity);

    Material read(int id);

    Collection<Material> readAll();

    Collection<Material> find(String filter);

    void delete(int id);
}
