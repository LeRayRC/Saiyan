package project.saiyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adivinaProfesor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivina_profesor);

        final EditText introducir_respuesta = findViewById(R.id.respuesta);
        final String[] respuesta_correcta = getResources().getStringArray(R.array.profesor_001);
        final Toast respuesta_incorrecta = Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);

        Button responder = findViewById(R.id.boton_respuesta);
        responder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intento2 = new Intent(adivinaProfesor.this, adivinaProfesor.class);
                String respuesta = introducir_respuesta.getText().toString().toLowerCase();

                if(respuesta.equals(respuesta_correcta[0])||respuesta.equals(respuesta_correcta[1])||respuesta.equals(respuesta_correcta[2])) {
                    startActivity(intento2);
                }else{
                    respuesta_incorrecta.show();
                }
            }
        });

    }
}
