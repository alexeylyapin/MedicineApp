package com.lyapinalex.android.medicineapp.ui.description_activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.core.CoreApp;
import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.models.Result;

import java.util.Objects;

public class MedicineActivity extends AppCompatActivity {
    private static final String MED_ID = "MEDICINE ID";


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_medicine);
        INetManger netManger = ((CoreApp) getApplication()).getNetManager();
        netManger.getMedicine(getIntent().getStringExtra(MED_ID)).subscribe(this::onSuccess, this::onFailure);


    }

    private void onFailure(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }


    private void onSuccess(Result result) {
        TextView label = findViewById(R.id.trade_label);
        TextView manufacturerName = findViewById(R.id.manufacturer_name);
        TextView packagingDescr = findViewById(R.id.packging_descr);
        TextView composition_descr = findViewById(R.id.composition_descr);
        TextView composition_inn = findViewById(R.id.composition_inn);
        TextView composotion_pharm_form = findViewById(R.id.composition_pharm_form);
        label.setText(result.getTradeLabel().getName());
        if (result.getManufacturer() != null) {
            manufacturerName.setText(result.getManufacturer().getName());
        } else {
            manufacturerName.setText(R.string.no_data);
        }

        packagingDescr.setText(result.getPackaging().getDescription());
        composition_descr.setText(result.getComposition().getDescription());
        composition_inn.setText(result.getComposition().getInn().getName());
        composotion_pharm_form.setText(result.getComposition().getPharmForm().getName());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
