package com.penny.loftmoney.screens.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.penny.loftmoney.R;
import com.penny.loftmoney.screens.additem.AddItemActivity;
import com.penny.loftmoney.screens.main.adapter.ChargeDiffUtils;
import com.penny.loftmoney.screens.main.adapter.ChargesModel;
import com.penny.loftmoney.screens.main.adapter.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class BudgetFragment extends Fragment {

    private ItemsAdapter itemsAdapter = new ItemsAdapter();
    public static int NEW_RECORD = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerMain);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        view.findViewById(R.id.fabMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyDiffUtils();
                Intent intent = new Intent(getActivity(), AddItemActivity.class);
                startActivityForResult(intent, NEW_RECORD);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_RECORD && resultCode == Activity.RESULT_OK && data != null) {
            ChargesModel chargeModel = (ChargesModel) data.getSerializableExtra(ChargesModel.KEY_NAME);
            itemsAdapter.addNewRecord(chargeModel);
        }
    }

    private void applyDiffUtils() {
        List<ChargesModel> testList = new ArrayList<>();
        testList.add(new ChargesModel("500 P", "House"));
        testList.add(new ChargesModel("200 P", "Children"));
        testList.add(new ChargesModel("300 P", "Cat"));
        testList.add(new ChargesModel("150 P", "Bills"));


        ChargeDiffUtils productDiffUtilCallback = new ChargeDiffUtils(itemsAdapter.getData(), testList);
        DiffUtil.DiffResult productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback);

        itemsAdapter.setData(testList);
        productDiffResult.dispatchUpdatesTo(itemsAdapter);
    }


}
