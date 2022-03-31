package com.example.comicbook;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicbook.Modelo.DbHelper;
import com.example.comicbook.Modelo.Persona;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Registro_Usuario extends AppCompatActivity {

    TextView txtCodigo, txtFechaRegistro1;
    DbHelper db;
    ImageView fotoPerfil;
    ImageButton btnCargarFoto;
    Button btnRegistrarse;
    EditText txtNick_Name, txtNombre, txtApellido, txtFecha, txtCorreo, txtContrasenia;
    Spinner spnTipoPersona;

    private Uri imageUri;



    public void SelecionFoto(){
        fotoPerfil = findViewById(R.id.imgFotoPerfilRegistro);
        btnCargarFoto = findViewById(R.id.btnCargaFotoRegistroPersona);
        btnCargarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Seleccion una Foto perfil"), 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fotoPerfil = findViewById(R.id.imgFotoPerfilRegistro);
        if (resultCode == RESULT_OK){
            imageUri = data.getData();
            fotoPerfil.setImageURI(imageUri);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_persona);
        Fecha();
        Codigo();
        guardar();
        SelecionFoto();
    }


    public void guardar(){
        btnRegistrarse = findViewById(R.id.btnRegistrarPersona);
        txtNick_Name = findViewById(R.id.editTextNickNameRegistro);
        txtNombre = findViewById(R.id.editTextNombreRegisrto);
        txtApellido = findViewById(R.id.editTextApellidoRegistro);
        txtFecha = findViewById(R.id.editTextFechaNacimientoRegistro);
        txtCorreo = findViewById(R.id.editTextTextEmailAddress);
        txtContrasenia = findViewById(R.id.editTextTextPassword);
        spnTipoPersona = findViewById(R.id.spnTipoPersonaRegistro);
        txtCodigo = findViewById(R.id.txtCodigoTipoPersona);
        txtFechaRegistro1 = findViewById(R.id.txtFechaRegistroPersona);
        db = new DbHelper(this, "baseComicSql", null, 1);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String NickName = txtNick_Name.getText().toString();
                String Nombre = txtNombre.getText().toString();
                String Apellido = txtApellido.getText().toString();
                String Fecha = txtFecha.getText().toString();
                String Correo = txtCorreo.getText().toString();
                String Pass = txtContrasenia.getText().toString();


                if(NickName.equals(" ") || Nombre.equals(" ") || Apellido.equals(" ") || Fecha.equals(" ")|| Correo.equals(" ") || Pass.equals(" ")){
                    Toast.makeText(Registro_Usuario.this, "Existen Campos Vacios", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean validacion_usuario = db.ValidacionUsuario(NickName);
                    if (validacion_usuario==false){
                        Persona personaActual = new Persona();
                        personaActual.setNick_Name(txtNick_Name.getText().toString());
                        personaActual.setNombre(txtNombre.getText().toString());
                        personaActual.setApellido(txtApellido.getText().toString());
                        personaActual.setEdad(CalcularFecha(txtFecha.getText().toString()));
                        personaActual.setCorreo_Electronico(txtCorreo.getText().toString());
                        personaActual.setPassword(txtContrasenia.getText().toString());
                        personaActual.setCod_Tipo_Persona(txtCodigo.getText().toString());
                        personaActual.setTipo_Persona(spnTipoPersona.getSelectedItem().toString());
                        personaActual.setFecha_Creacion(txtFecha.getText().toString());
                        personaActual.setNick_Name2(txtNick_Name.getText().toString());
                        personaActual.guardar(Registro_Usuario.this);
                        personaActual.GuardarTipo(Registro_Usuario.this);
                        Toast.makeText(Registro_Usuario.this, "Persona Creada", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Registro_Usuario.this, MainActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(Registro_Usuario.this, "Registro Fallido", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int CalcularFecha(String fechaNacimiento){
        int edad;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        edad = periodo.getYears();

        return edad;
    }







    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Fecha(){
        txtFechaRegistro1 = findViewById(R.id.txtFechaRegistroPersona);
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        txtFechaRegistro1.setText(formattedDate);

    }


    public void Codigo(){
        txtCodigo = findViewById(R.id.txtCodigoTipoPersona);
        Random random = new Random();
        String abecedario = "ABCDEFGHIJKMOPRSTUVWXYZ";
        String cadena = "";
        int m=0, pos=0, num;
        while(m<1){
            pos=(int) (random.nextDouble()*abecedario.length()-1+0);
            num=(int) (random.nextDouble()*9999+1000);
            cadena=cadena+abecedario.charAt(pos)+num;
            pos=(int) (random.nextDouble()*abecedario.length()-1+0);
            cadena=cadena+abecedario.charAt(pos);
            txtCodigo.setText("CODTIPO-"+cadena);
            m++;
        }

    }

}