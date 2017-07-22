package com.sanchev.provectus;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

class User implements Parcelable{
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

    private class Name {
        @SerializedName(NAME_TITLE_TAG)
        String title;
        @SerializedName(NAME_FIRST_TAG)
        private String first;
        @SerializedName(NAME_LAST_TAG)
        private String last;
    }

    @SerializedName(NAME_TAG)
    private Name name;

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

    @SerializedName(LOCATION_TAG)
    private Location location;

    @SerializedName(EMAIL_TAG)
    private String email;

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

    private class Id {
        @SerializedName(ID_NAME_TAG)
        private String name;
        @SerializedName(ID_VALUE_TAG)
        private String value;
    }

    @SerializedName(ID_TAG)
    private Id id;

    private class Picture {
        @SerializedName(PICTURE_LARGE_TAG)
        private String large;
        @SerializedName(PICTURE_MEDIUM_TAG)
        private String medium;
        @SerializedName(PICTURE_THUMBNAIL_TAG)
        private String thumbnail;
    }

    @SerializedName(PICTURE_TAG)
    private Picture picture;

    @SerializedName(NAT_TAG)
    private String nat;

    User() {
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeString(name.title);
        parcel.writeString(name.first);
        parcel.writeString(name.last);
        parcel.writeString(location.street);
        parcel.writeString(location.city);
        parcel.writeString(location.state);
        parcel.writeString(location.postcode);
        parcel.writeString(email);
        parcel.writeString(login.username);
        parcel.writeString(login.password);
        parcel.writeString(login.salt);
        parcel.writeString(login.md5);
        parcel.writeString(login.sha1);
        parcel.writeString(login.sha256);
        parcel.writeString(registered);
        parcel.writeString(dob);
        parcel.writeString(phone);
        parcel.writeString(cell);
        parcel.writeString(id.name);
        parcel.writeString(id.value);
        parcel.writeString(picture.large);
        parcel.writeString(picture.medium);
        parcel.writeString(picture.thumbnail);
        parcel.writeString(nat);
    }

    User(Parcel parcel) {
        gender = parcel.readString();
        name = new Name();
        name.title = parcel.readString();
        name.first = parcel.readString();
        name.last = parcel.readString();
        location = new Location();
        location.street = parcel.readString();
        location.city = parcel.readString();
        location.state = parcel.readString();
        location.postcode = parcel.readString();
        email = parcel.readString();
        login = new Login();
        login.username = parcel.readString();
        login.password = parcel.readString();
        login.salt = parcel.readString();
        login.md5 = parcel.readString();
        login.sha1 = parcel.readString();
        login.sha256 = parcel.readString();
        registered = parcel.readString();
        dob = parcel.readString();
        phone = parcel.readString();
        cell = parcel.readString();
        id = new Id();
        id.name = parcel.readString();
        id.value = parcel.readString();
        picture = new Picture();
        picture.large = parcel.readString();
        picture.medium = parcel.readString();
        picture.thumbnail = parcel.readString();
        nat = parcel.readString();
    }
}
