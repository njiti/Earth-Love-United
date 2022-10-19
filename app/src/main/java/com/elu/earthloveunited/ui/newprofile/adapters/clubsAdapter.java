package com.elu.earthloveunited.ui.newprofile.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.R;

import java.util.List;

public class clubsAdapter extends RecyclerView.Adapter<clubsAdapter.ViewHolder>{
    List<String> clubLabels;
    LayoutInflater inflater;
    public clubsAdapter(Context context, List<String> clubLabels) {
        this.clubLabels =  clubLabels;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.club_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.clubLabel.setText(clubLabels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.clubCard.setBackgroundResource(R.drawable.green_rounded_corner);
                holder.clubLabel.setTextColor(Color.parseColor("#7AF2AA"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubLabels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView clubLabel;
        CardView clubCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clubLabel = itemView.findViewById(R.id.clubLabel);
            clubCard=itemView.findViewById(R.id.clubCard);
        }


    }
}
