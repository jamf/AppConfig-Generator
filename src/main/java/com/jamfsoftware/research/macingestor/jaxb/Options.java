//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.17 at 09:04:29 AM CDT 
//


package com.jamfsoftware.research.macingestor.jaxb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="option" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}language" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "option"
})
@XmlRootElement(name = "options")
public class Options {

    @XmlElement(required = true)
    protected List<Options.Option> option;

    /**
     * Gets the value of the option property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the option property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Options.Option }
     * 
     * 
     */
    public List<Options.Option> getOption() {
        if (option == null) {
            option = new ArrayList<Options.Option>();
        }
        return this.option;
    }


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
     *         &lt;element ref="{}language" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "language"
    })
    public static class Option {

        @XmlElement(required = true)
        protected List<Language> language;
        @XmlAttribute(name = "selected")
        protected java.lang.Boolean selected;
        @XmlAttribute(name = "value", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected java.lang.String value;

        /**
         * Gets the value of the language property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the language property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Language }
         * 
         * 
         */
        public List<Language> getLanguage() {
            if (language == null) {
                language = new ArrayList<Language>();
            }
            return this.language;
        }

        /**
         * Gets the value of the selected property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.Boolean }
         *     
         */
        public java.lang.Boolean isSelected() {
            return selected;
        }

        /**
         * Sets the value of the selected property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.Boolean }
         *     
         */
        public void setSelected(java.lang.Boolean value) {
            this.selected = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setValue(java.lang.String value) {
            this.value = value;
        }
        
        public java.lang.String getLanguageForLocale(Locale locale, java.lang.String defaultLocale){      	
        	return Language.getLanguageForLocale(locale, defaultLocale, language);
        }
    }
}
