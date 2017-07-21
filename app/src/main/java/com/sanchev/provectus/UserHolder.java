package com.sanchev.provectus;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserHolder extends RecyclerView.ViewHolder {

    CircleImageView pictureThumbnail;
    TextView nameTitle;
    TextView nameFirst;
    TextView nameLast;

    public UserHolder(View itemView) {
        super(itemView);
        pictureThumbnail = itemView.findViewById(R.id.pictureThumbnail);
        nameTitle = itemView.findViewById(R.id.nameTitle);
        nameFirst = itemView.findViewById(R.id.nameFirst);
        nameLast = itemView.findViewById(R.id.nameLast);
    }

    public CircleImageView getPictureThumbnail() {
        return pictureThumbnail;
    }

    public UserHolder setNameTitle(String nameTitle) {
        this.nameTitle.setText(nameTitle);
        return this;
    }

    public UserHolder setNameFirst(String nameFirst) {
        this.nameFirst.setText(nameFirst);
        return this;
    }

    public UserHolder setNameLast(String nameLast) {
        this.nameLast.setText(nameLast);
        return this;
    }

    public UserHolder setBackgroundColor(int color) {
        this.itemView.setBackgroundColor(color);
        return this;
    }


}