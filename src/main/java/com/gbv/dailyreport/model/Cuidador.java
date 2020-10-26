package com.gbv.dailyreport.model;

@Entity
@Table(name = "cuidador")
public class Cuidador {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {

    }

    public void setId(Long id) {

    }

    public String getUsername() {

    }

    public void setUsername(String username) {

    }

    public String getPassword() {

    }

    public void setPassword(String password) {

    }

    @Transient
    public String getPasswordConfirm() {

    }

    public void setPasswordConfirm(String passwordConfirm) {

    }

    public void setRoles(Set roles) {

    }

}