package com.uvic.jbaucellsssales.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uvic.jbaucellsssales.Entitats.Competition;
import com.uvic.jbaucellsssales.R;

import java.util.List;

public class Adapter_Competition extends ArrayAdapter<Competition> {
        public int resourceId;
        public Adapter_Competition (Context context, int resource, List<Competition> objects) {
            super(context, resource, objects);
            this.resourceId = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //Obtenim l'objecte a partir de la posició
            Competition competition = getItem(position);

            //Comprovar si s'està reutilitzant una vista existent, en cas contrari inflar la vista
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(this.resourceId, parent, false);
            }

            //Obtenim instancies dels elements
            TextView tCompName = (TextView)convertView.findViewById(R.id.txtCompName);
            TextView tCompParticipants = (TextView)convertView.findViewById(R.id.txtCompParticipants);

            //Obtenim la instancia del Joc en la posicio actual
            tCompName.setText(competition.getName().toString());
            tCompParticipants.setText(Integer.toString(competition.getMaxInscrits()));

            //Tonrem al ListView la fila creada
            return convertView;
        }
}
