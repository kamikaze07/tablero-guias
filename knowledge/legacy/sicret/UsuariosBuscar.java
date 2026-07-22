/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class UsuariosBuscar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*     */   JFrame frame;
/*     */   JScrollPane panel;
/*  29 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  30 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  31 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  32 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  33 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*     */   MostrarTabla modelo;
/*  36 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*     */   JTabbedPane fichas;
/*     */   String USUARIO;
/*     */   JTable tabla;
/*     */   EscribirReporte esc;
/*     */   ReporteIndividual indi;
/*  42 */   CeldaRender celda = new CeldaRender(); JFrame padre; private JButton jButton5; private JComboBox jComboBox1; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel48;
/*     */   private JLabel jLabel52;
/*     */   
/*     */   public UsuariosBuscar(JFrame padre, JScrollPane panelito, String usua, JTabbedPane fichas) {
/*  46 */     this.fichas = fichas;
/*  47 */     this.frame = padre;
/*  48 */     this.padre = padre;
/*  49 */     initComponents();
/*  50 */     this.USUARIO = usua;
/*  51 */     panelito.setViewportView(this);
/*  52 */     this.panel = panelito;
/*  53 */     colorear();
/*  54 */     consultar();
/*  55 */     if (fichas != null) {
/*  56 */       fichas.addTab("Usuarios - [Buscar Uusarios]", panelito);
/*  57 */       if (fichas != null) {
/*  58 */         fichas.addTab("Usuarios - [Buscar Usuarios]", this.panel);
/*  59 */         this.jButton5.setText("Asignar");
/*  60 */         this.jLabel52.setText("Selecciona el registro y presiona el botón 'Asignar'");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4;
/*     */   
/*     */   private void initComponents() {
/*  67 */     this.jPanel1 = new JPanel();
/*  68 */     this.jLabel54 = new JLabel();
/*  69 */     this.jPanel5 = new JPanel();
/*  70 */     this.jScrollPane3 = new JScrollPane();
/*  71 */     this.jTable3 = new JTable();
/*  72 */     this.jButton5 = new JButton();
/*  73 */     this.jLabel52 = new JLabel();
/*  74 */     this.jLabel48 = new JLabel();
/*  75 */     this.jPanel17 = new JPanel();
/*  76 */     this.jLabel14 = new JLabel();
/*  77 */     this.jLabel32 = new JLabel();
/*  78 */     this.jLabel38 = new JLabel();
/*  79 */     this.jTextField1 = new JTextField();
/*  80 */     this.jTextField2 = new JTextField();
/*  81 */     this.jTextField3 = new JTextField();
/*  82 */     this.jComboBox1 = new JComboBox();
/*  83 */     this.jLabel39 = new JLabel();
/*  84 */     this.jTextField4 = new JTextField();
/*  85 */     this.jLabel15 = new JLabel();
/*     */     
/*  87 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  88 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  90 */     this.jLabel54.setFont(new Font("Tahoma", 1, 20));
/*  91 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  92 */     this.jLabel54.setHorizontalAlignment(0);
/*  93 */     this.jLabel54.setText("Buscar Usuarios");
/*     */     
/*  95 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  96 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  98 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  99 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Nombre de Usuario", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P." }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.jTable3.setShowVerticalLines(false);
/* 108 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 110 */             UsuariosBuscar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 113 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 115 */             UsuariosBuscar.this.jTable3KeyReleased(evt);
/*     */           }
/*     */         });
/* 118 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 120 */     this.jButton5.setMnemonic('G');
/* 121 */     this.jButton5.setText("Guardar Reporte");
/* 122 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 123 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 125 */             UsuariosBuscar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 129 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 130 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 131 */     this.jLabel52.setHorizontalAlignment(2);
/* 132 */     this.jLabel52.setText("Si deseas crear un nuevo reporte presiona el botón de 'Guardar Reporte'");
/*     */     
/* 134 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 135 */     this.jLabel48.setForeground(Color.red);
/* 136 */     this.jLabel48.setHorizontalAlignment(0);
/* 137 */     this.jLabel48.setText("t");
/* 138 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 140 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 141 */     this.jPanel5.setLayout(jPanel5Layout);
/* 142 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 144 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 145 */           .addGap(1, 1, 1)
/* 146 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 147 */           .addGap(99, 99, 99)
/* 148 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 149 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 150 */           .addComponent(this.jButton5)
/* 151 */           .addContainerGap(435, 32767))
/* 152 */         .addComponent(this.jScrollPane3, -1, 1182, 32767));
/*     */     
/* 154 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 157 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 158 */             .addComponent(this.jLabel48)
/* 159 */             .addComponent(this.jButton5)
/* 160 */             .addComponent(this.jLabel52))
/* 161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 162 */           .addComponent(this.jScrollPane3, -1, 196, 32767)));
/*     */ 
/*     */     
/* 165 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 166 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Usuarios ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 168 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/* 169 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/* 170 */     this.jLabel14.setHorizontalAlignment(0);
/* 171 */     this.jLabel14.setText("Nombre (s)");
/*     */     
/* 173 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/* 174 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 175 */     this.jLabel32.setText("Apellido Paterno");
/*     */     
/* 177 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/* 178 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 179 */     this.jLabel38.setHorizontalAlignment(0);
/* 180 */     this.jLabel38.setText("Apellido Materno");
/*     */     
/* 182 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 184 */             UsuariosBuscar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 188 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 190 */             UsuariosBuscar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 194 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 196 */             UsuariosBuscar.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 200 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 201 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 202 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Administrador", "Facturación", "Gerente de Operaciones", "Jefe de Liquidaciones", "Jefe de Tráfico", "Liquidaciones", "Tráfico", "Sistemas", "Recursos Humanos", "Super Usuario" }));
/* 203 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 205 */             UsuariosBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 209 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 210 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 211 */     this.jLabel39.setHorizontalAlignment(0);
/* 212 */     this.jLabel39.setText("Privilegios");
/*     */     
/* 214 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 216 */             UsuariosBuscar.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 220 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 221 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 222 */     this.jLabel15.setHorizontalAlignment(0);
/* 223 */     this.jLabel15.setText("Nombre de Usuario");
/*     */     
/* 225 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 226 */     this.jPanel17.setLayout(jPanel17Layout);
/* 227 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 229 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 230 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 231 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 232 */             .addComponent(this.jTextField4, -2, 155, -2))
/* 233 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 234 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 235 */             .addComponent(this.jLabel14, -1, -1, 32767)
/* 236 */             .addComponent(this.jTextField1, -2, 155, -2))
/* 237 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 238 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 239 */             .addComponent(this.jTextField2, -2, 151, -2)
/* 240 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 241 */               .addGap(34, 34, 34)
/* 242 */               .addComponent(this.jLabel32, -2, 90, -2)))
/* 243 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 244 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 245 */             .addComponent(this.jTextField3, -2, 163, -2)
/* 246 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 247 */               .addGap(43, 43, 43)
/* 248 */               .addComponent(this.jLabel38)))
/* 249 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 250 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 251 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 252 */             .addComponent(this.jComboBox1, 0, 171, 32767))
/* 253 */           .addContainerGap(363, 32767)));
/*     */     
/* 255 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 256 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 257 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 258 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 259 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 260 */               .addComponent(this.jTextField4, -2, -1, -2)
/* 261 */               .addGap(8, 8, 8)
/* 262 */               .addComponent(this.jLabel15))
/* 263 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 264 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 265 */                 .addComponent(this.jTextField3, -2, -1, -2)
/* 266 */                 .addComponent(this.jComboBox1, -2, -1, -2))
/* 267 */               .addGap(8, 8, 8)
/* 268 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 269 */                 .addComponent(this.jLabel38)
/* 270 */                 .addComponent(this.jLabel39)))
/* 271 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 272 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 273 */               .addGap(8, 8, 8)
/* 274 */               .addComponent(this.jLabel32))
/* 275 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 276 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 277 */               .addGap(8, 8, 8)
/* 278 */               .addComponent(this.jLabel14)))
/* 279 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 282 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 283 */     this.jPanel1.setLayout(jPanel1Layout);
/* 284 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 286 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 287 */           .addContainerGap()
/* 288 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 289 */             .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 290 */               .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 291 */               .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 292 */             .addComponent(this.jLabel54, -2, 1184, -2))
/* 293 */           .addContainerGap(-1, 32767)));
/*     */     
/* 295 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 296 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 297 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 298 */           .addComponent(this.jLabel54, -2, 22, -2)
/* 299 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 300 */           .addComponent(this.jPanel17, -2, 75, -2)
/* 301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 302 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 303 */           .addContainerGap()));
/*     */ 
/*     */     
/* 306 */     GroupLayout layout = new GroupLayout(this);
/* 307 */     setLayout(layout);
/* 308 */     layout.setHorizontalGroup(layout
/* 309 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 310 */         .addGap(0, 1238, 32767)
/* 311 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 312 */           .addGroup(layout.createSequentialGroup()
/* 313 */             .addGap(0, 10, 32767)
/* 314 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 315 */             .addGap(0, 10, 32767))));
/*     */     
/* 317 */     layout.setVerticalGroup(layout
/* 318 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 319 */         .addGap(0, 392, 32767)
/* 320 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 321 */           .addGroup(layout.createSequentialGroup()
/* 322 */             .addGap(8, 8, 8)
/* 323 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 324 */             .addGap(8, 8, 8))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTable3KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 337 */     String[] datos = { "NOMBRE DE USUARIO", "NOMBRES", "APELLIDO PATERNO", "APELLIDO MATERNO", "LIM CAJA CHICA", "PRIVILEGIOS" };
/* 338 */     this.esc = new EscribirReporte("USUARIOS", this.jTable3, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 342 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 346 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 350 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 354 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 358 */     consultar();
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 362 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 364 */             UsuariosBuscar.this.jTextGanado(UsuariosBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 367 */             UsuariosBuscar.this.jTextPerdido(UsuariosBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 370 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 372 */             UsuariosBuscar.this.jTextGanado(UsuariosBuscar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 375 */             UsuariosBuscar.this.jTextPerdido(UsuariosBuscar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 378 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 380 */             UsuariosBuscar.this.jTextGanado(UsuariosBuscar.this.jTextField3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 383 */             UsuariosBuscar.this.jTextPerdido(UsuariosBuscar.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 386 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 388 */             UsuariosBuscar.this.jTextGanado(UsuariosBuscar.this.jTextField4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 391 */             UsuariosBuscar.this.jTextPerdido(UsuariosBuscar.this.jTextField4, evt);
/*     */           }
/*     */         });
/* 394 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 396 */             UsuariosBuscar.this.jTextGanado(UsuariosBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 399 */             UsuariosBuscar.this.jTextPerdido(UsuariosBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 404 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 407 */     campo.setBackground(Color.white);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void Usuarios(String usu) {
/* 415 */     this.USUARIO = usu;
/* 416 */     this.panel.setViewportView(this);
/* 417 */     consultar();
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 421 */     String priv = "";
/* 422 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 423 */       priv = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 425 */     this.encontrado = this.con.consultar("count(nombre_usu)", "usuarios,empleados", "where nombre_usu<>'usuarioAdmin1' and clave_emp=num_emp and nombre_usu like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and priv like '%" + priv + "%'");
/* 426 */     int totreg = Integer.parseInt(this.con.Campo);
/* 427 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 428 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 429 */           .buscarReg(6, totreg, "nombre_usu,nombre,ap_pat,ap_mat,cajaChicaLetra,priv", "usuarios,empleados", "where nombre_usu<>'usuarioAdmin1' and clave_emp=num_emp and nombre_usu like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and priv like '%" + priv + "%' order by nombre_usu"), (Object[])new String[] { "Nombre Usuario", "Nombre", "Apellido Paterno", "Apellido Materno", "Lim Caja Chica", "Priviilegios" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 434 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 438 */             return this.canEdit[columnIndex];
/*     */           }
/* 440 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 444 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/* 447 */     this.con.consultar("count(nombre_usu)", "usuarios", "");
/* 448 */     String[] arre = this.con.regresaCol("nombre_usu", "usuarios", "", Integer.parseInt(this.con.Campo));
/* 449 */     this.celda.pasarInd(arre);
/* 450 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 451 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 452 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 453 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 454 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 455 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*     */     
/* 457 */     this.jTable3.setSelectionMode(0);
/* 458 */     this.jTable3.setAutoCreateRowSorter(true);
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 462 */     int otro = -1;
/* 463 */     String[] indices = new String[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 465 */       setEnabled((table == null || table.isEnabled()));
/* 466 */       String valor = String.valueOf(value);
/* 467 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 477 */       if (row % 2 == 0) {
/* 478 */         setBackground(new Color(194, 213, 151));
/* 479 */         setForeground(Color.black);
/*     */       } else {
/*     */         
/* 482 */         setBackground((Color)null);
/* 483 */         setForeground(Color.black);
/*     */       } 
/* 485 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 486 */       return this;
/*     */     }
/*     */     public void pasarInd(String[] ind) {
/* 489 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(String reg) {
/* 492 */       for (int i = 0; i < this.indices.length; i++) {
/* 493 */         if (this.indices[i].equals(reg)) {
/* 494 */           return true;
/*     */         }
/*     */       } 
/* 497 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UsuariosBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */