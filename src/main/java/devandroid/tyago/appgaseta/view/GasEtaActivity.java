package devandroid.tyago.appgaseta.view;


import android.os.Bundle;
import android.text.TextUtils;
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

    double precoEtanol;
    double precoGasolina;
    String recomendacao;
    UtilGasEta utilGasEta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);
        utilGasEta = new UtilGasEta();

        editEtanol = findViewById(R.id.editEtanol);
        editGasolina = findViewById(R.id.editGasolina);
        txtResultado = findViewById(R.id.txtResultado);

        btnLimparc = findViewById(R.id.btnLimparc);
        btnSalvarc = findViewById(R.id.btnSalvarc);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimparc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editGasolina.setText("");
                editEtanol.setText("");
            }
        });

        btnSalvarc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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
                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* Obrigatorio");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatorio");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }
                if (isDadosOk) {
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);
                    txtResultado.setText(recomendacao);

                } else {
                    Toast.makeText(GasEtaActivity.this, "Por favor digite os dados obrigatórios"
                            , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
        //Toast.makeText(GasEtaActivity.this,UtilGasEta.mensagem(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(GasEtaActivity.this


    }


