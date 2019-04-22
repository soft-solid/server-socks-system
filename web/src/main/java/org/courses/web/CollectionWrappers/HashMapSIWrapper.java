package org.courses.web.CollectionWrappers;


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;

public class HashMapSIWrapper {
 //   @XmlJavaTypeAdapter(MapA)
    HashMap<String, Integer> map;

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Integer> map) {
        this.map = map;
    }
}
