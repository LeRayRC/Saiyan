package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        Intent intento = getIntent();
        final String nombre_jugador = intento.getStringExtra("Nombre");
        final TextView texto = findViewById(R.id.mensaje_fin);
        texto.setText("Enhorabuena "+ nombre_jugador +"\n ¡HAS GANADO!" );

        Button boton_fin = (Button)findViewById(R.id.button_fin);

        boton_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intento = new Intent(Fin.this, MainActivity.class);

                startActivity(intento);
                finish();
            }
        });
    }
}
