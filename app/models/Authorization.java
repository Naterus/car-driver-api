package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "authorizations")
public class Authorization extends Model {

    @Id
    @Column(unique = true)
    private String authorizationKey;
    @Column(unique = true)
    private String email;
    private String name;


    public static Finder<String, Authorization> find = new Finder<>(Authorization.class);

    public Authorization() {
    }

    public Authorization(String authorizationKey, String email, String name) {
        this.authorizationKey = authorizationKey;
        this.email = email;
        this.name = name;
    }


    public String getAuthorizationKey() {
        return authorizationKey;
    }

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Finder<String, Authorization> getFind() {
        return find;
    }

    public static void setFind(Finder<String, Authorization> find) {
        Authorization.find = find;
    }
}
