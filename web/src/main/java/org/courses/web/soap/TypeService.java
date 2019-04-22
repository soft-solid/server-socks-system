package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.SocksType;

import java.util.Collection;
import java.util.Hashtable;

@WebService
public interface TypeService /*extends BaseDictionaryService<SocksType> */{
    Hashtable<String, Integer> Save(Collection<SocksType> entities);

    //SocksType Read(int id);

    Collection<SocksType> ReadAll();

    //Collection<SocksType> Find(String filter);

    //void Delete(int id);

    void Deactivate(Collection<Integer> ArrayID);
}
