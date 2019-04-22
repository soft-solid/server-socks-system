package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Socks;

import java.util.Collection;

@WebService
public interface SocksService {
    void save(Collection<Socks> entity);

    Socks read(int id);

    Collection<Socks> readAll();

    Collection<Socks> find(String filter);

    void delete(int id);
}
