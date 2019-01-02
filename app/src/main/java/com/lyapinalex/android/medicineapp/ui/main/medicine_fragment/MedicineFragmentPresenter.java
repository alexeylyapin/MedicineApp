package com.lyapinalex.android.medicineapp.ui.main.medicine_fragment;

import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;

public class MedicineFragmentPresenter implements MedicineFragmentContract.Presenter {
    private MedicineFragmentContract.View mView = null;
    private int medicinePageNumber = 1;


    @Override
    public void onLoading(INetManger netManger) {

        netManger.getResponse(medicinePageNumber).subscribe(this::OnSuccess, this::onFailure);
        medicinePageNumber++;

    }

    private void onFailure(Throwable throwable) {
        mView.showMessage(throwable.getMessage());
    }

    private void OnSuccess(ResponseBody body) {

        if (mView == null) return;
        mView.showList(body);
    }

    @Override
    public void attachView(MedicineFragmentContract.View view) {
        mView = view;
    }


    @Override
    public void detachView() {
        mView = null;
    }
}
