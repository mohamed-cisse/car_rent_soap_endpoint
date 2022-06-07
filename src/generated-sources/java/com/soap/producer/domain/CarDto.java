//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.05.19 at 05:58:44 PM EET 
//


package com.soap.producer.domain;

import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"model", "id", "customerName", "endDate"})
@XmlRootElement(name = "getCarDetailsRequest")
public class CarDto implements Serializable {

    protected String model;
    protected Integer id;
    protected String customerName;
    protected Date endDate;
    @XmlTransient
    protected String customerEmail;

    /**
     * Gets the value of the model property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the customerName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEndDate(Date value) {
        this.endDate = value;
    }

    public String getCustomerEmail() {

        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;

    }





}
