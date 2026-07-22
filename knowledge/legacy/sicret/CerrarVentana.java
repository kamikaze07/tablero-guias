/*    */ package sicret;
/*    */ 
/*    */ import java.awt.Dialog;
/*    */ import java.awt.Frame;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.AbstractAction;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.InputMap;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JRootPane;
/*    */ import javax.swing.KeyStroke;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CerrarVentana
/*    */   extends JDialog
/*    */ {
/*    */   public CerrarVentana(Frame owner) {
/* 22 */     super(owner, true);
/*    */   }
/*    */   
/*    */   public CerrarVentana(Dialog owner) {
/* 26 */     super(owner, true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected JRootPane createRootPane() {
/* 31 */     JRootPane rootPane = new JRootPane();
/* 32 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 33 */     Action actionListener = new AbstractAction() {
/*    */         public void actionPerformed(ActionEvent actionEvent) {
/* 35 */           CerrarVentana.this.setVisible(false);
/*    */         }
/*    */       };
/* 38 */     InputMap inputMap = rootPane.getInputMap(2);
/* 39 */     inputMap.put(stroke, "ESCAPE");
/* 40 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 41 */     return rootPane;
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CerrarVentana.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */