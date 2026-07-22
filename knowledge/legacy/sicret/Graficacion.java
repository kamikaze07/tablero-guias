/*     */ package sicret;
/*     */ 
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Graficacion
/*     */   extends Canvas
/*     */ {
/*  14 */   private double Xpixel = 0.0D, Ypixel = 0.0D;
/*  15 */   private double Xpixel1 = 0.0D; private double Ypixel1 = 0.0D; private int[][] x; private int[][] y;
/*     */   private int numd;
/*     */   private int n;
/*     */   private int MaxX;
/*     */   private int MaxY;
/*     */   private int[] posx;
/*     */   private int[] posy;
/*     */   private int numser;
/*  23 */   private double xmouse = 0.0D; private int inser; private double maxy; private double miny; private double[] etiqx; private double[] etiqy; private double maxx; private double minx; private Color[] c; private int pos_ejex; private int pos_ejey; private double ymouse = 0.0D; private double Ancho; private double Alto; private double miny1; private double maxy1;
/*     */   private double minx1;
/*     */   private double maxx1;
/*     */   private double prop1;
/*     */   private double prop2;
/*  28 */   String Titulo = "DIAGRAMA BHPBA vs QD", Variable1 = "BHPBA", Variable2 = "QD";
/*     */ 
/*     */   
/*     */   public Graficacion() {
/*  32 */     this.numd = 12;
/*  33 */     this.prop1 = 0.0D; this.prop2 = 0.0D;
/*  34 */     this.pos_ejex = 50;
/*  35 */     this.pos_ejey = 450;
/*  36 */     setBackground(Color.white);
/*  37 */     this.numser = 12;
/*  38 */     this.etiqx = new double[this.numd];
/*  39 */     this.etiqy = new double[this.numd];
/*  40 */     this.posx = new int[this.numd];
/*  41 */     this.posy = new int[this.numd];
/*  42 */     this.c = new Color[this.numser];
/*  43 */     this.inser = 0;
/*     */     
/*  45 */     this.c[0] = Color.blue;
/*  46 */     this.c[1] = Color.red;
/*  47 */     this.c[2] = Color.green;
/*  48 */     this.c[3] = Color.darkGray;
/*  49 */     this.c[4] = Color.cyan;
/*  50 */     this.c[5] = Color.black;
/*  51 */     this.c[6] = Color.orange;
/*  52 */     this.c[7] = Color.pink;
/*  53 */     this.c[8] = Color.darkGray;
/*  54 */     this.c[9] = Color.cyan;
/*  55 */     this.c[10] = Color.darkGray;
/*  56 */     this.c[11] = Color.cyan;
/*     */   }
/*     */   
/*     */   public void setDimensiones(double anchos, double altos) {
/*  60 */     this.Ancho = anchos;
/*  61 */     this.Alto = altos;
/*  62 */     this.MaxX = (int)(this.Ancho - 50.0D); this.MaxY = (int)(this.Alto - 50.0D);
/*  63 */     this.pos_ejey = (int)(this.Alto - 50.0D);
/*     */   }
/*     */   
/*     */   void Datos(double[] x, double[] y, double width, double height, String tit, String var1, String var2) {
/*  67 */     this.Ancho = width;
/*  68 */     this.Alto = height;
/*  69 */     this.Titulo = tit;
/*  70 */     this.Variable1 = var1;
/*  71 */     this.Variable2 = var2;
/*  72 */     SerieX(x);
/*  73 */     SerieY(y);
/*  74 */     System.out.println("alto=" + this.Alto + " ancho=" + this.Ancho);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void SerieX(double[] x0) {
/*  82 */     this.n = x0.length;
/*     */ 
/*     */     
/*  85 */     if (this.inser == 0) {
/*     */       
/*  87 */       this.x = new int[this.numser][this.n];
/*  88 */       this.maxx1 = this.minx1 = x0[0];
/*     */       int j;
/*  90 */       for (j = 1; j < this.n; j++) {
/*  91 */         if (x0[j] > this.maxx1)
/*  92 */           this.maxx1 = x0[j]; 
/*  93 */         if (x0[j] < this.minx1) {
/*  94 */           this.minx1 = x0[j];
/*     */         }
/*     */       } 
/*     */       
/*  98 */       this.minx = this.minx1;
/*  99 */       this.maxx = this.maxx1;
/*     */       
/* 101 */       double inc = (this.maxx1 - this.minx1) / this.numd;
/* 102 */       if (Math.abs(this.maxx1 - this.minx1) > 1.0D) {
/* 103 */         if (Math.abs(inc) < 1.0D) {
/* 104 */           inc = 1.0D;
/*     */         } else {
/* 106 */           inc = Math.round(inc + 0.5D);
/*     */         } 
/*     */       }
/* 109 */       for (j = 0; j < this.numd; j++) {
/* 110 */         double aux = this.minx1 + inc * j;
/* 111 */         aux = Math.round(aux * 10000.0D) / 10000.0D;
/* 112 */         this.etiqx[j] = aux;
/* 113 */         this.posx[j] = (int)((this.etiqx[j] - this.minx1) / (this.maxx1 - this.minx1) * (this.MaxX - 50));
/*     */       } 
/*     */       
/* 116 */       if (this.minx1 < 0.0D && this.maxx1 > 0.0D) {
/* 117 */         this.pos_ejex += (int)(-this.minx1 / (this.maxx1 - this.minx1) * (this.MaxX - 50));
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 122 */       this.minx1 = this.minx;
/* 123 */       this.maxx1 = this.maxx;
/*     */     } 
/* 125 */     for (int i = 0; i < this.n; i++) {
/* 126 */       this.x[this.inser][i] = (int)((x0[i] - this.minx1) / (this.maxx - this.minx) * (this.MaxX - 50));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void SerieY(double[] y0) {
/* 135 */     if (this.inser >= this.numser)
/*     */       return; 
/* 137 */     if (this.inser == 0) {
/*     */       
/* 139 */       this.y = new int[this.numser][this.n];
/*     */       
/* 141 */       this.maxy1 = this.miny1 = y0[0];
/*     */       int j;
/* 143 */       for (j = 1; j < this.n; j++) {
/*     */         
/* 145 */         if (y0[j] > this.maxy1) this.maxy1 = y0[j]; 
/* 146 */         if (y0[j] < this.miny1) this.miny1 = 0.0D;
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 151 */       this.maxy = this.maxy1;
/* 152 */       this.miny = this.miny1;
/*     */ 
/*     */       
/* 155 */       double inc = (this.maxy1 - this.miny1) / this.numd;
/*     */       
/* 157 */       if (Math.abs(this.maxy1 - this.miny1) > 1.0D)
/*     */       {
/* 159 */         if (Math.abs(inc) < 1.0D) { inc = 1.0D; }
/* 160 */         else { inc = Math.round(inc + 0.5D); }
/*     */       
/*     */       }
/*     */       
/* 164 */       for (j = 0; j < this.numd; j++) {
/*     */         
/* 166 */         double aux = this.miny1 + inc * j;
/*     */         
/* 168 */         aux = Math.round(aux * 10000.0D) / 10000.0D;
/* 169 */         this.etiqy[j] = aux;
/* 170 */         this.posy[j] = (int)((this.etiqy[j] - this.miny1) / (this.maxy1 - this.miny1) * (this.MaxY - 50));
/*     */       } 
/* 172 */       if (this.miny1 < 0.0D && this.maxy1 > 0.0D) {
/* 173 */         this.pos_ejey = this.MaxY - (int)(-this.miny1 / (this.maxy1 - this.miny1) * (this.MaxY - 50));
/*     */       }
/*     */     } else {
/*     */       
/* 177 */       this.maxy1 = this.maxy;
/* 178 */       this.miny1 = this.miny;
/*     */     } 
/*     */     
/* 181 */     for (int i = 0; i < this.n; i++) {
/* 182 */       this.y[this.inser][i] = (int)((y0[i] - this.miny1) / (this.maxy1 - this.miny1) * (this.MaxY - 50));
/*     */     }
/* 184 */     this.inser++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void GraficarTodo(Graphics g) {
/*     */     int mm;
/* 191 */     g.setColor(Color.black);
/*     */     
/* 193 */     g.drawLine(this.pos_ejex, 0, this.pos_ejex, (int)this.Alto);
/* 194 */     g.drawLine(0, this.pos_ejey, (int)this.Ancho, this.pos_ejey);
/* 195 */     g.drawString(this.Variable1, 10, 20);
/* 196 */     g.drawString(this.Variable2, (getSize()).width / 2 - 40, (getSize()).height - 10);
/* 197 */     g.drawString(this.Titulo, (getSize()).width / 2 - 80, 10); int i;
/* 198 */     for (i = 0; i < this.numd; i++) {
/*     */       
/* 200 */       this.etiqx[i] = (int)(this.etiqx[i] + 0.5D);
/* 201 */       this.etiqy[i] = (int)(this.etiqy[i] + 0.5D);
/* 202 */       g.drawString(Integer.toString((int)this.etiqx[i]), 50 + this.posx[i] - 2, this.pos_ejey + 20);
/* 203 */       g.drawLine(50 + this.posx[i], this.pos_ejey - 5, 50 + this.posx[i], this.pos_ejey + 5);
/*     */       
/* 205 */       g.drawString(Integer.toString((int)this.etiqy[i]), this.pos_ejex - 50, this.MaxY - this.posy[i]);
/* 206 */       g.drawLine(this.pos_ejex - 5, this.MaxY - this.posy[i], this.pos_ejex + 5, this.MaxY - this.posy[i]);
/*     */     } 
/* 208 */     g.setColor(Color.blue);
/*     */     
/* 210 */     if (this.inser > this.numser) { mm = this.numser; }
/* 211 */     else { mm = this.inser; }
/* 212 */      for (int j = 0; j <= mm; j++) {
/*     */       
/* 214 */       g.setColor(Color.blue);
/*     */ 
/*     */       
/* 217 */       for (i = 0; i < this.n - 1; i++) {
/* 218 */         g.drawLine(50 + this.x[j][i], this.MaxY - this.y[j][i], 50 + this.x[j][i + 1], this.MaxY - this.y[j][i + 1]);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 224 */     g.setColor(Color.black);
/* 225 */     g.fillOval((int)(50.0D + this.Xpixel1 - 3.0D), (int)(this.MaxY - this.Ypixel1 - 3.0D), 6, 6);
/*     */   }
/*     */   
/*     */   public void MarcarPunto(double Temp, double entr) {
/* 229 */     this.prop1 = Temp;
/* 230 */     this.prop2 = entr;
/* 231 */     repaint();
/* 232 */     MarcarUbicacion(getGraphics());
/*     */   }
/*     */   
/*     */   public void MarcarUbicacion(Graphics g) {
/* 236 */     g.setColor(Color.red);
/* 237 */     this.Xpixel = (int)((this.prop1 - this.minx1) / (this.maxx - this.minx) * (this.MaxX - 50));
/* 238 */     this.Ypixel = (int)((this.prop2 - this.miny1) / (this.maxy1 - this.miny1) * (this.MaxY - 50));
/* 239 */     g.fillOval((int)(50.0D + this.Xpixel - 3.0D), (int)(this.MaxY - this.Ypixel - 3.0D), 6, 6);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/* 243 */     GraficarTodo(g);
/* 244 */     MarcarUbicacion(g);
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Graficacion.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */