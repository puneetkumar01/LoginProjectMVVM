package e.skycap.myapplication.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import e.skycap.myapplication.Model.PostBean;
import e.skycap.myapplication.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.HeroViewHolder> {

    Context mCtx;
    List<PostBean> postlist;

    public PostAdapter(Context mCtx, List<PostBean> postlist) {
        this.mCtx = mCtx;
        this.postlist = postlist;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
       
      
        holder.textView.setText(postlist.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

       
        TextView textView;

        public HeroViewHolder(View itemView) {
            super(itemView);

            
            textView = itemView.findViewById(R.id.txtName);
        }
    }
}