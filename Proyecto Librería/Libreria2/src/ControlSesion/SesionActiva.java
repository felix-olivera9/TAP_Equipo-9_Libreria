package ControlSesion;

/**
 * Representa una sesión activa de un usuario.
 */

public class SesionActiva {
    private final String usuario;
    private long inicioSesion;
    private long ultimaActividad;

    /**
     * Crea una nueva sesión activa para un usuario.
     * 
     * @param usuario Nombre del usuario.
     */
    
    public SesionActiva(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("Usuario no puede ser nulo o vacío");
        }
        this.usuario = usuario;
        this.inicioSesion = System.currentTimeMillis();
        this.ultimaActividad = this.inicioSesion;
    }
    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Obtiene el tiempo de inicio de sesión.
     * 
     * @return Tiempo en milisegundos desde epoch.
     */
    public long getInicioSesion() {
        return inicioSesion;
    }
    /**
     * Obtiene el tiempo de la última actividad.
     * 
     * @return Tiempo en milisegundos desde epoch.
     */
    public long getUltimaActividad() {
        return ultimaActividad;
    }
    /**
     * Establece el tiempo de la última actividad.
     * 
     * @param ultimaActividad Tiempo en milisegundos desde epoch.
     */
    public void setUltimaActividad(long ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }
    /**
     * Retorna el usuario activo actualmente.
     * 
     * @return Actualmente retorna null, se puede modificar según la lógica del sistema.
     */
    public static String getUsuarioActivo() {
        // Se puede adaptar para usar una variable compartida si deseas manejar el usuario global
        return null;
    }
}
