package com.nemge.ppe;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {
    SQLiteDatabasePPE db;
    EditText nameInput, passwordInput;
    Button button_add, button_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        db = new SQLiteDatabasePPE(this);

        nameInput = findViewById(R.id.Name_EditText);
        passwordInput= findViewById(R.id.Password_EditText);
        button_add = findViewById(R.id.Data_Button);
        AddData();
        button_show = findViewById(R.id.Show_Button);
        ViewData();
    }

    public void AddData(){
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db. insertData(nameInput.getText().toString(), passwordInput.getText().toString());
                if(isInserted){
                    Toast.makeText(SQLiteActivity.this, "Data is inserted sucessfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SQLiteActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ViewData(){
        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor data = db.getData();
                if(data.getCount()==0){

                    return;
                }
                else{
                    StringBuffer buffer = new StringBuffer();
                    while(data.moveToNext()){
                        buffer.append("ID :" + data.getString(0)+ "\n ");
                        buffer.append("NAME :" + data.getString(1)+ "\n ");
                        buffer.append("PASSWORD :" + data.getString(2)+ "\n ");
                    }
                    showMessage("Data", buffer.toString());
                }
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}