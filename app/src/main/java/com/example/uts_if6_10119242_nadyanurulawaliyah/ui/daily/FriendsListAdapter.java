package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Friend;

import java.util.List;


public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendViewHolder> {
    private final Context context;
    private List<Friend> friendList;

    public FriendsListAdapter(Context context){ this.context =context;}
    @SuppressLint("NotifyDataSetChanged")
    public void setFriendList(List<Friend> list){
        this.friendList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FriendsListAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_friend_rows,parent,false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsListAdapter.FriendViewHolder holder, int position) {
    holder.friendName.setText((this.friendList.get(position).friendName));
    holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.friendList.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return this.friendList.size();
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder{
        TextView friendName;
        ImageView imagename;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            friendName = itemView.findViewById(R.id.friend_recycle_name);
            imagename =itemView.findViewById(R.id.friend_recycle_image);
        }
    }
    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }
}
