package com.lyapinalex.android.medicineapp.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;
import com.lyapinalex.android.medicineapp.net.models.Result;
import com.lyapinalex.android.medicineapp.ui.description_activity.MedicineActivity;
import com.lyapinalex.android.medicineapp.ui.main.fragment_utils.FragmentPresenter;
import com.lyapinalex.android.medicineapp.ui.main.fragment_utils.MedicineListAdapter;

public class BaseFragment extends Fragment implements MedicineListAdapter.OnItemClickListener {
    public static final String TAG = "SEARCH";
    private static final String MED_ID = "MEDICINE ID";
    protected RecyclerView mRecyclerView;
    protected MedicineListAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected FragmentPresenter mPresenter;
    protected ProgressBar mProgressBar;

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressBar = view.findViewById(R.id.progressBar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new MedicineListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mPresenter = new FragmentPresenter();
        mProgressBar.setVisibility(View.VISIBLE);

    }

    public void openDescription(Result medicine) {
        Intent intent = new Intent(getActivity(), MedicineActivity.class);
        intent.putExtra(MED_ID, medicine.getId().toString());
        startActivity(intent);
    }


    public void showList(ResponseBody body) {
        mAdapter.setOnItemClickListener(this);
        mAdapter.addResults(body.getResults());
        mAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }


    public void showMessage(String msg) {
        mProgressBar.setVisibility(View.GONE);
    }

    public void onItemClicked(Result medicine) {
        openDescription(medicine);
    }

    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
