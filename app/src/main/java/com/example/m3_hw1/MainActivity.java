package com.example.m3_hw1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.m3_hw1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.emailButton.setOnClickListener(view -> {
            String email = binding.edEmail.getText().toString();
            String emailSubject = binding.edSubject.getText().toString();
            String emailBody = binding.edMessage.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailBody);
            intent.setType("message/rfc822");

            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
        binding.screenbutton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityImage.class);
            intent.putExtra("image", R.drawable.image);
            MainActivity.this.startActivity(intent);

        });

    }
}