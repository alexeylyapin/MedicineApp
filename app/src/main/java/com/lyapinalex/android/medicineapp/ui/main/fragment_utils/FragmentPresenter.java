package com.lyapinalex.android.medicineapp.ui.main.fragment_utils;

import android.annotation.SuppressLint;

import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public class FragmentPresenter implements FragmentContract.Presenter {
    private FragmentContract.View mView = null;
    private int medicinePageNumber = 1;
    private int searchPageNumber = 1;


    @SuppressLint("CheckResult")
    @Override
    public void onLoading(INetManger netManger) {

        netManger.getResponse(medicinePageNumber).subscribe(this::OnSuccess, this::onFailure);
        medicinePageNumber++;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onSearchSubmit(String searchText, INetManger netManger) {
        netManger.getSearchResult(searchPageNumber, searchText).subscribe(this::OnSuccess, this::onFailure);
        searchPageNumber++;

    }

    private void onFailure(Throwable throwable) {
        mView.showMessage(throwable.getMessage());
    }

    private void OnSuccess(ResponseBody body) {
        if (mView == null) return;
        mView.showList(body);
    }

    @Override
    public void attachView(FragmentContract.View view) {
        mView = view;
    }


    @Override
    public void detachView() {
        mView = null;
    }
}
