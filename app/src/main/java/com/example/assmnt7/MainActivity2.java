package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnEdit;
    EditText editId;
    TextView idNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnEdit = findViewById(R.id.btnEdit);
        editId = findViewById(R.id.editId);
        idNum = findViewById(R.id.idNum);

        final DataManager dm = new DataManager(this);
        Intent intent = getIntent();
        idNum.setText(intent.getStringExtra("ID NUMBER"));
        editId.setText(intent.getStringExtra("ID Num"));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.update(idNum.getText().toString(), editId.getText().toString());
                Toast.makeText(MainActivity2.this,  idNum.getText().toString() + "has been updated!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}