package sg.edu.rp.c346.id20023841.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText etSongTitle, etSongSinger, etSongYear, etSongID;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgStars;
    Song song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etSongID = findViewById(R.id.etSongID);
        etSongSinger = findViewById(R.id.etSingersName);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSongYear = findViewById(R.id.etModifiedYear);
        btnCancel = findViewById(R.id.buttonCancel);
        btnDelete = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);
        rgStars = findViewById(R.id.rgStars);

        Intent i = getIntent();
        song = (Song) i.getSerializableExtra("song");

        etSongID.setText(song.get_id() + "");
        etSongTitle.setText(song.getTitle());
        etSongSinger.setText(song.getSingers());
        etSongYear.setText(song.getYear() + "");

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(song.get_id());

                finish();

            }

        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}