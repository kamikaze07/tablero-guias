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
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JRootPane;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import principal.MaterialButton;
/*      */ import utilerias.Tras_codigos;
/*      */ 
/*      */ public class tras_Destinos_Form extends JDialog {
/*      */   private int xx;
/*      */   private int xy;
/*      */   JScrollPane panel;
/*   41 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   42 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   43 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   44 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   45 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   46 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   47 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   48 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   49 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   50 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   51 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   52 */   JFrame padre = null;
/*   53 */   JTabbedPane fichas = null;
/*      */   Map<String, String> CAMPOSGENERALES;
/*   55 */   MensajePop mensajeTry = null;
/*      */   String USUARIO;
/*   57 */   SColores lc = new SColores();
/*   58 */   Fuentes fuentes = new Fuentes();
/*   59 */   PlaceHolder placeHolder = null;
/*   60 */   Consultas2 con2 = new Consultas2();
/*   61 */   Consultas2 con = new Consultas2();
/*   62 */   String TIPO = "";
/*   63 */   String SUCURSAL = "";
/*   64 */   int numSUC = 0;
/*   65 */   String ID = "";
/*   66 */   pintarComponentes pintar = new pintarComponentes();
/*      */   boolean actualizado = false;
/*   68 */   ArrayList LISTACODIGOS = null;
/*   69 */   TextAutoCompleter com_ListaCodigos = null;
/*   70 */   List<Tras_codigos> CODIGOSP = null;
/*   71 */   Map<String, String> CLAVECATALOGO = new TreeMap<>();
/*   72 */   Utilerias utilerias = new Utilerias();
/*   73 */   Map<String, String> Origen = new TreeMap<>();
/*   74 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JButton jButton1; private JButton jButton2; private JButton jButton3; private JButton jButton5; private JButton jButton6; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JDialog jDialog1; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel128; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15;
/*   75 */   NumerosALetras numLetra = null; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel9;
/*      */   
/*      */   public tras_Destinos_Form(String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, String TIPO, boolean actualizado, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP, String ID) {
/*   78 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   79 */     this.mensajeTry = this.mensajeTry;
/*   80 */     this.TIPO = TIPO;
/*   81 */     this.padre = padre;
/*   82 */     this.fichas = this.fichas;
/*   83 */     this.USUARIO = USUARIO;
/*   84 */     this.actualizado = actualizado;
/*   85 */     this.LISTACODIGOS = LISTACODIGOS;
/*   86 */     this.CODIGOSP = CODIGOSP;
/*   87 */     this.con2.setBaseDatos("sicre2PR");
/*      */     try {
/*   89 */       this.formaTel = new MaskFormatter("###-###-####");
/*   90 */     } catch (Exception exception) {}
/*      */     
/*   92 */     initComponents();
/*   93 */     limpiar();
/*   94 */     colorear();
/*   95 */     this.utilerias.formatearAPesos(this.jFormattedTextField4);
/*   96 */     this.utilerias.formatearAPesos(this.jFormattedTextField2);
/*   97 */     this.utilerias.formatearAPesos(this.jFormattedTextField3);
/*   98 */     this.buttonGroup1.add(this.jRadioButton1);
/*   99 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  101 */     this.buttonGroup2.add(this.jRadioButton3);
/*  102 */     this.buttonGroup2.add(this.jRadioButton4);
/*  103 */     if (this.TIPO.equals("NUEVO")) {
/*  104 */       this.jLabel20.setText("Nuevo");
/*  105 */       llenarCodigos();
/*  106 */       this.numSUC = dameSucursal();
/*  107 */       ID = dameID(this.numSUC);
/*  108 */       this.jTextField1.setText(ID);
/*  109 */       this.materialButton1.setVisible(true);
/*  110 */       this.materialButton1.setText("Guardar");
/*  111 */       this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*  112 */     } else if (this.TIPO.equals("VER")) {
/*  113 */       this.ID = ID;
/*  114 */       verDatos();
/*  115 */       desabilitar();
/*  116 */       this.jLabel20.setText("Destino: " + this.jTextField1.getText());
/*  117 */       this.materialButton1.setVisible(false);
/*  118 */     } else if (this.TIPO.equals("MODIFICAR")) {
/*  119 */       llenarCodigos();
/*  120 */       this.ID = ID;
/*  121 */       verDatos();
/*  122 */       this.jTextField4.setEnabled(true);
/*  123 */       this.jTextField5.setEnabled(true);
/*      */       
/*  125 */       this.jLabel20.setText("Modificar: " + this.jTextField1.getText());
/*  126 */       this.materialButton1.setVisible(true);
/*  127 */       this.materialButton1.setText("Modificar");
/*  128 */       this.materialButton1.setToolTipText("Modificar (Alt + M)");
/*      */     } 
/*      */     
/*  131 */     this.utilerias.activarVentanajDialog(this.jDialog1, 320, 325);
/*  132 */     convertirLetra();
/*  133 */     setLocationRelativeTo(null);
/*  134 */     setVisible(true);
/*  135 */     setResizable(true);
/*      */   }
/*      */   private JPanel jPanel1; private JPanel jPanel12; private JPanel jPanel50; private JPanel jPanel57; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JSeparator jSeparator1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7;
/*      */   private JTextField jTextField8;
/*      */   private MaterialButton materialButton1;
/*      */   private MaterialButton materialButton2;
/*      */   
/*      */   private void initComponents() {
/*  143 */     this.jPanel57 = new JPanel();
/*  144 */     this.jPanel8 = new JPanel();
/*  145 */     this.jTextField5 = new JTextField();
/*  146 */     this.jLabel18 = new JLabel();
/*  147 */     this.jComboBox1 = new JComboBox();
/*  148 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  149 */     this.jPanel6 = new JPanel();
/*  150 */     this.jLabel3 = new JLabel();
/*  151 */     this.jSeparator1 = new JSeparator();
/*  152 */     this.jLabel4 = new JLabel();
/*  153 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  154 */     this.jLabel5 = new JLabel();
/*  155 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  156 */     this.jButton6 = new JButton();
/*  157 */     this.jRadioButton1 = new JRadioButton();
/*  158 */     this.jRadioButton2 = new JRadioButton();
/*  159 */     this.jRadioButton3 = new JRadioButton();
/*  160 */     this.jRadioButton4 = new JRadioButton();
/*  161 */     this.jCheckBox1 = new JCheckBox();
/*  162 */     this.jLabel6 = new JLabel();
/*  163 */     this.jTextField22 = new JTextField();
/*  164 */     this.buttonGroup1 = new ButtonGroup();
/*  165 */     this.buttonGroup2 = new ButtonGroup();
/*  166 */     this.jPanel12 = new JPanel();
/*  167 */     this.jPanel50 = new JPanel();
/*  168 */     this.jLabel20 = new JLabel();
/*  169 */     this.jPanel80 = new JPanel();
/*  170 */     this.jLabel128 = new JLabel();
/*  171 */     this.jLabel27 = new JLabel();
/*  172 */     this.jPanel79 = new JPanel();
/*  173 */     this.materialButton2 = new MaterialButton();
/*  174 */     this.materialButton1 = new MaterialButton();
/*  175 */     this.jPanel1 = new JPanel();
/*  176 */     this.jLabel13 = new JLabel();
/*  177 */     this.jTextField1 = new JTextField();
/*  178 */     this.jLabel21 = new JLabel();
/*  179 */     this.jTextField8 = new JTextField();
/*  180 */     this.jLabel12 = new JLabel();
/*  181 */     this.jTextField2 = new JTextField();
/*  182 */     this.jLabel26 = new JLabel();
/*  183 */     this.jTextField15 = new JTextField();
/*  184 */     this.jLabel15 = new JLabel();
/*  185 */     this.jLabel11 = new JLabel();
/*  186 */     this.jTextField3 = new JTextField();
/*  187 */     this.jLabel9 = new JLabel();
/*  188 */     this.jTextField4 = new JTextField();
/*  189 */     this.jLabel10 = new JLabel();
/*  190 */     this.jPanel59 = new JPanel();
/*  191 */     this.jButton2 = new JButton();
/*  192 */     this.jTextField16 = new JTextField();
/*  193 */     this.jTextField17 = new JTextField();
/*  194 */     this.jLabel17 = new JLabel();
/*  195 */     this.jTextField7 = new JTextField();
/*  196 */     this.jTextField18 = new JTextField();
/*  197 */     this.jLabel29 = new JLabel();
/*  198 */     this.jTextField19 = new JTextField();
/*  199 */     this.jTextField20 = new JTextField();
/*  200 */     this.jLabel30 = new JLabel();
/*  201 */     this.jTextField21 = new JTextField();
/*  202 */     this.jLabel16 = new JLabel();
/*  203 */     this.jLabel23 = new JLabel();
/*  204 */     this.jTextField10 = new JTextField();
/*  205 */     this.jLabel24 = new JLabel();
/*  206 */     this.jTextField13 = new JTextField();
/*  207 */     this.jLabel25 = new JLabel();
/*  208 */     this.jTextField14 = new JTextField();
/*  209 */     this.jLabel22 = new JLabel();
/*  210 */     this.jTextField11 = new JTextField();
/*  211 */     this.jLabel19 = new JLabel();
/*  212 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  213 */     this.jLabel28 = new JLabel();
/*  214 */     this.jTextField12 = new JTextField();
/*  215 */     this.jButton5 = new JButton();
/*  216 */     this.jPanel60 = new JPanel();
/*  217 */     this.jButton1 = new JButton();
/*  218 */     this.jTextField6 = new JTextField();
/*  219 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  220 */     this.jLabel14 = new JLabel();
/*  221 */     this.jTextField23 = new JTextField();
/*  222 */     this.jPanel61 = new JPanel();
/*  223 */     this.jButton3 = new JButton();
/*  224 */     this.jTextField24 = new JTextField();
/*      */     
/*  226 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  227 */     this.jPanel57.setLayout(jPanel57Layout);
/*  228 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  230 */         .addGap(0, 611, 32767));
/*      */     
/*  232 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  234 */         .addGap(0, 495, 32767));
/*      */ 
/*      */     
/*  237 */     this.jPanel8.setBackground(this.lc.TERCERO1);
/*  238 */     this.jPanel8.setLayout(new GridBagLayout());
/*  239 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  240 */     gridBagConstraints.gridx = 4;
/*  241 */     gridBagConstraints.gridy = 8;
/*  242 */     gridBagConstraints.gridwidth = 19;
/*  243 */     gridBagConstraints.fill = 1;
/*  244 */     this.jPanel8.add(this.jTextField5, gridBagConstraints);
/*      */     
/*  246 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/*  247 */     this.jLabel18.setHorizontalAlignment(4);
/*  248 */     this.jLabel18.setText("Estado");
/*  249 */     gridBagConstraints = new GridBagConstraints();
/*  250 */     gridBagConstraints.gridx = 12;
/*  251 */     gridBagConstraints.gridy = 10;
/*  252 */     gridBagConstraints.anchor = 17;
/*  253 */     this.jPanel8.add(this.jLabel18, gridBagConstraints);
/*      */     
/*  255 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  256 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/*  257 */     gridBagConstraints = new GridBagConstraints();
/*  258 */     gridBagConstraints.gridx = 14;
/*  259 */     gridBagConstraints.gridy = 10;
/*  260 */     gridBagConstraints.gridwidth = 9;
/*  261 */     gridBagConstraints.fill = 2;
/*  262 */     this.jPanel8.add(this.jComboBox1, gridBagConstraints);
/*      */     
/*  264 */     this.jDialog1.setTitle("Cantidades Liquidaciones");
/*  265 */     this.jDialog1.setAlwaysOnTop(true);
/*  266 */     this.jDialog1.setModal(true);
/*      */     
/*  268 */     this.jLabel3.setFont(new Font("Cantarell", 1, 13));
/*  269 */     this.jLabel3.setForeground(this.lc.PRIMARIO2);
/*  270 */     this.jLabel3.setHorizontalAlignment(0);
/*  271 */     this.jLabel3.setText("LISTA DE CANTIDADES");
/*      */     
/*  273 */     this.jLabel4.setText("Cant. por Viaje");
/*      */     
/*  275 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*  276 */     this.jFormattedTextField2.setFont(new Font("Tahoma", 1, 11));
/*      */     
/*  278 */     this.jLabel5.setText("Cant. por Tonelada");
/*      */     
/*  280 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*  281 */     this.jFormattedTextField3.setFont(new Font("Tahoma", 1, 11));
/*      */     
/*  283 */     this.jButton6.setText("Cerrar");
/*  284 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  286 */             tras_Destinos_Form.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  290 */     this.jRadioButton1.setSelected(true);
/*  291 */     this.jRadioButton1.setText("Viaje");
/*      */     
/*  293 */     this.jRadioButton2.setText("Toneladas");
/*      */     
/*  295 */     this.jRadioButton3.setSelected(true);
/*  296 */     this.jRadioButton3.setText("Local");
/*      */     
/*  298 */     this.jRadioButton4.setText("Foraneo");
/*      */     
/*  300 */     this.jCheckBox1.setText("Es Pozo");
/*      */     
/*  302 */     this.jLabel6.setText("Kilometros");
/*      */     
/*  304 */     this.jTextField22.setHorizontalAlignment(4);
/*  305 */     this.jTextField22.setText("0");
/*      */     
/*  307 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  308 */     this.jPanel6.setLayout(jPanel6Layout);
/*  309 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  311 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  312 */           .addContainerGap()
/*  313 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  314 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  315 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  316 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/*  317 */                   .addGap(115, 115, 115)
/*  318 */                   .addComponent(this.jRadioButton4, -2, 111, -2))
/*  319 */                 .addComponent(this.jRadioButton3, -2, 83, -2)
/*  320 */                 .addComponent(this.jLabel3, -2, 285, -2)
/*  321 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  322 */                   .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  323 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  324 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  325 */                       .addComponent(this.jLabel5, -1, 106, 32767)
/*  326 */                       .addComponent(this.jLabel4, -1, -1, 32767))
/*  327 */                     .addGap(9, 9, 9)
/*  328 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  329 */                       .addComponent(this.jFormattedTextField3, -2, 164, -2)
/*  330 */                       .addComponent(this.jFormattedTextField2)
/*  331 */                       .addComponent(this.jRadioButton2, -2, 111, -2)
/*  332 */                       .addComponent(this.jButton6, GroupLayout.Alignment.TRAILING, -2, 84, -2))))
/*  333 */                 .addComponent(this.jRadioButton1, -2, 83, -2)
/*  334 */                 .addComponent(this.jCheckBox1, -2, 141, -2))
/*  335 */               .addContainerGap(-1, 32767))
/*  336 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  337 */               .addComponent(this.jLabel6, -1, -1, 32767)
/*  338 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  339 */               .addComponent(this.jTextField22, -2, 110, -2)
/*  340 */               .addGap(69, 69, 69)))));
/*      */     
/*  342 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  344 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  345 */           .addContainerGap()
/*  346 */           .addComponent(this.jLabel3)
/*  347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  348 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  349 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  350 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  351 */             .addComponent(this.jLabel4)
/*  352 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/*  353 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  354 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  355 */             .addComponent(this.jLabel5)
/*  356 */             .addComponent(this.jFormattedTextField3, -2, -1, -2))
/*  357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  358 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  359 */             .addComponent(this.jRadioButton1)
/*  360 */             .addComponent(this.jRadioButton2))
/*  361 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  362 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  363 */             .addComponent(this.jRadioButton3)
/*  364 */             .addComponent(this.jRadioButton4))
/*  365 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  366 */           .addComponent(this.jCheckBox1)
/*  367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  368 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  369 */             .addComponent(this.jLabel6)
/*  370 */             .addComponent(this.jTextField22, -2, -1, -2))
/*  371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/*  372 */           .addComponent(this.jButton6)
/*  373 */           .addContainerGap()));
/*      */ 
/*      */     
/*  376 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  377 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  378 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  379 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  380 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/*  382 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  384 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/*  387 */     setDefaultCloseOperation(2);
/*  388 */     setAlwaysOnTop(true);
/*  389 */     setModal(true);
/*  390 */     setUndecorated(true);
/*      */     
/*  392 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  394 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  396 */     this.jLabel20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  397 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/*  398 */     this.jLabel20.setHorizontalAlignment(0);
/*  399 */     this.jLabel20.setText("Nuevo");
/*  400 */     this.jLabel20.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  402 */             tras_Destinos_Form.this.jLabel20MouseDragged(evt);
/*      */           }
/*      */         });
/*  405 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  407 */             tras_Destinos_Form.this.jLabel20MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  411 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/*  412 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*      */     
/*  414 */     this.jLabel128.setHorizontalAlignment(0);
/*  415 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  416 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  418 */             tras_Destinos_Form.this.jLabel128MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  421 */             tras_Destinos_Form.this.jLabel128MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  424 */             tras_Destinos_Form.this.jLabel128MouseExited(evt);
/*      */           }
/*      */         });
/*  427 */     this.jPanel80.add(this.jLabel128);
/*      */     
/*  429 */     this.jLabel27.setHorizontalAlignment(0);
/*      */     
/*  431 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/*  432 */     this.jPanel50.setLayout(jPanel50Layout);
/*  433 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/*  434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  435 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  436 */           .addGap(1, 1, 1)
/*  437 */           .addComponent(this.jLabel27, -2, 36, -2)
/*  438 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  439 */           .addComponent(this.jLabel20, -1, -1, 32767)
/*  440 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  441 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*      */     
/*  443 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/*  444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  445 */         .addComponent(this.jPanel80, -1, -1, 32767)
/*  446 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  447 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  448 */             .addComponent(this.jLabel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  449 */             .addComponent(this.jLabel20, -2, 30, -2))
/*  450 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  453 */     this.jPanel79.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  455 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/*  456 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  457 */     this.materialButton2.setMnemonic('R');
/*  458 */     this.materialButton2.setText("Cerrar");
/*  459 */     this.materialButton2.setToolTipText("Cerrar (Alt+R)");
/*  460 */     this.materialButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  461 */     this.materialButton2.setHorizontalTextPosition(0);
/*  462 */     this.materialButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  464 */             tras_Destinos_Form.this.materialButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  468 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/*  469 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/*  470 */     this.materialButton1.setMnemonic('G');
/*  471 */     this.materialButton1.setText("Guardar");
/*  472 */     this.materialButton1.setToolTipText("Guardar (Alt+G)");
/*  473 */     this.materialButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  474 */     this.materialButton1.setHorizontalTextPosition(0);
/*  475 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  477 */             tras_Destinos_Form.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  481 */     GroupLayout jPanel79Layout = new GroupLayout(this.jPanel79);
/*  482 */     this.jPanel79.setLayout(jPanel79Layout);
/*  483 */     jPanel79Layout.setHorizontalGroup(jPanel79Layout
/*  484 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  485 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
/*  486 */           .addContainerGap(-1, 32767)
/*  487 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/*  488 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  489 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/*  490 */           .addContainerGap()));
/*      */     
/*  492 */     jPanel79Layout.setVerticalGroup(jPanel79Layout
/*  493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  494 */         .addGroup(jPanel79Layout.createSequentialGroup()
/*  495 */           .addGroup(jPanel79Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  496 */             .addComponent((Component)this.materialButton1, -2, 38, -2)
/*  497 */             .addComponent((Component)this.materialButton2, -1, -1, 32767))
/*  498 */           .addGap(0, 2, 32767)));
/*      */ 
/*      */     
/*  501 */     GridBagLayout jPanel1Layout = new GridBagLayout();
/*  502 */     jPanel1Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  503 */     jPanel1Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  504 */     this.jPanel1.setLayout(jPanel1Layout);
/*      */     
/*  506 */     this.jLabel13.setFont(new Font("Cantarell", 1, 11));
/*  507 */     this.jLabel13.setText("Clave*");
/*  508 */     gridBagConstraints = new GridBagConstraints();
/*  509 */     gridBagConstraints.gridx = 6;
/*  510 */     gridBagConstraints.gridy = 0;
/*  511 */     gridBagConstraints.anchor = 17;
/*  512 */     this.jPanel1.add(this.jLabel13, gridBagConstraints);
/*      */     
/*  514 */     this.jTextField1.setEditable(false);
/*  515 */     this.jTextField1.setFont(new Font("Tahoma", 1, 12));
/*  516 */     this.jTextField1.setForeground(Color.red);
/*  517 */     this.jTextField1.setText(" ");
/*  518 */     gridBagConstraints = new GridBagConstraints();
/*  519 */     gridBagConstraints.gridx = 8;
/*  520 */     gridBagConstraints.gridy = 0;
/*  521 */     gridBagConstraints.gridwidth = 3;
/*  522 */     gridBagConstraints.fill = 2;
/*  523 */     gridBagConstraints.anchor = 18;
/*  524 */     gridBagConstraints.weightx = 1.0D;
/*  525 */     this.jPanel1.add(this.jTextField1, gridBagConstraints);
/*      */     
/*  527 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/*  528 */     this.jLabel21.setText("RFC");
/*  529 */     gridBagConstraints = new GridBagConstraints();
/*  530 */     gridBagConstraints.gridx = 14;
/*  531 */     gridBagConstraints.gridy = 0;
/*  532 */     gridBagConstraints.anchor = 17;
/*  533 */     this.jPanel1.add(this.jLabel21, gridBagConstraints);
/*      */     
/*  535 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  537 */             tras_Destinos_Form.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*  540 */     gridBagConstraints = new GridBagConstraints();
/*  541 */     gridBagConstraints.gridx = 16;
/*  542 */     gridBagConstraints.gridy = 0;
/*  543 */     gridBagConstraints.fill = 2;
/*  544 */     gridBagConstraints.anchor = 256;
/*  545 */     gridBagConstraints.weightx = 6.0D;
/*  546 */     this.jPanel1.add(this.jTextField8, gridBagConstraints);
/*      */     
/*  548 */     this.jLabel12.setFont(new Font("Cantarell", 1, 11));
/*  549 */     this.jLabel12.setText("Destino o Nombre*");
/*  550 */     gridBagConstraints = new GridBagConstraints();
/*  551 */     gridBagConstraints.gridx = 6;
/*  552 */     gridBagConstraints.gridy = 4;
/*  553 */     gridBagConstraints.anchor = 17;
/*  554 */     this.jPanel1.add(this.jLabel12, gridBagConstraints);
/*      */     
/*  556 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  558 */             tras_Destinos_Form.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*  561 */     gridBagConstraints = new GridBagConstraints();
/*  562 */     gridBagConstraints.gridx = 8;
/*  563 */     gridBagConstraints.gridy = 4;
/*  564 */     gridBagConstraints.gridwidth = 9;
/*  565 */     gridBagConstraints.fill = 1;
/*  566 */     gridBagConstraints.ipady = 1;
/*  567 */     this.jPanel1.add(this.jTextField2, gridBagConstraints);
/*      */     
/*  569 */     this.jLabel26.setFont(new Font("Cantarell", 1, 11));
/*  570 */     this.jLabel26.setText("Nombre Corto*");
/*  571 */     gridBagConstraints = new GridBagConstraints();
/*  572 */     gridBagConstraints.gridx = 6;
/*  573 */     gridBagConstraints.gridy = 6;
/*  574 */     gridBagConstraints.anchor = 17;
/*  575 */     this.jPanel1.add(this.jLabel26, gridBagConstraints);
/*  576 */     gridBagConstraints = new GridBagConstraints();
/*  577 */     gridBagConstraints.gridx = 8;
/*  578 */     gridBagConstraints.gridy = 6;
/*  579 */     gridBagConstraints.gridwidth = 9;
/*  580 */     gridBagConstraints.fill = 1;
/*  581 */     gridBagConstraints.weightx = 10.0D;
/*  582 */     this.jPanel1.add(this.jTextField15, gridBagConstraints);
/*      */     
/*  584 */     this.jLabel15.setFont(new Font("Cantarell", 1, 11));
/*  585 */     this.jLabel15.setText("C.P. *");
/*  586 */     gridBagConstraints = new GridBagConstraints();
/*  587 */     gridBagConstraints.gridx = 6;
/*  588 */     gridBagConstraints.gridy = 8;
/*  589 */     gridBagConstraints.anchor = 17;
/*  590 */     this.jPanel1.add(this.jLabel15, gridBagConstraints);
/*      */     
/*  592 */     this.jLabel11.setFont(new Font("Cantarell", 1, 11));
/*  593 */     this.jLabel11.setText("Calle*");
/*  594 */     gridBagConstraints = new GridBagConstraints();
/*  595 */     gridBagConstraints.gridx = 6;
/*  596 */     gridBagConstraints.gridy = 10;
/*  597 */     gridBagConstraints.anchor = 17;
/*  598 */     this.jPanel1.add(this.jLabel11, gridBagConstraints);
/*      */     
/*  600 */     this.jTextField3.setEnabled(false);
/*  601 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  603 */             tras_Destinos_Form.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  606 */     gridBagConstraints = new GridBagConstraints();
/*  607 */     gridBagConstraints.gridx = 8;
/*  608 */     gridBagConstraints.gridy = 10;
/*  609 */     gridBagConstraints.gridwidth = 3;
/*  610 */     gridBagConstraints.fill = 1;
/*  611 */     gridBagConstraints.weightx = 10.0D;
/*  612 */     this.jPanel1.add(this.jTextField3, gridBagConstraints);
/*      */     
/*  614 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/*  615 */     this.jLabel9.setText("Número");
/*  616 */     gridBagConstraints = new GridBagConstraints();
/*  617 */     gridBagConstraints.gridx = 14;
/*  618 */     gridBagConstraints.gridy = 10;
/*  619 */     gridBagConstraints.anchor = 17;
/*  620 */     this.jPanel1.add(this.jLabel9, gridBagConstraints);
/*      */     
/*  622 */     this.jTextField4.setEnabled(false);
/*  623 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  625 */             tras_Destinos_Form.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*  628 */     gridBagConstraints = new GridBagConstraints();
/*  629 */     gridBagConstraints.gridx = 16;
/*  630 */     gridBagConstraints.gridy = 10;
/*  631 */     gridBagConstraints.fill = 2;
/*  632 */     gridBagConstraints.weightx = 6.0D;
/*  633 */     this.jPanel1.add(this.jTextField4, gridBagConstraints);
/*      */     
/*  635 */     this.jLabel10.setFont(new Font("Cantarell", 0, 11));
/*  636 */     this.jLabel10.setHorizontalAlignment(4);
/*  637 */     this.jLabel10.setText("Colonia");
/*  638 */     gridBagConstraints = new GridBagConstraints();
/*  639 */     gridBagConstraints.gridx = 6;
/*  640 */     gridBagConstraints.gridy = 12;
/*  641 */     gridBagConstraints.anchor = 17;
/*  642 */     this.jPanel1.add(this.jLabel10, gridBagConstraints);
/*      */     
/*  644 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  645 */     this.jButton2.setMnemonic('F');
/*  646 */     this.jButton2.setToolTipText("Filtrar información (Alt+F)");
/*  647 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  649 */             tras_Destinos_Form.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  653 */     this.jTextField16.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  654 */     this.jTextField16.setText("col");
/*  655 */     this.jTextField16.setEnabled(false);
/*  656 */     this.jTextField16.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  658 */             tras_Destinos_Form.this.jTextField16KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  662 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/*  663 */     this.jPanel59.setLayout(jPanel59Layout);
/*  664 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/*  665 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  666 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  667 */           .addComponent(this.jTextField16)
/*  668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  669 */           .addComponent(this.jButton2, -2, 20, -2)
/*  670 */           .addGap(0, 0, 0)));
/*      */     
/*  672 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/*  673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  674 */         .addGroup(jPanel59Layout.createSequentialGroup()
/*  675 */           .addGroup(jPanel59Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  676 */             .addComponent(this.jTextField16, -2, -1, -2)
/*  677 */             .addComponent(this.jButton2, -2, 24, -2))
/*  678 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  681 */     gridBagConstraints = new GridBagConstraints();
/*  682 */     gridBagConstraints.gridx = 10;
/*  683 */     gridBagConstraints.gridy = 12;
/*  684 */     gridBagConstraints.gridwidth = 7;
/*  685 */     gridBagConstraints.fill = 1;
/*  686 */     this.jPanel1.add(this.jPanel59, gridBagConstraints);
/*      */     
/*  688 */     this.jTextField17.setText("jTextField17");
/*  689 */     this.jTextField17.setEnabled(false);
/*  690 */     gridBagConstraints = new GridBagConstraints();
/*  691 */     gridBagConstraints.gridx = 8;
/*  692 */     gridBagConstraints.gridy = 12;
/*  693 */     gridBagConstraints.fill = 2;
/*  694 */     this.jPanel1.add(this.jTextField17, gridBagConstraints);
/*      */     
/*  696 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/*  697 */     this.jLabel17.setText("Clientes");
/*  698 */     gridBagConstraints = new GridBagConstraints();
/*  699 */     gridBagConstraints.gridx = 6;
/*  700 */     gridBagConstraints.gridy = 20;
/*  701 */     gridBagConstraints.anchor = 17;
/*  702 */     this.jPanel1.add(this.jLabel17, gridBagConstraints);
/*      */     
/*  704 */     this.jTextField7.setEnabled(false);
/*  705 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  707 */             tras_Destinos_Form.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*  710 */     gridBagConstraints = new GridBagConstraints();
/*  711 */     gridBagConstraints.gridx = 10;
/*  712 */     gridBagConstraints.gridy = 16;
/*  713 */     gridBagConstraints.gridwidth = 7;
/*  714 */     gridBagConstraints.fill = 2;
/*  715 */     this.jPanel1.add(this.jTextField7, gridBagConstraints);
/*      */     
/*  717 */     this.jTextField18.setText("jTextField18");
/*  718 */     this.jTextField18.setEnabled(false);
/*  719 */     gridBagConstraints = new GridBagConstraints();
/*  720 */     gridBagConstraints.gridx = 8;
/*  721 */     gridBagConstraints.gridy = 16;
/*  722 */     gridBagConstraints.fill = 2;
/*  723 */     this.jPanel1.add(this.jTextField18, gridBagConstraints);
/*      */     
/*  725 */     this.jLabel29.setFont(new Font("Cantarell", 1, 11));
/*  726 */     this.jLabel29.setText("Ciudad *");
/*  727 */     gridBagConstraints = new GridBagConstraints();
/*  728 */     gridBagConstraints.gridx = 6;
/*  729 */     gridBagConstraints.gridy = 16;
/*  730 */     gridBagConstraints.anchor = 17;
/*  731 */     this.jPanel1.add(this.jLabel29, gridBagConstraints);
/*      */     
/*  733 */     this.jTextField19.setText("jTextField19");
/*  734 */     this.jTextField19.setEnabled(false);
/*  735 */     gridBagConstraints = new GridBagConstraints();
/*  736 */     gridBagConstraints.gridx = 8;
/*  737 */     gridBagConstraints.gridy = 18;
/*  738 */     gridBagConstraints.fill = 2;
/*  739 */     this.jPanel1.add(this.jTextField19, gridBagConstraints);
/*      */     
/*  741 */     this.jTextField20.setText("jTextField20");
/*  742 */     this.jTextField20.setEnabled(false);
/*  743 */     gridBagConstraints = new GridBagConstraints();
/*  744 */     gridBagConstraints.gridx = 10;
/*  745 */     gridBagConstraints.gridy = 18;
/*  746 */     gridBagConstraints.gridwidth = 7;
/*  747 */     gridBagConstraints.fill = 2;
/*  748 */     gridBagConstraints.weightx = 1.0D;
/*  749 */     this.jPanel1.add(this.jTextField20, gridBagConstraints);
/*      */     
/*  751 */     this.jLabel30.setFont(new Font("Cantarell", 1, 11));
/*  752 */     this.jLabel30.setText("Estado*");
/*  753 */     gridBagConstraints = new GridBagConstraints();
/*  754 */     gridBagConstraints.gridx = 6;
/*  755 */     gridBagConstraints.gridy = 18;
/*  756 */     gridBagConstraints.anchor = 17;
/*  757 */     this.jPanel1.add(this.jLabel30, gridBagConstraints);
/*      */     
/*  759 */     this.jTextField21.setText("jTextField21");
/*  760 */     this.jTextField21.setEnabled(false);
/*  761 */     gridBagConstraints = new GridBagConstraints();
/*  762 */     gridBagConstraints.gridx = 8;
/*  763 */     gridBagConstraints.gridy = 20;
/*  764 */     gridBagConstraints.gridwidth = 9;
/*  765 */     gridBagConstraints.fill = 2;
/*  766 */     this.jPanel1.add(this.jTextField21, gridBagConstraints);
/*      */     
/*  768 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/*  769 */     this.jLabel16.setText("Monto a Cobrar ");
/*  770 */     gridBagConstraints = new GridBagConstraints();
/*  771 */     gridBagConstraints.gridx = 6;
/*  772 */     gridBagConstraints.gridy = 22;
/*  773 */     gridBagConstraints.anchor = 17;
/*  774 */     this.jPanel1.add(this.jLabel16, gridBagConstraints);
/*      */     
/*  776 */     this.jLabel23.setFont(new Font("Cantarell", 0, 11));
/*  777 */     this.jLabel23.setText("Cantidad con letra");
/*  778 */     gridBagConstraints = new GridBagConstraints();
/*  779 */     gridBagConstraints.gridx = 6;
/*  780 */     gridBagConstraints.gridy = 24;
/*  781 */     gridBagConstraints.anchor = 17;
/*  782 */     this.jPanel1.add(this.jLabel23, gridBagConstraints);
/*      */     
/*  784 */     this.jTextField10.setEnabled(false);
/*  785 */     gridBagConstraints = new GridBagConstraints();
/*  786 */     gridBagConstraints.gridx = 8;
/*  787 */     gridBagConstraints.gridy = 24;
/*  788 */     gridBagConstraints.gridwidth = 9;
/*  789 */     gridBagConstraints.fill = 2;
/*  790 */     gridBagConstraints.weightx = 0.2D;
/*  791 */     this.jPanel1.add(this.jTextField10, gridBagConstraints);
/*      */     
/*  793 */     this.jLabel24.setFont(new Font("Cantarell", 0, 11));
/*  794 */     this.jLabel24.setText("L.A.U.");
/*  795 */     gridBagConstraints = new GridBagConstraints();
/*  796 */     gridBagConstraints.gridx = 6;
/*  797 */     gridBagConstraints.gridy = 26;
/*  798 */     gridBagConstraints.anchor = 17;
/*  799 */     this.jPanel1.add(this.jLabel24, gridBagConstraints);
/*      */     
/*  801 */     this.jTextField13.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  803 */             tras_Destinos_Form.this.jTextField13KeyReleased(evt);
/*      */           }
/*      */         });
/*  806 */     gridBagConstraints = new GridBagConstraints();
/*  807 */     gridBagConstraints.gridx = 8;
/*  808 */     gridBagConstraints.gridy = 26;
/*  809 */     gridBagConstraints.gridwidth = 5;
/*  810 */     gridBagConstraints.fill = 2;
/*  811 */     gridBagConstraints.weightx = 1.0D;
/*  812 */     this.jPanel1.add(this.jTextField13, gridBagConstraints);
/*      */     
/*  814 */     this.jLabel25.setFont(new Font("Cantarell", 0, 11));
/*  815 */     this.jLabel25.setText("Báscula Ceritficada");
/*  816 */     gridBagConstraints = new GridBagConstraints();
/*  817 */     gridBagConstraints.gridx = 14;
/*  818 */     gridBagConstraints.gridy = 26;
/*  819 */     gridBagConstraints.anchor = 17;
/*  820 */     this.jPanel1.add(this.jLabel25, gridBagConstraints);
/*  821 */     gridBagConstraints = new GridBagConstraints();
/*  822 */     gridBagConstraints.gridx = 16;
/*  823 */     gridBagConstraints.gridy = 26;
/*  824 */     gridBagConstraints.fill = 2;
/*  825 */     gridBagConstraints.weightx = 6.0D;
/*  826 */     this.jPanel1.add(this.jTextField14, gridBagConstraints);
/*      */     
/*  828 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/*  829 */     this.jLabel22.setText("Aut. SEMARNAT ");
/*  830 */     gridBagConstraints = new GridBagConstraints();
/*  831 */     gridBagConstraints.gridx = 6;
/*  832 */     gridBagConstraints.gridy = 28;
/*  833 */     gridBagConstraints.anchor = 17;
/*  834 */     this.jPanel1.add(this.jLabel22, gridBagConstraints);
/*      */     
/*  836 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  838 */             tras_Destinos_Form.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*  841 */     gridBagConstraints = new GridBagConstraints();
/*  842 */     gridBagConstraints.gridx = 8;
/*  843 */     gridBagConstraints.gridy = 28;
/*  844 */     gridBagConstraints.gridwidth = 5;
/*  845 */     gridBagConstraints.fill = 2;
/*  846 */     gridBagConstraints.weightx = 1.0D;
/*  847 */     this.jPanel1.add(this.jTextField11, gridBagConstraints);
/*      */     
/*  849 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/*  850 */     this.jLabel19.setText("Teléfono");
/*  851 */     gridBagConstraints = new GridBagConstraints();
/*  852 */     gridBagConstraints.gridx = 14;
/*  853 */     gridBagConstraints.gridy = 28;
/*  854 */     gridBagConstraints.anchor = 17;
/*  855 */     this.jPanel1.add(this.jLabel19, gridBagConstraints);
/*      */     
/*  857 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  859 */             tras_Destinos_Form.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  862 */     gridBagConstraints = new GridBagConstraints();
/*  863 */     gridBagConstraints.gridx = 16;
/*  864 */     gridBagConstraints.gridy = 28;
/*  865 */     gridBagConstraints.fill = 2;
/*  866 */     gridBagConstraints.weightx = 6.0D;
/*  867 */     this.jPanel1.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/*  869 */     this.jLabel28.setFont(new Font("Cantarell", 0, 11));
/*  870 */     this.jLabel28.setText("Ruta");
/*  871 */     gridBagConstraints = new GridBagConstraints();
/*  872 */     gridBagConstraints.gridx = 6;
/*  873 */     gridBagConstraints.gridy = 30;
/*  874 */     gridBagConstraints.anchor = 17;
/*  875 */     this.jPanel1.add(this.jLabel28, gridBagConstraints);
/*      */     
/*  877 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  879 */             tras_Destinos_Form.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*  882 */     gridBagConstraints = new GridBagConstraints();
/*  883 */     gridBagConstraints.gridx = 8;
/*  884 */     gridBagConstraints.gridy = 30;
/*  885 */     gridBagConstraints.gridwidth = 9;
/*  886 */     gridBagConstraints.fill = 2;
/*  887 */     this.jPanel1.add(this.jTextField12, gridBagConstraints);
/*      */     
/*  889 */     this.jButton5.setText("Cant Liquidaciones");
/*  890 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  892 */             tras_Destinos_Form.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  895 */     gridBagConstraints = new GridBagConstraints();
/*  896 */     gridBagConstraints.gridx = 8;
/*  897 */     gridBagConstraints.gridy = 32;
/*  898 */     this.jPanel1.add(this.jButton5, gridBagConstraints);
/*      */     
/*  900 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  901 */     this.jButton1.setMnemonic('F');
/*  902 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/*  903 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  905 */             tras_Destinos_Form.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  909 */     this.jTextField6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  910 */     this.jTextField6.setText("cod");
/*  911 */     this.jTextField6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  913 */             tras_Destinos_Form.this.jTextField6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  916 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  918 */             tras_Destinos_Form.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  922 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/*  923 */     this.jPanel60.setLayout(jPanel60Layout);
/*  924 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/*  925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  926 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  927 */           .addComponent(this.jTextField6, -1, 584, 32767)
/*  928 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  929 */           .addComponent(this.jButton1, -2, 20, -2)
/*  930 */           .addGap(0, 0, 0)));
/*      */     
/*  932 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/*  933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  934 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  935 */           .addGroup(jPanel60Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  936 */             .addComponent(this.jTextField6, -2, -1, -2)
/*  937 */             .addComponent(this.jButton1, -2, 24, -2))
/*  938 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/*  941 */     gridBagConstraints = new GridBagConstraints();
/*  942 */     gridBagConstraints.gridx = 8;
/*  943 */     gridBagConstraints.gridy = 8;
/*  944 */     gridBagConstraints.gridwidth = 9;
/*  945 */     gridBagConstraints.fill = 2;
/*  946 */     this.jPanel1.add(this.jPanel60, gridBagConstraints);
/*      */     
/*  948 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/*  949 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  951 */             tras_Destinos_Form.this.jFormattedTextField4FocusLost(evt);
/*      */           }
/*      */         });
/*  954 */     gridBagConstraints = new GridBagConstraints();
/*  955 */     gridBagConstraints.gridx = 8;
/*  956 */     gridBagConstraints.gridy = 22;
/*  957 */     gridBagConstraints.gridwidth = 9;
/*  958 */     gridBagConstraints.fill = 2;
/*  959 */     this.jPanel1.add(this.jFormattedTextField4, gridBagConstraints);
/*      */     
/*  961 */     this.jLabel14.setFont(new Font("Cantarell", 1, 11));
/*  962 */     this.jLabel14.setHorizontalAlignment(4);
/*  963 */     this.jLabel14.setText("Localidad");
/*  964 */     gridBagConstraints = new GridBagConstraints();
/*  965 */     gridBagConstraints.gridx = 6;
/*  966 */     gridBagConstraints.gridy = 14;
/*  967 */     gridBagConstraints.anchor = 17;
/*  968 */     this.jPanel1.add(this.jLabel14, gridBagConstraints);
/*      */     
/*  970 */     this.jTextField23.setText("jTextField23");
/*  971 */     this.jTextField23.setEnabled(false);
/*  972 */     gridBagConstraints = new GridBagConstraints();
/*  973 */     gridBagConstraints.gridx = 8;
/*  974 */     gridBagConstraints.gridy = 14;
/*  975 */     gridBagConstraints.fill = 2;
/*  976 */     this.jPanel1.add(this.jTextField23, gridBagConstraints);
/*      */     
/*  978 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  979 */     this.jButton3.setMnemonic('F');
/*  980 */     this.jButton3.setToolTipText("Filtrar información (Alt+F)");
/*  981 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  983 */             tras_Destinos_Form.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  987 */     this.jTextField24.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  988 */     this.jTextField24.setText("Localidad");
/*  989 */     this.jTextField24.setEnabled(false);
/*  990 */     this.jTextField24.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  992 */             tras_Destinos_Form.this.jTextField24KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  996 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/*  997 */     this.jPanel61.setLayout(jPanel61Layout);
/*  998 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/*  999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1000 */         .addGroup(jPanel61Layout.createSequentialGroup()
/* 1001 */           .addComponent(this.jTextField24)
/* 1002 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1003 */           .addComponent(this.jButton3, -2, 20, -2)
/* 1004 */           .addGap(0, 0, 0)));
/*      */     
/* 1006 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/* 1007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1008 */         .addGroup(jPanel61Layout.createSequentialGroup()
/* 1009 */           .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1010 */             .addComponent(this.jTextField24, -2, -1, -2)
/* 1011 */             .addComponent(this.jButton3, -2, 24, -2))
/* 1012 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/* 1015 */     gridBagConstraints = new GridBagConstraints();
/* 1016 */     gridBagConstraints.gridx = 10;
/* 1017 */     gridBagConstraints.gridy = 14;
/* 1018 */     gridBagConstraints.gridwidth = 7;
/* 1019 */     gridBagConstraints.fill = 1;
/* 1020 */     this.jPanel1.add(this.jPanel61, gridBagConstraints);
/*      */     
/* 1022 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1023 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1024 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1025 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1026 */         .addComponent(this.jPanel50, -1, -1, 32767)
/* 1027 */         .addComponent(this.jPanel1, -1, 745, 32767)
/* 1028 */         .addComponent(this.jPanel79, -1, -1, 32767));
/*      */     
/* 1030 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1031 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1032 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1033 */           .addComponent(this.jPanel50, -2, -1, -2)
/* 1034 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1035 */           .addComponent(this.jPanel1, -1, 507, 32767)
/* 1036 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1037 */           .addComponent(this.jPanel79, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1040 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1041 */     getContentPane().setLayout(layout);
/* 1042 */     layout.setHorizontalGroup(layout
/* 1043 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1044 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 1046 */     layout.setVerticalGroup(layout
/* 1047 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1048 */         .addGroup(layout.createSequentialGroup()
/* 1049 */           .addComponent(this.jPanel12, -2, -1, -2)
/* 1050 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1053 */     pack();
/*      */   }
/*      */   
/*      */   private void jLabel20MouseDragged(MouseEvent evt) {
/* 1057 */     int x = evt.getXOnScreen();
/* 1058 */     int y = evt.getYOnScreen();
/* 1059 */     setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel20MouseClicked(MouseEvent evt) {
/* 1063 */     this.xx = evt.getX();
/* 1064 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel128MouseClicked(MouseEvent evt) {
/* 1068 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel128MouseEntered(MouseEvent evt) {
/* 1072 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel128MouseExited(MouseEvent evt) {
/* 1076 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void materialButton2ActionPerformed(ActionEvent evt) {
/* 1080 */     this.actualizado = false;
/* 1081 */     setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 1085 */     convertirLetra();
/* 1086 */     if (this.jTextField2.getText().equals("")) {
/* 1087 */       this.jTextField2.setBackground(Color.RED);
/* 1088 */       JOptionPane.showMessageDialog(this, "Falta el cliente, nombre o destino", "Falta el nombre", 0, this.ERROR);
/* 1089 */     } else if (this.jTextField15.getText().equals("")) {
/* 1090 */       this.jTextField15.setBackground(Color.RED);
/* 1091 */       JOptionPane.showMessageDialog(this, "Falta ingresar el nombre corto del cliente", "Falta el nombre corto", 0, this.ERROR);
/* 1092 */     } else if (this.jTextField2.getText().equals(this.jTextField15.getText())) {
/* 1093 */       this.jTextField2.setBackground(Color.RED);
/* 1094 */       this.jTextField15.setBackground(Color.RED);
/* 1095 */       JOptionPane.showMessageDialog(this, "La información debe ser diferente", "Ingresar nombre corto o nombre comercial", 0, this.ERROR);
/* 1096 */     } else if (this.jTextField6.getText().equals("")) {
/* 1097 */       this.jTextField6.setBackground(Color.RED);
/* 1098 */       JOptionPane.showMessageDialog(this, "Falta ingresar el código postal", "Falta el código", 0, this.ERROR);
/* 1099 */     } else if (this.jTextField8.getText().contains(" ")) {
/* 1100 */       this.jTextField8.setBackground(Color.RED);
/* 1101 */       JOptionPane.showMessageDialog(this, "No puedes ingresar espacios en el campo del RFC", "Espacios detectados", 0, this.ERROR);
/* 1102 */     } else if (this.jTextField8.getText().length() < 12) {
/* 1103 */       this.jTextField8.setBackground(Color.RED);
/* 1104 */       JOptionPane.showMessageDialog(this, "<html>Te faltan caracteres en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1109 */     else if (this.jTextField8.getText().length() > 13) {
/* 1110 */       this.jTextField8.setBackground(Color.RED);
/* 1111 */       JOptionPane.showMessageDialog(this, "<html>Caracteres de más en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1117 */     else if (this.jTextField3.getText().equals("")) {
/* 1118 */       this.jTextField3.setBackground(Color.RED);
/* 1119 */       JOptionPane.showMessageDialog(this, "Falta ingresar la calle", "Falta la calle", 0, this.ERROR);
/* 1120 */     } else if (this.jTextField24.getText().equals("")) {
/* 1121 */       JOptionPane.showMessageDialog(this, "Falta ingresar la Localidad", "Falta la Localidad", 0, this.ERROR);
/* 1122 */     } else if (this.jTextField18.getText().equals("")) {
/* 1123 */       JOptionPane.showMessageDialog(this, "Falta ingresar la ciudad o municipio", "Falta la ciudad", 0, this.ERROR);
/* 1124 */     } else if (this.jTextField3.getText().equals("")) {
/* 1125 */       this.jTextField3.setBackground(Color.RED);
/* 1126 */       JOptionPane.showMessageDialog(this, "Falta ingresar la calle", "Falta la calle", 0, this.ERROR);
/* 1127 */     } else if (this.jTextField19.getText().equals("")) {
/* 1128 */       this.jTextField19.setBackground(Color.RED);
/* 1129 */       JOptionPane.showMessageDialog(this, "Falta ingresar el estado", "Falta el estado", 0, this.ERROR);
/* 1130 */     } else if (this.jTextField10.getText().equals("")) {
/* 1131 */       this.jTextField10.setBackground(Color.RED);
/* 1132 */       JOptionPane.showMessageDialog(this, "Falta ingresar la cantidad en letra", "Falta la cantidad en letra", 0, this.ERROR);
/*      */     } else {
/* 1134 */       int tipoPago = 0;
/* 1135 */       String local = "";
/* 1136 */       String pozo = "";
/* 1137 */       if (this.jCheckBox1.isSelected()) {
/* 1138 */         pozo = "SI";
/*      */       } else {
/* 1140 */         pozo = "NO";
/*      */       } 
/* 1142 */       if (this.jRadioButton1.isSelected()) {
/* 1143 */         tipoPago = 1;
/*      */       } else {
/* 1145 */         tipoPago = 2;
/*      */       } 
/*      */       
/* 1148 */       if (this.jRadioButton3.isSelected()) {
/* 1149 */         local = "SI";
/*      */       } else {
/* 1151 */         local = "NO";
/*      */       } 
/* 1153 */       if (this.materialButton1.getText().equals("Guardar")) {
/* 1154 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas guardar la información del nuevo destino?", "Crear Destino", 0, 3, this.PREG);
/* 1155 */         if (res == 0) {
/* 1156 */           this.con.inserSinMsj("insert into emp_destinataria(id, rfc, empresa, nombreCorto, cp, calle,num,col,ciudad,edo, telefono,monto,letra,semarnat,ruta,lau,bascula,viaje,viajeLetra,tons,tonsLetra,tipoPago,local,pozo,km,clientes, usuario, c_colonia, c_municipio, c_estado, c_localidad, localidad) values('" + this.jTextField1
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
/* 1168 */               .getText().toUpperCase() + "', '" + this.jTextField8.getText().toUpperCase() + "', '" + this.jTextField2.getText().toUpperCase() + "', '" + this.jTextField15
/* 1169 */               .getText().toUpperCase() + "', '" + this.jTextField6.getText().toUpperCase() + "', '" + this.jTextField3.getText().toUpperCase() + "', '" + this.jTextField4
/* 1170 */               .getText().toUpperCase() + "', '" + this.jTextField16.getText().toUpperCase() + "', '" + this.jTextField7.getText().toUpperCase() + "', '" + this.jTextField20
/* 1171 */               .getText().toUpperCase() + "', '" + this.jFormattedTextField1.getText() + "', " + String.valueOf(this.jFormattedTextField4.getValue()) + ", '" + this.jTextField10
/* 1172 */               .getText().toUpperCase() + "', '" + this.jTextField11.getText().toUpperCase() + "', '" + this.jTextField12.getText().toUpperCase() + "', '" + this.jTextField13
/* 1173 */               .getText().toUpperCase() + "', '" + this.jTextField14.getText().toUpperCase() + "', " + String.valueOf(this.jFormattedTextField2.getValue()) + ", '" + this.jFormattedTextField2
/* 1174 */               .getText() + "', " + String.valueOf(this.jFormattedTextField3.getValue()) + ", '" + this.jFormattedTextField3.getText() + "', '" + tipoPago + "', '" + local + "', '" + pozo + "','" + this.jTextField22
/*      */               
/* 1176 */               .getText().toUpperCase() + "', '', '" + this.utilerias.sacarUsuario(this.USUARIO) + "', '" + this.jTextField17
/* 1177 */               .getText().toUpperCase() + "', '" + this.jTextField18.getText().toUpperCase() + "', '" + this.jTextField19.getText().toUpperCase() + "', '" + this.jTextField23.getText().toUpperCase() + "', '" + this.jTextField24.getText().toUpperCase() + "' )");
/*      */           
/* 1179 */           activarModificacion();
/*      */         } 
/*      */       } else {
/* 1182 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas modificar la información del destino?", "Modificar Destino", 0, 3, this.PREG);
/* 1183 */         if (res == 0) {
/* 1184 */           this.con.inserSinMsj("update emp_destinataria set rfc = '" + this.jTextField8
/* 1185 */               .getText().toUpperCase() + "', empresa = '" + this.jTextField2.getText().toUpperCase() + "', nombreCorto = '" + this.jTextField15.getText().toUpperCase() + "', cp = '" + this.jTextField6
/* 1186 */               .getText().toUpperCase() + "', calle = '" + this.jTextField3.getText().toUpperCase() + "', num = '" + this.jTextField4.getText().toUpperCase() + "', col = '" + this.jTextField16
/* 1187 */               .getText().toUpperCase() + "', ciudad = '" + this.jTextField7.getText().toUpperCase() + "', edo = '" + this.jTextField20.getText().toUpperCase() + "', telefono = '" + this.jFormattedTextField1
/* 1188 */               .getText() + "', monto = " + this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText()) + ", letra = '" + this.jTextField10.getText().toUpperCase() + "', semarnat = '" + this.jTextField11
/* 1189 */               .getText().toUpperCase() + "', ruta = '" + this.jTextField12.getText().toUpperCase() + "', lau = '" + this.jTextField13.getText().toUpperCase() + "', bascula = '" + this.jTextField14
/* 1190 */               .getText().toUpperCase() + "', viaje = " + this.utilerias.convertirCantTexto(this.jFormattedTextField2.getText()) + ", viajeLetra ='" + this.jFormattedTextField2.getText() + "', tons = " + this.utilerias
/* 1191 */               .convertirCantTexto(this.jFormattedTextField3.getText()) + ", tonsLetra = '" + this.jFormattedTextField3.getText() + "', tipoPago = " + tipoPago + ", local = '" + local + "', pozo = '" + pozo + "', km = '" + this.jTextField22
/* 1192 */               .getText() + "', c_colonia = '" + this.jTextField17
/* 1193 */               .getText().toUpperCase() + "', c_municipio = '" + this.jTextField18.getText().toUpperCase() + "', c_estado = '" + this.jTextField19.getText().toUpperCase() + "', usuario = '" + this.utilerias
/* 1194 */               .sacarUsuario(this.USUARIO) + "', c_localidad = '" + this.jTextField23
/* 1195 */               .getText().toUpperCase() + "', localidad = '" + this.jTextField24
/* 1196 */               .getText().toUpperCase() + "' where id = '" + this.jTextField1
/* 1197 */               .getText().toUpperCase() + "'");
/* 1198 */           activarModificacion();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {}
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
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {}
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
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {}
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
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {}
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
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {}
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
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 1304 */     int cont = 0;
/* 1305 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 1306 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 1307 */       this.jFormattedTextField1.setValue("");
/* 1308 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 1309 */       String cadena = this.jFormattedTextField1.getText();
/* 1310 */       String cad1 = cadena.substring(0, 3);
/* 1311 */       String cad2 = cadena.substring(4, 7);
/* 1312 */       String cad3 = cadena.substring(8, 12);
/* 1313 */       String tel = cad1 + cad1 + cad2;
/* 1314 */       for (int i = 1; i < tel.length(); i++) {
/* 1315 */         char c = tel.charAt(i - 1);
/* 1316 */         char d = tel.charAt(i);
/* 1317 */         if (c != d) {
/* 1318 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 1322 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 1323 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 1324 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField13KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1341 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1345 */     this.CLAVECATALOGO.clear();
/* 1346 */     new TrasColonias(this, true, this.jButton2, "tras_colonias", this.CLAVECATALOGO, this.jTextField6.getText(), true);
/* 1347 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1348 */       this.jTextField17.setText(this.CLAVECATALOGO.get("1"));
/* 1349 */       this.jTextField16.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */     
/* 1352 */     String nuevoCod = this.CLAVECATALOGO.get("3");
/* 1353 */     String viejoCod = this.jTextField6.getText();
/*      */     
/* 1355 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1356 */       if (!nuevoCod.equals(viejoCod)) {
/* 1357 */         this.jTextField6.setText(nuevoCod);
/* 1358 */         habilitarDir();
/*      */       } 
/* 1360 */       this.jTextField16.setToolTipText(this.jTextField16.getText());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField16KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1369 */     this.CLAVECATALOGO = new TreeMap<>();
/* 1370 */     new TrasColonias(this, true, this.jButton2, "tras_codigos_postales", this.CLAVECATALOGO, "", true);
/* 1371 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1372 */       this.jTextField6.setText(this.CLAVECATALOGO.get("2"));
/* 1373 */       this.jTextField17.setText("");
/* 1374 */       this.jTextField16.setText("");
/* 1375 */       habilitarDir();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6ActionPerformed(ActionEvent evt) {
/* 1380 */     habilitarDir();
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 1384 */     if (this.jTextField6.getText().length() < 5) {
/* 1385 */       this.jTextField3.setEnabled(false);
/* 1386 */       this.jTextField4.setEnabled(false);
/* 1387 */       this.jTextField16.setText("");
/* 1388 */       this.jTextField7.setText("");
/* 1389 */       this.jTextField20.setText("");
/* 1390 */       this.jTextField17.setText("          ");
/* 1391 */       this.jTextField18.setText("          ");
/* 1392 */       this.jTextField19.setText("          ");
/* 1393 */       this.jTextField23.setText("          ");
/* 1394 */       this.jTextField19.setText("");
/*      */       
/* 1396 */       if (this.materialButton1.getText().equals("Guardar")) {
/* 1397 */         this.jTextField3.setEnabled(false);
/* 1398 */         this.jTextField4.setEnabled(false);
/*      */       } else {
/* 1400 */         this.jTextField3.setEnabled(true);
/* 1401 */         this.jTextField4.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1407 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField4FocusLost(FocusEvent evt) {
/* 1411 */     convertirLetra();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1415 */     this.CLAVECATALOGO = new TreeMap<>();
/* 1416 */     new TrasColonias(this, true, this.jButton3, "tras_localidades", this.CLAVECATALOGO, this.jTextField19.getText(), true);
/* 1417 */     if (this.CLAVECATALOGO.size() > 0) {
/* 1418 */       this.jTextField23.setText(this.CLAVECATALOGO.get("1"));
/* 1419 */       this.jTextField24.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField24KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   public void convertirLetra() {
/* 1428 */     this.numLetra = new NumerosALetras(this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText()), "MXN");
/* 1429 */     this.jTextField10.setText(this.numLetra.regresaNumero());
/*      */   }
/*      */   
/*      */   public void activarModificacion() {
/* 1433 */     this.Origen.put("ID", this.jTextField1.getText().toUpperCase());
/* 1434 */     this.Origen.put("RFC", this.jTextField8.getText().toUpperCase());
/* 1435 */     this.Origen.put("NOMBRE", this.jTextField2.getText().toUpperCase());
/* 1436 */     this.Origen.put("NOMBRECORTO", this.jTextField15.getText().toUpperCase());
/* 1437 */     this.Origen.put("CP", this.jTextField6.getText().toUpperCase());
/* 1438 */     this.Origen.put("CALLE", this.jTextField3.getText().toUpperCase());
/* 1439 */     this.Origen.put("NUM", this.jTextField4.getText().toUpperCase());
/* 1440 */     this.Origen.put("COL", this.jTextField16.getText().toUpperCase());
/* 1441 */     this.Origen.put("CD", this.jTextField7.getText().toUpperCase());
/* 1442 */     this.Origen.put("EDO", this.jTextField20.getText().toUpperCase());
/* 1443 */     this.Origen.put("CLIENTES", this.jTextField21.getText().toUpperCase());
/* 1444 */     this.Origen.put("MONTO", this.jFormattedTextField4.getText());
/* 1445 */     this.Origen.put("CANTIDADLETRA", this.jTextField10.getText().toUpperCase());
/* 1446 */     this.Origen.put("RUTA", this.jTextField12.getText().toUpperCase());
/* 1447 */     this.Origen.put("C_COLONIA", this.jTextField17.getText().toUpperCase());
/* 1448 */     this.Origen.put("C_MUNICIPIO", this.jTextField18.getText().toUpperCase());
/* 1449 */     this.Origen.put("C_ESTADO", this.jTextField19.getText().toUpperCase());
/* 1450 */     this.Origen.put("C_LOCALIDAD", this.jTextField14.getText().toUpperCase());
/* 1451 */     this.Origen.put("LOCALIDAD", this.jTextField15.getText().toUpperCase());
/* 1452 */     this.actualizado = true;
/* 1453 */     setVisible(false);
/*      */   }
/*      */   
/*      */   public void verDatos() {
/* 1457 */     String[] datos = this.con.regresaRegIndex("rfc, empresa, nombreCorto, cp, calle, num, col, ciudad, edo, telefono, monto, letra, semarnat, ruta, lau, bascula, viaje, tons, tipoPago, local, pozo, km, clientes, c_colonia, c_municipio, c_estado, c_localidad, localidad", "emp_destinataria", "where id = '" + this.ID + "'");
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
/* 1469 */     this.jTextField1.setText(this.ID);
/* 1470 */     this.jTextField8.setText(datos[0]);
/* 1471 */     this.jTextField2.setText(datos[1]);
/* 1472 */     this.jTextField15.setText(datos[2]);
/*      */     
/* 1474 */     if (!datos[3].equals("0")) {
/* 1475 */       this.jTextField6.setText(datos[3]);
/*      */     }
/* 1477 */     this.jTextField3.setText(datos[4]);
/* 1478 */     this.jTextField4.setText(datos[5]);
/*      */     
/* 1480 */     this.jTextField16.setText(datos[6]);
/* 1481 */     this.jTextField7.setText(datos[7]);
/* 1482 */     this.jTextField20.setText(datos[8]);
/*      */     
/* 1484 */     this.jFormattedTextField1.setValue(datos[9]);
/* 1485 */     this.jFormattedTextField4.setValue(Double.valueOf(Double.parseDouble(datos[10])));
/* 1486 */     this.jTextField10.setText(datos[11]);
/*      */     
/* 1488 */     this.jTextField11.setText(datos[12]);
/* 1489 */     this.jTextField12.setText(datos[13]);
/* 1490 */     this.jTextField13.setText(datos[14]);
/*      */     
/* 1492 */     this.jTextField14.setText(datos[15]);
/* 1493 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(datos[16])));
/* 1494 */     this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(datos[17])));
/*      */     
/* 1496 */     if (datos[18].equals("1")) {
/* 1497 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 1499 */       this.jRadioButton2.setSelected(true);
/*      */     } 
/* 1501 */     if (datos[19].equals("SI")) {
/* 1502 */       this.jRadioButton3.setSelected(true);
/*      */     } else {
/* 1504 */       this.jRadioButton4.setSelected(true);
/*      */     } 
/* 1506 */     if (datos[20].equals("SI")) {
/* 1507 */       this.jCheckBox1.setSelected(true);
/*      */     } else {
/* 1509 */       this.jCheckBox1.setSelected(false);
/*      */     } 
/*      */     
/* 1512 */     this.jTextField22.setText(datos[21]);
/* 1513 */     this.jTextField21.setText(datos[22]);
/*      */     
/* 1515 */     this.jTextField17.setText(datos[23]);
/* 1516 */     this.jTextField18.setText(datos[24]);
/* 1517 */     this.jTextField19.setText(datos[25]);
/*      */     
/* 1519 */     this.jTextField23.setText(datos[26]);
/* 1520 */     this.jTextField24.setText(datos[27]);
/*      */   }
/*      */ 
/*      */   
/*      */   protected JRootPane createRootPane() {
/* 1525 */     JRootPane rootPane = new JRootPane();
/* 1526 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 1527 */     Action actionListener = new AbstractAction() {
/*      */         public void actionPerformed(ActionEvent actionEvent) {
/* 1529 */           tras_Destinos_Form.this.actualizado = false;
/* 1530 */           tras_Destinos_Form.this.setVisible(false);
/*      */         }
/*      */       };
/* 1533 */     InputMap inputMap = rootPane.getInputMap(2);
/* 1534 */     inputMap.put(stroke, "ESCAPE");
/* 1535 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 1536 */     return rootPane;
/*      */   }
/*      */   
/*      */   public void llenarCodigos() {
/* 1540 */     this.com_ListaCodigos = new TextAutoCompleter(this.jTextField6, this.LISTACODIGOS);
/*      */   }
/*      */   
/*      */   public int dameSucursal() {
/* 1544 */     int num = 0;
/* 1545 */     this.SUCURSAL = this.CAMPOSGENERALES.get("sucursal");
/* 1546 */     if (this.SUCURSAL.equals("CADEREYTA")) {
/* 1547 */       num = 1;
/* 1548 */     } else if (this.SUCURSAL.equals("VERACRUZ")) {
/* 1549 */       num = 2;
/* 1550 */     } else if (this.SUCURSAL.equals("POZA RICA")) {
/* 1551 */       num = 3;
/* 1552 */     } else if (this.SUCURSAL.equals("CARDENAS")) {
/* 1553 */       num = 4;
/*      */     } 
/* 1555 */     return num;
/*      */   }
/*      */   
/*      */   public String dameID(int num) {
/* 1559 */     int id = 0;
/* 1560 */     String clave = "";
/* 1561 */     this.con.consultar("count(clave_desti)", "emp_destinataria", "");
/* 1562 */     if (!this.con.Campo.equals("0")) {
/* 1563 */       this.con.consultar("max(clave_desti)", "emp_destinataria", "");
/* 1564 */       id = Integer.parseInt(this.con.Campo);
/* 1565 */       id++;
/*      */     } else {
/* 1567 */       id = 1;
/*      */     } 
/* 1569 */     if (id < 10) {
/* 1570 */       clave = "" + num + "0000" + num;
/* 1571 */     } else if (id < 100) {
/* 1572 */       clave = "" + num + "000" + num;
/* 1573 */     } else if (id < 1000) {
/* 1574 */       clave = "" + num + "00" + num;
/* 1575 */     } else if (id < 10000) {
/* 1576 */       clave = "" + num + "0" + num;
/*      */     } else {
/* 1578 */       clave = "" + num + num;
/*      */     } 
/* 1580 */     return "DE" + clave;
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 1584 */     this.pintar.colorear(this.jTextField1);
/* 1585 */     this.pintar.colorear(this.jTextField2);
/* 1586 */     this.pintar.colorear(this.jTextField3);
/* 1587 */     this.pintar.colorear(this.jTextField4);
/* 1588 */     this.pintar.colorear(this.jTextField5);
/* 1589 */     this.pintar.colorear(this.jTextField6);
/* 1590 */     this.pintar.colorear(this.jTextField7);
/* 1591 */     this.pintar.colorear(this.jTextField8);
/* 1592 */     this.pintar.colorear(this.jTextField10);
/* 1593 */     this.pintar.colorear(this.jTextField11);
/* 1594 */     this.pintar.colorear(this.jTextField12);
/* 1595 */     this.pintar.colorear(this.jTextField13);
/* 1596 */     this.pintar.colorear(this.jTextField14);
/* 1597 */     this.pintar.colorear(this.jTextField15);
/* 1598 */     this.pintar.colorear(this.jTextField16);
/* 1599 */     this.pintar.colorear(this.jTextField17);
/* 1600 */     this.pintar.colorear(this.jTextField18);
/* 1601 */     this.pintar.colorear(this.jTextField19);
/* 1602 */     this.pintar.colorear(this.jTextField20);
/* 1603 */     this.pintar.colorear(this.jTextField21);
/* 1604 */     this.pintar.colorear(this.jFormattedTextField2);
/* 1605 */     this.pintar.colorear(this.jFormattedTextField3);
/* 1606 */     this.pintar.colorear(this.jTextField22);
/*      */   }
/*      */ 
/*      */   
/*      */   public void limpiar() {
/* 1611 */     this.jTextField1.setText("");
/* 1612 */     this.jTextField2.setText("");
/* 1613 */     this.jTextField3.setText("");
/* 1614 */     this.jTextField4.setText("");
/* 1615 */     this.jTextField5.setText("");
/* 1616 */     this.jTextField6.setText("");
/* 1617 */     this.jTextField7.setText("");
/* 1618 */     this.jTextField8.setText("");
/* 1619 */     this.jTextField10.setText("");
/* 1620 */     this.jTextField11.setText("");
/* 1621 */     this.jTextField12.setText("");
/* 1622 */     this.jTextField13.setText("");
/* 1623 */     this.jTextField14.setText("");
/* 1624 */     this.jTextField15.setText("");
/* 1625 */     this.jTextField16.setText("");
/* 1626 */     this.jTextField17.setText("          ");
/* 1627 */     this.jTextField18.setText("          ");
/* 1628 */     this.jTextField19.setText("          ");
/* 1629 */     this.jTextField20.setText("");
/* 1630 */     this.jTextField23.setText("          ");
/* 1631 */     this.jTextField24.setText("");
/* 1632 */     this.jTextField21.setText("");
/* 1633 */     this.jTextField22.setText("0");
/* 1634 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 1635 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   public void desabilitar() {
/* 1639 */     this.jTextField8.setEnabled(false);
/* 1640 */     this.jTextField2.setEnabled(false);
/* 1641 */     this.jTextField15.setEnabled(false);
/* 1642 */     this.jTextField6.setEnabled(false);
/* 1643 */     this.jTextField3.setEnabled(false);
/* 1644 */     this.jTextField4.setEnabled(false);
/* 1645 */     this.jTextField17.setEnabled(false);
/* 1646 */     this.jTextField16.setEnabled(false);
/* 1647 */     this.jTextField18.setEnabled(false);
/* 1648 */     this.jTextField7.setEnabled(false);
/* 1649 */     this.jTextField19.setEnabled(false);
/* 1650 */     this.jTextField20.setEnabled(false);
/* 1651 */     this.jTextField21.setEnabled(false);
/* 1652 */     this.jTextField4.setEnabled(false);
/* 1653 */     this.jTextField10.setEnabled(false);
/* 1654 */     this.jTextField13.setEnabled(false);
/* 1655 */     this.jTextField14.setEnabled(false);
/* 1656 */     this.jTextField11.setEnabled(false);
/* 1657 */     this.jFormattedTextField1.setEnabled(false);
/* 1658 */     this.jTextField11.setEnabled(false);
/* 1659 */     this.jTextField12.setEnabled(false);
/* 1660 */     this.jFormattedTextField2.setEnabled(false);
/* 1661 */     this.jFormattedTextField3.setEnabled(false);
/* 1662 */     this.jFormattedTextField4.setEnabled(false);
/* 1663 */     this.jRadioButton1.setEnabled(false);
/* 1664 */     this.jRadioButton2.setEnabled(false);
/* 1665 */     this.jRadioButton3.setEnabled(false);
/* 1666 */     this.jRadioButton4.setEnabled(false);
/* 1667 */     this.jCheckBox1.setEnabled(false);
/* 1668 */     this.jTextField22.setEnabled(false);
/* 1669 */     this.jButton1.setEnabled(false);
/* 1670 */     this.jButton2.setEnabled(false);
/* 1671 */     this.jButton3.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void habilitarDir() {
/* 1675 */     String cod = this.jTextField6.getText();
/* 1676 */     if (this.LISTACODIGOS.contains(cod)) {
/* 1677 */       this.jTextField3.setEnabled(true);
/* 1678 */       this.jTextField4.setEnabled(true);
/* 1679 */       this.jButton2.setEnabled(true);
/*      */       
/* 1681 */       Tras_codigos c = ((List<Tras_codigos>)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(cod)).collect(Collectors.toList())).get(0);
/* 1682 */       this.con2.consultar("estado", "tras_estados", "where c_estado = '" + c.getC_estado() + "'");
/* 1683 */       this.jTextField20.setText(this.con2.Campo);
/* 1684 */       ((List)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(cod)).collect(Collectors.toList())).forEach(x -> {
/*      */             this.jTextField18.setText(x.getC_Municipio());
/*      */             
/*      */             this.jTextField7.setText(x.getCiudad());
/*      */           });
/* 1689 */       this.jTextField19.setText(c.getC_estado());
/*      */     } else {
/*      */       
/* 1692 */       this.jTextField3.setEnabled(false);
/* 1693 */       this.jTextField4.setEnabled(false);
/*      */       
/* 1695 */       this.jTextField16.setText("");
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/tras_Destinos_Form.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */