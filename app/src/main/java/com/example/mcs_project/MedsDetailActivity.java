package com.example.mcs_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcs_project.data.Data;
import com.example.mcs_project.data.Medicine;
import com.example.mcs_project.data.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class MedsDetailActivity extends AppCompatActivity {

    Vector<Medicine> medicines;
    Vector<Transaction> transactions = new Vector<>();
    MedicineAdapter medicineAdapter;

    TextView name_view, manufacture_view, desc_view, price_view;
    ImageView image_view;
    EditText qty_medsDetail;

    String medsName, medsManufacture, medsDescription;
    int medsImg, medsPrice;
    String medsQty;
    Button backButton, buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_detail);
        backButton = findViewById(R.id.backButton);

        medicineAdapter = new MedicineAdapter(getApplicationContext(), medicines);

        medsName = getIntent().getStringExtra("MedsName");
        medsManufacture = getIntent().getStringExtra("MedsManufacturer");
        medsPrice = getIntent().getIntExtra("MedsPrice", 0);
        medsImg = getIntent().getIntExtra("MedsImage", 0);
        medsDescription = getIntent().getStringExtra("MedsDescription");

        getIntent().removeExtra("MedsName");
        getIntent().removeExtra("MedsManufacturer");
        getIntent().removeExtra("MedsPrice");
        getIntent().removeExtra("MedsImage");
        getIntent().removeExtra("MedsDescription");

        name_view = findViewById(R.id.title);
        manufacture_view = findViewById(R.id.medsManufacturer);
        desc_view = findViewById(R.id.medsDescription);
        price_view = findViewById(R.id.medsPrice);
        image_view = findViewById(R.id.medsImg);

        name_view.setText(medsName);
        manufacture_view.setText(medsManufacture);
        desc_view.setText(medsDescription);
        price_view.setText(String.valueOf(medsPrice));
        image_view.setImageResource(medsImg);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buyButton = findViewById(R.id.buy_medsDetail);
        qty_medsDetail = findViewById(R.id.quantity_medsDetail);
        buyButton.setOnClickListener(new View.OnClickListener() {

            DateFormat df = new SimpleDateFormat("dd MMMM yyyy, HH:mm");

            Calendar calendar = Calendar.getInstance();

            @Override
            public void onClick(View v) {
                if(qty_medsDetail.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Quantity must be filled", Toast.LENGTH_SHORT).show();
                    return;
                } else if(Integer.parseInt(qty_medsDetail.getText().toString()) == 0){
                    Toast.makeText(getApplicationContext(),"Quantity must be bigger than 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                medsQty = qty_medsDetail.getText().toString();
                transactions
                        .add(new Transaction(medsName, df.format(calendar.getTime()),
                                medsPrice, Integer.parseInt(medsQty), medsImg));
//                } else if (Transaction.medsName.equals(medsName)){
//                    Transaction.qty += medsQty;
//                }


                finish();
//                startActivity(new Intent(MedsDetailActivity.this, HomeActivity.class));
//                medsQty = getIntent().getIntExtra("medsQty", 0);
            }
        });

    }
}