/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jeshu
 */
public class ValidadorRegistro {
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$");
    }

    public static boolean validarApellidoP(String ApellidoP) {
        return ApellidoP.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$");
    }
    
    public static boolean validarApellidoM(String ApellidoM) {
        return ApellidoM.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$");
    }
    
    public static boolean validarCorreo(String correo) {
        return correo.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    }

    //public static boolean validarContraseña(String contraseña) {
        //return contraseña.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$") && contraseña.length() >= 8;
    //}
}
