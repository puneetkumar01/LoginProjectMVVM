package e.skycap.myapplication.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import e.skycap.myapplication.Interface.Api;
import e.skycap.myapplication.Model.PostBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PostViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<PostBean>> PostList;

    //we will call this method to get the data
    public LiveData<List<PostBean>> getposts() {
        //if the list is null
        if (PostList == null) {
            PostList = new MutableLiveData<List<PostBean>>();
            
            
            //we will load it asynchronously from server in this method
            loadPosts();
        }

        //finally we will return the list
        return PostList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<PostBean>> call = api.getposts();


        call.enqueue(new Callback<List<PostBean>>() {


            @Override
            public void onResponse(Call<List<PostBean>> call, Response<List<PostBean>> response) {
                PostList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostBean>> call, Throwable t) {

            }
        });
    }
}