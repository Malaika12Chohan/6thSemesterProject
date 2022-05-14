package aligoldsmith.com;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import aligoldsmith.com.adapter.RecentAdapter;
import aligoldsmith.com.adapter.TopPlaceesAdapter;
import aligoldsmith.com.model.RecentsData;
import aligoldsmith.com.model.TopPlaceData;

public class MainActivity1 extends AppCompatActivity {

    RecyclerView recentReecycler, topPlaceRecycler;
    RecentAdapter recentAdapter;
    TopPlaceesAdapter topPlaceesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main1);

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Ring", "For girls ", "3000", R.drawable.ring1));
        recentsDataList.add(new RecentsData("Earing", "Earing for girls", "3000", R.drawable.earring));
        recentsDataList.add(new RecentsData("Necklace", "Necklas for girls ", "5000", R.drawable.necless1));
        recentsDataList.add(new RecentsData("Bracelet", "Bracelet for girls ", "5000", R.drawable.braslate));
        recentsDataList.add(new RecentsData("payal", "Payal for girls jewller", "3000", R.drawable.payal));
        recentsDataList.add(new RecentsData("Churian", "Churian for girls women", "5000", R.drawable.churian));
        recentsDataList.add(new RecentsData("Bridal Set", "for Bridals", "3000", R.drawable.bridet));
        setRecyclerView(recentsDataList);

        List<TopPlaceData> topPlaceDataList= new ArrayList<>();
        topPlaceDataList.add(new TopPlaceData("Silver","All our silver rings","5000", R.drawable.earing2));
        topPlaceDataList.add(new TopPlaceData("Platinum","All our diamond rings","5000", R.drawable.plateniumset));
        topPlaceDataList.add(new TopPlaceData("Gold","Gold Neeklace","8000", R.drawable.bridelset));
        topPlaceDataList.add(new TopPlaceData("Diamond","All our diamond rings","5000",R.drawable.ring1));
        topPlaceDataList.add(new TopPlaceData("Gold","All our gold rings","5000",R.drawable.goldring));
        topPlaceDataList.add(new TopPlaceData("Silver chain","All our silver chain","1000",R.drawable.silverchain));
        topPlaceDataList.add(new TopPlaceData("stock","Gold stock","50000",R.drawable.stockgold));
        topPlaceDataList.add(new TopPlaceData("Platinum","Full hand","3000",R.drawable.fullhand));
        topPlaceDataList.add(new TopPlaceData("Gold","All our diamond rings","5000",R.drawable.puredaimond));
        topPlaceDataList.add(new TopPlaceData("Diamond","All our diamond rings","5000",R.drawable.alldaimond));
        topPlaceDataList.add(new TopPlaceData("Gold","All our Gold payal","5000",R.drawable.goldpayal));


        setTopPlaceRecycler(topPlaceDataList);

    }

    private void setRecyclerView(List<RecentsData> recentsDataList) {
        recentReecycler = findViewById(R.id.recents_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentReecycler.setLayoutManager(layoutManager);
        recentAdapter = new RecentAdapter(this, recentsDataList);
        recentReecycler.setAdapter(recentAdapter);

    }

    private void setTopPlaceRecycler(List<TopPlaceData> topPlaceDataList) {
        topPlaceRecycler = findViewById(R.id.top_place_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlaceRecycler.setLayoutManager(layoutManager);
        topPlaceesAdapter = new TopPlaceesAdapter(this, topPlaceDataList);
        topPlaceRecycler.setAdapter(topPlaceesAdapter);


    }
}