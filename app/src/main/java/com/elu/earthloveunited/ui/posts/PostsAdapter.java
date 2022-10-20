package com.elu.earthloveunited.ui.posts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elu.earthloveunited.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyHolder> {

    Context context;
    String myuid;
    private DatabaseReference liekeref, postref;
    boolean mprocesslike = false;

    public PostsAdapter(Context context, List<Post> modelPosts) {
        this.context = context;
        this.modelPosts = modelPosts;
        myuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        liekeref = FirebaseDatabase.getInstance().getReference().child("Likes");
        postref = FirebaseDatabase.getInstance().getReference().child("Posts");
    }

    List<Post> modelPosts;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_layout, parent, false);
        return new MyHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, @SuppressLint("RecyclerView") final int position) {
        final String uid = modelPosts.get(position).getUid();
        String nameh = modelPosts.get(position).getUname();
        final String descri = modelPosts.get(position).getDescription();
        final String ptime = modelPosts.get(position).getPtime();
        String dp = modelPosts.get(position).getUdp();
        String plike = modelPosts.get(position).getPlike();
        final String image = modelPosts.get(position).getUimage();
        String email = modelPosts.get(position).getUemail();
        String comm = modelPosts.get(position).getPcomments();
        final String pid = modelPosts.get(position).getPtime();
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(Long.parseLong(ptime));
        String timedate = DateFormat.format("hh:mm aa", calendar).toString();
        holder.name.setText(nameh);
        holder.description.setText(descri);
        holder.time.setText(timedate);
        holder.like.setText(plike + " Likes");
        holder.comments.setText(comm + " Comments");
        setLikes(holder, ptime);
        try {
            Picasso.get().load(dp).placeholder(R.drawable.face_prof).into(holder.image);
//            Picasso.with(context).load(user!!.getImage()).placeholder(R.drawable.face).into(profileImage)
//            Glide.with(context).load(dp).into(holder.image);
        } catch (Exception e) {

        }
//        holder.image.setVisibility(View.VISIBLE);
        try {
            Glide.with(context).load(image).into(holder.picture);
        } catch (Exception e) {

        }
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(holder.itemView.getContext(), PostLikedByActivity.class);
//                intent.putExtra("pid", pid);
//                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.likeicn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int plike = Integer.parseInt(modelPosts.get(position).getPlike());
                mprocesslike = true;
                final String postid = modelPosts.get(position).getPtime();
                liekeref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (mprocesslike) {
                            if (dataSnapshot.child(postid).hasChild(myuid)) {
                                postref.child(postid).child("plike").setValue("" + (plike - 1));
                                liekeref.child(postid).child(myuid).removeValue();
                                mprocesslike = false;
                            } else {
                                postref.child(postid).child("plike").setValue("" + (plike + 1));
                                liekeref.child(postid).child(myuid).setValue("Liked");
                                mprocesslike = false;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
//        holder.comment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, PostDetailsActivity.class);
//                intent.putExtra("pid", ptime);
//                context.startActivity(intent);
//            }
//        });
    }

    private void setLikes(final MyHolder holder, final String pid) {
        liekeref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(pid).hasChild(myuid)) {
                    holder.likeicn.setImageResource(R.drawable.ic_action_name);
//                    holder.likeicn.setTe = "Liked";
//                    holder.likeicn.setText("Liked");
                } else {
                    holder.likeicn.setImageResource(R.drawable.outld_like);
//                    holder.likeicn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like, 0, 0, 0);
//                    holder.likeicn.setText("Like");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelPosts.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView picture, likeicn, commentsicn;
        CircleImageView image;
        TextView name, time, description, like, comments;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.post_image_home);
            image = itemView.findViewById(R.id.publisher_profile_image_post);
            name = itemView.findViewById(R.id.publisher_user_name_post);
            time = itemView.findViewById(R.id.time);
            description = itemView.findViewById(R.id.caption);
            like = itemView.findViewById(R.id.likes);
            comments = itemView.findViewById(R.id.comments);
            likeicn = itemView.findViewById(R.id.post_image_like_btn);
            commentsicn = itemView.findViewById(R.id.post_image_comment_btn);
        }
    }
}
