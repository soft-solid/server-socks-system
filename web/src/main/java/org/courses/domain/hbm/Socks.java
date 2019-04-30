package org.courses.domain.hbm;

import org.courses.data.DAO.hbm.EntityWithID;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "Socks")
public class Socks implements Serializable, EntityWithID {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private double size;

    @Column(name = "colour")
    private int colour;

    @ManyToOne
    @JoinColumn(name = "manufacture")
    private Manufacture manufacture;

    @ManyToOne
    @JoinColumn(name = "type")
    private SocksType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "socks", targetEntity = Composition.class)
    @XmlElementWrapper(name = "compositions")
    @XmlElement(name = "composition", required = true)
    private List<Composition> composition = new ArrayList<>();

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public SocksType getType() {
        return type;
    }

    public void setType(SocksType type) {
        this.type = type;
    }

    public List<Composition> getComposition() {
        return composition;
    }

    public void setComposition(List<Composition> composition) {
        this.composition = composition;
    }

    public void add(Composition c) {
        composition.add(c);
        c.setSocks(this);
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
