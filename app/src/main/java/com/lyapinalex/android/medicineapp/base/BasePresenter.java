package com.lyapinalex.android.medicineapp.base;

import com.lyapinalex.android.medicineapp.net.INetManger;

public interface BasePresenter<T extends BaseView> {
    void attachView(T view );

    void detachView();
}
