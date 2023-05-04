package devandroid.tyago.appgaseta.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.tyago.appgaseta.R;
import devandroid.tyago.appgaseta.apoio.UtilGasEta;
import devandroid.tyago.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;
    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Combustivel combustivel;

    // UtilGasEta utilGasEta = new UtilGasEta();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        combustivel = new Combustivel();


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("");
                editEtanol.setText("");
            }
        });

        btnSalvar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                combustivel.setGasolina(editGasolina.getText().toString());
                combustivel.setEtanol(editEtanol.getText().toString());

                Toast.makeText(GasEtaActivity.this, "Salvo" + combustivel.toString(), Toast.LENGTH_SHORT).show();
            }
        }));
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
