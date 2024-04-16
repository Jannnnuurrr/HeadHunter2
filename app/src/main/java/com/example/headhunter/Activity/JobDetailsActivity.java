package com.example.headhunter.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.headhunter.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.headhunter.R;
import java.util.Objects;

public class JobDetailsActivity extends AppCompatActivity {

    private TextView mTitle, mDate, mDescription, mSkills, mSalary, mEmail;
    private Button btn_apply;
    private String uRole = "worker";
    private String email;

    // Фото компании или логотип
    private ImageView iconOfCompanyProfile;

    // TextView для показа информации о компании
    private TextView mAboutCompanyName, mAboutCompanyEmail, mAboutCompanyAddress, mAboutCompanyBio;
    private static final int PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 123;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        // Добавьте следующий код для запроса разрешений
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_READ_EXTERNAL_STORAGE);
        }
        iconOfCompanyProfile = findViewById(R.id.icon_company_profile);

        // Настройка toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_job_details);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Job Details");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Кнопка откликнуться и о компании
        btn_apply = findViewById(R.id.btn_reply);
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
                startActivity(intent);            }
        });


        // Переключатель данных с вакансии на компанию
        Switch switchAboutCompany = findViewById(R.id.switch_about_company);

        // Инициализация данных по xml
        iconOfCompanyProfile = findViewById(R.id.icon_company_profile);

        mTitle = findViewById(R.id.job_details_title);
        mDate = findViewById(R.id.job_details_date);
        mDescription = findViewById(R.id.job_details_description);
        mSalary = findViewById(R.id.job_details_salary);
        mSkills = findViewById(R.id.job_details_skills);
        mEmail = findViewById(R.id.job_details_email);

        mAboutCompanyName = findViewById(R.id.about_company_name);
        mAboutCompanyEmail = findViewById(R.id.about_company_email);
        mAboutCompanyAddress = findViewById(R.id.about_company_address);
        mAboutCompanyBio = findViewById(R.id.about_company_bio);

        // Получение данных из предыдущей активности (или фрагмента)
        Intent intent = getIntent();
        int logoImageResource = intent.getIntExtra("logoImageResource", 0);
        if (logoImageResource != 0) {
            iconOfCompanyProfile.setImageResource(logoImageResource);
        }
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String description = intent.getStringExtra("description");
        String skills = intent.getStringExtra("skills");
        String salary = intent.getStringExtra("salary");
        email = intent.getStringExtra("email");

        String mName = intent.getStringExtra("companyName");
        String mCompanyEmail = intent.getStringExtra("companyEmail");
        String mAddress = intent.getStringExtra("companyAddress");
        String mBio = intent.getStringExtra("aboutCompany");

        mTitle.setText(title);
        mDate.setText(date);
        mDescription.setText(description);
        mSkills.setText(skills);
        mSalary.setText(salary);
        mEmail.setText(email);

        mAboutCompanyName.setText(mName);
        mAboutCompanyEmail.setText(mCompanyEmail);
        mAboutCompanyAddress.setText(mAddress);
        mAboutCompanyBio.setText(mBio);

        switchAboutCompany.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                // Показать элементы для компании
                switchAboutCompany.setText("Switch to vacancy");
                iconOfCompanyProfile.setVisibility(View.VISIBLE);
                mAboutCompanyName.setVisibility(View.VISIBLE);
                mAboutCompanyEmail.setVisibility(View.VISIBLE);
                mAboutCompanyAddress.setVisibility(View.VISIBLE);
                mAboutCompanyBio.setVisibility(View.VISIBLE);

                // Сделать невидимым элементы про вакансию
                mTitle.setVisibility(View.GONE);
                mDate.setVisibility(View.GONE);
                mDescription.setVisibility(View.GONE);
                mSalary.setVisibility(View.GONE);
                mSkills.setVisibility(View.GONE);
                mEmail.setVisibility(View.GONE);

            } else {
                switchAboutCompany.setText("Switch to company");
                mTitle.setVisibility(View.VISIBLE);
                mDate.setVisibility(View.VISIBLE);
                mDescription.setVisibility(View.VISIBLE);
                mSalary.setVisibility(View.VISIBLE);
                mSkills.setVisibility(View.VISIBLE);
                mEmail.setVisibility(View.VISIBLE);

                iconOfCompanyProfile.setVisibility(View.GONE);
                mAboutCompanyName.setVisibility(View.GONE);
                mAboutCompanyEmail.setVisibility(View.GONE);
                mAboutCompanyAddress.setVisibility(View.GONE);
                mAboutCompanyBio.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }else {
                Toast.makeText(getApplicationContext(), "Permission denied. Unable to download file.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}