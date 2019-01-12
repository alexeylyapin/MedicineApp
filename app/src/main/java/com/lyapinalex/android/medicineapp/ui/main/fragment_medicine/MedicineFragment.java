package com.lyapinalex.android.medicineapp.ui.main.fragment_medicine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lyapinalex.android.medicineapp.base.BaseFragment;
import com.lyapinalex.android.medicineapp.core.CoreApp;
import com.lyapinalex.android.medicineapp.ui.main.fragment_utils.FragmentContract;
import com.lyapinalex.android.medicineapp.ui.main.fragment_utils.MedicineListAdapter;

import java.util.Objects;

public class MedicineFragment extends BaseFragment implements FragmentContract.View, MedicineListAdapter.OnItemClickListener {


    private boolean loading = false;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        initScrollListener();

    }

    private void initScrollListener() {

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = mLayoutManager.getItemCount();
                int lastVisibleItem = ((LinearLayoutManager) Objects.requireNonNull(mRecyclerView.getLayoutManager())).findLastVisibleItemPosition();
                int VISIBLE_THRESHOLD = 1;
                if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD) && totalItemCount % 50 == 0) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPresenter.onLoading(((CoreApp) Objects.requireNonNull(getActivity()).getApplication()).getNetManager());
                }
            }
        });
        mProgressBar.setVisibility(View.VISIBLE);
        mPresenter.onLoading(((CoreApp) Objects.requireNonNull(getActivity()).getApplication()).getNetManager());
    }


}
