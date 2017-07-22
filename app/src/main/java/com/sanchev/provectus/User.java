package com.sanchev.provectus;

import com.google.gson.annotations.SerializedName;

class User {
    static final String GENDER_TAG = "gender";
    static final String NAME_TAG = "name";
    static final String NAME_TITLE_TAG = "title";
    static final String NAME_FIRST_TAG = "first";
    static final String NAME_LAST_TAG = "last";
    static final String LOCATION_TAG = "location";
    static final String LOCATION_STREET_TAG = "street";
    static final String LOCATION_CITY_TAG = "city";
    static final String LOCATION_STATE_TAG = "state";
    static final String LOCATION_POSTCODE_TAG = "postcode";
    static final String EMAIL_TAG = "email";
    static final String LOGIN_TAG = "login";
    static final String LOGIN_USERNAME_TAG = "username";
    static final String LOGIN_PASSWORD_TAG = "password";
    static final String LOGIN_SALT_TAG = "salt";
    static final String LOGIN_MD5_TAG = "md5";
    static final String LOGIN_SHA1_TAG = "sha1";
    static final String LOGIN_SHA256_TAG = "sha256";
    static final String REGISTERED_TAG = "registered";
    static final String DOB_TAG = "dob";
    static final String PHONE_TAG = "phone";
    static final String CELL_TAG = "cell";
    static final String ID_TAG = "id";
    static final String ID_NAME_TAG = "name";
    static final String ID_VALUE_TAG = "value";
    static final String PICTURE_TAG = "picture";
    static final String PICTURE_LARGE_TAG = "large";
    static final String PICTURE_MEDIUM_TAG = "medium";
    static final String PICTURE_THUMBNAIL_TAG = "thumbnail";
    static final String NAT_TAG = "nat";

    @SerializedName(GENDER_TAG)
    private String gender;
    @SerializedName(NAME_TAG)
    private Name name;
    @SerializedName(LOCATION_TAG)
    private Location location;
    @SerializedName(EMAIL_TAG)
    private String email;
    @SerializedName(LOGIN_TAG)
    private Login login;
    @SerializedName(REGISTERED_TAG)
    private String registered;
    @SerializedName(DOB_TAG)
    private String dob;
    @SerializedName(PHONE_TAG)
    private String phone;
    @SerializedName(CELL_TAG)
    private String cell;
    @SerializedName(ID_TAG)
    private Id id;
    @SerializedName(PICTURE_TAG)
    private Picture picture;
    @SerializedName(NAT_TAG)
    private String nat;

    User() {
    }

    String getGender() {
        return gender;
    }

    String getNameTitle() {
        return name.title;
    }

    String getNameFirst() {
        return name.first;
    }

    String getNameLast() {
        return name.last;
    }

    String getStreet() {
        return location.street;
    }

    String getCity() {
        return location.city;
    }

    String getState() {
        return location.state;
    }

    String getPostcode() {
        return location.postcode;
    }

    String getEmail() {
        return email;
    }

    String getUsername() {
        return login.username;
    }

    String getPassword() {
        return login.password;
    }

    String getSalt() {
        return login.salt;
    }

    String getMd5() {
        return login.md5;
    }

    String getSha1() {
        return login.sha1;
    }

    String getSha256() {
        return login.sha256;
    }

    String getRegistered() {
        return registered;
    }

    String getDob() {
        return dob;
    }

    String getPhone() {
        return phone;
    }

    String getCell() {
        return cell;
    }

    String getIdName() {
        return id.name;
    }

    String getIdValue() {
        return id.value;
    }

    String getPictureLarge() {
        return picture.large;
    }

    String getPictureMedium() {
        return picture.medium;
    }

    String getPictureThumbnail() {
        return picture.thumbnail;
    }

    String getNat() {
        return nat;
    }

    private class Name {
        @SerializedName(NAME_TITLE_TAG)
        String title;
        @SerializedName(NAME_FIRST_TAG)
        private String first;
        @SerializedName(NAME_LAST_TAG)
        private String last;
    }

    private class Location {
        @SerializedName(LOCATION_STREET_TAG)
        private String street;
        @SerializedName(LOCATION_CITY_TAG)
        private String city;
        @SerializedName(LOCATION_STATE_TAG)
        private String state;
        @SerializedName(LOCATION_POSTCODE_TAG)
        private String postcode;
    }

    private class Login {
        @SerializedName(LOGIN_USERNAME_TAG)
        private String username;
        @SerializedName(LOGIN_PASSWORD_TAG)
        private String password;
        @SerializedName(LOGIN_SALT_TAG)
        private String salt;
        @SerializedName(LOGIN_MD5_TAG)
        private String md5;
        @SerializedName(LOGIN_SHA1_TAG)
        private String sha1;
        @SerializedName(LOGIN_SHA256_TAG)
        private String sha256;
    }

    private class Id {
        @SerializedName(ID_NAME_TAG)
        private String name;
        @SerializedName(ID_VALUE_TAG)
        private String value;
    }

    private class Picture {
        @SerializedName(PICTURE_LARGE_TAG)
        private String large;
        @SerializedName(PICTURE_MEDIUM_TAG)
        private String medium;
        @SerializedName(PICTURE_THUMBNAIL_TAG)
        private String thumbnail;
    }
}