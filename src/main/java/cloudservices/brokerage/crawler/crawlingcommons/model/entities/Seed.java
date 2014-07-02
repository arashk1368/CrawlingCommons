/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities;

import cloudservices.brokerage.crawler.crawlingcommons.model.enums.WSDLColType;
import static cloudservices.brokerage.crawler.crawlingcommons.model.enums.WSDLColType.DESCRIPTION;
import static cloudservices.brokerage.crawler.crawlingcommons.model.enums.WSDLColType.SEARCHED_QUERY;
import static cloudservices.brokerage.crawler.crawlingcommons.model.enums.WSDLColType.TITLE;
import static cloudservices.brokerage.crawler.crawlingcommons.model.enums.WSDLColType.URL;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Arash
 */
@Entity
public class Seed implements Serializable {

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
    
     public static boolean checkLength(long length, WSDLColType colType) {
        switch (colType) {
            case DESCRIPTION:
                if (length < 10000) {
                    return true;
                } else {
                    return false;
                }
            case TITLE:
                if (length < 1000) {
                    return true;
                } else {
                    return false;
                }
            case URL:
                if (length < 1000) {
                    return true;
                } else {
                    return false;
                }
            case SEARCHED_QUERY:
                if (length < 1000) {
                    return true;
                } else {
                    return false;
                }

            default:
                if (length < 255) {
                    return true;
                } else {
                    return false;
                }
        }
    }
    
    public Seed() {
    }

    public Seed(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public Seed(String url, String title, String description, String searchedQuery) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.searchedQuery = searchedQuery;
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

    public String getSearchedQuery() {
        return searchedQuery;
    }

    public void setSearchedQuery(String searchedQuery) {
        this.searchedQuery = searchedQuery;
    }
    
}
