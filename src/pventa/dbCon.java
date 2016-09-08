/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pventa;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jahziel
 */
public class dbCon {
    //variable para la coneccion
    static Connection oCon;
    //variable para las consultas
    Statement sqlQuery;
    //variable para los resultados
    ResultSet sqlRes;
    // metodo para abrir la conexion
    int intRes;
    public static String sqlString;
    
    public boolean Conectar(String sConector,String sHost,String sUser,String sPassword){
        try {
            Class.forName(sConector);
            oCon = DriverManager.getConnection(sHost,sUser,sPassword);
            //JOptionPane.showMessageDialog(null,"Bienvenido");
            return true;
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Incorrecto: |"+ex);
            return false;
        }
    } 
    //metodo para cerrar la conexion
    public void CloseCon(){
        try{
            oCon.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: |"+e.toString());
        }
    }
    
    public boolean ExeQuery(String sQuery){
        
        try {
            sqlQuery = oCon.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: |"+e.toString());
            return false;
        }
        
        try{
            sqlRes = sqlQuery.executeQuery(sQuery);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: |"+e.toString());
            return false;
        }
    }
    
    public boolean UpdateQuery(String sQuery){
        try {
            sqlQuery = oCon.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error1 SubQueryExecuteUpdate:createStatement:"+e.getMessage());
            return false;
        }
        
        try {
            intRes = sqlQuery.executeUpdate(sQuery);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error2 SubQueryExecuteUpdate:createStatement:"+e.getMessage());
            return false;
        }
    }

        void SubAutoCommit(boolean bCommit)
    {
        // Coloca el Modo de la transacción
        try 
        {
            oCon.setAutoCommit(bCommit);
        } 
        catch (SQLException ex) 
        {
            // Genera el Looger
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
            
            // Mensaje de Error
            JOptionPane.showMessageDialog(null,"Error voidAutoCommit");               
            
        }

    }
        
    void SubRollBack()
    {
        try 
        {
            oCon.rollback();
        } catch (SQLException ex) 
        {
            // Graba al Logger
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
        
            // Mensaje de Error
            JOptionPane.showMessageDialog(null,"Error RollBack");               

        }
    }
    
    void SubCommit()
    {
        try {
            oCon.commit();
        } catch (SQLException ex) 
        {
            // Graba al Logger
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
            
            // Mensaje de Error
            JOptionPane.showMessageDialog(null,"Error Commit");               
        }
    }

}

