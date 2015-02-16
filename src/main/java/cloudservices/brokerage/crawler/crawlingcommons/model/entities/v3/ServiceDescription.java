/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3;

import cloudservices.brokerage.crawler.crawlingcommons.model.entities.v2.RawCrawledService;
import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionColType;
import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v3.ServiceDescriptionType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
@Entity
public class ServiceDescription implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String title;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String url;
    @Column(columnDefinition = "varchar(10000)", length = 10000)
    @Length(max = 10000)
    private String description;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String tags;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String source;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String extraInfo;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAvailableTime;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUnavailableTime;
    @Column
    private boolean wasAvailable;
    @Column
    private boolean updated;
    @Enumerated(EnumType.STRING)
    private ServiceDescriptionType type;
    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;
    @OneToMany(mappedBy = "serviceDescription")
    private Set<ServiceDescriptionSnapshot> crawledServiceSnapshots;
    
    public ServiceDescription() {
        this.title = "";
        this.url = "";
        this.description = "";
        this.tags = "";
        this.source = "";
        this.extraInfo = "";
        this.wasAvailable = false;
        this.updated = false;
    }

    public ServiceDescription(RawCrawledService rcs) {
        this();
        this.title = rcs.getTitle();
        this.url = rcs.getUrl();
        this.description=rcs.getDescription();
        this.tags = rcs.getQuery();
        this.source = rcs.getSource();
        this.extraInfo = rcs.getExtraContext();
        this.updated = rcs.isUpdated();
        this.type = ServiceDescriptionType.convertFromV2(rcs.getType());
    }
    
    
    
    public ServiceDescription(ServiceDescription sd) {
        this();
        this.title = sd.title;
        this.url = sd.url;
        this.description = sd.description;
        this.tags = sd.tags;
        this.source = sd.source;
        this.extraInfo = sd.extraInfo;
        this.lastAvailableTime = sd.lastAvailableTime;
        this.lastUnavailableTime = sd.lastUnavailableTime;
        this.wasAvailable = sd.wasAvailable;
        this.type = sd.type;
        this.updated = sd.updated;
    }
    
    public ServiceDescription(String title, String url, String description, String tags, String source, ServiceDescriptionType type) {
        this();
        this.title = title;
        this.url = url;
        this.description = description;
        this.tags = tags;
        this.source = source;
        this.type = type;
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
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
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
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getExtraInfo() {
        return extraInfo;
    }
    
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    
    public Date getLastAvailableTime() {
        return lastAvailableTime;
    }
    
    public void setLastAvailableTime(Date lastAvailableTime) {
        this.lastAvailableTime = lastAvailableTime;
    }
    
    public Date getLastUnavailableTime() {
        return lastUnavailableTime;
    }
    
    public void setLastUnavailableTime(Date lastUnavailableTime) {
        this.lastUnavailableTime = lastUnavailableTime;
    }
    
    public boolean available() {
        return wasAvailable;
    }
    
    public void setAvailable(boolean wasAvailable) {
        this.wasAvailable = wasAvailable;
    }
    
    public boolean isUpdated() {
        return updated;
    }
    
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
    
    public ServiceDescriptionType getType() {
        return type;
    }
    
    public void setType(ServiceDescriptionType type) {
        this.type = type;
    }
    
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }
    
    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    
    public Set<ServiceDescriptionSnapshot> getCrawledServiceSnapshots() {
        return crawledServiceSnapshots;
    }
    
    public void setCrawledServiceSnapshots(Set<ServiceDescriptionSnapshot> crawledServiceSnapshots) {
        this.crawledServiceSnapshots = crawledServiceSnapshots;
    }
}
