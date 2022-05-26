package com.sagar.spring.data.jpa.tutorial.entity;

import javax.persistence.*;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name="guardian_name")),
        @AttributeOverride(
                name = "email",
                column = @Column(name="guardian_email")),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name="guardian_mobile"))
})
public class Gaurdian {
    private String name;
    private String email;
    private String mobile;

    public Gaurdian() {
    }

    public Gaurdian(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
