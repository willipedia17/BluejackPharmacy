package com.example.mcs_project.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcs_project.R;
import com.example.mcs_project.TransactionAdapter;
import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Transaction;

import java.util.Vector;

public class TransactionFragment extends Fragment {

    Vector<Transaction> transactions = new Vector<>();
    RecyclerView transRV;

    public TransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        transRV = view.findViewById(R.id.transactionRV);

        TransactionAdapter transactionAdapter = new TransactionAdapter(getContext(), Data.transactionsList);
        transRV.setAdapter(transactionAdapter);

        transRV.setLayoutManager(new LinearLayoutManager(getContext()));
        transRV.setHasFixedSize(true);
    }
}