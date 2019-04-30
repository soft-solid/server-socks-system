package org.courses.domain.hbm;

import org.courses.data.DAO.hbm.EntityWithID;
import org.courses.domain.hbm.sqliteconvertion.DateConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "Storage")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Storage implements Serializable, EntityWithID{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //@OneToOne
    @Column(name = "socks")
    private int socks;

    @Column(name = "added")
    private String added;

    @Column(name = "retired")
    private String retired;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Socks getSocks() {
//        return socks;
//    }
//
//    public void setSocks(Socks socks) {
//        this.socks = socks;
//    }

//    public DateTime getAdded() {
//        return added;
//    }
//
//    public void setAdded(DateTime added) {
//        this.added = added;
//    }
//
//    public DateTime getRetired() {
//        return retired;
//    }
//
//    public void setRetired(DateTime retired) {
//        this.retired = retired;
//    }

}
