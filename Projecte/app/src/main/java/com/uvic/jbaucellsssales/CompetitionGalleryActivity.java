package com.uvic.jbaucellsssales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uvic.jbaucellsssales.Adapters.Adapter_Competition;
import com.uvic.jbaucellsssales.Entitats.Competition;
import com.uvic.jbaucellsssales.Singleton.App_singleton;
import com.uvic.jbaucellsssales.R;
import com.uvic.jbaucellsssales.ui.login.LoginActivity;

public class CompetitionGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_gallery);

        ListView list = (ListView) findViewById(R.id.list);
        Adapter_Competition adapter = new Adapter_Competition(this, R.layout.competition, App_singleton.getInstance().getList_competition());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("AD_C8", "Test");
            }
        });

        list.setAdapter(adapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aplication_toolbar, menu);
        MenuItem item = menu.findItem(R.id.logOut);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setVisible(true);
        item = menu.findItem(R.id.profile);
        item.setVisible(true);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent i;
        switch(id){
            case R.id.logOut:
                i = new Intent(CompetitionGalleryActivity.this, LoginActivity.class);
                startActivity(i);
                return true;
            case R.id.profile:
                i = new Intent(CompetitionGalleryActivity.this, profileActivity.class);
                startActivity(i);
                return  true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    public void AddCompetition(View view){
        Intent intent = new Intent(CompetitionGalleryActivity.this, afegir_competicio.class);
        startActivity(intent);
        finish();
    }
}