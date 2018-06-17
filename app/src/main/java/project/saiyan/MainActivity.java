package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText introducir_nombre = (EditText)findViewById(R.id.nombre_jugador);
        Button boton_jugar = (Button)findViewById(R.id.iniciar_juego);

        boton_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intento = new Intent(MainActivity.this, adivinaProfesor.class);
                String nombre_jugador = introducir_nombre.getText().toString();
                Bundle b = new Bundle();
                b.putString("Nombre",nombre_jugador);

                intento.putExtras(b);

                startActivity(intento);
            }
        });
    }
}
