package com.example.myapplication.batallanaval;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia al TableLayout en el XML
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Crear una fila extra para la cabecera (letras A-J)
        TableRow headerRow = new TableRow(this);
        headerRow.addView(createEmptyCell()); // Esquina vacía

        // Añadir las letras (A-J) en la fila de cabecera
        for (char letter = 'A'; letter <= 'J'; letter++) {
            TextView headerCell = createHeaderCell(String.valueOf(letter));
            headerRow.addView(headerCell);
        }

        tableLayout.addView(headerRow); // Agregar fila de letras al layout

        // Crear las filas del 1 al 10
        for (int i = 1; i <= 10; i++) {
            TableRow tableRow = new TableRow(this);

            // Añadir el número de la fila como cabecera lateral (1-10)
            TextView rowHeaderCell = createHeaderCell(String.valueOf(i));
            tableRow.addView(rowHeaderCell);

            // Añadir las celdas como botones
            for (int j = 1; j <= 10; j++) {
                char letter = (char) ('A' + (j - 1)); // Convertir índice a letra (A-J)
                Button cellButton = createButtonCell(letter + String.valueOf(i)); // Crear botón para la celda
                tableRow.addView(cellButton);
            }

            tableLayout.addView(tableRow); // Agregar fila al layout
        }
    }

    // Método para crear un botón para cada celda del tablero
    private Button createButtonCell(final String cellPosition) {
        Button button = new Button(this);
        button.setText("-"); // Mostrar un guion inicialmente
        button.setWidth(100);
        button.setHeight(100);
        button.setBackgroundColor(0xFFE0E0E0); // Color gris claro para las celdas
        button.setPadding(2, 2, 2, 2); // Añadir separación interna

        // Añadir listener para que al pulsar muestre la posición
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje con la posición de la celda
                Toast.makeText(MainActivity.this, "Casilla: " + cellPosition, Toast.LENGTH_SHORT).show();
            }
        });

        // Establecer los márgenes entre botones para separarlos visualmente
        TableRow.LayoutParams params = new TableRow.LayoutParams(100, 100);
        params.setMargins(5, 5, 5, 5); // Margen de 5px entre celdas
        button.setLayoutParams(params);

        return button;
    }

    // Método para crear una celda de cabecera (letras o números)
    private TextView createHeaderCell(String text) {
        TextView headerCell = new TextView(this);
        headerCell.setWidth(100);
        headerCell.setHeight(100);
        headerCell.setText(text);
        headerCell.setTextSize(20);
        headerCell.setGravity(android.view.Gravity.CENTER);
        headerCell.setBackgroundColor(0xFFADD8E6); // Color de fondo azul claro
        headerCell.setPadding(2, 2, 2, 2); // Agregar un pequeño padding
        return headerCell;
    }

    // Método para crear una celda vacía para la esquina superior izquierda
    private TextView createEmptyCell() {
        TextView emptyCell = new TextView(this);
        emptyCell.setWidth(100);
        emptyCell.setHeight(100);
        return emptyCell;
    }
}
