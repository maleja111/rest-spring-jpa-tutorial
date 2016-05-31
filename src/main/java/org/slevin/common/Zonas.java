package org.slevin.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="T_ZONAS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Zonas {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @XmlElement
	private String cdZona;
	


	@XmlElement
	private String dsNombre;

    @JsonIgnore
    @ManyToOne
    private Paises paises;

    public String getDsNombre() {
        return dsNombre;
    }

    public void setDsNombre(String dsNombre) {
        this.dsNombre = dsNombre;
    }

    public String getCdZona() {
        return cdZona;
    }

    public void setCdZona(String cdZona) {
        this.cdZona = cdZona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }
}
