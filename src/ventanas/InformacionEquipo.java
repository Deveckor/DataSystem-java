/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author gabriela
 */
public class InformacionEquipo extends javax.swing.JFrame {

    int IDcliente_update = 0, IDequipo = 0, bandera = 0;
    String user = "", nom_cliente = "";

    /**
     * Creates new form InformacionEquipo
     */
    public InformacionEquipo() {
        initComponents();

        user = Login.user;
        bandera = Informacion_Cliente.bandera;

        if (bandera == 1) {
            IDequipo = Informacion_Cliente.IDequipo;
            IDcliente_update = GestionarClientes.IDcliente_update;
            jTextPane_comentariosTecnicos.setEditable(false);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select nombre_cliente from clientes where id_cliente = '" + IDcliente_update + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nom_cliente = rs.getString("nombre_cliente");
                }

            } catch (SQLException e) {
                System.err.println("Error en la conexion: " + e);
                JOptionPane.showMessageDialog(null, "Error con la conexion contactar con el administrador.");
            }

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from equipos where id_equipo = '" + IDequipo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    cmb_tipoequipo.setSelectedItem(rs.getString("tipo_equipo"));
                    cmb_marca.setSelectedItem(rs.getString("marca"));
                    cmb_estatus.setSelectedItem(rs.getString("estatus"));
                    txt_Modelo.setText(rs.getString("modelo"));
                    txt_num_serie.setText(rs.getString("numero_serie"));
                    txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));

                    String dia = "", mes = "", annio = "";
                    dia = rs.getString("dia_ingreso");
                    mes = rs.getString("mes_ingreso");
                    annio = rs.getString("annio_ingreso");
                    txt_fecha.setText(dia + " del " + mes + " del " + annio);

                    jTextPane_observaciones.setText(rs.getString("observaciones"));
                    jTextPane_comentariosTecnicos.setText(rs.getString("comentarios_tecnicos"));
                    jLabel_revisiontecnicade.setText("Comentario y actualizacion del tecnico: " + rs.getString("revision_tecnica_de"));

                }

            } catch (SQLException e) {
                System.err.println("Error en la conexion vista: " + e);
            }
            setTitle("Equipo del cliente: " + nom_cliente);

        } else {
            IDequipo = GestionarEquipos.IDequipo_update;
            jTextPane_observaciones.setEditable(false);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select nombre_cliente from clientes where id_cliente = '" + IDequipo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nom_cliente = rs.getString("nombre_cliente");
                }

            } catch (SQLException e) {
                System.err.println("Error en la conexion: " + e);
                JOptionPane.showMessageDialog(null, "Error con la conexion contactar con el administrador.");
            }

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from equipos where id_equipo = '" + IDequipo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    cmb_tipoequipo.setSelectedItem(rs.getString("tipo_equipo"));
                    cmb_marca.setSelectedItem(rs.getString("marca"));
                    cmb_estatus.setSelectedItem(rs.getString("estatus"));
                    txt_Modelo.setText(rs.getString("modelo"));
                    txt_num_serie.setText(rs.getString("numero_serie"));
                    txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));

                    String dia = "", mes = "", annio = "";
                    dia = rs.getString("dia_ingreso");
                    mes = rs.getString("mes_ingreso");
                    annio = rs.getString("annio_ingreso");
                    txt_fecha.setText(dia + " del " + mes + " del " + annio);

                    jTextPane_observaciones.setText(rs.getString("observaciones"));
                    jTextPane_comentariosTecnicos.setText(rs.getString("comentarios_tecnicos"));
                    jLabel_revisiontecnicade.setText("Comentario y actualizacion del tecnico: " + rs.getString("revision_tecnica_de"));

                }

            } catch (SQLException e) {
                System.err.println("Error en la conexion vista: " + e);
            }
            setTitle("Equipo del cliente: " + nom_cliente);
        }

        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        txt_NombreCliente.setText(nom_cliente);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_comentariosTecnicos = new javax.swing.JTextPane();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jLabel_revisiontecnicade = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_num_serie = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmb_tipoequipo = new javax.swing.JComboBox<>();
        cmb_marca = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jScrollPane2.setViewportView(jTextPane_comentariosTecnicos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del Equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del Cliente :");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de Equipo: ");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca: ");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Numero de Serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de ingreso:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima modificacion por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_Nombre7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus:");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Daño reportado y observaciones");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel_revisiontecnicade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_revisiontecnicade.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_revisiontecnicade.setText("Comentarios y Actualizacion de tecnico");
        getContentPane().add(jLabel_revisiontecnicade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NombreCliente.setEnabled(false);
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_Modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_num_serie.setBackground(new java.awt.Color(153, 153, 255));
        txt_num_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_num_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_num_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ultimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimaModificacion.setEnabled(false);
        getContentPane().add(txt_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setBackground(new java.awt.Color(153, 153, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_tipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Equipo");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 35));

        jLabel_Footer.setText("Creado por Hector Enriquez");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        int validacion = 0;
        String tipo_equipo, marca, modelo, numero_serie, estatus, obsercaciones, comentarios_tecnicos;

        tipo_equipo = cmb_tipoequipo.getSelectedItem().toString();
        marca = cmb_marca.getSelectedItem().toString();
        estatus = cmb_estatus.getSelectedItem().toString();

        modelo = txt_Modelo.getText().trim();
        numero_serie = txt_num_serie.getText().trim();
        obsercaciones = jTextPane_observaciones.getText();
        comentarios_tecnicos = jTextPane_comentariosTecnicos.getText();

        if (modelo.equals("")) {
            txt_Modelo.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos. ");
            validacion++;
        }
        if (numero_serie.equals("")) {
            txt_num_serie.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos. ");
            validacion++;
        }
        if (obsercaciones.equals("")) {
            jTextPane_observaciones.setText("Sin Observaciones. ");
        }
        if (comentarios_tecnicos.equals("")) {
            jTextPane_comentariosTecnicos.setText("Sin Comentarios. ");
        }

        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update equipos set tipo_equipo=?, marca=?, modelo=?, numero_serie=?, observaciones=?, "
                        + "estatus=?, ultima_modificacion=?, comentarios_tecnicos=?, revision_tecnica_de=? where id_equipo = '" + IDequipo + "'");

                pst.setString(1, tipo_equipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);
                pst.setString(4, numero_serie);
                pst.setString(5, obsercaciones);
                pst.setString(6, estatus);
                pst.setString(7, user);
                pst.setString(8, comentarios_tecnicos);
                pst.setString(9, user);
                

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txt_NombreCliente.setBackground(Color.GREEN);
                txt_fecha.setBackground(Color.GREEN);
                txt_Modelo.setBackground(Color.GREEN);
                txt_num_serie.setBackground(Color.GREEN);
                txt_ultimaModificacion.setText(user);

                JOptionPane.showMessageDialog(null, "Actualizacion Correcta. ");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error al actualizar: " + e);
            }
        } 
            
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipoequipo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_revisiontecnicade;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane_comentariosTecnicos;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_num_serie;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables
public void Limpiar() {
        txt_Modelo.setText("");
        txt_NombreCliente.setText("");
        txt_fecha.setText("");
        txt_num_serie.setText("");
        txt_ultimaModificacion.setText("");

    }
}
