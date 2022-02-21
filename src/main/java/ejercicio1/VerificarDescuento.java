package ejercicio1;

public class VerificarDescuento {
    String msg;
    public String descuento(int entrada) throws Exception {
        if (entrada <= 0){
            throw new Exception("El salario no es valido");
        }else if (entrada <= 2000){
            msg = "No tiene descuento";
        } else if (entrada > 2000 && entrada < 4000){
            msg = "Tiene 5% de descuento: "+(entrada-(entrada*0.05));
        } else if (entrada > 4000){
            msg = "Tiene 15% de descuento: "+(entrada-(entrada*0.15));
        } else {
            throw new Exception("El salario no es valido");
        }
        return msg;
    }
}
