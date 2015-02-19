/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
@Entity
public class ServiceDescriptionSnapshot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IdOrGenerated")
    @GenericGenerator(name = "IdOrGenerated",strategy = "cloudservices.brokerage.crawler.crawlingcommons.utils.db_utils.UseExistingOrGenerateIdGenerator")
    private Long id;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String fileAddress;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessedTime;
    @Column
    private boolean isProcessed;
    @Enumerated(EnumType.STRING)
    private ServiceDescriptionType type;
    @ManyToOne
    @JoinColumn(name = "service_description_id")
    private ServiceDescription serviceDescription;

    public ServiceDescriptionSnapshot() {
    }

    public ServiceDescriptionSnapshot(String fileAddress, Date accessedTime, boolean isProcessed, ServiceDescriptionType type, ServiceDescription serviceDesc) {
        this.fileAddress = fileAddress;
        this.accessedTime = accessedTime;
        this.isProcessed = isProcessed;
        this.type = type;
        this.serviceDescription = serviceDesc;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public Date getAccessedTime() {
        return accessedTime;
    }

    public void setAccessedTime(Date accessedTime) {
        this.accessedTime = accessedTime;
    }

    public boolean isIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceDescriptionType getType() {
        return type;
    }

    public void setType(ServiceDescriptionType type) {
        this.type = type;
    }

    public ServiceDescription getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(ServiceDescription serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

}
