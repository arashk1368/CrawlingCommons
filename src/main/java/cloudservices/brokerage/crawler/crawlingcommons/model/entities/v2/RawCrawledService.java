/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities.v2;

import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v2.RawCrawledServiceColType;
import cloudservices.brokerage.crawler.crawlingcommons.model.enums.v2.RawCrawledServiceType;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
@Entity
public class RawCrawledService implements Serializable {

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
    private String searchedQuery;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String source;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String extraContext;
    @Enumerated(EnumType.STRING)
    private RawCrawledServiceType type;
    @Column
    private boolean updated;
    @OneToMany(mappedBy = "rawCrawledService")
    private Set<CrawledServiceSnapshot> crawledServiceSnapshots;

    public RawCrawledService() {
        this.title = "";
        this.url = "";
        this.description = "";
        this.searchedQuery = "";
        this.source = "";
        this.extraContext = "";
    }
    
    public RawCrawledService(RawCrawledService rcs) {
        this.title = rcs.title;
        this.url = rcs.url;
        this.description = rcs.description;
        this.searchedQuery = rcs.searchedQuery;
        this.source = rcs.source;
        this.extraContext = rcs.extraContext;
        this.type = rcs.type;
        this.updated = rcs.updated;
    }

    public RawCrawledService(String title, String url, String description, RawCrawledServiceType type) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.type = type;
    }

    public RawCrawledService(String title, String url, String description, String searchedQuery, String source, RawCrawledServiceType type) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.searchedQuery = searchedQuery;
        this.source = source;
        this.type = type;
    }

    public RawCrawledService(String title, String url, String description, String searchedQuery, String source, String extraContext, RawCrawledServiceType type) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.searchedQuery = searchedQuery;
        this.source = source;
        this.extraContext = extraContext;
        this.type = type;
    }

    public RawCrawledService(String title, String url, String description, String searchedQuery, String source, String extraContext, RawCrawledServiceType type, boolean isUpdated) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.searchedQuery = searchedQuery;
        this.source = source;
        this.extraContext = extraContext;
        this.type = type;
        this.updated = isUpdated;
    }

    public static boolean checkLength(long length, RawCrawledServiceColType colType) {
        switch (colType) {
            case DESCRIPTION:
                return length < 10000;
            case TITLE:
                return length < 1000;
            case URL:
                return length < 1000;
            case SEARCHED_QUERY:
                return length < 1000;
            case SOURCE:
                return length < 1000;
            case EXTRA_CONTEXT:
                return length < 1000;
            default:
                return length < 255;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getQuery() {
        return searchedQuery;
    }

    public void setQuery(String query) {
        this.searchedQuery = query;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public RawCrawledServiceType getType() {
        return type;
    }

    public void setType(RawCrawledServiceType type) {
        this.type = type;
    }

    public String getExtraContext() {
        return extraContext;
    }

    public void setExtraContext(String extraContext) {
        this.extraContext = extraContext;
    }

    public Set<CrawledServiceSnapshot> getCrawledServiceSnapshots() {
        return crawledServiceSnapshots;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean isUpdated) {
        this.updated = isUpdated;
    }
}
