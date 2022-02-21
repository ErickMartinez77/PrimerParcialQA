package ejercicio3Test;

import ejercicio3.ObtenerRolesStatic;
import ejercicio3.PermisosUsuarioStatic;
import ejercicio3.VerificarUsuarioStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ObtenerRolesStaticTest {
    String user = "Erick";
    String password = "123";
    @BeforeAll
    public static void before(){
        MockedStatic<VerificarUsuarioStatic> mockedVerificarUsuarioStatic = Mockito.mockStatic(VerificarUsuarioStatic.class);
        MockedStatic<PermisosUsuarioStatic> mockedPermisosUsuarioStatic = Mockito.mockStatic(PermisosUsuarioStatic.class);

        mockedVerificarUsuarioStatic.when(() -> VerificarUsuarioStatic.verifyUser("Erick","123")).thenReturn(false);
        mockedPermisosUsuarioStatic.when(() -> PermisosUsuarioStatic.getPermisosUsuario("Erick","123")).thenReturn("CRUD");
    }
    @Test
    public void verifyRoleA(){
        ObtenerRolesStatic obtenerRolesStatic = new ObtenerRolesStatic();
        String actualResult = obtenerRolesStatic.getRoles(user, password);
        String expectedResult = "Incorrect USER and PWD";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }
    @Test
    public void verifyRoleB(){
        MockedStatic<VerificarUsuarioStatic> mockedVerificarUsuarioStatic = Mockito.mockStatic(VerificarUsuarioStatic.class);
        MockedStatic<PermisosUsuarioStatic> mockedPermisosUsuarioStatic = Mockito.mockStatic(PermisosUsuarioStatic.class);
        mockedVerificarUsuarioStatic.when(() -> VerificarUsuarioStatic.verifyUser("Erick","123")).thenReturn(true);
        mockedPermisosUsuarioStatic.when(() -> PermisosUsuarioStatic.getPermisosUsuario("Erick","123")).thenReturn("CRUD");

        ObtenerRolesStatic obtenerRolesStatic = new ObtenerRolesStatic();
        String actualResult = obtenerRolesStatic.getRoles(user, password);
        String expectedResult = "PERMISSION ROLE : CRUD";
        Assertions.assertTrue(actualResult.contains(expectedResult), "ERROR datos incorrectos");
    }

}
