package org.slevin.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

@Entity
@Table(name="T_AVESPAIS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class AvesPais {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    @OneToMany(cascade=CascadeType.DETACH , fetch = FetchType.EAGER)
    @JoinColumn(name="AVESPAIS_ID")
    @XmlElement
    private Collection<Aves> aves = new LinkedHashSet<Aves>();

    @OneToMany(cascade=CascadeType.DETACH , fetch = FetchType.EAGER)
    @JoinColumn(name="AVESPAIS_ID")
    @XmlElement
    private Collection<Paises> paises = new LinkedHashSet<Paises>();

    public Collection<Aves> getAves() {
        return aves;
    }

    public void setAves(Collection<Aves> aves) {
        this.aves = aves;
    }

    public Collection<Paises> getPaises() {
        return paises;
    }

    public void setPaises(Collection<Paises> paises) {
        this.paises = paises;
    }

}
