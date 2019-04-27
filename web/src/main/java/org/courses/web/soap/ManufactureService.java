package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Manufacture;

import java.util.Collection;
import java.util.Hashtable;

@WebService
public interface ManufactureService {
    Hashtable<String, Integer> Save(Collection<Manufacture> entities);

    //SocksType Read(int id);

    Collection<Manufacture> ReadAll();

    //Collection<SocksType> Find(String filter);

    //void Delete(int id);

    void Deactivate(Collection<Integer> ArrayID);
}
