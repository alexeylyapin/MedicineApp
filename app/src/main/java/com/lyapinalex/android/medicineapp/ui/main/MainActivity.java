package com.lyapinalex.android.medicineapp.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.ui.main.fragment_search.SearchFragment;
import com.lyapinalex.android.medicineapp.ui.main.medicine_fragment.MedicineFragment;

public class MainActivity extends AppCompatActivity {

    private MedicineFragment mMedicineFragment = new MedicineFragment();
    private SearchFragment mSearchFragment;
    private FragmentManager mFragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(mMedicineFragment);

    }


    private void showFragment(Fragment fragment) {
        mFragmentManager
                .beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Bundle bundle = new Bundle();
                mSearchFragment = new SearchFragment();
                bundle.putString("SEARCH", s);
                mSearchFragment.setArguments(bundle);
                showFragment(mSearchFragment);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "onMenuItemActionExpand called", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "onMenuItemActionCollapse called", Toast.LENGTH_SHORT).show();
                showFragment(mMedicineFragment);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);


    }

  /*  private void medicineUploader(int type) {
        if (mAdapter.getItemCount() == 0) {
            mAdapter.clearList();
            mPresenter.clearData();
            mProgressBar.setVisibility(View.VISIBLE);
            switch (type) {
                case 1:
                    mPresenter.onLoading(((CoreApp) getApplication()).getNetManager());
                case 0:
                    mPresenter.onSearchSubmit(search, ((CoreApp) getApplication()).getNetManager());
            }
        } else {
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = mLayoutManager.getItemCount();
                    lastVisibleItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                            .findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD) && totalItemCount % 50 == 0) {
                        recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
                        mProgressBar.setVisibility(View.VISIBLE);
                        switch (type) {
                            case 1:
                                mPresenter.onLoading(((CoreApp) getApplication()).getNetManager());


                            case 0:
                                mPresenter.onSearchSubmit(search, ((CoreApp) getApplication()).getNetManager());
                        }

                    }
                }
            });

        }
    }*/




  /*  private void searchUploader(String search) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = mLayoutManager.getItemCount();
                lastVisibleItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                        .findLastVisibleItemPosition();
                if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD) && totalItemCount % 50 == 0) {
                    recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
                    mPresenter.onSearchSubmit(search, ((CoreApp) getApplication()).getNetManager());
                    mProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        mAdapter.clearList();
        mPresenter.clearData();
        mProgressBar.setVisibility(View.VISIBLE);
        mPresenter.onSearchSubmit(search, ((CoreApp) getApplication()).getNetManager());
    }*/

}