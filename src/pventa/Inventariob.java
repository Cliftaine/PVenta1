/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pventa;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jahziel
 */
public class Inventariob extends javax.swing.JDialog {

    /**
     * Creates new form Inventariob
     */
    dbCon con = new dbCon();
    misFunciones miFun = new misFunciones();
            
public Inventariob(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        //ejecutar consulta
        eConsulta();
    }
    
private void eConsulta(){
        
        //DefaultTableModel table = new DefaultTableModel();
         // Declaro una variable para las columnas
        int iColumnas=0;
        
        // Declaro un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();
        java.sql.ResultSetMetaData mdConsulta=null;
        Object [] oFila=null;
        //JOptionPane.showMessageDialog(null, dbCon.sqlString,"Duran Gourmet",JOptionPane.INFORMATION_MESSAGE);                

        // Ejecuto el Query definido en la variable
        if (con.ExeQuery(dbCon.sqlString))
        {
            // Captura el Error de Sql
            try 
            {
                // Prepara variable para obtener Meta Datos de la Consulta
                mdConsulta = con.sqlRes.getMetaData();
                
                // Obtiene el Numero de Columnas de la Consulta
                iColumnas = mdConsulta.getColumnCount();
                
                // Prepara los datos vacios iniciales
                oFila = new Object[iColumnas];
                                        
                // Ciclo para agregar las columnas                
                for ( int i = 1; i <= iColumnas; i++ ) 
                {
                    // Agrega la Columna al Modelo
                    modelo.addColumn(mdConsulta.getColumnLabel( i ));
                    //if ( i > 1 )
                    //    System.out.print( ", " );
                    //System.out.print( mdConsulta.getColumnLabel( i ) ); // Mostrar nombres de campos
                }
                
                // Coloca el Modelo en la Tabla
                jTable1.setModel(modelo);
        
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Inventariob.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try 
            {
                 // Obtener los datos de la consulta
                 DefaultTableModel tblDatos = (DefaultTableModel) jTable1.getModel();
                 
                // Verifica resultados
                while (con.sqlRes.next())
                {
                    // Ciclo para agregar las columnas                
                    for ( int i = 1; i <= iColumnas; i++ ) 
                    {
                        // Agrega la Columna al Modelo
                       oFila[i-1]=con.sqlRes.getString(i);                        
                    }
                    // Agrega los datos a la tabla
                    tblDatos.addRow(oFila);
                     
                }
                 
                  // Coloca el Modelo de Nueva Cuenta
                  jTable1.setModel(tblDatos);
                
             
                 // Cierra Resultados
                 con.sqlRes.close();
            } 
            catch (SQLException ex) 
            {
                //JOptionPane.showMessageDialorootPane,ex);
                JOptionPane.showMessageDialog(null, "Aqui","Duran Gourmet",JOptionPane.INFORMATION_MESSAGE);                
                //Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        
    }

private void sbProductoBuscaDato(){
        // Variables para Fila y Columns
        int fil, col;
        
        //boolean bEncontro=false;
        String sDato;
        
        // Para contar cuantos encontro
        int iEncontrados=0;
        
        // Pasa a mayúsculas
        sDato = txtBuscar.getText().toUpperCase();
        
        //Limpia selección de la tabla
        jTable1.clearSelection();

        for(fil = 0; fil < jTable1.getRowCount();fil++)
        {
            for(col = 0; col < jTable1.getColumnCount(); col++)
            {              
                 //Obtiene dato contenido en una celda de la tabla
                 String value = (String)jTable1.getValueAt(fil, col);
                 
                 // lo pasa a Mayúsculas
                 value = value.toUpperCase();
                                  
                 //if(value.equals(sDato))
                 if(value.lastIndexOf(sDato)>=0)
                 {     
                       //Selecciona celda si el texto es encontrado     
                       //tblProductos.changeSelection(col, col, bEncontro, bEncontro);
                       
                       jTable1.changeSelection(fil, col, true, false);
                       iEncontrados++;
                      
                 }
             }
           
        }
        
        // Coloca el número de incidencias encontradas
        txtEncontrados.setText(String.valueOf(iEncontrados));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lEncontrados = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        txtEncontrados = new javax.swing.JLabel();
        bAcceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lEncontrados.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lEncontrados.setText("Encontrados");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        txtEncontrados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bAcceptar.setText("Aceptar");
        bAcceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcceptarActionPerformed(evt);
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
                        .addComponent(bBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAcceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lEncontrados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(txtEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bAcceptar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcceptarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow()>=0)
        {
            // Variable para el modelo de la tabla
             DefaultTableModel tblDatos = (DefaultTableModel) jTable1.getModel();
            
            // Obtengo el Codigo de la celda
            varGlobales.sDato = tblDatos.getValueAt(jTable1.getSelectedRow(),0).toString();
            
            // Libera la Forma
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un registro","Duran Gourmet",JOptionPane.INFORMATION_MESSAGE);                
    }//GEN-LAST:event_bAcceptarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
    sbProductoBuscaDato();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
                    //JOptionPane.showMessageDialog(null, "asd","Duran Gourmet",JOptionPane.INFORMATION_MESSAGE);                
            if( evt.getClickCount() == 2 ){
                DefaultTableModel tblDatos = (DefaultTableModel) jTable1.getModel();
            
            //Obtengo el Codigo de la celda
                varGlobales.sDato = tblDatos.getValueAt(jTable1.getSelectedRow(),0).toString();
            
            // Libera la Forma
                this.dispose();
            } 
           
    }//GEN-LAST:event_jTable1MousePressed

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
            java.util.logging.Logger.getLogger(Inventariob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventariob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventariob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventariob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inventariob dialog = new Inventariob(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAcceptar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lEncontrados;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtEncontrados;
    // End of variables declaration//GEN-END:variables
}
