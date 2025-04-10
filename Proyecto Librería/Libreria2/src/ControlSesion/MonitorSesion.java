package ControlSesion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

/**
 * Clase que monitorea la sesión del usuario y cierra la ventana si la sesión ha expirado.
 * @author jeshu
 */
public class MonitorSesion {
    private final JFrame ventana;
    private final String usuario;
    private final Timer timer;

    /**
     * Constructor del MonitorSesion.
     * 
     * @param ventana La ventana principal de la aplicación.
     * @param usuario El nombre del usuario.
     * @param intervaloChequeoMs Intervalo en milisegundos para checar la sesión.
     */
    
    public MonitorSesion(JFrame ventana, String usuario, int intervaloChequeoMs) {
        this.ventana = ventana;
        this.usuario = usuario;

        // Timer de Swing (se ejecuta en el hilo del GUI)
        this.timer = new Timer(intervaloChequeoMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!SessionManager.sesionActiva(usuario)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(ventana, "Sesión cerrada por inactividad.");
                    ventana.dispose(); // Cierra la ventana actual
                }
            }
        });
    }
     /**
     * Inicia el monitoreo de la sesión.
     */
    public void iniciar() {
        timer.start();
    }
    /**
     * Detiene el monitoreo de la sesión.
     */
    public void detener() {
        timer.stop();
    }
}
