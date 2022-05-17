package com.example.converterapp;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.converterapp.Currency_converter_UI.MainActivity;
import com.example.converterapp.Unit_converter_UI.MainActivity2;
import com.google.android.material.navigation.NavigationView;

public class Frontpage_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer = findViewById(R.id.drawer_layout);

    AppBarConfiguration appBarConfiguration;


    @Override
    public void setContentView(View view) {
        drawer = (DrawerLayout) getLayoutInflater().inflate(R.layout.frontpaige_main, null);
        FrameLayout container = drawer.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawer);


        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationDrawer = drawer.findViewById(R.id.nav_view);
        navigationDrawer.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

    }

    protected void allocateActivityTitle(String titleString) {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }



    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.share) {
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.profile) {
            Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.nav_convert_currency:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_convert_unit:
                startActivity(new Intent(this, MainActivity2.class));
                overridePendingTransition(0, 0);
                break;
        }

        return false;
    }
}
