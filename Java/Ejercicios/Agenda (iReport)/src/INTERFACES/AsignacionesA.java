package INTERFACES;


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

public class AsignacionesA extends javax.swing.JFrame {
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
        
        
    }
    void vaciar () {
        
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
           Logger.getLogger(AsignacionesA.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    
   
ArrayList Agenda = new ArrayList();
    /**
     * Creates new form Principal
     */
    public AsignacionesA() {
        
         initComponents();
         
        Consulta("");
        
        Crear_Modelo();
        txtNombrem.setVisible(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        txtNombrem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASIGNACIONES AUXILIAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 240, 20));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGuardar.setText("MOSTRAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 70, 410, 310));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agenda.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, 120));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
        jPanel1.add(txtNombrem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          Connection conexion = null;
        
        try{
            conexion = getConnection();
            ps = conexion.prepareStatement("SELECT agendap (nombre_mascota,raza,servicio,nivel,fecha,hora) values(?,?,?,?,?,?)");
            
             Consulta("");
            
            
            conexion.close(); //Cerramos la conexion
            
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
      
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private boolean eliminarRegistro(String id){
         
        String sql_insert;
        sql_insert = "DELETE FROM agendap WHERE nombre_mascota = '"+id+"' ;";
        try {
            Connection conexion = getConnection();
            Statement sentencia = conexion.createStatement();
            int z = sentencia.executeUpdate(sql_insert);
            return z == 1;
        }catch (SQLException ex) {
            System.out.println("Excepción en eliminar de agendap");
        }
        return false;
    }
   
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        String cadena="";
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        int row = tabla.rowAtPoint(evt.getPoint());
        if (row >= 0 && tabla.isEnabled())
        {
            for (int i=0; i < tabla.getColumnCount();i++)
            {
               cadena=cadena + "," +  modelo.getValueAt(row,i).toString();
            }
        }
             
        String []nombre = cadena.split(",");
        int confirmado = JOptionPane.showConfirmDialog( null, "¿Seguro que desea eliminar este registron con nombre '"+nombre[1]+"' ?");

        if (JOptionPane.OK_OPTION == confirmado){
           
          modelo.removeRow(row);
          if(eliminarRegistro(nombre[1])==true){
              JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
          }
          else{
               JOptionPane.showMessageDialog(null, "El registro no se pudo eliminar porfavor presione el boton MOSTRAR");
          }
          
        }
        
    }//GEN-LAST:event_tablaMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(AsignacionesA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignacionesA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignacionesA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignacionesA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignacionesA().setVisible(true);
            }
        });
    }
    
    
    DefaultTableModel modelo;
    private void Crear_Modelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Identificación", "Nombres","Apellidos", "Teléfono", "Dirección"}) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNombrem;
    // End of variables declaration//GEN-END:variables
}
