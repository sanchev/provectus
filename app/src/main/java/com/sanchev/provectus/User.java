package com.sanchev.provectus;

import android.os.Parcel;
import android.os.Parcelable;

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

    private String gender;
    private String nameTitle;
    private String nameFirst;
    private String nameLast;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private String email;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
    private String registered;
    private String dob;
    private String phone;
    private String cell;
    private String idName;
    private String idValue;
    private String pictureLarge;
    private String pictureMedium;
    private String pictureThumbnail;
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

    User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    String getNameTitle() {
        return nameTitle;
    }

    User setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
        return this;
    }

    String getNameFirst() {
        return nameFirst;
    }

    User setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
        return this;
    }

    String getNameLast() {
        return nameLast;
    }

    User setNameLast(String nameLast) {
        this.nameLast = nameLast;
        return this;
    }

    String getStreet() {
        return street;
    }

    User setStreet(String street) {
        this.street = street;
        return this;
    }

    String getCity() {
        return city;
    }

    User setCity(String city) {
        this.city = city;
        return this;
    }

    String getState() {
        return state;
    }

    User setState(String state) {
        this.state = state;
        return this;
    }

    String getPostcode() {
        return postcode;
    }

    User setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    String getEmail() {
        return email;
    }

    User setEmail(String email) {
        this.email = email;
        return this;
    }

    String getUsername() {
        return username;
    }

    User setUsername(String username) {
        this.username = username;
        return this;
    }

    String getPassword() {
        return password;
    }

    User setPassword(String password) {
        this.password = password;
        return this;
    }

    String getSalt() {
        return salt;
    }

    User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    String getMd5() {
        return md5;
    }

    User setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    String getSha1() {
        return sha1;
    }

    User setSha1(String sha1) {
        this.sha1 = sha1;
        return this;
    }

    String getSha256() {
        return sha256;
    }

    User setSha256(String sha256) {
        this.sha256 = sha256;
        return this;
    }

    String getRegistered() {
        return registered;
    }

    User setRegistered(String registered) {
        this.registered = registered;
        return this;
    }

    String getDob() {
        return dob;
    }

    User setDob(String dob) {
        this.dob = dob;
        return this;
    }

    String getPhone() {
        return phone;
    }

    User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    String getCell() {
        return cell;
    }

    User setCell(String cell) {
        this.cell = cell;
        return this;
    }

    String getIdName() {
        return idName;
    }

    User setIdName(String idName) {
        this.idName = idName;
        return this;
    }

    String getIdValue() {
        return idValue;
    }

    User setIdValue(String idValue) {
        this.idValue = idValue;
        return this;
    }

    String getPictureLarge() {
        return pictureLarge;
    }

    User setPictureLarge(String pictureLarge) {
        this.pictureLarge = pictureLarge;
        return this;
    }

    String getPictureMedium() {
        return pictureMedium;
    }

    User setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
        return this;
    }

    String getPictureThumbnail() {
        return pictureThumbnail;
    }

    User setPictureThumbnail(String pictureThumbnail) {
        this.pictureThumbnail = pictureThumbnail;
        return this;
    }

    String getNat() {
        return nat;
    }

    User setNat(String nat) {
        this.nat = nat;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeString(nameTitle);
        parcel.writeString(nameFirst);
        parcel.writeString(nameLast);
        parcel.writeString(street);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(postcode);
        parcel.writeString(email);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(salt);
        parcel.writeString(md5);
        parcel.writeString(sha1);
        parcel.writeString(sha256);
        parcel.writeString(registered);
        parcel.writeString(dob);
        parcel.writeString(phone);
        parcel.writeString(cell);
        parcel.writeString(idName);
        parcel.writeString(idValue);
        parcel.writeString(pictureLarge);
        parcel.writeString(pictureMedium);
        parcel.writeString(pictureThumbnail);
        parcel.writeString(nat);
    }

    User(Parcel parcel) {
        gender = parcel.readString();
        nameTitle = parcel.readString();
        nameFirst = parcel.readString();
        nameLast = parcel.readString();
        street = parcel.readString();
        city = parcel.readString();
        state = parcel.readString();
        postcode = parcel.readString();
        email = parcel.readString();
        username = parcel.readString();
        password = parcel.readString();
        salt = parcel.readString();
        md5 = parcel.readString();
        sha1 = parcel.readString();
        sha256 = parcel.readString();
        registered = parcel.readString();
        dob = parcel.readString();
        phone = parcel.readString();
        cell = parcel.readString();
        idName = parcel.readString();
        idValue = parcel.readString();
        pictureLarge = parcel.readString();
        pictureMedium = parcel.readString();
        pictureThumbnail = parcel.readString();
        nat = parcel.readString();
    }
}
