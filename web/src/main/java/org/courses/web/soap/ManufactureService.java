package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Manufacture;

import java.util.Collection;
import java.util.Hashtable;

@WebService
public interface ManufactureService {
    Hashtable<String, Integer> Save(Collection<Manufacture> entities);

    Collection<Manufacture> ReadAll(boolean onlyActive);

    void Deactivate(Collection<Integer> ArrayID);
}
