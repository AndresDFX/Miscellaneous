
package INTERFACES;


import Reportes.GenerarReportes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;


public class AgendaP extends javax.swing.JFrame {
    public static final String URL = "jdbc:mysql://localhost:3306/agenda?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = "1234567";
    PreparedStatement ps;
    ResultSet rs; 
    
    //Método para establecer la conexión
    public Connection getConnection(){
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL,usuario,contraseña);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
            
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
        
        return conexion;
    }
    
    //Limpiamos todas las cajas para poder insertar mas registros
    public void limpiarCajas(){
        txtNombrem.setText(null);
        txtRaza.setText(null);
        txtServicio.setText(null);
        txtNivel.setText(null);
        txtFecha1.setText("");
        txtHora.setText(null);
        
    }
    void vaciar () {
        txtNombrem.setText("");
        txtRaza.setText("");
        txtServicio.setText("");
        txtNivel.setText("");
        txtFecha1.setText("");
        txtHora.setText("");
    }
    
     void Consulta (String Valor){
         Connection conexion = null;
         
       DefaultTableModel modelo = new DefaultTableModel();
      
       modelo.addColumn("Nombre mascota");
       modelo.addColumn("Raza");
       modelo.addColumn("Servicio");
       modelo.addColumn("Nivel");
       modelo.addColumn("Fecha");
       modelo.addColumn("Hora");
       
       tabla.setModel(modelo);
       String sql="SELECT * FROM agendap";
              
       String [] datos = new String [6];
       try {
           conexion = getConnection();
           Statement st = conexion.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               datos[5]=rs.getString(6);
               modelo.addRow(datos);
           }
           tabla .setModel(modelo);
       } catch (SQLException ex) {
           Logger.getLogger(AgendaP.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    
   
ArrayList Agenda = new ArrayList();
    /**
     * Creates new form Principal
     */
    public AgendaP() {
        
         initComponents();
        Consulta("");
        
    
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        btnGuardar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO MASCOTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre mascota:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 20));
        jPanel1.add(txtNombrem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Raza:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 20));
        jPanel1.add(txtRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));
        jPanel1.add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Servicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 20));
        jPanel1.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nivel:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 20));
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, 20));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 70, 410, 310));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 100, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agenda.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 130, 120));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 20));
        jPanel1.add(txtFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        btnGuardar1.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar1.setText("REPORTE");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
  
        
        try{
            Connection conexion = null;
            ResultSet result = null;
            boolean existe = false;
            String sql = "SELECT fecha,hora FROM agendap";
            ArrayList <String> horas = new ArrayList<>();
            ArrayList <String> dias = new ArrayList<>();
         
            conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            result = sentencia.executeQuery(sql);
            
            while(result.next()){
                horas.add(result.getString("hora"));
                dias.add(result.getString("fecha"));
            }
            
            for (int i=0 ; i<horas.size(); i++){
                System.out.println("Horas SQL: "+ horas.get(i));
                System.out.println("Dias SQL: "+ dias.get(i));
                System.out.println("DiasC: "+ txtFecha1.getText());
                System.out.println("Hora: "+ txtHora.getText());
                
                if(txtFecha1.getText().trim().equals(dias.get(i).trim()) && txtHora.getText().trim().equals(horas.get(i).trim())){
                    existe = true;
                }

            }
            if(existe==false){
                
                ps = conexion.prepareStatement("insert into agendap (nombre_mascota,raza,servicio,nivel,fecha,hora) values(?,?,?,?,?,?)");
                ps.setString(1,txtNombrem.getText());
                ps.setString(2,txtRaza.getText());
                ps.setString(3,txtServicio.getText());
                ps.setString(4,txtNivel.getText());
                ps.setString(5,txtFecha1.getText());
                ps.setString(6,txtHora.getText());
                int resultado = ps.executeUpdate(); //Ejecutamos la insercion
                Consulta("");
                
                if(resultado > 0){ //Se ejecuto correctamente la insercion
                JOptionPane.showMessageDialog(null, "Su cita fue regdsitrada correctaente");
                
                limpiarCajas();
                
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Error al agregar el registro");
                    limpiarCajas();
                }
            
            }
            
            else if(existe==true){
                JOptionPane.showMessageDialog(null, "Ya existe una cita para la fecha y hora asignada, intente nuevamente");
            }
                
            
            conexion.close(); //Cerramos la conexion
      
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        GenerarReportes reporte = new GenerarReportes();
        reporte.generar();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(AgendaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaP().setVisible(true);
            }
        });
    }
    
    

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombrem;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
