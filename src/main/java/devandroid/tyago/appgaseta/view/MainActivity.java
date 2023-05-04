package devandroid.tyago.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.tyago.appgaseta.R;
import devandroid.tyago.appgaseta.controller.CursoController;
import devandroid.tyago.appgaseta.controller.PessoaController;
import devandroid.tyago.appgaseta.model.Pessoa;


public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    List<String> nomesDosCursos;
    Pessoa outraPessoa;
    SharedPreferences.Editor listaVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        controller = new PessoaController(MainActivity.this);
        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();
        controller.toString();
        pessoa = new Pessoa();
        controller.buscar(pessoa);
        controller.limpar();
        outraPessoa = new Pessoa();


        EditText editPrimeiroNome;
        EditText editSobreNomeAluno;
        EditText editNomeCurso;
        EditText editTelefoneContato;

        Button btnLimpar;
        Button btnSalvar;
        Button btnFinalizar;
        Spinner spinner;


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNomeAluno.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnFinalizar = findViewById(R.id.btnFinalizar);
       // btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvarc);

        //Adapter
        //Layout
        //Injetar o Spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);


       /* btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNomeAluno.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");


            }
        });*/

     /*   btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });*/
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNomeAluno.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();


                controller.salvar(pessoa);

            }
        });

        Log.i("POOAndroid", "Objeto Pessoa: " + pessoa.toString());
        Log.i("POOAndroid", "Objeto Outrapessoa:" + outraPessoa.toString());

    }
}