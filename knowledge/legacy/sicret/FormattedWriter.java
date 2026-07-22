/*    */ package sicret;
/*    */ 
/*    */ import java.io.PrintWriter;
/*    */ import java.io.Writer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormattedWriter
/*    */   extends PrintWriter
/*    */ {
/*    */   public static final int LEFT_JUSTIFIED = 1;
/*    */   public static final int RIGHT_JUSTIFIED = 2;
/* 16 */   private int justification = 2;
/*    */   
/* 18 */   private int width = 0;
/*    */ 
/*    */   
/*    */   public FormattedWriter(Writer output, boolean autoflush, int width, int justification) {
/* 22 */     super(output, autoflush);
/* 23 */     if (width > 0)
/* 24 */       this.width = width; 
/* 25 */     if (justification == 1 || justification == 2) {
/* 26 */       this.justification = justification;
/*    */     }
/*    */   }
/*    */   
/*    */   public FormattedWriter(Writer output, int width) {
/* 31 */     this(output, true, width, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public FormattedWriter(Writer output, int width, int justification) {
/* 36 */     this(output, true, width, justification);
/*    */   }
/*    */ 
/*    */   
/*    */   public FormattedWriter(Writer output, boolean autoflush, int width) {
/* 41 */     this(output, autoflush, width, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   private String pad(String str) {
/* 46 */     if (this.width == 0) {
/* 47 */       return str;
/*    */     }
/*    */     
/* 50 */     int blanks = this.width - str.length();
/* 51 */     StringBuffer result = new StringBuffer();
/*    */     
/* 53 */     if (blanks < 0) {
/* 54 */       for (int i = 0; i < this.width; i++)
/* 55 */         result.append('X'); 
/* 56 */       return result.toString();
/*    */     } 
/*    */     
/* 59 */     if (blanks > 0) {
/* 60 */       for (int i = 0; i < blanks; i++) {
/* 61 */         result.append(' ');
/*    */       }
/*    */     }
/* 64 */     result.insert((this.justification == 1) ? 0 : result.length(), str);
/* 65 */     return result.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void print(int value) {
/* 70 */     super.print(pad(String.valueOf(value)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void print(long value) {
/* 75 */     super.print(pad(String.valueOf(value)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void print(double value) {
/* 80 */     super.print(pad(String.valueOf(value)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void print(String str) {
/* 85 */     super.print(pad(str));
/*    */   }
/*    */   
/*    */   public void println(int value) {
/* 89 */     println(pad(String.valueOf(value)));
/*    */   }
/*    */   
/*    */   public void setWidth(int width) {
/* 93 */     if (width >= 0)
/* 94 */       this.width = width; 
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/FormattedWriter.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */