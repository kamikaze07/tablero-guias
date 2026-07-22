/*    */ package sicret;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DatosEnviarCorreo
/*    */ {
/*    */   private boolean enviarCorreo;
/*    */   private String contenido;
/*    */   private String direccion;
/*    */   private String copia;
/*    */   private String tipo;
/*    */   private String asunto;
/*    */   
/*    */   public DatosEnviarCorreo() {}
/*    */   
/*    */   public DatosEnviarCorreo(boolean enviarCorreo, String contenido, String direccion, String copia, String tipo, String asunto) {
/* 21 */     this.enviarCorreo = enviarCorreo;
/* 22 */     this.contenido = contenido;
/* 23 */     this.direccion = direccion;
/* 24 */     this.copia = copia;
/* 25 */     this.tipo = tipo;
/* 26 */     this.asunto = asunto;
/*    */   }
/*    */   
/*    */   public String getAsunto() {
/* 30 */     return this.asunto;
/*    */   }
/*    */   
/*    */   public void setAsunto(String asunto) {
/* 34 */     this.asunto = asunto;
/*    */   }
/*    */   
/*    */   public String getTipo() {
/* 38 */     return this.tipo;
/*    */   }
/*    */   
/*    */   public void setTipo(String tipo) {
/* 42 */     this.tipo = tipo;
/*    */   }
/*    */   
/*    */   public boolean isEnviarCorreo() {
/* 46 */     return this.enviarCorreo;
/*    */   }
/*    */   
/*    */   public void setEnviarCorreo(boolean enviarCorreo) {
/* 50 */     this.enviarCorreo = enviarCorreo;
/*    */   }
/*    */   
/*    */   public String getContenido() {
/* 54 */     return this.contenido;
/*    */   }
/*    */   
/*    */   public void setContenido(String contenido) {
/* 58 */     this.contenido = contenido;
/*    */   }
/*    */   
/*    */   public String getDireccion() {
/* 62 */     return this.direccion;
/*    */   }
/*    */   
/*    */   public void setDireccion(String direccion) {
/* 66 */     this.direccion = direccion;
/*    */   }
/*    */   
/*    */   public String getCopia() {
/* 70 */     return this.copia;
/*    */   }
/*    */   
/*    */   public void setCopia(String copia) {
/* 74 */     this.copia = copia;
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DatosEnviarCorreo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */