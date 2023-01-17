package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        Button deleteBtn = findViewById(R.id.deleteBtn);
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
            public void onClick(View v) {
                Integer midterms = Integer.valueOf(mt.getText().toString());
                Integer finalg = Integer.valueOf(finals.getText().toString());

                if (midterms < 60) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                } else if (midterms > 100) {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();

                } else if (finalg < 60) {

                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                } else if (finalg > 100) {

                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                } else {


                    Integer grade = (Integer.valueOf(mt.getText().toString()) + Integer.valueOf(finals.getText().toString())) / 2;
                    String fgrade = Integer.toString(grade);
                    dm.insert(ID.getText().toString(),
                            fName.getText().toString(),
                            course.getText().toString(),
                            section.getText().toString(),
                            mt.getText().toString(),
                            finals.getText().toString(),
                            fgrade
                    );
                    Toast.makeText(MainActivity.this, fName.getText().toString() + " has been inserted!", Toast.LENGTH_LONG).show();
                }
            }
        });

        searchAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);

                intent.putExtra("showall",dm.showData(dm.searchAll()).toString());
                Toast.makeText(MainActivity.this, "Loading Data...",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppData editData;
                editData = dm.editId(dm.searchAll());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("IDnum", editData.getId().toString());
                intent.putExtra("name", editData.getNAME().toString());
                intent.putExtra("course", editData.getCourse().toString());
                intent.putExtra("section", editData.getSection().toString());
                intent.putExtra("midterm", editData.getMidterm().toString());
                intent.putExtra("finals", editData.getFinals().toString());

                startActivity(intent);

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.delete(idDelete.getText().toString());
                Toast.makeText(MainActivity.this, idDelete.getText().toString()+ " has been deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dm.showData(dm.search(searchTV.getText().toString()));
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

    }
}