/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionColType;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Arash Khodadadi <http://www.arashkhodadadi.com/>
 */
@Entity
public class ServiceProvider {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int numberOfServices;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String url;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String name;
    @Column(columnDefinition = "varchar(255)", length = 255)
    @Length(max = 255)
    private String country;
    @Column(columnDefinition = "varchar(10000)", length = 10000)
    @Length(max = 10000)
    private String description;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String tags;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String extraInfo;
    @OneToMany(mappedBy = "serviceProvider")
    private Set<ServiceDescription> serviceDescriptions;

    public ServiceProvider() {
        this.name = "";
        this.url = "";
        this.description = "";
        this.tags = "";
        this.country = "";
        this.extraInfo = "";
        this.numberOfServices = 0;
    }

    public ServiceProvider(String url) {
        this();
        this.url = url;
    }
    
    public static boolean checkLength(long length, ServiceDescriptionColType colType) {
        switch (colType) {
            case DESCRIPTION:
                return length < 10000;
            case TITLE:
                return length < 1000;
            case URL:
                return length < 1000;
            case TAGS:
                return length < 1000;
            case SOURCE:
                return length < 1000;
            case EXTRA_INFO:
                return length < 1000;
            default:
                return length < 255;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Set<ServiceDescription> getServiceDescriptions() {
        return serviceDescriptions;
    }

    public void setServiceDescriptions(Set<ServiceDescription> serviceDescriptions) {
        this.serviceDescriptions = serviceDescriptions;
    }

}
