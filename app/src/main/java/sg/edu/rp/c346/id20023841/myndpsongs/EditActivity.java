package sg.edu.rp.c346.id20023841.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    EditText etSongTitle, etSongSinger, etSongYear;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etSongSinger = findViewById(R.id.etSingersName);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSongYear = findViewById(R.id.etModifiedYear);
        btnCancel = findViewById(R.id.buttonCancel);
        btnDelete = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);

        Intent i = getIntent();
        Song song = (Song) i.getSerializableExtra("song");

    }
}