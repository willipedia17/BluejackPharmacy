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
import android.widget.Toast;

import com.example.mcs_project.R;
import com.example.mcs_project.MedicineAdapter;
import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Medicine;

import java.util.Vector;

public class HomeFragment extends Fragment {

    private Vector<Medicine> medicines = new Vector<>();
    private RecyclerView medsRecycler;


    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(Data.medicinesList.isEmpty()){
            dataInitialize();
        }

        medsRecycler = view.findViewById(R.id.medsRV);
        medsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        medsRecycler.setHasFixedSize(true);

        MedicineAdapter medicineAdapter = new MedicineAdapter(getContext(), medicines);
        medsRecycler.setAdapter(medicineAdapter);


    }


    private void dataInitialize() {

        medicines.add(new Medicine
                (R.drawable.panadol, "Panadol 500 mg 10 kaplet", "Sterling", 14000, "PANADOL merupakan obat dengan kandungan Paracetamol yang dapat digunakan untuk meringankan rasa sakit pada sakit kepala, sakit gigi, sakit pada otot dan menurunkan demam."));
        medicines.add(new Medicine
                (R.drawable.favipiravir, "Favipiravir", "Generic Manufacturer", 211200, "Favipiravir merupakan obat antivirus influenza. Obat ini digunakan untuk pengobatan influenza ketika obat antivirus influenza lainnya tidak efektif."));
        medicines.add(new Medicine
                (R.drawable.oskadon, "Oskadon", "Supra Ferbindo Farma", 2300, "OSKADON adalah obat yang di gunakan sebagai penurun demam dan pereda nyeri seperti sakit gigi, sakit kepala dan nyeri ringan lainnya."));
        medicines.add(new Medicine
                (R.drawable.hufagrip, "Hufagrip Flu & Batuk Sirup 60 ml", "Gratia Husada Farma", 25400, "HUFAGRIP FLU & BATUK merupakan obat yang mengandung Paracetamol, Chlorpeniramin Maleat, Pseudoefedrin HCl dan Guaifenesin."));
        medicines.add(new Medicine
                (R.drawable.byebyefever, "Bye Bye Fever Anak 1 Lembar", "Hisamitsu", 14500, "BYE BYE FEVER ANAK merupakan plester yang digunakan pada anak untuk meringankan efek tidak nyaman karena demam, sakit gigi, sakit kepala. "));
        medicines.add(new Medicine
                (R.drawable.vicksformula44, "Vicks Formula 44 Sirup 100 ml", "Darya Varia Laboratoria", 14500, "VICKS FORMULA 44 SIRUP merupakan Sirup Obat Batuk dengan kombinasi formula Dextromethorphan HBr dan Doxylamine Succinate untuk meringankan batuk yang tidak berdahak disertai bersin-bersin/ alergi."));

    }
}