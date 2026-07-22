/*     */ package sicret;
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
/*     */ public class Esperando
/*     */   implements Runnable
/*     */ {
/*     */   Thread t;
/* 214 */   int cont = 0;
/*     */   
/*     */   Esperando() {
/* 217 */     this.t = new Thread(this);
/* 218 */     this.t.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {}
/*     */   
/*     */   public void run() {
/*     */     try {
/*     */       while (true) {
/* 227 */         MensajePop.this.FOLIOANT = MensajePop.this.FOLIONUE;
/* 228 */         Thread.currentThread(); Thread.sleep(12000L);
/* 229 */         MensajePop.this.cargar();
/* 230 */         if (!MensajePop.this.FOLIOANT.equals(MensajePop.this.FOLIONUE) && !MensajePop.this.FOLIOANT.equals("")) {
/* 231 */           MensajePop.this.actVariables();
/* 232 */           String depa = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 5];
/* 233 */           System.out.println("mensaje pop: " + MensajePop.this.DEPARTAMENTOS + " " + depa);
/* 234 */           if (MensajePop.this.DEPARTAMENTOS.contains(depa)) {
/* 235 */             String msj = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 4];
/* 236 */             String tit = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 3];
/* 237 */             String tipo = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 2];
/* 238 */             MensajePop.this.Mensaje(msj, tit, tipo);
/*     */           } 
/*     */         } 
/*     */       } 
/* 242 */     } catch (InterruptedException interruptedException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/MensajePop$Esperando.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */