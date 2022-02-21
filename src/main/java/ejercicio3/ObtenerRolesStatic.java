package ejercicio3;

import java.util.Date;

public class ObtenerRolesStatic {
    String msg;
    public String getRoles(String user, String password){
        Date date = new Date();
        if (VerificarUsuarioStatic.verifyUser(user,password)){
            msg = "PERMISSION ROLE : " + PermisosUsuarioStatic.getPermisosUsuario(user,password) + " - "+date.toString();
        } else {
            msg = "Incorrect USER and PWD";
        }
        return msg;
    }
}
