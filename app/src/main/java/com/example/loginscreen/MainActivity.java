package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText Email;
    EditText Password;
    String Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email=findViewById(R.id.editTextTextEmailAddress);
        Password=findViewById(R.id.editTextTextPassword);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButtonMale:
                if (checked)
                    Gender="Male";
                    break;
            case R.id.radioButtonFemale:
                if (checked)
                    Gender="Female";
                    break;
        }
    }


    public void SubmitClicked(View view) {


        SharedPreferences sharedPreferences = getSharedPreferences("LoginApp",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", Email.getText().toString());
        myEdit.putString("Password", Password.getText().toString());
        myEdit.putString("Gender",Gender.toString());
        myEdit.commit();

    }
}