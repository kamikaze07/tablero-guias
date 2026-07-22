/*     */ package sicret;
/*     */ import Fuentes.Fuentes;
/*     */ import com.bolivia.label.CLabel;
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.InputMap;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import principal.MaterialButton;
/*     */ import utilerias.Utilerias;
/*     */ 
/*     */ public class Gafete2020 extends JDialog {
/*  42 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  43 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  49 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  50 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  51 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*  52 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*     */ 
/*     */   
/*     */   Map<String, String> CAMPOSGENERALES;
/*     */ 
/*     */   
/*  58 */   SColores lc = new SColores();
/*  59 */   Fuentes fuentes = new Fuentes();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int xx;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int xy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   String[] DATOS = null;
/*  89 */   fotoIndividual cargar = null;
/*  90 */   String ruta = "";
/*  91 */   String FOTO = ""; private CLabel cLabel1; private JDateChooser jDateChooser8; private JLabel jLabel1; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104;
/*  92 */   Utilerias utilerias = new Utilerias(); private JLabel jLabel11; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel128; private JLabel jLabel13; private JLabel jLabel2; private JLabel jLabel3;
/*     */   
/*     */   public Gafete2020(Frame parent, boolean modal, Map<String, String> CAMPOSGENERALES, String[] DATOS) {
/*  95 */     super(parent, modal);
/*  96 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  97 */     this.DATOS = DATOS;
/*  98 */     initComponents();
/*     */     
/* 100 */     this.jLabel100.setText("<html>" + DATOS[1] + "</html>");
/* 101 */     this.jLabel101.setText("<html><center>" + DATOS[2] + "</center></html>");
/* 102 */     this.jLabel102.setText("<html><center><u><b>VIGENCIA:</b> " + DATOS[3] + "</u></center></html>");
/* 103 */     this.jLabel103.setText("<html><center><b>NSS:</b> " + DATOS[4] + "</center></html>");
/* 104 */     this.jLabel104.setText("<html><center><b>CURP:</b> " + DATOS[5] + "</center></html>");
/* 105 */     this.jLabel6.setText("<html><center> " + (String)this.CAMPOSGENERALES.get("direccionCompleta") + "</center></html>");
/*     */     
/* 107 */     this.cLabel1.setIcon(null);
/* 108 */     this.cLabel1.setText("Cargando...");
/* 109 */     this.cargar = new fotoIndividual(DATOS[0]);
/*     */     
/* 111 */     int w = this.tama.width;
/* 112 */     int h = this.tama.height;
/* 113 */     int rw = (w - 630) / 2;
/* 114 */     int rh = (h - 785) / 2;
/* 115 */     setLocation(rw, rh);
/* 116 */     setSize(697, 530);
/* 117 */     setLocationRelativeTo(null);
/* 118 */     setResizable(false);
/* 119 */     setResizable(false);
/* 120 */     setVisible(true);
/*     */   }
/*     */   private JLabel jLabel33; private JLabel jLabel35; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JPanel jPanel1; private JPanel jPanel11; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel50; private JPanel jPanel80; private MaterialButton materialButton22;
/*     */   private MaterialButton materialButton23;
/*     */   
/*     */   private void initComponents() {
/* 126 */     this.jPanel20 = new JPanel();
/* 127 */     this.jLabel119 = new JLabel();
/* 128 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 129 */     this.jLabel3 = new JLabel();
/* 130 */     this.jPanel11 = new JPanel();
/* 131 */     this.jPanel50 = new JPanel();
/* 132 */     this.jLabel33 = new JLabel();
/* 133 */     this.jPanel80 = new JPanel();
/* 134 */     this.jLabel128 = new JLabel();
/* 135 */     this.jLabel35 = new JLabel();
/* 136 */     this.jPanel1 = new JPanel();
/* 137 */     this.jPanel2 = new JPanel();
/* 138 */     this.jLabel1 = new JLabel();
/* 139 */     this.jLabel2 = new JLabel();
/* 140 */     this.cLabel1 = new CLabel();
/* 141 */     this.jLabel100 = new JLabel();
/* 142 */     this.jLabel101 = new JLabel();
/* 143 */     this.jLabel102 = new JLabel();
/* 144 */     this.jLabel103 = new JLabel();
/* 145 */     this.jLabel104 = new JLabel();
/* 146 */     this.jLabel6 = new JLabel();
/* 147 */     this.jPanel3 = new JPanel();
/* 148 */     this.jLabel4 = new JLabel();
/* 149 */     this.jLabel11 = new JLabel();
/* 150 */     this.jLabel12 = new JLabel();
/* 151 */     this.jLabel13 = new JLabel();
/* 152 */     this.jLabel5 = new JLabel();
/* 153 */     this.jPanel4 = new JPanel();
/* 154 */     this.materialButton22 = new MaterialButton();
/* 155 */     this.materialButton23 = new MaterialButton();
/*     */     
/* 157 */     this.jLabel119.setText("Ingresa la vigencia");
/*     */     
/* 159 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 160 */     this.jDateChooser8.setIcon(this.icon);
/*     */     
/* 162 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 163 */     this.jPanel20.setLayout(jPanel20Layout);
/* 164 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 165 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 166 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 167 */           .addContainerGap()
/* 168 */           .addComponent(this.jLabel119, -2, 115, 32767)
/* 169 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 170 */           .addComponent((Component)this.jDateChooser8, -2, 108, -2)
/* 171 */           .addContainerGap()));
/*     */     
/* 173 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 174 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 175 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 176 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 177 */             .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 178 */             .addComponent(this.jLabel119, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 179 */           .addContainerGap()));
/*     */ 
/*     */     
/* 182 */     this.jLabel3.setHorizontalAlignment(0);
/* 183 */     this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Recurso 10.png")));
/*     */     
/* 185 */     setDefaultCloseOperation(2);
/* 186 */     setUndecorated(true);
/*     */     
/* 188 */     this.jPanel11.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*     */     
/* 190 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 192 */     this.jLabel33.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 193 */     this.jLabel33.setForeground(new Color(255, 255, 255));
/* 194 */     this.jLabel33.setHorizontalAlignment(0);
/* 195 */     this.jLabel33.setText("Impresión de Gafetes");
/* 196 */     this.jLabel33.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent evt) {
/* 198 */             Gafete2020.this.jLabel33MouseDragged(evt);
/*     */           }
/*     */         });
/* 201 */     this.jLabel33.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 203 */             Gafete2020.this.jLabel33MouseClicked(evt);
/*     */           }
/*     */         });
/*     */     
/* 207 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/* 208 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*     */     
/* 210 */     this.jLabel128.setHorizontalAlignment(0);
/* 211 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 212 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 214 */             Gafete2020.this.jLabel128MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 217 */             Gafete2020.this.jLabel128MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 220 */             Gafete2020.this.jLabel128MouseExited(evt);
/*     */           }
/*     */         });
/* 223 */     this.jPanel80.add(this.jLabel128);
/*     */     
/* 225 */     this.jLabel35.setHorizontalAlignment(0);
/* 226 */     this.jLabel35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/id-card.png")));
/*     */     
/* 228 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 229 */     this.jPanel50.setLayout(jPanel50Layout);
/* 230 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 231 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 232 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 233 */           .addGap(1, 1, 1)
/* 234 */           .addComponent(this.jLabel35, -2, 36, -2)
/* 235 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 236 */           .addComponent(this.jLabel33, -1, -1, 32767)
/* 237 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 238 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*     */     
/* 240 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 241 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 242 */         .addComponent(this.jPanel80, -1, -1, 32767)
/* 243 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 244 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 245 */             .addComponent(this.jLabel35, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 246 */             .addComponent(this.jLabel33, -2, 30, -2))
/* 247 */           .addGap(0, 0, 32767)));
/*     */ 
/*     */     
/* 250 */     this.jPanel1.setLayout(new GridLayout(1, 2, 12, 0));
/*     */     
/* 252 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 253 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 254 */     this.jPanel2.setLayout((LayoutManager)null);
/*     */     
/* 256 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Recurso 11.png")));
/* 257 */     this.jPanel2.add(this.jLabel1);
/* 258 */     this.jLabel1.setBounds(0, 0, 65, 450);
/*     */     
/* 260 */     this.jLabel2.setHorizontalAlignment(0);
/* 261 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis120x.png")));
/* 262 */     this.jPanel2.add(this.jLabel2);
/* 263 */     this.jLabel2.setBounds(75, 10, 260, 120);
/*     */     
/* 265 */     this.cLabel1.setBackground(this.lc.FONDOTABLA);
/* 266 */     this.cLabel1.setForeground(this.lc.PRIMARIO2);
/* 267 */     this.cLabel1.setText("");
/* 268 */     this.cLabel1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 269 */     this.cLabel1.setLineBorder(3);
/* 270 */     this.cLabel1.setLineColor(Color.red);
/* 271 */     this.jPanel2.add((Component)this.cLabel1);
/* 272 */     this.cLabel1.setBounds(157, 140, 100, 100);
/*     */     
/* 274 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 12.0F));
/*     */     
/* 276 */     this.jLabel100.setHorizontalAlignment(0);
/* 277 */     this.jLabel100.setText("PR-0001");
/* 278 */     this.jPanel2.add(this.jLabel100);
/* 279 */     this.jLabel100.setBounds(70, 240, 270, 20);
/*     */     
/* 281 */     this.jLabel101.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*     */     
/* 283 */     this.jLabel101.setHorizontalAlignment(0);
/* 284 */     this.jLabel101.setText("PR-0001");
/* 285 */     this.jPanel2.add(this.jLabel101);
/* 286 */     this.jLabel101.setBounds(70, 270, 270, 40);
/*     */     
/* 288 */     this.jLabel102.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*     */     
/* 290 */     this.jLabel102.setHorizontalAlignment(0);
/* 291 */     this.jLabel102.setText("VIGENCIA");
/* 292 */     this.jLabel102.setCursor(new Cursor(12));
/* 293 */     this.jLabel102.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 295 */             Gafete2020.this.jLabel102MouseClicked(evt);
/*     */           }
/*     */         });
/* 298 */     this.jPanel2.add(this.jLabel102);
/* 299 */     this.jLabel102.setBounds(70, 330, 270, 20);
/*     */     
/* 301 */     this.jLabel103.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*     */     
/* 303 */     this.jLabel103.setHorizontalAlignment(0);
/* 304 */     this.jLabel103.setText("NSS");
/* 305 */     this.jPanel2.add(this.jLabel103);
/* 306 */     this.jLabel103.setBounds(70, 350, 270, 20);
/*     */     
/* 308 */     this.jLabel104.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*     */     
/* 310 */     this.jLabel104.setHorizontalAlignment(0);
/* 311 */     this.jLabel104.setText("CURP");
/* 312 */     this.jPanel2.add(this.jLabel104);
/* 313 */     this.jLabel104.setBounds(70, 370, 270, 20);
/*     */     
/* 315 */     this.jLabel6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 9.0F));
/*     */     
/* 317 */     this.jLabel6.setHorizontalAlignment(0);
/* 318 */     this.jLabel6.setText("<html><center>| Carretera Cardel km 5 | <br>| Col. Nueva Era | Veracruz, Ver |<br> | Tel: (229) 924 86 00, 01, 02 y 03 | </center></html>");
/* 319 */     this.jPanel2.add(this.jLabel6);
/* 320 */     this.jLabel6.setBounds(70, 400, 270, 50);
/*     */     
/* 322 */     this.jPanel1.add(this.jPanel2);
/*     */     
/* 324 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/* 325 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 326 */     this.jPanel3.setLayout((LayoutManager)null);
/*     */     
/* 328 */     this.jLabel4.setHorizontalAlignment(0);
/* 329 */     this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Recurso 12.png")));
/* 330 */     this.jPanel3.add(this.jLabel4);
/* 331 */     this.jLabel4.setBounds(1, 320, 340, 135);
/*     */     
/* 333 */     this.jLabel11.setHorizontalAlignment(0);
/* 334 */     this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Recurso 13.png")));
/* 335 */     this.jPanel3.add(this.jLabel11);
/* 336 */     this.jLabel11.setBounds(1, 0, 340, 70);
/*     */     
/* 338 */     this.jLabel12.setHorizontalAlignment(0);
/* 339 */     this.jLabel12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/qr_img.png")));
/* 340 */     this.jPanel3.add(this.jLabel12);
/* 341 */     this.jLabel12.setBounds(40, 290, 260, 110);
/*     */     
/* 343 */     this.jLabel13.setHorizontalAlignment(0);
/* 344 */     this.jLabel13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.jpg")));
/* 345 */     this.jPanel3.add(this.jLabel13);
/* 346 */     this.jLabel13.setBounds(40, 10, 260, 120);
/*     */     
/* 348 */     this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Recurso16.png")));
/* 349 */     this.jPanel3.add(this.jLabel5);
/* 350 */     this.jLabel5.setBounds(80, 160, 180, 90);
/*     */     
/* 352 */     this.jPanel1.add(this.jPanel3);
/*     */     
/* 354 */     this.jPanel4.setLayout(new GridLayout(1, 2, 120, 0));
/*     */     
/* 356 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/* 357 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 358 */     this.materialButton22.setText("Imprimir Frente");
/* 359 */     this.materialButton22.setToolTipText("Imprimir Frente");
/* 360 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 361 */     this.materialButton22.setHorizontalTextPosition(0);
/* 362 */     this.materialButton22.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 364 */             Gafete2020.this.materialButton22ActionPerformed(evt);
/*     */           }
/*     */         });
/* 367 */     this.jPanel4.add((Component)this.materialButton22);
/*     */     
/* 369 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/* 370 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 371 */     this.materialButton23.setText("Imprimir Reverso");
/* 372 */     this.materialButton23.setToolTipText("Imprimir Reverso");
/* 373 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 374 */     this.materialButton23.setHorizontalTextPosition(0);
/* 375 */     this.materialButton23.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 377 */             Gafete2020.this.materialButton23ActionPerformed(evt);
/*     */           }
/*     */         });
/* 380 */     this.jPanel4.add((Component)this.materialButton23);
/*     */     
/* 382 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 383 */     this.jPanel11.setLayout(jPanel11Layout);
/* 384 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 386 */         .addComponent(this.jPanel1, -1, -1, 32767)
/* 387 */         .addComponent(this.jPanel50, -1, -1, 32767)
/* 388 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 389 */           .addContainerGap(92, 32767)
/* 390 */           .addComponent(this.jPanel4, -2, 515, -2)
/* 391 */           .addGap(88, 88, 88)));
/*     */     
/* 393 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 395 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 396 */           .addComponent(this.jPanel50, -2, -1, -2)
/* 397 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 398 */           .addComponent(this.jPanel1, -1, 447, 32767)
/* 399 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 400 */           .addComponent(this.jPanel4, -2, 38, -2)));
/*     */ 
/*     */     
/* 403 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 404 */     getContentPane().setLayout(layout);
/* 405 */     layout.setHorizontalGroup(layout
/* 406 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 407 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*     */     
/* 409 */     layout.setVerticalGroup(layout
/* 410 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 411 */         .addComponent(this.jPanel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/*     */     
/* 414 */     pack();
/*     */   }
/*     */   
/*     */   private void materialButton22ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 419 */       String foto = this.ruta + "/" + this.ruta + ".png";
/* 420 */       ImageIcon costado = new ImageIcon("Formatos/Gafete/Recurso11.png");
/* 421 */       ImageIcon recurso10 = new ImageIcon("Formatos/Gafete/Recurso10.png");
/* 422 */       ImageIcon circulo = new ImageIcon("Formatos/Gafete/Recurso11.png");
/* 423 */       ImageIcon foto1 = new ImageIcon(foto);
/* 424 */       Map<Object, Object> datos = new HashMap<>();
/*     */       
/* 426 */       datos.put("folio", this.DATOS[1]);
/* 427 */       datos.put("nombre", this.DATOS[2]);
/* 428 */       datos.put("vigencia", this.DATOS[3]);
/* 429 */       datos.put("nss", this.DATOS[4]);
/* 430 */       datos.put("curp", this.DATOS[5]);
/* 431 */       datos.put("categoria", this.DATOS[6]);
/*     */       
/* 433 */       datos.put("costado", costado);
/* 434 */       datos.put("recurso10", recurso10);
/* 435 */       datos.put("foto", foto1);
/*     */       
/* 437 */       datos.put("direccion", this.CAMPOSGENERALES.get("direccionCompleta"));
/* 438 */       datos.put("telefonos", this.CAMPOSGENERALES.get("telefonos"));
/*     */       
/* 440 */       this.utilerias.cargarImagenesAReporte(datos);
/* 441 */       this.utilerias.verImpresion("/Reportes/qhse/GafeteFrente2020.jasper", null, datos, "Gafete vista de Frente");
/* 442 */     } catch (JRException e) {
/* 443 */       System.out.println(e.getMessage());
/* 444 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 445 */       JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void materialButton23ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 452 */       String foto = this.ruta + "/" + this.ruta + ".png";
/* 453 */       ImageIcon recurso15 = new ImageIcon("Formatos/Gafete/Recurso15.png");
/* 454 */       ImageIcon recurso13 = new ImageIcon("Formatos/Gafete/Recurso13.png");
/* 455 */       ImageIcon recurso12 = new ImageIcon("Formatos/Gafete/Recurso12.png");
/* 456 */       ImageIcon recurso1 = new ImageIcon("Formatos/Gafete/Recurso1.png");
/* 457 */       ImageIcon recurso16 = new ImageIcon("Formatos/Gafete/Recurso16.png");
/* 458 */       Map<Object, Object> datos = new HashMap<>();
/* 459 */       datos.put("recurso15", recurso15);
/* 460 */       datos.put("recurso13", recurso13);
/* 461 */       datos.put("recurso12", recurso12);
/* 462 */       datos.put("recurso1", recurso1);
/* 463 */       datos.put("recurso16", recurso16);
/*     */       
/* 465 */       this.utilerias.cargarImagenesAReporte(datos);
/* 466 */       this.utilerias.verImpresion("/Reportes/qhse/GafeteReverso2020.jasper", null, datos, "Gafete vista de Reveso");
/* 467 */     } catch (JRException e) {
/* 468 */       System.out.println(e.getMessage());
/* 469 */       Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 470 */       JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jLabel33MouseDragged(MouseEvent evt) {
/* 475 */     int x = evt.getXOnScreen();
/* 476 */     int y = evt.getYOnScreen();
/* 477 */     setLocation(x - this.xx, y - this.xy);
/*     */   }
/*     */   
/*     */   private void jLabel33MouseClicked(MouseEvent evt) {
/* 481 */     this.xx = evt.getX();
/* 482 */     this.xy = evt.getY();
/*     */   }
/*     */   
/*     */   private void jLabel128MouseClicked(MouseEvent evt) {
/* 486 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void jLabel128MouseEntered(MouseEvent evt) {
/* 490 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*     */   }
/*     */   
/*     */   private void jLabel128MouseExited(MouseEvent evt) {
/* 494 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*     */   }
/*     */   
/*     */   private void jLabel102MouseClicked(MouseEvent evt) {
/* 498 */     this.jDateChooser8.setDate(new Date());
/* 499 */     int res = JOptionPane.showConfirmDialog(this, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 500 */     if (res == 0) {
/* 501 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 502 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 503 */       String año = cadenaFecha1.substring(0, 4);
/* 504 */       String mes = cadenaFecha1.substring(4, 6);
/* 505 */       String dia = cadenaFecha1.substring(6, 8);
/* 506 */       String mm = dameMes(mes);
/* 507 */       this.jLabel102.setText("<html><center><u><b>VIGENCIA: </b>" + mm.toUpperCase() + " " + año + "</u></center></html>");
/* 508 */       this.DATOS[3] = mm + " " + mm;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String dameMes(String mes) {
/* 513 */     String mesLetra = "";
/* 514 */     if (mes.equals("01")) {
/* 515 */       mesLetra = "Enero";
/* 516 */     } else if (mes.equals("02")) {
/* 517 */       mesLetra = "Febrero";
/* 518 */     } else if (mes.equals("03")) {
/* 519 */       mesLetra = "Marzo";
/* 520 */     } else if (mes.equals("04")) {
/* 521 */       mesLetra = "Abril";
/* 522 */     } else if (mes.equals("05")) {
/* 523 */       mesLetra = "Mayo";
/* 524 */     } else if (mes.equals("06")) {
/* 525 */       mesLetra = "Junio";
/* 526 */     } else if (mes.equals("07")) {
/* 527 */       mesLetra = "Julio";
/* 528 */     } else if (mes.equals("08")) {
/* 529 */       mesLetra = "Agosto";
/* 530 */     } else if (mes.equals("09")) {
/* 531 */       mesLetra = "Septiembre";
/* 532 */     } else if (mes.equals("10")) {
/* 533 */       mesLetra = "Octubre";
/* 534 */     } else if (mes.equals("11")) {
/* 535 */       mesLetra = "Noviembre";
/* 536 */     } else if (mes.equals("12")) {
/* 537 */       mesLetra = "Diciembre";
/*     */     } 
/* 539 */     return mesLetra;
/*     */   }
/*     */   
/*     */   protected JRootPane createRootPane() {
/* 543 */     JRootPane rootPane = new JRootPane();
/* 544 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 545 */     Action actionListener = new AbstractAction() {
/*     */         public void actionPerformed(ActionEvent actionEvent) {
/* 547 */           Gafete2020.this.setVisible(false);
/*     */         }
/*     */       };
/* 550 */     InputMap inputMap = rootPane.getInputMap(2);
/* 551 */     inputMap.put(stroke, "ESCAPE");
/* 552 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 553 */     return rootPane;
/*     */   }
/*     */   
/*     */   class fotoIndividual
/*     */     implements Runnable {
/*     */     Thread t;
/* 559 */     String num = "";
/*     */     
/*     */     fotoIndividual(String valor) {
/* 562 */       this.t = new Thread(this);
/* 563 */       this.num = valor;
/* 564 */       this.t.start();
/*     */     }
/*     */ 
/*     */     
/*     */     public void start() {}
/*     */     
/*     */     public void run() {
/* 571 */       ImageIcon tmpIcon = null;
/* 572 */       if (Gafete2020.this.DATOS[1].contains("-OP-")) {
/* 573 */         Gafete2020.this.ruta = ((String)Gafete2020.this.CAMPOSGENERALES.get("fotosOperadores")).toString();
/*     */       } else {
/* 575 */         Gafete2020.this.ruta = ((String)Gafete2020.this.CAMPOSGENERALES.get("fotosEmpleados")).toString();
/*     */       } 
/* 577 */       tmpIcon = new ImageIcon(Gafete2020.this.ruta + "/" + Gafete2020.this.ruta + ".png");
/* 578 */       System.out.println(Gafete2020.this.ruta + "/" + Gafete2020.this.ruta + ".png");
/* 579 */       Gafete2020.this.FOTO = Gafete2020.this.ruta + "/" + Gafete2020.this.ruta + ".png";
/* 580 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(94, -1, 1));
/* 581 */       Gafete2020.this.jLabel1.setText("");
/* 582 */       if (temporal.getImageLoadStatus() == 4) {
/* 583 */         Gafete2020.this.cLabel1.setText("Sin Fotogafía");
/*     */       } else {
/* 585 */         Gafete2020.this.cLabel1.setText("");
/* 586 */         Gafete2020.this.cLabel1.setIcon(temporal);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Gafete2020.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */