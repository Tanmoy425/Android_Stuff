package com.example.colchesterguide;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    ItemAdapter(@NonNull Context context, @NonNull ArrayList<Item> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item currentItem = getItem(position);          assert currentItem != null;
        View listItemView = convertView;

        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item, parent, false);

        LinearLayout linearLayout = listItemView.findViewById(R.id.custom_list_item_layout);
        ImageView imageView = listItemView.findViewById(R.id.list_image);
        TextView titleTextView = listItemView.findViewById(R.id.list_title);
        TextView textTextView = listItemView.findViewById(R.id.list_text);

        if (!currentItem.isLink()) {
            imageView.setImageResource(currentItem.getImage());
            titleTextView.setText(currentItem.getTitle());
            textTextView.setText(currentItem.getText());
        } else {
            imageView.setVisibility(View.GONE);
            textTextView.setVisibility(View.GONE);
            titleTextView.setMovementMethod(LinkMovementMethod.getInstance());

            linearLayout.setPadding(24, 64, 24, 12);
            titleTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        return listItemView;
    }
}
