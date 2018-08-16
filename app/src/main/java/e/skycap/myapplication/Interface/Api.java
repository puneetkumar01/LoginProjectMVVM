package e.skycap.myapplication.Interface;

import java.util.List;

import e.skycap.myapplication.Model.PostBean;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<PostBean>> getposts();
}
