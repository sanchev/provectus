package com.sanchev.provectus;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static final String API_URL = "https://randomuser.me/api/?results=%d";
    private static final int USER_COUNT = 5000;
    private static final String RESULTS_TAG = "results";

    private static UserStorage instance;

    private Context context;
    private List<User> users;

    private RequestQueue queue;

    private UserStorage(Context context) {
        this.context = context;
        users = new ArrayList<>();

        queue = Volley.newRequestQueue(context.getApplicationContext());

        String url = String.format(API_URL, USER_COUNT);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonUsers = response.getJSONArray(RESULTS_TAG);
                            for (int i = 0; i < jsonUsers.length(); i++) {
                                JSONObject jsonUser = jsonUsers.getJSONObject(i);
                                User user = new User();

                                user.setGender(jsonUser.getString(User.GENDER_TAG));

                                JSONObject jsonUserName = jsonUser.getJSONObject(User.NAME_TAG);
                                user
                                        .setNameTitle(jsonUserName.getString(User.NAME_TITLE_TAG))
                                        .setNameFirst(jsonUserName.getString(User.NAME_FIRST_TAG))
                                        .setNameLast(jsonUserName.getString(User.NAME_LAST_TAG));

                                JSONObject jsonUserLocation = jsonUser.getJSONObject(User.LOCATION_TAG);
                                user
                                        .setStreet(jsonUserLocation.getString(User.LOCATION_STREET_TAG))
                                        .setCity(jsonUserLocation.getString(User.LOCATION_CITY_TAG))
                                        .setState(jsonUserLocation.getString(User.LOCATION_STATE_TAG))
                                        .setPostcode(jsonUserLocation.getString(User.LOCATION_POSTCODE_TAG));

                                user.setEmail(jsonUser.getString(User.EMAIL_TAG));

                                JSONObject jsonUserLogin = jsonUser.getJSONObject(User.LOGIN_TAG);
                                user
                                        .setUsername(jsonUserLogin.getString(User.LOGIN_USERNAME_TAG))
                                        .setPassword(jsonUserLogin.getString(User.LOGIN_PASSWORD_TAG))
                                        .setSalt(jsonUserLogin.getString(User.LOGIN_SALT_TAG))
                                        .setMd5(jsonUserLogin.getString(User.LOGIN_MD5_TAG))
                                        .setSha1(jsonUserLogin.getString(User.LOGIN_SHA1_TAG))
                                        .setSha256(jsonUserLogin.getString(User.LOGIN_SHA256_TAG))
                                        .setRegistered(jsonUser.getString(User.REGISTERED_TAG))
                                        .setDob(jsonUser.getString(User.DOB_TAG))
                                        .setPhone(jsonUser.getString(User.PHONE_TAG))
                                        .setCell(jsonUser.getString(User.CELL_TAG));

                                JSONObject jsonUserId = jsonUser.getJSONObject(User.ID_TAG);
                                user
                                        .setIdName(jsonUserId.getString(User.ID_NAME_TAG))
                                        .setIdValue(jsonUserId.getString(User.ID_VALUE_TAG));

                                JSONObject jsonUserPicture = jsonUser.getJSONObject(User.PICTURE_TAG);
                                user
                                        .setPictureLarge(jsonUserPicture.getString(User.PICTURE_LARGE_TAG))
                                        .setPictureMedium(jsonUserPicture.getString(User.PICTURE_MEDIUM_TAG))
                                        .setPictureThumbnail(jsonUserPicture.getString(User.PICTURE_THUMBNAIL_TAG))
                                        .setNat(jsonUser.getString(User.NAT_TAG));

                                users.add(user);
                            }
                            notifyUsersChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });


        queue.add(jsObjRequest);
        System.out.println(users.size());
    }

    public static synchronized UserStorage getInstance(Context context) {
        if (instance == null)
            instance = new UserStorage(context);
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    private void notifyUsersChanged() {
        queue.stop();
        ((StartActivity) context).updateUsersList();
    }
}