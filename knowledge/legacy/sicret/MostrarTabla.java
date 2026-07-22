/*    */ package sicret;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.ResultSetMetaData;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ 
/*    */ public class MostrarTabla extends AbstractTableModel {
/*    */   private Connection conexion;
/*    */   private Statement instruccion;
/*    */   private ResultSet conjuntoResultados;
/*    */   private ResultSetMetaData metaDatos;
/*    */   
/*    */   public MostrarTabla(String consulta, String[] nombres, int NumCampos) throws SQLException, ClassNotFoundException {
/* 17 */     this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sicre", "root", "");
/* 18 */     this.instruccion = this.conexion.createStatement(1004, 1007);
/* 19 */     this.Campos = nombres;
/* 20 */     this.Numero = NumCampos;
/* 21 */     this.conectadoALaBaseDeDatos = true;
/* 22 */     establecerConsulta(consulta);
/*    */   } private int numeroDeFilas; String[] Campos; int Numero; private boolean conectadoALaBaseDeDatos = false;
/*    */   public Class getColumnClass(int columna) throws IllegalStateException {
/* 25 */     if (!this.conectadoALaBaseDeDatos)
/* 26 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/*    */     try {
/* 28 */       String nombreClase = this.metaDatos.getColumnClassName(columna + 1);
/* 29 */       return Class.forName(nombreClase);
/*    */     }
/* 31 */     catch (Exception excepcion) {
/* 32 */       excepcion.printStackTrace();
/*    */       
/* 34 */       return Object.class;
/*    */     } 
/*    */   } public int getColumnCount() throws IllegalStateException {
/* 37 */     if (!this.conectadoALaBaseDeDatos)
/* 38 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 39 */     return this.Numero;
/*    */   }
/*    */   public String getColumnName(int columna) throws IllegalStateException {
/* 42 */     if (!this.conectadoALaBaseDeDatos)
/* 43 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 44 */     return this.Campos[columna];
/*    */   }
/*    */   public int getRowCount() throws IllegalStateException {
/* 47 */     if (!this.conectadoALaBaseDeDatos)
/* 48 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 49 */     return this.numeroDeFilas;
/*    */   }
/*    */   public Object getValueAt(int fila, int columna) throws IllegalStateException {
/* 52 */     if (!this.conectadoALaBaseDeDatos)
/* 53 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/*    */     try {
/* 55 */       this.conjuntoResultados.absolute(fila + 1);
/* 56 */       return this.conjuntoResultados.getObject(columna + 1);
/*    */     }
/* 58 */     catch (SQLException excepcionSQL) {
/* 59 */       excepcionSQL.printStackTrace();
/*    */       
/* 61 */       return "";
/*    */     } 
/*    */   } public void establecerConsulta(String consulta) throws SQLException, IllegalStateException {
/* 64 */     if (!this.conectadoALaBaseDeDatos)
/* 65 */       throw new IllegalStateException("No hay conexion a la base de datos"); 
/* 66 */     this.conjuntoResultados = this.instruccion.executeQuery(consulta);
/* 67 */     this.metaDatos = this.conjuntoResultados.getMetaData();
/* 68 */     this.conjuntoResultados.last();
/* 69 */     this.numeroDeFilas = this.conjuntoResultados.getRow();
/* 70 */     fireTableStructureChanged();
/*    */   }
/*    */   public void desconectarDeLaBaseDeDatos() {
/*    */     try {
/* 74 */       this.instruccion.close();
/* 75 */       this.conexion.close();
/*    */     }
/* 77 */     catch (SQLException excepcionSQL) {
/* 78 */       excepcionSQL.printStackTrace();
/*    */     } finally {
/*    */       
/* 81 */       this.conectadoALaBaseDeDatos = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/MostrarTabla.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */