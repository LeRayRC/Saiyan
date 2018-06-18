package project.saiyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class adivinaProfesor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_profesor);

        final EditText introducir_respuesta = findViewById(R.id.respuesta);
        int res_id_nombre = getResources().getIdentifier("profesor_001","array",getPackageName());
        final String[] nombres_profesor = getResources().getStringArray(res_id_nombre);
        final ImageView imagen_1 = findViewById(R.id.imagen_profesor);
        /**
        final ImageView imagen_2 = findViewById(R.id.imagen_profesor);
        final ImageView imagen_3 = findViewById(R.id.imagen_profesor);
        final ImageView imagen_4 = findViewById(R.id.imagen_profesor);
         */
        final Toast respuesta_incorrecta = Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);

        for(int i = 3;i<7;i++) {
            int res_id = getResources().getIdentifier("telematica", "drawable", getPackageName());
            imagen_1.setImageResource(res_id);
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
    }
    public static int getResStringId(String variableName) {
        try {
            Field idField = R.string.class.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
