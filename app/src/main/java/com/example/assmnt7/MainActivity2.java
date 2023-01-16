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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editId;
        TextView tvfName, tvSection, tvCourse, tvMt, tvFinals;

        Button btnEdit = findViewById(R.id.editBtn);
        editId = findViewById(R.id.editID);
        tvfName = findViewById(R.id.tvfName);
        tvSection = findViewById(R.id.tvSection);
        tvCourse = findViewById(R.id.tvCourse);
        tvMt = findViewById(R.id.tvMt);
        tvFinals = findViewById(R.id.tvFinals);


        final DataManager dm = new DataManager(this);
        Intent intent = getIntent();
        editId.setText(intent.getStringExtra("ID Num"));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.update(editId.getText().toString(),tvfName.getText().toString(), tvSection.getText().toString(),
                        tvCourse.getText().toString(), tvMt.getText().toString(), tvFinals.getText().toString());
                Toast.makeText(MainActivity2.this,  editId.getText().toString() + "has been updated!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}