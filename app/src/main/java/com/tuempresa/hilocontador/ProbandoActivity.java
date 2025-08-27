package com.tuempresa.hilocontador;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class ProbandoActivity extends AppCompatActivity {
    Button btnHilo;
    TextView tvTextoEjemplo;
    ImageView myImage;
    ImageView myImageAmarillo;
    ImageView myImageVerde;
    ImageView myImageRojo;
    private boolean encendido = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_probando);
        btnHilo = findViewById(R.id.btnHilo);
        tvTextoEjemplo = findViewById(R.id.tvTextoEjemplo);

        myImageAmarillo = findViewById(R.id.myImageAmarillo);
        myImageVerde = findViewById(R.id.myImageVerde);
        myImageRojo = findViewById(R.id.myImageRojo);


        btnHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            final int dec = i;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTextoEjemplo.setText(String.valueOf("Contador: " + dec));

                                    if (encendido) {
                                        myImageAmarillo.setImageResource(R.drawable.foco_negro);
                                        myImageVerde.setImageResource(R.drawable.foco_negro);
                                        myImageRojo.setImageResource(R.drawable.foco_negro);
                                    } else if (!encendido) {

                                        myImageAmarillo.setImageResource(R.drawable.foco_rojo);
                                        myImageVerde.setImageResource(R.drawable.foco_amarillo);
                                        myImageRojo.setImageResource(R.drawable.foco_verde);
                                    }

                                    encendido = !encendido;
                                }
                            });
                            try {
                                Thread.sleep(5000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }
                });
                hilo.start();
            }
        });
    }
}
