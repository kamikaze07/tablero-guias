/*    */ package sicret;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.Map;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableModel;
/*    */ import utilerias.Utilerias;
/*    */ 
/*    */ public class Facturas33CanceladasInternas extends JDialog {
/* 13 */   Consultas2 con = new Consultas2();
/*    */   Date fecha1;
/*    */   Date fecha2;
/*    */   String MONEDA;
/*    */   String TIPO;
/* 18 */   Utilerias utilerias = new Utilerias();
/*    */   String[] LISTAFACTURAS;
/* 20 */   double FLETESCR = 0.0D;
/* 21 */   double FLETESSR = 0.0D;
/* 22 */   double FLETESO = 0.0D;
/* 23 */   double FLETESSUB = 0.0D;
/* 24 */   double INGRESOSACTIVOFIJO = 0.0D;
/* 25 */   double FLETESANTICIPO = 0.0D;
/* 26 */   String CONSULTARLISTARPRODUCTOS = "";
/*    */   Map<String, String> CAMPOSGENERALES;
/* 28 */   int multiplo = 28;
/*    */   
/*    */   public Facturas33CanceladasInternas(Consultas2 con, String[] col, String campos, String tablas, String condicion) {
/* 31 */     this.con = con;
/* 32 */     initComponents();
/* 33 */     this.utilerias.consultaGralTabla(con, this.jTable1, col, campos, tablas, condicion);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   
/*    */   private JTable jTable1;
/*    */ 
/*    */ 
/*    */   
/*    */   private void initComponents() {
/* 47 */     this.jScrollPane1 = new JScrollPane();
/* 48 */     this.jTable1 = new JTable();
/*    */     
/* 50 */     setDefaultCloseOperation(2);
/*    */     
/* 52 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 63 */     this.jScrollPane1.setViewportView(this.jTable1);
/*    */     
/* 65 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 66 */     getContentPane().setLayout(layout);
/* 67 */     layout.setHorizontalGroup(layout
/* 68 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 69 */         .addGroup(layout.createSequentialGroup()
/* 70 */           .addGap(62, 62, 62)
/* 71 */           .addComponent(this.jScrollPane1, -2, 629, -2)
/* 72 */           .addContainerGap(92, 32767)));
/*    */     
/* 74 */     layout.setVerticalGroup(layout
/* 75 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 76 */         .addGroup(layout.createSequentialGroup()
/* 77 */           .addGap(39, 39, 39)
/* 78 */           .addComponent(this.jScrollPane1, -2, -1, -2)
/* 79 */           .addContainerGap(122, 32767)));
/*    */ 
/*    */     
/* 82 */     pack();
/*    */   }
/*    */ 
/*    */   
/*    */   public JTable regresaTabla() {
/* 87 */     return this.jTable1;
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33CanceladasInternas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */