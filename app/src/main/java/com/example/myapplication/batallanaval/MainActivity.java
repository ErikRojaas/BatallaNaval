package com.example.myapplication.batallanaval;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ajuste para el título más arriba (si fuera necesario, se puede ajustar en XML también)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener el GridLayout que contiene el tablero
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // Recorremos todos los hijos (views) del GridLayout
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View child = gridLayout.getChildAt(i);

            // Si el hijo es un Button, le asignamos una acción de clic (vacía para que no haga nada)
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setOnClickListener(v -> {
                    // No hacer nada al hacer clic
                });
            }
        }
    }
}
