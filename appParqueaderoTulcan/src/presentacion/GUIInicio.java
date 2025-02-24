/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Clases.fondoEscritorio;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mvcf.AModel;
import mvcf.AView;
import negocio.Conexion;
import negocio.GestorParqueadero;
import negocio.Persona;
import negocio.Reporte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jhayber
 */
public class GUIInicio extends javax.swing.JFrame {

    private String usuario;

    /**
     * Creates new form GUIInicio
     */
    public GUIInicio(String prmNombre, String prmApellido, String prmRol) {
        initComponents();
        cargarOpciones(prmRol);
        dskEscritorio.setBorder(new fondoEscritorio());
        this.setExtendedState(GUIInicio.MAXIMIZED_BOTH);
        usuario = prmNombre + " " + prmApellido + " - " + prmRol;
        mnuNomUsuario.setText(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskEscritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnuOpciones = new javax.swing.JMenu();
        mnuRegIngreso = new javax.swing.JMenuItem();
        mnuRegSalida = new javax.swing.JMenuItem();
        mnuAsociarVeh = new javax.swing.JMenuItem();
        mnuRegVigilante = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuRegMulta = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuMapa = new javax.swing.JMenu();
        mnuVerMapa = new javax.swing.JMenuItem();
        mnuNomUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dskEscritorio.setBackground(new java.awt.Color(153, 153, 255));

        mnuOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ajustes.png"))); // NOI18N
        mnuOpciones.setText("Opciones");

        mnuRegIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coche.png"))); // NOI18N
        mnuRegIngreso.setText("Registrar Ingreso");
        mnuRegIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegIngresoActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuRegIngreso);

        mnuRegSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no-estacionar.png"))); // NOI18N
        mnuRegSalida.setText("Registrar Salida");
        mnuRegSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegSalidaActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuRegSalida);

        mnuAsociarVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coches.png"))); // NOI18N
        mnuAsociarVeh.setText("Asociar Vehiculo");
        mnuAsociarVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAsociarVehActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuAsociarVeh);

        mnuRegVigilante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardia.png"))); // NOI18N
        mnuRegVigilante.setText("Registrar Vigilante");
        mnuRegVigilante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegVigilanteActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuRegVigilante);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuOpciones.add(mnuSalir);

        jMenuBar2.add(mnuOpciones);

        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        mnuReportes.setText("Reportes y Multas");

        mnuRegMulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multa.png"))); // NOI18N
        mnuRegMulta.setText("Registrar Multa");
        mnuRegMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegMultaActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuRegMulta);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crecimiento.png"))); // NOI18N
        jMenuItem2.setText("Reporte Ingreso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem2);

        jMenuBar2.add(mnuReportes);

        mnuMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alfiler.png"))); // NOI18N
        mnuMapa.setText("Mapa");

        mnuVerMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vision.png"))); // NOI18N
        mnuVerMapa.setText("Ver Mapa");
        mnuVerMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerMapaActionPerformed(evt);
            }
        });
        mnuMapa.add(mnuVerMapa);

        jMenuBar2.add(mnuMapa);

        mnuNomUsuario.setText("Usuario");
        mnuNomUsuario.setEnabled(false);
        mnuNomUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar2.add(mnuNomUsuario);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskEscritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarOpciones(String prmRol) {
        if (prmRol.equals("Vigilante")) {
            mnuRegVigilante.setVisible(false);
        }
    }
    private void mnuRegIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegIngresoActionPerformed
        GUIBuscarVehPersona objIngreso = new GUIBuscarVehPersona();
        objIngreso.setMaximizable(true);
        dskEscritorio.add(objIngreso);
        try {
            objIngreso.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objIngreso.show();
    }//GEN-LAST:event_mnuRegIngresoActionPerformed

    private void mnuVerMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerMapaActionPerformed
        GUIVerMapa objMapa = null;
        try {
            objMapa = new GUIVerMapa(0, "-1");
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        //objMapa.setMaximizable(true);
        dskEscritorio.add(objMapa);
        try {
            objMapa.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objMapa.show();
    }//GEN-LAST:event_mnuVerMapaActionPerformed

    private void mnuRegSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegSalidaActionPerformed
        GUIVerMapa objMapa = null;
        try {
            objMapa = new GUIVerMapa(2, "-1");
        } catch (InterruptedException ex) {
            //Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
            try {
                objMapa = new GUIVerMapa(2, "-1");
            } catch (InterruptedException ex1) {
                Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        //objMapa.setMaximizable(true);
        dskEscritorio.add(objMapa);
        try {
            objMapa.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objMapa.show();
    }//GEN-LAST:event_mnuRegSalidaActionPerformed

    private void mnuRegVigilanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegVigilanteActionPerformed
        // TODO add your handling code here:
        GUIRegistrarVigilante objVigilante = new GUIRegistrarVigilante();
        objVigilante.setMaximizable(true);
        dskEscritorio.add(objVigilante);
        try {
            objVigilante.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objVigilante.show();
    }//GEN-LAST:event_mnuRegVigilanteActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuAsociarVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAsociarVehActionPerformed
        // TODO add your handling code here:
        GUIAsociarVehPersona objVehPersona = new GUIAsociarVehPersona();
        objVehPersona.setMaximizable(true);
        dskEscritorio.add(objVehPersona);
        try {
            objVehPersona.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objVehPersona.show();
    }//GEN-LAST:event_mnuAsociarVehActionPerformed

    private void mnuRegMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegMultaActionPerformed
        // TODO add your handling code here:
        GUIRegistrarMulta objMulta = new GUIRegistrarMulta();
        objMulta.setMaximizable(true);
        dskEscritorio.add(objMulta);
        try {
            objMulta.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objMulta.show();
    }//GEN-LAST:event_mnuRegMultaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        GestorParqueadero objParqueadero = new GestorParqueadero();
        ArrayList<Reporte> listaReportes = null;
        try {
            listaReportes = objParqueadero.reporteIngreso();
            if (!listaReportes.equals("No se encontro reportes.")) {
                Conexion con = new Conexion();
                Connection conn = con.getConecion();
                try {
                    JasperReport reporte;
                    String path = "C:\\Users\\Personal\\Documents\\NetBeansProjects\\appProyectoFinal\\appParqueaderoTulcan\\src\\reporte\\IReportIngreso.jasper";
                    reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Se carga el reporte de su localizacion
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); //Agregamos los parametros para llenar el reporte
                    JasperViewer viewer = new JasperViewer(jprint, false); //Se crea la vista del reportes
                    viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Se declara con dispose_on_close para que no se cierre el programa cuando se cierre el reporte
                    viewer.setVisible(true); //Se vizualiza el reporte

                } catch (JRException ex) {
                    Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
                    Utilidades.Utilidades.mensajeError(ex.getMessage(), "Error");
                }
            } else {
                Utilidades.Utilidades.mensajeError("No existen datos", "Error");
            }
        } catch (Exception ex) {
            Utilidades.Utilidades.mensajeError(ex.getMessage(), "Error");
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dskEscritorio;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem mnuAsociarVeh;
    private javax.swing.JMenu mnuMapa;
    private javax.swing.JMenu mnuNomUsuario;
    private javax.swing.JMenu mnuOpciones;
    private javax.swing.JMenuItem mnuRegIngreso;
    private javax.swing.JMenuItem mnuRegMulta;
    private javax.swing.JMenuItem mnuRegSalida;
    private javax.swing.JMenuItem mnuRegVigilante;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuVerMapa;
    // End of variables declaration//GEN-END:variables

}
