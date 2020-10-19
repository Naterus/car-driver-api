package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.Date;

@Entity
@Table(name = "drivers")
public class Driver extends Model{

    @Id
    private int id;
    @Constraints.Required
    private String firstName;
    @Constraints.Required
    private String lastName;
    @Column(unique = true)
    @Constraints.Required
    private String username;
    @Constraints.Required
    private String password;
    @Constraints.Required
    private String contactNumber;
    @Constraints.Required
    private String gender;
    @Constraints.Required
    private int age;
    @Constraints.Required
    private boolean onlineStatus;
    @Constraints.Required
    private boolean deleted;
    private Date dateCreated = new Date();
    private Date dateModified = new Date();
    @OneToOne()
    @Column(nullable = true)
    @JsonBackReference
    private Car carAssigned;

    public static Finder<Long,Driver> find = new Finder<>(Driver.class);

    public Driver() {
    }

    public Driver(String firstName, String lastName, String username, String password, String contactNumber, String gender, int age, boolean onlineStatus, boolean deleted, Date dateCreated, Date dateModified, Car carAssigned) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.age = age;
        this.onlineStatus = onlineStatus;
        this.deleted = deleted;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.carAssigned = carAssigned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Car getCarAssigned() {
        return carAssigned;
    }

    public void setCarAssigned(Car carAssigned) {
        this.carAssigned = carAssigned;
    }
}
