/*    */ package sicret;
/*    */ import java.io.PrintWriter;
/*    */ 
/*    */ public class cargarDatos {
/*  5 */   String clase = "";
/*    */   public cargarDatos(String clase) {
/*  7 */     this.clase = clase;
/*    */   }
/*    */   public void escribir() {
/*    */     try {
/* 11 */       FileWriter fw = new FileWriter("datos.tmp");
/* 12 */       BufferedWriter bw = new BufferedWriter(fw);
/* 13 */       PrintWriter salida = new PrintWriter(bw);
/* 14 */       salida.print(this.clase);
/* 15 */       salida.close();
/*    */     }
/* 17 */     catch (IOException ioex) {
/* 18 */       System.out.println("se presento el error: " + ioex.toString());
/*    */     } 
/*    */   }
/*    */   public void eliminar() {
/* 22 */     File archivo = new File("datos.tmp");
/* 23 */     archivo.delete();
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/cargarDatos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */