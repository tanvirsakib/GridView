package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    int[] flags = {R.drawable.ban_icon,R.drawable.pak_icon,R.drawable.india_icon,R.drawable.aus_icon,
            R.drawable.nz_icon,R.drawable.eng_icon,R.drawable.sf_icon,R.drawable.wi_icon,
            R.drawable.afg_icon,R.drawable.sri_icon,R.drawable.ire_icon,R.drawable.zim_icon};

    String[] countryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);

        gridView = findViewById(R.id.gridViewID);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,countryNames,flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
