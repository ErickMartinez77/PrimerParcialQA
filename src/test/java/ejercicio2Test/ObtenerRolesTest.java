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
        String expectedResult = "PERMISSION ROLE : CRUD";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }
    @Test
    public void verifyRoleC(){
        Mockito.when(verificarUsuarioMock.verifyUser(user, password)).thenReturn(true);
        Mockito.when(permisosUsuarioMock.getPermisosUsuario(user, password)).thenReturn("CD");

        ObtenerRoles obtenerRoles = new ObtenerRoles(verificarUsuarioMock,permisosUsuarioMock);
        String actualResult = obtenerRoles.getRoles(user, password);
        String expectedResult = "PERMISSION ROLE : CD";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }
    @Test
    public void verifyRoleD(){
        Mockito.when(verificarUsuarioMock.verifyUser(user, password)).thenReturn(true);
        Mockito.when(permisosUsuarioMock.getPermisosUsuario(user, password)).thenReturn("R");

        ObtenerRoles obtenerRoles = new ObtenerRoles(verificarUsuarioMock,permisosUsuarioMock);
        String actualResult = obtenerRoles.getRoles(user, password);
        String expectedResult = "PERMISSION ROLE : R";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }
    @Test
    public void verifyRoleE(){
        Mockito.when(verificarUsuarioMock.verifyUser(user, password)).thenReturn(true);
        Mockito.when(permisosUsuarioMock.getPermisosUsuario(user, password)).thenReturn("CUD");

        ObtenerRoles obtenerRoles = new ObtenerRoles(verificarUsuarioMock,permisosUsuarioMock);
        String actualResult = obtenerRoles.getRoles(user, password);
        String expectedResult = "PERMISSION ROLE : CUD";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }


}
