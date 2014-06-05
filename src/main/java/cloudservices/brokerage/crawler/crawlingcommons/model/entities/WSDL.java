/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * @author Arash Khodadadi http://www.arashkhodadadi.com/  
 */
@Entity
public class WSDL implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column(columnDefinition = "varchar(1000)")
    private String url;
    @Column(columnDefinition = "varchar(1000)")
    private String description;

    public WSDL() {
    }

    public WSDL(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
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
}
