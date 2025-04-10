package ControlSesion;

import ControlSesion.SessionManager;

public class TestSesion {
    public static void main(String[] args) {
        String usuario = "usuarioPrueba";

        // Iniciar sesión
        SessionManager.iniciarSesion(usuario);
        System.out.println("Sesión iniciada para: " + usuario);

        // Simular actividad
        try {
            Thread.sleep(2000); // Esperar 2 segundos
            SessionManager.registrarActividad(usuario);
            System.out.println("Actividad registrada para: " + usuario);

            // Esperar a que la sesión se cierre por inactividad (ajustable para pruebas)
            System.out.println("Esperando que la sesión expire (5 minutos por defecto)...");
            Thread.sleep(6 * 60 * 1000); // Espera 6 minutos (puedes reducir en tu clase si gustas)

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del test.");
    }
}
