package com.sanchev.provectus;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static final String API_URL = "https://randomuser.me/api/?results=%d";
    private static final int USER_COUNT = 2;
    private static final String RESULTS_TAG = "results";
    public static final String USER_INDEX = "index";

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
                                Gson gson = new Gson();
                                User user = gson.fromJson(jsonUser.toString(), User.class);
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