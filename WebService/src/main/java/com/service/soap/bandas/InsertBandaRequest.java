//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.13 a las 05:13:01 PM COT 
//


package com.service.soap.bandas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="banda" type="{http://service.com/soap/bandas}bandas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "banda"
})
@XmlRootElement(name = "insertBandaRequest")
public class InsertBandaRequest {

    @XmlElement(required = true)
    protected Bandas banda;

    /**
     * Obtiene el valor de la propiedad banda.
     * 
     * @return
     *     possible object is
     *     {@link Bandas }
     *     
     */
    public Bandas getBanda() {
        return banda;
    }

    /**
     * Define el valor de la propiedad banda.
     * 
     * @param value
     *     allowed object is
     *     {@link Bandas }
     *     
     */
    public void setBanda(Bandas value) {
        this.banda = value;
    }

}
