package com.uvic.jbaucellsssales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uvic.jbaucellsssales.Adapters.Adapter_Competition;
import com.uvic.jbaucellsssales.Singleton.App_singleton;
import com.uvic.jbaucellsssales.R;

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
    }

    public void AddCompetition(View view){
        Intent intent = new Intent(CompetitionGalleryActivity.this, afegir_competicio.class);
        startActivity(intent);
        finish();
    }
}