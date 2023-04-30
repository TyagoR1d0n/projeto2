package devandroid.tyago.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.tyago.appgaseta.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos(){
    listCursos = new ArrayList<Curso>();
    listCursos.add(new Curso("Java"));
    listCursos.add(new Curso("HTML"));
    listCursos.add(new Curso("Css"));
    listCursos.add(new Curso("PHP"));
    listCursos.add(new Curso("PYTON"));

    return listCursos;
    }

    // maneira mais simples de criar um spinner rapidamente
    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size() ; i++) {
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
        }
        return dados;
        //fim spinner
    }
}
