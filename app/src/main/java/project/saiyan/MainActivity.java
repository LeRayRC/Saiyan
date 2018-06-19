package project.saiyan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;

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
                    return total;
                }
                System.out.println(total);
                total++;
            }
        }
        return total;
    }

    /*Genera un array con un orden aleatorio de numeros*/
    public int[] generar(){
        List<Integer> lista = new ArrayList<Integer>();
        int[] orden = new int [get_numero_total_profesores()];

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
