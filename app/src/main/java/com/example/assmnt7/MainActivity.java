package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.insert(ID.getText().toString(),fName.getText().toString(),course.getText().toString(),section.getText().toString(),mt.getText().toString(),finals.getText().toString());
                Toast.makeText(MainActivity.this,fName.getText().toString()+ " has been inserted!", Toast.LENGTH_LONG).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dm.showData(dm.searchAll());
                Toast.makeText(MainActivity.this, data,Toast.LENGTH_SHORT).show();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppData editData;
                editData = dm.editId(dm.searchAll());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("ID Num", editData.getId().toString());
                startActivity(intent);

            }
        });

    }
}