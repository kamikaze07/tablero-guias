/*    */ package sicret;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SColores
/*    */ {
/* 19 */   String dir = System.getProperty("user.dir");
/*    */   
/*    */   public Color PRIMARIO1;
/*    */   
/*    */   public Color PRIMARIO2;
/*    */   
/*    */   public Color SECUNDARIO1;
/*    */   
/*    */   public Color SECUNDARIO2;
/*    */   Color TERCERO1;
/*    */   public Color FONDOCAMPOSELEC;
/*    */   public Color FONDOTABLA;
/*    */   Color REJILLATABLA;
/*    */   String[] num;
/* 33 */   String[] datos = new String[9];
/* 34 */   String TIPOCOLOR = "";
/*    */   
/*    */   public SColores() {
/* 37 */     actVariables();
/* 38 */     if (this.datos.length > 0) {
/* 39 */       this.TIPOCOLOR = this.datos[0];
/* 40 */       this.num = this.datos[1].split(",");
/* 41 */       this.PRIMARIO1 = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 43 */       this.num = this.datos[2].split(",");
/* 44 */       this.PRIMARIO2 = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 46 */       this.num = this.datos[3].split(",");
/* 47 */       this.SECUNDARIO1 = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 49 */       this.num = this.datos[4].split(",");
/* 50 */       this.SECUNDARIO2 = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 52 */       this.num = this.datos[5].split(",");
/* 53 */       this.TERCERO1 = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 55 */       this.num = this.datos[6].split(",");
/* 56 */       this.FONDOCAMPOSELEC = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 58 */       this.num = this.datos[7].split(",");
/* 59 */       this.FONDOTABLA = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */       
/* 61 */       this.num = this.datos[8].split(",");
/* 62 */       this.REJILLATABLA = new Color(Integer.parseInt(this.num[0]), Integer.parseInt(this.num[1]), Integer.parseInt(this.num[2]));
/*    */     } else {
/*    */       
/* 65 */       this.PRIMARIO1 = new Color(246, 60, 60);
/* 66 */       this.PRIMARIO2 = new Color(237, 107, 107);
/*    */       
/* 68 */       this.SECUNDARIO1 = new Color(102, 102, 102);
/* 69 */       this.SECUNDARIO2 = new Color(189, 189, 189);
/*    */       
/* 71 */       this.TERCERO1 = new Color(255, 255, 255);
/*    */       
/* 73 */       this.FONDOCAMPOSELEC = new Color(255, 203, 144);
/*    */       
/* 75 */       this.FONDOTABLA = new Color(239, 239, 144);
/* 76 */       this.REJILLATABLA = new Color(200, 200, 200);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void actVariables() {
/* 81 */     String linea = "";
/* 82 */     int cont = 0;
/*    */     try {
/* 84 */       Reader archivo = new FileReader("Layout.color");
/* 85 */       BufferedReader filtro = new BufferedReader(archivo);
/* 86 */       while ((linea = filtro.readLine()) != null) {
/* 87 */         this.datos[cont] = linea;
/* 88 */         cont++;
/*    */       } 
/* 90 */       filtro.close();
/* 91 */       archivo.close();
/* 92 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/SColores.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */