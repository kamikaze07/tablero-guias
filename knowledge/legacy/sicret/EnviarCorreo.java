/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.util.Properties;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.MimeBodyPart;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import javax.mail.internet.MimeMultipart;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import principal.MaterialButton;
/*     */ 
/*     */ public class EnviarCorreo extends JDialog {
/*  43 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  44 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  45 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  46 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  47 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*     */   boolean encontrado = false;
/*  49 */   PlaceHolder placeHolder = null;
/*  50 */   SColores lc = new SColores();
/*  51 */   Consultas con = new Consultas();
/*  52 */   String[] credenciales = new String[4];
/*  53 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  54 */   int w = this.tama.width;
/*  55 */   int h = this.tama.height;
/*  56 */   int rw = (this.w - 300) / 2;
/*  57 */   int rh = (this.h - 115) / 2;
/*  58 */   String USUARIO = "";
/*  59 */   Frame padre = null;
/*     */   private int xx;
/*     */   private int xy;
/*     */   String[] DIRECCIONES;
/*  63 */   Esperando espera = null;
/*  64 */   String nombreArchivo = ""; private JButton jButton3; private JDialog jDialog1; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24;
/*     */   private JLabel jLabel25;
/*     */   private JList jList1;
/*     */   private JMenuItem jMenuItem1;
/*     */   private JMenuItem jMenuItem2;
/*     */   private JPanel jPanel1;
/*     */   
/*     */   public EnviarCorreo(Frame parent, String Asunto, String TextoDesc, String usuario, String nombreArchivo) {
/*  72 */     initComponents();
/*  73 */     this.padre = parent;
/*  74 */     this.USUARIO = usuario;
/*  75 */     this.jLabel25.setVisible(false);
/*  76 */     this.materialProgressSpinner1.setVisible(false);
/*  77 */     sacarCredenciales(usuario);
/*  78 */     this.jTextField2.setText(Asunto);
/*  79 */     this.nombreArchivo = nombreArchivo;
/*  80 */     this.con.consultar("correo", "usuarios", "where nombre_usu ='" + usuario + "'");
/*  81 */     this.jTextArea1.setText(TextoDesc + "\n\n\n\n\n" + TextoDesc + "\n" + this.credenciales[3] + " " + this.credenciales[1] + " " + this.credenciales[2]);
/*  82 */     this.jTextField3.setText("Archivos/" + nombreArchivo);
/*  83 */     this.jTextField4.setText(this.con.Campo);
/*  84 */     consultarDir();
/*  85 */     colorear();
/*     */     
/*  87 */     this.jDialog1.setSize(180, 240);
/*  88 */     this.jDialog1.setVisible(false);
/*  89 */     this.jDialog1.setResizable(false);
/*     */     
/*  91 */     this.rw = (this.w - 900) / 2;
/*  92 */     this.rh = (this.h - 400) / 2;
/*  93 */     setLocation(this.rw, this.rh);
/*  94 */     setModal(true);
/*  95 */     setVisible(true);
/*     */   }
/*     */   private JPanel jPanel30; private JPanel jPanel77; private JPanel jPanel78; private JPopupMenu jPopupMenu1; private JScrollPane jScrollPane19; private JScrollPane jScrollPane2; private JTextArea jTextArea1; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private MaterialButton materialButton1; private MaterialButton materialButton2; private MaterialProgressSpinner materialProgressSpinner1;
/*     */   public void sacarCredenciales(String USUARIO) {
/*  99 */     this.credenciales = this.con.regresaReg("empleados.nombre,empleados.ap_pat,empleados.ap_mat, departamentos.nombre", "empleados,usuarios,departamentos", "where usuarios.num_emp= empleados.clave_emp and empleados.clave_depa=departamentos.clave_depa and nombre_usu ='" + USUARIO + "'", 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/* 106 */     this.jDialog1 = new CerrarVentana(this.padre);
/* 107 */     this.jScrollPane2 = new JScrollPane();
/* 108 */     this.jList1 = new JList();
/* 109 */     this.jPopupMenu1 = new JPopupMenu();
/* 110 */     this.jMenuItem1 = new JMenuItem();
/* 111 */     this.jMenuItem2 = new JMenuItem();
/* 112 */     this.jPanel77 = new JPanel();
/* 113 */     this.jPanel30 = new JPanel();
/* 114 */     this.jLabel25 = new JLabel();
/* 115 */     this.materialButton2 = new MaterialButton();
/* 116 */     this.materialButton1 = new MaterialButton();
/* 117 */     this.materialProgressSpinner1 = new MaterialProgressSpinner();
/* 118 */     this.jPanel1 = new JPanel();
/* 119 */     this.jScrollPane19 = new JScrollPane();
/* 120 */     this.jTextArea1 = new JTextArea();
/* 121 */     this.jLabel23 = new JLabel();
/* 122 */     this.jTextField3 = new JTextField();
/* 123 */     this.jLabel22 = new JLabel();
/* 124 */     this.jTextField2 = new JTextField();
/* 125 */     this.jLabel24 = new JLabel();
/* 126 */     this.jTextField4 = new JTextField();
/* 127 */     this.jLabel2 = new JLabel();
/* 128 */     this.jLabel21 = new JLabel();
/* 129 */     this.jTextField1 = new JTextField();
/* 130 */     this.jButton3 = new JButton();
/* 131 */     this.jPanel78 = new JPanel();
/* 132 */     this.jLabel1 = new JLabel();
/*     */     
/* 134 */     this.jDialog1.setTitle("Contactos");
/* 135 */     this.jDialog1.setAlwaysOnTop(true);
/*     */     
/* 137 */     this.jList1.setFont(new Font("Segoe UI", 0, 11));
/* 138 */     this.jList1.setModel(new AbstractListModel() {
/* 139 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/* 140 */           public int getSize() { return this.strings.length; }
/* 141 */           public Object getElementAt(int i) { return this.strings[i]; }
/*     */         });
/* 143 */     this.jList1.setToolTipText("Doble clic para agregar");
/* 144 */     this.jList1.setComponentPopupMenu(this.jPopupMenu1);
/* 145 */     this.jList1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 147 */             EnviarCorreo.this.jList1MouseClicked(evt);
/*     */           }
/*     */         });
/* 150 */     this.jScrollPane2.setViewportView(this.jList1);
/*     */     
/* 152 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 153 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 154 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */         .addComponent(this.jScrollPane2, -1, 175, 32767));
/*     */     
/* 158 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 160 */         .addComponent(this.jScrollPane2));
/*     */ 
/*     */     
/* 163 */     this.jMenuItem1.setText("Agregardirección");
/* 164 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 166 */             EnviarCorreo.this.jMenuItem1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 169 */     this.jPopupMenu1.add(this.jMenuItem1);
/*     */     
/* 171 */     this.jMenuItem2.setText("Eliminar dirección");
/* 172 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 174 */             EnviarCorreo.this.jMenuItem2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 177 */     this.jPopupMenu1.add(this.jMenuItem2);
/*     */     
/* 179 */     setUndecorated(true);
/* 180 */     setResizable(false);
/*     */     
/* 182 */     this.jPanel77.setBackground(this.lc.TERCERO1);
/*     */     
/* 184 */     this.jPanel30.setBackground(this.lc.TERCERO1);
/*     */     
/* 186 */     this.jLabel25.setFont(new Font("Segoe UI", 2, 13));
/* 187 */     this.jLabel25.setForeground(this.lc.PRIMARIO1);
/* 188 */     this.jLabel25.setText("Enviando correo electrónico espere....");
/*     */     
/* 190 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/* 191 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/* 192 */     this.materialButton2.setMnemonic('C');
/* 193 */     this.materialButton2.setText("Cerrar");
/* 194 */     this.materialButton2.setToolTipText("Cerrar (Alt+C)");
/* 195 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/* 196 */     this.materialButton2.setHorizontalTextPosition(0);
/* 197 */     this.materialButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 199 */             EnviarCorreo.this.materialButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 203 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 204 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 205 */     this.materialButton1.setMnemonic('E');
/* 206 */     this.materialButton1.setText("Enviar correo");
/* 207 */     this.materialButton1.setToolTipText("Enviar correo (Alt+E)");
/* 208 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 209 */     this.materialButton1.setHorizontalTextPosition(0);
/* 210 */     this.materialButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 212 */             EnviarCorreo.this.materialButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 216 */     this.materialProgressSpinner1.setForeground(this.lc.PRIMARIO1);
/*     */     
/* 218 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/* 219 */     GridBagLayout jPanel1Layout = new GridBagLayout();
/* 220 */     jPanel1Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 221 */     jPanel1Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 222 */     this.jPanel1.setLayout(jPanel1Layout);
/*     */     
/* 224 */     this.jTextArea1.setColumns(20);
/* 225 */     this.jTextArea1.setFont(new Font("Segoe UI", 0, 11));
/* 226 */     this.jTextArea1.setLineWrap(true);
/* 227 */     this.jTextArea1.setRows(5);
/* 228 */     this.jScrollPane19.setViewportView(this.jTextArea1);
/*     */     
/* 230 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 231 */     gridBagConstraints.gridx = 0;
/* 232 */     gridBagConstraints.gridy = 12;
/* 233 */     gridBagConstraints.gridwidth = 5;
/* 234 */     gridBagConstraints.fill = 1;
/* 235 */     gridBagConstraints.ipady = 230;
/* 236 */     gridBagConstraints.anchor = 18;
/* 237 */     gridBagConstraints.weightx = 1.0D;
/* 238 */     this.jPanel1.add(this.jScrollPane19, gridBagConstraints);
/*     */     
/* 240 */     this.jLabel23.setFont(new Font("Segoe UI", 0, 11));
/* 241 */     this.jLabel23.setForeground(new Color(102, 102, 102));
/* 242 */     this.jLabel23.setText("Adjunto:");
/* 243 */     gridBagConstraints = new GridBagConstraints();
/* 244 */     gridBagConstraints.gridx = 0;
/* 245 */     gridBagConstraints.gridy = 10;
/* 246 */     gridBagConstraints.anchor = 17;
/* 247 */     this.jPanel1.add(this.jLabel23, gridBagConstraints);
/*     */     
/* 249 */     this.jTextField3.setEditable(false);
/* 250 */     this.jTextField3.setFont(new Font("Segoe UI", 3, 11));
/* 251 */     this.jTextField3.setForeground(this.lc.PRIMARIO2);
/* 252 */     this.jTextField3.setToolTipText("Archivos Adjuntos");
/* 253 */     this.jTextField3.setCursor(new Cursor(12));
/* 254 */     this.jTextField3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 256 */             EnviarCorreo.this.jTextField3MouseClicked(evt);
/*     */           }
/*     */         });
/* 259 */     gridBagConstraints = new GridBagConstraints();
/* 260 */     gridBagConstraints.gridx = 2;
/* 261 */     gridBagConstraints.gridy = 10;
/* 262 */     gridBagConstraints.gridwidth = 3;
/* 263 */     gridBagConstraints.fill = 2;
/* 264 */     gridBagConstraints.anchor = 18;
/* 265 */     gridBagConstraints.weightx = 1.0D;
/* 266 */     this.jPanel1.add(this.jTextField3, gridBagConstraints);
/*     */     
/* 268 */     this.jLabel22.setFont(new Font("Segoe UI", 0, 11));
/* 269 */     this.jLabel22.setForeground(new Color(102, 102, 102));
/* 270 */     this.jLabel22.setText("Asunto:");
/* 271 */     gridBagConstraints = new GridBagConstraints();
/* 272 */     gridBagConstraints.gridx = 0;
/* 273 */     gridBagConstraints.gridy = 8;
/* 274 */     gridBagConstraints.anchor = 17;
/* 275 */     this.jPanel1.add(this.jLabel22, gridBagConstraints);
/* 276 */     gridBagConstraints = new GridBagConstraints();
/* 277 */     gridBagConstraints.gridx = 2;
/* 278 */     gridBagConstraints.gridy = 8;
/* 279 */     gridBagConstraints.gridwidth = 3;
/* 280 */     gridBagConstraints.fill = 2;
/* 281 */     gridBagConstraints.anchor = 18;
/* 282 */     gridBagConstraints.weightx = 1.0D;
/* 283 */     this.jPanel1.add(this.jTextField2, gridBagConstraints);
/*     */     
/* 285 */     this.jLabel24.setFont(new Font("Segoe UI", 0, 11));
/* 286 */     this.jLabel24.setForeground(new Color(102, 102, 102));
/* 287 */     this.jLabel24.setText("CC");
/* 288 */     gridBagConstraints = new GridBagConstraints();
/* 289 */     gridBagConstraints.gridx = 0;
/* 290 */     gridBagConstraints.gridy = 6;
/* 291 */     gridBagConstraints.gridwidth = 3;
/* 292 */     gridBagConstraints.anchor = 17;
/* 293 */     this.jPanel1.add(this.jLabel24, gridBagConstraints);
/*     */     
/* 295 */     this.jTextField4.setEditable(false);
/* 296 */     this.jTextField4.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 298 */             EnviarCorreo.this.jTextField4MouseClicked(evt);
/*     */           }
/*     */         });
/* 301 */     gridBagConstraints = new GridBagConstraints();
/* 302 */     gridBagConstraints.gridx = 2;
/* 303 */     gridBagConstraints.gridy = 6;
/* 304 */     gridBagConstraints.gridwidth = 3;
/* 305 */     gridBagConstraints.fill = 2;
/* 306 */     gridBagConstraints.anchor = 18;
/* 307 */     gridBagConstraints.weightx = 1.0D;
/* 308 */     this.jPanel1.add(this.jTextField4, gridBagConstraints);
/*     */     
/* 310 */     this.jLabel2.setFont(new Font("Cantarell", 0, 10));
/* 311 */     this.jLabel2.setForeground(this.lc.SECUNDARIO1);
/* 312 */     this.jLabel2.setHorizontalAlignment(0);
/* 313 */     this.jLabel2.setText("ejemplo1@empresa.com.mx; ejemplo2@otraempresa.com.mx;");
/* 314 */     gridBagConstraints = new GridBagConstraints();
/* 315 */     gridBagConstraints.gridx = 0;
/* 316 */     gridBagConstraints.gridy = 4;
/* 317 */     gridBagConstraints.gridwidth = 5;
/* 318 */     gridBagConstraints.fill = 2;
/* 319 */     gridBagConstraints.weightx = 1.0D;
/* 320 */     this.jPanel1.add(this.jLabel2, gridBagConstraints);
/*     */     
/* 322 */     this.jLabel21.setFont(new Font("Segoe UI", 0, 11));
/* 323 */     this.jLabel21.setForeground(new Color(102, 102, 102));
/* 324 */     this.jLabel21.setHorizontalAlignment(2);
/* 325 */     this.jLabel21.setText("Para:");
/* 326 */     gridBagConstraints = new GridBagConstraints();
/* 327 */     gridBagConstraints.gridx = 0;
/* 328 */     gridBagConstraints.gridy = 2;
/* 329 */     gridBagConstraints.anchor = 21;
/* 330 */     this.jPanel1.add(this.jLabel21, gridBagConstraints);
/* 331 */     gridBagConstraints = new GridBagConstraints();
/* 332 */     gridBagConstraints.gridx = 2;
/* 333 */     gridBagConstraints.gridy = 2;
/* 334 */     gridBagConstraints.fill = 2;
/* 335 */     gridBagConstraints.weightx = 1.0D;
/* 336 */     this.jPanel1.add(this.jTextField1, gridBagConstraints);
/*     */     
/* 338 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/phone-book.png")));
/* 339 */     this.jButton3.setMinimumSize(new Dimension(46, 28));
/* 340 */     this.jButton3.setPreferredSize(new Dimension(46, 30));
/* 341 */     this.jButton3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 343 */             EnviarCorreo.this.jButton3ActionPerformed(evt);
/*     */           }
/*     */         });
/* 346 */     gridBagConstraints = new GridBagConstraints();
/* 347 */     gridBagConstraints.gridx = 4;
/* 348 */     gridBagConstraints.gridy = 2;
/* 349 */     this.jPanel1.add(this.jButton3, gridBagConstraints);
/*     */     
/* 351 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 352 */     this.jPanel30.setLayout(jPanel30Layout);
/* 353 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 355 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 356 */           .addContainerGap()
/* 357 */           .addComponent((Component)this.materialProgressSpinner1, -2, 29, -2)
/* 358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 359 */           .addComponent(this.jLabel25, -2, 285, -2)
/* 360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, 32767)
/* 361 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/* 362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 363 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/* 364 */           .addContainerGap())
/* 365 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 367 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 369 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 370 */           .addComponent(this.jPanel1, -1, 418, 32767)
/* 371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 372 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 373 */             .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 374 */               .addComponent(this.jLabel25)
/* 375 */               .addComponent((Component)this.materialButton2, -2, 38, -2)
/* 376 */               .addComponent((Component)this.materialButton1, -2, 38, -2))
/* 377 */             .addComponent((Component)this.materialProgressSpinner1, -2, 32, -2))
/* 378 */           .addContainerGap()));
/*     */ 
/*     */     
/* 381 */     this.jPanel78.setBackground(this.lc.PRIMARIO1);
/*     */     
/* 383 */     this.jLabel1.setHorizontalAlignment(0);
/* 384 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/mail.png")));
/* 385 */     this.jLabel1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent evt) {
/* 387 */             EnviarCorreo.this.jLabel1MouseDragged(evt);
/*     */           }
/*     */         });
/* 390 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 392 */             EnviarCorreo.this.jLabel1MouseClicked(evt);
/*     */           }
/*     */         });
/*     */     
/* 396 */     GroupLayout jPanel78Layout = new GroupLayout(this.jPanel78);
/* 397 */     this.jPanel78.setLayout(jPanel78Layout);
/* 398 */     jPanel78Layout.setHorizontalGroup(jPanel78Layout
/* 399 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 400 */         .addComponent(this.jLabel1, -1, 162, 32767));
/*     */     
/* 402 */     jPanel78Layout.setVerticalGroup(jPanel78Layout
/* 403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 404 */         .addComponent(this.jLabel1, -1, -1, 32767));
/*     */ 
/*     */     
/* 407 */     GroupLayout jPanel77Layout = new GroupLayout(this.jPanel77);
/* 408 */     this.jPanel77.setLayout(jPanel77Layout);
/* 409 */     jPanel77Layout.setHorizontalGroup(jPanel77Layout
/* 410 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 411 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
/* 412 */           .addComponent(this.jPanel78, -2, -1, -2)
/* 413 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 414 */           .addComponent(this.jPanel30, -1, -1, 32767)));
/*     */     
/* 416 */     jPanel77Layout.setVerticalGroup(jPanel77Layout
/* 417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 418 */         .addComponent(this.jPanel78, -1, -1, 32767)
/* 419 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*     */ 
/*     */     
/* 422 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 423 */     getContentPane().setLayout(layout);
/* 424 */     layout.setHorizontalGroup(layout
/* 425 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 426 */         .addComponent(this.jPanel77, -1, -1, 32767));
/*     */     
/* 428 */     layout.setVerticalGroup(layout
/* 429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 430 */         .addComponent(this.jPanel77, -1, -1, 32767));
/*     */ 
/*     */     
/* 433 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 437 */     Point punto = getLocation();
/* 438 */     this.jDialog1.setLocation(punto.x + 900, punto.y);
/* 439 */     this.jDialog1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void materialButton2ActionPerformed(ActionEvent evt) {
/* 443 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 447 */     boolean correcto = false;
/* 448 */     boolean enviar = false;
/* 449 */     this.jTextField1.setText(this.jTextField1.getText().replace(" ", ""));
/* 450 */     if (this.jTextField1.getText().equals("")) {
/* 451 */       this.jTextField1.setBackground(Color.RED);
/* 452 */       JOptionPane.showMessageDialog(this, "Necesitas agregar una cuenta de correo para poder enviar la información", "Falta Correo", 0, this.ADVER);
/* 453 */       enviar = false;
/*     */     } else {
/* 455 */       enviar = true;
/*     */     } 
/* 457 */     if (this.jTextField2.getText().equals("")) {
/* 458 */       this.jTextField2.setBackground(this.lc.FONDOCAMPOSELEC);
/* 459 */       int res = JOptionPane.showConfirmDialog(this, "Tu mensaje no tiene texto de asunto, ¿Deseas enviarlo sin asunto?", "Enviar sin Asunto", 0, 3, this.PREG);
/* 460 */       if (res == 0) {
/* 461 */         enviar = true;
/*     */       } else {
/* 463 */         enviar = false;
/*     */       } 
/*     */     } 
/*     */     
/* 467 */     if (enviar) {
/* 468 */       if (this.jTextField1.getText().charAt(this.jTextField1.getText().length() - 1) != ';') {
/* 469 */         this.jTextField1.setText(this.jTextField1.getText() + ";");
/*     */       }
/* 471 */       String cad = this.jTextField1.getText();
/* 472 */       int dir = 0;
/* 473 */       for (int i = 0; i < cad.length(); i++) {
/* 474 */         if (cad.charAt(i) == ';') {
/* 475 */           dir++;
/*     */         }
/*     */       } 
/* 478 */       this.DIRECCIONES = new String[dir];
/* 479 */       int cont = 0;
/* 480 */       String correo = ""; int j;
/* 481 */       for (j = 0; j < cad.length(); j++) {
/* 482 */         char valor = cad.charAt(j);
/* 483 */         if (valor != ';') {
/* 484 */           correo = correo + correo;
/*     */         } else {
/* 486 */           correcto = validarEmail(correo);
/* 487 */           this.DIRECCIONES[cont] = correo;
/* 488 */           cont++;
/* 489 */           correo = "";
/*     */         } 
/*     */       } 
/* 492 */       if (correcto) {
/* 493 */         this.materialButton1.setEnabled(false);
/* 494 */         this.materialButton2.setEnabled(false);
/* 495 */         this.jLabel25.setVisible(true);
/* 496 */         this.materialProgressSpinner1.setVisible(true);
/* 497 */         this.espera = new Esperando();
/* 498 */         for (j = 0; j < this.DIRECCIONES.length; j++) {
/* 499 */           this.encontrado = this.con.consultar("correo", "direcciones", "where nombre_usu = '" + this.USUARIO + "' and correo = '" + this.DIRECCIONES[j] + "'");
/* 500 */           if (!this.encontrado) {
/* 501 */             this.con.inserSinMsj("insert into direcciones(nombre_usu,correo)values('" + this.USUARIO + "','" + this.DIRECCIONES[j] + "')");
/*     */           }
/*     */         } 
/* 504 */         this.espera.start();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jList1MouseClicked(MouseEvent evt) {
/* 511 */     if (evt.getClickCount() == 2) {
/* 512 */       this.jTextField1.setText(this.jTextField1.getText().replace(" ", ""));
/* 513 */       String dir = String.valueOf(this.jList1.getSelectedValue());
/* 514 */       if (!this.jTextField1.getText().equals("")) {
/* 515 */         String caracter = this.jTextField1.getText().substring(this.jTextField1.getText().length() - 1);
/* 516 */         if (!caracter.equals(";")) {
/* 517 */           this.jTextField1.setText(this.jTextField1.getText() + ";");
/*     */         }
/*     */       } 
/* 520 */       if (this.jTextField1.getText().contains(dir)) {
/* 521 */         JOptionPane.showMessageDialog(this, "La dirección ya se encuentra capturada", "Direeción duplicada", 0, this.ADVER);
/*     */       } else {
/* 523 */         this.jTextField1.setText(this.jTextField1.getText() + this.jTextField1.getText() + ";");
/* 524 */         this.jDialog1.setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 530 */     this.xx = evt.getX();
/* 531 */     this.xy = evt.getY();
/*     */   }
/*     */   
/*     */   private void jLabel1MouseDragged(MouseEvent evt) {
/* 535 */     int x = evt.getXOnScreen();
/* 536 */     int y = evt.getYOnScreen();
/* 537 */     setLocation(x - this.xx, y - this.xy);
/*     */   }
/*     */   
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 541 */     if (this.jList1.getSelectedIndex() == -1) {
/* 542 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar la dirección que agregarás", "Selecciona una dirreción", 0, this.ERROR);
/*     */     } else {
/* 544 */       this.jTextField1.setText(this.jTextField1.getText().replace(" ", ""));
/* 545 */       String dir = String.valueOf(this.jList1.getSelectedValue());
/* 546 */       if (!this.jTextField1.getText().equals("")) {
/* 547 */         String caracter = this.jTextField1.getText().substring(this.jTextField1.getText().length() - 1);
/* 548 */         if (!caracter.equals(";")) {
/* 549 */           this.jTextField1.setText(this.jTextField1.getText() + ";");
/*     */         }
/*     */       } 
/* 552 */       if (this.jTextField1.getText().contains(dir)) {
/* 553 */         JOptionPane.showMessageDialog(this, "La dirección ya se encuentra capturada", "Direeción duplicada", 0, this.ADVER);
/*     */       } else {
/* 555 */         this.jTextField1.setText(this.jTextField1.getText() + this.jTextField1.getText() + ";");
/* 556 */         this.jDialog1.setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 562 */     if (this.jList1.getSelectedIndex() == -1) {
/* 563 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar la dirección que eliminarás", "Selecciona una dirreción", 0, this.ERROR);
/*     */     } else {
/* 565 */       this.con.eliminar2("direcciones", "where correo='" + String.valueOf(this.jList1.getSelectedValue()) + "' and nombre_usu='" + this.USUARIO + "'");
/* 566 */       consultarDir();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField4MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField3MouseClicked(MouseEvent evt) {
/*     */     try {
/* 576 */       File path = new File(this.jTextField3.getText());
/* 577 */       Desktop.getDesktop().open(path);
/* 578 */     } catch (IOException ex) {
/* 579 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 584 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 586 */             EnviarCorreo.this.jTextGanado(EnviarCorreo.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 590 */             EnviarCorreo.this.jTextPerdido(EnviarCorreo.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 593 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 595 */             EnviarCorreo.this.jTextGanado(EnviarCorreo.this.jTextField2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 599 */             EnviarCorreo.this.jTextPerdido(EnviarCorreo.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 602 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 604 */             EnviarCorreo.this.jTextGanado(EnviarCorreo.this.jTextArea1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 608 */             EnviarCorreo.this.jTextPerdido(EnviarCorreo.this.jTextArea1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 614 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 618 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void consultarDir() {
/* 622 */     this.encontrado = this.con.consultar("count(num)", "direcciones", "where nombre_usu = '" + this.USUARIO + "'");
/* 623 */     int totreg = Integer.parseInt(this.con.Campo);
/* 624 */     String[] direcciones = this.con.regresaCol("correo", "direcciones", "where nombre_usu = '" + this.USUARIO + "' order by correo", totreg);
/*     */     
/* 626 */     for (int i = 0; i < direcciones.length; i++) {
/* 627 */       direcciones[i] = direcciones[i].toLowerCase();
/*     */     }
/* 629 */     this.jList1.setListData(direcciones);
/*     */   }
/*     */   
/*     */   public boolean validarEmail(String correo) {
/* 633 */     Pattern pat = null;
/* 634 */     Matcher mat = null;
/* 635 */     pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
/* 636 */     mat = pat.matcher(correo);
/* 637 */     if (mat.find()) {
/* 638 */       System.out.println("Correcto: [" + mat.group() + "]");
/* 639 */       return true;
/*     */     } 
/* 641 */     System.out.println("Incorrecto " + correo);
/* 642 */     JOptionPane.showMessageDialog(this, "<html>La siguiente dirección de correo parece no válida, verifica tu información: <p>" + correo + "<p><b>Recuerda que las direcciones van separadas por punto y coma (;)<b></html>", "Dirección de correo no válida", 0, this.ERROR);
/* 643 */     return false;
/*     */   }
/*     */   
/*     */   class Esperando
/*     */     extends Thread
/*     */   {
/*     */     public void run() {
/* 650 */       EnviarCorreo.Enviando correo = new EnviarCorreo.Enviando();
/*     */     }
/*     */   }
/*     */   
/*     */   class Enviando
/*     */   {
/*     */     public Enviando() {
/*     */       try {
/* 658 */         Properties props = new Properties();
/* 659 */         props.setProperty("mail.smtp.host", "smtp.gmail.com");
/* 660 */         props.setProperty("mail.smtp.starttls.enable", "true");
/* 661 */         props.setProperty("mail.smtp.port", "587");
/* 662 */         props.setProperty("mail.smtp.user", "forsis4@gmail.com");
/* 663 */         props.setProperty("mail.smtp.auth", "true");
/*     */         
/* 665 */         MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
/* 666 */         mimeBodyPart1.setText(EnviarCorreo.this.jTextArea1.getText() + "\n\n\n\nVisítanos en www.forsis.com.mx \n______________________________________________________________________________________________\nFavor de no responder a la dirección remitente, ya que es enviado con el sistema de FORSIS");
/*     */         
/* 668 */         MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
/*     */         
/* 670 */         mimeBodyPart2.setDataHandler(new DataHandler((DataSource)new FileDataSource("Archivos/" + EnviarCorreo.this.nombreArchivo)));
/* 671 */         mimeBodyPart2.setFileName(EnviarCorreo.this.nombreArchivo);
/*     */         
/* 673 */         Session session = Session.getDefaultInstance(props);
/*     */ 
/*     */         
/* 676 */         MimeMessage message = new MimeMessage(session);
/* 677 */         message.setFrom((Address)new InternetAddress("forsis4@gmail.com"));
/*     */         
/* 679 */         MimeMultipart multiParte = new MimeMultipart();
/* 680 */         multiParte.addBodyPart((BodyPart)mimeBodyPart1);
/* 681 */         multiParte.addBodyPart((BodyPart)mimeBodyPart2);
/*     */         
/* 683 */         Address[] direccion = new Address[EnviarCorreo.this.DIRECCIONES.length];
/* 684 */         for (int i = 0; i < EnviarCorreo.this.DIRECCIONES.length; i++) {
/* 685 */           direccion[i] = (Address)new InternetAddress(EnviarCorreo.this.DIRECCIONES[i]);
/*     */         }
/* 687 */         message.addRecipients(Message.RecipientType.TO, direccion);
/* 688 */         message.addRecipients(Message.RecipientType.CC, EnviarCorreo.this.jTextField4.getText());
/*     */         
/* 690 */         message.setSubject(EnviarCorreo.this.jTextField2.getText());
/* 691 */         message.setContent((Multipart)multiParte);
/*     */         
/* 693 */         Transport t = session.getTransport("smtp");
/*     */         
/* 695 */         t.connect("forsis4@gmail.com", "dpceabhsjgudkusm");
/* 696 */         t.sendMessage((Message)message, message.getAllRecipients());
/* 697 */         t.close();
/* 698 */         EnviarCorreo.this.jLabel25.setVisible(false);
/* 699 */         EnviarCorreo.this.materialProgressSpinner1.setVisible(false);
/*     */ 
/*     */         
/* 702 */         JOptionPane.showMessageDialog(null, "El mensaje se ha enviado correctamente a todas las direcciones", "Mensaje Enviado", 0, EnviarCorreo.this.INFO);
/* 703 */         EnviarCorreo.this.setVisible(false);
/* 704 */       } catch (Exception e) {
/* 705 */         e.printStackTrace();
/* 706 */         EnviarCorreo.this.jLabel25.setVisible(false);
/*     */         
/* 708 */         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al enviar el correo electrónico", "Mensaje no Enviado", 0, EnviarCorreo.this.ERROR);
/*     */       } 
/* 710 */       EnviarCorreo.this.materialButton1.setEnabled(true);
/* 711 */       EnviarCorreo.this.materialButton2.setEnabled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/EnviarCorreo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */