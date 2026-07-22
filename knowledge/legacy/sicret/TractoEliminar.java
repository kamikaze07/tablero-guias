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
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class TractoEliminar extends JPanel {
/*     */   Border borde;
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  23 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  24 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*     */   String USUARIO;
/*  26 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  29 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  31 */   Date fechaActual = new Date();
/*  32 */   TractoAgregar TractoA = null;
/*  33 */   CeldaRender celda = new CeldaRender();
/*  34 */   MensajePop mensajeTry = null; private JButton jButton5; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2;
/*     */   public TractoEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  36 */     this.mensajeTry = mensajeTry;
/*  37 */     initComponents();
/*  38 */     this.padre = padre;
/*  39 */     this.fichas = fichas;
/*  40 */     colorear();
/*  41 */     this.USUARIO = USUARIO;
/*  42 */     panelito.setViewportView(this);
/*  43 */     this.panel = panelito;
/*  44 */     llenarCombos();
/*  45 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  50 */     this.jPanel1 = new JPanel();
/*  51 */     this.jPanel17 = new JPanel();
/*  52 */     this.jLabel14 = new JLabel();
/*  53 */     this.jLabel32 = new JLabel();
/*  54 */     this.jLabel38 = new JLabel();
/*  55 */     this.jTextField2 = new JTextField();
/*  56 */     this.jTextField1 = new JTextField();
/*  57 */     this.jLabel15 = new JLabel();
/*  58 */     this.jComboBox1 = new JComboBox();
/*  59 */     this.jComboBox2 = new JComboBox();
/*  60 */     this.jLabel39 = new JLabel();
/*  61 */     this.jComboBox3 = new JComboBox();
/*  62 */     this.jComboBox4 = new JComboBox();
/*  63 */     this.jLabel40 = new JLabel();
/*  64 */     this.jLabel54 = new JLabel();
/*  65 */     this.jPanel5 = new JPanel();
/*  66 */     this.jLabel48 = new JLabel();
/*  67 */     this.jScrollPane3 = new JScrollPane();
/*  68 */     this.jTable3 = new JTable();
/*  69 */     this.jButton5 = new JButton();
/*  70 */     this.jLabel52 = new JLabel();
/*  71 */     this.jCheckBox1 = new JCheckBox();
/*     */     
/*  73 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  74 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  76 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  77 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Tractos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  79 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  80 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  81 */     this.jLabel14.setHorizontalAlignment(0);
/*  82 */     this.jLabel14.setText("Placas");
/*     */     
/*  84 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  85 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  86 */     this.jLabel32.setHorizontalAlignment(0);
/*  87 */     this.jLabel32.setText("Marca");
/*     */     
/*  89 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  90 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  91 */     this.jLabel38.setHorizontalAlignment(0);
/*  92 */     this.jLabel38.setText("Tipo");
/*     */     
/*  94 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  96 */             TractoEliminar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 100 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 102 */             TractoEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 106 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 107 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 108 */     this.jLabel15.setHorizontalAlignment(0);
/* 109 */     this.jLabel15.setText("Número");
/*     */     
/* 111 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 112 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 114 */             TractoEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 118 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 119 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 121 */             TractoEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 125 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 126 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 127 */     this.jLabel39.setHorizontalAlignment(0);
/* 128 */     this.jLabel39.setText("Modelo");
/*     */     
/* 130 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 131 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 133 */             TractoEliminar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 137 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 138 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 139 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 141 */             TractoEliminar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 145 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 146 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 147 */     this.jLabel40.setHorizontalAlignment(0);
/* 148 */     this.jLabel40.setText("Estado");
/*     */     
/* 150 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 151 */     this.jPanel17.setLayout(jPanel17Layout);
/* 152 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 153 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 155 */           .addContainerGap()
/* 156 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 157 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 158 */               .addComponent(this.jTextField1, -2, 49, -2)
/* 159 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 160 */               .addComponent(this.jTextField2, -2, 155, -2))
/* 161 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 162 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 163 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 164 */               .addComponent(this.jLabel14, -1, -1, 32767)))
/* 165 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 166 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 167 */             .addComponent(this.jLabel32, -1, -1, 32767)
/* 168 */             .addComponent(this.jComboBox1, -2, 238, -2))
/* 169 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 170 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 171 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 172 */             .addComponent(this.jComboBox2, -2, 211, -2))
/* 173 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 174 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 175 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 176 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 177 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 178 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 179 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 180 */             .addComponent(this.jComboBox4, -2, 109, -2))
/* 181 */           .addContainerGap(-1, 32767)));
/*     */     
/* 183 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 186 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 187 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 188 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 189 */           .addGap(6, 6, 6)
/* 190 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 191 */             .addComponent(this.jLabel15)
/* 192 */             .addComponent(this.jLabel14)))
/* 193 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 194 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 195 */           .addGap(6, 6, 6)
/* 196 */           .addComponent(this.jLabel32))
/* 197 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 198 */           .addComponent(this.jComboBox2, -2, -1, -2)
/* 199 */           .addGap(6, 6, 6)
/* 200 */           .addComponent(this.jLabel38))
/* 201 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 202 */           .addComponent(this.jComboBox3, -2, -1, -2)
/* 203 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 204 */           .addComponent(this.jLabel39))
/* 205 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 206 */           .addComponent(this.jComboBox4, -2, -1, -2)
/* 207 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 208 */           .addComponent(this.jLabel40)));
/*     */ 
/*     */     
/* 211 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 212 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 213 */     this.jLabel54.setHorizontalAlignment(0);
/* 214 */     this.jLabel54.setText("Eliminar Tractos");
/*     */     
/* 216 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 217 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 219 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 220 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 221 */     this.jLabel48.setHorizontalAlignment(2);
/* 222 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 224 */     this.jTable3.setAutoCreateRowSorter(true);
/* 225 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 226 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 234 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 239 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 242 */     this.jTable3.setShowVerticalLines(false);
/* 243 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 245 */             TractoEliminar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 248 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 250 */     this.jButton5.setMnemonic('E');
/* 251 */     this.jButton5.setText("Eliminar");
/* 252 */     this.jButton5.setToolTipText("Eliminar (Alt+E)");
/* 253 */     this.jButton5.setEnabled(false);
/* 254 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 256 */             TractoEliminar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 260 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 261 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 262 */     this.jLabel52.setHorizontalAlignment(2);
/* 263 */     this.jLabel52.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar'");
/*     */     
/* 265 */     this.jCheckBox1.setFont(new Font("Tahoma", 2, 10));
/* 266 */     this.jCheckBox1.setText("Seleccionar Todos");
/* 267 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 269 */             TractoEliminar.this.jCheckBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 273 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 274 */     this.jPanel5.setLayout(jPanel5Layout);
/* 275 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 277 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 278 */           .addContainerGap()
/* 279 */           .addComponent(this.jCheckBox1, -2, 129, -2)
/* 280 */           .addGap(128, 128, 128)
/* 281 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 282 */           .addGap(127, 127, 127)
/* 283 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 284 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 285 */           .addComponent(this.jButton5)
/* 286 */           .addContainerGap(-1, 32767))
/* 287 */         .addComponent(this.jScrollPane3));
/*     */     
/* 289 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 290 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 291 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 292 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 293 */             .addComponent(this.jButton5)
/* 294 */             .addComponent(this.jLabel52)
/* 295 */             .addComponent(this.jLabel48)
/* 296 */             .addComponent(this.jCheckBox1))
/* 297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 298 */           .addComponent(this.jScrollPane3, -1, 178, 32767)));
/*     */ 
/*     */     
/* 301 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 302 */     this.jPanel1.setLayout(jPanel1Layout);
/* 303 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 304 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 305 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 306 */           .addContainerGap()
/* 307 */           .addComponent(this.jLabel54, -2, 1038, -2)
/* 308 */           .addContainerGap(608, 32767))
/* 309 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 310 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*     */     
/* 312 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 314 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 315 */           .addComponent(this.jLabel54)
/* 316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 317 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 318 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 319 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 320 */           .addContainerGap()));
/*     */ 
/*     */     
/* 323 */     GroupLayout layout = new GroupLayout(this);
/* 324 */     setLayout(layout);
/* 325 */     layout.setHorizontalGroup(layout
/* 326 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 327 */         .addGap(0, 1658, 32767)
/* 328 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 329 */           .addGroup(layout.createSequentialGroup()
/* 330 */             .addContainerGap()
/* 331 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 332 */             .addContainerGap())));
/*     */     
/* 334 */     layout.setVerticalGroup(layout
/* 335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 336 */         .addGap(0, 360, 32767)
/* 337 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 338 */           .addGroup(layout.createSequentialGroup()
/* 339 */             .addGap(9, 9, 9)
/* 340 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 341 */             .addGap(9, 9, 9))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 346 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 350 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 354 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 358 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 362 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 366 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 370 */     int ind = this.jTable3.getSelectedRow();
/* 371 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 372 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/*     */     
/* 374 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 378 */     String ind = "";
/* 379 */     int contar = 0;
/* 380 */     int contador = 0;
/* 381 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 382 */       String val = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 383 */       if (val.equals("true")) {
/* 384 */         contar++;
/*     */       }
/*     */     } 
/* 387 */     if (contar == 0) {
/* 388 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar los tractos", "Selecciona Un Tracto", 0, this.INFO);
/*     */     }
/* 390 */     else if (contar == 1) {
/* 391 */       int doc = 0;
/* 392 */       for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 393 */         String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 394 */         if (val.equals("true")) {
/* 395 */           String str = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 396 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 400 */       String valor = "<html><b>Clave del Tracto: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "<br><b>Serie: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 4)) + "<br><b>Placas: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 8)) + "<br></html>";
/* 401 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Tracto", 0, 3, this.ELIMINAR);
/* 402 */       if (res == 0) {
/* 403 */         String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/* 404 */         String[] reg = this.con.regresaReg("Modelo,color,No_serie,No_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,id_marca,id_tipo", "tracto", "where num_tracto = " + val, 13);
/* 405 */         this.con.eliminar("tracto", "where num_tracto=" + val);
/* 406 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el tracto número " + val + " definitivamente.','Clave Tracto: " + val + "\nModelo: " + reg[0] + "\nColor: " + reg[1] + "\nNúmero de Serie: " + reg[2] + "\nNúmero de Motor: " + reg[3] + "\nNúmero de Factura: " + reg[4] + "\nForma de Pago: " + reg[5] + "\nPlacas: " + reg[6] + "\nKilometros Recorridos: " + reg[7] + "\nPeso: " + reg[8] + "\nDimensión: " + reg[9] + "\nEstado :" + reg[10] + "\nFecha de Adquisición :" + reg[11] + "')");
/* 407 */         this.mensajeTry.guardarConf("Se ha eliminado una unidad, USUARIO: " + this.USUARIO, "Unidad Eliminada (" + valor + ")", "ERROR", "Perforacion");
/* 408 */         consultar();
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 413 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Tractos", 0, 3, this.ELIMINAR);
/* 414 */       if (res == 0) {
/* 415 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 416 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 417 */           if (val.equals("true")) {
/* 418 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 419 */             String[] reg = this.con.regresaReg("Modelo,color,No_serie,No_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,id_marca,id_tipo", "tracto", "where num_tracto = " + valor, 13);
/* 420 */             contador++;
/* 421 */             this.con.eliminar2("tracto", "where num_tracto=" + valor);
/* 422 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el tracto número " + valor + " definitivamente.','Clave Tracto: " + val + "\nModelo: " + reg[0] + "\nColor: " + reg[1] + "\nNúmero de Serie: " + reg[2] + "\nNúmero de Motor: " + reg[3] + "\nNúmero de Factura: " + reg[4] + "\nForma de Pago: " + reg[5] + "\nPlacas: " + reg[6] + "\nKilometros Recorridos: " + reg[7] + "\nPeso: " + reg[8] + "\nDimensión: " + reg[9] + "\nEstado :" + reg[10] + "\nFecha de Adquisición :" + reg[11] + "')");
/* 423 */             this.mensajeTry.guardarConf("Se ha eliminado una unidad, USUARIO: " + this.USUARIO, "Unidad Eliminada (" + valor + ")", "ERROR", "Perforacion");
/*     */           } 
/*     */         } 
/* 426 */         consultar();
/* 427 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " tractos.", "Tractos Eliminados", 0, this.INFO);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 433 */     if (this.jCheckBox1.isSelected() == true) {
/* 434 */       for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 435 */         this.jTable3.setValueAt(Boolean.valueOf(true), i, 0);
/*     */       }
/*     */     } else {
/*     */       
/* 439 */       for (int i = 0; i < this.jTable3.getRowCount(); i++)
/* 440 */         this.jTable3.setValueAt(Boolean.valueOf(false), i, 0); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 445 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 447 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 450 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 453 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 455 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 458 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 461 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 463 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 466 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 469 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 471 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 474 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 477 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 479 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 482 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 485 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 487 */             TractoEliminar.this.jTextGanado(TractoEliminar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 490 */             TractoEliminar.this.jTextPerdido(TractoEliminar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 495 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 498 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 502 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 503 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 504 */       setCursor(micursor);
/*     */     }
/* 506 */     catch (Exception e) {
/* 507 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void tracto(String usu) {
/* 511 */     this.USUARIO = usu;
/* 512 */     this.panel.setViewportView(this);
/* 513 */     llenarCombos();
/* 514 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 517 */     this.con.consultar("count(marca)", "marca", "");
/* 518 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 519 */     this.jComboBox1.removeAllItems();
/* 520 */     this.jComboBox1.addItem("Cualquiera"); int i;
/* 521 */     for (i = 0; i < depa.length; i++) {
/* 522 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/*     */     
/* 525 */     this.con.consultar("count(tipo)", "tipos", "");
/* 526 */     depa = this.con.regresaCol("tipo", "tipos", "order by tipo", Integer.parseInt(this.con.Campo));
/* 527 */     this.jComboBox2.removeAllItems();
/* 528 */     this.jComboBox2.addItem("Cualquiera");
/* 529 */     for (i = 0; i < depa.length; i++) {
/* 530 */       this.jComboBox2.addItem(depa[i]);
/*     */     }
/* 532 */     this.jComboBox3.removeAllItems();
/* 533 */     int año = this.fechaActual.getYear();
/* 534 */     año += 1901;
/* 535 */     this.jComboBox3.addItem("Cualquiera");
/* 536 */     for (int j = año; j >= 1990; j--)
/* 537 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 541 */     this.jCheckBox1.setSelected(false);
/* 542 */     String numero = this.jTextField1.getText();
/* 543 */     String serie = this.jTextField2.getText();
/* 544 */     String marca = "";
/* 545 */     String tipo = "";
/* 546 */     String modelo = "";
/* 547 */     String estado = "";
/* 548 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 549 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 551 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 552 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 554 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 555 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 557 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 558 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 560 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_tracto<>0");
/* 561 */     int totreg = Integer.parseInt(this.con.Campo);
/* 562 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto<>0");
/* 563 */     String tot = this.con.Campo;
/* 564 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 565 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 566 */           .buscarReg(19, totreg, "num_tracto,modelo,color,no_serie,no_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipos.tipo,tracto.num_sem,tracto.NUM_sct,tracto.num_sed,tracto.num_seg,tracto.num_eco", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_tracto<>0 order by num_tracto"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 571 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 574 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               true }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 578 */             return this.canEdit[columnIndex];
/*     */           }
/*     */           public Class getColumnClass(int columnIndex) {
/* 581 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/* 584 */     this.jTable3.setShowVerticalLines(false);
/* 585 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 587 */             TractoEliminar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 590 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 591 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 592 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 593 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 594 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 595 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
/* 596 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(60);
/* 597 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 598 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/* 599 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(50);
/* 600 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(50);
/* 601 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 602 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 603 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 604 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 605 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 606 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 607 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 608 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 609 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 610 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 611 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(65);
/* 612 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(65);
/* 613 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 614 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/* 615 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(75);
/* 616 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(75);
/* 617 */     this.jTable3.getColumnModel().getColumn(20).setPreferredWidth(35);
/* 618 */     this.jTable3.getColumnModel().getColumn(20).setMaxWidth(35);
/*     */     
/* 620 */     this.jButton5.setEnabled(false);
/* 621 */     this.jTable3.setSelectionMode(0);
/* 622 */     this.jTable3.setAutoCreateRowSorter(true);
/* 623 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 625 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 626 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 627 */       if (valor.equals("0")) {
/* 628 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 631 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 635 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 636 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 637 */       if (valor.equals("0")) {
/* 638 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 641 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 645 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 646 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 647 */       if (valor.equals("0")) {
/* 648 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 651 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/*     */     
/* 655 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 656 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 657 */       if (valor.equals("0")) {
/* 658 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 661 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/*     */     
/* 665 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 666 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 19));
/* 667 */       if (valor.equals("0")) {
/* 668 */         this.jTable3.setValueAt("No", i, 19);
/*     */       } else {
/*     */         
/* 671 */         this.jTable3.setValueAt("Si", i, 19);
/*     */       } 
/*     */     } 
/* 674 */     this.jTable3.getColumnModel().moveColumn(20, 0);
/*     */     
/* 676 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 677 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 678 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 679 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 680 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 681 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 682 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 683 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 684 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 685 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 686 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 687 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 688 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 689 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 690 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 691 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 692 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 693 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 694 */     this.jTable3.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/* 695 */     this.jTable3.getColumnModel().getColumn(20).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 698 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 699 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 701 */       setEnabled((table == null || table.isEnabled()));
/* 702 */       if (row % 2 == 0 && column == 8) {
/* 703 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 705 */       else if (row % 2 == 0) {
/* 706 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 708 */         setBackground((Color)null);
/* 709 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 710 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TractoEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */