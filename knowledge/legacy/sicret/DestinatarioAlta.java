/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.NumberFormat;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import principal.MaterialButton;
/*      */ 
/*      */ public class DestinatarioAlta extends JPanel {
/*   26 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   27 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   28 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   29 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   30 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   34 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   35 */   Date fechaActual = new Date();
/*   36 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   37 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   39 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   40 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   43 */   Consultas con = new Consultas();
/*      */   String[] inf;
/*   45 */   cargarDatos datos = new cargarDatos("DestinatarioAlta");
/*      */   
/*      */   Color fondo;
/*      */   
/*      */   JTable jTable3;
/*      */   boolean encontrado = false;
/*   51 */   int INDICE = 0;
/*   52 */   Errores error = new Errores(false);
/*   53 */   Validaciones val = new Validaciones();
/*   54 */   Date fecha = null;
/*   55 */   MensajePop mensajeTry = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JButton jButton5; private JButton jButton6; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JDialog jDialog1; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14;
/*   56 */   SColores lc = new SColores(); private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5;
/*      */   
/*      */   public DestinatarioAlta(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry) {
/*   59 */     this.mensajeTry = mensajeTry;
/*   60 */     this.USUARIO = usua;
/*   61 */     this.padre = padre;
/*   62 */     this.fichas = fichas;
/*   63 */     this.id = num;
/*   64 */     this.jTable3 = Tabla;
/*      */     try {
/*   66 */       this.formaTel = new MaskFormatter("###-###-####");
/*   67 */     } catch (Exception exception) {}
/*      */     
/*   69 */     this.formaTel.setPlaceholderCharacter('_');
/*   70 */     initComponents();
/*   71 */     panelito.setViewportView(this);
/*   72 */     this.panel = panelito;
/*   73 */     colorear();
/*   74 */     this.jLabel14.setVisible(false);
/*   75 */     crearInd();
/*   76 */     this.materialButton25.setVisible(false);
/*   77 */     this.materialButton24.setVisible(false);
/*      */     
/*   79 */     int w = this.tama.width;
/*   80 */     int h = this.tama.height;
/*   81 */     int rw = (w - 320) / 2;
/*   82 */     int rh = (h - 325) / 2;
/*   83 */     this.jDialog1.setLocation(rw, rh);
/*   84 */     this.jDialog1.setSize(320, 325);
/*   85 */     this.jDialog1.setVisible(false);
/*   86 */     this.jDialog1.setResizable(false);
/*   87 */     this.buttonGroup1.add(this.jRadioButton1);
/*   88 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*   90 */     this.buttonGroup2.add(this.jRadioButton3);
/*   91 */     this.buttonGroup2.add(this.jRadioButton4);
/*   92 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   93 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   94 */     this.jDialog1.setCursor(micursor);
/*      */     
/*   96 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*   97 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*   98 */     editFormat.setGroupingUsed(false);
/*   99 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  100 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  101 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  102 */     DefaultFormatterFactory currFactory2 = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  103 */     enFormat.setAllowsInvalid(true);
/*  104 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  105 */     this.jFormattedTextField2.setValue(Double.valueOf(0.0D));
/*  106 */     this.jFormattedTextField3.setFormatterFactory(currFactory2);
/*  107 */     this.jFormattedTextField3.setValue(Double.valueOf(0.0D));
/*      */     
/*  109 */     if (fichas != null) {
/*  110 */       fichas.addTab("Modificar Empresa Destinatario - [Clave: " + this.id + "]", this.panel);
/*  111 */       this.materialButton23.setText("Modificar");
/*  112 */       this.jLabel1.setText("Modificar Empresa Destinatario");
/*  113 */       this.materialButton24.setVisible(true);
/*  114 */       this.materialButton25.setVisible(true);
/*  115 */       cargarFormulario();
/*      */     } 
/*      */   }
/*      */   private JLabel jLabel6; private JLabel jLabel9; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JSeparator jSeparator1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton22; private MaterialButton materialButton23; private MaterialButton materialButton24;
/*      */   private MaterialButton materialButton25;
/*      */   
/*      */   private void initComponents() {
/*  122 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  123 */     this.jPanel6 = new JPanel();
/*  124 */     this.jLabel3 = new JLabel();
/*  125 */     this.jSeparator1 = new JSeparator();
/*  126 */     this.jLabel4 = new JLabel();
/*  127 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  128 */     this.jLabel5 = new JLabel();
/*  129 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  130 */     this.jButton6 = new JButton();
/*  131 */     this.jRadioButton1 = new JRadioButton();
/*  132 */     this.jRadioButton2 = new JRadioButton();
/*  133 */     this.jRadioButton3 = new JRadioButton();
/*  134 */     this.jRadioButton4 = new JRadioButton();
/*  135 */     this.jCheckBox1 = new JCheckBox();
/*  136 */     this.jLabel6 = new JLabel();
/*  137 */     this.jTextField16 = new JTextField();
/*  138 */     this.buttonGroup1 = new ButtonGroup();
/*  139 */     this.buttonGroup2 = new ButtonGroup();
/*  140 */     this.jPanel5 = new JPanel();
/*  141 */     this.jPanel7 = new JPanel();
/*  142 */     this.jLabel1 = new JLabel();
/*  143 */     this.jLabel14 = new JLabel();
/*  144 */     this.jPanel8 = new JPanel();
/*  145 */     this.jLabel13 = new JLabel();
/*  146 */     this.jTextField1 = new JTextField();
/*  147 */     this.jLabel12 = new JLabel();
/*  148 */     this.jTextField2 = new JTextField();
/*  149 */     this.jLabel26 = new JLabel();
/*  150 */     this.jTextField15 = new JTextField();
/*  151 */     this.jLabel11 = new JLabel();
/*  152 */     this.jTextField3 = new JTextField();
/*  153 */     this.jLabel9 = new JLabel();
/*  154 */     this.jTextField4 = new JTextField();
/*  155 */     this.jLabel10 = new JLabel();
/*  156 */     this.jTextField5 = new JTextField();
/*  157 */     this.jLabel15 = new JLabel();
/*  158 */     this.jTextField6 = new JTextField();
/*  159 */     this.jLabel17 = new JLabel();
/*  160 */     this.jTextField7 = new JTextField();
/*  161 */     this.jLabel18 = new JLabel();
/*  162 */     this.jComboBox1 = new JComboBox();
/*  163 */     this.jLabel21 = new JLabel();
/*  164 */     this.jTextField8 = new JTextField();
/*  165 */     this.jLabel19 = new JLabel();
/*  166 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  167 */     this.jLabel16 = new JLabel();
/*  168 */     this.jTextField9 = new JTextField();
/*  169 */     this.jLabel20 = new JLabel();
/*  170 */     this.jTextField10 = new JTextField();
/*  171 */     this.jLabel24 = new JLabel();
/*  172 */     this.jTextField13 = new JTextField();
/*  173 */     this.jLabel25 = new JLabel();
/*  174 */     this.jTextField14 = new JTextField();
/*  175 */     this.jLabel22 = new JLabel();
/*  176 */     this.jTextField11 = new JTextField();
/*  177 */     this.jLabel23 = new JLabel();
/*  178 */     this.jTextField12 = new JTextField();
/*  179 */     this.jButton5 = new JButton();
/*  180 */     this.jPanel9 = new JPanel();
/*  181 */     this.materialButton23 = new MaterialButton();
/*  182 */     this.materialButton22 = new MaterialButton();
/*  183 */     this.materialButton24 = new MaterialButton();
/*  184 */     this.materialButton25 = new MaterialButton();
/*      */     
/*  186 */     this.jDialog1.setTitle("Cantidades Liquidaciones");
/*  187 */     this.jDialog1.setModal(true);
/*      */     
/*  189 */     this.jLabel3.setFont(new Font("Cantarell", 1, 13));
/*  190 */     this.jLabel3.setForeground(this.lc.PRIMARIO2);
/*  191 */     this.jLabel3.setHorizontalAlignment(0);
/*  192 */     this.jLabel3.setText("LISTA DE CANTIDADES");
/*      */     
/*  194 */     this.jLabel4.setText("Cant. por Viaje");
/*      */     
/*  196 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*  197 */     this.jFormattedTextField2.setFont(new Font("Tahoma", 1, 11));
/*      */     
/*  199 */     this.jLabel5.setText("Cant. por Tonelada");
/*      */     
/*  201 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*  202 */     this.jFormattedTextField3.setFont(new Font("Tahoma", 1, 11));
/*      */     
/*  204 */     this.jButton6.setText("Cerrar");
/*  205 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  207 */             DestinatarioAlta.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  211 */     this.jRadioButton1.setSelected(true);
/*  212 */     this.jRadioButton1.setText("Viaje");
/*      */     
/*  214 */     this.jRadioButton2.setText("Toneladas");
/*      */     
/*  216 */     this.jRadioButton3.setSelected(true);
/*  217 */     this.jRadioButton3.setText("Local");
/*      */     
/*  219 */     this.jRadioButton4.setText("Foraneo");
/*      */     
/*  221 */     this.jCheckBox1.setText("Es Pozo");
/*      */     
/*  223 */     this.jLabel6.setText("Kilometros");
/*      */     
/*  225 */     this.jTextField16.setHorizontalAlignment(4);
/*  226 */     this.jTextField16.setText("0");
/*      */     
/*  228 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  229 */     this.jPanel6.setLayout(jPanel6Layout);
/*  230 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  231 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  232 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  233 */           .addContainerGap()
/*  234 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  235 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  236 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  237 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/*  238 */                   .addGap(115, 115, 115)
/*  239 */                   .addComponent(this.jRadioButton4, -2, 111, -2))
/*  240 */                 .addComponent(this.jRadioButton3, -2, 83, -2)
/*  241 */                 .addComponent(this.jLabel3, -2, 285, -2)
/*  242 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  243 */                   .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  244 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  245 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  246 */                       .addComponent(this.jLabel5, -2, 106, 32767)
/*  247 */                       .addComponent(this.jLabel4, -1, -1, 32767))
/*  248 */                     .addGap(9, 9, 9)
/*  249 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  250 */                       .addComponent(this.jFormattedTextField3, -2, 164, -2)
/*  251 */                       .addComponent(this.jFormattedTextField2)
/*  252 */                       .addComponent(this.jRadioButton2, -2, 111, -2)
/*  253 */                       .addComponent(this.jButton6, GroupLayout.Alignment.TRAILING, -2, 84, -2))))
/*  254 */                 .addComponent(this.jRadioButton1, -2, 83, -2)
/*  255 */                 .addComponent(this.jCheckBox1, -2, 141, -2))
/*  256 */               .addContainerGap(-1, 32767))
/*  257 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  258 */               .addComponent(this.jLabel6, -1, -1, 32767)
/*  259 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  260 */               .addComponent(this.jTextField16, -2, 110, -2)
/*  261 */               .addGap(69, 69, 69)))));
/*      */     
/*  263 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  265 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  266 */           .addContainerGap()
/*  267 */           .addComponent(this.jLabel3)
/*  268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  269 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  270 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  271 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  272 */             .addComponent(this.jLabel4)
/*  273 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/*  274 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  275 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  276 */             .addComponent(this.jLabel5)
/*  277 */             .addComponent(this.jFormattedTextField3, -2, -1, -2))
/*  278 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  279 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  280 */             .addComponent(this.jRadioButton1)
/*  281 */             .addComponent(this.jRadioButton2))
/*  282 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  283 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  284 */             .addComponent(this.jRadioButton3)
/*  285 */             .addComponent(this.jRadioButton4))
/*  286 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  287 */           .addComponent(this.jCheckBox1)
/*  288 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  289 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  290 */             .addComponent(this.jLabel6)
/*  291 */             .addComponent(this.jTextField16, -2, -1, -2))
/*  292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/*  293 */           .addComponent(this.jButton6)
/*  294 */           .addContainerGap()));
/*      */ 
/*      */     
/*  297 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  298 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  299 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  301 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/*  303 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  304 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  305 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/*  308 */     this.jPanel5.setBackground(this.lc.TERCERO1);
/*  309 */     this.jPanel5.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  311 */     this.jPanel7.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  313 */     this.jLabel1.setFont(new Font("Cantarell", 1, 22));
/*  314 */     this.jLabel1.setForeground(this.lc.PRIMARIO2);
/*  315 */     this.jLabel1.setHorizontalAlignment(0);
/*  316 */     this.jLabel1.setText("     Agregar Destinos");
/*      */     
/*  318 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  319 */     this.jLabel14.setToolTipText("Cerrar");
/*  320 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  322 */             DestinatarioAlta.this.jLabel14MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  325 */             DestinatarioAlta.this.jLabel14MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  328 */             DestinatarioAlta.this.jLabel14MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  332 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  333 */     this.jPanel7.setLayout(jPanel7Layout);
/*  334 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  336 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  337 */           .addContainerGap()
/*  338 */           .addComponent(this.jLabel1, -1, -1, 32767)
/*  339 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  340 */           .addComponent(this.jLabel14)
/*  341 */           .addContainerGap()));
/*      */     
/*  343 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  345 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  346 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  347 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  348 */               .addContainerGap()
/*  349 */               .addComponent(this.jLabel1, -1, -1, 32767))
/*  350 */             .addComponent(this.jLabel14, -1, -1, 32767))
/*  351 */           .addContainerGap()));
/*      */ 
/*      */     
/*  354 */     this.jPanel8.setBackground(this.lc.TERCERO1);
/*  355 */     GridBagLayout jPanel8Layout = new GridBagLayout();
/*  356 */     jPanel8Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  357 */     jPanel8Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  358 */     this.jPanel8.setLayout(jPanel8Layout);
/*      */     
/*  360 */     this.jLabel13.setFont(new Font("Cantarell", 1, 11));
/*  361 */     this.jLabel13.setText("Clave");
/*  362 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  363 */     gridBagConstraints.gridx = 2;
/*  364 */     gridBagConstraints.gridy = 0;
/*  365 */     gridBagConstraints.anchor = 17;
/*  366 */     this.jPanel8.add(this.jLabel13, gridBagConstraints);
/*      */     
/*  368 */     this.jTextField1.setEditable(false);
/*  369 */     this.jTextField1.setFont(new Font("Tahoma", 1, 12));
/*  370 */     this.jTextField1.setForeground(Color.red);
/*  371 */     this.jTextField1.setText(" ");
/*  372 */     gridBagConstraints = new GridBagConstraints();
/*  373 */     gridBagConstraints.gridx = 4;
/*  374 */     gridBagConstraints.gridy = 0;
/*  375 */     gridBagConstraints.gridwidth = 7;
/*  376 */     gridBagConstraints.fill = 1;
/*  377 */     gridBagConstraints.ipady = 1;
/*  378 */     gridBagConstraints.anchor = 23;
/*  379 */     this.jPanel8.add(this.jTextField1, gridBagConstraints);
/*      */     
/*  381 */     this.jLabel12.setFont(new Font("Cantarell", 1, 11));
/*  382 */     this.jLabel12.setText("Nombre o Razón social");
/*  383 */     gridBagConstraints = new GridBagConstraints();
/*  384 */     gridBagConstraints.gridx = 2;
/*  385 */     gridBagConstraints.gridy = 2;
/*  386 */     gridBagConstraints.anchor = 17;
/*  387 */     this.jPanel8.add(this.jLabel12, gridBagConstraints);
/*      */     
/*  389 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  391 */             DestinatarioAlta.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*  394 */     gridBagConstraints = new GridBagConstraints();
/*  395 */     gridBagConstraints.gridx = 4;
/*  396 */     gridBagConstraints.gridy = 2;
/*  397 */     gridBagConstraints.gridwidth = 19;
/*  398 */     gridBagConstraints.fill = 1;
/*  399 */     gridBagConstraints.ipady = 1;
/*  400 */     this.jPanel8.add(this.jTextField2, gridBagConstraints);
/*      */     
/*  402 */     this.jLabel26.setFont(new Font("Cantarell", 1, 11));
/*  403 */     this.jLabel26.setText("Nombre Corto");
/*  404 */     gridBagConstraints = new GridBagConstraints();
/*  405 */     gridBagConstraints.gridx = 2;
/*  406 */     gridBagConstraints.gridy = 4;
/*  407 */     gridBagConstraints.anchor = 17;
/*  408 */     this.jPanel8.add(this.jLabel26, gridBagConstraints);
/*  409 */     gridBagConstraints = new GridBagConstraints();
/*  410 */     gridBagConstraints.gridx = 4;
/*  411 */     gridBagConstraints.gridy = 4;
/*  412 */     gridBagConstraints.gridwidth = 7;
/*  413 */     gridBagConstraints.fill = 1;
/*  414 */     gridBagConstraints.weightx = 10.0D;
/*  415 */     this.jPanel8.add(this.jTextField15, gridBagConstraints);
/*      */     
/*  417 */     this.jLabel11.setFont(new Font("Cantarell", 1, 11));
/*  418 */     this.jLabel11.setText("Calle");
/*  419 */     gridBagConstraints = new GridBagConstraints();
/*  420 */     gridBagConstraints.gridx = 2;
/*  421 */     gridBagConstraints.gridy = 6;
/*  422 */     gridBagConstraints.anchor = 17;
/*  423 */     this.jPanel8.add(this.jLabel11, gridBagConstraints);
/*      */     
/*  425 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  427 */             DestinatarioAlta.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  430 */     gridBagConstraints = new GridBagConstraints();
/*  431 */     gridBagConstraints.gridx = 4;
/*  432 */     gridBagConstraints.gridy = 6;
/*  433 */     gridBagConstraints.gridwidth = 7;
/*  434 */     gridBagConstraints.fill = 1;
/*  435 */     gridBagConstraints.weightx = 10.0D;
/*  436 */     this.jPanel8.add(this.jTextField3, gridBagConstraints);
/*      */     
/*  438 */     this.jLabel9.setFont(new Font("Cantarell", 1, 11));
/*  439 */     this.jLabel9.setText("Número");
/*  440 */     gridBagConstraints = new GridBagConstraints();
/*  441 */     gridBagConstraints.gridx = 12;
/*  442 */     gridBagConstraints.gridy = 6;
/*  443 */     gridBagConstraints.anchor = 17;
/*  444 */     this.jPanel8.add(this.jLabel9, gridBagConstraints);
/*      */     
/*  446 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  448 */             DestinatarioAlta.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*  451 */     gridBagConstraints = new GridBagConstraints();
/*  452 */     gridBagConstraints.gridx = 14;
/*  453 */     gridBagConstraints.gridy = 6;
/*  454 */     gridBagConstraints.gridwidth = 9;
/*  455 */     gridBagConstraints.fill = 2;
/*  456 */     this.jPanel8.add(this.jTextField4, gridBagConstraints);
/*      */     
/*  458 */     this.jLabel10.setFont(new Font("Cantarell", 0, 11));
/*  459 */     this.jLabel10.setHorizontalAlignment(4);
/*  460 */     this.jLabel10.setText("Colonia");
/*  461 */     gridBagConstraints = new GridBagConstraints();
/*  462 */     gridBagConstraints.gridx = 2;
/*  463 */     gridBagConstraints.gridy = 8;
/*  464 */     gridBagConstraints.anchor = 17;
/*  465 */     this.jPanel8.add(this.jLabel10, gridBagConstraints);
/*  466 */     gridBagConstraints = new GridBagConstraints();
/*  467 */     gridBagConstraints.gridx = 4;
/*  468 */     gridBagConstraints.gridy = 8;
/*  469 */     gridBagConstraints.gridwidth = 19;
/*  470 */     gridBagConstraints.fill = 1;
/*  471 */     this.jPanel8.add(this.jTextField5, gridBagConstraints);
/*      */     
/*  473 */     this.jLabel15.setFont(new Font("Cantarell", 1, 11));
/*  474 */     this.jLabel15.setText("CP ");
/*  475 */     gridBagConstraints = new GridBagConstraints();
/*  476 */     gridBagConstraints.gridx = 2;
/*  477 */     gridBagConstraints.gridy = 12;
/*  478 */     gridBagConstraints.anchor = 17;
/*  479 */     this.jPanel8.add(this.jLabel15, gridBagConstraints);
/*      */     
/*  481 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  483 */             DestinatarioAlta.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*  486 */     gridBagConstraints = new GridBagConstraints();
/*  487 */     gridBagConstraints.gridx = 4;
/*  488 */     gridBagConstraints.gridy = 12;
/*  489 */     gridBagConstraints.gridwidth = 7;
/*  490 */     gridBagConstraints.fill = 2;
/*  491 */     gridBagConstraints.weightx = 1.0D;
/*  492 */     this.jPanel8.add(this.jTextField6, gridBagConstraints);
/*      */     
/*  494 */     this.jLabel17.setFont(new Font("Cantarell", 1, 11));
/*  495 */     this.jLabel17.setText("Ciudad ");
/*  496 */     gridBagConstraints = new GridBagConstraints();
/*  497 */     gridBagConstraints.gridx = 2;
/*  498 */     gridBagConstraints.gridy = 10;
/*  499 */     gridBagConstraints.anchor = 17;
/*  500 */     this.jPanel8.add(this.jLabel17, gridBagConstraints);
/*      */     
/*  502 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  504 */             DestinatarioAlta.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*  507 */     gridBagConstraints = new GridBagConstraints();
/*  508 */     gridBagConstraints.gridx = 4;
/*  509 */     gridBagConstraints.gridy = 10;
/*  510 */     gridBagConstraints.gridwidth = 7;
/*  511 */     gridBagConstraints.fill = 2;
/*  512 */     this.jPanel8.add(this.jTextField7, gridBagConstraints);
/*      */     
/*  514 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/*  515 */     this.jLabel18.setHorizontalAlignment(4);
/*  516 */     this.jLabel18.setText("Estado");
/*  517 */     gridBagConstraints = new GridBagConstraints();
/*  518 */     gridBagConstraints.gridx = 12;
/*  519 */     gridBagConstraints.gridy = 10;
/*  520 */     gridBagConstraints.anchor = 17;
/*  521 */     this.jPanel8.add(this.jLabel18, gridBagConstraints);
/*      */     
/*  523 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  524 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/*  525 */     gridBagConstraints = new GridBagConstraints();
/*  526 */     gridBagConstraints.gridx = 14;
/*  527 */     gridBagConstraints.gridy = 10;
/*  528 */     gridBagConstraints.gridwidth = 9;
/*  529 */     gridBagConstraints.fill = 2;
/*  530 */     this.jPanel8.add(this.jComboBox1, gridBagConstraints);
/*      */     
/*  532 */     this.jLabel21.setFont(new Font("Cantarell", 1, 11));
/*  533 */     this.jLabel21.setText("RFC");
/*  534 */     gridBagConstraints = new GridBagConstraints();
/*  535 */     gridBagConstraints.gridx = 12;
/*  536 */     gridBagConstraints.gridy = 12;
/*  537 */     gridBagConstraints.anchor = 17;
/*  538 */     this.jPanel8.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  540 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  542 */             DestinatarioAlta.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*  545 */     gridBagConstraints = new GridBagConstraints();
/*  546 */     gridBagConstraints.gridx = 14;
/*  547 */     gridBagConstraints.gridy = 12;
/*  548 */     gridBagConstraints.gridwidth = 9;
/*  549 */     gridBagConstraints.fill = 2;
/*  550 */     gridBagConstraints.anchor = 256;
/*  551 */     gridBagConstraints.weightx = 1.0D;
/*  552 */     this.jPanel8.add(this.jTextField8, gridBagConstraints);
/*      */     
/*  554 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/*  555 */     this.jLabel19.setText("Teléfono");
/*  556 */     gridBagConstraints = new GridBagConstraints();
/*  557 */     gridBagConstraints.gridx = 12;
/*  558 */     gridBagConstraints.gridy = 18;
/*  559 */     gridBagConstraints.anchor = 17;
/*  560 */     this.jPanel8.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  562 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  564 */             DestinatarioAlta.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  567 */     gridBagConstraints = new GridBagConstraints();
/*  568 */     gridBagConstraints.gridx = 14;
/*  569 */     gridBagConstraints.gridy = 18;
/*  570 */     gridBagConstraints.gridwidth = 9;
/*  571 */     gridBagConstraints.fill = 2;
/*  572 */     this.jPanel8.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/*  574 */     this.jLabel16.setFont(new Font("Cantarell", 1, 11));
/*  575 */     this.jLabel16.setText("Monto a Cobrar ");
/*  576 */     gridBagConstraints = new GridBagConstraints();
/*  577 */     gridBagConstraints.gridx = 2;
/*  578 */     gridBagConstraints.gridy = 14;
/*  579 */     gridBagConstraints.anchor = 17;
/*  580 */     this.jPanel8.add(this.jLabel16, gridBagConstraints);
/*      */     
/*  582 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  584 */             DestinatarioAlta.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*  587 */     gridBagConstraints = new GridBagConstraints();
/*  588 */     gridBagConstraints.gridx = 4;
/*  589 */     gridBagConstraints.gridy = 14;
/*  590 */     gridBagConstraints.gridwidth = 7;
/*  591 */     gridBagConstraints.fill = 2;
/*  592 */     gridBagConstraints.weightx = 1.0D;
/*  593 */     this.jPanel8.add(this.jTextField9, gridBagConstraints);
/*      */     
/*  595 */     this.jLabel20.setFont(new Font("Cantarell", 1, 11));
/*  596 */     this.jLabel20.setText("Cantidad con letra");
/*  597 */     gridBagConstraints = new GridBagConstraints();
/*  598 */     gridBagConstraints.gridx = 12;
/*  599 */     gridBagConstraints.gridy = 14;
/*  600 */     gridBagConstraints.anchor = 17;
/*  601 */     this.jPanel8.add(this.jLabel20, gridBagConstraints);
/*  602 */     gridBagConstraints = new GridBagConstraints();
/*  603 */     gridBagConstraints.gridx = 14;
/*  604 */     gridBagConstraints.gridy = 14;
/*  605 */     gridBagConstraints.gridwidth = 9;
/*  606 */     gridBagConstraints.fill = 2;
/*  607 */     gridBagConstraints.weightx = 0.2D;
/*  608 */     this.jPanel8.add(this.jTextField10, gridBagConstraints);
/*      */     
/*  610 */     this.jLabel24.setFont(new Font("Cantarell", 1, 11));
/*  611 */     this.jLabel24.setText("L.A.U.");
/*  612 */     gridBagConstraints = new GridBagConstraints();
/*  613 */     gridBagConstraints.gridx = 2;
/*  614 */     gridBagConstraints.gridy = 16;
/*  615 */     gridBagConstraints.anchor = 17;
/*  616 */     this.jPanel8.add(this.jLabel24, gridBagConstraints);
/*      */     
/*  618 */     this.jTextField13.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  620 */             DestinatarioAlta.this.jTextField13KeyReleased(evt);
/*      */           }
/*      */         });
/*  623 */     gridBagConstraints = new GridBagConstraints();
/*  624 */     gridBagConstraints.gridx = 4;
/*  625 */     gridBagConstraints.gridy = 16;
/*  626 */     gridBagConstraints.gridwidth = 7;
/*  627 */     gridBagConstraints.fill = 2;
/*  628 */     gridBagConstraints.weightx = 1.0D;
/*  629 */     this.jPanel8.add(this.jTextField13, gridBagConstraints);
/*      */     
/*  631 */     this.jLabel25.setFont(new Font("Cantarell", 0, 11));
/*  632 */     this.jLabel25.setText("Báscula Ceritficada");
/*  633 */     gridBagConstraints = new GridBagConstraints();
/*  634 */     gridBagConstraints.gridx = 12;
/*  635 */     gridBagConstraints.gridy = 16;
/*  636 */     gridBagConstraints.anchor = 17;
/*  637 */     this.jPanel8.add(this.jLabel25, gridBagConstraints);
/*  638 */     gridBagConstraints = new GridBagConstraints();
/*  639 */     gridBagConstraints.gridx = 14;
/*  640 */     gridBagConstraints.gridy = 16;
/*  641 */     gridBagConstraints.gridwidth = 9;
/*  642 */     gridBagConstraints.fill = 2;
/*  643 */     gridBagConstraints.weightx = 0.2D;
/*  644 */     this.jPanel8.add(this.jTextField14, gridBagConstraints);
/*      */     
/*  646 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/*  647 */     this.jLabel22.setText("Aut. SEMARNAT ");
/*  648 */     gridBagConstraints = new GridBagConstraints();
/*  649 */     gridBagConstraints.gridx = 2;
/*  650 */     gridBagConstraints.gridy = 18;
/*  651 */     gridBagConstraints.anchor = 17;
/*  652 */     this.jPanel8.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  654 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  656 */             DestinatarioAlta.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*  659 */     gridBagConstraints = new GridBagConstraints();
/*  660 */     gridBagConstraints.gridx = 4;
/*  661 */     gridBagConstraints.gridy = 18;
/*  662 */     gridBagConstraints.gridwidth = 7;
/*  663 */     gridBagConstraints.fill = 2;
/*  664 */     gridBagConstraints.weightx = 1.0D;
/*  665 */     this.jPanel8.add(this.jTextField11, gridBagConstraints);
/*      */     
/*  667 */     this.jLabel23.setFont(new Font("Cantarell", 0, 11));
/*  668 */     this.jLabel23.setText("Ruta");
/*  669 */     gridBagConstraints = new GridBagConstraints();
/*  670 */     gridBagConstraints.gridx = 2;
/*  671 */     gridBagConstraints.gridy = 20;
/*  672 */     gridBagConstraints.anchor = 17;
/*  673 */     this.jPanel8.add(this.jLabel23, gridBagConstraints);
/*      */     
/*  675 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  677 */             DestinatarioAlta.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*  680 */     gridBagConstraints = new GridBagConstraints();
/*  681 */     gridBagConstraints.gridx = 4;
/*  682 */     gridBagConstraints.gridy = 20;
/*  683 */     gridBagConstraints.gridwidth = 19;
/*  684 */     gridBagConstraints.fill = 2;
/*  685 */     this.jPanel8.add(this.jTextField12, gridBagConstraints);
/*      */     
/*  687 */     this.jButton5.setText("Cant Liquidaciones");
/*  688 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  690 */             DestinatarioAlta.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  693 */     gridBagConstraints = new GridBagConstraints();
/*  694 */     gridBagConstraints.gridx = 4;
/*  695 */     gridBagConstraints.gridy = 22;
/*  696 */     this.jPanel8.add(this.jButton5, gridBagConstraints);
/*      */     
/*  698 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  700 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/*  701 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/*  702 */     this.materialButton23.setMnemonic('G');
/*  703 */     this.materialButton23.setText("Guardar");
/*  704 */     this.materialButton23.setToolTipText("Guardar (Alt+G)");
/*  705 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/*  706 */     this.materialButton23.setHorizontalTextPosition(0);
/*  707 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  709 */             DestinatarioAlta.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  713 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/*  714 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  715 */     this.materialButton22.setMnemonic('L');
/*  716 */     this.materialButton22.setText("Limpiar");
/*  717 */     this.materialButton22.setToolTipText("Limpiar (Alt+L)");
/*  718 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  719 */     this.materialButton22.setHorizontalTextPosition(0);
/*  720 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  722 */             DestinatarioAlta.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  726 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/*  727 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/*  728 */     this.materialButton24.setMnemonic('R');
/*  729 */     this.materialButton24.setText("Restablecer");
/*  730 */     this.materialButton24.setToolTipText("Restablecer (Alt+R)");
/*  731 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/*  732 */     this.materialButton24.setHorizontalTextPosition(0);
/*  733 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  735 */             DestinatarioAlta.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  739 */     this.materialButton25.setBackground(this.lc.SECUNDARIO1);
/*  740 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/*  741 */     this.materialButton25.setMnemonic('C');
/*  742 */     this.materialButton25.setText("Cerrar");
/*  743 */     this.materialButton25.setToolTipText("Cerrar (Alt+C)");
/*  744 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/*  745 */     this.materialButton25.setHorizontalTextPosition(0);
/*  746 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  748 */             DestinatarioAlta.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  752 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  753 */     this.jPanel9.setLayout(jPanel9Layout);
/*  754 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  755 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  756 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  757 */           .addContainerGap(-1, 32767)
/*  758 */           .addComponent((Component)this.materialButton25, -2, 105, -2)
/*  759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  760 */           .addComponent((Component)this.materialButton24, -2, 105, -2)
/*  761 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  762 */           .addComponent((Component)this.materialButton23, -2, 150, -2)
/*  763 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  764 */           .addComponent((Component)this.materialButton22, -2, 105, -2)));
/*      */     
/*  766 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  767 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  768 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  769 */           .addComponent((Component)this.materialButton24, -2, 38, -2)
/*  770 */           .addComponent((Component)this.materialButton25, -2, 38, -2))
/*  771 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  772 */           .addComponent((Component)this.materialButton22, -2, 38, -2)
/*  773 */           .addComponent((Component)this.materialButton23, -2, 38, -2)));
/*      */ 
/*      */     
/*  776 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  777 */     this.jPanel5.setLayout(jPanel5Layout);
/*  778 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  780 */         .addComponent(this.jPanel7, -1, -1, 32767)
/*  781 */         .addComponent(this.jPanel8, -1, 889, 32767)
/*  782 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  784 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  785 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  786 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  787 */           .addComponent(this.jPanel7, -2, -1, -2)
/*  788 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  789 */           .addComponent(this.jPanel8, -2, 405, -2)
/*  790 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  791 */           .addComponent(this.jPanel9, -2, -1, -2)));
/*      */ 
/*      */     
/*  794 */     GroupLayout layout = new GroupLayout(this);
/*  795 */     setLayout(layout);
/*  796 */     layout.setHorizontalGroup(layout
/*  797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  798 */         .addGap(0, 903, 32767)
/*  799 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  800 */           .addGroup(layout.createSequentialGroup()
/*  801 */             .addGap(0, 0, 32767)
/*  802 */             .addComponent(this.jPanel5, -2, -1, -2)
/*  803 */             .addGap(0, 0, 32767))));
/*      */     
/*  805 */     layout.setVerticalGroup(layout
/*  806 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  807 */         .addGap(0, 521, 32767)
/*  808 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  809 */           .addGroup(layout.createSequentialGroup()
/*  810 */             .addGap(0, 0, 32767)
/*  811 */             .addComponent(this.jPanel5, -2, -1, -2)
/*  812 */             .addGap(0, 0, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/*  817 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  818 */     this.fichas.remove(1);
/*  819 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseEntered(MouseEvent evt) {
/*  823 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel14MouseExited(MouseEvent evt) {
/*  827 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/*  831 */     int cont = 0;
/*  832 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/*  833 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/*  834 */       this.jFormattedTextField1.setValue("");
/*  835 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/*  836 */       String cadena = this.jFormattedTextField1.getText();
/*  837 */       String cad1 = cadena.substring(0, 3);
/*  838 */       String cad2 = cadena.substring(4, 7);
/*  839 */       String cad3 = cadena.substring(8, 12);
/*  840 */       String tel = cad1 + cad1 + cad2;
/*  841 */       for (int i = 1; i < tel.length(); i++) {
/*  842 */         char c = tel.charAt(i - 1);
/*  843 */         char d = tel.charAt(i);
/*  844 */         if (c != d) {
/*  845 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/*  849 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/*  850 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/*  851 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  856 */     if (!this.jTextField2.getText().isEmpty()) {
/*  857 */       this.datos.escribir();
/*  858 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  859 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  864 */     if (!this.jTextField3.getText().isEmpty()) {
/*  865 */       this.datos.escribir();
/*  866 */     } else if (this.jTextField2.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  867 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/*  872 */     if (!this.jTextField4.getText().isEmpty()) {
/*  873 */       this.datos.escribir();
/*  874 */     } else if (this.jTextField3.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  875 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/*  880 */     if (!this.jTextField6.getText().isEmpty()) {
/*  881 */       this.datos.escribir();
/*  882 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  883 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/*  888 */     if (!this.jTextField7.getText().isEmpty()) {
/*  889 */       this.datos.escribir();
/*  890 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField8.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  891 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/*  896 */     if (!this.jTextField8.getText().isEmpty()) {
/*  897 */       this.datos.escribir();
/*  898 */     } else if (this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField2.getText().equals("") && this.jComboBox1.getSelectedIndex() == 0) {
/*  899 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField13KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/*  920 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  924 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/*  928 */     limpiar();
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/*  932 */     boolean mayor = true;
/*  933 */     long diasC = 0L;
/*  934 */     String clave = this.jTextField1.getText();
/*  935 */     String nom = this.jTextField2.getText();
/*  936 */     String calle = this.jTextField3.getText();
/*  937 */     String num = this.jTextField4.getText();
/*  938 */     String col = this.jTextField5.getText();
/*  939 */     String cod = this.jTextField6.getText();
/*  940 */     String ciudad = this.jTextField7.getText();
/*  941 */     String estado = "";
/*  942 */     String rfc = this.jTextField8.getText();
/*  943 */     String tel1 = this.jFormattedTextField1.getText();
/*  944 */     int id_edo = 0;
/*  945 */     String corto = this.jTextField15.getText().toUpperCase();
/*  946 */     int tipoPago = 0;
/*  947 */     String local = "";
/*  948 */     String pozo = "";
/*  949 */     if (this.jCheckBox1.isSelected()) {
/*  950 */       pozo = "SI";
/*      */     } else {
/*  952 */       pozo = "NO";
/*      */     } 
/*  954 */     if (this.jRadioButton1.isSelected()) {
/*  955 */       tipoPago = 1;
/*      */     } else {
/*  957 */       tipoPago = 2;
/*      */     } 
/*  959 */     if (this.jRadioButton3.isSelected()) {
/*  960 */       local = "SI";
/*      */     } else {
/*  962 */       local = "NO";
/*      */     } 
/*  964 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  965 */       estado = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/*  967 */     if (this.con.consultar("id_edo", "estados", "where estado = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'")) {
/*  968 */       id_edo = Integer.parseInt(this.con.Campo);
/*      */     }
/*  970 */     String[] campos = { "Clave de la empresa", "Nombre", "Calle", "Número", "Colonia", "Código Postal", "Ciudad", "Estado", "RFC", "Teléfono", "Monto a Cobrar", "Letra", "Aut. Semarnat" };
/*  971 */     if (tel1.equals("___-___-____")) {
/*  972 */       tel1 = "";
/*      */     }
/*  974 */     if (clave.equals("")) {
/*  975 */       this.error.cargarError(this.jTextField1, "050");
/*  976 */     } else if (nom.equals("")) {
/*  977 */       this.error.cargarError(this.jTextField2, "050");
/*  978 */     } else if (this.jTextField15.equals("")) {
/*  979 */       this.error.cargarError(this.jTextField15, "050");
/*  980 */     } else if (calle.equals("")) {
/*  981 */       this.error.cargarError(this.jTextField3, "050");
/*  982 */     } else if (num.equals("")) {
/*  983 */       this.error.cargarError(this.jTextField4, "050");
/*  984 */     } else if (cod.equals("")) {
/*  985 */       this.error.cargarError(this.jTextField6, "050");
/*  986 */     } else if (ciudad.equals("")) {
/*  987 */       this.error.cargarError(this.jTextField7, "050");
/*  988 */     } else if (this.jComboBox1.getSelectedIndex() == 0) {
/*  989 */       this.error.cargarError(this.jComboBox1, "050");
/*  990 */     } else if (rfc.equals("")) {
/*  991 */       this.error.cargarError(this.jTextField8, "050");
/*  992 */     } else if (this.jTextField9.getText().equals("")) {
/*  993 */       this.error.cargarError(this.jTextField9, "050");
/*  994 */     } else if (this.jTextField10.getText().equals("")) {
/*  995 */       this.error.cargarError(this.jTextField10, "050");
/*  996 */     } else if (this.jTextField13.getText().equals("")) {
/*  997 */       this.error.cargarError(this.jTextField13, "050");
/*      */     
/*      */     }
/* 1000 */     else if (this.jTextField10.getText().contains("'")) {
/* 1001 */       JOptionPane.showMessageDialog(this.padre, "<html>No puedes colocar el caracter <b>apostrófe(')</b>, por favor cambialo a comillas.</html>");
/* 1002 */     } else if (!this.val.validarApostrofe(this.jTextField2, nom, "020") && 
/* 1003 */       !this.val.validarApostrofe(this.jTextField15, nom, "020")) {
/*      */       
/* 1005 */       if (!this.val.validarNumero(this.jTextField4, num.toUpperCase(), "015") && 
/* 1006 */         !this.val.validarDireccion(this.jTextField5, col, "014") && 
/* 1007 */         !this.val.validarCodigoPostal(this.jTextField6, cod, "014") && 
/* 1008 */         !this.val.validarRegion(this.jTextField7, ciudad, "018") && 
/* 1009 */         !this.val.validarRFC(this.jTextField8, this.jTextField8.getText()) && 
/* 1010 */         !this.val.validarDigitos(this.jTextField9, this.jTextField9.getText()) && 
/* 1011 */         !this.val.validarApostrofe(this.jTextField10, this.jTextField10.getText(), "020") && 
/* 1012 */         !this.val.validarApostrofe(this.jTextField13, this.jTextField13.getText(), "020")) {
/*      */         
/* 1014 */         String[] info = { clave, nom.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), cod, ciudad.toUpperCase(), estado.toUpperCase(), this.jTextField8.getText().toUpperCase(), tel1, this.jTextField9.getText(), this.jTextField10.getText().toUpperCase(), this.jTextField11.getText().toUpperCase() };
/* 1015 */         if (this.materialButton23.getText().equals("Modificar")) {
/* 1016 */           int res = this.error.cargarDatos2(campos, info);
/* 1017 */           if (res == 0) {
/* 1018 */             this.con.insertar("update emp_destinataria set empresa='" + nom.toUpperCase() + "',nombreCorto = '" + corto + "', calle='" + calle.toUpperCase() + "', num='" + num.toUpperCase() + "', col='" + col.toUpperCase() + "', cp=" + cod + ", ciudad='" + ciudad.toUpperCase() + "',rfc='" + this.jTextField8.getText().toUpperCase() + "',telefono='" + tel1 + "',id_edo=" + id_edo + ",monto = " + this.jTextField9.getText() + ",letra = '" + this.jTextField10.getText().toUpperCase() + "', semarnat = '" + this.jTextField11.getText().toUpperCase() + "',ruta ='" + this.jTextField12.getText().toUpperCase() + "',lau = '" + this.jTextField13.getText() + "',bascula = '" + this.jTextField14.getText() + "',viaje = " + String.valueOf(this.jFormattedTextField2.getValue()) + ",viajeLetra = '" + this.jFormattedTextField2.getText() + "',tons='" + String.valueOf(this.jFormattedTextField3.getValue()) + "',tonsLetra ='" + this.jFormattedTextField3.getText() + "',tipoPago = " + tipoPago + ",local='" + local + "',pozo='" + pozo + "',km=" + this.jTextField16.getText() + "  where clave_desti=" + this.id);
/* 1019 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Modificó la empresa destino No: " + this.id + "','Nombre de la empresa: " + this.inf[1] + "\nDirección: " + this.inf[2] + " " + this.inf[3] + " " + this.inf[4] + " " + this.inf[5] + " " + this.inf[6] + "\nRFC: " + this.inf[7] + "\nTeléfono: " + this.inf[8] + "\nMonto: " + this.inf[10] + "\nC/Letra: " + this.inf[11] + "')");
/* 1020 */             this.mensajeTry.guardarConf("Se ha modificado un destino-" + this.jTextField15.getText().toUpperCase() + ", USUARIO: " + this.USUARIO, "Destino Modificado", "INFO", "Destinos");
/* 1021 */             limpiar();
/* 1022 */             consultar();
/* 1023 */             this.fichas.remove(1);
/*      */           } 
/*      */         } else {
/* 1026 */           int res = this.error.cargarDatos(campos, info);
/* 1027 */           if (res == 0) {
/* 1028 */             this.con.insertar("insert into emp_destinataria(empresa,nombreCorto,calle,num,col,cp,ciudad,rfc,telefono,monto,letra,semarnat,ruta,lau,bascula,viaje,viajeLetra,tons,tonsLetra,tipoPago,local,pozo,km,id_edo)values('" + info[1] + "','" + corto + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "'," + cod + ",'" + ciudad.toUpperCase() + "','" + rfc.toUpperCase() + "','" + tel1 + "'," + this.jTextField9.getText() + ",'" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField11.getText().toUpperCase().toUpperCase() + "','" + this.jTextField12.getText().toUpperCase() + "','" + this.jTextField13.getText() + "','" + this.jTextField14.getText() + "'," + String.valueOf(this.jFormattedTextField2.getValue()) + ",'" + this.jFormattedTextField2.getText() + "'," + String.valueOf(this.jFormattedTextField3.getValue()) + ",'" + this.jFormattedTextField3.getText() + "'," + tipoPago + ",'" + local + "','" + pozo + "'," + this.jTextField16.getText() + "," + id_edo + ")");
/* 1029 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Creó la Empresa Destinataria No: " + clave + "','Nombre de la empresa: " + info[1] + "\nDirección: " + info[2] + " " + info[3] + " " + info[4] + " " + info[5] + " " + info[6] + " " + info[7] + "\nRFC: " + info[8] + "\nTeléfono: " + info[9] + "\nMonto: " + this.jTextField9.getText() + "\nC/Letra: " + this.jTextField9.getText().toUpperCase() + "')");
/* 1030 */             this.mensajeTry.guardarConf("Se ha creado un destino-" + this.jTextField15.getText().toUpperCase() + ", USUARIO: " + this.USUARIO, "Nuevo Destino", "INFO", "Destinos");
/* 1031 */             limpiar();
/*      */           } 
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
/*      */ 
/*      */ 
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 1049 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 1053 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 1054 */     this.fichas.remove(1);
/* 1055 */     this.datos.eliminar();
/*      */   }
/*      */   public void crearInd() {
/* 1058 */     this.con.consultar("max(clave_desti)", "emp_destinataria", "");
/* 1059 */     int max = Integer.parseInt(this.con.Campo);
/* 1060 */     max++;
/* 1061 */     if (!this.materialButton23.getText().equals("Modificar")) {
/* 1062 */       this.jTextField1.setText("" + max);
/*      */     }
/*      */   }
/*      */   
/*      */   public void destinatario(String usua, String num) {
/* 1067 */     this.USUARIO = usua;
/* 1068 */     this.panel.setViewportView(this);
/* 1069 */     this.id = num;
/* 1070 */     crearInd();
/* 1071 */     this.jLabel14.setVisible(false);
/* 1072 */     if (this.fichas != null) {
/* 1073 */       cargarFormulario();
/* 1074 */       this.fichas.addTab("Modificar Destino - [Clave: " + this.id + "]", this.panel);
/* 1075 */       this.materialButton23.setText("Modificar");
/* 1076 */       this.jLabel1.setText("Modificar Destino");
/* 1077 */       this.materialButton24.setVisible(true);
/* 1078 */       this.materialButton25.setVisible(true);
/*      */     } else {
/* 1080 */       this.materialButton24.setVisible(false);
/* 1081 */       this.materialButton25.setVisible(false);
/* 1082 */       this.jLabel1.setText("Agregar Destinos");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 1087 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1089 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1093 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 1096 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1098 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1102 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 1105 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1107 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1111 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 1114 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1116 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1120 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1123 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1125 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1129 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1132 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1134 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1138 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 1141 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1143 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1147 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1150 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1152 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1156 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 1159 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1161 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1165 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 1168 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1170 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1174 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 1177 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1179 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1183 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 1186 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1188 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1192 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 1195 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1197 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1201 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 1204 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1206 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1210 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 1213 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1215 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1219 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 1222 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1224 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1228 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 1231 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1233 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1237 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 1240 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1242 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1246 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 1249 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1251 */             DestinatarioAlta.this.jTextGanado(DestinatarioAlta.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1255 */             DestinatarioAlta.this.jTextPerdido(DestinatarioAlta.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1261 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1265 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 1269 */     this.jTextField2.setText("");
/* 1270 */     this.jTextField3.setText("");
/* 1271 */     this.jTextField4.setText("");
/* 1272 */     this.jTextField5.setText("");
/* 1273 */     this.jTextField6.setText("");
/* 1274 */     this.jTextField7.setText("");
/* 1275 */     this.jTextField8.setText("");
/* 1276 */     this.jTextField9.setText("");
/* 1277 */     this.jTextField10.setText("");
/* 1278 */     this.jTextField11.setText("");
/* 1279 */     this.jTextField12.setText("");
/* 1280 */     this.jTextField13.setText("");
/* 1281 */     this.jTextField14.setText("");
/* 1282 */     this.jFormattedTextField1.setValue("");
/* 1283 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 1284 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 1285 */     this.jTextField15.setText("");
/* 1286 */     this.jComboBox1.setSelectedIndex(0);
/* 1287 */     this.jTextField16.setText("0");
/* 1288 */     crearInd();
/* 1289 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   public void pasarInd(int i) {
/* 1293 */     this.INDICE = i;
/*      */   }
/*      */   
/*      */   public void cargarFormulario() {
/* 1297 */     this.jLabel14.setVisible(true);
/* 1298 */     this.materialButton25.setVisible(true);
/* 1299 */     this.materialButton23.setMnemonic('M');
/* 1300 */     this.materialButton23.setToolTipText("Modificar (Alt+M)");
/* 1301 */     String[] campos = this.con.regresaReg("clave_desti,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado,monto,letra,semarnat,ruta,lau,bascula,viaje,tons,nombrecorto,tipoPago,local,pozo,km", "emp_destinataria,estados", "where emp_destinataria.id_edo = estados.id_edo and clave_desti = " + this.id, 23);
/* 1302 */     this.inf = campos;
/* 1303 */     this.jTextField1.setText(campos[0]);
/* 1304 */     this.jTextField2.setText(campos[1]);
/* 1305 */     this.jTextField3.setText(campos[2]);
/* 1306 */     this.jTextField4.setText(campos[3]);
/* 1307 */     this.jTextField5.setText(campos[4]);
/* 1308 */     this.jTextField6.setText(campos[5]);
/* 1309 */     this.jTextField7.setText(campos[6]);
/* 1310 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/* 1311 */     this.jComboBox1.setSelectedItem(campos[9]);
/* 1312 */     this.jTextField8.setText(campos[7]);
/* 1313 */     this.jFormattedTextField1.setText(campos[8]);
/* 1314 */     this.jTextField9.setText(campos[10]);
/* 1315 */     this.jTextField10.setText(campos[11]);
/* 1316 */     this.jTextField11.setText(campos[12]);
/* 1317 */     this.jTextField12.setText(campos[13]);
/* 1318 */     this.jTextField13.setText(campos[14]);
/* 1319 */     this.jTextField14.setText(campos[15]);
/* 1320 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(campos[16])));
/* 1321 */     this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(campos[17])));
/* 1322 */     this.jTextField15.setText(campos[18]);
/* 1323 */     if (campos[19].equals("1")) {
/* 1324 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 1326 */       this.jRadioButton2.setSelected(true);
/*      */     } 
/* 1328 */     if (campos[20].equals("SI")) {
/* 1329 */       this.jRadioButton3.setSelected(true);
/*      */     } else {
/* 1331 */       this.jRadioButton4.setSelected(true);
/*      */     } 
/* 1333 */     if (campos[21].equals("SI")) {
/* 1334 */       this.jCheckBox1.setSelected(true);
/*      */     } else {
/* 1336 */       this.jCheckBox1.setSelected(false);
/*      */     } 
/* 1338 */     this.jTextField16.setText(campos[22]);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1342 */     this.encontrado = this.con.consultar("count(clave_desti)", "emp_destinataria", "where clave_desti<>0");
/* 1343 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1344 */     this.encontrado = this.con.consultar("count(clave_desti)", "emp_destinataria", "where clave_desti<>0");
/* 1345 */     String tot = this.con.Campo;
/* 1346 */     System.out.println(totreg);
/* 1347 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1348 */           .buscarReg(17, totreg, "clave_desti,empresa,calle,num,col,cp,ciudad,estado,rfc,telefono,MONTO,semarnat,ruta,lau,bascula,viajeLetra,tonsLetra", "emp_destinataria,estados", "where emp_destinataria.id_edo=estados.id_edo and clave_desti<>0"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Destino", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "Monto", "Aut. Semarnat", "Ruta", "L.A.U.", "Báscula", "$ Viaje", "$ Tons" }));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1353 */     this.jTable3.setShowVerticalLines(false);
/* 1354 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 1355 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1356 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 1357 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 1358 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 1359 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(70);
/* 1360 */     this.jTable3.setSelectionMode(0);
/* 1361 */     this.jTable3.setAutoCreateRowSorter(true);
/* 1362 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DestinatarioAlta.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */