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
/*      */ public class CajaAgregar extends JPanel {
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
/*   52 */   MensajePop mensajeTry = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private ButtonGroup buttonGroup5; private ButtonGroup buttonGroup6; private ButtonGroup buttonGroup7; private ButtonGroup buttonGroup8; private JButton jButton1; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JDateChooser jDateChooser1; private JDateChooser jDateChooser10; private JDateChooser jDateChooser11; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JLabel jLabel1; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel30; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78;
/*      */   public CajaAgregar(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry) {
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
/*  151 */     consultar1();
/*  152 */     llenarCombo2();
/*  153 */     llenarCombo3();
/*      */     
/*  155 */     rw = (w - 870) / 2;
/*  156 */     rh = (h - 640) / 2;
/*  157 */     this.jDialog4.setVisible(false);
/*  158 */     this.jDialog4.setLocation(rw, rh);
/*  159 */     this.jDialog4.setSize(670, 640);
/*      */     
/*  161 */     rw = (w - 380) / 2;
/*  162 */     rh = (h - 240) / 2;
/*  163 */     this.jDialog5.setVisible(false);
/*  164 */     this.jDialog5.setLocation(rw, rh);
/*  165 */     this.jDialog5.setSize(390, 360);
/*      */     
/*  167 */     rw = (w - 380) / 2;
/*  168 */     rh = (h - 240) / 2;
/*  169 */     this.jDialog6.setVisible(false);
/*  170 */     this.jDialog6.setLocation(rw, rh);
/*  171 */     this.jDialog6.setSize(390, 360);
/*      */     
/*  173 */     rw = (w - 380) / 2;
/*  174 */     rh = (h - 240) / 2;
/*  175 */     this.jDialog7.setVisible(false);
/*  176 */     this.jDialog7.setLocation(rw, rh);
/*  177 */     this.jDialog7.setSize(390, 360);
/*  178 */     if (fichas != null) {
/*  179 */       fichas.addTab("Modificar Remolques - [Clave: " + this.id + "]", this.panel);
/*  180 */       this.jButton1.setText("Modificar");
/*  181 */       this.jLabel1.setText("Modificar Remolques");
/*  182 */       cargarFormulario();
/*      */     } 
/*      */   }
/*      */   private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JRadioButton jRadioButton1; private JRadioButton jRadioButton10; private JRadioButton jRadioButton11; private JRadioButton jRadioButton12; private JRadioButton jRadioButton13; private JRadioButton jRadioButton14; private JRadioButton jRadioButton15; private JRadioButton jRadioButton16; private JRadioButton jRadioButton17; private JRadioButton jRadioButton18; private JRadioButton jRadioButton19; private JRadioButton jRadioButton2; private JRadioButton jRadioButton20; private JRadioButton jRadioButton21; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JTable jTable1; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea4; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField44; private JTextField jTextField45; private JTextField jTextField46; private JTextField jTextField47; private JTextField jTextField48; private JTextField jTextField49; private JTextField jTextField50; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  188 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  189 */     this.jPanel1 = new JPanel();
/*  190 */     this.jLabel8 = new JLabel();
/*  191 */     this.jSeparator1 = new JSeparator();
/*  192 */     this.jPanel18 = new JPanel();
/*  193 */     this.jTextField12 = new JTextField();
/*  194 */     this.jLabel19 = new JLabel();
/*  195 */     this.jButton6 = new JButton();
/*  196 */     this.jPanel19 = new JPanel();
/*  197 */     this.jScrollPane1 = new JScrollPane();
/*  198 */     this.jTable1 = new JTable();
/*  199 */     this.jButton7 = new JButton();
/*  200 */     this.jButton8 = new JButton();
/*  201 */     this.buttonGroup1 = new ButtonGroup();
/*  202 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  203 */     this.jPanel2 = new JPanel();
/*  204 */     this.jLabel9 = new JLabel();
/*  205 */     this.jSeparator2 = new JSeparator();
/*  206 */     this.jPanel24 = new JPanel();
/*  207 */     this.jTextField14 = new JTextField();
/*  208 */     this.jLabel32 = new JLabel();
/*  209 */     this.jLabel33 = new JLabel();
/*  210 */     this.jTextField15 = new JTextField();
/*  211 */     this.jLabel34 = new JLabel();
/*  212 */     this.jTextField16 = new JTextField();
/*  213 */     this.jPanel25 = new JPanel();
/*  214 */     this.jTextField17 = new JTextField();
/*  215 */     this.jLabel35 = new JLabel();
/*  216 */     this.jLabel36 = new JLabel();
/*  217 */     this.jTextField18 = new JTextField();
/*  218 */     this.jLabel37 = new JLabel();
/*  219 */     this.jTextField19 = new JTextField();
/*  220 */     this.jPanel26 = new JPanel();
/*  221 */     this.jTextField20 = new JTextField();
/*  222 */     this.jLabel38 = new JLabel();
/*  223 */     this.jLabel39 = new JLabel();
/*  224 */     this.jTextField21 = new JTextField();
/*  225 */     this.jLabel40 = new JLabel();
/*  226 */     this.jDateChooser2 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  227 */     this.jLabel41 = new JLabel();
/*  228 */     this.jDateChooser5 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  229 */     this.jLabel42 = new JLabel();
/*  230 */     this.jTextField22 = new JTextField();
/*  231 */     this.jScrollPane2 = new JScrollPane();
/*  232 */     this.jTextArea1 = new JTextArea();
/*  233 */     this.jLabel43 = new JLabel();
/*  234 */     this.jLabel53 = new JLabel();
/*  235 */     this.jLabel58 = new JLabel();
/*  236 */     this.jPanel27 = new JPanel();
/*  237 */     this.jTextField23 = new JTextField();
/*  238 */     this.jLabel44 = new JLabel();
/*  239 */     this.jLabel45 = new JLabel();
/*  240 */     this.jTextField24 = new JTextField();
/*  241 */     this.jLabel46 = new JLabel();
/*  242 */     this.jTextField25 = new JTextField();
/*  243 */     this.jLabel47 = new JLabel();
/*  244 */     this.jTextField26 = new JTextField();
/*  245 */     this.jLabel48 = new JLabel();
/*  246 */     this.jTextField27 = new JTextField();
/*  247 */     this.jLabel49 = new JLabel();
/*  248 */     this.jTextField28 = new JTextField();
/*  249 */     this.jLabel50 = new JLabel();
/*  250 */     this.jTextField29 = new JTextField();
/*  251 */     this.jLabel51 = new JLabel();
/*  252 */     this.jComboBox4 = new JComboBox();
/*  253 */     this.jLabel52 = new JLabel();
/*  254 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  255 */     this.jButton11 = new JButton();
/*  256 */     this.jButton12 = new JButton();
/*  257 */     this.jButton13 = new JButton();
/*  258 */     this.jButton14 = new JButton();
/*  259 */     this.buttonGroup2 = new ButtonGroup();
/*  260 */     this.buttonGroup3 = new ButtonGroup();
/*  261 */     this.buttonGroup4 = new ButtonGroup();
/*  262 */     this.buttonGroup5 = new ButtonGroup();
/*  263 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  264 */     this.jPanel5 = new JPanel();
/*  265 */     this.jLabel11 = new JLabel();
/*  266 */     this.jSeparator4 = new JSeparator();
/*  267 */     this.jPanel31 = new JPanel();
/*  268 */     this.jTextField34 = new JTextField();
/*  269 */     this.jLabel59 = new JLabel();
/*  270 */     this.jLabel60 = new JLabel();
/*  271 */     this.jTextField35 = new JTextField();
/*  272 */     this.jLabel61 = new JLabel();
/*  273 */     this.jTextField36 = new JTextField();
/*  274 */     this.jPanel32 = new JPanel();
/*  275 */     this.jTextField37 = new JTextField();
/*  276 */     this.jLabel62 = new JLabel();
/*  277 */     this.jLabel63 = new JLabel();
/*  278 */     this.jTextField38 = new JTextField();
/*  279 */     this.jLabel64 = new JLabel();
/*  280 */     this.jTextField39 = new JTextField();
/*  281 */     this.jPanel33 = new JPanel();
/*  282 */     this.jTextField40 = new JTextField();
/*  283 */     this.jLabel65 = new JLabel();
/*  284 */     this.jLabel66 = new JLabel();
/*  285 */     this.jTextField41 = new JTextField();
/*  286 */     this.jLabel67 = new JLabel();
/*  287 */     this.jDateChooser3 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  288 */     this.jLabel68 = new JLabel();
/*  289 */     this.jDateChooser6 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  290 */     this.jLabel69 = new JLabel();
/*  291 */     this.jTextField42 = new JTextField();
/*  292 */     this.jScrollPane4 = new JScrollPane();
/*  293 */     this.jTextArea2 = new JTextArea();
/*  294 */     this.jLabel70 = new JLabel();
/*  295 */     this.jLabel71 = new JLabel();
/*  296 */     this.jLabel72 = new JLabel();
/*  297 */     this.jPanel34 = new JPanel();
/*  298 */     this.jTextField43 = new JTextField();
/*  299 */     this.jLabel73 = new JLabel();
/*  300 */     this.jLabel74 = new JLabel();
/*  301 */     this.jTextField44 = new JTextField();
/*  302 */     this.jLabel75 = new JLabel();
/*  303 */     this.jTextField45 = new JTextField();
/*  304 */     this.jLabel76 = new JLabel();
/*  305 */     this.jTextField46 = new JTextField();
/*  306 */     this.jLabel77 = new JLabel();
/*  307 */     this.jTextField47 = new JTextField();
/*  308 */     this.jLabel78 = new JLabel();
/*  309 */     this.jTextField48 = new JTextField();
/*  310 */     this.jLabel79 = new JLabel();
/*  311 */     this.jTextField49 = new JTextField();
/*  312 */     this.jLabel80 = new JLabel();
/*  313 */     this.jComboBox6 = new JComboBox();
/*  314 */     this.jLabel81 = new JLabel();
/*  315 */     this.jFormattedTextField2 = new JFormattedTextField(this.formaTel);
/*  316 */     this.jButton17 = new JButton();
/*  317 */     this.jButton18 = new JButton();
/*  318 */     this.jButton19 = new JButton();
/*  319 */     this.jButton20 = new JButton();
/*  320 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  321 */     this.jPanel6 = new JPanel();
/*  322 */     this.jLabel82 = new JLabel();
/*  323 */     this.jSeparator5 = new JSeparator();
/*  324 */     this.jLabel83 = new JLabel();
/*  325 */     this.jRadioButton13 = new JRadioButton();
/*  326 */     this.jRadioButton14 = new JRadioButton();
/*  327 */     this.jDateChooser4 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  328 */     this.jLabel85 = new JLabel();
/*  329 */     this.jLabel84 = new JLabel();
/*  330 */     this.jDateChooser7 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  331 */     this.jLabel86 = new JLabel();
/*  332 */     this.jScrollPane5 = new JScrollPane();
/*  333 */     this.jTextArea3 = new JTextArea();
/*  334 */     this.jButton21 = new JButton();
/*  335 */     this.jButton22 = new JButton();
/*  336 */     this.jButton23 = new JButton();
/*  337 */     this.jButton24 = new JButton();
/*  338 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  339 */     this.jPanel7 = new JPanel();
/*  340 */     this.jLabel87 = new JLabel();
/*  341 */     this.jSeparator6 = new JSeparator();
/*  342 */     this.jLabel88 = new JLabel();
/*  343 */     this.jRadioButton15 = new JRadioButton();
/*  344 */     this.jRadioButton16 = new JRadioButton();
/*  345 */     this.jDateChooser8 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  346 */     this.jLabel89 = new JLabel();
/*  347 */     this.jLabel90 = new JLabel();
/*  348 */     this.jDateChooser9 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  349 */     this.jLabel91 = new JLabel();
/*  350 */     this.jScrollPane6 = new JScrollPane();
/*  351 */     this.jTextArea4 = new JTextArea();
/*  352 */     this.jButton25 = new JButton();
/*  353 */     this.jButton26 = new JButton();
/*  354 */     this.jButton27 = new JButton();
/*  355 */     this.jButton28 = new JButton();
/*  356 */     this.buttonGroup6 = new ButtonGroup();
/*  357 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  358 */     this.jPanel8 = new JPanel();
/*  359 */     this.jLabel93 = new JLabel();
/*  360 */     this.jSeparator7 = new JSeparator();
/*  361 */     this.jLabel94 = new JLabel();
/*  362 */     this.jRadioButton20 = new JRadioButton();
/*  363 */     this.jRadioButton21 = new JRadioButton();
/*  364 */     this.jDateChooser10 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  365 */     this.jLabel95 = new JLabel();
/*  366 */     this.jLabel96 = new JLabel();
/*  367 */     this.jDateChooser11 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  368 */     this.jLabel97 = new JLabel();
/*  369 */     this.jScrollPane7 = new JScrollPane();
/*  370 */     this.jTextArea5 = new JTextArea();
/*  371 */     this.jButton29 = new JButton();
/*  372 */     this.jButton30 = new JButton();
/*  373 */     this.jButton31 = new JButton();
/*  374 */     this.jButton32 = new JButton();
/*  375 */     this.buttonGroup7 = new ButtonGroup();
/*  376 */     this.buttonGroup8 = new ButtonGroup();
/*  377 */     this.jPanel4 = new JPanel();
/*  378 */     this.jLabel1 = new JLabel();
/*  379 */     this.jButton1 = new JButton();
/*  380 */     this.jButton2 = new JButton();
/*  381 */     this.jLabel14 = new JLabel();
/*  382 */     this.jButton3 = new JButton();
/*  383 */     this.jButton4 = new JButton();
/*  384 */     this.jPanel17 = new JPanel();
/*  385 */     this.jLabel12 = new JLabel();
/*  386 */     this.jComboBox2 = new JComboBox();
/*  387 */     this.jButton5 = new JButton();
/*  388 */     this.jLabel16 = new JLabel();
/*  389 */     this.jLabel17 = new JLabel();
/*  390 */     this.jTextField4 = new JTextField();
/*  391 */     this.jComboBox7 = new JComboBox();
/*  392 */     this.jLabel28 = new JLabel();
/*  393 */     this.jTextField7 = new JTextField();
/*  394 */     this.jPanel20 = new JPanel();
/*  395 */     this.jLabel13 = new JLabel();
/*  396 */     this.jTextField1 = new JTextField();
/*  397 */     this.jLabel15 = new JLabel();
/*  398 */     this.jTextField2 = new JTextField();
/*  399 */     this.jLabel20 = new JLabel();
/*  400 */     this.jComboBox1 = new JComboBox();
/*  401 */     this.jLabel55 = new JLabel();
/*  402 */     this.jComboBox5 = new JComboBox();
/*  403 */     this.jPanel21 = new JPanel();
/*  404 */     this.jLabel18 = new JLabel();
/*  405 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  406 */     this.jLabel22 = new JLabel();
/*  407 */     this.jTextField6 = new JTextField();
/*  408 */     this.jLabel23 = new JLabel();
/*  409 */     this.jComboBox3 = new JComboBox();
/*  410 */     this.jPanel22 = new JPanel();
/*  411 */     this.jLabel24 = new JLabel();
/*  412 */     this.jLabel25 = new JLabel();
/*  413 */     this.jTextField10 = new JTextField();
/*  414 */     this.jLabel26 = new JLabel();
/*  415 */     this.jTextField11 = new JTextField();
/*  416 */     this.jTextField9 = new JTextField();
/*  417 */     this.jLabel57 = new JLabel();
/*  418 */     this.jPanel23 = new JPanel();
/*  419 */     this.jLabel27 = new JLabel();
/*  420 */     this.jRadioButton1 = new JRadioButton();
/*  421 */     this.jRadioButton2 = new JRadioButton();
/*  422 */     this.jRadioButton3 = new JRadioButton();
/*  423 */     this.jLabel54 = new JLabel();
/*  424 */     this.jRadioButton7 = new JRadioButton();
/*  425 */     this.jRadioButton8 = new JRadioButton();
/*  426 */     this.jRadioButton9 = new JRadioButton();
/*  427 */     this.jTextField30 = new JTextField();
/*  428 */     this.jTextField31 = new JTextField();
/*  429 */     this.jLabel92 = new JLabel();
/*  430 */     this.jRadioButton17 = new JRadioButton();
/*  431 */     this.jTextField50 = new JTextField();
/*  432 */     this.jRadioButton18 = new JRadioButton();
/*  433 */     this.jRadioButton19 = new JRadioButton();
/*  434 */     this.jPanel30 = new JPanel();
/*  435 */     this.jLabel30 = new JLabel();
/*  436 */     this.jRadioButton4 = new JRadioButton();
/*  437 */     this.jRadioButton5 = new JRadioButton();
/*  438 */     this.jRadioButton6 = new JRadioButton();
/*  439 */     this.jLabel56 = new JLabel();
/*  440 */     this.jRadioButton10 = new JRadioButton();
/*  441 */     this.jRadioButton11 = new JRadioButton();
/*  442 */     this.jRadioButton12 = new JRadioButton();
/*  443 */     this.jTextField32 = new JTextField();
/*  444 */     this.jTextField33 = new JTextField();
/*      */     
/*  446 */     this.jDialog1.setTitle("Organizar Marcas");
/*  447 */     this.jDialog1.setModal(true);
/*  448 */     this.jDialog1.setResizable(false);
/*      */     
/*  450 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*      */     
/*  452 */     this.jLabel8.setFont(new Font("Tahoma", 1, 14));
/*  453 */     this.jLabel8.setForeground(new Color(0, 102, 102));
/*  454 */     this.jLabel8.setHorizontalAlignment(0);
/*  455 */     this.jLabel8.setText("Organizar Marcas");
/*      */     
/*  457 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/*  458 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, " Agregar Marca ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  460 */     this.jTextField12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  462 */             CajaAgregar.this.jTextField12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  466 */     this.jLabel19.setFont(new Font("Tahoma", 3, 11));
/*  467 */     this.jLabel19.setForeground(new Color(15, 87, 51));
/*  468 */     this.jLabel19.setHorizontalAlignment(4);
/*  469 */     this.jLabel19.setText("Marca");
/*      */     
/*  471 */     this.jButton6.setMnemonic('A');
/*  472 */     this.jButton6.setText("Agregar");
/*  473 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/*  474 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  476 */             CajaAgregar.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  480 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  481 */     this.jPanel18.setLayout(jPanel18Layout);
/*  482 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  484 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  485 */           .addContainerGap()
/*  486 */           .addComponent(this.jLabel19, -2, 65, -2)
/*  487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  488 */           .addComponent(this.jTextField12, -2, 197, -2)
/*  489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  490 */           .addComponent(this.jButton6)
/*  491 */           .addContainerGap(12, 32767)));
/*      */     
/*  493 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  494 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  495 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  496 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  497 */             .addComponent(this.jLabel19)
/*  498 */             .addComponent(this.jTextField12, -2, -1, -2)
/*  499 */             .addComponent(this.jButton6))
/*  500 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  503 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*  504 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder(null, " Eliminar Marcas ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  506 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Marca" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  514 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  519 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  522 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  524 */     this.jButton7.setMnemonic('E');
/*  525 */     this.jButton7.setText("Eliminar");
/*  526 */     this.jButton7.setToolTipText("Eliminar (Alt+E)");
/*  527 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  529 */             CajaAgregar.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  533 */     this.jButton8.setMnemonic('C');
/*  534 */     this.jButton8.setText("Cerrar");
/*  535 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/*  536 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  538 */             CajaAgregar.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  542 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  543 */     this.jPanel19.setLayout(jPanel19Layout);
/*  544 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  546 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  547 */           .addContainerGap()
/*  548 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  549 */             .addComponent(this.jScrollPane1, -1, 351, 32767)
/*  550 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/*  551 */               .addComponent(this.jButton8)
/*  552 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  553 */               .addComponent(this.jButton7)))
/*  554 */           .addContainerGap()));
/*      */     
/*  556 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  557 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  558 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  559 */           .addComponent(this.jScrollPane1, -2, 156, -2)
/*  560 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  561 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  562 */             .addComponent(this.jButton7)
/*  563 */             .addComponent(this.jButton8))
/*  564 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  567 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  568 */     this.jPanel1.setLayout(jPanel1Layout);
/*  569 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  570 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  571 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  572 */           .addContainerGap()
/*  573 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  574 */             .addComponent(this.jPanel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  575 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  576 */               .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/*  577 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  578 */               .addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -1, 381, 32767)))
/*  579 */           .addContainerGap(18, 32767)));
/*      */     
/*  581 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  583 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  584 */           .addContainerGap()
/*  585 */           .addComponent(this.jLabel8)
/*  586 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  587 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  588 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  589 */           .addComponent(this.jPanel18, -2, -1, -2)
/*  590 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  591 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  592 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  595 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  596 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  597 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  598 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  601 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  603 */         .addComponent(this.jPanel1, -2, -1, -2));
/*      */ 
/*      */     
/*  606 */     this.jDialog2.setTitle("Datos de la Póliza");
/*  607 */     this.jDialog2.setModal(true);
/*  608 */     this.jDialog2.setResizable(false);
/*  609 */     this.jDialog2.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  611 */             CajaAgregar.this.jDialog2WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  615 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/*      */     
/*  617 */     this.jLabel9.setFont(new Font("Tahoma", 1, 14));
/*  618 */     this.jLabel9.setForeground(new Color(0, 102, 102));
/*  619 */     this.jLabel9.setHorizontalAlignment(0);
/*  620 */     this.jLabel9.setText("Información del Seguro Vehicular");
/*      */     
/*  622 */     this.jPanel24.setBackground(new Color(146, 193, 134));
/*  623 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder(null, "A nombre de ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  625 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/*  626 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  627 */     this.jLabel32.setHorizontalAlignment(4);
/*  628 */     this.jLabel32.setText("Nombre");
/*      */     
/*  630 */     this.jLabel33.setFont(new Font("Tahoma", 3, 11));
/*  631 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/*  632 */     this.jLabel33.setHorizontalAlignment(0);
/*  633 */     this.jLabel33.setText("Apellido Paterno");
/*      */     
/*  635 */     this.jLabel34.setFont(new Font("Tahoma", 2, 11));
/*  636 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/*  637 */     this.jLabel34.setHorizontalAlignment(4);
/*  638 */     this.jLabel34.setText("Apellido Paterno");
/*      */     
/*  640 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  641 */     this.jPanel24.setLayout(jPanel24Layout);
/*  642 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  643 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  644 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/*  645 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  646 */             .addGroup(jPanel24Layout.createSequentialGroup()
/*  647 */               .addContainerGap()
/*  648 */               .addComponent(this.jLabel32, -2, 87, -2)
/*  649 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  650 */               .addComponent(this.jTextField14, -1, 178, 32767))
/*  651 */             .addGroup(jPanel24Layout.createSequentialGroup()
/*  652 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  653 */                 .addComponent(this.jLabel34, -1, 99, 32767)
/*  654 */                 .addComponent(this.jLabel33, -2, 99, 32767))
/*  655 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  656 */               .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  657 */                 .addComponent(this.jTextField15)
/*  658 */                 .addComponent(this.jTextField16, -1, 176, 32767))))
/*  659 */           .addContainerGap()));
/*      */     
/*  661 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  663 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  664 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  665 */             .addComponent(this.jLabel32)
/*  666 */             .addComponent(this.jTextField14, -2, -1, -2))
/*  667 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  668 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  669 */             .addComponent(this.jLabel33)
/*  670 */             .addComponent(this.jTextField15, -2, -1, -2))
/*  671 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  672 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  673 */             .addComponent(this.jLabel34)
/*  674 */             .addComponent(this.jTextField16, -2, -1, -2))
/*  675 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  678 */     this.jPanel25.setBackground(new Color(146, 193, 134));
/*  679 */     this.jPanel25.setBorder(BorderFactory.createTitledBorder(null, " Beneficiario ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  681 */     this.jLabel35.setFont(new Font("Tahoma", 3, 11));
/*  682 */     this.jLabel35.setForeground(new Color(15, 87, 51));
/*  683 */     this.jLabel35.setHorizontalAlignment(4);
/*  684 */     this.jLabel35.setText("Nombre");
/*      */     
/*  686 */     this.jLabel36.setFont(new Font("Tahoma", 3, 11));
/*  687 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/*  688 */     this.jLabel36.setHorizontalAlignment(0);
/*  689 */     this.jLabel36.setText("Apellido Paterno");
/*      */     
/*  691 */     this.jLabel37.setFont(new Font("Tahoma", 2, 11));
/*  692 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*  693 */     this.jLabel37.setHorizontalAlignment(4);
/*  694 */     this.jLabel37.setText("Apellido Paterno");
/*      */     
/*  696 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  697 */     this.jPanel25.setLayout(jPanel25Layout);
/*  698 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  699 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  700 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
/*  701 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  702 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  703 */               .addContainerGap()
/*  704 */               .addComponent(this.jLabel35, -2, 87, -2)
/*  705 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/*  706 */             .addComponent(this.jLabel36, -2, 100, 32767)
/*  707 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  708 */               .addComponent(this.jLabel37, -2, 94, -2)
/*  709 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/*  710 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  711 */             .addComponent(this.jTextField18, -1, 179, 32767)
/*  712 */             .addComponent(this.jTextField17, GroupLayout.Alignment.LEADING, -1, 179, 32767)
/*  713 */             .addComponent(this.jTextField19, -1, 179, 32767))
/*  714 */           .addContainerGap()));
/*      */     
/*  716 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  717 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  718 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  719 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  720 */             .addComponent(this.jLabel35)
/*  721 */             .addComponent(this.jTextField17, -2, -1, -2))
/*  722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  723 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  724 */             .addComponent(this.jLabel36)
/*  725 */             .addComponent(this.jTextField18, -2, -1, -2))
/*  726 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  727 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  728 */             .addComponent(this.jTextField19, -2, -1, -2)
/*  729 */             .addComponent(this.jLabel37))
/*  730 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  733 */     this.jPanel26.setBackground(new Color(146, 193, 134));
/*  734 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Póliza ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  736 */     this.jLabel38.setFont(new Font("Tahoma", 3, 11));
/*  737 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  738 */     this.jLabel38.setHorizontalAlignment(4);
/*  739 */     this.jLabel38.setText("Tipo de Seguro");
/*      */     
/*  741 */     this.jLabel39.setFont(new Font("Tahoma", 3, 11));
/*  742 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*  743 */     this.jLabel39.setHorizontalAlignment(4);
/*  744 */     this.jLabel39.setText("Costo");
/*      */     
/*  746 */     this.jLabel40.setFont(new Font("Tahoma", 3, 11));
/*  747 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/*  748 */     this.jLabel40.setHorizontalAlignment(4);
/*  749 */     this.jLabel40.setText("Fecha de Inicio");
/*      */     
/*  751 */     this.jDateChooser2.setDate(this.fechaActual);
/*  752 */     this.jDateChooser2.setDateFormatString("yyyy/MM/dd");
/*  753 */     this.jDateChooser2.setIcon(this.icon);
/*  754 */     this.jDateChooser2.setMaxSelectableDate(this.fecha);
/*  755 */     this.jDateChooser2.setMinSelectableDate(this.fechaActual);
/*      */     
/*  757 */     this.jLabel41.setFont(new Font("Tahoma", 3, 11));
/*  758 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/*  759 */     this.jLabel41.setHorizontalAlignment(4);
/*  760 */     this.jLabel41.setText("F. de Vigencia");
/*      */     
/*  762 */     this.jDateChooser5.setDate(this.fechaActual);
/*  763 */     this.jDateChooser5.setDateFormatString("yyyy/MM/dd");
/*  764 */     this.jDateChooser5.setIcon(this.icon);
/*  765 */     this.jDateChooser5.setMaxSelectableDate(this.fecha);
/*  766 */     this.jDateChooser5.setMinSelectableDate(this.fechaActual);
/*      */     
/*  768 */     this.jLabel42.setFont(new Font("Tahoma", 3, 11));
/*  769 */     this.jLabel42.setForeground(new Color(15, 87, 51));
/*  770 */     this.jLabel42.setHorizontalAlignment(4);
/*  771 */     this.jLabel42.setText("T. de Gracia");
/*      */     
/*  773 */     this.jTextArea1.setColumns(20);
/*  774 */     this.jTextArea1.setRows(5);
/*  775 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/*  777 */     this.jLabel43.setFont(new Font("Tahoma", 2, 11));
/*  778 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/*  779 */     this.jLabel43.setHorizontalAlignment(0);
/*  780 */     this.jLabel43.setText("Coberturas");
/*      */     
/*  782 */     this.jLabel53.setFont(new Font("Tahoma", 2, 11));
/*  783 */     this.jLabel53.setForeground(new Color(15, 87, 51));
/*  784 */     this.jLabel53.setText("Meses");
/*      */     
/*  786 */     this.jLabel58.setFont(new Font("Tahoma", 2, 11));
/*  787 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/*  788 */     this.jLabel58.setText("Pesos");
/*      */     
/*  790 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  791 */     this.jPanel26.setLayout(jPanel26Layout);
/*  792 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  793 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  794 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  795 */           .addContainerGap()
/*  796 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  797 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  798 */               .addComponent(this.jLabel38, -2, 87, -2)
/*  799 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  800 */               .addComponent(this.jTextField20, -2, 208, -2))
/*  801 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  802 */               .addComponent(this.jLabel41, -2, 87, -2)
/*  803 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  804 */               .addComponent((Component)this.jDateChooser5, -1, -1, 32767))
/*  805 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  806 */               .addComponent(this.jLabel42, -2, 87, -2)
/*  807 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  808 */               .addComponent(this.jTextField22, -2, 96, -2)
/*  809 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  810 */               .addComponent(this.jLabel53, -2, 87, -2))
/*  811 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  812 */               .addComponent(this.jLabel40, -2, 87, -2)
/*  813 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  814 */               .addComponent((Component)this.jDateChooser2, -1, -1, 32767))
/*  815 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  816 */               .addComponent(this.jLabel39, -2, 87, -2)
/*  817 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  818 */               .addComponent(this.jTextField21, -2, 92, -2)
/*  819 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  820 */               .addComponent(this.jLabel58, -2, 87, -2)))
/*  821 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  822 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  823 */             .addComponent(this.jLabel43, -1, -1, 32767)
/*  824 */             .addComponent(this.jScrollPane2, -1, 271, 32767))
/*  825 */           .addContainerGap(-1, 32767)));
/*      */     
/*  827 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  828 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  829 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  830 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  831 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  832 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  833 */                 .addComponent(this.jLabel38)
/*  834 */                 .addComponent(this.jTextField20, -2, -1, -2)
/*  835 */                 .addComponent(this.jLabel43))
/*  836 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  837 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  838 */                 .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  839 */                   .addComponent(this.jLabel39)
/*  840 */                   .addComponent(this.jTextField21, -2, -1, -2))
/*  841 */                 .addComponent(this.jLabel58))
/*  842 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  843 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  844 */                 .addComponent((Component)this.jDateChooser2, -1, -1, 32767)
/*  845 */                 .addComponent(this.jLabel40))
/*  846 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  847 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */                 .addComponent(this.jLabel41)
/*  849 */                 .addComponent((Component)this.jDateChooser5, -2, -1, -2))
/*  850 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  851 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  852 */                 .addComponent(this.jLabel42)
/*  853 */                 .addComponent(this.jTextField22, -2, -1, -2)
/*  854 */                 .addComponent(this.jLabel53)))
/*  855 */             .addGroup(jPanel26Layout.createSequentialGroup()
/*  856 */               .addGap(28, 28, 28)
/*  857 */               .addComponent(this.jScrollPane2, -2, -1, -2)))
/*  858 */           .addContainerGap()));
/*      */ 
/*      */     
/*  861 */     this.jPanel27.setBackground(new Color(146, 193, 134));
/*  862 */     this.jPanel27.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Aseguradora ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  864 */     this.jLabel44.setFont(new Font("Tahoma", 3, 11));
/*  865 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/*  866 */     this.jLabel44.setHorizontalAlignment(4);
/*  867 */     this.jLabel44.setText("Aseguradora");
/*      */     
/*  869 */     this.jLabel45.setFont(new Font("Tahoma", 3, 11));
/*  870 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/*  871 */     this.jLabel45.setHorizontalAlignment(4);
/*  872 */     this.jLabel45.setText("Nombre del Agente");
/*      */     
/*  874 */     this.jLabel46.setFont(new Font("Tahoma", 2, 11));
/*  875 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/*  876 */     this.jLabel46.setHorizontalAlignment(4);
/*  877 */     this.jLabel46.setText("Calle");
/*      */     
/*  879 */     this.jLabel47.setFont(new Font("Tahoma", 2, 11));
/*  880 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/*  881 */     this.jLabel47.setHorizontalAlignment(4);
/*  882 */     this.jLabel47.setText("Num.");
/*      */     
/*  884 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/*  885 */     this.jLabel48.setForeground(new Color(15, 87, 51));
/*  886 */     this.jLabel48.setHorizontalAlignment(4);
/*  887 */     this.jLabel48.setText("Colonia");
/*      */     
/*  889 */     this.jLabel49.setFont(new Font("Tahoma", 2, 11));
/*  890 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/*  891 */     this.jLabel49.setHorizontalAlignment(4);
/*  892 */     this.jLabel49.setText("Ciudad");
/*      */     
/*  894 */     this.jLabel50.setFont(new Font("Tahoma", 2, 11));
/*  895 */     this.jLabel50.setForeground(new Color(15, 87, 51));
/*  896 */     this.jLabel50.setHorizontalAlignment(4);
/*  897 */     this.jLabel50.setText("c.p.");
/*      */     
/*  899 */     this.jLabel51.setFont(new Font("Tahoma", 2, 11));
/*  900 */     this.jLabel51.setForeground(new Color(15, 87, 51));
/*  901 */     this.jLabel51.setHorizontalAlignment(4);
/*  902 */     this.jLabel51.setText("Estado");
/*      */     
/*  904 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  905 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/*  906 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  908 */             CajaAgregar.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  912 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/*  913 */     this.jLabel52.setForeground(new Color(15, 87, 51));
/*  914 */     this.jLabel52.setHorizontalAlignment(4);
/*  915 */     this.jLabel52.setText("Teléfono");
/*      */     
/*  917 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  919 */             CajaAgregar.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  923 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  924 */     this.jPanel27.setLayout(jPanel27Layout);
/*  925 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  926 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  927 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  928 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  929 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  930 */               .addGap(10, 10, 10)
/*  931 */               .addComponent(this.jLabel52, -1, 110, 32767))
/*  932 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  933 */               .addContainerGap()
/*  934 */               .addComponent(this.jLabel49, -1, 110, 32767))
/*  935 */             .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  936 */               .addComponent(this.jLabel46, -1, -1, 32767)
/*  937 */               .addComponent(this.jLabel45, -1, -1, 32767)
/*  938 */               .addGroup(jPanel27Layout.createSequentialGroup()
/*  939 */                 .addGap(10, 10, 10)
/*  940 */                 .addComponent(this.jLabel44, -1, 110, 32767))))
/*  941 */           .addGap(16, 16, 16)
/*  942 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  943 */             .addComponent(this.jFormattedTextField1, GroupLayout.Alignment.LEADING, -2, 154, -2)
/*  944 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  945 */               .addComponent(this.jTextField25, -2, 154, -2)
/*  946 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  947 */               .addComponent(this.jLabel47, -2, 41, -2)
/*  948 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  949 */               .addComponent(this.jTextField26, -2, 47, -2)
/*  950 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  951 */               .addComponent(this.jLabel48, -2, 47, -2)
/*  952 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  953 */               .addComponent(this.jTextField27, -1, 145, 32767))
/*  954 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
/*  955 */               .addComponent(this.jTextField28, -2, 154, -2)
/*  956 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  957 */               .addComponent(this.jLabel50, -2, 41, -2)
/*  958 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  959 */               .addComponent(this.jTextField29, -2, 47, -2)
/*  960 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  961 */               .addComponent(this.jLabel51, -2, 47, -2)
/*  962 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  963 */               .addComponent(this.jComboBox4, 0, 145, 32767))
/*  964 */             .addComponent(this.jTextField24, GroupLayout.Alignment.LEADING, -1, 450, 32767)
/*  965 */             .addComponent(this.jTextField23, -1, 450, 32767))
/*  966 */           .addContainerGap()));
/*      */     
/*  968 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  969 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  970 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  971 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  972 */             .addComponent(this.jLabel44)
/*  973 */             .addComponent(this.jTextField23, -2, -1, -2))
/*  974 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  975 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  976 */             .addComponent(this.jLabel45)
/*  977 */             .addComponent(this.jTextField24, -2, -1, -2))
/*  978 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  979 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  980 */             .addComponent(this.jLabel46)
/*  981 */             .addComponent(this.jTextField25, -2, -1, -2)
/*  982 */             .addComponent(this.jLabel48)
/*  983 */             .addComponent(this.jLabel47)
/*  984 */             .addComponent(this.jTextField26, -2, -1, -2)
/*  985 */             .addComponent(this.jTextField27, -2, -1, -2))
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  988 */             .addComponent(this.jLabel49)
/*  989 */             .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  990 */               .addComponent(this.jTextField28, -2, -1, -2)
/*  991 */               .addComponent(this.jLabel50)
/*  992 */               .addComponent(this.jTextField29, -2, -1, -2)
/*  993 */               .addComponent(this.jLabel51)
/*  994 */               .addComponent(this.jComboBox4, -2, -1, -2)))
/*  995 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  996 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  997 */             .addComponent(this.jFormattedTextField1, -2, -1, -2)
/*  998 */             .addComponent(this.jLabel52))
/*  999 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1002 */     this.jButton11.setMnemonic('C');
/* 1003 */     this.jButton11.setText("Cerrar");
/* 1004 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/* 1005 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1007 */             CajaAgregar.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1011 */     this.jButton12.setMnemonic('L');
/* 1012 */     this.jButton12.setText("Limpiar");
/* 1013 */     this.jButton12.setToolTipText("Limpiar (Alt+L)");
/* 1014 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1016 */             CajaAgregar.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1020 */     this.jButton13.setMnemonic('G');
/* 1021 */     this.jButton13.setText("Guardar");
/* 1022 */     this.jButton13.setToolTipText("Guardar (Alt+G)");
/* 1023 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1025 */             CajaAgregar.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1029 */     this.jButton14.setMnemonic('R');
/* 1030 */     this.jButton14.setText("Restablecer");
/* 1031 */     this.jButton14.setToolTipText("Restablecer (Alt+R)");
/* 1032 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1034 */             CajaAgregar.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1038 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1039 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1040 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1041 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1042 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1043 */           .addContainerGap()
/* 1044 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1045 */             .addComponent(this.jSeparator2, GroupLayout.Alignment.LEADING)
/* 1046 */             .addComponent(this.jPanel27, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 1047 */             .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1048 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
/* 1049 */               .addComponent(this.jPanel24, -2, -1, -2)
/* 1050 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1051 */               .addComponent(this.jPanel25, -1, -1, 32767))
/* 1052 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1053 */               .addComponent(this.jButton14, -2, 104, -2)
/* 1054 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1055 */               .addComponent(this.jButton13, -2, 93, -2)
/* 1056 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1057 */               .addComponent(this.jButton12, -2, 93, -2)
/* 1058 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1059 */               .addComponent(this.jButton11, -2, 93, -2))
/* 1060 */             .addComponent(this.jLabel9, GroupLayout.Alignment.LEADING, -1, 602, 32767))
/* 1061 */           .addContainerGap(20, 32767)));
/*      */     
/* 1063 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1065 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1066 */           .addContainerGap()
/* 1067 */           .addComponent(this.jLabel9)
/* 1068 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1069 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1070 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1071 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1072 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 1073 */             .addComponent(this.jPanel25, -2, -1, -2))
/* 1074 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 1076 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1077 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1078 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1079 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1080 */             .addComponent(this.jButton11)
/* 1081 */             .addComponent(this.jButton12)
/* 1082 */             .addComponent(this.jButton13)
/* 1083 */             .addComponent(this.jButton14))
/* 1084 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1087 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1088 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1089 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1091 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 1093 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1094 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1095 */         .addComponent(this.jPanel2, -2, -1, -2));
/*      */ 
/*      */     
/* 1098 */     this.jDialog4.setTitle("Datos de la Póliza");
/* 1099 */     this.jDialog4.setModal(true);
/* 1100 */     this.jDialog4.setResizable(false);
/* 1101 */     this.jDialog4.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1103 */             CajaAgregar.this.jDialog4WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1107 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*      */     
/* 1109 */     this.jLabel11.setFont(new Font("Tahoma", 1, 14));
/* 1110 */     this.jLabel11.setForeground(new Color(0, 102, 102));
/* 1111 */     this.jLabel11.setHorizontalAlignment(0);
/* 1112 */     this.jLabel11.setText("Información del Seguro Ecológico");
/*      */     
/* 1114 */     this.jPanel31.setBackground(new Color(146, 193, 134));
/* 1115 */     this.jPanel31.setBorder(BorderFactory.createTitledBorder(null, "A nombre de ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1117 */     this.jLabel59.setFont(new Font("Tahoma", 3, 11));
/* 1118 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 1119 */     this.jLabel59.setHorizontalAlignment(4);
/* 1120 */     this.jLabel59.setText("Nombre");
/*      */     
/* 1122 */     this.jLabel60.setFont(new Font("Tahoma", 3, 11));
/* 1123 */     this.jLabel60.setForeground(new Color(15, 87, 51));
/* 1124 */     this.jLabel60.setHorizontalAlignment(0);
/* 1125 */     this.jLabel60.setText("Apellido Paterno");
/*      */     
/* 1127 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/* 1128 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 1129 */     this.jLabel61.setHorizontalAlignment(4);
/* 1130 */     this.jLabel61.setText("Apellido Paterno");
/*      */     
/* 1132 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1133 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1134 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1136 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1137 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1138 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1139 */               .addContainerGap()
/* 1140 */               .addComponent(this.jLabel59, -2, 87, -2)
/* 1141 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1142 */               .addComponent(this.jTextField34, -1, 178, 32767))
/* 1143 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1144 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1145 */                 .addComponent(this.jLabel61, -1, 99, 32767)
/* 1146 */                 .addComponent(this.jLabel60, -2, 99, 32767))
/* 1147 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1148 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1149 */                 .addComponent(this.jTextField35)
/* 1150 */                 .addComponent(this.jTextField36, -1, 176, 32767))))
/* 1151 */           .addContainerGap()));
/*      */     
/* 1153 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1155 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1156 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1157 */             .addComponent(this.jLabel59)
/* 1158 */             .addComponent(this.jTextField34, -2, -1, -2))
/* 1159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1160 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1161 */             .addComponent(this.jLabel60)
/* 1162 */             .addComponent(this.jTextField35, -2, -1, -2))
/* 1163 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1164 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1165 */             .addComponent(this.jLabel61)
/* 1166 */             .addComponent(this.jTextField36, -2, -1, -2))
/* 1167 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1170 */     this.jPanel32.setBackground(new Color(146, 193, 134));
/* 1171 */     this.jPanel32.setBorder(BorderFactory.createTitledBorder(null, " Beneficiario ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1173 */     this.jLabel62.setFont(new Font("Tahoma", 3, 11));
/* 1174 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 1175 */     this.jLabel62.setHorizontalAlignment(4);
/* 1176 */     this.jLabel62.setText("Nombre");
/*      */     
/* 1178 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/* 1179 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/* 1180 */     this.jLabel63.setHorizontalAlignment(0);
/* 1181 */     this.jLabel63.setText("Apellido Paterno");
/*      */     
/* 1183 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/* 1184 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/* 1185 */     this.jLabel64.setHorizontalAlignment(4);
/* 1186 */     this.jLabel64.setText("Apellido Paterno");
/*      */     
/* 1188 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1189 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1190 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1191 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1192 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1193 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1194 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1195 */               .addContainerGap()
/* 1196 */               .addComponent(this.jLabel62, -2, 87, -2)
/* 1197 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 1198 */             .addComponent(this.jLabel63, -2, 100, 32767)
/* 1199 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1200 */               .addComponent(this.jLabel64, -2, 94, -2)
/* 1201 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 1202 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1203 */             .addComponent(this.jTextField38, -1, 179, 32767)
/* 1204 */             .addComponent(this.jTextField37, GroupLayout.Alignment.LEADING, -1, 179, 32767)
/* 1205 */             .addComponent(this.jTextField39, -1, 179, 32767))
/* 1206 */           .addContainerGap()));
/*      */     
/* 1208 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1209 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1210 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1211 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1212 */             .addComponent(this.jLabel62)
/* 1213 */             .addComponent(this.jTextField37, -2, -1, -2))
/* 1214 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1215 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1216 */             .addComponent(this.jLabel63)
/* 1217 */             .addComponent(this.jTextField38, -2, -1, -2))
/* 1218 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1219 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1220 */             .addComponent(this.jTextField39, -2, -1, -2)
/* 1221 */             .addComponent(this.jLabel64))
/* 1222 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1225 */     this.jPanel33.setBackground(new Color(146, 193, 134));
/* 1226 */     this.jPanel33.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Póliza ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1228 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/* 1229 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/* 1230 */     this.jLabel65.setHorizontalAlignment(4);
/* 1231 */     this.jLabel65.setText("Tipo de Seguro");
/*      */     
/* 1233 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/* 1234 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/* 1235 */     this.jLabel66.setHorizontalAlignment(4);
/* 1236 */     this.jLabel66.setText("Costo");
/*      */     
/* 1238 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/* 1239 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1240 */     this.jLabel67.setHorizontalAlignment(4);
/* 1241 */     this.jLabel67.setText("Fecha de Inicio");
/*      */     
/* 1243 */     this.jDateChooser3.setDate(this.fechaActual);
/* 1244 */     this.jDateChooser3.setDateFormatString("yyyy/MM/dd");
/* 1245 */     this.jDateChooser3.setIcon(this.icon);
/* 1246 */     this.jDateChooser3.setMaxSelectableDate(this.fecha);
/* 1247 */     this.jDateChooser3.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1249 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/* 1250 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/* 1251 */     this.jLabel68.setHorizontalAlignment(4);
/* 1252 */     this.jLabel68.setText("F. de Vigencia");
/*      */     
/* 1254 */     this.jDateChooser6.setDate(this.fechaActual);
/* 1255 */     this.jDateChooser6.setDateFormatString("yyyy/MM/dd");
/* 1256 */     this.jDateChooser6.setIcon(this.icon);
/* 1257 */     this.jDateChooser6.setMaxSelectableDate(this.fecha);
/* 1258 */     this.jDateChooser6.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1260 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/* 1261 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/* 1262 */     this.jLabel69.setHorizontalAlignment(4);
/* 1263 */     this.jLabel69.setText("T. de Gracia");
/*      */     
/* 1265 */     this.jTextArea2.setColumns(20);
/* 1266 */     this.jTextArea2.setRows(5);
/* 1267 */     this.jScrollPane4.setViewportView(this.jTextArea2);
/*      */     
/* 1269 */     this.jLabel70.setFont(new Font("Tahoma", 2, 11));
/* 1270 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/* 1271 */     this.jLabel70.setHorizontalAlignment(0);
/* 1272 */     this.jLabel70.setText("Coberturas");
/*      */     
/* 1274 */     this.jLabel71.setFont(new Font("Tahoma", 2, 11));
/* 1275 */     this.jLabel71.setForeground(new Color(15, 87, 51));
/* 1276 */     this.jLabel71.setText("Meses");
/*      */     
/* 1278 */     this.jLabel72.setFont(new Font("Tahoma", 2, 11));
/* 1279 */     this.jLabel72.setForeground(new Color(15, 87, 51));
/* 1280 */     this.jLabel72.setText("Pesos");
/*      */     
/* 1282 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1283 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1284 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1286 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1287 */           .addContainerGap()
/* 1288 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1289 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1290 */               .addComponent(this.jLabel65, -2, 87, -2)
/* 1291 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1292 */               .addComponent(this.jTextField40, -2, 208, -2))
/* 1293 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1294 */               .addComponent(this.jLabel68, -2, 87, -2)
/* 1295 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1296 */               .addComponent((Component)this.jDateChooser6, -1, -1, 32767))
/* 1297 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1298 */               .addComponent(this.jLabel69, -2, 87, -2)
/* 1299 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1300 */               .addComponent(this.jTextField42, -2, 96, -2)
/* 1301 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1302 */               .addComponent(this.jLabel71, -2, 87, -2))
/* 1303 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1304 */               .addComponent(this.jLabel67, -2, 87, -2)
/* 1305 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1306 */               .addComponent((Component)this.jDateChooser3, -1, -1, 32767))
/* 1307 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1308 */               .addComponent(this.jLabel66, -2, 87, -2)
/* 1309 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1310 */               .addComponent(this.jTextField41, -2, 92, -2)
/* 1311 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1312 */               .addComponent(this.jLabel72, -2, 87, -2)))
/* 1313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1314 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1315 */             .addComponent(this.jLabel70, -1, -1, 32767)
/* 1316 */             .addComponent(this.jScrollPane4, -1, 271, 32767))
/* 1317 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1319 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1321 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1322 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1323 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1324 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1325 */                 .addComponent(this.jLabel65)
/* 1326 */                 .addComponent(this.jTextField40, -2, -1, -2)
/* 1327 */                 .addComponent(this.jLabel70))
/* 1328 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1329 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1330 */                 .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1331 */                   .addComponent(this.jLabel66)
/* 1332 */                   .addComponent(this.jTextField41, -2, -1, -2))
/* 1333 */                 .addComponent(this.jLabel72))
/* 1334 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1335 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1336 */                 .addComponent((Component)this.jDateChooser3, -1, -1, 32767)
/* 1337 */                 .addComponent(this.jLabel67))
/* 1338 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1339 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1340 */                 .addComponent(this.jLabel68)
/* 1341 */                 .addComponent((Component)this.jDateChooser6, -2, -1, -2))
/* 1342 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1343 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1344 */                 .addComponent(this.jLabel69)
/* 1345 */                 .addComponent(this.jTextField42, -2, -1, -2)
/* 1346 */                 .addComponent(this.jLabel71)))
/* 1347 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1348 */               .addGap(28, 28, 28)
/* 1349 */               .addComponent(this.jScrollPane4, -2, -1, -2)))
/* 1350 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1353 */     this.jPanel34.setBackground(new Color(146, 193, 134));
/* 1354 */     this.jPanel34.setBorder(BorderFactory.createTitledBorder(null, " Datos de la Aseguradora ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1356 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/* 1357 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/* 1358 */     this.jLabel73.setHorizontalAlignment(4);
/* 1359 */     this.jLabel73.setText("Aseguradora");
/*      */     
/* 1361 */     this.jLabel74.setFont(new Font("Tahoma", 3, 11));
/* 1362 */     this.jLabel74.setForeground(new Color(15, 87, 51));
/* 1363 */     this.jLabel74.setHorizontalAlignment(4);
/* 1364 */     this.jLabel74.setText("Nombre del Agente");
/*      */     
/* 1366 */     this.jLabel75.setFont(new Font("Tahoma", 2, 11));
/* 1367 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/* 1368 */     this.jLabel75.setHorizontalAlignment(4);
/* 1369 */     this.jLabel75.setText("Calle");
/*      */     
/* 1371 */     this.jLabel76.setFont(new Font("Tahoma", 2, 11));
/* 1372 */     this.jLabel76.setForeground(new Color(15, 87, 51));
/* 1373 */     this.jLabel76.setHorizontalAlignment(4);
/* 1374 */     this.jLabel76.setText("Num.");
/*      */     
/* 1376 */     this.jLabel77.setFont(new Font("Tahoma", 2, 11));
/* 1377 */     this.jLabel77.setForeground(new Color(15, 87, 51));
/* 1378 */     this.jLabel77.setHorizontalAlignment(4);
/* 1379 */     this.jLabel77.setText("Colonia");
/*      */     
/* 1381 */     this.jLabel78.setFont(new Font("Tahoma", 2, 11));
/* 1382 */     this.jLabel78.setForeground(new Color(15, 87, 51));
/* 1383 */     this.jLabel78.setHorizontalAlignment(4);
/* 1384 */     this.jLabel78.setText("Ciudad");
/*      */     
/* 1386 */     this.jLabel79.setFont(new Font("Tahoma", 2, 11));
/* 1387 */     this.jLabel79.setForeground(new Color(15, 87, 51));
/* 1388 */     this.jLabel79.setHorizontalAlignment(4);
/* 1389 */     this.jLabel79.setText("c.p.");
/*      */     
/* 1391 */     this.jLabel80.setFont(new Font("Tahoma", 2, 11));
/* 1392 */     this.jLabel80.setForeground(new Color(15, 87, 51));
/* 1393 */     this.jLabel80.setHorizontalAlignment(4);
/* 1394 */     this.jLabel80.setText("Estado");
/*      */     
/* 1396 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1397 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 1398 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1400 */             CajaAgregar.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1404 */     this.jLabel81.setFont(new Font("Tahoma", 2, 11));
/* 1405 */     this.jLabel81.setForeground(new Color(15, 87, 51));
/* 1406 */     this.jLabel81.setHorizontalAlignment(4);
/* 1407 */     this.jLabel81.setText("Teléfono");
/*      */     
/* 1409 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1411 */             CajaAgregar.this.jFormattedTextField2FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/* 1415 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1416 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1417 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1418 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1419 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1420 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1421 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1422 */               .addGap(10, 10, 10)
/* 1423 */               .addComponent(this.jLabel81, -1, 110, 32767))
/* 1424 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1425 */               .addContainerGap()
/* 1426 */               .addComponent(this.jLabel78, -1, 110, 32767))
/* 1427 */             .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1428 */               .addComponent(this.jLabel75, -1, -1, 32767)
/* 1429 */               .addComponent(this.jLabel74, -1, -1, 32767)
/* 1430 */               .addGroup(jPanel34Layout.createSequentialGroup()
/* 1431 */                 .addGap(10, 10, 10)
/* 1432 */                 .addComponent(this.jLabel73, -1, 110, 32767))))
/* 1433 */           .addGap(16, 16, 16)
/* 1434 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1435 */             .addComponent(this.jFormattedTextField2, GroupLayout.Alignment.LEADING, -2, 154, -2)
/* 1436 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1437 */               .addComponent(this.jTextField45, -2, 154, -2)
/* 1438 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1439 */               .addComponent(this.jLabel76, -2, 41, -2)
/* 1440 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1441 */               .addComponent(this.jTextField46, -2, 47, -2)
/* 1442 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1443 */               .addComponent(this.jLabel77, -2, 47, -2)
/* 1444 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1445 */               .addComponent(this.jTextField47, -1, 145, 32767))
/* 1446 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
/* 1447 */               .addComponent(this.jTextField48, -2, 154, -2)
/* 1448 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1449 */               .addComponent(this.jLabel79, -2, 41, -2)
/* 1450 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1451 */               .addComponent(this.jTextField49, -2, 47, -2)
/* 1452 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1453 */               .addComponent(this.jLabel80, -2, 47, -2)
/* 1454 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1455 */               .addComponent(this.jComboBox6, 0, 145, 32767))
/* 1456 */             .addComponent(this.jTextField44, GroupLayout.Alignment.LEADING, -1, 450, 32767)
/* 1457 */             .addComponent(this.jTextField43, -1, 450, 32767))
/* 1458 */           .addContainerGap()));
/*      */     
/* 1460 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1462 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1463 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1464 */             .addComponent(this.jLabel73)
/* 1465 */             .addComponent(this.jTextField43, -2, -1, -2))
/* 1466 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1467 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1468 */             .addComponent(this.jLabel74)
/* 1469 */             .addComponent(this.jTextField44, -2, -1, -2))
/* 1470 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1471 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1472 */             .addComponent(this.jLabel75)
/* 1473 */             .addComponent(this.jTextField45, -2, -1, -2)
/* 1474 */             .addComponent(this.jLabel77)
/* 1475 */             .addComponent(this.jLabel76)
/* 1476 */             .addComponent(this.jTextField46, -2, -1, -2)
/* 1477 */             .addComponent(this.jTextField47, -2, -1, -2))
/* 1478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1479 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1480 */             .addComponent(this.jLabel78)
/* 1481 */             .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1482 */               .addComponent(this.jTextField48, -2, -1, -2)
/* 1483 */               .addComponent(this.jLabel79)
/* 1484 */               .addComponent(this.jTextField49, -2, -1, -2)
/* 1485 */               .addComponent(this.jLabel80)
/* 1486 */               .addComponent(this.jComboBox6, -2, -1, -2)))
/* 1487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1488 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1489 */             .addComponent(this.jFormattedTextField2, -2, -1, -2)
/* 1490 */             .addComponent(this.jLabel81))
/* 1491 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1494 */     this.jButton17.setMnemonic('C');
/* 1495 */     this.jButton17.setText("Cerrar");
/* 1496 */     this.jButton17.setToolTipText("Cerrar (Alt+C)");
/* 1497 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1499 */             CajaAgregar.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1503 */     this.jButton18.setMnemonic('L');
/* 1504 */     this.jButton18.setText("Limpiar");
/* 1505 */     this.jButton18.setToolTipText("Limpiar (Alt+L)");
/* 1506 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1508 */             CajaAgregar.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1512 */     this.jButton19.setMnemonic('G');
/* 1513 */     this.jButton19.setText("Guardar");
/* 1514 */     this.jButton19.setToolTipText("Guardar (Alt+G)");
/* 1515 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1517 */             CajaAgregar.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1521 */     this.jButton20.setMnemonic('R');
/* 1522 */     this.jButton20.setText("Restablecer");
/* 1523 */     this.jButton20.setToolTipText("Restablecer (Alt+R)");
/* 1524 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1526 */             CajaAgregar.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1530 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1531 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1532 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1533 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1534 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1535 */           .addContainerGap()
/* 1536 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1537 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.LEADING)
/* 1538 */             .addComponent(this.jPanel34, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 1539 */             .addComponent(this.jPanel33, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1540 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1541 */               .addComponent(this.jPanel31, -2, -1, -2)
/* 1542 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1543 */               .addComponent(this.jPanel32, -1, -1, 32767))
/* 1544 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1545 */               .addComponent(this.jButton20, -2, 104, -2)
/* 1546 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1547 */               .addComponent(this.jButton19, -2, 93, -2)
/* 1548 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1549 */               .addComponent(this.jButton18, -2, 93, -2)
/* 1550 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1551 */               .addComponent(this.jButton17, -2, 93, -2))
/* 1552 */             .addComponent(this.jLabel11, GroupLayout.Alignment.LEADING, -1, 602, 32767))
/* 1553 */           .addContainerGap(20, 32767)));
/*      */     
/* 1555 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1556 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1557 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1558 */           .addContainerGap()
/* 1559 */           .addComponent(this.jLabel11)
/* 1560 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1561 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1562 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1563 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1564 */             .addComponent(this.jPanel31, -2, -1, -2)
/* 1565 */             .addComponent(this.jPanel32, -2, -1, -2))
/* 1566 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1567 */           .addComponent(this.jPanel33, -2, -1, -2)
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addComponent(this.jPanel34, -2, -1, -2)
/* 1570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1571 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1572 */             .addComponent(this.jButton17)
/* 1573 */             .addComponent(this.jButton18)
/* 1574 */             .addComponent(this.jButton19)
/* 1575 */             .addComponent(this.jButton20))
/* 1576 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1579 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1580 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1581 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1583 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*      */     
/* 1585 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1586 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1587 */         .addComponent(this.jPanel5, -2, -1, -2));
/*      */ 
/*      */     
/* 1590 */     this.jDialog5.setTitle("SEMARNAT");
/* 1591 */     this.jDialog5.setModal(true);
/* 1592 */     this.jDialog5.setResizable(false);
/* 1593 */     this.jDialog5.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1595 */             CajaAgregar.this.jDialog5WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1599 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*      */     
/* 1601 */     this.jLabel82.setFont(new Font("Tahoma", 1, 14));
/* 1602 */     this.jLabel82.setForeground(new Color(0, 102, 102));
/* 1603 */     this.jLabel82.setHorizontalAlignment(0);
/* 1604 */     this.jLabel82.setText("Permiso de la SEMARNAT");
/*      */     
/* 1606 */     this.jLabel83.setFont(new Font("Tahoma", 3, 11));
/* 1607 */     this.jLabel83.setForeground(new Color(15, 87, 51));
/* 1608 */     this.jLabel83.setHorizontalAlignment(4);
/* 1609 */     this.jLabel83.setText("Fecha de Inicio");
/*      */     
/* 1611 */     this.jRadioButton13.setSelected(true);
/* 1612 */     this.jRadioButton13.setText("Alta");
/*      */     
/* 1614 */     this.jRadioButton14.setText("Actualización");
/*      */     
/* 1616 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1617 */     this.jDateChooser4.setDateFormatString("yyyy/MM/dd");
/* 1618 */     this.jDateChooser4.setIcon(this.icon);
/* 1619 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1620 */     this.jDateChooser4.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1622 */     this.jLabel85.setFont(new Font("Tahoma", 3, 11));
/* 1623 */     this.jLabel85.setForeground(new Color(15, 87, 51));
/* 1624 */     this.jLabel85.setHorizontalAlignment(4);
/* 1625 */     this.jLabel85.setText("Tipo");
/*      */     
/* 1627 */     this.jLabel84.setFont(new Font("Tahoma", 3, 11));
/* 1628 */     this.jLabel84.setForeground(new Color(15, 87, 51));
/* 1629 */     this.jLabel84.setHorizontalAlignment(4);
/* 1630 */     this.jLabel84.setText("Fecha de Vigencia");
/*      */     
/* 1632 */     this.jDateChooser7.setDate(this.fechaActual);
/* 1633 */     this.jDateChooser7.setDateFormatString("yyyy/MM/dd");
/* 1634 */     this.jDateChooser7.setIcon(this.icon);
/* 1635 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/* 1636 */     this.jDateChooser7.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1638 */     this.jLabel86.setFont(new Font("Tahoma", 2, 11));
/* 1639 */     this.jLabel86.setForeground(new Color(15, 87, 51));
/* 1640 */     this.jLabel86.setHorizontalAlignment(4);
/* 1641 */     this.jLabel86.setText("Comentario");
/*      */     
/* 1643 */     this.jTextArea3.setColumns(20);
/* 1644 */     this.jTextArea3.setRows(5);
/* 1645 */     this.jScrollPane5.setViewportView(this.jTextArea3);
/*      */     
/* 1647 */     this.jButton21.setMnemonic('C');
/* 1648 */     this.jButton21.setText("Cerrar");
/* 1649 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 1650 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1652 */             CajaAgregar.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1656 */     this.jButton22.setMnemonic('L');
/* 1657 */     this.jButton22.setText("Limpiar");
/* 1658 */     this.jButton22.setToolTipText("Limpiar (Alt+L)");
/* 1659 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1661 */             CajaAgregar.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1665 */     this.jButton23.setMnemonic('G');
/* 1666 */     this.jButton23.setText("Guardar");
/* 1667 */     this.jButton23.setToolTipText("Guardar (Alt+G)");
/* 1668 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1670 */             CajaAgregar.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1674 */     this.jButton24.setMnemonic('R');
/* 1675 */     this.jButton24.setText("Restablecer");
/* 1676 */     this.jButton24.setToolTipText("Restablecer (Alt+R)");
/* 1677 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1679 */             CajaAgregar.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1683 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1684 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1685 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1686 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1687 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1688 */           .addContainerGap()
/* 1689 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1690 */             .addComponent(this.jSeparator5, -1, 331, 32767)
/* 1691 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1692 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1693 */                 .addComponent(this.jLabel85, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 1694 */                 .addComponent(this.jLabel83, -1, 108, 32767)
/* 1695 */                 .addComponent(this.jLabel84, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 1696 */                 .addComponent(this.jLabel86, -1, 108, 32767))
/* 1697 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1698 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1699 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1700 */                   .addComponent(this.jRadioButton13)
/* 1701 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1702 */                   .addComponent(this.jRadioButton14))
/* 1703 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1704 */                   .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1705 */                     .addComponent(this.jButton22, -1, 108, 32767)
/* 1706 */                     .addComponent(this.jButton24, -1, 108, 32767))
/* 1707 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1708 */                   .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1709 */                     .addComponent(this.jButton23, -1, -1, 32767)
/* 1710 */                     .addComponent(this.jButton21, -1, 105, 32767)))
/* 1711 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1712 */                   .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1713 */                   .addComponent((Component)this.jDateChooser7, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 1714 */                 .addComponent(this.jScrollPane5, -1, 219, 32767)))
/* 1715 */             .addComponent(this.jLabel82, -1, 331, 32767))
/* 1716 */           .addContainerGap()));
/*      */     
/* 1718 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1720 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1721 */           .addContainerGap()
/* 1722 */           .addComponent(this.jLabel82)
/* 1723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1724 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1725 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1726 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1727 */             .addComponent(this.jRadioButton13)
/* 1728 */             .addComponent(this.jRadioButton14)
/* 1729 */             .addComponent(this.jLabel85))
/* 1730 */           .addGap(8, 8, 8)
/* 1731 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1732 */             .addComponent(this.jLabel83, -1, -1, 32767)
/* 1733 */             .addComponent((Component)this.jDateChooser4, -2, 20, 32767))
/* 1734 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1735 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1736 */             .addComponent((Component)this.jDateChooser7, -2, -1, -2)
/* 1737 */             .addComponent(this.jLabel84))
/* 1738 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1739 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1740 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1741 */               .addComponent(this.jScrollPane5, -2, 114, -2)
/* 1742 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1743 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1744 */                 .addComponent(this.jButton21)
/* 1745 */                 .addComponent(this.jButton22))
/* 1746 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1747 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1748 */                 .addComponent(this.jButton23)
/* 1749 */                 .addComponent(this.jButton24)))
/* 1750 */             .addComponent(this.jLabel86))
/* 1751 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 1754 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1755 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1756 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1757 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1758 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/* 1760 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1761 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1762 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/* 1765 */     this.jDialog6.setTitle("SEMARNAT");
/* 1766 */     this.jDialog6.setModal(true);
/* 1767 */     this.jDialog6.setResizable(false);
/* 1768 */     this.jDialog6.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1770 */             CajaAgregar.this.jDialog6WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1774 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/* 1776 */     this.jLabel87.setFont(new Font("Tahoma", 1, 14));
/* 1777 */     this.jLabel87.setForeground(new Color(0, 102, 102));
/* 1778 */     this.jLabel87.setHorizontalAlignment(0);
/* 1779 */     this.jLabel87.setText("Permiso de la SCT");
/*      */     
/* 1781 */     this.jLabel88.setFont(new Font("Tahoma", 3, 11));
/* 1782 */     this.jLabel88.setForeground(new Color(15, 87, 51));
/* 1783 */     this.jLabel88.setHorizontalAlignment(4);
/* 1784 */     this.jLabel88.setText("Fecha de Inicio");
/*      */     
/* 1786 */     this.jRadioButton15.setSelected(true);
/* 1787 */     this.jRadioButton15.setText("Alta");
/*      */     
/* 1789 */     this.jRadioButton16.setText("Actualización");
/*      */     
/* 1791 */     this.jDateChooser8.setDate(this.fechaActual);
/* 1792 */     this.jDateChooser8.setDateFormatString("yyyy/MM/dd");
/* 1793 */     this.jDateChooser8.setIcon(this.icon);
/* 1794 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/* 1795 */     this.jDateChooser8.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1797 */     this.jLabel89.setFont(new Font("Tahoma", 3, 11));
/* 1798 */     this.jLabel89.setForeground(new Color(15, 87, 51));
/* 1799 */     this.jLabel89.setHorizontalAlignment(4);
/* 1800 */     this.jLabel89.setText("Tipo");
/*      */     
/* 1802 */     this.jLabel90.setFont(new Font("Tahoma", 3, 11));
/* 1803 */     this.jLabel90.setForeground(new Color(15, 87, 51));
/* 1804 */     this.jLabel90.setHorizontalAlignment(4);
/* 1805 */     this.jLabel90.setText("Fecha de Vigencia");
/*      */     
/* 1807 */     this.jDateChooser9.setDate(this.fechaActual);
/* 1808 */     this.jDateChooser9.setDateFormatString("yyyy/MM/dd");
/* 1809 */     this.jDateChooser9.setIcon(this.icon);
/* 1810 */     this.jDateChooser9.setMaxSelectableDate(this.fecha);
/* 1811 */     this.jDateChooser9.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1813 */     this.jLabel91.setFont(new Font("Tahoma", 2, 11));
/* 1814 */     this.jLabel91.setForeground(new Color(15, 87, 51));
/* 1815 */     this.jLabel91.setHorizontalAlignment(4);
/* 1816 */     this.jLabel91.setText("Comentario");
/*      */     
/* 1818 */     this.jTextArea4.setColumns(20);
/* 1819 */     this.jTextArea4.setRows(5);
/* 1820 */     this.jScrollPane6.setViewportView(this.jTextArea4);
/*      */     
/* 1822 */     this.jButton25.setMnemonic('C');
/* 1823 */     this.jButton25.setText("Cerrar");
/* 1824 */     this.jButton25.setToolTipText("Cerrar (Alt+C)");
/* 1825 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1827 */             CajaAgregar.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1831 */     this.jButton26.setMnemonic('L');
/* 1832 */     this.jButton26.setText("Limpiar");
/* 1833 */     this.jButton26.setToolTipText("Limpiar (Alt+L)");
/* 1834 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1836 */             CajaAgregar.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1840 */     this.jButton27.setMnemonic('G');
/* 1841 */     this.jButton27.setText("Guardar");
/* 1842 */     this.jButton27.setToolTipText("Guardar (Alt+G)");
/* 1843 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1845 */             CajaAgregar.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1849 */     this.jButton28.setMnemonic('R');
/* 1850 */     this.jButton28.setText("Restablecer");
/* 1851 */     this.jButton28.setToolTipText("Restablecer (Alt+R)");
/* 1852 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1854 */             CajaAgregar.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1858 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1859 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1860 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1862 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1863 */           .addContainerGap()
/* 1864 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1865 */             .addComponent(this.jSeparator6, -1, 331, 32767)
/* 1866 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1867 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1868 */                 .addComponent(this.jLabel89, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 1869 */                 .addComponent(this.jLabel88, -1, 108, 32767)
/* 1870 */                 .addComponent(this.jLabel90, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 1871 */                 .addComponent(this.jLabel91, -1, 108, 32767))
/* 1872 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1873 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1874 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 1875 */                   .addComponent(this.jRadioButton15)
/* 1876 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1877 */                   .addComponent(this.jRadioButton16))
/* 1878 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 1879 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1880 */                     .addComponent(this.jButton26, -1, 108, 32767)
/* 1881 */                     .addComponent(this.jButton28, -1, 108, 32767))
/* 1882 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1883 */                   .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1884 */                     .addComponent(this.jButton27, -1, -1, 32767)
/* 1885 */                     .addComponent(this.jButton25, -1, 105, 32767)))
/* 1886 */                 .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1887 */                   .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1888 */                   .addComponent((Component)this.jDateChooser9, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 1889 */                 .addComponent(this.jScrollPane6, -1, 219, 32767)))
/* 1890 */             .addComponent(this.jLabel87, -1, 331, 32767))
/* 1891 */           .addContainerGap()));
/*      */     
/* 1893 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1895 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1896 */           .addContainerGap()
/* 1897 */           .addComponent(this.jLabel87)
/* 1898 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1899 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1900 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1901 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1902 */             .addComponent(this.jRadioButton15)
/* 1903 */             .addComponent(this.jRadioButton16)
/* 1904 */             .addComponent(this.jLabel89))
/* 1905 */           .addGap(8, 8, 8)
/* 1906 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1907 */             .addComponent(this.jLabel88, -1, -1, 32767)
/* 1908 */             .addComponent((Component)this.jDateChooser8, -2, 20, 32767))
/* 1909 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1910 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1911 */             .addComponent((Component)this.jDateChooser9, -2, -1, -2)
/* 1912 */             .addComponent(this.jLabel90))
/* 1913 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1914 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1915 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1916 */               .addComponent(this.jScrollPane6, -2, 114, -2)
/* 1917 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1918 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1919 */                 .addComponent(this.jButton25)
/* 1920 */                 .addComponent(this.jButton26))
/* 1921 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1922 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1923 */                 .addComponent(this.jButton27)
/* 1924 */                 .addComponent(this.jButton28)))
/* 1925 */             .addComponent(this.jLabel91))
/* 1926 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 1929 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1930 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1931 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1932 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1933 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 1935 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1936 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1937 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 1940 */     this.jDialog7.setTitle("SEMARNAT");
/* 1941 */     this.jDialog7.setModal(true);
/* 1942 */     this.jDialog7.setResizable(false);
/* 1943 */     this.jDialog7.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/* 1945 */             CajaAgregar.this.jDialog7WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/* 1949 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/* 1951 */     this.jLabel93.setFont(new Font("Tahoma", 1, 14));
/* 1952 */     this.jLabel93.setForeground(new Color(0, 102, 102));
/* 1953 */     this.jLabel93.setHorizontalAlignment(0);
/* 1954 */     this.jLabel93.setText("Permiso de Sedere");
/*      */     
/* 1956 */     this.jLabel94.setFont(new Font("Tahoma", 3, 11));
/* 1957 */     this.jLabel94.setForeground(new Color(15, 87, 51));
/* 1958 */     this.jLabel94.setHorizontalAlignment(4);
/* 1959 */     this.jLabel94.setText("Fecha de Inicio");
/*      */     
/* 1961 */     this.jRadioButton20.setSelected(true);
/* 1962 */     this.jRadioButton20.setText("Alta");
/*      */     
/* 1964 */     this.jRadioButton21.setText("Actualización");
/*      */     
/* 1966 */     this.jDateChooser10.setDate(this.fechaActual);
/* 1967 */     this.jDateChooser10.setDateFormatString("yyyy/MM/dd");
/* 1968 */     this.jDateChooser10.setIcon(this.icon);
/* 1969 */     this.jDateChooser10.setMaxSelectableDate(this.fecha);
/* 1970 */     this.jDateChooser10.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1972 */     this.jLabel95.setFont(new Font("Tahoma", 3, 11));
/* 1973 */     this.jLabel95.setForeground(new Color(15, 87, 51));
/* 1974 */     this.jLabel95.setHorizontalAlignment(4);
/* 1975 */     this.jLabel95.setText("Tipo");
/*      */     
/* 1977 */     this.jLabel96.setFont(new Font("Tahoma", 3, 11));
/* 1978 */     this.jLabel96.setForeground(new Color(15, 87, 51));
/* 1979 */     this.jLabel96.setHorizontalAlignment(4);
/* 1980 */     this.jLabel96.setText("Fecha de Vigencia");
/*      */     
/* 1982 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1983 */     this.jDateChooser11.setDateFormatString("yyyy/MM/dd");
/* 1984 */     this.jDateChooser11.setIcon(this.icon);
/* 1985 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 1986 */     this.jDateChooser11.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1988 */     this.jLabel97.setFont(new Font("Tahoma", 2, 11));
/* 1989 */     this.jLabel97.setForeground(new Color(15, 87, 51));
/* 1990 */     this.jLabel97.setHorizontalAlignment(4);
/* 1991 */     this.jLabel97.setText("Comentario");
/*      */     
/* 1993 */     this.jTextArea5.setColumns(20);
/* 1994 */     this.jTextArea5.setRows(5);
/* 1995 */     this.jScrollPane7.setViewportView(this.jTextArea5);
/*      */     
/* 1997 */     this.jButton29.setMnemonic('C');
/* 1998 */     this.jButton29.setText("Cerrar");
/* 1999 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 2000 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2002 */             CajaAgregar.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2006 */     this.jButton30.setMnemonic('L');
/* 2007 */     this.jButton30.setText("Limpiar");
/* 2008 */     this.jButton30.setToolTipText("Limpiar (Alt+L)");
/* 2009 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2011 */             CajaAgregar.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2015 */     this.jButton31.setMnemonic('G');
/* 2016 */     this.jButton31.setText("Guardar");
/* 2017 */     this.jButton31.setToolTipText("Guardar (Alt+G)");
/* 2018 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2020 */             CajaAgregar.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2024 */     this.jButton32.setMnemonic('R');
/* 2025 */     this.jButton32.setText("Restablecer");
/* 2026 */     this.jButton32.setToolTipText("Restablecer (Alt+R)");
/* 2027 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2029 */             CajaAgregar.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2033 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 2034 */     this.jPanel8.setLayout(jPanel8Layout);
/* 2035 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 2036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2037 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 2038 */           .addContainerGap()
/* 2039 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2040 */             .addComponent(this.jSeparator7, -1, 331, 32767)
/* 2041 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 2042 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2043 */                 .addComponent(this.jLabel95, GroupLayout.Alignment.TRAILING, -2, 79, -2)
/* 2044 */                 .addComponent(this.jLabel94, -1, 108, 32767)
/* 2045 */                 .addComponent(this.jLabel96, GroupLayout.Alignment.TRAILING, -2, 108, -2)
/* 2046 */                 .addComponent(this.jLabel97, -1, 108, 32767))
/* 2047 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2048 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2049 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 2050 */                   .addComponent(this.jRadioButton20)
/* 2051 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2052 */                   .addComponent(this.jRadioButton21))
/* 2053 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 2054 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2055 */                     .addComponent(this.jButton30, -1, 108, 32767)
/* 2056 */                     .addComponent(this.jButton32, -1, 108, 32767))
/* 2057 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2058 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2059 */                     .addComponent(this.jButton31, -1, -1, 32767)
/* 2060 */                     .addComponent(this.jButton29, -1, 105, 32767)))
/* 2061 */                 .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2062 */                   .addComponent((Component)this.jDateChooser10, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2063 */                   .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.LEADING, -1, 134, 32767))
/* 2064 */                 .addComponent(this.jScrollPane7, -1, 219, 32767)))
/* 2065 */             .addComponent(this.jLabel93, -1, 331, 32767))
/* 2066 */           .addContainerGap()));
/*      */     
/* 2068 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 2069 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2070 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 2071 */           .addContainerGap()
/* 2072 */           .addComponent(this.jLabel93)
/* 2073 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2074 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 2075 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2076 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2077 */             .addComponent(this.jRadioButton20)
/* 2078 */             .addComponent(this.jRadioButton21)
/* 2079 */             .addComponent(this.jLabel95))
/* 2080 */           .addGap(8, 8, 8)
/* 2081 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2082 */             .addComponent(this.jLabel94, -1, -1, 32767)
/* 2083 */             .addComponent((Component)this.jDateChooser10, -2, 20, 32767))
/* 2084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2085 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2086 */             .addComponent((Component)this.jDateChooser11, -2, -1, -2)
/* 2087 */             .addComponent(this.jLabel96))
/* 2088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2089 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2090 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 2091 */               .addComponent(this.jScrollPane7, -2, 114, -2)
/* 2092 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2093 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2094 */                 .addComponent(this.jButton29)
/* 2095 */                 .addComponent(this.jButton30))
/* 2096 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2097 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2098 */                 .addComponent(this.jButton31)
/* 2099 */                 .addComponent(this.jButton32)))
/* 2100 */             .addComponent(this.jLabel97))
/* 2101 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 2104 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2105 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2106 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2107 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2108 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/* 2110 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2111 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2112 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/* 2115 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/* 2116 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2118 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/* 2119 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/* 2120 */     this.jLabel1.setHorizontalAlignment(0);
/* 2121 */     this.jLabel1.setText("     Agregar Remolques");
/*      */     
/* 2123 */     this.jButton1.setMnemonic('G');
/* 2124 */     this.jButton1.setText("Guardar");
/* 2125 */     this.jButton1.setToolTipText("Guardar (Alt+G)");
/* 2126 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2128 */             CajaAgregar.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2132 */     this.jButton2.setMnemonic('L');
/* 2133 */     this.jButton2.setText("Limpiar");
/* 2134 */     this.jButton2.setToolTipText("Limpiar (Alt+L)");
/* 2135 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2137 */             CajaAgregar.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2141 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 2142 */     this.jLabel14.setToolTipText("Cerrar");
/* 2143 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2145 */             CajaAgregar.this.jLabel14MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2148 */             CajaAgregar.this.jLabel14MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2151 */             CajaAgregar.this.jLabel14MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 2155 */     this.jButton3.setMnemonic('R');
/* 2156 */     this.jButton3.setText("Restablecer");
/* 2157 */     this.jButton3.setToolTipText("Restablecer ( Alt+R )");
/* 2158 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2160 */             CajaAgregar.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2164 */     this.jButton4.setMnemonic('C');
/* 2165 */     this.jButton4.setText("Cerrar");
/* 2166 */     this.jButton4.setToolTipText("Cerrar (Alt+C)");
/* 2167 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2169 */             CajaAgregar.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2173 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2174 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Datos del Modelo ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2176 */     this.jLabel12.setFont(new Font("Tahoma", 3, 11));
/* 2177 */     this.jLabel12.setForeground(new Color(15, 87, 51));
/* 2178 */     this.jLabel12.setHorizontalAlignment(2);
/* 2179 */     this.jLabel12.setText("Marca");
/*      */     
/* 2181 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2182 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno..." }));
/*      */     
/* 2184 */     this.jButton5.setText("...");
/* 2185 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2187 */             CajaAgregar.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2191 */     this.jLabel16.setFont(new Font("Tahoma", 3, 11));
/* 2192 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 2193 */     this.jLabel16.setHorizontalAlignment(2);
/* 2194 */     this.jLabel16.setText("Modelo");
/*      */     
/* 2196 */     this.jLabel17.setFont(new Font("Tahoma", 3, 11));
/* 2197 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 2198 */     this.jLabel17.setHorizontalAlignment(2);
/* 2199 */     this.jLabel17.setText("Núm. de Serie");
/*      */     
/* 2201 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*      */     
/* 2203 */     this.jLabel28.setFont(new Font("Tahoma", 3, 11));
/* 2204 */     this.jLabel28.setForeground(new Color(15, 87, 51));
/* 2205 */     this.jLabel28.setHorizontalAlignment(2);
/* 2206 */     this.jLabel28.setText("Placas");
/*      */     
/* 2208 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2209 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2210 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2211 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2212 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2213 */           .addContainerGap()
/* 2214 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2215 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2216 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2217 */                 .addComponent(this.jLabel17, -1, -1, 32767)
/* 2218 */                 .addGap(15, 15, 15))
/* 2219 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2220 */                 .addComponent(this.jLabel16, -1, -1, 32767)
/* 2221 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 2222 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 2223 */                 .addComponent(this.jLabel12, -1, -1, 32767)
/* 2224 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 2225 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2226 */               .addComponent(this.jLabel28, -2, 48, -2)
/* 2227 */               .addGap(44, 44, 44)))
/* 2228 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2229 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
/* 2230 */               .addComponent(this.jComboBox2, -2, 181, -2)
/* 2231 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2232 */               .addComponent(this.jButton5)
/* 2233 */               .addGap(511, 511, 511))
/* 2234 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2235 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2236 */                 .addComponent(this.jTextField4)
/* 2237 */                 .addComponent(this.jTextField7, GroupLayout.Alignment.LEADING)
/* 2238 */                 .addComponent(this.jComboBox7, GroupLayout.Alignment.LEADING, 0, -1, 32767))
/* 2239 */               .addGap(562, 562, 562)))
/* 2240 */           .addGap(55, 55, 55)));
/*      */     
/* 2242 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2243 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2244 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2245 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2246 */             .addComponent(this.jComboBox2, -2, -1, -2)
/* 2247 */             .addComponent(this.jButton5)
/* 2248 */             .addComponent(this.jLabel12))
/* 2249 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2250 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2251 */             .addComponent(this.jLabel16)
/* 2252 */             .addComponent(this.jComboBox7, -2, -1, -2))
/* 2253 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2254 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2255 */             .addComponent(this.jLabel17)
/* 2256 */             .addComponent(this.jTextField4, -2, -1, -2))
/* 2257 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2258 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2259 */             .addComponent(this.jLabel28)
/* 2260 */             .addComponent(this.jTextField7, -2, -1, -2))
/* 2261 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2264 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/* 2265 */     this.jPanel20.setBorder(BorderFactory.createTitledBorder(null, "Registro del Remolque ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2267 */     this.jLabel13.setFont(new Font("Tahoma", 3, 11));
/* 2268 */     this.jLabel13.setForeground(new Color(15, 87, 51));
/* 2269 */     this.jLabel13.setHorizontalAlignment(4);
/* 2270 */     this.jLabel13.setText("Núm. de Caja");
/*      */     
/* 2272 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 2273 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 2274 */     this.jLabel15.setHorizontalAlignment(4);
/* 2275 */     this.jLabel15.setText("Color");
/*      */     
/* 2277 */     this.jLabel20.setFont(new Font("Tahoma", 3, 11));
/* 2278 */     this.jLabel20.setForeground(new Color(15, 87, 51));
/* 2279 */     this.jLabel20.setHorizontalAlignment(4);
/* 2280 */     this.jLabel20.setText("Tipo");
/*      */     
/* 2282 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2283 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "GÓNDOLA", "PIPA" }));
/*      */     
/* 2285 */     this.jLabel55.setFont(new Font("Tahoma", 3, 11));
/* 2286 */     this.jLabel55.setForeground(new Color(15, 87, 51));
/* 2287 */     this.jLabel55.setHorizontalAlignment(4);
/* 2288 */     this.jLabel55.setText("Estado");
/*      */     
/* 2290 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 2291 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 2292 */     this.jComboBox5.setEnabled(false);
/*      */     
/* 2294 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2295 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2296 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2297 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2298 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2299 */           .addContainerGap()
/* 2300 */           .addComponent(this.jLabel13)
/* 2301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2302 */           .addComponent(this.jTextField1, -2, 65, -2)
/* 2303 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2304 */           .addComponent(this.jLabel15, -2, 50, -2)
/* 2305 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2306 */           .addComponent(this.jTextField2, -2, 103, -2)
/* 2307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2308 */           .addComponent(this.jLabel20, -2, 60, -2)
/* 2309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2310 */           .addComponent(this.jComboBox1, -2, 178, -2)
/* 2311 */           .addGap(55, 55, 55)
/* 2312 */           .addComponent(this.jLabel55, -2, 60, -2)
/* 2313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2314 */           .addComponent(this.jComboBox5, -2, 95, -2)
/* 2315 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2317 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2318 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2319 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2320 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2321 */             .addComponent(this.jLabel13)
/* 2322 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 2323 */             .addComponent(this.jLabel15)
/* 2324 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 2325 */             .addComponent(this.jLabel20)
/* 2326 */             .addComponent(this.jComboBox1, -2, -1, -2)
/* 2327 */             .addComponent(this.jLabel55)
/* 2328 */             .addComponent(this.jComboBox5, -2, -1, -2))
/* 2329 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2332 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/* 2333 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " Datos de Facturación ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2335 */     this.jLabel18.setFont(new Font("Tahoma", 3, 11));
/* 2336 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/* 2337 */     this.jLabel18.setHorizontalAlignment(2);
/* 2338 */     this.jLabel18.setText("F. Aquisición");
/*      */     
/* 2340 */     this.jDateChooser1.setDate(this.fechaActual);
/* 2341 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/* 2342 */     this.jDateChooser1.setIcon(this.icon);
/* 2343 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/* 2344 */     this.jDateChooser1.setMinSelectableDate(this.fechaActual);
/*      */     
/* 2346 */     this.jLabel22.setFont(new Font("Tahoma", 2, 11));
/* 2347 */     this.jLabel22.setForeground(new Color(15, 87, 51));
/* 2348 */     this.jLabel22.setHorizontalAlignment(2);
/* 2349 */     this.jLabel22.setText("Núm. de Factura");
/*      */     
/* 2351 */     this.jLabel23.setFont(new Font("Tahoma", 2, 11));
/* 2352 */     this.jLabel23.setForeground(new Color(15, 87, 51));
/* 2353 */     this.jLabel23.setHorizontalAlignment(2);
/* 2354 */     this.jLabel23.setText("Forma de Pago");
/*      */     
/* 2356 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2357 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Efectivo", "Tarjeta de Crédito", "Otro" }));
/*      */     
/* 2359 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 2360 */     this.jPanel21.setLayout(jPanel21Layout);
/* 2361 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 2362 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2363 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 2364 */           .addContainerGap()
/* 2365 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2366 */             .addComponent(this.jLabel18)
/* 2367 */             .addComponent(this.jLabel23, -1, 91, 32767)
/* 2368 */             .addComponent(this.jLabel22, -2, 91, 32767))
/* 2369 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2370 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2371 */             .addComponent((Component)this.jDateChooser1, -1, 183, 32767)
/* 2372 */             .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2373 */               .addComponent(this.jTextField6)
/* 2374 */               .addComponent(this.jComboBox3, 0, 183, 32767)))
/* 2375 */           .addContainerGap(56, 32767)));
/*      */     
/* 2377 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 2378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2379 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 2380 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2381 */             .addComponent(this.jLabel18, -1, -1, 32767)
/* 2382 */             .addComponent((Component)this.jDateChooser1, -1, -1, 32767))
/* 2383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2384 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2385 */             .addComponent(this.jLabel22)
/* 2386 */             .addComponent(this.jTextField6, -2, -1, -2))
/* 2387 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2388 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2389 */             .addComponent(this.jLabel23)
/* 2390 */             .addComponent(this.jComboBox3, -2, -1, -2))
/* 2391 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2394 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 2395 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, " Especificaciones del Vehículo ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2397 */     this.jLabel24.setFont(new Font("Tahoma", 2, 11));
/* 2398 */     this.jLabel24.setForeground(new Color(15, 87, 51));
/* 2399 */     this.jLabel24.setHorizontalAlignment(2);
/* 2400 */     this.jLabel24.setText("Kilometraje Actual");
/*      */     
/* 2402 */     this.jLabel25.setFont(new Font("Tahoma", 2, 11));
/* 2403 */     this.jLabel25.setForeground(new Color(15, 87, 51));
/* 2404 */     this.jLabel25.setHorizontalAlignment(2);
/* 2405 */     this.jLabel25.setText("Peso Vehicular");
/*      */     
/* 2407 */     this.jLabel26.setFont(new Font("Tahoma", 2, 11));
/* 2408 */     this.jLabel26.setForeground(new Color(15, 87, 51));
/* 2409 */     this.jLabel26.setHorizontalAlignment(2);
/* 2410 */     this.jLabel26.setText("Dimensiones");
/*      */     
/* 2412 */     this.jLabel57.setFont(new Font("Tahoma", 2, 11));
/* 2413 */     this.jLabel57.setForeground(new Color(15, 87, 51));
/* 2414 */     this.jLabel57.setHorizontalAlignment(2);
/* 2415 */     this.jLabel57.setText("Toneladas");
/*      */     
/* 2417 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 2418 */     this.jPanel22.setLayout(jPanel22Layout);
/* 2419 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 2420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2421 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2422 */           .addContainerGap()
/* 2423 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2424 */             .addComponent(this.jLabel26, -1, -1, 32767)
/* 2425 */             .addComponent(this.jLabel25, -1, -1, 32767)
/* 2426 */             .addComponent(this.jLabel24, -1, 125, 32767))
/* 2427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2428 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2429 */             .addComponent(this.jTextField11)
/* 2430 */             .addGroup(jPanel22Layout.createSequentialGroup()
/* 2431 */               .addComponent(this.jTextField10, -2, 80, -2)
/* 2432 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2433 */               .addComponent(this.jLabel57, -1, -1, 32767))
/* 2434 */             .addComponent(this.jTextField9, -1, 213, 32767))
/* 2435 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2437 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 2438 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2439 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2440 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2441 */             .addComponent(this.jLabel24)
/* 2442 */             .addComponent(this.jTextField9, -2, -1, -2))
/* 2443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2444 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2445 */             .addComponent(this.jLabel25)
/* 2446 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 2447 */             .addComponent(this.jLabel57))
/* 2448 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2449 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2450 */             .addComponent(this.jLabel26)
/* 2451 */             .addComponent(this.jTextField11, -2, -1, -2))
/* 2452 */           .addContainerGap(20, 32767)));
/*      */ 
/*      */     
/* 2455 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/* 2456 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, " Permisos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2458 */     this.jLabel27.setFont(new Font("Tahoma", 2, 11));
/* 2459 */     this.jLabel27.setForeground(new Color(15, 87, 51));
/* 2460 */     this.jLabel27.setHorizontalAlignment(2);
/* 2461 */     this.jLabel27.setText("Semarnat");
/* 2462 */     this.jLabel27.setEnabled(false);
/*      */     
/* 2464 */     this.jRadioButton1.setSelected(true);
/* 2465 */     this.jRadioButton1.setText("No");
/* 2466 */     this.jRadioButton1.setEnabled(false);
/* 2467 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2469 */             CajaAgregar.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2473 */     this.jRadioButton2.setText("Si");
/* 2474 */     this.jRadioButton2.setEnabled(false);
/* 2475 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2477 */             CajaAgregar.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2481 */     this.jRadioButton3.setText("Baja");
/* 2482 */     this.jRadioButton3.setEnabled(false);
/*      */     
/* 2484 */     this.jLabel54.setFont(new Font("Tahoma", 2, 11));
/* 2485 */     this.jLabel54.setForeground(new Color(15, 87, 51));
/* 2486 */     this.jLabel54.setHorizontalAlignment(2);
/* 2487 */     this.jLabel54.setText("SCT");
/* 2488 */     this.jLabel54.setEnabled(false);
/*      */     
/* 2490 */     this.jRadioButton7.setSelected(true);
/* 2491 */     this.jRadioButton7.setText("No");
/* 2492 */     this.jRadioButton7.setEnabled(false);
/* 2493 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2495 */             CajaAgregar.this.jRadioButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2499 */     this.jRadioButton8.setText("Si");
/* 2500 */     this.jRadioButton8.setEnabled(false);
/* 2501 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2503 */             CajaAgregar.this.jRadioButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2507 */     this.jRadioButton9.setText("Baja");
/* 2508 */     this.jRadioButton9.setEnabled(false);
/*      */     
/* 2510 */     this.jTextField30.setEditable(false);
/*      */     
/* 2512 */     this.jTextField31.setEditable(false);
/*      */     
/* 2514 */     this.jLabel92.setFont(new Font("Tahoma", 2, 11));
/* 2515 */     this.jLabel92.setForeground(new Color(15, 87, 51));
/* 2516 */     this.jLabel92.setHorizontalAlignment(2);
/* 2517 */     this.jLabel92.setText("Sedere");
/* 2518 */     this.jLabel92.setEnabled(false);
/*      */     
/* 2520 */     this.jRadioButton17.setSelected(true);
/* 2521 */     this.jRadioButton17.setText("No");
/* 2522 */     this.jRadioButton17.setEnabled(false);
/* 2523 */     this.jRadioButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2525 */             CajaAgregar.this.jRadioButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2529 */     this.jTextField50.setEditable(false);
/*      */     
/* 2531 */     this.jRadioButton18.setText("Si");
/* 2532 */     this.jRadioButton18.setEnabled(false);
/* 2533 */     this.jRadioButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2535 */             CajaAgregar.this.jRadioButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2539 */     this.jRadioButton19.setText("Baja");
/* 2540 */     this.jRadioButton19.setEnabled(false);
/*      */     
/* 2542 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 2543 */     this.jPanel23.setLayout(jPanel23Layout);
/* 2544 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 2545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2546 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2547 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2548 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2549 */               .addContainerGap()
/* 2550 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2551 */                 .addComponent(this.jLabel54, -2, 57, -2)
/* 2552 */                 .addComponent(this.jLabel27, -2, 74, -2))
/* 2553 */               .addGap(4, 4, 4)
/* 2554 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2555 */                 .addComponent(this.jTextField30)
/* 2556 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2557 */                   .addComponent(this.jRadioButton7)
/* 2558 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2559 */                   .addComponent(this.jRadioButton8)
/* 2560 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2561 */                   .addComponent(this.jRadioButton9))
/* 2562 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2563 */                   .addComponent(this.jRadioButton1)
/* 2564 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2565 */                   .addComponent(this.jRadioButton2)
/* 2566 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2567 */                   .addComponent(this.jRadioButton3))))
/* 2568 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 2569 */               .addGap(88, 88, 88)
/* 2570 */               .addComponent(this.jTextField31))
/* 2571 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2572 */               .addContainerGap()
/* 2573 */               .addComponent(this.jLabel92, -2, 57, -2)
/* 2574 */               .addGap(21, 21, 21)
/* 2575 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2576 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 2577 */                   .addComponent(this.jRadioButton17)
/* 2578 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2579 */                   .addComponent(this.jRadioButton18)
/* 2580 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2581 */                   .addComponent(this.jRadioButton19))
/* 2582 */                 .addComponent(this.jTextField50, GroupLayout.Alignment.TRAILING))))
/* 2583 */           .addContainerGap()));
/*      */     
/* 2585 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 2586 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2587 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2588 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2589 */             .addComponent(this.jRadioButton1)
/* 2590 */             .addComponent(this.jRadioButton2)
/* 2591 */             .addComponent(this.jRadioButton3, -2, 23, -2)
/* 2592 */             .addComponent(this.jLabel27))
/* 2593 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2594 */           .addComponent(this.jTextField30, -2, -1, -2)
/* 2595 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2596 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2597 */             .addComponent(this.jLabel54)
/* 2598 */             .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2599 */               .addComponent(this.jRadioButton7)
/* 2600 */               .addComponent(this.jRadioButton8)
/* 2601 */               .addComponent(this.jRadioButton9)))
/* 2602 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2603 */           .addComponent(this.jTextField31, -2, -1, -2)
/* 2604 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2605 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2606 */             .addComponent(this.jLabel92)
/* 2607 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2608 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2609 */                 .addComponent(this.jRadioButton17)
/* 2610 */                 .addComponent(this.jRadioButton18)
/* 2611 */                 .addComponent(this.jRadioButton19))
/* 2612 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2613 */               .addComponent(this.jTextField50, -2, -1, -2)))));
/*      */ 
/*      */     
/* 2616 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/* 2617 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder(null, " Pólizas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2619 */     this.jLabel30.setFont(new Font("Tahoma", 2, 11));
/* 2620 */     this.jLabel30.setForeground(new Color(15, 87, 51));
/* 2621 */     this.jLabel30.setHorizontalAlignment(2);
/* 2622 */     this.jLabel30.setText("Vehicular");
/* 2623 */     this.jLabel30.setEnabled(false);
/*      */     
/* 2625 */     this.jRadioButton4.setSelected(true);
/* 2626 */     this.jRadioButton4.setText("No");
/* 2627 */     this.jRadioButton4.setEnabled(false);
/* 2628 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2630 */             CajaAgregar.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2634 */     this.jRadioButton5.setText("Si");
/* 2635 */     this.jRadioButton5.setEnabled(false);
/* 2636 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2638 */             CajaAgregar.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2642 */     this.jRadioButton6.setText("Baja");
/* 2643 */     this.jRadioButton6.setEnabled(false);
/*      */     
/* 2645 */     this.jLabel56.setFont(new Font("Tahoma", 2, 11));
/* 2646 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 2647 */     this.jLabel56.setHorizontalAlignment(2);
/* 2648 */     this.jLabel56.setText("Ecológico");
/* 2649 */     this.jLabel56.setEnabled(false);
/*      */     
/* 2651 */     this.jRadioButton10.setSelected(true);
/* 2652 */     this.jRadioButton10.setText("No");
/* 2653 */     this.jRadioButton10.setEnabled(false);
/* 2654 */     this.jRadioButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2656 */             CajaAgregar.this.jRadioButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2660 */     this.jRadioButton11.setText("Si");
/* 2661 */     this.jRadioButton11.setEnabled(false);
/* 2662 */     this.jRadioButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2664 */             CajaAgregar.this.jRadioButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2668 */     this.jRadioButton12.setText("Baja");
/* 2669 */     this.jRadioButton12.setEnabled(false);
/*      */     
/* 2671 */     this.jTextField32.setEditable(false);
/*      */     
/* 2673 */     this.jTextField33.setEditable(false);
/*      */     
/* 2675 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2676 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2677 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2678 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2679 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2680 */           .addContainerGap()
/* 2681 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2682 */             .addComponent(this.jLabel56, -2, 57, -2)
/* 2683 */             .addComponent(this.jLabel30, -2, 74, -2))
/* 2684 */           .addGap(4, 4, 4)
/* 2685 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2686 */             .addComponent(this.jTextField33, GroupLayout.Alignment.TRAILING)
/* 2687 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2688 */               .addComponent(this.jRadioButton4)
/* 2689 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2690 */               .addComponent(this.jRadioButton5)
/* 2691 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2692 */               .addComponent(this.jRadioButton6))
/* 2693 */             .addComponent(this.jTextField32, GroupLayout.Alignment.TRAILING)
/* 2694 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2695 */               .addComponent(this.jRadioButton10)
/* 2696 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2697 */               .addComponent(this.jRadioButton11)
/* 2698 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2699 */               .addComponent(this.jRadioButton12)))
/* 2700 */           .addGap(20, 20, 20)));
/*      */     
/* 2702 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2704 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2705 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2706 */             .addComponent(this.jRadioButton4)
/* 2707 */             .addComponent(this.jRadioButton5)
/* 2708 */             .addComponent(this.jRadioButton6, -2, 23, -2)
/* 2709 */             .addComponent(this.jLabel30))
/* 2710 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2711 */           .addComponent(this.jTextField32, -2, -1, -2)
/* 2712 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2713 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2714 */             .addComponent(this.jLabel56)
/* 2715 */             .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2716 */               .addComponent(this.jRadioButton10)
/* 2717 */               .addComponent(this.jRadioButton11)
/* 2718 */               .addComponent(this.jRadioButton12)))
/* 2719 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2720 */           .addComponent(this.jTextField33, -2, -1, -2)
/* 2721 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2724 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2725 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2726 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2727 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2728 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2729 */           .addContainerGap()
/* 2730 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2731 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2732 */               .addComponent(this.jLabel1, -1, -1, 32767)
/* 2733 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2734 */               .addComponent(this.jLabel14))
/* 2735 */             .addComponent(this.jPanel20, -1, -1, 32767)
/* 2736 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2737 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2738 */                 .addComponent(this.jPanel21, -2, -1, -2)
/* 2739 */                 .addComponent(this.jPanel17, -2, 360, -2))
/* 2740 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2741 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2742 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2743 */                   .addComponent(this.jPanel22, -1, -1, 32767)
/* 2744 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2745 */                   .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2746 */                     .addComponent(this.jButton4, -1, -1, 32767)
/* 2747 */                     .addComponent(this.jButton3, -1, -1, 32767)
/* 2748 */                     .addComponent(this.jButton1, -1, -1, 32767)
/* 2749 */                     .addComponent(this.jButton2, -1, 94, 32767)))
/* 2750 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 2751 */                   .addComponent(this.jPanel23, -2, -1, -2)
/* 2752 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2753 */                   .addComponent(this.jPanel30, -2, -1, -2)))))
/* 2754 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2756 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2757 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2758 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2759 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2760 */             .addComponent(this.jLabel14)
/* 2761 */             .addComponent(this.jLabel1))
/* 2762 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2763 */           .addComponent(this.jPanel20, -2, -1, -2)
/* 2764 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2765 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2766 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2767 */               .addComponent(this.jPanel17, -2, -1, -2)
/* 2768 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2769 */               .addComponent(this.jPanel21, -1, -1, 32767))
/* 2770 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2771 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2772 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 2773 */                   .addComponent(this.jButton2)
/* 2774 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2775 */                   .addComponent(this.jButton1)
/* 2776 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2777 */                   .addComponent(this.jButton3)
/* 2778 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2779 */                   .addComponent(this.jButton4))
/* 2780 */                 .addComponent(this.jPanel22, -2, -1, -2))
/* 2781 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2782 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2783 */                 .addComponent(this.jPanel23, -1, -1, 32767)
/* 2784 */                 .addComponent(this.jPanel30, -1, -1, 32767))))));
/*      */ 
/*      */     
/* 2787 */     GroupLayout layout = new GroupLayout(this);
/* 2788 */     setLayout(layout);
/* 2789 */     layout.setHorizontalGroup(layout
/* 2790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2791 */         .addGap(0, 0, 32767)
/* 2792 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2793 */           .addGroup(layout.createSequentialGroup()
/* 2794 */             .addGap(0, 0, 32767)
/* 2795 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 2796 */             .addGap(0, 0, 32767))));
/*      */     
/* 2798 */     layout.setVerticalGroup(layout
/* 2799 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2800 */         .addGap(0, 473, 32767)
/* 2801 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2802 */           .addGroup(layout.createSequentialGroup()
/* 2803 */             .addGap(0, 0, 32767)
/* 2804 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 2805 */             .addGap(0, 0, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField12ActionPerformed(ActionEvent evt) {
/* 2810 */     guardarMarcas();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2814 */     guardarMarcas();
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2818 */     String ind = "";
/* 2819 */     int contar = 0;
/* 2820 */     int contador = 0;
/* 2821 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2822 */       String val = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2823 */       if (val.equals("true")) {
/* 2824 */         contar++;
/*      */       }
/*      */     } 
/* 2827 */     if (contar == 0) {
/* 2828 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar marcas", "Selecciona Una Marca", 0, this.INFO);
/*      */     }
/* 2830 */     else if (contar == 1) {
/* 2831 */       int doc = 0;
/* 2832 */       for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2833 */         String val = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 2834 */         if (val.equals("true")) {
/* 2835 */           String str = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 2836 */           doc = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 2840 */       String valor = "<html><b>Clave de la Marca: </b>" + String.valueOf(this.jTable1.getValueAt(doc, 1)) + "<br><b>Marca: </b>" + String.valueOf(this.jTable1.getValueAt(doc, 2)) + "<br></html>";
/* 2841 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Marca", 0, 3, this.ELIMINAR);
/* 2842 */       if (res == 0) {
/* 2843 */         String val = String.valueOf(this.jTable1.getValueAt(doc, 1));
/* 2844 */         String[] reg = this.con.regresaReg("id_marca,marca", "marca", "where id_marca = " + val, 2);
/* 2845 */         this.con.eliminar("marca", "where id_marca=" + val);
/* 2846 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó la marca de carro " + val + " definitivamente.','Clave de la Marca: " + val + "\nMarca: " + reg[1] + "')");
/* 2847 */         consultar1();
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 2852 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Marcas", 0, 3, this.ELIMINAR);
/* 2853 */       if (res == 0) {
/* 2854 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2855 */           String val = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 2856 */           if (val.equals("true")) {
/* 2857 */             String valor = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 2858 */             String[] reg = this.con.regresaReg("id_marca,marca", "marca", "where id_marca = " + valor, 2);
/* 2859 */             contador++;
/* 2860 */             this.con.eliminar2("marca", "where id_marca=" + valor);
/* 2861 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó la marca de carro " + valor + " definitivamente.','Clave de la Marca: " + valor + "\nMarca: " + reg[1] + "')");
/*      */           } 
/*      */         } 
/* 2864 */         consultar1();
/* 2865 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + contador + " marcas.", "Marcas Eliminadas", 0, this.INFO);
/*      */       } 
/*      */     } 
/* 2868 */     llenarCombo2();
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2872 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2876 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 2877 */       this.datos.escribir();
/*      */     }
/* 2879 */     else if (this.jTextField9.getText().equals("") && this.jTextField2.getText().equals("") && this.jComboBox7.getSelectedIndex() == 0 && this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField10.getText().equals("") && this.jTextField1.getText().equals("")) {
/* 2880 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 2885 */     int cont = 0;
/* 2886 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 2887 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 2888 */       this.jFormattedTextField1.setValue("");
/*      */     }
/* 2890 */     else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 2891 */       String cadena = this.jFormattedTextField1.getText();
/* 2892 */       String cad1 = cadena.substring(0, 3);
/* 2893 */       String cad2 = cadena.substring(4, 7);
/* 2894 */       String cad3 = cadena.substring(8, 12);
/* 2895 */       String tel = cad1 + cad1 + cad2;
/* 2896 */       for (int i = 1; i < tel.length(); i++) {
/* 2897 */         char c = tel.charAt(i - 1);
/* 2898 */         char d = tel.charAt(i);
/* 2899 */         if (c != d) {
/* 2900 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 2904 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 2905 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 2906 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2911 */     if (this.jTextField32.getText().equals("")) {
/* 2912 */       this.jRadioButton4.setSelected(true);
/*      */     }
/* 2914 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2918 */     limpiar2();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2922 */     String[] campos = { "A Nombre de: ", "A Beneficio de ", "Tipo de Seguro", "Costo", "Fecha de Inicio", "Fecha de Vigencia", "Tiempo de Gracia", "Aseguradora", "Nombre del Agente", "Calle", "Número", "Colonia", "Ciudad", "C.P.", "Teléfono" };
/* 2923 */     this.error.pasarModal(true);
/* 2924 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2925 */     String nombre1 = this.jTextField14.getText();
/* 2926 */     String ap_pat1 = this.jTextField15.getText();
/* 2927 */     String ap_mat1 = this.jTextField16.getText();
/*      */     
/* 2929 */     String nombre2 = this.jTextField17.getText();
/* 2930 */     String ap_pat2 = this.jTextField18.getText();
/* 2931 */     String ap_mat2 = this.jTextField19.getText();
/*      */     
/* 2933 */     String tipo = this.jTextField20.getText();
/* 2934 */     String costo = this.jTextField21.getText();
/* 2935 */     String gracia = this.jTextField22.getText();
/* 2936 */     String cobertura = this.jTextArea1.getText();
/*      */     
/* 2938 */     String nombre3 = this.jTextField23.getText();
/* 2939 */     String nombre4 = this.jTextField24.getText();
/* 2940 */     String calle = this.jTextField25.getText();
/* 2941 */     String num = this.jTextField26.getText();
/* 2942 */     String col = this.jTextField27.getText();
/* 2943 */     String ciudad = this.jTextField28.getText();
/* 2944 */     String cp = this.jTextField29.getText();
/* 2945 */     String estado = "33";
/* 2946 */     String tel1 = this.jFormattedTextField1.getText();
/*      */     
/* 2948 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2949 */     String cadenaFecha = "";
/* 2950 */     String año1 = "";
/* 2951 */     String mes1 = "";
/* 2952 */     String dia1 = "";
/*      */     
/* 2954 */     String año2 = "";
/* 2955 */     String mes2 = "";
/* 2956 */     String dia2 = "";
/*      */     
/* 2958 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 2959 */       estado = "" + this.jComboBox4.getSelectedIndex() - 1;
/*      */     }
/* 2961 */     String codigo = "0";
/* 2962 */     if (!this.jTextField29.getText().equals("")) {
/* 2963 */       codigo = cp;
/*      */     }
/* 2965 */     Date fecha1 = this.jDateChooser2.getDate();
/* 2966 */     Date fecha2 = this.jDateChooser5.getDate();
/* 2967 */     boolean f1 = false;
/* 2968 */     boolean f2 = false;
/* 2969 */     boolean valorC = false;
/* 2970 */     boolean esMayor = false;
/* 2971 */     if (fecha1 != null) {
/* 2972 */       f1 = true;
/*      */     }
/* 2974 */     if (fecha2 != null) {
/* 2975 */       f2 = true;
/*      */     }
/* 2977 */     if (f1 && f2) {
/* 2978 */       if (fecha2.after(fecha1)) {
/* 2979 */         esMayor = true;
/*      */       }
/* 2981 */       this.fecha = this.jDateChooser2.getDate();
/* 2982 */       cadenaFecha = formato.format(this.fecha);
/* 2983 */       año1 = cadenaFecha.substring(0, 4);
/* 2984 */       mes1 = cadenaFecha.substring(4, 6);
/* 2985 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 2987 */       this.fecha = this.jDateChooser5.getDate();
/* 2988 */       cadenaFecha = formato.format(this.fecha);
/* 2989 */       año2 = cadenaFecha.substring(0, 4);
/* 2990 */       mes2 = cadenaFecha.substring(4, 6);
/* 2991 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 2993 */     if (tel1.equals("___-___-____")) {
/* 2994 */       tel1 = "";
/*      */     }
/* 2996 */     float cos = 0.0F;
/* 2997 */     if (nombre1.equals("")) {
/* 2998 */       this.error.cargarError(this.jTextField14, "050");
/*      */     }
/* 3000 */     else if (ap_pat1.equals("")) {
/* 3001 */       this.error.cargarError(this.jTextField15, "050");
/*      */     }
/* 3003 */     else if (nombre2.equals("")) {
/* 3004 */       this.error.cargarError(this.jTextField17, "050");
/*      */     }
/* 3006 */     else if (ap_pat2.equals("")) {
/* 3007 */       this.error.cargarError(this.jTextField18, "050");
/*      */     }
/* 3009 */     else if (tipo.equals("")) {
/* 3010 */       this.error.cargarError(this.jTextField20, "050");
/*      */     }
/* 3012 */     else if (costo.equals("")) {
/* 3013 */       this.error.cargarError(this.jTextField21, "050");
/*      */     }
/* 3015 */     else if (!f1) {
/* 3016 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de inicio de la póliza", "Falta Fecha Inicio", 0, this.ADVER);
/*      */     }
/* 3018 */     else if (!f2) {
/* 3019 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de vigencia de la póliza", "Falta Fecha de Vigencia", 0, this.ADVER);
/*      */     }
/* 3021 */     else if (gracia.equals("")) {
/* 3022 */       this.error.cargarError(this.jTextField22, "050");
/*      */     }
/* 3024 */     else if (nombre3.equals("")) {
/* 3025 */       this.error.cargarError(this.jTextField23, "050");
/*      */     }
/* 3027 */     else if (nombre4.equals("")) {
/* 3028 */       this.error.cargarError(this.jTextField24, "050");
/*      */     }
/* 3030 */     else if (!this.val.validarNombres(this.jTextField14, nombre1, "010") && 
/* 3031 */       !this.val.validarNombres(this.jTextField15, ap_pat1, "010") && 
/* 3032 */       !this.val.validarNombres(this.jTextField16, ap_mat1, "010") && 
/* 3033 */       !this.val.validarNombres(this.jTextField17, nombre2, "010") && 
/* 3034 */       !this.val.validarNombres(this.jTextField18, ap_pat2, "010") && 
/* 3035 */       !this.val.validarNombres(this.jTextField19, ap_mat2, "010") && 
/* 3036 */       !this.val.validarApostrofe(this.jTextField20, tipo, "020") && 
/* 3037 */       !this.val.validarDigitos(this.jTextField21, costo)) {
/* 3038 */       if (!esMayor) {
/* 3039 */         JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */       }
/* 3041 */       else if (this.jDateChooser2.getDate().getYear() < 100) {
/* 3042 */         JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */       }
/* 3044 */       else if (!this.val.validarApostrofe(this.jTextArea1, cobertura, "020") && 
/* 3045 */         !this.val.validarDigitos(this.jTextField22, gracia) && 
/* 3046 */         !this.val.validarApostrofe(this.jTextField23, nombre3, "020") && 
/* 3047 */         !this.val.validarApostrofe(this.jTextField24, nombre4, "020") && 
/* 3048 */         !this.val.validarCalle(this.jTextField25, calle, "014")) {
/*      */         
/* 3050 */         if (!this.jTextField25.getText().equals("") && this.jTextField26.getText().equals("") && this.jTextField27.getText().equals("")) {
/* 3051 */           this.jTextField26.setBackground(new Color(255, 51, 51));
/* 3052 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/*      */         }
/* 3054 */         else if (!this.val.validarNumero(this.jTextField26, num.toUpperCase(), "015")) {
/* 3055 */           if (!this.jTextField26.getText().equals("") && this.jTextField25.getText().equals("")) {
/* 3056 */             this.jTextField25.setBackground(new Color(255, 51, 51));
/* 3057 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/*      */           }
/* 3059 */           else if (!this.val.validarDireccion(this.jTextField27, col, "014")) {
/* 3060 */             if (!this.jTextField27.getText().equals("") && this.jTextField25.getText().equals("")) {
/* 3061 */               this.jTextField25.setBackground(new Color(255, 51, 51));
/* 3062 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/*      */             }
/* 3064 */             else if (!this.val.validarCodigoPostal(this.jTextField29, cp, "014") && 
/* 3065 */               !this.val.validarRegion(this.jTextField28, ciudad, "018")) {
/* 3066 */               String[] info = { nombre1.toUpperCase() + " " + nombre1.toUpperCase() + " " + ap_pat1.toUpperCase(), nombre2.toUpperCase() + " " + nombre2.toUpperCase() + " " + ap_pat2.toUpperCase(), tipo.toUpperCase(), costo.toUpperCase(), fecha1.toString(), fecha2.toString(), gracia, nombre3.toUpperCase(), nombre4.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), ciudad.toUpperCase(), codigo, tel1 };
/* 3067 */               if (this.jButton13.getText().equals("Modificar")) {
/* 3068 */                 int res = this.error.cargarDatos2(campos, info);
/* 3069 */                 if (res == 0) {
/* 3070 */                   this.jDialog2.setVisible(false);
/* 3071 */                   this.con.insertar("update vehicular_carro set nombre1='" + nombre1.toUpperCase() + "', ap_pat1='" + ap_pat1.toUpperCase() + "', ap_mat1='" + ap_mat1.toUpperCase() + "', nombre2='" + nombre2.toUpperCase() + "', ap_pat2='" + ap_pat2.toUpperCase() + "', ap_mat2='" + ap_mat2.toUpperCase() + "', tipo_seg='" + tipo.toUpperCase() + "', costo=" + costo + ",fecha_inicio='" + año1 + "-" + mes1 + "-" + dia1 + "', fecha_vigen='" + año2 + "-" + mes2 + "-" + dia2 + "',gracia=" + gracia + ",cobertura='" + cobertura + "',nombre3='" + nombre3.toUpperCase() + "',nombre4='" + nombre4.toUpperCase() + "',calle='" + calle.toUpperCase() + "',num='" + num.toUpperCase() + "',col='" + col.toUpperCase() + "',ciudad='" + ciudad.toUpperCase() + "',cp=" + codigo + ",telefono='" + tel1 + "',id_edo =" + estado + "  where num_seg=" + this.jTextField32.getText());
/* 3072 */                   this.jRadioButton5.setSelected(true);
/*      */                 } 
/*      */               } else {
/*      */                 
/* 3076 */                 int res = this.error.cargarDatos(campos, info);
/* 3077 */                 if (res == 0) {
/* 3078 */                   this.con.insertar("insert into vehicular_carro(nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo)values('" + nombre1.toUpperCase() + "','" + ap_pat1.toUpperCase() + "','" + ap_mat1.toUpperCase() + "','" + nombre2.toUpperCase() + "','" + ap_pat2.toUpperCase() + "','" + ap_mat2.toUpperCase() + "','" + tipo.toUpperCase() + "'," + costo + ",'" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "'," + gracia + ",'" + cobertura + "','" + nombre3.toUpperCase() + "','" + nombre4.toUpperCase() + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "','" + ciudad.toUpperCase() + "'," + codigo + ",'" + tel1 + "'," + estado + " )");
/*      */                   
/* 3080 */                   limpiar2();
/* 3081 */                   this.jDialog2.setVisible(false);
/* 3082 */                   this.con.consultar("max(num_seg)", "vehicular_carro", "");
/* 3083 */                   this.jTextField32.setText(this.con.Campo);
/* 3084 */                   this.jRadioButton5.setSelected(true);
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
/* 3107 */     cargarFormulario1();
/*      */   }
/*      */   
/*      */   private void jDialog2WindowClosing(WindowEvent evt) {
/* 3111 */     if (this.jTextField32.getText().equals("")) {
/* 3112 */       this.jRadioButton4.setSelected(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField2FocusLost(FocusEvent evt) {
/* 3121 */     int cont = 0;
/* 3122 */     if (this.jFormattedTextField2.getText().contains("_") && !this.jFormattedTextField2.getText().equals("___-___-____")) {
/* 3123 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField2.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 3124 */       this.jFormattedTextField2.setValue("");
/*      */     }
/* 3126 */     else if (!this.jFormattedTextField2.getText().contains("_")) {
/* 3127 */       String cadena = this.jFormattedTextField2.getText();
/* 3128 */       String cad1 = cadena.substring(0, 3);
/* 3129 */       String cad2 = cadena.substring(4, 7);
/* 3130 */       String cad3 = cadena.substring(8, 12);
/* 3131 */       String tel = cad1 + cad1 + cad2;
/* 3132 */       for (int i = 1; i < tel.length(); i++) {
/* 3133 */         char c = tel.charAt(i - 1);
/* 3134 */         char d = tel.charAt(i);
/* 3135 */         if (c != d) {
/* 3136 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 3140 */     if (cont == 0 && !this.jFormattedTextField2.getText().contains("_")) {
/* 3141 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 3142 */       this.jFormattedTextField2.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3147 */     if (this.jTextField33.getText().equals("")) {
/* 3148 */       this.jRadioButton10.setSelected(true);
/*      */     }
/* 3150 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 3154 */     limpiar3();
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3158 */     String[] campos = { "A Nombre de: ", "A Beneficio de ", "Tipo de Seguro", "Costo", "Fecha de Inicio", "Fecha de Vigencia", "Tiempo de Gracia", "Aseguradora", "Nombre del Agente", "Calle", "Número", "Colonia", "Ciudad", "C.P.", "Teléfono" };
/* 3159 */     this.error.pasarModal(true);
/* 3160 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3161 */     String nombre1 = this.jTextField34.getText();
/* 3162 */     String ap_pat1 = this.jTextField35.getText();
/* 3163 */     String ap_mat1 = this.jTextField36.getText();
/*      */     
/* 3165 */     String nombre2 = this.jTextField37.getText();
/* 3166 */     String ap_pat2 = this.jTextField38.getText();
/* 3167 */     String ap_mat2 = this.jTextField39.getText();
/*      */     
/* 3169 */     String tipo = this.jTextField40.getText();
/* 3170 */     String costo = this.jTextField41.getText();
/* 3171 */     String gracia = this.jTextField42.getText();
/* 3172 */     String cobertura = this.jTextArea2.getText();
/*      */     
/* 3174 */     String nombre3 = this.jTextField43.getText();
/* 3175 */     String nombre4 = this.jTextField44.getText();
/* 3176 */     String calle = this.jTextField45.getText();
/* 3177 */     String num = this.jTextField46.getText();
/* 3178 */     String col = this.jTextField47.getText();
/* 3179 */     String ciudad = this.jTextField48.getText();
/* 3180 */     String cp = this.jTextField49.getText();
/* 3181 */     String estado = "33";
/* 3182 */     String tel1 = this.jFormattedTextField2.getText();
/*      */     
/* 3184 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3185 */     String cadenaFecha = "";
/* 3186 */     String año1 = "";
/* 3187 */     String mes1 = "";
/* 3188 */     String dia1 = "";
/*      */     
/* 3190 */     String año2 = "";
/* 3191 */     String mes2 = "";
/* 3192 */     String dia2 = "";
/*      */     
/* 3194 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3195 */       estado = "" + this.jComboBox6.getSelectedIndex() - 1;
/*      */     }
/* 3197 */     String codigo = "0";
/* 3198 */     if (!this.jTextField49.getText().equals("")) {
/* 3199 */       codigo = cp;
/*      */     }
/* 3201 */     Date fecha1 = this.jDateChooser3.getDate();
/* 3202 */     Date fecha2 = this.jDateChooser6.getDate();
/* 3203 */     boolean f1 = false;
/* 3204 */     boolean f2 = false;
/* 3205 */     boolean valorC = false;
/* 3206 */     boolean esMayor = false;
/* 3207 */     if (fecha1 != null) {
/* 3208 */       f1 = true;
/*      */     }
/* 3210 */     if (fecha2 != null) {
/* 3211 */       f2 = true;
/*      */     }
/* 3213 */     if (f1 && f2) {
/* 3214 */       if (fecha2.after(fecha1)) {
/* 3215 */         esMayor = true;
/*      */       }
/* 3217 */       this.fecha = this.jDateChooser3.getDate();
/* 3218 */       cadenaFecha = formato.format(this.fecha);
/* 3219 */       año1 = cadenaFecha.substring(0, 4);
/* 3220 */       mes1 = cadenaFecha.substring(4, 6);
/* 3221 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3223 */       this.fecha = this.jDateChooser6.getDate();
/* 3224 */       cadenaFecha = formato.format(this.fecha);
/* 3225 */       año2 = cadenaFecha.substring(0, 4);
/* 3226 */       mes2 = cadenaFecha.substring(4, 6);
/* 3227 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3229 */     if (tel1.equals("___-___-____")) {
/* 3230 */       tel1 = "";
/*      */     }
/* 3232 */     float cos = 0.0F;
/* 3233 */     if (nombre1.equals("")) {
/* 3234 */       this.error.cargarError(this.jTextField34, "050");
/*      */     }
/* 3236 */     else if (ap_pat1.equals("")) {
/* 3237 */       this.error.cargarError(this.jTextField35, "050");
/*      */     }
/* 3239 */     else if (nombre2.equals("")) {
/* 3240 */       this.error.cargarError(this.jTextField37, "050");
/*      */     }
/* 3242 */     else if (ap_pat2.equals("")) {
/* 3243 */       this.error.cargarError(this.jTextField38, "050");
/*      */     }
/* 3245 */     else if (tipo.equals("")) {
/* 3246 */       this.error.cargarError(this.jTextField40, "050");
/*      */     }
/* 3248 */     else if (costo.equals("")) {
/* 3249 */       this.error.cargarError(this.jTextField41, "050");
/*      */     }
/* 3251 */     else if (!f1) {
/* 3252 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de inicio de la póliza", "Falta Fecha Inicio", 0, this.ADVER);
/*      */     }
/* 3254 */     else if (!f2) {
/* 3255 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar la fecha de vigencia de la póliza", "Falta Fecha de Vigencia", 0, this.ADVER);
/*      */     }
/* 3257 */     else if (gracia.equals("")) {
/* 3258 */       this.error.cargarError(this.jTextField42, "050");
/*      */     }
/* 3260 */     else if (nombre3.equals("")) {
/* 3261 */       this.error.cargarError(this.jTextField43, "050");
/*      */     }
/* 3263 */     else if (nombre4.equals("")) {
/* 3264 */       this.error.cargarError(this.jTextField44, "050");
/*      */     }
/* 3266 */     else if (!this.val.validarNombres(this.jTextField34, nombre1, "010") && 
/* 3267 */       !this.val.validarNombres(this.jTextField35, ap_pat1, "010") && 
/* 3268 */       !this.val.validarNombres(this.jTextField36, ap_mat1, "010") && 
/* 3269 */       !this.val.validarNombres(this.jTextField37, nombre2, "010") && 
/* 3270 */       !this.val.validarNombres(this.jTextField38, ap_pat2, "010") && 
/* 3271 */       !this.val.validarNombres(this.jTextField39, ap_mat2, "010") && 
/* 3272 */       !this.val.validarApostrofe(this.jTextField40, tipo, "020") && 
/* 3273 */       !this.val.validarDigitos(this.jTextField41, costo)) {
/* 3274 */       if (!esMayor) {
/* 3275 */         JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */       }
/* 3277 */       else if (this.jDateChooser2.getDate().getYear() < 100) {
/* 3278 */         JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2009/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */       }
/* 3280 */       else if (!this.val.validarApostrofe(this.jTextArea2, cobertura, "020") && 
/* 3281 */         !this.val.validarDigitos(this.jTextField42, gracia) && 
/* 3282 */         !this.val.validarApostrofe(this.jTextField43, nombre3, "020") && 
/* 3283 */         !this.val.validarApostrofe(this.jTextField44, nombre4, "020") && 
/* 3284 */         !this.val.validarCalle(this.jTextField45, calle, "014")) {
/* 3285 */         if (!this.jTextField45.getText().equals("") && this.jTextField46.getText().equals("") && this.jTextField47.getText().equals("")) {
/* 3286 */           this.jTextField46.setBackground(new Color(255, 51, 51));
/* 3287 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/*      */         }
/* 3289 */         else if (!this.val.validarNumero(this.jTextField46, num.toUpperCase(), "015")) {
/* 3290 */           if (!this.jTextField46.getText().equals("") && this.jTextField45.getText().equals("")) {
/* 3291 */             this.jTextField45.setBackground(new Color(255, 51, 51));
/* 3292 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/*      */           }
/* 3294 */           else if (!this.val.validarDireccion(this.jTextField47, col, "014")) {
/* 3295 */             if (!this.jTextField47.getText().equals("") && this.jTextField45.getText().equals("")) {
/* 3296 */               this.jTextField45.setBackground(new Color(255, 51, 51));
/* 3297 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/*      */             }
/* 3299 */             else if (!this.val.validarCodigoPostal(this.jTextField49, cp, "014") && 
/* 3300 */               !this.val.validarRegion(this.jTextField48, ciudad, "018")) {
/* 3301 */               String[] info = { nombre1.toUpperCase() + " " + nombre1.toUpperCase() + " " + ap_pat1.toUpperCase(), nombre2.toUpperCase() + " " + nombre2.toUpperCase() + " " + ap_pat2.toUpperCase(), tipo.toUpperCase(), costo.toUpperCase(), fecha1.toString(), fecha2.toString(), gracia, nombre3.toUpperCase(), nombre4.toUpperCase(), calle.toUpperCase(), num.toUpperCase(), col.toUpperCase(), ciudad.toUpperCase(), codigo, tel1 };
/* 3302 */               if (this.jButton19.getText().equals("Modificar")) {
/* 3303 */                 int res = this.error.cargarDatos2(campos, info);
/* 3304 */                 if (res == 0) {
/* 3305 */                   this.jDialog4.setVisible(false);
/* 3306 */                   this.con.insertar("update ecologico set nombre1='" + nombre1.toUpperCase() + "', ap_pat1='" + ap_pat1.toUpperCase() + "', ap_mat1='" + ap_mat1.toUpperCase() + "', nombre2='" + nombre2.toUpperCase() + "', ap_pat2='" + ap_pat2.toUpperCase() + "', ap_mat2='" + ap_mat2.toUpperCase() + "', tipo_seg='" + tipo.toUpperCase() + "', costo=" + costo + ",fecha_inicio='" + año1 + "-" + mes1 + "-" + dia1 + "', fecha_vigen='" + año2 + "-" + mes2 + "-" + dia2 + "',gracia=" + gracia + ",cobertura='" + cobertura + "',nombre3='" + nombre3.toUpperCase() + "',nombre4='" + nombre4.toUpperCase() + "',calle='" + calle.toUpperCase() + "',num='" + num.toUpperCase() + "',col='" + col.toUpperCase() + "',ciudad='" + ciudad.toUpperCase() + "',cp=" + codigo + ",telefono='" + tel1 + "',id_edo =" + estado + "  where num_eco=" + this.jTextField33.getText());
/* 3307 */                   this.jRadioButton11.setSelected(true);
/*      */                 } 
/*      */               } else {
/*      */                 
/* 3311 */                 int res = this.error.cargarDatos(campos, info);
/* 3312 */                 if (res == 0) {
/* 3313 */                   this.con.insertar("insert into ecologico(nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo)values('" + nombre1.toUpperCase() + "','" + ap_pat1.toUpperCase() + "','" + ap_mat1.toUpperCase() + "','" + nombre2.toUpperCase() + "','" + ap_pat2.toUpperCase() + "','" + ap_mat2.toUpperCase() + "','" + tipo.toUpperCase() + "'," + costo + ",'" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "'," + gracia + ",'" + cobertura + "','" + nombre3.toUpperCase() + "','" + nombre4.toUpperCase() + "','" + calle.toUpperCase() + "','" + num.toUpperCase() + "','" + col.toUpperCase() + "','" + ciudad.toUpperCase() + "'," + codigo + ",'" + tel1 + "'," + estado + " )");
/*      */                   
/* 3315 */                   limpiar2();
/* 3316 */                   this.jDialog4.setVisible(false);
/* 3317 */                   this.con.consultar("max(num_eco)", "ecologico", "");
/* 3318 */                   this.jTextField33.setText(this.con.Campo);
/* 3319 */                   this.jRadioButton11.setSelected(true);
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
/* 3342 */     cargarFormulario2();
/*      */   }
/*      */   
/*      */   private void jDialog4WindowClosing(WindowEvent evt) {
/* 3346 */     if (this.jTextField33.getText().equals("")) {
/* 3347 */       this.jRadioButton10.setSelected(true);
/*      */     }
/* 3349 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3353 */     if (this.jTextField30.getText().equals("")) {
/* 3354 */       this.jRadioButton1.setSelected(true);
/*      */     }
/* 3356 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 3360 */     limpiar4();
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 3364 */     this.error.pasarModal(true);
/* 3365 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3366 */     boolean alta = this.jRadioButton13.isSelected();
/* 3367 */     String tipo = "Alta";
/* 3368 */     Date fecha1 = this.jDateChooser4.getDate();
/* 3369 */     Date fecha2 = this.jDateChooser7.getDate();
/* 3370 */     String comentario = this.jTextArea3.getText();
/* 3371 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 3373 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3374 */     String cadenaFecha = "";
/*      */     
/* 3376 */     String año1 = "";
/* 3377 */     String mes1 = "";
/* 3378 */     String dia1 = "";
/*      */     
/* 3380 */     String año2 = "";
/* 3381 */     String mes2 = "";
/* 3382 */     String dia2 = "";
/*      */     
/* 3384 */     boolean f1 = false;
/* 3385 */     boolean f2 = false;
/* 3386 */     boolean valorC = false;
/* 3387 */     boolean esMayor = false;
/*      */     
/* 3389 */     if (!alta) {
/* 3390 */       tipo = "Renovación";
/*      */     }
/* 3392 */     if (fecha1 != null) {
/* 3393 */       f1 = true;
/*      */     }
/* 3395 */     if (fecha2 != null) {
/* 3396 */       f2 = true;
/*      */     }
/* 3398 */     if (f1 && f2) {
/* 3399 */       if (fecha2.after(fecha1)) {
/* 3400 */         esMayor = true;
/*      */       }
/* 3402 */       this.fecha = this.jDateChooser4.getDate();
/* 3403 */       cadenaFecha = formato.format(this.fecha);
/* 3404 */       año1 = cadenaFecha.substring(0, 4);
/* 3405 */       mes1 = cadenaFecha.substring(4, 6);
/* 3406 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3408 */       this.fecha = this.jDateChooser7.getDate();
/* 3409 */       cadenaFecha = formato.format(this.fecha);
/* 3410 */       año2 = cadenaFecha.substring(0, 4);
/* 3411 */       mes2 = cadenaFecha.substring(4, 6);
/* 3412 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3414 */     if (!f1) {
/* 3415 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 3417 */     else if (!f2) {
/* 3418 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 3420 */     else if (!esMayor) {
/* 3421 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 3423 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 3424 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 3426 */     else if (!this.val.validarApostrofe(this.jTextArea3, this.jTextArea3.getText(), "020")) {
/* 3427 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 3428 */       if (this.jButton19.getText().equals("Modificar")) {
/* 3429 */         int res = this.error.cargarDatos2(campos, info);
/* 3430 */         if (res == 0) {
/* 3431 */           this.jDialog4.setVisible(false);
/* 3432 */           this.con.insertar("update ");
/* 3433 */           this.jRadioButton2.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 3437 */         int res = this.error.cargarDatos(campos, info);
/* 3438 */         if (res == 0) {
/* 3439 */           this.con.insertar("insert into semarnat (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea3.getText() + "')");
/* 3440 */           limpiar4();
/* 3441 */           this.jDialog5.setVisible(false);
/* 3442 */           this.con.consultar("max(num_sem)", "semarnat", "");
/* 3443 */           this.jTextField30.setText(this.con.Campo);
/* 3444 */           this.jRadioButton2.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 3451 */     cargarFormulario3();
/*      */   }
/*      */   
/*      */   private void jDialog5WindowClosing(WindowEvent evt) {
/* 3455 */     if (this.jTextField30.getText().equals("")) {
/* 3456 */       this.jRadioButton1.setSelected(true);
/*      */     }
/* 3458 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 3462 */     if (this.jTextField31.getText().equals("")) {
/* 3463 */       this.jRadioButton7.setSelected(true);
/*      */     }
/* 3465 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 3469 */     limpiar5();
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 3473 */     this.error.pasarModal(true);
/* 3474 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3475 */     boolean alta = this.jRadioButton15.isSelected();
/* 3476 */     String tipo = "Alta";
/* 3477 */     Date fecha1 = this.jDateChooser8.getDate();
/* 3478 */     Date fecha2 = this.jDateChooser9.getDate();
/* 3479 */     String comentario = this.jTextArea4.getText();
/* 3480 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 3482 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3483 */     String cadenaFecha = "";
/*      */     
/* 3485 */     String año1 = "";
/* 3486 */     String mes1 = "";
/* 3487 */     String dia1 = "";
/*      */     
/* 3489 */     String año2 = "";
/* 3490 */     String mes2 = "";
/* 3491 */     String dia2 = "";
/*      */     
/* 3493 */     boolean f1 = false;
/* 3494 */     boolean f2 = false;
/* 3495 */     boolean valorC = false;
/* 3496 */     boolean esMayor = false;
/*      */     
/* 3498 */     if (!alta) {
/* 3499 */       tipo = "Renovación";
/*      */     }
/* 3501 */     if (fecha1 != null) {
/* 3502 */       f1 = true;
/*      */     }
/* 3504 */     if (fecha2 != null) {
/* 3505 */       f2 = true;
/*      */     }
/* 3507 */     if (f1 && f2) {
/* 3508 */       if (fecha2.after(fecha1)) {
/* 3509 */         esMayor = true;
/*      */       }
/* 3511 */       this.fecha = this.jDateChooser8.getDate();
/* 3512 */       cadenaFecha = formato.format(this.fecha);
/* 3513 */       año1 = cadenaFecha.substring(0, 4);
/* 3514 */       mes1 = cadenaFecha.substring(4, 6);
/* 3515 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3517 */       this.fecha = this.jDateChooser9.getDate();
/* 3518 */       cadenaFecha = formato.format(this.fecha);
/* 3519 */       año2 = cadenaFecha.substring(0, 4);
/* 3520 */       mes2 = cadenaFecha.substring(4, 6);
/* 3521 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3523 */     if (!f1) {
/* 3524 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 3526 */     else if (!f2) {
/* 3527 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 3529 */     else if (!esMayor) {
/* 3530 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 3532 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 3533 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 3535 */     else if (!this.val.validarApostrofe(this.jTextArea4, this.jTextArea4.getText(), "020")) {
/* 3536 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 3537 */       if (this.jButton27.getText().equals("Modificar")) {
/* 3538 */         int res = this.error.cargarDatos2(campos, info);
/* 3539 */         if (res == 0) {
/* 3540 */           this.jDialog6.setVisible(false);
/* 3541 */           this.con.insertar("update ");
/* 3542 */           this.jRadioButton8.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 3546 */         int res = this.error.cargarDatos(campos, info);
/* 3547 */         if (res == 0) {
/* 3548 */           this.con.insertar("insert into sct (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea4.getText().toUpperCase() + "')");
/* 3549 */           limpiar5();
/* 3550 */           this.jDialog6.setVisible(false);
/* 3551 */           this.con.consultar("max(num_sct)", "sct", "");
/* 3552 */           this.jTextField31.setText(this.con.Campo);
/* 3553 */           this.jRadioButton8.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 3560 */     cargarFormulario4();
/*      */   }
/*      */   
/*      */   private void jDialog6WindowClosing(WindowEvent evt) {
/* 3564 */     if (this.jTextField31.getText().equals("")) {
/* 3565 */       this.jRadioButton7.setSelected(true);
/*      */     }
/* 3567 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 3571 */     if (this.jTextField50.getText().equals("")) {
/* 3572 */       this.jRadioButton17.setSelected(true);
/*      */     }
/* 3574 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 3582 */     this.error.pasarModal(true);
/* 3583 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3584 */     boolean alta = this.jRadioButton20.isSelected();
/* 3585 */     String tipo = "Alta";
/* 3586 */     Date fecha1 = this.jDateChooser10.getDate();
/* 3587 */     Date fecha2 = this.jDateChooser11.getDate();
/* 3588 */     String comentario = this.jTextArea5.getText();
/* 3589 */     String[] campos = { "Tipo", "Fecha de Inicio", "Fecha de Vigencia", "Comentarios" };
/*      */     
/* 3591 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3592 */     String cadenaFecha = "";
/*      */     
/* 3594 */     String año1 = "";
/* 3595 */     String mes1 = "";
/* 3596 */     String dia1 = "";
/*      */     
/* 3598 */     String año2 = "";
/* 3599 */     String mes2 = "";
/* 3600 */     String dia2 = "";
/*      */     
/* 3602 */     boolean f1 = false;
/* 3603 */     boolean f2 = false;
/* 3604 */     boolean valorC = false;
/* 3605 */     boolean esMayor = false;
/*      */     
/* 3607 */     if (!alta) {
/* 3608 */       tipo = "Renovación";
/*      */     }
/* 3610 */     if (fecha1 != null) {
/* 3611 */       f1 = true;
/*      */     }
/* 3613 */     if (fecha2 != null) {
/* 3614 */       f2 = true;
/*      */     }
/* 3616 */     if (f1 && f2) {
/* 3617 */       if (fecha2.after(fecha1)) {
/* 3618 */         esMayor = true;
/*      */       }
/* 3620 */       this.fecha = this.jDateChooser10.getDate();
/* 3621 */       cadenaFecha = formato.format(this.fecha);
/* 3622 */       año1 = cadenaFecha.substring(0, 4);
/* 3623 */       mes1 = cadenaFecha.substring(4, 6);
/* 3624 */       dia1 = cadenaFecha.substring(6, 8);
/*      */       
/* 3626 */       this.fecha = this.jDateChooser11.getDate();
/* 3627 */       cadenaFecha = formato.format(this.fecha);
/* 3628 */       año2 = cadenaFecha.substring(0, 4);
/* 3629 */       mes2 = cadenaFecha.substring(4, 6);
/* 3630 */       dia2 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3632 */     if (!f1) {
/* 3633 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de inicio vacía, verifica tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 3635 */     else if (!f2) {
/* 3636 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de vigencia vacía, verifica tu información", "Fecha de Vigencia Vacía", 0, this.ERROR);
/*      */     }
/* 3638 */     else if (!esMayor) {
/* 3639 */       JOptionPane.showMessageDialog(this.padre, "La fecha de vigencia debe ser mayor a la fecha de inicio.\nVerifica las fechas", "Fechas Incorrectas", 0, this.ERROR);
/*      */     }
/* 3641 */     else if (this.jDateChooser4.getDate().getYear() < 100) {
/* 3642 */       JOptionPane.showMessageDialog(this.padre, "Necesitas colocar una fecha que sea mayor o igual a 2000/Ene/01\nEn el campo para especificar la fecha de inicio", "Fecha Muy Pequeña", 0, this.ERROR);
/*      */     }
/* 3644 */     else if (!this.val.validarApostrofe(this.jTextArea5, this.jTextArea5.getText(), "020")) {
/* 3645 */       String[] info = { tipo, año1 + "-" + año1 + "-" + mes1, año2 + "-" + año2 + "-" + mes2, comentario };
/* 3646 */       if (this.jButton31.getText().equals("Modificar")) {
/* 3647 */         int res = this.error.cargarDatos2(campos, info);
/* 3648 */         if (res == 0) {
/* 3649 */           this.jDialog7.setVisible(false);
/* 3650 */           this.con.insertar("update ");
/* 3651 */           this.jRadioButton18.setSelected(true);
/*      */         } 
/*      */       } else {
/*      */         
/* 3655 */         int res = this.error.cargarDatos(campos, info);
/* 3656 */         if (res == 0) {
/* 3657 */           this.con.insertar("insert into sedere (tipo,fecha_inicio,fecha_vigen,comen) values('" + tipo + "','" + año1 + "-" + mes1 + "-" + dia1 + "','" + año2 + "-" + mes2 + "-" + dia2 + "','" + this.jTextArea5.getText().toUpperCase() + "')");
/* 3658 */           limpiar6();
/* 3659 */           this.jDialog7.setVisible(false);
/* 3660 */           this.con.consultar("max(num_sed)", "sedere", "");
/* 3661 */           this.jTextField50.setText(this.con.Campo);
/* 3662 */           this.jRadioButton18.setSelected(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jDialog7WindowClosing(WindowEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3677 */     this.error.pasarModal(false);
/* 3678 */     this.val.pasarModal(Boolean.valueOf(false));
/* 3679 */     String numTracto = this.jTextField1.getText();
/* 3680 */     String color = this.jTextField2.getText().toUpperCase();
/* 3681 */     String tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 3682 */     String estado = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     
/* 3684 */     String marca = String.valueOf(this.jComboBox2.getSelectedItem());
/* 3685 */     String modelo = String.valueOf(this.jComboBox7.getSelectedItem());
/* 3686 */     String serie = this.jTextField4.getText().toUpperCase();
/* 3687 */     String placas = this.jTextField7.getText().toUpperCase();
/*      */     
/* 3689 */     Date fAdquisicion = this.jDateChooser1.getDate();
/* 3690 */     String factu = this.jTextField6.getText();
/* 3691 */     String formaPago = "";
/*      */     
/* 3693 */     String km = this.jTextField9.getText();
/* 3694 */     String peso = this.jTextField10.getText();
/* 3695 */     String dimensiones = this.jTextField11.getText().toUpperCase();
/*      */     
/* 3697 */     String[] campos = { "Número de Caja", "Color", "Tipo", "Marca", "Modelo", "Núm de Serie", "Placas", "Fecha de Adquisición", "Núm Factura", "Forma de Pago", "KM Actual", "Peso Vehicular", "Dimensiones", "Permiso SEMARNAT", "Permiso SCT", "Permiso Sedere", "Póliza Vehicular", "Póliza Ecológica" };
/* 3698 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3699 */     String cadenaFecha = "";
/* 3700 */     String año1 = "";
/* 3701 */     String mes1 = "";
/* 3702 */     String dia1 = "";
/*      */     
/* 3704 */     String idMarca = "0";
/* 3705 */     String idTipo = "0";
/*      */     
/* 3707 */     String p1 = "0";
/* 3708 */     String p2 = "0";
/* 3709 */     String p3 = "0";
/* 3710 */     String p4 = "0";
/* 3711 */     String p5 = "0";
/*      */     
/* 3713 */     if (!this.jRadioButton1.isSelected()) {
/* 3714 */       p1 = this.jTextField30.getText();
/*      */     }
/* 3716 */     if (!this.jRadioButton7.isSelected()) {
/* 3717 */       p2 = this.jTextField31.getText();
/*      */     }
/* 3719 */     if (!this.jRadioButton17.isSelected()) {
/* 3720 */       p3 = this.jTextField50.getText();
/*      */     }
/* 3722 */     if (!this.jRadioButton4.isSelected()) {
/* 3723 */       p4 = this.jTextField32.getText();
/*      */     }
/* 3725 */     if (!this.jRadioButton10.isSelected()) {
/* 3726 */       p5 = this.jTextField33.getText();
/*      */     }
/* 3728 */     if (this.jComboBox1.getSelectedIndex() != 0 && this.jComboBox2.getSelectedIndex() != 0) {
/* 3729 */       this.con.consultar("id_marca", "marca", "where marca = '" + String.valueOf(this.jComboBox2.getSelectedItem()) + "'");
/* 3730 */       idMarca = this.con.Campo;
/*      */     } 
/* 3732 */     if (fAdquisicion != null) {
/* 3733 */       this.fecha = this.jDateChooser2.getDate();
/* 3734 */       cadenaFecha = formato.format(this.fecha);
/* 3735 */       año1 = cadenaFecha.substring(0, 4);
/* 3736 */       mes1 = cadenaFecha.substring(4, 6);
/* 3737 */       dia1 = cadenaFecha.substring(6, 8);
/*      */     } 
/* 3739 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3740 */       formaPago = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 3742 */     if (numTracto.equals("")) {
/* 3743 */       this.error.cargarError(this.jTextField1, "050");
/*      */     }
/* 3745 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3746 */       this.error.cargarError(this.jComboBox1, "050");
/*      */     }
/* 3748 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3749 */       this.error.cargarError(this.jComboBox1, "050");
/*      */     }
/* 3751 */     else if (this.jComboBox2.getSelectedIndex() == 0) {
/* 3752 */       this.error.cargarError(this.jComboBox2, "050");
/*      */     }
/* 3754 */     else if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3755 */       this.error.cargarError(this.jComboBox7, "050");
/*      */     }
/* 3757 */     else if (serie.equals("")) {
/* 3758 */       this.error.cargarError(this.jTextField4, "050");
/*      */     }
/* 3760 */     else if (fAdquisicion == null) {
/* 3761 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar en blanco la fecha de adquisición, por favor verifica la información", "Fecha de Adquisición Vacía", 0, this.ERROR);
/*      */     }
/* 3763 */     else if (placas.equals("")) {
/* 3764 */       this.error.cargarError(this.jTextField7, "050");
/*      */     }
/* 3766 */     else if (!this.val.validarSoloNum(this.jTextField1, numTracto)) {
/* 3767 */       if (this.con.consultar("num_rem", "remolque", "where num_rem = " + this.jTextField1.getText()) && this.jButton1.getText().equals("Guardar")) {
/* 3768 */         this.jTextField1.setBackground(new Color(255, 51, 51));
/* 3769 */         JOptionPane.showMessageDialog(this.padre, "El número de remolque que colocaste ya se encuentra registrado en la base de datos", "Número registrado", 0, this.ERROR);
/*      */       }
/* 3771 */       else if (!this.val.validarApostrofe(this.jTextField2, color, "020") && 
/* 3772 */         !this.val.validarApostrofe(this.jTextField4, serie, "020") && 
/* 3773 */         !this.val.validarPlacas(this.jTextField7, placas)) {
/* 3774 */         if (fAdquisicion.getYear() < 90) {
/* 3775 */           JOptionPane.showMessageDialog(this.padre, "La fecha de facturación no puede ser menor a 1990");
/*      */           return;
/*      */         } 
/* 3778 */         if (!this.val.validarDigitos(this.jTextField6, factu) && 
/* 3779 */           !this.val.validarDigitos(this.jTextField9, km) && 
/* 3780 */           !this.val.validarDigitos(this.jTextField10, peso) && 
/* 3781 */           !this.val.validarApostrofe(this.jTextField11, dimensiones, "020")) {
/* 3782 */           String[] info = { numTracto, color, tipo, marca, modelo, serie, placas, año1 + "-" + año1 + "-" + mes1, factu, formaPago, km, peso, dimensiones, p1, p2, p3, p4, p5 };
/* 3783 */           if (!this.jTextField6.getText().equals("")) {
/* 3784 */             factu = this.jTextField6.getText();
/*      */           } else {
/*      */             
/* 3787 */             factu = "0";
/*      */           } 
/* 3789 */           if (!this.jTextField9.getText().equals("")) {
/* 3790 */             km = this.jTextField9.getText();
/*      */           } else {
/*      */             
/* 3793 */             km = "0";
/*      */           } 
/* 3795 */           if (!this.jTextField10.getText().equals("")) {
/* 3796 */             peso = this.jTextField10.getText();
/*      */           } else {
/*      */             
/* 3799 */             peso = "0";
/*      */           } 
/* 3801 */           if (this.jButton1.getText().equals("Modificar")) {
/* 3802 */             int res = this.error.cargarDatos2(campos, info);
/* 3803 */             if (res == 0) {
/* 3804 */               this.con.insertar("update remolque set modelo ='" + modelo + "', color = '" + color + "',no_serie='" + serie + "', num_factu=" + factu + ",forma_pago='" + formaPago + "',placas='" + placas + "',km_actual='" + km + "',peso=" + peso + ",dimen='" + dimensiones + "',estado='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "', tipo = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "', id_marca=" + idMarca + " where num_rem = " + numTracto);
/* 3805 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Modificó el Remolque No: " + numTracto + "','Modelo: " + this.inf[0] + "\nColor: " + this.inf[1] + "\nNúmero de Serie: " + this.inf[2] + "\nNúmero de Factura " + this.inf[3] + "\nForma de Pago: " + this.inf[4] + "\nPlacas: " + this.inf[5] + "\nKm Actual: " + this.inf[6] + "\nPeso: " + this.inf[7] + "\nDimensión: " + this.inf[8] + "\nEstado: Alta\nFecha de Adquisición: " + this.inf[9] + "' )");
/*      */               
/* 3807 */               limpiar();
/* 3808 */               consultar();
/* 3809 */               this.fichas.remove(1);
/*      */             } 
/*      */           } else {
/*      */             
/* 3813 */             int res = this.error.cargarDatos2(campos, info);
/* 3814 */             if (res == 0) {
/* 3815 */               this.con.insertar("insert into remolque(num_rem,modelo,color,No_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,tipo,id_marca,num_sem,num_sct,num_sed,num_seg,num_eco)values(" + numTracto + ",'" + modelo + "','" + color + "','" + serie + "'," + factu + ",'" + formaPago + "','" + placas + "'," + km + "," + peso + ",'" + dimensiones + "','Activo','" + año1 + "-" + mes1 + "-" + dia1 + "','" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'," + idMarca + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + ")");
/* 3816 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó el remolque No: " + numTracto + "','Modelo: " + modelo + "\nColor: " + color + "\nNúmero de Serie: " + serie + "\nNúmero de Factura " + factu + "\nForma de Pago: " + formaPago + "\nPlacas: " + placas + "\nKm Actual: " + km + "\nPeso: " + peso + "\nDimensión: " + dimensiones + "\nEstado: Alta\nFecha de Adquisición: " + año1 + "-" + mes1 + "-" + dia1 + "\nMarca: " + marca + "\nTipo: " + String.valueOf(this.jComboBox1.getSelectedItem()) + "' )");
/* 3817 */               this.mensajeTry.guardarConf("Se ha agregado un remolque, USUARIO: " + this.USUARIO, "Nuevo Remolque (" + this.jTextField1.getText() + ")", "INFO", "Perforacion");
/* 3818 */               limpiar();
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
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3832 */     limpiar();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/* 3836 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3837 */     this.fichas.remove(1);
/* 3838 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseEntered(MouseEvent evt) {
/* 3842 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel14MouseExited(MouseEvent evt) {
/* 3846 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 3850 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 3854 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3855 */     this.fichas.remove(1);
/* 3856 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3860 */     consultar1();
/* 3861 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 3865 */     String camp = this.jTextField30.getText();
/* 3866 */     if (!camp.equals("")) {
/* 3867 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de SEMARNAT\n¿Deseas quitar esa información?", "Quitar Permiso SEMARNAT", 0, 3, this.PREG);
/* 3868 */       if (resp == 0) {
/* 3869 */         this.jRadioButton1.setSelected(true);
/* 3870 */         this.jTextField30.setText("");
/*      */       } else {
/*      */         
/* 3873 */         this.jRadioButton2.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 3879 */     if (this.jTextField30.getText().equals("")) {
/* 3880 */       this.jButton23.setText("Guardar");
/* 3881 */       this.jButton24.setVisible(false);
/* 3882 */       limpiar4();
/* 3883 */       this.jDialog5.setVisible(true);
/*      */     } else {
/*      */       
/* 3886 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de SEMARNAT\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 3887 */       if (resp == 0) {
/* 3888 */         cargarFormulario3();
/* 3889 */         this.jButton23.setText("Modificar");
/* 3890 */         this.jButton24.setVisible(true);
/* 3891 */         this.jDialog5.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton7ActionPerformed(ActionEvent evt) {
/* 3897 */     String camp = this.jTextField31.getText();
/* 3898 */     if (!camp.equals("")) {
/* 3899 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de SCT\n¿Deseas quitar esa información?", "Quitar Permiso SCT", 0, 3, this.PREG);
/* 3900 */       if (resp == 0) {
/* 3901 */         this.jRadioButton7.setSelected(true);
/* 3902 */         this.jTextField31.setText("");
/*      */       } else {
/*      */         
/* 3905 */         this.jRadioButton8.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton8ActionPerformed(ActionEvent evt) {
/* 3911 */     if (this.jTextField31.getText().equals("")) {
/* 3912 */       this.jButton27.setText("Guardar");
/* 3913 */       this.jButton28.setVisible(false);
/* 3914 */       limpiar5();
/* 3915 */       this.jDialog6.setVisible(true);
/*      */     } else {
/*      */       
/* 3918 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de SCT\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 3919 */       if (resp == 0) {
/* 3920 */         cargarFormulario4();
/* 3921 */         this.jButton27.setText("Modificar");
/* 3922 */         this.jButton28.setVisible(true);
/* 3923 */         this.jDialog6.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton17ActionPerformed(ActionEvent evt) {
/* 3929 */     String camp = this.jTextField50.getText();
/* 3930 */     if (!camp.equals("")) {
/* 3931 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca del permiso de Sedere\n¿Deseas quitar esa información?", "Quitar Permiso Sedere", 0, 3, this.PREG);
/* 3932 */       if (resp == 0) {
/* 3933 */         this.jRadioButton17.setSelected(true);
/* 3934 */         this.jTextField50.setText("");
/*      */       } else {
/*      */         
/* 3937 */         this.jRadioButton18.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton18ActionPerformed(ActionEvent evt) {
/* 3943 */     if (this.jTextField50.getText().equals("")) {
/* 3944 */       this.jButton31.setText("Guardar");
/* 3945 */       this.jButton32.setVisible(false);
/* 3946 */       limpiar6();
/* 3947 */       this.jDialog7.setVisible(true);
/*      */     } else {
/*      */       
/* 3950 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de Sedere\n¿Deseas modificar algunos de éstos datos?", "Modificar datos", 0, 3, this.PREG);
/* 3951 */       if (resp == 0) {
/* 3952 */         cargarFormulario5();
/* 3953 */         this.jButton31.setText("Modificar");
/* 3954 */         this.jButton32.setVisible(true);
/* 3955 */         this.jDialog7.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 3961 */     String camp = this.jTextField32.getText();
/* 3962 */     if (!camp.equals("")) {
/* 3963 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza\n¿Deseas quitar esa información?", "Quitar Seguro Vehicular", 0, 3, this.PREG);
/* 3964 */       if (resp == 0) {
/* 3965 */         this.jRadioButton4.setSelected(true);
/* 3966 */         this.jTextField32.setText("");
/*      */       } else {
/*      */         
/* 3969 */         this.jRadioButton5.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 3975 */     if (this.jTextField32.getText().equals("")) {
/* 3976 */       this.jButton13.setText("Guardar");
/* 3977 */       this.jButton14.setVisible(false);
/* 3978 */       limpiar2();
/* 3979 */       this.jDialog2.setVisible(true);
/*      */     } else {
/*      */       
/* 3982 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza vehicular\n¿Deseas modificar algunos de éstos datos?", "Modificar Seguro Vehicular", 0, 3, this.PREG);
/* 3983 */       if (resp == 0) {
/* 3984 */         cargarFormulario1();
/* 3985 */         this.jButton13.setText("Modificar");
/* 3986 */         this.jButton14.setVisible(true);
/* 3987 */         this.jDialog2.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton10ActionPerformed(ActionEvent evt) {
/* 3993 */     String camp = this.jTextField33.getText();
/* 3994 */     if (!camp.equals("")) {
/* 3995 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza\n¿Deseas quitar esa información?", "Quitar Seguro Vehicular", 0, 3, this.PREG);
/* 3996 */       if (resp == 0) {
/* 3997 */         this.jRadioButton10.setSelected(true);
/* 3998 */         this.jTextField33.setText("");
/*      */       } else {
/*      */         
/* 4001 */         this.jRadioButton11.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton11ActionPerformed(ActionEvent evt) {
/* 4007 */     if (this.jTextField33.getText().equals("")) {
/* 4008 */       this.jButton19.setText("Guardar");
/* 4009 */       this.jButton20.setVisible(false);
/* 4010 */       limpiar3();
/* 4011 */       this.jDialog4.setVisible(true);
/*      */     } else {
/*      */       
/* 4014 */       int resp = JOptionPane.showConfirmDialog(this.padre, "Ya has asignado información acerca de la póliza ecológica\n¿Deseas modificar algunos de éstos datos?", "Modificar Póliza Ecológica", 0, 3, this.PREG);
/* 4015 */       if (resp == 0) {
/* 4016 */         cargarFormulario2();
/* 4017 */         this.jButton19.setText("Modificar");
/* 4018 */         this.jButton20.setVisible(true);
/* 4019 */         this.jDialog4.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void colorear() {
/* 4024 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4026 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4029 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 4032 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4034 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4037 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 4040 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4042 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4045 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 4048 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4050 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4053 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 4056 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4058 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4061 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 4064 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4066 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4069 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 4072 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4074 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4077 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 4080 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4082 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4085 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField10, evt);
/*      */           }
/*      */         });
/*      */     
/* 4089 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4091 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField11, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4094 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 4097 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4099 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField12, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4102 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 4105 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4107 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField14, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4110 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 4113 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4115 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField15, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4118 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 4121 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4123 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField16, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4126 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 4129 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4131 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField17, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4134 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 4137 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4139 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField18, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4142 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 4145 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4147 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField19, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4150 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField19, evt);
/*      */           }
/*      */         });
/* 4153 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4155 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField20, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4158 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField20, evt);
/*      */           }
/*      */         });
/* 4161 */     this.jTextField21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4163 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField21, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4166 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField21, evt);
/*      */           }
/*      */         });
/* 4169 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4171 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField22, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4174 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField22, evt);
/*      */           }
/*      */         });
/* 4177 */     this.jTextField23.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4179 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField23, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4182 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField23, evt);
/*      */           }
/*      */         });
/* 4185 */     this.jTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4187 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField24, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4190 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField24, evt);
/*      */           }
/*      */         });
/* 4193 */     this.jTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4195 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField25, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4198 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField25, evt);
/*      */           }
/*      */         });
/* 4201 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4203 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField26, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4206 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField26, evt);
/*      */           }
/*      */         });
/* 4209 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4211 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField27, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4214 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 4217 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4219 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField28, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4222 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 4225 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4227 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField29, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4230 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 4233 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4235 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextArea1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4238 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 4241 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4243 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4246 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 4249 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4251 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4254 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 4257 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4259 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4262 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 4265 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4267 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4270 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 4273 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4275 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4278 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 4281 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4283 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4286 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 4291 */     this.jTextField34.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4293 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField34, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4296 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField34, evt);
/*      */           }
/*      */         });
/* 4299 */     this.jTextField35.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4301 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField35, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4304 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField35, evt);
/*      */           }
/*      */         });
/* 4307 */     this.jTextField36.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4309 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField36, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4312 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField36, evt);
/*      */           }
/*      */         });
/* 4315 */     this.jTextField37.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4317 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField37, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4320 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField37, evt);
/*      */           }
/*      */         });
/* 4323 */     this.jTextField38.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4325 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField38, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4328 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField38, evt);
/*      */           }
/*      */         });
/* 4331 */     this.jTextField39.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4333 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField39, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4336 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField39, evt);
/*      */           }
/*      */         });
/* 4339 */     this.jTextField40.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4341 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField40, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4344 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField40, evt);
/*      */           }
/*      */         });
/* 4347 */     this.jTextField41.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4349 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField41, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4352 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField41, evt);
/*      */           }
/*      */         });
/* 4355 */     this.jTextField42.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4357 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField42, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4360 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField42, evt);
/*      */           }
/*      */         });
/* 4363 */     this.jTextField43.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4365 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField43, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4368 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField43, evt);
/*      */           }
/*      */         });
/* 4371 */     this.jTextField44.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4373 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField44, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4376 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField44, evt);
/*      */           }
/*      */         });
/* 4379 */     this.jTextField45.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4381 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField45, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4384 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField45, evt);
/*      */           }
/*      */         });
/* 4387 */     this.jTextField46.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4389 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField46, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4392 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField46, evt);
/*      */           }
/*      */         });
/* 4395 */     this.jTextField47.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4397 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField47, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4400 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField47, evt);
/*      */           }
/*      */         });
/* 4403 */     this.jTextField48.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4405 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField48, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4408 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField48, evt);
/*      */           }
/*      */         });
/* 4411 */     this.jTextField49.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4413 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextField49, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4416 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextField49, evt);
/*      */           }
/*      */         });
/* 4419 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4421 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextArea2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4424 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 4427 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4429 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextArea3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4432 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 4435 */     this.jTextArea4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4437 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextArea4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4440 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextArea4, evt);
/*      */           }
/*      */         });
/* 4443 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4445 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jTextArea5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4448 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 4451 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4453 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jComboBox6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4456 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 4459 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4461 */             CajaAgregar.this.jTextGanado(CajaAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4464 */             CajaAgregar.this.jTextPerdido(CajaAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4469 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4472 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void limpiar() {
/* 4475 */     if (this.jButton1.getText().equals("Guardar")) {
/* 4476 */       this.jTextField1.setText("");
/*      */     }
/* 4478 */     this.jTextField2.setText("");
/* 4479 */     this.jTextField4.setText("");
/* 4480 */     this.jTextField6.setText("");
/* 4481 */     this.jTextField7.setText("");
/* 4482 */     this.jTextField9.setText("");
/* 4483 */     this.jTextField10.setText("");
/* 4484 */     this.jTextField11.setText("");
/* 4485 */     this.jTextField30.setText("");
/* 4486 */     this.jTextField31.setText("");
/* 4487 */     this.jTextField50.setText("");
/* 4488 */     this.jTextField32.setText("");
/* 4489 */     this.jTextField33.setText("");
/* 4490 */     this.jRadioButton1.setSelected(true);
/* 4491 */     this.jRadioButton4.setSelected(true);
/* 4492 */     this.jRadioButton7.setSelected(true);
/* 4493 */     this.jRadioButton10.setSelected(true);
/* 4494 */     this.jDateChooser1.setDate(this.fechaActual);
/* 4495 */     this.jComboBox1.setSelectedIndex(0);
/* 4496 */     this.jComboBox2.setSelectedIndex(0);
/* 4497 */     this.jComboBox3.setSelectedIndex(0);
/* 4498 */     this.jComboBox5.setSelectedIndex(0);
/* 4499 */     this.jComboBox7.setSelectedIndex(0);
/* 4500 */     this.datos.eliminar();
/*      */   }
/*      */   public void limpiar2() {
/* 4503 */     this.jTextField14.setText("");
/* 4504 */     this.jTextField15.setText("");
/* 4505 */     this.jTextField16.setText("");
/* 4506 */     this.jTextField17.setText("");
/* 4507 */     this.jTextField18.setText("");
/* 4508 */     this.jTextField19.setText("");
/* 4509 */     this.jTextField20.setText("");
/* 4510 */     this.jTextField21.setText("");
/* 4511 */     this.jTextField22.setText("");
/* 4512 */     this.jTextField23.setText("");
/* 4513 */     this.jTextField24.setText("");
/* 4514 */     this.jTextField25.setText("");
/* 4515 */     this.jTextField26.setText("");
/* 4516 */     this.jTextField27.setText("");
/* 4517 */     this.jTextField28.setText("");
/* 4518 */     this.jTextField29.setText("");
/* 4519 */     this.jTextArea1.setText("");
/* 4520 */     this.jDateChooser2.setDate(this.fechaActual);
/* 4521 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4522 */     this.jComboBox4.setSelectedIndex(0);
/* 4523 */     this.jFormattedTextField1.setValue("");
/*      */   }
/*      */   public void limpiar3() {
/* 4526 */     this.jTextField34.setText("");
/* 4527 */     this.jTextField35.setText("");
/* 4528 */     this.jTextField36.setText("");
/* 4529 */     this.jTextField37.setText("");
/* 4530 */     this.jTextField38.setText("");
/* 4531 */     this.jTextField39.setText("");
/* 4532 */     this.jTextField40.setText("");
/* 4533 */     this.jTextField41.setText("");
/* 4534 */     this.jTextField42.setText("");
/* 4535 */     this.jTextField43.setText("");
/* 4536 */     this.jTextField44.setText("");
/* 4537 */     this.jTextField45.setText("");
/* 4538 */     this.jTextField46.setText("");
/* 4539 */     this.jTextField47.setText("");
/* 4540 */     this.jTextField48.setText("");
/* 4541 */     this.jTextField49.setText("");
/* 4542 */     this.jTextArea2.setText("");
/* 4543 */     this.jDateChooser3.setDate(this.fechaActual);
/* 4544 */     this.jDateChooser6.setDate(this.fechaActual);
/* 4545 */     this.jComboBox6.setSelectedIndex(0);
/* 4546 */     this.jFormattedTextField2.setValue("");
/*      */   }
/*      */   public void limpiar4() {
/* 4549 */     this.jRadioButton13.setSelected(true);
/* 4550 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4551 */     this.jDateChooser7.setDate(this.fechaActual);
/* 4552 */     this.jTextArea3.setText("");
/*      */   }
/*      */   public void limpiar5() {
/* 4555 */     this.jRadioButton15.setSelected(true);
/* 4556 */     this.jDateChooser8.setDate(this.fechaActual);
/* 4557 */     this.jDateChooser9.setDate(this.fechaActual);
/* 4558 */     this.jTextArea4.setText("");
/*      */   }
/*      */   public void limpiar6() {
/* 4561 */     this.jRadioButton20.setSelected(true);
/* 4562 */     this.jDateChooser10.setDate(this.fechaActual);
/* 4563 */     this.jDateChooser11.setDate(this.fechaActual);
/* 4564 */     this.jTextArea5.setText("");
/*      */   }
/*      */   public void caja(String usua, String num) {
/* 4567 */     this.USUARIO = usua;
/* 4568 */     this.panel.setViewportView(this);
/* 4569 */     this.id = num;
/* 4570 */     this.jLabel14.setVisible(false);
/* 4571 */     llenarCombo2();
/* 4572 */     llenarCombo3();
/* 4573 */     if (this.fichas != null) {
/* 4574 */       cargarFormulario();
/* 4575 */       this.fichas.addTab("Modificar Remolques - [Clave: " + this.id + "]", this.panel);
/* 4576 */       this.jButton1.setText("Modificar");
/* 4577 */       this.jLabel1.setText("Modificar Remolques");
/* 4578 */       this.jButton3.setVisible(true);
/* 4579 */       this.jButton4.setVisible(true);
/*      */     } else {
/*      */       
/* 4582 */       this.jButton3.setVisible(false);
/* 4583 */       this.jButton4.setVisible(false);
/* 4584 */       this.jLabel1.setText("Agregar Remolques");
/*      */     } 
/*      */   }
/*      */   public void consultar1() {
/* 4588 */     this.encontrado = this.con.consultar("count(marca)", "marca", "");
/* 4589 */     int totreg = Integer.parseInt(this.con.Campo);
/* 4590 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 4591 */           .buscarReg(2, totreg, "id_marca,marca", "marca", ""), (Object[])new String[] { "Clave", "Marca", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4596 */           Class[] types = new Class[] { Object.class, Object.class, Boolean.class };
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4600 */             return this.types[columnIndex];
/*      */           }
/* 4602 */           boolean[] canEdit = new boolean[] { false, false, true };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4606 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4609 */     this.jTable1.setShowVerticalLines(false);
/* 4610 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 4611 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4612 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4613 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
/* 4614 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(30);
/* 4615 */     this.jTable1.setSelectionMode(0);
/* 4616 */     this.jTable1.setAutoCreateRowSorter(true);
/* 4617 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 4618 */     this.jTable1.getColumnModel().moveColumn(2, 0);
/*      */   }
/*      */   public void llenarCombo2() {
/* 4621 */     this.con.consultar("count(marca)", "marca", "");
/* 4622 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 4623 */     this.jComboBox2.removeAllItems();
/* 4624 */     this.jComboBox2.addItem("Selecciona uno...");
/* 4625 */     for (int i = 0; i < depa.length; i++)
/* 4626 */       this.jComboBox2.addItem(depa[i]); 
/*      */   }
/*      */   
/*      */   public void llenarCombo3() {
/* 4630 */     this.jComboBox7.removeAllItems();
/* 4631 */     int año = this.fechaActual.getYear();
/* 4632 */     año += 1901;
/* 4633 */     this.jComboBox7.addItem("Selecciona uno...");
/* 4634 */     for (int i = año; i >= 1990; i--)
/* 4635 */       this.jComboBox7.addItem("" + i); 
/*      */   }
/*      */   
/*      */   public void guardarMarcas() {
/* 4639 */     this.error.pasarModal(true);
/* 4640 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4641 */     String marca = this.jTextField12.getText().toUpperCase();
/* 4642 */     if (marca.equals("")) {
/* 4643 */       this.error.cargarError(this.jTextField12, "050");
/*      */     }
/* 4645 */     else if (!this.val.validarApostrofe(this.jTextField12, marca, "020")) {
/* 4646 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas crear una nueva marca de vehículos?", "Crear Marca", 0, 1, this.PREG);
/* 4647 */       if (res == 0) {
/* 4648 */         this.con.insertar("insert into marca(marca)values('" + marca + "')");
/* 4649 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó una nueva marca de carro.','\nMarca: " + this.jTextField12.getText() + "')");
/* 4650 */         llenarCombo2();
/* 4651 */         consultar1();
/* 4652 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void cargarFormulario() {
/* 4657 */     this.jButton3.setVisible(true);
/* 4658 */     this.jButton4.setVisible(true);
/* 4659 */     this.jLabel14.setVisible(true);
/* 4660 */     this.jComboBox5.setEnabled(true);
/* 4661 */     this.jTextField1.setEnabled(false);
/* 4662 */     this.jButton1.setMnemonic('M');
/* 4663 */     String[] reg = this.con.regresaReg("Modelo,color,No_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,tipo,id_marca", "remolque", "where num_rem = " + this.id, 13);
/* 4664 */     this.inf = reg;
/* 4665 */     this.jTextField1.setText(this.id);
/* 4666 */     this.jTextField2.setText(reg[1]);
/* 4667 */     this.jComboBox1.setSelectedItem(reg[11]);
/* 4668 */     this.jComboBox5.setSelectedItem(reg[9]);
/* 4669 */     this.con.consultar("marca", "marca", "where id_marca=" + reg[12]);
/* 4670 */     this.jComboBox2.setSelectedItem(this.con.Campo);
/* 4671 */     this.jComboBox7.setSelectedItem(reg[0]);
/* 4672 */     this.jComboBox3.setSelectedItem(reg[4]);
/* 4673 */     this.jTextField4.setText(reg[2]);
/*      */     
/* 4675 */     String año = reg[10].substring(0, 4);
/* 4676 */     String mes = reg[10].substring(5, 7);
/* 4677 */     String dia = reg[10].substring(8, 10);
/* 4678 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4679 */     String strFecha = año + "-" + año + "-" + mes;
/* 4680 */     Date fecha = null;
/*      */     try {
/* 4682 */       fecha = formatoDelTexto.parse(strFecha);
/* 4683 */       this.jDateChooser1.setDate(fecha);
/*      */     }
/* 4685 */     catch (ParseException ex) {
/* 4686 */       ex.printStackTrace();
/*      */     } 
/* 4688 */     if (reg[3].equals("0")) {
/* 4689 */       reg[3] = "";
/*      */     }
/* 4691 */     this.jTextField6.setText(reg[3]);
/*      */     
/* 4693 */     if (reg[6].equals("0")) {
/* 4694 */       reg[6] = "";
/*      */     }
/* 4696 */     if (reg[7].equals("0")) {
/* 4697 */       reg[7] = "";
/*      */     }
/* 4699 */     this.jTextField7.setText(reg[5]);
/* 4700 */     this.jTextField9.setText(reg[6]);
/* 4701 */     this.jTextField10.setText(reg[7]);
/* 4702 */     this.jTextField11.setText(reg[8]);
/* 4703 */     this.jRadioButton1.setEnabled(false);
/* 4704 */     this.jRadioButton2.setEnabled(false);
/* 4705 */     this.jRadioButton7.setEnabled(false);
/* 4706 */     this.jRadioButton8.setEnabled(false);
/* 4707 */     this.jRadioButton17.setEnabled(false);
/* 4708 */     this.jRadioButton18.setEnabled(false);
/*      */     
/* 4710 */     this.jRadioButton4.setEnabled(false);
/* 4711 */     this.jRadioButton5.setEnabled(false);
/* 4712 */     this.jRadioButton10.setEnabled(false);
/* 4713 */     this.jRadioButton11.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void cargarFormulario1() {
/* 4717 */     String id = this.jTextField32.getText();
/* 4718 */     String[] reg = this.con.regresaReg("nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo", "vehicular_carro", "where num_seg = " + id, 21);
/*      */     
/* 4720 */     this.jTextField14.setText(reg[0]);
/* 4721 */     this.jTextField15.setText(reg[1]);
/* 4722 */     this.jTextField16.setText(reg[2]);
/*      */     
/* 4724 */     this.jTextField17.setText(reg[3]);
/* 4725 */     this.jTextField18.setText(reg[4]);
/* 4726 */     this.jTextField19.setText(reg[5]);
/*      */     
/* 4728 */     this.jTextField20.setText(reg[6]);
/* 4729 */     this.jTextField21.setText(reg[7]);
/* 4730 */     String año = reg[8].substring(0, 4);
/* 4731 */     String mes = reg[8].substring(5, 7);
/* 4732 */     String dia = reg[8].substring(8, 10);
/* 4733 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4734 */     String strFecha = año + "-" + año + "-" + mes;
/* 4735 */     Date fecha = null;
/*      */     try {
/* 4737 */       fecha = formatoDelTexto.parse(strFecha);
/* 4738 */       this.jDateChooser2.setDate(fecha);
/*      */     }
/* 4740 */     catch (ParseException ex) {
/* 4741 */       ex.printStackTrace();
/*      */     } 
/* 4743 */     año = reg[9].substring(0, 4);
/* 4744 */     mes = reg[9].substring(5, 7);
/* 4745 */     dia = reg[9].substring(8, 10);
/* 4746 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4747 */     strFecha = año + "-" + año + "-" + mes;
/* 4748 */     fecha = null;
/*      */     try {
/* 4750 */       fecha = formatoDelTexto.parse(strFecha);
/* 4751 */       this.jDateChooser5.setDate(fecha);
/*      */     }
/* 4753 */     catch (ParseException ex) {
/* 4754 */       ex.printStackTrace();
/*      */     } 
/* 4756 */     this.jTextField22.setText(reg[10]);
/* 4757 */     this.jTextArea1.setText(reg[11]);
/*      */     
/* 4759 */     this.jTextField23.setText(reg[12]);
/* 4760 */     this.jTextField24.setText(reg[13]);
/* 4761 */     this.jTextField25.setText(reg[14]);
/* 4762 */     this.jTextField26.setText(reg[15]);
/* 4763 */     this.jTextField27.setText(reg[16]);
/* 4764 */     this.jTextField28.setText(reg[17]);
/* 4765 */     this.jTextField29.setText(reg[18]);
/* 4766 */     this.jFormattedTextField1.setValue(reg[19]);
/*      */     
/* 4768 */     if (!reg[20].equals("33")) {
/* 4769 */       this.jComboBox4.setSelectedIndex(Integer.parseInt(reg[20]) + 1);
/*      */     }
/* 4771 */     String estado = "33";
/* 4772 */     String tel1 = this.jFormattedTextField1.getText();
/*      */   }
/*      */   public void cargarFormulario2() {
/* 4775 */     String id = this.jTextField33.getText();
/* 4776 */     String[] reg = this.con.regresaReg("nombre1,ap_pat1,ap_mat1,nombre2,ap_pat2,ap_mat2,tipo_seg,costo,fecha_inicio,fecha_vigen,gracia,cobertura,nombre3,nombre4,calle,num,col,ciudad,cp,telefono,id_edo", "ecologico", "where num_eco = " + id, 21);
/*      */     
/* 4778 */     this.jTextField34.setText(reg[0]);
/* 4779 */     this.jTextField35.setText(reg[1]);
/* 4780 */     this.jTextField36.setText(reg[2]);
/*      */     
/* 4782 */     this.jTextField37.setText(reg[3]);
/* 4783 */     this.jTextField38.setText(reg[4]);
/* 4784 */     this.jTextField39.setText(reg[5]);
/*      */     
/* 4786 */     this.jTextField40.setText(reg[6]);
/* 4787 */     this.jTextField41.setText(reg[7]);
/* 4788 */     String año = reg[8].substring(0, 4);
/* 4789 */     String mes = reg[8].substring(5, 7);
/* 4790 */     String dia = reg[8].substring(8, 10);
/* 4791 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4792 */     String strFecha = año + "-" + año + "-" + mes;
/* 4793 */     Date fecha = null;
/*      */     try {
/* 4795 */       fecha = formatoDelTexto.parse(strFecha);
/* 4796 */       this.jDateChooser3.setDate(fecha);
/*      */     }
/* 4798 */     catch (ParseException ex) {
/* 4799 */       ex.printStackTrace();
/*      */     } 
/* 4801 */     año = reg[9].substring(0, 4);
/* 4802 */     mes = reg[9].substring(5, 7);
/* 4803 */     dia = reg[9].substring(8, 10);
/* 4804 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4805 */     strFecha = año + "-" + año + "-" + mes;
/* 4806 */     fecha = null;
/*      */     try {
/* 4808 */       fecha = formatoDelTexto.parse(strFecha);
/* 4809 */       this.jDateChooser6.setDate(fecha);
/*      */     }
/* 4811 */     catch (ParseException ex) {
/* 4812 */       ex.printStackTrace();
/*      */     } 
/* 4814 */     this.jTextField42.setText(reg[10]);
/* 4815 */     this.jTextArea2.setText(reg[11]);
/*      */     
/* 4817 */     this.jTextField43.setText(reg[12]);
/* 4818 */     this.jTextField44.setText(reg[13]);
/* 4819 */     this.jTextField45.setText(reg[14]);
/* 4820 */     this.jTextField46.setText(reg[15]);
/* 4821 */     this.jTextField47.setText(reg[16]);
/* 4822 */     this.jTextField48.setText(reg[17]);
/* 4823 */     this.jTextField49.setText(reg[18]);
/* 4824 */     this.jFormattedTextField2.setValue(reg[19]);
/*      */     
/* 4826 */     if (!reg[20].equals("33")) {
/* 4827 */       this.jComboBox4.setSelectedIndex(Integer.parseInt(reg[20]) + 1);
/*      */     }
/* 4829 */     String estado = "33";
/* 4830 */     String tel1 = this.jFormattedTextField1.getText();
/*      */   }
/*      */   public void cargarFormulario3() {
/* 4833 */     String id = this.jTextField30.getText();
/* 4834 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "semarnat", "where num_sem = " + id, 4);
/* 4835 */     if (reg[0].equals("Alta")) {
/* 4836 */       this.jRadioButton13.setSelected(true);
/*      */     } else {
/*      */       
/* 4839 */       this.jRadioButton14.setSelected(true);
/*      */     } 
/* 4841 */     String año = reg[1].substring(0, 4);
/* 4842 */     String mes = reg[1].substring(5, 7);
/* 4843 */     String dia = reg[1].substring(8, 10);
/* 4844 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4845 */     String strFecha = año + "-" + año + "-" + mes;
/* 4846 */     Date fecha = null;
/*      */     try {
/* 4848 */       fecha = formatoDelTexto.parse(strFecha);
/* 4849 */       this.jDateChooser4.setDate(fecha);
/*      */     }
/* 4851 */     catch (ParseException ex) {
/* 4852 */       ex.printStackTrace();
/*      */     } 
/* 4854 */     año = reg[2].substring(0, 4);
/* 4855 */     mes = reg[2].substring(5, 7);
/* 4856 */     dia = reg[2].substring(8, 10);
/* 4857 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4858 */     strFecha = año + "-" + año + "-" + mes;
/* 4859 */     fecha = null;
/*      */     try {
/* 4861 */       fecha = formatoDelTexto.parse(strFecha);
/* 4862 */       this.jDateChooser7.setDate(fecha);
/*      */     }
/* 4864 */     catch (ParseException ex) {
/* 4865 */       ex.printStackTrace();
/*      */     } 
/* 4867 */     this.jTextArea3.setText(reg[3]);
/*      */   }
/*      */   public void cargarFormulario4() {
/* 4870 */     String id = this.jTextField31.getText();
/* 4871 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "sct", "where num_sct = " + id, 4);
/* 4872 */     if (reg[0].equals("Alta")) {
/* 4873 */       this.jRadioButton15.setSelected(true);
/*      */     } else {
/*      */       
/* 4876 */       this.jRadioButton16.setSelected(true);
/*      */     } 
/* 4878 */     String año = reg[1].substring(0, 4);
/* 4879 */     String mes = reg[1].substring(5, 7);
/* 4880 */     String dia = reg[1].substring(8, 10);
/* 4881 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4882 */     String strFecha = año + "-" + año + "-" + mes;
/* 4883 */     Date fecha = null;
/*      */     try {
/* 4885 */       fecha = formatoDelTexto.parse(strFecha);
/* 4886 */       this.jDateChooser8.setDate(fecha);
/*      */     }
/* 4888 */     catch (ParseException ex) {
/* 4889 */       ex.printStackTrace();
/*      */     } 
/* 4891 */     año = reg[2].substring(0, 4);
/* 4892 */     mes = reg[2].substring(5, 7);
/* 4893 */     dia = reg[2].substring(8, 10);
/* 4894 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4895 */     strFecha = año + "-" + año + "-" + mes;
/* 4896 */     fecha = null;
/*      */     try {
/* 4898 */       fecha = formatoDelTexto.parse(strFecha);
/* 4899 */       this.jDateChooser9.setDate(fecha);
/*      */     }
/* 4901 */     catch (ParseException ex) {
/* 4902 */       ex.printStackTrace();
/*      */     } 
/* 4904 */     this.jTextArea4.setText(reg[3]);
/*      */   }
/*      */   public void cargarFormulario5() {
/* 4907 */     String id = this.jTextField50.getText();
/* 4908 */     String[] reg = this.con.regresaReg("tipo,fecha_inicio,fecha_vigen,comen", "sedere", "where num_sed = " + id, 4);
/* 4909 */     if (reg[0].equals("Alta")) {
/* 4910 */       this.jRadioButton20.setSelected(true);
/*      */     } else {
/*      */       
/* 4913 */       this.jRadioButton20.setSelected(true);
/*      */     } 
/* 4915 */     String año = reg[1].substring(0, 4);
/* 4916 */     String mes = reg[1].substring(5, 7);
/* 4917 */     String dia = reg[1].substring(8, 10);
/* 4918 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4919 */     String strFecha = año + "-" + año + "-" + mes;
/* 4920 */     Date fecha = null;
/*      */     try {
/* 4922 */       fecha = formatoDelTexto.parse(strFecha);
/* 4923 */       this.jDateChooser10.setDate(fecha);
/*      */     }
/* 4925 */     catch (ParseException ex) {
/* 4926 */       ex.printStackTrace();
/*      */     } 
/* 4928 */     año = reg[2].substring(0, 4);
/* 4929 */     mes = reg[2].substring(5, 7);
/* 4930 */     dia = reg[2].substring(8, 10);
/* 4931 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4932 */     strFecha = año + "-" + año + "-" + mes;
/* 4933 */     fecha = null;
/*      */     try {
/* 4935 */       fecha = formatoDelTexto.parse(strFecha);
/* 4936 */       this.jDateChooser11.setDate(fecha);
/*      */     }
/* 4938 */     catch (ParseException ex) {
/* 4939 */       ex.printStackTrace();
/*      */     } 
/* 4941 */     this.jTextArea5.setText(reg[3]);
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
/* 4962 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca");
/* 4963 */     int totreg = Integer.parseInt(this.con.Campo);
/* 4964 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca");
/* 4965 */     String tot = this.con.Campo;
/* 4966 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 4967 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 4968 */           .buscarReg(19, totreg, "num_rem,modelo,color,no_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipo,remolque.num_sem,remolque.NUM_sct,remolque.num_sed,remolque.num_seg,remolque.num_eco", "remolque,marca", "where remolque.id_marca = marca.id_marca"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4973 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4977 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4980 */     this.jTable3.setShowVerticalLines(false);
/* 4981 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 4982 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 4983 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 4984 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 4985 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 4986 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/*      */ 
/*      */     
/* 4989 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 4990 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 4991 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 4992 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 4993 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(45);
/* 4994 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(45);
/* 4995 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 4996 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 4997 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(65);
/* 4998 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(65);
/* 4999 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(85);
/* 5000 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(85);
/*      */     
/* 5002 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(65);
/* 5003 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(65);
/* 5004 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 5005 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(65);
/* 5006 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 5007 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 5008 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 5009 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 5010 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(75);
/* 5011 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(75);
/* 5012 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 5013 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/*      */     
/* 5015 */     this.jButton5.setEnabled(false);
/* 5016 */     this.jTable3.setSelectionMode(0);
/* 5017 */     this.jTable3.setAutoCreateRowSorter(true);
/* 5018 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     int i;
/* 5020 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5021 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 14));
/* 5022 */       if (valor.equals("0")) {
/* 5023 */         this.jTable3.setValueAt("No", i, 14);
/*      */       } else {
/*      */         
/* 5026 */         this.jTable3.setValueAt("Si", i, 14);
/*      */       } 
/*      */     } 
/*      */     
/* 5030 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5031 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 5032 */       if (valor.equals("0")) {
/* 5033 */         this.jTable3.setValueAt("No", i, 15);
/*      */       } else {
/*      */         
/* 5036 */         this.jTable3.setValueAt("Si", i, 15);
/*      */       } 
/*      */     } 
/*      */     
/* 5040 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5041 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 5042 */       if (valor.equals("0")) {
/* 5043 */         this.jTable3.setValueAt("No", i, 16);
/*      */       } else {
/*      */         
/* 5046 */         this.jTable3.setValueAt("Si", i, 16);
/*      */       } 
/*      */     } 
/*      */     
/* 5050 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5051 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 5052 */       if (valor.equals("0")) {
/* 5053 */         this.jTable3.setValueAt("No", i, 17);
/*      */       } else {
/*      */         
/* 5056 */         this.jTable3.setValueAt("Si", i, 17);
/*      */       } 
/*      */     } 
/*      */     
/* 5060 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 5061 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 5062 */       if (valor.equals("0")) {
/* 5063 */         this.jTable3.setValueAt("No", i, 18);
/*      */       } else {
/*      */         
/* 5066 */         this.jTable3.setValueAt("Si", i, 18);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CajaAgregar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */