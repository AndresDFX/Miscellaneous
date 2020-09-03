package INTERFACES;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;



public class Inicio extends javax.swing.JFrame {

  
  private Timer t;
    private ActionListener ac;
    private int x=0;
   
    
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        btningresar = new javax.swing.JButton();
        barra = new javax.swing.JProgressBar();
        porcentaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 360));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel3.setText("BIENVENIDOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuario : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Contraseña :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txtusuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 170, 30));

        Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordMouseClicked(evt);
            }
        });
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, 30));

        btningresar.setBackground(new java.awt.Color(0, 0, 0));
        btningresar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 204, 204));
        btningresar.setText("Ingresar");
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btningresarMouseClicked(evt);
            }
        });
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        getContentPane().add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 450, -1));

        porcentaje.setText("1%");
        getContentPane().add(porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordMouseClicked

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
        // TODO add your handling code here:
        String Usuario = "compañiaSIJ";
        String Contraseña = "12345";
        
        
       String Pass =new String(Password.getPassword());
       if (txtusuario.getText().equals(Usuario)&& Pass.equals(Contraseña)){
        
    
           ac= new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                x=x+1;
                barra.setValue(x);
                if(barra.getValue()==1){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==2){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==3){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==4){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==5){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==6){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==7){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==8){
                  porcentaje.setText("CARGANDO...");
                    }
                if(barra.getValue()==9){
                  porcentaje.setText("CARGANDO...");
                    }
                
                 if(barra.getValue()==10){
                  
                  dispose();
                  MenuG yis = new MenuG ();
                  yis.setVisible(true);
                  t.stop();
                }
                
            }
            
        };
        t = new Timer(200,ac);
        t.start();
    
       }else{
           JOptionPane.showMessageDialog(this,"Usuario  / Contraseña Incorrecta");
       }
        
        
        
    }//GEN-LAST:event_btningresarMouseClicked

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
    
    
    }//GEN-LAST:event_PasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel porcentaje;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
