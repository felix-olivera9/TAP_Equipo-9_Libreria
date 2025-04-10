package ControlSesion;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase encargada de gestionar las sesiones activas de los usuarios.
 */
public final class SessionManager {
    private static final Map<String, SesionActiva> sesiones = new HashMap<>();
    private static final long TIEMPO_INACTIVIDAD = 10 * 1000; // 5 minutos
    private static final Timer timer = new Timer(true);

    // Evitar instanciación
    public SessionManager() {}
    
    /**
     * Inicia una sesión para el usuario especificado.
     * 
     * @param usuario Nombre del usuario.
     */
    public static void iniciarSesion(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("Usuario no puede ser nulo o vacío");
        }

        SesionActiva sesion = new SesionActiva(usuario);
        sesiones.put(usuario, sesion);
        programarCierrePorInactividad(usuario);
    }
    /**
     * Registra actividad del usuario, reiniciando el temporizador de inactividad.
     * 
     * @param usuario Nombre del usuario.
     */
    public static void registrarActividad(String usuario) {
        if (usuario == null || !sesiones.containsKey(usuario)) return;

        SesionActiva sesion = sesiones.get(usuario);
        sesion.setUltimaActividad(System.currentTimeMillis());
    }
    /**
     * Verifica si una sesión está activa para el usuario.
     * 
     * @param usuario Nombre del usuario.
     * @return true si la sesión está activa, false en caso contrario.
     */
    public static boolean sesionActiva(String usuario){
        return sesiones.containsKey(usuario);
    }
    /**
     * Cierra la sesión activa del usuario.
     * 
     * @param usuario Nombre del usuario.
     */
    public static void cerrarSesion(String usuario) {
        if (usuario == null || !sesiones.containsKey(usuario)) return;

        sesiones.remove(usuario);
        System.out.println("Sesión cerrada automáticamente para: " + usuario);
    }
    /**
     * Programa el cierre automático de sesión si hay inactividad.
     * 
     * @param usuario Nombre del usuario.
     */
    private static void programarCierrePorInactividad(String usuario) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SesionActiva sesion = sesiones.get(usuario);
                if (sesion != null && (System.currentTimeMillis() - sesion.getUltimaActividad() >= TIEMPO_INACTIVIDAD)) {
                    cerrarSesion(usuario);
                    cancel();
                }
            }
        }, 0, 1 * 1000); // Revisar cada segundo
    }
}
