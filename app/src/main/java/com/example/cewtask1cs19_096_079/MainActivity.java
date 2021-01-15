package com.example.cewtask1cs19_096_079;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText et_first_name;
    EditText et_last_name;
    EditText et_gender;
    EditText et_date_of_birth;
    EditText et_email_id;
    EditText et_password;
    EditText et_confirm_password;
    ArrayList<EditText> edit_texts = new ArrayList<>();
    Button btn_signup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_gender = (EditText) findViewById(R.id.et_gender);
        et_date_of_birth = (EditText) findViewById(R.id.et_date_of_birth);
        et_email_id = (EditText)findViewById(R.id.et_email_id);
        et_password = (EditText) findViewById(R.id.et_password);
        et_confirm_password = (EditText) findViewById(R.id.et_confirm_password);
        btn_signup = (Button) findViewById(R.id.btn_signup);

        edit_texts.add(et_first_name);
        edit_texts.add(et_last_name);
        edit_texts.add(et_gender);
        edit_texts.add(et_date_of_birth);
        edit_texts.add(et_email_id);
        edit_texts.add(et_password);
        edit_texts.add(et_confirm_password);

        }

    public void onSignupButtonClick(View view) {

        // Check if any edit text is empty
        for (EditText et: edit_texts)
        {
            if (et.getText().toString().equals(""))
            {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Check if email is valid (using Regex)
        String email_id = et_email_id.getText().toString();
        String email_regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(email_id);
        if (! matcher.matches())
        {
            Toast.makeText(MainActivity.this, "Please enter a valid email id",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if both passwords match
        String password1 = et_password.getText().toString();
        String password2 = et_confirm_password.getText().toString();
        if (! password1.equals(password2))
        {
            Toast.makeText(MainActivity.this, "Passwords don't match. Please re-enter",
                    Toast.LENGTH_SHORT).show();
            et_password.setText("");
            et_confirm_password.setText("");
            return;
        }


        // If all above checks pass
        String first_name = et_first_name.getText().toString();
        String last_name = et_last_name.getText().toString();
        Toast.makeText(MainActivity.this,
                "You have successfully signed up, " + first_name + " " + last_name + "!",
                Toast.LENGTH_LONG).show();

        for (EditText et: edit_texts)
        {
            et.setText("");
        }




    }
}