package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manufacturers")
public class Manufacturer extends Model {

    @Id
    @Column(unique = true)
    @Constraints.Required
    private String id;
    @Column(nullable = true)
    private String location;
    @Column(nullable = true)
    private Date dateEstablished;
    // Other relevant info about manufacturer can be added

    public static Finder<String,Manufacturer> find = new Finder<>(Manufacturer.class);

    public Manufacturer() {
    }

    public Manufacturer(String id, String location, Date dateEstablished) {
        this.id = id;
        this.location = location;
        this.dateEstablished = dateEstablished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }
}
