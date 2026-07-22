/*    */ package sicret;
/*    */ 
/*    */ import java.awt.EventQueue;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class registro
/*    */   extends JFrame
/*    */ {
/*    */   public registro() {
/* 15 */     initComponents();
/*    */   }
/*    */ 
/*    */   
/*    */   private void initComponents() {
/* 20 */     setDefaultCloseOperation(3);
/*    */     
/* 22 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 23 */     getContentPane().setLayout(layout);
/* 24 */     layout.setHorizontalGroup(layout
/* 25 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 26 */         .addGap(0, 400, 32767));
/*    */     
/* 28 */     layout.setVerticalGroup(layout
/* 29 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 30 */         .addGap(0, 300, 32767));
/*    */ 
/*    */     
/* 33 */     pack();
/*    */   }
/*    */   public static void main(String[] args) {
/* 36 */     EventQueue.invokeLater(new Runnable() {
/*    */           public void run() {
/* 38 */             (new registro()).setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/registro.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */