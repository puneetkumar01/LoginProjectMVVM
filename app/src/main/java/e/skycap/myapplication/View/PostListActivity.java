package e.skycap.myapplication.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import e.skycap.myapplication.Adapter.PostAdapter;
import e.skycap.myapplication.Model.PostBean;
import e.skycap.myapplication.R;
import e.skycap.myapplication.ViewModel.PostViewModel;


public class PostListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter adapter;
    List<PostBean> postList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        PostViewModel model = ViewModelProviders.of(this).get(PostViewModel.class);

        model.getposts().observe(this, new Observer<List<PostBean>>() {
            @Override
            public void onChanged(@Nullable List<PostBean> postList) {
                adapter = new PostAdapter(PostListActivity.this, postList);
                recyclerView.setAdapter(adapter);
            }
        });



    }
}
