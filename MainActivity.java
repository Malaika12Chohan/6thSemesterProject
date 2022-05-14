package aligoldsmith.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Silver Ring  ",getString(R.string.SilverDes), R.drawable.ring1));
        modelList.add(new Model("Platinum","(Out of stock)", R.drawable.plateniumset));
        modelList.add(new Model("Neckless ",getString(R.string.GoldDes), R.drawable.necless1));
        modelList.add(new Model("Diamond ","Not Available",R.drawable.bridelset));
        modelList.add(new Model("Gold ",getString(R.string.GoldDes),R.drawable.goldring));
        modelList.add(new Model("Silver chain ", getString(R.string.SilverDes),R.drawable.silverchain));
        modelList.add(new Model("Platinum ","(Out of stock)",R.drawable.fullhand));
        modelList.add(new Model("Ring ",getString(R.string.GoldDes),R.drawable.puredaimond));
        modelList.add(new Model("Bridal Set ", getString(R.string.GoldDes), R.drawable.bridet));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }
}