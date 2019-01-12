package com.lyapinalex.android.medicineapp.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.ui.main.fragment_medicine.MedicineFragment;
import com.lyapinalex.android.medicineapp.ui.main.fragment_search.SearchFragment;

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
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                showFragment(mMedicineFragment);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);


    }

}