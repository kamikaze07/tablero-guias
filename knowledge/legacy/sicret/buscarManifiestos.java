/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class buscarManifiestos extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JFrame padre;
/*      */   JScrollPane panel;
/*   31 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   32 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   33 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   34 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   35 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   36 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   37 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   38 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   39 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   MostrarTabla modelo;
/*   42 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   JTable tabla;
/*      */   EscribirReporte esc;
/*      */   ManifiestosAceite aceite;
/*      */   ManifiestosAgua agua;
/*      */   ManifiestosEspecial mEspecial;
/*      */   declaracionRecortes declaracion;
/*      */   declaracionRecortesWTF declaracionWTF;
/*   52 */   Errores error = new Errores(false);
/*   53 */   Validaciones val = new Validaciones();
/*   54 */   String CLAVE = "";
/*   55 */   Date fechaInicio = null;
/*   56 */   Date fechaTermino = null;
/*   57 */   Date fechaActual = new Date();
/*   58 */   Date fecha = new Date();
/*   59 */   CeldaRender celda = new CeldaRender();
/*   60 */   Presionado presionado = null;
/*   61 */   String SEMARNAT = "";
/*      */   boolean PRIMERA = false;
/*   63 */   PlaceHolder placeHolder = null;
/*   64 */   String holderGuia = "GUÍA";
/*   65 */   String holderFolio = "FOLIO MANIFIESTO";
/*   66 */   String holderOperador = "NOMBRE DEL OPERADOR";
/*   67 */   String holderUnidad = "UNIDAD";
/*   68 */   String holderRemolque = "REMOLQUE";
/*   69 */   SColores lc = new SColores(); private JButton jButton2; private JButton jButton5; private JButton jButton7; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JLabel jLabel1; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel54;
/*      */   
/*      */   public buscarManifiestos(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   72 */     String año = "2009";
/*   73 */     String mes = "11";
/*   74 */     String dia = "19";
/*   75 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   76 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   78 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   79 */     } catch (ParseException ex) {
/*   80 */       ex.printStackTrace();
/*      */     } 
/*   82 */     Calendar ca = Calendar.getInstance();
/*   83 */     Calendar fecha = Calendar.getInstance();
/*   84 */     int aa = fecha.get(1);
/*   85 */     int mm = fecha.get(2);
/*   86 */     int dd = fecha.get(5);
/*   87 */     int diasTotal = diasDelMes(mm, aa);
/*   88 */     this.padre = padre;
/*   89 */     initComponents();
/*      */     
/*   91 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderFolio, false, "Cantarell", 11);
/*   92 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderGuia, false, "Cantarell", 11);
/*   93 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderOperador, false, "Cantarell", 11);
/*   94 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderUnidad, false, "Cantarell", 11);
/*   95 */     this.placeHolder = new PlaceHolder(this.jTextField5, new Color(189, 189, 189), Color.BLACK, this.holderRemolque, false, "Cantarell", 11);
/*   96 */     this.USUARIO = usua;
/*   97 */     this.fichas = fichas;
/*   98 */     panelito.setViewportView(this);
/*   99 */     this.panel = panelito;
/*  100 */     colorear();
/*  101 */     int w = this.tama.width;
/*  102 */     int h = this.tama.height;
/*  103 */     int rw = (w - 300) / 2;
/*  104 */     int rh = (h - 135) / 2;
/*      */     
/*  106 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  107 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  108 */     this.rSTableMetro1.setCursor(micursor);
/*      */     
/*  110 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  111 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  112 */     this.jLabel5.setCursor(micursor);
/*  113 */     this.jLabel6.setCursor(micursor);
/*  114 */     this.jLabel7.setCursor(micursor);
/*  115 */     privilegios();
/*  116 */     llenarCombos();
/*  117 */     consultar();
/*      */     
/*  119 */     this.con.consultar("semarnat", "configuraciones", "");
/*  120 */     this.SEMARNAT = this.con.Campo;
/*      */   }
/*      */   private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane20; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private void initComponents() {
/*  125 */     this.jPanel3 = new JPanel();
/*  126 */     this.jPanel4 = new JPanel();
/*  127 */     this.jLabel54 = new JLabel();
/*  128 */     this.jLabel8 = new JLabel();
/*  129 */     this.jLabel9 = new JLabel();
/*  130 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  131 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  132 */     this.jButton7 = new JButton();
/*  133 */     this.jPanel6 = new JPanel();
/*  134 */     this.jLabel5 = new JLabel();
/*  135 */     this.jLabel7 = new JLabel();
/*  136 */     this.jLabel6 = new JLabel();
/*  137 */     this.jPanel7 = new JPanel();
/*  138 */     this.jPanel8 = new JPanel();
/*  139 */     this.jComboBox8 = new JComboBox();
/*  140 */     this.jComboBox1 = new JComboBox();
/*  141 */     this.jTextField1 = new JTextField();
/*  142 */     this.jTextField2 = new JTextField();
/*  143 */     this.jComboBox2 = new JComboBox();
/*  144 */     this.jComboBox9 = new JComboBox();
/*  145 */     this.jComboBox3 = new JComboBox();
/*  146 */     this.jComboBox4 = new JComboBox();
/*  147 */     this.jComboBox5 = new JComboBox();
/*  148 */     this.jComboBox6 = new JComboBox();
/*  149 */     this.jComboBox7 = new JComboBox();
/*  150 */     this.jTextField3 = new JTextField();
/*  151 */     this.jTextField4 = new JTextField();
/*  152 */     this.jTextField5 = new JTextField();
/*  153 */     this.jPanel9 = new JPanel();
/*  154 */     this.jPanel10 = new JPanel();
/*  155 */     this.jPanel11 = new JPanel();
/*  156 */     this.jLabel1 = new JLabel();
/*  157 */     this.jLabel48 = new JLabel();
/*  158 */     this.jButton2 = new JButton();
/*  159 */     this.jButton5 = new JButton();
/*  160 */     this.jScrollPane20 = new JScrollPane();
/*  161 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  163 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  165 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  167 */     this.jLabel54.setFont(new Font("Cantarell", 1, 22));
/*  168 */     this.jLabel54.setForeground(this.lc.PRIMARIO1);
/*  169 */     this.jLabel54.setText("Consultar Manifiestos");
/*      */     
/*  171 */     this.jLabel8.setFont(new Font("Cantarell", 0, 11));
/*  172 */     this.jLabel8.setHorizontalAlignment(4);
/*  173 */     this.jLabel8.setText("Visualizando información del ");
/*      */     
/*  175 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/*  176 */     this.jLabel9.setHorizontalAlignment(0);
/*  177 */     this.jLabel9.setText("al");
/*      */     
/*  179 */     this.jDateChooser4.setDate(this.fechaActual);
/*  180 */     this.jDateChooser4.setDateFormatString("yyyy/MM/dd");
/*  181 */     this.jDateChooser4.setIcon(this.icon);
/*  182 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  183 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  185 */     this.jDateChooser5.setDate(this.fechaActual);
/*  186 */     this.jDateChooser5.setDateFormatString("yyyy/MM/dd");
/*  187 */     this.jDateChooser5.setIcon(this.icon);
/*  188 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/*  189 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  191 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/*  192 */     this.jButton7.setMnemonic('F');
/*  193 */     this.jButton7.setToolTipText("Filtrar (Alt +F)");
/*  194 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  196 */             buscarManifiestos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  200 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/*  201 */     this.jPanel6.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  203 */     this.jLabel5.setFont(new Font("Cantarell", 0, 11));
/*  204 */     this.jLabel5.setForeground(this.lc.PRIMARIO1);
/*  205 */     this.jLabel5.setHorizontalAlignment(0);
/*  206 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/*  207 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  209 */             buscarManifiestos.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  212 */             buscarManifiestos.this.jLabel5MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  215 */             buscarManifiestos.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */         });
/*  218 */     this.jPanel6.add(this.jLabel5);
/*      */     
/*  220 */     this.jLabel7.setFont(new Font("Cantarell", 0, 11));
/*  221 */     this.jLabel7.setForeground(this.lc.PRIMARIO1);
/*  222 */     this.jLabel7.setHorizontalAlignment(0);
/*  223 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/*  224 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  226 */             buscarManifiestos.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  229 */             buscarManifiestos.this.jLabel7MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  232 */             buscarManifiestos.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */         });
/*  235 */     this.jPanel6.add(this.jLabel7);
/*      */     
/*  237 */     this.jLabel6.setFont(new Font("Cantarell", 0, 11));
/*  238 */     this.jLabel6.setForeground(this.lc.PRIMARIO1);
/*  239 */     this.jLabel6.setHorizontalAlignment(0);
/*  240 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/*  241 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  243 */             buscarManifiestos.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  246 */             buscarManifiestos.this.jLabel6MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  249 */             buscarManifiestos.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */         });
/*  252 */     this.jPanel6.add(this.jLabel6);
/*      */     
/*  254 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  255 */     this.jPanel4.setLayout(jPanel4Layout);
/*  256 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  257 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  258 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  259 */           .addComponent(this.jLabel54, -2, 278, -2)
/*  260 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  261 */           .addComponent(this.jLabel8, -2, 149, -2)
/*  262 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  263 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/*  264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  265 */           .addComponent(this.jLabel9, -2, 43, -2)
/*  266 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  267 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/*  268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  269 */           .addComponent(this.jButton7)
/*  270 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  271 */           .addComponent(this.jPanel6, -2, -1, -2)
/*  272 */           .addGap(0, 0, 32767)));
/*      */     
/*  274 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  276 */         .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  277 */           .addComponent(this.jLabel8, -2, 29, -2)
/*  278 */           .addComponent(this.jLabel9, -2, 29, -2)
/*  279 */           .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/*  280 */           .addComponent(this.jButton7, -1, -1, 32767)
/*  281 */           .addComponent(this.jPanel6, -1, -1, 32767))
/*  282 */         .addComponent((Component)this.jDateChooser4, -2, 29, -2)
/*  283 */         .addComponent(this.jLabel54, -2, 29, -2));
/*      */ 
/*      */     
/*  286 */     this.jPanel7.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  288 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/*  289 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Búsqueda de Manifiestos", 0, 1, new Font("Cantarell", 0, 11)));
/*      */     
/*  291 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  292 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA", "TODOS" }));
/*  293 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  295 */             buscarManifiestos.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  299 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  300 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACEITE", "AGUA", "EXTERNOS" }));
/*  301 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  303 */             buscarManifiestos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  307 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  309 */             buscarManifiestos.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  312 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  314 */             buscarManifiestos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  318 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  320 */             buscarManifiestos.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  323 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  325 */             buscarManifiestos.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  329 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  330 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Góndola", "Pipa" }));
/*  331 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  333 */             buscarManifiestos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  337 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/*  338 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Altamira", "Latinaja", "Poza Rica", "Veracruz", "Villahermosa" }));
/*  339 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  341 */             buscarManifiestos.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  345 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  346 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  347 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  349 */             buscarManifiestos.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  353 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  354 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  355 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  357 */             buscarManifiestos.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  361 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  362 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  363 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  365 */             buscarManifiestos.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  369 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  370 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  371 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  373 */             buscarManifiestos.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  377 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  378 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  379 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  381 */             buscarManifiestos.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  385 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  387 */             buscarManifiestos.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  390 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  392 */             buscarManifiestos.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  396 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  398 */             buscarManifiestos.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  402 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  404 */             buscarManifiestos.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  408 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  409 */     this.jPanel8.setLayout(jPanel8Layout);
/*  410 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  411 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  412 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  413 */           .addComponent(this.jComboBox8, -2, 135, -2)
/*  414 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  415 */           .addComponent(this.jComboBox1, -2, 135, -2)
/*  416 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  417 */           .addComponent(this.jTextField1, -2, 135, -2)
/*  418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  419 */           .addComponent(this.jTextField2, -2, 135, -2)
/*  420 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  421 */           .addComponent(this.jComboBox2, -2, 135, -2)
/*  422 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  423 */           .addComponent(this.jComboBox9, -2, 135, -2)
/*  424 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  425 */           .addComponent(this.jComboBox3, -2, 227, -2)
/*  426 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  427 */           .addComponent(this.jComboBox4, -2, 200, -2)
/*  428 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  429 */           .addComponent(this.jComboBox5, -2, 135, -2)
/*  430 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  431 */           .addComponent(this.jComboBox6, -2, 134, -2)
/*  432 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  433 */           .addComponent(this.jComboBox7, -2, 134, -2)
/*  434 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  435 */           .addComponent(this.jTextField3, -2, 199, -2)
/*  436 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  437 */           .addComponent(this.jTextField4, -2, 80, -2)
/*  438 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  439 */           .addComponent(this.jTextField5, -2, 80, -2)
/*  440 */           .addContainerGap(-1, 32767)));
/*      */     
/*  442 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  443 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  444 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  445 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  446 */             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  447 */               .addComponent(this.jComboBox8, -2, -1, -2)
/*  448 */               .addComponent(this.jComboBox1, -2, -1, -2)
/*  449 */               .addComponent(this.jTextField1, -2, -1, -2)
/*  450 */               .addComponent(this.jTextField2, -2, -1, -2)
/*  451 */               .addComponent(this.jComboBox2, -2, -1, -2)
/*  452 */               .addComponent(this.jComboBox9, -2, -1, -2)
/*  453 */               .addComponent(this.jComboBox3, -2, -1, -2)
/*  454 */               .addComponent(this.jComboBox4, -2, -1, -2)
/*  455 */               .addComponent(this.jComboBox5, -2, -1, -2)
/*  456 */               .addComponent(this.jComboBox6, -2, -1, -2)
/*  457 */               .addComponent(this.jComboBox7, -2, -1, -2)
/*  458 */               .addComponent(this.jTextField3, -2, -1, -2))
/*  459 */             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  460 */               .addComponent(this.jTextField4, -2, -1, -2)
/*  461 */               .addComponent(this.jTextField5, -2, -1, -2)))
/*  462 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/*  465 */     this.jPanel9.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  467 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/*  468 */     this.jPanel10.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  470 */     this.jPanel11.setBackground(this.lc.SECUNDARIO1);
/*  471 */     this.jPanel11.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  473 */     this.jLabel1.setFont(new Font("Cantarell", 0, 13));
/*  474 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/*  475 */     this.jLabel1.setHorizontalAlignment(4);
/*  476 */     this.jLabel1.setText("Total");
/*  477 */     this.jPanel11.add(this.jLabel1);
/*      */     
/*  479 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/*  480 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/*  481 */     this.jLabel48.setHorizontalAlignment(0);
/*  482 */     this.jLabel48.setText("t");
/*  483 */     this.jPanel11.add(this.jLabel48);
/*      */     
/*  485 */     this.jPanel10.add(this.jPanel11);
/*      */     
/*  487 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/*  488 */     this.jButton2.setText("ReImprimir Manifiesto");
/*  489 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  491 */             buscarManifiestos.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  494 */     this.jPanel10.add(this.jButton2);
/*      */     
/*  496 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/*  497 */     this.jButton5.setMnemonic('G');
/*  498 */     this.jButton5.setText("Guardar Reporte");
/*  499 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/*  500 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  502 */             buscarManifiestos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  505 */     this.jPanel10.add(this.jButton5);
/*      */     
/*  507 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  515 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  520 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  523 */     this.rSTableMetro1.setAltoHead(40);
/*  524 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  525 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  526 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  527 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  528 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  529 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  530 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  531 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 11));
/*  532 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 9));
/*  533 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  534 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  535 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  536 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  537 */     this.rSTableMetro1.setSelectionForeground(new Color(255, 255, 255));
/*  538 */     this.rSTableMetro1.setShowHorizontalLines(false);
/*  539 */     this.rSTableMetro1.setShowVerticalLines(false);
/*  540 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  541 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  542 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  544 */             buscarManifiestos.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/*  547 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  549 */             buscarManifiestos.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/*  552 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro1);
/*      */     
/*  554 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  555 */     this.jPanel9.setLayout(jPanel9Layout);
/*  556 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  557 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  558 */         .addComponent(this.jScrollPane20, -1, 2099, 32767)
/*  559 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  560 */           .addComponent(this.jPanel10, -2, 512, -2)
/*  561 */           .addGap(0, 0, 32767)));
/*      */     
/*  563 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  564 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  565 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  566 */           .addComponent(this.jPanel10, -2, 31, -2)
/*  567 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  568 */           .addComponent(this.jScrollPane20, -1, 310, 32767)));
/*      */ 
/*      */     
/*  571 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  572 */     this.jPanel7.setLayout(jPanel7Layout);
/*  573 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  574 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  575 */         .addComponent(this.jPanel8, -1, -1, 32767)
/*  576 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  578 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  579 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  580 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  581 */           .addContainerGap()
/*  582 */           .addComponent(this.jPanel8, -2, -1, -2)
/*  583 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  584 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */ 
/*      */     
/*  587 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  588 */     this.jPanel3.setLayout(jPanel3Layout);
/*  589 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  590 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  591 */         .addComponent(this.jPanel4, -1, -1, 32767)
/*  592 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/*  594 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  595 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  596 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  597 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  598 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  599 */           .addComponent(this.jPanel7, -1, -1, 32767)));
/*      */ 
/*      */     
/*  602 */     GroupLayout layout = new GroupLayout(this);
/*  603 */     setLayout(layout);
/*  604 */     layout.setHorizontalGroup(layout
/*  605 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  606 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  608 */     layout.setVerticalGroup(layout
/*  609 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  610 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/*  615 */     String cadena = this.jTextField1.getText();
/*  616 */     if (!cadena.equals("")) {
/*  617 */       if (this.presionado == null) {
/*  618 */         this.presionado = new Presionado();
/*  619 */         this.presionado.start();
/*      */       } else {
/*  621 */         this.presionado.detenerFuera();
/*  622 */         this.presionado = new Presionado();
/*  623 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*  626 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  631 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/*  632 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/*  637 */     if (this.jComboBox2.getItemCount() > 0 && this.PRIMERA == true) {
/*  638 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/*  643 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/*  644 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/*  649 */     if (this.jComboBox4.getItemCount() > 0 && this.PRIMERA == true) {
/*  650 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/*  655 */     if (this.jComboBox5.getItemCount() > 0 && this.PRIMERA == true) {
/*  656 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/*  661 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERA == true)
/*  662 */       consultar(); 
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/*  666 */     if (this.jComboBox7.getItemCount() > 0 && this.PRIMERA == true)
/*  667 */       consultar(); 
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/*  671 */     if (this.jComboBox8.getItemCount() > 0 && this.PRIMERA == true)
/*  672 */       consultar(); 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  676 */     String tabla = "";
/*  677 */     this.con.consultar("semarnat", "configuraciones", "");
/*  678 */     this.SEMARNAT = this.con.Campo;
/*  679 */     String col = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4));
/*  680 */     if (this.jComboBox1.getSelectedItem().equals("ACEITE")) {
/*  681 */       tabla = "manifiestos_recorteaceite";
/*      */     } else {
/*  683 */       tabla = "manifiestos_lodoagua";
/*  684 */       this.SEMARNAT = "";
/*      */     } 
/*  686 */     String semar = "SEMARNAT";
/*  687 */     String cliente = "";
/*  688 */     String residuo = "";
/*  689 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/*  690 */       cliente = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5));
/*  691 */       residuo = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4));
/*  692 */       if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.") && (residuo.contains("RECORTE") || residuo.contains("LODO"))) {
/*  693 */         semar = "SEDEMA";
/*      */       }
/*  695 */       int indice = this.rSTableMetro1.getSelectedRow();
/*      */       
/*  697 */       String[] reg = this.con.regresaReg("operadores.nombre,ap_pat,ap_mat,tracto.num_tracto,remolque.num_rem", "remolque,tracto,guias,operadores,llamadas_historicas," + tabla, "where llamadas_historicas.num_ope = operadores.num_ope and " + tabla + ".num_guia=guias.num_guia and guias.num_llama=llamadas_historicas.num_llama and remolque.num_rem = llamadas_historicas.num_rem and tracto.num_tracto=llamadas_historicas.num_tracto and guias.manifiesto = '" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)) + "'", 5);
/*  698 */       this.con.consultar("placas", "tracto", "where num_tracto=" + reg[3]);
/*  699 */       String placasT = this.con.Campo;
/*  700 */       this.con.consultar("placas", "remolque", "where num_rem=" + reg[4]);
/*  701 */       String placasR = this.con.Campo;
/*  702 */       this.con.consultar("semarnat", "emp_destinataria", "where empresa = '" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)) + "'");
/*  703 */       String[] dir = this.con.regresaReg("calle,num,col,ciudad,ruta,telefono,bascula", "emp_destinataria", "where empresa ='" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)) + "'", 7);
/*  704 */       String[] otrosCampos = { String.valueOf(this.rSTableMetro1.getValueAt(indice, 9)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 11)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 10)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 4)) + String.valueOf(this.rSTableMetro1.getValueAt(indice, 4)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 12)) + String.valueOf(this.rSTableMetro1.getValueAt(indice, 12)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 11)), reg[0] + " " + reg[0] + " " + reg[1], reg[3], reg[4], placasT, placasR, String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)), this.con.Campo, dir[0] + " " + dir[0] + " " + dir[1] + " " + dir[2], dir[4], this.SEMARNAT, semar, "ACEITE", String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)), dir[5], dir[6] };
/*  705 */       if (col.equals("DRAKE-MESA S DE RL DE CV")) {
/*  706 */         this.mEspecial = new ManifiestosEspecial(otrosCampos, "ACEITE");
/*      */       }
/*  708 */       else if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.")) {
/*  709 */         this.declaracion = new declaracionRecortes(otrosCampos);
/*  710 */       } else if (cliente.equals("WEATHERFORD DE MEXICO S. DE R.L. DE C.V.") || cliente.equals("INTEGRIDAD MEXICANA DEL NORTE S DE RL DE CV")) {
/*  711 */         System.out.println("entraaa---");
/*  712 */         this.declaracionWTF = new declaracionRecortesWTF(otrosCampos);
/*      */       } else {
/*  714 */         this.aceite = new ManifiestosAceite(otrosCampos);
/*      */       } 
/*      */     } else {
/*      */       
/*  718 */       cliente = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5));
/*  719 */       residuo = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4));
/*  720 */       if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.") && (residuo.contains("RECORTE") || residuo.contains("LODO"))) {
/*  721 */         semar = "SEDEMA";
/*      */       }
/*  723 */       System.out.println("Semarnat " + semar);
/*  724 */       int indice = this.rSTableMetro1.getSelectedRow();
/*      */       
/*  726 */       String[] reg = this.con.regresaReg("operadores.nombre,ap_pat,ap_mat,tracto.num_tracto,remolque.num_rem", "remolque,tracto,guias,operadores,llamadas_historicas," + tabla, "where llamadas_historicas.num_ope = operadores.num_ope and " + tabla + ".num_guia=guias.num_guia and guias.num_llama=llamadas_historicas.num_llama and remolque.num_rem = llamadas_historicas.num_rem and tracto.num_tracto=llamadas_historicas.num_tracto and " + tabla + ".manifiesto = '" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)) + "'", 5);
/*  727 */       this.con.consultar("placas", "tracto", "where num_tracto=" + reg[3]);
/*  728 */       String placasT = this.con.Campo;
/*  729 */       this.con.consultar("placas", "remolque", "where num_rem=" + reg[4]);
/*  730 */       String placasR = this.con.Campo;
/*  731 */       this.con.consultar("semarnat", "emp_destinataria", "where empresa = '" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)) + "'");
/*  732 */       String[] dir = this.con.regresaReg("calle,num,col,ciudad,ruta,telefono,bascula", "emp_destinataria", "where empresa ='" + String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)) + "'", 7);
/*  733 */       String[] otrosCampos = { String.valueOf(this.rSTableMetro1.getValueAt(indice, 9)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 11)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 10)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 4)) + String.valueOf(this.rSTableMetro1.getValueAt(indice, 4)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 12)) + String.valueOf(this.rSTableMetro1.getValueAt(indice, 12)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 11)), reg[0] + " " + reg[0] + " " + reg[1], reg[3], reg[4], placasT, placasR, String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)), this.con.Campo, dir[0] + " " + dir[0] + " " + dir[1] + " " + dir[2], dir[4], this.SEMARNAT, semar, "AGUA", String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)), dir[5], dir[6] };
/*  734 */       if (col.equals("DRAKE-MESA S DE RL DE CV")) {
/*  735 */         this.mEspecial = new ManifiestosEspecial(otrosCampos, "AGUA");
/*      */       }
/*  737 */       else if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.")) {
/*  738 */         this.declaracion = new declaracionRecortes(otrosCampos);
/*  739 */       } else if ((cliente.equals("WEATHERFORD DE MEXICO S. DE R.L. DE C.V.") || cliente.equals("INTEGRIDAD MEXICANA DEL NORTE S DE RL DE CV")) && residuo.equals("RECORTE BASE AGUA")) {
/*  740 */         this.declaracionWTF = new declaracionRecortesWTF(otrosCampos);
/*      */       } else {
/*  742 */         this.agua = new ManifiestosAgua(otrosCampos);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  749 */     String cadena = this.jTextField2.getText();
/*  750 */     if (!cadena.equals("")) {
/*  751 */       if (this.presionado == null) {
/*  752 */         this.presionado = new Presionado();
/*  753 */         this.presionado.start();
/*      */       } else {
/*  755 */         this.presionado.detenerFuera();
/*  756 */         this.presionado = new Presionado();
/*  757 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*  760 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  765 */     String[] datos = { "FOLIO", "GUÍA", "FOLIO IMPRESO", "FECHA", "RESIDUO", "CLIENTE", "DESTINO", "TRACTOR", "REMOLQUE", "EQUIPO", "PLATAFORMA", "POZO", "TIPO", "OPERADOR", "AUTORIZÓ", "ESTADO" };
/*  766 */     this.esc = new EscribirReporte("MANIFIESTOS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/*  770 */     consultar();
/*      */   }
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  773 */     String cadena = this.jTextField3.getText();
/*  774 */     if (!cadena.equals("")) {
/*  775 */       if (this.presionado == null) {
/*  776 */         this.presionado = new Presionado();
/*  777 */         this.presionado.start();
/*      */       } else {
/*  779 */         this.presionado.detenerFuera();
/*  780 */         this.presionado = new Presionado();
/*  781 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*  784 */       this.jTextField3.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/*  788 */     String cadena = this.jTextField4.getText();
/*  789 */     if (!cadena.equals("")) {
/*  790 */       if (this.presionado == null) {
/*  791 */         this.presionado = new Presionado();
/*  792 */         this.presionado.start();
/*      */       } else {
/*  794 */         this.presionado.detenerFuera();
/*  795 */         this.presionado = new Presionado();
/*  796 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*  799 */       this.jTextField4.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/*  803 */     String cadena = this.jTextField5.getText();
/*  804 */     if (!cadena.equals("")) {
/*  805 */       if (this.presionado == null) {
/*  806 */         this.presionado = new Presionado();
/*  807 */         this.presionado.start();
/*      */       } else {
/*  809 */         this.presionado.detenerFuera();
/*  810 */         this.presionado = new Presionado();
/*  811 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*  814 */       this.jTextField5.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/*  819 */     this.jDateChooser4.setDate(this.fechaInicio);
/*  820 */     this.jDateChooser5.setDate(this.fechaActual);
/*  821 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/*  825 */     this.jLabel5.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/*  829 */     this.jLabel5.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/*  833 */     this.jDateChooser4.setDate(this.fechaActual);
/*  834 */     this.jDateChooser5.setDate(this.fechaActual);
/*  835 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/*  839 */     this.jLabel6.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/*  843 */     this.jLabel6.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/*  847 */     Calendar ca = Calendar.getInstance();
/*  848 */     Calendar fecha = Calendar.getInstance();
/*  849 */     int aa = fecha.get(1);
/*  850 */     int mm = fecha.get(2);
/*  851 */     int dd = fecha.get(5);
/*  852 */     if (dd == 1) {
/*  853 */       if (mm == 0) {
/*  854 */         mm = 11;
/*  855 */         aa--;
/*      */       } else {
/*  857 */         mm--;
/*      */       } 
/*  859 */       int diasTotal = diasDelMes(mm, aa);
/*  860 */       dd = diasTotal;
/*      */     } else {
/*  862 */       dd--;
/*      */     } 
/*  864 */     mm++;
/*  865 */     String año = "" + aa;
/*  866 */     String mes = "" + mm;
/*  867 */     String dia = "" + dd;
/*  868 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  869 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/*  871 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/*  872 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/*  873 */     } catch (ParseException ex) {
/*  874 */       ex.printStackTrace();
/*      */     } 
/*  876 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/*  880 */     this.jLabel7.setForeground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/*  884 */     this.jLabel7.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/*  888 */     if (this.jComboBox9.getItemCount() > 0 && this.PRIMERA == true) {
/*  889 */       consultar();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/*  906 */     this.jButton2.setEnabled(true);
/*  907 */     privilegios();
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   public void jPintarTexto(JComponent campo) {
/*  914 */     campo.setBackground(this.lc.PRIMARIO2);
/*      */   }
/*      */   
/*      */   public void tieneTexto() {
/*  918 */     if (!this.jTextField1.getText().equals("") && !this.jTextField1.getText().equals(this.holderFolio)) {
/*  919 */       jPintarTexto(this.jTextField1);
/*      */     }
/*  921 */     if (!this.jTextField2.getText().equals("") && !this.jTextField2.getText().equals(this.holderGuia)) {
/*  922 */       jPintarTexto(this.jTextField2);
/*      */     }
/*  924 */     if (!this.jTextField3.getText().equals("") && !this.jTextField3.getText().equals(this.holderOperador)) {
/*  925 */       jPintarTexto(this.jTextField3);
/*      */     }
/*  927 */     if (!this.jTextField4.getText().equals("") && !this.jTextField4.getText().equals(this.holderUnidad)) {
/*  928 */       jPintarTexto(this.jTextField4);
/*      */     }
/*  930 */     if (!this.jTextField5.getText().equals("") && !this.jTextField5.getText().equals(this.holderRemolque)) {
/*  931 */       jPintarTexto(this.jTextField5);
/*      */     }
/*  933 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/*  934 */       jPintarTexto(this.jComboBox8);
/*      */     }
/*  936 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  937 */       jPintarTexto(this.jComboBox1);
/*      */     }
/*  939 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/*  940 */       jPintarTexto(this.jComboBox2);
/*      */     }
/*  942 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/*  943 */       jPintarTexto(this.jComboBox3);
/*      */     }
/*  945 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/*  946 */       jPintarTexto(this.jComboBox4);
/*      */     }
/*  948 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/*  949 */       jPintarTexto(this.jComboBox5);
/*      */     }
/*  951 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/*  952 */       jPintarTexto(this.jComboBox6);
/*      */     }
/*  954 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/*  955 */       jPintarTexto(this.jComboBox7);
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/*  960 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  962 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jTextField1, evt);
/*  963 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  967 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jTextField1, evt);
/*  968 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/*  971 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  973 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jTextField2, evt);
/*  974 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  978 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jTextField2, evt);
/*  979 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/*  982 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  984 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jTextField3, evt);
/*  985 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  989 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jTextField3, evt);
/*  990 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/*  993 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  995 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jTextField4, evt);
/*  996 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1000 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jTextField4, evt);
/* 1001 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1004 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1006 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jTextField5, evt);
/* 1007 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1011 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jTextField5, evt);
/* 1012 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1015 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1017 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox1, evt);
/* 1018 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1022 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox1, evt);
/* 1023 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1026 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1028 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox2, evt);
/* 1029 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1033 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox2, evt);
/* 1034 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1037 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1039 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox3, evt);
/* 1040 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1044 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox3, evt);
/* 1045 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1048 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1050 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox4, evt);
/* 1051 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1055 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox4, evt);
/* 1056 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1059 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1061 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox5, evt);
/* 1062 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1066 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox5, evt);
/* 1067 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1070 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1072 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox6, evt);
/* 1073 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1077 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox6, evt);
/* 1078 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1081 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1083 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox7, evt);
/* 1084 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1088 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox7, evt);
/* 1089 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1092 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1094 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox8, evt);
/* 1095 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1099 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox8, evt);
/* 1100 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/* 1103 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1105 */             buscarManifiestos.this.jTextGanado(buscarManifiestos.this.jComboBox9, evt);
/* 1106 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1110 */             buscarManifiestos.this.jTextPerdido(buscarManifiestos.this.jComboBox9, evt);
/* 1111 */             buscarManifiestos.this.tieneTexto();
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1117 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1121 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1125 */     this.PRIMERA = true;
/* 1126 */     boolean correcto = true;
/* 1127 */     if (this.jDateChooser4.getDate() == null) {
/* 1128 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 1129 */       if (res == 0) {
/* 1130 */         this.jDateChooser4.setDate(this.fechaActual);
/* 1131 */         correcto = true;
/*      */       } else {
/* 1133 */         correcto = false;
/*      */       } 
/* 1135 */     } else if (this.jDateChooser5.getDate() == null) {
/* 1136 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 1137 */       if (res == 0) {
/* 1138 */         this.jDateChooser5.setDate(this.fechaActual);
/* 1139 */         correcto = true;
/*      */       } else {
/* 1141 */         correcto = false;
/*      */       } 
/* 1143 */     } else if (correcto) {
/* 1144 */       Date fecha1 = this.jDateChooser4.getDate();
/* 1145 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 1147 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1148 */       String cadenaFecha = "";
/* 1149 */       cadenaFecha = formato.format(fecha1);
/* 1150 */       String AÑO = cadenaFecha.substring(0, 4);
/* 1151 */       String MES = cadenaFecha.substring(4, 6);
/* 1152 */       String DIA = cadenaFecha.substring(6, 8);
/* 1153 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1155 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 1156 */       cadenaFecha = "";
/* 1157 */       cadenaFecha = formato.format(fecha2);
/* 1158 */       AÑO = cadenaFecha.substring(0, 4);
/* 1159 */       MES = cadenaFecha.substring(4, 6);
/* 1160 */       DIA = cadenaFecha.substring(6, 8);
/* 1161 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */       
/* 1163 */       this.jButton2.setEnabled(false);
/* 1164 */       String residuo = "";
/* 1165 */       String tipo = "";
/* 1166 */       String origen = "";
/* 1167 */       String destino = "";
/* 1168 */       String equipo = "";
/* 1169 */       String plataforma = "";
/* 1170 */       String pozo = "";
/* 1171 */       String estado = "";
/* 1172 */       String ciudad = "";
/* 1173 */       String tablita = "";
/* 1174 */       String TIPOMANI = "";
/* 1175 */       if (this.jComboBox1.getSelectedIndex() == 0) {
/*      */ 
/*      */         
/* 1178 */         TIPOMANI = "(guias.manifiesto not like 'FPR-AG%' and guias.servicio = 'SERVICIO INTEGRAL') ";
/* 1179 */         tablita = "manifiestos_recorteaceite";
/* 1180 */       } else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 1181 */         TIPOMANI = "guias.manifiesto like 'FPR-AG%'";
/* 1182 */         tablita = "manifiestos_lodoagua";
/*      */       } else {
/* 1184 */         TIPOMANI = "(guias.manifiesto not like 'FPR-AG%' and guias.servicio != 'SERVICIO INTEGRAL' AND manifiesto<>'')";
/*      */       } 
/*      */       
/* 1187 */       String TABLA = tablita;
/* 1188 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 1189 */         tipo = String.valueOf(this.jComboBox2.getSelectedItem()) + String.valueOf(this.jComboBox2.getSelectedItem());
/*      */       }
/* 1191 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 1192 */         origen = String.valueOf(this.jComboBox3.getSelectedItem()) + String.valueOf(this.jComboBox3.getSelectedItem());
/*      */       }
/* 1194 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 1195 */         destino = String.valueOf(this.jComboBox4.getSelectedItem()) + String.valueOf(this.jComboBox4.getSelectedItem());
/*      */       }
/* 1197 */       if (this.jComboBox5.getSelectedIndex() != 0) {
/* 1198 */         equipo = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*      */       }
/* 1200 */       if (this.jComboBox6.getSelectedIndex() != 0) {
/* 1201 */         plataforma = String.valueOf(this.jComboBox6.getSelectedItem()) + String.valueOf(this.jComboBox6.getSelectedItem());
/*      */       }
/* 1203 */       if (this.jComboBox7.getSelectedIndex() != 0) {
/* 1204 */         pozo = String.valueOf(this.jComboBox7.getSelectedItem()) + String.valueOf(this.jComboBox7.getSelectedItem());
/*      */       }
/* 1206 */       if (this.jComboBox8.getSelectedIndex() != 2) {
/* 1207 */         estado = String.valueOf(this.jComboBox8.getSelectedItem()) + String.valueOf(this.jComboBox8.getSelectedItem());
/*      */       }
/* 1209 */       if (this.jComboBox9.getSelectedIndex() != 0) {
/* 1210 */         ciudad = String.valueOf(this.jComboBox9.getSelectedItem());
/*      */       }
/*      */       
/* 1213 */       String folioManifiesto = "";
/* 1214 */       String folioGuia = "";
/* 1215 */       String folioOperador = "";
/* 1216 */       String folioUnidad = "";
/* 1217 */       String folioRemolque = "";
/* 1218 */       if (!this.jTextField1.getText().equals(this.holderFolio)) {
/* 1219 */         folioManifiesto = this.jTextField1.getText();
/*      */       }
/* 1221 */       if (!this.jTextField2.getText().equals(this.holderGuia)) {
/* 1222 */         folioGuia = this.jTextField2.getText();
/*      */       }
/* 1224 */       if (!this.jTextField3.getText().equals(this.holderOperador)) {
/* 1225 */         folioOperador = this.jTextField3.getText();
/*      */       }
/* 1227 */       if (!this.jTextField4.getText().equals(this.holderUnidad)) {
/* 1228 */         folioUnidad = this.jTextField4.getText();
/*      */       }
/* 1230 */       if (!this.jTextField5.getText().equals(this.holderRemolque)) {
/* 1231 */         folioRemolque = this.jTextField5.getText();
/*      */       }
/*      */       
/* 1234 */       this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 1235 */             .buscarDatos(16, "guias.manifiesto,guias.num_guia,guias.folio_imp,guias.fecha, residuo, emp_generadora.empresa, emp_destinataria.empresa,num_tracto,num_rem,equipo,plataforma,pozos.nombre,guias.tipo,guias.operador,guias.nombre,guias.estado", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria", "where " + TIPOMANI + " and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.num_guia like '%" + folioGuia + "%' and guias.manifiesto like '%" + folioManifiesto + "%' and emp_generadora.empresa like '%" + origen + "%' and emp_destinataria.empresa like '%" + destino + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.estado like '%" + estado + "%' and guias.tipo like '%" + tipo + "%' and guias.operador like '%" + folioOperador + "%' and emp_generadora.ciudad like '%" + ciudad + "%' and llamadas_historicas.num_tracto like '%" + folioUnidad + "%' and llamadas_historicas.num_rem like '%" + folioRemolque + "%' order by guias.fecha desc"), (Object[])new String[] { "Folio", "Guía", "Folio Impreso", "Fecha", "Residuo", "Cliente", "Destino", "Tractor", "Remolque", "Equipo", "Plataforma", "Pozo", "Tipo", "Operador", "Autorizó", "Estado" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1241 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false };
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1246 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 1249 */       this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 1250 */       this.rSTableMetro1.setSelectionMode(0);
/* 1251 */       this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 1252 */       this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1253 */       this.rSTableMetro1.setShowVerticalLines(false);
/*      */       
/* 1255 */       this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 1256 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1257 */       this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 1258 */       this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 1259 */       this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 1260 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 1261 */       this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(140);
/* 1262 */       this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(140);
/*      */       
/* 1264 */       this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(70);
/* 1265 */       this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(70);
/* 1266 */       this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(70);
/* 1267 */       this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(70);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1291 */       if (this.jComboBox8.getSelectedIndex() == 2) {
/* 1292 */         this.celda.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "ACTIVA", 0, 15, 1));
/*      */       } else {
/* 1294 */         String[] arre = new String[0];
/* 1295 */         this.celda.pasarInd(arre);
/*      */       } 
/*      */       
/* 1298 */       this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 1299 */       this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 1300 */       this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 1301 */       this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1302 */       this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1303 */       this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 1304 */       this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 1305 */       this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 1306 */       this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 1307 */       this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 1308 */       this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 1309 */       this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 1310 */       this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 1311 */       this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 1312 */       this.rSTableMetro1.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 1313 */       this.rSTableMetro1.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 1314 */       this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 1319 */     int cont = this.rSTableMetro1.getRowCount();
/* 1320 */     String[] registros = new String[cont]; int i;
/* 1321 */     for (i = 0; i < cont; i++) {
/* 1322 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 1324 */     for (i = 0; i < cont; i++) {
/* 1325 */       registros[i] = registros[i] + " " + registros[i];
/* 1326 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 1328 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 1329 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void manifiestos(String usu) {
/* 1333 */     this.USUARIO = usu;
/* 1334 */     this.panel.setViewportView(this);
/*      */ 
/*      */     
/* 1337 */     this.fechaActual = new Date();
/* 1338 */     privilegios();
/* 1339 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1340 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 1341 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1342 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 1343 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCombos() {
/* 1348 */     String[] datos = this.con.regresaColIndex("empresa", "emp_generadora", "where clave_gene<>0 order by empresa");
/* 1349 */     this.jComboBox3.removeAllItems();
/* 1350 */     this.jComboBox3.addItem("CLIENTES"); int i;
/* 1351 */     for (i = 0; i < datos.length; i++) {
/* 1352 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */ 
/*      */     
/* 1356 */     datos = this.con.regresaColIndex("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa");
/* 1357 */     this.jComboBox4.removeAllItems();
/* 1358 */     this.jComboBox4.addItem("DESTINOS");
/* 1359 */     for (i = 0; i < datos.length; i++) {
/* 1360 */       this.jComboBox4.addItem(datos[i]);
/*      */     }
/*      */ 
/*      */     
/* 1364 */     datos = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 order by equipo");
/* 1365 */     this.jComboBox5.removeAllItems();
/* 1366 */     this.jComboBox5.addItem("EQUIPOS");
/* 1367 */     for (i = 0; i < datos.length; i++) {
/* 1368 */       this.jComboBox5.addItem(datos[i]);
/*      */     }
/*      */     
/* 1371 */     datos = this.con.regresaColIndex("plataforma", "plataformas", " order by plataforma");
/* 1372 */     this.jComboBox6.removeAllItems();
/* 1373 */     this.jComboBox6.addItem("PLATAFORMAS");
/* 1374 */     for (i = 0; i < datos.length; i++) {
/* 1375 */       this.jComboBox6.addItem(datos[i]);
/*      */     }
/*      */ 
/*      */     
/* 1379 */     datos = this.con.regresaColIndex("nombre", "pozos", "where num_pozo<>0 order by nombre");
/* 1380 */     this.jComboBox7.removeAllItems();
/* 1381 */     this.jComboBox7.addItem("POZOS");
/* 1382 */     for (i = 0; i < datos.length; i++) {
/* 1383 */       this.jComboBox7.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void sacarFecha() {
/* 1388 */     String año = "";
/* 1389 */     String mes = "";
/* 1390 */     String dia = "";
/* 1391 */     Calendar ca = Calendar.getInstance();
/* 1392 */     Calendar fecha = Calendar.getInstance();
/* 1393 */     int aa = fecha.get(1);
/* 1394 */     int mm = fecha.get(2);
/* 1395 */     int dd = fecha.get(5);
/* 1396 */     int diasTotal = diasDelMes(mm, aa);
/* 1397 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1398 */     String strFecha = "";
/* 1399 */     if (diasTotal == dd) {
/* 1400 */       dd = 1;
/* 1401 */       if (mm == 11) {
/* 1402 */         aa++;
/* 1403 */         mm = 0;
/*      */       } else {
/* 1405 */         mm++;
/*      */       } 
/*      */     } else {
/* 1408 */       dd++;
/*      */     } 
/* 1410 */     mm++;
/* 1411 */     año = "" + aa;
/* 1412 */     mes = "" + mm;
/* 1413 */     dia = "" + dd;
/* 1414 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1415 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 1417 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/* 1418 */     } catch (ParseException ex) {
/* 1419 */       ex.printStackTrace();
/*      */     } 
/* 1421 */     this.fechaActual = new Date();
/* 1422 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 1423 */     this.jDateChooser5.setMaxSelectableDate(this.fechaTermino);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 1427 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1435 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1441 */         return 30;
/*      */       
/*      */       case 1:
/* 1444 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1446 */           return 29;
/*      */         }
/* 1448 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 1452 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void privilegios() {
/* 1457 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 1458 */     if (this.con.Campo.equals("FACTURACIÓN")) {
/* 1459 */       this.jButton2.setEnabled(false);
/*      */     } else {
/* 1461 */       this.jButton2.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 1467 */     int otro = -1;
/* 1468 */     String[] indices = new String[0];
/* 1469 */     String[] indices2 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1472 */       setEnabled((table == null || table.isEnabled()));
/* 1473 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 1474 */       if (comparar(comp)) {
/* 1475 */         setBackground(Color.red);
/* 1476 */         setForeground(Color.white);
/* 1477 */       } else if (comparar2(comp)) {
/* 1478 */         setBackground(Color.YELLOW);
/* 1479 */         setForeground(Color.red);
/* 1480 */       } else if (row % 2 == 0 && (column == 0 || column == 1)) {
/* 1481 */         setBackground(new Color(120, 200, 104));
/* 1482 */       } else if (row % 2 == 0 && (column == 9 || column == 10 || column == 11)) {
/* 1483 */         setBackground(new Color(136, 191, 173));
/* 1484 */       } else if (row % 2 == 0) {
/* 1485 */         setBackground(buscarManifiestos.this.lc.FONDOTABLA);
/*      */       } else {
/*      */         
/* 1488 */         setBackground((Color)null);
/*      */       } 
/* 1490 */       setForeground(buscarManifiestos.this.lc.SECUNDARIO1);
/* 1491 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1492 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 1496 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 1500 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 1504 */       for (int i = 0; i < this.indices.length; i++) {
/* 1505 */         if (this.indices[i].equals(reg)) {
/* 1506 */           return true;
/*      */         }
/*      */       } 
/* 1509 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 1513 */       for (int i = 0; i < this.indices2.length; i++) {
/* 1514 */         if (this.indices2[i].equals(reg)) {
/* 1515 */           return true;
/*      */         }
/*      */       } 
/* 1518 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable {
/*      */     Thread t;
/* 1525 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 1528 */       this.t = new Thread(this);
/* 1529 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 1537 */         Thread.currentThread(); Thread.sleep(1000L);
/* 1538 */         detener();
/* 1539 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 1544 */       buscarManifiestos.this.consultar();
/* 1545 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 1549 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/buscarManifiestos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */