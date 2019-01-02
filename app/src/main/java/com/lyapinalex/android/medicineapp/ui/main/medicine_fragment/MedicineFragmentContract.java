package com.lyapinalex.android.medicineapp.ui.main.medicine_fragment;

import com.lyapinalex.android.medicineapp.base.BasePresenter;
import com.lyapinalex.android.medicineapp.base.BaseView;
import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public interface MedicineFragmentContract {
    interface Presenter extends BasePresenter<View>{
        void onLoading(INetManger netManger);
    }

     interface View extends BaseView {
        void showList(ResponseBody body);

    }
}
