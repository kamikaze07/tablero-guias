/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class CajaEliminar extends JPanel {
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
/*  34 */   MensajePop mensajeTry = null; private JButton jButton5; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39;
/*     */   public CajaEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
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
/*     */   private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   
/*     */   private void initComponents() {
/*  51 */     this.jPanel1 = new JPanel();
/*  52 */     this.jPanel17 = new JPanel();
/*  53 */     this.jLabel14 = new JLabel();
/*  54 */     this.jLabel32 = new JLabel();
/*  55 */     this.jLabel38 = new JLabel();
/*  56 */     this.jTextField2 = new JTextField();
/*  57 */     this.jTextField1 = new JTextField();
/*  58 */     this.jLabel15 = new JLabel();
/*  59 */     this.jComboBox1 = new JComboBox();
/*  60 */     this.jComboBox2 = new JComboBox();
/*  61 */     this.jLabel39 = new JLabel();
/*  62 */     this.jComboBox3 = new JComboBox();
/*  63 */     this.jComboBox4 = new JComboBox();
/*  64 */     this.jLabel40 = new JLabel();
/*  65 */     this.jLabel54 = new JLabel();
/*  66 */     this.jPanel5 = new JPanel();
/*  67 */     this.jLabel48 = new JLabel();
/*  68 */     this.jScrollPane3 = new JScrollPane();
/*  69 */     this.jTable3 = new JTable();
/*  70 */     this.jButton5 = new JButton();
/*  71 */     this.jLabel52 = new JLabel();
/*  72 */     this.jCheckBox1 = new JCheckBox();
/*     */     
/*  74 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  75 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*     */     
/*  77 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  78 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Remolques ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  80 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  81 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  82 */     this.jLabel14.setHorizontalAlignment(0);
/*  83 */     this.jLabel14.setText("Placas");
/*     */     
/*  85 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  86 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  87 */     this.jLabel32.setHorizontalAlignment(0);
/*  88 */     this.jLabel32.setText("Marca");
/*     */     
/*  90 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  91 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  92 */     this.jLabel38.setHorizontalAlignment(0);
/*  93 */     this.jLabel38.setText("Tipo");
/*     */     
/*  95 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  97 */             CajaEliminar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 101 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 103 */             CajaEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 108 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 109 */     this.jLabel15.setHorizontalAlignment(0);
/* 110 */     this.jLabel15.setText("Número");
/*     */     
/* 112 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 113 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 115 */             CajaEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 119 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 120 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Góndola", "Pipa" }));
/* 121 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 123 */             CajaEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 127 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 128 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 129 */     this.jLabel39.setHorizontalAlignment(0);
/* 130 */     this.jLabel39.setText("Modelo");
/*     */     
/* 132 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 133 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 135 */             CajaEliminar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 139 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 140 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 141 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 143 */             CajaEliminar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 147 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 148 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 149 */     this.jLabel40.setHorizontalAlignment(0);
/* 150 */     this.jLabel40.setText("Estado");
/*     */     
/* 152 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 153 */     this.jPanel17.setLayout(jPanel17Layout);
/* 154 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 157 */           .addContainerGap()
/* 158 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 159 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 160 */               .addComponent(this.jTextField1, -2, 49, -2)
/* 161 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 162 */               .addComponent(this.jTextField2, -2, 155, -2))
/* 163 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 164 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 165 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 166 */               .addComponent(this.jLabel14, -1, -1, 32767)))
/* 167 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 168 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 169 */             .addComponent(this.jLabel32, -1, -1, 32767)
/* 170 */             .addComponent(this.jComboBox1, 0, 184, 32767))
/* 171 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 172 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 173 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 174 */             .addComponent(this.jComboBox2, -2, 211, -2))
/* 175 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 176 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 177 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 178 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 179 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 180 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 181 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 182 */             .addComponent(this.jComboBox4, -2, 111, -2))
/* 183 */           .addGap(550, 550, 550)));
/*     */     
/* 185 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 186 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 187 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 188 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 189 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 190 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 191 */                 .addComponent(this.jTextField2, -2, -1, -2)
/* 192 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 193 */                 .addComponent(this.jComboBox1, -2, -1, -2))
/* 194 */               .addGap(6, 6, 6)
/* 195 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 196 */                 .addComponent(this.jLabel15)
/* 197 */                 .addComponent(this.jLabel14)
/* 198 */                 .addComponent(this.jLabel32)))
/* 199 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 200 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 201 */               .addGap(6, 6, 6)
/* 202 */               .addComponent(this.jLabel38))
/* 203 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 204 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 205 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 206 */               .addComponent(this.jLabel39))
/* 207 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 208 */               .addComponent(this.jComboBox4, -2, -1, -2)
/* 209 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 210 */               .addComponent(this.jLabel40)))
/* 211 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 214 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 215 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 216 */     this.jLabel54.setHorizontalAlignment(0);
/* 217 */     this.jLabel54.setText("Eliminar Remolques");
/*     */     
/* 219 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 220 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 222 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 223 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 224 */     this.jLabel48.setHorizontalAlignment(2);
/* 225 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 227 */     this.jTable3.setAutoCreateRowSorter(true);
/* 228 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 229 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 237 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 242 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 245 */     this.jTable3.setShowVerticalLines(false);
/* 246 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 248 */     this.jButton5.setMnemonic('E');
/* 249 */     this.jButton5.setText("Eliminar");
/* 250 */     this.jButton5.setToolTipText("Eliminar (Alt+E)");
/* 251 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 253 */             CajaEliminar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 257 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 258 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 259 */     this.jLabel52.setHorizontalAlignment(2);
/* 260 */     this.jLabel52.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar'");
/*     */     
/* 262 */     this.jCheckBox1.setFont(new Font("Tahoma", 2, 10));
/* 263 */     this.jCheckBox1.setText("Seleccionar Todos");
/* 264 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 266 */             CajaEliminar.this.jCheckBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 270 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 271 */     this.jPanel5.setLayout(jPanel5Layout);
/* 272 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 273 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 274 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 275 */           .addContainerGap()
/* 276 */           .addComponent(this.jCheckBox1, -2, 129, -2)
/* 277 */           .addGap(132, 132, 132)
/* 278 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 279 */           .addGap(123, 123, 123)
/* 280 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 281 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 282 */           .addComponent(this.jButton5)
/* 283 */           .addContainerGap(402, 32767))
/* 284 */         .addComponent(this.jScrollPane3, -1, 1423, 32767));
/*     */     
/* 286 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 288 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 289 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 290 */             .addComponent(this.jButton5)
/* 291 */             .addComponent(this.jLabel52)
/* 292 */             .addComponent(this.jLabel48)
/* 293 */             .addComponent(this.jCheckBox1))
/* 294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 295 */           .addComponent(this.jScrollPane3, -1, 200, 32767)));
/*     */ 
/*     */     
/* 298 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 299 */     this.jPanel1.setLayout(jPanel1Layout);
/* 300 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 302 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 303 */           .addContainerGap()
/* 304 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 305 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 306 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 307 */             .addComponent(this.jLabel54, -2, 1038, -2))
/* 308 */           .addContainerGap()));
/*     */     
/* 310 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 312 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 313 */           .addContainerGap()
/* 314 */           .addComponent(this.jLabel54)
/* 315 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 316 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 317 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 318 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 319 */           .addContainerGap()));
/*     */ 
/*     */     
/* 322 */     GroupLayout layout = new GroupLayout(this);
/* 323 */     setLayout(layout);
/* 324 */     layout.setHorizontalGroup(layout
/* 325 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 326 */         .addGap(0, 1479, 32767)
/* 327 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 328 */           .addGroup(layout.createSequentialGroup()
/* 329 */             .addContainerGap()
/* 330 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 331 */             .addContainerGap())));
/*     */     
/* 333 */     layout.setVerticalGroup(layout
/* 334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 335 */         .addGap(0, 421, 32767)
/* 336 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */           .addGroup(layout.createSequentialGroup()
/* 338 */             .addGap(15, 15, 15)
/* 339 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 340 */             .addGap(15, 15, 15))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 345 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 349 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 353 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 357 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 361 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 365 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 369 */     String ind = "";
/* 370 */     int contar = 0;
/* 371 */     int contador = 0;
/* 372 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 373 */       String val = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 374 */       if (val.equals("true")) {
/* 375 */         contar++;
/*     */       }
/*     */     } 
/* 378 */     if (contar == 0) {
/* 379 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar los remolques", "Selecciona Un Remolque", 0, this.INFO);
/*     */     }
/* 381 */     else if (contar == 1) {
/* 382 */       int doc = 0;
/* 383 */       for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 384 */         String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 385 */         if (val.equals("true")) {
/* 386 */           String str = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 387 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 391 */       String valor = "<html><b>Clave del Tracto: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "<br><b>Serie: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 4)) + "<br><b>Placas: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 7)) + "<br></html>";
/* 392 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Remolque", 0, 3, this.ELIMINAR);
/* 393 */       if (res == 0) {
/* 394 */         String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/* 395 */         String[] reg = this.con.regresaReg("Modelo,color,No_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,tipo,id_marca", "remolque", "where num_rem = " + val, 12);
/* 396 */         this.con.eliminar("remolque", "where num_rem=" + val);
/* 397 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el remolque número " + val + " definitivamente.','Clave Remolque: " + val + "\nModelo: " + reg[0] + "\nColor: " + reg[1] + "\nNúmero de Serie: " + reg[2] + "\nNúmero de Factura: " + reg[3] + "\nForma de Pago: " + reg[4] + "\nPlacas: " + reg[5] + "\nKilometros Recorridos: " + reg[6] + "\nPeso: " + reg[7] + "\nDimensión: " + reg[8] + "\nEstado :" + reg[9] + "\nFecha de Adquisición :" + reg[10] + "')");
/* 398 */         this.mensajeTry.guardarConf("Se ha eliminado un remolque, USUARIO: " + this.USUARIO, "Remolque Eliminado (" + val + ")", "ERROR", "Perforacion");
/* 399 */         consultar();
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 404 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Remolques", 0, 3, this.ELIMINAR);
/* 405 */       if (res == 0) {
/* 406 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 407 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 408 */           if (val.equals("true")) {
/* 409 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 410 */             String[] reg = this.con.regresaReg("Modelo,color,No_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,tipo,id_marca", "remolque", "where num_rem = " + valor, 12);
/* 411 */             contador++;
/* 412 */             this.con.eliminar2("remolque", "where num_rem=" + valor);
/* 413 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el remolque número " + val + " definitivamente.','Clave Remolque: " + val + "\nModelo: " + reg[0] + "\nColor: " + reg[1] + "\nNúmero de Serie: " + reg[2] + "\nNúmero de Factura: " + reg[3] + "\nForma de Pago: " + reg[4] + "\nPlacas: " + reg[5] + "\nKilometros Recorridos: " + reg[6] + "\nPeso: " + reg[7] + "\nDimensión: " + reg[8] + "\nEstado :" + reg[9] + "\nFecha de Adquisición :" + reg[10] + "')");
/* 414 */             this.mensajeTry.guardarConf("Se ha eliminado un remolque, USUARIO: " + this.USUARIO, "Remolque Eliminado (" + valor + ")", "ERROR", "Perforacion");
/*     */           } 
/*     */         } 
/* 417 */         consultar();
/* 418 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " remolques.", "Cajas Eliminadas", 0, this.INFO);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 424 */     if (this.jCheckBox1.isSelected() == true) {
/* 425 */       for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 426 */         this.jTable3.setValueAt(Boolean.valueOf(true), i, 0);
/*     */       }
/*     */     } else {
/*     */       
/* 430 */       for (int i = 0; i < this.jTable3.getRowCount(); i++)
/* 431 */         this.jTable3.setValueAt(Boolean.valueOf(false), i, 0); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 436 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 438 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 441 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 444 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 446 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 449 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 452 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 454 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 457 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 460 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 462 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 465 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 468 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 470 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 473 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 476 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 478 */             CajaEliminar.this.jTextGanado(CajaEliminar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 481 */             CajaEliminar.this.jTextPerdido(CajaEliminar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 486 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 489 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 493 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 494 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 495 */       setCursor(micursor);
/*     */     }
/* 497 */     catch (Exception e) {
/* 498 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void caja(String usu) {
/* 502 */     this.USUARIO = usu;
/* 503 */     this.panel.setViewportView(this);
/* 504 */     llenarCombos();
/* 505 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 508 */     this.con.consultar("count(marca)", "marca", "");
/* 509 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 510 */     this.jComboBox1.removeAllItems();
/* 511 */     this.jComboBox1.addItem("Cualquiera");
/* 512 */     for (int i = 0; i < depa.length; i++) {
/* 513 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 523 */     this.jComboBox3.removeAllItems();
/* 524 */     int año = this.fechaActual.getYear();
/* 525 */     año += 1901;
/* 526 */     this.jComboBox3.addItem("Cualquiera");
/* 527 */     for (int j = año; j >= 1990; j--)
/* 528 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 532 */     this.jCheckBox1.setSelected(false);
/* 533 */     String numero = this.jTextField1.getText();
/* 534 */     String serie = this.jTextField2.getText();
/* 535 */     String marca = "";
/* 536 */     String tipo = "";
/* 537 */     String modelo = "";
/* 538 */     String estado = "";
/* 539 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 540 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 542 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 543 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 545 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 546 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 548 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 549 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 551 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_rem<>0");
/* 552 */     int totreg = Integer.parseInt(this.con.Campo);
/* 553 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem<>0");
/* 554 */     String tot = this.con.Campo;
/* 555 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 556 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 557 */           .buscarReg(19, totreg, "num_rem,modelo,color,no_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipo,remolque.num_sem,remolque.NUM_sct,remolque.num_sed,remolque.num_seg,remolque.num_eco", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_rem<>0 order by num_rem"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 562 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 565 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, true };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 569 */             return this.canEdit[columnIndex];
/*     */           }
/*     */           public Class getColumnClass(int columnIndex) {
/* 572 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/* 575 */     this.jTable3.setShowVerticalLines(false);
/* 576 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 577 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 578 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 579 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 580 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 581 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 582 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/*     */ 
/*     */     
/* 585 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 586 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 587 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 588 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 589 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(45);
/* 590 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(45);
/* 591 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 592 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 593 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(65);
/* 594 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(65);
/* 595 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(85);
/* 596 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(85);
/*     */     
/* 598 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(65);
/* 599 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(65);
/* 600 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 601 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(65);
/* 602 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 603 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 604 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 605 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 606 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(75);
/* 607 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(75);
/* 608 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 609 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/* 610 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(35);
/* 611 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(35);
/*     */     
/* 613 */     this.jTable3.setSelectionMode(0);
/* 614 */     this.jTable3.setAutoCreateRowSorter(true);
/* 615 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 617 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 618 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 14));
/* 619 */       if (valor.equals("0")) {
/* 620 */         this.jTable3.setValueAt("No", i, 14);
/*     */       } else {
/*     */         
/* 623 */         this.jTable3.setValueAt("Si", i, 14);
/*     */       } 
/*     */     } 
/*     */     
/* 627 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 628 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 629 */       if (valor.equals("0")) {
/* 630 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 633 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 637 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 638 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 639 */       if (valor.equals("0")) {
/* 640 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 643 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 647 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 648 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 649 */       if (valor.equals("0")) {
/* 650 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 653 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/*     */     
/* 657 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 658 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 659 */       if (valor.equals("0")) {
/* 660 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 663 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/* 666 */     this.jTable3.getColumnModel().moveColumn(19, 0);
/*     */     
/* 668 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 669 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 670 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 671 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 672 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 673 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 674 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 675 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 676 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 677 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 678 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 679 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 680 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 681 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 682 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 683 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 684 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 685 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 686 */     this.jTable3.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 689 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 690 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 692 */       setEnabled((table == null || table.isEnabled()));
/* 693 */       if (row % 2 == 0 && column == 7) {
/* 694 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 696 */       else if (row % 2 == 0) {
/* 697 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 699 */         setBackground((Color)null);
/* 700 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 701 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CajaEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */