package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insert = findViewById(R.id.insertBtn);
        Button edit = findViewById(R.id.editBtn);
        Button search = findViewById(R.id.searchOne);
        Button searchAll = findViewById(R.id.allSearch);
        EditText ID,course,fName,section,mt,finals,idEdit,idDelete,searchTV;

        ID = findViewById(R.id.idInput);
        course = findViewById(R.id.courseInput);
        fName = findViewById(R.id.fNameInput);
        section = findViewById(R.id.sectionInput);
        mt = findViewById(R.id.mtInput);
        finals = findViewById(R.id.fInput);
        idEdit = findViewById(R.id.editID);
        idDelete = findViewById(R.id.deleteID);
        searchTV = findViewById(R.id.searchTV);


        final DataManager dm = new DataManager(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dm.showData(dm.searchAll());
            }
        });

    }
}