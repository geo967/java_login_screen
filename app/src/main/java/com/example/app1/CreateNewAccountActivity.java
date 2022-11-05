package com.example.app1;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.Calendar;

public class CreateNewAccountActivity extends AppCompatActivity {

    EditText name,dob,email,mobile;
    TextView age;
    Spinner spin;
    Button submit;
    String[] sex={"male","female","others"};
    int mYear,mMonth,mDay,mage;
    int dobYear,dobMonth,dobDay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_account_creation);

        name = findViewById(R.id.name_editText);
        dob = findViewById(R.id.date_picker_editText);
        age = findViewById(R.id.age_textView);
        spin = findViewById(R.id.sex_spinner);

        ArrayAdapter<String> adapt= new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, sex);
        spin.setAdapter(adapt);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),sex[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        email = findViewById(R.id.mail_editText);
        mobile = findViewById(R.id.mobile_no_editText);
        submit = findViewById(R.id.submit_button);


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void openCalender(View view){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view1, year, monthOfYear, dayOfMonth) -> {
                    String dateToSetText=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    dobYear=year;
                    dobMonth=monthOfYear+1;
                    dobDay=dayOfMonth;
                    mage = mYear - dobYear;
                    if (dobMonth > mMonth) {
                        mage--;
                    } else if (mMonth == dobMonth) {
                        if (dobDay > mDay) {
                            mage--;
                        }
                    }
                    String ageForText="Age:"+mage;
                    age.setText(ageForText);
                    dob.setText(dateToSetText);



                }, mYear, mMonth, mDay);
        datePickerDialog.show();


        int mage = mYear - dobYear;

        if (dobMonth > mMonth) {
            mage--;
        } else if (mMonth == dobMonth) {
            if (dobDay > mDay) {
                mage--;
            }
        }
        String ageForText="Age:"+mage;
        age.setText(ageForText);
    }

    public void saveData(View view){
        name = findViewById(R.id.name_editText);
        mobile = findViewById(R.id.mobile_no_editText);
        Database db=new Database();
        db.setLoginDetails(name.getText().toString().trim(),mobile.getText().toString().trim());
        finish();
    }

}
