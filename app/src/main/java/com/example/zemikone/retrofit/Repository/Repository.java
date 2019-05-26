package com.example.zemikone.retrofit.Repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.zemikone.retrofit.ApplicationConstants;
import com.example.zemikone.retrofit.Interface.DataResultInterface;
import com.example.zemikone.retrofit.Model.Request;
import com.example.zemikone.retrofit.Model.ApiResponse;
import com.example.zemikone.retrofit.Services.API;
import com.example.zemikone.retrofit.Services.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private Context context;
    private API api;

    public Repository setContext(Context context){
        this.context=context;
        api = APIClient.getClient(context);
        return this;
    }

    public Repository() {
    }


    //Get as a Object

//    public void getRecipesList(final DataResultInterface dataResultInterface, String searchSrting){
//        api.getRecipes(new Request(ApplicationConstants.API_KEY, searchSrting)).enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//
//                dataResultInterface.dataReceived(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//
//                dataResultInterface.dataFailed();
//            }
//        });
//    }


//    public void getRecipesList(final DataResultInterface dataResultInterface, String searchSrting) {
//        Call<ApiResponse> call2 = api.getRecipes(ApplicationConstants.API_KEY, searchSrting);
//        call2.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//
//                dataResultInterface.dataReceived(response.body());
//
//            }
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                dataResultInterface.dataFailed();
//            }
//        });
//    }



    ////////////////////////////  OR  /////////////////////////////////////


    public void getRecipesList(final DataResultInterface dataResultInterface, String searchSrting) {
        api.getRecipes(ApplicationConstants.API_KEY, searchSrting).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                dataResultInterface.dataReceived(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                dataResultInterface.dataFailed();
            }
        });
    }
}
