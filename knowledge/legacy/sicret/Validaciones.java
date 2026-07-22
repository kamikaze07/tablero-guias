/*     */ package sicret;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ 
/*     */ public class Validaciones {
/*   6 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   7 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   8 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   9 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  10 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  11 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  12 */   Errores error = new Errores(false);
/*     */   public void pasarModal(Boolean MODAL) {
/*  14 */     this.error = new Errores(MODAL.booleanValue());
/*     */   }
/*     */   public boolean validarNombres(JComponent comp, String valor, String er) {
/*  17 */     String texto = valor;
/*  18 */     int esp = 0;
/*     */     
/*  20 */     boolean mayor = false, menor = false;
/*  21 */     if (!texto.equals("")) {
/*  22 */       if (texto.length() > 90) {
/*  23 */         this.error.cargarError(comp, "024");
/*  24 */         return true;
/*     */       } 
/*  26 */       if (texto.contains("  ")) {
/*  27 */         this.error.cargarError(comp, "029");
/*  28 */         return true;
/*     */       } 
/*     */       int i;
/*  31 */       for (i = 0; i < texto.length(); i++) {
/*  32 */         if (texto.charAt(i) == ' ') {
/*  33 */           esp++;
/*     */         }
/*     */       } 
/*  36 */       String[] nombres = new String[esp + 1];
/*  37 */       for (i = 0; i <= esp; i++) {
/*  38 */         nombres[i] = "";
/*     */       }
/*  40 */       esp = 0;
/*  41 */       for (i = 0; i < texto.length(); i++) {
/*  42 */         if (texto.charAt(i) == ' ') {
/*  43 */           esp++;
/*     */         } else {
/*     */           
/*  46 */           nombres[esp] = nombres[esp] + nombres[esp];
/*     */         } 
/*     */       } 
/*  49 */       for (i = 0; i < nombres.length; i++) {
/*  50 */         if (nombres[i].length() > 2) {
/*  51 */           menor = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  56 */       if (!menor && nombres.length <= 1) {
/*  57 */         this.error.cargarError(comp, "030");
/*  58 */         return true;
/*     */       } 
/*     */       
/*  61 */       for (i = 0; i < nombres.length; i++) {
/*  62 */         if (nombres[i].length() == 0) {
/*  63 */           this.error.cargarError(comp, "031");
/*  64 */           return true;
/*     */         } 
/*     */         
/*  67 */         String letra = "" + nombres[i].charAt(0);
/*  68 */         String sec = nombres[i].substring(1);
/*  69 */         if (!nombres[i].matches("([A-ZÁÉÍÓÚÑa-záéíóúñ]{0,30})")) {
/*  70 */           this.error.cargarError(comp, er);
/*  71 */           return true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  76 */       if (esp > 4) {
/*  77 */         this.error.cargarError(comp, "028");
/*  78 */         return true;
/*     */       } 
/*     */     } 
/*  81 */     return false;
/*     */   }
/*     */   public boolean validarDireccion(JComponent comp, String valor, String er) {
/*  84 */     String texto = valor;
/*  85 */     int esp = 0;
/*     */     
/*  87 */     boolean mayor = false, menor = false;
/*  88 */     if (!texto.equals("")) {
/*     */       try {
/*  90 */         int num = Integer.parseInt(texto);
/*  91 */         this.error.cargarError(comp, "034");
/*  92 */         return true;
/*     */       }
/*  94 */       catch (NumberFormatException e) {
/*  95 */         if (texto.length() > 90) {
/*  96 */           this.error.cargarError(comp, "024");
/*  97 */           return true;
/*     */         } 
/*  99 */         if (texto.contains("  ")) {
/* 100 */           this.error.cargarError(comp, "029");
/* 101 */           return true;
/*     */         } 
/*     */         int i;
/* 104 */         for (i = 0; i < texto.length(); i++) {
/* 105 */           if (texto.charAt(i) == ' ') {
/* 106 */             esp++;
/*     */           }
/*     */         } 
/* 109 */         String[] nombres = new String[esp + 1];
/* 110 */         for (i = 0; i <= esp; i++) {
/* 111 */           nombres[i] = "";
/*     */         }
/* 113 */         esp = 0;
/* 114 */         for (i = 0; i < texto.length(); i++) {
/* 115 */           if (texto.charAt(i) == ' ') {
/* 116 */             esp++;
/*     */           } else {
/*     */             
/* 119 */             nombres[esp] = nombres[esp] + nombres[esp];
/*     */           } 
/*     */         } 
/* 122 */         for (i = 0; i < nombres.length; i++) {
/* 123 */           if (nombres[i].length() > 2) {
/* 124 */             menor = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 129 */         if (!menor) {
/* 130 */           this.error.cargarError(comp, "030");
/* 131 */           return true;
/*     */         } 
/*     */         
/* 134 */         for (i = 0; i < nombres.length; i++) {
/* 135 */           if (nombres[i].length() == 0) {
/* 136 */             this.error.cargarError(comp, "031");
/* 137 */             return true;
/*     */           } 
/*     */           
/* 140 */           if (!nombres[i].matches("([A-ZÁÉÍÓÚÑa-záéíóúñ0-9]{0,30})")) {
/* 141 */             this.error.cargarError(comp, er);
/* 142 */             return true;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 147 */         if (esp > 9) {
/* 148 */           this.error.cargarError(comp, "047");
/* 149 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/* 153 */     return false;
/*     */   }
/*     */   public boolean validarNumero(JComponent comp, String valor, String er) {
/* 156 */     String texto = valor;
/* 157 */     if (!texto.equals("")) {
/*     */       try {
/* 159 */         int num = Integer.parseInt(texto);
/* 160 */         if (num > 9999) {
/* 161 */           this.error.cargarError(comp, "035");
/* 162 */           return true;
/*     */         } 
/* 164 */         if (num < 1) {
/* 165 */           this.error.cargarError(comp, "037");
/* 166 */           return true;
/*     */         }
/*     */       
/* 169 */       } catch (NumberFormatException e) {
/* 170 */         if (texto.length() > 20) {
/* 171 */           this.error.cargarError(comp, "036");
/* 172 */           return true;
/*     */         } 
/* 174 */         if (!texto.matches("([A-ZÁÉÍÓÚÑa-záéíóúñ0-9\\s/]{0,30})")) {
/* 175 */           this.error.cargarError(comp, "014");
/* 176 */           return true;
/*     */         } 
/* 178 */         if (!texto.matches("\\d+[a-zA-Z]|\\d+\\s+bis|(\\d+\\s+bis+\\s+[a-z])|\\d+|S/N")) {
/* 179 */           this.error.cargarError(comp, er);
/* 180 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/* 184 */     return false;
/*     */   }
/*     */   public boolean validarRegion(JComponent comp, String valor, String er) {
/* 187 */     String texto = valor;
/* 188 */     int esp = 0;
/*     */     
/* 190 */     boolean mayor = false, menor = false;
/* 191 */     if (!texto.equals("")) {
/* 192 */       if (texto.length() > 30) {
/* 193 */         this.error.cargarError(comp, "024");
/* 194 */         return true;
/*     */       } 
/* 196 */       if (texto.contains("  ")) {
/* 197 */         this.error.cargarError(comp, "029");
/* 198 */         return true;
/*     */       } 
/*     */       int i;
/* 201 */       for (i = 0; i < texto.length(); i++) {
/* 202 */         if (texto.charAt(i) == ' ') {
/* 203 */           esp++;
/*     */         }
/*     */       } 
/* 206 */       String[] nombres = new String[esp + 1];
/* 207 */       for (i = 0; i <= esp; i++) {
/* 208 */         nombres[i] = "";
/*     */       }
/* 210 */       esp = 0;
/* 211 */       for (i = 0; i < texto.length(); i++) {
/* 212 */         if (texto.charAt(i) == ' ') {
/* 213 */           esp++;
/*     */         } else {
/*     */           
/* 216 */           nombres[esp] = nombres[esp] + nombres[esp];
/*     */         } 
/*     */       } 
/* 219 */       for (i = 0; i < nombres.length; i++) {
/* 220 */         if (nombres[i].length() > 2) {
/* 221 */           menor = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 226 */       if (!menor) {
/* 227 */         this.error.cargarError(comp, "030");
/* 228 */         return true;
/*     */       } 
/*     */       
/* 231 */       for (i = 0; i < nombres.length; i++) {
/* 232 */         if (nombres[i].length() == 0) {
/* 233 */           this.error.cargarError(comp, "031");
/* 234 */           return true;
/*     */         } 
/*     */         
/* 237 */         String letra = "" + nombres[i].charAt(0);
/* 238 */         String sec = nombres[i].substring(1);
/* 239 */         if (!nombres[i].matches("([A-ZÁÉÍÓÚÑa-záéíóúñ]{0,30})")) {
/* 240 */           this.error.cargarError(comp, er);
/* 241 */           return true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 246 */       if (esp > 4) {
/* 247 */         this.error.cargarError(comp, "028");
/* 248 */         return true;
/*     */       } 
/*     */     } 
/* 251 */     return false;
/*     */   }
/*     */   public boolean validarCorreo(JComponent comp, String valor, String er) {
/* 254 */     String texto = valor;
/* 255 */     if (!texto.equals("")) {
/* 256 */       if (valor.length() > 30) {
/* 257 */         this.error.cargarError(comp, "024");
/* 258 */         return true;
/*     */       } 
/* 260 */       if (!texto.matches("([0-9a-zA-ZñÑ_]{1,20})@([a-zA-ZñÑ]{1,20})(.com)")) {
/* 261 */         this.error.cargarError(comp, er);
/* 262 */         return true;
/*     */       } 
/*     */     } 
/* 265 */     return false;
/*     */   }
/*     */   public boolean validarHora(JComponent comp, String valor) {
/* 268 */     String texto = valor;
/* 269 */     if (!texto.matches("[0-9][0-9]:[0-9][0-9]")) {
/* 270 */       this.error.cargarError(comp, "060");
/* 271 */       return true;
/*     */     } 
/* 273 */     return false;
/*     */   }
/*     */   public boolean validarCodigoPostal(JComponent comp, String valor, String er) {
/* 276 */     String texto = valor;
/* 277 */     if (!texto.equals("")) {
/* 278 */       if (texto.length() != 5) {
/* 279 */         this.error.cargarError(comp, "016");
/* 280 */         return true;
/*     */       } 
/* 282 */       if (texto.contains("-")) {
/* 283 */         this.error.cargarError(comp, "049");
/* 284 */         return true;
/*     */       } 
/*     */       
/*     */       try {
/* 288 */         int codigo = Integer.parseInt(texto);
/* 289 */         return false;
/*     */       }
/* 291 */       catch (NumberFormatException e) {
/* 292 */         this.error.cargarError(comp, "017");
/* 293 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 297 */     return false;
/*     */   }
/*     */   
/*     */   public boolean validarApostrofe(JComponent comp, String Campo, String er) {
/* 301 */     String texto = Campo;
/* 302 */     int total = 0;
/* 303 */     if (!texto.equals("")) {
/*     */       try {
/* 305 */         int n = Integer.parseInt(Campo);
/* 306 */         this.error.cargarError(comp, "034");
/* 307 */         return true;
/*     */       }
/* 309 */       catch (NumberFormatException e) {
/* 310 */         if (texto.length() > 90) {
/* 311 */           this.error.cargarError(comp, "024");
/* 312 */           return true;
/*     */         } 
/* 314 */         int esp = 0;
/* 315 */         boolean menor = false;
/* 316 */         for (int i = 0; i < texto.length(); i++) {
/* 317 */           if (texto.charAt(i) == ' ') {
/* 318 */             esp++;
/* 319 */             total++;
/*     */           } 
/*     */         } 
/* 322 */         String[] nombres = new String[esp + 1]; int j;
/* 323 */         for (j = 0; j <= esp; j++) {
/* 324 */           nombres[j] = "";
/*     */         }
/* 326 */         esp = 0;
/* 327 */         for (j = 0; j < texto.length(); j++) {
/* 328 */           if (texto.charAt(j) == ' ') {
/* 329 */             esp++;
/*     */           } else {
/*     */             
/* 332 */             nombres[esp] = nombres[esp] + nombres[esp];
/*     */           } 
/*     */         } 
/* 335 */         if (texto.contains("  ")) {
/* 336 */           this.error.cargarError(comp, "029");
/* 337 */           return true;
/*     */         } 
/* 339 */         for (j = 0; j < nombres.length; j++) {
/* 340 */           if (nombres[j].length() == 0) {
/* 341 */             this.error.cargarError(comp, "031");
/* 342 */             return true;
/*     */           } 
/*     */         } 
/* 345 */         int cont = 0;
/* 346 */         menor = false; int k;
/* 347 */         for (k = 0; k < nombres.length; k++) {
/* 348 */           if (nombres[k].length() > 2) {
/* 349 */             menor = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 353 */         if (!menor) {
/* 354 */           this.error.cargarError(comp, "030");
/* 355 */           return true;
/*     */         } 
/* 357 */         if (esp > 9) {
/* 358 */           this.error.cargarError(comp, "054");
/* 359 */           return true;
/*     */         } 
/* 361 */         for (k = 0; k < Campo.length(); k++) {
/* 362 */           String apostrofe = "" + Campo.charAt(k);
/* 363 */           if (apostrofe.equals("'") || apostrofe.equals("\"")) {
/* 364 */             this.error.cargarError(comp, er);
/* 365 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 370 */     return false;
/*     */   }
/*     */   public boolean validarTexto(JComponent comp, String Campo, String er) {
/* 373 */     String texto = Campo;
/* 374 */     int total = 0;
/* 375 */     if (!texto.equals("")) {
/* 376 */       if (texto.length() > 999) {
/* 377 */         comp.setBackground(new Color(255, 51, 51));
/* 378 */         JOptionPane.showMessageDialog(null, "El campo no puede contener más de 999 caracteres\nPor favor verifica tu información.");
/* 379 */         return true;
/*     */       } 
/* 381 */       int esp = 0;
/* 382 */       boolean menor = false;
/* 383 */       for (int i = 0; i < texto.length(); i++) {
/* 384 */         if (texto.charAt(i) == ' ') {
/* 385 */           esp++;
/* 386 */           total++;
/*     */         } 
/*     */       } 
/* 389 */       String[] nombres = new String[esp + 1]; int j;
/* 390 */       for (j = 0; j <= esp; j++) {
/* 391 */         nombres[j] = "";
/*     */       }
/* 393 */       esp = 0;
/* 394 */       for (j = 0; j < texto.length(); j++) {
/* 395 */         if (texto.charAt(j) == ' ') {
/* 396 */           esp++;
/*     */         } else {
/*     */           
/* 399 */           nombres[esp] = nombres[esp] + nombres[esp];
/*     */         } 
/*     */       } 
/* 402 */       if (texto.contains("  ")) {
/* 403 */         this.error.cargarError(comp, "029");
/* 404 */         return true;
/*     */       } 
/* 406 */       for (j = 0; j < nombres.length; j++) {
/* 407 */         if (nombres[j].length() == 0) {
/* 408 */           this.error.cargarError(comp, "031");
/* 409 */           return true;
/*     */         } 
/*     */       } 
/* 412 */       int cont = 0;
/* 413 */       menor = false; int k;
/* 414 */       for (k = 0; k < nombres.length; k++) {
/* 415 */         if (nombres[k].length() > 2) {
/* 416 */           menor = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 420 */       if (!menor) {
/* 421 */         this.error.cargarError(comp, "030");
/* 422 */         return true;
/*     */       } 
/* 424 */       for (k = 0; k < Campo.length(); k++) {
/* 425 */         String apostrofe = "" + Campo.charAt(k);
/* 426 */         if (apostrofe.equals("'") || apostrofe.equals("\"")) {
/* 427 */           this.error.cargarError(comp, er);
/* 428 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 433 */     return false;
/*     */   }
/*     */   public boolean validarDigitos(JComponent comp, String valor) {
/* 436 */     float cos = 0.0F;
/* 437 */     if (!valor.equals("")) {
/*     */       try {
/* 439 */         cos = Float.parseFloat(valor);
/* 440 */         if (cos < 1.0F) {
/* 441 */           this.error.cargarError(comp, "049");
/* 442 */           return true;
/*     */         } 
/*     */         
/* 445 */         return false;
/*     */       
/*     */       }
/* 448 */       catch (NumberFormatException n) {
/* 449 */         this.error.cargarError(comp, "055");
/* 450 */         return true;
/*     */       } 
/*     */     }
/* 453 */     return false;
/*     */   }
/*     */   public boolean validarCalle(JComponent comp, String valor, String er) {
/* 456 */     String texto = valor;
/* 457 */     int esp = 0;
/*     */     
/* 459 */     boolean mayor = false, menor = false;
/* 460 */     if (!texto.equals("")) {
/*     */       try {
/* 462 */         int num = Integer.parseInt(texto);
/* 463 */         if (num < 1) {
/* 464 */           this.error.cargarError(comp, "033");
/* 465 */           return true;
/*     */         } 
/* 467 */         if (num > 999) {
/* 468 */           this.error.cargarError(comp, "032");
/* 469 */           return true;
/*     */         } 
/*     */         
/* 472 */         return false;
/*     */       
/*     */       }
/* 475 */       catch (NumberFormatException e) {
/* 476 */         if (texto.length() > 90) {
/* 477 */           this.error.cargarError(comp, "024");
/* 478 */           return true;
/*     */         } 
/* 480 */         if (texto.contains("  ")) {
/* 481 */           this.error.cargarError(comp, "029");
/* 482 */           return true;
/*     */         } 
/*     */         int i;
/* 485 */         for (i = 0; i < texto.length(); i++) {
/* 486 */           if (texto.charAt(i) == ' ') {
/* 487 */             esp++;
/*     */           }
/*     */         } 
/* 490 */         String[] nombres = new String[esp + 1];
/* 491 */         for (i = 0; i <= esp; i++) {
/* 492 */           nombres[i] = "";
/*     */         }
/* 494 */         esp = 0;
/* 495 */         for (i = 0; i < texto.length(); i++) {
/* 496 */           if (texto.charAt(i) == ' ') {
/* 497 */             esp++;
/*     */           } else {
/*     */             
/* 500 */             nombres[esp] = nombres[esp] + nombres[esp];
/*     */           } 
/*     */         } 
/* 503 */         for (i = 0; i < nombres.length; i++) {
/* 504 */           if (nombres[i].length() > 2) {
/* 505 */             menor = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 510 */         if (!menor) {
/* 511 */           this.error.cargarError(comp, "030");
/* 512 */           return true;
/*     */         } 
/*     */         
/* 515 */         for (i = 0; i < nombres.length; i++) {
/* 516 */           if (nombres[i].length() == 0) {
/* 517 */             this.error.cargarError(comp, "031");
/* 518 */             return true;
/*     */           } 
/*     */           
/* 521 */           if (!nombres[i].matches("([A-ZÁÉÍÓÚÑa-záéíóúñ0-9-/.]{0,30})")) {
/* 522 */             this.error.cargarError(comp, er);
/* 523 */             return true;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 528 */         if (esp > 9) {
/* 529 */           this.error.cargarError(comp, "047");
/* 530 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/* 534 */     return false;
/*     */   }
/*     */   public boolean validarDosDecimales(JComponent comp, String valor) {
/* 537 */     String texto = valor;
/* 538 */     if (!texto.equals("")) {
/*     */       try {
/* 540 */         double cant = Double.parseDouble(texto);
/* 541 */         if (texto.length() > 6) {
/* 542 */           this.error.cargarError(comp, "061");
/* 543 */           return true;
/*     */         } 
/* 545 */         if (!texto.contains(".")) {
/* 546 */           this.error.cargarError(comp, "062");
/* 547 */           return true;
/*     */         }
/*     */       
/* 550 */       } catch (NumberFormatException e) {
/* 551 */         this.error.cargarError(comp, "046");
/* 552 */         return true;
/*     */       } 
/*     */     }
/* 555 */     return false;
/*     */   }
/*     */   public boolean validarPuntoDceimal(JComponent comp, String valor) {
/* 558 */     String texto = valor;
/* 559 */     if (!texto.equals("")) {
/*     */       try {
/* 561 */         double cant = Double.parseDouble(texto);
/* 562 */         if (cant < 1.0D) {
/* 563 */           this.error.cargarError(comp, "049");
/* 564 */           return true;
/*     */         }
/*     */       
/* 567 */       } catch (NumberFormatException e) {
/* 568 */         this.error.cargarError(comp, "046");
/* 569 */         return true;
/*     */       } 
/*     */     }
/* 572 */     return false;
/*     */   }
/*     */   public boolean validarSoloNum(JComponent comp, String valor) {
/* 575 */     String texto = valor;
/* 576 */     if (!texto.equals("")) {
/*     */       try {
/* 578 */         int re = Integer.parseInt(valor);
/* 579 */         if (texto.length() > 16) {
/* 580 */           this.error.cargarError(comp, "051");
/* 581 */           return true;
/*     */         } 
/* 583 */         if (Integer.parseInt(texto) < 1) {
/* 584 */           this.error.cargarError(comp, "049");
/* 585 */           return true;
/*     */         } 
/* 587 */         return false;
/*     */       }
/* 589 */       catch (NumberFormatException e) {
/* 590 */         this.error.cargarError(comp, "046");
/* 591 */         return true;
/*     */       } 
/*     */     }
/* 594 */     return false;
/*     */   }
/*     */   public boolean validarNss(JComponent comp, String valor) {
/* 597 */     String texto = valor;
/* 598 */     if (!texto.equals("")) {
/* 599 */       if (texto.length() != 11) {
/* 600 */         this.error.cargarError(comp, "052");
/* 601 */         return true;
/*     */       } 
/* 603 */       if (texto.contains("-")) {
/* 604 */         this.error.cargarError(comp, "049");
/* 605 */         return true;
/*     */       } 
/*     */       try {
/* 608 */         long re = Long.parseLong(texto);
/* 609 */         return false;
/*     */       }
/* 611 */       catch (NumberFormatException e) {
/* 612 */         this.error.cargarError(comp, "046");
/* 613 */         return true;
/*     */       } 
/*     */     } 
/* 616 */     return false;
/*     */   }
/*     */   public boolean validarRFC(JComponent comp, String valor) {
/* 619 */     String texto = valor;
/* 620 */     if (!valor.equals("")) {
/* 621 */       if (!texto.matches("([A-ZÁÉÍÓÚÑa-záéíóúñ0-9]{0,30})")) {
/* 622 */         this.error.cargarError(comp, "014");
/* 623 */         return true;
/*     */       } 
/*     */     } else {
/*     */       
/* 627 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 637 */     return false;
/*     */   }
/*     */   public boolean validarEmpresa(JComponent comp, String valor, String er) {
/* 640 */     String texto = valor;
/* 641 */     int esp = 0;
/*     */     
/* 643 */     boolean mayor = false, menor = false;
/* 644 */     if (!texto.equals("")) {
/* 645 */       if (texto.length() > 90) {
/* 646 */         this.error.cargarError(comp, "024");
/* 647 */         return true;
/*     */       } 
/* 649 */       if (texto.contains("  ")) {
/* 650 */         this.error.cargarError(comp, "029");
/* 651 */         return true;
/*     */       } 
/*     */       int i;
/* 654 */       for (i = 0; i < texto.length(); i++) {
/* 655 */         if (texto.charAt(i) == ' ') {
/* 656 */           esp++;
/*     */         }
/*     */       } 
/* 659 */       String[] nombres = new String[esp + 1];
/* 660 */       for (i = 0; i <= esp; i++) {
/* 661 */         nombres[i] = "";
/*     */       }
/* 663 */       esp = 0;
/* 664 */       for (i = 0; i < texto.length(); i++) {
/* 665 */         if (texto.charAt(i) == ' ') {
/* 666 */           esp++;
/*     */         } else {
/*     */           
/* 669 */           nombres[esp] = nombres[esp] + nombres[esp];
/*     */         } 
/*     */       } 
/* 672 */       for (i = 0; i < nombres.length; i++) {
/* 673 */         if (nombres[i].length() > 2) {
/* 674 */           menor = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 679 */       if (!menor) {
/* 680 */         this.error.cargarError(comp, "030");
/* 681 */         return true;
/*     */       } 
/*     */       
/* 684 */       for (i = 0; i < nombres.length; i++) {
/* 685 */         if (nombres[i].length() == 0) {
/* 686 */           this.error.cargarError(comp, "031");
/* 687 */           return true;
/*     */         } 
/*     */         
/* 690 */         String letra = "" + nombres[i].charAt(0);
/* 691 */         String sec = nombres[i].substring(1);
/* 692 */         if (!nombres[i].matches("([A-ZÁÉÍÓÚÑa-záéíóúñ]{0,30})")) {
/* 693 */           this.error.cargarError(comp, er);
/* 694 */           return true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 699 */       if (esp > 9) {
/* 700 */         System.out.println("entra");
/* 701 */         this.error.cargarError(comp, "028");
/* 702 */         return true;
/*     */       } 
/*     */     } 
/* 705 */     return false;
/*     */   }
/*     */   
/*     */   public boolean validarNumSerie(JComponent comp, String valor) {
/* 709 */     String texto = valor;
/* 710 */     int esp = 0;
/*     */     
/* 712 */     boolean mayor = false, menor = false;
/* 713 */     if (!texto.equals("")) {
/*     */       try {
/* 715 */         int num = Integer.parseInt(texto);
/* 716 */         this.error.cargarError(comp, "034");
/* 717 */         return true;
/*     */       }
/* 719 */       catch (NumberFormatException e) {
/* 720 */         if (texto.length() < 16) {
/* 721 */           this.error.cargarError(comp, "056");
/* 722 */           return true;
/*     */         } 
/* 724 */         if (texto.length() > 16) {
/* 725 */           this.error.cargarError(comp, "057");
/* 726 */           return true;
/*     */         } 
/*     */         
/* 729 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 733 */     return false;
/*     */   }
/*     */   public boolean validarNumMotor(JComponent comp, String valor) {
/* 736 */     String texto = valor;
/* 737 */     int esp = 0;
/*     */     
/* 739 */     boolean mayor = false, menor = false;
/* 740 */     if (!texto.equals("")) {
/*     */       try {
/* 742 */         int num = Integer.parseInt(texto);
/* 743 */         if (texto.length() < 8) {
/* 744 */           this.error.cargarError(comp, "058");
/* 745 */           return true;
/*     */         } 
/* 747 */         if (texto.length() > 8) {
/* 748 */           this.error.cargarError(comp, "059");
/* 749 */           return true;
/*     */         } 
/*     */         
/* 752 */         return false;
/*     */       
/*     */       }
/* 755 */       catch (NumberFormatException e) {
/* 756 */         this.error.cargarError(comp, "046");
/* 757 */         return true;
/*     */       } 
/*     */     }
/* 760 */     return false;
/*     */   }
/*     */   public boolean validarPlacas(JComponent comp, String valor) {
/* 763 */     String texto = valor;
/* 764 */     int esp = 0;
/*     */     
/* 766 */     boolean mayor = false, menor = false;
/* 767 */     if (!texto.equals("")) {
/*     */       try {
/* 769 */         int num = Integer.parseInt(texto);
/* 770 */         this.error.cargarError(comp, "034");
/* 771 */         return true;
/*     */       }
/* 773 */       catch (NumberFormatException e) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 779 */         if (texto.length() > 8) {
/* 780 */           comp.setBackground(new Color(255, 51, 51));
/* 781 */           JOptionPane.showMessageDialog(null, "El campo no puede tener más de 8 caracteres, por favor verifica tu información", "Muchos Caracteres", 0, this.ERROR);
/*     */           
/* 783 */           return true;
/*     */         } 
/*     */         
/* 786 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 790 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Validaciones.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */