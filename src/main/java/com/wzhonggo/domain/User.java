package com.wzhonggo.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "userCache")
@Cacheable
@Entity
@Table(name = "user")
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long userId;
    private String screenName;
    private String email;
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
