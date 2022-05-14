package aligoldsmith.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationBar extends AppCompatActivity {
BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new Dashboard()).commit();

        bnv=(BottomNavigationView) findViewById(R.id.bottomnavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment temp=null;
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:temp=new Dashboard();
                    break;
                    case R.id.nav_search:temp=new serch();
                    break;
                    case R.id.nav_profile: Intent intent = new Intent(NavigationBar.this, UserProfile.class);
                        startActivity(intent);
                        return true;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,temp).commit();
                return true;
            }
        });



    }




}