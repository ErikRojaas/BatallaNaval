package com.example.myapplication.batallanaval;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que este layout tenga un TableLayout

        // Obtén la referencia al TableLayout donde se agregarán las filas.
        TableLayout tableLayout = findViewById(R.id.tableLayout);
    }
}
