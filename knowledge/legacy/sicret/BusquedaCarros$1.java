/*    */ package sicret;
/*    */ 
/*    */ import java.awt.event.FocusAdapter;
/*    */ import java.awt.event.FocusEvent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends FocusAdapter
/*    */ {
/*    */   public void focusGained(FocusEvent evt) {
/* 69 */     BusquedaCarros.this.jTextGanado(BusquedaCarros.this.jTextField1, evt);
/*    */   }
/*    */   public void focusLost(FocusEvent evt) {
/* 72 */     BusquedaCarros.this.jTextPerdido(BusquedaCarros.this.jTextField1, evt);
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/BusquedaCarros$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */