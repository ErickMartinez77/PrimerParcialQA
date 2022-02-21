package ejercicio2;

import java.util.Date;

public class ObtenerRoles {
    VerificarUsuario verificarUsuario;
    PermisosUsuario permisosUsuario;
    String msg;
    public ObtenerRoles(VerificarUsuario verificarUsuarioMockeado, PermisosUsuario permisosUsuarioMockeado){
        verificarUsuario = verificarUsuarioMockeado;
        permisosUsuario = permisosUsuarioMockeado;
    }
    public String getRoles(String user, String password){
        Date date = new Date();
        if (verificarUsuario.verifyUser(user,password)){
            msg = "PERMISSION ROLE : " + permisosUsuario.getPermisosUsuario(user,password) + " - "+date.toString();
        } else {
            msg = "Incorrect USER and PWD";
        }
        return msg;
    }
}
