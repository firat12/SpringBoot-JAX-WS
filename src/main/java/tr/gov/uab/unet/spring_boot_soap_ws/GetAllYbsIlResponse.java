//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.27 at 08:45:43 PM EET 
//


package tr.gov.uab.unet.spring_boot_soap_ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="ybsIlDto" type="{http://unet.uab.gov.tr/spring-boot-soap-ws}ybsIlDto" maxOccurs="unbounded"/>
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
    "ybsIlDto"
})
@XmlRootElement(name = "getAllYbsIlResponse")
public class GetAllYbsIlResponse {

    @XmlElement(required = true)
    protected List<YbsIlDto> ybsIlDto;

    /**
     * Gets the value of the ybsIlDto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ybsIlDto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYbsIlDto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link YbsIlDto }
     * 
     * 
     */
    public List<YbsIlDto> getYbsIlDto() {
        if (ybsIlDto == null) {
            ybsIlDto = new ArrayList<YbsIlDto>();
        }
        return this.ybsIlDto;
    }

}