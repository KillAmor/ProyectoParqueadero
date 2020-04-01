/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Utilidades.Utilidades;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import mvcf.AModel;
import mvcf.AView;
import negocio.*;
import static presentacion.GUIInicio.dskEscritorio;

/**
 *
 * @author Usuario
 */
public class GUIBuscarVehPersona extends javax.swing.JInternalFrame {

    private String accion;
    private String idPersona;
    private String placa;
    private Persona per = null;
    private String tipoId;
    private int cont;

    public GUIBuscarVehPersona() {
        initComponents();
        cont = 0;
        tipoId = "null";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotones = new javax.swing.ButtonGroup();
        pnlDatos = new javax.swing.JPanel();
        lblInsertarNumero = new javax.swing.JLabel();
        rbtCarnet = new javax.swing.JRadioButton();
        rbtCedula = new javax.swing.JRadioButton();
        txtNumeroIngresado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlInfUsuario = new javax.swing.JPanel();
        lblinfoPersona = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblinfUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        pnlRegistro = new javax.swing.JPanel();
        btnRegPersona = new javax.swing.JButton();
        btnRegVehiculo = new javax.swing.JButton();
        btnAsignarPuesto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de usuarios UNICAUCA");

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        pnlDatos.setLayout(new java.awt.GridLayout(0, 5));

        lblInsertarNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInsertarNumero.setText("Buscar por:");
        pnlDatos.add(lblInsertarNumero);

        GrupoBotones.add(rbtCarnet);
        rbtCarnet.setSelected(true);
        rbtCarnet.setText("Carnet");
        rbtCarnet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlDatos.add(rbtCarnet);

        GrupoBotones.add(rbtCedula);
        rbtCedula.setText("Cedula");
        pnlDatos.add(rbtCedula);

        txtNumeroIngresado.setMargin(new java.awt.Insets(2, 2, 2, 100));
        txtNumeroIngresado.setSelectionStart(5);
        txtNumeroIngresado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroIngresadoFocusLost(evt);
            }
        });
        pnlDatos.add(txtNumeroIngresado);

        btnBuscar.setText("Buscar");
        pnlDatos.add(btnBuscar);

        getContentPane().add(pnlDatos, java.awt.BorderLayout.NORTH);

        pnlInfUsuario.setLayout(new java.awt.GridLayout(5, 0));

        lblinfoPersona.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lblinfoPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblinfoPersona.setText("Informacion de la Persona");
        lblinfoPersona.setToolTipText("");
        lblinfoPersona.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Usuario"));
        lblinfoPersona.setMaximumSize(new java.awt.Dimension(1000, 1000));
        lblinfoPersona.setMinimumSize(jScrollPane1.getSize());
        lblinfoPersona.setPreferredSize(new java.awt.Dimension(200, 20));
        lblinfoPersona.setVerifyInputWhenFocusTarget(false);
        pnlInfUsuario.add(lblinfoPersona);
        lblinfoPersona.getAccessibleContext().setAccessibleName("Informacion de\n la Persona");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 50));

        tblinfUsuario.setBackground(new java.awt.Color(204, 204, 204));
        tblinfUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Rol"
            }
        ));
        tblinfUsuario.setShowHorizontalLines(false);
        tblinfUsuario.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblinfUsuario);

        pnlInfUsuario.add(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vehiculos Asociados");
        pnlInfUsuario.add(jLabel1);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 50));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(450, 80));

        tblVehiculos.setBackground(new java.awt.Color(204, 204, 204));
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Tipo", "Multas", "Reporte Multas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setShowHorizontalLines(false);
        tblVehiculos.setShowVerticalLines(false);
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVehiculosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblVehiculos);

        pnlInfUsuario.add(jScrollPane2);

        pnlRegistro.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegistro.setLayout(new java.awt.GridLayout(1, 2));

        btnRegPersona.setText("Registrar Persona");
        btnRegPersona.setEnabled(false);
        btnRegPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPersonaActionPerformed(evt);
            }
        });
        pnlRegistro.add(btnRegPersona);

        btnRegVehiculo.setText("Registrar Vehiculo");
        btnRegVehiculo.setEnabled(false);
        btnRegVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegVehiculoActionPerformed(evt);
            }
        });
        pnlRegistro.add(btnRegVehiculo);

        btnAsignarPuesto.setText("Asignar Puesto");
        btnAsignarPuesto.setEnabled(false);
        btnAsignarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarPuestoActionPerformed(evt);
            }
        });
        pnlRegistro.add(btnAsignarPuesto);

        pnlInfUsuario.add(pnlRegistro);

        getContentPane().add(pnlInfUsuario, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean comprobarventana(Object obj) {

        JInternalFrame[] activos = GUIInicio.dskEscritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;

        }
        return cerrado;

    }
    private void txtNumeroIngresadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroIngresadoFocusLost
        // TODO add your handling code here:
        try {
            if (validaRadioButon()) {
                if (validarFormulario()) {
                    GestorVehiculoPersona gestor = new GestorVehiculoPersona();
                    String id = getDocumento();
                    ArrayList<Vehiculo> vehiculo = null;
                    int Id = Integer.parseInt(id);
                    if (rbtCarnet.isSelected()) {
                        per = gestor.buscarUsuarioCarne(Id);
                        tipoId = "carnet";
                    } else {
                        tipoId = "cedula";
                        per = gestor.buscarUsuarioDocumento(Id);
                    }
                    vehiculo = gestor.BuscarVeh(Id);
                    if (per != null && vehiculo.size() == 0) {
                        accion = "buscarPersona";
                        llenarPersona(per);
                        btnRegVehiculo.setEnabled(true);
                        btnAsignarPuesto.setEnabled(true);
                    } else if (per != null && vehiculo != null) {
                        llenarPersona(per);
                        llenarVehiculo(vehiculo);
                        btnAsignarPuesto.setEnabled(true);
                    } else {
                        Utilidades.mensajeAdvertencia("La consulta no arrojo datos", "Advertencia");
                        btnRegPersona.setEnabled(true);
                        btnRegVehiculo.setEnabled(true);
                        btnAsignarPuesto.setEnabled(false);
                        limpiarTabla((DefaultTableModel) tblVehiculos.getModel());
                        limpiarTabla((DefaultTableModel) tblinfUsuario.getModel());
                    }
                    if (tipoId.equals("carnet")) {
                        per.setCodCarne(Id);
                    } else {
                        per.setPerIdentificacion(Id);

                    }
                }
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtNumeroIngresadoFocusLost

    private void btnRegPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPersonaActionPerformed
        int doc = Integer.parseInt(getDocumento());
        String tipo = getTipoId();
        GUIRegistrarConductor objRegConductor = new GUIRegistrarConductor(doc, tipo);
        GUIInicio.dskEscritorio.add(objRegConductor);
        objRegConductor.toFront();
        objRegConductor.setVisible(true);
        objRegConductor.setMaximizable(true);
        btnRegPersona.setEnabled(false);
        cont++;
        if (cont == 2) {
            btnAsignarPuesto.setEnabled(true);
            cont = 0;
        }
    }//GEN-LAST:event_btnRegPersonaActionPerformed

    private void btnRegVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegVehiculoActionPerformed
        // TODO add your handling code here:
        GestorVehiculoPersona gestor = new GestorVehiculoPersona();
        if (getTipoId().equals("carnet")) {
            per = gestor.buscarUsuarioCarne(Integer.parseInt(getDocumento()));
        } else {
            per = gestor.buscarUsuarioDocumento(Integer.parseInt(getDocumento()));
        }
        GUIRegistrarVehiculo objRegVehiculo = new GUIRegistrarVehiculo(per.getPerIdentificacion(), per.getCodCarne());
        GUIInicio.dskEscritorio.add(objRegVehiculo);
        objRegVehiculo.toFront();
        objRegVehiculo.setVisible(true);
        objRegVehiculo.setMaximizable(true);
        btnRegVehiculo.setEnabled(false);
        cont++;
        if (cont == 2) {
            btnAsignarPuesto.setEnabled(true);
            cont = 0;
        }
    }//GEN-LAST:event_btnRegVehiculoActionPerformed

    private void btnAsignarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarPuestoActionPerformed
        if (placa == null) {
            Utilidades.mensajeAdvertencia("Se debe seleccionar el vehiculo a parquear", "Advertencia");
        } else {
            GUIVerMapa objVerMapa = null;
            try {
                objVerMapa = new GUIVerMapa(1, placa);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUIBuscarVehPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            GUIInicio.dskEscritorio.add(objVerMapa);
            objVerMapa.toFront();
            objVerMapa.setVisible(true);
            objVerMapa.setMaximizable(false);
        }
    }//GEN-LAST:event_btnAsignarPuestoActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
        int column = tblVehiculos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblVehiculos.getRowHeight();
        if(row < tblVehiculos.getRowCount() && row >= 0 && column < tblVehiculos.getColumnCount() && column >=0 ){
            Object value = tblVehiculos.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn = (JButton) value;
                if(btn.getName().equals("m")){
                    verMultas();
                }else{
                   verReporte();
                }
            }
        }
    }//GEN-LAST:event_tblVehiculosMouseClicked
    public void verReporte(){
        GUIReporteIngreso objReporte = new GUIReporteIngreso(placa);
        
        if(objReporte.verReporte(placa)){
            GUIReporteIngreso objReport = new GUIReporteIngreso(placa);
            objReport.setMaximizable(true);
            dskEscritorio.add(objReport);
            try {
                objReport.setMaximum(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            objReport.show();
            
        }else{
            Utilidades.mensajeAdvertencia("El vehiculo no tiene ingreso registrados en las ultimas dos semanas", "Advertencia");
        }
        
       
    }
    public void verMultas(){
        GUIVerMultas objMulta = new GUIVerMultas(placa);
        objMulta.setMaximizable(true);
        dskEscritorio.add(objMulta);
        try {
            objMulta.setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        objMulta.show();
    }
    private void tblVehiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMousePressed
        // TODO add your handling code here:
        int seleccionar = tblVehiculos.rowAtPoint(evt.getPoint());
        placa = String.valueOf(tblVehiculos.getValueAt(seleccionar, 0));
        System.out.println(placa);
    }//GEN-LAST:event_tblVehiculosMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton btnAsignarPuesto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegPersona;
    private javax.swing.JButton btnRegVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInsertarNumero;
    private javax.swing.JLabel lblinfoPersona;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlInfUsuario;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JRadioButton rbtCarnet;
    private javax.swing.JRadioButton rbtCedula;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTable tblinfUsuario;
    private javax.swing.JTextField txtNumeroIngresado;
    // End of variables declaration//GEN-END:variables

    public void llenarPersona(Persona objPersona) {
        //limpiarTabla(model);
        JButton btnVerMulta = new JButton();
        DefaultTableModel model = (DefaultTableModel) tblinfUsuario.getModel();
        limpiarTabla(model);
        for (int i = 0; i < tblinfUsuario.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        if (objPersona != null) {
            model.addRow(new String[]{
                objPersona.getPerNombre(), objPersona.getPerApellido(), objPersona.getPerRol()
            });
        }
    }

    public void llenarVehiculo(ArrayList<Vehiculo> vehiculos) {
        DefaultTableModel model = (DefaultTableModel) tblVehiculos.getModel();
        limpiarTabla(model);
        tblVehiculos.setDefaultRenderer(Object.class, new Render());
        JButton btnVerMultas = new JButton("ver Multas");
        btnVerMultas.setName("m");
        JButton btnRepMultas = new JButton("Reporte Ingreso");
        btnRepMultas.setName("r");
        Object rowData[] = new Object[5];
        for (Vehiculo veh : vehiculos) {
            rowData[0] = veh.getVehPlaca();
            rowData[1] = veh.getVehMarca();
            rowData[2] = veh.getVehTipo();
            rowData[3] = btnVerMultas;
            rowData[4] = btnRepMultas;
            model.addRow(rowData);
        }
    }

    public String getDocumento() {
        idPersona = txtNumeroIngresado.getText();
        return idPersona;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public JButton getButon() {
        return btnBuscar;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public boolean validarFormulario() {
        boolean band = true;
        if (this.getDocumento().equals("")) {
            Utilidades.mensajeError("Debe Ingeesar un id", "FALTA");
            txtNumeroIngresado.requestFocus();
            band = false;
        }
        return band;
    }

    public boolean validaRadioButon() {
        boolean band = true;
        if (rbtCarnet.isSelected() == false && rbtCedula.isSelected() == false) {
            Utilidades.mensajeAdvertencia("No se selecciono ninguna opción de búsqueda", "Advertencia");
            band = false;
        }
        return band;
    }

    public void limpiarTabla(DefaultTableModel objTabla) {
        while (objTabla.getRowCount() > 0) {
            objTabla.removeRow(0);
        }
    }
}
