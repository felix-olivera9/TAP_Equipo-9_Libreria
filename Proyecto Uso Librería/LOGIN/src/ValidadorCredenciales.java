/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jeshu
 */
public class ValidadorCredenciales {
    public static boolean validar(String correo, String contraseña){
        if (!correo.contains("@")) {
            return false;
        }
        String nombreUsuario = correo.split("@")[0];
        
        return contraseña.startsWith(nombreUsuario) && contraseña.length() >= 8;
    }
}
