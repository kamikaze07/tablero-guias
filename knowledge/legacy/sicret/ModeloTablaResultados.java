/*    */ package sicret;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ 
/*    */ public class ModeloTablaResultados extends AbstractTableModel {
/*    */   private Connection conexion;
/*    */   private Statement instruccion;
/*    */   private ResultSet conjuntoResultados;
/*    */   
/*    */   public ModeloTablaResultados(String controlador, String url, String consulta) throws SQLException, ClassNotFoundException {
/* 15 */     Class.forName(controlador);
/* 16 */     this.conexion = DriverManager.getConnection(url);
/* 17 */     this.instruccion = this.conexion.createStatement(1004, 1007);
/* 18 */     this.conectadoALaBaseDeDatos = true;
/* 19 */     establecerConsulta(consulta);
/*    */   } private ResultSetMetaData metaDatos; private int numeroDeFilas; private boolean conectadoALaBaseDeDatos = false;
/*    */   public Class getColumnClass(int columna) throws IllegalStateException {
/* 22 */     if (!this.conectadoALaBaseDeDatos)
/*    */       try {
/* 24 */         String nombreClase = this.metaDatos.getColumnClassName(columna + 1);
/* 25 */         return Class.forName(nombreClase);
/*    */       }
/* 27 */       catch (Exception excepcion) {
/* 28 */         excepcion.printStackTrace();
/*    */       }  
/* 30 */     return Object.class;
/*    */   }
/*    */   public int getColumnCount() throws IllegalStateException {
/* 33 */     if (!this.conectadoALaBaseDeDatos) throw new IllegalStateException("No hay conexion a la base de datos"); 
/*    */     try {
/* 35 */       return this.metaDatos.getColumnCount();
/*    */     }
/* 37 */     catch (SQLException excepcionSQL) {
/* 38 */       excepcionSQL.printStackTrace();
/*    */       
/* 40 */       return 0;
/*    */     } 
/*    */   } public String getColumnName(int columna) throws IllegalStateException {
/* 43 */     if (!this.conectadoALaBaseDeDatos)
/* 44 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/*    */     try {
/* 46 */       return this.metaDatos.getColumnName(columna + 1);
/*    */     }
/* 48 */     catch (SQLException excepcionSQL) {
/* 49 */       excepcionSQL.printStackTrace();
/*    */       
/* 51 */       return "";
/*    */     } 
/*    */   } public int getRowCount() throws IllegalStateException {
/* 54 */     if (!this.conectadoALaBaseDeDatos)
/* 55 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 56 */     return this.numeroDeFilas;
/*    */   }
/*    */   public Object getValueAt(int fila, int columna) throws IllegalStateException {
/* 59 */     if (!this.conectadoALaBaseDeDatos)
/* 60 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/*    */     try {
/* 62 */       this.conjuntoResultados.absolute(fila + 1);
/* 63 */       return this.conjuntoResultados.getObject(columna + 1);
/*    */     }
/* 65 */     catch (SQLException excepcionSQL) {
/* 66 */       excepcionSQL.printStackTrace();
/*    */       
/* 68 */       return "";
/*    */     } 
/*    */   } public void establecerConsulta(String consulta) throws SQLException, IllegalStateException {
/* 71 */     if (!this.conectadoALaBaseDeDatos)
/* 72 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 73 */     this.conjuntoResultados = this.instruccion.executeQuery(consulta);
/* 74 */     this.metaDatos = this.conjuntoResultados.getMetaData();
/* 75 */     this.conjuntoResultados.last();
/* 76 */     this.numeroDeFilas = this.conjuntoResultados.getRow();
/* 77 */     fireTableStructureChanged();
/*    */   }
/*    */   public void desconectarDeLaBaseDeDatos() {
/*    */     try {
/* 81 */       this.instruccion.close();
/* 82 */       this.conexion.close();
/*    */     }
/* 84 */     catch (SQLException excepcionSQL) {
/* 85 */       excepcionSQL.printStackTrace();
/*    */     } finally {
/*    */       
/* 88 */       this.conectadoALaBaseDeDatos = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ModeloTablaResultados.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */