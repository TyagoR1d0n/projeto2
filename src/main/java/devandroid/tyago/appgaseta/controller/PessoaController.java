package devandroid.tyago.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.tyago.appgaseta.model.Pessoa;
import devandroid.tyago.appgaseta.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_ListaVip";
    SharedPreferences.Editor listaVip;


    //Construtor abaixo
    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();


    }


    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller Iniciada");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("Primeiro Nome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobreNome());
        listaVip.putString("Curso Desejado", pessoa.getCursoDesejado());
        listaVip.putString("Telefone Contato", pessoa.getTelefoneContato());
        listaVip.apply();

    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("Primeiro Nome", ""));
        pessoa.setSobreNome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("Curso Desejado", ""));
        pessoa.setTelefoneContato(preferences.getString("Telefone Contato", ""));
        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
