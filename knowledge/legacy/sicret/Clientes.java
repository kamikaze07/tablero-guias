/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import utilerias.Tras_codigos;
/*      */ 
/*      */ public class Clientes extends JPanel {
/*   26 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   27 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   28 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   29 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   30 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   31 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   35 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   36 */   Utilerias utilerias = new Utilerias();
/*      */   JFrame padre;
/*   38 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*   40 */   Consultas2 con = new Consultas2();
/*   41 */   Consultas2 con2 = new Consultas2();
/*   42 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   44 */   Fuentes fuentes = new Fuentes();
/*   45 */   PlaceHolder placeHolder = null;
/*   46 */   String holderId = "NÚM";
/*   47 */   String holderNombre = "RAZÓN SOCIAL, NOMBRE O NOMBRE COMERCIAL";
/*   48 */   String holderCiudad = "CIUDAD";
/*   49 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean actualizado = false;
/*   51 */   List<Tras_codigos> CODIGOSP = new ArrayList<>();
/*   52 */   ArrayList LISTACODIGOS = new ArrayList();
/*   53 */   TextAutoCompleter com_ListaCodigos = null;
/*      */   boolean entraPrimera = false;
/*      */   boolean PRIMERA = false;
/*   56 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   EscribirReporte esc;
/*   58 */   String SUCURSAL = "";
/*   59 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   60 */   Map<String, String> CLAVECATALOGO = new TreeMap<>();
/*   61 */   Map<String, String> PRIVILEGIOS = new TreeMap<>(); RFCTipo RFCTIPO; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton101; private JButton jButton102; private JButton jButton103; private JButton jButton104; private JButton jButton105; private JButton jButton106; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox<String> jComboBox3; private JComboBox<String> jComboBox4; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel11; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel9; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel133;
/*      */   private JPanel jPanel134;
/*      */   private JPanel jPanel14;
/*      */   
/*      */   public Clientes(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*   68 */     this.con2.setBaseDatos("sicre2PR");
/*   69 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*      */     
/*   71 */     this.padre = padre;
/*   72 */     this.fichas = fichas;
/*   73 */     this.USUARIO = USUARIO;
/*   74 */     this.panel = panelito;
/*   75 */     this.LISTACODIGOS = LISTACODIGOS;
/*   76 */     this.CODIGOSP = CODIGOSP;
/*   77 */     this.panel.setViewportView(this);
/*   78 */     this.PRIVILEGIOS.put("SUPER SUUARIO", "SUPER USUARIO");
/*   79 */     this.PRIVILEGIOS.put("FACTURACIÓN", "FACTURACIÓN");
/*      */     
/*      */     try {
/*   82 */       this.formaTel = new MaskFormatter("###-###-####");
/*   83 */     } catch (Exception exception) {}
/*      */     
/*   85 */     initComponents();
/*      */     
/*   87 */     colorear();
/*   88 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderId, false, "Century Gothic", 11);
/*   89 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderNombre, false, "Century Gothic", 11);
/*   90 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCiudad, false, "Century Gothic", 11);
/*      */     
/*   92 */     llenarComboEstados();
/*   93 */     consultar();
/*   94 */     llenarCodigos();
/*      */ 
/*      */     
/*   97 */     this.utilerias.activarVentanajDialog(this.jDialog2, 800, 665);
/*   98 */     this.utilerias.activarVentanajDialog(this.jDialog3, 650, 250);
/*   99 */     limpiar();
/*  100 */     llenarCatPaises();
/*      */     
/*  102 */     privilegios();
/*  103 */     this.buttonGroup1.add(this.jRadioButton1);
/*  104 */     this.buttonGroup1.add(this.jRadioButton2);
/*  105 */     this.buttonGroup1.add(this.jRadioButton3);
/*      */     
/*  107 */     if (this.USUARIO.equals("KOFUZ01")) {
/*  108 */       this.jButton6.setVisible(true);
/*      */     } else {
/*  110 */       this.jButton6.setVisible(false);
/*      */     } 
/*      */   }
/*      */   private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel2; private JPanel jPanel21; private JPanel jPanel3; private JPanel jPanel35; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane23; private JTextField jTextField1;
/*      */   private JTextField jTextField101;
/*      */   private JTextField jTextField102;
/*      */   private JTextField jTextField103;
/*      */   private JTextField jTextField104;
/*      */   
/*      */   private void initComponents() {
/*  120 */     this.jPanel2 = new JPanel();
/*  121 */     this.jTextField4 = new JTextField();
/*  122 */     this.jDialog1 = new JDialog();
/*  123 */     this.jPanel3 = new JPanel();
/*  124 */     this.jScrollPane14 = new JScrollPane();
/*  125 */     this.rSTableMetro2 = new RSTableMetro();
/*  126 */     this.jButton3 = new JButton();
/*  127 */     this.jButton5 = new JButton();
/*  128 */     this.jComboBox3 = new JComboBox<>();
/*  129 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  130 */     this.jPanel5 = new JPanel();
/*  131 */     this.jPanel21 = new JPanel();
/*  132 */     this.materialButton2 = new MaterialButton();
/*  133 */     this.materialButton1 = new MaterialButton();
/*  134 */     this.jPanel4 = new JPanel();
/*  135 */     this.jLabel13 = new JLabel();
/*  136 */     this.jTextField101 = new JTextField();
/*  137 */     this.jTextField103 = new JTextField();
/*  138 */     this.jLabel2 = new JLabel();
/*  139 */     this.jTextField104 = new JTextField();
/*  140 */     this.jLabel21 = new JLabel();
/*  141 */     this.jTextField102 = new JTextField();
/*  142 */     this.jLabel3 = new JLabel();
/*  143 */     this.jTextField105 = new JTextField();
/*  144 */     this.jLabel15 = new JLabel();
/*  145 */     this.jPanel60 = new JPanel();
/*  146 */     this.jButton101 = new JButton();
/*  147 */     this.jTextField106 = new JTextField();
/*  148 */     this.jLabel11 = new JLabel();
/*  149 */     this.jTextField107 = new JTextField();
/*  150 */     this.jLabel9 = new JLabel();
/*  151 */     this.jTextField108 = new JTextField();
/*  152 */     this.jLabel10 = new JLabel();
/*  153 */     this.jTextField113 = new JTextField();
/*  154 */     this.jPanel59 = new JPanel();
/*  155 */     this.jButton102 = new JButton();
/*  156 */     this.jTextField109 = new JTextField();
/*  157 */     this.jLabel29 = new JLabel();
/*  158 */     this.jTextField114 = new JTextField();
/*  159 */     this.jTextField110 = new JTextField();
/*  160 */     this.jLabel30 = new JLabel();
/*  161 */     this.jTextField115 = new JTextField();
/*  162 */     this.jTextField111 = new JTextField();
/*  163 */     this.jLabel19 = new JLabel();
/*  164 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  165 */     this.jLabel20 = new JLabel();
/*  166 */     this.jPanel133 = new JPanel();
/*  167 */     this.jTextField112 = new JTextField();
/*  168 */     this.jButton103 = new JButton();
/*  169 */     this.jTextField116 = new JTextField();
/*  170 */     this.jCheckBox1 = new JCheckBox();
/*  171 */     this.jLabel14 = new JLabel();
/*  172 */     this.jTextField117 = new JTextField();
/*  173 */     this.jPanel61 = new JPanel();
/*  174 */     this.jButton104 = new JButton();
/*  175 */     this.jTextField118 = new JTextField();
/*  176 */     this.jLabel22 = new JLabel();
/*  177 */     this.jComboBox4 = new JComboBox<>();
/*  178 */     this.jLabel16 = new JLabel();
/*  179 */     this.jLabel17 = new JLabel();
/*  180 */     this.jTextField200 = new JTextField();
/*  181 */     this.jPanel62 = new JPanel();
/*  182 */     this.jButton105 = new JButton();
/*  183 */     this.jTextField201 = new JTextField();
/*  184 */     this.jLabel18 = new JLabel();
/*  185 */     this.jTextField202 = new JTextField();
/*  186 */     this.jPanel63 = new JPanel();
/*  187 */     this.jButton106 = new JButton();
/*  188 */     this.jTextField203 = new JTextField();
/*  189 */     this.jLabel23 = new JLabel();
/*  190 */     this.jTextField119 = new JTextField();
/*  191 */     this.jLabel1 = new JLabel();
/*  192 */     this.jPanel6 = new JPanel();
/*  193 */     this.jRadioButton1 = new JRadioButton();
/*  194 */     this.jRadioButton2 = new JRadioButton();
/*  195 */     this.jRadioButton3 = new JRadioButton();
/*  196 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  197 */     this.jPanel134 = new JPanel();
/*  198 */     this.jScrollPane23 = new JScrollPane();
/*  199 */     this.rSTableMetro12 = new RSTableMetro();
/*  200 */     this.buttonGroup1 = new ButtonGroup();
/*  201 */     this.jPanel9 = new JPanel();
/*  202 */     this.jPanel10 = new JPanel();
/*  203 */     this.jLabel98 = new JLabel();
/*  204 */     this.jPanel35 = new JPanel();
/*  205 */     this.jTextField1 = new JTextField();
/*  206 */     this.jTextField2 = new JTextField();
/*  207 */     this.jTextField3 = new JTextField();
/*  208 */     this.jComboBox1 = new JComboBox();
/*  209 */     this.jComboBox2 = new JComboBox();
/*  210 */     this.jPanel11 = new JPanel();
/*  211 */     this.jPanel12 = new JPanel();
/*  212 */     this.jPanel15 = new JPanel();
/*  213 */     this.jLabel99 = new JLabel();
/*  214 */     this.jLabel100 = new JLabel();
/*  215 */     this.jPanel14 = new JPanel();
/*  216 */     this.jPanel16 = new JPanel();
/*  217 */     this.jButton1 = new JButton();
/*  218 */     this.jButton2 = new JButton();
/*  219 */     this.jButton4 = new JButton();
/*  220 */     this.jButton6 = new JButton();
/*  221 */     this.jPanel1 = new JPanel();
/*  222 */     this.jScrollPane13 = new JScrollPane();
/*  223 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  225 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  226 */     this.jPanel2.setLayout(jPanel2Layout);
/*  227 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  229 */         .addGap(0, 738, 32767));
/*      */     
/*  231 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  232 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  233 */         .addGap(0, 267, 32767));
/*      */ 
/*      */     
/*  236 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  238 */             Clientes.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  241 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  243 */             Clientes.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  247 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  255 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  260 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  263 */     this.rSTableMetro2.setAltoHead(40);
/*  264 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  265 */     this.rSTableMetro2.setColorBordeFilas(this.lc.REJILLATABLA);
/*  266 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  267 */     this.rSTableMetro2.setColorFilasBackgound2(this.lc.REJILLATABLA);
/*  268 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  269 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  270 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  271 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  272 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  273 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  274 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  275 */     this.rSTableMetro2.setRowHeight(18);
/*  276 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  277 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  278 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  279 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  281 */             Clientes.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  284 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  286 */             Clientes.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  289 */     this.jScrollPane14.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  291 */     this.jButton3.setText("Activar Origenes");
/*  292 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  294 */             Clientes.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  298 */     this.jButton5.setText("Desactivar Clientes sin Tarjeta");
/*  299 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  301 */             Clientes.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  305 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona", "Con tarjeta", "Sin Tarjeta" }));
/*  306 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  308 */             Clientes.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  312 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  313 */     this.jPanel3.setLayout(jPanel3Layout);
/*  314 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  316 */         .addComponent(this.jScrollPane14, -1, 533, 32767)
/*  317 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  318 */           .addContainerGap(-1, 32767)
/*  319 */           .addComponent(this.jButton5, -2, 198, -2)
/*  320 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  321 */           .addComponent(this.jButton3, -2, 141, -2)
/*  322 */           .addContainerGap())
/*  323 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  324 */           .addContainerGap()
/*  325 */           .addComponent(this.jComboBox3, -2, 279, -2)
/*  326 */           .addContainerGap(-1, 32767)));
/*      */     
/*  328 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  329 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  330 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  331 */           .addContainerGap()
/*  332 */           .addComponent(this.jComboBox3, -2, -1, -2)
/*  333 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  334 */           .addComponent(this.jScrollPane14, -1, 342, 32767)
/*  335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  336 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  337 */             .addComponent(this.jButton3)
/*  338 */             .addComponent(this.jButton5))
/*  339 */           .addContainerGap()));
/*      */ 
/*      */     
/*  342 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  343 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  344 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  346 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  348 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  349 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  350 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  353 */     this.jDialog2.setTitle("Clientes");
/*  354 */     this.jDialog2.setModal(true);
/*      */     
/*  356 */     this.jPanel5.setBackground(new Color(255, 255, 255));
/*      */     
/*  358 */     this.jPanel21.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  360 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/*  361 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  362 */     this.materialButton2.setMnemonic('C');
/*  363 */     this.materialButton2.setText("Cerrar");
/*  364 */     this.materialButton2.setToolTipText("Cerrar (Alt+C)");
/*  365 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/*  366 */     this.materialButton2.setHorizontalTextPosition(0);
/*  367 */     this.materialButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  369 */             Clientes.this.materialButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  373 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/*  374 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/*  375 */     this.materialButton1.setMnemonic('G');
/*  376 */     this.materialButton1.setText("Guardar");
/*  377 */     this.materialButton1.setToolTipText("Guardar (Alt +G)");
/*  378 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/*  379 */     this.materialButton1.setHorizontalTextPosition(0);
/*  380 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  382 */             Clientes.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  386 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  387 */     this.jPanel21.setLayout(jPanel21Layout);
/*  388 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  390 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/*  391 */           .addContainerGap(-1, 32767)
/*  392 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/*  393 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  394 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/*  395 */           .addContainerGap()));
/*      */     
/*  397 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  399 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/*  400 */           .addGap(0, 0, 32767)
/*  401 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  402 */             .addComponent((Component)this.materialButton2, -2, 38, -2)
/*  403 */             .addComponent((Component)this.materialButton1, -2, 38, -2))));
/*      */ 
/*      */     
/*  406 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  407 */     GridBagLayout jPanel4Layout = new GridBagLayout();
/*  408 */     jPanel4Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  409 */     jPanel4Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  410 */     this.jPanel4.setLayout(jPanel4Layout);
/*      */     
/*  412 */     this.jLabel13.setFont(new Font("Cantarell", 1, 11));
/*  413 */     this.jLabel13.setText("Clave");
/*  414 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  415 */     gridBagConstraints.gridx = 6;
/*  416 */     gridBagConstraints.gridy = 0;
/*  417 */     gridBagConstraints.fill = 2;
/*  418 */     gridBagConstraints.anchor = 21;
/*  419 */     gridBagConstraints.weightx = 0.5D;
/*  420 */     this.jPanel4.add(this.jLabel13, gridBagConstraints);
/*      */     
/*  422 */     this.jTextField101.setEditable(false);
/*  423 */     this.jTextField101.setText(" ");
/*  424 */     gridBagConstraints = new GridBagConstraints();
/*  425 */     gridBagConstraints.gridx = 10;
/*  426 */     gridBagConstraints.gridy = 0;
/*  427 */     gridBagConstraints.gridwidth = 3;
/*  428 */     gridBagConstraints.fill = 2;
/*  429 */     gridBagConstraints.weightx = 1.0D;
/*  430 */     this.jPanel4.add(this.jTextField101, gridBagConstraints);
/*      */     
/*  432 */     this.jTextField103.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  434 */             Clientes.this.jTextField103FocusGained(evt);
/*      */           }
/*      */         });
/*  437 */     this.jTextField103.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  439 */             Clientes.this.jTextField103KeyReleased(evt);
/*      */           }
/*      */         });
/*  442 */     gridBagConstraints = new GridBagConstraints();
/*  443 */     gridBagConstraints.gridx = 10;
/*  444 */     gridBagConstraints.gridy = 10;
/*  445 */     gridBagConstraints.gridwidth = 11;
/*  446 */     gridBagConstraints.fill = 2;
/*  447 */     this.jPanel4.add(this.jTextField103, gridBagConstraints);
/*      */     
/*  449 */     this.jLabel2.setFont(new Font("Cantarell", 1, 11));
/*  450 */     this.jLabel2.setHorizontalAlignment(4);
/*  451 */     this.jLabel2.setText("<html><u>Nombre Comercial</u></html>");
/*  452 */     this.jLabel2.setToolTipText("Éste nombre aparecerá en los reportes para la DIRECCIÓN");
/*  453 */     gridBagConstraints = new GridBagConstraints();
/*  454 */     gridBagConstraints.gridx = 6;
/*  455 */     gridBagConstraints.gridy = 12;
/*  456 */     gridBagConstraints.gridwidth = 3;
/*  457 */     gridBagConstraints.anchor = 17;
/*  458 */     gridBagConstraints.weightx = 2.0D;
/*  459 */     this.jPanel4.add(this.jLabel2, gridBagConstraints);
/*  460 */     gridBagConstraints = new GridBagConstraints();
/*  461 */     gridBagConstraints.gridx = 10;
/*  462 */     gridBagConstraints.gridy = 12;
/*  463 */     gridBagConstraints.gridwidth = 11;
/*  464 */     gridBagConstraints.fill = 2;
/*  465 */     this.jPanel4.add(this.jTextField104, gridBagConstraints);
/*      */     
/*  467 */     this.jLabel21.setFont(new Font("Cantarell", 1, 11));
/*  468 */     this.jLabel21.setHorizontalAlignment(4);
/*  469 */     this.jLabel21.setText("RFC*");
/*  470 */     gridBagConstraints = new GridBagConstraints();
/*  471 */     gridBagConstraints.gridx = 6;
/*  472 */     gridBagConstraints.gridy = 6;
/*  473 */     gridBagConstraints.anchor = 17;
/*  474 */     gridBagConstraints.weightx = 2.0D;
/*  475 */     this.jPanel4.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  477 */     this.jTextField102.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  479 */             Clientes.this.jTextField102KeyReleased(evt);
/*      */           }
/*      */         });
/*  482 */     gridBagConstraints = new GridBagConstraints();
/*  483 */     gridBagConstraints.gridx = 10;
/*  484 */     gridBagConstraints.gridy = 6;
/*  485 */     gridBagConstraints.gridwidth = 11;
/*  486 */     gridBagConstraints.fill = 2;
/*  487 */     this.jPanel4.add(this.jTextField102, gridBagConstraints);
/*      */     
/*  489 */     this.jLabel3.setFont(new Font("Cantarell", 1, 11));
/*  490 */     this.jLabel3.setHorizontalAlignment(4);
/*  491 */     this.jLabel3.setText("<html><u>Iniciales</u></html>");
/*  492 */     this.jLabel3.setToolTipText("Éstas iniciales aparecerán en los reportes GENERALES DE FACTURACIÓN");
/*  493 */     gridBagConstraints = new GridBagConstraints();
/*  494 */     gridBagConstraints.gridx = 22;
/*  495 */     gridBagConstraints.gridy = 12;
/*  496 */     gridBagConstraints.fill = 2;
/*  497 */     gridBagConstraints.anchor = 21;
/*  498 */     gridBagConstraints.weightx = 1.0D;
/*  499 */     this.jPanel4.add(this.jLabel3, gridBagConstraints);
/*      */     
/*  501 */     this.jTextField105.setToolTipText("Mínimo tres letras y máximo 8");
/*  502 */     gridBagConstraints = new GridBagConstraints();
/*  503 */     gridBagConstraints.gridx = 24;
/*  504 */     gridBagConstraints.gridy = 12;
/*  505 */     gridBagConstraints.gridwidth = 3;
/*  506 */     gridBagConstraints.fill = 2;
/*  507 */     gridBagConstraints.weightx = 1.0D;
/*  508 */     this.jPanel4.add(this.jTextField105, gridBagConstraints);
/*      */     
/*  510 */     this.jLabel15.setFont(new Font("Cantarell", 1, 11));
/*  511 */     this.jLabel15.setText("Uso del CFDI");
/*  512 */     gridBagConstraints = new GridBagConstraints();
/*  513 */     gridBagConstraints.gridx = 6;
/*  514 */     gridBagConstraints.gridy = 18;
/*  515 */     gridBagConstraints.gridwidth = 3;
/*  516 */     gridBagConstraints.anchor = 17;
/*  517 */     gridBagConstraints.weightx = 2.0D;
/*  518 */     this.jPanel4.add(this.jLabel15, gridBagConstraints);
/*      */     
/*  520 */     this.jPanel60.setBackground(new Color(255, 255, 255));
/*      */     
/*  522 */     this.jButton101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  523 */     this.jButton101.setMnemonic('F');
/*  524 */     this.jButton101.setToolTipText("Filtrar información (Alt+F)");
/*  525 */     this.jButton101.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  527 */             Clientes.this.jButton101ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  531 */     this.jTextField106.setText("cod");
/*  532 */     this.jTextField106.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  534 */             Clientes.this.jTextField106ActionPerformed(evt);
/*      */           }
/*      */         });
/*  537 */     this.jTextField106.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  539 */             Clientes.this.jTextField106KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  543 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/*  544 */     this.jPanel60.setLayout(jPanel60Layout);
/*  545 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/*  546 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  547 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  548 */           .addComponent(this.jTextField106, -1, 472, 32767)
/*  549 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  550 */           .addComponent(this.jButton101, -2, 20, -2)
/*  551 */           .addGap(0, 0, 0)));
/*      */     
/*  553 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/*  554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  555 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  556 */           .addGroup(jPanel60Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  557 */             .addComponent(this.jTextField106, -2, -1, -2)
/*  558 */             .addComponent(this.jButton101, -2, 24, -2))
/*  559 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  562 */     gridBagConstraints = new GridBagConstraints();
/*  563 */     gridBagConstraints.gridx = 10;
/*  564 */     gridBagConstraints.gridy = 20;
/*  565 */     gridBagConstraints.gridwidth = 11;
/*  566 */     gridBagConstraints.fill = 2;
/*  567 */     this.jPanel4.add(this.jPanel60, gridBagConstraints);
/*      */     
/*  569 */     this.jLabel11.setFont(new Font("Cantarell", 1, 11));
/*  570 */     this.jLabel11.setHorizontalAlignment(4);
/*  571 */     this.jLabel11.setText("Calle");
/*  572 */     gridBagConstraints = new GridBagConstraints();
/*  573 */     gridBagConstraints.gridx = 6;
/*  574 */     gridBagConstraints.gridy = 22;
/*  575 */     gridBagConstraints.anchor = 17;
/*  576 */     gridBagConstraints.weightx = 2.0D;
/*  577 */     this.jPanel4.add(this.jLabel11, gridBagConstraints);
/*      */     
/*  579 */     this.jTextField107.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  581 */             Clientes.this.jTextField107KeyReleased(evt);
/*      */           }
/*      */         });
/*  584 */     gridBagConstraints = new GridBagConstraints();
/*  585 */     gridBagConstraints.gridx = 10;
/*  586 */     gridBagConstraints.gridy = 22;
/*  587 */     gridBagConstraints.gridwidth = 11;
/*  588 */     gridBagConstraints.fill = 2;
/*  589 */     gridBagConstraints.weightx = 1.0D;
/*  590 */     this.jPanel4.add(this.jTextField107, gridBagConstraints);
/*      */     
/*  592 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/*  593 */     this.jLabel9.setHorizontalAlignment(4);
/*  594 */     this.jLabel9.setText("Número");
/*  595 */     gridBagConstraints = new GridBagConstraints();
/*  596 */     gridBagConstraints.gridx = 22;
/*  597 */     gridBagConstraints.gridy = 22;
/*  598 */     gridBagConstraints.fill = 2;
/*  599 */     gridBagConstraints.anchor = 21;
/*  600 */     gridBagConstraints.weightx = 1.0D;
/*  601 */     this.jPanel4.add(this.jLabel9, gridBagConstraints);
/*      */     
/*  603 */     this.jTextField108.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  605 */             Clientes.this.jTextField108KeyReleased(evt);
/*      */           }
/*      */         });
/*  608 */     gridBagConstraints = new GridBagConstraints();
/*  609 */     gridBagConstraints.gridx = 24;
/*  610 */     gridBagConstraints.gridy = 22;
/*  611 */     gridBagConstraints.gridwidth = 3;
/*  612 */     gridBagConstraints.fill = 2;
/*  613 */     gridBagConstraints.weightx = 1.0D;
/*  614 */     this.jPanel4.add(this.jTextField108, gridBagConstraints);
/*      */     
/*  616 */     this.jLabel10.setFont(new Font("Cantarell", 1, 11));
/*  617 */     this.jLabel10.setHorizontalAlignment(4);
/*  618 */     this.jLabel10.setText("Localidad");
/*  619 */     gridBagConstraints = new GridBagConstraints();
/*  620 */     gridBagConstraints.gridx = 6;
/*  621 */     gridBagConstraints.gridy = 26;
/*  622 */     gridBagConstraints.anchor = 17;
/*  623 */     gridBagConstraints.weightx = 2.0D;
/*  624 */     this.jPanel4.add(this.jLabel10, gridBagConstraints);
/*      */     
/*  626 */     this.jTextField113.setText("jTextField113");
/*  627 */     this.jTextField113.setEnabled(false);
/*  628 */     gridBagConstraints = new GridBagConstraints();
/*  629 */     gridBagConstraints.gridx = 10;
/*  630 */     gridBagConstraints.gridy = 24;
/*  631 */     gridBagConstraints.fill = 2;
/*  632 */     this.jPanel4.add(this.jTextField113, gridBagConstraints);
/*      */     
/*  634 */     this.jPanel59.setBackground(new Color(255, 255, 255));
/*      */     
/*  636 */     this.jButton102.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  637 */     this.jButton102.setMnemonic('F');
/*  638 */     this.jButton102.setToolTipText("Filtrar información (Alt+F)");
/*  639 */     this.jButton102.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  641 */             Clientes.this.jButton102ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  645 */     this.jTextField109.setText("col");
/*  646 */     this.jTextField109.setEnabled(false);
/*  647 */     this.jTextField109.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  649 */             Clientes.this.jTextField109KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  653 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  654 */     this.jPanel59.setLayout(jPanel59Layout);
/*  655 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  656 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  657 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  658 */           .addComponent(this.jTextField109)
/*  659 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  660 */           .addComponent(this.jButton102, -2, 20, -2)
/*  661 */           .addGap(0, 0, 0)));
/*      */     
/*  663 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  664 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  665 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  666 */           .addGroup(jPanel59Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  667 */             .addComponent(this.jTextField109, -2, -1, -2)
/*  668 */             .addComponent(this.jButton102, -2, 24, -2))
/*  669 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  672 */     gridBagConstraints = new GridBagConstraints();
/*  673 */     gridBagConstraints.gridx = 12;
/*  674 */     gridBagConstraints.gridy = 24;
/*  675 */     gridBagConstraints.gridwidth = 9;
/*  676 */     gridBagConstraints.fill = 1;
/*  677 */     this.jPanel4.add(this.jPanel59, gridBagConstraints);
/*      */     
/*  679 */     this.jLabel29.setFont(new Font("Cantarell", 1, 11));
/*  680 */     this.jLabel29.setText("Ciudad *");
/*  681 */     gridBagConstraints = new GridBagConstraints();
/*  682 */     gridBagConstraints.gridx = 6;
/*  683 */     gridBagConstraints.gridy = 28;
/*  684 */     gridBagConstraints.anchor = 17;
/*  685 */     gridBagConstraints.weightx = 2.0D;
/*  686 */     this.jPanel4.add(this.jLabel29, gridBagConstraints);
/*      */     
/*  688 */     this.jTextField114.setText("jTextField114");
/*  689 */     this.jTextField114.setEnabled(false);
/*  690 */     gridBagConstraints = new GridBagConstraints();
/*  691 */     gridBagConstraints.gridx = 10;
/*  692 */     gridBagConstraints.gridy = 28;
/*  693 */     gridBagConstraints.fill = 2;
/*  694 */     this.jPanel4.add(this.jTextField114, gridBagConstraints);
/*      */     
/*  696 */     this.jTextField110.setEnabled(false);
/*  697 */     this.jTextField110.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  699 */             Clientes.this.jTextField110KeyReleased(evt);
/*      */           }
/*      */         });
/*  702 */     gridBagConstraints = new GridBagConstraints();
/*  703 */     gridBagConstraints.gridx = 12;
/*  704 */     gridBagConstraints.gridy = 28;
/*  705 */     gridBagConstraints.gridwidth = 9;
/*  706 */     gridBagConstraints.fill = 2;
/*  707 */     this.jPanel4.add(this.jTextField110, gridBagConstraints);
/*      */     
/*  709 */     this.jLabel30.setFont(new Font("Cantarell", 1, 11));
/*  710 */     this.jLabel30.setText("Estado*");
/*  711 */     gridBagConstraints = new GridBagConstraints();
/*  712 */     gridBagConstraints.gridx = 6;
/*  713 */     gridBagConstraints.gridy = 30;
/*  714 */     gridBagConstraints.anchor = 17;
/*  715 */     gridBagConstraints.weightx = 2.0D;
/*  716 */     this.jPanel4.add(this.jLabel30, gridBagConstraints);
/*      */     
/*  718 */     this.jTextField115.setText("jTextField115");
/*  719 */     this.jTextField115.setEnabled(false);
/*  720 */     gridBagConstraints = new GridBagConstraints();
/*  721 */     gridBagConstraints.gridx = 10;
/*  722 */     gridBagConstraints.gridy = 30;
/*  723 */     gridBagConstraints.fill = 2;
/*  724 */     this.jPanel4.add(this.jTextField115, gridBagConstraints);
/*      */     
/*  726 */     this.jTextField111.setText("jTextField111");
/*  727 */     this.jTextField111.setEnabled(false);
/*  728 */     gridBagConstraints = new GridBagConstraints();
/*  729 */     gridBagConstraints.gridx = 12;
/*  730 */     gridBagConstraints.gridy = 30;
/*  731 */     gridBagConstraints.gridwidth = 9;
/*  732 */     gridBagConstraints.fill = 2;
/*  733 */     gridBagConstraints.weightx = 1.0D;
/*  734 */     this.jPanel4.add(this.jTextField111, gridBagConstraints);
/*      */     
/*  736 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/*  737 */     this.jLabel19.setHorizontalAlignment(4);
/*  738 */     this.jLabel19.setText("Servicio SCT");
/*  739 */     gridBagConstraints = new GridBagConstraints();
/*  740 */     gridBagConstraints.gridx = 6;
/*  741 */     gridBagConstraints.gridy = 36;
/*  742 */     gridBagConstraints.anchor = 17;
/*  743 */     gridBagConstraints.weightx = 2.0D;
/*  744 */     this.jPanel4.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  746 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  748 */             Clientes.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  751 */     gridBagConstraints = new GridBagConstraints();
/*  752 */     gridBagConstraints.gridx = 10;
/*  753 */     gridBagConstraints.gridy = 34;
/*  754 */     gridBagConstraints.gridwidth = 11;
/*  755 */     gridBagConstraints.fill = 2;
/*  756 */     this.jPanel4.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/*  758 */     this.jLabel20.setFont(new Font("Cantarell", 1, 11));
/*  759 */     this.jLabel20.setHorizontalAlignment(4);
/*  760 */     this.jLabel20.setText("País*");
/*  761 */     gridBagConstraints = new GridBagConstraints();
/*  762 */     gridBagConstraints.gridx = 6;
/*  763 */     gridBagConstraints.gridy = 32;
/*  764 */     gridBagConstraints.anchor = 17;
/*  765 */     gridBagConstraints.weightx = 2.0D;
/*  766 */     this.jPanel4.add(this.jLabel20, gridBagConstraints);
/*      */     
/*  768 */     this.jPanel133.setBackground(new Color(255, 255, 255));
/*      */     
/*  770 */     this.jTextField112.setText("MEXICO");
/*  771 */     this.jTextField112.setEnabled(false);
/*      */     
/*  773 */     this.jButton103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  774 */     this.jButton103.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  776 */             Clientes.this.jButton103ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  780 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  781 */     this.jPanel133.setLayout(jPanel133Layout);
/*  782 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  783 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  784 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  785 */           .addComponent(this.jTextField112)
/*  786 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  787 */           .addComponent(this.jButton103, -2, 18, -2)));
/*      */     
/*  789 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  791 */         .addComponent(this.jTextField112)
/*  792 */         .addComponent(this.jButton103, -2, 0, 32767));
/*      */ 
/*      */     
/*  795 */     gridBagConstraints = new GridBagConstraints();
/*  796 */     gridBagConstraints.gridx = 12;
/*  797 */     gridBagConstraints.gridy = 32;
/*  798 */     gridBagConstraints.gridwidth = 9;
/*  799 */     gridBagConstraints.fill = 2;
/*  800 */     this.jPanel4.add(this.jPanel133, gridBagConstraints);
/*      */     
/*  802 */     this.jTextField116.setText("MEX");
/*  803 */     this.jTextField116.setEnabled(false);
/*  804 */     this.jTextField116.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  806 */             Clientes.this.jTextField116KeyReleased(evt);
/*      */           }
/*      */         });
/*  809 */     gridBagConstraints = new GridBagConstraints();
/*  810 */     gridBagConstraints.gridx = 10;
/*  811 */     gridBagConstraints.gridy = 32;
/*  812 */     gridBagConstraints.fill = 2;
/*  813 */     this.jPanel4.add(this.jTextField116, gridBagConstraints);
/*      */     
/*  815 */     this.jCheckBox1.setText("Desactivar");
/*  816 */     gridBagConstraints = new GridBagConstraints();
/*  817 */     gridBagConstraints.gridx = 10;
/*  818 */     gridBagConstraints.gridy = 38;
/*  819 */     gridBagConstraints.fill = 2;
/*  820 */     this.jPanel4.add(this.jCheckBox1, gridBagConstraints);
/*      */     
/*  822 */     this.jLabel14.setFont(new Font("Cantarell", 0, 11));
/*  823 */     this.jLabel14.setHorizontalAlignment(4);
/*  824 */     this.jLabel14.setText("Colonia");
/*  825 */     gridBagConstraints = new GridBagConstraints();
/*  826 */     gridBagConstraints.gridx = 6;
/*  827 */     gridBagConstraints.gridy = 24;
/*  828 */     gridBagConstraints.anchor = 17;
/*  829 */     gridBagConstraints.weightx = 2.0D;
/*  830 */     this.jPanel4.add(this.jLabel14, gridBagConstraints);
/*      */     
/*  832 */     this.jTextField117.setText("jTextField117");
/*  833 */     this.jTextField117.setEnabled(false);
/*  834 */     gridBagConstraints = new GridBagConstraints();
/*  835 */     gridBagConstraints.gridx = 10;
/*  836 */     gridBagConstraints.gridy = 26;
/*  837 */     gridBagConstraints.fill = 2;
/*  838 */     this.jPanel4.add(this.jTextField117, gridBagConstraints);
/*      */     
/*  840 */     this.jPanel61.setBackground(new Color(255, 255, 255));
/*      */     
/*  842 */     this.jButton104.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  843 */     this.jButton104.setMnemonic('F');
/*  844 */     this.jButton104.setToolTipText("Filtrar información (Alt+F)");
/*  845 */     this.jButton104.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  847 */             Clientes.this.jButton104ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  851 */     this.jTextField118.setText("local");
/*  852 */     this.jTextField118.setEnabled(false);
/*  853 */     this.jTextField118.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  855 */             Clientes.this.jTextField118KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  859 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/*  860 */     this.jPanel61.setLayout(jPanel61Layout);
/*  861 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/*  862 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  863 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  864 */           .addComponent(this.jTextField118)
/*  865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  866 */           .addComponent(this.jButton104, -2, 20, -2)
/*  867 */           .addGap(0, 0, 0)));
/*      */     
/*  869 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/*  870 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  871 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  872 */           .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  873 */             .addComponent(this.jTextField118, -2, -1, -2)
/*  874 */             .addComponent(this.jButton104, -2, 24, -2))
/*  875 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  878 */     gridBagConstraints = new GridBagConstraints();
/*  879 */     gridBagConstraints.gridx = 12;
/*  880 */     gridBagConstraints.gridy = 26;
/*  881 */     gridBagConstraints.gridwidth = 9;
/*  882 */     gridBagConstraints.fill = 1;
/*  883 */     this.jPanel4.add(this.jPanel61, gridBagConstraints);
/*      */     
/*  885 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/*  886 */     this.jLabel22.setHorizontalAlignment(4);
/*  887 */     this.jLabel22.setText("Teléfono");
/*  888 */     gridBagConstraints = new GridBagConstraints();
/*  889 */     gridBagConstraints.gridx = 6;
/*  890 */     gridBagConstraints.gridy = 34;
/*  891 */     gridBagConstraints.anchor = 17;
/*  892 */     gridBagConstraints.weightx = 2.0D;
/*  893 */     this.jPanel4.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  895 */     this.jComboBox4.setBackground(new Color(255, 255, 255));
/*  896 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "TPAF01 - AUT. FED. DE CARGA GENERAL", "TPAF03 - AUT. FED. DE CARGA ESP. DE MAT Y RESIDUOS PELIGROSOS" }));
/*  897 */     gridBagConstraints = new GridBagConstraints();
/*  898 */     gridBagConstraints.gridx = 10;
/*  899 */     gridBagConstraints.gridy = 36;
/*  900 */     gridBagConstraints.gridwidth = 11;
/*  901 */     gridBagConstraints.fill = 2;
/*  902 */     this.jPanel4.add(this.jComboBox4, gridBagConstraints);
/*      */     
/*  904 */     this.jLabel16.setFont(new Font("Cantarell", 1, 11));
/*  905 */     this.jLabel16.setHorizontalAlignment(4);
/*  906 */     this.jLabel16.setText("<html><u>Nombre SAT</u></html>");
/*  907 */     this.jLabel16.setToolTipText("Éste nombre aparecere dentro la Cédula Fiscal, NO LLEVA SOCIEDAD");
/*  908 */     gridBagConstraints = new GridBagConstraints();
/*  909 */     gridBagConstraints.gridx = 6;
/*  910 */     gridBagConstraints.gridy = 8;
/*  911 */     gridBagConstraints.gridwidth = 3;
/*  912 */     gridBagConstraints.anchor = 17;
/*  913 */     gridBagConstraints.weightx = 2.0D;
/*  914 */     this.jPanel4.add(this.jLabel16, gridBagConstraints);
/*      */     
/*  916 */     this.jLabel17.setFont(new Font("Cantarell", 1, 11));
/*  917 */     this.jLabel17.setText("C.P. *");
/*  918 */     gridBagConstraints = new GridBagConstraints();
/*  919 */     gridBagConstraints.gridx = 6;
/*  920 */     gridBagConstraints.gridy = 20;
/*  921 */     gridBagConstraints.anchor = 17;
/*  922 */     gridBagConstraints.weightx = 2.0D;
/*  923 */     this.jPanel4.add(this.jLabel17, gridBagConstraints);
/*      */     
/*  925 */     this.jTextField200.setText("jTextField200");
/*  926 */     this.jTextField200.setEnabled(false);
/*  927 */     gridBagConstraints = new GridBagConstraints();
/*  928 */     gridBagConstraints.gridx = 10;
/*  929 */     gridBagConstraints.gridy = 16;
/*  930 */     gridBagConstraints.fill = 2;
/*  931 */     this.jPanel4.add(this.jTextField200, gridBagConstraints);
/*      */     
/*  933 */     this.jPanel62.setBackground(new Color(255, 255, 255));
/*      */     
/*  935 */     this.jButton105.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  936 */     this.jButton105.setMnemonic('F');
/*  937 */     this.jButton105.setToolTipText("Filtrar información (Alt+F)");
/*  938 */     this.jButton105.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  940 */             Clientes.this.jButton105ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  944 */     this.jTextField201.setText("jTextField201");
/*  945 */     this.jTextField201.setEnabled(false);
/*  946 */     this.jTextField201.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  948 */             Clientes.this.jTextField201ActionPerformed(evt);
/*      */           }
/*      */         });
/*  951 */     this.jTextField201.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  953 */             Clientes.this.jTextField201KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  957 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  958 */     this.jPanel62.setLayout(jPanel62Layout);
/*  959 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  960 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  962 */           .addComponent(this.jTextField201, -1, 374, 32767)
/*  963 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  964 */           .addComponent(this.jButton105, -2, 20, -2)
/*  965 */           .addGap(0, 0, 0)));
/*      */     
/*  967 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  968 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  969 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  970 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  971 */             .addComponent(this.jTextField201, -2, -1, -2)
/*  972 */             .addComponent(this.jButton105, -2, 24, -2))
/*  973 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  976 */     gridBagConstraints = new GridBagConstraints();
/*  977 */     gridBagConstraints.gridx = 12;
/*  978 */     gridBagConstraints.gridy = 16;
/*  979 */     gridBagConstraints.gridwidth = 9;
/*  980 */     gridBagConstraints.fill = 2;
/*  981 */     this.jPanel4.add(this.jPanel62, gridBagConstraints);
/*      */     
/*  983 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/*  984 */     this.jLabel18.setText("Régimen Fiscal");
/*  985 */     gridBagConstraints = new GridBagConstraints();
/*  986 */     gridBagConstraints.gridx = 6;
/*  987 */     gridBagConstraints.gridy = 16;
/*  988 */     gridBagConstraints.gridwidth = 3;
/*  989 */     gridBagConstraints.anchor = 17;
/*  990 */     gridBagConstraints.weightx = 2.0D;
/*  991 */     this.jPanel4.add(this.jLabel18, gridBagConstraints);
/*      */     
/*  993 */     this.jTextField202.setText("jTextField202");
/*  994 */     this.jTextField202.setEnabled(false);
/*  995 */     gridBagConstraints = new GridBagConstraints();
/*  996 */     gridBagConstraints.gridx = 10;
/*  997 */     gridBagConstraints.gridy = 18;
/*  998 */     gridBagConstraints.fill = 2;
/*  999 */     this.jPanel4.add(this.jTextField202, gridBagConstraints);
/*      */     
/* 1001 */     this.jPanel63.setBackground(new Color(255, 255, 255));
/*      */     
/* 1003 */     this.jButton106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1004 */     this.jButton106.setMnemonic('F');
/* 1005 */     this.jButton106.setToolTipText("Filtrar información (Alt+F)");
/* 1006 */     this.jButton106.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1008 */             Clientes.this.jButton106ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1012 */     this.jTextField203.setText("jTextField 203");
/* 1013 */     this.jTextField203.setEnabled(false);
/* 1014 */     this.jTextField203.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1016 */             Clientes.this.jTextField203ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1019 */     this.jTextField203.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1021 */             Clientes.this.jTextField203KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1025 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/* 1026 */     this.jPanel63.setLayout(jPanel63Layout);
/* 1027 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/* 1028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1029 */         .addGroup(jPanel63Layout.createSequentialGroup()
/* 1030 */           .addComponent(this.jTextField203, -1, 374, 32767)
/* 1031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1032 */           .addComponent(this.jButton106, -2, 20, -2)
/* 1033 */           .addGap(0, 0, 0)));
/*      */     
/* 1035 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/* 1036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1037 */         .addGroup(jPanel63Layout.createSequentialGroup()
/* 1038 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1039 */             .addComponent(this.jTextField203, -2, -1, -2)
/* 1040 */             .addComponent(this.jButton106, -2, 24, -2))
/* 1041 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/* 1044 */     gridBagConstraints = new GridBagConstraints();
/* 1045 */     gridBagConstraints.gridx = 12;
/* 1046 */     gridBagConstraints.gridy = 18;
/* 1047 */     gridBagConstraints.gridwidth = 9;
/* 1048 */     gridBagConstraints.fill = 2;
/* 1049 */     this.jPanel4.add(this.jPanel63, gridBagConstraints);
/*      */     
/* 1051 */     this.jLabel23.setFont(new Font("Cantarell", 1, 11));
/* 1052 */     this.jLabel23.setHorizontalAlignment(4);
/* 1053 */     this.jLabel23.setText("<html><u>Razón Social Completa</u></html>");
/* 1054 */     this.jLabel23.setToolTipText("Éste nombre aparecerá dentro el sistema, tarjeta deudor, guias, reportes.");
/* 1055 */     gridBagConstraints = new GridBagConstraints();
/* 1056 */     gridBagConstraints.gridx = 6;
/* 1057 */     gridBagConstraints.gridy = 10;
/* 1058 */     gridBagConstraints.gridwidth = 3;
/* 1059 */     gridBagConstraints.anchor = 17;
/* 1060 */     gridBagConstraints.weightx = 2.0D;
/* 1061 */     this.jPanel4.add(this.jLabel23, gridBagConstraints);
/*      */     
/* 1063 */     this.jTextField119.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1065 */             Clientes.this.jTextField119KeyReleased(evt);
/*      */           }
/*      */         });
/* 1068 */     gridBagConstraints = new GridBagConstraints();
/* 1069 */     gridBagConstraints.gridx = 10;
/* 1070 */     gridBagConstraints.gridy = 8;
/* 1071 */     gridBagConstraints.gridwidth = 11;
/* 1072 */     gridBagConstraints.fill = 2;
/* 1073 */     this.jPanel4.add(this.jTextField119, gridBagConstraints);
/*      */     
/* 1075 */     this.jLabel1.setFont(new Font("Cantarell", 1, 11));
/* 1076 */     this.jLabel1.setHorizontalAlignment(2);
/* 1077 */     this.jLabel1.setText("Tipo de Persona");
/* 1078 */     gridBagConstraints = new GridBagConstraints();
/* 1079 */     gridBagConstraints.gridx = 6;
/* 1080 */     gridBagConstraints.gridy = 14;
/* 1081 */     gridBagConstraints.fill = 2;
/* 1082 */     gridBagConstraints.anchor = 21;
/* 1083 */     this.jPanel4.add(this.jLabel1, gridBagConstraints);
/*      */     
/* 1085 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/* 1086 */     this.jPanel6.setLayout(new GridLayout(1, 3, 10, 6));
/*      */     
/* 1088 */     this.jRadioButton1.setText("Moral");
/* 1089 */     this.jPanel6.add(this.jRadioButton1);
/*      */     
/* 1091 */     this.jRadioButton2.setText("Física");
/* 1092 */     this.jPanel6.add(this.jRadioButton2);
/*      */     
/* 1094 */     this.jRadioButton3.setText("Extranjero");
/* 1095 */     this.jPanel6.add(this.jRadioButton3);
/*      */     
/* 1097 */     gridBagConstraints = new GridBagConstraints();
/* 1098 */     gridBagConstraints.gridx = 10;
/* 1099 */     gridBagConstraints.gridy = 14;
/* 1100 */     gridBagConstraints.gridwidth = 11;
/* 1101 */     gridBagConstraints.fill = 2;
/* 1102 */     this.jPanel4.add(this.jPanel6, gridBagConstraints);
/*      */     
/* 1104 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1105 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1106 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1107 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1108 */         .addComponent(this.jPanel21, -1, -1, 32767)
/* 1109 */         .addComponent(this.jPanel4, -1, 735, 32767));
/*      */     
/* 1111 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1112 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1113 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 1114 */           .addComponent(this.jPanel4, -1, 613, 32767)
/* 1115 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1116 */           .addComponent(this.jPanel21, -2, -1, -2)));
/*      */ 
/*      */     
/* 1119 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1120 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1121 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1122 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1123 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */     
/* 1125 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1126 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1127 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */ 
/*      */     
/* 1130 */     this.jDialog3.setTitle("Catálogo de Paises");
/*      */     
/* 1132 */     this.rSTableMetro12.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1140 */     this.rSTableMetro12.setAltoHead(25);
/* 1141 */     this.rSTableMetro12.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1142 */     this.rSTableMetro12.setColorBordeFilas(new Color(200, 200, 200));
/* 1143 */     this.rSTableMetro12.setColorBordeHead(this.lc.PRIMARIO1);
/* 1144 */     this.rSTableMetro12.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1145 */     this.rSTableMetro12.setColorFilasForeground1(new Color(102, 102, 102));
/* 1146 */     this.rSTableMetro12.setColorFilasForeground2(new Color(102, 102, 102));
/* 1147 */     this.rSTableMetro12.setColorSelBackgound(new Color(237, 107, 107));
/* 1148 */     this.rSTableMetro12.setFont(new Font("Cantarell", 0, 10));
/* 1149 */     this.rSTableMetro12.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1150 */     this.rSTableMetro12.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1151 */     this.rSTableMetro12.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1152 */     this.rSTableMetro12.setGrosorBordeFilas(0);
/* 1153 */     this.rSTableMetro12.setRowHeight(18);
/* 1154 */     this.rSTableMetro12.setSelectionBackground(this.lc.PRIMARIO2);
/* 1155 */     this.rSTableMetro12.getTableHeader().setResizingAllowed(false);
/* 1156 */     this.rSTableMetro12.getTableHeader().setReorderingAllowed(false);
/* 1157 */     this.rSTableMetro12.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1159 */             Clientes.this.rSTableMetro12MouseClicked(evt);
/*      */           }
/*      */         });
/* 1162 */     this.jScrollPane23.setViewportView((Component)this.rSTableMetro12);
/*      */     
/* 1164 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/* 1165 */     this.jPanel134.setLayout(jPanel134Layout);
/* 1166 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/* 1167 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1168 */         .addComponent(this.jScrollPane23, -1, 543, 32767));
/*      */     
/* 1170 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/* 1171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1172 */         .addComponent(this.jScrollPane23, -1, 223, 32767));
/*      */ 
/*      */     
/* 1175 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1176 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1177 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1179 */         .addGap(0, 543, 32767)
/* 1180 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1181 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */     
/* 1183 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1185 */         .addGap(0, 223, 32767)
/* 1186 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1187 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1190 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1192 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1194 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 1195 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 1196 */     this.jLabel98.setHorizontalAlignment(0);
/* 1197 */     this.jLabel98.setText("Clientes");
/*      */     
/* 1199 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1200 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1201 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1202 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1203 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*      */     
/* 1205 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1206 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1207 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1208 */           .addContainerGap()
/* 1209 */           .addComponent(this.jLabel98)
/* 1210 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1213 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 1214 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1216 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1218 */             Clientes.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1221 */     this.jPanel35.add(this.jTextField1);
/*      */     
/* 1223 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1225 */             Clientes.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1228 */     this.jPanel35.add(this.jTextField2);
/*      */     
/* 1230 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1232 */             Clientes.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1235 */     this.jPanel35.add(this.jTextField3);
/*      */     
/* 1237 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1238 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 1239 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1241 */             Clientes.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1244 */     this.jPanel35.add(this.jComboBox1);
/*      */     
/* 1246 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1247 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "ELIMINADOS", "TODOS" }));
/* 1248 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1250 */             Clientes.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1253 */     this.jPanel35.add(this.jComboBox2);
/*      */     
/* 1255 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1257 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 1258 */     this.jPanel12.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/* 1260 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1261 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1263 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1264 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 1265 */     this.jLabel99.setHorizontalAlignment(4);
/* 1266 */     this.jLabel99.setText("Total");
/* 1267 */     this.jPanel15.add(this.jLabel99);
/*      */     
/* 1269 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1270 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1271 */     this.jLabel100.setHorizontalAlignment(2);
/* 1272 */     this.jLabel100.setText("t");
/* 1273 */     this.jPanel15.add(this.jLabel100);
/*      */     
/* 1275 */     this.jPanel12.add(this.jPanel15);
/*      */     
/* 1277 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1279 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1280 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1281 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1283 */         .addGap(0, 52, 32767));
/*      */     
/* 1285 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1287 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1290 */     this.jPanel12.add(this.jPanel14);
/*      */     
/* 1292 */     this.jPanel16.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1294 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 1295 */     this.jPanel16.setLayout(jPanel16Layout);
/* 1296 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 1297 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1298 */         .addGap(0, 52, 32767));
/*      */     
/* 1300 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 1301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1302 */         .addGap(0, 37, 32767));
/*      */ 
/*      */     
/* 1305 */     this.jPanel12.add(this.jPanel16);
/*      */     
/* 1307 */     this.jButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1308 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1309 */     this.jButton1.setMnemonic('N');
/* 1310 */     this.jButton1.setText("Nuevo");
/* 1311 */     this.jButton1.setToolTipText("Nuevo(Alt + N)");
/* 1312 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1314 */             Clientes.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1317 */     this.jPanel12.add(this.jButton1);
/*      */     
/* 1319 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1320 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1321 */     this.jButton2.setMnemonic('M');
/* 1322 */     this.jButton2.setText("Modificar");
/* 1323 */     this.jButton2.setToolTipText("Modificar (Alt + M)");
/* 1324 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1326 */             Clientes.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1329 */     this.jPanel12.add(this.jButton2);
/*      */     
/* 1331 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1332 */     this.jButton4.setMnemonic('G');
/* 1333 */     this.jButton4.setText("Guardar Reporte");
/* 1334 */     this.jButton4.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1335 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1337 */             Clientes.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1340 */     this.jPanel12.add(this.jButton4);
/*      */     
/* 1342 */     this.jButton6.setMnemonic('G');
/* 1343 */     this.jButton6.setText("Activar RFC");
/* 1344 */     this.jButton6.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 1345 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1347 */             Clientes.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1350 */     this.jPanel12.add(this.jButton6);
/*      */     
/* 1352 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1360 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1365 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1368 */     this.rSTableMetro1.setAltoHead(40);
/* 1369 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1370 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 1371 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1372 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 1373 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1374 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1375 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1376 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1377 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1378 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1379 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1380 */     this.rSTableMetro1.setRowHeight(18);
/* 1381 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1382 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1383 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1384 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1386 */             Clientes.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1389 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1391 */             Clientes.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1394 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1396 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1397 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1398 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1399 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1400 */         .addComponent(this.jScrollPane13, -2, 0, 32767));
/*      */     
/* 1402 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1405 */           .addComponent(this.jScrollPane13, -1, 173, 32767)
/* 1406 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1409 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1410 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1411 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1413 */         .addComponent(this.jPanel12, -2, 400, 32767)
/* 1414 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/* 1416 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1418 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1419 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 1420 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1421 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 1422 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1425 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1426 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1427 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1428 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1429 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 1430 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 1431 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*      */     
/* 1433 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1435 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1436 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1438 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1439 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1440 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1443 */     GroupLayout layout = new GroupLayout(this);
/* 1444 */     setLayout(layout);
/* 1445 */     layout.setHorizontalGroup(layout
/* 1446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1447 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1449 */     layout.setVerticalGroup(layout
/* 1450 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1451 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */   }
/*      */   private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField107; private JTextField jTextField108; private JTextField jTextField109; private JTextField jTextField110; private JTextField jTextField111; private JTextField jTextField112; private JTextField jTextField113; private JTextField jTextField114; private JTextField jTextField115; private JTextField jTextField116; private JTextField jTextField117; private JTextField jTextField118; private JTextField jTextField119; private JTextField jTextField2; private JTextField jTextField200; private JTextField jTextField201; private JTextField jTextField202; private JTextField jTextField203; private JTextField jTextField3; private JTextField jTextField4; private MaterialButton materialButton1; private MaterialButton materialButton2; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro12; private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1456 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1460 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1464 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 1472 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1476 */     if (this.PRIMERA) {
/* 1477 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1482 */     limpiar();
/* 1483 */     activar();
/* 1484 */     this.jTextField116.setText("MEX");
/* 1485 */     this.jTextField112.setText("MÉXICO");
/* 1486 */     this.jCheckBox1.setEnabled(false);
/* 1487 */     this.jLabel13.setVisible(false);
/* 1488 */     this.jTextField101.setVisible(false);
/* 1489 */     this.materialButton1.setVisible(true);
/* 1490 */     this.materialButton1.setText("Guardar");
/* 1491 */     this.materialButton1.setToolTipText("Guardar (Alt + G)");
/* 1492 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1496 */     limpiar();
/* 1497 */     verDatos();
/* 1498 */     activar();
/* 1499 */     this.jLabel13.setVisible(true);
/* 1500 */     this.jTextField101.setVisible(true);
/* 1501 */     this.materialButton1.setVisible(true);
/* 1502 */     this.materialButton1.setText("Modificar");
/* 1503 */     this.materialButton1.setToolTipText("Modificar (Alt + M)");
/* 1504 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1508 */     String[] datos = { "NÚM", "RAZÓN SOCIAL", "NOMBRE CORTO", "C.P.", "CALLE", "NÚM", "COLONIA", "CIUDAD", "ESTADO", "ACTUALIZÓ" };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1513 */     this.esc = new EscribirReporte("CLIENTES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1517 */     if (evt.getClickCount() == 2) {
/* 1518 */       limpiar();
/* 1519 */       desactivar();
/* 1520 */       verDatos();
/* 1521 */       this.jLabel13.setVisible(true);
/* 1522 */       this.jTextField101.setVisible(true);
/* 1523 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1532 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 1544 */     consultar1Clientes();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1548 */     int suc = dameSucursal();
/* 1549 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 1550 */       this.con.consultar("rfc", "emp_generadora", "where clave_gene = " + String.valueOf(this.rSTableMetro1.getValueAt(i, 0)));
/* 1551 */       String rfc = this.con.Campo;
/* 1552 */       this.con2.inserSinMsj("insert into tras_origenes(num_o, id, rfc, nombre, cp, calle, num, col, ciudad, edo, comentarios, clientes, usuario, c_colonia, c_municipio, c_estado) values (" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1559 */           String.valueOf(this.rSTableMetro1.getValueAt(i, 0)) + ",'" + dameID(suc, this.rSTableMetro1.getValueAt(i, 0).toString()) + "', '" + rfc + "', '" + String.valueOf(this.rSTableMetro1.getValueAt(i, 1)) + "', '" + 
/* 1560 */           String.valueOf(this.rSTableMetro1.getValueAt(i, 3)) + "', '" + String.valueOf(this.rSTableMetro1.getValueAt(i, 4)) + "', '" + String.valueOf(this.rSTableMetro1.getValueAt(i, 5)) + "', '" + 
/* 1561 */           String.valueOf(this.rSTableMetro1.getValueAt(i, 6)) + "', '" + String.valueOf(this.rSTableMetro1.getValueAt(i, 7)) + "', '" + String.valueOf(this.rSTableMetro1.getValueAt(i, 8)) + "', '', '', '" + this.utilerias
/* 1562 */           .sacarUsuario("SICRET") + "', '','','')");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1569 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 1570 */       String num = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 1571 */       boolean esta = false;
/* 1572 */       for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/* 1573 */         String tarjeta = this.rSTableMetro2.getValueAt(j, 0).toString();
/* 1574 */         if (num.equals(tarjeta)) {
/* 1575 */           esta = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1579 */       if (!esta) {
/* 1580 */         this.con.inserSinMsj("update emp_generadora set activo = 'Eliminado' where clave_gene = " + num);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton2ActionPerformed(ActionEvent evt) {
/* 1586 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 1590 */     if (this.jTextField102.getText().equals("")) {
/* 1591 */       this.jTextField102.setBackground(Color.RED);
/* 1592 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el RFC", "Falta el RFC", 0, this.ERROR);
/* 1593 */     } else if (this.jTextField102.getText().contains(" ")) {
/* 1594 */       this.jTextField102.setBackground(Color.RED);
/* 1595 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes ingresar espacios en el campo del RFC", "Espacios detectados", 0, this.ERROR);
/* 1596 */     } else if (this.jTextField102.getText().length() < 12) {
/* 1597 */       this.jTextField102.setBackground(Color.RED);
/* 1598 */       JOptionPane.showMessageDialog(this.jDialog2, "<html>Te faltan caracteres en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1603 */     else if (this.jTextField102.getText().length() > 13) {
/* 1604 */       this.jTextField102.setBackground(Color.RED);
/* 1605 */       JOptionPane.showMessageDialog(this.jDialog2, "<html>Caracteres de más en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1610 */     else if (!validarRFC(this.jTextField102.getText())) {
/* 1611 */       this.jTextField102.setBackground(Color.RED);
/* 1612 */       String mensaje = "<html><body><b>¡RFC INCORRECTO!</b><br><br><b>Para capturar el RFC correctamente, ten en cuenta lo siguiente:</b><br><br><b>Persona Física:</b><br>1. El RFC consta de 13 caracteres.<br>2. Los primeros 4 caracteres son las primeras letras del apellido paterno.<br>3. Los siguientes 6 caracteres son la fecha de nacimiento en formato AA-MM-DD.<br>4. Los últimos 3 caracteres son homoclave (pueden ser letras o números).<br><br><b>Ejemplo: GOME900101ABC</b><br><br><b>Persona Moral:</b><br>1. El RFC consta de 12 caracteres.<br>2. Los primeros 3 caracteres son las primeras letras de la razón social.<br>3. Los siguientes 6 caracteres son la fecha de constitución en formato AA-MM-DD.<br>4. Los últimos 3 caracteres son homoclave (pueden ser letras o números).<br><br><b>Ejemplo: EMP200101ABC</b><br><br><b>¡Asegúrate de capturar correctamente tu RFC!</b><br>Presiona Aceptar para continuar.</body></html>";
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1628 */       JOptionPane.showMessageDialog(this, mensaje, "Instrucciones para capturar el RFC", 0, this.ERROR);
/*      */     }
/* 1630 */     else if (this.jTextField119.getText().equals("")) {
/* 1631 */       this.jTextField119.setBackground(Color.RED);
/* 1632 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el nombre del cliente", "Falta la razón social", 0, this.ERROR);
/* 1633 */     } else if (this.jTextField103.getText().equals("")) {
/* 1634 */       this.jTextField103.setBackground(Color.RED);
/* 1635 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar la razón social o nombre del cliente", "Falta la razón social", 0, this.ERROR);
/* 1636 */     } else if (this.jTextField104.getText().equals("")) {
/* 1637 */       this.jTextField104.setBackground(Color.RED);
/* 1638 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el nombre del corto del cliente", "Falta el nombre corto", 0, this.ERROR);
/* 1639 */     } else if (this.jTextField103.getText().equals(this.jTextField104.getText())) {
/* 1640 */       this.jTextField103.setBackground(Color.RED);
/* 1641 */       this.jTextField104.setBackground(Color.RED);
/* 1642 */       JOptionPane.showMessageDialog(this.jDialog2, "La información debe ser diferente", "Ingresar nombre corto o nombre comercial", 0, this.ERROR);
/* 1643 */     } else if (this.jTextField105.getText().equals("")) {
/* 1644 */       this.jTextField105.setBackground(Color.RED);
/* 1645 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar las iniciales del cliente", "Faltan las iniciales", 0, this.ERROR);
/* 1646 */     } else if (this.jTextField200.getText().equals("")) {
/* 1647 */       this.jTextField200.setBackground(Color.RED);
/* 1648 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el régimen del cliente", "Falta el régimen", 0, this.ERROR);
/* 1649 */     } else if (this.jTextField202.getText().equals("")) {
/* 1650 */       this.jTextField202.setBackground(Color.RED);
/* 1651 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el uso del CFDI", "Falta ingresar el Uso del CFDI", 0, this.ERROR);
/* 1652 */     } else if (this.jTextField117.getText().equals("")) {
/* 1653 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar la localidad", "Falta la razón Localidad", 0, this.ERROR);
/* 1654 */     } else if (this.jTextField106.getText().equals("")) {
/* 1655 */       this.jTextField106.setBackground(Color.RED);
/* 1656 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el Código Postal", "Falta el código postal", 0, this.ERROR);
/* 1657 */     } else if (this.jTextField107.getText().equals("")) {
/* 1658 */       this.jTextField107.setBackground(Color.RED);
/* 1659 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar la calle", "Falta la calle", 0, this.ERROR);
/* 1660 */     } else if (this.jTextField104.getText().equals("")) {
/* 1661 */       this.jTextField104.setBackground(Color.RED);
/* 1662 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar el nombre del corto del cliente", "Falta el nombre corto", 0, this.ERROR);
/* 1663 */     } else if (this.jTextField115.getText().equals("")) {
/* 1664 */       this.jTextField115.setBackground(Color.RED);
/* 1665 */       JOptionPane.showMessageDialog(this.jDialog2, "Falta ingresar la clave del estado", "Falta el estado", 0, this.ERROR);
/*      */     } else {
/* 1667 */       String persona = "";
/* 1668 */       if (this.jRadioButton1.isSelected()) {
/* 1669 */         persona = "PERSONA_MORAL";
/* 1670 */       } else if (this.jRadioButton2.isSelected()) {
/* 1671 */         persona = "PERSONA_FISICA";
/* 1672 */       } else if (this.jRadioButton3.isSelected()) {
/* 1673 */         persona = "EXTRANJERO";
/*      */       } 
/* 1675 */       String SCT = this.jComboBox4.getSelectedItem().toString().substring(0, 6);
/* 1676 */       if (this.materialButton1.getText().equals("Guardar")) {
/* 1677 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas guardar la información del nuevo cliente?", "Crear Cliente", 0, 3, this.PREG);
/* 1678 */         if (res == 0) {
/* 1679 */           this.con.inserSinMsj("insert into emp_generadora (rfc, empresa, nombre_corto, iniciales, cp, calle, num, col, ciudad, edo, origen, telefono, activo, codigopais, pais, usuario, c_colonia, c_municipio, c_estado, id_edo, c_localidad, localidad, sct, razonSocialSAT, regimenFiscalClave, regimenFiscalDesc, usoCFDIClave, usoCFDIDesc, personaTipo) values('" + this.jTextField102
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1689 */               .getText().toUpperCase() + "', '" + this.jTextField103.getText().toUpperCase() + "', '" + this.jTextField104.getText().toUpperCase() + "', '" + this.jTextField105
/* 1690 */               .getText().toUpperCase() + "', '" + this.jTextField106.getText().toUpperCase() + "', '" + this.jTextField107.getText().toUpperCase() + "', '" + this.jTextField108
/* 1691 */               .getText().toUpperCase() + "', '" + this.jTextField109.getText().toUpperCase() + "', '" + this.jTextField110.getText().toUpperCase() + "', '" + this.jTextField111
/* 1692 */               .getText().toUpperCase() + "', '', '" + this.jFormattedTextField1.getText() + "','Activado', '" + this.jTextField116
/* 1693 */               .getText().toUpperCase() + "', '" + this.jTextField112.getText().toUpperCase() + "', '" + this.utilerias
/* 1694 */               .sacarUsuario(this.USUARIO) + "', '" + this.jTextField113.getText().toUpperCase() + "', '" + this.jTextField114.getText().toUpperCase() + "', '" + this.jTextField115.getText().toUpperCase() + "', 33, '" + this.jTextField117.getText() + "', '" + this.jTextField118.getText() + "', '" + SCT + "', '" + this.jTextField119
/* 1695 */               .getText().toUpperCase() + "', '" + this.jTextField200.getText().toUpperCase() + "', '" + this.jTextField201.getText().toUpperCase() + "', '" + this.jTextField202
/* 1696 */               .getText().toUpperCase() + "', '" + this.jTextField203.getText().toUpperCase() + "', '" + persona + "')");
/*      */           
/* 1698 */           this.jDialog2.setVisible(false);
/* 1699 */           consultar();
/*      */         } 
/*      */       } else {
/* 1702 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar el cliente?", "Modificar Cliente", 0, 3, this.PREG);
/* 1703 */         if (res == 0) {
/* 1704 */           String activo = "";
/* 1705 */           if (this.jCheckBox1.isSelected()) {
/* 1706 */             activo = "Eliminado";
/*      */           } else {
/* 1708 */             activo = "Activado";
/*      */           } 
/* 1710 */           this.con.inserSinMsj("update emp_generadora set rfc = '" + this.jTextField102
/* 1711 */               .getText().toUpperCase() + "', razonSocialSAT = '" + this.jTextField119
/* 1712 */               .getText().toUpperCase() + "', regimenFiscalClave = '" + this.jTextField200
/* 1713 */               .getText().toUpperCase() + "', regimenFiscalDesc = '" + this.jTextField201
/* 1714 */               .getText().toUpperCase() + "', usoCFDIClave = '" + this.jTextField202
/* 1715 */               .getText().toUpperCase() + "', usoCFDIDesc = '" + this.jTextField203
/* 1716 */               .getText().toUpperCase() + "', empresa = '" + this.jTextField103
/* 1717 */               .getText().toUpperCase() + "', nombre_corto = '" + this.jTextField104
/* 1718 */               .getText().toUpperCase() + "', iniciales = '" + this.jTextField105
/* 1719 */               .getText().toUpperCase() + "', cp = '" + this.jTextField106
/* 1720 */               .getText().toUpperCase() + "', calle = '" + this.jTextField107
/* 1721 */               .getText().toUpperCase() + "', num = '" + this.jTextField108
/* 1722 */               .getText().toUpperCase() + "', col = '" + this.jTextField109
/* 1723 */               .getText().toUpperCase() + "', ciudad = '" + this.jTextField110
/* 1724 */               .getText().toUpperCase() + "', edo = '" + this.jTextField111
/* 1725 */               .getText().toUpperCase() + "', telefono = '" + this.jFormattedTextField1
/* 1726 */               .getText() + "', activo = '" + activo + "', codigopais = '" + this.jTextField116
/*      */               
/* 1728 */               .getText().toUpperCase() + "', pais = '" + this.jTextField112
/* 1729 */               .getText().toUpperCase() + "', c_colonia = '" + this.jTextField113
/* 1730 */               .getText().toUpperCase() + "', c_municipio = '" + this.jTextField114
/* 1731 */               .getText().toUpperCase() + "', c_estado = '" + this.jTextField115
/* 1732 */               .getText().toUpperCase() + "', usuario = '" + this.utilerias
/* 1733 */               .sacarUsuario(this.USUARIO) + "', c_localidad = '" + this.jTextField117
/* 1734 */               .getText().toUpperCase() + "', localidad = '" + this.jTextField118
/* 1735 */               .getText().toUpperCase() + "', sct = '" + SCT + "', personaTipo = '" + persona + "'where clave_gene = " + this.jTextField101
/*      */ 
/*      */               
/* 1738 */               .getText());
/*      */ 
/*      */           
/* 1741 */           this.con.inserSinMsj("update tarjeta_deudor_cliente set nombreCompleto = '" + this.jTextField103
/* 1742 */               .getText().toUpperCase() + "', nombre_corto = '" + this.jTextField104
/* 1743 */               .getText().toUpperCase() + "', usuario_creo = '" + this.USUARIO + "' where clave_gene = " + this.jTextField101
/*      */               
/* 1745 */               .getText());
/* 1746 */           this.jDialog2.setVisible(false);
/* 1747 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField103KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField102KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton101ActionPerformed(ActionEvent evt) {
/* 1770 */     this.CLAVECATALOGO = new TreeMap<>();
/* 1771 */     new TrasColonias(this.jDialog2, true, this.jButton101, "tras_codigos_postales", this.CLAVECATALOGO, "", true);
/* 1772 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1773 */       this.jTextField106.setText(this.CLAVECATALOGO.get("2"));
/* 1774 */       this.jTextField113.setText("");
/* 1775 */       this.jTextField109.setText("");
/* 1776 */       habilitarDir();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField106ActionPerformed(ActionEvent evt) {
/* 1781 */     habilitarDir();
/*      */   }
/*      */   
/*      */   private void jTextField106KeyReleased(KeyEvent evt) {
/* 1785 */     this.utilerias.boorarCodigoPostal(this.jTextField106, this.jTextField107, this.jTextField108, this.jTextField109, this.jTextField110, this.jTextField111, this.jTextField113, this.jTextField114, this.jTextField115, this.materialButton1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField107KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField108KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton102ActionPerformed(ActionEvent evt) {
/* 1809 */     this.CLAVECATALOGO.clear();
/* 1810 */     new TrasColonias(this.jDialog2, true, this.jButton102, "tras_colonias", this.CLAVECATALOGO, this.jTextField106.getText(), true);
/* 1811 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1812 */       this.jTextField113.setText(this.CLAVECATALOGO.get("1"));
/* 1813 */       this.jTextField109.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */     
/* 1816 */     String nuevoCod = this.CLAVECATALOGO.get("3");
/* 1817 */     String viejoCod = this.jTextField106.getText();
/*      */     
/* 1819 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1820 */       if (!nuevoCod.equals(viejoCod)) {
/* 1821 */         this.jTextField106.setText(nuevoCod);
/* 1822 */         habilitarDir();
/*      */       } 
/* 1824 */       this.jTextField109.setToolTipText(this.jTextField109.getText());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField109KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField110KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 1841 */     int cont = 0;
/* 1842 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 1843 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 1844 */       this.jFormattedTextField1.setValue("");
/* 1845 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 1846 */       String cadena = this.jFormattedTextField1.getText();
/* 1847 */       String cad1 = cadena.substring(0, 3);
/* 1848 */       String cad2 = cadena.substring(4, 7);
/* 1849 */       String cad3 = cadena.substring(8, 12);
/* 1850 */       String tel = cad1 + cad1 + cad2;
/* 1851 */       for (int i = 1; i < tel.length(); i++) {
/* 1852 */         char c = tel.charAt(i - 1);
/* 1853 */         char d = tel.charAt(i);
/* 1854 */         if (c != d) {
/* 1855 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 1859 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 1860 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 1861 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton103ActionPerformed(ActionEvent evt) {
/* 1866 */     Dimension di = this.jButton103.getSize();
/* 1867 */     Point p = this.jButton103.getLocationOnScreen();
/* 1868 */     this.jDialog3.setLocation(p.x + di.width - 200, p.y + 30);
/* 1869 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField116KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro12MouseClicked(MouseEvent evt) {
/* 1877 */     if (evt.getClickCount() == 2) {
/* 1878 */       this.jTextField116.setText(this.rSTableMetro12.getValueAt(this.rSTableMetro12.getSelectedRow(), 0).toString());
/* 1879 */       this.jTextField112.setText(this.rSTableMetro12.getValueAt(this.rSTableMetro12.getSelectedRow(), 1).toString());
/* 1880 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton104ActionPerformed(ActionEvent evt) {
/* 1885 */     this.CLAVECATALOGO = new TreeMap<>();
/* 1886 */     new TrasColonias(this.jDialog2, true, this.jButton104, "tras_localidades", this.CLAVECATALOGO, this.jTextField115.getText(), true);
/* 1887 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1888 */       this.jTextField117.setText(this.CLAVECATALOGO.get("1"));
/* 1889 */       this.jTextField118.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField118KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton105ActionPerformed(ActionEvent evt) {
/* 1898 */     this.CLAVECATALOGO.clear();
/* 1899 */     new TrasColonias(this.jDialog2, true, this.jButton105, "fact_regimenfiscal", this.CLAVECATALOGO, "", true);
/* 1900 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1901 */       this.jTextField200.setText(this.CLAVECATALOGO.get("1"));
/* 1902 */       this.jTextField201.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField201ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField201KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton106ActionPerformed(ActionEvent evt) {
/* 1915 */     this.CLAVECATALOGO.clear();
/* 1916 */     new TrasColonias(this.jDialog2, true, this.jButton106, "fact_usocfdi", this.CLAVECATALOGO, "", true);
/* 1917 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1918 */       this.jTextField202.setText(this.CLAVECATALOGO.get("1"));
/* 1919 */       this.jTextField203.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField203ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField203KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField119KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField103FocusGained(FocusEvent evt) {
/* 1936 */     if (!this.jTextField119.getText().equals("") && this.jTextField103.getText().equals("")) {
/* 1937 */       this.jTextField103.setText(this.jTextField119.getText().toUpperCase());
/* 1938 */       String cad = "";
/* 1939 */       String iniciales = "";
/* 1940 */       String v = this.jTextField119.getText().toUpperCase();
/* 1941 */       String[] campos = v.split(" ");
/* 1942 */       int indice = 0;
/*      */       
/* 1944 */       for (String e : campos) {
/* 1945 */         if (e.length() > 2) {
/* 1946 */           cad = cad + cad + " ";
/* 1947 */           indice++;
/* 1948 */           iniciales = iniciales + iniciales;
/* 1949 */           if (indice > 2) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1955 */       cad = cad.replaceAll(",", "");
/* 1956 */       String temp = cad.replace(".", "");
/* 1957 */       if (this.jTextField104.getText().equals("")) {
/* 1958 */         this.jTextField104.setText(temp.substring(0, temp.length() - 1));
/*      */       }
/* 1960 */       if (this.jTextField105.getText().equals("")) {
/* 1961 */         this.jTextField105.setText(iniciales);
/*      */       }
/*      */     } 
/*      */     
/* 1965 */     this.RFCTIPO = validarRFCTipo(this.jTextField102.getText());
/* 1966 */     if (this.RFCTIPO.equals(RFCTipo.PERSONA_MORAL)) {
/* 1967 */       this.jRadioButton1.setSelected(true);
/* 1968 */     } else if (this.RFCTIPO.equals(RFCTipo.PERSONA_FISICA)) {
/* 1969 */       this.jRadioButton2.setSelected(true);
/* 1970 */     } else if (this.RFCTIPO.equals(RFCTipo.EXTRANJERO)) {
/* 1971 */       this.jRadioButton3.setSelected(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1976 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 1977 */       String col = this.rSTableMetro1.getValueAt(i, 9).toString();
/* 1978 */       if (!col.equals("")) {
/* 1979 */         String clave = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 1980 */         this.con.consultar("rfc", "emp_generadora", "where clave_gene = " + clave);
/* 1981 */         this.RFCTIPO = validarRFCTipo(this.con.Campo);
/* 1982 */         this.con.inserSinMsj("update emp_generadora set personaTipo = '" + String.valueOf(this.RFCTIPO) + "' where clave_gene = " + clave);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean validarRFC(String rfc) {
/* 1989 */     String rfcRegex = "^([A-Z&Ñ]{3}|[A-Z][AEIOU][A-Z]{2})\\d{6}([A-Z0-9]{3})?$";
/* 1990 */     Pattern pattern = Pattern.compile(rfcRegex);
/* 1991 */     Matcher matcher = pattern.matcher(rfc);
/*      */     
/* 1993 */     return matcher.matches();
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 1997 */     if (!this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 1998 */       this.jButton1.setEnabled(false);
/* 1999 */       this.jButton2.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCodigos() {
/* 2004 */     this.com_ListaCodigos = new TextAutoCompleter(this.jTextField106, this.LISTACODIGOS);
/*      */   }
/*      */   
/*      */   public void llenarCatPaises() {
/* 2008 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro12, new String[] { "Pais", "Descripción" }, "pais,descripcion", "catpaises", "order by descripcion");
/*      */ 
/*      */ 
/*      */     
/* 2012 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro12, 0, 70);
/* 2013 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro12);
/*      */   }
/*      */   
/*      */   public void verDatos() {
/* 2017 */     String[] datos = this.con.regresaRegIndex("clave_gene, rfc, empresa, nombre_corto, iniciales, cp, calle, num, col, ciudad, edo, telefono, activo, codigopais, pais, c_colonia, c_municipio, c_estado, c_localidad, localidad, sct, razonSocialSAT, regimenFiscalClave, regimenFiscalDesc, usoCFDIClave, usoCFDIDesc, personaTipo", "emp_generadora", "where clave_gene = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2026 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */     
/* 2028 */     this.jTextField119.setText(datos[21]);
/*      */     
/* 2030 */     this.jTextField200.setText(datos[22]);
/* 2031 */     this.jTextField201.setText(datos[23]);
/*      */     
/* 2033 */     this.jTextField202.setText(datos[24]);
/* 2034 */     this.jTextField203.setText(datos[25]);
/*      */     
/* 2036 */     if (datos[20].equals("TPAF01")) {
/* 2037 */       this.jComboBox4.setSelectedIndex(0);
/* 2038 */     } else if (datos[20].equals("TPAF03")) {
/* 2039 */       this.jComboBox4.setSelectedIndex(1);
/*      */     } 
/* 2041 */     this.jTextField101.setText(datos[0]);
/* 2042 */     this.jTextField102.setText(datos[1]);
/* 2043 */     this.jTextField103.setText(datos[2]);
/* 2044 */     this.jTextField104.setText(datos[3]);
/* 2045 */     this.jTextField105.setText(datos[4]);
/* 2046 */     this.jTextField106.setText(datos[5]);
/* 2047 */     this.jTextField107.setText(datos[6]);
/* 2048 */     this.jTextField108.setText(datos[7]);
/* 2049 */     this.jTextField109.setText(datos[8]);
/* 2050 */     this.jTextField110.setText(datos[9]);
/* 2051 */     this.jTextField111.setText(datos[10]);
/* 2052 */     this.jFormattedTextField1.setText(datos[11]);
/* 2053 */     System.out.println("activado " + datos[12]);
/* 2054 */     if (datos[12].equals("Activado")) {
/* 2055 */       this.jCheckBox1.setSelected(false);
/*      */     } else {
/* 2057 */       this.jCheckBox1.setSelected(true);
/*      */     } 
/* 2059 */     this.jTextField116.setText(datos[13]);
/* 2060 */     this.jTextField112.setText(datos[14]);
/* 2061 */     this.jTextField113.setText(datos[15]);
/* 2062 */     this.jTextField114.setText(datos[16]);
/* 2063 */     this.jTextField115.setText(datos[17]);
/*      */     
/* 2065 */     this.jTextField117.setText(datos[18]);
/* 2066 */     this.jTextField118.setText(datos[19]);
/*      */     
/* 2068 */     String tipo = datos[26];
/*      */     
/* 2070 */     if (tipo.equals("PERSONA_MORAL")) {
/* 2071 */       this.jRadioButton1.setSelected(true);
/* 2072 */     } else if (tipo.equals("PERSONA_FISICA")) {
/* 2073 */       this.jRadioButton2.setSelected(true);
/* 2074 */     } else if (tipo.equals("EXTRANJERO")) {
/* 2075 */       this.jRadioButton3.setSelected(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void habilitarDir() {
/* 2080 */     String cod = this.jTextField106.getText();
/* 2081 */     if (this.LISTACODIGOS.contains(cod)) {
/* 2082 */       this.jTextField107.setEnabled(true);
/* 2083 */       this.jTextField108.setEnabled(true);
/* 2084 */       this.jButton2.setEnabled(true);
/*      */       
/* 2086 */       Tras_codigos c = ((List<Tras_codigos>)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(cod)).collect(Collectors.toList())).get(0);
/* 2087 */       this.con2.consultar("estado", "tras_estados", "where c_estado = '" + c.getC_estado() + "'");
/* 2088 */       this.jTextField111.setText(this.con2.Campo);
/* 2089 */       ((List)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(cod)).collect(Collectors.toList())).forEach(x -> {
/*      */             this.jTextField114.setText(x.getC_Municipio());
/*      */             
/*      */             this.jTextField110.setText(x.getCiudad());
/*      */           });
/* 2094 */       this.jTextField115.setText(c.getC_estado());
/*      */     } else {
/*      */       
/* 2097 */       this.jTextField107.setEnabled(false);
/* 2098 */       this.jTextField108.setEnabled(false);
/* 2099 */       this.jTextField109.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   public enum RFCTipo {
/* 2104 */     PERSONA_FISICA,
/* 2105 */     PERSONA_MORAL,
/* 2106 */     EXTRANJERO,
/* 2107 */     INVALIDO;
/*      */   }
/*      */ 
/*      */   
/*      */   public RFCTipo validarRFCTipo(String rfc) {
/* 2112 */     int rfcLength = rfc.length();
/* 2113 */     if (rfcLength != 12 && rfcLength != 13 && rfcLength != 18 && rfcLength != 16) {
/* 2114 */       return RFCTipo.INVALIDO;
/*      */     }
/*      */     
/* 2117 */     char c1 = rfc.charAt(0);
/* 2118 */     char c2 = rfc.charAt(3);
/*      */     
/* 2120 */     if (rfc.equals("XEXX010101000"))
/*      */     {
/* 2122 */       return RFCTipo.EXTRANJERO; } 
/* 2123 */     if (Character.isLetter(c1) && Character.isDigit(c2))
/*      */     {
/* 2125 */       return RFCTipo.PERSONA_MORAL; } 
/* 2126 */     if (Character.isLetter(c1) && Character.isLetter(c2))
/*      */     {
/* 2128 */       return RFCTipo.PERSONA_FISICA;
/*      */     }
/*      */     
/* 2131 */     return RFCTipo.INVALIDO;
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 2135 */     this.jTextField102.setEnabled(false);
/* 2136 */     this.jTextField103.setEnabled(false);
/* 2137 */     this.jTextField104.setEnabled(false);
/* 2138 */     this.jTextField105.setEnabled(false);
/* 2139 */     this.jTextField106.setEnabled(false);
/* 2140 */     this.jTextField107.setEnabled(false);
/* 2141 */     this.jTextField119.setEnabled(false);
/*      */     
/* 2143 */     this.jFormattedTextField1.setEnabled(false);
/* 2144 */     this.jCheckBox1.setEnabled(false);
/* 2145 */     this.jButton101.setEnabled(false);
/* 2146 */     this.jButton102.setEnabled(false);
/* 2147 */     this.jButton103.setEnabled(false);
/* 2148 */     this.jButton104.setEnabled(false);
/* 2149 */     this.jButton105.setEnabled(false);
/* 2150 */     this.jButton106.setEnabled(false);
/* 2151 */     this.materialButton1.setVisible(false);
/* 2152 */     this.jComboBox4.setEnabled(false);
/*      */     
/* 2154 */     this.jRadioButton1.setEnabled(false);
/* 2155 */     this.jRadioButton2.setEnabled(false);
/* 2156 */     this.jRadioButton3.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void activar() {
/* 2160 */     this.jTextField102.setEnabled(true);
/* 2161 */     this.jTextField103.setEnabled(true);
/* 2162 */     this.jTextField104.setEnabled(true);
/* 2163 */     this.jTextField105.setEnabled(true);
/* 2164 */     this.jTextField106.setEnabled(true);
/* 2165 */     this.jTextField119.setEnabled(true);
/* 2166 */     this.jFormattedTextField1.setEnabled(true);
/* 2167 */     this.jCheckBox1.setEnabled(true);
/* 2168 */     this.jButton101.setEnabled(true);
/* 2169 */     this.jButton102.setEnabled(true);
/* 2170 */     this.jButton103.setEnabled(true);
/* 2171 */     this.jComboBox4.setEnabled(true);
/* 2172 */     this.jButton104.setEnabled(true);
/* 2173 */     this.jButton105.setEnabled(true);
/* 2174 */     this.jButton106.setEnabled(true);
/*      */     
/* 2176 */     this.jRadioButton1.setEnabled(true);
/* 2177 */     this.jRadioButton2.setEnabled(true);
/* 2178 */     this.jRadioButton3.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2182 */     this.jTextField101.setText("");
/* 2183 */     this.jTextField102.setText("");
/* 2184 */     this.jTextField103.setText("");
/* 2185 */     this.jTextField104.setText("");
/* 2186 */     this.jTextField105.setText("");
/* 2187 */     this.jTextField106.setText("");
/* 2188 */     this.jTextField107.setText("");
/* 2189 */     this.jTextField108.setText("");
/* 2190 */     this.jTextField109.setText("");
/* 2191 */     this.jTextField110.setText("");
/* 2192 */     this.jTextField111.setText("");
/* 2193 */     this.jTextField112.setText("");
/* 2194 */     this.jTextField113.setText("");
/* 2195 */     this.jTextField114.setText("");
/* 2196 */     this.jTextField115.setText("");
/* 2197 */     this.jTextField116.setText("");
/* 2198 */     this.jTextField117.setText("");
/* 2199 */     this.jTextField118.setText("");
/*      */     
/* 2201 */     this.jTextField119.setText("");
/* 2202 */     this.jTextField200.setText("");
/* 2203 */     this.jTextField201.setText("");
/* 2204 */     this.jTextField202.setText("");
/* 2205 */     this.jTextField203.setText("");
/*      */     
/* 2207 */     this.jRadioButton1.setSelected(true);
/*      */     
/* 2209 */     this.jFormattedTextField1.setText("");
/* 2210 */     this.jCheckBox1.setSelected(false);
/* 2211 */     this.jTextField107.setEnabled(false);
/* 2212 */     this.jTextField108.setEnabled(false);
/* 2213 */     this.jComboBox4.setSelectedIndex(0);
/*      */   }
/*      */   
/*      */   public int dameSucursal() {
/* 2217 */     int num = 0;
/* 2218 */     this.SUCURSAL = this.CAMPOSGENERALES.get("sucursal");
/* 2219 */     if (this.SUCURSAL.equals("CADEREYTA")) {
/* 2220 */       num = 1;
/* 2221 */     } else if (this.SUCURSAL.equals("VERACRUZ")) {
/* 2222 */       num = 2;
/* 2223 */     } else if (this.SUCURSAL.equals("POZA RICA")) {
/* 2224 */       num = 3;
/* 2225 */     } else if (this.SUCURSAL.equals("CARDENAS")) {
/* 2226 */       num = 4;
/*      */     } 
/* 2228 */     return num;
/*      */   }
/*      */   
/*      */   public String dameID(int num, String clave_gene) {
/* 2232 */     int id = Integer.parseInt(clave_gene);
/* 2233 */     String clave = "";
/* 2234 */     if (id < 10) {
/* 2235 */       clave = "" + num + "0000" + num;
/* 2236 */     } else if (id < 100) {
/* 2237 */       clave = "" + num + "000" + num;
/* 2238 */     } else if (id < 1000) {
/* 2239 */       clave = "" + num + "00" + num;
/* 2240 */     } else if (id < 10000) {
/* 2241 */       clave = "" + num + "0" + num;
/*      */     } else {
/* 2243 */       clave = "" + num + num;
/*      */     } 
/* 2245 */     return "OR" + clave;
/*      */   }
/*      */   
/*      */   public void clientes(String usua) {
/* 2249 */     privilegios();
/* 2250 */     this.USUARIO = usua;
/* 2251 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void llenarCampoEstados() {
/* 2255 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 2256 */       this.con.consultar("estado", "emp_generadora, estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene = " + String.valueOf(this.rSTableMetro1.getValueAt(i, 0)));
/* 2257 */       this.con.inserSinMsj("update emp_generadora set edo = '" + this.con.Campo + "' where clave_gene = " + String.valueOf(this.rSTableMetro1.getValueAt(i, 0)));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verPrimeraVez() {
/* 2262 */     if (this.USUARIO.equals("KOFUZ01")) {
/* 2263 */       JOptionPane.showMessageDialog(this, "Activando privilegios para KOFUZ01");
/* 2264 */       String edo = this.rSTableMetro1.getValueAt(0, 8).toString();
/* 2265 */       if (edo.equals("")) {
/* 2266 */         llenarCampoEstados();
/*      */       }
/* 2268 */       int res = JOptionPane.showConfirmDialog(this, "Deseas ver los datos de tarjetas deudor", "Tarjetas", 0, 3, this.PREG);
/* 2269 */       if (res == 0) {
/* 2270 */         this.utilerias.activarVentanajDialog(this.jDialog1, 800, 650);
/* 2271 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2277 */     this.pintar.colorear(this.jTextField1);
/* 2278 */     this.pintar.colorear(this.jTextField2);
/* 2279 */     this.pintar.colorear(this.jTextField3);
/* 2280 */     this.pintar.colorear(this.jTextField4);
/* 2281 */     this.pintar.colorear(this.jComboBox1);
/* 2282 */     this.pintar.colorear(this.jComboBox2);
/* 2283 */     this.pintar.colorear(this.jComboBox4);
/*      */     
/* 2285 */     this.pintar.colorear(this.jTextField101);
/* 2286 */     this.pintar.colorear(this.jTextField102);
/* 2287 */     this.pintar.colorear(this.jTextField103);
/* 2288 */     this.pintar.colorear(this.jTextField104);
/* 2289 */     this.pintar.colorear(this.jTextField105);
/* 2290 */     this.pintar.colorear(this.jTextField106);
/* 2291 */     this.pintar.colorear(this.jTextField107);
/* 2292 */     this.pintar.colorear(this.jTextField108);
/* 2293 */     this.pintar.colorear(this.jTextField109);
/* 2294 */     this.pintar.colorear(this.jTextField110);
/* 2295 */     this.pintar.colorear(this.jTextField111);
/* 2296 */     this.pintar.colorear(this.jTextField112);
/* 2297 */     this.pintar.colorear(this.jTextField113);
/* 2298 */     this.pintar.colorear(this.jTextField114);
/* 2299 */     this.pintar.colorear(this.jTextField115);
/* 2300 */     this.pintar.colorear(this.jTextField116);
/*      */     
/* 2302 */     this.pintar.colorear(this.jTextField119);
/* 2303 */     this.pintar.colorear(this.jTextField116);
/* 2304 */     this.pintar.colorear(this.jFormattedTextField1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarComboEstados() {
/* 2309 */     String[] estados = this.con2.regresaColIndex("distinct(edo)", "tras_origenes", " order by edo");
/* 2310 */     this.jComboBox1.removeAllItems();
/* 2311 */     this.jComboBox1.addItem("ESTADOS");
/* 2312 */     this.utilerias.llenarCombo(this.jComboBox1, estados);
/* 2313 */     this.jComboBox1.setSelectedItem("ESTADOS");
/*      */   }
/*      */   
/*      */   public void llenarCodigosPostales() {
/* 2317 */     this.entraPrimera = true;
/* 2318 */     String[][] cod = this.con2.buscarDatos(6, "num, codigo, c_Municipio, ciudad, c_estado, estado ", "tras_codigos_postales", "order by codigo");
/* 2319 */     for (String[] c : cod) {
/* 2320 */       this.CODIGOSP.add(new Tras_codigos(c[0], c[1], c[2], c[3], c[4], c[5]));
/* 2321 */       agregarCampo(this.LISTACODIGOS, c[1]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 2326 */     if (!datos.contains(valor)) {
/* 2327 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2332 */     this.PRIMERA = true;
/* 2333 */     String id = "";
/* 2334 */     String nombre = "";
/* 2335 */     String ciudad = "";
/* 2336 */     String estados = "";
/* 2337 */     String activo = "";
/*      */     
/* 2339 */     if (!this.jTextField1.getText().equals(this.holderId)) {
/* 2340 */       id = this.jTextField1.getText();
/*      */     }
/* 2342 */     if (!this.jTextField2.getText().equals(this.holderNombre)) {
/* 2343 */       nombre = this.jTextField2.getText();
/*      */     }
/* 2345 */     if (!this.jTextField3.getText().equals(this.holderCiudad)) {
/* 2346 */       ciudad = this.jTextField3.getText();
/*      */     }
/* 2348 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 2349 */       estados = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 2351 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2352 */       activo = "Activado";
/* 2353 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 2354 */       activo = "Eliminado";
/*      */     } 
/*      */     
/* 2357 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "Núm", "Razón Social", "Nombre Corto", "C.P.", "Calle", "Número", "Colonia", "Ciudad", "Estado", "Actualizó" }, "clave_gene, empresa, nombre_corto, cp, calle, num, col, ciudad, edo,  usuario", "emp_generadora", "where clave_gene like '%" + id + "%' and empresa like '%" + nombre + "%' and ciudad like '%" + ciudad + "%' and edo like '%" + estados + "%' and activo like '%" + activo + "%' order by empresa");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2374 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*      */     
/* 2376 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 2377 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/* 2378 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 8, 90);
/*      */     
/* 2380 */     String[] claves = this.con.regresaColIndex("clave_gene", "emp_generadora", "where usoCFDIClave=''");
/* 2381 */     this.celda1.pasarInd(claves);
/* 2382 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/*      */   }
/*      */   
/*      */   public void consultar1Clientes() {
/* 2386 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 2387 */       this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro2, new String[] { "Clave", "Razón Social", "C.P.", "Calle", "Número", "Colonia", "Ciudad", "Estado", "Actualizó" }, "emp_generadora.clave_gene, emp_generadora.empresa, cp, calle, num, col, ciudad, edo, usuario", "emp_generadora, tarjeta_deudor_cliente", "where emp_generadora.clave_gene = tarjeta_deudor_cliente.clave_gene");
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
/*      */     }
/* 2400 */     else if (this.jComboBox3.getSelectedIndex() == 2) {
/*      */     
/*      */     } 
/* 2403 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*      */     
/* 2405 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 2406 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/* 2407 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 8, 90);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2412 */     int otro = -1;
/* 2413 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2416 */       setEnabled((table == null || table.isEnabled()));
/* 2417 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 2419 */       if (column == 0 || column == 3) {
/* 2420 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2422 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 2425 */       if (comparar(comp)) {
/* 2426 */         setBackground(new Color(102, 153, 255));
/* 2427 */         setForeground(Color.BLUE);
/*      */       } else {
/* 2429 */         setBackground((Color)null);
/* 2430 */         setForeground(Clientes.this.lc.SECUNDARIO1);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2439 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2440 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 2444 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 2448 */       for (int i = 0; i < this.indices.length; i++) {
/* 2449 */         if (this.indices[i].equals(reg)) {
/* 2450 */           return true;
/*      */         }
/*      */       } 
/* 2453 */       return false;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Clientes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */