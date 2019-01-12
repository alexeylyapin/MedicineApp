package com.lyapinalex.android.medicineapp.ui.main.fragment_utils;

import com.lyapinalex.android.medicineapp.base.BasePresenter;
import com.lyapinalex.android.medicineapp.base.BaseView;
import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public interface FragmentContract {
    interface Presenter extends BasePresenter<View> {
        void onLoading(INetManger netManger);

        void onSearchSubmit(String searchText, INetManger netManger);
    }

    interface View extends BaseView {
        void showList(ResponseBody body);

    }
}
