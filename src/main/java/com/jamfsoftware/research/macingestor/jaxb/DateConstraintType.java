//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.17 at 09:04:29 AM CDT 
//


package com.jamfsoftware.research.macingestor.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dateConstraintType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dateConstraintType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="nullable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateConstraintType")
public class DateConstraintType {

    @XmlAttribute(name = "max")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar max;
    @XmlAttribute(name = "min")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar min;
    @XmlAttribute(name = "nullable")
    protected java.lang.Boolean nullable;

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMax(XMLGregorianCalendar value) {
        this.max = value;
    }

    /**
     * Gets the value of the min property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMin(XMLGregorianCalendar value) {
        this.min = value;
    }

    /**
     * Gets the value of the nullable property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Boolean }
     *     
     */
    public java.lang.Boolean isNullable() {
        return nullable;
    }

    /**
     * Sets the value of the nullable property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Boolean }
     *     
     */
    public void setNullable(java.lang.Boolean value) {
        this.nullable = value;
    }

}
