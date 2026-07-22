/*     */ package sicret;
/*     */ import com.placeholder.PlaceHolder;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class tras_Destinos extends JPanel {
/*  21 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  22 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  23 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  24 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  25 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  26 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  30 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  31 */   Utilerias utilerias = new Utilerias();
/*     */   JFrame padre;
/*  33 */   String USUARIO = "";
/*     */   JTabbedPane fichas;
/*  35 */   Consultas2 con = new Consultas2();
/*  36 */   Consultas2 con2 = new Consultas2();
/*  37 */   SColores lc = new SColores();
/*     */   Map<String, String> CAMPOSGENERALES;
/*  39 */   Fuentes fuentes = new Fuentes();
/*  40 */   PlaceHolder placeHolder = null;
/*  41 */   String holderId = "ID";
/*  42 */   String holderNombre = "NOMBRE O DESTINO";
/*  43 */   String holderCiudad = "CIUDAD";
/*  44 */   String holderCliente = "CLIENTE";
/*  45 */   pintarComponentes pintar = new pintarComponentes();
/*     */   boolean actualizado = false;
/*  47 */   List<Tras_codigos> CODIGOSP = null;
/*  48 */   ArrayList LISTACODIGOS = null;
/*  49 */   TextAutoCompleter com_ListaCodigos = null;
/*     */   boolean entraPrimera = false;
/*     */   boolean PRIMERA = false;
/*  52 */   CeldaRender1 celda1 = new CeldaRender1(); EscribirReporte esc; private JButton jButton1; private JButton jButton2; private JButton jButton4; private JComboBox jComboBox1; private JLabel jLabel100; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel2; private JPanel jPanel35; private JPanel jPanel9; private JScrollPane jScrollPane13; private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public tras_Destinos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*  59 */     this.con2.setBaseDatos("sicre2PR");
/*  60 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*     */     
/*  62 */     this.padre = padre;
/*  63 */     this.fichas = fichas;
/*  64 */     this.USUARIO = USUARIO;
/*  65 */     this.panel = panelito;
/*  66 */     this.panel.setViewportView(this);
/*  67 */     this.LISTACODIGOS = LISTACODIGOS;
/*  68 */     this.CODIGOSP = CODIGOSP;
/*  69 */     initComponents();
/*     */     
/*  71 */     colorear();
/*  72 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderId, false, "Century Gothic", 11);
/*  73 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderNombre, false, "Century Gothic", 11);
/*  74 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCiudad, false, "Century Gothic", 11);
/*  75 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderCliente, false, "Century Gothic", 11);
/*     */     
/*  77 */     llenarComboEstados();
/*  78 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  86 */     this.jPanel2 = new JPanel();
/*  87 */     this.jPanel9 = new JPanel();
/*  88 */     this.jPanel10 = new JPanel();
/*  89 */     this.jLabel98 = new JLabel();
/*  90 */     this.jPanel35 = new JPanel();
/*  91 */     this.jTextField1 = new JTextField();
/*  92 */     this.jTextField2 = new JTextField();
/*  93 */     this.jTextField3 = new JTextField();
/*  94 */     this.jTextField4 = new JTextField();
/*  95 */     this.jComboBox1 = new JComboBox();
/*  96 */     this.jPanel11 = new JPanel();
/*  97 */     this.jPanel12 = new JPanel();
/*  98 */     this.jPanel15 = new JPanel();
/*  99 */     this.jLabel99 = new JLabel();
/* 100 */     this.jLabel100 = new JLabel();
/* 101 */     this.jPanel14 = new JPanel();
/* 102 */     this.jPanel16 = new JPanel();
/* 103 */     this.jButton1 = new JButton();
/* 104 */     this.jButton2 = new JButton();
/* 105 */     this.jButton4 = new JButton();
/* 106 */     this.jPanel1 = new JPanel();
/* 107 */     this.jScrollPane13 = new JScrollPane();
/* 108 */     this.rSTableMetro1 = new RSTableMetro();
/*     */     
/* 110 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 111 */     this.jPanel2.setLayout(jPanel2Layout);
/* 112 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 113 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 114 */         .addGap(0, 738, 32767));
/*     */     
/* 116 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 117 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 118 */         .addGap(0, 267, 32767));
/*     */ 
/*     */     
/* 121 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 123 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 125 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 126 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 127 */     this.jLabel98.setHorizontalAlignment(0);
/* 128 */     this.jLabel98.setText("Destinos");
/*     */     
/* 130 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 131 */     this.jPanel10.setLayout(jPanel10Layout);
/* 132 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 133 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 134 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*     */     
/* 136 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 138 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 139 */           .addContainerGap()
/* 140 */           .addComponent(this.jLabel98)
/* 141 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 144 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 145 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*     */     
/* 147 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 149 */             tras_Destinos.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/* 152 */     this.jPanel35.add(this.jTextField1);
/*     */     
/* 154 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 156 */             tras_Destinos.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/* 159 */     this.jPanel35.add(this.jTextField2);
/*     */     
/* 161 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 163 */             tras_Destinos.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/* 166 */     this.jPanel35.add(this.jTextField3);
/*     */     
/* 168 */     this.jTextField4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 170 */             tras_Destinos.this.jTextField4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 173 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 175 */             tras_Destinos.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/* 178 */     this.jPanel35.add(this.jTextField4);
/*     */     
/* 180 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 181 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 182 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 184 */             tras_Destinos.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 187 */     this.jPanel35.add(this.jComboBox1);
/*     */     
/* 189 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 191 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 192 */     this.jPanel12.setLayout(new GridLayout(1, 6, 6, 0));
/*     */     
/* 194 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 195 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 197 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 198 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 199 */     this.jLabel99.setHorizontalAlignment(4);
/* 200 */     this.jLabel99.setText("Total");
/* 201 */     this.jPanel15.add(this.jLabel99);
/*     */     
/* 203 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 204 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 205 */     this.jLabel100.setHorizontalAlignment(2);
/* 206 */     this.jLabel100.setText("t");
/* 207 */     this.jPanel15.add(this.jLabel100);
/*     */     
/* 209 */     this.jPanel12.add(this.jPanel15);
/*     */     
/* 211 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 213 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 214 */     this.jPanel14.setLayout(jPanel14Layout);
/* 215 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 216 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 217 */         .addGap(0, 61, 32767));
/*     */     
/* 219 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */         .addGap(0, 37, 32767));
/*     */ 
/*     */     
/* 224 */     this.jPanel12.add(this.jPanel14);
/*     */     
/* 226 */     this.jPanel16.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 228 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 229 */     this.jPanel16.setLayout(jPanel16Layout);
/* 230 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 231 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 232 */         .addGap(0, 61, 32767));
/*     */     
/* 234 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 236 */         .addGap(0, 37, 32767));
/*     */ 
/*     */     
/* 239 */     this.jPanel12.add(this.jPanel16);
/*     */     
/* 241 */     this.jButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 242 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 243 */     this.jButton1.setMnemonic('N');
/* 244 */     this.jButton1.setText("Nuevo");
/* 245 */     this.jButton1.setToolTipText("Nuevo(Alt + N)");
/* 246 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 248 */             tras_Destinos.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 251 */     this.jPanel12.add(this.jButton1);
/*     */     
/* 253 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 254 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 255 */     this.jButton2.setMnemonic('M');
/* 256 */     this.jButton2.setText("Modificar");
/* 257 */     this.jButton2.setToolTipText("Modificar (Alt + M)");
/* 258 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 260 */             tras_Destinos.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 263 */     this.jPanel12.add(this.jButton2);
/*     */     
/* 265 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 266 */     this.jButton4.setMnemonic('G');
/* 267 */     this.jButton4.setText("Guardar Reporte");
/* 268 */     this.jButton4.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 269 */     this.jButton4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 271 */             tras_Destinos.this.jButton4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 274 */     this.jPanel12.add(this.jButton4);
/*     */     
/* 276 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 284 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 289 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 292 */     this.rSTableMetro1.setAltoHead(40);
/* 293 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 294 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 295 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 296 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 297 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 298 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 299 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 300 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 301 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 302 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 303 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 304 */     this.rSTableMetro1.setRowHeight(18);
/* 305 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 306 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 307 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 308 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 310 */             tras_Destinos.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 313 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 315 */             tras_Destinos.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 318 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 320 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 321 */     this.jPanel1.setLayout(jPanel1Layout);
/* 322 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 324 */         .addComponent(this.jScrollPane13, -2, 0, 32767));
/*     */     
/* 326 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 327 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 328 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 329 */           .addComponent(this.jScrollPane13, -1, 173, 32767)
/* 330 */           .addContainerGap()));
/*     */ 
/*     */     
/* 333 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 334 */     this.jPanel11.setLayout(jPanel11Layout);
/* 335 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */         .addComponent(this.jPanel12, -2, 400, 32767)
/* 338 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 340 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 342 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 343 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 344 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 345 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 346 */           .addContainerGap()));
/*     */ 
/*     */     
/* 349 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 350 */     this.jPanel9.setLayout(jPanel9Layout);
/* 351 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 352 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 353 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 354 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 355 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*     */     
/* 357 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 358 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 359 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 360 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 361 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 362 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 364 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*     */ 
/*     */     
/* 367 */     GroupLayout layout = new GroupLayout(this);
/* 368 */     setLayout(layout);
/* 369 */     layout.setHorizontalGroup(layout
/* 370 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 371 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 373 */     layout.setVerticalGroup(layout
/* 374 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 375 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 380 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 384 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 388 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 396 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 400 */     if (this.PRIMERA) {
/* 401 */       consultar();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 409 */     this.actualizado = false;
/* 410 */     tras_Destinos_Form form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, "");
/* 411 */     this.actualizado = form.actualizado;
/* 412 */     if (this.actualizado) {
/* 413 */       consultar();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 421 */     String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString();
/* 422 */     this.actualizado = false;
/* 423 */     tras_Destinos_Form form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/* 424 */     this.actualizado = form.actualizado;
/* 425 */     if (this.actualizado) {
/* 426 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 431 */     String[] datos = { "NÚM", "ID", "NOMBRE", "C.P.", "CALLE", "NÚM", "COLONIA", "CIUDAD", "ESTADO", "CLIENTES", "ACTUALIZÓ" };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     this.esc = new EscribirReporte("ORIGENES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 440 */     if (evt.getClickCount() == 2) {
/* 441 */       String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString();
/* 442 */       tras_Destinos_Form tras_Destinos_Form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   public void activarFolios() {
/* 451 */     int numSUC = dameSucursal();
/* 452 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 453 */       String num = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 454 */       String nuevo = transformaFolio(numSUC, num);
/* 455 */       this.con.inserSinMsj("update emp_destinataria set id = '" + nuevo + "' where clave_desti = " + num);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int dameSucursal() {
/* 460 */     int num = 0;
/* 461 */     String SUCURSAL = this.CAMPOSGENERALES.get("sucursal");
/* 462 */     if (SUCURSAL.equals("CADEREYTA")) {
/* 463 */       num = 1;
/* 464 */     } else if (SUCURSAL.equals("VERACRUZ")) {
/* 465 */       num = 2;
/* 466 */     } else if (SUCURSAL.equals("POZA RICA")) {
/* 467 */       num = 3;
/* 468 */     } else if (SUCURSAL.equals("CARDENAS")) {
/* 469 */       num = 4;
/*     */     } 
/* 471 */     return num;
/*     */   }
/*     */   
/*     */   public String transformaFolio(int numSuc, String num) {
/* 475 */     String clave = "";
/* 476 */     int id = Integer.parseInt(num);
/* 477 */     if (id < 10) {
/* 478 */       clave = "" + numSuc + "0000" + numSuc;
/* 479 */     } else if (id < 100) {
/* 480 */       clave = "" + numSuc + "000" + numSuc;
/* 481 */     } else if (id < 1000) {
/* 482 */       clave = "" + numSuc + "00" + numSuc;
/* 483 */     } else if (id < 10000) {
/* 484 */       clave = "" + numSuc + "0" + numSuc;
/*     */     } else {
/* 486 */       clave = "" + numSuc + numSuc;
/*     */     } 
/* 488 */     return "DE" + clave;
/*     */   }
/*     */   
/*     */   public void destinos(String usua) {
/* 492 */     this.USUARIO = usua;
/* 493 */     this.panel.setViewportView(this);
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 497 */     this.pintar.colorear(this.jTextField1);
/* 498 */     this.pintar.colorear(this.jTextField2);
/* 499 */     this.pintar.colorear(this.jTextField3);
/* 500 */     this.pintar.colorear(this.jTextField4);
/* 501 */     this.pintar.colorear(this.jComboBox1);
/*     */   }
/*     */   
/*     */   public void llenarComboEstados() {
/* 505 */     String[] estados = this.con2.regresaColIndex("distinct(edo)", "tras_origenes", " order by edo");
/* 506 */     this.jComboBox1.removeAllItems();
/* 507 */     this.jComboBox1.addItem("ESTADOS");
/* 508 */     this.utilerias.llenarCombo(this.jComboBox1, estados);
/* 509 */     this.jComboBox1.setSelectedItem("ESTADOS");
/*     */   }
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
/*     */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 522 */     if (!datos.contains(valor)) {
/* 523 */       datos.add(valor);
/*     */     }
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 528 */     this.PRIMERA = true;
/* 529 */     String id = "";
/* 530 */     String nombre = "";
/* 531 */     String ciudad = "";
/* 532 */     String cliente = "";
/* 533 */     String estados = "";
/*     */     
/* 535 */     if (!this.jTextField1.getText().equals(this.holderId)) {
/* 536 */       id = this.jTextField1.getText();
/*     */     }
/* 538 */     if (!this.jTextField2.getText().equals(this.holderNombre)) {
/* 539 */       nombre = this.jTextField2.getText();
/*     */     }
/* 541 */     if (!this.jTextField3.getText().equals(this.holderCiudad)) {
/* 542 */       ciudad = this.jTextField3.getText();
/*     */     }
/* 544 */     if (!this.jTextField4.getText().equals(this.holderCliente)) {
/* 545 */       cliente = this.jTextField4.getText();
/*     */     }
/*     */     
/* 548 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 549 */       estados = this.jComboBox1.getSelectedItem().toString();
/*     */     }
/*     */     
/* 552 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Núm", "ID", "Destino", "C.P.", "Calle", "Número", "Colonia", "Ciudad", "Estado", "Clientes", "Actualizó" }, "clave_desti, id, empresa, cp, calle, num, col, ciudad, edo, clientes, usuario", "emp_destinataria", "where id like '%" + id + "%' and empresa like '%" + nombre + "%' and ciudad like '%" + ciudad + "%' and clientes like '%" + cliente + "%' and edo like '%" + estados + "%' order by empresa desc");
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
/* 569 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*     */     
/* 571 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 70);
/* 572 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 70);
/* 573 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/* 574 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 120);
/* 575 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 120);
/*     */     
/* 577 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/*     */   }
/*     */   
/*     */   public class CeldaRender1
/*     */     extends DefaultTableCellRenderer {
/* 582 */     int otro = -1;
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 585 */       setEnabled((table == null || table.isEnabled()));
/* 586 */       if (column == 0 || column == 3) {
/* 587 */         setHorizontalAlignment(4);
/*     */       } else {
/* 589 */         setHorizontalAlignment(2);
/*     */       } 
/* 591 */       if (row % 2 == 0) {
/* 592 */         setBackground(tras_Destinos.this.lc.FONDOTABLA);
/*     */       } else {
/* 594 */         setBackground((Color)null);
/*     */       } 
/* 596 */       setForeground(tras_Destinos.this.lc.SECUNDARIO1);
/* 597 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 598 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/tras_Destinos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */