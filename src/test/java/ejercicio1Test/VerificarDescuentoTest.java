package ejercicio1Test;

import ejercicio1.VerificarDescuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VerificarDescuentoTest {
    @ParameterizedTest
    @CsvSource({
            "-1,El salario no es valido",
            "1000,No tiene descuento",
            "3000, Tiene 5% de descuento: 2850.0",
            "8000, Tiene 15% de descuento: 6800.0"
    })
    public void verifyDescuento (int entrada, String expectedResult) throws Exception {
        VerificarDescuento verificarDescuento = new VerificarDescuento();
        String actualResult = verificarDescuento.descuento(entrada);
        Assertions.assertEquals(expectedResult,actualResult,"ERROR el mensaje es incorrecto");
    }
}
