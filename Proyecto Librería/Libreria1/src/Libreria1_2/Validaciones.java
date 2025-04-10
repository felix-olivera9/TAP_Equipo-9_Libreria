/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria1_2;

import java.util.ArrayList;

/**
 *
 * @author felix
 */
public class Validaciones {
    public static boolean esContraseñaDiferente(String nombreUsuario, String nuevaContraseña, ArrayList<String> usuariosYContraseñas) {
      
if(usuarioExiste( nombreUsuario, usuariosYContraseñas)==true){
String contraseñaActual = obtenerContraseña(nombreUsuario, usuariosYContraseñas);
        
        return !contraseñaActual.equals(nuevaContraseña);
    }
  return false;
}

    private static String obtenerContraseña(String nombreUsuario, ArrayList<String> usuariosYContraseñas) {
        for (int i = 0; i < usuariosYContraseñas.size(); i += 2) {
            if (usuariosYContraseñas.get(i).equals(nombreUsuario)) {
                return usuariosYContraseñas.get(i + 1); 
            }
        }
        return null; 
    }

public static boolean usuarioExiste(String nombreUsuario, ArrayList<String> usuariosYContraseñas) {
        if (usuariosYContraseñas.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < usuariosYContraseñas.size(); i += 2) {
            if (usuariosYContraseñas.get(i).equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
}
