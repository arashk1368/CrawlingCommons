/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities;

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
    @Column
    private String title;
    @Column(columnDefinition = "varchar(1000)", length = 1000)
    @Length(max = 1000)
    private String url;
    @Column(columnDefinition = "varchar(10000)", length = 10000)
    @Length(max = 10000)
    private String description;

    public Seed() {
    }

    public Seed(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
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
}
