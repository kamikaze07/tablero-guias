/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class TractoAgregar extends JPanel {
/*   22 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   23 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   24 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   25 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   26 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   27 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
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
/*      */   Color fondo;
/*      */   JTable jTable3;
/*   45 */   BusquedaCarros carros = new BusquedaCarros();
/*   46 */   busquedaRem remolque = new busquedaRem();
/*      */   boolean encontrado = false;
/*   48 */   int INDICE = 0;
/*   49 */   Errores error = new Errores(true);
/*   50 */   Validaciones val = new Validaciones();
/*   51 */   Date fecha = null;
/*   52 */   MensajePop mensajeTry = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private ButtonGroup buttonGroup5; private ButtonGroup buttonGroup6; private ButtonGroup buttonGroup7; private ButtonGroup buttonGroup8; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JDateChooser jDateChooser1; private JDateChooser jDateChooser10; private JDateChooser jDateChooser11; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78;
/*      */   public TractoAgregar(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry) {
/*   54 */     this.mensajeTry = mensajeTry;
/*   55 */     String año = "2000";
/*   56 */     String mes = "01";
/*   57 */     String dia = "01";
/*   58 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*   59 */     String strFecha = año + "-" + año + "-" + mes;
/*   60 */     Date fecha = null;
/*      */     try {
/*   62 */       this.formaTel = new MaskFormatter("###-###-####");
/*      */     }
/*   64 */     catch (Exception exception) {}
/*   65 */     this.formaTel.setPlaceholderCharacter('_');
/*   66 */     this.padre = padre;
/*   67 */     initComponents();
/*      */     try {
/*   69 */       fecha = formatoDelTexto.parse(strFecha);
/*   70 */       this.jDateChooser2.setMinSelectableDate(fecha);
/*   71 */       this.jDateChooser5.setMinSelectableDate(fecha);
/*   72 */       this.jDateChooser3.setMinSelectableDate(fecha);
/*   73 */       this.jDateChooser6.setMinSelectableDate(fecha);
/*   74 */       this.jDateChooser4.setMinSelectableDate(fecha);
/*   75 */       this.jDateChooser7.setMinSelectableDate(fecha);
/*   76 */       this.jDateChooser8.setMinSelectableDate(fecha);
/*   77 */       this.jDateChooser9.setMinSelectableDate(fecha);
/*   78 */       this.jDateChooser10.setMinSelectableDate(fecha);
/*   79 */       this.jDateChooser11.setMinSelectableDate(fecha);
/*      */     }
/*   81 */     catch (ParseException ex) {
/*   82 */       ex.printStackTrace();
/*      */     } 
/*   84 */     año = "1990";
/*   85 */     mes = "01";
/*   86 */     dia = "01";
/*   87 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*   88 */     strFecha = año + "-" + año + "-" + mes;
/*   89 */     fecha = null;
/*      */     try {
/*   91 */       fecha = formatoDelTexto.parse(strFecha);
/*   92 */       this.jDateChooser1.setMinSelectableDate(fecha);
/*      */     }
/*   94 */     catch (ParseException ex) {
/*   95 */       ex.printStackTrace();
/*      */     } 
/*      */     
/*   98 */     this.buttonGroup1.add(this.jRadioButton1);
/*   99 */     this.buttonGroup1.add(this.jRadioButton2);
/*  100 */     this.buttonGroup1.add(this.jRadioButton3);
/*  101 */     this.buttonGroup2.add(this.jRadioButton4);
/*  102 */     this.buttonGroup2.add(this.jRadioButton5);
/*  103 */     this.buttonGroup2.add(this.jRadioButton6);
/*  104 */     this.buttonGroup3.add(this.jRadioButton7);
/*  105 */     this.buttonGroup3.add(this.jRadioButton8);
/*  106 */     this.buttonGroup3.add(this.jRadioButton9);
/*  107 */     this.buttonGroup4.add(this.jRadioButton10);
/*  108 */     this.buttonGroup4.add(this.jRadioButton11);
/*  109 */     this.buttonGroup4.add(this.jRadioButton12);
/*  110 */     this.buttonGroup5.add(this.jRadioButton13);
/*  111 */     this.buttonGroup5.add(this.jRadioButton14);
/*  112 */     this.buttonGroup6.add(this.jRadioButton15);
/*  113 */     this.buttonGroup6.add(this.jRadioButton16);
/*  114 */     this.buttonGroup7.add(this.jRadioButton20);
/*  115 */     this.buttonGroup7.add(this.jRadioButton21);
/*  116 */     this.buttonGroup8.add(this.jRadioButton17);
/*  117 */     this.buttonGroup8.add(this.jRadioButton18);
/*      */     
/*  119 */     this.USUARIO = usua;
/*  120 */     this.fichas = fichas;
/*  121 */     this.id = num;
/*  122 */     this.jTable3 = Tabla;
/*      */     try {
/*  124 */       this.formaTel = new MaskFormatter("###-###-####");
/*      */     }
/*  126 */     catch (Exception exception) {}
/*  127 */     this.formaTel.setPlaceholderCharacter('_');
/*  128 */     panelito.setViewportView(this);
/*  129 */     this.panel = panelito;
/*  130 */     colorear();
/*  131 */     this.jLabel14.setVisible(false);
/*  132 */     this.jButton3.setVisible(false);
/*  133 */     this.jButton4.setVisible(false);
/*  134 */     this.jButton14.setVisible(false);
/*  135 */     this.jButton24.setVisible(false);
/*  136 */     this.jButton32.setVisible(false);
/*  137 */     int w = this.tama.width;
/*  138 */     int h = this.tama.height;
/*  139 */     int rw = (w - 425) / 2;
/*  140 */     int rh = (h - 380) / 2;
/*  141 */     this.jDialog1.setVisible(false);
/*  142 */     this.jDialog1.setLocation(rw, rh);
/*  143 */     this.jDialog1.setSize(425, 380);
/*      */     
/*  145 */     rw = (w - 870) / 2;
/*  146 */     rh = (h - 640) / 2;
/*  147 */     this.jDialog2.setVisible(false);
/*  148 */     this.jDialog2.setLocation(rw, rh);
/*  149 */     this.jDialog2.setSize(670, 640);
/*      */     
/*  151 */     rw = (w - 425) / 2;
/*  152 */     rh = (h - 380) / 2;
/*  153 */     this.jDialog3.setVisible(false);
/*  154 */     this.jDialog3.setLocation(rw, rh);
/*  155 */     this.jDialog3.setSize(425, 380);
/*  156 */     consultar1();
/*  157 */     consultar2();
/*  158 */     llenarCombo();
/*  159 */     llenarCombo2();
/*  160 */     llenarCombo3();
/*      */     
/*  162 */     rw = (w - 870) / 2;
/*  163 */     rh = (h - 640) / 2;
/*  164 */     this.jDialog4.setVisible(false);
/*  165 */     this.jDialog4.setLocation(rw, rh);
/*  166 */     this.jDialog4.setSize(670, 640);
/*      */     
/*  168 */     rw = (w - 380) / 2;
/*  169 */     rh = (h - 240) / 2;
/*  170 */     this.jDialog5.setVisible(false);
/*  171 */     this.jDialog5.setLocation(rw, rh);
/*  172 */     this.jDialog5.setSize(390, 360);
/*      */     
/*  174 */     rw = (w - 380) / 2;
/*  175 */     rh = (h - 240) / 2;
/*  176 */     this.jDialog6.setVisible(false);
/*  177 */     this.jDialog6.setLocation(rw, rh);
/*  178 */     this.jDialog6.setSize(390, 360);
/*      */     
/*  180 */     rw = (w - 380) / 2;
/*  181 */     rh = (h - 240) / 2;
/*  182 */     this.jDialog7.setVisible(false);
/*  183 */     this.jDialog7.setLocation(rw, rh);
/*  184 */     this.jDialog7.setSize(390, 360);
/*  185 */     if (fichas != null) {
/*  186 */       fichas.addTab("Modificar Tractos - [Clave: " + this.id + "]", this.panel);
/*  187 */       this.jButton1.setText("Modificar");
/*  188 */       this.jLabel1.setText("Modificar Tractos");
/*  189 */       cargarFormulario();
/*      */     } 
/*      */   }
/*      */   private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JRadioButton jRadioButton1; private JRadioButton jRadioButton10; private JRadioButton jRadioButton11; private JRadioButton jRadioButton12; private JRadioButton jRadioButton13; private JRadioButton jRadioButton14; private JRadioButton jRadioButton15; private JRadioButton jRadioButton16; private JRadioButton jRadioButton17; private JRadioButton jRadioButton18; private JRadioButton jRadioButton19; private JRadioButton jRadioButton2; private JRadioButton jRadioButton20; private JRadioButton jRadioButton21; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JTable jTable1; private JTable jTable2; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea4; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField44; private JTextField jTextField45; private JTextField jTextField46; private JTextField jTextField47; private JTextField jTextField48; private JTextField jTextField49; private JTextField jTextField5; private JTextField jTextField50; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  195 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  196 */     this.jPanel1 = new JPanel();
/*  197 */     this.jLabel8 = new JLabel();
/*  198 */     this.jSeparator1 = new JSeparator();
/*  199 */     this.jPanel18 = new JPanel();
/*  200 */     this.jTextField12 = new JTextField();
/*  201 */     this.jLabel19 = new JLabel();
/*  202 */     this.jButton6 = new JButton();
/*  203 */     this.jPanel19 = new JPanel();
/*  204 */     this.jScrollPane1 = new JScrollPane();
/*  205 */     this.jTable1 = new JTable();
/*  206 */     this.jButton7 = new JButton();
/*  207 */     this.jButton8 = new JButton();
/*  208 */     this.buttonGroup1 = new ButtonGroup();
/*  209 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  210 */     this.jPanel2 = new JPanel();
/*  211 */     this.jLabel9 = new JLabel();
/*  212 */     this.jSeparator2 = new JSeparator();
/*  213 */     this.jPanel24 = new JPanel();
/*  214 */     this.jTextField14 = new JTextField();
/*  215 */     this.jLabel32 = new JLabel();
/*  216 */     this.jLabel33 = new JLabel();
/*  217 */     this.jTextField15 = new JTextField();
/*  218 */     this.jLabel34 = new JLabel();
/*  219 */     this.jTextField16 = new JTextField();
/*  220 */     this.jPanel25 = new JPanel();
/*  221 */     this.jTextField17 = new JTextField();
/*  222 */     this.jLabel35 = new JLabel();
/*  223 */     this.jLabel36 = new JLabel();
/*  224 */     this.jTextField18 = new JTextField();
/*  225 */     this.jLabel37 = new JLabel();
/*  226 */     this.jTextField19 = new JTextField();
/*  227 */     this.jPanel26 = new JPanel();
/*  228 */     this.jTextField20 = new JTextField();
/*  229 */     this.jLabel38 = new JLabel();
/*  230 */     this.jLabel39 = new JLabel();
/*  231 */     this.jTextField21 = new JTextField();
/*  232 */     this.jLabel40 = new JLabel();
/*  233 */     this.jDateChooser2 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  234 */     this.jLabel41 = new JLabel();
/*  235 */     this.jDateChooser5 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  236 */     this.jLabel42 = new JLabel();
/*  237 */     this.jTextField22 = new JTextField();
/*  238 */     this.jScrollPane2 = new JScrollPane();
/*  239 */     this.jTextArea1 = new JTextArea();
/*  240 */     this.jLabel43 = new JLabel();
/*  241 */     this.jLabel53 = new JLabel();
/*  242 */     this.jLabel58 = new JLabel();
/*  243 */     this.jPanel27 = new JPanel();
/*  244 */     this.jTextField23 = new JTextField();
/*  245 */     this.jLabel44 = new JLabel();
/*  246 */     this.jLabel45 = new JLabel();
/*  247 */     this.jTextField24 = new JTextField();
/*  248 */     this.jLabel46 = new JLabel();
/*  249 */     this.jTextField25 = new JTextField();
/*  250 */     this.jLabel47 = new JLabel();
/*  251 */     this.jTextField26 = new JTextField();
/*  252 */     this.jLabel48 = new JLabel();
/*  253 */     this.jTextField27 = new JTextField();
/*  254 */     this.jLabel49 = new JLabel();
/*  255 */     this.jTextField28 = new JTextField();
/*  256 */     this.jLabel50 = new JLabel();
/*  257 */     this.jTextField29 = new JTextField();
/*  258 */     this.jLabel51 = new JLabel();
/*  259 */     this.jComboBox4 = new JComboBox();
/*  260 */     this.jLabel52 = new JLabel();
/*  261 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  262 */     this.jButton11 = new JButton();
/*  263 */     this.jButton12 = new JButton();
/*  264 */     this.jButton13 = new JButton();
/*  265 */     this.jButton14 = new JButton();
/*  266 */     this.buttonGroup2 = new ButtonGroup();
/*  267 */     this.buttonGroup3 = new ButtonGroup();
/*  268 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  269 */     this.jPanel3 = new JPanel();
/*  270 */     this.jLabel10 = new JLabel();
/*  271 */     this.jSeparator3 = new JSeparator();
/*  272 */     this.jPanel28 = new JPanel();
/*  273 */     this.jTextField13 = new JTextField();
/*  274 */     this.jLabel31 = new JLabel();
/*  275 */     this.jButton9 = new JButton();
/*  276 */     this.jPanel29 = new JPanel();
/*  277 */     this.jScrollPane3 = new JScrollPane();
/*  278 */     this.jTable2 = new JTable();
/*  279 */     this.jButton15 = new JButton();
/*  280 */     this.jButton16 = new JButton();
/*  281 */     this.buttonGroup4 = new ButtonGroup();
/*  282 */     this.buttonGroup5 = new ButtonGroup();
/*  283 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  284 */     this.jPanel5 = new JPanel();
/*  285 */     this.jLabel11 = new JLabel();
/*  286 */     this.jSeparator4 = new JSeparator();
/*  287 */     this.jPanel31 = new JPanel();
/*  288 */     this.jTextField34 = new JTextField();
/*  289 */     this.jLabel59 = new JLabel();
/*  290 */     this.jLabel60 = new JLabel();
/*  291 */     this.jTextField35 = new JTextField();
/*  292 */     this.jLabel61 = new JLabel();
/*  293 */     this.jTextField36 = new JTextField();
/*  294 */     this.jPanel32 = new JPanel();
/*  295 */     this.jTextField37 = new JTextField();
/*  296 */     this.jLabel62 = new JLabel();
/*  297 */     this.jLabel63 = new JLabel();
/*  298 */     this.jTextField38 = new JTextField();
/*  299 */     this.jLabel64 = new JLabel();
/*  300 */     this.jTextField39 = new JTextField();
/*  301 */     this.jPanel33 = new JPanel();
/*  302 */     this.jTextField40 = new JTextField();
/*  303 */     this.jLabel65 = new JLabel();
/*  304 */     this.jLabel66 = new JLabel();
/*  305 */     this.jTextField41 = new JTextField();
/*  306 */     this.jLabel67 = new JLabel();
/*  307 */     this.jDateChooser3 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  308 */     this.jLabel68 = new JLabel();
/*  309 */     this.jDateChooser6 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  310 */     this.jLabel69 = new JLabel();
/*  311 */     this.jTextField42 = new JTextField();
/*  312 */     this.jScrollPane4 = new JScrollPane();
/*  313 */     this.jTextArea2 = new JTextArea();
/*  314 */     this.jLabel70 = new JLabel();
/*  315 */     this.jLabel71 = new JLabel();
/*  316 */     this.jLabel72 = new JLabel();
/*  317 */     this.jPanel34 = new JPanel();
/*  318 */     this.jTextField43 = new JTextField();
/*  319 */     this.jLabel73 = new JLabel();
/*  320 */     this.jLabel74 = new JLabel();
/*  321 */     this.jTextField44 = new JTextField();
/*  322 */     this.jLabel75 = new JLabel();
/*  323 */     this.jTextField45 = new JTextField();
/*  324 */     this.jLabel76 = new JLabel();
/*  325 */     this.jTextField46 = new JTextField();
/*  326 */     this.jLabel77 = new JLabel();
/*  327 */     this.jTextField47 = new JTextField();
/*  328 */     this.jLabel78 = new JLabel();
/*  329 */     this.jTextField48 = new JTextField();
/*  330 */     this.jLabel79 = new JLabel();
/*  331 */     this.jTextField49 = new JTextField();
/*  332 */     this.jLabel80 = new JLabel();
/*  333 */     this.jComboBox6 = new JComboBox();
/*  334 */     this.jLabel81 = new JLabel();
/*  335 */     this.jFormattedTextField2 = new JFormattedTextField(this.formaTel);
/*  336 */     this.jButton17 = new JButton();
/*  337 */     this.jButton18 = new JButton();
/*  338 */     this.jButton19 = new JButton();
/*  339 */     this.jButton20 = new JButton();
/*  340 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  341 */     this.jPanel6 = new JPanel();
/*  342 */     this.jLabel82 = new JLabel();
/*  343 */     this.jSeparator5 = new JSeparator();
/*  344 */     this.jLabel83 = new JLabel();
/*  345 */     this.jRadioButton13 = new JRadioButton();
/*  346 */     this.jRadioButton14 = new JRadioButton();
/*  347 */     this.jDateChooser4 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  348 */     this.jLabel85 = new JLabel();
/*  349 */     this.jLabel84 = new JLabel();
/*  350 */     this.jDateChooser7 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  351 */     this.jLabel86 = new JLabel();
/*  352 */     this.jScrollPane5 = new JScrollPane();
/*  353 */     this.jTextArea3 = new JTextArea();
/*  354 */     this.jButton21 = new JButton();
/*  355 */     this.jButton22 = new JButton();
/*  356 */     this.jButton23 = new JButton();
/*  357 */     this.jButton24 = new JButton();
/*  358 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  359 */     this.jPanel7 = new JPanel();
/*  360 */     this.jLabel87 = new JLabel();
/*  361 */     this.jSeparator6 = new JSeparator();
/*  362 */     this.jLabel88 = new JLabel();
/*  363 */     this.jRadioButton15 = new JRadioButton();
/*  364 */     this.jRadioButton16 = new JRadioButton();
/*  365 */     this.jDateChooser8 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  366 */     this.jLabel89 = new JLabel();
/*  367 */     this.jLabel90 = new JLabel();
/*  368 */     this.jDateChooser9 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  369 */     this.jLabel91 = new JLabel();
/*  370 */     this.jScrollPane6 = new JScrollPane();
/*  371 */     this.jTextArea4 = new JTextArea();
/*  372 */     this.jButton25 = new JButton();
/*  373 */     this.jButton26 = new JButton();
/*  374 */     this.jButton27 = new JButton();
/*  375 */     this.jButton28 = new JButton();
/*  376 */     this.buttonGroup6 = new ButtonGroup();
/*  377 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  378 */     this.jPanel8 = new JPanel();
/*  379 */     this.jLabel93 = new JLabel();
/*  380 */     this.jSeparator7 = new JSeparator();
/*  381 */     this.jLabel94 = new JLabel();
/*  382 */     this.jRadioButton20 = new JRadioButton();
/*  383 */     this.jRadioButton21 = new JRadioButton();
/*  384 */     this.jDateChooser10 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  385 */     this.jLabel95 = new JLabel();
/*  386 */     this.jLabel96 = new JLabel();
/*  387 */     this.jDateChooser11 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  388 */     this.jLabel97 = new JLabel();
/*  389 */     this.jScrollPane7 = new JScrollPane();
/*  390 */     this.jTextArea5 = new JTextArea();
/*  391 */     this.jButton29 = new JButton();
/*  392 */     this.jButton30 = new JButton();
/*  393 */     this.jButton31 = new JButton();
/*  394 */     this.jButton32 = new JButton();
/*  395 */     this.buttonGroup7 = new ButtonGroup();
/*  396 */     this.buttonGroup8 = new ButtonGroup();
/*  397 */     this.jPanel4 = new JPanel();
/*  398 */     this.jLabel1 = new JLabel();
/*  399 */     this.jButton1 = new JButton();
/*  400 */     this.jButton2 = new JButton();
/*  401 */     this.jLabel14 = new JLabel();
/*  402 */     this.jButton3 = new JButton();
/*  403 */     this.jButton4 = new JButton();
/*  404 */     this.jPanel17 = new JPanel();
/*  405 */     this.jLabel12 = new JLabel();
/*  406 */     this.jComboBox2 = new JComboBox();
/*  407 */     this.jButton5 = new JButton();
/*  408 */     this.jLabel16 = new JLabel();
/*  409 */     this.jLabel17 = new JLabel();
/*  410 */     this.jTextField4 = new JTextField();
/*  411 */     this.jLabel21 = new JLabel();
/*  412 */     this.jTextField5 = new JTextField();
/*  413 */     this.jComboBox7 = new JComboBox();
/*  414 */     this.jLabel28 = new JLabel();
/*  415 */     this.jTextField7 = new JTextField();
/*  416 */     this.jPanel20 = new JPanel();
/*  417 */     this.jLabel13 = new JLabel();
/*  418 */     this.jTextField1 = new JTextField();
/*  419 */     this.jLabel15 = new JLabel();
/*  420 */     this.jTextField2 = new JTextField();
/*  421 */     this.jLabel20 = new JLabel();
/*  422 */     this.jComboBox1 = new JComboBox();
/*  423 */     this.jButton10 = new JButton();
/*  424 */     this.jLabel55 = new JLabel();
/*  425 */     this.jComboBox5 = new JComboBox();
/*  426 */     this.jPanel21 = new JPanel();
/*  427 */     this.jLabel18 = new JLabel();
/*  428 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  429 */     this.jLabel22 = new JLabel();
/*  430 */     this.jTextField6 = new JTextField();
/*  431 */     this.jLabel23 = new JLabel();
/*  432 */     this.jComboBox3 = new JComboBox();
/*  433 */     this.jPanel22 = new JPanel();
/*  434 */     this.jLabel24 = new JLabel();
/*  435 */     this.jLabel25 = new JLabel();
/*  436 */     this.jTextField10 = new JTextField();
/*  437 */     this.jLabel26 = new JLabel();
/*  438 */     this.jTextField11 = new JTextField();
/*  439 */     this.jTextField9 = new JTextField();
/*  440 */     this.jLabel57 = new JLabel();
/*  441 */     this.jPanel23 = new JPanel();
/*  442 */     this.jLabel27 = new JLabel();
/*  443 */     this.jRadioButton1 = new JRadioButton();
/*  444 */     this.jRadioButton2 = new JRadioButton();
/*  445 */     this.jRadioButton3 = new JRadioButton();
/*  446 */     this.jLabel54 = new JLabel();
/*  447 */     this.jRadioButton7 = new JRadioButton();
/*  448 */     this.jRadioButton8 = new JRadioButton();
/*  449 */     this.jRadioButton9 = new JRadioButton();
/*  450 */     this.jTextField30 = new JTextField();
/*  451 */     this.jTextField31 = new JTextField();
/*  452 */     this.jLabel92 = new JLabel();
/*  453 */     this.jRadioButton17 = new JRadioButton();
/*  454 */     this.jTextField50 = new JTextField();
/*  455 */     this.jRadioButton18 = new JRadioButton();
/*  456 */     this.jRadioButton19 = new JRadioButton();
/*  457 */     this.jPanel30 = new JPanel();
/*  458 */     this.jLabel30 = new JLabel();
/*  459 */     this.jRadioButton4 = new JRadioButton();
/*  460 */     this.jRadioButton5 = new JRadioButton();
/*  461 */     this.jRadioButton6 = new JRadioButton();
/*  462 */     this.jLabel56 = new JLabel();
/*  463 */     this.jRadioButton10 = new JRadioButton();
/*  464 */     this.jRadioButton11 = new JRadioButton();
/*  465 */     this.jRadioButton12 = new JRadioButton();
/*  466 */     this.jTextField32 = new JTextField();
/*  467 */     this.jTextField33 = new JTextField();
/*      */     
/*  469 */     this.jDialog1.setTitle("Organizar Marcas");
/*  470 */     this.jDialog1.setModal(true);
/*  471 */     this.jDialog1.setResizable(false);
/*      */     
/*  473 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*      */     
/*  475 */     this.jLabel8.setFont(new Font("Tahoma", 1, 14));
/*  476 */     this.jLabel8.setForeground(new Color(0, 102, 102));
/*  477 */     this.jLabel8.setHorizontalAlignment(0);
/*  478 */     this.jLabel8.setText("Organizar Marcas");
/*      */     
/*  480 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/*  481 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, " Agregar Marca ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  483 */     this.jTextField12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  485 */             TractoAgregar.this.jTextField12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  489 */     this.jLabel19.setFont(new Font("Tahoma", 3, 11));
/*  490 */     this.jLabel19.setForeground(new Color(15, 87, 51));
/*  491 */     this.jLabel19.setHorizontalAlignment(4);
/*  492 */     this.jLabel19.setText("Marca");
/*      */     
/*  494 */     this.jButton6.setMnemonic('A');
/*  495 */     this.jButton6.setText("Agregar");
/*  496 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/*  497 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  499 */             TractoAgregar.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  503 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  504 */     this.jPanel18.setLayout(jPanel18Layout);
/*  505 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  507 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  508 */           .addContainerGap()
/*  509 */           .addComponent(this.jLabel19, -2, 65, -2)
/*  510 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  511 */           .addComponent(this.jTextField12, -2, 197, -2)
/*  512 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  513 */           .addComponent(this.jButton6)
/*  514 */           .addContainerGap(12, 32767)));
/*      */     
/*  516 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  517 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  518 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  519 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  520 */             .addComponent(this.jLabel19)
/*  521 */             .addComponent(this.jTextField12, -2, -1, -2)
/*  522 */             .addComponent(this.jButton6))
/*  523 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  526 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*  527 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder(null, " Eliminar Marcas ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  529 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Marca" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  537 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  542 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  545 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  546 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  547 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/*  548 */       this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
/*  549 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     } 
/*      */     
/*  552 */     this.jButton7.setMnemonic('E');
/*  553 */     this.jButton7.setText("Eliminar");
/*  554 */     this.jButton7.setToolTipText("Eliminar (Alt+E)");
/*  555 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  557 */             TractoAgregar.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  561 */     this.jButton8.setMnemonic('C');
/*  562 */     this.jButton8.setText("Cerrar");
/*  563 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/*  564 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  566 */             TractoAgregar.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  570 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  571 */     this.jPanel19.setLayout(jPanel19Layout);
/*  572 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  573 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  574 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  575 */           .addContainerGap()
/*  576 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  577 */             .addComponent(this.jScrollPane1, -1, 351, 32767)
/*  578 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/*  579 */               .addComponent(this.jButton8)
/*  580 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  581 */               .addComponent(this.jButton7)))
/*  582 */           .addContainerGap()));
/*      */     
/*  584 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  585 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  586 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  587 */           .addComponent(this.jScrollPane1, -2, 156, -2)
/*  588 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  589 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  590 */             .addComponent(this.jButton7)
/*  591 */             .addComponent(this.jButton8))
/*  592 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  595 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  596 */     this.jPanel1.setLayout(jPanel1Layout);
/*  597 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  598 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  600 */           .addContainerGap()
/*  601 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  602 */             .addComponent(this.jPanel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  603 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  604 */               .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/*  605 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  606 */               .addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -1, 381, 32767)))
/*  607 */           .addContainerGap(18, 32767)));
/*      */     
/*  609 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  610 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  611 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  612 */           .addContainerGap()
/*  613 */           .addComponent(this.jLabel8)
/*  614 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  615 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  616 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  617 */           .addComponent(this.jPanel18, -2, -1, -2)
/*  618 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  619 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  620 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  623 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  624 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  625 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  626 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  627 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  629 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  630 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  631 */         .addComponent(this.jPanel1, -2, -1, -2));
/*      */ 
/*      */     
/*  634 */     this.jDialog2.setTitle("Datos de la Póliza");
/*  635 */     this.jDialog2.setModal(true);
/*  636 */     this.jDialog2.setResizable(false);
/*  637 */     this.jDialog2.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  639 */             TractoAgregar.this.jDialog2WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  643 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/*      */     
/*  645 */     this.jLabel9.setFont(new Font("Tahoma", 1, 14));
/*  646 */     this.jLabel9.setForeground(new Color(0, 102, 102));
/*  647 */     this.jLabel9.setHorizontalAlignment(0);
/*  648 */     this.jLabel9.setText("Información del Seguro Vehicular");
/*      */     
/*  650 */     this.jPanel24.setBackground(new Color(146, 193, 134));
/*  651 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder(null, "A nombre de ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  653 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/*  654 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  655 */     this.jLabel32.setHorizontalAlignment(4);
/*  656 */     this.jLabel32.setText("Nombre");
/*      */     
/*  658 */     this.jLabel33.setFont(new Font("Tahoma", 3, 11));
/*  659 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/*  660 */     this.jLabel33.setHorizontalAlignment(0);
/*  661 */     this.jLabel33.setText("Apellido Paterno");
/*      */     
/*  663 */     this.jLabel34.setFont(new Font("Tahoma", 2, 11));
/*  664 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/*  665 */     this.jLabel34.setHorizontalAlignment(4);
/*  666 */     this.jLabel34.setText("Apellido Paterno");
/*      */     
/*  668 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  669 */     this.jPanel24.setLayout(jPanel24Layout);
/*  670 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  671 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  672 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/*  673 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  674 */             .addGroup(jPanel24Layout.createSequentialGroup()
/*  675 */               .addContainerGap()
/*  676 */               .addComponent(this.jLabel32, -2, 87, -2)
/*  677 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  678 */               .addComponent(this.jTextField14, -1, 178, 32767))
/*  679 */             .addGroup(jPanel24Layout.createSequentialGroup()
/*  680 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  681 */                 .addComponent(this.jLabel34, -1, 99, 32767)
/*  682 */                 .addComponent(this.jLabel33, -2, 99, 32767))
/*  683 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  684 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  685 */                 .addComponent(this.jTextField15)
/*  686 */                 .addComponent(this.jTextField16, -1, 176, 32767))))
/*  687 */           .addContainerGap()));
/*      */     
/*  689 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  691 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  692 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  693 */             .addComponent(this.jLabel32)
/*  694 */             .addComponent(this.jTextField14, -2, -1, -2))
/*  695 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  696 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  697 */             .addComponent(this.jLabel33)
/*  698 */             .addComponent(this.jTextField15, -2, -1, -2))
/*  699 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  700 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  701 */             .addComponent(this.jLabel34)
/*  702 */             .addComponent(this.jTextField16, -2, -1, -2))
/*  703 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  706 */     this.jPanel25.setBackground(new Color(146, 193, 134));
/*  707 */     this.jPanel25.setBorder(BorderFactory.createTitledBorder(null, " Beneficiario ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  709 */     this.jLabel35.setFont(new Font("Tahoma", 3, 11));
/*  710 */     this.jLabel35.setForeground(new Color(15, 87, 51));
/*  711 */     this.jLabel35.setHorizontalAlignment(4);
/*  712 */     this.jLabel35.setText("Nombre");
/*      */     
/*  714 */     this.jLabel36.setFont(new Font("Tahoma", 3, 11));
/*  715 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/*  716 */     this.jLabel36.setHorizontalAlignment(0);
/*  717 */     this.jLabel36.setText("Apellido Paterno");
/*      */     
/*  719 */     this.jLabel37.setFont(new Font("Tahoma", 2, 11));
/*  720 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*  721 */     this.jLabel37.setHorizontalAlignment(4);
/*  722 */     this.jLabel37.setText("Apellido Paterno");
/*      */     
/*  724 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  725 */     this.jPanel25.setLayout(jPanel25Layout);
/*  726 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  727 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  728 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
/*  729 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  730 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  731 */               .addContainerGap()
/*  732 */               .addComponent(this.jLabel35, -2, 87, -2)
/*  733 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/*  734 */             .addComponent(this.jLabel36, -2, 100, 32767)
/*  735 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  736 */               .addComponent(this.jLabel37, -2, 94, -2)
/*  737 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/*  738 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  739 */             .addComponent(this.jTextField18, -1, 179, 32767)
/*  740 */             .addComponent(this.jTextField17, GroupLayout.Alignment.LEADING, -1, 179, 32767)
/*  741 */             .addComponent(this.jTextField19, -1, 179, 32767))
/*  742 */           .addContainerGap()));
/*      */     
/*  744 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  745 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  746 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  747 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  748 */             .addComponent(this.jLabel35)
/*  749 */             .addComponent(this.jTextField17, -2, -1, -2))
/*  750 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  751 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  752 */             .addComponent(this.jLabel36)
/*  753 */             .addComponent(this.jTextField18, -2, -1, -2))
/*  754 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  755 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  756 */             .addComponent(this.jTextField19, -2, -1, -2)
/*  757 */             .addComponent(this.jLabel37))
/*  758 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  761 */     this.jPanel26.setBackground(new Color(146, 193, 134));
/*  762 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Póliza ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  764 */     this.jLabel38.setFont(new Font("Tahoma", 3, 11));
/*  765 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  766 */     this.jLabel38.setHorizontalAlignment(4);
/*  767 */     this.jLabel38.setText("Tipo de Seguro");
/*      */     
/*  769 */     this.jLabel39.setFont(new Font("Tahoma", 3, 11));
/*  770 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*  771 */     this.jLabel39.setHorizontalAlignment(4);
/*  772 */     this.jLabel39.setText("Costo");
/*      */     
/*  774 */     this.jLabel40.setFont(new Font("Tahoma", 3, 11));
/*  775 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/*  776 */     this.jLabel40.setHorizontalAlignment(4);
/*  777 */     this.jLabel40.setText("Fecha de Inicio");
/*      */     
/*  779 */     this.jDateChooser2.setDate(this.fechaActual);
/*  780 */     this.jDateChooser2.setDateFormatString("yyyy/MM/dd");
/*  781 */     this.jDateChooser2.setIcon(this.icon);
/*  782 */     this.jDateChooser2.setMaxSelectableDate(this.fecha);
/*  783 */     this.jDateChooser2.setMinSelectableDate(this.fechaActual);
/*      */     
/*  785 */     this.jLabel41.setFont(new Font("Tahoma", 3, 11));
/*  786 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/*  787 */     this.jLabel41.setHorizontalAlignment(4);
/*  788 */     this.jLabel41.setText("F. de Vigencia");
/*      */     
/*  790 */     this.jDateChooser5.setDate(this.fechaActual);
/*  791 */     this.jDateChooser5.setDateFormatString("yyyy/MM/dd");
/*  792 */     this.jDateChooser5.setIcon(this.icon);
/*  793 */     this.jDateChooser5.setMaxSelectableDate(this.fecha);
/*  794 */     this.jDateChooser5.setMinSelectableDate(this.fechaActual);
/*      */     
/*  796 */     this.jLabel42.setFont(new Font("Tahoma", 3, 11));
/*  797 */     this.jLabel42.setForeground(new Color(15, 87, 51));
/*  798 */     this.jLabel42.setHorizontalAlignment(4);
/*  799 */     this.jLabel42.setText("T. de Gracia");
/*      */     
/*  801 */     this.jTextArea1.setColumns(20);
/*  802 */     this.jTextArea1.setRows(5);
/*  803 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/*  805 */     this.jLabel43.setFont(new Font("Tahoma", 2, 11));
/*  806 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/*  807 */     this.jLabel43.setHorizontalAlignment(0);
/*  808 */     this.jLabel43.setText("Coberturas");
/*      */     
/*  810 */     this.jLabel53.setFont(new Font("Tahoma", 2, 11));
/*  811 */     this.jLabel53.setForeground(new Color(15, 87, 51));
/*  812 */     this.jLabel53.setText("Meses");
/*      */     
/*  814 */     this.jLabel58.setFont(new Font("Tahoma", 2, 11));
/*  815 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/*  816 */     this.jLabel58.setText("Pesos");
/*      */     
/*  818 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  819 */     this.jPanel26.setLayout(jPanel26Layout);
/*  820 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  821 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  822 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  823 */           .addContainerGap()
/*  824 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  825 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  826 */               .addComponent(this.jLabel38, -2, 87, -2)
/*  827 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  828 */               .addComponent(this.jTextField20, -2, 208, -2))
/*  829 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  830 */               .addComponent(this.jLabel41, -2, 87, -2)
/*  831 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  832 */               .addComponent((Component)this.jDateChooser5, -1, -1, 32767))
/*  833 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  834 */               .addComponent(this.jLabel42, -2, 87, -2)
/*  835 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  836 */               .addComponent(this.jTextField22, -2, 96, -2)
/*  837 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  838 */               .addComponent(this.jLabel53, -2, 87, -2))
/*  839 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  840 */               .addComponent(this.jLabel40, -2, 87, -2)
/*  841 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  842 */               .addComponent((Component)this.jDateChooser2, -1, -1, 32767))
/*  843 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  844 */               .addComponent(this.jLabel39, -2, 87, -2)
/*  845 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  846 */               .addComponent(this.jTextField21, -2, 92, -2)
/*  847 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  848 */               .addComponent(this.jLabel58, -2, 87, -2)))
/*  849 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  850 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  851 */             .addComponent(this.jLabel43, -1, -1, 32767)
/*  852 */             .addComponent(this.jScrollPane2, -1, 271, 32767))
/*  853 */           .addContainerGap(-1, 32767)));
/*      */     
/*  855 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  857 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  858 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  859 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  860 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  861 */                 .addComponent(this.jLabel38)
/*  862 */                 .addComponent(this.jTextField20, -2, -1, -2)
/*  863 */                 .addComponent(this.jLabel43))
/*  864 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  865 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  866 */                 .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  867 */                   .addComponent(this.jLabel39)
/*  868 */                   .addComponent(this.jTextField21, -2, -1, -2))
/*  869 */                 .addComponent(this.jLabel58))
/*  870 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  871 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  872 */                 .addComponent((Component)this.jDateChooser2, -1, -1, 32767)
/*  873 */                 .addComponent(this.jLabel40))
/*  874 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  875 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  876 */                 .addComponent(this.jLabel41)
/*  877 */                 .addComponent((Component)this.jDateChooser5, -2, -1, -2))
/*  878 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  879 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  880 */                 .addComponent(this.jLabel42)
/*  881 */                 .addComponent(this.jTextField22, -2, -1, -2)
/*  882 */                 .addComponent(this.jLabel53)))
/*  883 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  884 */               .addGap(28, 28, 28)
/*  885 */               .addComponent(this.jScrollPane2, -2, -1, -2)))
/*  886 */           .addContainerGap()));
/*      */ 
/*      */     
/*  889 */     this.jPanel27.setBackground(new Color(146, 193, 134));
/*  890 */     this.jPanel27.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Aseguradora ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  892 */     this.jLabel44.setFont(new Font("Tahoma", 3, 11));
/*  893 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/*  894 */     this.jLabel44.setHorizontalAlignment(4);
/*  895 */     this.jLabel44.setText("Aseguradora");
/*      */     
/*  897 */     this.jLabel45.setFont(new Font("Tahoma", 3, 11));
/*  898 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/*  899 */     this.jLabel45.setHorizontalAlignment(4);
/*  900 */     this.jLabel45.setText("Nombre del Agente");
/*      */     
/*  902 */     this.jLabel46.setFont(new Font("Tahoma", 2, 11));
/*  903 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/*  904 */     this.jLabel46.setHorizontalAlignment(4);
/*  905 */     this.jLabel46.setText("Calle");
/*      */     
/*  907 */     this.jLabel47.setFont(new Font("Tahoma", 2, 11));
/*  908 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/*  909 */     this.jLabel47.setHorizontalAlignment(4);
/*  910 */     this.jLabel47.setText("Num.");
/*      */     
/*  912 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/*  913 */     this.jLabel48.setForeground(new Color(15, 87, 51));
/*  914 */     this.jLabel48.setHorizontalAlignment(4);
/*  915 */     this.jLabel48.setText("Colonia");
/*      */     
/*  917 */     this.jLabel49.setFont(new Font("Tahoma", 2, 11));
/*  918 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/*  919 */     this.jLabel49.setHorizontalAlignment(4);
/*  920 */     this.jLabel49.setText("Ciudad");
/*      */     
/*  922 */     this.jLabel50.setFont(new Font("Tahoma", 2, 11));
/*  923 */     this.jLabel50.setForeground(new Color(15, 87, 51));
/*  924 */     this.jLabel50.setHorizontalAlignment(4);
/*  925 */     this.jLabel50.setText("c.p.");
/*      */     
/*  927 */     this.jLabel51.setFont(new Font("Tahoma", 2, 11));
/*  928 */     this.jLabel51.setForeground(new Color(15, 87, 51));
/*  929 */     this.jLabel51.setHorizontalAlignment(4);
/*  930 */     this.jLabel51.setText("Estado");
/*      */     
/*  932 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  933 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/*  934 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  936 */             TractoAgregar.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  940 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/*  941 */     this.jLabel52.setForeground(new Color(15, 87, 51));
/*  942 */     this.jLabel52.setHorizontalAlignment(4);
/*  943 */     this.jLabel52.setText("Teléfono");
/*      */     
/*  945 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  947 */             TractoAgregar.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  951 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  952 */     this.jPanel27.setLayout(jPanel27Layout);
/*  953 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  955 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  956 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  957 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  958 */               .addGap(10, 10, 10)
/*  959 */               .addComponent(this.jLabel52, -1, 110, 32767))
/*  960 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  961 */               .addContainerGap()
/*  962 */               .addComponent(this.jLabel49, -1, 110, 32767))
/*  963 */             .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  964 */               .addComponent(this.jLabel46, -1, -1, 32767)
/*  965 */               .addComponent(this.jLabel45, -1, -1, 32767)
/*  966 */               .addGroup(jPanel27Layout.createSequentialGroup()
/*  967 */                 .addGap(10, 10, 10)
/*  968 */                 .addComponent(this.jLabel44, -1, 110, 32767))))
/*  969 */           .addGap(16, 16, 16)
/*  970 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  971 */             .addComponent(this.jFormattedTextField1, GroupLayout.Alignment.LEADING, -2, 154, -2)
/*  972 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  973 */               .addComponent(this.jTextField25, -2, 154, -2)
/*  974 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  975 */               .addComponent(this.jLabel47, -2, 41, -2)
/*  976 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  977 */               .addComponent(this.jTextField26, -2, 47, -2)
/*  978 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  979 */               .addComponent(this.jLabel48, -2, 47, -2)
/*  980 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  981 */               .addComponent(this.jTextField27, -1, 145, 32767))
/*  982 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
/*  983 */               .addComponent(this.jTextField28, -2, 154, -2)
/*  984 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  985 */               .addComponent(this.jLabel50, -2, 41, -2)
/*  986 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */               .addComponent(this.jTextField29, -2, 47, -2)
/*  988 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */               .addComponent(this.jLabel51, -2, 47, -2)
/*  990 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  991 */               .addComponent(this.jComboBox4, 0, 145, 32767))
/*  992 */             .addComponent(this.jTextField24, GroupLayout.Alignment.LEADING, -1, 450, 32767)
/*  993 */             .addComponent(this.jTextField23, -1, 450, 32767))
/*  994 */           .addContainerGap()));
/*      */     
/*  996 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  997 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  998 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  999 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1000 */             .addComponent(this.jLabel44)
/* 1001 */             .addComponent(this.jTextField23, -2, -1, -2))
/* 1002 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1003 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1004 */             .addComponent(this.jLabel45)
/* 1005 */             .addComponent(this.jTextField24, -2, -1, -2))
/* 1006 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1007 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1008 */             .addComponent(this.jLabel46)
/* 1009 */             .addComponent(this.jTextField25, -2, -1, -2)
/* 1010 */             .addComponent(this.jLabel48)
/* 1011 */             .addComponent(this.jLabel47)
/* 1012 */             .addComponent(this.jTextField26, -2, -1, -2)
/* 1013 */             .addComponent(this.jTextField27, -2, -1, -2))
/* 1014 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1015 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1016 */             .addComponent(this.jLabel49)
/* 1017 */             .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1018 */               .addComponent(this.jTextField28, -2, -1, -2)
/* 1019 */               .addComponent(this.jLabel50)
/* 1020 */               .addComponent(this.jTextField29, -2, -1, -2)
/* 1021 */               .addComponent(this.jLabel51)
/* 1022 */               .addComponent(this.jComboBox4, -2, -1, -2)))
/* 1023 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1024 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1025 */             .addComponent(this.jFormattedTextField1, -2, -1, -2)
/* 1026 */             .addComponent(this.jLabel52))
/* 1027 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1030 */     this.jButton11.setMnemonic('C');
/* 1031 */     this.jButton11.setText("Cerrar");
/* 1032 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/* 1033 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1035 */             TractoAgregar.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1039 */     this.jButton12.setMnemonic('L');
/* 1040 */     this.jButton12.setText("Limpiar");
/* 1041 */     this.jButton12.setToolTipText("Limpiar (Alt+L)");
/* 1042 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1044 */             TractoAgregar.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1048 */     this.jButton13.setMnemonic('G');
/* 1049 */     this.jButton13.setText("Guardar");
/* 1050 */     this.jButton13.setToolTipText("Guardar (Alt+G)");
/* 1051 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1053 */             TractoAgregar.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1057 */     this.jButton14.setMnemonic('R');
/* 1058 */     this.jButton14.setText("Restablecer");
/* 1059 */     this.jButton14.setToolTipText("Restablecer (Alt+R)");
/* 1060 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1062 */             TractoAgregar.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1066 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1067 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1068 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1069 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1070 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1071 */           .addContainerGap()
/* 1072 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1073 */             .addComponent(this.jSeparator2, GroupLayout.Alignment.LEADING)
/* 1074 */             .addComponent(this.jPanel27, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 1075 */             .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1076 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
/* 1077 */               .addComponent(this.jPanel24, -2, -1, -2)
/* 1078 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1079 */               .addComponent(this.jPanel25, -1, -1, 32767))
/* 1080 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1081 */               .addComponent(this.jButton14, -2, 104, -2)
/* 1082 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1083 */               .addComponent(this.jButton13, -2, 93, -2)
/* 1084 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1085 */               .addComponent(this.jButton12, -2, 93, -2)
/* 1086 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1087 */               .addComponent(this.jButton11, -2, 93, -2))
/* 1088 */             .addComponent(this.jLabel9, GroupLayout.Alignment.LEADING, -1, 602, 32767))
/* 1089 */           .addContainerGap(20, 32767)));
/*      */     
/* 1091 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1092 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1093 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1094 */           .addContainerGap()
/* 1095 */           .addComponent(this.jLabel9)
/* 1096 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1097 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1098 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1099 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 1101 */             .addComponent(this.jPanel25, -2, -1, -2))
/* 1102 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1103 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 1104 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1105 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1106 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1107 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1108 */             .addComponent(this.jButton11)
/* 1109 */             .addComponent(this.jButton12)
/* 1110 */             .addComponent(this.jButton13)
/* 1111 */             .addComponent(this.jButton14))
/* 1112 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1115 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1116 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1117 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1119 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 1121 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1122 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1123 */         .addComponent(this.jPanel2, -2, -1, -2));
/*      */ 
/*      */     
/* 1126 */     this.jDialog3.setTitle("Organizar Tipos");
/* 1127 */     this.jDialog3.setModal(true);
/* 1128 */     this.jDialog3.setResizable(false);
/*      */     
/* 1130 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/*      */     
/* 1132 */     this.jLabel10.setFont(new Font("Tahoma", 1, 14));
/* 1133 */     this.jLabel10.setForeground(new Color(0, 102, 102));
/* 1134 */     this.jLabel10.setHorizontalAlignment(0);
/* 1135 */     this.jLabel10.setText("Organizar Tipos");
/*      */     
/* 1137 */     this.jPanel28.setBackground(new Color(146, 193, 134));
/* 1138 */     this.jPanel28.setBorder(BorderFactory.createTitledBorder(null, " Agregar Tipo ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1140 */     this.jTextField13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1142 */             TractoAgregar.this.jTextField13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1146 */     this.jLabel31.setFont(new Font("Tahoma", 3, 11));
/* 1147 */     this.jLabel31.setForeground(new Color(15, 87, 51));
/* 1148 */     this.jLabel31.setHorizontalAlignment(4);
/* 1149 */     this.jLabel31.setText("Tipo");
/*      */     
/* 1151 */     this.jButton9.setMnemonic('A');
/* 1152 */     this.jButton9.setText("Agregar");
/* 1153 */     this.jButton9.setToolTipText("Agregar (Alt+A)");
/* 1154 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1156 */             TractoAgregar.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1160 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 1161 */     this.jPanel28.setLayout(jPanel28Layout);
/* 1162 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 1163 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1164 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 1165 */           .addContainerGap()
/* 1166 */           .addComponent(this.jLabel31, -2, 65, -2)
/* 1167 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1168 */           .addComponent(this.jTextField13, -2, 197, -2)
/* 1169 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1170 */           .addComponent(this.jButton9)
/* 1171 */           .addContainerGap(12, 32767)));
/*      */     
/* 1173 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 1174 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 1176 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1177 */             .addComponent(this.jLabel31)
/* 1178 */             .addComponent(this.jTextField13, -2, -1, -2)
/* 1179 */             .addComponent(this.jButton9))
/* 1180 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1183 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/* 1184 */     this.jPanel29.setBorder(BorderFactory.createTitledBorder(null, " Eliminar Tipos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1186 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Tipos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1194 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1199 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1202 */     this.jScrollPane3.setViewportView(this.jTable2);
/* 1203 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 1204 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(40);
/* 1205 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 1206 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     } 
/*      */     
/* 1209 */     this.jButton15.setMnemonic('E');
/* 1210 */     this.jButton15.setText("Eliminar");
/* 1211 */     this.jButton15.setToolTipText("Eliminar (Alt+E)");
/* 1212 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1214 */             TractoAgregar.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1218 */     this.jButton16.setMnemonic('C');
/* 1219 */     this.jButton16.setText("Cerrar");
/* 1220 */     this.jButton16.setToolTipText("Cerrar (Alt+C)");
/* 1221 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1223 */             TractoAgregar.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1227 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1228 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1229 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1230 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1231 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1232 */           .addContainerGap()
/* 1233 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1234 */             .addComponent(this.jScrollPane3, -1, 351, 32767)
/* 1235 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1236 */               .addComponent(this.jButton16)
/* 1237 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1238 */               .addComponent(this.jButton15)))
/* 1239 */           .addContainerGap()));
/*      */     
/* 1241 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1242 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1243 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1244 */           .addComponent(this.jScrollPane3, -2, 156, -2)
/* 1245 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1246 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1247 */             .addComponent(this.jButton15)
/* 1248 */             .addComponent(this.jButton16))
/* 1249 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1252 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1253 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1254 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1255 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1256 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1257 */           .addContainerGap()
/* 1258 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1259 */             .addComponent(this.jPanel29, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1260 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1261 */               .addComponent(this.jPanel28, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 1262 */               .addComponent(this.jSeparator3, GroupLayout.Alignment.LEADING)
/* 1263 */               .addComponent(this.jLabel10, GroupLayout.Alignment.LEADING, -1, 381, 32767)))
/* 1264 */           .addContainerGap(18, 32767)));
/*      */     
/* 1266 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1267 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1268 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1269 */           .addContainerGap()
/* 1270 */           .addComponent(this.jLabel10)
/* 1271 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1272 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 1273 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1274 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 1275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1276 */           .addComponent(this.jPanel29, -2, -1, -2)
/* 1277 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1280 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1281 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1282 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1283 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1284 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/* 1286 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1288 */         .addComponent(this.jPanel3, -2, -1, -2));
/*      */ 
/*      */     
/* 1291 */     this.jDialog4.setTitle("Datos de la Póliza");
/* 1292 */     this.jDialog4.setModal(true);
/* 1293 */     this.jDialog4.setResizable(false);
/* 1294 */     this.jDialog4.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1296 */             TractoAgregar.this.jDialog4WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1300 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*      */     
/* 1302 */     this.jLabel11.setFont(new Font("Tahoma", 1, 14));
/* 1303 */     this.jLabel11.setForeground(new Color(0, 102, 102));
/* 1304 */     this.jLabel11.setHorizontalAlignment(0);
/* 1305 */     this.jLabel11.setText("Información del Seguro Ecológico");
/*      */     
/* 1307 */     this.jPanel31.setBackground(new Color(146, 193, 134));
/* 1308 */     this.jPanel31.setBorder(BorderFactory.createTitledBorder(null, "A nombre de ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1310 */     this.jLabel59.setFont(new Font("Tahoma", 3, 11));
/* 1311 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 1312 */     this.jLabel59.setHorizontalAlignment(4);
/* 1313 */     this.jLabel59.setText("Nombre");
/*      */     
/* 1315 */     this.jLabel60.setFont(new Font("Tahoma", 3, 11));
/* 1316 */     this.jLabel60.setForeground(new Color(15, 87, 51));
/* 1317 */     this.jLabel60.setHorizontalAlignment(0);
/* 1318 */     this.jLabel60.setText("Apellido Paterno");
/*      */     
/* 1320 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/* 1321 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 1322 */     this.jLabel61.setHorizontalAlignment(4);
/* 1323 */     this.jLabel61.setText("Apellido Paterno");
/*      */     
/* 1325 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1326 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1327 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1328 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1329 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1330 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1331 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1332 */               .addContainerGap()
/* 1333 */               .addComponent(this.jLabel59, -2, 87, -2)
/* 1334 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1335 */               .addComponent(this.jTextField34, -1, 178, 32767))
/* 1336 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1337 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1338 */                 .addComponent(this.jLabel61, -1, 99, 32767)
/* 1339 */                 .addComponent(this.jLabel60, -2, 99, 32767))
/* 1340 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1341 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1342 */                 .addComponent(this.jTextField35)
/* 1343 */                 .addComponent(this.jTextField36, -1, 176, 32767))))
/* 1344 */           .addContainerGap()));
/*      */     
/* 1346 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1349 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1350 */             .addComponent(this.jLabel59)
/* 1351 */             .addComponent(this.jTextField34, -2, -1, -2))
/* 1352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1353 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1354 */             .addComponent(this.jLabel60)
/* 1355 */             .addComponent(this.jTextField35, -2, -1, -2))
/* 1356 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1357 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1358 */             .addComponent(this.jLabel61)
/* 1359 */             .addComponent(this.jTextField36, -2, -1, -2))
/* 1360 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1363 */     this.jPanel32.setBackground(new Color(146, 193, 134));
/* 1364 */     this.jPanel32.setBorder(BorderFactory.createTitledBorder(null, " Beneficiario ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1366 */     this.jLabel62.setFont(new Font("Tahoma", 3, 11));
/* 1367 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 1368 */     this.jLabel62.setHorizontalAlignment(4);
/* 1369 */     this.jLabel62.setText("Nombre");
/*      */     
/* 1371 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/* 1372 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/* 1373 */     this.jLabel63.setHorizontalAlignment(0);
/* 1374 */     this.jLabel63.setText("Apellido Paterno");
/*      */     
/* 1376 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/* 1377 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/* 1378 */     this.jLabel64.setHorizontalAlignment(4);
/* 1379 */     this.jLabel64.setText("Apellido Paterno");
/*      */     
/* 1381 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1382 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1383 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1385 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1386 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1387 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1388 */               .addContainerGap()
/* 1389 */               .addComponent(this.jLabel62, -2, 87, -2)
/* 1390 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 1391 */             .addComponent(this.jLabel63, -2, 100, 32767)
/* 1392 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1393 */               .addComponent(this.jLabel64, -2, 94, -2)
/* 1394 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 1395 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1396 */             .addComponent(this.jTextField38, -1, 179, 32767)
/* 1397 */             .addComponent(this.jTextField37, GroupLayout.Alignment.LEADING, -1, 179, 32767)
/* 1398 */             .addComponent(this.jTextField39, -1, 179, 32767))
/* 1399 */           .addContainerGap()));
/*      */     
/* 1401 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1402 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1403 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1404 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1405 */             .addComponent(this.jLabel62)
/* 1406 */             .addComponent(this.jTextField37, -2, -1, -2))
/* 1407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1408 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1409 */             .addComponent(this.jLabel63)
/* 1410 */             .addComponent(this.jTextField38, -2, -1, -2))
/* 1411 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1412 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1413 */             .addComponent(this.jTextField39, -2, -1, -2)
/* 1414 */             .addComponent(this.jLabel64))
/* 1415 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1418 */     this.jPanel33.setBackground(new Color(146, 193, 134));
/* 1419 */     this.jPanel33.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Póliza ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1421 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/* 1422 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/* 1423 */     this.jLabel65.setHorizontalAlignment(4);
/* 1424 */     this.jLabel65.setText("Tipo de Seguro");
/*      */     
/* 1426 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/* 1427 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/* 1428 */     this.jLabel66.setHorizontalAlignment(4);
/* 1429 */     this.jLabel66.setText("Costo");
/*      */     
/* 1431 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/* 1432 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1433 */     this.jLabel67.setHorizontalAlignment(4);
/* 1434 */     this.jLabel67.setText("Fecha de Inicio");
/*      */     
/* 1436 */     this.jDateChooser3.setDate(this.fechaActual);
/* 1437 */     this.jDateChooser3.setDateFormatString("yyyy/MM/dd");
/* 1438 */     this.jDateChooser3.setIcon(this.icon);
/* 1439 */     this.jDateChooser3.setMaxSelectableDate(this.fecha);
/* 1440 */     this.jDateChooser3.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1442 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/* 1443 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/* 1444 */     this.jLabel68.setHorizontalAlignment(4);
/* 1445 */     this.jLabel68.setText("F. de Vigencia");
/*      */     
/* 1447 */     this.jDateChooser6.setDate(this.fechaActual);
/* 1448 */     this.jDateChooser6.setDateFormatString("yyyy/MM/dd");
/* 1449 */     this.jDateChooser6.setIcon(this.icon);
/* 1450 */     this.jDateChooser6.setMaxSelectableDate(this.fecha);
/* 1451 */     this.jDateChooser6.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1453 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/* 1454 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/* 1455 */     this.jLabel69.setHorizontalAlignment(4);
/* 1456 */     this.jLabel69.setText("T. de Gracia");
/*      */     
/* 1458 */     this.jTextArea2.setColumns(20);
/* 1459 */     this.jTextArea2.setRows(5);
/* 1460 */     this.jScrollPane4.setViewportView(this.jTextArea2);
/*      */     
/* 1462 */     this.jLabel70.setFont(new Font("Tahoma", 2, 11));
/* 1463 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/* 1464 */     this.jLabel70.setHorizontalAlignment(0);
/* 1465 */     this.jLabel70.setText("Coberturas");
/*      */     
/* 1467 */     this.jLabel71.setFont(new Font("Tahoma", 2, 11));
/* 1468 */     this.jLabel71.setForeground(new Color(15, 87, 51));
/* 1469 */     this.jLabel71.setText("Meses");
/*      */     
/* 1471 */     this.jLabel72.setFont(new Font("Tahoma", 2, 11));
/* 1472 */     this.jLabel72.setForeground(new Color(15, 87, 51));
/* 1473 */     this.jLabel72.setText("Pesos");
/*      */     
/* 1475 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1476 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1477 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1478 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1479 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1480 */           .addContainerGap()
/* 1481 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1482 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1483 */               .addComponent(this.jLabel65, -2, 87, -2)
/* 1484 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1485 */               .addComponent(this.jTextField40, -2, 208, -2))
/* 1486 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1487 */               .addComponent(this.jLabel68, -2, 87, -2)
/* 1488 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1489 */               .addComponent((Component)this.jDateChooser6, -1, -1, 32767))
/* 1490 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1491 */               .addComponent(this.jLabel69, -2, 87, -2)
/* 1492 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1493 */               .addComponent(this.jTextField42, -2, 96, -2)
/* 1494 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1495 */               .addComponent(this.jLabel71, -2, 87, -2))
/* 1496 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1497 */               .addComponent(this.jLabel67, -2, 87, -2)
/* 1498 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1499 */               .addComponent((Component)this.jDateChooser3, -1, -1, 32767))
/* 1500 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1501 */               .addComponent(this.jLabel66, -2, 87, -2)
/* 1502 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1503 */               .addComponent(this.jTextField41, -2, 92, -2)
/* 1504 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1505 */               .addComponent(this.jLabel72, -2, 87, -2)))
/* 1506 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1507 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1508 */             .addComponent(this.jLabel70, -1, -1, 32767)
/* 1509 */             .addComponent(this.jScrollPane4, -1, 271, 32767))
/* 1510 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1512 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1513 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1514 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1515 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1516 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1517 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1518 */                 .addComponent(this.jLabel65)
/* 1519 */                 .addComponent(this.jTextField40, -2, -1, -2)
/* 1520 */                 .addComponent(this.jLabel70))
/* 1521 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1522 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1523 */                 .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1524 */                   .addComponent(this.jLabel66)
/* 1525 */                   .addComponent(this.jTextField41, -2, -1, -2))
/* 1526 */                 .addComponent(this.jLabel72))
/* 1527 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1528 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1529 */                 .addComponent((Component)this.jDateChooser3, -1, -1, 32767)
/* 1530 */                 .addComponent(this.jLabel67))
/* 1531 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1532 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1533 */                 .addComponent(this.jLabel68)
/* 1534 */                 .addComponent((Component)this.jDateChooser6, -2, -1, -2))
/* 1535 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1536 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1537 */                 .addComponent(this.jLabel69)
/* 1538 */                 .addComponent(this.jTextField42, -2, -1, -2)
/* 1539 */                 .addComponent(this.jLabel71)))
/* 1540 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1541 */               .addGap(28, 28, 28)
/* 1542 */               .addComponent(this.jScrollPane4, -2, -1, -2)))
/* 1543 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1546 */     this.jPanel34.setBackground(new Color(146, 193, 134));
/* 1547 */     this.jPanel34.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Aseguradora ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1549 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/* 1550 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/* 1551 */     this.jLabel73.setHorizontalAlignment(4);
/* 1552 */     this.jLabel73.setText("Aseguradora");
/*      */     
/* 1554 */     this.jLabel74.setFont(new Font("Tahoma", 3, 11));
/* 1555 */     this.jLabel74.setForeground(new Color(15, 87, 51));
/* 1556 */     this.jLabel74.setHorizontalAlignment(4);
/* 1557 */     this.jLabel74.setText("Nombre del Agente");
/*      */     
/* 1559 */     this.jLabel75.setFont(new Font("Tahoma", 2, 11));
/* 1560 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/* 1561 */     this.jLabel75.setHorizontalAlignment(4);
/* 1562 */     this.jLabel75.setText("Calle");
/*      */     
/* 1564 */     this.jLabel76.setFont(new Font("Tahoma", 2, 11));
/* 1565 */     this.jLabel76.setForeground(new Color(15, 87, 51));
/* 1566 */     this.jLabel76.setHorizontalAlignment(4);
/* 1567 */     this.jLabel76.setText("Num.");
/*      */     
/* 1569 */     this.jLabel77.setFont(new Font("Tahoma", 2, 11));
/* 1570 */     this.jLabel77.setForeground(new Color(15, 87, 51));
/* 1571 */     this.jLabel77.setHorizontalAlignment(4);
/* 1572 */     this.jLabel77.setText("Colonia");
/*      */     
/* 1574 */     this.jLabel78.setFont(new Font("Tahoma", 2, 11));
/* 1575 */     this.jLabel78.setForeground(new Color(15, 87, 51));
/* 1576 */     this.jLabel78.setHorizontalAlignment(4);
/* 1577 */     this.jLabel78.setText("Ciudad");
/*      */     
/* 1579 */     this.jLabel79.setFont(new Font("Tahoma", 2, 11));
/* 1580 */     this.jLabel79.setForeground(new Color(15, 87, 51));
/* 1581 */     this.jLabel79.setHorizontalAlignment(4);
/* 1582 */     this.jLabel79.setText("c.p.");
/*      */     
/* 1584 */     this.jLabel80.setFont(new Font("Tahoma", 2, 11));
/* 1585 */     this.jLabel80.setForeground(new Color(15, 87, 51));
/* 1586 */     this.jLabel80.setHorizontalAlignment(4);
/* 1587 */     this.jLabel80.setText("Estado");
/*      */     
/* 1589 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1590 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 1591 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1593 */             TractoAgregar.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1597 */     this.jLabel81.setFont(new Font("Tahoma", 2, 11));
/* 1598 */     this.jLabel81.setForeground(new Color(15, 87, 51));
/* 1599 */     this.jLabel81.setHorizontalAlignment(4);
/* 1600 */     this.jLabel81.setText("Teléfono");
/*      */     
/* 1602 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1604 */             TractoAgregar.this.jFormattedTextField2FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/* 1608 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1609 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1610 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1611 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1612 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1613 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1614 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1615 */               .addGap(10, 10, 10)
/* 1616 */               .addComponent(this.jLabel81, -1, 110, 32767))
/* 1617 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1618 */               .addContainerGap()
/* 1619 */               .addComponent(this.jLabel78, -1, 110, 32767))
/* 1620 */             .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1621 */               .addComponent(this.jLabel75, -1, -1, 32767)
/* 1622 */               .addComponent(this.jLabel74, -1, -1, 32767)
/* 1623 */               .addGroup(jPanel34Layout.createSequentialGroup()
/* 1624 */                 .addGap(10, 10, 10)
/* 1625 */                 .addComponent(this.jLabel73, -1, 110, 32767))))
/* 1626 */           .addGap(16, 16, 16)
/* 1627 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1628 */             .addComponent(this.jFormattedTextField2, GroupLayout.Alignment.LEADING, -2, 154, -2)
/* 1629 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1630 */               .addComponent(this.jTextField45, -2, 154, -2)
/* 1631 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1632 */               .addComponent(this.jLabel76, -2, 41, -2)
/* 1633 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1634 */               .addComponent(this.jTextField46, -2, 47, -2)
/* 1635 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1636 */               .addComponent(this.jLabel77, -2, 47, -2)
/* 1637 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1638 */               .addComponent(this.jTextField47, -1, 145, 32767))
/* 1639 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
/* 1640 */               .addComponent(this.jTextField48, -2, 154, -2)
/* 1641 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1642 */               .addComponent(this.jLabel79, -2, 41, -2)
/* 1643 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1644 */               .addComponent(this.jTextField49, -2, 47, -2)
/* 1645 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1646 */               .addComponent(this.jLabel80, -2, 47, -2)
/* 1647 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1648 */               .addComponent(this.jComboBox6, 0, 145, 32767))
/* 1649 */             .addComponent(this.jTextField44, GroupLayout.Alignment.LEADING, -1, 450, 32767)
/* 1650 */             .addComponent(this.jTextField43, -1, 450, 32767))
/* 1651 */           .addContainerGap()));
/*      */     
/* 1653 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1654 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1655 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1656 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1657 */             .addComponent(this.jLabel73)
/* 1658 */             .addComponent(this.jTextField43, -2, -1, -2))
/* 1659 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1660 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1661 */             .addComponent(this.jLabel74)
/* 1662 */             .addComponent(this.jTextField44, -2, -1, -2))
/* 1663 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1664 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1665 */             .addComponent(this.jLabel75)
/* 1666 */             .addComponent(this.jTextField45, -2, -1, -2)
/* 1667 */             .addComponent(this.jLabel77)
/* 1668 */             .addComponent(this.jLabel76)
/* 1669 */             .addComponent(this.jTextField46, -2, -1, -2)
/* 1670 */             .addComponent(this.jTextField47, -2, -1, -2))
/* 1671 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1672 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1673 */             .addComponent(this.jLabel78)
/* 1674 */             .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1675 */               .addComponent(this.jTextField48, -2, -1, -2)
/* 1676 */               .addComponent(this.jLabel79)
/* 1677 */               .addComponent(this.jTextField49, -2, -1, -2)
/* 1678 */               .addComponent(this.jLabel80)
/* 1679 */               .addComponent(this.jComboBox6, -2, -1, -2)))
/* 1680 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1681 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1682 */             .addComponent(this.jFormattedTextField2, -2, -1, -2)
/* 1683 */             .addComponent(this.jLabel81))
/* 1684 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1687 */     this.jButton17.setMnemonic('C');
/* 1688 */     this.jButton17.setText("Cerrar");
/* 1689 */     this.jButton17.setToolTipText("Cerrar (Alt+C)");
/* 1690 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1692 */             TractoAgregar.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1696 */     this.jButton18.setMnemonic('L');
/* 1697 */     this.jButton18.setText("Limpiar");
/* 1698 */     this.jButton18.setToolTipText("Limpiar (Alt+L)");
/* 1699 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1701 */             TractoAgregar.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1705 */     this.jButton19.setMnemonic('G');
/* 1706 */     this.jButton19.setText("Guardar");
/* 1707 */     this.jButton19.setToolTipText("Guardar (Alt+G)");
/* 1708 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1710 */             TractoAgregar.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1714 */     this.jButton20.setMnemonic('R');
/* 1715 */     this.jButton20.setText("Restablecer");
/* 1716 */     this.jButton20.setToolTipText("Restablecer (Alt+R)");
/* 1717 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1719 */             TractoAgregar.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1723 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1724 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1725 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1726 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1727 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1728 */           .addContainerGap()
/* 1729 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1730 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.LEADING)
/* 1731 */             .addComponent(this.jPanel34, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 1732 */             .addComponent(this.jPanel33, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1733 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1734 */               .addComponent(this.jPanel31, -2, -1, -2)
/* 1735 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1736 */               .addComponent(this.jPanel32, -1, -1, 32767))
/* 1737 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1738 */               .addComponent(this.jButton20, -2, 104, -2)
/* 1739 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1740 */               .addComponent(this.jButton19, -2, 93, -2)
/* 1741 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1742 */               .addComponent(this.jButton18, -2, 93, -2)
/* 1743 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1744 */               .addComponent(this.jButton17, -2, 93, -2))
/* 1745 */             .addComponent(this.jLabel11, GroupLayout.Alignment.LEADING, -1, 602, 32767))
/* 1746 */           .addContainerGap(20, 32767)));
/*      */     
/* 1748 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1749 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1750 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1751 */           .addContainerGap()
/* 1752 */           .addComponent(this.jLabel11)
/* 1753 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1754 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1755 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1756 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1757 */             .addComponent(this.jPanel31, -2, -1, -2)
/* 1758 */             .addComponent(this.jPanel32, -2, -1, -2))
/* 1759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1760 */           .addComponent(this.jPanel33, -2, -1, -2)
/* 1761 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1762 */           .addComponent(this.jPanel34, -2, -1, -2)
/* 1763 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1764 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1765 */             .addComponent(this.jButton17)
/* 1766 */             .addComponent(this.jButton18)
/* 1767 */             .addComponent(this.jButton19)
/* 1768 */             .addComponent(this.jButton20))
/* 1769 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1772 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1773 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1774 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1775 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1776 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */     
/* 1778 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1780 */         .addComponent(this.jPanel5, -2, -1, -2));
/*      */ 
/*      */     
/* 1783 */     this.jDialog5.setTitle("SEMARNAT");
/* 1784 */     this.jDialog5.setModal(true);
/* 1785 */     this.jDialog5.setResizable(false);
/* 1786 */     this.jDialog5.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1788 */             TractoAgregar.this.jDialog5WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1792 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*      */     
/* 1794 */     this.jLabel82.setFont(new Font("Tahoma", 1, 14));
/* 1795 */     this.jLabel82.setForeground(new Color(0, 102, 102));
/* 1796 */     this.jLabel82.setHorizontalAlignment(0);
/* 1797 */     this.jLabel82.setText("Permiso de la SEMARNAT");
/*      */     
/* 1799 */     this.jLabel83.setFont(new Font("Tahoma", 3, 11));
/* 1800 */     this.jLabel83.setForeground(new Color(15, 87, 51));
/* 1801 */     this.jLabel83.setHorizontalAlignment(4);
/* 1802 */     this.jLabel83.setText("Fecha de Inicio");
/*      */     
/* 1804 */     this.jRadioButton13.setSelected(true);
/* 1805 */     this.jRadioButton13.setText("Alta");
/*      */     
/* 1807 */     this.jRadioButton14.setText("Actualización");
/*      */     
/* 1809 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1810 */     this.jDateChooser4.setDateFormatString("yyyy/MM/dd");
/* 1811 */     this.jDateChooser4.setIcon(this.icon);
/* 1812 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1813 */     this.jDateChooser4.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1815 */     this.jLabel85.setFont(new Font("Tahoma", 3, 11));
/* 1816 */     this.jLabel85.setForeground(new Color(15, 87, 51));
/* 1817 */     this.jLabel85.setHorizontalAlignment(4);
/* 1818 */     this.jLabel85.setText("Tipo");
/*      */     
/* 1820 */     this.jLabel84.setFont(new Font("Tahoma", 3, 11));
/* 1821 */     this.jLabel84.setForeground(new Color(15, 87, 51));
/* 1822 */     this.jLabel84.setHorizontalAlignment(4);
/* 1823 */     this.jLabel84.setText("Fecha de Vigencia");
/*      */     
/* 1825 */     this.jDateChooser7.setDate(this.fechaActual);
/* 1826 */     this.jDateChooser7.setDateFormatString("yyyy/MM/dd");
/* 1827 */     this.jDateChooser7.setIcon(this.icon);
/* 1828 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/* 1829 */     this.jDateChooser7.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1831 */     this.jLabel86.setFont(new Font("Tahoma", 2, 11));
/* 1832 */     this.jLabel86.setForeground(new Color(15, 87, 51));
/* 1833 */     this.jLabel86.setHorizontalAlignment(4);
/* 1834 */     this.jLabel86.setText("Comentario");
/*      */     
/* 1836 */     this.jTextArea3.setColumns(20);
/* 1837 */     this.jTextArea3.setRows(5);
/* 1838 */     this.jScrollPane5.setViewportView(this.jTextArea3);
/*      */     
/* 1840 */     this.jButton21.setMnemonic('C');
/* 1841 */     this.jButton21.setText("Cerrar");
/* 1842 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 1843 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1845 */             TractoAgregar.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1849 */     this.jButton22.setMnemonic('L');
/* 1850 */     this.jButton22.setText("Limpiar");
/* 1851 */     this.jButton22.setToolTipText("Limpiar (Alt+L)");
/* 1852 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1854 */             TractoAgregar.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1858 */     this.jButton23.setMnemonic('G');
/* 1859 */     this.jButton23.setText("Guardar");
/* 1860 */     this.jButton23.setToolTipText("Guardar (Alt+G)");
/* 1861 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1863 */             TractoAgregar.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1867 */     this.jButton24.setMnemonic('R');
/* 1868 */     this.jButton24.setText("Restablecer");
/* 1869 */     this.jButton24.setToolTipText("Restablecer (Alt+R)");
/* 1870 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1872 */             TractoAgregar.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1876 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1877 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1878 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1879 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1880 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1881 */           .addContainerGap()
/* 1882 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1883 */             .addComponent(this.jSeparator5, -1, 331, 32767)
/* 1884 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1885 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1886 */                 .addComponent(this.jLabel85, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 1887 */                 .addComponent(this.jLabel83, -1, 108, 32767)
/* 1888 */                 .addComponent(this.jLabel84, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 1889 */                 .addComponent(this.jLabel86, -1, 108, 32767))
/* 1890 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1891 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1892 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1893 */                   .addComponent(this.jRadioButton13)
/* 1894 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1895 */                   .addComponent(this.jRadioButton14))
/* 1896 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1897 */                   .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1898 */                     .addComponent(this.jButton22, -1, 108, 32767)
/* 1899 */                     .addComponent(this.jButton24, -1, 108, 32767))
/* 1900 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1901 */                   .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1902 */                     .addComponent(this.jButton23, -1, -1, 32767)
/* 1903 */                     .addComponent(this.jButton21, -1, 105, 32767)))
/* 1904 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1905 */                   .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1906 */                   .addComponent((Component)this.jDateChooser7, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 1907 */                 .addComponent(this.jScrollPane5, -1, 219, 32767)))
/* 1908 */             .addComponent(this.jLabel82, -1, 331, 32767))
/* 1909 */           .addContainerGap()));
/*      */     
/* 1911 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1912 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1913 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1914 */           .addContainerGap()
/* 1915 */           .addComponent(this.jLabel82)
/* 1916 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1917 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1918 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1919 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1920 */             .addComponent(this.jRadioButton13)
/* 1921 */             .addComponent(this.jRadioButton14)
/* 1922 */             .addComponent(this.jLabel85))
/* 1923 */           .addGap(8, 8, 8)
/* 1924 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1925 */             .addComponent(this.jLabel83, -1, -1, 32767)
/* 1926 */             .addComponent((Component)this.jDateChooser4, -2, 20, 32767))
/* 1927 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1928 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1929 */             .addComponent((Component)this.jDateChooser7, -2, -1, -2)
/* 1930 */             .addComponent(this.jLabel84))
/* 1931 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1932 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1933 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1934 */               .addComponent(this.jScrollPane5, -2, 114, -2)
/* 1935 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1936 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1937 */                 .addComponent(this.jButton21)
/* 1938 */                 .addComponent(this.jButton22))
/* 1939 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1940 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1941 */                 .addComponent(this.jButton23)
/* 1942 */                 .addComponent(this.jButton24)))
/* 1943 */             .addComponent(this.jLabel86))
/* 1944 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 1947 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1948 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1949 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1950 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1951 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/* 1953 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1955 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/* 1958 */     this.jDialog6.setTitle("SEMARNAT");
/* 1959 */     this.jDialog6.setModal(true);
/* 1960 */     this.jDialog6.setResizable(false);
/* 1961 */     this.jDialog6.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1963 */             TractoAgregar.this.jDialog6WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1967 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/* 1969 */     this.jLabel87.setFont(new Font("Tahoma", 1, 14));
/* 1970 */     this.jLabel87.setForeground(new Color(0, 102, 102));
/* 1971 */     this.jLabel87.setHorizontalAlignment(0);
/* 1972 */     this.jLabel87.setText("Permiso de la SCT");
/*      */     
/* 1974 */     this.jLabel88.setFont(new Font("Tahoma", 3, 11));
/* 1975 */     this.jLabel88.setForeground(new Color(15, 87, 51));
/* 1976 */     this.jLabel88.setHorizontalAlignment(4);
/* 1977 */     this.jLabel88.setText("Fecha de Inicio");
/*      */     
/* 1979 */     this.jRadioButton15.setSelected(true);
/* 1980 */     this.jRadioButton15.setText("Alta");
/*      */     
/* 1982 */     this.jRadioButton16.setText("Actualización");
/*      */     
/* 1984 */     this.jDateChooser8.setDate(this.fechaActual);
/* 1985 */     this.jDateChooser8.setDateFormatString("yyyy/MM/dd");
/* 1986 */     this.jDateChooser8.setIcon(this.icon);
/* 1987 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/* 1988 */     this.jDateChooser8.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1990 */     this.jLabel89.setFont(new Font("Tahoma", 3, 11));
/* 1991 */     this.jLabel89.setForeground(new Color(15, 87, 51));
/* 1992 */     this.jLabel89.setHorizontalAlignment(4);
/* 1993 */     this.jLabel89.setText("Tipo");
/*      */     
/* 1995 */     this.jLabel90.setFont(new Font("Tahoma", 3, 11));
/* 1996 */     this.jLabel90.setForeground(new Color(15, 87, 51));
/* 1997 */     this.jLabel90.setHorizontalAlignment(4);
/* 1998 */     this.jLabel90.setText("Fecha de Vigencia");
/*      */     
/* 2000 */     this.jDateChooser9.setDate(this.fechaActual);
/* 2001 */     this.jDateChooser9.setDateFormatString("yyyy/MM/dd");
/* 2002 */     this.jDateChooser9.setIcon(this.icon);
/* 2003 */     this.jDateChooser9.setMaxSelectableDate(this.fecha);
/* 2004 */     this.jDateChooser9.setMinSelectableDate(this.fechaActual);
/*      */     
/* 2006 */     this.jLabel91.setFont(new Font("Tahoma", 2, 11));
/* 2007 */     this.jLabel91.setForeground(new Color(15, 87, 51));
/* 2008 */     this.jLabel91.setHorizontalAlignment(4);
/* 2009 */     this.jLabel91.setText("Comentario");
/*      */     
/* 2011 */     this.jTextArea4.setColumns(20);
/* 2012 */     this.jTextArea4.setRows(5);
/* 2013 */     this.jScrollPane6.setViewportView(this.jTextArea4);
/*      */     
/* 2015 */     this.jButton25.setMnemonic('C');
/* 2016 */     this.jButton25.setText("Cerrar");
/* 2017 */     this.jButton25.setToolTipText("Cerrar (Alt+C)");
/* 2018 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2020 */             TractoAgregar.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2024 */     this.jButton26.setMnemonic('L');
/* 2025 */     this.jButton26.setText("Limpiar");
/* 2026 */     this.jButton26.setToolTipText("Limpiar (Alt+L)");
/* 2027 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2029 */             TractoAgregar.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2033 */     this.jButton27.setMnemonic('G');
/* 2034 */     this.jButton27.setText("Guardar");
/* 2035 */     this.jButton27.setToolTipText("Guardar (Alt+G)");
/* 2036 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2038 */             TractoAgregar.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2042 */     this.jButton28.setMnemonic('R');
/* 2043 */     this.jButton28.setText("Restablecer");
/* 2044 */     this.jButton28.setToolTipText("Restablecer (Alt+R)");
/* 2045 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2047 */             TractoAgregar.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2051 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 2052 */     this.jPanel7.setLayout(jPanel7Layout);
/* 2053 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 2054 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2055 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 2056 */           .addContainerGap()
/* 2057 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2058 */             .addComponent(this.jSeparator6, -1, 331, 32767)
/* 2059 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 2060 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2061 */                 .addComponent(this.jLabel89, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 2062 */                 .addComponent(this.jLabel88, -1, 108, 32767)
/* 2063 */                 .addComponent(this.jLabel90, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 2064 */                 .addComponent(this.jLabel91, -1, 108, 32767))
/* 2065 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2066 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2067 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 2068 */                   .addComponent(this.jRadioButton15)
/* 2069 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2070 */                   .addComponent(this.jRadioButton16))
/* 2071 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 2072 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2073 */                     .addComponent(this.jButton26, -1, 108, 32767)
/* 2074 */                     .addComponent(this.jButton28, -1, 108, 32767))
/* 2075 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2076 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2077 */                     .addComponent(this.jButton27, -1, -1, 32767)
/* 2078 */                     .addComponent(this.jButton25, -1, 105, 32767)))
/* 2079 */                 .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2080 */                   .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2081 */                   .addComponent((Component)this.jDateChooser9, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 2082 */                 .addComponent(this.jScrollPane6, -1, 219, 32767)))
/* 2083 */             .addComponent(this.jLabel87, -1, 331, 32767))
/* 2084 */           .addContainerGap()));
/*      */     
/* 2086 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 2087 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2088 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 2089 */           .addContainerGap()
/* 2090 */           .addComponent(this.jLabel87)
/* 2091 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2092 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 2093 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2094 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2095 */             .addComponent(this.jRadioButton15)
/* 2096 */             .addComponent(this.jRadioButton16)
/* 2097 */             .addComponent(this.jLabel89))
/* 2098 */           .addGap(8, 8, 8)
/* 2099 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2100 */             .addComponent(this.jLabel88, -1, -1, 32767)
/* 2101 */             .addComponent((Component)this.jDateChooser8, -2, 20, 32767))
/* 2102 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2103 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2104 */             .addComponent((Component)this.jDateChooser9, -2, -1, -2)
/* 2105 */             .addComponent(this.jLabel90))
/* 2106 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2107 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2108 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 2109 */               .addComponent(this.jScrollPane6, -2, 114, -2)
/* 2110 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2111 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2112 */                 .addComponent(this.jButton25)
/* 2113 */                 .addComponent(this.jButton26))
/* 2114 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2115 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2116 */                 .addComponent(this.jButton27)
/* 2117 */                 .addComponent(this.jButton28)))
/* 2118 */             .addComponent(this.jLabel91))
/* 2119 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 2122 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2123 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2124 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2125 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2126 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 2128 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2129 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2130 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 2133 */     this.jDialog7.setTitle("SEMARNAT");
/* 2134 */     this.jDialog7.setModal(true);
/* 2135 */     this.jDialog7.setResizable(false);
/* 2136 */     this.jDialog7.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 2138 */             TractoAgregar.this.jDialog7WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 2142 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/* 2144 */     this.jLabel93.setFont(new Font("Tahoma", 1, 14));
/* 2145 */     this.jLabel93.setForeground(new Color(0, 102, 102));
/* 2146 */     this.jLabel93.setHorizontalAlignment(0);
/* 2147 */     this.jLabel93.setText("Permiso de Sedere");
/*      */     
/* 2149 */     this.jLabel94.setFont(new Font("Tahoma", 3, 11));
/* 2150 */     this.jLabel94.setForeground(new Color(15, 87, 51));
/* 2151 */     this.jLabel94.setHorizontalAlignment(4);
/* 2152 */     this.jLabel94.setText("Fecha de Inicio");
/*      */     
/* 2154 */     this.jRadioButton20.setSelected(true);
/* 2155 */     this.jRadioButton20.setText("Alta");
/*      */     
/* 2157 */     this.jRadioButton21.setText("Actualización");
/*      */     
/* 2159 */     this.jDateChooser10.setDate(this.fechaActual);
/* 2160 */     this.jDateChooser10.setDateFormatString("yyyy/MM/dd");
/* 2161 */     this.jDateChooser10.setIcon(this.icon);
/* 2162 */     this.jDateChooser10.setMaxSelectableDate(this.fecha);
/* 2163 */     this.jDateChooser10.setMinSelectableDate(this.fechaActual);
/*      */     
/* 2165 */     this.jLabel95.setFont(new Font("Tahoma", 3, 11));
/* 2166 */     this.jLabel95.setForeground(new Color(15, 87, 51));
/* 2167 */     this.jLabel95.setHorizontalAlignment(4);
/* 2168 */     this.jLabel95.setText("Tipo");
/*      */     
/* 2170 */     this.jLabel96.setFont(new Font("Tahoma", 3, 11));
/* 2171 */     this.jLabel96.setForeground(new Color(15, 87, 51));
/* 2172 */     this.jLabel96.setHorizontalAlignment(4);
/* 2173 */     this.jLabel96.setText("Fecha de Vigencia");
/*      */     
/* 2175 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2176 */     this.jDateChooser11.setDateFormatString("yyyy/MM/dd");
/* 2177 */     this.jDateChooser11.setIcon(this.icon);
/* 2178 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 2179 */     this.jDateChooser11.setMinSelectableDate(this.fechaActual);
/*      */     
/* 2181 */     this.jLabel97.setFont(new Font("Tahoma", 2, 11));
/* 2182 */     this.jLabel97.setForeground(new Color(15, 87, 51));
/* 2183 */     this.jLabel97.setHorizontalAlignment(4);
/* 2184 */     this.jLabel97.setText("Comentario");
/*      */     
/* 2186 */     this.jTextArea5.setColumns(20);
/* 2187 */     this.jTextArea5.setRows(5);
/* 2188 */     this.jScrollPane7.setViewportView(this.jTextArea5);
/*      */     
/* 2190 */     this.jButton29.setMnemonic('C');
/* 2191 */     this.jButton29.setText("Cerrar");
/* 2192 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 2193 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2195 */             TractoAgregar.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2199 */     this.jButton30.setMnemonic('L');
/* 2200 */     this.jButton30.setText("Limpiar");
/* 2201 */     this.jButton30.setToolTipText("Limpiar (Alt+L)");
/* 2202 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2204 */             TractoAgregar.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2208 */     this.jButton31.setMnemonic('G');
/* 2209 */     this.jButton31.setText("Guardar");
/* 2210 */     this.jButton31.setToolTipText("Guardar (Alt+G)");
/* 2211 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2213 */             TractoAgregar.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2217 */     this.jButton32.setMnemonic('R');
/* 2218 */     this.jButton32.setText("Restablecer");
/* 2219 */     this.jButton32.setToolTipText("Restablecer (Alt+R)");
/* 2220 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2222 */             TractoAgregar.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2226 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 2227 */     this.jPanel8.setLayout(jPanel8Layout);
/* 2228 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 2229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2230 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 2231 */           .addContainerGap()
/* 2232 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2233 */             .addComponent(this.jSeparator7, -1, 331, 32767)
/* 2234 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 2235 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */                 .addComponent(this.jLabel95, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 2237 */                 .addComponent(this.jLabel94, -1, 108, 32767)
/* 2238 */                 .addComponent(this.jLabel96, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 2239 */                 .addComponent(this.jLabel97, -1, 108, 32767))
/* 2240 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2241 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2242 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 2243 */                   .addComponent(this.jRadioButton20)
/* 2244 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2245 */                   .addComponent(this.jRadioButton21))
/* 2246 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 2247 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2248 */                     .addComponent(this.jButton30, -1, 108, 32767)
/* 2249 */                     .addComponent(this.jButton32, -1, 108, 32767))
/* 2250 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2251 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2252 */                     .addComponent(this.jButton31, -1, -1, 32767)
/* 2253 */                     .addComponent(this.jButton29, -1, 105, 32767)))
/* 2254 */                 .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2255 */                   .addComponent((Component)this.jDateChooser10, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2256 */                   .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 2257 */                 .addComponent(this.jScrollPane7, -1, 219, 32767)))
/* 2258 */             .addComponent(this.jLabel93, -1, 331, 32767))
/* 2259 */           .addContainerGap()));
/*      */     
/* 2261 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 2262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2263 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 2264 */           .addContainerGap()
/* 2265 */           .addComponent(this.jLabel93)
/* 2266 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2267 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 2268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2269 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2270 */             .addComponent(this.jRadioButton20)
/* 2271 */             .addComponent(this.jRadioButton21)
/* 2272 */             .addComponent(this.jLabel95))
/* 2273 */           .addGap(8, 8, 8)
/* 2274 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2275 */             .addComponent(this.jLabel94, -1, -1, 32767)
/* 2276 */             .addComponent((Component)this.jDateChooser10, -2, 20, 32767))
/* 2277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2278 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2279 */             .addComponent((Component)this.jDateChooser11, -2, -1, -2)
/* 2280 */             .addComponent(this.jLabel96))
/* 2281 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2282 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2283 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 2284 */               .addComponent(this.jScrollPane7, -2, 114, -2)
/* 2285 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2286 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2287 */                 .addComponent(this.jButton29)
/* 2288 */                 .addComponent(this.jButton30))
/* 2289 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2290 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2291 */                 .addComponent(this.jButton31)
/* 2292 */                 .addComponent(this.jButton32)))
/* 2293 */             .addComponent(this.jLabel97))
/* 2294 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 2297 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2298 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2299 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2301 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/* 2303 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2304 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2305 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/* 2308 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/* 2309 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2311 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/* 2312 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/* 2313 */     this.jLabel1.setHorizontalAlignment(0);
/* 2314 */     this.jLabel1.setText("     Agregar Tractos");
/*      */     
/* 2316 */     this.jButton1.setMnemonic('G');
/* 2317 */     this.jButton1.setText("Guardar");
/* 2318 */     this.jButton1.setToolTipText("Guardar (Alt+G)");
/* 2319 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2321 */             TractoAgregar.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2325 */     this.jButton2.setMnemonic('L');
/* 2326 */     this.jButton2.setText("Limpiar");
/* 2327 */     this.jButton2.setToolTipText("Limpiar (Alt+L)");
/* 2328 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2330 */             TractoAgregar.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2334 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 2335 */     this.jLabel14.setToolTipText("Cerrar");
/* 2336 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2338 */             TractoAgregar.this.jLabel14MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2341 */             TractoAgregar.this.jLabel14MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2344 */             TractoAgregar.this.jLabel14MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2348 */     this.jButton3.setMnemonic('R');
/* 2349 */     this.jButton3.setText("Restablecer");
/* 2350 */     this.jButton3.setToolTipText("Restablecer ( Alt+R )");
/* 2351 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2353 */             TractoAgregar.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2357 */     this.jButton4.setMnemonic('C');
/* 2358 */     this.jButton4.setText("Cerrar");
/* 2359 */     this.jButton4.setToolTipText("Cerrar (Alt+C)");
/* 2360 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2362 */             TractoAgregar.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2366 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2367 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Datos del Modelo ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2369 */     this.jLabel12.setFont(new Font("Tahoma", 3, 11));
/* 2370 */     this.jLabel12.setForeground(new Color(15, 87, 51));
/* 2371 */     this.jLabel12.setHorizontalAlignment(2);
/* 2372 */     this.jLabel12.setText("Marca");
/*      */     
/* 2374 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2375 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno..." }));
/*      */     
/* 2377 */     this.jButton5.setText("...");
/* 2378 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2380 */             TractoAgregar.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2384 */     this.jLabel16.setFont(new Font("Tahoma", 3, 11));
/* 2385 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 2386 */     this.jLabel16.setHorizontalAlignment(2);
/* 2387 */     this.jLabel16.setText("Modelo");
/*      */     
/* 2389 */     this.jLabel17.setFont(new Font("Tahoma", 3, 11));
/* 2390 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 2391 */     this.jLabel17.setHorizontalAlignment(2);
/* 2392 */     this.jLabel17.setText("Núm. de Serie");
/*      */     
/* 2394 */     this.jLabel21.setFont(new Font("Tahoma", 3, 11));
/* 2395 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/* 2396 */     this.jLabel21.setHorizontalAlignment(2);
/* 2397 */     this.jLabel21.setText("Núm. de Motor");
/*      */     
/* 2399 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*      */     
/* 2401 */     this.jLabel28.setFont(new Font("Tahoma", 3, 11));
/* 2402 */     this.jLabel28.setForeground(new Color(15, 87, 51));
/* 2403 */     this.jLabel28.setHorizontalAlignment(2);
/* 2404 */     this.jLabel28.setText("Placas");
/*      */     
/* 2406 */     this.jTextField7.setNextFocusableComponent((Component)this.jDateChooser1);
/*      */     
/* 2408 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2409 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2410 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2411 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2412 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2413 */           .addContainerGap()
/* 2414 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2415 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2416 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2417 */                 .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2418 */                   .addComponent(this.jLabel21, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2419 */                   .addComponent(this.jLabel17, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2420 */                 .addGap(15, 15, 15))
/* 2421 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2422 */                 .addComponent(this.jLabel16, -1, -1, 32767)
/* 2423 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 2424 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2425 */                 .addComponent(this.jLabel12, -1, -1, 32767)
/* 2426 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 2427 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2428 */               .addComponent(this.jLabel28, -2, 48, -2)
/* 2429 */               .addGap(49, 49, 49)))
/* 2430 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2431 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
/* 2432 */               .addComponent(this.jComboBox2, -2, 181, -2)
/* 2433 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2434 */               .addComponent(this.jButton5)
/* 2435 */               .addGap(511, 511, 511))
/* 2436 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2437 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2438 */                 .addComponent(this.jTextField4)
/* 2439 */                 .addComponent(this.jTextField5, GroupLayout.Alignment.LEADING)
/* 2440 */                 .addComponent(this.jComboBox7, GroupLayout.Alignment.LEADING, -2, 136, -2)
/* 2441 */                 .addComponent(this.jTextField7, GroupLayout.Alignment.LEADING))
/* 2442 */               .addGap(562, 562, 562)))
/* 2443 */           .addGap(55, 55, 55)));
/*      */     
/* 2445 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2447 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2448 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2449 */             .addComponent(this.jComboBox2, -2, -1, -2)
/* 2450 */             .addComponent(this.jButton5)
/* 2451 */             .addComponent(this.jLabel12))
/* 2452 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2453 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2454 */             .addComponent(this.jLabel16)
/* 2455 */             .addComponent(this.jComboBox7, -2, -1, -2))
/* 2456 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2457 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2458 */             .addComponent(this.jLabel17)
/* 2459 */             .addComponent(this.jTextField4, -2, -1, -2))
/* 2460 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2461 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2462 */             .addComponent(this.jLabel21)
/* 2463 */             .addComponent(this.jTextField5, -2, -1, -2))
/* 2464 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2465 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2466 */             .addComponent(this.jLabel28)
/* 2467 */             .addComponent(this.jTextField7, -2, -1, -2))
/* 2468 */           .addContainerGap(17, 32767)));
/*      */ 
/*      */     
/* 2471 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/* 2472 */     this.jPanel20.setBorder(BorderFactory.createTitledBorder(null, "Registro del Tracto ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2474 */     this.jLabel13.setFont(new Font("Tahoma", 3, 11));
/* 2475 */     this.jLabel13.setForeground(new Color(15, 87, 51));
/* 2476 */     this.jLabel13.setHorizontalAlignment(4);
/* 2477 */     this.jLabel13.setText("Núm. de Tracto");
/*      */     
/* 2479 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 2480 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 2481 */     this.jLabel15.setHorizontalAlignment(4);
/* 2482 */     this.jLabel15.setText("Color");
/*      */     
/* 2484 */     this.jLabel20.setFont(new Font("Tahoma", 3, 11));
/* 2485 */     this.jLabel20.setForeground(new Color(15, 87, 51));
/* 2486 */     this.jLabel20.setHorizontalAlignment(4);
/* 2487 */     this.jLabel20.setText("Tipo");
/*      */     
/* 2489 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2490 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno..." }));
/*      */     
/* 2492 */     this.jButton10.setText("...");
/* 2493 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2495 */             TractoAgregar.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2499 */     this.jLabel55.setFont(new Font("Tahoma", 3, 11));
/* 2500 */     this.jLabel55.setForeground(new Color(15, 87, 51));
/* 2501 */     this.jLabel55.setHorizontalAlignment(4);
/* 2502 */     this.jLabel55.setText("Estado");
/*      */     
/* 2504 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 2505 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 2506 */     this.jComboBox5.setEnabled(false);
/*      */     
/* 2508 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2509 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2510 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2512 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2513 */           .addContainerGap()
/* 2514 */           .addComponent(this.jLabel13)
/* 2515 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2516 */           .addComponent(this.jTextField1, -2, 65, -2)
/* 2517 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2518 */           .addComponent(this.jLabel15, -2, 36, -2)
/* 2519 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2520 */           .addComponent(this.jTextField2, -2, 103, -2)
/* 2521 */           .addGap(18, 18, 18)
/* 2522 */           .addComponent(this.jLabel20, -2, 32, -2)
/* 2523 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2524 */           .addComponent(this.jComboBox1, -2, 143, -2)
/* 2525 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2526 */           .addComponent(this.jButton10)
/* 2527 */           .addGap(40, 40, 40)
/* 2528 */           .addComponent(this.jLabel55, -2, 50, -2)
/* 2529 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2530 */           .addComponent(this.jComboBox5, -2, 95, -2)
/* 2531 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2533 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2534 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2535 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2536 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2537 */             .addComponent(this.jLabel13)
/* 2538 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 2539 */             .addComponent(this.jLabel15)
/* 2540 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 2541 */             .addComponent(this.jComboBox1, -2, -1, -2)
/* 2542 */             .addComponent(this.jButton10)
/* 2543 */             .addComponent(this.jLabel20)
/* 2544 */             .addComponent(this.jLabel55)
/* 2545 */             .addComponent(this.jComboBox5, -2, -1, -2))
/* 2546 */           .addContainerGap(13, 32767)));
/*      */ 
/*      */     
/* 2549 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/* 2550 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " Datos de Facturación ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2552 */     this.jLabel18.setFont(new Font("Tahoma", 3, 11));
/* 2553 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/* 2554 */     this.jLabel18.setHorizontalAlignment(2);
/* 2555 */     this.jLabel18.setText("F. Aquisición");
/*      */     
/* 2557 */     this.jDateChooser1.setDate(this.fechaActual);
/* 2558 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/* 2559 */     this.jDateChooser1.setIcon(this.icon);
/* 2560 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/* 2561 */     this.jDateChooser1.setMinSelectableDate(this.fechaActual);
/*      */     
/* 2563 */     this.jLabel22.setFont(new Font("Tahoma", 2, 11));
/* 2564 */     this.jLabel22.setForeground(new Color(15, 87, 51));
/* 2565 */     this.jLabel22.setHorizontalAlignment(2);
/* 2566 */     this.jLabel22.setText("Núm. de Factura");
/*      */     
/* 2568 */     this.jLabel23.setFont(new Font("Tahoma", 2, 11));
/* 2569 */     this.jLabel23.setForeground(new Color(15, 87, 51));
/* 2570 */     this.jLabel23.setHorizontalAlignment(2);
/* 2571 */     this.jLabel23.setText("Forma de Pago");
/*      */     
/* 2573 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2574 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Efectivo", "Tarjeta de Crédito", "Otro" }));
/* 2575 */     this.jComboBox3.setNextFocusableComponent(this.jTextField9);
/*      */     
/* 2577 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 2578 */     this.jPanel21.setLayout(jPanel21Layout);
/* 2579 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 2580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2581 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 2582 */           .addContainerGap()
/* 2583 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2584 */             .addComponent(this.jLabel18)
/* 2585 */             .addComponent(this.jLabel23, -1, 91, 32767)
/* 2586 */             .addComponent(this.jLabel22, -2, 91, 32767))
/* 2587 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2588 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2589 */             .addComponent((Component)this.jDateChooser1, -1, 183, 32767)
/* 2590 */             .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2591 */               .addComponent(this.jTextField6)
/* 2592 */               .addComponent(this.jComboBox3, 0, 183, 32767)))
/* 2593 */           .addContainerGap(56, 32767)));
/*      */     
/* 2595 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 2596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2597 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 2598 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2599 */             .addComponent(this.jLabel18, -1, -1, 32767)
/* 2600 */             .addComponent((Component)this.jDateChooser1, -1, -1, 32767))
/* 2601 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2602 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2603 */             .addComponent(this.jLabel22)
/* 2604 */             .addComponent(this.jTextField6, -2, -1, -2))
/* 2605 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2606 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2607 */             .addComponent(this.jLabel23)
/* 2608 */             .addComponent(this.jComboBox3, -2, -1, -2))
/* 2609 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2612 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 2613 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, " Especificaciones del Vehículo ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2615 */     this.jLabel24.setFont(new Font("Tahoma", 2, 11));
/* 2616 */     this.jLabel24.setForeground(new Color(15, 87, 51));
/* 2617 */     this.jLabel24.setHorizontalAlignment(2);
/* 2618 */     this.jLabel24.setText("Kilometraje Actual");
/*      */     
/* 2620 */     this.jLabel25.setFont(new Font("Tahoma", 2, 11));
/* 2621 */     this.jLabel25.setForeground(new Color(15, 87, 51));
/* 2622 */     this.jLabel25.setHorizontalAlignment(2);
/* 2623 */     this.jLabel25.setText("Peso Vehicular");
/*      */     
/* 2625 */     this.jLabel26.setFont(new Font("Tahoma", 2, 11));
/* 2626 */     this.jLabel26.setForeground(new Color(15, 87, 51));
/* 2627 */     this.jLabel26.setHorizontalAlignment(2);
/* 2628 */     this.jLabel26.setText("Dimensiones");
/*      */     
/* 2630 */     this.jTextField11.setNextFocusableComponent(this.jRadioButton1);
/*      */     
/* 2632 */     this.jLabel57.setFont(new Font("Tahoma", 2, 11));
/* 2633 */     this.jLabel57.setForeground(new Color(15, 87, 51));
/* 2634 */     this.jLabel57.setHorizontalAlignment(2);
/* 2635 */     this.jLabel57.setText("Tons.");
/*      */     
/* 2637 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 2638 */     this.jPanel22.setLayout(jPanel22Layout);
/* 2639 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 2640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2641 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2642 */           .addContainerGap()
/* 2643 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2644 */             .addComponent(this.jLabel26, -1, -1, 32767)
/* 2645 */             .addComponent(this.jLabel25, -1, -1, 32767)
/* 2646 */             .addComponent(this.jLabel24, -1, 125, 32767))
/* 2647 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2648 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2649 */             .addComponent(this.jTextField11)
/* 2650 */             .addGroup(jPanel22Layout.createSequentialGroup()
/* 2651 */               .addComponent(this.jTextField10, -2, 80, -2)
/* 2652 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2653 */               .addComponent(this.jLabel57, -2, 59, -2))
/* 2654 */             .addComponent(this.jTextField9))
/* 2655 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2657 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 2658 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2659 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2660 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2661 */             .addComponent(this.jLabel24)
/* 2662 */             .addComponent(this.jTextField9, -2, -1, -2))
/* 2663 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2664 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2665 */             .addComponent(this.jLabel25)
/* 2666 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 2667 */             .addComponent(this.jLabel57))
/* 2668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2669 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2670 */             .addComponent(this.jLabel26)
/* 2671 */             .addComponent(this.jTextField11, -2, -1, -2))
/* 2672 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2675 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/* 2676 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, " Permisos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2678 */     this.jLabel27.setFont(new Font("Tahoma", 2, 11));
/* 2679 */     this.jLabel27.setForeground(new Color(15, 87, 51));
/* 2680 */     this.jLabel27.setHorizontalAlignment(2);
/* 2681 */     this.jLabel27.setText("Semarnat");
/*      */     
/* 2683 */     this.jRadioButton1.setSelected(true);
/* 2684 */     this.jRadioButton1.setText("No");
/* 2685 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2687 */             TractoAgregar.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2691 */     this.jRadioButton2.setText("Si");
/* 2692 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2694 */             TractoAgregar.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2698 */     this.jRadioButton3.setText("Baja");
/* 2699 */     this.jRadioButton3.setEnabled(false);
/*      */     
/* 2701 */     this.jLabel54.setFont(new Font("Tahoma", 2, 11));
/* 2702 */     this.jLabel54.setForeground(new Color(15, 87, 51));
/* 2703 */     this.jLabel54.setHorizontalAlignment(2);
/* 2704 */     this.jLabel54.setText("SCT");
/*      */     
/* 2706 */     this.jRadioButton7.setSelected(true);
/* 2707 */     this.jRadioButton7.setText("No");
/* 2708 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2710 */             TractoAgregar.this.jRadioButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2714 */     this.jRadioButton8.setText("Si");
/* 2715 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2717 */             TractoAgregar.this.jRadioButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2721 */     this.jRadioButton9.setText("Baja");
/* 2722 */     this.jRadioButton9.setEnabled(false);
/*      */     
/* 2724 */     this.jTextField30.setEditable(false);
/*      */     
/* 2726 */     this.jTextField31.setEditable(false);
/*      */     
/* 2728 */     this.jLabel92.setFont(new Font("Tahoma", 2, 11));
/* 2729 */     this.jLabel92.setForeground(new Color(15, 87, 51));
/* 2730 */     this.jLabel92.setHorizontalAlignment(2);
/* 2731 */     this.jLabel92.setText("Sedere");
/*      */     
/* 2733 */     this.jRadioButton17.setSelected(true);
/* 2734 */     this.jRadioButton17.setText("No");
/* 2735 */     this.jRadioButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2737 */             TractoAgregar.this.jRadioButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2741 */     this.jTextField50.setEditable(false);
/*      */     
/* 2743 */     this.jRadioButton18.setText("Si");
/* 2744 */     this.jRadioButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2746 */             TractoAgregar.this.jRadioButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2750 */     this.jRadioButton19.setText("Baja");
/* 2751 */     this.jRadioButton19.setEnabled(false);
/*      */     
/* 2753 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 2754 */     this.jPanel23.setLayout(jPanel23Layout);
/* 2755 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 2756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2757 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2758 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2759 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2760 */               .addContainerGap()
/* 2761 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2762 */                 .addComponent(this.jLabel54, -2, 57, -2)
/* 2763 */                 .addComponent(this.jLabel27, -2, 74, -2))
/* 2764 */               .addGap(4, 4, 4)
/* 2765 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2766 */                 .addComponent(this.jTextField30)
/* 2767 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2768 */                   .addComponent(this.jRadioButton7)
/* 2769 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2770 */                   .addComponent(this.jRadioButton8)
/* 2771 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2772 */                   .addComponent(this.jRadioButton9))
/* 2773 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2774 */                   .addComponent(this.jRadioButton1)
/* 2775 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2776 */                   .addComponent(this.jRadioButton2)
/* 2777 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2778 */                   .addComponent(this.jRadioButton3))))
/* 2779 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 2780 */               .addGap(88, 88, 88)
/* 2781 */               .addComponent(this.jTextField31))
/* 2782 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2783 */               .addContainerGap()
/* 2784 */               .addComponent(this.jLabel92, -2, 57, -2)
/* 2785 */               .addGap(21, 21, 21)
/* 2786 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2787 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2788 */                   .addComponent(this.jRadioButton17)
/* 2789 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2790 */                   .addComponent(this.jRadioButton18)
/* 2791 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2792 */                   .addComponent(this.jRadioButton19))
/* 2793 */                 .addComponent(this.jTextField50, GroupLayout.Alignment.TRAILING))))
/* 2794 */           .addContainerGap()));
/*      */     
/* 2796 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 2797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2798 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2799 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2800 */             .addComponent(this.jRadioButton1)
/* 2801 */             .addComponent(this.jRadioButton2)
/* 2802 */             .addComponent(this.jRadioButton3, -2, 23, -2)
/* 2803 */             .addComponent(this.jLabel27))
/* 2804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2805 */           .addComponent(this.jTextField30, -2, -1, -2)
/* 2806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2807 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2808 */             .addComponent(this.jLabel54)
/* 2809 */             .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2810 */               .addComponent(this.jRadioButton7)
/* 2811 */               .addComponent(this.jRadioButton8)
/* 2812 */               .addComponent(this.jRadioButton9)))
/* 2813 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2814 */           .addComponent(this.jTextField31, -2, -1, -2)
/* 2815 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2816 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2817 */             .addComponent(this.jLabel92)
/* 2818 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2819 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2820 */                 .addComponent(this.jRadioButton17)
/* 2821 */                 .addComponent(this.jRadioButton18)
/* 2822 */                 .addComponent(this.jRadioButton19))
/* 2823 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2824 */               .addComponent(this.jTextField50, -2, -1, -2)))));
/*      */ 
/*      */     
/* 2827 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/* 2828 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder(null, " Pólizas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2830 */     this.jLabel30.setFont(new Font("Tahoma", 2, 11));
/* 2831 */     this.jLabel30.setForeground(new Color(15, 87, 51));
/* 2832 */     this.jLabel30.setHorizontalAlignment(2);
/* 2833 */     this.jLabel30.setText("Vehicular");
/*      */     
/* 2835 */     this.jRadioButton4.setSelected(true);
/* 2836 */     this.jRadioButton4.setText("No");
/* 2837 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2839 */             TractoAgregar.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2843 */     this.jRadioButton5.setText("Si");
/* 2844 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2846 */             TractoAgregar.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2850 */     this.jRadioButton6.setText("Baja");
/* 2851 */     this.jRadioButton6.setEnabled(false);
/*      */     
/* 2853 */     this.jLabel56.setFont(new Font("Tahoma", 2, 11));
/* 2854 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 2855 */     this.jLabel56.setHorizontalAlignment(2);
/* 2856 */     this.jLabel56.setText("Ecológico");
/*      */     
/* 2858 */     this.jRadioButton10.setSelected(true);
/* 2859 */     this.jRadioButton10.setText("No");
/* 2860 */     this.jRadioButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2862 */             TractoAgregar.this.jRadioButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2866 */     this.jRadioButton11.setText("Si");
/* 2867 */     this.jRadioButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2869 */             TractoAgregar.this.jRadioButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2873 */     this.jRadioButton12.setText("Baja");
/* 2874 */     this.jRadioButton12.setEnabled(false);
/*      */     
/* 2876 */     this.jTextField32.setEditable(false);
/*      */     
/* 2878 */     this.jTextField33.setEditable(false);
/*      */     
/* 2880 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2881 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2882 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2883 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2884 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2885 */           .addContainerGap()
/* 2886 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2887 */             .addComponent(this.jLabel56, -2, 57, -2)
/* 2888 */             .addComponent(this.jLabel30, -2, 74, -2))
/* 2889 */           .addGap(4, 4, 4)
/* 2890 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2891 */             .addComponent(this.jTextField33, GroupLayout.Alignment.TRAILING)
/* 2892 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2893 */               .addComponent(this.jRadioButton4)
/* 2894 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2895 */               .addComponent(this.jRadioButton5)
/* 2896 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2897 */               .addComponent(this.jRadioButton6))
/* 2898 */             .addComponent(this.jTextField32, GroupLayout.Alignment.TRAILING)
/* 2899 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2900 */               .addComponent(this.jRadioButton10)
/* 2901 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2902 */               .addComponent(this.jRadioButton11)
/* 2903 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2904 */               .addComponent(this.jRadioButton12)))
/* 2905 */           .addGap(20, 20, 20)));
/*      */     
/* 2907 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2908 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2909 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2910 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2911 */             .addComponent(this.jRadioButton4)
/* 2912 */             .addComponent(this.jRadioButton5)
/* 2913 */             .addComponent(this.jRadioButton6, -2, 23, -2)
/* 2914 */             .addComponent(this.jLabel30))
/* 2915 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2916 */           .addComponent(this.jTextField32, -2, -1, -2)
/* 2917 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2918 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2919 */             .addComponent(this.jLabel56)
/* 2920 */             .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2921 */               .addComponent(this.jRadioButton10)
/* 2922 */               .addComponent(this.jRadioButton11)
/* 2923 */               .addComponent(this.jRadioButton12)))
/* 2924 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2925 */           .addComponent(this.jTextField33, -2, -1, -2)
/* 2926 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2929 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2930 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2931 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2932 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2933 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2934 */           .addContainerGap()
/* 2935 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2936 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2937 */               .addComponent(this.jLabel1, -1, -1, 32767)
/* 2938 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2939 */               .addComponent(this.jLabel14))
/* 2940 */             .addComponent(this.jPanel20, -1, -1, 32767)
/* 2941 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2942 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2943 */                 .addComponent(this.jPanel17, -2, 360, -2)
/* 2944 */                 .addComponent(this.jPanel21, -2, -1, -2))
/* 2945 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2946 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2947 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2948 */                   .addComponent(this.jPanel22, -1, -1, 32767)
/* 2949 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2950 */                   .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2951 */                     .addComponent(this.jButton4, -1, -1, 32767)
/* 2952 */                     .addComponent(this.jButton3, -1, -1, 32767)
/* 2953 */                     .addComponent(this.jButton1, -1, -1, 32767)
/* 2954 */                     .addComponent(this.jButton2, -1, 94, 32767)))
/* 2955 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 2956 */                   .addComponent(this.jPanel23, -2, -1, -2)
/* 2957 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2958 */                   .addComponent(this.jPanel30, -2, -1, -2)))))
/* 2959 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2961 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2962 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2963 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2964 */           .addContainerGap()
/* 2965 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2966 */             .addComponent(this.jLabel14)
/* 2967 */             .addComponent(this.jLabel1))
/* 2968 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2969 */           .addComponent(this.jPanel20, -2, -1, -2)
/* 2970 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2971 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2972 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2973 */               .addComponent(this.jPanel17, -2, -1, -2)
/* 2974 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2975 */               .addComponent(this.jPanel21, -2, -1, -2))
/* 2976 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2977 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2978 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 2979 */                   .addComponent(this.jButton2)
/* 2980 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2981 */                   .addComponent(this.jButton1)
/* 2982 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2983 */                   .addComponent(this.jButton3)
/* 2984 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2985 */                   .addComponent(this.jButton4))
/* 2986 */                 .addComponent(this.jPanel22, -2, -1, -2))
/* 2987 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2988 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2989 */                 .addComponent(this.jPanel30, -1, -1, 32767)
/* 2990 */                 .addComponent(this.jPanel23, -1, -1, 32767))))
/* 2991 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2994 */     GroupLayout layout = new GroupLayout(this);
/* 2995 */     setLayout(layout);
/* 2996 */     layout.setHorizontalGroup(layout
/* 2997 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2998 */         .addGap(0, 888, 32767)
/* 2999 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3000 */           .addGroup(layout.createSequentialGroup()
/* 3001 */             .addGap(0, 10, 32767)
/* 3002 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 3003 */             .addGap(0, 10, 32767))));
/*      */     
/* 3005 */     layout.setVerticalGroup(layout
/* 3006 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3007 */         .addGap(0, 431, 32767)
/* 3008 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3009 */           .addGroup(layout.createSequentialGroup()
/* 3010 */             .addGap(0, 13, 32767)
/* 3011 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 3012 */             .addGap(0, 13, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3017 */     this.error.pasarModal(false);
/* 3018 */     this.val.pasarModal(Boolean.valueOf(false));
/* 3019 */     String numTracto = this.jTextField1.getText();
/* 3020 */     String color = this.jTextField2.getText().toUpperCase();
/* 3021 */     String tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 3022 */     String estado = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     
/* 3024 */     String marca = String.valueOf(this.jComboBox2.getSelectedItem());
/* 3025 */     String modelo = String.valueOf(this.jComboBox7.getSelectedItem());
/* 3026 */     String serie = this.jTextField4.getText().toUpperCase();
/* 3027 */     String motor = this.jTextField5.getText();
/* 3028 */     String placas = this.jTextField7.getText().toUpperCase();
/*      */     
/* 3030 */     Date fAdquisicion = this.jDateChooser1.getDate();
/* 3031 */     String factu = this.jTextField6.getText();
/* 3032 */     String formaPago = "";
/*      */     
/* 3034 */     String km = this.jTextField9.getText();
/* 3035 */     String peso = this.jTextField10.getText();
/* 3036 */     String dimensiones = this.jTextField11.getText().toUpperCase();
/*      */     
/* 3038 */     String[] campos = { "Número de Tracto", "Color", "Tipo", "Marca", "Modelo", "Núm de Serie", "Núm de Motor", "Placas", "Fecha de Adquisición", "Núm Factura", "Forma de Pago", "KM Actual", "Peso Vehicular", "Dimensiones", "Permiso SEMARNAT", "Permiso SCT", "Permiso Sedere", "Póliza Vehicular", "Póliza Ecológica" };
/*      */     
/* 3040 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3041 */     String cadenaFecha = "";
/* 3042 */     String año1 = "";
/* 3043 */     String mes1 = "";
/* 3044 */     String dia1 = "";
/*      */     
/* 3046 */     String idMarca = "0";
/* 3047 */     String idTipo = "0";
/*      */     
/* 3049 */     String p1 = "0";
/* 3050 */     String p2 = "0";
/* 3051 */     String p3 = "0";
/* 3052 */     String p4 = "0";
/* 3053 */     String p5 = "0";
/*      */     
/* 3055 */     if (!this.jRadioButton1.isSelected()) {
/* 3056 */       p1 = this.jTextField30.getText();
/*      */     }
/* 3058 */     if (!this.jRadioButton7.isSelected()) {
/* 3059 */       p2 = this.jTextField31.getText();
/*      */     }
/* 3061 */     if (!this.jRadioButton17.isSelected()) {
/* 3062 */       p3 = this.jTextField50.getText();
/*      */     }
/* 3064 */     if (!this.jRadioButton4.isSelected()) {
/* 3065 */       p4 = this.jTextField32.getText();
/*      */     }
/* 3067 */     if (!this.jRadioButton10.isSelected()) {
/* 3068 */       p5 = this.jTextField33.getText();
/*      */     }
/* 3070 */     if (this.jComboBox1.getSelectedIndex() != 0 && this.jComboBox2.getSelectedIndex() != 0) {
/* 3071 */       this.con.consultar("id_marca", "marca", "where marca = '" + String.valueOf(this.jComboBox2.getSelectedItem()) + "'");
/* 3072 */       idMarca = this.con.Campo;
/* 3073 */       this.con.consultar("id_tipo", "tipos", "where tipo = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 3074 */       idTipo = this.con.Campo;
/*      */     } 
/* 3076 */     if (fAdquisicion != null) {
/* 3077 */       this.fecha = this.jDateChooser2.getDate();
/* 3078 */       cadenaFecha = formato.format(this.fecha);
/* 3079 */       año1 = cadenaFecha.substring(0, 4);
/* 3080 */       mes1 = cadenaFecha.substring(4, 6);
/* 3081 */       dia1 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3083 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3084 */       formaPago = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 3086 */     if (numTracto.equals("")) {
/* 3087 */       this.error.cargarError(this.jTextField1, "050");
/*      */     }
/* 3089 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3090 */       this.error.cargarError(this.jComboBox1, "050");
/*      */     }
/* 3092 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3093 */       this.error.cargarError(this.jComboBox1, "050");
/*      */     }
/* 3095 */     else if (this.jComboBox2.getSelectedIndex() == 0) {
/* 3096 */       this.error.cargarError(this.jComboBox2, "050");
/*      */     }
/* 3098 */     else if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3099 */       this.error.cargarError(this.jComboBox7, "050");
/*      */     }
/* 3101 */     else if (serie.equals("")) {
/* 3102 */       this.error.cargarError(this.jTextField4, "050");
/*      */     }
/* 3104 */     else if (motor.equals("")) {
/* 3105 */       this.error.cargarError(this.jTextField5, "050");
/*      */     }
/* 3107 */     else if (fAdquisicion == null) {
/* 3108 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar en blanco la fecha de adquisición, por favor verifica la información", "Fecha de Adquisición Vacía", 0, this.ERROR);
/*      */     }
/* 3110 */     else if (placas.equals("")) {
/* 3111 */       this.error.cargarError(this.jTextField7, "050");
/*      */     }
/* 3113 */     else if (!this.val.validarSoloNum(this.jTextField1, numTracto)) {
/* 3114 */       if (this.con.consultar("num_tracto", "tracto", "where num_tracto = " + this.jTextField1.getText()) && this.jButton1.getText().equals("Guardar")) {
/* 3115 */         this.jTextField1.setBackground(new Color(255, 51, 51));
/* 3116 */         JOptionPane.showMessageDialog(this.padre, "El número de Tracto que colocaste ya se encuentra registrado en la base de datos", "Número registrado", 0, this.ERROR);
/*      */         return;
/*      */       } 
/* 3119 */       if (!this.val.validarApostrofe(this.jTextField2, color, "020") && 
/* 3120 */         !this.val.validarApostrofe(this.jTextField4, serie, "020") && 
/* 3121 */         !this.val.validarApostrofe(this.jTextField5, motor, "020") && 
/* 3122 */         !this.val.validarPlacas(this.jTextField7, placas)) {
/* 3123 */         if (fAdquisicion.getYear() < 90) {
/* 3124 */           JOptionPane.showMessageDialog(this.padre, "La fecha de facturación no puede ser menor a 1990");
/*      */         }
/* 3126 */         else if (!this.val.validarDigitos(this.jTextField6, factu) && 
/* 3127 */           !this.val.validarDigitos(this.jTextField9, km) && 
/* 3128 */           !this.val.validarDigitos(this.jTextField10, peso) && 
/* 3129 */           !this.val.validarApostrofe(this.jTextField11, dimensiones, "020")) {
/* 3130 */           String[] info = { numTracto, color, tipo, marca, modelo, serie, motor, placas, año1 + "-" + año1 + "-" + mes1, factu, formaPago, km, peso, dimensiones, p1, p2, p3, p4, p5 };
/* 3131 */           if (!this.jTextField6.getText().equals("")) {
/* 3132 */             factu = this.jTextField6.getText();
/*      */           } else {
/*      */             
/* 3135 */             factu = "0";
/*      */           } 
/* 3137 */           if (!this.jTextField9.getText().equals("")) {
/* 3138 */             km = this.jTextField9.getText();
/*      */           } else {
/*      */             
/* 3141 */             km = "0";
/*      */           } 
/* 3143 */           if (!this.jTextField10.getText().equals("")) {
/* 3144 */             peso = this.jTextField10.getText();
/*      */           } else {
/*      */             
/* 3147 */             peso = "0";
/*      */           } 
/* 3149 */           if (this.jButton1.getText().equals("Modificar")) {
/* 3150 */             int res = this.error.cargarDatos2(campos, info);
/* 3151 */             if (res == 0) {
/* 3152 */               this.con.insertar("update tracto set modelo ='" + modelo + "', color = '" + color + "', no_serie='" + serie + "',no_motor='" + motor + "', num_factu=" + factu + ",forma_pago='" + formaPago + "',placas='" + placas + "',km_actual='" + km + "',peso=" + peso + ",dimen='" + dimensiones + "',estado='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "' where num_tracto = " + numTracto);
/* 3153 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Modificó el Tractor No: " + numTracto + "','Modelo: " + this.inf[0] + "\nColor: " + this.inf[1] + "\nNúmero de Serie: " + this.inf[2] + "\nNúmero de Motor: " + this.inf[3] + "\nNúmero de Factura " + this.inf[4] + "\nForma de Pago: " + this.inf[5] + "\nPlacas: " + this.inf[6] + "\nKm Actual: " + this.inf[7] + "\nPeso: " + this.inf[8] + "\nDimensión: " + this.inf[9] + "\nEstado: Alta\nFecha de Adquisición: " + this.inf[10] + "' )");
/* 3154 */               this.mensajeTry.guardarConf("Se ha modificado una unidad, USUARIO: " + this.USUARIO, "Unidad Modificada (" + this.jTextField1.getText() + ")", "INFO", "Perforacion");
/* 3155 */               limpiar();
/* 3156 */               consultar();
/* 3157 */               this.fichas.remove(1);
/*      */             } 
/*      */           } else {
/*      */             
/* 3161 */             int res = this.error.cargarDatos2(campos, info);
/* 3162 */             if (res == 0) {
/* 3163 */               this.con.insertar("insert into tracto(num_tracto,modelo,color,No_serie,No_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,id_marca,id_tipo,num_sem,num_sct,num_sed,num_seg,num_eco)values(" + numTracto + ",'" + modelo + "','" + color + "','" + serie + "','" + motor + "'," + factu + ",'" + formaPago + "','" + placas + "'," + km + "," + peso + ",'" + dimensiones + "','Activo','" + año1 + "-" + mes1 + "-" + dia1 + "'," + idMarca + "," + idTipo + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + ")");
/* 3164 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó el nuevo auto No: " + numTracto + "','Modelo: " + modelo + "\nColor: " + color + "\nNúmero de Serie: " + serie + "\nNúmero de Motor: " + motor + "\nNúmero de Factura " + factu + "\nForma de Pago: " + formaPago + "\nPlacas: " + placas + "\nKm Actual: " + km + "\nPeso: " + peso + "\nDimensión: " + dimensiones + "\nEstado: Alta\nFecha de Adquisición: " + año1 + "-" + mes1 + "-" + dia1 + "\nMarca: " + marca + "\nTipo: " + tipo + "' )");
/* 3165 */               this.mensajeTry.guardarConf("Se ha agregado una unidad, USUARIO: " + this.USUARIO, "Nueva Unidad (" + this.jTextField1.getText() + ")", "INFO", "Perforacion");
/* 3166 */               limpiar();
/*      */             } 
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
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3181 */     limpiar();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/* 3185 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3186 */     this.fichas.remove(1);
/* 3187 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseEntered(MouseEvent evt) {
/* 3191 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel14MouseExited(MouseEvent evt) {
/* 3195 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 3199 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 3203 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3204 */     this.fichas.remove(1);
/* 3205 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3209 */     consultar1();
/* 3210 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 3213 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3217 */     guardarMarcas();
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 3221 */     consultar2();
/* 3222 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 3226 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3227 */       this.datos.escribir();
/*      */     }
/* 3229 */     else if (this.jTextField9.getText().equals("") && this.jTextField2.getText().equals("") && this.jComboBox7.getSelectedIndex() == 0 && this.jTextField4.getText().equals("") && this.jTextField5.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField10.getText().equals("") && this.jTextField1.getText().equals("")) {
/* 3230 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 3235 */     int cont = 0;
/* 3236 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 3237 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 3238 */       this.jFormattedTextField1.setValue("");
/*      */     }
/* 3240 */     else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 3241 */       String cadena = this.jFormattedTextField1.getText();
/* 3242 */       String cad1 = cadena.substring(0, 3);
/* 3243 */       String cad2 = cadena.substring(4, 7);
/* 3244 */       String cad3 = cadena.substring(8, 12);
/* 3245 */       String tel = cad1 + cad1 + cad2;
/* 3246 */       for (int i = 1; i < tel.length(); i++) {
/* 3247 */         char c = tel.charAt(i - 1);
/* 3248 */         char d = tel.charAt(i);
/* 3249 */         if (c != d) {
/* 3250 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 3254 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 3255 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 3256 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 3261 */     if (this.jTextField32.getText().equals("")) {
/* 3262 */       this.jRadioButton4.setSelected(true);
/*      */     }
/* 3264 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 3268 */     limpiar2();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 3272 */     String[] campos = { "A Nombre de: ", "A Beneficio de ", "Tipo de Seguro", "Costo", "Fecha de Inicio", "Fecha de Vigencia", "Tiempo de Gracia", "Aseguradora", "Nombre del Agente", "Calle", "Número", "Colonia", "Ciudad", "C.P.", "Teléfono" };
/* 3273 */     this.error.pasarModal(true);
/* 3274 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3275 */     String nombre1 = this.jTextField14.getText();
/* 3276 */     String ap_pat1 = this.jTextField15.getText();
/* 3277 */     String ap_mat1 = this.jTextField16.getText();
/*      */     
/* 3279 */     String nombre2 = this.jTextField17.getText();
/* 3280 */     String ap_pat2 = this.jTextField18.getText();
/* 3281 */     String ap_mat2 = this.jTextField19.getText();
/*      */     
/* 3283 */     String tipo = this.jTextField20.getText();
/* 3284 */     String costo = this.jTextField21.getText();
/* 3285 */     String gracia = this.jTextField22.getText();
/* 3286 */     String cobertura = this.jTextArea1.getText();
/*      */     
/* 3288 */     String nombre3 = this.jTextField23.getText();
/* 3289 */     String nombre4 = this.jTextField24.getText();
/* 3290 */     String calle = this.jTextField25.getText();
/* 3291 */     String num = this.jTextField26.getText();
/* 3292 */     String col = this.jTextField27.getText();
/* 3293 */     String ciudad = this.jTextField28.getText();
/* 3294 */     String cp = this.jTextField29.getText();
/* 3295 */     String estado = "33";
/* 3296 */     String tel1 = this.jFormattedTextField1.getText();
/*      */     
/* 3298 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3299 */     String cadenaFecha = "";
/* 3300 */     String año1 = "";
/* 3301 */     String mes1 = "";
/* 3302 */     String dia1 = "";
/*      */     
/* 3304 */     String año2 = "";
/* 3305 */     String mes2 = "";
/* 3306 */     String dia2 = "";
/*      */     
/* 3308 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3309 */       estado = "" + this.jComboBox4.getSelectedIndex() - 1;
/*      */     }
/* 3311 */     String codigo = "0";
/* 3312 */     if (!this.jTextField29.getText().equals("")) {
/* 3313 */       codigo = cp;
/*      */     }
/* 3315 */     Date fecha1 = this.jDateChooser2.getDate();
/* 3316 */     Date fecha2 = this.jDateChooser5.getDate();
/* 3317 */     boolean f1 = false;
/* 3318 */     boolean f2 = false;
/* 3319 */     boolean valorC = false;
/* 3320 */     boolean esMayor = false;
/* 3321 */     if (fecha1 != null) {
/* 3322 */       f1 = true;
/*      */     }
/* 3324 */     if (fecha2 != null) {
/* 3325 */       f2 = true;
/*      */     }
/* 3327 */     if (f1 && f2) {
/* 3328 */       if (fecha2.after(fecha1)) {
/* 3329 */         esMayor = true;
/*      */       }
/* 3331 */       this.fecha = this.jDateChooser2.getDate();
/* 3332 */       cadenaFecha = formato.format(this.fecha);
/* 3333 */       año1 = cadenaFecha.substring(0, 4);
/* 3334 */       mes1 = cadenaFecha.substring(4, 6);
/* 3335 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3337 */       this.fecha = this.jDateChooser5.getDate();
/* 3338 */       cadenaFecha = formato.format(this.fecha);
/* 3339 */       año2 = cadenaFecha.substring(0, 4);
/* 3340 */       mes2 = cadenaFecha.substring(4, 6);
/* 3341 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3343 */     if (tel1.equals("___-___-____")) {
/* 3344 */       tel1 = "";
/*      */     }
/* 3346 */     float cos = 0.0F;
/* 3347 */     if (nombre1.equals("")) {
/* 3348 */       this.error.cargarError(this.jTextField14, "050");
/*      */     }
/* 3350 */     else if (ap_pat1.equals("")) {
/* 3351 */       this.error.cargarError(this.jTextField15, "050");
/*      */     }
/* 3353 */     else if (nombre2.equals("")) {
/* 3354 */       this.error.cargarError(this.jTextField17, "050");
/*      */     }
/* 3356 */     else if (ap_pat2.equals("")) {
/* 3357 */       this.error.cargarError(this.jTextField18, "050");
/*      */     }
/* 3359 */     else if (tipo.equals("")) {
/* 3360 */       this.error.cargarError(this.jTextField20, "050");
/*      */     }
/* 3362 */     else if (costo.equals("")) {
/* 3363 */       this.error.cargarError(this.jTextField21, "050");
/*      */     }
/* 3365 */     else if (!f1) {
/* 3366 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de inicio de la póliza", "Falta Fecha Inicio", 0, this.ADVER);
/*      */     }
/* 3368 */     else if (!f2) {
/* 3369 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de vigencia de la póliza", "Falta Fecha de Vigencia", 0, this.ADVER);
/*      */     }
/* 3371 */     else if (gracia.equals("")) {
/* 3372 */       this.error.cargarError(this.jTextField22, "050");
/*      */     }
/* 3374 */     else if (nombre3.equals("")) {
/* 3375 */       this.error.cargarError(this.jTextField23, "050");
/*      */     }
/* 3377 */     else if (nombre4.equals("")) {
/* 3378 */       this.error.cargarError(this.jTextField24, "050");
/*      */     }
/* 3380 */     else if (!this.val.validarNombres(this.jTextField14, nombre1, "010") && 
/* 3381 */       !this.val.validarNombres(this.jTextField15, ap_pat1, "010") && 
/* 3382 */       !this.val.validarNombres(this.jTextField16, ap_mat1, "010") && 
/* 3383 */       !this.val.validarNombres(this.jTextField17, nombre2, "010") && 
/* 3384 */       !this.val.validarNombres(this.jTextField18, ap_pat2, "010") && 
/* 3385 */       !this.val.validarNombres(this.jTextField19, ap_mat2, "010") && 
/* 3386 */       !this.val.validarApostrofe(this.jTextField20, tipo, "020") && 
/* 3387 */       !this.val.validarDigitos(this.jTextField21, costo)) {
/* 3388 */       if (!esMayor) {
/* 3389 */         JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */       }
/* 3391 */       else if (this.jDateChooser2.getDate().getYear() < 100) {
/* 3392 */         JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */       }
/* 3394 */       else if (!this.val.validarApostrofe(this.jTextArea1, cobertura, "020") && 
/* 3395 */         !this.val.validarDigitos(this.jTextField22, gracia) && 
/* 3396 */         !this.val.validarApostrofe(this.jTextField23, nombre3, "020") && 
/* 3397 */         !this.val.validarApostrofe(this.jTextField24, nombre4, "020") && 
/* 3398 */         !this.val.validarCalle(this.jTextField25, calle, "014")) {
/*      */         
/* 3400 */         if (!this.jTextField25.getText().equals("") && this.jTextField26.getText().equals("") && this.jTextField27.getText().equals("")) {
/* 3401 */           this.jTextField26.setBackground(new Color(255, 51, 51));
/* 3402 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/*      */         }
/* 3404 */         else if (!this.val.validarNumero(this.jTextField26, num.toUpperCase(), "015")) {
/* 3405 */           if (!this.jTextField26.getText().equals("") && this.jTextField25.getText().equals("")) {
/* 3406 */             this.jTextField25.setBackground(new Color(255, 51, 51));
/* 3407 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/*      */           }
/* 3409 */           else if (!this.val.validarDireccion(this.jTextField27, col, "014")) {
/* 3410 */             if (!this.jTextField27.getText().equals("") && this.jTextField25.getText().equals("")) {
/* 3411 */               this.jTextField25.setBackground(new Color(255, 51, 51));
/* 3412 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/*      */             }
/* 3414 */             else if (!this.val.validarCodigoPostal(this.jTextField29, cp, "014") && 
/* 3415 */               !this.val.validarRegion(this.jTextField28, ciudad, "018")) {
/* 3416 */               String[] info = { nombre1.toUpperCase() + " " + nombre1.toUpperCase() + " " + ap_pat1.toUpperCase(), nombre2.toUpperCase() + " " + nombre2.toUpperCase() + " " + ap_pat2.toUpperCase(), tipo.toUpperCase(), costo.toUpperCase(), fecha1.toString(), fecha2.toString(), gracia, nombre3.toUpperCase(), nombre4.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), ciudad.toUpperCase(), codigo, tel1 };
/* 3417 */               if (this.jButton13.getText().equals("Modificar")) {
/* 3418 */                 int res = this.error.cargarDatos2(campos, info);
/* 3419 */                 if (res == 0) {
/* 3420 */                   this.jDialog2.setVisible(false);
/* 3421 */                   this.con.insertar("update vehicular_carro set nombre1='" + nombre1.toUpperCase() + "', ap_pat1='" + ap_pat1.toUpperCase() + "', ap_mat1='" + ap_mat1.toUpperCase() + "', nombre2='" + nombre2.toUpperCase() + "', ap_pat2='" + ap_pat2.toUpperCase() + "', ap_mat2='" + ap_mat2.toUpperCase() + "', tipo_seg='" + tipo.toUpperCase() + "', costo=" + costo + ",fecha_inicio='" + año1 + "-" + mes1 + "-" + dia1 + "', fecha_vigen='" + año2 + "-" + mes2 + "-" + dia2 + "',gracia=" + gracia + ",cobertura='" + cobertura + "',nombre3='" + nombre3.toUpperCase() + "',nombre4='" + nombre4.toUpperCase() + "',calle='" + calle.toUpperCase() + "',num='" + num.toUpperCase() + "',col='" + col.toUpperCase() + "',ciudad='" + ciudad.toUpperCase() + "',cp=" + codigo + ",telefono='" + tel1 + "',id_edo =" + estado + "  where num_seg=" + this.jTextField32.getText());
/* 3422 */                   this.jRadioButton5.setSelected(true);
/*      */                 } 
/*      */               } else {
/*      */                 
/* 3426 */                 int res = this.error.cargarDatos(campos, info);
/* 3427 */                 if (res == 0) {
/* 3428 */                   this.con.insertar("insert into vehicular_carro(nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo)values('" + nombre1.toUpperCase() + "','" + ap_pat1.toUpperCase() + "','" + ap_mat1.toUpperCase() + "','" + nombre2.toUpperCase() + "','" + ap_pat2.toUpperCase() + "','" + ap_mat2.toUpperCase() + "','" + tipo.toUpperCase() + "'," + costo + ",'" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "'," + gracia + ",'" + cobertura + "','" + nombre3.toUpperCase() + "','" + nombre4.toUpperCase() + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "','" + ciudad.toUpperCase() + "'," + codigo + ",'" + tel1 + "'," + estado + " )");
/*      */                   
/* 3430 */                   limpiar2();
/* 3431 */                   this.jDialog2.setVisible(false);
/* 3432 */                   this.con.consultar("max(num_seg)", "vehicular_carro", "");
/* 3433 */                   this.jTextField32.setText(this.con.Campo);
/* 3434 */                   this.jRadioButton5.setSelected(true);
/*      */                 } 
/*      */               } 
/*      */             } 
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
/*      */ 
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 3457 */     cargarFormulario1();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 3461 */     guardarTipos();
/*      */   }
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 3464 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 3468 */     String ind = "";
/* 3469 */     int contar = 0;
/* 3470 */     int contador = 0;
/* 3471 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 3472 */       String val = String.valueOf(this.jTable2.getValueAt(i, 0));
/* 3473 */       if (val.equals("true")) {
/* 3474 */         contar++;
/*      */       }
/*      */     } 
/* 3477 */     if (contar == 0) {
/* 3478 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar tipos", "Selecciona Un Tipo", 0, this.INFO);
/*      */     }
/* 3480 */     else if (contar == 1) {
/* 3481 */       int doc = 0;
/* 3482 */       for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 3483 */         String val = String.valueOf(this.jTable2.getValueAt(j, 0));
/* 3484 */         if (val.equals("true")) {
/* 3485 */           String str = String.valueOf(this.jTable2.getValueAt(j, 1));
/* 3486 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3490 */       String valor = "<html><b>Clave del Tipo: </b>" + String.valueOf(this.jTable2.getValueAt(doc, 1)) + "<br><b>Tipo de Carro: </b>" + String.valueOf(this.jTable2.getValueAt(doc, 2)) + "<br></html>";
/* 3491 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Tipo", 0, 3, this.ELIMINAR);
/* 3492 */       if (res == 0) {
/* 3493 */         String val = String.valueOf(this.jTable2.getValueAt(doc, 1));
/* 3494 */         String[] reg = this.con.regresaReg("id_tipo,tipo", "tipos", "where id_tipo = " + val, 2);
/* 3495 */         this.con.eliminar("Tipos", "where id_tipo=" + val);
/* 3496 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el tipo de carro " + val + " definitivamente.','Clave Tipo: " + val + "\nTipo: " + reg[1] + "')");
/* 3497 */         consultar2();
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 3502 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Marcas", 0, 3, this.ELIMINAR);
/* 3503 */       if (res == 0) {
/* 3504 */         for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 3505 */           String val = String.valueOf(this.jTable2.getValueAt(j, 0));
/* 3506 */           if (val.equals("true")) {
/* 3507 */             String valor = String.valueOf(this.jTable2.getValueAt(j, 1));
/* 3508 */             String[] reg = this.con.regresaReg("id_tipo,tipo", "tipos", "where id_tipo = " + valor, 2);
/* 3509 */             contador++;
/* 3510 */             this.con.eliminar2("Tipos", "where id_tipo=" + valor);
/* 3511 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el tipo de carro " + valor + " definitivamente.','Clave Tipo: " + valor + "\nTipo: " + reg[1] + "')");
/*      */           } 
/*      */         } 
/* 3514 */         consultar2();
/* 3515 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " empleados.", "Empleados Eliminados", 0, this.INFO);
/*      */       } 
/*      */     } 
/* 3518 */     llenarCombo();
/*      */   }
/*      */   
/*      */   private void jTextField13ActionPerformed(ActionEvent evt) {
/* 3522 */     guardarTipos();
/*      */   }
/*      */   
/*      */   private void jTextField12ActionPerformed(ActionEvent evt) {
/* 3526 */     guardarMarcas();
/*      */   }
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 3530 */     if (this.jTextField32.getText().equals("")) {
/* 3531 */       this.jButton13.setText("Guardar");
/* 3532 */       this.jButton14.setVisible(false);
/* 3533 */       limpiar2();
/* 3534 */       this.jDialog2.setVisible(true);
/*      */     } else {
/*      */       
/* 3537 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza vehicular\n¿Deseas modificar algunos de éstos datos?", "Modificar Seguro Vehicular", 0, 3, this.PREG);
/* 3538 */       if (resp == 0) {
/* 3539 */         cargarFormulario1();
/* 3540 */         this.jButton13.setText("Modificar");
/* 3541 */         this.jButton14.setVisible(true);
/* 3542 */         this.jDialog2.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 3548 */     String camp = this.jTextField32.getText();
/* 3549 */     if (!camp.equals("")) {
/* 3550 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza\n¿Deseas quitar esa información?", "Quitar Seguro Vehicular", 0, 3, this.PREG);
/* 3551 */       if (resp == 0) {
/* 3552 */         this.jRadioButton4.setSelected(true);
/* 3553 */         this.jTextField32.setText("");
/*      */       } else {
/*      */         
/* 3556 */         this.jRadioButton5.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 3562 */     String ind = "";
/* 3563 */     int contar = 0;
/* 3564 */     int contador = 0;
/* 3565 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3566 */       String val = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 3567 */       if (val.equals("true")) {
/* 3568 */         contar++;
/*      */       }
/*      */     } 
/* 3571 */     if (contar == 0) {
/* 3572 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar marcas", "Selecciona Una Marca", 0, this.INFO);
/*      */     }
/* 3574 */     else if (contar == 1) {
/* 3575 */       int doc = 0;
/* 3576 */       for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3577 */         String val = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3578 */         if (val.equals("true")) {
/* 3579 */           String str = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3580 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3584 */       String valor = "<html><b>Clave de la Marca: </b>" + String.valueOf(this.jTable1.getValueAt(doc, 1)) + "<br><b>Marca: </b>" + String.valueOf(this.jTable1.getValueAt(doc, 2)) + "<br></html>";
/* 3585 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Marca", 0, 3, this.ELIMINAR);
/* 3586 */       if (res == 0) {
/* 3587 */         String val = String.valueOf(this.jTable1.getValueAt(doc, 1));
/* 3588 */         String[] reg = this.con.regresaReg("id_marca,marca", "marca", "where id_marca = " + val, 2);
/* 3589 */         this.con.eliminar("marca", "where id_marca=" + val);
/* 3590 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó la marca de carro " + val + " definitivamente.','Clave de la Marca: " + val + "\nMarca: " + reg[1] + "')");
/* 3591 */         consultar1();
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 3596 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Marcas", 0, 3, this.ELIMINAR);
/* 3597 */       if (res == 0) {
/* 3598 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3599 */           String val = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3600 */           if (val.equals("true")) {
/* 3601 */             String valor = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3602 */             String[] reg = this.con.regresaReg("id_marca,marca", "marca", "where id_marca = " + valor, 2);
/* 3603 */             contador++;
/* 3604 */             this.con.eliminar2("marca", "where id_marca=" + valor);
/* 3605 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó la marca de carro " + valor + " definitivamente.','Clave de la Marca: " + valor + "\nMarca: " + reg[1] + "')");
/*      */           } 
/*      */         } 
/* 3608 */         consultar1();
/* 3609 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " marcas.", "Marcas Eliminadas", 0, this.INFO);
/*      */       } 
/*      */     } 
/* 3612 */     llenarCombo2();
/*      */   }
/*      */   
/*      */   private void jDialog2WindowClosing(WindowEvent evt) {
/* 3616 */     if (this.jTextField32.getText().equals("")) {
/* 3617 */       this.jRadioButton4.setSelected(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField2FocusLost(FocusEvent evt) {
/* 3626 */     int cont = 0;
/* 3627 */     if (this.jFormattedTextField2.getText().contains("_") && !this.jFormattedTextField2.getText().equals("___-___-____")) {
/* 3628 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField2.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 3629 */       this.jFormattedTextField2.setValue("");
/*      */     }
/* 3631 */     else if (!this.jFormattedTextField2.getText().contains("_")) {
/* 3632 */       String cadena = this.jFormattedTextField2.getText();
/* 3633 */       String cad1 = cadena.substring(0, 3);
/* 3634 */       String cad2 = cadena.substring(4, 7);
/* 3635 */       String cad3 = cadena.substring(8, 12);
/* 3636 */       String tel = cad1 + cad1 + cad2;
/* 3637 */       for (int i = 1; i < tel.length(); i++) {
/* 3638 */         char c = tel.charAt(i - 1);
/* 3639 */         char d = tel.charAt(i);
/* 3640 */         if (c != d) {
/* 3641 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 3645 */     if (cont == 0 && !this.jFormattedTextField2.getText().contains("_")) {
/* 3646 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 3647 */       this.jFormattedTextField2.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3652 */     if (this.jTextField33.getText().equals("")) {
/* 3653 */       this.jRadioButton10.setSelected(true);
/*      */     }
/* 3655 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 3659 */     limpiar3();
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3663 */     String[] campos = { "A Nombre de: ", "A Beneficio de ", "Tipo de Seguro", "Costo", "Fecha de Inicio", "Fecha de Vigencia", "Tiempo de Gracia", "Aseguradora", "Nombre del Agente", "Calle", "Número", "Colonia", "Ciudad", "C.P.", "Teléfono" };
/* 3664 */     this.error.pasarModal(true);
/* 3665 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3666 */     String nombre1 = this.jTextField34.getText();
/* 3667 */     String ap_pat1 = this.jTextField35.getText();
/* 3668 */     String ap_mat1 = this.jTextField36.getText();
/*      */     
/* 3670 */     String nombre2 = this.jTextField37.getText();
/* 3671 */     String ap_pat2 = this.jTextField38.getText();
/* 3672 */     String ap_mat2 = this.jTextField39.getText();
/*      */     
/* 3674 */     String tipo = this.jTextField40.getText();
/* 3675 */     String costo = this.jTextField41.getText();
/* 3676 */     String gracia = this.jTextField42.getText();
/* 3677 */     String cobertura = this.jTextArea2.getText();
/*      */     
/* 3679 */     String nombre3 = this.jTextField43.getText();
/* 3680 */     String nombre4 = this.jTextField44.getText();
/* 3681 */     String calle = this.jTextField45.getText();
/* 3682 */     String num = this.jTextField46.getText();
/* 3683 */     String col = this.jTextField47.getText();
/* 3684 */     String ciudad = this.jTextField48.getText();
/* 3685 */     String cp = this.jTextField49.getText();
/* 3686 */     String estado = "33";
/* 3687 */     String tel1 = this.jFormattedTextField2.getText();
/*      */     
/* 3689 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3690 */     String cadenaFecha = "";
/* 3691 */     String año1 = "";
/* 3692 */     String mes1 = "";
/* 3693 */     String dia1 = "";
/*      */     
/* 3695 */     String año2 = "";
/* 3696 */     String mes2 = "";
/* 3697 */     String dia2 = "";
/*      */     
/* 3699 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3700 */       estado = "" + this.jComboBox6.getSelectedIndex() - 1;
/*      */     }
/* 3702 */     String codigo = "0";
/* 3703 */     if (!this.jTextField49.getText().equals("")) {
/* 3704 */       codigo = cp;
/*      */     }
/* 3706 */     Date fecha1 = this.jDateChooser3.getDate();
/* 3707 */     Date fecha2 = this.jDateChooser6.getDate();
/* 3708 */     boolean f1 = false;
/* 3709 */     boolean f2 = false;
/* 3710 */     boolean valorC = false;
/* 3711 */     boolean esMayor = false;
/* 3712 */     if (fecha1 != null) {
/* 3713 */       f1 = true;
/*      */     }
/* 3715 */     if (fecha2 != null) {
/* 3716 */       f2 = true;
/*      */     }
/* 3718 */     if (f1 && f2) {
/* 3719 */       if (fecha2.after(fecha1)) {
/* 3720 */         esMayor = true;
/*      */       }
/* 3722 */       this.fecha = this.jDateChooser3.getDate();
/* 3723 */       cadenaFecha = formato.format(this.fecha);
/* 3724 */       año1 = cadenaFecha.substring(0, 4);
/* 3725 */       mes1 = cadenaFecha.substring(4, 6);
/* 3726 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3728 */       this.fecha = this.jDateChooser6.getDate();
/* 3729 */       cadenaFecha = formato.format(this.fecha);
/* 3730 */       año2 = cadenaFecha.substring(0, 4);
/* 3731 */       mes2 = cadenaFecha.substring(4, 6);
/* 3732 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3734 */     if (tel1.equals("___-___-____")) {
/* 3735 */       tel1 = "";
/*      */     }
/* 3737 */     float cos = 0.0F;
/* 3738 */     if (nombre1.equals("")) {
/* 3739 */       this.error.cargarError(this.jTextField34, "050");
/*      */     }
/* 3741 */     else if (ap_pat1.equals("")) {
/* 3742 */       this.error.cargarError(this.jTextField35, "050");
/*      */     }
/* 3744 */     else if (nombre2.equals("")) {
/* 3745 */       this.error.cargarError(this.jTextField37, "050");
/*      */     }
/* 3747 */     else if (ap_pat2.equals("")) {
/* 3748 */       this.error.cargarError(this.jTextField38, "050");
/*      */     }
/* 3750 */     else if (tipo.equals("")) {
/* 3751 */       this.error.cargarError(this.jTextField40, "050");
/*      */     }
/* 3753 */     else if (costo.equals("")) {
/* 3754 */       this.error.cargarError(this.jTextField41, "050");
/*      */     }
/* 3756 */     else if (!f1) {
/* 3757 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de inicio de la póliza", "Falta Fecha Inicio", 0, this.ADVER);
/*      */     }
/* 3759 */     else if (!f2) {
/* 3760 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de vigencia de la póliza", "Falta Fecha de Vigencia", 0, this.ADVER);
/*      */     }
/* 3762 */     else if (gracia.equals("")) {
/* 3763 */       this.error.cargarError(this.jTextField42, "050");
/*      */     }
/* 3765 */     else if (nombre3.equals("")) {
/* 3766 */       this.error.cargarError(this.jTextField43, "050");
/*      */     }
/* 3768 */     else if (nombre4.equals("")) {
/* 3769 */       this.error.cargarError(this.jTextField44, "050");
/*      */     }
/* 3771 */     else if (!this.val.validarNombres(this.jTextField34, nombre1, "010") && 
/* 3772 */       !this.val.validarNombres(this.jTextField35, ap_pat1, "010") && 
/* 3773 */       !this.val.validarNombres(this.jTextField36, ap_mat1, "010") && 
/* 3774 */       !this.val.validarNombres(this.jTextField37, nombre2, "010") && 
/* 3775 */       !this.val.validarNombres(this.jTextField38, ap_pat2, "010") && 
/* 3776 */       !this.val.validarNombres(this.jTextField39, ap_mat2, "010") && 
/* 3777 */       !this.val.validarApostrofe(this.jTextField40, tipo, "020") && 
/* 3778 */       !this.val.validarDigitos(this.jTextField41, costo)) {
/* 3779 */       if (!esMayor) {
/* 3780 */         JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */       }
/* 3782 */       else if (this.jDateChooser2.getDate().getYear() < 100) {
/* 3783 */         JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2009/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */       }
/* 3785 */       else if (!this.val.validarApostrofe(this.jTextArea2, cobertura, "020") && 
/* 3786 */         !this.val.validarDigitos(this.jTextField42, gracia) && 
/* 3787 */         !this.val.validarApostrofe(this.jTextField43, nombre3, "020") && 
/* 3788 */         !this.val.validarApostrofe(this.jTextField44, nombre4, "020") && 
/* 3789 */         !this.val.validarCalle(this.jTextField45, calle, "014")) {
/* 3790 */         if (!this.jTextField45.getText().equals("") && this.jTextField46.getText().equals("") && this.jTextField47.getText().equals("")) {
/* 3791 */           this.jTextField46.setBackground(new Color(255, 51, 51));
/* 3792 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/*      */         }
/* 3794 */         else if (!this.val.validarNumero(this.jTextField46, num.toUpperCase(), "015")) {
/* 3795 */           if (!this.jTextField46.getText().equals("") && this.jTextField45.getText().equals("")) {
/* 3796 */             this.jTextField45.setBackground(new Color(255, 51, 51));
/* 3797 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/*      */           }
/* 3799 */           else if (!this.val.validarDireccion(this.jTextField47, col, "014")) {
/* 3800 */             if (!this.jTextField47.getText().equals("") && this.jTextField45.getText().equals("")) {
/* 3801 */               this.jTextField45.setBackground(new Color(255, 51, 51));
/* 3802 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/*      */             }
/* 3804 */             else if (!this.val.validarCodigoPostal(this.jTextField49, cp, "014") && 
/* 3805 */               !this.val.validarRegion(this.jTextField48, ciudad, "018")) {
/* 3806 */               String[] info = { nombre1.toUpperCase() + " " + nombre1.toUpperCase() + " " + ap_pat1.toUpperCase(), nombre2.toUpperCase() + " " + nombre2.toUpperCase() + " " + ap_pat2.toUpperCase(), tipo.toUpperCase(), costo.toUpperCase(), fecha1.toString(), fecha2.toString(), gracia, nombre3.toUpperCase(), nombre4.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), ciudad.toUpperCase(), codigo, tel1 };
/* 3807 */               if (this.jButton19.getText().equals("Modificar")) {
/* 3808 */                 int res = this.error.cargarDatos2(campos, info);
/* 3809 */                 if (res == 0) {
/* 3810 */                   this.jDialog4.setVisible(false);
/* 3811 */                   this.con.insertar("update ecologico set nombre1='" + nombre1.toUpperCase() + "', ap_pat1='" + ap_pat1.toUpperCase() + "', ap_mat1='" + ap_mat1.toUpperCase() + "', nombre2='" + nombre2.toUpperCase() + "', ap_pat2='" + ap_pat2.toUpperCase() + "', ap_mat2='" + ap_mat2.toUpperCase() + "', tipo_seg='" + tipo.toUpperCase() + "', costo=" + costo + ",fecha_inicio='" + año1 + "-" + mes1 + "-" + dia1 + "', fecha_vigen='" + año2 + "-" + mes2 + "-" + dia2 + "',gracia=" + gracia + ",cobertura='" + cobertura + "',nombre3='" + nombre3.toUpperCase() + "',nombre4='" + nombre4.toUpperCase() + "',calle='" + calle.toUpperCase() + "',num='" + num.toUpperCase() + "',col='" + col.toUpperCase() + "',ciudad='" + ciudad.toUpperCase() + "',cp=" + codigo + ",telefono='" + tel1 + "',id_edo =" + estado + "  where num_eco=" + this.jTextField33.getText());
/* 3812 */                   this.jRadioButton11.setSelected(true);
/*      */                 } 
/*      */               } else {
/*      */                 
/* 3816 */                 int res = this.error.cargarDatos(campos, info);
/* 3817 */                 if (res == 0) {
/* 3818 */                   this.con.insertar("insert into ecologico(nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo)values('" + nombre1.toUpperCase() + "','" + ap_pat1.toUpperCase() + "','" + ap_mat1.toUpperCase() + "','" + nombre2.toUpperCase() + "','" + ap_pat2.toUpperCase() + "','" + ap_mat2.toUpperCase() + "','" + tipo.toUpperCase() + "'," + costo + ",'" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "'," + gracia + ",'" + cobertura + "','" + nombre3.toUpperCase() + "','" + nombre4.toUpperCase() + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "','" + ciudad.toUpperCase() + "'," + codigo + ",'" + tel1 + "'," + estado + " )");
/*      */                   
/* 3820 */                   limpiar2();
/* 3821 */                   this.jDialog4.setVisible(false);
/* 3822 */                   this.con.consultar("max(num_eco)", "ecologico", "");
/* 3823 */                   this.jTextField33.setText(this.con.Campo);
/* 3824 */                   this.jRadioButton11.setSelected(true);
/*      */                 } 
/*      */               } 
/*      */             } 
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
/*      */ 
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 3847 */     cargarFormulario2();
/*      */   }
/*      */   
/*      */   private void jDialog4WindowClosing(WindowEvent evt) {
/* 3851 */     if (this.jTextField33.getText().equals("")) {
/* 3852 */       this.jRadioButton10.setSelected(true);
/*      */     }
/* 3854 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton11ActionPerformed(ActionEvent evt) {
/* 3858 */     if (this.jTextField33.getText().equals("")) {
/* 3859 */       this.jButton19.setText("Guardar");
/* 3860 */       this.jButton20.setVisible(false);
/* 3861 */       limpiar3();
/* 3862 */       this.jDialog4.setVisible(true);
/*      */     } else {
/*      */       
/* 3865 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza ecológica\n¿Deseas modificar algunos de éstos datos?", "Modificar Póliza Ecológica", 0, 3, this.PREG);
/* 3866 */       if (resp == 0) {
/* 3867 */         cargarFormulario2();
/* 3868 */         this.jButton19.setText("Modificar");
/* 3869 */         this.jButton20.setVisible(true);
/* 3870 */         this.jDialog4.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton10ActionPerformed(ActionEvent evt) {
/* 3876 */     String camp = this.jTextField33.getText();
/* 3877 */     if (!camp.equals("")) {
/* 3878 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza\n¿Deseas quitar esa información?", "Quitar Seguro Vehicular", 0, 3, this.PREG);
/* 3879 */       if (resp == 0) {
/* 3880 */         this.jRadioButton10.setSelected(true);
/* 3881 */         this.jTextField33.setText("");
/*      */       } else {
/*      */         
/* 3884 */         this.jRadioButton11.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 3890 */     if (this.jTextField30.getText().equals("")) {
/* 3891 */       this.jButton23.setText("Guardar");
/* 3892 */       this.jButton24.setVisible(false);
/* 3893 */       limpiar4();
/* 3894 */       this.jDialog5.setVisible(true);
/*      */     } else {
/*      */       
/* 3897 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de SEMARNAT\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 3898 */       if (resp == 0) {
/* 3899 */         cargarFormulario3();
/* 3900 */         this.jButton23.setText("Modificar");
/* 3901 */         this.jButton24.setVisible(true);
/* 3902 */         this.jDialog5.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3908 */     if (this.jTextField30.getText().equals("")) {
/* 3909 */       this.jRadioButton1.setSelected(true);
/*      */     }
/* 3911 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jDialog5WindowClosing(WindowEvent evt) {
/* 3915 */     if (this.jTextField30.getText().equals("")) {
/* 3916 */       this.jRadioButton1.setSelected(true);
/*      */     }
/* 3918 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 3922 */     limpiar4();
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 3926 */     this.error.pasarModal(true);
/* 3927 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3928 */     boolean alta = this.jRadioButton13.isSelected();
/* 3929 */     String tipo = "Alta";
/* 3930 */     Date fecha1 = this.jDateChooser4.getDate();
/* 3931 */     Date fecha2 = this.jDateChooser7.getDate();
/* 3932 */     String comentario = this.jTextArea3.getText();
/* 3933 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 3935 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3936 */     String cadenaFecha = "";
/*      */     
/* 3938 */     String año1 = "";
/* 3939 */     String mes1 = "";
/* 3940 */     String dia1 = "";
/*      */     
/* 3942 */     String año2 = "";
/* 3943 */     String mes2 = "";
/* 3944 */     String dia2 = "";
/*      */     
/* 3946 */     boolean f1 = false;
/* 3947 */     boolean f2 = false;
/* 3948 */     boolean valorC = false;
/* 3949 */     boolean esMayor = false;
/*      */     
/* 3951 */     if (!alta) {
/* 3952 */       tipo = "Renovación";
/*      */     }
/* 3954 */     if (fecha1 != null) {
/* 3955 */       f1 = true;
/*      */     }
/* 3957 */     if (fecha2 != null) {
/* 3958 */       f2 = true;
/*      */     }
/* 3960 */     if (f1 && f2) {
/* 3961 */       if (fecha2.after(fecha1)) {
/* 3962 */         esMayor = true;
/*      */       }
/* 3964 */       this.fecha = this.jDateChooser4.getDate();
/* 3965 */       cadenaFecha = formato.format(this.fecha);
/* 3966 */       año1 = cadenaFecha.substring(0, 4);
/* 3967 */       mes1 = cadenaFecha.substring(4, 6);
/* 3968 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3970 */       this.fecha = this.jDateChooser7.getDate();
/* 3971 */       cadenaFecha = formato.format(this.fecha);
/* 3972 */       año2 = cadenaFecha.substring(0, 4);
/* 3973 */       mes2 = cadenaFecha.substring(4, 6);
/* 3974 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3976 */     if (!f1) {
/* 3977 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 3979 */     else if (!f2) {
/* 3980 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 3982 */     else if (!esMayor) {
/* 3983 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 3985 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 3986 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 3988 */     else if (!this.val.validarApostrofe(this.jTextArea3, this.jTextArea3.getText(), "020")) {
/* 3989 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 3990 */       if (this.jButton19.getText().equals("Modificar")) {
/* 3991 */         int res = this.error.cargarDatos2(campos, info);
/* 3992 */         if (res == 0) {
/* 3993 */           this.jDialog4.setVisible(false);
/* 3994 */           this.con.insertar("update ");
/* 3995 */           this.jRadioButton2.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 3999 */         int res = this.error.cargarDatos(campos, info);
/* 4000 */         if (res == 0) {
/* 4001 */           this.con.insertar("insert into semarnat (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea3.getText() + "')");
/* 4002 */           limpiar4();
/* 4003 */           this.jDialog5.setVisible(false);
/* 4004 */           this.con.consultar("max(num_sem)", "semarnat", "");
/* 4005 */           this.jTextField30.setText(this.con.Campo);
/* 4006 */           this.jRadioButton2.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 4013 */     String camp = this.jTextField30.getText();
/* 4014 */     if (!camp.equals("")) {
/* 4015 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de SEMARNAT\n¿Deseas quitar esa información?", "Quitar Permiso SEMARNAT", 0, 3, this.PREG);
/* 4016 */       if (resp == 0) {
/* 4017 */         this.jRadioButton1.setSelected(true);
/* 4018 */         this.jTextField30.setText("");
/*      */       } else {
/*      */         
/* 4021 */         this.jRadioButton2.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 4027 */     if (this.jTextField31.getText().equals("")) {
/* 4028 */       this.jRadioButton7.setSelected(true);
/*      */     }
/* 4030 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 4034 */     limpiar5();
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 4038 */     this.error.pasarModal(true);
/* 4039 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4040 */     boolean alta = this.jRadioButton15.isSelected();
/* 4041 */     String tipo = "Alta";
/* 4042 */     Date fecha1 = this.jDateChooser8.getDate();
/* 4043 */     Date fecha2 = this.jDateChooser9.getDate();
/* 4044 */     String comentario = this.jTextArea4.getText();
/* 4045 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 4047 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4048 */     String cadenaFecha = "";
/*      */     
/* 4050 */     String año1 = "";
/* 4051 */     String mes1 = "";
/* 4052 */     String dia1 = "";
/*      */     
/* 4054 */     String año2 = "";
/* 4055 */     String mes2 = "";
/* 4056 */     String dia2 = "";
/*      */     
/* 4058 */     boolean f1 = false;
/* 4059 */     boolean f2 = false;
/* 4060 */     boolean valorC = false;
/* 4061 */     boolean esMayor = false;
/*      */     
/* 4063 */     if (!alta) {
/* 4064 */       tipo = "Renovación";
/*      */     }
/* 4066 */     if (fecha1 != null) {
/* 4067 */       f1 = true;
/*      */     }
/* 4069 */     if (fecha2 != null) {
/* 4070 */       f2 = true;
/*      */     }
/* 4072 */     if (f1 && f2) {
/* 4073 */       if (fecha2.after(fecha1)) {
/* 4074 */         esMayor = true;
/*      */       }
/* 4076 */       this.fecha = this.jDateChooser8.getDate();
/* 4077 */       cadenaFecha = formato.format(this.fecha);
/* 4078 */       año1 = cadenaFecha.substring(0, 4);
/* 4079 */       mes1 = cadenaFecha.substring(4, 6);
/* 4080 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 4082 */       this.fecha = this.jDateChooser9.getDate();
/* 4083 */       cadenaFecha = formato.format(this.fecha);
/* 4084 */       año2 = cadenaFecha.substring(0, 4);
/* 4085 */       mes2 = cadenaFecha.substring(4, 6);
/* 4086 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 4088 */     if (!f1) {
/* 4089 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 4091 */     else if (!f2) {
/* 4092 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 4094 */     else if (!esMayor) {
/* 4095 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 4097 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 4098 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 4100 */     else if (!this.val.validarApostrofe(this.jTextArea4, this.jTextArea4.getText(), "020")) {
/* 4101 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 4102 */       if (this.jButton27.getText().equals("Modificar")) {
/* 4103 */         int res = this.error.cargarDatos2(campos, info);
/* 4104 */         if (res == 0) {
/* 4105 */           this.jDialog6.setVisible(false);
/* 4106 */           this.con.insertar("update ");
/* 4107 */           this.jRadioButton8.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 4111 */         int res = this.error.cargarDatos(campos, info);
/* 4112 */         if (res == 0) {
/* 4113 */           this.con.insertar("insert into sct (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea4.getText().toUpperCase() + "')");
/* 4114 */           limpiar5();
/* 4115 */           this.jDialog6.setVisible(false);
/* 4116 */           this.con.consultar("max(num_sct)", "sct", "");
/* 4117 */           this.jTextField31.setText(this.con.Campo);
/* 4118 */           this.jRadioButton8.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jDialog6WindowClosing(WindowEvent evt) {
/* 4125 */     if (this.jTextField31.getText().equals("")) {
/* 4126 */       this.jRadioButton7.setSelected(true);
/*      */     }
/* 4128 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 4132 */     cargarFormulario3();
/*      */   }
/*      */   
/*      */   private void jRadioButton8ActionPerformed(ActionEvent evt) {
/* 4136 */     if (this.jTextField31.getText().equals("")) {
/* 4137 */       this.jButton27.setText("Guardar");
/* 4138 */       this.jButton28.setVisible(false);
/* 4139 */       limpiar5();
/* 4140 */       this.jDialog6.setVisible(true);
/*      */     } else {
/*      */       
/* 4143 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de SCT\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 4144 */       if (resp == 0) {
/* 4145 */         cargarFormulario4();
/* 4146 */         this.jButton27.setText("Modificar");
/* 4147 */         this.jButton28.setVisible(true);
/* 4148 */         this.jDialog6.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton7ActionPerformed(ActionEvent evt) {
/* 4154 */     String camp = this.jTextField31.getText();
/* 4155 */     if (!camp.equals("")) {
/* 4156 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de SCT\n¿Deseas quitar esa información?", "Quitar Permiso SCT", 0, 3, this.PREG);
/* 4157 */       if (resp == 0) {
/* 4158 */         this.jRadioButton7.setSelected(true);
/* 4159 */         this.jTextField31.setText("");
/*      */       } else {
/*      */         
/* 4162 */         this.jRadioButton8.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 4168 */     cargarFormulario4();
/*      */   }
/*      */   
/*      */   private void jRadioButton17ActionPerformed(ActionEvent evt) {
/* 4172 */     String camp = this.jTextField50.getText();
/* 4173 */     if (!camp.equals("")) {
/* 4174 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de Sedere\n¿Deseas quitar esa información?", "Quitar Permiso Sedere", 0, 3, this.PREG);
/* 4175 */       if (resp == 0) {
/* 4176 */         this.jRadioButton17.setSelected(true);
/* 4177 */         this.jTextField50.setText("");
/*      */       } else {
/*      */         
/* 4180 */         this.jRadioButton18.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton18ActionPerformed(ActionEvent evt) {
/* 4186 */     if (this.jTextField50.getText().equals("")) {
/* 4187 */       this.jButton31.setText("Guardar");
/* 4188 */       this.jButton32.setVisible(false);
/* 4189 */       limpiar6();
/* 4190 */       this.jDialog7.setVisible(true);
/*      */     } else {
/*      */       
/* 4193 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de Sedere\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 4194 */       if (resp == 0) {
/* 4195 */         cargarFormulario5();
/* 4196 */         this.jButton31.setText("Modificar");
/* 4197 */         this.jButton32.setVisible(true);
/* 4198 */         this.jDialog7.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 4204 */     if (this.jTextField50.getText().equals("")) {
/* 4205 */       this.jRadioButton17.setSelected(true);
/*      */     }
/* 4207 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 4215 */     this.error.pasarModal(true);
/* 4216 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4217 */     boolean alta = this.jRadioButton20.isSelected();
/* 4218 */     String tipo = "Alta";
/* 4219 */     Date fecha1 = this.jDateChooser10.getDate();
/* 4220 */     Date fecha2 = this.jDateChooser11.getDate();
/* 4221 */     String comentario = this.jTextArea5.getText();
/* 4222 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 4224 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4225 */     String cadenaFecha = "";
/*      */     
/* 4227 */     String año1 = "";
/* 4228 */     String mes1 = "";
/* 4229 */     String dia1 = "";
/*      */     
/* 4231 */     String año2 = "";
/* 4232 */     String mes2 = "";
/* 4233 */     String dia2 = "";
/*      */     
/* 4235 */     boolean f1 = false;
/* 4236 */     boolean f2 = false;
/* 4237 */     boolean valorC = false;
/* 4238 */     boolean esMayor = false;
/*      */     
/* 4240 */     if (!alta) {
/* 4241 */       tipo = "Renovación";
/*      */     }
/* 4243 */     if (fecha1 != null) {
/* 4244 */       f1 = true;
/*      */     }
/* 4246 */     if (fecha2 != null) {
/* 4247 */       f2 = true;
/*      */     }
/* 4249 */     if (f1 && f2) {
/* 4250 */       if (fecha2.after(fecha1)) {
/* 4251 */         esMayor = true;
/*      */       }
/* 4253 */       this.fecha = this.jDateChooser10.getDate();
/* 4254 */       cadenaFecha = formato.format(this.fecha);
/* 4255 */       año1 = cadenaFecha.substring(0, 4);
/* 4256 */       mes1 = cadenaFecha.substring(4, 6);
/* 4257 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 4259 */       this.fecha = this.jDateChooser11.getDate();
/* 4260 */       cadenaFecha = formato.format(this.fecha);
/* 4261 */       año2 = cadenaFecha.substring(0, 4);
/* 4262 */       mes2 = cadenaFecha.substring(4, 6);
/* 4263 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 4265 */     if (!f1) {
/* 4266 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 4268 */     else if (!f2) {
/* 4269 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 4271 */     else if (!esMayor) {
/* 4272 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 4274 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 4275 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 4277 */     else if (!this.val.validarApostrofe(this.jTextArea5, this.jTextArea5.getText(), "020")) {
/* 4278 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 4279 */       if (this.jButton31.getText().equals("Modificar")) {
/* 4280 */         int res = this.error.cargarDatos2(campos, info);
/* 4281 */         if (res == 0) {
/* 4282 */           this.jDialog7.setVisible(false);
/* 4283 */           this.con.insertar("update ");
/* 4284 */           this.jRadioButton18.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 4288 */         int res = this.error.cargarDatos(campos, info);
/* 4289 */         if (res == 0) {
/* 4290 */           this.con.insertar("insert into sedere (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea5.getText().toUpperCase() + "')");
/* 4291 */           limpiar6();
/* 4292 */           this.jDialog7.setVisible(false);
/* 4293 */           this.con.consultar("max(num_sed)", "sedere", "");
/* 4294 */           this.jTextField50.setText(this.con.Campo);
/* 4295 */           this.jRadioButton18.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jDialog7WindowClosing(WindowEvent evt) {}
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 4309 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4311 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4314 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 4317 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4319 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4322 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 4325 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4327 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4330 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 4333 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4335 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4338 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 4341 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4343 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4346 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 4349 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4351 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4354 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 4357 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4359 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4362 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 4365 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4367 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4370 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 4373 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4375 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4378 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField10, evt);
/*      */           }
/*      */         });
/*      */     
/* 4382 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4384 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField11, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4387 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 4390 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4392 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField12, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4395 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 4398 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4400 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField13, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4403 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 4406 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4408 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField14, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4411 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 4414 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4416 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField15, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4419 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 4422 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4424 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField16, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4427 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 4430 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4432 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField17, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4435 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 4438 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4440 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField18, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4443 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 4446 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4448 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField19, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4451 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField19, evt);
/*      */           }
/*      */         });
/* 4454 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4456 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField20, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4459 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField20, evt);
/*      */           }
/*      */         });
/* 4462 */     this.jTextField21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4464 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField21, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4467 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField21, evt);
/*      */           }
/*      */         });
/* 4470 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4472 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField22, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4475 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField22, evt);
/*      */           }
/*      */         });
/* 4478 */     this.jTextField23.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4480 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField23, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4483 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField23, evt);
/*      */           }
/*      */         });
/* 4486 */     this.jTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4488 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField24, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4491 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField24, evt);
/*      */           }
/*      */         });
/* 4494 */     this.jTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4496 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField25, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4499 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField25, evt);
/*      */           }
/*      */         });
/* 4502 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4504 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField26, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4507 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField26, evt);
/*      */           }
/*      */         });
/* 4510 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4512 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField27, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4515 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 4518 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4520 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField28, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4523 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 4526 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4528 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField29, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4531 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 4534 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4536 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextArea1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4539 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 4542 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4544 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4547 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 4550 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4552 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4555 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 4558 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4560 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4563 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 4566 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4568 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4571 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 4574 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4576 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4579 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 4582 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4584 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4587 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 4592 */     this.jTextField34.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4594 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField34, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4597 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField34, evt);
/*      */           }
/*      */         });
/* 4600 */     this.jTextField35.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4602 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField35, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4605 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField35, evt);
/*      */           }
/*      */         });
/* 4608 */     this.jTextField36.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4610 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField36, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4613 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField36, evt);
/*      */           }
/*      */         });
/* 4616 */     this.jTextField37.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4618 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField37, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4621 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField37, evt);
/*      */           }
/*      */         });
/* 4624 */     this.jTextField38.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4626 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField38, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4629 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField38, evt);
/*      */           }
/*      */         });
/* 4632 */     this.jTextField39.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4634 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField39, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4637 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField39, evt);
/*      */           }
/*      */         });
/* 4640 */     this.jTextField40.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4642 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField40, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4645 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField40, evt);
/*      */           }
/*      */         });
/* 4648 */     this.jTextField41.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4650 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField41, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4653 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField41, evt);
/*      */           }
/*      */         });
/* 4656 */     this.jTextField42.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4658 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField42, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4661 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField42, evt);
/*      */           }
/*      */         });
/* 4664 */     this.jTextField43.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4666 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField43, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4669 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField43, evt);
/*      */           }
/*      */         });
/* 4672 */     this.jTextField44.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4674 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField44, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4677 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField44, evt);
/*      */           }
/*      */         });
/* 4680 */     this.jTextField45.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4682 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField45, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4685 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField45, evt);
/*      */           }
/*      */         });
/* 4688 */     this.jTextField46.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4690 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField46, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4693 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField46, evt);
/*      */           }
/*      */         });
/* 4696 */     this.jTextField47.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4698 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField47, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4701 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField47, evt);
/*      */           }
/*      */         });
/* 4704 */     this.jTextField48.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4706 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField48, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4709 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField48, evt);
/*      */           }
/*      */         });
/* 4712 */     this.jTextField49.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4714 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextField49, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4717 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextField49, evt);
/*      */           }
/*      */         });
/* 4720 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4722 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextArea2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4725 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 4728 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4730 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextArea3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4733 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 4736 */     this.jTextArea4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4738 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextArea4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4741 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextArea4, evt);
/*      */           }
/*      */         });
/* 4744 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4746 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jTextArea5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4749 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 4752 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4754 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jComboBox6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4757 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 4760 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4762 */             TractoAgregar.this.jTextGanado(TractoAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4765 */             TractoAgregar.this.jTextPerdido(TractoAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4770 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4773 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void limpiar() {
/* 4776 */     if (this.jButton1.getText().equals("Guardar")) {
/* 4777 */       this.jTextField1.setText("");
/*      */     }
/* 4779 */     this.jTextField2.setText("");
/* 4780 */     this.jTextField4.setText("");
/* 4781 */     this.jTextField5.setText("");
/* 4782 */     this.jTextField6.setText("");
/* 4783 */     this.jTextField7.setText("");
/* 4784 */     this.jTextField9.setText("");
/* 4785 */     this.jTextField10.setText("");
/* 4786 */     this.jTextField11.setText("");
/* 4787 */     this.jTextField30.setText("");
/* 4788 */     this.jTextField31.setText("");
/* 4789 */     this.jTextField50.setText("");
/* 4790 */     this.jTextField32.setText("");
/* 4791 */     this.jTextField33.setText("");
/* 4792 */     this.jRadioButton1.setSelected(true);
/* 4793 */     this.jRadioButton4.setSelected(true);
/* 4794 */     this.jRadioButton7.setSelected(true);
/* 4795 */     this.jRadioButton10.setSelected(true);
/* 4796 */     this.jDateChooser1.setDate(this.fechaActual);
/* 4797 */     this.jComboBox1.setSelectedIndex(0);
/* 4798 */     this.jComboBox2.setSelectedIndex(0);
/* 4799 */     this.jComboBox3.setSelectedIndex(0);
/* 4800 */     this.jComboBox5.setSelectedIndex(0);
/* 4801 */     this.jComboBox7.setSelectedIndex(0);
/* 4802 */     this.datos.eliminar();
/*      */   }
/*      */   public void limpiar2() {
/* 4805 */     this.jTextField14.setText("");
/* 4806 */     this.jTextField15.setText("");
/* 4807 */     this.jTextField16.setText("");
/* 4808 */     this.jTextField17.setText("");
/* 4809 */     this.jTextField18.setText("");
/* 4810 */     this.jTextField19.setText("");
/* 4811 */     this.jTextField20.setText("");
/* 4812 */     this.jTextField21.setText("");
/* 4813 */     this.jTextField22.setText("");
/* 4814 */     this.jTextField23.setText("");
/* 4815 */     this.jTextField24.setText("");
/* 4816 */     this.jTextField25.setText("");
/* 4817 */     this.jTextField26.setText("");
/* 4818 */     this.jTextField27.setText("");
/* 4819 */     this.jTextField28.setText("");
/* 4820 */     this.jTextField29.setText("");
/* 4821 */     this.jTextArea1.setText("");
/* 4822 */     this.jDateChooser2.setDate(this.fechaActual);
/* 4823 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4824 */     this.jComboBox4.setSelectedIndex(0);
/* 4825 */     this.jFormattedTextField1.setValue("");
/*      */   }
/*      */   public void limpiar3() {
/* 4828 */     this.jTextField34.setText("");
/* 4829 */     this.jTextField35.setText("");
/* 4830 */     this.jTextField36.setText("");
/* 4831 */     this.jTextField37.setText("");
/* 4832 */     this.jTextField38.setText("");
/* 4833 */     this.jTextField39.setText("");
/* 4834 */     this.jTextField40.setText("");
/* 4835 */     this.jTextField41.setText("");
/* 4836 */     this.jTextField42.setText("");
/* 4837 */     this.jTextField43.setText("");
/* 4838 */     this.jTextField44.setText("");
/* 4839 */     this.jTextField45.setText("");
/* 4840 */     this.jTextField46.setText("");
/* 4841 */     this.jTextField47.setText("");
/* 4842 */     this.jTextField48.setText("");
/* 4843 */     this.jTextField49.setText("");
/* 4844 */     this.jTextArea2.setText("");
/* 4845 */     this.jDateChooser3.setDate(this.fechaActual);
/* 4846 */     this.jDateChooser6.setDate(this.fechaActual);
/* 4847 */     this.jComboBox6.setSelectedIndex(0);
/* 4848 */     this.jFormattedTextField2.setValue("");
/*      */   }
/*      */   public void limpiar4() {
/* 4851 */     this.jRadioButton13.setSelected(true);
/* 4852 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4853 */     this.jDateChooser7.setDate(this.fechaActual);
/* 4854 */     this.jTextArea3.setText("");
/*      */   }
/*      */   public void limpiar5() {
/* 4857 */     this.jRadioButton15.setSelected(true);
/* 4858 */     this.jDateChooser8.setDate(this.fechaActual);
/* 4859 */     this.jDateChooser9.setDate(this.fechaActual);
/* 4860 */     this.jTextArea4.setText("");
/*      */   }
/*      */   public void limpiar6() {
/* 4863 */     this.jRadioButton20.setSelected(true);
/* 4864 */     this.jDateChooser10.setDate(this.fechaActual);
/* 4865 */     this.jDateChooser11.setDate(this.fechaActual);
/* 4866 */     this.jTextArea5.setText("");
/*      */   }
/*      */   public void tracto(String usua, String num) {
/* 4869 */     this.USUARIO = usua;
/* 4870 */     this.panel.setViewportView(this);
/* 4871 */     this.id = num;
/* 4872 */     this.jLabel14.setVisible(false);
/* 4873 */     if (this.fichas != null) {
/* 4874 */       cargarFormulario();
/* 4875 */       this.fichas.addTab("Modificar Tractos - [Clave: " + this.id + "]", this.panel);
/* 4876 */       this.jButton1.setText("Modificar");
/* 4877 */       this.jLabel1.setText("Modificar Tractos");
/* 4878 */       this.jButton3.setVisible(true);
/* 4879 */       this.jButton4.setVisible(true);
/*      */     } else {
/*      */       
/* 4882 */       this.jButton3.setVisible(false);
/* 4883 */       this.jButton4.setVisible(false);
/* 4884 */       this.jLabel1.setText("Agregar Tractos");
/*      */     } 
/*      */   }
/*      */   public void consultar1() {
/* 4888 */     this.encontrado = this.con.consultar("count(marca)", "marca", "");
/* 4889 */     int totreg = Integer.parseInt(this.con.Campo);
/* 4890 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 4891 */           .buscarReg(2, totreg, "id_marca,marca", "marca", ""), (Object[])new String[] { "Clave", "Marca", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4896 */           Class[] types = new Class[] { Object.class, Object.class, Boolean.class };
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4900 */             return this.types[columnIndex];
/*      */           }
/* 4902 */           boolean[] canEdit = new boolean[] { false, false, true };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4906 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4909 */     this.jTable1.setShowVerticalLines(false);
/* 4910 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 4911 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4912 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4913 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
/* 4914 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(30);
/* 4915 */     this.jTable1.setSelectionMode(0);
/* 4916 */     this.jTable1.setAutoCreateRowSorter(true);
/* 4917 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 4918 */     this.jTable1.getColumnModel().moveColumn(2, 0);
/*      */   }
/*      */   public void consultar2() {
/* 4921 */     this.encontrado = this.con.consultar("count(tipo)", "tipos", "");
/* 4922 */     int totreg = Integer.parseInt(this.con.Campo);
/* 4923 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 4924 */           .buscarReg(2, totreg, "id_tipo,tipo", "tipos", ""), (Object[])new String[] { "Clave", "Tipo", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4929 */           Class[] types = new Class[] { Object.class, Object.class, Boolean.class };
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4933 */             return this.types[columnIndex];
/*      */           }
/* 4935 */           boolean[] canEdit = new boolean[] { false, false, true };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4939 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4942 */     this.jTable2.setShowVerticalLines(false);
/* 4943 */     this.jScrollPane3.setViewportView(this.jTable2);
/* 4944 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4945 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4946 */     this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(30);
/* 4947 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(30);
/* 4948 */     this.jTable2.setSelectionMode(0);
/* 4949 */     this.jTable2.setAutoCreateRowSorter(true);
/* 4950 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 4951 */     this.jTable2.getColumnModel().moveColumn(2, 0);
/*      */   }
/*      */   public void llenarCombo() {
/* 4954 */     this.con.consultar("count(tipo)", "tipos", "");
/* 4955 */     String[] depa = this.con.regresaCol("tipo", "tipos", "order by tipo", Integer.parseInt(this.con.Campo));
/* 4956 */     this.jComboBox1.removeAllItems();
/* 4957 */     this.jComboBox1.addItem("Selecciona uno...");
/* 4958 */     for (int i = 0; i < depa.length; i++)
/* 4959 */       this.jComboBox1.addItem(depa[i]); 
/*      */   }
/*      */   
/*      */   public void llenarCombo2() {
/* 4963 */     this.con.consultar("count(marca)", "marca", "");
/* 4964 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 4965 */     this.jComboBox2.removeAllItems();
/* 4966 */     this.jComboBox2.addItem("Selecciona uno...");
/* 4967 */     for (int i = 0; i < depa.length; i++)
/* 4968 */       this.jComboBox2.addItem(depa[i]); 
/*      */   }
/*      */   
/*      */   public void llenarCombo3() {
/* 4972 */     int año = this.fechaActual.getYear();
/* 4973 */     año += 1901;
/* 4974 */     this.jComboBox7.addItem("Selecciona uno...");
/* 4975 */     for (int i = año; i >= 1990; i--)
/* 4976 */       this.jComboBox7.addItem("" + i); 
/*      */   }
/*      */   
/*      */   public void guardarTipos() {
/* 4980 */     this.error.pasarModal(true);
/* 4981 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4982 */     String tipo = this.jTextField13.getText().toUpperCase();
/* 4983 */     if (tipo.equals("")) {
/* 4984 */       this.error.cargarError(this.jTextField13, "050");
/*      */     }
/* 4986 */     else if (!this.val.validarApostrofe(this.jTextField13, tipo, "020")) {
/* 4987 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas crear en nuevo tipo de vehículos?", "Crear Tipo", 0, 1, this.PREG);
/* 4988 */       if (res == 0) {
/* 4989 */         this.con.insertar("insert into tipos(tipo)values('" + tipo + "')");
/* 4990 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo tipo de carro.','Tipo: " + this.jTextField13.getText() + "')");
/* 4991 */         llenarCombo();
/* 4992 */         consultar2();
/* 4993 */         this.jTextField13.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void guardarMarcas() {
/* 4998 */     this.error.pasarModal(true);
/* 4999 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5000 */     String marca = this.jTextField12.getText();
/* 5001 */     if (marca.equals("")) {
/* 5002 */       this.error.cargarError(this.jTextField12, "050");
/*      */     }
/* 5004 */     else if (!this.val.validarApostrofe(this.jTextField12, marca, "020")) {
/* 5005 */       this.encontrado = this.con.consultar("marca", "marca", "where marca = '" + this.jTextField12.getText() + "'");
/* 5006 */       if (this.encontrado) {
/* 5007 */         JOptionPane.showMessageDialog(this.jDialog1, "La marca que deseas insertar ya se encuentra registrada, por favor verifica tu información", "Marca Ya Existe", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 5010 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas crear una nueva marca de vehículos?", "Crear Marca", 0, 1, this.PREG);
/* 5011 */         if (res == 0) {
/* 5012 */           this.con.insertar("insert into marca(marca)values('" + marca + "')");
/* 5013 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + this.jTextField12.getText() + "')");
/* 5014 */           llenarCombo2();
/* 5015 */           consultar1();
/* 5016 */           this.jTextField12.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void cargarFormulario() {
/* 5022 */     this.jButton3.setVisible(true);
/* 5023 */     this.jButton4.setVisible(true);
/* 5024 */     this.jLabel14.setVisible(true);
/* 5025 */     this.jComboBox5.setEnabled(true);
/* 5026 */     this.jTextField1.setEnabled(false);
/* 5027 */     this.jButton1.setMnemonic('M');
/* 5028 */     String[] reg = this.con.regresaReg("Modelo,color,No_serie,No_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,id_marca,id_tipo", "tracto", "where num_tracto = " + this.id, 14);
/* 5029 */     this.inf = reg;
/* 5030 */     this.jTextField1.setText(this.id);
/* 5031 */     this.jTextField2.setText(reg[1]);
/*      */     
/* 5033 */     this.con.consultar("tipo", "tipos", "where id_tipo=" + reg[13]);
/* 5034 */     this.jComboBox1.setSelectedItem(this.con.Campo);
/*      */     
/* 5036 */     this.con.consultar("marca", "marca", "where id_marca=" + reg[12]);
/* 5037 */     this.jComboBox2.setSelectedItem(this.con.Campo);
/*      */     
/* 5039 */     this.jTextField4.setText(reg[2]);
/* 5040 */     this.jTextField5.setText(reg[3]);
/* 5041 */     this.jTextField7.setText(reg[6]);
/*      */     
/* 5043 */     String año = reg[11].substring(0, 4);
/* 5044 */     String mes = reg[11].substring(5, 7);
/* 5045 */     String dia = reg[11].substring(8, 10);
/* 5046 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5047 */     String strFecha = año + "-" + año + "-" + mes;
/* 5048 */     Date fecha = null;
/*      */     try {
/* 5050 */       fecha = formatoDelTexto.parse(strFecha);
/* 5051 */       this.jDateChooser1.setDate(fecha);
/*      */     }
/* 5053 */     catch (ParseException ex) {
/* 5054 */       ex.printStackTrace();
/*      */     } 
/* 5056 */     if (reg[4].equals("0")) {
/* 5057 */       reg[4] = "";
/*      */     }
/* 5059 */     this.jTextField6.setText(reg[4]);
/*      */     
/* 5061 */     if (reg[7].equals("0")) {
/* 5062 */       reg[7] = "";
/*      */     }
/* 5064 */     if (reg[8].equals("0")) {
/* 5065 */       reg[8] = "";
/*      */     }
/*      */     
/* 5068 */     this.jTextField9.setText(reg[7]);
/* 5069 */     this.jTextField10.setText(reg[8]);
/* 5070 */     this.jTextField11.setText(reg[9]);
/* 5071 */     this.jComboBox7.setSelectedItem(reg[0]);
/* 5072 */     this.jRadioButton1.setEnabled(false);
/* 5073 */     this.jRadioButton2.setEnabled(false);
/* 5074 */     this.jRadioButton7.setEnabled(false);
/* 5075 */     this.jRadioButton8.setEnabled(false);
/* 5076 */     this.jRadioButton17.setEnabled(false);
/* 5077 */     this.jRadioButton18.setEnabled(false);
/*      */     
/* 5079 */     this.jRadioButton4.setEnabled(false);
/* 5080 */     this.jRadioButton5.setEnabled(false);
/* 5081 */     this.jRadioButton10.setEnabled(false);
/* 5082 */     this.jRadioButton11.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void cargarFormulario1() {
/* 5086 */     String id = this.jTextField32.getText();
/* 5087 */     String[] reg = this.con.regresaReg("nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo", "vehicular_carro", "where num_seg = " + id, 21);
/*      */     
/* 5089 */     this.jTextField14.setText(reg[0]);
/* 5090 */     this.jTextField15.setText(reg[1]);
/* 5091 */     this.jTextField16.setText(reg[2]);
/*      */     
/* 5093 */     this.jTextField17.setText(reg[3]);
/* 5094 */     this.jTextField18.setText(reg[4]);
/* 5095 */     this.jTextField19.setText(reg[5]);
/*      */     
/* 5097 */     this.jTextField20.setText(reg[6]);
/* 5098 */     this.jTextField21.setText(reg[7]);
/* 5099 */     String año = reg[8].substring(0, 4);
/* 5100 */     String mes = reg[8].substring(5, 7);
/* 5101 */     String dia = reg[8].substring(8, 10);
/* 5102 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5103 */     String strFecha = año + "-" + año + "-" + mes;
/* 5104 */     Date fecha = null;
/*      */     try {
/* 5106 */       fecha = formatoDelTexto.parse(strFecha);
/* 5107 */       this.jDateChooser2.setDate(fecha);
/*      */     }
/* 5109 */     catch (ParseException ex) {
/* 5110 */       ex.printStackTrace();
/*      */     } 
/* 5112 */     año = reg[9].substring(0, 4);
/* 5113 */     mes = reg[9].substring(5, 7);
/* 5114 */     dia = reg[9].substring(8, 10);
/* 5115 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5116 */     strFecha = año + "-" + año + "-" + mes;
/* 5117 */     fecha = null;
/*      */     try {
/* 5119 */       fecha = formatoDelTexto.parse(strFecha);
/* 5120 */       this.jDateChooser5.setDate(fecha);
/*      */     }
/* 5122 */     catch (ParseException ex) {
/* 5123 */       ex.printStackTrace();
/*      */     } 
/* 5125 */     this.jTextField22.setText(reg[10]);
/* 5126 */     this.jTextArea1.setText(reg[11]);
/*      */     
/* 5128 */     this.jTextField23.setText(reg[12]);
/* 5129 */     this.jTextField24.setText(reg[13]);
/* 5130 */     this.jTextField25.setText(reg[14]);
/* 5131 */     this.jTextField26.setText(reg[15]);
/* 5132 */     this.jTextField27.setText(reg[16]);
/* 5133 */     this.jTextField28.setText(reg[17]);
/* 5134 */     this.jTextField29.setText(reg[18]);
/* 5135 */     this.jFormattedTextField1.setValue(reg[19]);
/*      */     
/* 5137 */     if (!reg[20].equals("33")) {
/* 5138 */       this.jComboBox4.setSelectedIndex(Integer.parseInt(reg[20]) + 1);
/*      */     }
/* 5140 */     String estado = "33";
/* 5141 */     String tel1 = this.jFormattedTextField1.getText();
/*      */   }
/*      */   public void cargarFormulario2() {
/* 5144 */     String id = this.jTextField33.getText();
/* 5145 */     String[] reg = this.con.regresaReg("nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo", "ecologico", "where num_eco = " + id, 21);
/*      */     
/* 5147 */     this.jTextField34.setText(reg[0]);
/* 5148 */     this.jTextField35.setText(reg[1]);
/* 5149 */     this.jTextField36.setText(reg[2]);
/*      */     
/* 5151 */     this.jTextField37.setText(reg[3]);
/* 5152 */     this.jTextField38.setText(reg[4]);
/* 5153 */     this.jTextField39.setText(reg[5]);
/*      */     
/* 5155 */     this.jTextField40.setText(reg[6]);
/* 5156 */     this.jTextField41.setText(reg[7]);
/* 5157 */     String año = reg[8].substring(0, 4);
/* 5158 */     String mes = reg[8].substring(5, 7);
/* 5159 */     String dia = reg[8].substring(8, 10);
/* 5160 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5161 */     String strFecha = año + "-" + año + "-" + mes;
/* 5162 */     Date fecha = null;
/*      */     try {
/* 5164 */       fecha = formatoDelTexto.parse(strFecha);
/* 5165 */       this.jDateChooser3.setDate(fecha);
/*      */     }
/* 5167 */     catch (ParseException ex) {
/* 5168 */       ex.printStackTrace();
/*      */     } 
/* 5170 */     año = reg[9].substring(0, 4);
/* 5171 */     mes = reg[9].substring(5, 7);
/* 5172 */     dia = reg[9].substring(8, 10);
/* 5173 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5174 */     strFecha = año + "-" + año + "-" + mes;
/* 5175 */     fecha = null;
/*      */     try {
/* 5177 */       fecha = formatoDelTexto.parse(strFecha);
/* 5178 */       this.jDateChooser6.setDate(fecha);
/*      */     }
/* 5180 */     catch (ParseException ex) {
/* 5181 */       ex.printStackTrace();
/*      */     } 
/* 5183 */     this.jTextField42.setText(reg[10]);
/* 5184 */     this.jTextArea2.setText(reg[11]);
/*      */     
/* 5186 */     this.jTextField43.setText(reg[12]);
/* 5187 */     this.jTextField44.setText(reg[13]);
/* 5188 */     this.jTextField45.setText(reg[14]);
/* 5189 */     this.jTextField46.setText(reg[15]);
/* 5190 */     this.jTextField47.setText(reg[16]);
/* 5191 */     this.jTextField48.setText(reg[17]);
/* 5192 */     this.jTextField49.setText(reg[18]);
/* 5193 */     this.jFormattedTextField2.setValue(reg[19]);
/*      */     
/* 5195 */     if (!reg[20].equals("33")) {
/* 5196 */       this.jComboBox4.setSelectedIndex(Integer.parseInt(reg[20]) + 1);
/*      */     }
/* 5198 */     String estado = "33";
/* 5199 */     String tel1 = this.jFormattedTextField1.getText();
/*      */   }
/*      */   public void cargarFormulario3() {
/* 5202 */     String id = this.jTextField30.getText();
/* 5203 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "semarnat", "where num_sem = " + id, 4);
/* 5204 */     if (reg[0].equals("Alta")) {
/* 5205 */       this.jRadioButton13.setSelected(true);
/*      */     } else {
/*      */       
/* 5208 */       this.jRadioButton14.setSelected(true);
/*      */     } 
/* 5210 */     String año = reg[1].substring(0, 4);
/* 5211 */     String mes = reg[1].substring(5, 7);
/* 5212 */     String dia = reg[1].substring(8, 10);
/* 5213 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5214 */     String strFecha = año + "-" + año + "-" + mes;
/* 5215 */     Date fecha = null;
/*      */     try {
/* 5217 */       fecha = formatoDelTexto.parse(strFecha);
/* 5218 */       this.jDateChooser4.setDate(fecha);
/*      */     }
/* 5220 */     catch (ParseException ex) {
/* 5221 */       ex.printStackTrace();
/*      */     } 
/* 5223 */     año = reg[2].substring(0, 4);
/* 5224 */     mes = reg[2].substring(5, 7);
/* 5225 */     dia = reg[2].substring(8, 10);
/* 5226 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5227 */     strFecha = año + "-" + año + "-" + mes;
/* 5228 */     fecha = null;
/*      */     try {
/* 5230 */       fecha = formatoDelTexto.parse(strFecha);
/* 5231 */       this.jDateChooser7.setDate(fecha);
/*      */     }
/* 5233 */     catch (ParseException ex) {
/* 5234 */       ex.printStackTrace();
/*      */     } 
/* 5236 */     this.jTextArea3.setText(reg[3]);
/*      */   }
/*      */   public void cargarFormulario4() {
/* 5239 */     String id = this.jTextField31.getText();
/* 5240 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "sct", "where num_sct = " + id, 4);
/* 5241 */     if (reg[0].equals("Alta")) {
/* 5242 */       this.jRadioButton15.setSelected(true);
/*      */     } else {
/*      */       
/* 5245 */       this.jRadioButton16.setSelected(true);
/*      */     } 
/* 5247 */     String año = reg[1].substring(0, 4);
/* 5248 */     String mes = reg[1].substring(5, 7);
/* 5249 */     String dia = reg[1].substring(8, 10);
/* 5250 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5251 */     String strFecha = año + "-" + año + "-" + mes;
/* 5252 */     Date fecha = null;
/*      */     try {
/* 5254 */       fecha = formatoDelTexto.parse(strFecha);
/* 5255 */       this.jDateChooser8.setDate(fecha);
/*      */     }
/* 5257 */     catch (ParseException ex) {
/* 5258 */       ex.printStackTrace();
/*      */     } 
/* 5260 */     año = reg[2].substring(0, 4);
/* 5261 */     mes = reg[2].substring(5, 7);
/* 5262 */     dia = reg[2].substring(8, 10);
/* 5263 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5264 */     strFecha = año + "-" + año + "-" + mes;
/* 5265 */     fecha = null;
/*      */     try {
/* 5267 */       fecha = formatoDelTexto.parse(strFecha);
/* 5268 */       this.jDateChooser9.setDate(fecha);
/*      */     }
/* 5270 */     catch (ParseException ex) {
/* 5271 */       ex.printStackTrace();
/*      */     } 
/* 5273 */     this.jTextArea4.setText(reg[3]);
/*      */   }
/*      */   public void cargarFormulario5() {
/* 5276 */     String id = this.jTextField50.getText();
/* 5277 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "sedere", "where num_sed = " + id, 4);
/* 5278 */     if (reg[0].equals("Alta")) {
/* 5279 */       this.jRadioButton20.setSelected(true);
/*      */     } else {
/*      */       
/* 5282 */       this.jRadioButton20.setSelected(true);
/*      */     } 
/* 5284 */     String año = reg[1].substring(0, 4);
/* 5285 */     String mes = reg[1].substring(5, 7);
/* 5286 */     String dia = reg[1].substring(8, 10);
/* 5287 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5288 */     String strFecha = año + "-" + año + "-" + mes;
/* 5289 */     Date fecha = null;
/*      */     try {
/* 5291 */       fecha = formatoDelTexto.parse(strFecha);
/* 5292 */       this.jDateChooser10.setDate(fecha);
/*      */     }
/* 5294 */     catch (ParseException ex) {
/* 5295 */       ex.printStackTrace();
/*      */     } 
/* 5297 */     año = reg[2].substring(0, 4);
/* 5298 */     mes = reg[2].substring(5, 7);
/* 5299 */     dia = reg[2].substring(8, 10);
/* 5300 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 5301 */     strFecha = año + "-" + año + "-" + mes;
/* 5302 */     fecha = null;
/*      */     try {
/* 5304 */       fecha = formatoDelTexto.parse(strFecha);
/* 5305 */       this.jDateChooser11.setDate(fecha);
/*      */     }
/* 5307 */     catch (ParseException ex) {
/* 5308 */       ex.printStackTrace();
/*      */     } 
/* 5310 */     this.jTextArea5.setText(reg[3]);
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
/*      */   public void consultar() {
/* 5331 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca");
/* 5332 */     int totreg = Integer.parseInt(this.con.Campo);
/*      */     
/* 5334 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 5335 */           .buscarReg(20, totreg, "num_tracto,modelo,color,no_serie,no_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipos.tipo,tracto.num_sem,tracto.NUM_sct,tracto.num_sed,tracto.num_seg,tracto.num_eco", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 5340 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5344 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5347 */     this.jTable3.setShowVerticalLines(false);
/*      */     
/* 5349 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 5350 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 5351 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 5352 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 5353 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
/* 5354 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(60);
/* 5355 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 5356 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/* 5357 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(50);
/* 5358 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(50);
/* 5359 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 5360 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 5361 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 5362 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 5363 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 5364 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 5365 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 5366 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 5367 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 5368 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 5369 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(65);
/* 5370 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(65);
/* 5371 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 5372 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/* 5373 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(75);
/* 5374 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(75);
/*      */     
/* 5376 */     this.jButton5.setEnabled(false);
/* 5377 */     this.jTable3.setSelectionMode(0);
/* 5378 */     this.jTable3.setAutoCreateRowSorter(true);
/* 5379 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     int i;
/* 5381 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5382 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 5383 */       if (valor.equals("0")) {
/* 5384 */         this.jTable3.setValueAt("No", i, 15);
/*      */       } else {
/*      */         
/* 5387 */         this.jTable3.setValueAt("Si", i, 15);
/*      */       } 
/*      */     } 
/*      */     
/* 5391 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5392 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 5393 */       if (valor.equals("0")) {
/* 5394 */         this.jTable3.setValueAt("No", i, 16);
/*      */       } else {
/*      */         
/* 5397 */         this.jTable3.setValueAt("Si", i, 16);
/*      */       } 
/*      */     } 
/*      */     
/* 5401 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5402 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 5403 */       if (valor.equals("0")) {
/* 5404 */         this.jTable3.setValueAt("No", i, 17);
/*      */       } else {
/*      */         
/* 5407 */         this.jTable3.setValueAt("Si", i, 17);
/*      */       } 
/*      */     } 
/*      */     
/* 5411 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5412 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 5413 */       if (valor.equals("0")) {
/* 5414 */         this.jTable3.setValueAt("No", i, 18);
/*      */       } else {
/*      */         
/* 5417 */         this.jTable3.setValueAt("Si", i, 18);
/*      */       } 
/*      */     } 
/*      */     
/* 5421 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5422 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 19));
/* 5423 */       if (valor.equals("0")) {
/* 5424 */         this.jTable3.setValueAt("No", i, 19);
/*      */       } else {
/*      */         
/* 5427 */         this.jTable3.setValueAt("Si", i, 19);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TractoAgregar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */