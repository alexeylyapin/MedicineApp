package com.lyapinalex.android.medicineapp.ui.main.fragment_search;

import com.lyapinalex.android.medicineapp.base.BasePresenter;
import com.lyapinalex.android.medicineapp.base.BaseView;
import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public interface SearchFragmentContract {
    interface Presenter extends BasePresenter<SearchFragmentContract.View> {
        void onSearchSubmit(String searchText, INetManger netManger);
    }

    interface View extends BaseView {
        void showList(ResponseBody body);

    }
}
