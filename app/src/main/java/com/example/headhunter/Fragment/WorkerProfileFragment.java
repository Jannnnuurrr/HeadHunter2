package com.example.headhunter.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.headhunter.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WorkerProfileFragment extends Fragment {
    private TextView textViewName,textViewEmail,textViewBio;
    Button btnAboutLegal,btnAboutHow;

    public WorkerProfileFragment() {}

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_profile, container, false);

        // Инициализация элементов
        btnAboutLegal = view.findViewById(R.id.btnAboutLegal);
        btnAboutLegal.setOnClickListener(v -> {
            String websiteUrl = "https://online.zakon.kz/Document/?doc_id=38910832";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            startActivity(intent);
        });

        //Открытие соответствющей ссылки для
        btnAboutHow = view.findViewById(R.id.btnAboutHow);
        btnAboutHow.setOnClickListener(v -> {
            String websiteUrl = "https://www.canva.com/create/cv/"; //Что делать если работодатель нарушает Трудовой кодекс/договор?
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            startActivity(intent);
        });

        // Инициализация элементов
        textViewName = view.findViewById(R.id.textView_name_worker_profile);
        textViewEmail = view.findViewById(R.id.textView_email_worker_profile);
        textViewBio = view.findViewById(R.id.textView_bio_worker_profile);

        return view;
    }






}
