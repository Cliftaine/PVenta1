/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pventa;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jahziel
 */
public class Login extends javax.swing.JFrame {
    dbCon con = new dbCon();
    static String idUsuario;
    /**
     * Creates new form Login
     */
    public Login() {
        //if(!con.Conectar("com.mysql.jdbc.Driver","jdbc:mysql://23.229.184.66:3306/pVenDG","PDVDG","Pdv_J4v0")){
        if(!con.Conectar("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/PDVDG2","root","toor")){
        
            JOptionPane.showMessageDialog(null,"Error");
            System.exit(0);
        }else{
            initComponents();
            String sQuery = "SELECT * FROM Usuarios";
            con.ExeQuery(sQuery);
            try {
                while(con.sqlRes.next()){
                sUser.addItem(con.sqlRes.getString("Usuario"));
                idUsuario = con.sqlRes.getString("idUsuario");

            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
            
            this.setTitle("Punto de venta");
            this.setLocationRelativeTo(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        lUser = new javax.swing.JLabel();
        lPassword = new javax.swing.JLabel();
        sPassword = new javax.swing.JPasswordField();
        logo = new javax.swing.JLabel();
        sUser = new javax.swing.JComboBox<>();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lUser.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lUser.setText("Usuario:");
        lUser.setToolTipText("");

        lPassword.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lPassword.setText("Contraseña:");

        sPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sPasswordKeyPressed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        sUser.setEditable(true);
        sUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sUserKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sPassword)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPassword)
                            .addComponent(lUser))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(lUser)
                        .addGap(18, 18, 18)
                        .addComponent(sUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lPassword)
                        .addGap(18, 18, 18)
                        .addComponent(sPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        bCancelar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        bCancelar.setText("Salir");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bAceptar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        bAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        aAccion();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void sUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sUserKeyPressed
        // TODO add your handling code here:
        //detecta la tecla enter
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           aAccion();
        }
    }//GEN-LAST:event_sUserKeyPressed

    private void sPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           aAccion();
        }    
    }//GEN-LAST:event_sPasswordKeyPressed

    public void aAccion(){
        String sSentencia;
        String srtUser;
        String srtPass;
        
        if(bAceptar.getText() == "Aceptar"){
            srtUser = String.valueOf(sUser.getSelectedItem());
            if(srtUser == "null"){
                srtUser = "";
            }
            srtPass = String.valueOf(sPassword.getPassword());
            //JOptionPane.showMessageDialog(null,srtUser.length());
            if(srtUser.length()== 0 && srtPass.length() == 0){
                JOptionPane.showMessageDialog(null,"Ingrese Usuario y Contraseña");
            }else if(srtUser.length() == 0){
                JOptionPane.showMessageDialog(null,"Ingrese Usuario");
            }else if(srtPass.length() == 0){
                JOptionPane.showMessageDialog(null,"Ingrese Contraseña");
            }else{
                
                sSentencia = "select * from Usuarios";
                sSentencia +=" where idUsuario='"+idUsuario+"'";
                //sSentencia += " where usuario='"+sUser.getText()+"'";
                sSentencia += " and Usuario='"+String.valueOf(sUser.getSelectedItem())+"'";
                //JOptionPane.showMessageDialog(null,sSentencia);
                sSentencia += " and Contraseña='"+String.valueOf(sPassword.getPassword())+"'";
            
                con.ExeQuery(sSentencia);
                try{
                    //verificar si existe
                    if(con.sqlRes.next()){
                        varGlobales.sNombre = con.sqlRes.getString("Nombre");
                        varGlobales.sApellido = con.sqlRes.getString("Apellido");
                        bAceptar.setText("Iniciando...");
                        bCancelar.setEnabled(false);
                        sPassword.setEnabled(false);
                        sUser.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Accediendo al sistema");
                        this.dispose();
                        Principal iniciar = new Principal();
                        iniciar.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Accediendo al sistema");
            } 
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lUser;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField sPassword;
    private javax.swing.JComboBox<String> sUser;
    // End of variables declaration//GEN-END:variables
}