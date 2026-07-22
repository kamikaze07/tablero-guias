/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.NumberFormat;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class Configuracion extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   35 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   36 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   37 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   38 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   39 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   40 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   41 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   42 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   43 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   45 */   Validaciones val = new Validaciones();
/*   46 */   Consultas con = new Consultas();
/*   47 */   Consultas2 con2 = new Consultas2();
/*   48 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*   52 */   String FOTO = "";
/*   53 */   String CLAVEPERIODO = "";
/*   54 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   boolean entraSuc = true;
/*   57 */   String claveSuc = "";
/*   58 */   CeldaRender1 celda1 = new CeldaRender1();
/*   59 */   Map<String, String> CARPETAS = new TreeMap<>(); private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton55; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JCheckBox jCheckBox10; private JCheckBox jCheckBox11; private JCheckBox jCheckBox12; private JCheckBox jCheckBox2; private JCheckBox jCheckBox3; private JCheckBox jCheckBox4; private JCheckBox jCheckBox5; private JCheckBox jCheckBox6; private JCheckBox jCheckBox7; private JCheckBox jCheckBox8; private JCheckBox jCheckBox9; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox9; private JDialog jDialog1; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28;
/*      */   private JLabel jLabel29;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel30;
/*      */   
/*      */   public Configuracion(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES) {
/*   65 */     this.con2.setBaseDatos("sicre2PR");
/*   66 */     this.con2.cambiarServidor();
/*   67 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   68 */     this.padre = padre;
/*   69 */     this.fichas = fichas;
/*   70 */     initComponents();
/*   71 */     this.USUARIO = USUARIO;
/*   72 */     panelito.setViewportView(this);
/*   73 */     this.panel = panelito;
/*   74 */     initComponents();
/*   75 */     colorear();
/*   76 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*   77 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*   78 */     editFormat.setGroupingUsed(false);
/*   79 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*   80 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*   81 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*   82 */     DefaultFormatterFactory currFactory2 = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*   83 */     enFormat.setAllowsInvalid(true);
/*   84 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*   85 */     this.jFormattedTextField1.setValue(Double.valueOf(0.0D));
/*   86 */     this.jFormattedTextField2.setFormatterFactory(currFactory2);
/*   87 */     this.jFormattedTextField2.setValue(Double.valueOf(0.0D));
/*   88 */     this.jFormattedTextField3.setFormatterFactory(currFactory2);
/*   89 */     this.jFormattedTextField3.setValue(Double.valueOf(0.0D));
/*   90 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   91 */     Cursor micursor2 = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   92 */     this.rSTableMetro1.setCursor(micursor2);
/*      */     
/*   94 */     llenarCombo();
/*   95 */     cargarConfig();
/*      */     
/*   97 */     privilegios();
/*      */     
/*   99 */     int w = this.tama.width;
/*  100 */     int h = this.tama.height;
/*  101 */     int rw = (w - 656) / 2;
/*  102 */     int rh = (h - 383) / 2;
/*      */ 
/*      */     
/*  105 */     String[][] carpetas = this.con.buscarDatos("tipo, direccion", "unidadescarpetas", "");
/*  106 */     for (int i = 0; i < carpetas.length; i++) {
/*  107 */       this.CARPETAS.put(carpetas[i][0], carpetas[i][1]);
/*      */     }
/*  109 */     this.jTextField15.setText(this.CARPETAS.get("TC"));
/*  110 */     this.jTextField16.setText(this.CARPETAS.get("POLIZA"));
/*  111 */     this.jTextField17.setText(this.CARPETAS.get("SEDEMA"));
/*  112 */     this.jTextField18.setText(this.CARPETAS.get("NOM012"));
/*  113 */     this.jTextField19.setText(this.CARPETAS.get("VERIFICACION"));
/*  114 */     this.jTextField20.setText(this.CARPETAS.get("FISICOMECANICA"));
/*  115 */     this.jTextField21.setText(this.CARPETAS.get("SCT"));
/*  116 */     this.jTextField23.setText(this.CARPETAS.get("OTRO"));
/*  117 */     this.jTextField22.setText(this.CARPETAS.get("INSPECCION"));
/*  118 */     this.jTextField24.setText(this.CARPETAS.get("PAGOS"));
/*  119 */     this.jDialog1.setLocation(rw, rh);
/*  120 */     this.jDialog1.setSize(656, 400);
/*  121 */     this.jDialog1.setVisible(false);
/*  122 */     this.jDialog1.setResizable(false);
/*      */   }
/*      */   private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel62; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel2; private JPanel jPanel25; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane38; private JSeparator jSeparator1; private JSeparator jSeparator3; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JTabbedPane jTabbedPane1; private JTable jTable1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton1; private MaterialButton materialButton2; private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private void initComponents() {
/*  127 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  128 */     this.jPanel25 = new JPanel();
/*  129 */     this.jLabel62 = new JLabel();
/*  130 */     this.jSeparator3 = new JSeparator();
/*  131 */     this.jLabel24 = new JLabel();
/*  132 */     this.jComboBox9 = new JComboBox();
/*  133 */     this.jSpinner2 = new JSpinner();
/*  134 */     this.jLabel25 = new JLabel();
/*  135 */     this.jLabel26 = new JLabel();
/*  136 */     this.jButton8 = new JButton();
/*  137 */     this.jPanel10 = new JPanel();
/*  138 */     this.jScrollPane1 = new JScrollPane();
/*  139 */     this.jTable1 = new JTable();
/*  140 */     this.jButton9 = new JButton();
/*  141 */     this.jButton55 = new JButton();
/*  142 */     this.jButton10 = new JButton();
/*  143 */     this.jLabel48 = new JLabel();
/*  144 */     this.jPanel11 = new JPanel();
/*  145 */     this.jLabel23 = new JLabel();
/*  146 */     this.jButton7 = new JButton();
/*  147 */     this.jPanel6 = new JPanel();
/*  148 */     this.jLabel3 = new JLabel();
/*  149 */     this.jSeparator1 = new JSeparator();
/*  150 */     this.jTabbedPane1 = new JTabbedPane();
/*  151 */     this.jPanel1 = new JPanel();
/*  152 */     this.jPanel7 = new JPanel();
/*  153 */     this.jLabel4 = new JLabel();
/*  154 */     this.jTextField1 = new JTextField();
/*  155 */     this.jLabel5 = new JLabel();
/*  156 */     this.jLabel1 = new JLabel();
/*  157 */     this.jTextField2 = new JTextField();
/*  158 */     this.jLabel2 = new JLabel();
/*  159 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  160 */     this.jLabel6 = new JLabel();
/*  161 */     this.jLabel7 = new JLabel();
/*  162 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  163 */     this.jLabel8 = new JLabel();
/*  164 */     this.jComboBox2 = new JComboBox();
/*  165 */     this.jLabel9 = new JLabel();
/*  166 */     this.jLabel10 = new JLabel();
/*  167 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  168 */     this.jLabel11 = new JLabel();
/*  169 */     this.jTextField3 = new JTextField();
/*  170 */     this.jLabel12 = new JLabel();
/*  171 */     this.jLabel13 = new JLabel();
/*  172 */     this.jTextField4 = new JTextField();
/*  173 */     this.jPanel8 = new JPanel();
/*  174 */     this.jLabel17 = new JLabel();
/*  175 */     this.jTextField7 = new JTextField();
/*  176 */     this.jLabel18 = new JLabel();
/*  177 */     this.jTextField8 = new JTextField();
/*  178 */     this.jLabel19 = new JLabel();
/*  179 */     this.jComboBox3 = new JComboBox();
/*  180 */     this.jLabel22 = new JLabel();
/*  181 */     this.jSpinner1 = new JSpinner();
/*  182 */     this.jLabel29 = new JLabel();
/*  183 */     this.jTextField13 = new JTextField();
/*  184 */     this.jPanel2 = new JPanel();
/*  185 */     this.jLabel14 = new JLabel();
/*  186 */     this.jTextField5 = new JTextField();
/*  187 */     this.jButton3 = new JButton();
/*  188 */     this.jLabel15 = new JLabel();
/*  189 */     this.jTextField6 = new JTextField();
/*  190 */     this.jButton4 = new JButton();
/*  191 */     this.jPanel3 = new JPanel();
/*  192 */     this.jCheckBox1 = new JCheckBox();
/*  193 */     this.jCheckBox2 = new JCheckBox();
/*  194 */     this.jCheckBox3 = new JCheckBox();
/*  195 */     this.jCheckBox4 = new JCheckBox();
/*  196 */     this.jCheckBox5 = new JCheckBox();
/*  197 */     this.jCheckBox6 = new JCheckBox();
/*  198 */     this.jCheckBox7 = new JCheckBox();
/*  199 */     this.jCheckBox8 = new JCheckBox();
/*  200 */     this.jCheckBox9 = new JCheckBox();
/*  201 */     this.jCheckBox11 = new JCheckBox();
/*  202 */     this.jCheckBox10 = new JCheckBox();
/*  203 */     this.jCheckBox12 = new JCheckBox();
/*  204 */     this.jPanel9 = new JPanel();
/*  205 */     this.jLabel20 = new JLabel();
/*  206 */     this.jLabel21 = new JLabel();
/*  207 */     this.jTextField9 = new JTextField();
/*  208 */     this.jTextField10 = new JTextField();
/*  209 */     this.jButton5 = new JButton();
/*  210 */     this.jButton6 = new JButton();
/*  211 */     this.jLabel27 = new JLabel();
/*  212 */     this.jTextField11 = new JTextField();
/*  213 */     this.jButton11 = new JButton();
/*  214 */     this.jButton12 = new JButton();
/*  215 */     this.jLabel28 = new JLabel();
/*  216 */     this.jTextField12 = new JTextField();
/*  217 */     this.jPanel4 = new JPanel();
/*  218 */     this.jPanel5 = new JPanel();
/*  219 */     this.jScrollPane38 = new JScrollPane();
/*  220 */     this.rSTableMetro1 = new RSTableMetro();
/*  221 */     this.jLabel16 = new JLabel();
/*  222 */     this.jTextField14 = new JTextField();
/*  223 */     this.materialButton1 = new MaterialButton();
/*  224 */     this.materialButton2 = new MaterialButton();
/*  225 */     this.jPanel12 = new JPanel();
/*  226 */     this.jLabel30 = new JLabel();
/*  227 */     this.jTextField15 = new JTextField();
/*  228 */     this.jButton13 = new JButton();
/*  229 */     this.jLabel31 = new JLabel();
/*  230 */     this.jTextField16 = new JTextField();
/*  231 */     this.jButton14 = new JButton();
/*  232 */     this.jLabel32 = new JLabel();
/*  233 */     this.jTextField17 = new JTextField();
/*  234 */     this.jButton15 = new JButton();
/*  235 */     this.jLabel33 = new JLabel();
/*  236 */     this.jTextField18 = new JTextField();
/*  237 */     this.jButton16 = new JButton();
/*  238 */     this.jLabel34 = new JLabel();
/*  239 */     this.jTextField19 = new JTextField();
/*  240 */     this.jButton17 = new JButton();
/*  241 */     this.jLabel35 = new JLabel();
/*  242 */     this.jTextField20 = new JTextField();
/*  243 */     this.jButton18 = new JButton();
/*  244 */     this.jLabel36 = new JLabel();
/*  245 */     this.jTextField21 = new JTextField();
/*  246 */     this.jButton19 = new JButton();
/*  247 */     this.jLabel37 = new JLabel();
/*  248 */     this.jTextField22 = new JTextField();
/*  249 */     this.jButton20 = new JButton();
/*  250 */     this.jLabel38 = new JLabel();
/*  251 */     this.jSpinner3 = new JSpinner();
/*  252 */     this.jLabel39 = new JLabel();
/*  253 */     this.jTextField23 = new JTextField();
/*  254 */     this.jButton21 = new JButton();
/*  255 */     this.jLabel40 = new JLabel();
/*  256 */     this.jTextField24 = new JTextField();
/*  257 */     this.jButton22 = new JButton();
/*  258 */     this.jButton1 = new JButton();
/*  259 */     this.jButton2 = new JButton();
/*      */     
/*  261 */     this.jDialog1.setTitle("Organizar líneas de crédito");
/*      */     
/*  263 */     this.jPanel25.setBackground(new Color(146, 193, 134));
/*      */     
/*  265 */     this.jLabel62.setFont(new Font("Tahoma", 1, 14));
/*  266 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/*  267 */     this.jLabel62.setHorizontalAlignment(0);
/*  268 */     this.jLabel62.setText("Organizar líneas de crédito");
/*      */     
/*  270 */     this.jLabel24.setText("Cliente:");
/*      */     
/*  272 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/*  273 */     this.jComboBox9.setFont(new Font("Tahoma", 0, 10));
/*      */     
/*  275 */     this.jSpinner2.setModel(new SpinnerNumberModel(1, 1, 180, 1));
/*      */     
/*  277 */     this.jLabel25.setText("Días:");
/*      */     
/*  279 */     this.jLabel26.setText("Clic para guardar");
/*      */     
/*  281 */     this.jButton8.setMnemonic('G');
/*  282 */     this.jButton8.setText("Guardar");
/*  283 */     this.jButton8.setToolTipText("Guardar (Alta+ G)");
/*  284 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  286 */             Configuracion.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  290 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*  291 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder("Organizar periodos de vencimiento"));
/*      */     
/*  293 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  304 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  306 */     this.jButton9.setMnemonic('M');
/*  307 */     this.jButton9.setText("Modificar");
/*  308 */     this.jButton9.setToolTipText("Modificar (Alt+M)");
/*  309 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  311 */             Configuracion.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  315 */     this.jButton55.setMnemonic('C');
/*  316 */     this.jButton55.setText("Cerrar");
/*  317 */     this.jButton55.setToolTipText("Cerrar (Alt+C)");
/*  318 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  320 */             Configuracion.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  324 */     this.jButton10.setMnemonic('E');
/*  325 */     this.jButton10.setText("Eliminar");
/*  326 */     this.jButton10.setToolTipText("Eliminar (Alt+E)");
/*  327 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  329 */             Configuracion.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  333 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/*  334 */     this.jLabel48.setForeground(Color.red);
/*  335 */     this.jLabel48.setHorizontalAlignment(0);
/*  336 */     this.jLabel48.setText("t");
/*  337 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  339 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  340 */     this.jPanel10.setLayout(jPanel10Layout);
/*  341 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  342 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  343 */         .addComponent(this.jScrollPane1)
/*  344 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  345 */           .addComponent(this.jLabel48, -2, 163, -2)
/*  346 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 140, 32767)
/*  347 */           .addComponent(this.jButton10, -2, 100, -2)
/*  348 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  349 */           .addComponent(this.jButton9, -2, 100, -2)
/*  350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  351 */           .addComponent(this.jButton55, -2, 100, -2)));
/*      */     
/*  353 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  355 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  356 */           .addComponent(this.jScrollPane1, -2, 170, -2)
/*  357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  358 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  359 */             .addComponent(this.jButton55)
/*  360 */             .addComponent(this.jButton9)
/*  361 */             .addComponent(this.jButton10)
/*  362 */             .addComponent(this.jLabel48))
/*  363 */           .addGap(0, 9, 32767)));
/*      */ 
/*      */     
/*  366 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  367 */     this.jPanel25.setLayout(jPanel25Layout);
/*  368 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  370 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  371 */           .addContainerGap()
/*  372 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  373 */             .addComponent(this.jLabel62, -1, -1, 32767)
/*  374 */             .addComponent(this.jSeparator3)
/*  375 */             .addComponent(this.jPanel10, -1, -1, 32767)
/*  376 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  377 */               .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  378 */                 .addGroup(jPanel25Layout.createSequentialGroup()
/*  379 */                   .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  380 */                     .addComponent(this.jLabel26, GroupLayout.Alignment.LEADING, -1, 123, 32767)
/*  381 */                     .addComponent(this.jLabel25, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  382 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  383 */                   .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  384 */                     .addComponent(this.jButton8, -1, 99, 32767)
/*  385 */                     .addComponent(this.jSpinner2)))
/*  386 */                 .addGroup(jPanel25Layout.createSequentialGroup()
/*  387 */                   .addComponent(this.jLabel24, -2, 123, -2)
/*  388 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  389 */                   .addComponent(this.jComboBox9, -2, 338, -2)))
/*  390 */               .addGap(0, 0, 32767)))
/*  391 */           .addContainerGap()));
/*      */     
/*  393 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  395 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  396 */           .addComponent(this.jLabel62)
/*  397 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  398 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  399 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  400 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  401 */             .addComponent(this.jLabel24)
/*  402 */             .addComponent(this.jComboBox9, -2, -1, -2))
/*  403 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  404 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  405 */             .addComponent(this.jLabel25)
/*  406 */             .addComponent(this.jSpinner2, -2, -1, -2))
/*  407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  408 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  409 */             .addComponent(this.jLabel26)
/*  410 */             .addComponent(this.jButton8))
/*  411 */           .addGap(18, 18, 18)
/*  412 */           .addComponent(this.jPanel10, -2, -1, -2)));
/*      */ 
/*      */     
/*  415 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  416 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  417 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  418 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  419 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  420 */           .addComponent(this.jPanel25, -2, -1, -2)
/*  421 */           .addGap(0, 0, 32767)));
/*      */     
/*  423 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  424 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  425 */         .addComponent(this.jPanel25, -2, -1, -2));
/*      */ 
/*      */     
/*  428 */     this.jLabel23.setFont(new Font("Tahoma", 2, 11));
/*  429 */     this.jLabel23.setHorizontalAlignment(2);
/*  430 */     this.jLabel23.setText("<html>Clic para configurar líneas de crédito</html>");
/*      */     
/*  432 */     this.jButton7.setText("Crédito");
/*  433 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  435 */             Configuracion.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  439 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  440 */     this.jPanel11.setLayout(jPanel11Layout);
/*  441 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  442 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  443 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  444 */           .addContainerGap()
/*  445 */           .addComponent(this.jLabel23, -2, 0, 32767)
/*  446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  447 */           .addComponent(this.jButton7, -1, -1, 32767)
/*  448 */           .addGap(454, 454, 454)));
/*      */     
/*  450 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  451 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  452 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  453 */           .addContainerGap()
/*  454 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  455 */             .addComponent(this.jLabel23, -2, -1, -2)
/*  456 */             .addComponent(this.jButton7))
/*  457 */           .addContainerGap(381, 32767)));
/*      */ 
/*      */     
/*  460 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*  461 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  463 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/*  464 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/*  465 */     this.jLabel3.setHorizontalAlignment(0);
/*  466 */     this.jLabel3.setText("CONFIGURACIÓN");
/*      */     
/*  468 */     this.jTabbedPane1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  470 */             Configuracion.this.jTabbedPane1MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  474 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  476 */     this.jLabel4.setFont(new Font("Tahoma", 2, 11));
/*  477 */     this.jLabel4.setHorizontalAlignment(2);
/*  478 */     this.jLabel4.setText("Directivas de Folios");
/*      */     
/*  480 */     this.jTextField1.setHorizontalAlignment(4);
/*  481 */     this.jTextField1.setText("PR");
/*      */     
/*  483 */     this.jLabel5.setText("- 00001");
/*      */     
/*  485 */     this.jLabel1.setFont(new Font("Tahoma", 2, 11));
/*  486 */     this.jLabel1.setHorizontalAlignment(2);
/*  487 */     this.jLabel1.setText("I.V.A. %");
/*      */     
/*  489 */     this.jTextField2.setHorizontalAlignment(4);
/*  490 */     this.jTextField2.setText("16");
/*      */     
/*  492 */     this.jLabel2.setFont(new Font("Tahoma", 2, 11));
/*  493 */     this.jLabel2.setHorizontalAlignment(2);
/*  494 */     this.jLabel2.setText("Gastos por Viaje");
/*      */     
/*  496 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  497 */     this.jFormattedTextField1.setText("$0.0");
/*      */     
/*  499 */     this.jLabel6.setText("<html>Esta cantidad aparecerá por defecto en los vales de caja chica</html>");
/*      */     
/*  501 */     this.jLabel7.setFont(new Font("Tahoma", 2, 11));
/*  502 */     this.jLabel7.setHorizontalAlignment(2);
/*  503 */     this.jLabel7.setText("Precio Diesel");
/*      */     
/*  505 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*  506 */     this.jFormattedTextField2.setText("$0.0");
/*      */     
/*  508 */     this.jLabel8.setFont(new Font("Tahoma", 2, 11));
/*  509 */     this.jLabel8.setHorizontalAlignment(2);
/*  510 */     this.jLabel8.setText("Día Infonavit");
/*      */     
/*  512 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  513 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/*  514 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" }));
/*      */     
/*  516 */     this.jLabel9.setText("<html>En este día se cargarán todos los adeudos de Infonavit</html>");
/*      */     
/*  518 */     this.jLabel10.setFont(new Font("Tahoma", 2, 11));
/*  519 */     this.jLabel10.setHorizontalAlignment(2);
/*  520 */     this.jLabel10.setText("Salario Renta");
/*      */     
/*  522 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*  523 */     this.jFormattedTextField3.setText("$0.0");
/*      */     
/*  525 */     this.jLabel11.setFont(new Font("Tahoma", 2, 11));
/*  526 */     this.jLabel11.setHorizontalAlignment(2);
/*  527 */     this.jLabel11.setText("Retención %");
/*      */     
/*  529 */     this.jTextField3.setHorizontalAlignment(4);
/*  530 */     this.jTextField3.setText("16");
/*      */     
/*  532 */     this.jLabel12.setText("Impuesto Retenido");
/*      */     
/*  534 */     this.jLabel13.setFont(new Font("Tahoma", 2, 11));
/*  535 */     this.jLabel13.setHorizontalAlignment(2);
/*  536 */     this.jLabel13.setText("SEMARNAT");
/*      */     
/*  538 */     this.jTextField4.setHorizontalAlignment(4);
/*      */     
/*  540 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  541 */     this.jPanel7.setLayout(jPanel7Layout);
/*  542 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  544 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  545 */           .addContainerGap()
/*  546 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  547 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  548 */               .addComponent(this.jLabel7, -2, 76, -2)
/*  549 */               .addGap(365, 365, 365))
/*  550 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/*  551 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  552 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/*  553 */                   .addGap(2, 2, 2)
/*  554 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  555 */                     .addGroup(jPanel7Layout.createSequentialGroup()
/*  556 */                       .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  557 */                         .addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -2, 96, 32767)
/*  558 */                         .addGroup(GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  559 */                           .addComponent(this.jLabel1, -1, -1, 32767)
/*  560 */                           .addComponent(this.jLabel2, -2, 88, 32767)))
/*  561 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/*  562 */                     .addGroup(jPanel7Layout.createSequentialGroup()
/*  563 */                       .addComponent(this.jLabel8, -2, 76, -2)
/*  564 */                       .addGap(20, 20, 20))))
/*  565 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/*  566 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  567 */                     .addComponent(this.jLabel13, -2, 76, -2)
/*  568 */                     .addComponent(this.jLabel11, -2, 76, -2)
/*  569 */                     .addComponent(this.jLabel10, -1, 98, 32767))
/*  570 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/*  571 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  572 */                 .addComponent(this.jTextField4)
/*  573 */                 .addComponent(this.jTextField3)
/*  574 */                 .addComponent(this.jFormattedTextField3)
/*  575 */                 .addComponent(this.jComboBox2, 0, -1, 32767)
/*  576 */                 .addComponent(this.jTextField1)
/*  577 */                 .addComponent(this.jFormattedTextField1)
/*  578 */                 .addComponent(this.jTextField2, -1, 128, 32767)
/*  579 */                 .addComponent(this.jFormattedTextField2))
/*  580 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  581 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  582 */                 .addComponent(this.jLabel12, -2, 187, -2)
/*  583 */                 .addComponent(this.jLabel5, -2, 79, -2)
/*  584 */                 .addComponent(this.jLabel6, -2, 207, -2)
/*  585 */                 .addComponent(this.jLabel9, -2, 207, -2))))
/*  586 */           .addContainerGap()));
/*      */     
/*  588 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  589 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  591 */           .addContainerGap()
/*  592 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  593 */             .addComponent(this.jLabel4)
/*  594 */             .addComponent(this.jLabel5)
/*  595 */             .addComponent(this.jTextField1, -2, -1, -2))
/*  596 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  598 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  599 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  600 */                 .addComponent(this.jLabel1)
/*  601 */                 .addComponent(this.jTextField2, -2, -1, -2))
/*  602 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  603 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  604 */                 .addComponent(this.jLabel2)
/*  605 */                 .addComponent(this.jFormattedTextField1, -2, -1, -2))
/*  606 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  607 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  608 */                 .addComponent(this.jLabel7)
/*  609 */                 .addComponent(this.jFormattedTextField2, -2, -1, -2)))
/*  610 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  611 */               .addGap(27, 27, 27)
/*  612 */               .addComponent(this.jLabel6, -2, -1, -2)))
/*  613 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  614 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  615 */             .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  616 */               .addComponent(this.jLabel8)
/*  617 */               .addComponent(this.jComboBox2, -2, -1, -2))
/*  618 */             .addComponent(this.jLabel9, -2, -1, -2))
/*  619 */           .addGap(12, 12, 12)
/*  620 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  621 */             .addComponent(this.jFormattedTextField3, -2, -1, -2)
/*  622 */             .addComponent(this.jLabel10))
/*  623 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  624 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  625 */             .addComponent(this.jTextField3, -2, -1, -2)
/*  626 */             .addComponent(this.jLabel12)
/*  627 */             .addComponent(this.jLabel11))
/*  628 */           .addGap(9, 9, 9)
/*  629 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  630 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  631 */             .addComponent(this.jLabel13))
/*  632 */           .addContainerGap(93, 32767)));
/*      */ 
/*      */     
/*  635 */     this.jLabel17.setFont(new Font("Tahoma", 2, 11));
/*  636 */     this.jLabel17.setHorizontalAlignment(2);
/*  637 */     this.jLabel17.setText("Capacitador QHSE");
/*      */     
/*  639 */     this.jLabel18.setFont(new Font("Tahoma", 2, 11));
/*  640 */     this.jLabel18.setHorizontalAlignment(2);
/*  641 */     this.jLabel18.setText("Sucursal");
/*      */     
/*  643 */     this.jLabel19.setFont(new Font("Tahoma", 2, 11));
/*  644 */     this.jLabel19.setHorizontalAlignment(2);
/*  645 */     this.jLabel19.setText("Abonar Facturas");
/*      */     
/*  647 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*      */     
/*  649 */     this.jLabel22.setFont(new Font("Tahoma", 2, 11));
/*  650 */     this.jLabel22.setHorizontalAlignment(2);
/*  651 */     this.jLabel22.setText("<html>Días antes del reporte de viajes PENDIENTES</html>");
/*      */     
/*  653 */     this.jSpinner1.setModel(new SpinnerNumberModel(20, 0, 50, 1));
/*      */     
/*  655 */     this.jLabel29.setFont(new Font("Tahoma", 2, 11));
/*  656 */     this.jLabel29.setHorizontalAlignment(2);
/*  657 */     this.jLabel29.setText("Nombre del Capacitador");
/*      */     
/*  659 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  660 */     this.jPanel8.setLayout(jPanel8Layout);
/*  661 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  663 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  664 */           .addContainerGap()
/*  665 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  666 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  667 */               .addComponent(this.jLabel22, -2, 117, -2)
/*  668 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  669 */               .addComponent(this.jSpinner1, -2, 50, -2))
/*  670 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  671 */               .addComponent(this.jLabel17, -2, 117, -2)
/*  672 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  673 */               .addComponent(this.jTextField7, -2, 155, -2))
/*  674 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  675 */               .addComponent(this.jLabel18, -2, 117, -2)
/*  676 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  677 */               .addComponent(this.jTextField8, -2, 155, -2))
/*  678 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  679 */               .addComponent(this.jLabel19, -2, 117, -2)
/*  680 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */               .addComponent(this.jComboBox3, -2, 142, -2))
/*  682 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  683 */               .addComponent(this.jLabel29, -2, 117, -2)
/*  684 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  685 */               .addComponent(this.jTextField13, -2, 155, -2)))
/*  686 */           .addGap(22, 22, 22)));
/*      */     
/*  688 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  689 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  690 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  691 */           .addContainerGap()
/*  692 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  693 */             .addComponent(this.jLabel17)
/*  694 */             .addComponent(this.jTextField7, -2, -1, -2))
/*  695 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  696 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  697 */             .addComponent(this.jLabel29)
/*  698 */             .addComponent(this.jTextField13, -2, -1, -2))
/*  699 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  700 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  701 */             .addComponent(this.jLabel18)
/*  702 */             .addComponent(this.jTextField8, -2, -1, -2))
/*  703 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  704 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  705 */             .addComponent(this.jLabel19)
/*  706 */             .addComponent(this.jComboBox3, -2, -1, -2))
/*  707 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  709 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  710 */               .addComponent(this.jLabel22, -2, 50, -2))
/*  711 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  712 */               .addGap(18, 18, 18)
/*  713 */               .addComponent(this.jSpinner1, -2, -1, -2)))
/*  714 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  717 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  718 */     this.jPanel1.setLayout(jPanel1Layout);
/*  719 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  721 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  722 */           .addContainerGap()
/*  723 */           .addComponent(this.jPanel7, -2, -1, -2)
/*  724 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  725 */           .addComponent(this.jPanel8, -2, -1, -2)
/*  726 */           .addGap(99, 99, 99)));
/*      */     
/*  728 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  729 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  730 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  731 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  732 */             .addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  733 */             .addComponent(this.jPanel7, -1, -1, 32767))
/*  734 */           .addContainerGap()));
/*      */ 
/*      */     
/*  737 */     this.jTabbedPane1.addTab("General", this.jPanel1);
/*      */     
/*  739 */     this.jPanel2.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  741 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  742 */     this.jLabel14.setText("Fotos Operadores");
/*      */     
/*  744 */     this.jTextField5.setEditable(false);
/*      */     
/*  746 */     this.jButton3.setText("Buscar");
/*  747 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  749 */             Configuracion.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  753 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/*  754 */     this.jLabel15.setText("Fotos Empleados");
/*      */     
/*  756 */     this.jTextField6.setEditable(false);
/*      */     
/*  758 */     this.jButton4.setText("Buscar");
/*  759 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  761 */             Configuracion.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  765 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder("Avisos"));
/*      */     
/*  767 */     this.jCheckBox1.setText("Guias");
/*      */     
/*  769 */     this.jCheckBox2.setText("Operadores");
/*      */     
/*  771 */     this.jCheckBox3.setText("Perforacion");
/*      */     
/*  773 */     this.jCheckBox4.setText("Empleados");
/*      */     
/*  775 */     this.jCheckBox5.setText("Clientes");
/*      */     
/*  777 */     this.jCheckBox6.setText("Destinos");
/*      */     
/*  779 */     this.jCheckBox7.setText("Facturación");
/*      */     
/*  781 */     this.jCheckBox8.setText("Liquidaciones");
/*      */     
/*  783 */     this.jCheckBox9.setText("Venc Licencias");
/*      */     
/*  785 */     this.jCheckBox11.setText("Reseteos");
/*      */     
/*  787 */     this.jCheckBox10.setText("R.H.");
/*      */     
/*  789 */     this.jCheckBox12.setText("Cuentas por pagar");
/*      */     
/*  791 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  792 */     this.jPanel3.setLayout(jPanel3Layout);
/*  793 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  794 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  795 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  796 */           .addContainerGap()
/*  797 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  798 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  799 */               .addComponent(this.jCheckBox1, -2, 107, -2)
/*  800 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  801 */               .addComponent(this.jCheckBox2, -2, 107, -2))
/*  802 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  803 */               .addComponent(this.jCheckBox7, -2, 107, -2)
/*  804 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  805 */               .addComponent(this.jCheckBox8, -2, 116, -2)))
/*  806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  808 */             .addComponent(this.jCheckBox4, -1, -1, 32767)
/*  809 */             .addComponent(this.jCheckBox9, -1, -1, 32767))
/*  810 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  811 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  812 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  813 */               .addComponent(this.jCheckBox5, -2, 107, -2)
/*  814 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  815 */               .addComponent(this.jCheckBox6, -2, 107, -2)
/*  816 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  817 */               .addComponent(this.jCheckBox3, -2, 117, -2))
/*  818 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  819 */               .addComponent(this.jCheckBox11, -2, 107, -2)
/*  820 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  821 */               .addComponent(this.jCheckBox12, -1, -1, 32767)))
/*  822 */           .addGap(18, 18, 18)
/*  823 */           .addComponent(this.jCheckBox10, -2, 67, -2)
/*  824 */           .addContainerGap(-1, 32767)));
/*      */     
/*  826 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  827 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  828 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  829 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  830 */             .addComponent(this.jCheckBox1)
/*  831 */             .addComponent(this.jCheckBox2)
/*  832 */             .addComponent(this.jCheckBox4, -2, 23, -2)
/*  833 */             .addComponent(this.jCheckBox5, -2, 23, -2)
/*  834 */             .addComponent(this.jCheckBox6, -2, 23, -2)
/*  835 */             .addComponent(this.jCheckBox3, -2, 23, -2)
/*  836 */             .addComponent(this.jCheckBox10, -2, 23, -2))
/*  837 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  838 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  839 */             .addComponent(this.jCheckBox7, -2, 23, -2)
/*  840 */             .addComponent(this.jCheckBox8, -2, 23, -2)
/*  841 */             .addComponent(this.jCheckBox9, -2, 23, -2)
/*  842 */             .addComponent(this.jCheckBox11, -2, 23, -2)
/*  843 */             .addComponent(this.jCheckBox12, -2, 23, -2))
/*  844 */           .addContainerGap(19, 32767)));
/*      */ 
/*      */     
/*  847 */     this.jPanel9.setBorder(BorderFactory.createTitledBorder("Manifiestos"));
/*      */     
/*  849 */     this.jLabel20.setFont(new Font("Tahoma", 2, 11));
/*  850 */     this.jLabel20.setText("Aceite");
/*      */     
/*  852 */     this.jLabel21.setFont(new Font("Tahoma", 2, 11));
/*  853 */     this.jLabel21.setText("Agua");
/*      */     
/*  855 */     this.jTextField9.setEditable(false);
/*      */     
/*  857 */     this.jTextField10.setEditable(false);
/*      */     
/*  859 */     this.jButton5.setText("Buscar");
/*  860 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  862 */             Configuracion.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  866 */     this.jButton6.setText("Buscar");
/*  867 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  869 */             Configuracion.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  873 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  874 */     this.jPanel9.setLayout(jPanel9Layout);
/*  875 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  876 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  877 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  878 */           .addContainerGap()
/*  879 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  880 */             .addComponent(this.jLabel20, -1, 93, 32767)
/*  881 */             .addComponent(this.jLabel21, -1, -1, 32767))
/*  882 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  883 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  884 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  885 */               .addComponent(this.jTextField9, -2, 264, -2)
/*  886 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  887 */               .addComponent(this.jButton6))
/*  888 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  889 */               .addComponent(this.jTextField10, -2, 264, -2)
/*  890 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  891 */               .addComponent(this.jButton5)))
/*  892 */           .addContainerGap(-1, 32767)));
/*      */     
/*  894 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  895 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  896 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  897 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  898 */             .addComponent(this.jLabel20)
/*  899 */             .addComponent(this.jTextField10, -2, -1, -2)
/*  900 */             .addComponent(this.jButton5))
/*  901 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  902 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  903 */             .addComponent(this.jLabel21)
/*  904 */             .addComponent(this.jTextField9, -2, -1, -2)
/*  905 */             .addComponent(this.jButton6))
/*  906 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  909 */     this.jLabel27.setFont(new Font("Tahoma", 2, 11));
/*  910 */     this.jLabel27.setText("Archivo de mensajes 1");
/*      */     
/*  912 */     this.jTextField11.setEditable(false);
/*      */     
/*  914 */     this.jButton11.setText("Buscar");
/*  915 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  917 */             Configuracion.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  921 */     this.jButton12.setText("Buscar");
/*  922 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  924 */             Configuracion.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  928 */     this.jLabel28.setFont(new Font("Tahoma", 2, 11));
/*  929 */     this.jLabel28.setText("Archivo de mensajes 2");
/*      */     
/*  931 */     this.jTextField12.setEditable(false);
/*      */     
/*  933 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  934 */     this.jPanel2.setLayout(jPanel2Layout);
/*  935 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  936 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  937 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  938 */           .addContainerGap()
/*  939 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  940 */             .addComponent(this.jPanel3, -1, -1, 32767)
/*  941 */             .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  942 */             .addGroup(jPanel2Layout.createSequentialGroup()
/*  943 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  944 */                 .addGroup(jPanel2Layout.createSequentialGroup()
/*  945 */                   .addComponent(this.jLabel14, -2, 107, -2)
/*  946 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  947 */                   .addComponent(this.jTextField5, -2, 264, -2)
/*  948 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  949 */                   .addComponent(this.jButton3))
/*  950 */                 .addGroup(jPanel2Layout.createSequentialGroup()
/*  951 */                   .addComponent(this.jLabel15, -2, 107, -2)
/*  952 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  953 */                   .addComponent(this.jTextField6, -2, 264, -2)
/*  954 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  955 */                   .addComponent(this.jButton4)))
/*  956 */               .addGap(0, 0, 32767))
/*  957 */             .addGroup(jPanel2Layout.createSequentialGroup()
/*  958 */               .addComponent(this.jLabel27, -2, 113, -2)
/*  959 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  960 */               .addComponent(this.jTextField11, -2, 185, -2)
/*  961 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  962 */               .addComponent(this.jButton11)
/*  963 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  964 */               .addComponent(this.jLabel28, -2, 113, -2)
/*  965 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  966 */               .addComponent(this.jTextField12, -2, 185, -2)
/*  967 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  968 */               .addComponent(this.jButton12)))
/*  969 */           .addContainerGap()));
/*      */     
/*  971 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  974 */           .addContainerGap()
/*  975 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  976 */             .addComponent(this.jLabel14)
/*  977 */             .addComponent(this.jTextField5, -2, -1, -2)
/*  978 */             .addComponent(this.jButton3))
/*  979 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  980 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  981 */             .addComponent(this.jLabel15)
/*  982 */             .addComponent(this.jTextField6, -2, -1, -2)
/*  983 */             .addComponent(this.jButton4))
/*  984 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  985 */           .addComponent(this.jPanel9, -2, -1, -2)
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  988 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  989 */               .addComponent(this.jLabel28)
/*  990 */               .addComponent(this.jTextField12, -2, -1, -2)
/*  991 */               .addComponent(this.jButton12))
/*  992 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  993 */               .addComponent(this.jLabel27)
/*  994 */               .addComponent(this.jTextField11, -2, -1, -2)
/*  995 */               .addComponent(this.jButton11)))
/*  996 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  997 */           .addComponent(this.jPanel3, -2, -1, -2)
/*  998 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1001 */     this.jTabbedPane1.addTab("Otras Configuraciones", this.jPanel2);
/*      */     
/* 1003 */     this.jPanel4.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1005 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Sucursal" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1013 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1018 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1021 */     this.rSTableMetro1.setAltoHead(25);
/* 1022 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1023 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 1024 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1025 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1026 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1027 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1028 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1029 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1030 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1031 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1032 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1033 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1034 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1035 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1036 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1038 */             Configuracion.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1041 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1043 */             Configuracion.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1046 */     this.jScrollPane38.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1048 */     this.jLabel16.setText("Sucursal: ");
/*      */     
/* 1050 */     this.jTextField14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1052 */             Configuracion.this.jTextField14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1056 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 1057 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 1058 */     this.materialButton1.setMnemonic('G');
/* 1059 */     this.materialButton1.setText("Guardar");
/* 1060 */     this.materialButton1.setToolTipText("Guardar (Alt + G)");
/* 1061 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 1062 */     this.materialButton1.setHorizontalTextPosition(0);
/* 1063 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1065 */             Configuracion.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1069 */     this.materialButton2.setBackground(this.lc.PRIMARIO1);
/* 1070 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/* 1071 */     this.materialButton2.setMnemonic('M');
/* 1072 */     this.materialButton2.setText("Modificar");
/* 1073 */     this.materialButton2.setToolTipText("Modificar (Alt + M)");
/* 1074 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/* 1075 */     this.materialButton2.setHorizontalTextPosition(0);
/* 1076 */     this.materialButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1078 */             Configuracion.this.materialButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1082 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1083 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1084 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1086 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1087 */           .addContainerGap()
/* 1088 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1089 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1090 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1091 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1092 */                   .addComponent(this.jLabel16, -2, 80, -2)
/* 1093 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1094 */                   .addComponent(this.jTextField14))
/* 1095 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1096 */                   .addGap(0, 194, 32767)
/* 1097 */                   .addComponent((Component)this.materialButton1, -2, 150, -2)))
/* 1098 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1099 */               .addComponent(this.jScrollPane38, -2, 483, -2))
/* 1100 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1101 */               .addGap(0, 0, 32767)
/* 1102 */               .addComponent((Component)this.materialButton2, -2, 150, -2)))));
/*      */     
/* 1104 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1106 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1107 */           .addGap(11, 11, 11)
/* 1108 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1109 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1110 */               .addComponent(this.jScrollPane38, -2, 0, 32767)
/* 1111 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1112 */               .addComponent((Component)this.materialButton2, -2, 38, -2))
/* 1113 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1114 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1115 */                 .addComponent(this.jLabel16)
/* 1116 */                 .addComponent(this.jTextField14, -2, -1, -2))
/* 1117 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1118 */               .addComponent((Component)this.materialButton1, -2, 38, -2)
/* 1119 */               .addGap(0, 241, 32767)))
/* 1120 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1123 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1124 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1125 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1126 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1127 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */     
/* 1129 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1130 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1131 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */ 
/*      */     
/* 1134 */     this.jTabbedPane1.addTab("Sucursales", this.jPanel4);
/*      */     
/* 1136 */     this.jLabel30.setFont(new Font("Tahoma", 2, 11));
/* 1137 */     this.jLabel30.setText("Tarjetas de Circulación");
/*      */     
/* 1139 */     this.jTextField15.setEditable(false);
/*      */     
/* 1141 */     this.jButton13.setText("Buscar");
/* 1142 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1144 */             Configuracion.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1148 */     this.jLabel31.setFont(new Font("Tahoma", 2, 11));
/* 1149 */     this.jLabel31.setText("Pólizas de Seguro");
/*      */     
/* 1151 */     this.jTextField16.setEditable(false);
/*      */     
/* 1153 */     this.jButton14.setText("Buscar");
/* 1154 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1156 */             Configuracion.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1160 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/* 1161 */     this.jLabel32.setText("Sedema");
/*      */     
/* 1163 */     this.jTextField17.setEditable(false);
/*      */     
/* 1165 */     this.jButton15.setText("Buscar");
/* 1166 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1168 */             Configuracion.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1172 */     this.jLabel33.setFont(new Font("Tahoma", 2, 11));
/* 1173 */     this.jLabel33.setText("Nom 012");
/*      */     
/* 1175 */     this.jTextField18.setEditable(false);
/*      */     
/* 1177 */     this.jButton16.setText("Buscar");
/* 1178 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1180 */             Configuracion.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1184 */     this.jLabel34.setFont(new Font("Tahoma", 2, 11));
/* 1185 */     this.jLabel34.setText("Verificación");
/*      */     
/* 1187 */     this.jTextField19.setEditable(false);
/*      */     
/* 1189 */     this.jButton17.setText("Buscar");
/* 1190 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1192 */             Configuracion.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1196 */     this.jLabel35.setFont(new Font("Tahoma", 2, 11));
/* 1197 */     this.jLabel35.setText("Fisicomecanica");
/*      */     
/* 1199 */     this.jTextField20.setEditable(false);
/*      */     
/* 1201 */     this.jButton18.setText("Buscar");
/* 1202 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1204 */             Configuracion.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1208 */     this.jLabel36.setFont(new Font("Tahoma", 2, 11));
/* 1209 */     this.jLabel36.setText("SCT");
/*      */     
/* 1211 */     this.jTextField21.setEditable(false);
/*      */     
/* 1213 */     this.jButton19.setText("Buscar");
/* 1214 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1216 */             Configuracion.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1220 */     this.jLabel37.setFont(new Font("Tahoma", 2, 11));
/* 1221 */     this.jLabel37.setText("Otros");
/*      */     
/* 1223 */     this.jTextField22.setEditable(false);
/*      */     
/* 1225 */     this.jButton20.setText("Buscar");
/* 1226 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1228 */             Configuracion.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1232 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/* 1233 */     this.jLabel38.setText("Días de anticipación de aviso");
/*      */     
/* 1235 */     this.jSpinner3.setModel(new SpinnerNumberModel(1, 1, 100, 1));
/*      */     
/* 1237 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 1238 */     this.jLabel39.setText("Inspección");
/*      */     
/* 1240 */     this.jTextField23.setEditable(false);
/*      */     
/* 1242 */     this.jButton21.setText("Buscar");
/* 1243 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1245 */             Configuracion.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1249 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 1250 */     this.jLabel40.setText("Pagos");
/*      */     
/* 1252 */     this.jTextField24.setEditable(false);
/*      */     
/* 1254 */     this.jButton22.setText("Buscar");
/* 1255 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1257 */             Configuracion.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1261 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1262 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1263 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1265 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1266 */           .addContainerGap()
/* 1267 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1268 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1269 */               .addComponent(this.jLabel30, -2, 184, -2)
/* 1270 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1271 */               .addComponent(this.jTextField15, -2, 264, -2)
/* 1272 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1273 */               .addComponent(this.jButton13))
/* 1274 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1275 */               .addComponent(this.jLabel31, -2, 184, -2)
/* 1276 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1277 */               .addComponent(this.jTextField16, -2, 264, -2)
/* 1278 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1279 */               .addComponent(this.jButton14))
/* 1280 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1281 */               .addComponent(this.jLabel32, -2, 184, -2)
/* 1282 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1283 */               .addComponent(this.jTextField17, -2, 264, -2)
/* 1284 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1285 */               .addComponent(this.jButton15))
/* 1286 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1287 */               .addComponent(this.jLabel33, -2, 184, -2)
/* 1288 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1289 */               .addComponent(this.jTextField18, -2, 264, -2)
/* 1290 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1291 */               .addComponent(this.jButton16))
/* 1292 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1293 */               .addComponent(this.jLabel34, -2, 184, -2)
/* 1294 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1295 */               .addComponent(this.jTextField19, -2, 264, -2)
/* 1296 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1297 */               .addComponent(this.jButton17))
/* 1298 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1299 */               .addComponent(this.jLabel35, -2, 184, -2)
/* 1300 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1301 */               .addComponent(this.jTextField20, -2, 264, -2)
/* 1302 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1303 */               .addComponent(this.jButton18))
/* 1304 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1305 */               .addComponent(this.jLabel36, -2, 184, -2)
/* 1306 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1307 */               .addComponent(this.jTextField21, -2, 264, -2)
/* 1308 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1309 */               .addComponent(this.jButton19))
/* 1310 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1311 */               .addComponent(this.jLabel37, -2, 184, -2)
/* 1312 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1313 */               .addComponent(this.jTextField22, -2, 264, -2)
/* 1314 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1315 */               .addComponent(this.jButton20))
/* 1316 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1317 */               .addComponent(this.jLabel39, -2, 184, -2)
/* 1318 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1319 */               .addComponent(this.jTextField23, -2, 264, -2)
/* 1320 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1321 */               .addComponent(this.jButton21))
/* 1322 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1323 */               .addComponent(this.jLabel40, -2, 184, -2)
/* 1324 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1325 */               .addComponent(this.jTextField24, -2, 264, -2)
/* 1326 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1327 */               .addComponent(this.jButton22))
/* 1328 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1329 */               .addComponent(this.jLabel38, -2, 184, -2)
/* 1330 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1331 */               .addComponent(this.jSpinner3)))
/* 1332 */           .addContainerGap(307, 32767)));
/*      */     
/* 1334 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1336 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1337 */           .addContainerGap()
/* 1338 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1339 */             .addComponent(this.jLabel30)
/* 1340 */             .addComponent(this.jTextField15, -2, -1, -2)
/* 1341 */             .addComponent(this.jButton13))
/* 1342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1343 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1344 */             .addComponent(this.jLabel31)
/* 1345 */             .addComponent(this.jTextField16, -2, -1, -2)
/* 1346 */             .addComponent(this.jButton14))
/* 1347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1348 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1349 */             .addComponent(this.jLabel32)
/* 1350 */             .addComponent(this.jTextField17, -2, -1, -2)
/* 1351 */             .addComponent(this.jButton15))
/* 1352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1353 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1354 */             .addComponent(this.jLabel33)
/* 1355 */             .addComponent(this.jTextField18, -2, -1, -2)
/* 1356 */             .addComponent(this.jButton16))
/* 1357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1358 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1359 */             .addComponent(this.jLabel34)
/* 1360 */             .addComponent(this.jTextField19, -2, -1, -2)
/* 1361 */             .addComponent(this.jButton17))
/* 1362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1363 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1364 */             .addComponent(this.jLabel35)
/* 1365 */             .addComponent(this.jTextField20, -2, -1, -2)
/* 1366 */             .addComponent(this.jButton18))
/* 1367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1368 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1369 */             .addComponent(this.jLabel36)
/* 1370 */             .addComponent(this.jTextField21, -2, -1, -2)
/* 1371 */             .addComponent(this.jButton19))
/* 1372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1373 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1374 */             .addComponent(this.jLabel39)
/* 1375 */             .addComponent(this.jTextField23, -2, -1, -2)
/* 1376 */             .addComponent(this.jButton21))
/* 1377 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1378 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1379 */             .addComponent(this.jLabel37)
/* 1380 */             .addComponent(this.jTextField22, -2, -1, -2)
/* 1381 */             .addComponent(this.jButton20))
/* 1382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1383 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1384 */             .addComponent(this.jLabel40)
/* 1385 */             .addComponent(this.jTextField24, -2, -1, -2)
/* 1386 */             .addComponent(this.jButton22))
/* 1387 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1388 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1389 */             .addComponent(this.jSpinner3, -2, -1, -2)
/* 1390 */             .addComponent(this.jLabel38))
/* 1391 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1394 */     this.jTabbedPane1.addTab("Carpetas", this.jPanel12);
/*      */     
/* 1396 */     this.jButton1.setMnemonic('G');
/* 1397 */     this.jButton1.setText("Guardar");
/* 1398 */     this.jButton1.setToolTipText("Guardar (Alt+G)");
/* 1399 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1401 */             Configuracion.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1405 */     this.jButton2.setMnemonic('A');
/* 1406 */     this.jButton2.setText("Actualizar");
/* 1407 */     this.jButton2.setToolTipText("Actualizar (Alt+A)");
/* 1408 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1410 */             Configuracion.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1414 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1415 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1416 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1418 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1419 */           .addContainerGap()
/* 1420 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1421 */             .addComponent(this.jSeparator1)
/* 1422 */             .addComponent(this.jLabel3, -1, -1, 32767)
/* 1423 */             .addComponent(this.jTabbedPane1, -2, 845, 32767))
/* 1424 */           .addContainerGap())
/* 1425 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1426 */           .addContainerGap(-1, 32767)
/* 1427 */           .addComponent(this.jButton1, -2, 105, -2)
/* 1428 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1429 */           .addComponent(this.jButton2, -2, 108, -2)
/* 1430 */           .addGap(300, 300, 300)));
/*      */     
/* 1432 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1433 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1434 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1435 */           .addComponent(this.jLabel3)
/* 1436 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1437 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1438 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1439 */           .addComponent(this.jTabbedPane1, -1, 360, 32767)
/* 1440 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1441 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1442 */             .addComponent(this.jButton2)
/* 1443 */             .addComponent(this.jButton1))
/* 1444 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1447 */     GroupLayout layout = new GroupLayout(this);
/* 1448 */     setLayout(layout);
/* 1449 */     layout.setHorizontalGroup(layout
/* 1450 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1451 */         .addGap(0, 931, 32767)
/* 1452 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1453 */           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 1454 */             .addContainerGap(35, 32767)
/* 1455 */             .addComponent(this.jPanel6, -2, -1, -2)
/* 1456 */             .addContainerGap(35, 32767))));
/*      */     
/* 1458 */     layout.setVerticalGroup(layout
/* 1459 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1460 */         .addGap(0, 447, 32767)
/* 1461 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1462 */           .addGroup(layout.createSequentialGroup()
/* 1463 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1464 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1469 */     String direc = "";
/* 1470 */     if (this.jTextField1.getText().equals("")) {
/* 1471 */       this.error.cargarError(this.jTextField1, "050");
/* 1472 */     } else if (this.jTextField2.getText().equals("")) {
/* 1473 */       this.error.cargarError(this.jTextField2, "050");
/* 1474 */     } else if (this.jTextField3.getText().equals("")) {
/* 1475 */       this.error.cargarError(this.jTextField3, "050");
/* 1476 */     } else if (this.jTextField13.getText().equals("")) {
/* 1477 */       this.error.cargarError(this.jTextField13, "050");
/* 1478 */     } else if (this.jFormattedTextField2.getText().equals("$0.00")) {
/* 1479 */       this.error.cargarError(this.jFormattedTextField2, "050");
/* 1480 */     } else if (!this.val.validarSoloNum(this.jTextField2, this.jTextField2.getText())) {
/* 1481 */       if (this.jTextField1.getText().length() > 4) {
/* 1482 */         JOptionPane.showMessageDialog(this.padre, "Las directivas son las letras anteriores al número de folio es recomendable que sean menos de cuatro letras", "Directiva Larga", 0, this.ADVER);
/*      */       }
/* 1484 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas guardar las nuevas configuraciones del SICRET?", "Guardar Configuraciones", 0, 3, this.PREG);
/* 1485 */       if (res == 0) {
/* 1486 */         String linea = "/";
/* 1487 */         if (this.jCheckBox1.isSelected()) {
/* 1488 */           linea = linea + "Guias/";
/*      */         }
/* 1490 */         if (this.jCheckBox2.isSelected()) {
/* 1491 */           linea = linea + "Operadores/";
/*      */         }
/* 1493 */         if (this.jCheckBox4.isSelected()) {
/* 1494 */           linea = linea + "Empleados/";
/*      */         }
/* 1496 */         if (this.jCheckBox5.isSelected()) {
/* 1497 */           linea = linea + "Clientes/";
/*      */         }
/* 1499 */         if (this.jCheckBox6.isSelected()) {
/* 1500 */           linea = linea + "Destinos/";
/*      */         }
/* 1502 */         if (this.jCheckBox3.isSelected()) {
/* 1503 */           linea = linea + "Perforacion/";
/*      */         }
/* 1505 */         if (this.jCheckBox7.isSelected()) {
/* 1506 */           linea = linea + "Facturacion/";
/*      */         }
/* 1508 */         if (this.jCheckBox8.isSelected()) {
/* 1509 */           linea = linea + "Liquidaciones/";
/*      */         }
/* 1511 */         if (this.jCheckBox9.isSelected()) {
/* 1512 */           linea = linea + "Venc Licencias/";
/*      */         }
/* 1514 */         if (this.jCheckBox10.isSelected()) {
/* 1515 */           linea = linea + "RH/";
/*      */         }
/* 1517 */         if (this.jCheckBox11.isSelected()) {
/* 1518 */           linea = linea + "Reseteos/";
/*      */         }
/* 1520 */         if (this.jCheckBox12.isSelected()) {
/* 1521 */           linea = linea + "Cuentasporpagar/";
/*      */         }
/*      */         
/* 1524 */         this.con.variables[5] = linea;
/* 1525 */         this.con.guardarConf();
/*      */         
/* 1527 */         this.con.inserSinMsj("update configuraciones set diasAvisos= " + String.valueOf(this.jSpinner3.getValue()) + ", diasRepPendientes = " + String.valueOf(this.jSpinner1.getValue()) + ", contraloria='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "', sucursal='" + this.jTextField8.getText().toUpperCase() + "', fotosOperadores='" + this.jTextField5.getText() + "',fotosEmpleados='" + this.jTextField6.getText() + "',directiva = '" + this.jTextField1.getText().toUpperCase() + "', iva = " + this.jTextField2.getText() + ",retencion=" + this.jTextField3.getText() + ", gastosletra = '" + this.jFormattedTextField1.getText() + "', gastos = " + String.valueOf(this.jFormattedTextField1.getValue()) + ",dieselLetra = '" + this.jFormattedTextField2.getText() + "', diesel = " + String.valueOf(this.jFormattedTextField2.getValue()) + ", dia_info = " + this.jComboBox2.getSelectedIndex() + ", renta = " + String.valueOf(this.jFormattedTextField3.getValue()) + ", rentaLetra = '" + this.jFormattedTextField3.getText() + "', semarnat = '" + this.jTextField4.getText().toUpperCase() + "', capacitadorQHSE='" + this.jTextField7.getText().toUpperCase() + "', nombreCapacitador ='" + this.jTextField13.getText().toUpperCase() + "'");
/* 1528 */         this.jTextField1.setText("");
/* 1529 */         this.jTextField2.setText("");
/* 1530 */         this.jTextField3.setText("");
/* 1531 */         this.jTextField4.setText("");
/* 1532 */         this.jTextField5.setText("");
/* 1533 */         this.jTextField6.setText("");
/* 1534 */         this.jTextField7.setText("");
/* 1535 */         this.jTextField8.setText("");
/* 1536 */         this.jTextField13.setText("");
/* 1537 */         this.jFormattedTextField1.setValue(Double.valueOf(0.0D));
/* 1538 */         this.jFormattedTextField2.setValue(Double.valueOf(0.0D));
/* 1539 */         this.jFormattedTextField3.setValue(Double.valueOf(0.0D));
/* 1540 */         this.jComboBox2.setSelectedIndex(0);
/* 1541 */         this.jSpinner1.setValue(Integer.valueOf(0));
/* 1542 */         this.jSpinner1.setValue(Integer.valueOf(3));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1548 */     cargarConfig();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1552 */     String dir = direccion();
/* 1553 */     if (!dir.equals("no")) {
/* 1554 */       this.FOTO = dir;
/* 1555 */       dir = "";
/* 1556 */       for (int i = 0; i < this.FOTO.length(); i++) {
/* 1557 */         if (this.FOTO.charAt(i) == '\\') {
/* 1558 */           dir = dir + "/";
/*      */         } else {
/* 1560 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1563 */       this.FOTO = dir;
/* 1564 */       this.con.insertar("update configuraciones set fotosEmpleados = '" + this.FOTO + "'");
/* 1565 */       this.jTextField6.setText(this.FOTO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1570 */     String dir = direccion();
/* 1571 */     if (!dir.equals("no")) {
/* 1572 */       this.FOTO = dir;
/* 1573 */       dir = "";
/* 1574 */       for (int i = 0; i < this.FOTO.length(); i++) {
/* 1575 */         if (this.FOTO.charAt(i) == '\\') {
/* 1576 */           dir = dir + "/";
/*      */         } else {
/* 1578 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1581 */       this.FOTO = dir;
/* 1582 */       this.con.insertar("update configuraciones set fotosOperadores = '" + this.FOTO + "'");
/* 1583 */       this.jTextField5.setText(this.FOTO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1588 */     String dir = direccion();
/* 1589 */     if (!dir.equals("no")) {
/* 1590 */       this.FOTO = dir;
/* 1591 */       dir = "";
/* 1592 */       for (int i = 0; i < this.FOTO.length(); i++) {
/* 1593 */         if (this.FOTO.charAt(i) == '\\') {
/* 1594 */           dir = dir + "/";
/*      */         } else {
/* 1596 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1599 */       this.FOTO = dir;
/* 1600 */       this.con.insertar("update configuraciones set aceite = '" + this.FOTO + "'");
/* 1601 */       this.jTextField10.setText(this.FOTO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1606 */     String dir = direccion();
/* 1607 */     if (!dir.equals("no")) {
/* 1608 */       this.FOTO = dir;
/* 1609 */       dir = "";
/* 1610 */       for (int i = 0; i < this.FOTO.length(); i++) {
/* 1611 */         if (this.FOTO.charAt(i) == '\\') {
/* 1612 */           dir = dir + "/";
/*      */         } else {
/* 1614 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1617 */       this.FOTO = dir;
/* 1618 */       this.con.insertar("update configuraciones set agua = '" + this.FOTO + "'");
/* 1619 */       this.jTextField9.setText(this.FOTO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1624 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1628 */     this.jButton8.setText("Guardar");
/* 1629 */     this.jComboBox9.setSelectedIndex(0);
/* 1630 */     this.jSpinner2.setValue(Integer.valueOf(1));
/* 1631 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1635 */     if (this.jButton8.getText().equals("Guardar")) {
/* 1636 */       agregarPeriodos();
/*      */     } else {
/* 1638 */       String cliente = String.valueOf(this.jComboBox9.getSelectedItem());
/* 1639 */       this.encontrado = this.con.consultar("cliente", "facturasvencidas", "where cliente ='" + cliente + "' and num<>" + this.CLAVEPERIODO);
/* 1640 */       if (this.encontrado) {
/* 1641 */         this.jComboBox9.setBackground(Color.RED);
/* 1642 */         JOptionPane.showMessageDialog(this.jDialog1, "El cliente que seleccionaste ya tiene datos asignados", "Cliente ya agregado", 0, this.ERROR);
/*      */       } else {
/* 1644 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar los datos?", "Modificar datos", 0, 3, this.PREG);
/* 1645 */         if (res == 0) {
/* 1646 */           this.con.inserSinMsj("update facturasvencidas set cliente = '" + cliente + "', dias = " + String.valueOf(this.jSpinner2.getValue()) + " where num = '" + this.CLAVEPERIODO + "'");
/* 1647 */           this.jButton8.setText("Agregar");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1655 */     int indice = this.jTable1.getSelectedRow();
/* 1656 */     if (indice < 0) {
/* 1657 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 1659 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "Estás seguro que deseas eliminar los datos que seleccionaste?", "Eliminar datos", 0, 3, this.ELIMINAR);
/* 1660 */       if (res == 0) {
/* 1661 */         this.con.eliminar2("conceptosfact", "where num=" + String.valueOf(this.jTable1.getValueAt(indice, 0)));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1668 */     int indice = this.jTable1.getSelectedRow();
/* 1669 */     if (indice < 0) {
/* 1670 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un periodo para poder modificarlo", "Selecciona un periodo", 0, this.ADVER);
/*      */     } else {
/* 1672 */       this.jButton8.setText("Cambiar");
/* 1673 */       String[] datos = this.con.regresaReg("num,cliente,dias", "facturasvencidas", "where num=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 3);
/* 1674 */       this.jComboBox9.setSelectedItem(datos[1]);
/* 1675 */       this.jSpinner2.setValue(Integer.valueOf(Integer.parseInt(datos[2])));
/* 1676 */       this.CLAVEPERIODO = datos[0];
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1681 */     String rutaMensajes = "";
/* 1682 */     String dir = direccion();
/* 1683 */     if (!dir.equals("no")) {
/* 1684 */       rutaMensajes = dir;
/* 1685 */       dir = "";
/* 1686 */       for (int i = 0; i < rutaMensajes.length(); i++) {
/* 1687 */         if (rutaMensajes.charAt(i) == '\\') {
/* 1688 */           dir = dir + "/";
/*      */         } else {
/* 1690 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1693 */       rutaMensajes = dir;
/* 1694 */       this.con.insertar("update configuraciones set rutaAvisos = '" + rutaMensajes + "/mensajes.msj'");
/* 1695 */       this.jTextField11.setText(dir);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1700 */     String rutaMensajes = "";
/* 1701 */     String dir = direccion();
/* 1702 */     if (!dir.equals("no")) {
/* 1703 */       rutaMensajes = dir;
/* 1704 */       dir = "";
/* 1705 */       for (int i = 0; i < rutaMensajes.length(); i++) {
/* 1706 */         if (rutaMensajes.charAt(i) == '\\') {
/* 1707 */           dir = dir + "/";
/*      */         } else {
/* 1709 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1712 */       rutaMensajes = dir;
/* 1713 */       this.con.insertar("update configuraciones set rutaAvisos2 = '" + rutaMensajes + "/mensajes.msj'");
/* 1714 */       this.jTextField12.setText(dir);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 1727 */     nuevaSucursal();
/*      */   }
/*      */   
/*      */   private void materialButton2ActionPerformed(ActionEvent evt) {
/* 1731 */     if (this.materialButton2.getText().equals("Modificar")) {
/* 1732 */       int ind = this.rSTableMetro1.getSelectedRow();
/* 1733 */       if (ind < 0) {
/* 1734 */         JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una sucursal para poder modificarla", "Selecciona una sucursal", 0, this.ERROR);
/*      */       } else {
/* 1736 */         this.materialButton1.setText("Modificar");
/* 1737 */         this.materialButton1.setMnemonic('M');
/* 1738 */         this.materialButton1.setToolTipText("Modificar (Alt + M)");
/*      */         
/* 1740 */         this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/* 1741 */         this.materialButton2.setText("Cancelar");
/* 1742 */         this.materialButton2.setMnemonic('C');
/* 1743 */         this.materialButton2.setToolTipText("Cancelar (Alt + C)");
/*      */         
/* 1745 */         this.claveSuc = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 1746 */         this.jTextField14.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/*      */       } 
/*      */     } else {
/* 1749 */       this.materialButton2.setBackground(this.lc.PRIMARIO1);
/* 1750 */       this.materialButton2.setText("Modificar");
/* 1751 */       this.materialButton2.setMnemonic('M');
/* 1752 */       this.materialButton2.setToolTipText("Modificar (Alt + M)");
/*      */       
/* 1754 */       this.materialButton1.setText("Guardar");
/* 1755 */       this.materialButton1.setMnemonic('G');
/* 1756 */       this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*      */       
/* 1758 */       this.jTextField14.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTabbedPane1MouseClicked(MouseEvent evt) {
/* 1763 */     if (this.jTabbedPane1.getSelectedIndex() == 2 && this.entraSuc == true) {
/* 1764 */       consultarSuc();
/* 1765 */       this.entraSuc = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField14ActionPerformed(ActionEvent evt) {
/* 1770 */     nuevaSucursal();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 1774 */     agregarCarpeta("TC", this.jTextField15);
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 1778 */     agregarCarpeta("POLIZA", this.jTextField16);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 1782 */     agregarCarpeta("SEDEMA", this.jTextField17);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 1786 */     agregarCarpeta("NOM012", this.jTextField18);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 1790 */     agregarCarpeta("VERIFICACION", this.jTextField19);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 1794 */     agregarCarpeta("FISICOMECANICA", this.jTextField20);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 1798 */     agregarCarpeta("SCT", this.jTextField21);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 1802 */     agregarCarpeta("OTRO", this.jTextField22);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 1806 */     agregarCarpeta("INSPECCION", this.jTextField23);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 1810 */     agregarCarpeta("PAGOS", this.jTextField24);
/*      */   }
/*      */   
/*      */   public void nuevaSucursal() {
/* 1814 */     if (!this.val.validarTexto(this.jTextField14, this.jTextField14.getText(), "020")) {
/* 1815 */       if (this.materialButton1.getText().equals("Guardar")) {
/* 1816 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas agregar una nueva sucursal?", "Agregar Sucursal", 0, 3, this.PREG);
/* 1817 */         if (res == 0 && 
/* 1818 */           !this.val.validarTexto(this.jTextField14, this.jTextField14.getText(), "020")) {
/* 1819 */           this.con2.insertar("insert into prov_sucursales(sucursal) values ('" + this.jTextField14.getText().toUpperCase() + "')");
/* 1820 */           this.jTextField14.setText("");
/* 1821 */           consultarSuc();
/*      */         } 
/*      */       } else {
/*      */         
/* 1825 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas modificar la sucursal?", "Modificar Sucursal", 0, 3, this.PREG);
/* 1826 */         if (res == 0) {
/* 1827 */           this.con2.insertar("update prov_sucursales set sucursal='" + this.jTextField14.getText().toUpperCase() + "' where numSuc = " + this.claveSuc);
/* 1828 */           this.jTextField14.setText("");
/* 1829 */           consultarSuc();
/*      */           
/* 1831 */           this.materialButton2.setBackground(this.lc.PRIMARIO1);
/* 1832 */           this.materialButton2.setText("Modificar");
/* 1833 */           this.materialButton2.setMnemonic('M');
/* 1834 */           this.materialButton2.setToolTipText("Modificar (Alt + M)");
/*      */           
/* 1836 */           this.materialButton1.setText("Guardar");
/* 1837 */           this.materialButton1.setMnemonic('G');
/* 1838 */           this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void agregarCarpeta(String campo, JTextField texto) {
/* 1845 */     String dir = direccion();
/* 1846 */     String ruta = "";
/* 1847 */     if (!dir.equals("no")) {
/* 1848 */       ruta = dir;
/* 1849 */       dir = "";
/* 1850 */       for (int i = 0; i < ruta.length(); i++) {
/* 1851 */         if (ruta.charAt(i) == '\\') {
/* 1852 */           dir = dir + "/";
/*      */         } else {
/* 1854 */           dir = dir + dir;
/*      */         } 
/*      */       } 
/* 1857 */       ruta = dir;
/* 1858 */       this.con.inserSinMsj("insert into unidadescarpetas (tipo, direccion) values('" + campo + "', '" + ruta + "')");
/* 1859 */       texto.setText(ruta);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarSuc() {
/* 1864 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con2
/* 1865 */           .buscarDatos(2, "numSuc,sucursal", "prov_sucursales", "order by sucursal"), (Object[])new String[] { "Núm", "Descripción" })
/*      */         {
/*      */           
/* 1868 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1873 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1877 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 1878 */     this.jScrollPane38.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 1880 */     this.rSTableMetro1.setSelectionMode(0);
/* 1881 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 1882 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1884 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 1885 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     
/* 1887 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 1888 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 1889 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void agregarPeriodos() {
/* 1893 */     String cliente = String.valueOf(this.jComboBox9.getSelectedItem());
/* 1894 */     this.encontrado = this.con.consultar("cliente", "facturasvencidas", "where cliente ='" + cliente + "'");
/* 1895 */     if (this.encontrado) {
/* 1896 */       this.jComboBox9.setBackground(Color.RED);
/* 1897 */       JOptionPane.showMessageDialog(this.jDialog1, "El cliente que seleccionaste ya tiene datos asignados", "Cliente ya agregado", 0, this.ERROR);
/*      */     } else {
/* 1899 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas agregar una nuevo periodo de crédito?", "Guardar periodo de crédito", 0, 3, this.PREG);
/* 1900 */       if (res == 0) {
/* 1901 */         this.con.insertar("insert into facturasvencidas(cliente,dias) values('" + cliente + "'," + String.valueOf(this.jSpinner2.getValue()) + ")");
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public String direccion() {
/* 1907 */     JFileChooser fileChooser = new JFileChooser();
/* 1908 */     fileChooser.setFileSelectionMode(1);
/* 1909 */     String fileName = "";
/* 1910 */     int retVal = fileChooser.showSaveDialog(null);
/* 1911 */     if (retVal == 0) {
/* 1912 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 1913 */       return fileName;
/*      */     } 
/* 1915 */     return "no";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cargarConfig() {
/* 1923 */     String[] reg = { this.CAMPOSGENERALES.get("directiva"), this.CAMPOSGENERALES.get("iva"), this.CAMPOSGENERALES.get("gastos"), this.CAMPOSGENERALES.get("diesel"), this.CAMPOSGENERALES.get("dia_info"), this.CAMPOSGENERALES.get("renta"), this.CAMPOSGENERALES.get("retencion"), this.CAMPOSGENERALES.get("semarnat"), this.CAMPOSGENERALES.get("fotosoperadores"), this.CAMPOSGENERALES.get("fotosempleados"), this.CAMPOSGENERALES.get("capacitadorQHSE"), this.CAMPOSGENERALES.get("sucursal"), this.CAMPOSGENERALES.get("contraloria"), this.CAMPOSGENERALES.get("diasRepPendientes"), this.CAMPOSGENERALES.get("aceite"), this.CAMPOSGENERALES.get("agua"), this.CAMPOSGENERALES.get("rutaAvisos"), this.CAMPOSGENERALES.get("rutaAvisos2"), this.CAMPOSGENERALES.get("nombreCapacitador") };
/* 1924 */     this.jSpinner3.setValue(Integer.valueOf(Integer.parseInt(this.CAMPOSGENERALES.get("diasAvisos"))));
/* 1925 */     this.jTextField1.setText(reg[0]);
/* 1926 */     this.jTextField2.setText(reg[1]);
/* 1927 */     this.jTextField3.setText(reg[6]);
/* 1928 */     this.jTextField4.setText(reg[7]);
/* 1929 */     this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(reg[2])));
/* 1930 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(reg[3])));
/* 1931 */     this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(reg[5])));
/* 1932 */     this.jComboBox2.setSelectedIndex(Integer.parseInt(reg[4]));
/* 1933 */     this.jTextField5.setText(reg[8]);
/* 1934 */     this.jTextField6.setText(reg[9]);
/* 1935 */     this.jTextField7.setText(reg[10]);
/* 1936 */     this.jTextField8.setText(reg[11]);
/* 1937 */     this.jTextField10.setText(reg[14]);
/* 1938 */     this.jTextField9.setText(reg[15]);
/* 1939 */     this.jTextField11.setText(reg[16]);
/* 1940 */     this.jTextField12.setText(reg[17]);
/* 1941 */     this.jTextField13.setText(reg[18]);
/* 1942 */     this.jComboBox3.setSelectedItem(reg[12]);
/*      */     
/* 1944 */     this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(reg[13])));
/* 1945 */     String linea = this.con.variables[5];
/* 1946 */     if (linea.contains("Guias")) {
/* 1947 */       this.jCheckBox1.setSelected(true);
/*      */     } else {
/* 1949 */       this.jCheckBox1.setSelected(false);
/*      */     } 
/* 1951 */     if (linea.contains("Operadores")) {
/* 1952 */       this.jCheckBox2.setSelected(true);
/*      */     } else {
/* 1954 */       this.jCheckBox2.setSelected(false);
/*      */     } 
/* 1956 */     if (linea.contains("Empleados")) {
/* 1957 */       this.jCheckBox4.setSelected(true);
/*      */     } else {
/* 1959 */       this.jCheckBox4.setSelected(false);
/*      */     } 
/* 1961 */     if (linea.contains("Clientes")) {
/* 1962 */       this.jCheckBox5.setSelected(true);
/*      */     } else {
/* 1964 */       this.jCheckBox5.setSelected(false);
/*      */     } 
/* 1966 */     if (linea.contains("Destinos")) {
/* 1967 */       this.jCheckBox6.setSelected(true);
/*      */     } else {
/* 1969 */       this.jCheckBox6.setSelected(false);
/*      */     } 
/* 1971 */     if (linea.contains("Perforacion")) {
/* 1972 */       this.jCheckBox3.setSelected(true);
/*      */     } else {
/* 1974 */       this.jCheckBox3.setSelected(false);
/*      */     } 
/* 1976 */     if (linea.contains("Facturacion")) {
/* 1977 */       this.jCheckBox7.setSelected(true);
/*      */     } else {
/* 1979 */       this.jCheckBox7.setSelected(false);
/*      */     } 
/* 1981 */     if (linea.contains("Liquidaciones")) {
/* 1982 */       this.jCheckBox8.setSelected(true);
/*      */     } else {
/* 1984 */       this.jCheckBox8.setSelected(false);
/*      */     } 
/* 1986 */     if (linea.contains("Venc Licencias")) {
/* 1987 */       this.jCheckBox9.setSelected(true);
/*      */     } else {
/* 1989 */       this.jCheckBox9.setSelected(false);
/*      */     } 
/* 1991 */     if (linea.contains("Reseteos")) {
/* 1992 */       this.jCheckBox11.setSelected(true);
/*      */     } else {
/* 1994 */       this.jCheckBox11.setSelected(false);
/*      */     } 
/* 1996 */     if (linea.contains("RH")) {
/* 1997 */       this.jCheckBox10.setSelected(true);
/*      */     } else {
/* 1999 */       this.jCheckBox10.setSelected(false);
/*      */     } 
/* 2001 */     if (linea.contains("Cuentasporpagar")) {
/* 2002 */       this.jCheckBox12.setSelected(true);
/*      */     } else {
/* 2004 */       this.jCheckBox12.setSelected(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void configuracion(String usu) {
/* 2009 */     this.USUARIO = usu;
/* 2010 */     cargarConfig();
/* 2011 */     privilegios();
/* 2012 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 2016 */     String[] usuarios = this.con.regresaColIndex("nombre_usu", "usuarios", "where contrasena<>'' order by nombre_usu");
/* 2017 */     for (int i = 0; i < usuarios.length; i++) {
/* 2018 */       this.jComboBox3.addItem(usuarios[i]);
/*      */     }
/* 2020 */     String[] datos = this.con.regresaColIndex("distinct(cliente)", "facturas", "order by cliente");
/* 2021 */     for (int j = 0; j < datos.length; j++) {
/* 2022 */       this.jComboBox9.addItem(datos[j]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2027 */     String depa = this.CAMPOSGENERALES.get("priv");
/* 2028 */     if (depa.equals("SUPER USUARIO")) {
/* 2029 */       this.jTabbedPane1.removeAll();
/* 2030 */       this.jTabbedPane1.addTab("General", this.jPanel1);
/* 2031 */       this.jTabbedPane1.addTab("Otras Configuraciones", this.jPanel2);
/* 2032 */       this.jTabbedPane1.addTab("Sucursales", this.jPanel4);
/* 2033 */       this.jTabbedPane1.addTab("Carpetas", this.jPanel12);
/*      */     } else {
/* 2035 */       this.jTabbedPane1.removeAll();
/* 2036 */       this.jTabbedPane1.addTab("Otras Configuraciones", this.jPanel2);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 2077 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2079 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2083 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 2086 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2088 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2092 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 2095 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2097 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2101 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 2104 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2106 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2110 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 2113 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2115 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2119 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 2122 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2124 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2128 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField7, evt);
/*      */           }
/*      */         });
/*      */     
/* 2132 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2134 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2138 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField8, evt);
/*      */           }
/*      */         });
/*      */     
/* 2142 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2144 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2148 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 2152 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2154 */             Configuracion.this.jTextGanado(Configuracion.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2158 */             Configuracion.this.jTextPerdido(Configuracion.this.jTextField13, evt);
/*      */           }
/*      */         });
/*      */     
/* 2162 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2164 */             Configuracion.this.jTextGanado(Configuracion.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2168 */             Configuracion.this.jTextPerdido(Configuracion.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 2171 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2173 */             Configuracion.this.jTextGanado(Configuracion.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2177 */             Configuracion.this.jTextPerdido(Configuracion.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 2180 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2182 */             Configuracion.this.jTextGanado(Configuracion.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2186 */             Configuracion.this.jTextPerdido(Configuracion.this.jComboBox9, evt);
/*      */           }
/*      */         });
/* 2189 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2191 */             Configuracion.this.jTextGanado(Configuracion.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2195 */             Configuracion.this.jTextPerdido(Configuracion.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 2198 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2200 */             Configuracion.this.jTextGanado(Configuracion.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2204 */             Configuracion.this.jTextPerdido(Configuracion.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 2207 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2209 */             Configuracion.this.jTextGanado(Configuracion.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2213 */             Configuracion.this.jTextPerdido(Configuracion.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 2219 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 2223 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 2228 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2231 */       setEnabled((table == null || table.isEnabled()));
/* 2232 */       if (row % 2 == 0) {
/* 2233 */         setBackground(Configuracion.this.lc.FONDOTABLA);
/*      */       }
/*      */       else {
/*      */         
/* 2237 */         setBackground((Color)null);
/*      */       } 
/*      */ 
/*      */       
/* 2241 */       setForeground(Configuracion.this.lc.SECUNDARIO1);
/* 2242 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2243 */       return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Configuracion.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */