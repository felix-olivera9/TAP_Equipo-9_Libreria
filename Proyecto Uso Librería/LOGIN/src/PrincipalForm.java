import ControlSesion.SesionActiva;
import static ControlSesion.SesionActiva.getUsuarioActivo;
import javax.swing.*;
import ControlSesion.SessionManager;
import ControlSesion.MonitorSesion;
//import ControlSesion.SesionActiva;
/**
 *
 * @author jeshu
 */
public class PrincipalForm extends javax.swing.JFrame {
    private ControlSesion.MonitorSesion monitor;
    /**
     * Creates new form PrincipalForm
     */public PrincipalForm() {
        initComponents();
        String usuario = getUsuarioActivo();
        SessionManager.registrarActividad(usuario);
        monitor = new ControlSesion.MonitorSesion(this, usuario, 10000);
        monitor.iniciar();
        //gestorSesiones = new SessionManager();
        setTitle("Bienvenido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel mensaje = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
        add(mensaje);
    }
    @Override
protected void processWindowEvent(java.awt.event.WindowEvent e) {
    if (e.getID() == java.awt.event.WindowEvent.WINDOW_CLOSING) {
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Seguro que quieres salir?", "Confirmar salida", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            String usuario = SesionActiva.getUsuarioActivo();
            SessionManager manager = new SessionManager();
            manager.cerrarSesion(usuario);
            System.exit(0); // Cierra solo esta ventana
            // O usa System.exit(0); para cerrar toda la app si es PrincipalForm
        }
    } else {
        super.processWindowEvent(e);
    }
}

//@Override
//public void dispose(){
    //super.dispose();
    //String usuario = SesionActiva.getUsuarioActivo();
    //if (!SessionManager.sesionActiva(usuario)){
      //  new Login().setVisible(true);
    //}
//}

    
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
