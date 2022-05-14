package aligoldsmith.com;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Categories extends AppCompatActivity {
    ImageView backbtn;
    CardView goldcard;
    Button btngold,btnsilver,btndiamond,btncopper, btnplatenium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        backbtn=findViewById(R.id.back);
        goldcard=findViewById(R.id.gold);
        btngold=findViewById(R.id.btngold);
        btnsilver=findViewById(R.id.btnsilver);
        btndiamond=findViewById(R.id.btndiamond);
        btncopper=findViewById(R.id.btncopper);
        btnplatenium=findViewById(R.id.btnplatenium);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categories.super.onBackPressed();
            }
        });
        goldcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btngold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bsf = new BottomSheetFragment();
                bsf.show(getSupportFragmentManager(),bsf.getTag());
            }
        });
        btnsilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bsf = new BottomSheetFragment();
                bsf.show(getSupportFragmentManager(),bsf.getTag());
            }
        });
        btndiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bsf = new BottomSheetFragment();
                bsf.show(getSupportFragmentManager(),bsf.getTag());
            }
        });
        btncopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bsf = new BottomSheetFragment();
                bsf.show(getSupportFragmentManager(),bsf.getTag());
            }
        });
        btnplatenium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bsf = new BottomSheetFragment();
                bsf.show(getSupportFragmentManager(),bsf.getTag());
            }
        });
    }
}