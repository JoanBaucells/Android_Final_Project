package com.uvic.jbaucellsssales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.uvic.jbaucellsssales.Entitats.Competition;
import com.uvic.jbaucellsssales.Singleton.App_singleton;
import com.uvic.jbaucellsssales.R;

public class afegir_competicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_competicio);
    }

    public void add_competicio(View view){
        EditText editNomComp = (EditText)findViewById(R.id.nomCompeticio);
        EditText editPreuComp = (EditText)findViewById(R.id.preuCompeticio);
        EditText editPoblacioComp = (EditText)findViewById(R.id.poblacioCompeticio);
        EditText editParticipantsComp = (EditText)findViewById(R.id.participantsCompeticio);
        EditText editDataComp = (EditText)findViewById(R.id.dataCompeticio);
        EditText editDescripcioComp = (EditText)findViewById(R.id.descripcioCompeticio);
        //
        Competition c;
        int idCompeticio = App_singleton.getInstance().getNewIdCompetition();
        String Nom = editNomComp.getText().toString();
        String Descripcio = editDescripcioComp.getText().toString();
        String Poblacio = editPoblacioComp.getText().toString();
        String Data = editDataComp.getText().toString();
        int Participants = Integer.parseInt(editParticipantsComp.getText().toString());
        Float Preu = Float.parseFloat(editPreuComp.getText().toString());
        c = new Competition(idCompeticio, Nom, Descripcio, Preu, Poblacio, Data, Participants);
        App_singleton.getInstance().addCompetition(c);

        Intent intent = new Intent(afegir_competicio.this, CompetitionGalleryActivity.class);
        startActivity(intent);
        finish();
    }
}