package org.slevin.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Aves {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;


    @JsonIgnore
    @ManyToOne
    private AvesPais avesPais;

    @XmlElement
    private String cdAve;

    @XmlElement
    private String dsNombreComun;

    @XmlElement
    private String dsNombreCientifico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AvesPais getAvesPais() {
        return avesPais;
    }

    public void setAvesPais(AvesPais avesPais) {
        this.avesPais = avesPais;
    }

    public String getDsNombreComun() {
        return dsNombreComun;
    }

    public void setDsNombreComun(String dsNombreComun) {
        this.dsNombreComun = dsNombreComun;
    }

    public String getDsNombreCientifico() {
        return dsNombreCientifico;
    }

    public void setDsNombreCientifico(String dsNombreCientifico) {
        this.dsNombreCientifico = dsNombreCientifico;
    }

    public String getCdAve() {
        return cdAve;
    }

    public void setCdAve(String cdAve) {
        this.cdAve = cdAve;
    }
}
