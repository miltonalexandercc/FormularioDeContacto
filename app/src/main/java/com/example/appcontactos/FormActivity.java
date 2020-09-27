package com.example.appcontactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private String dateText;
    private TextInputEditText date;
    private Button siguiente;
    private Contact contact;

    private TextView tvInfoNombre;
    private TextView tvInfoFecha;
    private TextView tvInfoTelefono;
    private TextView tvInfoEmail;
    private TextView tvInfoDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        date = (TextInputEditText) findViewById(R.id.editDate);
        siguiente = (Button) findViewById(R.id.btnSiguiente);

        inicialize();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            contact = (Contact) bundle.getSerializable(getResources().getString(R.string.keyContacto));
            showData();
        }
    }

    public void showData() {
        tvInfoNombre = (TextView) findViewById(R.id.editNombreCompleto);
        tvInfoFecha = (TextView) findViewById(R.id.editDate);
        tvInfoTelefono = (TextView) findViewById(R.id.editTelefono);
        tvInfoEmail = (TextView) findViewById(R.id.editEmail);
        tvInfoDescripcion = (TextView) findViewById(R.id.editDescripcion);

        tvInfoNombre.setText(contact.getNombre());
        tvInfoFecha.setText(contact.getFecha());
        tvInfoTelefono.setText(contact.getTelefono());
        tvInfoEmail.setText(contact.getEmail());
        tvInfoDescripcion.setText(contact.getDescripcion());
    }

    public void showDatePicker() {
        DatePickerDialog datePicker = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePicker.show();
    }

    public void goToNetx() {
        Intent intent = new Intent(getApplicationContext(), ConfirmData.class);
        intent.putExtra(getResources().getString(R.string.keyContacto), contact);
        startActivity(intent);
        finish();
    }

    public void saveData() {
        TextInputLayout nombre = (TextInputLayout) findViewById(R.id.labelNombreCompleto);
        TextInputLayout email = (TextInputLayout) findViewById(R.id.labelEmail);
        TextInputLayout telefono = (TextInputLayout) findViewById(R.id.labelTelefono);
        TextInputLayout descripcion = (TextInputLayout) findViewById(R.id.labelDescripcion);

        contact = new Contact(nombre.getEditText().getText().toString(),
                dateText,
                email.getEditText().getText().toString(),
                telefono.getEditText().getText().toString(),
                descripcion.getEditText().getText().toString());
    }

    public void inicialize() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                goToNetx();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateText = month + 1 + "/" + dayOfMonth + "/" + year;
        date.setText(dateText);
    }

}