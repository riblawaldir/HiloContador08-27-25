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
    ImageView myImage2;
    ImageView myImageAmarillo1;
    ImageView myImageVerde1;
    ImageView myImageRojo1;
    ImageView myImageAmarillo2;
    ImageView myImageVerde2;
    ImageView myImageRojo2;
    private boolean encendido = false;
    private int colorActual = 0;
    private int colorActual2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_probando);
        btnHilo = findViewById(R.id.btnHilo);
        tvTextoEjemplo = findViewById(R.id.tvTextoEjemplo);


        myImageAmarillo1 = findViewById(R.id.myImageAmarillo1);
        myImageVerde1 = findViewById(R.id.myImageVerde1);
        myImageRojo1 = findViewById(R.id.myImageRojo1);
        myImageAmarillo2 = findViewById(R.id.myImageAmarillo2);
        myImageVerde2 = findViewById(R.id.myImageVerde2);
        myImageRojo2 = findViewById(R.id.myImageRojo2);

        apagartodos();

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
                                    apagartodos();
                                    myImageRojo1.setImageResource(R.drawable.foco_rojo);
                                    myImageVerde2.setImageResource(R.drawable.foco_verde);
                                }
                            });
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTextoEjemplo.setText(String.valueOf("Contador: " + dec));
                                    apagartodos();
                                    myImageAmarillo1.setImageResource(R.drawable.foco_amarillo);
                                    myImageAmarillo2.setImageResource(R.drawable.foco_amarillo);
                                }
                            });
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTextoEjemplo.setText(String.valueOf("Contador: " + dec));
                                    apagartodos();
                                    myImageVerde1.setImageResource(R.drawable.foco_verde);
                                    myImageRojo2.setImageResource(R.drawable.foco_rojo);
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

    private void apagartodos() {
        apagar1();
        apagar2();
    }

    private void apagar2() {
        myImageAmarillo2.setImageResource(R.drawable.circulitonegro);
        myImageVerde2.setImageResource(R.drawable.circulitonegro);
        myImageRojo2.setImageResource(R.drawable.circulitonegro);
    }

    private void apagar1() {
        myImageAmarillo1.setImageResource(R.drawable.circulitonegro);
        myImageVerde1.setImageResource(R.drawable.circulitonegro);
        myImageRojo1.setImageResource(R.drawable.circulitonegro);
    }
}
