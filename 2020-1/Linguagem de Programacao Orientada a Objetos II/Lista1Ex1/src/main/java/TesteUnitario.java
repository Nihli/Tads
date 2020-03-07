import junit.framework.TestCase;

public class TesteUnitario extends TestCase {
// Bloco de testes do método CalculaAreaRetangulo
    public void testCalculaAreaRetangulo(){
        double valor1=2.0;
        double valor2=1.5;
        double retornoEsperado=3.0;

        double retornoRecebido = AreaFiguras.calculaAreaRetangulo(valor1, valor2);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    public void testCalculaAreaRetanguloInputsIncorretos(){
        double valor1=2.0;
        double valor2=-1;
        double retornoEsperado= -1;

        double retornoRecebido = AreaFiguras.calculaAreaRetangulo(valor1, valor2);

        assertEquals(retornoEsperado, retornoRecebido);
    }

// Bloco de testes do método CalculaAreaCircunferencia
    public void testCalculaAreaCircunferencia(){
        double valorRaio=2.0;
        double retornoEsperado=12.56;

        double retornoRecebido = AreaFiguras.calculaAreaCircunferencia(valorRaio);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    public void testCalculaAreaCircunferenciaInputsIncorretos(){
        double valorRaio=-2.0;
        double retornoEsperado=-1;

        double retornoRecebido = AreaFiguras.calculaAreaCircunferencia(valorRaio);

        assertEquals(retornoEsperado, retornoRecebido);
    }

// Bloco de testes do método CalculaAreaTriangulo
    public void testCalculaAreaTriangulo(){
        double valorBase=2.0;
        double valorAltura=3.0;
        double retornoEsperado=3.0;

        double retornoRecebido = AreaFiguras.calculaAreaTriangulo(valorBase, valorAltura);

        assertEquals(retornoEsperado, retornoRecebido);
    }

    public void testCalculaAreaTrianguloInputsIncorretos(){
        double valorBase=2.0;
        double valorAltura=-3.0;
        double retornoEsperado=-1;

        double retornoRecebido = AreaFiguras.calculaAreaTriangulo(valorBase, valorAltura);

        assertEquals(retornoEsperado, retornoRecebido);
    }
}
