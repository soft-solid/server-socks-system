package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Manufacture;

import java.util.Collection;

@WebService
public interface ManufactureService {
    void save(Collection<Manufacture> entity);

    Manufacture read(int id);

    Collection<Manufacture> readAll();

    Collection<Manufacture> find(String filter);

    void delete(int id);
}
