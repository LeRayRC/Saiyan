package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*Genera un array con un orden aleatorio de numeros*/
    public int[] generar() {
        int[] orden = new int[2];
        boolean existe = false;
        int selector = 1 + (int) (Math.random() * 2);

        for (int i = 0; i < orden.length; i++) {
            if (orden[i] == selector) {
                existe = true;
            }
        }

        for (int i = 0; i < orden.length; i++) {
            if (orden[i] == 0) {
                orden[i] = selector;
            }
        }
        return orden;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] orden = generar();
        final int contador = 0;

        final EditText introducir_nombre = (EditText)findViewById(R.id.nombre_jugador);
        Button boton_jugar = (Button)findViewById(R.id.iniciar_juego);

        boton_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intento = new Intent(MainActivity.this, adivinaProfesor.class);
                String nombre_jugador = introducir_nombre.getText().toString();

                intento.putExtra("Nombre",nombre_jugador);
                intento.putExtra("Orden",orden);
                intento.putExtra("Contador",contador);

                startActivity(intento);
            }
        });
    }
}
