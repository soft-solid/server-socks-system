package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Socks;

import java.util.Collection;

@WebService
public interface SocksService {
    void Save(Collection<Socks> entity);

    Socks Read(int id);

    Collection<Socks> ReadAll(boolean onlyActive);

    Collection<Socks> Find(String filter);

    void Delete(int id);
}
