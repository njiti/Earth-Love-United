package com.elu.earthloveunited.ui.newprofile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.R;

import java.util.ArrayList;
import java.util.List;

public class InterestsRecyclerviewAdapter extends RecyclerView.Adapter<InterestsRecyclerviewAdapter.ViewHolder> {
    List<String> interestLabels;
    List<Integer> images;
    LayoutInflater inflater;

    public ArrayList<String> labels;
    public InterestsRecyclerviewAdapter(Context context, List<Integer> images, List<String> interestLabels) {
        this.images = images;
        this.interestLabels = interestLabels;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.interest_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InterestsRecyclerviewAdapter.ViewHolder holder, int position) {
        holder.interestImage.setImageResource(images.get(position));
        holder.interestLabel.setText(interestLabels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.interestCard.setBackgroundResource(R.drawable.green_rounded_corner);
            }
        });
    }



    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView interestLabel;
        ImageView interestImage;
        CardView interestCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            interestLabel = itemView.findViewById(R.id.imageLabel);
            interestImage = itemView.findViewById(R.id.interestLabel);
            interestCard=itemView.findViewById(R.id.interestCard);
        }


    }
}
