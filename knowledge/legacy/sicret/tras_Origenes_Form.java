/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.Insets;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRootPane;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import principal.MaterialButton;
/*      */ import utilerias.TrasColonias;
/*      */ import utilerias.Tras_codigos;
/*      */ 
/*      */ public class tras_Origenes_Form extends JDialog {
/*      */   private int xx;
/*      */   private int xy;
/*      */   JScrollPane panel;
/*   40 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   41 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   42 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   43 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   44 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   45 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   46 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   47 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   48 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   49 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   50 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   51 */   JFrame padre = null;
/*   52 */   JTabbedPane fichas = null;
/*      */   Map<String, String> CAMPOSGENERALES;
/*   54 */   MensajePop mensajeTry = null;
/*      */   String USUARIO;
/*   56 */   SColores lc = new SColores();
/*   57 */   Fuentes fuentes = new Fuentes();
/*   58 */   PlaceHolder placeHolder = null;
/*   59 */   Consultas2 con2 = new Consultas2();
/*      */   
/*   61 */   String TIPO = "";
/*   62 */   String SUCURSAL = "";
/*   63 */   int numSUC = 0;
/*   64 */   String ID = "";
/*   65 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean actualizado = false;
/*   67 */   ArrayList LISTACODIGOS = null;
/*   68 */   TextAutoCompleter com_ListaCodigos = null;
/*   69 */   List<Tras_codigos> CODIGOSP = null;
/*   70 */   Map<String, String> CLAVECATALOGO = new TreeMap<>();
/*   71 */   Utilerias utilerias = new Utilerias(); private JButton jButton1; private JButton jButton2; private JButton jButton3; private JEditorPane jEditorPane1; private JLabel jLabel128; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel27; private JLabel jLabel3; private JLabel jLabel34;
/*   72 */   Map<String, String> Origen = new TreeMap<>(); private JLabel jLabel35; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel50; private JPanel jPanel57;
/*      */   
/*      */   public tras_Origenes_Form(String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, String TIPO, boolean actualizado, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP, String ID) {
/*   75 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   76 */     this.mensajeTry = this.mensajeTry;
/*   77 */     this.TIPO = TIPO;
/*   78 */     this.padre = padre;
/*   79 */     this.fichas = this.fichas;
/*   80 */     this.USUARIO = USUARIO;
/*   81 */     this.actualizado = actualizado;
/*   82 */     this.LISTACODIGOS = LISTACODIGOS;
/*   83 */     this.CODIGOSP = CODIGOSP;
/*   84 */     this.con2.setBaseDatos("sicre2PR");
/*   85 */     initComponents();
/*   86 */     limpiar();
/*   87 */     colorear();
/*   88 */     if (this.TIPO.equals("NUEVO")) {
/*   89 */       this.jLabel20.setText("Nuevo");
/*   90 */       llenarCodigos();
/*   91 */       this.numSUC = dameSucursal();
/*   92 */       ID = dameID(this.numSUC);
/*   93 */       this.jTextField1.setText(ID);
/*   94 */       this.materialButton1.setVisible(true);
/*   95 */       this.materialButton1.setText("Guardar");
/*   96 */       this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*   97 */     } else if (this.TIPO.equals("VER")) {
/*   98 */       this.ID = ID;
/*   99 */       verDatos();
/*  100 */       desabilitar();
/*  101 */       this.jLabel20.setText("Origen: " + this.jTextField1.getText());
/*  102 */       this.materialButton1.setVisible(false);
/*  103 */     } else if (this.TIPO.equals("MODIFICAR")) {
/*  104 */       this.ID = ID;
/*  105 */       verDatos();
/*  106 */       llenarCodigos();
/*  107 */       this.jTextField4.setEnabled(true);
/*  108 */       this.jTextField5.setEnabled(true);
/*      */       
/*  110 */       this.jLabel20.setText("Modificar: " + this.jTextField1.getText());
/*  111 */       this.materialButton1.setVisible(true);
/*  112 */       this.materialButton1.setText("Modificar");
/*  113 */       this.materialButton1.setToolTipText("Modificar (Alt + M)");
/*      */     } 
/*      */     
/*  116 */     setLocationRelativeTo(null);
/*  117 */     setVisible(true);
/*  118 */     setResizable(true);
/*      */   }
/*      */   private JPanel jPanel59; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel64; private JPanel jPanel79; private JPanel jPanel80; private JScrollPane jScrollPane1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8;
/*      */   private JTextField jTextField9;
/*      */   private MaterialButton materialButton1;
/*      */   private MaterialButton materialButton2;
/*      */   
/*      */   private void initComponents() {
/*  126 */     this.jPanel57 = new JPanel();
/*  127 */     this.jPanel12 = new JPanel();
/*  128 */     this.jPanel50 = new JPanel();
/*  129 */     this.jLabel20 = new JLabel();
/*  130 */     this.jPanel80 = new JPanel();
/*  131 */     this.jLabel128 = new JLabel();
/*  132 */     this.jLabel27 = new JLabel();
/*  133 */     this.jPanel79 = new JPanel();
/*  134 */     this.materialButton2 = new MaterialButton();
/*  135 */     this.materialButton1 = new MaterialButton();
/*  136 */     this.jPanel11 = new JPanel();
/*  137 */     this.jLabel21 = new JLabel();
/*  138 */     this.jLabel34 = new JLabel();
/*  139 */     this.jLabel48 = new JLabel();
/*  140 */     this.jLabel22 = new JLabel();
/*  141 */     this.jLabel35 = new JLabel();
/*  142 */     this.jLabel49 = new JLabel();
/*  143 */     this.jPanel59 = new JPanel();
/*  144 */     this.jButton2 = new JButton();
/*  145 */     this.jTextField7 = new JTextField();
/*  146 */     this.jPanel60 = new JPanel();
/*  147 */     this.jButton1 = new JButton();
/*  148 */     this.jTextField3 = new JTextField();
/*  149 */     this.jPanel61 = new JPanel();
/*  150 */     this.jTextField4 = new JTextField();
/*  151 */     this.jLabel2 = new JLabel();
/*  152 */     this.jPanel64 = new JPanel();
/*  153 */     this.jLabel3 = new JLabel();
/*  154 */     this.jTextField5 = new JTextField();
/*  155 */     this.jTextField6 = new JTextField();
/*  156 */     this.jTextField8 = new JTextField();
/*  157 */     this.jTextField10 = new JTextField();
/*  158 */     this.jLabel50 = new JLabel();
/*  159 */     this.jTextField1 = new JTextField();
/*  160 */     this.jLabel51 = new JLabel();
/*  161 */     this.jTextField2 = new JTextField();
/*  162 */     this.jLabel52 = new JLabel();
/*  163 */     this.jTextField12 = new JTextField();
/*  164 */     this.jLabel53 = new JLabel();
/*  165 */     this.jScrollPane1 = new JScrollPane();
/*  166 */     this.jEditorPane1 = new JEditorPane();
/*  167 */     this.jTextField11 = new JTextField();
/*  168 */     this.jTextField9 = new JTextField();
/*  169 */     this.jLabel54 = new JLabel();
/*  170 */     this.jTextField13 = new JTextField();
/*  171 */     this.jLabel23 = new JLabel();
/*  172 */     this.jTextField14 = new JTextField();
/*  173 */     this.jPanel62 = new JPanel();
/*  174 */     this.jButton3 = new JButton();
/*  175 */     this.jTextField15 = new JTextField();
/*      */     
/*  177 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  178 */     this.jPanel57.setLayout(jPanel57Layout);
/*  179 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  181 */         .addGap(0, 430, 32767));
/*      */     
/*  183 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  185 */         .addGap(0, 25, 32767));
/*      */ 
/*      */     
/*  188 */     setDefaultCloseOperation(2);
/*  189 */     setModal(true);
/*  190 */     setUndecorated(true);
/*      */     
/*  192 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  194 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  196 */     this.jLabel20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  197 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/*  198 */     this.jLabel20.setHorizontalAlignment(0);
/*  199 */     this.jLabel20.setText("Nuevo");
/*  200 */     this.jLabel20.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  202 */             tras_Origenes_Form.this.jLabel20MouseDragged(evt);
/*      */           }
/*      */         });
/*  205 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  207 */             tras_Origenes_Form.this.jLabel20MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  211 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/*  212 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*      */     
/*  214 */     this.jLabel128.setHorizontalAlignment(0);
/*  215 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  216 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  218 */             tras_Origenes_Form.this.jLabel128MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  221 */             tras_Origenes_Form.this.jLabel128MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  224 */             tras_Origenes_Form.this.jLabel128MouseExited(evt);
/*      */           }
/*      */         });
/*  227 */     this.jPanel80.add(this.jLabel128);
/*      */     
/*  229 */     this.jLabel27.setHorizontalAlignment(0);
/*      */     
/*  231 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/*  232 */     this.jPanel50.setLayout(jPanel50Layout);
/*  233 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/*  234 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  235 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  236 */           .addGap(1, 1, 1)
/*  237 */           .addComponent(this.jLabel27, -2, 36, -2)
/*  238 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  239 */           .addComponent(this.jLabel20, -1, -1, 32767)
/*  240 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  241 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*      */     
/*  243 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/*  244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  245 */         .addComponent(this.jPanel80, -1, -1, 32767)
/*  246 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  247 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  248 */             .addComponent(this.jLabel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  249 */             .addComponent(this.jLabel20, -2, 30, -2))
/*  250 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  253 */     this.jPanel79.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  255 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/*  256 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  257 */     this.materialButton2.setMnemonic('R');
/*  258 */     this.materialButton2.setText("Cerrar");
/*  259 */     this.materialButton2.setToolTipText("Cerrar (Alt+R)");
/*  260 */     this.materialButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  261 */     this.materialButton2.setHorizontalTextPosition(0);
/*  262 */     this.materialButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  264 */             tras_Origenes_Form.this.materialButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  268 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/*  269 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/*  270 */     this.materialButton1.setMnemonic('G');
/*  271 */     this.materialButton1.setText("Guardar");
/*  272 */     this.materialButton1.setToolTipText("Guardar (Alt+G)");
/*  273 */     this.materialButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  274 */     this.materialButton1.setHorizontalTextPosition(0);
/*  275 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  277 */             tras_Origenes_Form.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  281 */     GroupLayout jPanel79Layout = new GroupLayout(this.jPanel79);
/*  282 */     this.jPanel79.setLayout(jPanel79Layout);
/*  283 */     jPanel79Layout.setHorizontalGroup(jPanel79Layout
/*  284 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  285 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
/*  286 */           .addContainerGap(429, 32767)
/*  287 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/*  288 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  289 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/*  290 */           .addContainerGap()));
/*      */     
/*  292 */     jPanel79Layout.setVerticalGroup(jPanel79Layout
/*  293 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  294 */         .addGroup(jPanel79Layout.createSequentialGroup()
/*  295 */           .addGroup(jPanel79Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  296 */             .addComponent((Component)this.materialButton1, -2, 38, -2)
/*  297 */             .addComponent((Component)this.materialButton2, -1, -1, 32767))
/*  298 */           .addGap(0, 2, 32767)));
/*      */ 
/*      */     
/*  301 */     GridBagLayout jPanel11Layout = new GridBagLayout();
/*  302 */     jPanel11Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  303 */     jPanel11Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  304 */     this.jPanel11.setLayout(jPanel11Layout);
/*      */     
/*  306 */     this.jLabel21.setFont(new Font("Cantarell", 1, 11));
/*  307 */     this.jLabel21.setText("Código Postal *");
/*  308 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  309 */     gridBagConstraints.gridx = 2;
/*  310 */     gridBagConstraints.gridy = 6;
/*  311 */     gridBagConstraints.fill = 2;
/*  312 */     gridBagConstraints.ipadx = 40;
/*  313 */     gridBagConstraints.weightx = 0.1D;
/*  314 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  315 */     this.jPanel11.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  317 */     this.jLabel34.setFont(new Font("Cantarell", 1, 11));
/*  318 */     this.jLabel34.setText("Calle *");
/*  319 */     gridBagConstraints = new GridBagConstraints();
/*  320 */     gridBagConstraints.gridx = 2;
/*  321 */     gridBagConstraints.gridy = 8;
/*  322 */     gridBagConstraints.fill = 2;
/*  323 */     gridBagConstraints.ipadx = 40;
/*  324 */     gridBagConstraints.weightx = 0.1D;
/*  325 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  326 */     this.jPanel11.add(this.jLabel34, gridBagConstraints);
/*      */     
/*  328 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/*  329 */     this.jLabel48.setText("RFC");
/*  330 */     gridBagConstraints = new GridBagConstraints();
/*  331 */     gridBagConstraints.gridx = 2;
/*  332 */     gridBagConstraints.gridy = 2;
/*  333 */     gridBagConstraints.fill = 2;
/*  334 */     gridBagConstraints.ipadx = 40;
/*  335 */     gridBagConstraints.weightx = 0.1D;
/*  336 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  337 */     this.jPanel11.add(this.jLabel48, gridBagConstraints);
/*      */     
/*  339 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/*  340 */     this.jLabel22.setText("Colonia");
/*  341 */     gridBagConstraints = new GridBagConstraints();
/*  342 */     gridBagConstraints.gridx = 2;
/*  343 */     gridBagConstraints.gridy = 12;
/*  344 */     gridBagConstraints.fill = 2;
/*  345 */     gridBagConstraints.ipadx = 40;
/*  346 */     gridBagConstraints.weightx = 0.1D;
/*  347 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  348 */     this.jPanel11.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  350 */     this.jLabel35.setFont(new Font("Cantarell", 0, 11));
/*  351 */     this.jLabel35.setText("Ciudad o Municipio");
/*  352 */     gridBagConstraints = new GridBagConstraints();
/*  353 */     gridBagConstraints.gridx = 2;
/*  354 */     gridBagConstraints.gridy = 16;
/*  355 */     gridBagConstraints.fill = 2;
/*  356 */     gridBagConstraints.ipadx = 40;
/*  357 */     gridBagConstraints.weightx = 0.1D;
/*  358 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  359 */     this.jPanel11.add(this.jLabel35, gridBagConstraints);
/*      */     
/*  361 */     this.jLabel49.setFont(new Font("Cantarell", 1, 11));
/*  362 */     this.jLabel49.setText("Estado *");
/*  363 */     gridBagConstraints = new GridBagConstraints();
/*  364 */     gridBagConstraints.gridx = 2;
/*  365 */     gridBagConstraints.gridy = 18;
/*  366 */     gridBagConstraints.fill = 2;
/*  367 */     gridBagConstraints.ipadx = 40;
/*  368 */     gridBagConstraints.weightx = 0.1D;
/*  369 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  370 */     this.jPanel11.add(this.jLabel49, gridBagConstraints);
/*      */     
/*  372 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  373 */     this.jButton2.setMnemonic('F');
/*  374 */     this.jButton2.setToolTipText("Filtrar información (Alt+F)");
/*  375 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  377 */             tras_Origenes_Form.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  381 */     this.jTextField7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  382 */     this.jTextField7.setText("col");
/*  383 */     this.jTextField7.setEnabled(false);
/*  384 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  386 */             tras_Origenes_Form.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  390 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  391 */     this.jPanel59.setLayout(jPanel59Layout);
/*  392 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  393 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  394 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  395 */           .addComponent(this.jTextField7)
/*  396 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  397 */           .addComponent(this.jButton2, -2, 20, -2)
/*  398 */           .addGap(0, 0, 0)));
/*      */     
/*  400 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  403 */           .addGroup(jPanel59Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  404 */             .addComponent(this.jTextField7, -2, -1, -2)
/*  405 */             .addComponent(this.jButton2, -2, 24, -2))
/*  406 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  409 */     gridBagConstraints = new GridBagConstraints();
/*  410 */     gridBagConstraints.gridx = 10;
/*  411 */     gridBagConstraints.gridy = 12;
/*  412 */     gridBagConstraints.fill = 1;
/*  413 */     this.jPanel11.add(this.jPanel59, gridBagConstraints);
/*      */     
/*  415 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  416 */     this.jButton1.setMnemonic('F');
/*  417 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/*  418 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  420 */             tras_Origenes_Form.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  424 */     this.jTextField3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  425 */     this.jTextField3.setText("cod");
/*  426 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  428 */             tras_Origenes_Form.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  431 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  433 */             tras_Origenes_Form.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  437 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/*  438 */     this.jPanel60.setLayout(jPanel60Layout);
/*  439 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/*  440 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  441 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  442 */           .addComponent(this.jTextField3, -1, 435, 32767)
/*  443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  444 */           .addComponent(this.jButton1, -2, 20, -2)
/*  445 */           .addGap(0, 0, 0)));
/*      */     
/*  447 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/*  448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  449 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  450 */           .addGroup(jPanel60Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  451 */             .addComponent(this.jTextField3, -2, -1, -2)
/*  452 */             .addComponent(this.jButton1, -2, 24, -2))
/*  453 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  456 */     gridBagConstraints = new GridBagConstraints();
/*  457 */     gridBagConstraints.gridx = 8;
/*  458 */     gridBagConstraints.gridy = 6;
/*  459 */     gridBagConstraints.gridwidth = 3;
/*  460 */     gridBagConstraints.fill = 2;
/*  461 */     this.jPanel11.add(this.jPanel60, gridBagConstraints);
/*      */     
/*  463 */     this.jTextField4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  464 */     this.jTextField4.setText("calle");
/*  465 */     this.jTextField4.setEnabled(false);
/*  466 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  468 */             tras_Origenes_Form.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  472 */     this.jLabel2.setText(" ");
/*      */     
/*  474 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/*  475 */     this.jPanel61.setLayout(jPanel61Layout);
/*  476 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/*  477 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  478 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
/*  479 */           .addComponent(this.jTextField4, -1, 444, 32767)
/*  480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  481 */           .addComponent(this.jLabel2, -2, 11, -2)));
/*      */     
/*  483 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/*  484 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  485 */         .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  486 */           .addComponent(this.jTextField4, -2, -1, -2)
/*  487 */           .addComponent(this.jLabel2)));
/*      */ 
/*      */     
/*  490 */     gridBagConstraints = new GridBagConstraints();
/*  491 */     gridBagConstraints.gridx = 8;
/*  492 */     gridBagConstraints.gridy = 8;
/*  493 */     gridBagConstraints.gridwidth = 3;
/*  494 */     gridBagConstraints.fill = 2;
/*  495 */     this.jPanel11.add(this.jPanel61, gridBagConstraints);
/*      */     
/*  497 */     this.jLabel3.setText(" ");
/*      */     
/*  499 */     this.jTextField5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  500 */     this.jTextField5.setText("num");
/*  501 */     this.jTextField5.setEnabled(false);
/*  502 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  504 */             tras_Origenes_Form.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  508 */     GroupLayout jPanel64Layout = new GroupLayout(this.jPanel64);
/*  509 */     this.jPanel64.setLayout(jPanel64Layout);
/*  510 */     jPanel64Layout.setHorizontalGroup(jPanel64Layout
/*  511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  512 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
/*  513 */           .addComponent(this.jTextField5, -1, 444, 32767)
/*  514 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  515 */           .addComponent(this.jLabel3, -2, 11, -2)));
/*      */     
/*  517 */     jPanel64Layout.setVerticalGroup(jPanel64Layout
/*  518 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  519 */         .addGroup(jPanel64Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  520 */           .addComponent(this.jLabel3)
/*  521 */           .addComponent(this.jTextField5, -2, -1, -2)));
/*      */ 
/*      */     
/*  524 */     gridBagConstraints = new GridBagConstraints();
/*  525 */     gridBagConstraints.gridx = 8;
/*  526 */     gridBagConstraints.gridy = 10;
/*  527 */     gridBagConstraints.gridwidth = 3;
/*  528 */     gridBagConstraints.fill = 2;
/*  529 */     this.jPanel11.add(this.jPanel64, gridBagConstraints);
/*      */     
/*  531 */     this.jTextField6.setText("jTextField6");
/*  532 */     this.jTextField6.setEnabled(false);
/*  533 */     gridBagConstraints = new GridBagConstraints();
/*  534 */     gridBagConstraints.gridx = 8;
/*  535 */     gridBagConstraints.gridy = 12;
/*  536 */     this.jPanel11.add(this.jTextField6, gridBagConstraints);
/*      */     
/*  538 */     this.jTextField8.setText("jTextField8");
/*  539 */     this.jTextField8.setEnabled(false);
/*  540 */     gridBagConstraints = new GridBagConstraints();
/*  541 */     gridBagConstraints.gridx = 8;
/*  542 */     gridBagConstraints.gridy = 16;
/*  543 */     this.jPanel11.add(this.jTextField8, gridBagConstraints);
/*      */     
/*  545 */     this.jTextField10.setText("jTextField10");
/*  546 */     this.jTextField10.setEnabled(false);
/*  547 */     gridBagConstraints = new GridBagConstraints();
/*  548 */     gridBagConstraints.gridx = 8;
/*  549 */     gridBagConstraints.gridy = 18;
/*  550 */     this.jPanel11.add(this.jTextField10, gridBagConstraints);
/*      */     
/*  552 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/*  553 */     this.jLabel50.setText("Número");
/*  554 */     gridBagConstraints = new GridBagConstraints();
/*  555 */     gridBagConstraints.gridx = 2;
/*  556 */     gridBagConstraints.gridy = 10;
/*  557 */     gridBagConstraints.fill = 2;
/*  558 */     gridBagConstraints.ipadx = 40;
/*  559 */     gridBagConstraints.weightx = 0.1D;
/*  560 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  561 */     this.jPanel11.add(this.jLabel50, gridBagConstraints);
/*      */     
/*  563 */     this.jTextField1.setText("jTextField1");
/*  564 */     this.jTextField1.setEnabled(false);
/*  565 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  567 */             tras_Origenes_Form.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  570 */     gridBagConstraints = new GridBagConstraints();
/*  571 */     gridBagConstraints.gridx = 8;
/*  572 */     gridBagConstraints.gridy = 0;
/*  573 */     gridBagConstraints.gridwidth = 3;
/*  574 */     gridBagConstraints.fill = 2;
/*  575 */     this.jPanel11.add(this.jTextField1, gridBagConstraints);
/*      */     
/*  577 */     this.jLabel51.setFont(new Font("Cantarell", 1, 11));
/*  578 */     this.jLabel51.setText("Cliente, Nombre u Origen*");
/*  579 */     gridBagConstraints = new GridBagConstraints();
/*  580 */     gridBagConstraints.gridx = 2;
/*  581 */     gridBagConstraints.gridy = 4;
/*  582 */     gridBagConstraints.fill = 2;
/*  583 */     gridBagConstraints.ipadx = 40;
/*  584 */     gridBagConstraints.weightx = 0.1D;
/*  585 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  586 */     this.jPanel11.add(this.jLabel51, gridBagConstraints);
/*      */     
/*  588 */     this.jTextField2.setText("jTextField2");
/*  589 */     gridBagConstraints = new GridBagConstraints();
/*  590 */     gridBagConstraints.gridx = 8;
/*  591 */     gridBagConstraints.gridy = 2;
/*  592 */     gridBagConstraints.gridwidth = 3;
/*  593 */     gridBagConstraints.fill = 2;
/*  594 */     this.jPanel11.add(this.jTextField2, gridBagConstraints);
/*      */     
/*  596 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/*  597 */     this.jLabel52.setText("ID");
/*  598 */     gridBagConstraints = new GridBagConstraints();
/*  599 */     gridBagConstraints.gridx = 2;
/*  600 */     gridBagConstraints.gridy = 0;
/*  601 */     gridBagConstraints.fill = 2;
/*  602 */     gridBagConstraints.ipadx = 40;
/*  603 */     gridBagConstraints.weightx = 0.1D;
/*  604 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  605 */     this.jPanel11.add(this.jLabel52, gridBagConstraints);
/*      */     
/*  607 */     this.jTextField12.setText("jTextField12");
/*  608 */     this.jTextField12.setEnabled(false);
/*  609 */     gridBagConstraints = new GridBagConstraints();
/*  610 */     gridBagConstraints.gridx = 8;
/*  611 */     gridBagConstraints.gridy = 20;
/*  612 */     gridBagConstraints.gridwidth = 3;
/*  613 */     gridBagConstraints.fill = 2;
/*  614 */     this.jPanel11.add(this.jTextField12, gridBagConstraints);
/*      */     
/*  616 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/*  617 */     this.jLabel53.setText("Clientes");
/*  618 */     gridBagConstraints = new GridBagConstraints();
/*  619 */     gridBagConstraints.gridx = 2;
/*  620 */     gridBagConstraints.gridy = 20;
/*  621 */     gridBagConstraints.fill = 2;
/*  622 */     gridBagConstraints.ipadx = 40;
/*  623 */     gridBagConstraints.weightx = 0.1D;
/*  624 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  625 */     this.jPanel11.add(this.jLabel53, gridBagConstraints);
/*      */     
/*  627 */     this.jScrollPane1.setViewportView(this.jEditorPane1);
/*      */     
/*  629 */     gridBagConstraints = new GridBagConstraints();
/*  630 */     gridBagConstraints.gridx = 8;
/*  631 */     gridBagConstraints.gridy = 22;
/*  632 */     gridBagConstraints.gridwidth = 3;
/*  633 */     gridBagConstraints.gridheight = 17;
/*  634 */     gridBagConstraints.fill = 1;
/*  635 */     gridBagConstraints.weighty = 1.0D;
/*  636 */     this.jPanel11.add(this.jScrollPane1, gridBagConstraints);
/*      */     
/*  638 */     this.jTextField11.setText("jTextField11");
/*  639 */     this.jTextField11.setEnabled(false);
/*  640 */     gridBagConstraints = new GridBagConstraints();
/*  641 */     gridBagConstraints.gridx = 10;
/*  642 */     gridBagConstraints.gridy = 18;
/*  643 */     gridBagConstraints.fill = 2;
/*  644 */     gridBagConstraints.weightx = 1.0D;
/*  645 */     this.jPanel11.add(this.jTextField11, gridBagConstraints);
/*      */     
/*  647 */     this.jTextField9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  648 */     this.jTextField9.setText("ciud");
/*  649 */     this.jTextField9.setEnabled(false);
/*  650 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  652 */             tras_Origenes_Form.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*  655 */     gridBagConstraints = new GridBagConstraints();
/*  656 */     gridBagConstraints.gridx = 10;
/*  657 */     gridBagConstraints.gridy = 16;
/*  658 */     gridBagConstraints.fill = 2;
/*  659 */     this.jPanel11.add(this.jTextField9, gridBagConstraints);
/*      */     
/*  661 */     this.jLabel54.setFont(new Font("Cantarell", 0, 11));
/*  662 */     this.jLabel54.setText("Comentarios");
/*  663 */     gridBagConstraints = new GridBagConstraints();
/*  664 */     gridBagConstraints.gridx = 2;
/*  665 */     gridBagConstraints.gridy = 22;
/*  666 */     gridBagConstraints.fill = 2;
/*  667 */     gridBagConstraints.ipadx = 40;
/*  668 */     gridBagConstraints.weightx = 0.1D;
/*  669 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  670 */     this.jPanel11.add(this.jLabel54, gridBagConstraints);
/*      */     
/*  672 */     this.jTextField13.setText("jTextField13");
/*  673 */     gridBagConstraints = new GridBagConstraints();
/*  674 */     gridBagConstraints.gridx = 8;
/*  675 */     gridBagConstraints.gridy = 4;
/*  676 */     gridBagConstraints.gridwidth = 3;
/*  677 */     gridBagConstraints.fill = 2;
/*  678 */     this.jPanel11.add(this.jTextField13, gridBagConstraints);
/*      */     
/*  680 */     this.jLabel23.setFont(new Font("Cantarell", 1, 11));
/*  681 */     this.jLabel23.setText("Localidad");
/*  682 */     gridBagConstraints = new GridBagConstraints();
/*  683 */     gridBagConstraints.gridx = 2;
/*  684 */     gridBagConstraints.gridy = 14;
/*  685 */     gridBagConstraints.fill = 2;
/*  686 */     gridBagConstraints.ipadx = 40;
/*  687 */     gridBagConstraints.weightx = 0.1D;
/*  688 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/*  689 */     this.jPanel11.add(this.jLabel23, gridBagConstraints);
/*      */     
/*  691 */     this.jTextField14.setText("jTextField14");
/*  692 */     this.jTextField14.setEnabled(false);
/*  693 */     gridBagConstraints = new GridBagConstraints();
/*  694 */     gridBagConstraints.gridx = 8;
/*  695 */     gridBagConstraints.gridy = 14;
/*  696 */     this.jPanel11.add(this.jTextField14, gridBagConstraints);
/*      */     
/*  698 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  699 */     this.jButton3.setMnemonic('F');
/*  700 */     this.jButton3.setToolTipText("Filtrar información (Alt+F)");
/*  701 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  703 */             tras_Origenes_Form.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  707 */     this.jTextField15.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  708 */     this.jTextField15.setText("Localidad");
/*  709 */     this.jTextField15.setEnabled(false);
/*  710 */     this.jTextField15.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  712 */             tras_Origenes_Form.this.jTextField15KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  716 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  717 */     this.jPanel62.setLayout(jPanel62Layout);
/*  718 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  720 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  721 */           .addComponent(this.jTextField15)
/*  722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  723 */           .addComponent(this.jButton3, -2, 20, -2)
/*  724 */           .addGap(0, 0, 0)));
/*      */     
/*  726 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  727 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  728 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  729 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  730 */             .addComponent(this.jTextField15, -2, -1, -2)
/*  731 */             .addComponent(this.jButton3, -2, 24, -2))
/*  732 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  735 */     gridBagConstraints = new GridBagConstraints();
/*  736 */     gridBagConstraints.gridx = 10;
/*  737 */     gridBagConstraints.gridy = 14;
/*  738 */     gridBagConstraints.fill = 1;
/*  739 */     this.jPanel11.add(this.jPanel62, gridBagConstraints);
/*      */     
/*  741 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  742 */     this.jPanel12.setLayout(jPanel12Layout);
/*  743 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  745 */         .addComponent(this.jPanel79, -1, -1, 32767)
/*  746 */         .addComponent(this.jPanel50, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  747 */         .addComponent(this.jPanel11, -2, 0, 32767));
/*      */     
/*  749 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  750 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  751 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  752 */           .addComponent(this.jPanel50, -2, -1, -2)
/*  753 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  754 */           .addComponent(this.jPanel11, -1, 412, 32767)
/*  755 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  756 */           .addComponent(this.jPanel79, -2, -1, -2)));
/*      */ 
/*      */     
/*  759 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  760 */     getContentPane().setLayout(layout);
/*  761 */     layout.setHorizontalGroup(layout
/*  762 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  763 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/*  765 */     layout.setVerticalGroup(layout
/*  766 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  767 */         .addGroup(layout.createSequentialGroup()
/*  768 */           .addComponent(this.jPanel12, -1, -1, 32767)
/*  769 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/*  772 */     pack();
/*      */   }
/*      */   
/*      */   private void jLabel20MouseDragged(MouseEvent evt) {
/*  776 */     int x = evt.getXOnScreen();
/*  777 */     int y = evt.getYOnScreen();
/*  778 */     setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel20MouseClicked(MouseEvent evt) {
/*  782 */     this.xx = evt.getX();
/*  783 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel128MouseClicked(MouseEvent evt) {
/*  787 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel128MouseEntered(MouseEvent evt) {
/*  791 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel128MouseExited(MouseEvent evt) {
/*  795 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void materialButton2ActionPerformed(ActionEvent evt) {
/*  799 */     this.actualizado = false;
/*  800 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/*  804 */     if (this.jTextField2.getText().contains(" ")) {
/*  805 */       this.jTextField2.setBackground(Color.RED);
/*  806 */       JOptionPane.showMessageDialog(this, "No puedes ingresar espacios en el campo del RFC", "Espacios detectados", 0, this.ERROR);
/*  807 */     } else if (this.jTextField2.getText().length() < 12) {
/*  808 */       this.jTextField2.setBackground(Color.RED);
/*  809 */       JOptionPane.showMessageDialog(this, "<html>Te faltan caracteres en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  815 */     else if (this.jTextField2.getText().length() > 13) {
/*  816 */       this.jTextField2.setBackground(Color.RED);
/*  817 */       JOptionPane.showMessageDialog(this, "<html>Caracteres de más en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  822 */     else if (this.jTextField13.getText().equals("")) {
/*  823 */       this.jTextField13.setBackground(Color.RED);
/*  824 */       JOptionPane.showMessageDialog(this, "Falta el cliente, nombre u Origen", "Falta el nombre", 0, this.ERROR);
/*  825 */     } else if (this.jTextField3.getText().equals("")) {
/*  826 */       this.jTextField3.setBackground(Color.RED);
/*  827 */       JOptionPane.showMessageDialog(this, "Falta ingresar el código postal", "Falta el código", 0, this.ERROR);
/*  828 */     } else if (this.jTextField4.getText().equals("")) {
/*  829 */       this.jTextField4.setBackground(Color.RED);
/*  830 */       JOptionPane.showMessageDialog(this, "Falta ingresar la calle", "Falta la calle", 0, this.ERROR);
/*  831 */     } else if (this.jTextField15.getText().equals("")) {
/*  832 */       JOptionPane.showMessageDialog(this, "Falta ingresar la localidad", "Falta la Localidad", 0, this.ERROR);
/*  833 */     } else if (this.jTextField10.getText().equals("")) {
/*  834 */       this.jTextField10.setBackground(Color.RED);
/*  835 */       JOptionPane.showMessageDialog(this, "Falta ingresar el estado", "Falta el estado", 0, this.ERROR);
/*      */     }
/*  837 */     else if (this.materialButton1.getText().equals("Guardar")) {
/*  838 */       int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas guardar la información del nuevo origen?", "Crear Origen", 0, 3, this.PREG);
/*  839 */       if (res == 0) {
/*  840 */         this.con2.inserSinMsj("insert into tras_origenes (id, rfc, nombre, cp, calle, num, col, ciudad, edo, comentarios, clientes, usuario, c_colonia, c_municipio, c_estado, c_localidad, localidad) values ('" + this.jTextField1
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  847 */             .getText() + "', '" + this.jTextField2.getText().toUpperCase() + "','" + this.jTextField13.getText().toUpperCase() + "', '" + this.jTextField3.getText().toUpperCase() + "', '" + this.jTextField4
/*  848 */             .getText().toUpperCase() + "', '" + this.jTextField5.getText().toUpperCase() + "', '" + this.jTextField7.getText().toUpperCase() + "', '" + this.jTextField9
/*  849 */             .getText().toUpperCase() + "', '" + this.jTextField11.getText().toUpperCase() + "', '" + this.jEditorPane1.getText().toUpperCase() + "', '', '" + this.utilerias
/*  850 */             .sacarUsuario(this.USUARIO) + "', '" + this.jTextField6.getText().toUpperCase() + "', '" + this.jTextField8
/*  851 */             .getText().toUpperCase() + "', '" + this.jTextField10.getText().toUpperCase() + "', '" + this.jTextField14.getText().toUpperCase() + "', '" + this.jTextField15.getText().toUpperCase() + "')");
/*      */         
/*  853 */         activarModificacion();
/*      */       } 
/*      */     } else {
/*  856 */       int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas modificar la información del origen?", "Modificar Origen", 0, 3, this.PREG);
/*  857 */       if (res == 0) {
/*  858 */         this.con2.inserSinMsj("update tras_origenes set rfc = '" + this.jTextField2
/*  859 */             .getText().toUpperCase() + "', nombre = '" + this.jTextField13
/*  860 */             .getText().toUpperCase() + "', cp = '" + this.jTextField3
/*  861 */             .getText().toUpperCase() + "', calle = '" + this.jTextField4
/*  862 */             .getText().toUpperCase() + "', num = '" + this.jTextField5
/*  863 */             .getText().toUpperCase() + "', col = '" + this.jTextField7
/*  864 */             .getText().toUpperCase() + "', ciudad = '" + this.jTextField9
/*  865 */             .getText().toUpperCase() + "', edo = '" + this.jTextField11
/*  866 */             .getText().toUpperCase() + "', comentarios = '" + this.jEditorPane1
/*  867 */             .getText().toUpperCase() + "', usuario = '" + this.utilerias
/*  868 */             .sacarUsuario(this.USUARIO) + "', c_colonia = '" + this.jTextField6
/*  869 */             .getText().toUpperCase() + "', c_municipio = '" + this.jTextField8
/*  870 */             .getText().toUpperCase() + "', c_estado = '" + this.jTextField10
/*  871 */             .getText().toUpperCase() + "', c_localidad = '" + this.jTextField14
/*  872 */             .getText().toUpperCase() + "', localidad = '" + this.jTextField15
/*  873 */             .getText().toUpperCase() + "'  where id = '" + this.jTextField1
/*  874 */             .getText() + "'");
/*      */         
/*  876 */         activarModificacion();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  887 */     this.CLAVECATALOGO.clear();
/*  888 */     new TrasColonias(this, true, this.jButton1, "tras_colonias", this.CLAVECATALOGO, this.jTextField3.getText(), true);
/*  889 */     if (this.CLAVECATALOGO.size() > 0) {
/*  890 */       this.jTextField6.setText(this.CLAVECATALOGO.get("1"));
/*  891 */       this.jTextField7.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */     
/*  894 */     String nuevoCod = this.CLAVECATALOGO.get("3");
/*  895 */     String viejoCod = this.jTextField3.getText();
/*      */     
/*  897 */     if (this.CLAVECATALOGO.size() > 0) {
/*  898 */       if (!nuevoCod.equals(viejoCod)) {
/*  899 */         this.jTextField3.setText(nuevoCod);
/*  900 */         habilitarDir();
/*      */       } 
/*  902 */       this.jTextField7.setToolTipText(this.jTextField7.getText());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  911 */     this.CLAVECATALOGO = new TreeMap<>();
/*  912 */     new TrasColonias(this, true, this.jButton2, "tras_codigos_postales", this.CLAVECATALOGO, "", true);
/*  913 */     if (this.CLAVECATALOGO.size() > 0) {
/*  914 */       this.jTextField3.setText(this.CLAVECATALOGO.get("2"));
/*  915 */       this.jTextField6.setText("");
/*  916 */       this.jTextField7.setText("");
/*  917 */       habilitarDir();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/*  922 */     habilitarDir();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  926 */     if (this.jTextField3.getText().length() < 5) {
/*  927 */       this.jTextField4.setEnabled(false);
/*  928 */       this.jTextField5.setEnabled(false);
/*  929 */       this.jTextField9.setText("");
/*  930 */       this.jTextField11.setText("");
/*  931 */       this.jTextField6.setText("          ");
/*  932 */       this.jTextField7.setText("");
/*  933 */       this.jTextField8.setText("          ");
/*  934 */       this.jTextField10.setText("          ");
/*  935 */       this.jTextField14.setText("          ");
/*  936 */       this.jTextField15.setText("");
/*      */       
/*  938 */       if (this.materialButton1.getText().equals("Guardar")) {
/*  939 */         this.jTextField4.setEnabled(false);
/*  940 */         this.jTextField5.setEnabled(false);
/*      */       } else {
/*  942 */         this.jTextField4.setEnabled(true);
/*  943 */         this.jTextField5.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  961 */     this.CLAVECATALOGO = new TreeMap<>();
/*  962 */     new TrasColonias(this, true, this.jButton3, "tras_localidades", this.CLAVECATALOGO, this.jTextField10.getText(), true);
/*  963 */     if (this.CLAVECATALOGO.size() > 0) {
/*  964 */       this.jTextField14.setText(this.CLAVECATALOGO.get("1"));
/*  965 */       this.jTextField15.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField15KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   public void activarModificacion() {
/*  974 */     this.Origen.put("ID", this.jTextField1.getText().toUpperCase());
/*  975 */     this.Origen.put("RFC", this.jTextField2.getText().toUpperCase());
/*  976 */     this.Origen.put("NOMBRE", this.jTextField13.getText().toUpperCase());
/*  977 */     this.Origen.put("CP", this.jTextField3.getText().toUpperCase());
/*  978 */     this.Origen.put("CALLE", this.jTextField4.getText().toUpperCase());
/*  979 */     this.Origen.put("NUM", this.jTextField5.getText().toUpperCase());
/*  980 */     this.Origen.put("COL", this.jTextField7.getText().toUpperCase());
/*  981 */     this.Origen.put("CD", this.jTextField9.getText().toUpperCase());
/*  982 */     this.Origen.put("EDO", this.jTextField11.getText().toUpperCase());
/*  983 */     this.Origen.put("CLIENTES", this.jTextField12.getText().toUpperCase());
/*  984 */     this.Origen.put("COMENTARIOS", this.jEditorPane1.getText().toUpperCase());
/*  985 */     this.Origen.put("C_COLONIA", this.jTextField6.getText().toUpperCase());
/*  986 */     this.Origen.put("C_MUNICIPIO", this.jTextField8.getText().toUpperCase());
/*  987 */     this.Origen.put("C_ESTADO", this.jTextField10.getText().toUpperCase());
/*  988 */     this.Origen.put("C_LOCALIDAD", this.jTextField14.getText().toUpperCase());
/*  989 */     this.Origen.put("LOCALIDAD", this.jTextField15.getText().toUpperCase());
/*  990 */     this.actualizado = true;
/*  991 */     setVisible(false);
/*      */   }
/*      */   
/*      */   public void verDatos() {
/*  995 */     String[] datos = this.con2.regresaRegIndex("rfc, cp, calle, num, col, ciudad, edo, comentarios, clientes, usuario, c_colonia, c_municipio, c_estado, nombre, c_localidad, localidad", "tras_origenes", "where id = '" + this.ID + "'");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1000 */     this.jTextField1.setText(this.ID);
/* 1001 */     this.jTextField2.setText(datos[0]);
/* 1002 */     this.jTextField3.setText(datos[1]);
/* 1003 */     this.jTextField4.setText(datos[2]);
/* 1004 */     this.jTextField5.setText(datos[3]);
/* 1005 */     this.jTextField7.setText(datos[4]);
/* 1006 */     this.jTextField9.setText(datos[5]);
/* 1007 */     this.jTextField11.setText(datos[6]);
/* 1008 */     this.jTextField12.setText(datos[8]);
/* 1009 */     this.jTextField13.setText(datos[13]);
/* 1010 */     this.jEditorPane1.setText(datos[7]);
/*      */     
/* 1012 */     this.jTextField6.setText(datos[10]);
/* 1013 */     this.jTextField8.setText(datos[11]);
/* 1014 */     this.jTextField10.setText(datos[12]);
/*      */     
/* 1016 */     this.jTextField14.setText(datos[14]);
/* 1017 */     this.jTextField15.setText(datos[15]);
/*      */   }
/*      */ 
/*      */   
/*      */   protected JRootPane createRootPane() {
/* 1022 */     JRootPane rootPane = new JRootPane();
/* 1023 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 1024 */     Action actionListener = new AbstractAction() {
/*      */         public void actionPerformed(ActionEvent actionEvent) {
/* 1026 */           tras_Origenes_Form.this.actualizado = false;
/* 1027 */           tras_Origenes_Form.this.setVisible(false);
/*      */         }
/*      */       };
/* 1030 */     InputMap inputMap = rootPane.getInputMap(2);
/* 1031 */     inputMap.put(stroke, "ESCAPE");
/* 1032 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 1033 */     return rootPane;
/*      */   }
/*      */   
/*      */   public void llenarCodigos() {
/* 1037 */     this.com_ListaCodigos = new TextAutoCompleter(this.jTextField3, this.LISTACODIGOS);
/*      */   }
/*      */   
/*      */   public int dameSucursal() {
/* 1041 */     int num = 0;
/* 1042 */     this.SUCURSAL = this.CAMPOSGENERALES.get("sucursal");
/* 1043 */     if (this.SUCURSAL.equals("CADEREYTA")) {
/* 1044 */       num = 1;
/* 1045 */     } else if (this.SUCURSAL.equals("VERACRUZ")) {
/* 1046 */       num = 2;
/* 1047 */     } else if (this.SUCURSAL.equals("POZA RICA")) {
/* 1048 */       num = 3;
/* 1049 */     } else if (this.SUCURSAL.equals("CARDENAS")) {
/* 1050 */       num = 4;
/*      */     } 
/* 1052 */     return num;
/*      */   }
/*      */   
/*      */   public String dameID(int num) {
/* 1056 */     int id = 0;
/* 1057 */     String clave = "";
/* 1058 */     this.con2.consultar("count(num_o)", "tras_origenes", "");
/* 1059 */     if (!this.con2.Campo.equals("0")) {
/* 1060 */       this.con2.consultar("max(num_o)", "tras_origenes", "");
/* 1061 */       id = Integer.parseInt(this.con2.Campo);
/* 1062 */       id++;
/*      */     } else {
/* 1064 */       id = 1;
/*      */     } 
/* 1066 */     if (id < 10) {
/* 1067 */       clave = "" + num + "0000" + num;
/* 1068 */     } else if (id < 100) {
/* 1069 */       clave = "" + num + "000" + num;
/* 1070 */     } else if (id < 1000) {
/* 1071 */       clave = "" + num + "00" + num;
/* 1072 */     } else if (id < 10000) {
/* 1073 */       clave = "" + num + "0" + num;
/*      */     } else {
/* 1075 */       clave = "" + num + num;
/*      */     } 
/* 1077 */     return "OR" + clave;
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 1081 */     this.pintar.colorear(this.jTextField2);
/* 1082 */     this.pintar.colorear(this.jTextField3);
/* 1083 */     this.pintar.colorear(this.jTextField4);
/* 1084 */     this.pintar.colorear(this.jTextField5);
/* 1085 */     this.pintar.colorear(this.jTextField13);
/* 1086 */     this.pintar.colorear(this.jEditorPane1);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 1090 */     this.jTextField1.setText("");
/* 1091 */     this.jTextField2.setText("");
/* 1092 */     this.jTextField3.setText("");
/* 1093 */     this.jTextField4.setText("");
/* 1094 */     this.jTextField5.setText("");
/* 1095 */     this.jTextField6.setText("          ");
/* 1096 */     this.jTextField7.setText("");
/* 1097 */     this.jTextField8.setText("          ");
/* 1098 */     this.jTextField14.setText("          ");
/* 1099 */     this.jTextField15.setText("");
/* 1100 */     this.jTextField9.setText("");
/* 1101 */     this.jTextField10.setText("          ");
/* 1102 */     this.jTextField11.setText("");
/* 1103 */     this.jTextField12.setText("");
/* 1104 */     this.jTextField13.setText("");
/*      */     
/* 1106 */     this.jEditorPane1.setText("");
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 1110 */     this.jTextField2.setEnabled(false);
/* 1111 */     this.jTextField3.setEnabled(false);
/* 1112 */     this.jTextField13.setEnabled(false);
/* 1113 */     this.jEditorPane1.setEnabled(false);
/* 1114 */     this.jButton1.setEnabled(false);
/* 1115 */     this.jButton2.setEnabled(false);
/* 1116 */     this.jButton3.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void habilitarDir() {
/* 1120 */     String cod = this.jTextField3.getText();
/* 1121 */     if (this.LISTACODIGOS.contains(cod)) {
/* 1122 */       this.jTextField4.setEnabled(true);
/* 1123 */       this.jTextField5.setEnabled(true);
/* 1124 */       this.jButton1.setEnabled(true);
/* 1125 */       this.jButton1.setEnabled(true);
/*      */       
/* 1127 */       Tras_codigos c = ((List<Tras_codigos>)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(this.jTextField3.getText())).collect(Collectors.toList())).get(0);
/* 1128 */       this.con2.consultar("estado", "tras_estados", "where c_estado = '" + c.getC_estado() + "'");
/* 1129 */       this.jTextField11.setText(this.con2.Campo);
/* 1130 */       ((List)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(this.jTextField3.getText())).collect(Collectors.toList())).forEach(x -> {
/*      */             this.jTextField8.setText(x.getC_Municipio());
/*      */             
/*      */             this.jTextField9.setText(x.getCiudad());
/*      */           });
/* 1135 */       this.jTextField10.setText(c.getC_estado());
/*      */     } else {
/*      */       
/* 1138 */       this.jTextField4.setEnabled(false);
/* 1139 */       this.jTextField5.setEnabled(false);
/*      */ 
/*      */       
/* 1142 */       this.jButton1.setEnabled(false);
/* 1143 */       this.jTextField7.setText("");
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/tras_Origenes_Form.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */