/*    */ package sicret;
/*    */ 
/*    */ import javax.swing.table.DefaultTableModel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends DefaultTableModel
/*    */ {
/*    */   Class[] types;
/*    */   boolean[] canEdit;
/*    */   
/*    */   null(Object[][] arg0, Object[] arg1) {
/* 67 */     super(arg0, arg1);
/* 68 */     this.types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*    */     
/* 70 */     this.canEdit = new boolean[] { false, false, false, false, false, false, false };
/*    */   }
/*    */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 73 */     return this.canEdit[columnIndex];
/*    */   }
/*    */   
/*    */   public Class getColumnClass(int columnIndex) {
/* 77 */     return this.types[columnIndex];
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvTarjetaDeudorMovimiento$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */