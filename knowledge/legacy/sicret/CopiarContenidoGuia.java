/*    */ package sicret;
/*    */ 
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.datatransfer.Clipboard;
/*    */ import java.awt.datatransfer.StringSelection;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopiarContenidoGuia
/*    */ {
/* 13 */   Map<String, String> DATOS = new LinkedHashMap<>();
/* 14 */   String salto = System.lineSeparator();
/* 15 */   String conte = "";
/*    */   public CopiarContenidoGuia(Map DATOS) {
/* 17 */     DATOS.forEach((x, y) -> this.conte = this.conte + this.conte + ": " + String.valueOf(x) + String.valueOf(y));
/*    */ 
/*    */     
/* 20 */     StringSelection stringSelection = new StringSelection(this.conte);
/* 21 */     Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
/* 22 */     c.setContents(stringSelection, null);
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CopiarContenidoGuia.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */