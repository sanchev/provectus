package com.sanchev.provectus;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra(User.class.getCanonicalName());

        ImageView pictureLarge = (ImageView) findViewById(R.id.pictureLarge);
        Picasso.
                with(this).
                load(user.getPictureLarge()).
                into((pictureLarge));

        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(String.format("%s %s %s", user.getNameTitle(), user.getNameFirst(), user.getNameLast()));

        TextView valueStreet = (TextView) findViewById(R.id.valueStreet);
        TextView valueCity = (TextView) findViewById(R.id.valueCity);
        TextView valueState = (TextView) findViewById(R.id.valueState);
        TextView valuePostcode = (TextView) findViewById(R.id.valuePostcode);
        valueStreet.setText(user.getStreet());
        valueCity.setText(user.getCity());
        valueState.setText(user.getState());
        valuePostcode.setText(user.getPostcode());

        TextView valueEmail = (TextView) findViewById(R.id.valueEmail);
        valueEmail.setText(user.getEmail());

        TextView valueUsername = (TextView) findViewById(R.id.valueUsername);
        TextView valuePassword = (TextView) findViewById(R.id.valuePassword);
        TextView valueSalt = (TextView) findViewById(R.id.valueSalt);
        TextView valueMd5 = (TextView) findViewById(R.id.valueMd5);
        TextView valueSha1 = (TextView) findViewById(R.id.valueSha1);
        TextView valueSha256 = (TextView) findViewById(R.id.valueSha256);
        valueUsername.setText(user.getUsername());
        valuePassword.setText(user.getPassword());
        valueSalt.setText(user.getSalt());
        valueMd5.setText(user.getMd5());
        valueSha1.setText(user.getSha1());
        valueSha256.setText(user.getSha256());

        TextView valueDob = (TextView) findViewById(R.id.valueDob);
        TextView valueRegistered = (TextView) findViewById(R.id.valueRegistered);
        TextView valuePhone = (TextView) findViewById(R.id.valuePhone);
        TextView valueCell = (TextView) findViewById(R.id.valueCell);
        valueDob.setText(user.getDob());
        valueRegistered.setText(user.getRegistered());
        valuePhone.setText(user.getPhone());
        valueCell.setText(user.getCell());

        TextView valueIdName = (TextView) findViewById(R.id.valueIdName);
        TextView valueIdValue = (TextView) findViewById(R.id.valueIdValue);
        valueIdName.setText(user.getIdName());
        valueIdValue.setText(user.getIdValue());

        TextView valueNat = (TextView) findViewById(R.id.valueNat);
        valueNat.setText(user.getNat());

        ConstraintLayout userInfo = (ConstraintLayout) findViewById(R.id.userInfo);
        userInfo.setBackgroundColor(user.getGender().equals("male") ? ContextCompat.getColor(this, R.color.colorBlue) : ContextCompat.getColor(this, R.color.colorPink));
    }
}