
public class AreaFiguras {
    public static double calculaAreaRetangulo(double lado1, double lado2){
        try{

            if (lado1<0||lado2<0){
                throw new RuntimeException("Essa função não aceita parâmetros negativos.");
            }

            return lado1 * lado2;
        }catch(RuntimeException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static double calculaAreaCircunferencia(double raio){
        try{

            if (raio<0){
                throw new RuntimeException("Essa função não aceita parâmetros negativos.");
            }

            return 3.14*(raio*2);
        }catch(RuntimeException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static double calculaAreaTriangulo(double base, double altura){
        try{

            if (base<0||altura<0){
                throw new RuntimeException("Essa função não aceita parâmetros negativos.");
            }

           return (base*altura)/2;
        }catch(RuntimeException e){
            e.printStackTrace();
            return -1;
        }
    }
}
