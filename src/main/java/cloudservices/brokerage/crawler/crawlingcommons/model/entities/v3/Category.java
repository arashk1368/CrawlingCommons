/*
 * Copyright 2014 Arash khodadadi.
 * <http://www.arashkhodadadi.com/>
 */
package cloudservices.brokerage.crawler.crawlingcommons.model.entities.v3;

import java.io.Serializable;
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
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(columnDefinition = "varchar(255)", length = 255)
    @Length(max = 255)
    private String name;
        @OneToMany(mappedBy = "primaryCategoryWithCtx")
    private Set<ServiceDescriptionSnapshot> withCtxPrimarySnapshots;
                @OneToMany(mappedBy = "primaryCategoryPlain")
    private Set<ServiceDescriptionSnapshot> plainPrimarySnapshots;
                        @OneToMany(mappedBy = "secondaryCategoryWithCtx")
    private Set<ServiceDescriptionSnapshot> withCtxSecondarySnapshots;
                                @OneToMany(mappedBy = "secondaryCategoryPlain")
    private Set<ServiceDescriptionSnapshot> plainSecondarySnapshots;

    public Category() {
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ServiceDescriptionSnapshot> getWithCtxPrimarySnapshots() {
        return withCtxPrimarySnapshots;
    }

    public void setWithCtxPrimarySnapshots(Set<ServiceDescriptionSnapshot> withCtxPrimarySnapshots) {
        this.withCtxPrimarySnapshots = withCtxPrimarySnapshots;
    }

    public Set<ServiceDescriptionSnapshot> getPlainPrimarySnapshots() {
        return plainPrimarySnapshots;
    }

    public void setPlainPrimarySnapshots(Set<ServiceDescriptionSnapshot> plainPrimarySnapshots) {
        this.plainPrimarySnapshots = plainPrimarySnapshots;
    }

    public Set<ServiceDescriptionSnapshot> getWithCtxSecondarySnapshots() {
        return withCtxSecondarySnapshots;
    }

    public void setWithCtxSecondarySnapshots(Set<ServiceDescriptionSnapshot> withCtxSecondarySnapshots) {
        this.withCtxSecondarySnapshots = withCtxSecondarySnapshots;
    }

    public Set<ServiceDescriptionSnapshot> getPlainSecondarySnapshots() {
        return plainSecondarySnapshots;
    }

    public void setPlainSecondarySnapshots(Set<ServiceDescriptionSnapshot> plainSecondarySnapshots) {
        this.plainSecondarySnapshots = plainSecondarySnapshots;
    }
    
    
}
