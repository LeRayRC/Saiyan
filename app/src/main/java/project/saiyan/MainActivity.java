package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    /*Genera un array con un orden aleatorio de numeros*/
    public int[] generar(){
        List<Integer> lista = new ArrayList<Integer>();
        int[] orden = new int [2];

        for (int i=0;i<orden.length;i++){
            lista.add(i+1);
        }

        Collections.shuffle(lista);

        for(int i=0;i<lista.size();i++){
            orden[i] = lista.get(i);
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

                Bundle b = new Bundle();
                b.putString("Nombre",nombre_jugador);
                b.putIntArray("Orden",orden);
                b.putInt("Contador",contador);

                intento.putExtras(b);

                startActivity(intento);

            }
        });
    }
}
