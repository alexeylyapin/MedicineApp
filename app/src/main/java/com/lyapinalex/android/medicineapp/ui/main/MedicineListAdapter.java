package com.lyapinalex.android.medicineapp.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyapinalex.android.medicineapp.R;
import com.lyapinalex.android.medicineapp.net.models.Result;

import java.util.LinkedList;
import java.util.List;

public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.ViewHolder> {

    private List<Result> medicines = new LinkedList<>();
    private OnItemClickListener mClickListener;


    public void addResults(List<Result> results) {
        medicines.addAll(results);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_medicine, viewGroup, false);
        return new MedicineListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        viewHolder.itemView.setOnClickListener(view -> mClickListener.onItemClicked(medicines.get(i)));
        viewHolder.medicineTradeLabel.setText(medicines.get(i).getTradeLabel().getName());
        if (medicines.get(i).getManufacturer() != null) {
            viewHolder.medicineManufacturerName.setText(medicines.get(i).getManufacturer().getName());
        } else viewHolder.medicineManufacturerName.setText("Даних немає");

    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClicked(Result medicine);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView medicineTradeLabel;
        private TextView medicineManufacturerName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineTradeLabel = itemView.findViewById(R.id.trade_label);
            medicineManufacturerName = itemView.findViewById(R.id.manufacturer_name);
        }
    }
}
