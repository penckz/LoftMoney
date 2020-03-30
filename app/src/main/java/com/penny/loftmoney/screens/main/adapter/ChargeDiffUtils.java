package com.penny.loftmoney.screens.main.adapter;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class ChargeDiffUtils extends DiffUtil.Callback {

    private final List<ChargesModel> oldList;
    private final List<ChargesModel> newList;

    public ChargeDiffUtils(List<ChargesModel> oldList, List<ChargesModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        boolean isTitlesSame = oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
        boolean isValuesSame = oldList.get(oldItemPosition).getValue().equals(newList.get(newItemPosition).getValue());
        return isTitlesSame && isValuesSame;
    }
}
