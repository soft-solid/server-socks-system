package org.courses.web.soap;

import javax.jws.WebService;

import org.courses.domain.hbm.Material;

import java.util.Collection;
import java.util.Hashtable;

@WebService
public interface MaterialService {
    Hashtable<String, Integer> Save(Collection<Material> entities);

    Collection<Material> ReadAll(boolean onlyActive);

    void Deactivate(Collection<Integer> ArrayID);
}
