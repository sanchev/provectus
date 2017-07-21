package com.sanchev.provectus;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import com.squareup.picasso.Picasso;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    Context context;
    OnClickListener onClickListener;
    List<User> users;

    UserAdapter(Context context, OnClickListener onClickListener, List<User> users) {
        this.context = context;
        this.onClickListener = onClickListener;
        this.users = users;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);
        view.setOnClickListener(onClickListener);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = users.get(position);
        Picasso.
                with(context).
                load(user.getPictureThumbnail()).
                into(holder.getPictureThumbnail());
        holder.
                setBackgroundColor(user.getGender().equals("male") ? ContextCompat.getColor(context, R.color.colorBlue) : ContextCompat.getColor(context, R.color.colorPink)).
                setNameTitle(user.getNameTitle()).
                setNameFirst(user.getNameFirst()).
                setNameLast(user.getNameLast());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}