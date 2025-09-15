package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScreenAdapter extends RecyclerView.Adapter<ScreenAdapter.PageVH> {

    private final String[] titles = { "Екран 1", "Екран 2", "Екран 3" };
    private final int[] colors = { 0xFFE3F2FD, 0xFFFFFFFF, 0xFFFFF3E0 };

    @NonNull
    @Override
    public PageVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_page, parent, false);
        return new PageVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PageVH holder, int position) {
        holder.title.setText(titles[position]);
        holder.root.setBackgroundColor(colors[position]);


        holder.button.setVisibility(View.GONE);
        holder.image.setVisibility(View.GONE);


        if (position == 1) {
            holder.button.setVisibility(View.VISIBLE);
            holder.button.setOnClickListener(v -> {
                holder.image.setVisibility(View.VISIBLE);
                holder.image.setImageResource(R.drawable.screen_image);
                holder.button.setVisibility(View.GONE);
            });
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    static class PageVH extends RecyclerView.ViewHolder {
        final LinearLayout root;
        final TextView title;
        final ImageView image;
        final Button button;

        PageVH(@NonNull View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.pageRoot);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.page_image);
            button = itemView.findViewById(R.id.show_button);
        }
    }
}
