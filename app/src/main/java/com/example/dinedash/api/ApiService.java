package com.example.dinedash.api;
import com.example.dinedash.model.MenuItem;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;
public interface ApiService {
    @GET("menus")
    Call<List<MenuItem>> getMenuItems();
}
