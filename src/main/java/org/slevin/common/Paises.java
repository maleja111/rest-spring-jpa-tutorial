package org.slevin.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
@Table(name="T_PAISES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Paises {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@XmlElement
	private String cdPais;
	
	@XmlElement
	private String dsNombre;

    @OneToMany(cascade=CascadeType.DETACH , fetch = FetchType.EAGER)
    @JoinColumn(name="PAISES_ID")
    @XmlElement
    private Collection<Zonas> zonas = new LinkedHashSet<Zonas>();

    @JsonIgnore
    @ManyToOne
    private Zonas cdZona;

    public Zonas getCdZona() {
        return cdZona;
    }

    public void setCdZona(Zonas cdZona) {
        this.cdZona = cdZona;
    }

    public String getDsNombre() {
        return dsNombre;
    }

    public void setDsNombre(String dsNombre) {
        this.dsNombre = dsNombre;
    }

    public String getCdPais() {
        return cdPais;
    }

    public void setCdPais(String cdPais) {
        this.cdPais = cdPais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Zonas> getZonas() {
        return zonas;
    }

    public void setZonas(Collection<Zonas> zonas) {
        this.zonas = zonas;
    }

}
