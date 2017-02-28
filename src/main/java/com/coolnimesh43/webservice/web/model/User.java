package com.coolnimesh43.webservice.web.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends AbstractAuditEntity implements UserDetails {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String fullName;
    private Collection<? extends GrantedAuthority> authority;
    private String userToken;
    private String password;

    public User() {
        super();
    }

    public User(String userName, String password, Collection<? extends GrantedAuthority> authority, String userToken) {
        this.login = userName;
        this.password = password;
        this.authority = authority;
        this.userToken = userToken;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.login = builder.login;
        this.fullName = builder.fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<? extends GrantedAuthority> getAuthority() {
        return authority;
    }

    public void setAuthority(Collection<? extends GrantedAuthority> authority) {
        this.authority = authority;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authority;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.login;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.isEnabled();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", login=" + login
                + ", fullName=" + fullName + "]";
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String login;
        private String fullName;

        public Builder() {
            super();
        }

        public Builder(String firstName, String lastName, String email, String login) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.login = login;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
