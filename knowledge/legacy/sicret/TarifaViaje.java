/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.Calendar;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JList;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ 
/*      */ public class TarifaViaje extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   29 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   30 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   31 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   32 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   33 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   34 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   35 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   36 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   37 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   39 */   Validaciones val = new Validaciones();
/*   40 */   Consultas con = new Consultas();
/*   41 */   Errores error = new Errores(true);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*   45 */   DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Nueva Tarifa");
/*   46 */   DefaultMutableTreeNode raiz2 = new DefaultMutableTreeNode("Nueva Tarifa");
/*   47 */   CeldaRender celda = new CeldaRender();
/*      */   String[] CLIENTES;
/*      */   String[] GUIAS;
/*      */   String[] SERVICIOS;
/*      */   String[] RESIDUOS;
/*      */   String[] DESTINOS;
/*      */   String[] TIPOS;
/*      */   String[] EQUIPOS;
/*      */   String[] POZOS;
/*   56 */   String[] COLUMNAS = new String[] { "", "", "", "", "", "", "", "" };
/*   57 */   int INDCOL = 0;
/*   58 */   DefaultMutableTreeNode[] NODOS = new DefaultMutableTreeNode[] { new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode("") };
/*   59 */   double MONTO = 0.0D;
/*   60 */   String DESCRIP = ""; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton10; private JButton jButton18; private JButton jButton19; private JButton jButton20; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel2; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62;
/*      */   
/*      */   public TarifaViaje(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   63 */     this.padre = padre;
/*   64 */     this.fichas = fichas;
/*   65 */     initComponents();
/*   66 */     this.USUARIO = USUARIO;
/*      */     
/*   68 */     panelito.setViewportView(this);
/*   69 */     this.panel = panelito;
/*   70 */     this.buttonGroup1.add(this.jRadioButton1);
/*   71 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*   73 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   74 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   75 */     this.jLabel2.setCursor(micursor);
/*      */     
/*   77 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   78 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   79 */     this.jDialog1.setCursor(micursor);
/*   80 */     this.jDialog2.setCursor(micursor);
/*   81 */     this.jDialog3.setCursor(micursor);
/*      */     
/*   83 */     this.jSpinner1.setBackground(Color.WHITE);
/*   84 */     int w = this.tama.width;
/*   85 */     int h = this.tama.height;
/*   86 */     int rh = (h - 400) / 2;
/*   87 */     this.jDialog1.setSize(500, 400);
/*   88 */     this.jDialog1.setLocation(50, rh);
/*   89 */     this.jDialog1.setResizable(false);
/*   90 */     this.jSplitPane1.setDividerLocation(240);
/*      */     
/*   92 */     rh = (h - 320) / 2;
/*   93 */     this.jDialog2.setSize(425, 320);
/*   94 */     this.jDialog2.setLocation(560, rh);
/*   95 */     this.jDialog2.setResizable(false);
/*   96 */     colorear();
/*      */     
/*   98 */     int rw = (w - 335) / 2;
/*   99 */     rh = (h - 150) / 2;
/*  100 */     this.jDialog3.setSize(335, 150);
/*  101 */     this.jDialog3.setLocation(rw, rh);
/*  102 */     this.jDialog3.setResizable(false);
/*      */     
/*  104 */     rw = (w - 420) / 2;
/*  105 */     rh = (h - 300) / 2;
/*  106 */     this.jDialog4.setSize(420, 300);
/*  107 */     this.jDialog4.setLocation(rw, rh);
/*  108 */     this.jDialog4.setResizable(false);
/*      */     
/*  110 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  111 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  112 */     editFormat.setGroupingUsed(false);
/*  113 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  114 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  115 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  116 */     enFormat.setAllowsInvalid(true);
/*  117 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  118 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */     
/*  120 */     cargarInfo();
/*  121 */     consultar();
/*      */     
/*  123 */     privilegios();
/*      */   }
/*      */   private JLabel jLabel63; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JList jList1; private JPanel jPanel1; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JSpinner jSpinner1; private JSplitPane jSplitPane1; private JTable jTable1; private JTextField jTextField1; private JTextField jTextField2; private JTree jTree1; private JTree jTree2;
/*      */   
/*      */   private void initComponents() {
/*  128 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  129 */     this.jPanel11 = new JPanel();
/*  130 */     this.jLabel58 = new JLabel();
/*  131 */     this.jSeparator6 = new JSeparator();
/*  132 */     this.jLabel59 = new JLabel();
/*  133 */     this.jButton18 = new JButton();
/*  134 */     this.jButton19 = new JButton();
/*  135 */     this.jButton20 = new JButton();
/*  136 */     this.jSplitPane1 = new JSplitPane(1);
/*  137 */     this.jLabel5 = new JLabel();
/*  138 */     this.jTextField1 = new JTextField();
/*  139 */     this.jLabel6 = new JLabel();
/*  140 */     this.jTextField2 = new JTextField();
/*  141 */     this.jLabel7 = new JLabel();
/*  142 */     this.jSpinner1 = new JSpinner();
/*  143 */     this.jLabel8 = new JLabel();
/*  144 */     this.jLabel11 = new JLabel();
/*  145 */     this.jRadioButton1 = new JRadioButton();
/*  146 */     this.jRadioButton2 = new JRadioButton();
/*  147 */     this.jPanel2 = new JPanel();
/*  148 */     this.jScrollPane2 = new JScrollPane();
/*  149 */     this.jTree1 = new JTree();
/*  150 */     this.jPanel3 = new JPanel();
/*  151 */     this.jPanel4 = new JPanel();
/*  152 */     this.jLabel2 = new JLabel();
/*  153 */     this.jDialog2 = new JDialog(this.jDialog1);
/*  154 */     this.jPanel12 = new JPanel();
/*  155 */     this.jLabel60 = new JLabel();
/*  156 */     this.jSeparator7 = new JSeparator();
/*  157 */     this.jLabel61 = new JLabel();
/*  158 */     this.jComboBox1 = new JComboBox();
/*  159 */     this.jScrollPane3 = new JScrollPane();
/*  160 */     this.jList1 = new JList();
/*  161 */     this.jLabel62 = new JLabel();
/*  162 */     this.jSeparator3 = new JSeparator();
/*  163 */     this.jButton5 = new JButton();
/*  164 */     this.jButton6 = new JButton();
/*  165 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  166 */     this.jPanel5 = new JPanel();
/*  167 */     this.jLabel63 = new JLabel();
/*  168 */     this.jLabel4 = new JLabel();
/*  169 */     this.jSeparator4 = new JSeparator();
/*  170 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  171 */     this.jButton7 = new JButton();
/*  172 */     this.jButton8 = new JButton();
/*  173 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  174 */     this.jPanel7 = new JPanel();
/*  175 */     this.jLabel9 = new JLabel();
/*  176 */     this.jSeparator5 = new JSeparator();
/*  177 */     this.jScrollPane4 = new JScrollPane();
/*  178 */     this.jTree2 = new JTree();
/*  179 */     this.jButton9 = new JButton();
/*  180 */     this.jLabel10 = new JLabel();
/*  181 */     this.jSeparator8 = new JSeparator();
/*  182 */     this.buttonGroup1 = new ButtonGroup();
/*  183 */     this.jPanel6 = new JPanel();
/*  184 */     this.jLabel3 = new JLabel();
/*  185 */     this.jSeparator1 = new JSeparator();
/*  186 */     this.jPanel1 = new JPanel();
/*  187 */     this.jScrollPane1 = new JScrollPane();
/*  188 */     this.jTable1 = new JTable();
/*  189 */     this.jButton1 = new JButton();
/*  190 */     this.jButton3 = new JButton();
/*  191 */     this.jButton4 = new JButton();
/*  192 */     this.jSeparator2 = new JSeparator();
/*  193 */     this.jLabel1 = new JLabel();
/*  194 */     this.jButton10 = new JButton();
/*  195 */     this.jLabel12 = new JLabel();
/*  196 */     this.jComboBox2 = new JComboBox();
/*      */     
/*  198 */     this.jDialog1.setTitle("Establecer Precios");
/*  199 */     this.jDialog1.setModal(true);
/*      */     
/*  201 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/*  203 */     this.jLabel58.setFont(new Font("Times New Roman", 1, 18));
/*  204 */     this.jLabel58.setHorizontalAlignment(0);
/*  205 */     this.jLabel58.setText("Establecer Precios");
/*      */     
/*  207 */     this.jLabel59.setText("Para todos los viajes siempre y cuando se cumplan las siguientes condiciones:");
/*      */     
/*  209 */     this.jButton18.setMnemonic('C');
/*  210 */     this.jButton18.setText("Cerrar");
/*  211 */     this.jButton18.setToolTipText("Cerrar (Alt+C)");
/*  212 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  214 */             TarifaViaje.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  218 */     this.jButton19.setMnemonic('R');
/*  219 */     this.jButton19.setText("Crear");
/*  220 */     this.jButton19.setToolTipText("Crear (Alt+R)");
/*  221 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  223 */             TarifaViaje.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  227 */     this.jButton20.setMnemonic('A');
/*  228 */     this.jButton20.setText("Agregar");
/*  229 */     this.jButton20.setToolTipText("Agregar (Alt+A)");
/*  230 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  232 */             TarifaViaje.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  236 */     this.jSplitPane1.setLeftComponent(this.jPanel2);
/*  237 */     this.jSplitPane1.setRightComponent(this.jPanel3);
/*  238 */     this.jSplitPane1.setDividerSize(4);
/*      */     
/*  240 */     this.jLabel5.setText("Nombre de la Tarifa");
/*      */     
/*  242 */     this.jLabel6.setText("Descripción");
/*      */     
/*  244 */     this.jLabel7.setText("Tipo Cobro");
/*      */     
/*  246 */     this.jSpinner1.setModel(new SpinnerNumberModel(0, 0, 9, 1));
/*  247 */     this.jSpinner1.setToolTipText("Si existen dos o más tarifas de un cliente, el sistema elije por orden de prioridad.");
/*      */     
/*  249 */     this.jLabel8.setFont(new Font("Tahoma", 2, 11));
/*  250 */     this.jLabel8.setText("0 = Menos Prioridad, 9 Mayor Prioridad");
/*      */     
/*  252 */     this.jLabel11.setText("Prioridad");
/*      */     
/*  254 */     this.jRadioButton1.setSelected(true);
/*  255 */     this.jRadioButton1.setText("Tonelada");
/*      */     
/*  257 */     this.jRadioButton2.setText("Viaje");
/*      */     
/*  259 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  260 */     this.jPanel11.setLayout(jPanel11Layout);
/*  261 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  263 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  264 */           .addContainerGap()
/*  265 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  266 */             .addComponent(this.jLabel7, -2, 96, -2)
/*  267 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  268 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  269 */                 .addComponent(this.jLabel5, -2, 112, -2)
/*  270 */                 .addComponent(this.jLabel6, -2, 112, -2))
/*  271 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  272 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  273 */                 .addGroup(jPanel11Layout.createSequentialGroup()
/*  274 */                   .addComponent(this.jRadioButton1, -2, 90, -2)
/*  275 */                   .addGap(26, 26, 26)
/*  276 */                   .addComponent(this.jRadioButton2, -2, 90, -2))
/*  277 */                 .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  278 */                   .addComponent(this.jTextField2, GroupLayout.Alignment.LEADING)
/*  279 */                   .addComponent(this.jTextField1, GroupLayout.Alignment.LEADING, -1, 206, 32767))
/*  280 */                 .addGroup(jPanel11Layout.createSequentialGroup()
/*  281 */                   .addComponent(this.jSpinner1, -2, -1, -2)
/*  282 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  283 */                   .addComponent(this.jLabel8, -2, 237, -2)))
/*  284 */               .addContainerGap(104, 32767))
/*  285 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  286 */               .addComponent(this.jLabel11, -1, 87, 32767)
/*  287 */               .addGap(405, 405, 405))
/*  288 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  289 */               .addComponent(this.jSplitPane1, -2, 374, -2)
/*  290 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  291 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  292 */                 .addComponent(this.jButton19, -2, 92, -2)
/*  293 */                 .addComponent(this.jButton18, -2, 92, -2)
/*  294 */                 .addComponent(this.jButton20, -2, 92, -2))
/*  295 */               .addContainerGap(20, 32767))
/*  296 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  297 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  298 */                 .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING)
/*  299 */                 .addComponent(this.jLabel58, GroupLayout.Alignment.LEADING, -1, 468, 32767))
/*  300 */               .addContainerGap(24, 32767))
/*  301 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  302 */               .addComponent(this.jLabel59, -2, 482, 32767)
/*  303 */               .addContainerGap(10, 32767)))));
/*      */     
/*  305 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  306 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  307 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  308 */           .addComponent(this.jLabel58, -2, 25, -2)
/*  309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  310 */           .addComponent(this.jSeparator6, -2, 10, -2)
/*  311 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  312 */           .addComponent(this.jLabel59)
/*  313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  314 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  315 */             .addComponent(this.jLabel5)
/*  316 */             .addComponent(this.jTextField1, -2, -1, -2))
/*  317 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  318 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  319 */             .addComponent(this.jLabel6)
/*  320 */             .addComponent(this.jTextField2, -2, -1, -2))
/*  321 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  322 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  323 */             .addComponent(this.jLabel11)
/*  324 */             .addComponent(this.jSpinner1, -2, -1, -2)
/*  325 */             .addComponent(this.jLabel8))
/*  326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  327 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  328 */             .addComponent(this.jLabel7)
/*  329 */             .addComponent(this.jRadioButton1)
/*  330 */             .addComponent(this.jRadioButton2))
/*  331 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  332 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  333 */             .addComponent(this.jSplitPane1, -2, 152, -2)
/*  334 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  335 */               .addComponent(this.jButton20)
/*  336 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  337 */               .addComponent(this.jButton19)
/*  338 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  339 */               .addComponent(this.jButton18)))
/*  340 */           .addContainerGap(41, 32767)));
/*      */ 
/*      */     
/*  343 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  344 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  345 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  346 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  347 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */     
/*  349 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  350 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  351 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/*  354 */     this.jTree1.setFont(new Font("Tahoma", 0, 10));
/*  355 */     this.jTree1.setModel(new DefaultTreeModel(this.raiz));
/*  356 */     this.jScrollPane2.setViewportView(this.jTree1);
/*      */     
/*  358 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  359 */     this.jPanel2.setLayout(jPanel2Layout);
/*  360 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  361 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  362 */         .addComponent(this.jScrollPane2, -1, 180, 32767));
/*      */     
/*  364 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  366 */         .addComponent(this.jScrollPane2, -1, 198, 32767));
/*      */ 
/*      */     
/*  369 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  370 */     this.jPanel4.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  372 */     this.jLabel2.setFont(new Font("Times New Roman", 1, 25));
/*  373 */     this.jLabel2.setHorizontalAlignment(0);
/*  374 */     this.jLabel2.setText("$ MONTO");
/*  375 */     this.jLabel2.setToolTipText("Doble clic para asignar el monto");
/*  376 */     this.jLabel2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  378 */             TarifaViaje.this.jLabel2MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  382 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  383 */     this.jPanel4.setLayout(jPanel4Layout);
/*  384 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  386 */         .addComponent(this.jLabel2, -2, 129, 32767));
/*      */     
/*  388 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  390 */         .addComponent(this.jLabel2, -1, 146, 32767));
/*      */ 
/*      */     
/*  393 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  394 */     this.jPanel3.setLayout(jPanel3Layout);
/*  395 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  396 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  397 */         .addGap(0, 133, 32767)
/*  398 */         .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  399 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*      */     
/*  401 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  402 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  403 */         .addGap(0, 150, 32767)
/*  404 */         .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  405 */           .addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
/*      */ 
/*      */     
/*  408 */     this.jDialog2.setTitle("Datos");
/*      */     
/*  410 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/*  412 */     this.jLabel60.setFont(new Font("Times New Roman", 1, 18));
/*  413 */     this.jLabel60.setHorizontalAlignment(0);
/*  414 */     this.jLabel60.setText("Seleccionar Datos");
/*      */     
/*  416 */     this.jLabel61.setText("Selecciona el orgien de los datos:");
/*      */     
/*  418 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  419 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Cliente", "Guía", "Servicio", "Residuo", "Destino", "Tipo de Vehículo", "Equipo", "Pozo" }));
/*  420 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  422 */             TarifaViaje.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  426 */     this.jList1.setFont(new Font("Tahoma", 0, 10));
/*  427 */     this.jList1.setModel(new AbstractListModel() {
/*  428 */           String[] strings = new String[] { "Aquí se Visualiza la información" };
/*  429 */           public int getSize() { return this.strings.length; }
/*  430 */           public Object getElementAt(int i) { return this.strings[i]; }
/*      */         });
/*  432 */     this.jList1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  434 */             TarifaViaje.this.jList1MouseClicked(evt);
/*      */           }
/*      */         });
/*  437 */     this.jScrollPane3.setViewportView(this.jList1);
/*      */     
/*  439 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/*  440 */     this.jLabel62.setText("<html>Ésta es la información que puedes elegir para generar un nuevo tarificador. Recuerda que los precios aplican para los viajes que cumpan las condiciones</html>");
/*      */     
/*  442 */     this.jButton5.setMnemonic('C');
/*  443 */     this.jButton5.setText("Cerrar");
/*  444 */     this.jButton5.setToolTipText("Cerrar");
/*  445 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  447 */             TarifaViaje.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  451 */     this.jButton6.setMnemonic('A');
/*  452 */     this.jButton6.setText("<< Agregar");
/*  453 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/*  454 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  456 */             TarifaViaje.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  460 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  461 */     this.jPanel12.setLayout(jPanel12Layout);
/*  462 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  464 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  465 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  466 */             .addGroup(jPanel12Layout.createSequentialGroup()
/*  467 */               .addGap(151, 151, 151)
/*  468 */               .addComponent(this.jButton6, -2, 98, -2)
/*  469 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  470 */               .addComponent(this.jButton5, -2, 98, -2))
/*  471 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/*  472 */               .addContainerGap()
/*  473 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  474 */                 .addComponent(this.jSeparator3, GroupLayout.Alignment.LEADING, -1, 376, 32767)
/*  475 */                 .addComponent(this.jSeparator7, GroupLayout.Alignment.LEADING, -1, 376, 32767)
/*  476 */                 .addComponent(this.jLabel62, GroupLayout.Alignment.LEADING, 0, 0, 32767)
/*  477 */                 .addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING, -1, 376, 32767)
/*  478 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/*  479 */                   .addComponent(this.jLabel61, -1, 226, 32767)
/*  480 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  481 */                   .addComponent(this.jComboBox1, -2, 140, -2))
/*  482 */                 .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -2, 376, -2))))
/*  483 */           .addGap(23, 23, 23)));
/*      */     
/*  485 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  486 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  487 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  488 */           .addComponent(this.jLabel60, -2, 25, -2)
/*  489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  490 */           .addComponent(this.jSeparator7, -2, 10, -2)
/*  491 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  492 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  493 */             .addComponent(this.jLabel61)
/*  494 */             .addComponent(this.jComboBox1, -2, -1, -2))
/*  495 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  496 */           .addComponent(this.jScrollPane3, -2, 113, -2)
/*  497 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  498 */           .addComponent(this.jLabel62, -2, -1, -2)
/*  499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  500 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  501 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  502 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  503 */             .addComponent(this.jButton5)
/*  504 */             .addComponent(this.jButton6))
/*  505 */           .addContainerGap(26, 32767)));
/*      */ 
/*      */     
/*  508 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  509 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  510 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  512 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/*  514 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  515 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  516 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/*  519 */     this.jDialog3.setTitle("Monto $");
/*      */     
/*  521 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*      */     
/*  523 */     this.jLabel63.setFont(new Font("Times New Roman", 1, 18));
/*  524 */     this.jLabel63.setHorizontalAlignment(0);
/*  525 */     this.jLabel63.setText("Coloca el Monto $");
/*      */     
/*  527 */     this.jLabel4.setFont(new Font("Times New Roman", 1, 18));
/*  528 */     this.jLabel4.setText("Cantidad");
/*      */     
/*  530 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getCurrencyInstance())));
/*  531 */     this.jFormattedTextField1.setFont(new Font("Tahoma", 1, 20));
/*      */     
/*  533 */     this.jButton7.setMnemonic('C');
/*  534 */     this.jButton7.setText("Cerrar");
/*  535 */     this.jButton7.setToolTipText("Cerrar (Alt+C)");
/*  536 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  538 */             TarifaViaje.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  542 */     this.jButton8.setMnemonic('A');
/*  543 */     this.jButton8.setText("Aceptar");
/*  544 */     this.jButton8.setToolTipText("Aceptar (Alt+A)");
/*  545 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  547 */             TarifaViaje.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  551 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  552 */     this.jPanel5.setLayout(jPanel5Layout);
/*  553 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  555 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  556 */           .addContainerGap()
/*  557 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  558 */             .addGroup(jPanel5Layout.createSequentialGroup()
/*  559 */               .addComponent(this.jLabel4, -2, 97, -2)
/*  560 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  561 */               .addComponent(this.jFormattedTextField1, -2, 197, -2))
/*  562 */             .addComponent(this.jLabel63, -1, 298, 32767)
/*  563 */             .addComponent(this.jSeparator4))
/*  564 */           .addContainerGap(-1, 32767))
/*  565 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/*  566 */           .addContainerGap(128, 32767)
/*  567 */           .addComponent(this.jButton8, -2, 87, -2)
/*  568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  569 */           .addComponent(this.jButton7, -2, 87, -2)
/*  570 */           .addContainerGap()));
/*      */     
/*  572 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  573 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  574 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  575 */           .addComponent(this.jLabel63, -2, 24, -2)
/*  576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  577 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  578 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  579 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  580 */             .addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING, -1, 38, 32767)
/*  581 */             .addComponent(this.jFormattedTextField1, GroupLayout.Alignment.TRAILING))
/*  582 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  583 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  584 */             .addComponent(this.jButton7)
/*  585 */             .addComponent(this.jButton8))
/*  586 */           .addContainerGap()));
/*      */ 
/*      */     
/*  589 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  590 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  591 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  592 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  593 */         .addComponent(this.jPanel5, -2, -1, -2));
/*      */     
/*  595 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */         .addComponent(this.jPanel5, -2, -1, -2));
/*      */ 
/*      */     
/*  600 */     this.jDialog4.setTitle("Ver Tarifa a Detalle");
/*      */     
/*  602 */     this.jPanel7.setBackground(Color.white);
/*      */     
/*  604 */     this.jLabel9.setFont(new Font("Times New Roman", 1, 20));
/*  605 */     this.jLabel9.setHorizontalAlignment(0);
/*  606 */     this.jLabel9.setText("Tarifa");
/*      */     
/*  608 */     this.jTree2.setFont(new Font("Tahoma", 0, 10));
/*  609 */     this.jTree2.setModel(new DefaultTreeModel(this.raiz2));
/*  610 */     this.jScrollPane4.setViewportView(this.jTree2);
/*      */     
/*  612 */     this.jButton9.setMnemonic('C');
/*  613 */     this.jButton9.setText("Cerrar");
/*  614 */     this.jButton9.setToolTipText("Cerrar Tarifa (Alt+C)");
/*  615 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  617 */             TarifaViaje.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  621 */     this.jLabel10.setFont(new Font("Tahoma", 2, 11));
/*  622 */     this.jLabel10.setText("<html>Las tarifas aplican para todos los viajes que cumplan estas condiciones al 100%<html>");
/*      */     
/*  624 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  625 */     this.jPanel7.setLayout(jPanel7Layout);
/*  626 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  628 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  629 */           .addContainerGap()
/*  630 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  631 */             .addComponent(this.jScrollPane4, -1, 396, 32767)
/*  632 */             .addComponent(this.jSeparator5, -1, 396, 32767)
/*  633 */             .addComponent(this.jLabel9, -1, 396, 32767)
/*  634 */             .addComponent(this.jLabel10, -1, 396, 32767)
/*  635 */             .addComponent(this.jSeparator8, -1, 396, 32767)
/*  636 */             .addComponent(this.jButton9, GroupLayout.Alignment.TRAILING, -2, 99, -2))
/*  637 */           .addContainerGap()));
/*      */     
/*  639 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  641 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  642 */           .addComponent(this.jLabel9)
/*  643 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  644 */           .addComponent(this.jSeparator5, -2, 10, -2)
/*  645 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  646 */           .addComponent(this.jScrollPane4, -2, 152, -2)
/*  647 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  648 */           .addComponent(this.jLabel10, -2, -1, -2)
/*  649 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  650 */           .addComponent(this.jSeparator8, -2, 10, -2)
/*  651 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  652 */           .addComponent(this.jButton9)
/*  653 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  656 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  657 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  658 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  659 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  660 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/*  662 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  664 */         .addComponent(this.jPanel7, -2, -1, -2));
/*      */ 
/*      */     
/*  667 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*  668 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  670 */     this.jLabel3.setFont(new Font("Times New Roman", 1, 24));
/*  671 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/*  672 */     this.jLabel3.setHorizontalAlignment(0);
/*  673 */     this.jLabel3.setText("Tarificador por Viaje");
/*      */     
/*  675 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  677 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  678 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, , { null, null, null, null, null }, , { null, null, null, null, null }, , { null, null, null, null, null },  }, (Object[])new String[] { "Núm", "Tarifa", "Descripción", "Contenido", "Precio" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  689 */           boolean[] canEdit = new boolean[] { false, false, true, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  694 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  697 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  699 */             TarifaViaje.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/*  702 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  703 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  704 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/*  705 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/*  706 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(90);
/*  707 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
/*      */     } 
/*      */     
/*  710 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  711 */     this.jButton1.setMnemonic('N');
/*  712 */     this.jButton1.setText("Nueva");
/*  713 */     this.jButton1.setToolTipText("Crea nuevas reglas de tarificadores (Alt+N)");
/*  714 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  716 */             TarifaViaje.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  720 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/*  721 */     this.jButton3.setMnemonic('E');
/*  722 */     this.jButton3.setText("Eliminar");
/*  723 */     this.jButton3.setToolTipText("Si la tarifa ya no se utiliza puedes eliminarla (Alt+E)");
/*  724 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  726 */             TarifaViaje.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  730 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/*  731 */     this.jButton4.setMnemonic('V');
/*  732 */     this.jButton4.setText("Ver");
/*  733 */     this.jButton4.setToolTipText("Puedes observar a detalle la tarifa (Alt+V)");
/*  734 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  736 */             TarifaViaje.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  740 */     this.jLabel1.setFont(new Font("Tahoma", 2, 11));
/*  741 */     this.jLabel1.setText("A continuación se muestra el listado de todas las tarifas para el módulo de facturación");
/*      */     
/*  743 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  744 */     this.jButton10.setMnemonic('M');
/*  745 */     this.jButton10.setText("Modificar");
/*  746 */     this.jButton10.setToolTipText("Modificar Tarifa (Alt+M)");
/*  747 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  749 */             TarifaViaje.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  753 */     this.jLabel12.setHorizontalAlignment(4);
/*  754 */     this.jLabel12.setText("Mostrar sólo");
/*      */     
/*  756 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  757 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  759 */             TarifaViaje.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  763 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  764 */     this.jPanel1.setLayout(jPanel1Layout);
/*  765 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  766 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  767 */         .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)
/*  768 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  769 */           .addContainerGap()
/*  770 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  771 */             .addComponent(this.jSeparator2)
/*  772 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  773 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  774 */                 .addComponent(this.jLabel1, -2, 484, -2)
/*  775 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/*  776 */                   .addComponent(this.jButton1, -2, 113, -2)
/*  777 */                   .addGap(18, 18, 18)
/*  778 */                   .addComponent(this.jButton10, -2, 113, -2)
/*  779 */                   .addGap(27, 27, 27)
/*  780 */                   .addComponent(this.jButton3, -2, 113, -2)
/*  781 */                   .addGap(26, 26, 26)
/*  782 */                   .addComponent(this.jButton4, -2, 114, -2)
/*  783 */                   .addGap(31, 31, 31)
/*  784 */                   .addComponent(this.jLabel12, -2, 77, -2)
/*  785 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  786 */                   .addComponent(this.jComboBox2, -2, 155, -2)))
/*  787 */               .addGap(0, 43, 32767)))
/*  788 */           .addContainerGap()));
/*      */     
/*  790 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  792 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  793 */           .addContainerGap()
/*  794 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  795 */             .addComponent(this.jButton1)
/*  796 */             .addComponent(this.jButton10)
/*  797 */             .addComponent(this.jButton3)
/*  798 */             .addComponent(this.jButton4)
/*  799 */             .addComponent(this.jComboBox2, -2, -1, -2)
/*  800 */             .addComponent(this.jLabel12))
/*  801 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  802 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  803 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  804 */           .addComponent(this.jLabel1)
/*  805 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  806 */           .addComponent(this.jScrollPane1, -1, 230, 32767)));
/*      */ 
/*      */     
/*  809 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  810 */     this.jPanel6.setLayout(jPanel6Layout);
/*  811 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  812 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  813 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  814 */           .addContainerGap()
/*  815 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  816 */             .addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  817 */             .addComponent(this.jLabel3, -1, -1, 32767)
/*  818 */             .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING))
/*  819 */           .addContainerGap()));
/*      */     
/*  821 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  822 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  823 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  824 */           .addComponent(this.jLabel3)
/*  825 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  826 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  827 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  828 */           .addComponent(this.jPanel1, -1, -1, 32767)
/*  829 */           .addContainerGap()));
/*      */ 
/*      */     
/*  832 */     GroupLayout layout = new GroupLayout(this);
/*  833 */     setLayout(layout);
/*  834 */     layout.setHorizontalGroup(layout
/*  835 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  836 */         .addGap(0, 922, 32767)
/*  837 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  838 */           .addGroup(layout.createSequentialGroup()
/*  839 */             .addContainerGap()
/*  840 */             .addComponent(this.jPanel6, -1, -1, 32767)
/*  841 */             .addContainerGap())));
/*      */     
/*  843 */     layout.setVerticalGroup(layout
/*  844 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  845 */         .addGap(0, 418, 32767)
/*  846 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/*  848 */             .addGap(10, 10, 10)
/*  849 */             .addComponent(this.jPanel6, -1, -1, 32767)
/*  850 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/*  855 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/*  859 */     this.val.pasarModal(Boolean.valueOf(true));
/*  860 */     if (this.jTextField1.getText().equals("")) {
/*  861 */       this.error.cargarError(this.jTextField1, "050");
/*      */     }
/*  863 */     else if (this.jTextField2.getText().equals("")) {
/*  864 */       this.error.cargarError(this.jTextField2, "050");
/*      */     }
/*  866 */     else if (this.raiz.isLeaf() && this.jButton10.getText().equals("Crear")) {
/*  867 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar información general del tarificador, por ejemplo: cliente, servicio, reisudo.", "Falta Información General", 0, this.ERROR);
/*      */     }
/*  869 */     else if (this.jLabel2.getText().equals("$ MONTO")) {
/*  870 */       this.jLabel2.setForeground(Color.RED);
/*  871 */       JOptionPane.showMessageDialog(this.jDialog3, "Debes colocar el monto de la tarifa para guardar la información", "Falta Monto", 0, this.ERROR);
/*  872 */       this.jLabel2.setForeground(Color.BLACK);
/*      */     }
/*  874 */     else if (!this.val.validarApostrofe(this.jTextField1, this.jTextField1.getText(), "020") && 
/*  875 */       !this.val.validarApostrofe(this.jTextField2, this.jTextField2.getText(), "020")) {
/*  876 */       if (this.jButton19.getText().equals("Crear")) {
/*  877 */         String conte = agrupar();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  883 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html>¿Estás seguro que deseas crear una nueva tarifa?<html>", "Nueva Tarifa", 0, 3, this.PREG);
/*  884 */         if (res == 0) {
/*  885 */           String tarifa = "Tonelada";
/*  886 */           if (this.jRadioButton2.isSelected()) {
/*  887 */             tarifa = "Viaje";
/*      */           }
/*  889 */           this.con.inserSinMsj("insert into tarifas(cliente,tarifa,descripcion,contenido,montoLetra,monto,tipoCobro,prioridad)values('" + String.valueOf(this.NODOS[0].getUserObject()) + "','" + this.jTextField1.getText().toUpperCase() + "','" + this.jTextField2.getText().toUpperCase() + "','" + conte + "','" + this.jFormattedTextField1.getText() + "'," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + tarifa + "'," + Integer.parseInt(String.valueOf(this.jSpinner1.getValue())) + ")");
/*  890 */           consultar();
/*  891 */           this.jDialog1.setVisible(false);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/*  896 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html>¿Estás seguro que deseas modificar la tarifa?<html>", "Modificar Tarifa", 0, 3, this.PREG);
/*  897 */         if (res == 0) {
/*  898 */           String tarifa = "Tonelada";
/*  899 */           if (this.jRadioButton2.isSelected()) {
/*  900 */             tarifa = "Viaje";
/*      */           }
/*  902 */           this.con.inserSinMsj("update tarifas set tarifa = '" + this.jTextField1.getText().toUpperCase() + "', descripcion = '" + this.jTextField2.getText().toUpperCase() + "', montoLetra='" + this.jLabel2.getText() + "', monto = " + this.MONTO + ", prioridad=" + String.valueOf(this.jSpinner1.getValue()) + ",tipoCobro='" + tarifa + "' where num=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/*  903 */           consultar();
/*  904 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/*  911 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  915 */     limpiar();
/*  916 */     this.jButton20.setEnabled(true);
/*  917 */     this.jButton19.setMnemonic('R');
/*  918 */     this.jButton19.setText("Crear");
/*  919 */     this.jButton19.setToolTipText("Crear (Alt+R)");
/*  920 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  924 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  925 */       String col = String.valueOf(this.jComboBox1.getSelectedItem());
/*  926 */       selecCol(col);
/*      */     } else {
/*      */       
/*  929 */       this.jList1 = new JList();
/*  930 */       this.jList1.setModel(new AbstractListModel() {
/*  931 */             String[] strings = new String[] { "Aquí se Visualiza la información" };
/*  932 */             public int getSize() { return this.strings.length; }
/*  933 */             public Object getElementAt(int i) { return this.strings[i]; }
/*      */           });
/*  935 */       this.jScrollPane3.setViewportView(this.jList1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  940 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jList1MouseClicked(MouseEvent evt) {
/*  944 */     if (evt.getClickCount() == 2) {
/*  945 */       String valor = String.valueOf(this.jList1.getSelectedValue());
/*  946 */       if (valor.equals("Aquí se Visualiza la información")) {
/*  947 */         this.jComboBox1.setBackground(Color.RED);
/*  948 */         JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar el origen de los datos para activar su información", "Origen de Datos", 0, this.ERROR);
/*      */       } else {
/*      */         
/*  951 */         String valorCombo = String.valueOf(this.jComboBox1.getSelectedItem());
/*  952 */         if (!estaCol(valorCombo)) {
/*  953 */           pasarDatos();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/*  960 */     if (this.jList1.isSelectionEmpty()) {
/*  961 */       JOptionPane.showMessageDialog(this.jDialog2, "Debes seleccionar un dato de la lista para poder pasarlo a la tarifa", "Selecciona un Dato", 0, this.ERROR);
/*      */     } else {
/*      */       
/*  964 */       String valor = String.valueOf(this.jComboBox1.getSelectedItem());
/*  965 */       if (!estaCol(valor)) {
/*  966 */         pasarDatos();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel2MouseClicked(MouseEvent evt) {
/*  972 */     if (evt.getClickCount() == 2) {
/*  973 */       if (this.MONTO > 0.0D) {
/*  974 */         this.jFormattedTextField1.setValue(Double.valueOf(this.MONTO));
/*      */       } else {
/*      */         
/*  977 */         this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */       } 
/*  979 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/*  984 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/*  988 */     establecerMonto();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/*  992 */     if (evt.getClickCount() == 2) {
/*  993 */       cargarTarifa();
/*      */     } else {
/*      */       
/*  996 */       this.jButton3.setEnabled(true);
/*  997 */       this.jButton4.setEnabled(true);
/*  998 */       this.jButton10.setEnabled(true);
/*  999 */       privilegios();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1004 */     int indice = this.jTable1.getSelectedRow();
/* 1005 */     if (indice < 0) {
/* 1006 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar un registro para poder acceder a la información.", "Selecicona tu Información", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1009 */       cargarTarifa();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1014 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1018 */     int indice = this.jTable1.getSelectedRow();
/* 1019 */     if (indice < 0) {
/* 1020 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar un registro para poder acceder a la información.", "Selecicona tu Información", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1023 */       limpiar();
/* 1024 */       this.jButton19.setMnemonic('M');
/* 1025 */       this.jButton19.setText("Modificar");
/* 1026 */       this.jButton19.setToolTipText("Modificar (Alt+M)");
/* 1027 */       this.jButton20.setEnabled(false);
/*      */       
/* 1029 */       String[] datos = this.con.regresaReg("tarifa,descripcion,contenido,montoLetra,monto,prioridad,tipoCobro", "tarifas", "where num=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 7);
/* 1030 */       crearArbol(datos[2]);
/* 1031 */       this.jTextField1.setText(datos[0]);
/* 1032 */       this.jTextField2.setText(datos[1]);
/* 1033 */       this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(datos[5])));
/* 1034 */       this.jLabel2.setText(datos[3]);
/* 1035 */       this.MONTO = Double.parseDouble(datos[4]);
/* 1036 */       if (datos[6].equals("Tonelada")) {
/* 1037 */         this.jRadioButton1.setSelected(true);
/*      */       } else {
/*      */         
/* 1040 */         this.jRadioButton2.setSelected(true);
/*      */       } 
/* 1042 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1047 */     int indice = this.jTable1.getSelectedRow();
/* 1048 */     if (indice < 0) {
/* 1049 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar un registro para poder acceder a la información.", "Selecicona tu Información", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1052 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas eliminar la tarifa que seleccionaste?", "Eliminar Tarifa", 0, 3, this.ELIMINAR);
/* 1053 */       if (res == 0) {
/* 1054 */         this.con.eliminar("tarifas", "where num=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1055 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1061 */     consultar();
/*      */   }
/*      */   public void cargarTarifa() {
/* 1064 */     limpiar();
/* 1065 */     String cliente = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 1066 */     this.con.consultar("contenido", "tarifas", "where num = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1067 */     String conte = this.con.Campo;
/* 1068 */     crearArbol(conte);
/* 1069 */     this.jLabel9.setText("TARIFA DE " + cliente);
/* 1070 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   public void privilegios() {
/* 1073 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 1074 */     if (this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("FACTURACIÓN") || this.con.Campo.equals("ADMINISTRADOR")) {
/* 1075 */       this.jButton1.setEnabled(true);
/* 1076 */       this.jButton3.setEnabled(true);
/* 1077 */       this.jButton10.setEnabled(true);
/*      */     } else {
/*      */       
/* 1080 */       this.jButton1.setEnabled(false);
/* 1081 */       this.jButton3.setEnabled(false);
/* 1082 */       this.jButton10.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   public void establecerMonto() {
/* 1086 */     String cant = this.jFormattedTextField1.getValue().toString();
/* 1087 */     this.MONTO = Double.parseDouble(cant);
/* 1088 */     if (this.MONTO < 0.0D) {
/* 1089 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes insertar cantidades negativas, por favor verifica tu información", "Cantidad Negativa", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1092 */       this.jLabel2.setText(this.jFormattedTextField1.getText());
/* 1093 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */   public String agrupar() {
/* 1097 */     String contenido = "";
/* 1098 */     for (int i = 0; i < this.INDCOL; i++) {
/* 1099 */       contenido = contenido + "<" + contenido + ">\n";
/* 1100 */       contenido = contenido + contenido;
/* 1101 */       contenido = contenido + "\n</" + contenido + ">\n";
/*      */     } 
/* 1103 */     return contenido;
/*      */   }
/*      */   public void consultar() {
/* 1106 */     String cliente = String.valueOf(this.jComboBox2.getSelectedItem());
/* 1107 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 1108 */       cliente = "";
/*      */     }
/* 1110 */     this.jButton4.setEnabled(false);
/* 1111 */     this.jButton3.setEnabled(false);
/* 1112 */     this.jButton10.setEnabled(false);
/* 1113 */     this.encontrado = this.con.consultar("count(num)", "tarifas", "where cliente like '%" + cliente + "%'");
/* 1114 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1115 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 1116 */           .buscarReg(7, totreg, "num,cliente,tarifa,descripcion,montoLetra,tipoCobro,prioridad", "tarifas", "where cliente like '%" + cliente + "%' order by cliente"), (Object[])new String[] { "Núm", "Cliente", "Tarifa", "Descripcion", "Monto", "Tipo", "Prioridad" })
/*      */         {
/*      */ 
/*      */           
/* 1120 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1124 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1127 */     this.jTable1.setSelectionMode(0);
/* 1128 */     this.jTable1.setAutoCreateRowSorter(true);
/* 1129 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 1130 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 1131 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 1132 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 1133 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(120);
/* 1134 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 1135 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/* 1136 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 1137 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
/* 1138 */     this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);
/* 1139 */     this.jTable1.getColumnModel().getColumn(6).setMaxWidth(60);
/* 1140 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */   }
/*      */   public void pasarDatos() {
/* 1143 */     int indice = this.jTree1.getRowCount();
/* 1144 */     int indCombo = this.jComboBox1.getSelectedIndex();
/* 1145 */     if (indice == 1) {
/* 1146 */       if (indCombo != 1) {
/* 1147 */         this.jComboBox1.setBackground(Color.RED);
/* 1148 */         JOptionPane.showMessageDialog(this.jDialog2, "Debes seleccionar primero el cliente para comenzar con una nueva tarifa", "Selecciona el Cliente", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1151 */         String valor = String.valueOf(this.jList1.getSelectedValue());
/* 1152 */         agregarArbol(valor);
/*      */       } 
/*      */     } else {
/*      */       
/* 1156 */       String valor = String.valueOf(this.jList1.getSelectedValue());
/* 1157 */       agregarArbol(valor);
/*      */     } 
/*      */   }
/*      */   public boolean estaCol(String col) {
/* 1161 */     for (int i = 0; i < this.COLUMNAS.length; i++) {
/* 1162 */       if (this.COLUMNAS[i].equals(col)) {
/* 1163 */         this.jComboBox1.setBackground(Color.RED);
/* 1164 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>El dato <font color='BLUE'><b>" + col + "</b></font> que seleccionaste ya se encuentra almacenado en la parte derecha<html>", "Valor Agregado", 0, this.ERROR);
/* 1165 */         return true;
/*      */       } 
/*      */     } 
/* 1168 */     return false;
/*      */   }
/*      */   public void agregarArbol(String dato) {
/* 1171 */     this.NODOS[this.INDCOL].setUserObject(dato);
/* 1172 */     this.COLUMNAS[this.INDCOL] = String.valueOf(this.jComboBox1.getSelectedItem());
/* 1173 */     if (this.INDCOL == 0) {
/* 1174 */       this.raiz.add(this.NODOS[this.INDCOL]);
/* 1175 */       this.jTree1.expandPath(this.jTree1.getPathForRow(0));
/*      */     } else {
/*      */       
/* 1178 */       this.NODOS[this.INDCOL - 1].add(this.NODOS[this.INDCOL]);
/* 1179 */       this.jTree1.expandPath(this.jTree1.getPathForRow(this.INDCOL));
/*      */     } 
/* 1181 */     this.INDCOL++;
/* 1182 */     this.jTree1.setLargeModel(true);
/* 1183 */     this.jTree1.setExpandsSelectedPaths(true);
/* 1184 */     this.jScrollPane2.setViewportView(this.jTree1);
/*      */   }
/*      */   public void TarifaViaje(String usu) {
/* 1187 */     this.USUARIO = usu;
/* 1188 */     this.panel.setViewportView(this);
/* 1189 */     consultar();
/* 1190 */     privilegios();
/*      */   }
/*      */   public void colorear() {
/* 1193 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1195 */             TarifaViaje.this.jTextGanado(TarifaViaje.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1198 */             TarifaViaje.this.jTextPerdido(TarifaViaje.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1201 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1203 */             TarifaViaje.this.jTextGanado(TarifaViaje.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1206 */             TarifaViaje.this.jTextPerdido(TarifaViaje.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1209 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1211 */             TarifaViaje.this.jTextGanado(TarifaViaje.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1214 */             TarifaViaje.this.jTextPerdido(TarifaViaje.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 1217 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1219 */             TarifaViaje.this.jTextGanado(TarifaViaje.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1222 */             TarifaViaje.this.jTextPerdido(TarifaViaje.this.jComboBox2, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1227 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1230 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void cargarInfo() {
/* 1234 */     this.con.consultar("count(clave_gene)", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by nombre_corto");
/* 1235 */     this.CLIENTES = this.con.regresaCol("nombre_corto", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by nombre_corto", Integer.parseInt(this.con.Campo));
/* 1236 */     this.jComboBox2.addItem("TODOS");
/* 1237 */     for (int i = 0; i < this.CLIENTES.length; i++) {
/* 1238 */       this.jComboBox2.addItem(this.CLIENTES[i]);
/*      */     }
/*      */     
/* 1241 */     this.con.consultar("count(distinct(servicio))", "guias", "order by servicio");
/* 1242 */     this.SERVICIOS = this.con.regresaCol("distinct(servicio)", "guias", "order by servicio", Integer.parseInt(this.con.Campo));
/*      */     
/* 1244 */     this.con.consultar("count(distinct(residuo))", "llamadas_historicas", "order by residuo");
/* 1245 */     this.RESIDUOS = this.con.regresaCol("distinct(residuo)", "llamadas_historicas", "order by residuo", Integer.parseInt(this.con.Campo));
/*      */     
/* 1247 */     this.con.consultar("count(distinct(nombreCorto))", "emp_destinataria", "order by nombreCorto");
/* 1248 */     this.DESTINOS = this.con.regresaCol("distinct(nombreCorto)", "emp_destinataria", "order by nombreCorto", Integer.parseInt(this.con.Campo));
/*      */     
/* 1250 */     this.con.consultar("count(distinct(tipo))", "guias", "order by tipo");
/* 1251 */     this.TIPOS = this.con.regresaCol("distinct(tipo)", "guias", "order by tipo", Integer.parseInt(this.con.Campo));
/*      */     
/* 1253 */     this.con.consultar("count(distinct(equipo))", "equipos", "order by equipo");
/* 1254 */     this.EQUIPOS = this.con.regresaCol("distinct(equipo)", "equipos", "order by equipo", Integer.parseInt(this.con.Campo));
/*      */     
/* 1256 */     this.con.consultar("count(distinct(nombre))", "pozos", "order by nombre");
/* 1257 */     this.POZOS = this.con.regresaCol("distinct(nombre)", "pozos", "order by nombre", Integer.parseInt(this.con.Campo));
/*      */ 
/*      */ 
/*      */     
/* 1261 */     Calendar ca = Calendar.getInstance();
/* 1262 */     Calendar fecha = Calendar.getInstance();
/* 1263 */     int aa = fecha.get(1);
/* 1264 */     int mm = fecha.get(2);
/* 1265 */     int dd = fecha.get(5);
/* 1266 */     mm++;
/* 1267 */     if (mm == 1) {
/* 1268 */       mm = 9;
/* 1269 */       aa--;
/*      */     }
/* 1271 */     else if (mm == 2) {
/* 1272 */       mm = 10;
/* 1273 */       aa--;
/*      */     }
/* 1275 */     else if (mm == 3) {
/* 1276 */       mm = 11;
/* 1277 */       aa--;
/*      */     } else {
/*      */       
/* 1280 */       mm -= 3;
/*      */     } 
/* 1282 */     this.con.consultar("count(distinct(num_GUIA))", "guias", "where fecha>'" + aa + "-" + mm + "-01' order by num_guia desc");
/* 1283 */     this.GUIAS = this.con.regresaCol("distinct(num_guia)", "guias", "where fecha>'" + aa + "-" + mm + "-01' order by num_guia desc", Integer.parseInt(this.con.Campo));
/*      */   }
/*      */   public void selecCol(String columna) {
/* 1286 */     if (columna.equals("Cliente")) {
/* 1287 */       this.jList1 = new JList<>(this.CLIENTES);
/*      */     }
/* 1289 */     else if (columna.equals("Guía")) {
/* 1290 */       this.jList1 = new JList<>(this.GUIAS);
/*      */     }
/* 1292 */     else if (columna.equals("Servicio")) {
/* 1293 */       this.jList1 = new JList<>(this.SERVICIOS);
/*      */     }
/* 1295 */     else if (columna.equals("Residuo")) {
/* 1296 */       this.jList1 = new JList<>(this.RESIDUOS);
/*      */     }
/* 1298 */     else if (columna.equals("Destino")) {
/* 1299 */       this.jList1 = new JList<>(this.DESTINOS);
/*      */     }
/* 1301 */     else if (columna.equals("Tipo de Vehículo")) {
/* 1302 */       this.jList1 = new JList<>(this.TIPOS);
/*      */     }
/* 1304 */     else if (columna.equals("Equipo")) {
/* 1305 */       this.jList1 = new JList<>(this.EQUIPOS);
/*      */     }
/* 1307 */     else if (columna.equals("Pozo")) {
/* 1308 */       this.jList1 = new JList<>(this.POZOS);
/*      */     } 
/* 1310 */     this.jList1.setFont(new Font("Tahoma", 0, 10));
/* 1311 */     this.jList1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1313 */             TarifaViaje.this.jList1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1316 */     this.jScrollPane3.setViewportView(this.jList1);
/*      */   }
/*      */   public void limpiar() {
/* 1319 */     this.jRadioButton1.setSelected(true);
/* 1320 */     this.jTextField1.setText("");
/* 1321 */     this.jTextField2.setText("");
/* 1322 */     this.jSpinner1.setValue(Integer.valueOf(5));
/* 1323 */     this.jComboBox1.setSelectedIndex(0);
/* 1324 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 1325 */     this.COLUMNAS = new String[] { "", "", "", "", "", "", "", "" };
/* 1326 */     this.INDCOL = 0;
/* 1327 */     this.NODOS = new DefaultMutableTreeNode[] { new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode(""), new DefaultMutableTreeNode("") };
/* 1328 */     this.raiz = new DefaultMutableTreeNode("Nueva Tarifa");
/* 1329 */     this.raiz2 = new DefaultMutableTreeNode("Nueva Tarifa");
/* 1330 */     this.jTree2.setModel(new DefaultTreeModel(this.raiz2));
/* 1331 */     this.jScrollPane4.setViewportView(this.jTree2);
/* 1332 */     this.jTree1.setModel(new DefaultTreeModel(this.raiz));
/* 1333 */     this.jScrollPane2.setViewportView(this.jTree1);
/* 1334 */     this.jLabel2.setText("$ MONTO");
/* 1335 */     this.jButton19.setText("Crear");
/*      */   }
/*      */   public void crearArbol(String conte) {
/* 1338 */     String[] columnas = { "", "", "", "", "", "", "", "", "", "" };
/* 1339 */     String[] info = { "", "", "", "", "", "", "", "", "", "" };
/* 1340 */     String[] datos = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 1341 */     int colum = 0;
/* 1342 */     int ren = 0;
/* 1343 */     int cont = 0; int i;
/* 1344 */     for (i = 0; i < conte.length(); i++) {
/* 1345 */       char letra = conte.charAt(i);
/* 1346 */       if (letra == '\n') {
/* 1347 */         colum++;
/*      */       } else {
/*      */         
/* 1350 */         datos[colum] = datos[colum] + datos[colum];
/*      */       } 
/*      */     } 
/* 1353 */     for (i = 0; i < colum; i++) {
/* 1354 */       char letra = datos[i].charAt(0);
/* 1355 */       if (letra != '<') {
/* 1356 */         info[ren] = datos[i];
/* 1357 */         ren++;
/*      */       }
/* 1359 */       else if (datos[i].charAt(1) != '/') {
/* 1360 */         columnas[cont] = datos[i].substring(1, datos[i].length() - 1);
/* 1361 */         cont++;
/*      */       } 
/*      */     } 
/* 1364 */     for (i = 0; i < columnas.length; i++) {
/* 1365 */       System.out.println("col: " + columnas[i] + " - " + info[i]);
/*      */     }
/* 1367 */     this.INDCOL = 0;
/* 1368 */     for (i = 0; i < cont; i++) {
/* 1369 */       this.NODOS[this.INDCOL].setUserObject(columnas[i] + " {" + columnas[i] + "}");
/* 1370 */       this.raiz2.setUserObject("Tarifa Núm - " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1371 */       if (this.INDCOL == 0) {
/* 1372 */         this.raiz2.add(this.NODOS[this.INDCOL]);
/* 1373 */         this.jTree2.expandPath(this.jTree2.getPathForRow(0));
/*      */       } else {
/*      */         
/* 1376 */         this.NODOS[this.INDCOL - 1].add(this.NODOS[this.INDCOL]);
/* 1377 */         this.jTree2.expandPath(this.jTree2.getPathForRow(this.INDCOL));
/*      */       } 
/* 1379 */       this.INDCOL++;
/*      */     } 
/* 1381 */     this.NODOS[this.INDCOL - 1].add(new DefaultMutableTreeNode(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4)));
/* 1382 */     this.jTree2.expandPath(this.jTree2.getPathForRow(this.INDCOL));
/* 1383 */     if (this.jButton19.getText().equals("Modificar")) {
/* 1384 */       this.jScrollPane2.setViewportView(this.jTree2);
/*      */     } else {
/*      */       
/* 1387 */       this.jScrollPane4.setViewportView(this.jTree2);
/*      */     } 
/*      */   }
/*      */   
/* 1391 */   public class CeldaRender extends DefaultTableCellRenderer { String[] indices = new String[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1393 */       setEnabled((table == null || table.isEnabled()));
/* 1394 */       setHorizontalAlignment(4);
/* 1395 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1396 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TarifaViaje.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */