package com.example.achar.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button saludo, saludo2, bimagen;
    TextView Texto;
    ImageView imagen;
    private  Bitmap imagenDescargada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludo = (Button)findViewById(R.id.button3);
        saludo2 = (Button)findViewById(R.id.button4);
        bimagen = (Button)findViewById(R.id.button5);
        Texto = (TextView)findViewById(R.id.lblSaludar);
        imagen = (ImageView)findViewById(R.id.imageView);

        saludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texto.setText("Hola GitHub");
                Toast.makeText(MainActivity.this, "se cambio el mensaje del textview", Toast.LENGTH_SHORT ).show();
            }
        });

        saludo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texto.setText("Diplomado Android");
                Toast.makeText(MainActivity.this, "se cambio el mensaje del textview", Toast.LENGTH_SHORT ).show();
            }
        });

        bimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new DescargarImagen().execute(new URL("https://vignette.wikia.nocookie.net/toontown/images/8/8a/Toontown_Online_Game_Screenshot_Toons.png/revision/latest?cb=20131125005304"));
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    class DescargarImagen extends AsyncTask<URL, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                imagenDescargada = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            }catch (Exception e){
                Log.e("diplo", "Error");
            }
            return  imagenDescargada;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imagen.setImageBitmap(imagenDescargada);
            super.onPostExecute(bitmap);
        }
    }

}
