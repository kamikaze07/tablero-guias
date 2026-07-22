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
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class GeneradoraBuscar extends JPanel {
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
/*  35 */   PlaceHolder placeHolder = null;
/*  36 */   String holderClave = "CLAVE"; private JButton jButton1; private JButton jButton18; private JButton jButton26; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JScrollPane jScrollPane29; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public GeneradoraBuscar(JFrame padre, JScrollPane panelito, String usua, JTabbedPane fichas) {
/*  40 */     initComponents();
/*  41 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  42 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  43 */     this.rSTableMetro1.setCursor(micursor);
/*  44 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  45 */     this.USUARIO = usua;
/*  46 */     this.fichas = fichas;
/*  47 */     this.frame = padre;
/*  48 */     panelito.setViewportView(this);
/*  49 */     this.panel = panelito;
/*  50 */     llenarCombo();
/*  51 */     colorear();
/*  52 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.jLabel54 = new JLabel();
/*  59 */     this.jPanel5 = new JPanel();
/*  60 */     this.jScrollPane3 = new JScrollPane();
/*  61 */     this.jTable3 = new JTable();
/*  62 */     this.jLabel52 = new JLabel();
/*  63 */     this.jButton5 = new JButton();
/*  64 */     this.jLabel59 = new JLabel();
/*  65 */     this.jButton1 = new JButton();
/*  66 */     this.jPanel2 = new JPanel();
/*  67 */     this.jPanel3 = new JPanel();
/*  68 */     this.jLabel55 = new JLabel();
/*  69 */     this.jPanel17 = new JPanel();
/*  70 */     this.jTextField1 = new JTextField();
/*  71 */     this.jComboBox1 = new JComboBox();
/*  72 */     this.jComboBox2 = new JComboBox();
/*  73 */     this.jPanel4 = new JPanel();
/*  74 */     this.jScrollPane29 = new JScrollPane();
/*  75 */     this.rSTableMetro1 = new RSTableMetro();
/*  76 */     this.jLabel48 = new JLabel();
/*  77 */     this.jButton26 = new JButton();
/*  78 */     this.jButton18 = new JButton();
/*     */     
/*  80 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  81 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  83 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/*  84 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  85 */     this.jLabel54.setHorizontalAlignment(0);
/*  86 */     this.jLabel54.setText("Buscar Empresas Origen");
/*     */     
/*  88 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  89 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  91 */     this.jTable3.setAutoCreateRowSorter(true);
/*  92 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  93 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Empresa", "Dirección", "RFC", "Teléfono", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 101 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 104 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 109 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 113 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 116 */     this.jTable3.setShowVerticalLines(false);
/* 117 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 119 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 120 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 121 */     this.jLabel52.setHorizontalAlignment(2);
/* 122 */     this.jLabel52.setText("Si deseas crear un nuevo reporte presiona el botón de 'Guardar Reporte'");
/*     */     
/* 124 */     this.jButton5.setMnemonic('G');
/* 125 */     this.jButton5.setText("Guardar Reporte");
/* 126 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 127 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 129 */             GeneradoraBuscar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 133 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 134 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 135 */     this.jLabel59.setHorizontalAlignment(0);
/* 136 */     this.jLabel59.setText("Imprimir Consulta");
/*     */     
/* 138 */     this.jButton1.setText("Imprimir");
/* 139 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 141 */             GeneradoraBuscar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 145 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 146 */     this.jPanel5.setLayout(jPanel5Layout);
/* 147 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 148 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 149 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 150 */           .addContainerGap(203, 32767)
/* 151 */           .addComponent(this.jLabel59, -2, 99, -2)
/* 152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 153 */           .addComponent(this.jButton1)
/* 154 */           .addGap(132, 132, 132)
/* 155 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 156 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 157 */           .addComponent(this.jButton5))
/* 158 */         .addComponent(this.jScrollPane3));
/*     */     
/* 160 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 161 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 162 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 163 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 164 */             .addComponent(this.jButton5)
/* 165 */             .addComponent(this.jLabel52)
/* 166 */             .addComponent(this.jLabel59)
/* 167 */             .addComponent(this.jButton1))
/* 168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 169 */           .addComponent(this.jScrollPane3, -1, 152, 32767)));
/*     */ 
/*     */     
/* 172 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 173 */     this.jPanel1.setLayout(jPanel1Layout);
/* 174 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 176 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 177 */           .addContainerGap()
/* 178 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 179 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 180 */             .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 181 */           .addContainerGap()));
/*     */     
/* 183 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 186 */           .addComponent(this.jLabel54)
/* 187 */           .addGap(80, 80, 80)
/* 188 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 191 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 193 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 195 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/* 196 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 197 */     this.jLabel55.setHorizontalAlignment(0);
/* 198 */     this.jLabel55.setText("Buscar Clientes");
/*     */     
/* 200 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 201 */     this.jPanel3.setLayout(jPanel3Layout);
/* 202 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 203 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 204 */         .addComponent(this.jLabel55, -1, 764, 32767));
/*     */     
/* 206 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 209 */           .addContainerGap()
/* 210 */           .addComponent(this.jLabel55)
/* 211 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 214 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 216 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 218 */             GeneradoraBuscar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 222 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 223 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 224 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 226 */             GeneradoraBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 230 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 231 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 232 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 234 */             GeneradoraBuscar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 238 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 239 */     this.jPanel17.setLayout(jPanel17Layout);
/* 240 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 241 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 242 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 243 */           .addContainerGap()
/* 244 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 245 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 246 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 247 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 248 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 249 */           .addContainerGap(-1, 32767)));
/*     */     
/* 251 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 252 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 253 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 254 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 255 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 256 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 259 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 261 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 269 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 274 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 277 */     this.rSTableMetro1.setAltoHead(40);
/* 278 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 279 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 280 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 281 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 282 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 283 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 284 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 285 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 286 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 287 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 288 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 289 */     this.rSTableMetro1.setRowHeight(18);
/* 290 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 291 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 292 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 293 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 294 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 295 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 297 */             GeneradoraBuscar.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 300 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 302 */             GeneradoraBuscar.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 305 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 307 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 308 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 309 */     this.jLabel48.setHorizontalAlignment(2);
/* 310 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 312 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 313 */     this.jButton26.setMnemonic('G');
/* 314 */     this.jButton26.setText("Guardar Reporte");
/* 315 */     this.jButton26.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 316 */     this.jButton26.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 318 */             GeneradoraBuscar.this.jButton26ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 322 */     this.jButton18.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 323 */     this.jButton18.setMnemonic('I');
/* 324 */     this.jButton18.setText("Imprimir");
/* 325 */     this.jButton18.setToolTipText("Imprimir Reporte (Alt+I)");
/* 326 */     this.jButton18.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 328 */             GeneradoraBuscar.this.jButton18ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 332 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 333 */     this.jPanel4.setLayout(jPanel4Layout);
/* 334 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 336 */         .addComponent(this.jScrollPane29, -1, 764, 32767)
/* 337 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 338 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 339 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 340 */           .addComponent(this.jButton18, -2, 163, -2)
/* 341 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 342 */           .addComponent(this.jButton26, -2, 184, -2)
/* 343 */           .addContainerGap()));
/*     */     
/* 345 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 346 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 347 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 348 */           .addComponent(this.jScrollPane29, -1, 293, 32767)
/* 349 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 350 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 351 */             .addComponent(this.jLabel48, GroupLayout.Alignment.TRAILING)
/* 352 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 353 */               .addComponent(this.jButton26, -2, 31, -2)
/* 354 */               .addComponent(this.jButton18, -2, 31, -2)))
/* 355 */           .addContainerGap()));
/*     */ 
/*     */     
/* 358 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 359 */     this.jPanel2.setLayout(jPanel2Layout);
/* 360 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 361 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 362 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 363 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 364 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 366 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 367 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 368 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 369 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 370 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 371 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 373 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 376 */     GroupLayout layout = new GroupLayout(this);
/* 377 */     setLayout(layout);
/* 378 */     layout.setHorizontalGroup(layout
/* 379 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 380 */         .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 382 */     layout.setVerticalGroup(layout
/* 383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 384 */         .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 389 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 393 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 397 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 416 */     String[] datos = { "Clave", "Nombre de la Empresa", "Dirección", "RFC", "Teléfono", "Estatus", "Estatus" };
/* 417 */     this.esc = new EscribirReporte("CLIENTES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jButton18ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 422 */       if (!this.rSTableMetro1.print());
/*     */ 
/*     */     
/*     */     }
/* 426 */     catch (PrinterException printerException) {}
/*     */   }
/*     */   
/*     */   public void generadora(String usu) {
/* 430 */     this.USUARIO = usu;
/* 431 */     this.panel.setViewportView(this);
/* 432 */     llenarCombo();
/* 433 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 436 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 438 */             GeneradoraBuscar.this.jTextGanado(GeneradoraBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 441 */             GeneradoraBuscar.this.jTextPerdido(GeneradoraBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 444 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 446 */             GeneradoraBuscar.this.jTextGanado(GeneradoraBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 449 */             GeneradoraBuscar.this.jTextPerdido(GeneradoraBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 452 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 454 */             GeneradoraBuscar.this.jTextGanado(GeneradoraBuscar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 457 */             GeneradoraBuscar.this.jTextPerdido(GeneradoraBuscar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 462 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 465 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 468 */     String clave = "";
/* 469 */     String nombre = "";
/* 470 */     String estados = "";
/* 471 */     String id_edo = "";
/* 472 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 473 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 475 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 476 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 477 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 478 */       id_edo = this.con.Campo;
/*     */     } 
/* 480 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 481 */       clave = this.jTextField1.getText();
/*     */     }
/* 483 */     this.encontrado = this.con.consultar("count(clave_gene)", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0");
/* 484 */     int totreg = Integer.parseInt(this.con.Campo);
/* 485 */     this.encontrado = this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 486 */     String tot = this.con.Campo;
/* 487 */     this.jLabel48.setText(" Registros encontrados " + totreg + " de " + tot);
/* 488 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 489 */           .buscarReg(13, totreg, "clave_gene,empresa,nombre_corto,Iniciales,calle,num,col,cp,ciudad,estado,rfc,telefono,activo", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Origen", "Nombre Corto", "Iniciales", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "Estatus" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 494 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 498 */             return this.types[columnIndex];
/*     */           }
/* 500 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 504 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 507 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 508 */     eliminarColumna(5, 4, "Número");
/* 509 */     eliminarColumna(5, 4, "Colonia");
/* 510 */     eliminarColumna(5, 4, "CP");
/* 511 */     eliminarColumna(5, 4, "Ciudad");
/* 512 */     eliminarColumna(5, 4, "Estado");
/*     */     
/* 514 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 515 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 516 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 517 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(310);
/* 518 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(310);
/* 519 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(130);
/* 520 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(130);
/* 521 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(60);
/* 522 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(60);
/* 523 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(110);
/* 524 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(110);
/* 525 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 526 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(70);
/* 527 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(100);
/* 528 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(100);
/* 529 */     this.rSTableMetro1.setSelectionMode(0);
/* 530 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 531 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 533 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 534 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 535 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 536 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 537 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 538 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 539 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 540 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 541 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 544 */     int cont = this.rSTableMetro1.getRowCount();
/* 545 */     String[] registros = new String[cont]; int i;
/* 546 */     for (i = 0; i < cont; i++) {
/* 547 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 549 */     for (i = 0; i < cont; i++) {
/* 550 */       registros[i] = registros[i] + " " + registros[i];
/* 551 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 553 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 554 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   public void pasarTabla(JTable tabla) {
/* 557 */     this.tabla = tabla;
/*     */   }
/*     */   public void llenarCombo() {
/* 560 */     this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 561 */     String[] depa = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 562 */     this.jComboBox1.removeAllItems();
/* 563 */     this.jComboBox1.addItem("CLIENTES");
/* 564 */     for (int i = 0; i < depa.length; i++)
/* 565 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 569 */     int otro = -1;
/* 570 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 572 */       setEnabled((table == null || table.isEnabled()));
/* 573 */       if (comparar(row)) {
/* 574 */         setBackground(Color.red);
/*     */       }
/* 576 */       else if (row % 2 == 0) {
/* 577 */         setBackground(GeneradoraBuscar.this.lc.FONDOTABLA);
/*     */       } else {
/* 579 */         setBackground((Color)null);
/* 580 */       }  setForeground(GeneradoraBuscar.this.lc.SECUNDARIO1);
/* 581 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 582 */       return this;
/*     */     }
/*     */     public void pasarInd(int[] ind) {
/* 585 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(int reg) {
/* 588 */       for (int i = 0; i < this.indices.length; i++) {
/* 589 */         if (this.indices[i] == reg) {
/* 590 */           return true;
/*     */         }
/*     */       } 
/* 593 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GeneradoraBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */