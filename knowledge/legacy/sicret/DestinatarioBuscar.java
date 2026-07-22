/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class DestinatarioBuscar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*  23 */   Toolkit tk = Toolkit.getDefaultToolkit(); JFrame frame; JScrollPane panel;
/*  24 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  25 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*     */   MostrarTabla modelo;
/*  28 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*     */   JTabbedPane fichas;
/*     */   String USUARIO;
/*     */   JTable tabla;
/*     */   EscribirReporte esc;
/*  33 */   CeldaRender celda = new CeldaRender();
/*  34 */   SColores lc = new SColores();
/*  35 */   String holderClave = "CLAVE"; private JButton jButton18; private JButton jButton26; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel55; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JScrollPane jScrollPane29; private JTextField jTextField1; private RSTableMetro rSTableMetro1;
/*     */   public DestinatarioBuscar(JFrame padre, JScrollPane panelito, String usua, JTabbedPane fichas) {
/*  37 */     initComponents();
/*  38 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  39 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  40 */     this.rSTableMetro1.setCursor(micursor);
/*  41 */     PlaceHolder placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  42 */     this.USUARIO = usua;
/*  43 */     this.fichas = fichas;
/*  44 */     this.frame = padre;
/*  45 */     panelito.setViewportView(this);
/*  46 */     this.panel = panelito;
/*  47 */     colorear();
/*  48 */     llenarCombo();
/*  49 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  54 */     this.jPanel2 = new JPanel();
/*  55 */     this.jPanel3 = new JPanel();
/*  56 */     this.jLabel55 = new JLabel();
/*  57 */     this.jPanel17 = new JPanel();
/*  58 */     this.jTextField1 = new JTextField();
/*  59 */     this.jComboBox1 = new JComboBox();
/*  60 */     this.jComboBox2 = new JComboBox();
/*  61 */     this.jPanel4 = new JPanel();
/*  62 */     this.jScrollPane29 = new JScrollPane();
/*  63 */     this.rSTableMetro1 = new RSTableMetro();
/*  64 */     this.jLabel48 = new JLabel();
/*  65 */     this.jButton26 = new JButton();
/*  66 */     this.jButton18 = new JButton();
/*     */     
/*  68 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/*  70 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/*  72 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/*  73 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/*  74 */     this.jLabel55.setHorizontalAlignment(0);
/*  75 */     this.jLabel55.setText("Buscar Destinos");
/*     */     
/*  77 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  78 */     this.jPanel3.setLayout(jPanel3Layout);
/*  79 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  80 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  81 */         .addComponent(this.jLabel55, -1, 859, 32767));
/*     */     
/*  83 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  84 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  86 */           .addContainerGap()
/*  87 */           .addComponent(this.jLabel55)
/*  88 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/*  91 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/*  93 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  95 */             DestinatarioBuscar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  99 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 100 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 101 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 103 */             DestinatarioBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 108 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 109 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 111 */             DestinatarioBuscar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 115 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 116 */     this.jPanel17.setLayout(jPanel17Layout);
/* 117 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 119 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 120 */           .addContainerGap()
/* 121 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 122 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 123 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 124 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 125 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 126 */           .addContainerGap(-1, 32767)));
/*     */     
/* 128 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 129 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 130 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 131 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 132 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 133 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 136 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 138 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 146 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 151 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 154 */     this.rSTableMetro1.setAltoHead(40);
/* 155 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 156 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 157 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 158 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 159 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 160 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 161 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 162 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 163 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 164 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 165 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 166 */     this.rSTableMetro1.setRowHeight(18);
/* 167 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 168 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 169 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 170 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 171 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 172 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 174 */             DestinatarioBuscar.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 177 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 179 */             DestinatarioBuscar.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 182 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 184 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 185 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 186 */     this.jLabel48.setHorizontalAlignment(2);
/* 187 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 189 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 190 */     this.jButton26.setMnemonic('G');
/* 191 */     this.jButton26.setText("Guardar Reporte");
/* 192 */     this.jButton26.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 193 */     this.jButton26.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 195 */             DestinatarioBuscar.this.jButton26ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 199 */     this.jButton18.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 200 */     this.jButton18.setMnemonic('I');
/* 201 */     this.jButton18.setText("Imprimir");
/* 202 */     this.jButton18.setToolTipText("Imprimir Reporte (Alt+I)");
/* 203 */     this.jButton18.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 205 */             DestinatarioBuscar.this.jButton18ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 209 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 210 */     this.jPanel4.setLayout(jPanel4Layout);
/* 211 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 212 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 213 */         .addComponent(this.jScrollPane29, -1, 859, 32767)
/* 214 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 215 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 216 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 217 */           .addComponent(this.jButton18, -2, 163, -2)
/* 218 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 219 */           .addComponent(this.jButton26, -2, 184, -2)
/* 220 */           .addContainerGap()));
/*     */     
/* 222 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 223 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 224 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 225 */           .addComponent(this.jScrollPane29, -1, 293, 32767)
/* 226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 227 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 228 */             .addComponent(this.jLabel48, GroupLayout.Alignment.TRAILING)
/* 229 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 230 */               .addComponent(this.jButton26, -2, 31, -2)
/* 231 */               .addComponent(this.jButton18, -2, 31, -2)))
/* 232 */           .addContainerGap()));
/*     */ 
/*     */     
/* 235 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 236 */     this.jPanel2.setLayout(jPanel2Layout);
/* 237 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 239 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 240 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 241 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 243 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 245 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 246 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 247 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 248 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 249 */           .addGap(7, 7, 7)
/* 250 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 253 */     GroupLayout layout = new GroupLayout(this);
/* 254 */     setLayout(layout);
/* 255 */     layout.setHorizontalGroup(layout
/* 256 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 257 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 259 */     layout.setVerticalGroup(layout
/* 260 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 261 */         .addGroup(layout.createSequentialGroup()
/* 262 */           .addComponent(this.jPanel2, -1, -1, 32767)
/* 263 */           .addGap(0, 0, 0)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 268 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 272 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 276 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 288 */     String[] datos = { "Clave", "Nombre de la Empresa", "Dirección", "RFC", "Teléfono", "Monto", "Cantidad con Letra" };
/* 289 */     this.esc = new EscribirReporte("Empresas Destino", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jButton18ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 294 */       if (!this.rSTableMetro1.print());
/*     */ 
/*     */     
/*     */     }
/* 298 */     catch (PrinterException printerException) {}
/*     */   }
/*     */   
/*     */   public void destinatario(String usu) {
/* 302 */     this.USUARIO = usu;
/* 303 */     this.panel.setViewportView(this);
/* 304 */     llenarCombo();
/* 305 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 308 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 310 */             DestinatarioBuscar.this.jTextGanado(DestinatarioBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 313 */             DestinatarioBuscar.this.jTextPerdido(DestinatarioBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 316 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 318 */             DestinatarioBuscar.this.jTextGanado(DestinatarioBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 321 */             DestinatarioBuscar.this.jTextPerdido(DestinatarioBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 324 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 326 */             DestinatarioBuscar.this.jTextGanado(DestinatarioBuscar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 329 */             DestinatarioBuscar.this.jTextPerdido(DestinatarioBuscar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 334 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 337 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 340 */     String clave = "";
/* 341 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 342 */       clave = this.jTextField1.getText();
/*     */     }
/* 344 */     String nombre = "";
/* 345 */     String estados = "";
/* 346 */     String id_edo = "";
/* 347 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 348 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 350 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 351 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 352 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 353 */       id_edo = this.con.Campo;
/*     */     } 
/* 355 */     this.encontrado = this.con.consultar("count(clave_desti)", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0");
/* 356 */     int totreg = Integer.parseInt(this.con.Campo);
/* 357 */     this.encontrado = this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 358 */     String tot = this.con.Campo;
/* 359 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 360 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 361 */           .buscarReg(13, totreg, "clave_desti,empresa,calle,num,col,cp,ciudad,estado,rfc,telefono,monto,letra,semarnat", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Destino", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "Monto", "Cantidad con Letra", "Aut. SEMARNAT" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 366 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 370 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 373 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 374 */     eliminarColumna(3, 2, "Número");
/* 375 */     eliminarColumna(3, 2, "Colonia");
/* 376 */     eliminarColumna(3, 2, "CP");
/* 377 */     eliminarColumna(3, 2, "Ciudad");
/* 378 */     eliminarColumna(3, 2, "Estado");
/*     */ 
/*     */     
/* 381 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 382 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 383 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 384 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(70);
/* 385 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 386 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(70);
/* 387 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 388 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(70);
/* 389 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(260);
/* 390 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(260);
/* 391 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(190);
/* 392 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(190);
/* 393 */     this.rSTableMetro1.setSelectionMode(0);
/* 394 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 395 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 397 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 398 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 399 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 400 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 401 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 402 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 403 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 404 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 405 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 408 */     int cont = this.rSTableMetro1.getRowCount();
/* 409 */     String[] registros = new String[cont]; int i;
/* 410 */     for (i = 0; i < cont; i++) {
/* 411 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 413 */     for (i = 0; i < cont; i++) {
/* 414 */       registros[i] = registros[i] + " " + registros[i];
/* 415 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 417 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 418 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   public void pasarTabla(JTable tabla) {
/* 421 */     this.tabla = tabla;
/*     */   }
/*     */   public void llenarCombo() {
/* 424 */     this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 425 */     String[] depa = this.con.regresaCol("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 426 */     this.jComboBox1.removeAllItems();
/* 427 */     this.jComboBox1.addItem("DESTINOS");
/* 428 */     for (int i = 0; i < depa.length; i++)
/* 429 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 433 */     int otro = -1;
/* 434 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 436 */       setEnabled((table == null || table.isEnabled()));
/* 437 */       if (comparar(row)) {
/* 438 */         setBackground(Color.red);
/*     */       }
/* 440 */       else if (row % 2 == 0) {
/* 441 */         setBackground(DestinatarioBuscar.this.lc.FONDOTABLA);
/*     */       } else {
/* 443 */         setBackground((Color)null);
/*     */       } 
/* 445 */       setForeground(DestinatarioBuscar.this.lc.SECUNDARIO1);
/* 446 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 447 */       return this;
/*     */     }
/*     */     public void pasarInd(int[] ind) {
/* 450 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(int reg) {
/* 453 */       for (int i = 0; i < this.indices.length; i++) {
/* 454 */         if (this.indices[i] == reg) {
/* 455 */           return true;
/*     */         }
/*     */       } 
/* 458 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DestinatarioBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */