package ejercicio2;

public class ObtenerRoles {
    VerificarUsuario verificarUsuario;
    PermisosUsuario permisosUsuario;
    String msg;
    public ObtenerRoles(VerificarUsuario verificarUsuarioMockeado, PermisosUsuario permisosUsuarioMockeado){
        verificarUsuario = verificarUsuarioMockeado;
        permisosUsuario = permisosUsuarioMockeado;
    }
    public String getRoles(String user, String password){
        return msg;
    }
}
