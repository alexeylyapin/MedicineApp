package com.lyapinalex.android.medicineapp.net;

import com.lyapinalex.android.medicineapp.net.models.ResponseBody;
import com.lyapinalex.android.medicineapp.net.models.Result;

import io.reactivex.Single;

public interface INetManger {

    Single<ResponseBody> getResponse(int pageNumber);

    Single<Result> getMedicine(String id);

    Single<ResponseBody> getSearchResult(int pageNumber, String searchText);

}
