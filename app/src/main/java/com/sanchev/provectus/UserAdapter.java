package com.sanchev.provectus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private int layoutResourceId;

    private static final String LOG_TAG = "UserAdapter";

    UserAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        layoutResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        try {
            User user = getItem(position);
            View view;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(layoutResourceId, null);
            } else {
                view = convertView;
            }

            Picasso.
                    with(context).
                    load(user != null ? user.getPictureThumbnail() : null).
                    into((ImageView)view.findViewById(R.id.pictureThumbnail));

            assert user != null;
            ((TextView) view.findViewById(R.id.nameTitle)).setText(user.getNameTitle());
            ((TextView) view.findViewById(R.id.nameFirst)).setText(user.getNameFirst());
            ((TextView) view.findViewById(R.id.nameLast)).setText(user.getNameLast());

            view.setBackgroundColor(user.getGender().equals("male") ? ContextCompat.getColor(context, R.color.colorBlue) : ContextCompat.getColor(context, R.color.colorPink));

            return view;
        } catch (Exception ex) {
            Log.e(LOG_TAG, "error", ex);
            return null;
        }
    }
}