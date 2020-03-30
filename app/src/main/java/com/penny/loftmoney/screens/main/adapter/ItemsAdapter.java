package com.penny.loftmoney.screens.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penny.loftmoney.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ChargesViewHolder> {

    private List<ChargesModel> mDataList = new ArrayList<>();

    public List<ChargesModel> getData() {
        return mDataList;
    }

    public void setData(List<ChargesModel> newList) {
        this.mDataList = newList;
    }

    public void setNewData(List<ChargesModel> chargeModels) {
        mDataList.clear();
        mDataList.addAll(chargeModels);
        notifyDataSetChanged();
    }

    public void addNewRecord(ChargesModel chargeModel) {
        mDataList.add(chargeModel);
        notifyItemInserted(mDataList.size() - 1);
    }

    @NonNull
    @Override
    public ChargesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChargesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_change, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChargesViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ChargesViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle = itemView.findViewById(R.id.txtChargeName);
        private TextView txtValue = itemView.findViewById(R.id.txtChargeValue);

        ChargesViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(ChargesModel model) {
            txtTitle.setText(model.getName());
            txtValue.setText(model.getValue());
        }
    }
}
