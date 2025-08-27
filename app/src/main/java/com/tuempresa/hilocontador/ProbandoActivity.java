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
    private int colorActual = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_probando);
        btnHilo = findViewById(R.id.btnHilo);
        tvTextoEjemplo = findViewById(R.id.tvTextoEjemplo);
        myImage = findViewById(R.id.myImage);





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

                                    switch (colorActual) {
                                        case 0:
                                            myImage.setImageResource(R.drawable.foco_rojo);
                                            break;
                                        case 1:
                                            myImage.setImageResource(R.drawable.foco_amarillo);
                                            break;
                                        case 2:
                                            myImage.setImageResource(R.drawable.foco_verde);
                                            break;
                                    }
                                    colorActual = (colorActual + 1) % 3;
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
