package com.example.comicbook;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.comicbook.Modelo.*;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Registro_Comic extends AppCompatActivity {


    TextView txtCodigoTipo1, txtSerialComic1, txtFechaComic1;
    Button  btnRegistrarComic, btnCancelar;
    ImageButton btnFotoSeleccion;
    EditText txtTitulo, txtEditorial, txtNumeroTomos,  txtDescripcionComic;
    Spinner spnGeneroComic, spnTipoComic;
    ImageView imgFotoComic;



    //Action Bar
    private ActionBar actionBar;
    //Permisos de la clase
    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    //Selecion de imagen
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    // matrices de permisos
    private String[] cameraPermissions;
    private String[] storagePermissions;
    //variables para guardar
    private Uri imageUri;

    //DbHelper
    private DbHelper dbHelper;






    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_comic);
        Fecha();
        CodigoComic();
        Serial();
        RegistrarComic();
        SeleccionarFoto();
    }


    public void RegistrarComic(){
        btnRegistrarComic =findViewById(R.id.btnRegistroComic);
        txtTitulo = findViewById(R.id.editTextTituloComicRegistro);
        txtEditorial = findViewById(R.id.editTextEditorialComicRegistro);
        txtNumeroTomos = findViewById(R.id.editTextNumeroTomoComicRegistro);
        txtDescripcionComic = findViewById(R.id.editTextDescripcionComicRegistro);
        spnGeneroComic =findViewById(R.id.spnGeneroRegistroComic);
        spnTipoComic = findViewById(R.id.spnTipoComicRegistro);
        txtFechaComic1 = findViewById(R.id.txtFechaComicRegistro);
        txtCodigoTipo1 = findViewById(R.id.txtCodigoTipoComicRegistro);
        txtSerialComic1 = findViewById(R.id.txtSerial_ComicRegistro);
        btnRegistrarComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comic comicActual = new Comic();
                comicActual.setSerial_Comic(txtSerialComic1.getText().toString());
                comicActual.setTitulo_Comic(txtTitulo.getText().toString());
                comicActual.setEditorial_Comic(txtEditorial.getText().toString());
                comicActual.setNumero_Tomos(Integer.parseInt(txtNumeroTomos.getText().toString()));
                comicActual.setGenero_Comic(spnGeneroComic.getSelectedItem().toString());
                comicActual.setPuntuacion(1);
                comicActual.setDescripcion(txtDescripcionComic.getText().toString());
                comicActual.setCod_tipo_Comic(txtCodigoTipo1.getText().toString());
                comicActual.setTipo_comic(spnTipoComic.getSelectedItem().toString());
                comicActual.setFecha_Publicacion(txtFechaComic1.getText().toString());
                comicActual.setSerial_Comic1(txtSerialComic1.getText().toString());
                comicActual.Guardar(Registro_Comic.this);
                comicActual.GuardarTipoComic(Registro_Comic.this);
                Toast.makeText(Registro_Comic.this, "Se registro el comic", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registro_Comic.this, Menu_Comic.class);
                startActivity(intent);
            }
        });

    }



    public void SeleccionarFoto(){
        imgFotoComic = findViewById(R.id.imgFotoComicRegistro);
        btnFotoSeleccion = findViewById(R.id.btnCargarFotoComicRegistro);
        btnFotoSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Seleccion Foto Comic"), 10);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imgFotoComic = findViewById(R.id.imgFotoComicRegistro);
        if (resultCode == RESULT_OK){
            imageUri = data.getData();
            imgFotoComic.setImageURI(imageUri);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Fecha(){
        txtFechaComic1 = findViewById(R.id.txtFechaComicRegistro);
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        txtFechaComic1.setText(formattedDate);

    }


    public void CodigoComic(){
        txtCodigoTipo1 = findViewById(R.id.txtCodigoTipoComicRegistro);
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
            txtCodigoTipo1.setText("CODTIPO-"+cadena);
            m++;
        }

    }
    public void Serial(){
        txtSerialComic1 = findViewById(R.id.txtSerial_ComicRegistro);
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
            txtSerialComic1.setText("SERIAL-"+cadena);
            m++;
        }

    }



}