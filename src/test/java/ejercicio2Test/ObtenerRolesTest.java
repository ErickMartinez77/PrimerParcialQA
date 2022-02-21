package ejercicio2Test;

import ejercicio2.ObtenerRoles;
import ejercicio2.PermisosUsuario;
import ejercicio2.VerificarUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ObtenerRolesTest {
    VerificarUsuario verificarUsuarioMock = Mockito.mock(VerificarUsuario.class);
    PermisosUsuario permisosUsuarioMock = Mockito.mock(PermisosUsuario.class);

    String user = "Erick";
    String password = "123";

    @Test
    public void verifyRoleA(){
        Mockito.when(verificarUsuarioMock.verifyUser(user, password)).thenReturn(false);
        Mockito.when(permisosUsuarioMock.getPermisosUsuario(user, password)).thenReturn("CRUD");

        ObtenerRoles obtenerRoles = new ObtenerRoles(verificarUsuarioMock,permisosUsuarioMock);
        String actualResult = obtenerRoles.getRoles(user, password);
        String expectedResult = "Incorrect USER and PWD";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR datos incorrectos");
    }
    @Test
    public void verifyRoleB(){
        Mockito.when(verificarUsuarioMock.verifyUser(user, password)).thenReturn(true);
        Mockito.when(permisosUsuarioMock.getPermisosUsuario(user, password)).thenReturn("CRUD");

        ObtenerRoles obtenerRoles = new ObtenerRoles(verificarUsuarioMock,permisosUsuarioMock);
        String actualResult = obtenerRoles.getRoles(user, password);
        String expectedResult = "PERMISSION ROLE : CRUD - Mon Feb 21 08:34:19 BOT 2022";
        if (expectedResult.contains("Mon Feb 21")){
            Assertions.assertEquals(expectedResult,actualResult,"ERROR datos incorrectos");
        }
    }


}
