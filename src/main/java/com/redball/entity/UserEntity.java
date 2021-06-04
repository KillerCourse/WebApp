package com.redball.entity;

import java.util.Date;

public class UserEntity extends Entity {
    public static final String LOGIN_COLUMN = "login";
    public static final String PASSWORD_COLUMN = "password";
    public static final String ADDRESS_COLUMN = "address";
    public static final String NAME_COLUMN = "name";
    public static final String SURNAME_COLUMN = "surname";
    public static final String EMAIL_COLUMN = "email";
    public static final String DATE_OF_BIRTH_COLUMN = "date_of_birth";
    public static final String IS_ADMIN_COLUMN = "is_admin";
    public static final String LANGUAGE_COLUMN = "language";
    public static final String CITY_ID_COLUMN = "city_id";

    private String login;
    private String password;
    private String address;
    private String name;
    private String surname;
    private String email;
    private Date date;
    private boolean isAdmin;
    private int languageId;
    private int cityId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", isAdmin=" + isAdmin +
                ", languageId=" + languageId +
                ", cityId=" + cityId +
                '}';
    }
}
