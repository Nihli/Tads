import junit.framework.TestCase;

public class TesteUnitario extends TestCase {
    //Testes com o método CalculaSalarioBruto
    public void testCalculaSalarioBruto(){
        double valorHora=12.5;
        double horasTrabalhadas=120;
        double retornoEsperado=1500.0;

        double retornoRecebido = Salario.calculaSalarioBruto(valorHora, horasTrabalhadas);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    public void testCalculaSalarioBrutoInputsIncorretos(){
        double valorHora=12.5;
        double horasTrabalhadas=-120;
        double retornoEsperado=-1;

        double retornoRecebido = Salario.calculaSalarioBruto(valorHora, horasTrabalhadas);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    //Testes com o método CalculaSalarioLiquido
    public void testCalculaSalarioLiquido(){
        double salarioBruto=1500;
        double percentualInss=5;
        double retornoEsperado=1425.0;

        double retornoRecebido = Salario.calculaSalarioLiquido(salarioBruto, percentualInss);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    public void testCalculaSalarioLiquidoInputsIncorretos(){
        double salarioBruto=-1500;
        double percentualInss=5;
        double retornoEsperado=-1;

        double retornoRecebido = Salario.calculaSalarioLiquido(salarioBruto, percentualInss);

        assertEquals(retornoEsperado, retornoRecebido);
    }
}
