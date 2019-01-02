package com.lyapinalex.android.medicineapp.net;

import com.lyapinalex.android.medicineapp.net.models.ResponseBody;
import com.lyapinalex.android.medicineapp.net.models.Result;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MedicineApi {
    @GET("/v1/medicine")
    Single<ResponseBody> getBody(@Query("page") int pageNumber);

    @GET("/v1/medicine/{id}")
    Single<Result> getMedicine(@Path("id") String id);

    @GET("/v1/medicine/")
    Single<ResponseBody> getSearchResult(@Query("page") int pageNumber, @Query("search") String searchText);
}
