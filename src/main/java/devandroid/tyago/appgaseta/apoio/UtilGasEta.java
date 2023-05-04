package devandroid.tyago.appgaseta.apoio;

public class UtilGasEta {

    public void metodoEstatico() {

    }

    public static void metodoNaoEstatico() {
    }


    public static String calcularMelhorOpcao(double gasolina, double etanol) {
        double precoIdeal = gasolina * 0.70;
        String mensademDeRetorno;

        if (etanol <= precoIdeal) {
            mensademDeRetorno = "Abastecer com Etanol";

        } else {
            mensademDeRetorno = "Abastecer com Gasolina";
        }

        return mensademDeRetorno;


    }

    public static String mensagemn() {
        return "Novo ";
    }
}
