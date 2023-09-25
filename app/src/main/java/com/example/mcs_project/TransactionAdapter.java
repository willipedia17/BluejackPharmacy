package com.example.mcs_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Transaction;
import com.example.mcs_project.fragment.TransactionFragment;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    Context ctx;
    Vector<Transaction> transactions = new Vector<>();

    public TransactionAdapter(Context ctx, Vector<Transaction> transactions) {
        this.ctx = ctx;
        this.transactions = transactions;
    }


    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.transaction_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {

        Transaction transaction = transactions.get(position);

        holder.dateTrans.setText(Transaction.transDate);
        holder.itemName.setText(Transaction.medsName);
        holder.itemQty.setText(String.valueOf(Transaction.qty));
        holder.itemPrice.setText(String.valueOf(Transaction.price));
        holder.itemImage.setImageResource(Transaction.img);

//        holder.layout.setOnClickListener(v ->{
//            Intent intent = new Intent(v.getContext(), TransactionFragment.class);
//
//            intent.putExtra("MedsName", transaction.medsName);
//            intent.putExtra("transDate", transaction.transDate);
//            intent.putExtra("totalPrice", transaction.price);
//            intent.putExtra("qty", transaction.qty);
////            intent.putExtra("img", transaction.img);
//
//            ctx.startActivity(intent);
//
//            intent.removeExtra("MedsName");
//            intent.removeExtra("transDate");
//            intent.removeExtra("totalPrice");
//            intent.removeExtra("qty");
////            intent.removeExtra("img");
//        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateTrans, itemName, itemPrice, itemQty;
        ImageView itemImage;

        public ViewHolder(View view) {
            super(view);

            dateTrans = view.findViewById(R.id.transDate);
            itemImage = view.findViewById(R.id.itemImage_trans);
            itemName = view.findViewById(R.id.itemName_trans);
            itemPrice = view.findViewById(R.id.itemPrice_trans);
            itemQty = view.findViewById(R.id.itemQty_trans);
        }
    }
}
