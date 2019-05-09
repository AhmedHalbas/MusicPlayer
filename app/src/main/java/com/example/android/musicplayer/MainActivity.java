package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_POSITION = "position";
    public static ArrayList<MySong> songs;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<MySong>();

        songs.add(new MySong(R.drawable.a5retelsha2awa, R.raw.a5retelsha2awa, "A5ret El Sha2awa", "Mekky & El Leesy", "Single Song"));
        songs.add(new MySong(R.drawable.aghlamnelya2oot, R.raw.aghlamnelya2oot, "A3'la Mn El Ya2oot", "Mekky", "Single Song"));
        songs.add(new MySong(R.drawable.elnoormakanofel2loob, R.raw.elnoormakanofel2loob, "El Noor Makano Fel 2loob", "Medhat Saleh", "Amir El Zalam Movie"));
        songs.add(new MySong(R.drawable.easymoney, R.raw.easymoney, "Easy Money", "Sharmoofers", "Bank El Haz Movie"));
        songs.add(new MySong(R.drawable.to2a3wt2oom, R.raw.to2a3wt2oom, "To2a3 W T2oom", "Engy El Atraby", "Torab El Maas Movie"));
        songs.add(new MySong(R.drawable.coconut, R.raw.coconut, "Coconut", "Sharmoofers", "Single Song"));
        songs.add(new MySong(R.drawable.thenightwemet, R.raw.thenightwemet, "The Night We Met", "Lord Huron", "13 Reasons Why Series"));
        songs.add(new MySong(R.drawable.ne2abelnas, R.raw.ne2abelnas, "Ne2abel Naas", "Loay", "Kalam 3la Wra2 Series"));
        songs.add(new MySong(R.drawable.daryyaalby, R.raw.daryya2alby, "Dary Ya 2alby", "Hamza Namira", "Hateer Mn Tany"));
        songs.add(new MySong(R.drawable.el7alagat, R.raw.el7alagat, "El 7ala Gat", "El Madfa3gya", "5alsana B Shyaka Series"));


        MyAdapter adapter = new MyAdapter(this, songs);

        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);


                intent.putExtra(MainActivity.KEY_POSITION, Parcels.wrap(songs.get(i)));

                startActivity(intent);



            }
        });


    }


}
