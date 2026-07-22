/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ public class GeneradoraAlta extends JPanel {
/*   23 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   24 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   25 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   26 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   27 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   31 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   32 */   Date fechaActual = new Date();
/*   33 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   34 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   36 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   37 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   40 */   Consultas con = new Consultas();
/*      */   String[] inf;
/*   42 */   cargarDatos datos = new cargarDatos("GeneradoraAlta");
/*      */   
/*      */   Color fondo;
/*      */   
/*      */   JTable jTable3;
/*      */   boolean encontrado = false;
/*   48 */   int INDICE = 0;
/*   49 */   Errores error = new Errores(false);
/*   50 */   Validaciones val = new Validaciones();
/*   51 */   Date fecha = null;
/*   52 */   CeldaRender3 celda3 = new CeldaRender3(); private JButton jButton1; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton55; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JDialog jDialog1; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20;
/*      */   
/*      */   public GeneradoraAlta(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   55 */     this.USUARIO = usua;
/*   56 */     this.padre = padre;
/*   57 */     this.fichas = fichas;
/*   58 */     this.id = num;
/*   59 */     this.jTable3 = Tabla;
/*      */     try {
/*   61 */       this.formaTel = new MaskFormatter("###-###-####");
/*   62 */     } catch (Exception exception) {}
/*      */     
/*   64 */     this.formaTel.setPlaceholderCharacter('_');
/*   65 */     initComponents();
/*   66 */     panelito.setViewportView(this);
/*   67 */     this.panel = panelito;
/*   68 */     colorear();
/*   69 */     this.jLabel14.setVisible(false);
/*   70 */     crearInd();
/*   71 */     this.jButton4.setVisible(false);
/*   72 */     this.jButton3.setVisible(false);
/*   73 */     if (fichas != null) {
/*   74 */       this.jTextField1.setText(num);
/*   75 */       fichas.addTab("Modificar Empresa Origen - [Clave: " + this.id + "]", this.panel);
/*   76 */       this.jButton1.setText("Modificar");
/*   77 */       this.jLabel1.setText("Modificar Empresa Origen");
/*   78 */       this.jButton3.setVisible(true);
/*   79 */       this.jButton4.setVisible(true);
/*   80 */       cargarFormulario();
/*      */     } 
/*      */     
/*   83 */     int w = this.tama.width;
/*   84 */     int h = this.tama.height;
/*   85 */     int rw = (w - 870) / 2;
/*   86 */     int rh = (h - 10) / 2;
/*   87 */     rw = (w - 650) / 2;
/*   88 */     rh = (h - 250) / 2;
/*   89 */     this.jDialog1.setLocation(rw, rh);
/*   90 */     this.jDialog1.setSize(650, 250);
/*   91 */     this.jDialog1.setResizable(false);
/*   92 */     llenarCatPaises();
/*      */   }
/*      */   private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel3; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel133; private JPanel jPanel134; private JPanel jPanel4; private JScrollPane jScrollPane17; private JTable jTable11; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8;
/*      */   private JTextField jTextField85;
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*   99 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  100 */     this.jPanel134 = new JPanel();
/*  101 */     this.jScrollPane17 = new JScrollPane();
/*  102 */     this.jTable11 = new JTable();
/*  103 */     this.jPanel4 = new JPanel();
/*  104 */     this.jLabel1 = new JLabel();
/*  105 */     this.jButton1 = new JButton();
/*  106 */     this.jButton2 = new JButton();
/*  107 */     this.jLabel14 = new JLabel();
/*  108 */     this.jButton3 = new JButton();
/*  109 */     this.jButton4 = new JButton();
/*  110 */     this.jPanel1 = new JPanel();
/*  111 */     this.jLabel13 = new JLabel();
/*  112 */     this.jTextField1 = new JTextField();
/*  113 */     this.jLabel2 = new JLabel();
/*  114 */     this.jTextField9 = new JTextField();
/*  115 */     this.jLabel3 = new JLabel();
/*  116 */     this.jTextField10 = new JTextField();
/*  117 */     this.jLabel12 = new JLabel();
/*  118 */     this.jTextField2 = new JTextField();
/*  119 */     this.jLabel16 = new JLabel();
/*  120 */     this.jTextField11 = new JTextField();
/*  121 */     this.jLabel11 = new JLabel();
/*  122 */     this.jTextField3 = new JTextField();
/*  123 */     this.jLabel9 = new JLabel();
/*  124 */     this.jTextField4 = new JTextField();
/*  125 */     this.jLabel10 = new JLabel();
/*  126 */     this.jTextField5 = new JTextField();
/*  127 */     this.jLabel15 = new JLabel();
/*  128 */     this.jTextField6 = new JTextField();
/*  129 */     this.jLabel17 = new JLabel();
/*  130 */     this.jTextField7 = new JTextField();
/*  131 */     this.jLabel18 = new JLabel();
/*  132 */     this.jComboBox1 = new JComboBox();
/*  133 */     this.jLabel20 = new JLabel();
/*  134 */     this.jTextField12 = new JTextField();
/*  135 */     this.jLabel22 = new JLabel();
/*  136 */     this.jPanel133 = new JPanel();
/*  137 */     this.jTextField85 = new JTextField();
/*  138 */     this.jButton55 = new JButton();
/*  139 */     this.jLabel21 = new JLabel();
/*  140 */     this.jTextField8 = new JTextField();
/*  141 */     this.jLabel19 = new JLabel();
/*  142 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  143 */     this.jCheckBox1 = new JCheckBox();
/*      */     
/*  145 */     this.jDialog1.setTitle("Catálogo de Paises");
/*      */     
/*  147 */     this.jTable11.setFont(new Font("Dialog", 0, 11));
/*  148 */     this.jTable11.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "País", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  156 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  161 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  164 */     this.jTable11.setShowVerticalLines(false);
/*  165 */     this.jTable11.getTableHeader().setReorderingAllowed(false);
/*  166 */     this.jTable11.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  168 */             GeneradoraAlta.this.jTable11MouseClicked(evt);
/*      */           }
/*      */         });
/*  171 */     this.jScrollPane17.setViewportView(this.jTable11);
/*      */     
/*  173 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/*  174 */     this.jPanel134.setLayout(jPanel134Layout);
/*  175 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/*  176 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  177 */         .addComponent(this.jScrollPane17, -1, 543, 32767));
/*      */     
/*  179 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/*  180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  181 */         .addComponent(this.jScrollPane17, GroupLayout.Alignment.TRAILING, -1, 223, 32767));
/*      */ 
/*      */     
/*  184 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  185 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  186 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  187 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  188 */         .addGap(0, 543, 32767)
/*  189 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  190 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */     
/*  192 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  193 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  194 */         .addGap(0, 223, 32767)
/*  195 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  196 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */ 
/*      */     
/*  199 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*  200 */     this.jPanel4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/*  202 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/*  203 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/*  204 */     this.jLabel1.setHorizontalAlignment(0);
/*  205 */     this.jLabel1.setText("     Agregar Empresas Origen");
/*      */     
/*  207 */     this.jButton1.setMnemonic('G');
/*  208 */     this.jButton1.setText("Guardar");
/*  209 */     this.jButton1.setToolTipText("Guardar (Alt+G)");
/*  210 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  212 */             GeneradoraAlta.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  216 */     this.jButton2.setMnemonic('L');
/*  217 */     this.jButton2.setText("Limpiar");
/*  218 */     this.jButton2.setToolTipText("Limpiar (Alt+L)");
/*  219 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  221 */             GeneradoraAlta.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  225 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  226 */     this.jLabel14.setToolTipText("Cerrar");
/*  227 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  229 */             GeneradoraAlta.this.jLabel14MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  232 */             GeneradoraAlta.this.jLabel14MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  235 */             GeneradoraAlta.this.jLabel14MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  239 */     this.jButton3.setMnemonic('R');
/*  240 */     this.jButton3.setText("Restablecer");
/*  241 */     this.jButton3.setToolTipText("Restablecer ( Alt+R )");
/*  242 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  244 */             GeneradoraAlta.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  248 */     this.jButton4.setMnemonic('C');
/*  249 */     this.jButton4.setText("Cerrar");
/*  250 */     this.jButton4.setToolTipText("Cerrar (Alt+C)");
/*  251 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  253 */             GeneradoraAlta.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  257 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  258 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Información necesaria de la empresa", 0, 0, new Font("Dialog", 1, 11)));
/*  259 */     GridBagLayout jPanel1Layout = new GridBagLayout();
/*  260 */     jPanel1Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/*  261 */     jPanel1Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  262 */     this.jPanel1.setLayout(jPanel1Layout);
/*      */     
/*  264 */     this.jLabel13.setFont(new Font("Tahoma", 3, 11));
/*  265 */     this.jLabel13.setForeground(new Color(15, 87, 51));
/*  266 */     this.jLabel13.setHorizontalAlignment(4);
/*  267 */     this.jLabel13.setText("Clave");
/*  268 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  269 */     gridBagConstraints.gridx = 0;
/*  270 */     gridBagConstraints.gridy = 0;
/*  271 */     gridBagConstraints.fill = 2;
/*  272 */     gridBagConstraints.ipadx = 2;
/*  273 */     this.jPanel1.add(this.jLabel13, gridBagConstraints);
/*      */     
/*  275 */     this.jTextField1.setEditable(false);
/*  276 */     this.jTextField1.setText(" ");
/*  277 */     gridBagConstraints = new GridBagConstraints();
/*  278 */     gridBagConstraints.gridx = 2;
/*  279 */     gridBagConstraints.gridy = 0;
/*  280 */     gridBagConstraints.fill = 2;
/*  281 */     this.jPanel1.add(this.jTextField1, gridBagConstraints);
/*      */     
/*  283 */     this.jLabel2.setFont(new Font("Tahoma", 3, 11));
/*  284 */     this.jLabel2.setForeground(new Color(15, 87, 51));
/*  285 */     this.jLabel2.setHorizontalAlignment(4);
/*  286 */     this.jLabel2.setText("Nombre corto");
/*  287 */     gridBagConstraints = new GridBagConstraints();
/*  288 */     gridBagConstraints.gridx = 0;
/*  289 */     gridBagConstraints.gridy = 2;
/*  290 */     gridBagConstraints.fill = 2;
/*  291 */     gridBagConstraints.ipadx = 2;
/*  292 */     this.jPanel1.add(this.jLabel2, gridBagConstraints);
/*  293 */     gridBagConstraints = new GridBagConstraints();
/*  294 */     gridBagConstraints.gridx = 2;
/*  295 */     gridBagConstraints.gridy = 2;
/*  296 */     gridBagConstraints.fill = 2;
/*  297 */     this.jPanel1.add(this.jTextField9, gridBagConstraints);
/*      */     
/*  299 */     this.jLabel3.setFont(new Font("Tahoma", 3, 11));
/*  300 */     this.jLabel3.setForeground(new Color(15, 87, 51));
/*  301 */     this.jLabel3.setHorizontalAlignment(4);
/*  302 */     this.jLabel3.setText("Iniciales");
/*  303 */     gridBagConstraints = new GridBagConstraints();
/*  304 */     gridBagConstraints.gridx = 4;
/*  305 */     gridBagConstraints.gridy = 0;
/*  306 */     gridBagConstraints.fill = 2;
/*  307 */     gridBagConstraints.ipadx = 40;
/*  308 */     this.jPanel1.add(this.jLabel3, gridBagConstraints);
/*      */     
/*  310 */     this.jTextField10.setToolTipText("Mínimo tres letras y máximo 8");
/*  311 */     gridBagConstraints = new GridBagConstraints();
/*  312 */     gridBagConstraints.gridx = 6;
/*  313 */     gridBagConstraints.gridy = 0;
/*  314 */     gridBagConstraints.fill = 2;
/*  315 */     this.jPanel1.add(this.jTextField10, gridBagConstraints);
/*      */     
/*  317 */     this.jLabel12.setFont(new Font("Tahoma", 3, 11));
/*  318 */     this.jLabel12.setForeground(new Color(15, 87, 51));
/*  319 */     this.jLabel12.setHorizontalAlignment(4);
/*  320 */     this.jLabel12.setText("Cliente o Razón social");
/*  321 */     gridBagConstraints = new GridBagConstraints();
/*  322 */     gridBagConstraints.gridx = 0;
/*  323 */     gridBagConstraints.gridy = 4;
/*  324 */     gridBagConstraints.fill = 2;
/*  325 */     gridBagConstraints.ipadx = 2;
/*  326 */     this.jPanel1.add(this.jLabel12, gridBagConstraints);
/*      */     
/*  328 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  330 */             GeneradoraAlta.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*  333 */     gridBagConstraints = new GridBagConstraints();
/*  334 */     gridBagConstraints.gridx = 2;
/*  335 */     gridBagConstraints.gridy = 4;
/*  336 */     gridBagConstraints.fill = 2;
/*  337 */     this.jPanel1.add(this.jTextField2, gridBagConstraints);
/*      */     
/*  339 */     this.jLabel16.setFont(new Font("Tahoma", 2, 11));
/*  340 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/*  341 */     this.jLabel16.setHorizontalAlignment(4);
/*  342 */     this.jLabel16.setText("Origen");
/*  343 */     gridBagConstraints = new GridBagConstraints();
/*  344 */     gridBagConstraints.gridx = 4;
/*  345 */     gridBagConstraints.gridy = 4;
/*  346 */     gridBagConstraints.fill = 2;
/*  347 */     gridBagConstraints.ipadx = 40;
/*  348 */     this.jPanel1.add(this.jLabel16, gridBagConstraints);
/*      */     
/*  350 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  352 */             GeneradoraAlta.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*  355 */     gridBagConstraints = new GridBagConstraints();
/*  356 */     gridBagConstraints.gridx = 6;
/*  357 */     gridBagConstraints.gridy = 4;
/*  358 */     gridBagConstraints.fill = 2;
/*  359 */     this.jPanel1.add(this.jTextField11, gridBagConstraints);
/*      */     
/*  361 */     this.jLabel11.setFont(new Font("Tahoma", 3, 11));
/*  362 */     this.jLabel11.setForeground(new Color(15, 87, 51));
/*  363 */     this.jLabel11.setHorizontalAlignment(4);
/*  364 */     this.jLabel11.setText("Calle");
/*  365 */     gridBagConstraints = new GridBagConstraints();
/*  366 */     gridBagConstraints.gridx = 0;
/*  367 */     gridBagConstraints.gridy = 6;
/*  368 */     gridBagConstraints.fill = 2;
/*  369 */     gridBagConstraints.ipadx = 2;
/*  370 */     this.jPanel1.add(this.jLabel11, gridBagConstraints);
/*      */     
/*  372 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  374 */             GeneradoraAlta.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  377 */     gridBagConstraints = new GridBagConstraints();
/*  378 */     gridBagConstraints.gridx = 2;
/*  379 */     gridBagConstraints.gridy = 6;
/*  380 */     gridBagConstraints.fill = 2;
/*  381 */     this.jPanel1.add(this.jTextField3, gridBagConstraints);
/*      */     
/*  383 */     this.jLabel9.setFont(new Font("Tahoma", 2, 11));
/*  384 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/*  385 */     this.jLabel9.setHorizontalAlignment(4);
/*  386 */     this.jLabel9.setText("Número");
/*  387 */     gridBagConstraints = new GridBagConstraints();
/*  388 */     gridBagConstraints.gridx = 4;
/*  389 */     gridBagConstraints.gridy = 6;
/*  390 */     gridBagConstraints.fill = 2;
/*  391 */     gridBagConstraints.ipadx = 40;
/*  392 */     this.jPanel1.add(this.jLabel9, gridBagConstraints);
/*      */     
/*  394 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  396 */             GeneradoraAlta.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*  399 */     gridBagConstraints = new GridBagConstraints();
/*  400 */     gridBagConstraints.gridx = 6;
/*  401 */     gridBagConstraints.gridy = 6;
/*  402 */     gridBagConstraints.fill = 2;
/*  403 */     this.jPanel1.add(this.jTextField4, gridBagConstraints);
/*      */     
/*  405 */     this.jLabel10.setFont(new Font("Tahoma", 2, 11));
/*  406 */     this.jLabel10.setForeground(new Color(15, 87, 51));
/*  407 */     this.jLabel10.setHorizontalAlignment(4);
/*  408 */     this.jLabel10.setText("Colonia");
/*  409 */     gridBagConstraints = new GridBagConstraints();
/*  410 */     gridBagConstraints.gridx = 0;
/*  411 */     gridBagConstraints.gridy = 8;
/*  412 */     gridBagConstraints.fill = 2;
/*  413 */     gridBagConstraints.ipadx = 2;
/*  414 */     this.jPanel1.add(this.jLabel10, gridBagConstraints);
/*  415 */     gridBagConstraints = new GridBagConstraints();
/*  416 */     gridBagConstraints.gridx = 2;
/*  417 */     gridBagConstraints.gridy = 8;
/*  418 */     gridBagConstraints.fill = 2;
/*  419 */     this.jPanel1.add(this.jTextField5, gridBagConstraints);
/*      */     
/*  421 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/*  422 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/*  423 */     this.jLabel15.setHorizontalAlignment(4);
/*  424 */     this.jLabel15.setText("CP ");
/*  425 */     gridBagConstraints = new GridBagConstraints();
/*  426 */     gridBagConstraints.gridx = 4;
/*  427 */     gridBagConstraints.gridy = 8;
/*  428 */     gridBagConstraints.fill = 2;
/*  429 */     gridBagConstraints.ipadx = 40;
/*  430 */     this.jPanel1.add(this.jLabel15, gridBagConstraints);
/*      */     
/*  432 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  434 */             GeneradoraAlta.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*  437 */     gridBagConstraints = new GridBagConstraints();
/*  438 */     gridBagConstraints.gridx = 6;
/*  439 */     gridBagConstraints.gridy = 8;
/*  440 */     gridBagConstraints.fill = 2;
/*  441 */     this.jPanel1.add(this.jTextField6, gridBagConstraints);
/*      */     
/*  443 */     this.jLabel17.setFont(new Font("Tahoma", 3, 11));
/*  444 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/*  445 */     this.jLabel17.setHorizontalAlignment(4);
/*  446 */     this.jLabel17.setText("Ciudad ");
/*  447 */     gridBagConstraints = new GridBagConstraints();
/*  448 */     gridBagConstraints.gridx = 0;
/*  449 */     gridBagConstraints.gridy = 10;
/*  450 */     gridBagConstraints.fill = 2;
/*  451 */     gridBagConstraints.ipadx = 2;
/*  452 */     this.jPanel1.add(this.jLabel17, gridBagConstraints);
/*      */     
/*  454 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  456 */             GeneradoraAlta.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*  459 */     gridBagConstraints = new GridBagConstraints();
/*  460 */     gridBagConstraints.gridx = 2;
/*  461 */     gridBagConstraints.gridy = 10;
/*  462 */     gridBagConstraints.fill = 2;
/*  463 */     this.jPanel1.add(this.jTextField7, gridBagConstraints);
/*      */     
/*  465 */     this.jLabel18.setFont(new Font("Tahoma", 3, 11));
/*  466 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/*  467 */     this.jLabel18.setHorizontalAlignment(4);
/*  468 */     this.jLabel18.setText("Estado");
/*  469 */     gridBagConstraints = new GridBagConstraints();
/*  470 */     gridBagConstraints.gridx = 4;
/*  471 */     gridBagConstraints.gridy = 10;
/*  472 */     gridBagConstraints.fill = 2;
/*  473 */     gridBagConstraints.ipadx = 40;
/*  474 */     this.jPanel1.add(this.jLabel18, gridBagConstraints);
/*      */     
/*  476 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  477 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS", "CIUDAD DE MEXICO", "TEXAS", "FLORIDA" }));
/*  478 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  480 */             GeneradoraAlta.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  483 */     gridBagConstraints = new GridBagConstraints();
/*  484 */     gridBagConstraints.gridx = 6;
/*  485 */     gridBagConstraints.gridy = 10;
/*  486 */     gridBagConstraints.fill = 2;
/*  487 */     this.jPanel1.add(this.jComboBox1, gridBagConstraints);
/*      */     
/*  489 */     this.jLabel20.setFont(new Font("Tahoma", 2, 11));
/*  490 */     this.jLabel20.setForeground(new Color(15, 87, 51));
/*  491 */     this.jLabel20.setHorizontalAlignment(4);
/*  492 */     this.jLabel20.setText("País");
/*  493 */     gridBagConstraints = new GridBagConstraints();
/*  494 */     gridBagConstraints.gridx = 4;
/*  495 */     gridBagConstraints.gridy = 12;
/*  496 */     gridBagConstraints.fill = 2;
/*  497 */     gridBagConstraints.ipadx = 40;
/*  498 */     this.jPanel1.add(this.jLabel20, gridBagConstraints);
/*      */     
/*  500 */     this.jTextField12.setEditable(false);
/*  501 */     this.jTextField12.setText("MÉXICO");
/*  502 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  504 */             GeneradoraAlta.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*  507 */     gridBagConstraints = new GridBagConstraints();
/*  508 */     gridBagConstraints.gridx = 6;
/*  509 */     gridBagConstraints.gridy = 12;
/*  510 */     gridBagConstraints.fill = 2;
/*  511 */     this.jPanel1.add(this.jTextField12, gridBagConstraints);
/*      */     
/*  513 */     this.jLabel22.setFont(new Font("Tahoma", 3, 11));
/*  514 */     this.jLabel22.setForeground(new Color(15, 87, 51));
/*  515 */     this.jLabel22.setHorizontalAlignment(4);
/*  516 */     this.jLabel22.setText("Código del país");
/*  517 */     gridBagConstraints = new GridBagConstraints();
/*  518 */     gridBagConstraints.gridx = 0;
/*  519 */     gridBagConstraints.gridy = 12;
/*  520 */     gridBagConstraints.fill = 2;
/*  521 */     gridBagConstraints.ipadx = 2;
/*  522 */     this.jPanel1.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  524 */     this.jTextField85.setEditable(false);
/*  525 */     this.jTextField85.setText("MEX");
/*      */     
/*  527 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  528 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  530 */             GeneradoraAlta.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  534 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  535 */     this.jPanel133.setLayout(jPanel133Layout);
/*  536 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  537 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  538 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  539 */           .addComponent(this.jTextField85, -1, 355, 32767)
/*  540 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  541 */           .addComponent(this.jButton55, -2, 18, -2)));
/*      */     
/*  543 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  544 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  545 */         .addComponent(this.jTextField85)
/*  546 */         .addComponent(this.jButton55, -2, 0, 32767));
/*      */ 
/*      */     
/*  549 */     gridBagConstraints = new GridBagConstraints();
/*  550 */     gridBagConstraints.gridx = 2;
/*  551 */     gridBagConstraints.gridy = 12;
/*  552 */     gridBagConstraints.fill = 2;
/*  553 */     this.jPanel1.add(this.jPanel133, gridBagConstraints);
/*      */     
/*  555 */     this.jLabel21.setFont(new Font("Tahoma", 2, 11));
/*  556 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/*  557 */     this.jLabel21.setHorizontalAlignment(4);
/*  558 */     this.jLabel21.setText("RFC");
/*  559 */     gridBagConstraints = new GridBagConstraints();
/*  560 */     gridBagConstraints.gridx = 0;
/*  561 */     gridBagConstraints.gridy = 14;
/*  562 */     gridBagConstraints.fill = 2;
/*  563 */     gridBagConstraints.ipadx = 2;
/*  564 */     this.jPanel1.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  566 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  568 */             GeneradoraAlta.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*  571 */     gridBagConstraints = new GridBagConstraints();
/*  572 */     gridBagConstraints.gridx = 2;
/*  573 */     gridBagConstraints.gridy = 14;
/*  574 */     gridBagConstraints.fill = 2;
/*  575 */     this.jPanel1.add(this.jTextField8, gridBagConstraints);
/*      */     
/*  577 */     this.jLabel19.setFont(new Font("Tahoma", 2, 11));
/*  578 */     this.jLabel19.setForeground(new Color(15, 87, 51));
/*  579 */     this.jLabel19.setHorizontalAlignment(4);
/*  580 */     this.jLabel19.setText("Teléfono");
/*  581 */     gridBagConstraints = new GridBagConstraints();
/*  582 */     gridBagConstraints.gridx = 4;
/*  583 */     gridBagConstraints.gridy = 14;
/*  584 */     gridBagConstraints.fill = 2;
/*  585 */     gridBagConstraints.ipadx = 40;
/*  586 */     this.jPanel1.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  588 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  590 */             GeneradoraAlta.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  593 */     gridBagConstraints = new GridBagConstraints();
/*  594 */     gridBagConstraints.gridx = 6;
/*  595 */     gridBagConstraints.gridy = 14;
/*  596 */     gridBagConstraints.fill = 2;
/*  597 */     this.jPanel1.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/*  599 */     this.jCheckBox1.setText("Desactivar");
/*  600 */     gridBagConstraints = new GridBagConstraints();
/*  601 */     gridBagConstraints.gridx = 2;
/*  602 */     gridBagConstraints.gridy = 16;
/*  603 */     gridBagConstraints.fill = 2;
/*  604 */     this.jPanel1.add(this.jCheckBox1, gridBagConstraints);
/*      */     
/*  606 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  607 */     this.jPanel4.setLayout(jPanel4Layout);
/*  608 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  609 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  610 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  611 */           .addContainerGap(-1, 32767)
/*  612 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  613 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  614 */               .addComponent(this.jLabel1, -2, 743, -2)
/*  615 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  616 */               .addComponent(this.jLabel14))
/*  617 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  618 */               .addComponent(this.jButton4, -2, 78, -2)
/*  619 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  620 */               .addComponent(this.jButton3, -2, 100, -2)
/*  621 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  622 */               .addComponent(this.jButton1, -2, 78, -2)
/*  623 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  624 */               .addComponent(this.jButton2, -2, 77, -2)))
/*  625 */           .addContainerGap())
/*  626 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  628 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  629 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  630 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  631 */           .addContainerGap()
/*  632 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  633 */             .addComponent(this.jLabel1)
/*  634 */             .addComponent(this.jLabel14))
/*  635 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  636 */           .addComponent(this.jPanel1, -2, 323, -2)
/*  637 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  638 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  639 */             .addComponent(this.jButton1, -1, -1, 32767)
/*  640 */             .addComponent(this.jButton2, -1, -1, 32767)
/*  641 */             .addComponent(this.jButton3, -1, -1, 32767)
/*  642 */             .addComponent(this.jButton4, -1, -1, 32767))
/*  643 */           .addContainerGap()));
/*      */ 
/*      */     
/*  646 */     GroupLayout layout = new GroupLayout(this);
/*  647 */     setLayout(layout);
/*  648 */     layout.setHorizontalGroup(layout
/*  649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  650 */         .addGap(0, 828, 32767)
/*  651 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  652 */           .addGroup(layout.createSequentialGroup()
/*  653 */             .addGap(0, 0, 32767)
/*  654 */             .addComponent(this.jPanel4, -2, -1, -2)
/*  655 */             .addGap(0, 0, 32767))));
/*      */     
/*  657 */     layout.setVerticalGroup(layout
/*  658 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  659 */         .addGap(0, 446, 32767)
/*  660 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  661 */           .addGroup(layout.createSequentialGroup()
/*  662 */             .addGap(0, 0, 32767)
/*  663 */             .addComponent(this.jPanel4, -2, -1, -2)
/*  664 */             .addGap(0, 0, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  669 */     boolean mayor = true;
/*  670 */     long diasC = 0L;
/*  671 */     String clave = this.jTextField1.getText();
/*  672 */     String nom = this.jTextField2.getText();
/*  673 */     String calle = this.jTextField3.getText();
/*  674 */     String num = this.jTextField4.getText();
/*  675 */     String col = this.jTextField5.getText();
/*  676 */     String cod = this.jTextField6.getText();
/*  677 */     String ciudad = this.jTextField7.getText();
/*  678 */     String estado = "";
/*  679 */     String rfc = this.jTextField8.getText();
/*  680 */     String tel1 = this.jFormattedTextField1.getText();
/*  681 */     int id_edo = 0;
/*  682 */     String activo = "";
/*  683 */     if (this.jCheckBox1.isSelected()) {
/*  684 */       activo = "Desactivado";
/*      */     } else {
/*  686 */       activo = "Activado";
/*      */     } 
/*      */     
/*  689 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  690 */       estado = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/*  692 */     if (this.con.consultar("id_edo", "estados", "where estado = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'")) {
/*  693 */       id_edo = Integer.parseInt(this.con.Campo);
/*      */     }
/*  695 */     String[] campos = { "Nombre Corto", "Clave de la empresa", "Nombre", "Calle", "Número", "Colonia", "Código Postal", "Ciudad", "Estado", "RFC", "Teléfono", "Estatus" };
/*  696 */     if (tel1.equals("___-___-____")) {
/*  697 */       tel1 = "";
/*      */     }
/*  699 */     if (clave.equals("")) {
/*  700 */       this.error.cargarError(this.jTextField1, "050");
/*  701 */     } else if (this.jTextField9.getText().equals("")) {
/*  702 */       this.error.cargarError(this.jTextField9, "050");
/*  703 */     } else if (this.jTextField10.getText().equals("")) {
/*  704 */       this.error.cargarError(this.jTextField10, "050");
/*  705 */     } else if (nom.equals("")) {
/*  706 */       this.error.cargarError(this.jTextField2, "050");
/*  707 */     } else if (this.jTextField9.getText().equals("")) {
/*  708 */       this.error.cargarError(this.jTextField9, "050");
/*  709 */     } else if (calle.equals("")) {
/*  710 */       this.error.cargarError(this.jTextField3, "050");
/*  711 */     } else if (ciudad.equals("")) {
/*  712 */       this.error.cargarError(this.jTextField7, "050");
/*  713 */     } else if (this.jComboBox1.getSelectedIndex() == 0) {
/*  714 */       this.error.cargarError(this.jComboBox1, "050");
/*  715 */     } else if (!this.val.validarApostrofe(this.jTextField2, nom, "020") && 
/*  716 */       !this.val.validarApostrofe(this.jTextField9, this.jTextField9.getText(), "020") && 
/*  717 */       !this.val.validarApostrofe(this.jTextField10, this.jTextField10.getText(), "020") && 
/*  718 */       !this.val.validarCalle(this.jTextField3, calle, "014") && 
/*  719 */       !this.val.validarTexto(this.jTextField4, num.toUpperCase(), "020") && 
/*  720 */       !this.val.validarDireccion(this.jTextField5, col, "014") && 
/*  721 */       !this.val.validarTexto(this.jTextField6, cod, "020") && 
/*  722 */       !this.val.validarRegion(this.jTextField7, ciudad, "018")) {
/*  723 */       String[] info = { this.jTextField9.getText(), clave, nom.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), cod, ciudad.toUpperCase(), estado.toUpperCase(), this.jTextField8.getText().toUpperCase(), tel1, activo };
/*  724 */       if (this.jButton1.getText().equals("Modificar")) {
/*  725 */         int res = this.error.cargarDatos2(campos, info);
/*  726 */         if (res == 0) {
/*  727 */           this.con.insertar("update emp_generadora set iniciales ='" + this.jTextField10.getText().toUpperCase() + "' ,nombre_corto = '" + this.jTextField9.getText().toUpperCase() + "', empresa='" + nom.toUpperCase() + "', calle='" + calle.toUpperCase() + "', num='" + num.toUpperCase() + "', col='" + col.toUpperCase() + "', cp='" + cod + "', ciudad='" + ciudad.toUpperCase() + "',rfc='" + this.jTextField8.getText().toUpperCase() + "',telefono='" + tel1 + "',id_edo=" + id_edo + ",activo='" + activo + "',origen='" + this.jTextField11.getText().toUpperCase() + "', pais='" + this.jTextField12.getText().toUpperCase() + "', codigopais='" + this.jTextField85.getText() + "'  where clave_gene=" + this.id);
/*  728 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Modificó la empresa origen No: " + this.id + "','Nombre de la empresa: " + this.inf[1] + "\nDirección: " + this.inf[2] + " " + this.inf[3] + " " + this.inf[4] + " " + this.inf[5] + " " + this.inf[6] + "\nRFC: " + this.inf[7] + "\nTeléfono: " + this.inf[8] + "')");
/*  729 */           limpiar();
/*  730 */           consultar();
/*  731 */           this.fichas.remove(1);
/*      */         } 
/*      */       } else {
/*  734 */         int res = this.error.cargarDatos(campos, info);
/*  735 */         if (res == 0) {
/*  736 */           this.con.insertar("insert into emp_generadora(nombre_Corto,iniciales,empresa,calle,num,col,cp,ciudad,rfc,telefono,activo,id_edo,origen, codigopais, pais)values('" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField10.getText().toUpperCase() + "','" + info[2] + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "','" + cod + "','" + ciudad.toUpperCase() + "','" + rfc.toUpperCase() + "','" + tel1 + "','" + activo + "'," + id_edo + ",'" + this.jTextField11.getText().toUpperCase() + "','" + this.jTextField85.getText() + "','" + this.jTextField12.getText().toUpperCase() + "')");
/*  737 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Creó la empresa origen No: " + clave + "','Nombre de la empresa: " + info[1] + "\nDirección: " + info[2] + " " + info[3] + " " + info[4] + " " + info[5] + " " + info[6] + " " + info[7] + "\nRFC: " + info[8] + "\nTeléfono: " + info[9] + "')");
/*  738 */           limpiar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  752 */     limpiar();
/*      */   }
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/*  755 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  756 */     this.fichas.remove(1);
/*  757 */     this.datos.eliminar();
/*      */   }
/*      */   private void jLabel14MouseEntered(MouseEvent evt) {
/*  760 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel14MouseExited(MouseEvent evt) {
/*  764 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/*  768 */     int cont = 0;
/*  769 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/*  770 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/*  771 */       this.jFormattedTextField1.setValue("");
/*  772 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/*  773 */       String cadena = this.jFormattedTextField1.getText();
/*  774 */       String cad1 = cadena.substring(0, 3);
/*  775 */       String cad2 = cadena.substring(4, 7);
/*  776 */       String cad3 = cadena.substring(8, 12);
/*  777 */       String tel = cad1 + cad1 + cad2;
/*  778 */       for (int i = 1; i < tel.length(); i++) {
/*  779 */         char c = tel.charAt(i - 1);
/*  780 */         char d = tel.charAt(i);
/*  781 */         if (c != d) {
/*  782 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/*  786 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/*  787 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/*  788 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  793 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/*  797 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  798 */     this.fichas.remove(1);
/*  799 */     this.datos.eliminar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  806 */     if (!this.jTextField2.getText().isEmpty()) {
/*  807 */       this.datos.escribir();
/*  808 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  809 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  814 */     if (!this.jTextField3.getText().isEmpty()) {
/*  815 */       this.datos.escribir();
/*  816 */     } else if (this.jTextField2.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  817 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/*  822 */     if (!this.jTextField4.getText().isEmpty()) {
/*  823 */       this.datos.escribir();
/*  824 */     } else if (this.jTextField3.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  825 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/*  830 */     if (!this.jTextField6.getText().isEmpty()) {
/*  831 */       this.datos.escribir();
/*  832 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  833 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/*  838 */     if (!this.jTextField7.getText().isEmpty()) {
/*  839 */       this.datos.escribir();
/*  840 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  841 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/*  846 */     if (!this.jTextField8.getText().isEmpty()) {
/*  847 */       this.datos.escribir();
/*  848 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField2.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  849 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/*  862 */     Dimension di = this.jButton55.getSize();
/*  863 */     Point p = this.jButton55.getLocationOnScreen();
/*  864 */     this.jDialog1.setLocation(p.x + di.width - 200, p.y + 30);
/*  865 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTable11MouseClicked(MouseEvent evt) {
/*  869 */     if (evt.getClickCount() == 2) {
/*  870 */       this.jTextField85.setText(this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 0).toString());
/*  871 */       this.jTextField12.setText(this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 1).toString());
/*  872 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void crearInd() {
/*  884 */     int id = 0;
/*  885 */     this.con.consultar("count(clave_gene)", "emp_generadora", "");
/*  886 */     if (!this.con.Campo.equals("0")) {
/*  887 */       this.con.consultar("max(clave_gene)", "emp_generadora", "");
/*  888 */       id = Integer.parseInt(this.con.Campo);
/*  889 */       id++;
/*  890 */       this.jTextField1.setText("" + id);
/*      */     } else {
/*  892 */       id = 1;
/*      */     } 
/*  894 */     this.jTextField1.setText("" + id);
/*      */   }
/*      */   
/*      */   public void llenarCatPaises() {
/*  898 */     this.jTable11.setModel(new DefaultTableModel((Object[][])this.con
/*  899 */           .buscarDatos(2, "pais,descripcion", "catpaises", "order by descripcion"), (Object[])new String[] { "Pais", "Descripción" })
/*      */         {
/*      */           
/*  902 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  907 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  911 */     this.jTable11.setShowVerticalLines(false);
/*  912 */     this.jScrollPane17.setViewportView(this.jTable11);
/*      */     
/*  914 */     this.jTable11.setSelectionMode(0);
/*  915 */     this.jTable11.setAutoCreateRowSorter(true);
/*  916 */     this.jTable11.getTableHeader().setReorderingAllowed(false);
/*      */     
/*  918 */     this.jTable11.getColumnModel().getColumn(0).setPreferredWidth(90);
/*  919 */     this.jTable11.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     
/*  921 */     this.jTable11.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/*  922 */     this.jTable11.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public void generadora(String usua, String num) {
/*  926 */     this.USUARIO = usua;
/*  927 */     this.panel.setViewportView(this);
/*  928 */     this.id = num;
/*  929 */     crearInd();
/*  930 */     this.jLabel14.setVisible(false);
/*  931 */     if (this.fichas != null) {
/*  932 */       cargarFormulario();
/*  933 */       this.fichas.addTab("Modificar Empresa Origen - [Clave: " + this.id + "]", this.panel);
/*  934 */       this.jButton1.setText("Modificar");
/*  935 */       this.jLabel1.setText("Modificar Empresas Origen");
/*  936 */       this.jButton3.setVisible(true);
/*  937 */       this.jButton4.setVisible(true);
/*      */     } else {
/*  939 */       this.jButton3.setVisible(false);
/*  940 */       this.jButton4.setVisible(false);
/*  941 */       this.jLabel1.setText("     Agergar Empresas Origen");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/*  946 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  948 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  952 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField1, evt);
/*      */           }
/*      */         });
/*  955 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  957 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  961 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField9, evt);
/*      */           }
/*      */         });
/*  964 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  966 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  970 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/*  974 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  976 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  980 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField12, evt);
/*      */           }
/*      */         });
/*      */     
/*  984 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  986 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  990 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField3, evt);
/*      */           }
/*      */         });
/*  993 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  995 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  999 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1002 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1004 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1008 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 1011 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1013 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1017 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 1020 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1022 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1026 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 1029 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1031 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1035 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 1038 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1040 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1044 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 1047 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1049 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1053 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 1056 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1058 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1062 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 1065 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1067 */             GeneradoraAlta.this.jTextGanado(GeneradoraAlta.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1071 */             GeneradoraAlta.this.jTextPerdido(GeneradoraAlta.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1077 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1081 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 1085 */     this.jTextField2.setText("");
/* 1086 */     this.jTextField3.setText("");
/* 1087 */     this.jTextField4.setText("");
/* 1088 */     this.jTextField5.setText("");
/* 1089 */     this.jTextField6.setText("");
/* 1090 */     this.jTextField7.setText("");
/* 1091 */     this.jTextField8.setText("");
/* 1092 */     this.jTextField9.setText("");
/* 1093 */     this.jTextField10.setText("");
/* 1094 */     this.jTextField11.setText("");
/* 1095 */     this.jTextField12.setText("MÉXICO");
/* 1096 */     this.jTextField85.setText("MEX");
/* 1097 */     this.jFormattedTextField1.setValue("");
/* 1098 */     this.jComboBox1.setSelectedIndex(0);
/* 1099 */     crearInd();
/* 1100 */     if (this.jButton1.getText().equals("Modificar")) {
/* 1101 */       this.jTextField1.setText(this.id);
/*      */     }
/* 1103 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   public void pasarInd(int i) {
/* 1107 */     this.INDICE = i;
/*      */   }
/*      */   
/*      */   public void cargarFormulario() {
/* 1111 */     this.jLabel14.setVisible(true);
/* 1112 */     this.jButton4.setVisible(true);
/* 1113 */     this.jButton1.setMnemonic('M');
/* 1114 */     this.jButton1.setToolTipText("Modificar (Alt+M)");
/* 1115 */     String[] campos = this.con.regresaReg("clave_gene,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado,activo,nombre_corto,iniciales,origen,pais,codigopais", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene = " + this.id, 16);
/* 1116 */     this.inf = campos;
/* 1117 */     this.jTextField1.setText(campos[0]);
/* 1118 */     this.jTextField2.setText(campos[1]);
/* 1119 */     this.jTextField3.setText(campos[2]);
/* 1120 */     this.jTextField4.setText(campos[3]);
/* 1121 */     this.jTextField5.setText(campos[4]);
/* 1122 */     this.jTextField6.setText(campos[5]);
/* 1123 */     this.jTextField7.setText(campos[6]);
/* 1124 */     this.jTextField12.setText(campos[14]);
/* 1125 */     this.jTextField85.setText(campos[15]);
/* 1126 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS", "CIUDAD DE MEXICO", "TEXAS", "FLORIDA" }));
/* 1127 */     this.jComboBox1.setSelectedItem(campos[9]);
/* 1128 */     this.jTextField8.setText(campos[7]);
/* 1129 */     this.jFormattedTextField1.setText(campos[8]);
/* 1130 */     this.jTextField9.setText(campos[11]);
/* 1131 */     this.jTextField10.setText(campos[12]);
/* 1132 */     this.jTextField11.setText(campos[13]);
/* 1133 */     if (campos[10].equals("Activado")) {
/* 1134 */       this.jCheckBox1.setSelected(false);
/*      */     } else {
/* 1136 */       this.jCheckBox1.setSelected(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1141 */     String clave = this.jTextField1.getText();
/* 1142 */     String nombre = "";
/* 1143 */     String estados = "";
/* 1144 */     String id_edo = "";
/* 1145 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 1146 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 1148 */     this.encontrado = this.con.consultar("count(clave_gene)", "emp_generadora", "where clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and id_edo like '%" + id_edo + "%'");
/* 1149 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1150 */     this.encontrado = this.con.consultar("count(empresa)", "emp_generadora", "");
/* 1151 */     String tot = this.con.Campo;
/* 1152 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1153 */           .buscarReg(10, totreg, "clave_gene,empresa,calle,num,col,cp,ciudad,estado,rfc,telefono", "emp_generadora,estados", "where emp_generadora.id_edo=estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%'"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Origen", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1158 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1163 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1166 */     this.jTable3.setShowVerticalLines(false);
/* 1167 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 1168 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1169 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 1170 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 1171 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 1172 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(70);
/* 1173 */     this.jTable3.setSelectionMode(0);
/* 1174 */     this.jTable3.setAutoCreateRowSorter(true);
/* 1175 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */   
/*      */   class CeldaRender3
/*      */     extends DefaultTableCellRenderer {
/* 1180 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1183 */       setEnabled((table == null || table.isEnabled()));
/* 1184 */       if (row % 2 == 0) {
/* 1185 */         setBackground(new Color(194, 213, 151));
/* 1186 */         setForeground(Color.black);
/* 1187 */         setHorizontalAlignment(2);
/*      */       } else {
/* 1189 */         setBackground((Color)null);
/* 1190 */         setForeground(Color.black);
/* 1191 */         setHorizontalAlignment(2);
/*      */       } 
/* 1193 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1194 */       return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GeneradoraAlta.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */