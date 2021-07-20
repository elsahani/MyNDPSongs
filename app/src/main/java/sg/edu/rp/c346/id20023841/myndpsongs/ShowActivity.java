package sg.edu.rp.c346.id20023841.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    Button btnFilter;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        DBHelper dbh = new DBHelper(ShowActivity.this);

        btnFilter = findViewById(R.id.buttonFilter);
        lv = findViewById(R.id.lvSongs);

        al = new ArrayList<Song>();
        al.addAll(dbh.getAllSongs());
        aa = new ArrayAdapter<>(ShowActivity.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        aa.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Song song = al.get(position);
                Intent i = new Intent(ShowActivity.this,
                        EditActivity.class);
                i.putExtra("song", song);
                startActivity(i);
            }
        });

    }

}