package devandroid.tyago.appgaseta.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.tyago.appgaseta.R;
import devandroid.tyago.appgaseta.apoio.UtilGasEta;


public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;
    TextView txtResultado;

    Button btnCalcular;
    Button btnLimparc;
    Button btnSalvarc;
    Button btnFinalizar;


    // UtilGasEta utilGasEta = new UtilGasEta();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);


        btnLimparc = findViewById(R.id.btnLimparc);
        btnSalvarc = findViewById(R.id.btnSalvarc);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimparc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
           editEtanol.setText("");
           editGasolina.setText("");

            }
        });

        btnSalvarc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){


            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Finalizado",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Toast.makeText(GasEtaActivity.this,UtilGasEta.mensagem(),Toast.LENGTH_SHORT).show();
        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12, 3.19), Toast.LENGTH_SHORT).show();


    }
}
