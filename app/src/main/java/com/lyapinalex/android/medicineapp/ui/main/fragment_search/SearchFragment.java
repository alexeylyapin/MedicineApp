package com.lyapinalex.android.medicineapp.ui.main.fragment_search;

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
import android.widget.Toast;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.core.CoreApp;
import com.lyapinalex.android.medicineapp.net.models.ResponseBody;
import com.lyapinalex.android.medicineapp.net.models.Result;
import com.lyapinalex.android.medicineapp.ui.description_activity.MedicineActivity;
import com.lyapinalex.android.medicineapp.ui.main.MedicineListAdapter;

import java.util.Objects;

public class SearchFragment extends Fragment implements SearchFragmentContract.View, MedicineListAdapter.OnItemClickListener {

    public static final String TAG = "SEARCH";
    private static final String MED_ID = "MEDICINE ID";
    private RecyclerView mRecyclerView;
    private MedicineListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchFragmentPresenter mPresenter;
    private ProgressBar mProgressBar;
    private boolean loading = false;

    @Nullable
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
        mPresenter = new SearchFragmentPresenter();
        mPresenter.attachView(this);
        String search = getArguments().getString(TAG);
        mProgressBar.setVisibility(View.VISIBLE);
        medicineUploader(search);

    }

    private void medicineUploader(String search) {

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int totalItemCount = mLayoutManager.getItemCount();
                int lastVisibleItem = ((LinearLayoutManager) Objects.requireNonNull(mRecyclerView.getLayoutManager())).findLastVisibleItemPosition();
                int VISIBLE_THRESHOLD = 1;
                if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD) && totalItemCount % 50 == 0) {

                    loading = true;
                    mProgressBar.setVisibility(View.VISIBLE);

                    mPresenter.onSearchSubmit(search, ((CoreApp) Objects.requireNonNull(getActivity()).getApplication()).getNetManager());


                }
            }
        });

        loading = false;
        mProgressBar.setVisibility(View.VISIBLE);
        mPresenter.onSearchSubmit(search, ((CoreApp) Objects.requireNonNull(getActivity()).getApplication()).getNetManager());
    }

    @Override
    public void showList(ResponseBody body) {
        mAdapter.setOnItemClickListener(this);
        mAdapter.addResults(body.getResults());
        mAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(Result medicine) {
        openDescription(medicine);
    }

    private void openDescription(Result medicine) {
        Intent intent = new Intent(getActivity(), MedicineActivity.class);
        intent.putExtra(MED_ID, medicine.getId().toString());
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}

