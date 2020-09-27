package com.example.appcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmData extends AppCompatActivity {

    private TextView tvInfoNombre;
    private TextView tvInfoFecha;
    private TextView tvInfoTelefono;
    private TextView tvInfoEmail;
    private TextView tvInfoDescripcion;

    private Button siguiente;

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_data);

        Bundle bundle = getIntent().getExtras();
        contact = (Contact) bundle.getSerializable(getResources().getString(R.string.keyContacto));
        siguiente = (Button) findViewById(R.id.btnEditarDatos);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNetx();
            }
        });
        showData();
    }

    public void showData(){
        tvInfoNombre = (TextView) findViewById(R.id.tvInfoNombre);
        tvInfoFecha = (TextView) findViewById(R.id.tvInfoDate);
        tvInfoTelefono = (TextView) findViewById(R.id.tvInfoTelefono);
        tvInfoEmail = (TextView) findViewById(R.id.tvInfoEmail);
        tvInfoDescripcion = (TextView) findViewById(R.id.tvInfoDescripcion);

        tvInfoNombre.setText(contact.getNombre());
        tvInfoFecha.setText(contact.getFecha());
        tvInfoTelefono.setText(contact.getTelefono());
        tvInfoEmail.setText(contact.getEmail());
        tvInfoDescripcion.setText(contact.getDescripcion());
    }


    public void goToNetx() {
        Intent intent = new Intent(ConfirmData.this, FormActivity.class);
        intent.putExtra(getResources().getString(R.string.keyContacto), contact);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}