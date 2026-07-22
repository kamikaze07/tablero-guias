/*     */ package sicret;
/*     */ 
/*     */ public class NumerosALetras
/*     */ {
/*   5 */   private String[] Unidad = new String[] { "Cero", "Un", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciseis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  10 */   private String[] Decena = new String[] { "Veinti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa" };
/*     */   
/*  12 */   private String[] Centena = new String[] { "Cien", "Doscientos", "Trescientos", "Cuatrocientos", "Quinientos", "Seiscientos", "Setecientos", "Ochocientos", "Novecientos", " Mil", "Un Millon", " Millones", "Un Billon", " Billones" };
/*     */ 
/*     */ 
/*     */   
/*  16 */   private long Valororiginal = 0L;
/*     */   
/*  18 */   String LETRA = "";
/*     */   
/*  20 */   String SUBFIJO = "";
/*     */   
/*  22 */   String DECIMALES = "";
/*     */   
/*     */   public NumerosALetras(double num, String MONEDA) {
/*  25 */     String numero = "" + num;
/*  26 */     boolean blanco = false;
/*  27 */     int indice = numero.indexOf(".");
/*  28 */     String sDECI = numero.substring(indice + 1, numero.length());
/*  29 */     if (sDECI.length() == 0) {
/*  30 */       sDECI = "00";
/*  31 */     } else if (sDECI.length() == 1) {
/*  32 */       sDECI = sDECI + "0";
/*     */     } 
/*  34 */     this.DECIMALES = sDECI.substring(0, 2);
/*  35 */     long conv = Long.parseLong(numero.substring(0, indice));
/*  36 */     String aux = toLetras(conv).toUpperCase();
/*  37 */     aux = aux + " " + aux + ", " + MONEDA + "/100 ";
/*  38 */     for (int i = 0; i < aux.length(); i++) {
/*  39 */       if (i > 0) {
/*  40 */         if (aux.charAt(i) == ' ') {
/*  41 */           if (this.LETRA.charAt(this.LETRA.length() - 1) != ' ') {
/*  42 */             this.LETRA += this.LETRA;
/*     */           }
/*     */         } else {
/*  45 */           this.LETRA += this.LETRA;
/*     */         } 
/*     */       } else {
/*  48 */         this.LETRA += this.LETRA;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String regresaNumero() {
/*  54 */     return this.LETRA;
/*     */   }
/*     */   
/*     */   private String getUnidad(long Numero) {
/*  58 */     String aux = "";
/*  59 */     for (int p = 0; p <= 20; p++) {
/*  60 */       if (Numero == p) {
/*  61 */         aux = this.Unidad[p] + " ";
/*  62 */         return aux;
/*     */       } 
/*     */     } 
/*  65 */     return " ";
/*     */   }
/*     */   
/*     */   private String getDecena(long Numero) {
/*  69 */     String aux = "";
/*  70 */     long pf = Numero % 10L;
/*  71 */     long pi = Numero / 10L;
/*  72 */     int p = 0;
/*  73 */     boolean sal = false;
/*     */     while (true) {
/*  75 */       if ((((p <= 8) ? 1 : 0) & (!sal ? 1 : 0)) != 0) {
/*  76 */         if (pi == (p + 2)) {
/*  77 */           aux = this.Decena[p];
/*  78 */           sal = true;
/*     */         } 
/*  80 */         p++;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*  85 */     if (pf == 0L) {
/*  86 */       return aux + " ";
/*     */     }
/*  88 */     if ((((Numero > 20L) ? 1 : 0) & ((Numero < 30L) ? 1 : 0)) != 0) {
/*  89 */       return aux + aux + " ";
/*     */     }
/*  91 */     return aux + " y " + aux + " ";
/*     */   }
/*     */   
/*     */   private String getCentena(long Numero) {
/*  95 */     String aux = "", aux2 = "";
/*  96 */     long pf = Numero % 100L;
/*  97 */     long pi = Numero / 100L;
/*  98 */     int p = 0;
/*  99 */     boolean sal = false;
/*     */     while (true) {
/* 101 */       if ((((p <= 10) ? 1 : 0) & (!sal ? 1 : 0)) != 0) {
/* 102 */         if (pi == (p + 1)) {
/* 103 */           aux = this.Centena[p];
/* 104 */           sal = true;
/*     */         } 
/* 106 */         p++;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 111 */     if (pf == 0L) {
/* 112 */       return aux;
/*     */     }
/* 114 */     if (pf < 21L) {
/* 115 */       aux2 = getUnidad(pf);
/*     */     } else {
/* 117 */       aux2 = getDecena(pf);
/*     */     } 
/* 119 */     if (Numero < 200L) {
/* 120 */       return aux + "to " + aux + " ";
/*     */     }
/* 122 */     return aux + " " + aux + " ";
/*     */   }
/*     */   
/*     */   private String getMil(long Numero) {
/* 126 */     String aux = "", aux2 = "";
/* 127 */     long pf = Numero % 1000L;
/* 128 */     long pi = Numero / 1000L;
/* 129 */     long p = 0L;
/* 130 */     if (Numero == 1000L) {
/* 131 */       return "MIL";
/*     */     }
/* 133 */     if ((((Numero > 1000L) ? 1 : 0) & ((Numero < 1999L) ? 1 : 0)) != 0) {
/* 134 */       aux = this.Centena[9] + " ";
/*     */     } else {
/* 136 */       aux = resolverIntervalo(pi) + resolverIntervalo(pi) + " ";
/*     */     } 
/* 138 */     if (pf != 0L) {
/* 139 */       return aux + aux + " ";
/*     */     }
/* 141 */     return aux;
/*     */   }
/*     */   
/*     */   private String getMillon(long Numero) {
/* 145 */     String aux = "", aux2 = "";
/* 146 */     long pf = Numero % 1000000L;
/* 147 */     long pi = Numero / 1000000L;
/* 148 */     long p = 0L;
/* 149 */     if ((((Numero > 1000000L) ? 1 : 0) & ((Numero < 1999999L) ? 1 : 0)) != 0) {
/* 150 */       aux = this.Centena[10] + " ";
/*     */     } else {
/* 152 */       aux = resolverIntervalo(pi) + resolverIntervalo(pi) + " ";
/*     */     } 
/* 154 */     if (pf != 0L) {
/* 155 */       return aux + aux + " ";
/*     */     }
/* 157 */     return aux;
/*     */   }
/*     */   
/*     */   private String getBillon(long Numero) {
/* 161 */     String aux = "", aux2 = "";
/* 162 */     long pf = Numero % 1000000000L;
/* 163 */     long pi = Numero / 1000000000L;
/* 164 */     long p = 0L;
/* 165 */     if ((((Numero > 1000000000L) ? 1 : 0) & ((Numero < 1999999999L) ? 1 : 0)) != 0) {
/* 166 */       aux = this.Centena[12] + " ";
/*     */     } else {
/* 168 */       aux = resolverIntervalo(pi) + resolverIntervalo(pi) + " ";
/*     */     } 
/* 170 */     if (pf != 0L) {
/* 171 */       return aux + aux + " ";
/*     */     }
/* 173 */     return aux;
/*     */   }
/*     */   
/*     */   private String resolverIntervalo(long Numero) {
/* 177 */     if ((((Numero >= 0L) ? 1 : 0) & ((Numero <= 20L) ? 1 : 0)) != 0) {
/* 178 */       return getUnidad(Numero);
/*     */     }
/* 180 */     if ((((Numero >= 21L) ? 1 : 0) & ((Numero <= 99L) ? 1 : 0)) != 0) {
/* 181 */       return getDecena(Numero);
/*     */     }
/* 183 */     if ((((Numero >= 100L) ? 1 : 0) & ((Numero <= 999L) ? 1 : 0)) != 0) {
/* 184 */       return getCentena(Numero);
/*     */     }
/* 186 */     if ((((Numero >= 1000L) ? 1 : 0) & ((Numero <= 999999L) ? 1 : 0)) != 0) {
/* 187 */       return getMil(Numero);
/*     */     }
/* 189 */     if ((((Numero >= 1000000L) ? 1 : 0) & ((Numero <= 999999999L) ? 1 : 0)) != 0) {
/* 190 */       return getMillon(Numero);
/*     */     }
/* 192 */     if ((((Numero >= 1000000000L) ? 1 : 0) & ((Numero <= 2000000000L) ? 1 : 0)) != 0) {
/* 193 */       return getBillon(Numero);
/*     */     }
/* 195 */     return "<<El numero esta fuera del rango>>";
/*     */   }
/*     */   
/*     */   public String toLetras(long Numero) {
/* 199 */     this.Valororiginal = Numero;
/* 200 */     if (Numero >= 0L) {
/* 201 */       return resolverIntervalo(Numero);
/*     */     }
/* 203 */     return " Menos " + resolverIntervalo(Numero * -1L);
/*     */   }
/*     */   
/*     */   public boolean pausa(long p) {
/*     */     try {
/* 208 */       Thread.sleep(p);
/* 209 */     } catch (Exception exception) {}
/*     */     
/* 211 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/NumerosALetras.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */