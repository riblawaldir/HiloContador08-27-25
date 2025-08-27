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
    private boolean encendido = false;
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

                                    if (encendido) {
                                        myImage.setImageResource(R.drawable.circulitonegro);
                                    } else {
                                        myImage.setImageResource(R.drawable.foco_rojo);
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
