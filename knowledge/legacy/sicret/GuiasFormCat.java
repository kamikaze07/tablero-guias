/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Font;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.InputMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import utilerias.Utilerias;
/*     */ import utilerias.pintarComponentes;
/*     */ 
/*     */ public class GuiasFormCat extends JDialog {
/*  28 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  29 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  30 */   SColores lc = new SColores();
/*  31 */   Utilerias utilerias = new Utilerias();
/*  32 */   pintarComponentes pintar = new pintarComponentes();
/*  33 */   PlaceHolder placeHolder = null;
/*  34 */   String holderBuscar = "BUSCAR ...";
/*  35 */   Consultas2 con = new Consultas2();
/*  36 */   String TIPO = "";
/*  37 */   Map<String, String> CLAVECONFIGAUT = new TreeMap<>();
/*  38 */   String campoBuscar = ""; boolean habilitarBusqueda = true; Clientes cliente; Operadores operadores; Proveedores proveedores; provUsos usos;
/*     */   utilitariosSelec utilitarios;
/*     */   Usos n;
/*     */   boolean seleccionado = false;
/*     */   private int xx;
/*     */   private int xy;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel136;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane33;
/*     */   private JTextField jTextField1;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public GuiasFormCat(Dialog parent, boolean modal, String TIPO, JButton boton) {
/*  53 */     super(parent, modal);
/*  54 */     this.TIPO = TIPO;
/*  55 */     initComponents();
/*  56 */     colorear();
/*  57 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderBuscar, false, "Century Gothic", 11);
/*  58 */     if (TIPO.equals("emp_generadora")) {
/*  59 */       consultarClientes();
/*  60 */       this.jLabel2.setText("Cliente");
/*  61 */       setSize(700, 290);
/*  62 */     } else if (TIPO.equals("operadores")) {
/*  63 */       consultarOperadores();
/*  64 */       this.jLabel2.setText("Operador");
/*     */     }
/*  66 */     else if (TIPO.equals("com_compras")) {
/*  67 */       consultarProveedores();
/*  68 */       this.jLabel2.setText("Nombre Comercial");
/*  69 */       setSize(700, 290);
/*  70 */     } else if (TIPO.equals("com_usos")) {
/*  71 */       consultarProvUsos();
/*  72 */       this.jLabel2.setText("Usos o Destinos");
/*     */     }
/*  74 */     else if (TIPO.equals("vales_diesel")) {
/*  75 */       consultarUtilitarios();
/*  76 */       this.jLabel2.setText("Utilitarios");
/*     */     } 
/*     */ 
/*     */     
/*  80 */     Dimension di = boton.getSize();
/*  81 */     Point p = boton.getLocationOnScreen();
/*  82 */     setLocation(p.x - 500, p.y - 35);
/*  83 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  90 */     this.jPanel136 = new JPanel();
/*  91 */     this.jScrollPane33 = new JScrollPane();
/*  92 */     this.rSTableMetro1 = new RSTableMetro();
/*  93 */     this.jPanel1 = new JPanel();
/*  94 */     this.jPanel2 = new JPanel();
/*  95 */     this.jLabel2 = new JLabel();
/*  96 */     this.jTextField1 = new JTextField();
/*     */     
/*  98 */     setDefaultCloseOperation(2);
/*  99 */     setUndecorated(true);
/*     */     
/* 101 */     this.jPanel136.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*     */     
/* 103 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 111 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 116 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 119 */     this.rSTableMetro1.setAltoHead(25);
/* 120 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 121 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 122 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 123 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 124 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 125 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 126 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 127 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 128 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 129 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 130 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 131 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 132 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 133 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 134 */     this.rSTableMetro1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent evt) {
/* 136 */             GuiasFormCat.this.rSTableMetro1MouseDragged(evt);
/*     */           }
/*     */         });
/* 139 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 141 */             GuiasFormCat.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 144 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 146 */             GuiasFormCat.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 149 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 151 */     this.jPanel1.setLayout(new GridLayout(1, 2, 40, 0));
/*     */     
/* 153 */     this.jLabel2.setHorizontalAlignment(0);
/* 154 */     this.jLabel2.setText("Nombre");
/*     */     
/* 156 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 158 */             GuiasFormCat.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 161 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 163 */             GuiasFormCat.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 167 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 168 */     this.jPanel2.setLayout(jPanel2Layout);
/* 169 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 171 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 172 */           .addComponent(this.jLabel2, -2, 143, -2)
/* 173 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 174 */           .addComponent(this.jTextField1, -2, 260, -2)
/* 175 */           .addContainerGap()));
/*     */     
/* 177 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */         .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 180 */           .addComponent(this.jLabel2, -2, 21, -2)
/* 181 */           .addComponent(this.jTextField1, -2, -1, -2)));
/*     */ 
/*     */     
/* 184 */     this.jPanel1.add(this.jPanel2);
/*     */     
/* 186 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 187 */     this.jPanel136.setLayout(jPanel136Layout);
/* 188 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 190 */         .addComponent(this.jScrollPane33, -1, 598, 32767)
/* 191 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 193 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 194 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 195 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 196 */           .addComponent(this.jScrollPane33, -1, 254, 32767)
/* 197 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 198 */           .addComponent(this.jPanel1, -2, -1, -2)));
/*     */ 
/*     */     
/* 201 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 202 */     getContentPane().setLayout(layout);
/* 203 */     layout.setHorizontalGroup(layout
/* 204 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 205 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 206 */           .addGap(0, 0, 0)
/* 207 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*     */     
/* 209 */     layout.setVerticalGroup(layout
/* 210 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 211 */         .addComponent(this.jPanel136, -1, -1, 32767));
/*     */ 
/*     */     
/* 214 */     pack();
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 218 */     this.xx = evt.getX();
/* 219 */     this.xy = evt.getY();
/* 220 */     if (evt.getClickCount() > 1) {
/* 221 */       int ind = this.rSTableMetro1.getSelectedRow();
/* 222 */       if (this.TIPO.equals("operadores")) {
/* 223 */         this
/*     */           
/* 225 */           .operadores = new Operadores(this.rSTableMetro1.getValueAt(ind, 0).toString(), this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString(), this.rSTableMetro1.getValueAt(ind, 3).toString());
/*     */         
/* 227 */         this.seleccionado = true;
/* 228 */         setVisible(false);
/* 229 */       } else if (this.TIPO.equals("emp_generadora")) {
/* 230 */         String RFC = this.rSTableMetro1.getValueAt(ind, 2).toString();
/* 231 */         if (RFC.equals("")) {
/* 232 */           JOptionPane.showMessageDialog(this, "El RFC no puede estar vacío", "Falta RFC", 0, this.ERROR);
/* 233 */         } else if (RFC.contains("XXX")) {
/* 234 */           JOptionPane.showMessageDialog(this, "El cliente necesita un RFC válido", "RFC Inválido", 0, this.ERROR);
/*     */         } else {
/* 236 */           this
/*     */ 
/*     */ 
/*     */             
/* 240 */             .cliente = new Clientes(this.rSTableMetro1.getValueAt(ind, 0).toString(), this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString(), this.rSTableMetro1.getValueAt(ind, 3).toString(), this.rSTableMetro1.getValueAt(ind, 4).toString(), this.rSTableMetro1.getValueAt(ind, 5).toString(), this.rSTableMetro1.getValueAt(ind, 6).toString(), this.rSTableMetro1.getValueAt(ind, 7).toString());
/*     */           
/* 242 */           this.seleccionado = true;
/* 243 */           setVisible(false);
/*     */         } 
/* 245 */       } else if (this.TIPO.equals("com_compras")) {
/* 246 */         this
/*     */ 
/*     */           
/* 249 */           .proveedores = new Proveedores(this.rSTableMetro1.getValueAt(ind, 0).toString(), this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString(), this.rSTableMetro1.getValueAt(ind, 3).toString(), this.rSTableMetro1.getValueAt(ind, 4).toString(), this.rSTableMetro1.getValueAt(ind, 5).toString());
/*     */         
/* 251 */         this.seleccionado = true;
/* 252 */         setVisible(false);
/* 253 */       } else if (this.TIPO.equals("com_usos")) {
/* 254 */         this
/* 255 */           .usos = new provUsos(this.rSTableMetro1.getValueAt(ind, 0).toString());
/*     */         
/* 257 */         this.seleccionado = true;
/* 258 */         setVisible(false);
/* 259 */       } else if (this.TIPO.equals("vales_diesel")) {
/* 260 */         this
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 265 */           .utilitarios = new utilitariosSelec(this.rSTableMetro1.getValueAt(ind, 0).toString(), this.rSTableMetro1.getValueAt(ind, 1).toString(), this.rSTableMetro1.getValueAt(ind, 2).toString(), this.rSTableMetro1.getValueAt(ind, 3).toString(), this.rSTableMetro1.getValueAt(ind, 4).toString());
/*     */         
/* 267 */         this.seleccionado = true;
/* 268 */         setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 282 */     if (this.TIPO.equals("emp_generadora")) {
/* 283 */       consultarClientes();
/* 284 */     } else if (this.TIPO.equals("Cliente")) {
/* 285 */       consultarOperadores();
/* 286 */     } else if (this.TIPO.equals("com_compras")) {
/* 287 */       consultarProveedores();
/* 288 */     } else if (this.TIPO.equals("com_usos")) {
/* 289 */       consultarProvUsos();
/* 290 */     } else if (this.TIPO.equals("operadores")) {
/* 291 */       consultarOperadores();
/* 292 */     } else if (this.TIPO.equals("vales_diesel")) {
/* 293 */       consultarUtilitarios();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseDragged(MouseEvent evt) {
/* 298 */     int x = evt.getXOnScreen();
/* 299 */     int y = evt.getYOnScreen();
/* 300 */     setLocation(x - this.xx, y - this.xy);
/*     */   }
/*     */   
/*     */   public void consultarClientes() {
/* 304 */     String nombre = "";
/* 305 */     if (!this.jTextField1.getText().equals(this.holderBuscar)) {
/* 306 */       nombre = this.jTextField1.getText();
/*     */     }
/*     */     
/* 309 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Clave", "Cliente", "RFC", "CP", "Calle", "Núm", "Colonia", "Ciudad" }, "clave_gene, empresa, rfc, cp, calle, num, col, ciudad", "emp_generadora", "where activo = 'Activado' and empresa like '%" + nombre + "%' order by empresa");
/*     */     
/* 311 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 312 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 40);
/* 313 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 140);
/* 314 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 70);
/* 315 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 40);
/* 316 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 60);
/*     */   }
/*     */ 
/*     */   
/*     */   public void consultarOperadores() {
/* 321 */     String nombre = "";
/* 322 */     if (!this.jTextField1.getText().equals(this.holderBuscar)) {
/* 323 */       nombre = this.jTextField1.getText();
/*     */     }
/*     */     
/* 326 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Clave", "Nombre", "Paterno", "Materno" }, "num_ope, nombre, ap_pat, ap_mat", "operadores", "where actual = 0 and (nombre like '%" + nombre + "%' || ap_pat like '%" + nombre + "%' || ap_mat like '%" + nombre + "%') order by nombre, ap_pat, ap_mat");
/*     */     
/* 328 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 329 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 40);
/*     */   }
/*     */   
/*     */   public void consultarProveedores() {
/* 333 */     String nombre = "";
/* 334 */     if (!this.jTextField1.getText().equals(this.holderBuscar)) {
/* 335 */       nombre = this.jTextField1.getText();
/*     */     }
/*     */     
/* 338 */     this.con.setBaseDatos("sicre2PR");
/* 339 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Clave", "Nombre", "Calle", "#", "Col", "Ciudad" }, "numProv, nombreComercial, calle, num, col, cd", "prov_proveedores", "where razonSocial like '%" + nombre + "%' and estado ='ACTIVO' order by razonSocial");
/*     */     
/* 341 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 342 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 343 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 50);
/* 344 */     this.con.setBaseDatos("sicrePR");
/*     */   }
/*     */   
/*     */   public void consultarProvUsos() {
/* 348 */     String nombre = "";
/* 349 */     if (!this.jTextField1.getText().equals(this.holderBuscar)) {
/* 350 */       nombre = this.jTextField1.getText();
/*     */     }
/*     */     
/* 353 */     this.con.setBaseDatos("sicre2PR");
/* 354 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Uso" }, "distinct(uso)", "com_requi_conceptos", "where uso like '%" + nombre + "%' order by uso");
/*     */     
/* 356 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/*     */ 
/*     */     
/* 359 */     this.con.setBaseDatos("sicrePR");
/*     */   }
/*     */   
/*     */   public void consultarUtilitarios() {
/* 363 */     String nombre = "";
/* 364 */     if (!this.jTextField1.getText().equals(this.holderBuscar)) {
/* 365 */       nombre = this.jTextField1.getText();
/*     */     }
/*     */     
/* 368 */     this.con.setBaseDatos("sicrePR");
/* 369 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "#", "Eco", "Placas", "Serie", "Marca" }, "num, eco, placas, serie, marca", "utilitarios", "where eco like '%" + nombre + "%' and estado ='ACTIVO' order by eco");
/*     */     
/* 371 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 372 */     this.con.setBaseDatos("sicrePR");
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 376 */     this.pintar.colorear(this.jTextField1);
/*     */   }
/*     */   
/*     */   protected JRootPane createRootPane() {
/* 380 */     JRootPane rootPane = new JRootPane();
/* 381 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 382 */     Action actionListener = new AbstractAction() {
/*     */         public void actionPerformed(ActionEvent actionEvent) {
/* 384 */           GuiasFormCat.this.setVisible(false);
/*     */         }
/*     */       };
/* 387 */     InputMap inputMap = rootPane.getInputMap(2);
/* 388 */     inputMap.put(stroke, "ESCAPE");
/* 389 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 390 */     return rootPane;
/*     */   }
/*     */   
/*     */   class Clientes
/*     */   {
/*     */     private String clave_gene;
/*     */     private String nombre;
/*     */     private String rfc;
/*     */     private String cp;
/*     */     private String calle;
/*     */     private String num;
/*     */     private String col;
/*     */     private String ciudad;
/*     */     
/*     */     public Clientes(String clave_gene, String nombre, String rfc, String cp, String calle, String num, String col, String ciudad) {
/* 405 */       this.clave_gene = clave_gene;
/* 406 */       this.nombre = nombre;
/* 407 */       this.rfc = rfc;
/* 408 */       this.cp = cp;
/* 409 */       this.calle = calle;
/* 410 */       this.num = num;
/* 411 */       this.col = col;
/* 412 */       this.ciudad = ciudad;
/*     */     }
/*     */     
/*     */     public String getClave_gene() {
/* 416 */       return this.clave_gene;
/*     */     }
/*     */     
/*     */     public void setClave_gene(String clave_gene) {
/* 420 */       this.clave_gene = clave_gene;
/*     */     }
/*     */     
/*     */     public String getNombre() {
/* 424 */       return this.nombre;
/*     */     }
/*     */     
/*     */     public void setNombre(String nombre) {
/* 428 */       this.nombre = nombre;
/*     */     }
/*     */     
/*     */     public String getRfc() {
/* 432 */       return this.rfc;
/*     */     }
/*     */     
/*     */     public void setRfc(String rfc) {
/* 436 */       this.rfc = rfc;
/*     */     }
/*     */     
/*     */     public String getCp() {
/* 440 */       return this.cp;
/*     */     }
/*     */     
/*     */     public void setCp(String cp) {
/* 444 */       this.cp = cp;
/*     */     }
/*     */     
/*     */     public String getCalle() {
/* 448 */       return this.calle;
/*     */     }
/*     */     
/*     */     public void setCalle(String calle) {
/* 452 */       this.calle = calle;
/*     */     }
/*     */     
/*     */     public String getNum() {
/* 456 */       return this.num;
/*     */     }
/*     */     
/*     */     public void setNum(String num) {
/* 460 */       this.num = num;
/*     */     }
/*     */     
/*     */     public String getCol() {
/* 464 */       return this.col;
/*     */     }
/*     */     
/*     */     public void setCol(String col) {
/* 468 */       this.col = col;
/*     */     }
/*     */     
/*     */     public String getCiudad() {
/* 472 */       return this.ciudad;
/*     */     }
/*     */     
/*     */     public void setCiudad(String ciudad) {
/* 476 */       this.ciudad = ciudad;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class Operadores
/*     */   {
/*     */     private String num_ope;
/*     */     private String nombre;
/*     */     private String ap_pat;
/*     */     private String ap_mat;
/*     */     
/*     */     public Operadores(String num_ope, String nombre, String ap_pat, String ap_mat) {
/* 489 */       this.num_ope = num_ope;
/* 490 */       this.nombre = nombre;
/* 491 */       this.ap_pat = ap_pat;
/* 492 */       this.ap_mat = ap_mat;
/*     */     }
/*     */     
/*     */     public String getNum_ope() {
/* 496 */       return this.num_ope;
/*     */     }
/*     */     
/*     */     public void setNum_ope(String num_ope) {
/* 500 */       this.num_ope = num_ope;
/*     */     }
/*     */     
/*     */     public String getNombre() {
/* 504 */       return this.nombre;
/*     */     }
/*     */     
/*     */     public void setNombre(String nombre) {
/* 508 */       this.nombre = nombre;
/*     */     }
/*     */     
/*     */     public String getAp_pat() {
/* 512 */       return this.ap_pat;
/*     */     }
/*     */     
/*     */     public void setAp_pat(String ap_pat) {
/* 516 */       this.ap_pat = ap_pat;
/*     */     }
/*     */     
/*     */     public String getAp_mat() {
/* 520 */       return this.ap_mat;
/*     */     }
/*     */     
/*     */     public void setAp_mat(String ap_mat) {
/* 524 */       this.ap_mat = ap_mat;
/*     */     }
/*     */   }
/*     */   
/*     */   class Proveedores
/*     */   {
/*     */     private String numProv;
/*     */     private String nombre;
/*     */     private String calle;
/*     */     private String num;
/*     */     private String col;
/*     */     private String cd;
/*     */     
/*     */     public Proveedores(String numProv, String nombre, String calle, String num, String col, String cd) {
/* 538 */       this.numProv = numProv;
/* 539 */       this.nombre = nombre;
/* 540 */       this.calle = calle;
/* 541 */       this.num = num;
/* 542 */       this.col = col;
/* 543 */       this.cd = cd;
/*     */     }
/*     */     
/*     */     public String getNumProv() {
/* 547 */       return this.numProv;
/*     */     }
/*     */     
/*     */     public void setNumProv(String numProv) {
/* 551 */       this.numProv = numProv;
/*     */     }
/*     */     
/*     */     public String getNombre() {
/* 555 */       return this.nombre;
/*     */     }
/*     */     
/*     */     public void setNombre(String nombre) {
/* 559 */       this.nombre = nombre;
/*     */     }
/*     */     
/*     */     public String getCalle() {
/* 563 */       return this.calle;
/*     */     }
/*     */     
/*     */     public void setCalle(String calle) {
/* 567 */       this.calle = calle;
/*     */     }
/*     */     
/*     */     public String getNum() {
/* 571 */       return this.num;
/*     */     }
/*     */     
/*     */     public void setNum(String num) {
/* 575 */       this.num = num;
/*     */     }
/*     */     
/*     */     public String getCol() {
/* 579 */       return this.col;
/*     */     }
/*     */     
/*     */     public void setCol(String col) {
/* 583 */       this.col = col;
/*     */     }
/*     */     
/*     */     public String getCd() {
/* 587 */       return this.cd;
/*     */     }
/*     */     
/*     */     public void setCd(String cd) {
/* 591 */       this.cd = cd;
/*     */     }
/*     */   }
/*     */   
/*     */   class provUsos
/*     */   {
/*     */     private String uso;
/*     */     
/*     */     public provUsos(String uso) {
/* 600 */       this.uso = uso;
/*     */     }
/*     */     
/*     */     public String getUso() {
/* 604 */       return this.uso;
/*     */     }
/*     */     
/*     */     public void setUso(String uso) {
/* 608 */       this.uso = uso;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class Usos {}
/*     */ 
/*     */   
/*     */   class utilitariosSelec
/*     */   {
/*     */     private String num;
/*     */     
/*     */     private String eco;
/*     */     private String serie;
/*     */     private String placas;
/*     */     private String marca;
/*     */     
/*     */     public utilitariosSelec(String num, String eco, String serie, String placas, String marca) {
/* 626 */       this.num = num;
/* 627 */       this.eco = eco;
/* 628 */       this.serie = serie;
/* 629 */       this.placas = placas;
/* 630 */       this.marca = marca;
/*     */     }
/*     */     
/*     */     public String getNum() {
/* 634 */       return this.num;
/*     */     }
/*     */     
/*     */     public void setNum(String num) {
/* 638 */       this.num = num;
/*     */     }
/*     */     
/*     */     public String getEco() {
/* 642 */       return this.eco;
/*     */     }
/*     */     
/*     */     public void setEco(String eco) {
/* 646 */       this.eco = eco;
/*     */     }
/*     */     
/*     */     public String getSerie() {
/* 650 */       return this.serie;
/*     */     }
/*     */     
/*     */     public void setSerie(String serie) {
/* 654 */       this.serie = serie;
/*     */     }
/*     */     
/*     */     public String getPlacas() {
/* 658 */       return this.placas;
/*     */     }
/*     */     
/*     */     public void setPlacas(String placas) {
/* 662 */       this.placas = placas;
/*     */     }
/*     */     
/*     */     public String getMarca() {
/* 666 */       return this.marca;
/*     */     }
/*     */     
/*     */     public void setMarca(String marca) {
/* 670 */       this.marca = marca;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GuiasFormCat.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */