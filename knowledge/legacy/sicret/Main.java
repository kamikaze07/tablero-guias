/*    */ package sicret;
/*    */ import com.nilo.plaf.nimrod.NimRODLookAndFeel;
/*    */ import com.nilo.plaf.nimrod.NimRODTheme;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ public class Main {
/*    */   public static void main(String[] args) {
/*  8 */     String so = System.getProperty("os.name");
/*  9 */     String tema = "";
/* 10 */     NimRODTheme nt = new NimRODTheme();
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
/* 32 */     nt.setOpacity(80);
/* 33 */     NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
/* 34 */     NimRODLookAndFeel.setCurrentTheme((MetalTheme)nt);
/*    */     
/*    */     try {
/* 37 */       if (so.equals("Linux")) {
/* 38 */         UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
/*    */       } else {
/*    */         
/* 41 */         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*    */ 
/*    */       
/*    */       }
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 49 */     catch (Exception exception) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     Principal prin = new Principal();
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Main.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */