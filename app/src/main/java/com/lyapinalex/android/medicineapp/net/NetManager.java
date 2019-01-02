package com.lyapinalex.android.medicineapp.net;

import com.lyapinalex.android.medicineapp.net.models.ResponseBody;
import com.lyapinalex.android.medicineapp.net.models.Result;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager implements INetManger {
    public static final String BASE_URL = "https://api.pills-prod.sdh.com.ua/";
    private Retrofit mRetrofit;
    private MedicineApi mApi;

    public NetManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = mRetrofit.create(MedicineApi.class);
    }

    @Override
    public Single<ResponseBody> getResponse(int pageNumber) {
        return mApi.getBody(pageNumber).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<Result> getMedicine(String id) {
        return mApi.getMedicine(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<ResponseBody> getSearchResult(int pageNumber, String searchText) {
        return mApi.getSearchResult(pageNumber, searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
