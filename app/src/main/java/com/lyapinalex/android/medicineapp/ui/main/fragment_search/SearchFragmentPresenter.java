package com.lyapinalex.android.medicineapp.ui.main.fragment_search;

import android.annotation.SuppressLint;

import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public class SearchFragmentPresenter implements SearchFragmentContract.Presenter {
    private SearchFragmentContract.View mView;
    private int searchPageNumber = 1;


    @SuppressLint("CheckResult")
    @Override
    public void onSearchSubmit(String searchText, INetManger netManger) {

        netManger.getSearchResult(searchPageNumber, searchText).subscribe(this::onSuccess, this::onFailure);
        searchPageNumber++;

    }

    private void onFailure(Throwable throwable) {
        mView.showMessage(throwable.getMessage());
    }

    private void onSuccess(ResponseBody body) {
        if (mView == null) return;

        mView.showList(body);
    }

    @Override
    public void attachView(SearchFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
