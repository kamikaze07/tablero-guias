/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.Calendar;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class EmpleadosEliminar extends JPanel {
/*      */   Border borde;
/*   27 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*   28 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   29 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   30 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   31 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   32 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   String USUARIO;
/*   34 */   Consultas con = new Consultas();
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   38 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   41 */   CeldaRender celda = new CeldaRender();
/*   42 */   String RUTA = "";
/*      */   MensajePop mensajeTry;
/*   44 */   SColores lc = new SColores();
/*   45 */   PlaceHolder placeHolder = null;
/*   46 */   String holderClave = "CLAVE";
/*   47 */   String holderNombre = "NOMBRE";
/*   48 */   String holderPaterno = "APELLIDO PATERNO";
/*   49 */   String holderMaterno = "APELLIDO MATERNO"; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel49; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JPanel jPanel1; private JPanel jPanel17;
/*      */   
/*      */   public EmpleadosEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   52 */     this.mensajeTry = mensajeTry;
/*   53 */     initComponents();
/*   54 */     this.con.consultar("fotosEmpleados", "configuraciones", "");
/*   55 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   56 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   57 */     this.rSTableMetro1.setCursor(micursor);
/*   58 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*   59 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderNombre, false, "Cantarell", 11);
/*   60 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderPaterno, false, "Cantarell", 11);
/*   61 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderMaterno, false, "Cantarell", 11);
/*   62 */     this.RUTA = this.con.Campo;
/*   63 */     this.padre = padre;
/*   64 */     this.fichas = fichas;
/*   65 */     colorear();
/*   66 */     this.USUARIO = USUARIO;
/*   67 */     panelito.setViewportView(this);
/*   68 */     this.panel = panelito;
/*   69 */     llenarCombo();
/*   70 */     consultar();
/*      */   }
/*      */   private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel7; private JScrollPane jScrollPane2; private JScrollPane jScrollPane29; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private MaterialButton materialButton1; private MaterialButton materialButton2;
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private void initComponents() {
/*   76 */     this.jPanel1 = new JPanel();
/*   77 */     this.jLabel54 = new JLabel();
/*   78 */     this.jPanel5 = new JPanel();
/*   79 */     this.jLabel52 = new JLabel();
/*   80 */     this.jPanel2 = new JPanel();
/*   81 */     this.jPanel3 = new JPanel();
/*   82 */     this.jLabel55 = new JLabel();
/*   83 */     this.jPanel17 = new JPanel();
/*   84 */     this.jTextField1 = new JTextField();
/*   85 */     this.jTextField2 = new JTextField();
/*   86 */     this.jTextField3 = new JTextField();
/*   87 */     this.jComboBox1 = new JComboBox();
/*   88 */     this.jTextField4 = new JTextField();
/*   89 */     this.jComboBox3 = new JComboBox();
/*   90 */     this.jComboBox4 = new JComboBox();
/*   91 */     this.jPanel4 = new JPanel();
/*   92 */     this.jScrollPane2 = new JScrollPane();
/*   93 */     this.jPanel7 = new JPanel();
/*   94 */     this.jScrollPane29 = new JScrollPane();
/*   95 */     this.rSTableMetro1 = new RSTableMetro();
/*   96 */     this.jCheckBox1 = new JCheckBox();
/*   97 */     this.jLabel49 = new JLabel();
/*   98 */     this.jLabel56 = new JLabel();
/*   99 */     this.materialButton1 = new MaterialButton();
/*  100 */     this.jLabel51 = new JLabel();
/*  101 */     this.jLabel53 = new JLabel();
/*  102 */     this.materialButton2 = new MaterialButton();
/*      */     
/*  104 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  105 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  107 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/*  108 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  109 */     this.jLabel54.setHorizontalAlignment(0);
/*  110 */     this.jLabel54.setText("Eliminar Empleados");
/*      */     
/*  112 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  113 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  115 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/*  116 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/*  117 */     this.jLabel52.setHorizontalAlignment(4);
/*  118 */     this.jLabel52.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar''");
/*      */     
/*  120 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  121 */     this.jPanel5.setLayout(jPanel5Layout);
/*  122 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  123 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  124 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  125 */           .addGap(638, 638, 638)
/*  126 */           .addComponent(this.jLabel52, -2, 383, -2)
/*  127 */           .addContainerGap(-1, 32767)));
/*      */     
/*  129 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  130 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  131 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  132 */           .addComponent(this.jLabel52)
/*  133 */           .addContainerGap(168, 32767)));
/*      */ 
/*      */     
/*  136 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  137 */     this.jPanel1.setLayout(jPanel1Layout);
/*  138 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  139 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  140 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  141 */           .addGap(337, 337, 337)
/*  142 */           .addComponent(this.jLabel54, -2, 891, -2)
/*  143 */           .addContainerGap(525, 32767))
/*  144 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */     
/*  146 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  147 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  148 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  149 */           .addComponent(this.jLabel54)
/*  150 */           .addGap(64, 64, 64)
/*  151 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*      */ 
/*      */     
/*  154 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  156 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  158 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/*  159 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/*  160 */     this.jLabel55.setHorizontalAlignment(0);
/*  161 */     this.jLabel55.setText("Eliminar Empleados");
/*      */     
/*  163 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  164 */     this.jPanel3.setLayout(jPanel3Layout);
/*  165 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  166 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  167 */         .addComponent(this.jLabel55, -1, -1, 32767));
/*      */     
/*  169 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  171 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  172 */           .addContainerGap()
/*  173 */           .addComponent(this.jLabel55)
/*  174 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  177 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*  178 */     this.jPanel17.setPreferredSize(new Dimension(220, 43));
/*  179 */     GridBagLayout jPanel17Layout = new GridBagLayout();
/*  180 */     jPanel17Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  181 */     jPanel17Layout.rowHeights = new int[] { 0 };
/*  182 */     this.jPanel17.setLayout(jPanel17Layout);
/*      */     
/*  184 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  186 */             EmpleadosEliminar.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*  189 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  190 */     gridBagConstraints.gridx = 4;
/*  191 */     gridBagConstraints.gridy = 0;
/*  192 */     gridBagConstraints.fill = 2;
/*  193 */     gridBagConstraints.weightx = 1.5D;
/*  194 */     this.jPanel17.add(this.jTextField1, gridBagConstraints);
/*      */     
/*  196 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  198 */             EmpleadosEliminar.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*  201 */     gridBagConstraints = new GridBagConstraints();
/*  202 */     gridBagConstraints.gridx = 6;
/*  203 */     gridBagConstraints.gridy = 0;
/*  204 */     gridBagConstraints.fill = 2;
/*  205 */     gridBagConstraints.weightx = 1.5D;
/*  206 */     this.jPanel17.add(this.jTextField2, gridBagConstraints);
/*      */     
/*  208 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  210 */             EmpleadosEliminar.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  213 */     gridBagConstraints = new GridBagConstraints();
/*  214 */     gridBagConstraints.gridx = 8;
/*  215 */     gridBagConstraints.gridy = 0;
/*  216 */     gridBagConstraints.fill = 2;
/*  217 */     gridBagConstraints.weightx = 1.5D;
/*  218 */     this.jPanel17.add(this.jTextField3, gridBagConstraints);
/*      */     
/*  220 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  221 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  223 */             EmpleadosEliminar.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  226 */     gridBagConstraints = new GridBagConstraints();
/*  227 */     gridBagConstraints.gridx = 12;
/*  228 */     gridBagConstraints.gridy = 0;
/*  229 */     gridBagConstraints.fill = 2;
/*  230 */     gridBagConstraints.weightx = 2.0D;
/*  231 */     this.jPanel17.add(this.jComboBox1, gridBagConstraints);
/*      */     
/*  233 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  235 */             EmpleadosEliminar.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*  238 */     gridBagConstraints = new GridBagConstraints();
/*  239 */     gridBagConstraints.gridx = 2;
/*  240 */     gridBagConstraints.gridy = 0;
/*  241 */     gridBagConstraints.fill = 2;
/*  242 */     gridBagConstraints.weightx = 1.0D;
/*  243 */     this.jPanel17.add(this.jTextField4, gridBagConstraints);
/*      */     
/*  245 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  246 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "ELIMINADOS", "TODOS" }));
/*  247 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  249 */             EmpleadosEliminar.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  252 */     gridBagConstraints = new GridBagConstraints();
/*  253 */     gridBagConstraints.gridx = 14;
/*  254 */     gridBagConstraints.gridy = 0;
/*  255 */     gridBagConstraints.fill = 2;
/*  256 */     gridBagConstraints.weightx = 1.5D;
/*  257 */     this.jPanel17.add(this.jComboBox3, gridBagConstraints);
/*      */     
/*  259 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  260 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "EMPLEADOS", "FUNCIONARIOS", "TODOS" }));
/*  261 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  263 */             EmpleadosEliminar.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  266 */     gridBagConstraints = new GridBagConstraints();
/*  267 */     gridBagConstraints.gridx = 10;
/*  268 */     gridBagConstraints.gridy = 0;
/*  269 */     gridBagConstraints.fill = 2;
/*  270 */     gridBagConstraints.weightx = 1.5D;
/*  271 */     this.jPanel17.add(this.jComboBox4, gridBagConstraints);
/*      */     
/*  273 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  275 */     this.jScrollPane2.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  277 */     this.jPanel7.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  279 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  287 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  292 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  295 */     this.rSTableMetro1.setAltoHead(40);
/*  296 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  297 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  298 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  299 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  300 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  301 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  302 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  303 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  304 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  305 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  306 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  307 */     this.rSTableMetro1.setRowHeight(18);
/*  308 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  309 */     this.rSTableMetro1.setShowHorizontalLines(false);
/*  310 */     this.rSTableMetro1.setShowVerticalLines(false);
/*  311 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  312 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  313 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  315 */             EmpleadosEliminar.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/*  318 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  320 */             EmpleadosEliminar.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/*  323 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*      */     
/*  325 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  326 */     this.jPanel7.setLayout(jPanel7Layout);
/*  327 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  328 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  329 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  330 */           .addComponent(this.jScrollPane29, -2, 1863, -2)
/*  331 */           .addGap(0, 0, 32767)));
/*      */     
/*  333 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  335 */         .addComponent(this.jScrollPane29, -1, 307, 32767));
/*      */ 
/*      */     
/*  338 */     this.jScrollPane2.setViewportView(this.jPanel7);
/*      */     
/*  340 */     this.jCheckBox1.setFont(new Font("Cantarell", 0, 11));
/*  341 */     this.jCheckBox1.setText("Seleccionar Todos");
/*  342 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  344 */             EmpleadosEliminar.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  348 */     this.jLabel49.setFont(new Font("Cantarell", 1, 13));
/*  349 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/*  350 */     this.jLabel49.setHorizontalAlignment(2);
/*  351 */     this.jLabel49.setText("0");
/*      */     
/*  353 */     this.jLabel56.setFont(new Font("Cantarell", 0, 11));
/*  354 */     this.jLabel56.setForeground(this.lc.SECUNDARIO1);
/*  355 */     this.jLabel56.setHorizontalAlignment(4);
/*  356 */     this.jLabel56.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar''");
/*      */     
/*  358 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/*  359 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/*  360 */     this.materialButton1.setMnemonic('E');
/*  361 */     this.materialButton1.setText("Eliminar");
/*  362 */     this.materialButton1.setToolTipText("Eliminar (Alt+E)");
/*  363 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/*  364 */     this.materialButton1.setHorizontalTextPosition(0);
/*  365 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  367 */             EmpleadosEliminar.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  371 */     this.jLabel51.setFont(new Font("Cantarell", 0, 13));
/*  372 */     this.jLabel51.setForeground(this.lc.SECUNDARIO1);
/*  373 */     this.jLabel51.setHorizontalAlignment(2);
/*  374 */     this.jLabel51.setText("Total:");
/*      */     
/*  376 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/*  377 */     this.jLabel53.setForeground(this.lc.PRIMARIO2);
/*  378 */     this.jLabel53.setHorizontalAlignment(4);
/*  379 */     this.jLabel53.setText("Activar Empleados");
/*      */     
/*  381 */     this.materialButton2.setBackground(this.lc.PRIMARIO1);
/*  382 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  383 */     this.materialButton2.setMnemonic('A');
/*  384 */     this.materialButton2.setText("Activar");
/*  385 */     this.materialButton2.setToolTipText("Activar (Alt+A)");
/*  386 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/*  387 */     this.materialButton2.setHorizontalTextPosition(0);
/*  388 */     this.materialButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  390 */             EmpleadosEliminar.this.materialButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  394 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  395 */     this.jPanel4.setLayout(jPanel4Layout);
/*  396 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  397 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  398 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  399 */           .addContainerGap()
/*  400 */           .addComponent(this.jCheckBox1, -2, 129, -2)
/*  401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  402 */           .addComponent(this.jLabel51, -2, 51, -2)
/*  403 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  404 */           .addComponent(this.jLabel49, -2, 93, -2)
/*  405 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767)
/*  406 */           .addComponent(this.jLabel53, -2, 137, -2)
/*  407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  408 */           .addComponent((Component)this.materialButton2, -2, 150, -2)
/*  409 */           .addGap(101, 101, 101)
/*  410 */           .addComponent(this.jLabel56, -2, 437, -2)
/*  411 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  412 */           .addComponent((Component)this.materialButton1, -2, 150, -2))
/*  413 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/*  415 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  417 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  418 */           .addComponent(this.jScrollPane2, -1, 323, 32767)
/*  419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  420 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  421 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  422 */               .addComponent(this.jLabel56)
/*  423 */               .addComponent((Component)this.materialButton1, -2, 38, -2)
/*  424 */               .addComponent((Component)this.materialButton2, -2, 38, -2)
/*  425 */               .addComponent(this.jLabel53))
/*  426 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  427 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  428 */                 .addComponent(this.jCheckBox1)
/*  429 */                 .addComponent(this.jLabel49)
/*  430 */                 .addComponent(this.jLabel51))
/*  431 */               .addContainerGap()))));
/*      */ 
/*      */     
/*  434 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  435 */     this.jPanel2.setLayout(jPanel2Layout);
/*  436 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  438 */         .addComponent(this.jPanel3, -1, -1, 32767)
/*  439 */         .addComponent(this.jPanel17, -1, -1, 32767)
/*  440 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/*  442 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  443 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  444 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  445 */           .addComponent(this.jPanel3, -2, -1, -2)
/*  446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  447 */           .addComponent(this.jPanel17, -2, 26, -2)
/*  448 */           .addGap(5, 5, 5)
/*  449 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*      */ 
/*      */     
/*  452 */     GroupLayout layout = new GroupLayout(this);
/*  453 */     setLayout(layout);
/*  454 */     layout.setHorizontalGroup(layout
/*  455 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  456 */         .addGap(0, 1297, 32767)
/*  457 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  458 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */     
/*  460 */     layout.setVerticalGroup(layout
/*  461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  462 */         .addGap(0, 447, 32767)
/*  463 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  464 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/*  468 */     consultar();
/*      */   }
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  471 */     consultar();
/*      */   }
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  474 */     consultar();
/*      */   }
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  477 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/*  481 */     consultar();
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/*  485 */     if (this.jCheckBox1.isSelected() == true) {
/*  486 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  487 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } else {
/*  490 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  491 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(false), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/*  497 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/*  501 */     consultar();
/*      */   }
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/*  505 */     String ind = "";
/*  506 */     int contar = 0;
/*  507 */     this.contador = 0;
/*  508 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  509 */       String val = String.valueOf(this.rSTableMetro1.getValueAt(i, 0));
/*  510 */       if (val.equals("true")) {
/*  511 */         contar++;
/*      */       }
/*      */     } 
/*  514 */     if (contar == 0) {
/*  515 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar empleados", "Selecciona Un Empleado", 0, this.INFO);
/*  516 */     } else if (contar == 1) {
/*  517 */       int doc = 0;
/*  518 */       for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  519 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  520 */         if (val.equals("true")) {
/*  521 */           String str = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  522 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/*  526 */       String valor = "<html><b>Número de Empleado: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 3)) + "<br></html>";
/*  527 */       if (this.jComboBox3.getSelectedIndex() == 0) {
/*  528 */         int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas guardar un historial para consultas posteriores?", "Eliminar Empleado", 1, 2, this.ELIMINAR);
/*      */         
/*  530 */         if (res == 0) {
/*  531 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/*  532 */           this.con.inserSinMsj("update empleados set actual = 1 where clave_emp = " + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)));
/*  533 */           this.con.inserSinMsj("update tarjeta_deudor set estatus='<BAJA>' where num_ope=0 and clave_emp=" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)));
/*  534 */           this.mensajeTry.guardarConf("Se ha eliminado un empleado-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Empleado de Baja", "ERROR", "Empleados");
/*  535 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "','Clave Empleado: " + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "\nSe almacenó para consultas posteriores')");
/*  536 */           this.con.consultar("comentarios", "EMPLEADOS", "where clave_emp = " + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)));
/*  537 */           String var = this.con.Campo;
/*  538 */           String nuevo = "EL EMPLEADO SE DIÓ DE BAJA EN ESTA FECHA.";
/*  539 */           this.con.inserSinMsj("update empleados set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where clave_emp = " + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)));
/*  540 */           consultar();
/*  541 */           JOptionPane.showMessageDialog(this.padre, "Se ha eliminado el empleado satisfactoriamente con clave " + val, "Empleado Eliminado", 0, this.INFO);
/*  542 */         } else if (res == 1) {
/*  543 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/*  544 */           String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,nss,rfc,ingreso", "empleados", "where clave_emp = " + val, 14);
/*  545 */           this.encontrado = this.con.consultar("num_emp", "vales_diesel", "where num_emp = " + val);
/*  546 */           boolean comp = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp = " + val);
/*  547 */           if (this.encontrado || comp) {
/*  548 */             JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el empleado ya que tiene otros datos en su historial\nSi eliminas esta información también desaparecerá su historial completo.", "OTROS DATOS ENLAZADOS", 0, this.ERROR);
/*      */           } else {
/*  550 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + val + " definitivamente.','Clave Operador: " + val + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nNSS: " + reg[11] + "\nRFC: " + reg[12] + "\nFecha de Ingreso: " + reg[13] + "')");
/*  551 */             this.con.eliminar2("empleados", "where clave_emp = " + val);
/*  552 */             this.mensajeTry.guardarConf("Se ha eliminado un empleado-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Empleado Eliminado", "ERROR", "Empleados");
/*  553 */             consultar();
/*  554 */             JOptionPane.showMessageDialog(this.padre, "Se ha eliminado definitivamente el empleado con clave " + val, "Empleado Eliminado", 0, this.INFO);
/*      */           } 
/*      */         } 
/*      */       } else {
/*  558 */         valor = "<html><b>Número de Empleado: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 3)) + "<br></html>";
/*  559 */         int res = JOptionPane.showConfirmDialog(this.padre, "Se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar los datos definitivamente?", "Eliminar Empleados", 0, 3, this.ELIMINAR);
/*  560 */         if (res == 0) {
/*  561 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/*  562 */           String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,nss,rfc,ingreso", "empleados", "where clave_emp = " + val, 14);
/*  563 */           boolean comp = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp = " + val);
/*  564 */           if (this.encontrado || comp) {
/*  565 */             JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el empleado ya que tiene otros datos en su historial\nSi eliminas esta información también desaparecerá su historial completo.", "OTROS DATOS", 0, this.ERROR);
/*      */           } else {
/*  567 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + val + " definitivamente.','Clave Operador: " + val + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nNSS: " + reg[11] + "\nRFC: " + reg[12] + "\nFecha de Ingreso: " + reg[13] + "')");
/*  568 */             this.con.eliminar2("empleados", "where clave_emp =" + val);
/*  569 */             consultar();
/*  570 */             JOptionPane.showMessageDialog(this.padre, "Se ha eliminado definitivamente el empleado con clave " + val, "Empleado Eliminado", 0, this.INFO);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       } 
/*  576 */     } else if (this.jComboBox3.getSelectedIndex() == 0) {
/*  577 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos y poder consultar los datos posteriormente?", "Eliminar Empleados", 1, 2, this.ELIMINAR);
/*  578 */       if (res == 0) {
/*  579 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  580 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  581 */           if (val.equals("true")) {
/*  582 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  583 */             this.contador++;
/*  584 */             this.con.inserSinMsj("update empleados set actual = 1 where clave_emp = " + valor);
/*  585 */             this.con.inserSinMsj("update tarjeta_deudor set estatus='<BAJA>' where num_ope=0 and clave_emp=" + valor);
/*  586 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + valor + "','Clave Empleado: " + valor + "\nSe almacenó para consultas posteriores')");
/*      */             
/*  588 */             this.con.consultar("comentarios", "empleados", "where clave_emp = " + valor);
/*  589 */             String var = this.con.Campo;
/*  590 */             String nuevo = "EL EMPLEADO SE DIÓ DE BAJA EN ESTA FECHA.";
/*  591 */             this.con.inserSinMsj("update empleados set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where clave_emp = " + valor);
/*      */           } 
/*      */         } 
/*  594 */         consultar();
/*  595 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + this.contador + " empleados.", "Operador Empleados", 0, this.INFO);
/*  596 */       } else if (res == 1) {
/*  597 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  598 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  599 */           if (val.equals("true")) {
/*  600 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  601 */             this.encontrado = this.con.consultar("num_emp", "vales_diesel", "where num_emp = " + valor);
/*  602 */             boolean comp = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp = " + valor);
/*  603 */             if (this.encontrado || comp) {
/*  604 */               JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el empleado ya que tiene datos en su historial\nSi eliminas esta información también desaparecerá su historial de datos.", "OTROS DATOS", 0, this.ERROR);
/*      */             } else {
/*  606 */               String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,nss,rfc,ingreso", "empleados", "where clave_emp = " + valor, 14);
/*  607 */               this.contador++;
/*  608 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + val + " definitivamente.','Clave Operador: " + val + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nNSS: " + reg[11] + "\nRFC: " + reg[12] + "\nFecha de Ingreso: " + reg[13] + "')");
/*  609 */               this.con.eliminar2("empleados", "where clave_emp = " + valor);
/*      */             } 
/*      */           } 
/*      */         } 
/*  613 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado definitivamente " + this.contador + " operadores.", "Operador Eliminados", 0, this.INFO);
/*  614 */         consultar();
/*      */       } 
/*      */     } else {
/*  617 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Empleados", 0, 3, this.ELIMINAR);
/*  618 */       if (res == 0) {
/*  619 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  620 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  621 */           if (val.equals("true")) {
/*  622 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  623 */             this.encontrado = this.con.consultar("num_emp", "vales_diesel", "where num_emp = " + valor);
/*  624 */             boolean comp = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp = " + valor);
/*  625 */             if (this.encontrado || comp) {
/*  626 */               JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el operador ya que tiene viajes en su historial\nSi eliminas esta información también desaparecerá su historial de viajes.", "VIAJES ASIGNADOS", 0, this.ERROR);
/*      */             } else {
/*  628 */               String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,nss,rfc,ingreso", "empleados", "where clave_emp = " + valor, 14);
/*  629 */               this.contador++;
/*  630 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Empleado " + val + " definitivamente.','Clave Operador: " + val + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nNSS: " + reg[11] + "\nRFC: " + reg[12] + "\nFecha de Ingreso: " + reg[13] + "')");
/*  631 */               this.con.eliminar2("empleados", "where clave_emp = " + valor);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*  636 */       JOptionPane.showMessageDialog(this.padre, "Se han eliminado definitivamente " + this.contador + " empleados.", "Empleados Eliminados", 0, this.INFO);
/*  637 */       consultar();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {
/*  647 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  648 */     String nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 0));
/*  649 */     String ap = String.valueOf(this.rSTableMetro1.getValueAt(ind, 1));
/*  650 */     this.materialButton1.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void materialButton2ActionPerformed(ActionEvent evt) {
/*  654 */     cambiar();
/*      */   }
/*      */   public void cambiar() {
/*  657 */     String ind = "";
/*  658 */     int contar = 0;
/*  659 */     this.contador = 0;
/*  660 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  661 */       String val = String.valueOf(this.rSTableMetro1.getValueAt(i, 0));
/*  662 */       if (val.equals("true")) {
/*  663 */         contar++;
/*      */       }
/*      */     } 
/*  666 */     if (contar == 0) {
/*  667 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una casilla para volver a activar algún empleado", "Selecciona un Empleado", 0, this.INFO);
/*  668 */     } else if (contar == 1) {
/*  669 */       int doc = 0;
/*  670 */       for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  671 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  672 */         if (val.equals("true")) {
/*  673 */           String str = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  674 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/*  678 */       String valor = "<html><b>Número de Empleado: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 3)) + "<br></html>";
/*  679 */       int res = JOptionPane.showConfirmDialog(this.padre, "Se activará el siguiente empleado:\n" + valor + "\n¿Estás seguro que deseas volver a activar el empleado?", "Activar Empleados", 0, 3, this.PREG);
/*      */       
/*  681 */       if (res == 0) {
/*  682 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/*  683 */         this.con.inserSinMsj("update empleados set actual = 0 where clave_emp = " + val);
/*  684 */         this.con.inserSinMsj("update tarjeta_deudor set estatus = '<CONGELADA>' where clave_emp = " + val);
/*  685 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Activo el Empleado " + val + "','Clave Empleado: " + val + "\nSe activó el Empleado')");
/*      */         
/*  687 */         this.con.consultar("comentarios", "empleados", "where clave_emp = " + val);
/*  688 */         String var = this.con.Campo;
/*  689 */         String nuevo = "EL EMPLEADO SE ACTIVÓ EN ESTA FECHA";
/*  690 */         this.con.inserSinMsj("update empleados set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where clave_emp = " + val);
/*      */         
/*  692 */         consultar();
/*  693 */         JOptionPane.showMessageDialog(this.padre, "Se ha activado satisfactoriamente el empleado con clave " + val, "Empleado Activado", 0, this.INFO);
/*      */       } 
/*      */     } else {
/*  696 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas activar estos " + contar + " elementos para poder actualizar información?", "Activar Empleados", 0, 3, this.PREG);
/*  697 */       if (res == 0) {
/*  698 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  699 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/*  700 */           if (val.equals("true")) {
/*  701 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/*  702 */             this.contador++;
/*  703 */             this.con.inserSinMsj("update empleados set actual = 0 where clave_emp = " + valor);
/*  704 */             this.con.inserSinMsj("update tarjeta_deudor set estatus = '<CONGELADA>' where clave_emp = " + valor);
/*  705 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Activo el Empleado " + val + "','Clave Empleado: " + val + "\nSe activó el Empleado')");
/*      */             
/*  707 */             this.con.consultar("comentarios", "empleados", "where clave_emp = " + valor);
/*  708 */             String var = this.con.Campo;
/*  709 */             String nuevo = "EL EMPLEADOS SE ACTIVÓ EN ESTA FECHA.";
/*  710 */             this.con.inserSinMsj("update empleados set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where clave_emp = " + valor);
/*      */           } 
/*      */         } 
/*  713 */         consultar();
/*  714 */         JOptionPane.showMessageDialog(this.padre, "Se han activado satisfactoriamente " + this.contador + " empleados.", "Empleados Activados", 0, this.INFO);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/*  720 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  722 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  726 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jTextField1, evt);
/*      */           }
/*      */         });
/*  729 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  731 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  735 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jTextField2, evt);
/*      */           }
/*      */         });
/*  738 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  740 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  744 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jTextField3, evt);
/*      */           }
/*      */         });
/*  747 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  749 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  753 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jTextField4, evt);
/*      */           }
/*      */         });
/*  756 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  758 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  762 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*  765 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  767 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  771 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jComboBox3, evt);
/*      */           }
/*      */         });
/*  774 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  776 */             EmpleadosEliminar.this.jTextGanado(EmpleadosEliminar.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  780 */             EmpleadosEliminar.this.jTextPerdido(EmpleadosEliminar.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  786 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  790 */     campo.setBackground(Color.white);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCombo() {
/*  795 */     String[] depa = this.con.regresaColIndex("nombre", "departamentos", " order by nombre");
/*  796 */     this.jComboBox1.removeAllItems();
/*  797 */     this.jComboBox1.addItem("DEPARTAMENTO");
/*  798 */     for (int i = 0; i < depa.length; i++) {
/*  799 */       this.jComboBox1.addItem(depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultar() {
/*  804 */     this.jCheckBox1.setSelected(false);
/*  805 */     String clave = "";
/*  806 */     String nombre = "";
/*  807 */     String paterno = "";
/*  808 */     String materno = "";
/*      */     
/*  810 */     if (!this.jTextField4.getText().equals(this.holderClave)) {
/*  811 */       clave = this.jTextField4.getText();
/*      */     }
/*      */     
/*  814 */     if (!this.jTextField1.getText().equals(this.holderNombre)) {
/*  815 */       nombre = this.jTextField1.getText();
/*      */     }
/*      */     
/*  818 */     if (!this.jTextField2.getText().equals(this.holderPaterno)) {
/*  819 */       paterno = this.jTextField2.getText();
/*      */     }
/*      */     
/*  822 */     if (!this.jTextField3.getText().equals(this.holderMaterno)) {
/*  823 */       materno = this.jTextField3.getText();
/*      */     }
/*      */     
/*  826 */     String tipo = "";
/*  827 */     String clave_depa = "";
/*  828 */     String actual = "0";
/*  829 */     this.materialButton2.setEnabled(false);
/*  830 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/*  831 */       actual = "1";
/*  832 */       this.materialButton2.setEnabled(true);
/*  833 */     } else if (this.jComboBox3.getSelectedIndex() == 2) {
/*  834 */       this.materialButton2.setEnabled(false);
/*  835 */       actual = "";
/*      */     } 
/*  837 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  838 */       tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/*  839 */       this.con.consultar("clave_depa", "departamentos", "where nombre = '" + tipo + "'");
/*  840 */       clave_depa = this.con.Campo;
/*      */     } 
/*  842 */     String tipoEmp = "";
/*  843 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/*  844 */       tipoEmp = "EMPLEADO";
/*  845 */     } else if (this.jComboBox4.getSelectedIndex() == 1) {
/*  846 */       tipoEmp = "FUNCIONARIO";
/*      */     } else {
/*  848 */       tipoEmp = "";
/*      */     } 
/*  850 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/*  851 */           .buscarDatos(22, "clave_emp,ap_pat,ap_mat,empleados.nombre,calle,num,col,cp,ciudad,estado,tel_casa,celular,correo,fecha_nac,nss,rfc,sexo,departamentos.nombre,ingreso,numinfo,infonavitLetra,tipoEmp", "empleados,estados,departamentos", "where clave_emp like '%" + clave + "%' and empleados.nombre like '%" + nombre + "%' and ap_pat like '%" + paterno + "%' and ap_mat like '%" + materno + "%' and empleados.id_edo = estados.id_edo and empleados.clave_depa = departamentos.clave_depa and departamentos.clave_depa like '%" + clave_depa + "%' and actual like '%" + actual + "%' and tipoEmp like '%" + tipoEmp + "%' order by ap_pat"), (Object[])new String[] { "Clave", "Nombre Completo", "Apellido Materno", "Nombre", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Correo", "Fecha de Nac.", "NSS", "RFC", "Sexo", "Departamentos", "F. Ingreso", "Infonavit", "Infonavit $", "Tipo", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*  856 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, true };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  861 */             return this.canEdit[columnIndex];
/*      */           }
/*  863 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/*  868 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/*  871 */     this.jLabel49.setText("" + this.rSTableMetro1.getRowCount());
/*  872 */     this.rSTableMetro1.setShowVerticalLines(false);
/*  873 */     eliminarColumna(2, 1, "Apellido Materno");
/*  874 */     eliminarColumna(2, 1, "Nombre");
/*  875 */     eliminarColumna(3, 2, "Número");
/*  876 */     eliminarColumna(3, 2, "Colonia");
/*  877 */     eliminarColumna(3, 2, "CP");
/*  878 */     eliminarColumna(3, 2, "Ciudad");
/*  879 */     eliminarColumna(3, 2, "Estado");
/*      */     
/*  881 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  882 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/*  883 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(270);
/*  884 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(270);
/*  885 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(85);
/*  886 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(85);
/*  887 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(85);
/*  888 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(85);
/*  889 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(120);
/*  890 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(120);
/*  891 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(85);
/*  892 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(85);
/*  893 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(70);
/*  894 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(70);
/*  895 */     this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(65);
/*  896 */     this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(65);
/*  897 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(65);
/*  898 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(65);
/*  899 */     this.rSTableMetro1.getColumnModel().getColumn(10).setPreferredWidth(120);
/*  900 */     this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(120);
/*      */     
/*  902 */     this.rSTableMetro1.getColumnModel().getColumn(11).setPreferredWidth(90);
/*  903 */     this.rSTableMetro1.getColumnModel().getColumn(11).setMaxWidth(90);
/*      */     
/*  905 */     this.rSTableMetro1.getColumnModel().getColumn(12).setPreferredWidth(80);
/*  906 */     this.rSTableMetro1.getColumnModel().getColumn(12).setMaxWidth(80);
/*  907 */     this.rSTableMetro1.getColumnModel().getColumn(13).setPreferredWidth(80);
/*  908 */     this.rSTableMetro1.getColumnModel().getColumn(13).setMaxWidth(80);
/*      */     
/*  910 */     this.rSTableMetro1.getColumnModel().getColumn(14).setPreferredWidth(80);
/*  911 */     this.rSTableMetro1.getColumnModel().getColumn(14).setMaxWidth(80);
/*      */     
/*  913 */     this.rSTableMetro1.getColumnModel().getColumn(15).setMinWidth(30);
/*  914 */     this.rSTableMetro1.getColumnModel().getColumn(15).setPreferredWidth(30);
/*      */     
/*  916 */     this.rSTableMetro1.getColumnModel().getColumn(15).setMaxWidth(30);
/*  917 */     this.rSTableMetro1.getColumnModel().moveColumn(15, 0);
/*  918 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  919 */     this.rSTableMetro1.setSelectionMode(0);
/*  920 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/*      */     
/*  922 */     if (this.jComboBox3.getSelectedIndex() == 2) {
/*      */       
/*  924 */       String[] arre = this.con.regresaColIndex("clave_emp", "empleados", "where actual =1");
/*  925 */       this.celda.pasarInd(arre);
/*      */     } else {
/*  927 */       String[] arre = new String[0];
/*  928 */       this.celda.pasarInd(arre);
/*      */     } 
/*      */     
/*  931 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*  932 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*  933 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*  934 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*  935 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*  936 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*  937 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*  938 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/*  939 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/*  940 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/*  941 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/*  942 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/*  943 */     this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/*  944 */     this.rSTableMetro1.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/*  945 */     this.rSTableMetro1.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/*  946 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/*  950 */     int cont = this.rSTableMetro1.getRowCount();
/*  951 */     String[] registros = new String[cont]; int i;
/*  952 */     for (i = 0; i < cont; i++) {
/*  953 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/*  955 */     for (i = 0; i < cont; i++) {
/*  956 */       registros[i] = registros[i] + " " + registros[i];
/*  957 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/*  959 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/*  960 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void empleados(String usu) {
/*  964 */     this.USUARIO = usu;
/*  965 */     this.panel.setViewportView(this);
/*  966 */     consultar();
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/*  971 */     int otro = -1;
/*  972 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/*  975 */       setEnabled((table == null || table.isEnabled()));
/*  976 */       String valor = String.valueOf(value);
/*  977 */       String comp = String.valueOf(table.getValueAt(row, 1));
/*  978 */       if (comparar(comp)) {
/*  979 */         setBackground(Color.red);
/*  980 */         setForeground(Color.white);
/*  981 */       } else if (row % 2 == 0 && (column == 4 || column == 5)) {
/*  982 */         setBackground(new Color(120, 200, 104));
/*  983 */         setForeground(Color.black);
/*  984 */       } else if (row % 2 == 0 && (column == 8 || column == 9)) {
/*  985 */         setBackground(new Color(136, 191, 173));
/*  986 */         setForeground(Color.black);
/*  987 */       } else if (row % 2 == 0) {
/*  988 */         setForeground(EmpleadosEliminar.this.lc.SECUNDARIO1);
/*  989 */         setBackground(EmpleadosEliminar.this.lc.FONDOTABLA);
/*      */       } else {
/*  991 */         setForeground(EmpleadosEliminar.this.lc.SECUNDARIO1);
/*  992 */         setBackground((Color)null);
/*      */       } 
/*  994 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/*  995 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/*  999 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 1003 */       for (int i = 0; i < this.indices.length; i++) {
/* 1004 */         if (this.indices[i].equals(reg)) {
/* 1005 */           return true;
/*      */         }
/*      */       } 
/* 1008 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 1013 */     Date fecha = new Date();
/* 1014 */     Calendar ahoraCal = Calendar.getInstance();
/* 1015 */     ahoraCal.setTime(fecha);
/* 1016 */     String mesesito = "";
/* 1017 */     String hoy = "";
/* 1018 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1019 */     hoy = "" + ahoraCal.get(5);
/* 1020 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1021 */       mesesito = "0" + mesesito;
/*      */     }
/* 1023 */     if (ahoraCal.get(5) < 10) {
/* 1024 */       hoy = "0" + hoy;
/*      */     }
/* 1026 */     return "(" + hoy + "/" + mesesito + "/" + ahoraCal.get(1) + "): ";
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/EmpleadosEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */