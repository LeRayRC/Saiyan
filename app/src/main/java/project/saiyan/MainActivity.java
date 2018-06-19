package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /**
     *  \brief Devuelve el numero de profesores encontrados
     *  en strings.xml
     *  \return Numero total de profesores
     *  \author Adrian Rosello <creitor96@gmail.com>
     **/
    private int get_numero_total_profesores() {
        int total = 0;
        String profesor_nombres;

        for (int idx_0 = 0; idx_0 < 10; idx_0++) {
            for (int idx_1 = 0; idx_1 < 10; idx_1++) {
                profesor_nombres = "profesor_0" + idx_1 + idx_0;
                final int res_id_nombre = getResources().getIdentifier(profesor_nombres, "array", getPackageName());
                if (res_id_nombre == 0) {
                    break;
                }
                total++;
            }
        }
        return total;
    }

    /*Genera un array con un orden aleatorio de numeros*/
    public int[] generar() {
        int[] orden = new int[get_numero_total_profesores()];
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
