/*     */ package sicret;
/*     */ 
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DefaultTableModel
/*     */ {
/*     */   Class[] types;
/*     */   boolean[] canEdit;
/*     */   
/*     */   null(Object[][] arg0, Object[] arg1) {
/* 100 */     super(arg0, arg1);
/* 101 */     this.types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */     
/* 104 */     this.canEdit = new boolean[] { false, false, false, false, false, true };
/*     */   }
/*     */ 
/*     */   
/*     */   public Class getColumnClass(int columnIndex) {
/* 109 */     return this.types[columnIndex];
/*     */   }
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 113 */     return this.canEdit[columnIndex];
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GeneradoraBuscar$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */