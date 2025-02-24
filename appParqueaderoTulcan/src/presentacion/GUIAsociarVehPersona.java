/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import negocio.GestorVehiculoPersona;
import negocio.Persona;
import negocio.Vehiculo;

/**
 *
 * @author Personal
 */
public class GUIAsociarVehPersona extends javax.swing.JInternalFrame {
    
    private GestorVehiculoPersona gestorVehiculo = new GestorVehiculoPersona();
    private Integer atrCodCarne;
    private String atrPlacaVeh;
    private int cont = 0;

    /**
     * Creates new form GUIAsociarVehPersona
     */
    public GUIAsociarVehPersona() {
        initComponents();
        mostarLabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbCodCarne = new javax.swing.JLabel();
        txtCodCarne = new javax.swing.JTextField();
        lbCarne = new javax.swing.JLabel();
        lbPlacaVeh = new javax.swing.JLabel();
        txtPlacaVeh = new javax.swing.JFormattedTextField();
        lbPlaca = new javax.swing.JLabel();
        lbGuardarInfo = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        lbCodCarne.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        lbCodCarne.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCodCarne.setText("Código de Carné: ");
        jPanel2.add(lbCodCarne);
        jPanel2.add(txtCodCarne);

        lbCarne.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        lbCarne.setForeground(new java.awt.Color(255, 0, 0));
        lbCarne.setText("Requerido");
        jPanel2.add(lbCarne);

        lbPlacaVeh.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        lbPlacaVeh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPlacaVeh.setText("Placa Vehiculo: ");
        jPanel2.add(lbPlacaVeh);
        jPanel2.add(txtPlacaVeh);

        lbPlaca.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        lbPlaca.setForeground(new java.awt.Color(255, 0, 0));
        lbPlaca.setText("Requerido");
        jPanel2.add(lbPlaca);

        lbGuardarInfo.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        lbGuardarInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbGuardarInfo.setText("Guardar Información");
        jPanel2.add(lbGuardarInfo);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        validarCampos();
        if (getCont() == 0) {
            Integer codCarnet = getAtrCodCarne();
            String placaVeh = getAtrPlacaVeh();
            String respuesta;
            Persona persona = gestorVehiculo.buscarUsuarioCarne(codCarnet);
            if (persona != null) {
                Vehiculo vehiculo = gestorVehiculo.buscarVehPlaca(placaVeh);
                if (vehiculo != null) {
                    respuesta = gestorVehiculo.registrarAsociacion(persona.getPerIdentificacion(), atrCodCarne, placaVeh);
                    if (respuesta.equals("Asociacion registrada con exito")) {
                        Utilidades.Utilidades.mensajeExito(respuesta, "Exito");
                    } else {
                        Utilidades.Utilidades.mensajeError(respuesta, "Error");
                    }
                } else {
                    Utilidades.Utilidades.mensajeAdvertencia("Placa Vehiculo NO registrada", "Advertencia");
                }
            } else {
                Utilidades.Utilidades.mensajeAdvertencia("Usuario NO registrada", "Advertencia");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    public Integer getAtrCodCarne() {
        atrCodCarne = Integer.parseInt(txtCodCarne.getText());
        return atrCodCarne;
    }
    
    public String getAtrPlacaVeh() {
        atrPlacaVeh = txtPlacaVeh.getText();
        return atrPlacaVeh;
    }
    
    public int getCont() {
        return cont;
    }
    
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    public void validarCampos() {
        if (getAtrPlacaVeh().equals("")) {
            lbPlaca.setVisible(true);
            cont++;
        } else {
            lbPlaca.setVisible(false);
        }
        if (txtCodCarne.getText().equals("")) {
            lbCarne.setVisible(true);
            cont++;
        } else {
            lbCarne.setVisible(false);
        }
        
    }
    
    public void mostarLabel() {
        lbPlaca.setVisible(false);
        lbCarne.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCarne;
    private javax.swing.JLabel lbCodCarne;
    private javax.swing.JLabel lbGuardarInfo;
    private javax.swing.JLabel lbPlaca;
    private javax.swing.JLabel lbPlacaVeh;
    private javax.swing.JTextField txtCodCarne;
    private javax.swing.JFormattedTextField txtPlacaVeh;
    // End of variables declaration//GEN-END:variables
}
