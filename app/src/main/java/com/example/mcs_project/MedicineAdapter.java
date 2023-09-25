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
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Medicine;

import java.util.Vector;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
    Context ctx;
    static Vector<Medicine> meds;
    static LinearLayout linearLayout;

    public MedicineAdapter(Context ctx, Vector<Medicine> meds) {
        this.ctx = ctx;
        this.meds = meds;
    }

    @NonNull
    @Override
    public MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.medicine_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.ViewHolder holder, int position) {

        Medicine medicine = meds.get(position);

        holder.medsName.setText(medicine.medsName);
        holder.medsPrice.setText(String.valueOf(medicine.medsPrice));
        holder.medsManufacture.setText(medicine.medsManufacture);
        holder.medsImg.setImageResource(medicine.medsImg);

        linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MedsDetailActivity.class);
            intent.putExtra("MedsName", medicine.medsName);
            intent.putExtra("MedsManufacturer", medicine.medsManufacture);
            intent.putExtra("MedsImage", medicine.medsImg);
            intent.putExtra("MedsPrice", medicine.medsPrice);
            intent.putExtra("MedsDescription", medicine.medsDescription);

            ctx.startActivity(intent);

            intent.removeExtra("MedsName");
            intent.removeExtra("MedsManufacturer");
            intent.removeExtra("MedsPrice");
            intent.removeExtra("MedsImage");
            intent.removeExtra("MedsDescription");
        });

    }

    @Override
    public int getItemCount() {
        return meds.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView medsImg;
        TextView medsName, medsPrice, medsManufacture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.meds_item);
            medsImg = itemView.findViewById(R.id.itemImage_home);
            medsName = itemView.findViewById(R.id.itemName_home);
            medsPrice = itemView.findViewById(R.id.itemPrice_home);
            medsManufacture = itemView.findViewById(R.id.itemManufacture_home);
        }
    }
}
