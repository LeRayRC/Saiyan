package project.saiyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class adivinaProfesor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_profesor);

        /* Generamos un int random entre 1 y 2. De momento solo hay dos profesroes */
        final int selector = 1 + (int)(Math.random()*2);

        /* Accedemos al XML. */
        final String profesor_nombres = "profesor_00" + selector;
        final String profesor_imagenes = "profesor_00" + selector + "_imagenes";
        final int res_id_nombre = getResources().getIdentifier(profesor_nombres,"array",getPackageName());
        final String[] nombres_profesor = getResources().getStringArray(res_id_nombre);
        final int res_id_imagenes = getResources().getIdentifier(profesor_imagenes,"array",getPackageName());
        final String[] imagenes_profesor = getResources().getStringArray(res_id_imagenes);

        /* Aqui introduciremos la respuesta */
        final EditText introducir_respuesta = findViewById(R.id.respuesta);

        /* Las cuatro imagenes del profesor. */
        final ImageView imagen_1 = findViewById(R.id.imagen_1);
        final ImageView imagen_2 = findViewById(R.id.imagen_2);
        final ImageView imagen_3 = findViewById(R.id.imagen_3);
        final ImageView imagen_4 = findViewById(R.id.imagen_4);

        final Toast respuesta_incorrecta = Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);

        for(int i = 0;i<imagenes_profesor.length;i++) {
            final int res_id = getResources().getIdentifier(imagenes_profesor[i], "drawable", getPackageName());
            switch (i) {
                case 0: {
                    imagen_1.setImageResource(res_id);
                    break;
                }
                case 1: {
                    imagen_2.setImageResource(res_id);
                    break;
                }
                case 2: {
                    imagen_3.setImageResource(res_id);
                    break;
                }
                case 3: {
                    imagen_4.setImageResource(res_id);
                    break;
                }
            }
        }


        Button responder = findViewById(R.id.boton_respuesta);
        responder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intento2 = new Intent(adivinaProfesor.this, adivinaProfesor.class);
                String respuesta = introducir_respuesta.getText().toString().toLowerCase();

                if(respuesta.equals(nombres_profesor[0])||respuesta.equals(nombres_profesor[1])||respuesta.equals(nombres_profesor[2])) {
                    startActivity(intento2);
                }else{
                    respuesta_incorrecta.show();
                }
            }
        });
        /* Implementacion del boton pista. Al pulsarlo se muestran las imagenes de abajo y desaparece el boton */
        final Button pista = findViewById(R.id.boton_pista);
        pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imagen_3.setVisibility(View.VISIBLE);
                imagen_4.setVisibility(View.VISIBLE);
                pista.setVisibility(View.GONE);
            }
        });
    }
}
