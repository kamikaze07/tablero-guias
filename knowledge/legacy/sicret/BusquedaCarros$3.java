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
/* 104 */     super(arg0, arg1);
/* 105 */     this.types = new Class[] { Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */     
/* 108 */     this.canEdit = new boolean[] { false, false, false, true };
/*     */   }
/*     */   
/*     */   public Class getColumnClass(int columnIndex) {
/* 112 */     return this.types[columnIndex];
/*     */   }
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 115 */     return this.canEdit[columnIndex];
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/BusquedaCarros$3.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */