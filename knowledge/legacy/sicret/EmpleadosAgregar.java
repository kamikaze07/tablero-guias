/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import principal.MaterialButton;
/*      */ 
/*      */ public class EmpleadosAgregar extends JPanel {
/*   37 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   38 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   39 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   40 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   41 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   42 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   43 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   44 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   45 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   49 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   50 */   Date fechaActual = new Date();
/*   51 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   52 */   String USUARIO = "";
/*   53 */   Validaciones val = new Validaciones();
/*   54 */   Consultas con = new Consultas();
/*   55 */   Errores error = new Errores(false);
/*      */   String id;
/*      */   String[] inf;
/*      */   JTabbedPane fichas;
/*      */   int INDICE;
/*      */   JTable jTable3;
/*      */   JFrame padre;
/*   62 */   cargarDatos datos = new cargarDatos("EmpleadoAgregar");
/*      */   Color fondo;
/*      */   boolean encontrado = false;
/*   65 */   Date fechaInicio = null;
/*   66 */   String FOTO = "";
/*   67 */   int PANEL = 0;
/*   68 */   fotoIndividual ind = null;
/*   69 */   String[] CONFIG = null;
/*   70 */   String VIGENCIA = "";
/*   71 */   String CLAVEOP = "";
/*   72 */   fotoCredencial fotoC = null;
/*   73 */   String CLAVEDEPA = "";
/*   74 */   String NOMBRECOMPLETO = "";
/*   75 */   String ACTIVIDADES = "";
/*   76 */   String PRIVILEGIOS = "";
/*   77 */   MensajePop mensajeTry = null;
/*      */   PlaceHolder holder;
/*   79 */   SColores lc = new SColores();
/*   80 */   int xx = 0;
/*   81 */   int xy = 0; Map<String, String> CAMPOSGENERALES; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private JButton jButton12; private JButton jButton13; private JButton jButton19; private JButton jButton20; private JButton jButton21; private JButton jButton4; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JDateChooser jDateChooser1; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser8; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField8; private JLabel jLabel1; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel151; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel3; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69;
/*      */   private JLabel jLabel70;
/*      */   
/*      */   public EmpleadosAgregar(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES) {
/*   85 */     this.mensajeTry = mensajeTry;
/*   86 */     this.USUARIO = usua;
/*   87 */     this.padre = padre;
/*   88 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   89 */     this.id = num;
/*   90 */     this.fichas = fichas;
/*   91 */     this.jTable3 = Tabla;
/*   92 */     String año1 = "1990";
/*   93 */     String mes1 = "01";
/*   94 */     String dia1 = "01";
/*   95 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*   96 */     String strFecha = año1 + "-" + año1 + "-" + mes1;
/*      */     try {
/*   98 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   99 */     } catch (ParseException ex) {
/*  100 */       ex.printStackTrace();
/*      */     } 
/*      */     try {
/*  103 */       this.formaTel = new MaskFormatter("###-###-####");
/*  104 */       this.formaTel2 = new MaskFormatter("###-###-####");
/*  105 */     } catch (Exception exception) {}
/*      */     
/*  107 */     this.formaTel.setPlaceholderCharacter('_');
/*  108 */     this.formaTel2.setPlaceholderCharacter('_');
/*  109 */     initComponents();
/*  110 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  111 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  112 */     this.jLabel86.setCursor(micursor);
/*  113 */     this.jLabel136.setCursor(micursor);
/*      */     
/*  115 */     panelito.setViewportView(this);
/*  116 */     this.panel = panelito;
/*  117 */     colorear();
/*  118 */     this.jLabel9.setVisible(false);
/*  119 */     llenarCombo();
/*  120 */     crearInd();
/*  121 */     this.materialButton21.setVisible(false);
/*  122 */     this.materialButton20.setVisible(false);
/*      */     
/*  124 */     int w = this.tama.width;
/*  125 */     int h = this.tama.height;
/*  126 */     int rw = (w - 390) / 2;
/*  127 */     int rh = (h - 510) / 2;
/*  128 */     this.jDialog1.setVisible(false);
/*  129 */     this.jDialog1.setLocation(rw, rh);
/*  130 */     this.jDialog1.setSize(420, 500);
/*      */     
/*  132 */     rw = (w - 250) / 2;
/*  133 */     rh = (h - 365) / 2;
/*  134 */     this.jDialog2.setLocation(rw, rh);
/*  135 */     this.jDialog2.setSize(250, 365);
/*  136 */     this.jDialog2.setVisible(false);
/*  137 */     this.jDialog2.setResizable(false);
/*      */     
/*  139 */     rw = (w - 378) / 2;
/*  140 */     rh = (h - 165) / 2;
/*  141 */     this.jDialog3.setLocation(rw, rh);
/*  142 */     this.jDialog3.setSize(378, 165);
/*  143 */     this.jDialog3.setVisible(false);
/*  144 */     this.jDialog3.setResizable(false);
/*      */     
/*  146 */     rw = (w - 443) / 2;
/*  147 */     rh = (h - 615) / 2;
/*  148 */     this.jDialog4.setLocation(rw, rh);
/*  149 */     this.jDialog4.setSize(443, 640);
/*  150 */     this.jDialog4.setVisible(false);
/*  151 */     this.jDialog4.setResizable(false);
/*      */     
/*  153 */     rw = (w - 475) / 2;
/*  154 */     rh = (h - 690) / 2;
/*  155 */     this.jDialog5.setLocation(rw, rh);
/*  156 */     this.jDialog5.setSize(475, 690);
/*  157 */     this.jDialog5.setVisible(false);
/*  158 */     this.jDialog5.setResizable(false);
/*      */     
/*  160 */     rw = (w - 765) / 2;
/*  161 */     rh = (h - 575) / 2;
/*  162 */     this.jDialog9.setLocation(rw, rh);
/*  163 */     this.jDialog9.setSize(765, 575);
/*  164 */     this.jDialog9.setVisible(false);
/*  165 */     this.jDialog9.setResizable(false);
/*      */     
/*  167 */     consultar1();
/*      */     
/*  169 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  170 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  171 */     this.jDialog1.setCursor(micursor);
/*  172 */     this.jDialog2.setCursor(micursor);
/*  173 */     this.jDialog3.setCursor(micursor);
/*  174 */     this.jDialog4.setCursor(micursor);
/*  175 */     this.jDialog5.setCursor(micursor);
/*  176 */     this.jDialog9.setCursor(micursor);
/*      */     
/*  178 */     this.jDateChooser1.setDate(new Date());
/*  179 */     this.jDateChooser3.setDate(new Date());
/*  180 */     this.jDateChooser4.setDate(new Date());
/*  181 */     this.buttonGroup2.add(this.jRadioButton3);
/*  182 */     this.buttonGroup2.add(this.jRadioButton4);
/*      */     
/*  184 */     this.buttonGroup3.add(this.jRadioButton5);
/*  185 */     this.buttonGroup3.add(this.jRadioButton6);
/*      */     
/*  187 */     this.buttonGroup4.add(this.jRadioButton7);
/*  188 */     this.buttonGroup4.add(this.jRadioButton8);
/*  189 */     this.CONFIG = this.con.regresaReg("fotosEmpleados,directiva,capacitadorQHSE,nombreCapacitador", "configuraciones", "", 4);
/*      */     
/*  191 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  192 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  193 */     editFormat.setGroupingUsed(false);
/*  194 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  195 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  196 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  197 */     enFormat.setAllowsInvalid(true);
/*  198 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  199 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*  200 */     this.jFormattedTextField7.setFormatterFactory(currFactory);
/*  201 */     this.jFormattedTextField8.setFormatterFactory(currFactory);
/*  202 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  203 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*  204 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/*  205 */     this.jFormattedTextField8.setValue(Integer.valueOf(0));
/*      */     
/*  207 */     this.jTabbedPane1.removeAll();
/*  208 */     this.jTabbedPane1.add("Datos Personales", this.jPanel9);
/*  209 */     this.materialButton17.setEnabled(false);
/*      */     
/*  211 */     if (fichas != null) {
/*  212 */       this.jTextField13.setEditable(false);
/*  213 */       this.jLabel9.setVisible(true);
/*  214 */       llenarCombo();
/*  215 */       cargarFormulario();
/*  216 */       this.jTextField13.setText(num);
/*  217 */       fichas.addTab("Modificar Empleados - [Clave: " + this.id + "]", this.panel);
/*  218 */       this.materialButton17.setText("Modificar");
/*  219 */       this.materialButton20.setVisible(true);
/*  220 */       this.materialButton21.setVisible(true);
/*      */     } 
/*  222 */     this.fondo = this.jDateChooser1.getBackground();
/*      */     
/*  224 */     String[] datos = this.con.regresaReg("nombre,ap_pat,ap_mat,priv", "empleados,usuarios", "where clave_emp=num_emp and nombre_usu = '" + this.USUARIO + "'", 4);
/*  225 */     this.NOMBRECOMPLETO = datos[1] + " " + datos[1] + " " + datos[2];
/*      */     
/*  227 */     this.PRIVILEGIOS = datos[3];
/*  228 */     if (datos[3].equals("CAPTURISTA")) {
/*  229 */       this.jFormattedTextField8.setEnabled(false);
/*  230 */       this.jFormattedTextField8.setValue(Integer.valueOf(0));
/*      */     } else {
/*  232 */       this.jFormattedTextField7.setEnabled(true);
/*  233 */       this.jFormattedTextField8.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel9; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JScrollPane jScrollPane13; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JSeparator jSeparator4; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JTabbedPane jTabbedPane1; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField2; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton23; private MaterialButton materialButton24; private MaterialButton materialButton25; private MaterialButton materialButton26; private MaterialButton materialButton27; private MaterialButton materialButton28; private MaterialButton materialButton29; private MaterialButton materialButton30; private MaterialButton materialButton31; private MaterialButton materialButton32; private MaterialButton materialButton33; private MaterialButton materialButton34;
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private void initComponents() {
/*  240 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  241 */     this.jPanel56 = new JPanel();
/*  242 */     this.jPanel57 = new JPanel();
/*  243 */     this.jScrollPane3 = new JScrollPane();
/*  244 */     this.jTextArea2 = new JTextArea();
/*  245 */     this.jLabel3 = new JLabel();
/*  246 */     this.jLabel34 = new JLabel();
/*  247 */     this.jTextField12 = new JTextField();
/*  248 */     this.jLabel32 = new JLabel();
/*  249 */     this.materialButton23 = new MaterialButton();
/*  250 */     this.jPanel58 = new JPanel();
/*  251 */     this.jScrollPane13 = new JScrollPane();
/*  252 */     this.rSTableMetro3 = new RSTableMetro();
/*  253 */     this.materialButton25 = new MaterialButton();
/*  254 */     this.materialButton26 = new MaterialButton();
/*  255 */     this.materialButton24 = new MaterialButton();
/*  256 */     this.buttonGroup1 = new ButtonGroup();
/*  257 */     this.buttonGroup2 = new ButtonGroup();
/*  258 */     this.buttonGroup3 = new ButtonGroup();
/*  259 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  260 */     this.jPanel2 = new JPanel();
/*  261 */     this.jPanel59 = new JPanel();
/*  262 */     this.jLabel69 = new JLabel();
/*  263 */     this.jLabel1 = new JLabel();
/*  264 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  265 */     this.jPanel6 = new JPanel();
/*  266 */     this.jLabel12 = new JLabel();
/*  267 */     this.jSeparator4 = new JSeparator();
/*  268 */     this.jPanel1 = new JPanel();
/*  269 */     this.jRadioButton7 = new JRadioButton();
/*  270 */     this.jRadioButton8 = new JRadioButton();
/*  271 */     this.materialButton27 = new MaterialButton();
/*  272 */     this.materialButton28 = new MaterialButton();
/*  273 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  274 */     this.jPanel14 = new JPanel();
/*  275 */     this.jLabel61 = new JLabel();
/*  276 */     this.jSeparator7 = new JSeparator();
/*  277 */     this.jLabel62 = new JLabel();
/*  278 */     this.jPanel15 = new JPanel();
/*  279 */     this.jLabel13 = new JLabel();
/*  280 */     this.jLabel33 = new JLabel();
/*  281 */     this.jLabel63 = new JLabel();
/*  282 */     this.jLabel78 = new JLabel();
/*  283 */     this.jLabel80 = new JLabel();
/*  284 */     this.jLabel82 = new JLabel();
/*  285 */     this.jLabel84 = new JLabel();
/*  286 */     this.jLabel85 = new JLabel();
/*  287 */     this.jLabel86 = new JLabel();
/*  288 */     this.jPanel16 = new JPanel();
/*  289 */     this.jLabel81 = new JLabel();
/*  290 */     this.jLabel87 = new JLabel();
/*  291 */     this.jPanel19 = new JPanel();
/*  292 */     this.jLabel88 = new JLabel();
/*  293 */     this.jLabel89 = new JLabel();
/*  294 */     this.jLabel64 = new JLabel();
/*  295 */     this.jPanel20 = new JPanel();
/*  296 */     this.jLabel79 = new JLabel();
/*  297 */     this.jLabel90 = new JLabel();
/*  298 */     this.jLabel91 = new JLabel();
/*  299 */     this.jLabel94 = new JLabel();
/*  300 */     this.jLabel95 = new JLabel();
/*  301 */     this.jLabel96 = new JLabel();
/*  302 */     this.jLabel97 = new JLabel();
/*  303 */     this.jLabel99 = new JLabel();
/*  304 */     this.jLabel100 = new JLabel();
/*  305 */     this.jLabel102 = new JLabel();
/*  306 */     this.jLabel103 = new JLabel();
/*  307 */     this.jLabel104 = new JLabel();
/*  308 */     this.jLabel105 = new JLabel();
/*  309 */     this.jLabel92 = new JLabel();
/*  310 */     this.jLabel106 = new JLabel();
/*  311 */     this.materialButton32 = new MaterialButton();
/*  312 */     this.materialButton33 = new MaterialButton();
/*  313 */     this.materialButton34 = new MaterialButton();
/*  314 */     this.jPanel24 = new JPanel();
/*  315 */     this.jLabel119 = new JLabel();
/*  316 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  317 */     this.buttonGroup4 = new ButtonGroup();
/*  318 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  319 */     this.jPanel25 = new JPanel();
/*  320 */     this.jLabel65 = new JLabel();
/*  321 */     this.jSeparator6 = new JSeparator();
/*  322 */     this.jLabel66 = new JLabel();
/*  323 */     this.jLabel67 = new JLabel();
/*  324 */     this.jButton19 = new JButton();
/*  325 */     this.jButton20 = new JButton();
/*  326 */     this.jButton21 = new JButton();
/*  327 */     this.jPanel26 = new JPanel();
/*  328 */     this.jLabel107 = new JLabel();
/*  329 */     this.jLabel108 = new JLabel();
/*  330 */     this.jLabel109 = new JLabel();
/*  331 */     this.jLabel111 = new JLabel();
/*  332 */     this.jLabel112 = new JLabel();
/*  333 */     this.jLabel113 = new JLabel();
/*  334 */     this.jLabel114 = new JLabel();
/*  335 */     this.jLabel116 = new JLabel();
/*  336 */     this.jLabel117 = new JLabel();
/*  337 */     this.jLabel110 = new JLabel();
/*  338 */     this.jLabel115 = new JLabel();
/*  339 */     this.jLabel120 = new JLabel();
/*  340 */     this.jPanel27 = new JPanel();
/*  341 */     this.jLabel121 = new JLabel();
/*  342 */     this.jLabel129 = new JLabel();
/*  343 */     this.jLabel130 = new JLabel();
/*  344 */     this.jLabel131 = new JLabel();
/*  345 */     this.jLabel132 = new JLabel();
/*  346 */     this.jLabel133 = new JLabel();
/*  347 */     this.jLabel134 = new JLabel();
/*  348 */     this.jLabel135 = new JLabel();
/*  349 */     this.jLabel136 = new JLabel();
/*  350 */     this.jLabel68 = new JLabel();
/*  351 */     this.jLabel137 = new JLabel();
/*  352 */     this.jLabel118 = new JLabel();
/*  353 */     this.jLabel138 = new JLabel();
/*  354 */     this.jLabel139 = new JLabel();
/*  355 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  356 */     this.jPanel28 = new JPanel();
/*  357 */     this.jPanel33 = new JPanel();
/*  358 */     this.jPanel29 = new JPanel();
/*  359 */     this.jPanel30 = new JPanel();
/*  360 */     this.jLabel74 = new JLabel();
/*  361 */     this.jLabel75 = new JLabel();
/*  362 */     this.jPanel31 = new JPanel();
/*  363 */     this.jLabel76 = new JLabel();
/*  364 */     this.jPanel32 = new JPanel();
/*  365 */     this.jPanel34 = new JPanel();
/*  366 */     this.jLabel77 = new JLabel();
/*  367 */     this.jPanel35 = new JPanel();
/*  368 */     this.jPanel36 = new JPanel();
/*  369 */     this.jLabel83 = new JLabel();
/*  370 */     this.jLabel93 = new JLabel();
/*  371 */     this.jPanel37 = new JPanel();
/*  372 */     this.jLabel98 = new JLabel();
/*  373 */     this.jPanel38 = new JPanel();
/*  374 */     this.jLabel101 = new JLabel();
/*  375 */     this.jPanel39 = new JPanel();
/*  376 */     this.jLabel122 = new JLabel();
/*  377 */     this.jPanel40 = new JPanel();
/*  378 */     this.jSpinner3 = new JSpinner();
/*  379 */     this.jLabel146 = new JLabel();
/*  380 */     this.jLabel140 = new JLabel();
/*  381 */     this.jDateChooser2 = new JDateChooser();
/*  382 */     this.jLabel142 = new JLabel();
/*  383 */     this.jLabel143 = new JLabel();
/*  384 */     this.jLabel144 = new JLabel();
/*  385 */     this.jTextField30 = new JTextField();
/*  386 */     this.jPanel41 = new JPanel();
/*  387 */     this.jPanel42 = new JPanel();
/*  388 */     this.jLabel128 = new JLabel();
/*  389 */     this.jLabel141 = new JLabel();
/*  390 */     this.jPanel43 = new JPanel();
/*  391 */     this.jLabel145 = new JLabel();
/*  392 */     this.jPanel44 = new JPanel();
/*  393 */     this.jLabel70 = new JLabel();
/*  394 */     this.jPanel45 = new JPanel();
/*  395 */     this.jPanel46 = new JPanel();
/*  396 */     this.jPanel47 = new JPanel();
/*  397 */     this.jPanel48 = new JPanel();
/*  398 */     this.jLabel148 = new JLabel();
/*  399 */     this.jLabel149 = new JLabel();
/*  400 */     this.jPanel49 = new JPanel();
/*  401 */     this.jPanel50 = new JPanel();
/*  402 */     this.jLabel151 = new JLabel();
/*  403 */     this.jLabel147 = new JLabel();
/*  404 */     this.jPanel51 = new JPanel();
/*  405 */     this.materialButton29 = new MaterialButton();
/*  406 */     this.materialButton30 = new MaterialButton();
/*  407 */     this.materialButton31 = new MaterialButton();
/*  408 */     this.jPanel4 = new JPanel();
/*  409 */     this.jPanel52 = new JPanel();
/*  410 */     this.jLabel4 = new JLabel();
/*  411 */     this.jLabel9 = new JLabel();
/*  412 */     this.jPanel53 = new JPanel();
/*  413 */     this.jLabel11 = new JLabel();
/*  414 */     this.jTabbedPane1 = new JTabbedPane();
/*  415 */     this.jPanel9 = new JPanel();
/*  416 */     this.jPanel17 = new JPanel();
/*  417 */     this.jLabel14 = new JLabel();
/*  418 */     this.jTextField1 = new JTextField();
/*  419 */     this.jLabel15 = new JLabel();
/*  420 */     this.jTextField2 = new JTextField();
/*  421 */     this.jLabel16 = new JLabel();
/*  422 */     this.jTextField3 = new JTextField();
/*  423 */     this.jLabel31 = new JLabel();
/*  424 */     this.jTextField13 = new JTextField();
/*  425 */     this.jTextField4 = new JTextField();
/*  426 */     this.jLabel17 = new JLabel();
/*  427 */     this.jLabel18 = new JLabel();
/*  428 */     this.jTextField5 = new JTextField();
/*  429 */     this.jLabel19 = new JLabel();
/*  430 */     this.jTextField6 = new JTextField();
/*  431 */     this.jLabel20 = new JLabel();
/*  432 */     this.jTextField7 = new JTextField();
/*  433 */     this.jLabel21 = new JLabel();
/*  434 */     this.jTextField8 = new JTextField();
/*  435 */     this.jPanel5 = new JPanel();
/*  436 */     this.jLabel22 = new JLabel();
/*  437 */     this.jComboBox3 = new JComboBox();
/*  438 */     this.jLabel24 = new JLabel();
/*  439 */     this.jTextField9 = new JTextField();
/*  440 */     this.jLabel25 = new JLabel();
/*  441 */     this.jTextField11 = new JTextField();
/*  442 */     this.jLabel37 = new JLabel();
/*  443 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  444 */     this.jLabel38 = new JLabel();
/*  445 */     this.jFormattedTextField2 = new JFormattedTextField(this.formaTel2);
/*  446 */     this.jLabel39 = new JLabel();
/*  447 */     this.jTextField14 = new JTextField();
/*  448 */     this.jDateChooser1 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  449 */     this.jLabel27 = new JLabel();
/*  450 */     this.jLabel26 = new JLabel();
/*  451 */     this.jTextField17 = new JTextField();
/*  452 */     this.jPanel10 = new JPanel();
/*  453 */     this.jPanel18 = new JPanel();
/*  454 */     this.jLabel35 = new JLabel();
/*  455 */     this.jTextField16 = new JTextField();
/*  456 */     this.jLabel36 = new JLabel();
/*  457 */     this.jLabel40 = new JLabel();
/*  458 */     this.jLabel41 = new JLabel();
/*  459 */     this.jLabel42 = new JLabel();
/*  460 */     this.jLabel43 = new JLabel();
/*  461 */     this.jLabel44 = new JLabel();
/*  462 */     this.jLabel45 = new JLabel();
/*  463 */     this.jRadioButton3 = new JRadioButton();
/*  464 */     this.jRadioButton4 = new JRadioButton();
/*  465 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  466 */     this.jRadioButton5 = new JRadioButton();
/*  467 */     this.jRadioButton6 = new JRadioButton();
/*  468 */     this.jTextField15 = new JTextField();
/*  469 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  470 */     this.jComboBox5 = new JComboBox();
/*  471 */     this.jComboBox1 = new JComboBox();
/*  472 */     this.jButton4 = new JButton();
/*  473 */     this.jPanel12 = new JPanel();
/*  474 */     this.jLabel46 = new JLabel();
/*  475 */     this.jLabel47 = new JLabel();
/*  476 */     this.jComboBox2 = new JComboBox();
/*  477 */     this.jTextField10 = new JTextField();
/*  478 */     this.jPanel11 = new JPanel();
/*  479 */     this.jPanel23 = new JPanel();
/*  480 */     this.jLabel48 = new JLabel();
/*  481 */     this.jLabel49 = new JLabel();
/*  482 */     this.jLabel50 = new JLabel();
/*  483 */     this.jLabel51 = new JLabel();
/*  484 */     this.jLabel52 = new JLabel();
/*  485 */     this.jLabel53 = new JLabel();
/*  486 */     this.jLabel54 = new JLabel();
/*  487 */     this.jLabel55 = new JLabel();
/*  488 */     this.jDateChooser3 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  489 */     this.jDateChooser4 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  490 */     this.jSpinner1 = new JSpinner();
/*  491 */     this.jComboBox6 = new JComboBox();
/*  492 */     this.jComboBox7 = new JComboBox();
/*  493 */     this.jSpinner2 = new JSpinner();
/*  494 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  495 */     this.jFormattedTextField8 = new JFormattedTextField();
/*  496 */     this.jPanel13 = new JPanel();
/*  497 */     this.jLabel56 = new JLabel();
/*  498 */     this.jLabel57 = new JLabel();
/*  499 */     this.jTextField25 = new JTextField();
/*  500 */     this.jLabel58 = new JLabel();
/*  501 */     this.jTextField26 = new JTextField();
/*  502 */     this.jLabel59 = new JLabel();
/*  503 */     this.jTextField27 = new JTextField();
/*  504 */     this.jLabel60 = new JLabel();
/*  505 */     this.jTextField29 = new JTextField();
/*  506 */     this.jScrollPane2 = new JScrollPane();
/*  507 */     this.jTextArea1 = new JTextArea();
/*  508 */     this.jPanel54 = new JPanel();
/*  509 */     this.jPanel55 = new JPanel();
/*  510 */     this.jButton12 = new JButton();
/*  511 */     this.jButton13 = new JButton();
/*  512 */     this.materialButton18 = new MaterialButton();
/*  513 */     this.materialButton17 = new MaterialButton();
/*  514 */     this.materialButton19 = new MaterialButton();
/*  515 */     this.materialButton20 = new MaterialButton();
/*  516 */     this.materialButton21 = new MaterialButton();
/*  517 */     this.materialButton22 = new MaterialButton();
/*      */     
/*  519 */     this.jDialog1.setTitle("Departamentos");
/*  520 */     this.jDialog1.setModal(true);
/*  521 */     this.jDialog1.setResizable(false);
/*      */     
/*  523 */     this.jPanel57.setBorder(BorderFactory.createTitledBorder(null, "Agregar nuevo departamento", 0, 1, new Font("Cantarell", 0, 11)));
/*      */     
/*  525 */     this.jTextArea2.setColumns(20);
/*  526 */     this.jTextArea2.setLineWrap(true);
/*  527 */     this.jTextArea2.setRows(5);
/*  528 */     this.jTextArea2.setToolTipText("Éstos datos son los que serán impresos en el contrato");
/*  529 */     this.jScrollPane3.setViewportView(this.jTextArea2);
/*      */     
/*  531 */     this.jLabel3.setFont(new Font("Cantarell", 2, 11));
/*  532 */     this.jLabel3.setForeground(this.lc.PRIMARIO1);
/*  533 */     this.jLabel3.setHorizontalAlignment(0);
/*  534 */     this.jLabel3.setText("<html><P ALIGN=center>Éstas actividades se verán reflejadas en el contrato</p></html>");
/*      */     
/*  536 */     this.jLabel34.setFont(new Font("Cantarell", 0, 11));
/*  537 */     this.jLabel34.setText("Actividades ");
/*      */     
/*  539 */     this.jTextField12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  541 */             EmpleadosAgregar.this.jTextField12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  545 */     this.jLabel32.setFont(new Font("Cantarell", 0, 11));
/*  546 */     this.jLabel32.setText("Nombre");
/*      */     
/*  548 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/*  549 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/*  550 */     this.materialButton23.setMnemonic('G');
/*  551 */     this.materialButton23.setText("Guardar");
/*  552 */     this.materialButton23.setToolTipText("Guardar (Alt+G)");
/*  553 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/*  554 */     this.materialButton23.setHorizontalTextPosition(0);
/*  555 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  557 */             EmpleadosAgregar.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  561 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  562 */     this.jPanel57.setLayout(jPanel57Layout);
/*  563 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  564 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  565 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  566 */           .addContainerGap()
/*  567 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  568 */             .addGroup(jPanel57Layout.createSequentialGroup()
/*  569 */               .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  570 */                 .addComponent(this.jLabel34, GroupLayout.Alignment.LEADING, -1, 67, 32767)
/*  571 */                 .addComponent(this.jLabel32, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  572 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  573 */               .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  574 */                 .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING)
/*  575 */                 .addComponent(this.jScrollPane3)
/*  576 */                 .addComponent(this.jTextField12)))
/*  577 */             .addGroup(jPanel57Layout.createSequentialGroup()
/*  578 */               .addGap(0, 0, 32767)
/*  579 */               .addComponent((Component)this.materialButton23, -2, 150, -2)))));
/*      */     
/*  581 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  583 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  584 */           .addContainerGap(-1, 32767)
/*  585 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  586 */             .addComponent(this.jLabel32)
/*  587 */             .addComponent(this.jTextField12, -2, -1, -2))
/*  588 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  589 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */             .addComponent(this.jLabel34)
/*  591 */             .addComponent(this.jScrollPane3, -2, -1, -2))
/*  592 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  593 */           .addComponent(this.jLabel3, -2, -1, -2)
/*  594 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  595 */           .addComponent((Component)this.materialButton23, -2, 38, -2)
/*  596 */           .addGap(118, 118, 118)));
/*      */ 
/*      */     
/*  599 */     this.jPanel58.setBorder(BorderFactory.createTitledBorder(null, "Administrar Departamentos", 0, 1, new Font("Cantarell", 0, 11)));
/*      */     
/*  601 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  609 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  614 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  617 */     this.rSTableMetro3.setAltoHead(25);
/*  618 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  619 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  620 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  621 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  622 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  623 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  624 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  625 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 11));
/*  626 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  627 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 11));
/*  628 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 0, 11));
/*  629 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  630 */     this.rSTableMetro3.setRowHeight(18);
/*  631 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  632 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  633 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  634 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  636 */             EmpleadosAgregar.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  639 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  641 */             EmpleadosAgregar.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  644 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  646 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/*  647 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/*  648 */     this.materialButton25.setMnemonic('M');
/*  649 */     this.materialButton25.setText("Modificar");
/*  650 */     this.materialButton25.setToolTipText("Modificar (Alt+M)");
/*  651 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/*  652 */     this.materialButton25.setHorizontalTextPosition(0);
/*  653 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  655 */             EmpleadosAgregar.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  659 */     this.materialButton26.setBackground(this.lc.PRIMARIO1);
/*  660 */     this.materialButton26.setForeground(new Color(255, 255, 255));
/*  661 */     this.materialButton26.setMnemonic('E');
/*  662 */     this.materialButton26.setText("Eliminar");
/*  663 */     this.materialButton26.setToolTipText("Eliminar (Alt+E)");
/*  664 */     this.materialButton26.setFont(new Font("Cantarell", 0, 12));
/*  665 */     this.materialButton26.setHorizontalTextPosition(0);
/*  666 */     this.materialButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  668 */             EmpleadosAgregar.this.materialButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  672 */     GroupLayout jPanel58Layout = new GroupLayout(this.jPanel58);
/*  673 */     this.jPanel58.setLayout(jPanel58Layout);
/*  674 */     jPanel58Layout.setHorizontalGroup(jPanel58Layout
/*  675 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  676 */         .addComponent(this.jScrollPane13, -1, 393, 32767)
/*  677 */         .addGroup(jPanel58Layout.createSequentialGroup()
/*  678 */           .addGap(0, 0, 32767)
/*  679 */           .addComponent((Component)this.materialButton26, -2, 150, -2)
/*  680 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */           .addComponent((Component)this.materialButton25, -2, 150, -2)));
/*      */     
/*  683 */     jPanel58Layout.setVerticalGroup(jPanel58Layout
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addGroup(jPanel58Layout.createSequentialGroup()
/*  686 */           .addComponent(this.jScrollPane13, -1, 141, 32767)
/*  687 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  688 */           .addGroup(jPanel58Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  689 */             .addComponent((Component)this.materialButton25, -2, 38, -2)
/*  690 */             .addComponent((Component)this.materialButton26, -2, 38, -2))));
/*      */ 
/*      */     
/*  693 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/*  694 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/*  695 */     this.materialButton24.setMnemonic('C');
/*  696 */     this.materialButton24.setText("Cerrar");
/*  697 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/*  698 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/*  699 */     this.materialButton24.setHorizontalTextPosition(0);
/*  700 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  702 */             EmpleadosAgregar.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  706 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/*  707 */     this.jPanel56.setLayout(jPanel56Layout);
/*  708 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/*  709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  710 */         .addComponent(this.jPanel57, -1, -1, 32767)
/*  711 */         .addComponent(this.jPanel58, -1, -1, 32767)
/*  712 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
/*  713 */           .addGap(0, 0, 32767)
/*  714 */           .addComponent((Component)this.materialButton24, -2, 105, -2)));
/*      */     
/*  716 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/*  717 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  718 */         .addGroup(jPanel56Layout.createSequentialGroup()
/*  719 */           .addComponent(this.jPanel57, -2, 211, -2)
/*  720 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  721 */           .addComponent(this.jPanel58, -1, -1, 32767)
/*  722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  723 */           .addComponent((Component)this.materialButton24, -2, 38, -2)
/*  724 */           .addContainerGap()));
/*      */ 
/*      */     
/*  727 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  728 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  729 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  730 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  731 */         .addComponent(this.jPanel56, -1, -1, 32767));
/*      */     
/*  733 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  735 */         .addComponent(this.jPanel56, -1, -1, 32767));
/*      */ 
/*      */     
/*  738 */     this.jDialog2.setTitle("Foto");
/*  739 */     this.jDialog2.setAlwaysOnTop(true);
/*  740 */     this.jDialog2.setFocusable(false);
/*  741 */     this.jDialog2.setUndecorated(true);
/*      */     
/*  743 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*  744 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*  745 */     this.jPanel2.setLayout((LayoutManager)null);
/*      */     
/*  747 */     this.jPanel59.setBackground(this.lc.PRIMARIO1);
/*  748 */     this.jPanel59.setLayout(new GridLayout(1, 0));
/*      */     
/*  750 */     this.jLabel69.setHorizontalAlignment(0);
/*  751 */     this.jLabel69.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  752 */     this.jLabel69.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  754 */             EmpleadosAgregar.this.jLabel69MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  757 */             EmpleadosAgregar.this.jLabel69MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  760 */             EmpleadosAgregar.this.jLabel69MouseEntered(evt);
/*      */           }
/*      */         });
/*  763 */     this.jPanel59.add(this.jLabel69);
/*      */     
/*  765 */     this.jPanel2.add(this.jPanel59);
/*  766 */     this.jPanel59.setBounds(219, 1, 30, 31);
/*      */     
/*  768 */     this.jLabel1.setFont(new Font("Cantarell", 0, 13));
/*  769 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/*  770 */     this.jLabel1.setHorizontalAlignment(0);
/*  771 */     this.jLabel1.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  773 */             EmpleadosAgregar.this.jLabel1MouseDragged(evt);
/*      */           }
/*      */         });
/*  776 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  778 */             EmpleadosAgregar.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */         });
/*  781 */     this.jPanel2.add(this.jLabel1);
/*  782 */     this.jLabel1.setBounds(0, 20, 250, 290);
/*      */     
/*  784 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  785 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  786 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  787 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  788 */         .addComponent(this.jPanel2, -1, 254, 32767));
/*      */     
/*  790 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  792 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  793 */           .addComponent(this.jPanel2, -1, 328, 32767)
/*  794 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/*  797 */     this.jDialog3.setTitle("Impresión de Gafetes");
/*  798 */     this.jDialog3.setModal(true);
/*      */     
/*  800 */     this.jLabel12.setFont(new Font("Cantarell", 0, 11));
/*  801 */     this.jLabel12.setText("<html>Selecciona el tipo de gafete que deseas crear y a continuación pulsa el botón siguiente</html>");
/*      */     
/*  803 */     this.jPanel1.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/*  805 */     this.jRadioButton7.setSelected(true);
/*  806 */     this.jRadioButton7.setText("Credencial Forsis");
/*  807 */     this.jPanel1.add(this.jRadioButton7);
/*      */     
/*  809 */     this.jRadioButton8.setText("Curso Básico");
/*  810 */     this.jPanel1.add(this.jRadioButton8);
/*      */     
/*  812 */     this.materialButton27.setBackground(this.lc.SECUNDARIO1);
/*  813 */     this.materialButton27.setForeground(new Color(255, 255, 255));
/*  814 */     this.materialButton27.setMnemonic('C');
/*  815 */     this.materialButton27.setText("Cancelar");
/*  816 */     this.materialButton27.setToolTipText("Cancelar (Alt+C)");
/*  817 */     this.materialButton27.setFont(new Font("Cantarell", 0, 12));
/*  818 */     this.materialButton27.setHorizontalTextPosition(0);
/*  819 */     this.materialButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  821 */             EmpleadosAgregar.this.materialButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  825 */     this.materialButton28.setBackground(this.lc.SECUNDARIO1);
/*  826 */     this.materialButton28.setForeground(new Color(255, 255, 255));
/*  827 */     this.materialButton28.setMnemonic('C');
/*  828 */     this.materialButton28.setText("Siguiente >");
/*  829 */     this.materialButton28.setToolTipText("Cancelar (Alt+C)");
/*  830 */     this.materialButton28.setFont(new Font("Cantarell", 0, 12));
/*  831 */     this.materialButton28.setHorizontalTextPosition(0);
/*  832 */     this.materialButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  834 */             EmpleadosAgregar.this.materialButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  838 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  839 */     this.jPanel6.setLayout(jPanel6Layout);
/*  840 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  841 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  842 */         .addComponent(this.jLabel12, -1, 345, 32767)
/*  843 */         .addComponent(this.jSeparator4, -1, 345, 32767)
/*  844 */         .addComponent(this.jPanel1, -1, -1, 32767)
/*  845 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  846 */           .addContainerGap(-1, 32767)
/*  847 */           .addComponent((Component)this.materialButton28, -2, 105, -2)
/*  848 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  849 */           .addComponent((Component)this.materialButton27, -2, 105, -2)
/*  850 */           .addContainerGap()));
/*      */     
/*  852 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  853 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  854 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  855 */           .addComponent(this.jLabel12, -2, 42, -2)
/*  856 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  857 */           .addComponent(this.jPanel1, -2, -1, -2)
/*  858 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  859 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  860 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  861 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  862 */             .addComponent((Component)this.materialButton27, -2, 38, -2)
/*  863 */             .addComponent((Component)this.materialButton28, -2, 38, -2))
/*  864 */           .addGap(158, 158, 158)));
/*      */ 
/*      */     
/*  867 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  868 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  869 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  870 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  871 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/*  873 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  874 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  875 */         .addComponent(this.jPanel6, -1, 144, 32767));
/*      */ 
/*      */     
/*  878 */     this.jDialog4.setTitle("Impresión de Gafetes");
/*  879 */     this.jDialog4.setModal(true);
/*      */     
/*  881 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/*  883 */     this.jLabel61.setFont(new Font("Times New Roman", 1, 20));
/*  884 */     this.jLabel61.setHorizontalAlignment(0);
/*  885 */     this.jLabel61.setText("Gafette para empleados");
/*      */     
/*  887 */     this.jLabel62.setFont(new Font("Tahoma", 1, 12));
/*  888 */     this.jLabel62.setForeground(new Color(153, 153, 153));
/*  889 */     this.jLabel62.setText("Frente        Frente        Frente        Frente        Frente        Frente    ");
/*      */     
/*  891 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/*  892 */     this.jPanel15.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  893 */     this.jPanel15.setLayout((LayoutManager)null);
/*      */     
/*  895 */     this.jLabel13.setFont(new Font("Times New Roman", 0, 19));
/*  896 */     this.jLabel13.setForeground(new Color(153, 0, 0));
/*  897 */     this.jLabel13.setText("Fletes y Materiales Forsis S.A. de C.V.");
/*  898 */     this.jPanel15.add(this.jLabel13);
/*  899 */     this.jLabel13.setBounds(40, 0, 330, 27);
/*      */     
/*  901 */     this.jLabel33.setText("____________________________________________________");
/*  902 */     this.jPanel15.add(this.jLabel33);
/*  903 */     this.jLabel33.setBounds(40, 20, 370, 19);
/*      */     
/*  905 */     this.jLabel63.setText("___________________________________________________");
/*  906 */     this.jPanel15.add(this.jLabel63);
/*  907 */     this.jLabel63.setBounds(20, 10, 370, 19);
/*      */     
/*  909 */     this.jLabel78.setHorizontalAlignment(0);
/*  910 */     this.jLabel78.setText("sin foto");
/*  911 */     this.jLabel78.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/*  912 */     this.jPanel15.add(this.jLabel78);
/*  913 */     this.jLabel78.setBounds(10, 40, 110, 130);
/*      */     
/*  915 */     this.jLabel80.setFont(new Font("Tahoma", 1, 11));
/*  916 */     this.jLabel80.setHorizontalAlignment(0);
/*  917 */     this.jLabel80.setText("OP-00001");
/*  918 */     this.jPanel15.add(this.jLabel80);
/*  919 */     this.jLabel80.setBounds(10, 170, 110, 16);
/*      */     
/*  921 */     this.jLabel82.setFont(new Font("Tahoma", 1, 10));
/*  922 */     this.jLabel82.setText("Nombre Completo");
/*  923 */     this.jPanel15.add(this.jLabel82);
/*  924 */     this.jLabel82.setBounds(130, 40, 280, 14);
/*      */     
/*  926 */     this.jLabel84.setText("Tipo");
/*  927 */     this.jPanel15.add(this.jLabel84);
/*  928 */     this.jLabel84.setBounds(130, 90, 230, 19);
/*      */     
/*  930 */     this.jLabel85.setText("Nss");
/*  931 */     this.jPanel15.add(this.jLabel85);
/*  932 */     this.jLabel85.setBounds(130, 110, 230, 19);
/*      */     
/*  934 */     this.jLabel86.setText("Vigencia");
/*  935 */     this.jLabel86.setToolTipText("Clic para cambiar la vigencia");
/*  936 */     this.jLabel86.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  938 */             EmpleadosAgregar.this.jLabel86MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  941 */             EmpleadosAgregar.this.jLabel86MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  944 */             EmpleadosAgregar.this.jLabel86MouseExited(evt);
/*      */           }
/*      */         });
/*  947 */     this.jPanel15.add(this.jLabel86);
/*  948 */     this.jLabel86.setBounds(130, 150, 230, 19);
/*      */     
/*  950 */     this.jPanel16.setBackground(new Color(247, 150, 70));
/*      */     
/*  952 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/*  953 */     this.jLabel81.setHorizontalAlignment(0);
/*  954 */     this.jLabel81.setText("Categoría del Empleado");
/*  955 */     this.jLabel81.setToolTipText("Clic para cambiar la categoría");
/*      */     
/*  957 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/*  958 */     this.jPanel16.setLayout(jPanel16Layout);
/*  959 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/*  960 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */         .addComponent(this.jLabel81, -1, 280, 32767));
/*      */     
/*  963 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/*  964 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  965 */         .addComponent(this.jLabel81, -1, 20, 32767));
/*      */ 
/*      */     
/*  968 */     this.jPanel15.add(this.jPanel16);
/*  969 */     this.jPanel16.setBounds(130, 170, 280, 20);
/*      */     
/*  971 */     this.jLabel87.setHorizontalAlignment(0);
/*  972 */     this.jLabel87.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisCreden.png")));
/*  973 */     this.jPanel15.add(this.jLabel87);
/*  974 */     this.jLabel87.setBounds(230, 40, 220, 150);
/*      */     
/*  976 */     this.jPanel19.setBackground(new Color(153, 0, 0));
/*      */     
/*  978 */     this.jLabel88.setFont(new Font("Tahoma", 0, 10));
/*  979 */     this.jLabel88.setForeground(new Color(255, 255, 255));
/*  980 */     this.jLabel88.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/*      */     
/*  982 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  983 */     this.jPanel19.setLayout(jPanel19Layout);
/*  984 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  985 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  986 */         .addComponent(this.jLabel88, -1, 400, 32767));
/*      */     
/*  988 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  990 */         .addComponent(this.jLabel88, -1, 30, 32767));
/*      */ 
/*      */     
/*  993 */     this.jPanel15.add(this.jPanel19);
/*  994 */     this.jPanel19.setBounds(10, 200, 400, 30);
/*      */     
/*  996 */     this.jLabel89.setText("Curp");
/*  997 */     this.jPanel15.add(this.jLabel89);
/*  998 */     this.jLabel89.setBounds(130, 130, 230, 19);
/*      */     
/* 1000 */     this.jLabel64.setFont(new Font("Tahoma", 1, 12));
/* 1001 */     this.jLabel64.setForeground(new Color(153, 153, 153));
/* 1002 */     this.jLabel64.setHorizontalAlignment(0);
/* 1003 */     this.jLabel64.setText("Reverso        Reverso        Reverso        Reverso        Reverso        ");
/*      */     
/* 1005 */     this.jPanel20.setBackground(new Color(255, 255, 255));
/* 1006 */     this.jPanel20.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1007 */     this.jPanel20.setLayout((LayoutManager)null);
/*      */     
/* 1009 */     this.jLabel79.setFont(new Font("Times New Roman", 0, 19));
/* 1010 */     this.jLabel79.setForeground(new Color(153, 0, 0));
/* 1011 */     this.jLabel79.setHorizontalAlignment(0);
/* 1012 */     this.jLabel79.setText("Políticas de la empresa");
/* 1013 */     this.jPanel20.add(this.jLabel79);
/* 1014 */     this.jLabel79.setBounds(40, 0, 330, 27);
/*      */     
/* 1016 */     this.jLabel90.setText("____________________________________________________");
/* 1017 */     this.jPanel20.add(this.jLabel90);
/* 1018 */     this.jLabel90.setBounds(40, 20, 370, 19);
/*      */     
/* 1020 */     this.jLabel91.setText("___________________________________________________");
/* 1021 */     this.jPanel20.add(this.jLabel91);
/* 1022 */     this.jLabel91.setBounds(20, 10, 370, 19);
/*      */     
/* 1024 */     this.jLabel94.setFont(new Font("Tahoma", 0, 8));
/* 1025 */     this.jLabel94.setText("<html>•  Brindar  trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos considerando que el fin de la empresa es el servicio del cliente.</html>");
/* 1026 */     this.jPanel20.add(this.jLabel94);
/* 1027 */     this.jLabel94.setBounds(20, 40, 380, 20);
/*      */     
/* 1029 */     this.jLabel95.setFont(new Font("Tahoma", 0, 8));
/* 1030 */     this.jLabel95.setText("<html>• Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo, es mi responsabilidad.</html>");
/* 1031 */     this.jPanel20.add(this.jLabel95);
/* 1032 */     this.jLabel95.setBounds(20, 60, 400, 30);
/*      */     
/* 1034 */     this.jLabel96.setFont(new Font("Tahoma", 0, 8));
/* 1035 */     this.jLabel96.setText("<html>• Como integrante de la empresa debo mantener un comportamiento ético, desterrar toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de FORSIS y de todos los clientes.</html>");
/* 1036 */     this.jPanel20.add(this.jLabel96);
/* 1037 */     this.jLabel96.setBounds(20, 90, 390, 20);
/*      */     
/* 1039 */     this.jLabel97.setFont(new Font("Tahoma", 0, 10));
/* 1040 */     this.jLabel97.setHorizontalAlignment(0);
/* 1041 */     this.jLabel97.setText("Roger Garza Cantú");
/* 1042 */     this.jPanel20.add(this.jLabel97);
/* 1043 */     this.jLabel97.setBounds(300, 170, 110, 14);
/*      */     
/* 1045 */     this.jLabel99.setHorizontalAlignment(0);
/* 1046 */     this.jLabel99.setText("_______________");
/* 1047 */     this.jPanel20.add(this.jLabel99);
/* 1048 */     this.jLabel99.setBounds(300, 200, 110, 19);
/*      */     
/* 1050 */     this.jLabel100.setFont(new Font("Tahoma", 0, 10));
/* 1051 */     this.jLabel100.setHorizontalAlignment(0);
/* 1052 */     this.jLabel100.setText("Director");
/* 1053 */     this.jPanel20.add(this.jLabel100);
/* 1054 */     this.jLabel100.setBounds(310, 210, 100, 14);
/*      */     
/* 1056 */     this.jLabel102.setFont(new Font("Tahoma", 0, 10));
/* 1057 */     this.jLabel102.setHorizontalAlignment(0);
/* 1058 */     this.jLabel102.setText("Nombre Completo");
/* 1059 */     this.jPanel20.add(this.jLabel102);
/* 1060 */     this.jLabel102.setBounds(10, 170, 170, 14);
/*      */     
/* 1062 */     this.jLabel103.setHorizontalAlignment(0);
/* 1063 */     this.jLabel103.setText("_________________");
/* 1064 */     this.jPanel20.add(this.jLabel103);
/* 1065 */     this.jLabel103.setBounds(10, 200, 150, 19);
/*      */     
/* 1067 */     this.jLabel104.setFont(new Font("Tahoma", 0, 10));
/* 1068 */     this.jLabel104.setHorizontalAlignment(0);
/* 1069 */     this.jLabel104.setText("Categoría");
/* 1070 */     this.jPanel20.add(this.jLabel104);
/* 1071 */     this.jLabel104.setBounds(10, 210, 160, 14);
/*      */     
/* 1073 */     this.jLabel105.setFont(new Font("Tahoma", 0, 8));
/* 1074 */     this.jLabel105.setText("<html>• Como operador capacitado atender al cliente es mi responsabilidad, para lo cual debo conocer los procedimientos a fin de realizarlos con excelencia..</html>");
/* 1075 */     this.jPanel20.add(this.jLabel105);
/* 1076 */     this.jLabel105.setBounds(20, 120, 390, 20);
/* 1077 */     this.jPanel20.add(this.jLabel92);
/* 1078 */     this.jLabel92.setBounds(330, 170, 50, 60);
/*      */     
/* 1080 */     this.jLabel106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png")));
/* 1081 */     this.jLabel106.setText("l");
/* 1082 */     this.jPanel20.add(this.jLabel106);
/* 1083 */     this.jLabel106.setBounds(10, 60, 400, 120);
/*      */     
/* 1085 */     this.materialButton32.setBackground(this.lc.SECUNDARIO1);
/* 1086 */     this.materialButton32.setForeground(new Color(255, 255, 255));
/* 1087 */     this.materialButton32.setMnemonic('C');
/* 1088 */     this.materialButton32.setText("Cancelar");
/* 1089 */     this.materialButton32.setToolTipText("Cancelar (Alt+C)");
/* 1090 */     this.materialButton32.setFont(new Font("Cantarell", 0, 12));
/* 1091 */     this.materialButton32.setHorizontalTextPosition(0);
/* 1092 */     this.materialButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1094 */             EmpleadosAgregar.this.materialButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1098 */     this.materialButton33.setBackground(this.lc.SECUNDARIO1);
/* 1099 */     this.materialButton33.setForeground(new Color(255, 255, 255));
/* 1100 */     this.materialButton33.setMnemonic('I');
/* 1101 */     this.materialButton33.setText("Imprimir");
/* 1102 */     this.materialButton33.setToolTipText("Imprimir (Alt+A)");
/* 1103 */     this.materialButton33.setFont(new Font("Cantarell", 0, 12));
/* 1104 */     this.materialButton33.setHorizontalTextPosition(0);
/* 1105 */     this.materialButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1107 */             EmpleadosAgregar.this.materialButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1111 */     this.materialButton34.setBackground(this.lc.SECUNDARIO1);
/* 1112 */     this.materialButton34.setForeground(new Color(255, 255, 255));
/* 1113 */     this.materialButton34.setMnemonic('R');
/* 1114 */     this.materialButton34.setText("< Regresar");
/* 1115 */     this.materialButton34.setToolTipText("Regresar (Alt+R)");
/* 1116 */     this.materialButton34.setFont(new Font("Cantarell", 0, 12));
/* 1117 */     this.materialButton34.setHorizontalTextPosition(0);
/* 1118 */     this.materialButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1120 */             EmpleadosAgregar.this.materialButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1124 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1125 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1126 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1128 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1129 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1130 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1131 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/* 1132 */                 .addContainerGap()
/* 1133 */                 .addComponent(this.jSeparator7))
/* 1134 */               .addComponent(this.jLabel61, GroupLayout.Alignment.LEADING, -2, 423, -2))
/* 1135 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1136 */               .addContainerGap()
/* 1137 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */                 .addComponent(this.jPanel15, -2, 419, -2)
/* 1139 */                 .addComponent(this.jLabel62, -1, -1, 32767)
/* 1140 */                 .addComponent(this.jLabel64, -1, -1, 32767)
/* 1141 */                 .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1142 */                   .addGroup(jPanel14Layout.createSequentialGroup()
/* 1143 */                     .addComponent((Component)this.materialButton34, -2, 105, -2)
/* 1144 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1145 */                     .addComponent((Component)this.materialButton33, -2, 105, -2)
/* 1146 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1147 */                     .addComponent((Component)this.materialButton32, -2, 105, -2))
/* 1148 */                   .addComponent(this.jPanel20, -2, 419, -2)))))
/* 1149 */           .addContainerGap()));
/*      */     
/* 1151 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1152 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1153 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1154 */           .addComponent(this.jLabel61, -2, 22, -2)
/* 1155 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1156 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1158 */           .addComponent(this.jLabel62)
/* 1159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1160 */           .addComponent(this.jPanel15, -2, 235, -2)
/* 1161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1162 */           .addComponent(this.jLabel64)
/* 1163 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1164 */           .addComponent(this.jPanel20, -2, 235, -2)
/* 1165 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1166 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1167 */             .addComponent((Component)this.materialButton32, -2, 38, -2)
/* 1168 */             .addComponent((Component)this.materialButton33, -2, 38, -2)
/* 1169 */             .addComponent((Component)this.materialButton34, -2, 38, -2))
/* 1170 */           .addContainerGap(24, 32767)));
/*      */ 
/*      */     
/* 1173 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1174 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1175 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1176 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1177 */         .addComponent(this.jPanel14, -2, 437, -2));
/*      */     
/* 1179 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1181 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 1184 */     this.jLabel119.setText("Coloca la vigencia");
/*      */     
/* 1186 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 1187 */     this.jDateChooser8.setIcon(this.icon);
/*      */     
/* 1189 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 1190 */     this.jPanel24.setLayout(jPanel24Layout);
/* 1191 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 1192 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1193 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1194 */           .addContainerGap()
/* 1195 */           .addComponent(this.jLabel119, -2, 115, 32767)
/* 1196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1197 */           .addComponent((Component)this.jDateChooser8, -2, 108, -2)
/* 1198 */           .addContainerGap()));
/*      */     
/* 1200 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 1201 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1202 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1203 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1204 */             .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1205 */             .addComponent(this.jLabel119, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1206 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1209 */     this.jDialog5.setTitle("Impresión de Gafetes");
/* 1210 */     this.jDialog5.setModal(true);
/*      */     
/* 1212 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/*      */     
/* 1214 */     this.jLabel65.setFont(new Font("Times New Roman", 1, 20));
/* 1215 */     this.jLabel65.setHorizontalAlignment(0);
/* 1216 */     this.jLabel65.setText("Credencial RigPass para Locaciones");
/*      */     
/* 1218 */     this.jLabel66.setFont(new Font("Tahoma", 1, 12));
/* 1219 */     this.jLabel66.setForeground(new Color(153, 153, 153));
/* 1220 */     this.jLabel66.setText("Frente       Frente       Frente       Frente       Frente       Frente       Frente");
/*      */     
/* 1222 */     this.jLabel67.setFont(new Font("Tahoma", 1, 12));
/* 1223 */     this.jLabel67.setForeground(new Color(153, 153, 153));
/* 1224 */     this.jLabel67.setText("Reverso      Reverso      Reverso      Reverso      Reverso      Reverso ");
/*      */     
/* 1226 */     this.jButton19.setMnemonic('C');
/* 1227 */     this.jButton19.setText("Cancelar");
/* 1228 */     this.jButton19.setToolTipText("Cancelar (Alt+C)");
/* 1229 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1231 */             EmpleadosAgregar.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1235 */     this.jButton20.setMnemonic('I');
/* 1236 */     this.jButton20.setText("Imprimir");
/* 1237 */     this.jButton20.setToolTipText("Imprimir (Alt+I)");
/* 1238 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1240 */             EmpleadosAgregar.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1244 */     this.jButton21.setMnemonic('R');
/* 1245 */     this.jButton21.setText("< Regresar");
/* 1246 */     this.jButton21.setToolTipText("Regresar (Alt+R)");
/* 1247 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1249 */             EmpleadosAgregar.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1253 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/* 1254 */     this.jPanel26.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1255 */     this.jPanel26.setLayout((LayoutManager)null);
/*      */     
/* 1257 */     this.jLabel107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis50.png")));
/* 1258 */     this.jPanel26.add(this.jLabel107);
/* 1259 */     this.jLabel107.setBounds(10, 10, 50, 50);
/*      */     
/* 1261 */     this.jLabel108.setFont(new Font("Tahoma", 1, 13));
/* 1262 */     this.jLabel108.setForeground(new Color(0, 51, 204));
/* 1263 */     this.jLabel108.setHorizontalAlignment(0);
/* 1264 */     this.jLabel108.setText("<html><u>CURSO DE SEGURIDAD BÁSICA</u></html>");
/* 1265 */     this.jPanel26.add(this.jLabel108);
/* 1266 */     this.jLabel108.setBounds(110, 120, 300, 20);
/*      */     
/* 1268 */     this.jLabel109.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png")));
/* 1269 */     this.jPanel26.add(this.jLabel109);
/* 1270 */     this.jLabel109.setBounds(70, 30, 350, 40);
/*      */     
/* 1272 */     this.jLabel111.setFont(new Font("Tahoma", 1, 14));
/* 1273 */     this.jLabel111.setForeground(new Color(0, 51, 204));
/* 1274 */     this.jLabel111.setHorizontalAlignment(0);
/* 1275 */     this.jLabel111.setText("FLETES Y MATERIALES FORSIS S.A. DE C.V.");
/* 1276 */     this.jPanel26.add(this.jLabel111);
/* 1277 */     this.jLabel111.setBounds(60, 10, 340, 20);
/*      */     
/* 1279 */     this.jLabel112.setFont(new Font("Tahoma", 1, 11));
/* 1280 */     this.jLabel112.setHorizontalAlignment(0);
/* 1281 */     this.jLabel112.setText("ACREDITA A:");
/* 1282 */     this.jPanel26.add(this.jLabel112);
/* 1283 */     this.jLabel112.setBounds(110, 70, 290, 16);
/*      */     
/* 1285 */     this.jLabel113.setFont(new Font("Tahoma", 1, 11));
/* 1286 */     this.jLabel113.setForeground(new Color(0, 51, 204));
/* 1287 */     this.jLabel113.setHorizontalAlignment(0);
/* 1288 */     this.jLabel113.setText("UZZIEL CONTRERAS PORTILLA");
/* 1289 */     this.jPanel26.add(this.jLabel113);
/* 1290 */     this.jLabel113.setBounds(110, 90, 300, 16);
/*      */     
/* 1292 */     this.jLabel114.setHorizontalAlignment(0);
/* 1293 */     this.jLabel114.setText("DE HABER:");
/* 1294 */     this.jPanel26.add(this.jLabel114);
/* 1295 */     this.jLabel114.setBounds(110, 110, 290, 19);
/*      */     
/* 1297 */     this.jLabel116.setHorizontalAlignment(0);
/* 1298 */     this.jLabel116.setText("<html><center>Certificado por:<br>SECRETARÍA DEL TRABAJO Y PREVISION SOCIAL\n</center></html>");
/* 1299 */     this.jPanel26.add(this.jLabel116);
/* 1300 */     this.jLabel116.setBounds(110, 190, 300, 30);
/*      */     
/* 1302 */     this.jLabel117.setHorizontalAlignment(0);
/* 1303 */     this.jLabel117.setText("<html>Uzziel Contreras Portilla <p>VACJ 710806 TU8 0013</html>");
/* 1304 */     this.jPanel26.add(this.jLabel117);
/* 1305 */     this.jLabel117.setBounds(110, 154, 300, 30);
/*      */     
/* 1307 */     this.jLabel110.setFont(new Font("Tahoma", 0, 10));
/* 1308 */     this.jLabel110.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/* 1309 */     this.jPanel26.add(this.jLabel110);
/* 1310 */     this.jLabel110.setBounds(0, 220, 450, 30);
/*      */     
/* 1312 */     this.jLabel115.setHorizontalAlignment(0);
/* 1313 */     this.jLabel115.setText("sin foto");
/* 1314 */     this.jLabel115.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1315 */     this.jPanel26.add(this.jLabel115);
/* 1316 */     this.jLabel115.setBounds(10, 80, 110, 130);
/*      */     
/* 1318 */     this.jLabel120.setHorizontalAlignment(0);
/* 1319 */     this.jLabel120.setText("AGENTE CAPACITADOR");
/* 1320 */     this.jPanel26.add(this.jLabel120);
/* 1321 */     this.jLabel120.setBounds(110, 140, 300, 19);
/*      */     
/* 1323 */     this.jPanel27.setBackground(new Color(255, 255, 255));
/* 1324 */     this.jPanel27.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1325 */     this.jPanel27.setLayout((LayoutManager)null);
/*      */     
/* 1327 */     this.jLabel121.setFont(new Font("Tahoma", 1, 14));
/* 1328 */     this.jLabel121.setForeground(new Color(0, 51, 204));
/* 1329 */     this.jLabel121.setHorizontalAlignment(0);
/* 1330 */     this.jLabel121.setText("CURSO DE SEGURIDAD BÁSICA");
/* 1331 */     this.jPanel27.add(this.jLabel121);
/* 1332 */     this.jLabel121.setBounds(60, 10, 340, 20);
/*      */     
/* 1334 */     this.jLabel129.setFont(new Font("Tahoma", 0, 12));
/* 1335 */     this.jLabel129.setForeground(new Color(0, 51, 153));
/* 1336 */     this.jLabel129.setText("COPU01087464");
/* 1337 */     this.jPanel27.add(this.jLabel129);
/* 1338 */     this.jLabel129.setBounds(160, 70, 260, 17);
/*      */     
/* 1340 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 1341 */     this.jLabel130.setText("CURP:");
/* 1342 */     this.jPanel27.add(this.jLabel130);
/* 1343 */     this.jLabel130.setBounds(10, 70, 140, 16);
/*      */     
/* 1345 */     this.jLabel131.setFont(new Font("Tahoma", 1, 11));
/* 1346 */     this.jLabel131.setText("NOMBRE DEL EMPLEADO:");
/* 1347 */     this.jPanel27.add(this.jLabel131);
/* 1348 */     this.jLabel131.setBounds(10, 40, 140, 16);
/*      */     
/* 1350 */     this.jLabel132.setFont(new Font("Tahoma", 0, 12));
/* 1351 */     this.jLabel132.setForeground(new Color(0, 51, 153));
/* 1352 */     this.jLabel132.setText("NOMBRE DEL EMPLEADO:");
/* 1353 */     this.jPanel27.add(this.jLabel132);
/* 1354 */     this.jLabel132.setBounds(160, 40, 260, 17);
/*      */     
/* 1356 */     this.jLabel133.setFont(new Font("Tahoma", 1, 11));
/* 1357 */     this.jLabel133.setText("IMSS:");
/* 1358 */     this.jPanel27.add(this.jLabel133);
/* 1359 */     this.jLabel133.setBounds(10, 100, 140, 16);
/*      */     
/* 1361 */     this.jLabel134.setFont(new Font("Tahoma", 0, 12));
/* 1362 */     this.jLabel134.setForeground(new Color(0, 51, 153));
/* 1363 */     this.jLabel134.setText("9837476276343");
/* 1364 */     this.jPanel27.add(this.jLabel134);
/* 1365 */     this.jLabel134.setBounds(160, 100, 260, 17);
/*      */     
/* 1367 */     this.jLabel135.setFont(new Font("Tahoma", 1, 11));
/* 1368 */     this.jLabel135.setForeground(new Color(0, 51, 153));
/* 1369 */     this.jLabel135.setText("00001");
/* 1370 */     this.jPanel27.add(this.jLabel135);
/* 1371 */     this.jLabel135.setBounds(380, 220, 60, 16);
/*      */     
/* 1373 */     this.jLabel136.setFont(new Font("Tahoma", 0, 12));
/* 1374 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/* 1375 */     this.jLabel136.setText("ENERO 2011");
/* 1376 */     this.jLabel136.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1378 */             EmpleadosAgregar.this.jLabel136MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1381 */             EmpleadosAgregar.this.jLabel136MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1384 */             EmpleadosAgregar.this.jLabel136MouseExited(evt);
/*      */           }
/*      */         });
/* 1387 */     this.jPanel27.add(this.jLabel136);
/* 1388 */     this.jLabel136.setBounds(160, 130, 260, 17);
/*      */     
/* 1390 */     this.jLabel68.setFont(new Font("Tahoma", 1, 11));
/* 1391 */     this.jLabel68.setHorizontalAlignment(0);
/* 1392 */     this.jLabel68.setText("<html><center>DE ACUERDO A LOS LINEAMIENTOS DE:<br>\"INTERNATIONAL ASSOCIATION OF DRILLI NG CONTRACTORS\"</center></html>");
/* 1393 */     this.jPanel27.add(this.jLabel68);
/* 1394 */     this.jLabel68.setBounds(10, 150, 420, 40);
/*      */     
/* 1396 */     this.jLabel137.setFont(new Font("Tahoma", 1, 11));
/* 1397 */     this.jLabel137.setText("VIGENCIA:");
/* 1398 */     this.jPanel27.add(this.jLabel137);
/* 1399 */     this.jLabel137.setBounds(10, 130, 140, 16);
/*      */     
/* 1401 */     this.jLabel118.setText("__________________");
/* 1402 */     this.jPanel27.add(this.jLabel118);
/* 1403 */     this.jLabel118.setBounds(60, 220, 160, 19);
/*      */     
/* 1405 */     this.jLabel138.setFont(new Font("Tahoma", 1, 11));
/* 1406 */     this.jLabel138.setText("Firma:");
/* 1407 */     this.jPanel27.add(this.jLabel138);
/* 1408 */     this.jLabel138.setBounds(10, 220, 50, 16);
/*      */     
/* 1410 */     this.jLabel139.setFont(new Font("Tahoma", 1, 11));
/* 1411 */     this.jLabel139.setHorizontalAlignment(4);
/* 1412 */     this.jLabel139.setText("FPR-");
/* 1413 */     this.jPanel27.add(this.jLabel139);
/* 1414 */     this.jLabel139.setBounds(320, 220, 50, 16);
/*      */     
/* 1416 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1417 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1418 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1420 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1421 */           .addContainerGap()
/* 1422 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1423 */             .addGroup(jPanel25Layout.createSequentialGroup()
/* 1424 */               .addComponent(this.jButton21, -2, 97, -2)
/* 1425 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1426 */               .addComponent(this.jButton20, -2, 97, -2)
/* 1427 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1428 */               .addComponent(this.jButton19, -2, 97, -2))
/* 1429 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1430 */               .addComponent(this.jPanel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1431 */               .addComponent(this.jLabel67, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1432 */               .addComponent(this.jLabel65, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1433 */               .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING)
/* 1434 */               .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1435 */               .addComponent(this.jLabel66, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1436 */           .addContainerGap(23, 32767)));
/*      */     
/* 1438 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1440 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1441 */           .addComponent(this.jLabel65, -2, 34, -2)
/* 1442 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1443 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1444 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1445 */           .addComponent(this.jLabel66)
/* 1446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1447 */           .addComponent(this.jPanel26, -2, 248, -2)
/* 1448 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1449 */           .addComponent(this.jLabel67)
/* 1450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1451 */           .addComponent(this.jPanel27, -2, 248, -2)
/* 1452 */           .addGap(18, 18, 18)
/* 1453 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1454 */             .addComponent(this.jButton19)
/* 1455 */             .addComponent(this.jButton20)
/* 1456 */             .addComponent(this.jButton21))
/* 1457 */           .addContainerGap(23, 32767)));
/*      */ 
/*      */     
/* 1460 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1461 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1462 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1464 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */     
/* 1466 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1467 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1468 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */ 
/*      */     
/* 1471 */     this.jDialog9.setTitle("Curso Básico de Seguridad");
/* 1472 */     this.jDialog9.setModal(true);
/*      */     
/* 1474 */     this.jPanel33.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/* 1476 */     this.jPanel29.setBackground(Color.white);
/* 1477 */     this.jPanel29.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 1479 */     this.jPanel30.setBackground(Color.white);
/*      */     
/* 1481 */     this.jLabel74.setHorizontalAlignment(0);
/* 1482 */     this.jLabel74.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 1484 */     this.jLabel75.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 1486 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 1487 */     this.jPanel30.setLayout(jPanel30Layout);
/* 1488 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 1489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1490 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 1491 */           .addComponent(this.jLabel74, -2, 127, -2)
/* 1492 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1493 */           .addComponent(this.jLabel75, -1, 239, 32767)));
/*      */     
/* 1495 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 1496 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1497 */         .addComponent(this.jLabel75)
/* 1498 */         .addComponent(this.jLabel74, -1, -1, 32767));
/*      */ 
/*      */     
/* 1501 */     this.jPanel31.setBackground(new Color(255, 0, 0));
/*      */     
/* 1503 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1504 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1505 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addGap(0, 0, 32767));
/*      */     
/* 1509 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1510 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1511 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 1514 */     this.jLabel76.setHorizontalAlignment(0);
/* 1515 */     this.jLabel76.setText("FOLIO");
/*      */     
/* 1517 */     this.jPanel32.setBackground(Color.white);
/* 1518 */     this.jPanel32.setLayout((LayoutManager)null);
/*      */     
/* 1520 */     this.jPanel34.setBackground(new Color(255, 0, 0));
/*      */     
/* 1522 */     this.jLabel77.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 1523 */     this.jLabel77.setForeground(Color.white);
/* 1524 */     this.jLabel77.setHorizontalAlignment(0);
/* 1525 */     this.jLabel77.setText("<html><center>EL PORTADOR DE ESTA TARJETA A ACREDITADO UN CURSO DE ORIENTACIÓN BÁSICA DE SEGURIDAD PARA INGRESAR A INSTALACIONES PETROLERAS</center></html>");
/*      */     
/* 1527 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1528 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1529 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1530 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1531 */         .addComponent(this.jLabel77, -1, 340, 32767));
/*      */     
/* 1533 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1534 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1535 */         .addComponent(this.jLabel77, -1, 100, 32767));
/*      */ 
/*      */     
/* 1538 */     this.jPanel32.add(this.jPanel34);
/* 1539 */     this.jPanel34.setBounds(20, 10, 340, 0);
/*      */     
/* 1541 */     this.jPanel35.setBackground(new Color(177, 189, 188));
/*      */     
/* 1543 */     this.jPanel36.setBackground(new Color(177, 189, 188));
/* 1544 */     this.jPanel36.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 1546 */     this.jLabel83.setHorizontalAlignment(0);
/* 1547 */     this.jLabel83.setText("NOMBRE:");
/* 1548 */     this.jPanel36.add(this.jLabel83);
/*      */     
/* 1550 */     this.jLabel93.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 1551 */     this.jLabel93.setHorizontalAlignment(0);
/* 1552 */     this.jLabel93.setText("NOMBRE DEL EMPLEADO");
/* 1553 */     this.jPanel36.add(this.jLabel93);
/*      */     
/* 1555 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 1556 */     this.jPanel35.setLayout(jPanel35Layout);
/* 1557 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 1558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1559 */         .addComponent(this.jPanel36, -1, -1, 32767));
/*      */     
/* 1561 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 1562 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1563 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/* 1564 */           .addContainerGap(64, 32767)
/* 1565 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 1566 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1569 */     this.jPanel32.add(this.jPanel35);
/* 1570 */     this.jPanel35.setBounds(0, 60, 370, 120);
/*      */     
/* 1572 */     this.jPanel37.setBackground(new Color(177, 189, 188));
/* 1573 */     this.jPanel37.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1574 */     this.jPanel37.setLayout(new GridLayout(1, 0));
/*      */     
/* 1576 */     this.jLabel98.setHorizontalAlignment(0);
/* 1577 */     this.jPanel37.add(this.jLabel98);
/*      */     
/* 1579 */     this.jPanel38.setBackground(Color.white);
/*      */     
/* 1581 */     this.jLabel101.setBackground(new Color(255, 0, 0));
/* 1582 */     this.jLabel101.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 1583 */     this.jLabel101.setForeground(new Color(255, 0, 0));
/* 1584 */     this.jLabel101.setText("CURSO BÁSICO DE SEGURIDAD");
/*      */     
/* 1586 */     this.jPanel39.setBackground(Color.white);
/* 1587 */     this.jPanel39.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/* 1589 */     this.jLabel122.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 1590 */     this.jLabel122.setText("DURACIÓN:");
/* 1591 */     this.jPanel39.add(this.jLabel122);
/*      */     
/* 1593 */     this.jPanel40.setBackground(Color.white);
/* 1594 */     this.jPanel40.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1596 */     this.jSpinner3.setModel(new SpinnerNumberModel(8, 1, 480, 1));
/* 1597 */     this.jPanel40.add(this.jSpinner3);
/*      */     
/* 1599 */     this.jLabel146.setText("hrs.");
/* 1600 */     this.jPanel40.add(this.jLabel146);
/*      */     
/* 1602 */     this.jPanel39.add(this.jPanel40);
/*      */     
/* 1604 */     this.jLabel140.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 1605 */     this.jLabel140.setText("VIGENCIA:");
/* 1606 */     this.jPanel39.add(this.jLabel140);
/*      */     
/* 1608 */     this.jDateChooser2.setIcon(this.icon);
/* 1609 */     this.jPanel39.add((Component)this.jDateChooser2);
/*      */     
/* 1611 */     this.jLabel142.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 1612 */     this.jLabel142.setText("FECHA:");
/* 1613 */     this.jPanel39.add(this.jLabel142);
/*      */     
/* 1615 */     this.jLabel143.setText("jLabel143");
/* 1616 */     this.jPanel39.add(this.jLabel143);
/*      */     
/* 1618 */     this.jLabel144.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 1619 */     this.jLabel144.setText("CATEGORÍA:");
/* 1620 */     this.jPanel39.add(this.jLabel144);
/*      */     
/* 1622 */     this.jTextField30.setText("jTextField29");
/* 1623 */     this.jPanel39.add(this.jTextField30);
/*      */     
/* 1625 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1626 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1627 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1628 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1629 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1630 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1631 */             .addComponent(this.jPanel39, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 1632 */             .addComponent(this.jLabel101, -1, -1, 32767))
/* 1633 */           .addContainerGap()));
/*      */     
/* 1635 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1636 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1637 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1638 */           .addComponent(this.jLabel101)
/* 1639 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1640 */           .addComponent(this.jPanel39, -1, 124, 32767)));
/*      */ 
/*      */     
/* 1643 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1644 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1645 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1646 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1647 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1648 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1649 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1650 */               .addComponent(this.jPanel37, -2, 114, -2)
/* 1651 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1652 */               .addComponent(this.jPanel38, -1, -1, 32767))
/* 1653 */             .addComponent(this.jPanel30, -2, -1, -2)
/* 1654 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1655 */               .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1656 */                 .addComponent(this.jPanel32, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1657 */                 .addComponent(this.jLabel76, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1658 */               .addGap(3, 3, 3)))
/* 1659 */           .addGap(12, 12, 12))
/* 1660 */         .addComponent(this.jPanel31, -1, -1, 32767));
/*      */     
/* 1662 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1664 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1665 */           .addComponent(this.jPanel30, -2, -1, -2)
/* 1666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1667 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 1668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1669 */           .addComponent(this.jLabel76)
/* 1670 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1671 */           .addComponent(this.jPanel32, -2, 178, -2)
/* 1672 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1673 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1674 */             .addComponent(this.jPanel38, -1, -1, 32767)
/* 1675 */             .addComponent(this.jPanel37, -1, -1, 32767))
/* 1676 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1679 */     this.jPanel33.add(this.jPanel29);
/*      */     
/* 1681 */     this.jPanel41.setBackground(Color.white);
/* 1682 */     this.jPanel41.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 1684 */     this.jPanel42.setBackground(Color.white);
/*      */     
/* 1686 */     this.jLabel128.setHorizontalAlignment(0);
/* 1687 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 1689 */     this.jLabel141.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 1691 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 1692 */     this.jPanel42.setLayout(jPanel42Layout);
/* 1693 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 1694 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1695 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1696 */           .addComponent(this.jLabel128, -2, 127, -2)
/* 1697 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1698 */           .addComponent(this.jLabel141, -1, 238, 32767)));
/*      */     
/* 1700 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 1701 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1702 */         .addComponent(this.jLabel141)
/* 1703 */         .addComponent(this.jLabel128, -1, -1, 32767));
/*      */ 
/*      */     
/* 1706 */     this.jPanel43.setBackground(new Color(255, 0, 0));
/*      */     
/* 1708 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 1709 */     this.jPanel43.setLayout(jPanel43Layout);
/* 1710 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 1711 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1712 */         .addGap(0, 390, 32767));
/*      */     
/* 1714 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 1715 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1716 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 1719 */     this.jLabel145.setHorizontalAlignment(0);
/* 1720 */     this.jLabel145.setText("FOLIO");
/*      */     
/* 1722 */     this.jPanel44.setBackground(Color.white);
/* 1723 */     this.jPanel44.setLayout((LayoutManager)null);
/*      */     
/* 1725 */     this.jLabel70.setHorizontalAlignment(0);
/* 1726 */     this.jLabel70.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/FirmaQHSE.jpg")));
/* 1727 */     this.jPanel44.add(this.jLabel70);
/* 1728 */     this.jLabel70.setBounds(20, 10, 340, 90);
/*      */     
/* 1730 */     this.jPanel45.setBackground(new Color(255, 0, 0));
/*      */     
/* 1732 */     this.jPanel46.setBackground(Color.white);
/*      */     
/* 1734 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 1735 */     this.jPanel46.setLayout(jPanel46Layout);
/* 1736 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 1737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1738 */         .addGap(0, 316, 32767));
/*      */     
/* 1740 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 1741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1742 */         .addGap(0, 76, 32767));
/*      */ 
/*      */     
/* 1745 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/* 1746 */     this.jPanel45.setLayout(jPanel45Layout);
/* 1747 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/* 1748 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1749 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 1750 */           .addContainerGap()
/* 1751 */           .addComponent(this.jPanel46, -1, -1, 32767)
/* 1752 */           .addContainerGap()));
/*      */     
/* 1754 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/* 1755 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1756 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 1757 */           .addContainerGap()
/* 1758 */           .addComponent(this.jPanel46, -1, -1, 32767)
/* 1759 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1762 */     this.jPanel44.add(this.jPanel45);
/* 1763 */     this.jPanel45.setBounds(20, 10, 340, 0);
/*      */     
/* 1765 */     this.jPanel47.setBackground(new Color(177, 189, 188));
/*      */     
/* 1767 */     this.jPanel48.setBackground(new Color(177, 189, 188));
/* 1768 */     this.jPanel48.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 1770 */     this.jLabel148.setHorizontalAlignment(0);
/* 1771 */     this.jLabel148.setText("AGENTE CAPACITADOR:");
/* 1772 */     this.jPanel48.add(this.jLabel148);
/*      */     
/* 1774 */     this.jLabel149.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 1775 */     this.jLabel149.setHorizontalAlignment(0);
/* 1776 */     this.jLabel149.setText("NOMBRE DEL EMPLEADO");
/* 1777 */     this.jPanel48.add(this.jLabel149);
/*      */     
/* 1779 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/* 1780 */     this.jPanel47.setLayout(jPanel47Layout);
/* 1781 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/* 1782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1783 */         .addComponent(this.jPanel48, -1, -1, 32767));
/*      */     
/* 1785 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/* 1786 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1787 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
/* 1788 */           .addContainerGap(64, 32767)
/* 1789 */           .addComponent(this.jPanel48, -2, -1, -2)
/* 1790 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1793 */     this.jPanel44.add(this.jPanel47);
/* 1794 */     this.jPanel47.setBounds(0, 60, 370, 120);
/*      */     
/* 1796 */     this.jPanel49.setBackground(new Color(177, 189, 188));
/* 1797 */     this.jPanel49.setLayout(new GridLayout(1, 0));
/*      */     
/* 1799 */     this.jPanel50.setBackground(Color.white);
/*      */     
/* 1801 */     this.jLabel151.setBackground(new Color(255, 0, 0));
/* 1802 */     this.jLabel151.setText("<html><b><center>CAPACITACIÓN ACREDITADA ANTE LA SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL CON EL NÚMERO DE REGISTRO:</center><b></html>");
/*      */     
/* 1804 */     this.jLabel147.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 1805 */     this.jLabel147.setHorizontalAlignment(0);
/* 1806 */     this.jLabel147.setText("jLabel147");
/*      */     
/* 1808 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 1809 */     this.jPanel50.setLayout(jPanel50Layout);
/* 1810 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 1811 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1812 */         .addComponent(this.jLabel147, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1813 */         .addComponent(this.jLabel151, -2, 0, 32767));
/*      */     
/* 1815 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 1816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1817 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 1818 */           .addComponent(this.jLabel151, -2, 103, -2)
/* 1819 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1820 */           .addComponent(this.jLabel147)
/* 1821 */           .addGap(0, 21, 32767)));
/*      */ 
/*      */     
/* 1824 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 1825 */     this.jPanel41.setLayout(jPanel41Layout);
/* 1826 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 1827 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1828 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 1829 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1830 */             .addComponent(this.jPanel43, -2, -1, -2)
/* 1831 */             .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1832 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel41Layout.createSequentialGroup()
/* 1833 */                 .addComponent(this.jPanel49, -2, 114, -2)
/* 1834 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1835 */                 .addComponent(this.jPanel50, -1, -1, 32767))
/* 1836 */               .addComponent(this.jPanel44, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1837 */               .addComponent(this.jLabel145, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1838 */               .addComponent(this.jPanel42, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1839 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1841 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 1842 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1843 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 1844 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 1845 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1846 */           .addComponent(this.jPanel43, -2, -1, -2)
/* 1847 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1848 */           .addComponent(this.jLabel145)
/* 1849 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1850 */           .addComponent(this.jPanel44, -2, 178, -2)
/* 1851 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1852 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1853 */             .addComponent(this.jPanel50, -1, -1, 32767)
/* 1854 */             .addComponent(this.jPanel49, -1, -1, 32767))
/* 1855 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1858 */     this.jPanel33.add(this.jPanel41);
/*      */     
/* 1860 */     this.materialButton29.setBackground(this.lc.SECUNDARIO1);
/* 1861 */     this.materialButton29.setForeground(new Color(255, 255, 255));
/* 1862 */     this.materialButton29.setMnemonic('C');
/* 1863 */     this.materialButton29.setText("Cancelar");
/* 1864 */     this.materialButton29.setToolTipText("Cancelar (Alt+C)");
/* 1865 */     this.materialButton29.setFont(new Font("Cantarell", 0, 12));
/* 1866 */     this.materialButton29.setHorizontalTextPosition(0);
/* 1867 */     this.materialButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1869 */             EmpleadosAgregar.this.materialButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1873 */     this.materialButton30.setBackground(this.lc.SECUNDARIO1);
/* 1874 */     this.materialButton30.setForeground(new Color(255, 255, 255));
/* 1875 */     this.materialButton30.setMnemonic('I');
/* 1876 */     this.materialButton30.setText("Imprimir");
/* 1877 */     this.materialButton30.setToolTipText("Imprimir (Alt+I)");
/* 1878 */     this.materialButton30.setFont(new Font("Cantarell", 0, 12));
/* 1879 */     this.materialButton30.setHorizontalTextPosition(0);
/* 1880 */     this.materialButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1882 */             EmpleadosAgregar.this.materialButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1886 */     this.materialButton31.setBackground(this.lc.SECUNDARIO1);
/* 1887 */     this.materialButton31.setForeground(new Color(255, 255, 255));
/* 1888 */     this.materialButton31.setMnemonic('R');
/* 1889 */     this.materialButton31.setText("< Regresar");
/* 1890 */     this.materialButton31.setToolTipText("Regresar (Alt+R)");
/* 1891 */     this.materialButton31.setFont(new Font("Cantarell", 0, 12));
/* 1892 */     this.materialButton31.setHorizontalTextPosition(0);
/* 1893 */     this.materialButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1895 */             EmpleadosAgregar.this.materialButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1899 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 1900 */     this.jPanel51.setLayout(jPanel51Layout);
/* 1901 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 1902 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1903 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
/* 1904 */           .addContainerGap(-1, 32767)
/* 1905 */           .addComponent((Component)this.materialButton31, -2, 105, -2)
/* 1906 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1907 */           .addComponent((Component)this.materialButton30, -2, 105, -2)
/* 1908 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1909 */           .addComponent((Component)this.materialButton29, -2, 105, -2)
/* 1910 */           .addContainerGap()));
/*      */     
/* 1912 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 1913 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1914 */         .addGroup(jPanel51Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1915 */           .addComponent((Component)this.materialButton29, -2, 38, -2)
/* 1916 */           .addComponent((Component)this.materialButton30, -2, 38, -2)
/* 1917 */           .addComponent((Component)this.materialButton31, -2, 38, -2)));
/*      */ 
/*      */     
/* 1920 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 1921 */     this.jPanel28.setLayout(jPanel28Layout);
/* 1922 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 1923 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1924 */         .addComponent(this.jPanel51, -1, -1, 32767)
/* 1925 */         .addComponent(this.jPanel33, -1, 763, 32767));
/*      */     
/* 1927 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 1928 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1929 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 1930 */           .addComponent(this.jPanel33, -1, -1, 32767)
/* 1931 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1932 */           .addComponent(this.jPanel51, -2, -1, -2)
/* 1933 */           .addGap(18, 18, 18)));
/*      */ 
/*      */     
/* 1936 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 1937 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 1938 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 1939 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1940 */         .addComponent(this.jPanel28, -1, -1, 32767));
/*      */     
/* 1942 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 1943 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1944 */         .addComponent(this.jPanel28, -1, -1, 32767));
/*      */ 
/*      */     
/* 1947 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 1948 */     this.jPanel4.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*      */     
/* 1950 */     this.jPanel52.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1952 */     this.jLabel4.setFont(new Font("Cantarell", 1, 22));
/* 1953 */     this.jLabel4.setForeground(this.lc.PRIMARIO2);
/* 1954 */     this.jLabel4.setHorizontalAlignment(0);
/* 1955 */     this.jLabel4.setText("       Agregar Empleados");
/*      */     
/* 1957 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 1958 */     this.jLabel9.setToolTipText("Cerrar");
/* 1959 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1961 */             EmpleadosAgregar.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1964 */             EmpleadosAgregar.this.jLabel9MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1967 */             EmpleadosAgregar.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1971 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 1972 */     this.jPanel52.setLayout(jPanel52Layout);
/* 1973 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 1974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1975 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 1976 */           .addComponent(this.jLabel4, -1, -1, 32767)
/* 1977 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1978 */           .addComponent(this.jLabel9)
/* 1979 */           .addContainerGap()));
/*      */     
/* 1981 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 1982 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1983 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 1984 */           .addContainerGap()
/* 1985 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1986 */             .addComponent(this.jLabel4)
/* 1987 */             .addComponent(this.jLabel9))
/* 1988 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1991 */     this.jPanel53.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1993 */     this.jLabel11.setFont(new Font("Cantarell", 2, 11));
/* 1994 */     this.jLabel11.setForeground(this.lc.PRIMARIO1);
/* 1995 */     this.jLabel11.setText("<html> Para almacenar un nuevo empleado por lo menos coloca la información remarcada.</html>");
/*      */     
/* 1997 */     this.jPanel9.setLayout(new GridLayout(1, 2, 30, 0));
/*      */     
/* 1999 */     GridBagLayout jPanel17Layout = new GridBagLayout();
/* 2000 */     jPanel17Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2001 */     jPanel17Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2002 */     this.jPanel17.setLayout(jPanel17Layout);
/*      */     
/* 2004 */     this.jLabel14.setFont(new Font("Cantarell", 1, 11));
/* 2005 */     this.jLabel14.setText("Nombre (s) ");
/* 2006 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 2007 */     gridBagConstraints.gridx = 2;
/* 2008 */     gridBagConstraints.gridy = 2;
/* 2009 */     gridBagConstraints.anchor = 17;
/* 2010 */     this.jPanel17.add(this.jLabel14, gridBagConstraints);
/*      */     
/* 2012 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2014 */             EmpleadosAgregar.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2017 */     gridBagConstraints = new GridBagConstraints();
/* 2018 */     gridBagConstraints.gridx = 4;
/* 2019 */     gridBagConstraints.gridy = 2;
/* 2020 */     gridBagConstraints.fill = 2;
/* 2021 */     gridBagConstraints.anchor = 18;
/* 2022 */     gridBagConstraints.weightx = 20.0D;
/* 2023 */     this.jPanel17.add(this.jTextField1, gridBagConstraints);
/*      */     
/* 2025 */     this.jLabel15.setFont(new Font("Cantarell", 1, 11));
/* 2026 */     this.jLabel15.setText("Apellido Paterno");
/* 2027 */     gridBagConstraints = new GridBagConstraints();
/* 2028 */     gridBagConstraints.gridx = 2;
/* 2029 */     gridBagConstraints.gridy = 4;
/* 2030 */     gridBagConstraints.anchor = 17;
/* 2031 */     this.jPanel17.add(this.jLabel15, gridBagConstraints);
/*      */     
/* 2033 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2035 */             EmpleadosAgregar.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2038 */     gridBagConstraints = new GridBagConstraints();
/* 2039 */     gridBagConstraints.gridx = 4;
/* 2040 */     gridBagConstraints.gridy = 4;
/* 2041 */     gridBagConstraints.fill = 2;
/* 2042 */     gridBagConstraints.anchor = 18;
/* 2043 */     gridBagConstraints.weightx = 20.0D;
/* 2044 */     this.jPanel17.add(this.jTextField2, gridBagConstraints);
/*      */     
/* 2046 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/* 2047 */     this.jLabel16.setText("Apellido Materno");
/* 2048 */     gridBagConstraints = new GridBagConstraints();
/* 2049 */     gridBagConstraints.gridx = 2;
/* 2050 */     gridBagConstraints.gridy = 6;
/* 2051 */     gridBagConstraints.anchor = 17;
/* 2052 */     this.jPanel17.add(this.jLabel16, gridBagConstraints);
/*      */     
/* 2054 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2056 */             EmpleadosAgregar.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 2059 */     gridBagConstraints = new GridBagConstraints();
/* 2060 */     gridBagConstraints.gridx = 4;
/* 2061 */     gridBagConstraints.gridy = 6;
/* 2062 */     gridBagConstraints.fill = 2;
/* 2063 */     gridBagConstraints.anchor = 18;
/* 2064 */     gridBagConstraints.weightx = 20.0D;
/* 2065 */     this.jPanel17.add(this.jTextField3, gridBagConstraints);
/*      */     
/* 2067 */     this.jLabel31.setFont(new Font("Cantarell", 1, 11));
/* 2068 */     this.jLabel31.setText("Clave");
/* 2069 */     gridBagConstraints = new GridBagConstraints();
/* 2070 */     gridBagConstraints.gridx = 2;
/* 2071 */     gridBagConstraints.gridy = 0;
/* 2072 */     gridBagConstraints.anchor = 17;
/* 2073 */     this.jPanel17.add(this.jLabel31, gridBagConstraints);
/*      */     
/* 2075 */     this.jTextField13.setFont(new Font("Tahoma", 1, 12));
/* 2076 */     this.jTextField13.setForeground(new Color(255, 255, 255));
/* 2077 */     this.jTextField13.setEnabled(false);
/* 2078 */     this.jTextField13.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2080 */             EmpleadosAgregar.this.jTextField13KeyReleased(evt);
/*      */           }
/*      */         });
/* 2083 */     gridBagConstraints = new GridBagConstraints();
/* 2084 */     gridBagConstraints.gridx = 4;
/* 2085 */     gridBagConstraints.gridy = 0;
/* 2086 */     gridBagConstraints.fill = 2;
/* 2087 */     gridBagConstraints.anchor = 18;
/* 2088 */     gridBagConstraints.weightx = 20.0D;
/* 2089 */     this.jPanel17.add(this.jTextField13, gridBagConstraints);
/*      */     
/* 2091 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2093 */             EmpleadosAgregar.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 2096 */     gridBagConstraints = new GridBagConstraints();
/* 2097 */     gridBagConstraints.gridx = 4;
/* 2098 */     gridBagConstraints.gridy = 8;
/* 2099 */     gridBagConstraints.fill = 2;
/* 2100 */     gridBagConstraints.anchor = 18;
/* 2101 */     gridBagConstraints.weightx = 20.0D;
/* 2102 */     this.jPanel17.add(this.jTextField4, gridBagConstraints);
/*      */     
/* 2104 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/* 2105 */     this.jLabel17.setText("Calle");
/* 2106 */     gridBagConstraints = new GridBagConstraints();
/* 2107 */     gridBagConstraints.gridx = 2;
/* 2108 */     gridBagConstraints.gridy = 8;
/* 2109 */     gridBagConstraints.anchor = 17;
/* 2110 */     this.jPanel17.add(this.jLabel17, gridBagConstraints);
/*      */     
/* 2112 */     this.jLabel18.setFont(new Font("Cantarell", 0, 11));
/* 2113 */     this.jLabel18.setText("Número");
/* 2114 */     gridBagConstraints = new GridBagConstraints();
/* 2115 */     gridBagConstraints.gridx = 2;
/* 2116 */     gridBagConstraints.gridy = 10;
/* 2117 */     gridBagConstraints.anchor = 17;
/* 2118 */     this.jPanel17.add(this.jLabel18, gridBagConstraints);
/*      */     
/* 2120 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2122 */             EmpleadosAgregar.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/* 2125 */     gridBagConstraints = new GridBagConstraints();
/* 2126 */     gridBagConstraints.gridx = 4;
/* 2127 */     gridBagConstraints.gridy = 10;
/* 2128 */     gridBagConstraints.fill = 2;
/* 2129 */     gridBagConstraints.anchor = 18;
/* 2130 */     gridBagConstraints.weightx = 20.0D;
/* 2131 */     this.jPanel17.add(this.jTextField5, gridBagConstraints);
/*      */     
/* 2133 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/* 2134 */     this.jLabel19.setText("Colonia");
/* 2135 */     gridBagConstraints = new GridBagConstraints();
/* 2136 */     gridBagConstraints.gridx = 2;
/* 2137 */     gridBagConstraints.gridy = 12;
/* 2138 */     gridBagConstraints.anchor = 17;
/* 2139 */     this.jPanel17.add(this.jLabel19, gridBagConstraints);
/*      */     
/* 2141 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2143 */             EmpleadosAgregar.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 2146 */     gridBagConstraints = new GridBagConstraints();
/* 2147 */     gridBagConstraints.gridx = 4;
/* 2148 */     gridBagConstraints.gridy = 12;
/* 2149 */     gridBagConstraints.fill = 2;
/* 2150 */     gridBagConstraints.anchor = 18;
/* 2151 */     gridBagConstraints.weightx = 20.0D;
/* 2152 */     this.jPanel17.add(this.jTextField6, gridBagConstraints);
/*      */     
/* 2154 */     this.jLabel20.setFont(new Font("Cantarell", 0, 11));
/* 2155 */     this.jLabel20.setText("Código Postal ");
/* 2156 */     gridBagConstraints = new GridBagConstraints();
/* 2157 */     gridBagConstraints.gridx = 2;
/* 2158 */     gridBagConstraints.gridy = 14;
/* 2159 */     gridBagConstraints.anchor = 17;
/* 2160 */     this.jPanel17.add(this.jLabel20, gridBagConstraints);
/*      */     
/* 2162 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2164 */             EmpleadosAgregar.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/* 2167 */     gridBagConstraints = new GridBagConstraints();
/* 2168 */     gridBagConstraints.gridx = 4;
/* 2169 */     gridBagConstraints.gridy = 14;
/* 2170 */     gridBagConstraints.fill = 2;
/* 2171 */     gridBagConstraints.anchor = 18;
/* 2172 */     gridBagConstraints.weightx = 20.0D;
/* 2173 */     this.jPanel17.add(this.jTextField7, gridBagConstraints);
/*      */     
/* 2175 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/* 2176 */     this.jLabel21.setText("Ciudad ");
/* 2177 */     gridBagConstraints = new GridBagConstraints();
/* 2178 */     gridBagConstraints.gridx = 2;
/* 2179 */     gridBagConstraints.gridy = 16;
/* 2180 */     gridBagConstraints.anchor = 21;
/* 2181 */     this.jPanel17.add(this.jLabel21, gridBagConstraints);
/*      */     
/* 2183 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2185 */             EmpleadosAgregar.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/* 2188 */     gridBagConstraints = new GridBagConstraints();
/* 2189 */     gridBagConstraints.gridx = 4;
/* 2190 */     gridBagConstraints.gridy = 16;
/* 2191 */     gridBagConstraints.fill = 2;
/* 2192 */     gridBagConstraints.weightx = 20.0D;
/* 2193 */     this.jPanel17.add(this.jTextField8, gridBagConstraints);
/*      */     
/* 2195 */     this.jPanel9.add(this.jPanel17);
/*      */     
/* 2197 */     GridBagLayout jPanel5Layout = new GridBagLayout();
/* 2198 */     jPanel5Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2199 */     jPanel5Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2200 */     this.jPanel5.setLayout(jPanel5Layout);
/*      */     
/* 2202 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/* 2203 */     this.jLabel22.setText("Estado");
/* 2204 */     gridBagConstraints = new GridBagConstraints();
/* 2205 */     gridBagConstraints.gridx = 2;
/* 2206 */     gridBagConstraints.gridy = 2;
/* 2207 */     gridBagConstraints.anchor = 17;
/* 2208 */     this.jPanel5.add(this.jLabel22, gridBagConstraints);
/*      */     
/* 2210 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2211 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/* 2212 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2214 */             EmpleadosAgregar.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2217 */     gridBagConstraints = new GridBagConstraints();
/* 2218 */     gridBagConstraints.gridx = 4;
/* 2219 */     gridBagConstraints.gridy = 2;
/* 2220 */     gridBagConstraints.fill = 2;
/* 2221 */     gridBagConstraints.anchor = 18;
/* 2222 */     gridBagConstraints.weightx = 1.0D;
/* 2223 */     this.jPanel5.add(this.jComboBox3, gridBagConstraints);
/*      */     
/* 2225 */     this.jLabel24.setFont(new Font("Cantarell", 0, 11));
/* 2226 */     this.jLabel24.setText("NSS ");
/* 2227 */     gridBagConstraints = new GridBagConstraints();
/* 2228 */     gridBagConstraints.gridx = 2;
/* 2229 */     gridBagConstraints.gridy = 4;
/* 2230 */     gridBagConstraints.anchor = 17;
/* 2231 */     this.jPanel5.add(this.jLabel24, gridBagConstraints);
/*      */     
/* 2233 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2235 */             EmpleadosAgregar.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/* 2238 */     gridBagConstraints = new GridBagConstraints();
/* 2239 */     gridBagConstraints.gridx = 4;
/* 2240 */     gridBagConstraints.gridy = 4;
/* 2241 */     gridBagConstraints.fill = 2;
/* 2242 */     gridBagConstraints.anchor = 18;
/* 2243 */     this.jPanel5.add(this.jTextField9, gridBagConstraints);
/*      */     
/* 2245 */     this.jLabel25.setFont(new Font("Cantarell", 0, 11));
/* 2246 */     this.jLabel25.setText("Curp ");
/* 2247 */     gridBagConstraints = new GridBagConstraints();
/* 2248 */     gridBagConstraints.gridx = 2;
/* 2249 */     gridBagConstraints.gridy = 6;
/* 2250 */     gridBagConstraints.anchor = 17;
/* 2251 */     this.jPanel5.add(this.jLabel25, gridBagConstraints);
/*      */     
/* 2253 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2255 */             EmpleadosAgregar.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/* 2258 */     gridBagConstraints = new GridBagConstraints();
/* 2259 */     gridBagConstraints.gridx = 4;
/* 2260 */     gridBagConstraints.gridy = 6;
/* 2261 */     gridBagConstraints.fill = 2;
/* 2262 */     gridBagConstraints.anchor = 18;
/* 2263 */     this.jPanel5.add(this.jTextField11, gridBagConstraints);
/*      */     
/* 2265 */     this.jLabel37.setFont(new Font("Cantarell", 0, 11));
/* 2266 */     this.jLabel37.setText("Teléfono");
/* 2267 */     gridBagConstraints = new GridBagConstraints();
/* 2268 */     gridBagConstraints.gridx = 2;
/* 2269 */     gridBagConstraints.gridy = 10;
/* 2270 */     gridBagConstraints.anchor = 17;
/* 2271 */     this.jPanel5.add(this.jLabel37, gridBagConstraints);
/*      */     
/* 2273 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 2275 */             EmpleadosAgregar.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/* 2278 */     gridBagConstraints = new GridBagConstraints();
/* 2279 */     gridBagConstraints.gridx = 4;
/* 2280 */     gridBagConstraints.gridy = 10;
/* 2281 */     gridBagConstraints.fill = 2;
/* 2282 */     gridBagConstraints.anchor = 18;
/* 2283 */     this.jPanel5.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/* 2285 */     this.jLabel38.setFont(new Font("Cantarell", 0, 11));
/* 2286 */     this.jLabel38.setText("Celular");
/* 2287 */     gridBagConstraints = new GridBagConstraints();
/* 2288 */     gridBagConstraints.gridx = 2;
/* 2289 */     gridBagConstraints.gridy = 12;
/* 2290 */     gridBagConstraints.anchor = 17;
/* 2291 */     this.jPanel5.add(this.jLabel38, gridBagConstraints);
/*      */     
/* 2293 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 2295 */             EmpleadosAgregar.this.jFormattedTextField2FocusLost(evt);
/*      */           }
/*      */         });
/* 2298 */     gridBagConstraints = new GridBagConstraints();
/* 2299 */     gridBagConstraints.gridx = 4;
/* 2300 */     gridBagConstraints.gridy = 12;
/* 2301 */     gridBagConstraints.fill = 2;
/* 2302 */     gridBagConstraints.anchor = 18;
/* 2303 */     this.jPanel5.add(this.jFormattedTextField2, gridBagConstraints);
/*      */     
/* 2305 */     this.jLabel39.setFont(new Font("Cantarell", 1, 11));
/* 2306 */     this.jLabel39.setText("Lugar de Nac");
/* 2307 */     gridBagConstraints = new GridBagConstraints();
/* 2308 */     gridBagConstraints.gridx = 2;
/* 2309 */     gridBagConstraints.gridy = 14;
/* 2310 */     gridBagConstraints.anchor = 17;
/* 2311 */     this.jPanel5.add(this.jLabel39, gridBagConstraints);
/* 2312 */     gridBagConstraints = new GridBagConstraints();
/* 2313 */     gridBagConstraints.gridx = 4;
/* 2314 */     gridBagConstraints.gridy = 14;
/* 2315 */     gridBagConstraints.fill = 2;
/* 2316 */     gridBagConstraints.anchor = 18;
/* 2317 */     this.jPanel5.add(this.jTextField14, gridBagConstraints);
/*      */     
/* 2319 */     this.jDateChooser1.setBackground(new Color(218, 231, 246));
/* 2320 */     this.jDateChooser1.setDateFormatString("yyyy/MM/dd");
/* 2321 */     this.jDateChooser1.setIcon(this.icon);
/* 2322 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/* 2323 */     this.jDateChooser1.setMinSelectableDate(new Date(-2208985701000L));
/* 2324 */     gridBagConstraints = new GridBagConstraints();
/* 2325 */     gridBagConstraints.gridx = 4;
/* 2326 */     gridBagConstraints.gridy = 16;
/* 2327 */     gridBagConstraints.fill = 2;
/* 2328 */     gridBagConstraints.anchor = 18;
/* 2329 */     this.jPanel5.add((Component)this.jDateChooser1, gridBagConstraints);
/*      */     
/* 2331 */     this.jLabel27.setFont(new Font("Cantarell", 1, 11));
/* 2332 */     this.jLabel27.setText("Fecha de Nac");
/* 2333 */     gridBagConstraints = new GridBagConstraints();
/* 2334 */     gridBagConstraints.gridx = 2;
/* 2335 */     gridBagConstraints.gridy = 16;
/* 2336 */     gridBagConstraints.anchor = 17;
/* 2337 */     this.jPanel5.add(this.jLabel27, gridBagConstraints);
/*      */     
/* 2339 */     this.jLabel26.setFont(new Font("Cantarell", 0, 11));
/* 2340 */     this.jLabel26.setText("RFC");
/* 2341 */     gridBagConstraints = new GridBagConstraints();
/* 2342 */     gridBagConstraints.gridx = 2;
/* 2343 */     gridBagConstraints.gridy = 8;
/* 2344 */     gridBagConstraints.ipadx = 13;
/* 2345 */     gridBagConstraints.anchor = 17;
/* 2346 */     this.jPanel5.add(this.jLabel26, gridBagConstraints);
/*      */     
/* 2348 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2350 */             EmpleadosAgregar.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/* 2353 */     gridBagConstraints = new GridBagConstraints();
/* 2354 */     gridBagConstraints.gridx = 4;
/* 2355 */     gridBagConstraints.gridy = 8;
/* 2356 */     gridBagConstraints.fill = 2;
/* 2357 */     gridBagConstraints.anchor = 18;
/* 2358 */     this.jPanel5.add(this.jTextField17, gridBagConstraints);
/*      */     
/* 2360 */     this.jPanel9.add(this.jPanel5);
/*      */     
/* 2362 */     this.jTabbedPane1.addTab("Datos Personales", this.jPanel9);
/*      */     
/* 2364 */     this.jPanel10.setLayout(new GridLayout(1, 2, 30, 0));
/*      */     
/* 2366 */     GridBagLayout jPanel18Layout = new GridBagLayout();
/* 2367 */     jPanel18Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2368 */     jPanel18Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2369 */     this.jPanel18.setLayout(jPanel18Layout);
/*      */     
/* 2371 */     this.jLabel35.setFont(new Font("Cantarell", 0, 11));
/* 2372 */     this.jLabel35.setHorizontalAlignment(4);
/* 2373 */     this.jLabel35.setText("Nextel ");
/* 2374 */     gridBagConstraints = new GridBagConstraints();
/* 2375 */     gridBagConstraints.gridx = 2;
/* 2376 */     gridBagConstraints.gridy = 2;
/* 2377 */     gridBagConstraints.anchor = 17;
/* 2378 */     gridBagConstraints.weightx = 0.2D;
/* 2379 */     this.jPanel18.add(this.jLabel35, gridBagConstraints);
/*      */     
/* 2381 */     this.jTextField16.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2383 */             EmpleadosAgregar.this.jTextField16KeyReleased(evt);
/*      */           }
/*      */         });
/* 2386 */     gridBagConstraints = new GridBagConstraints();
/* 2387 */     gridBagConstraints.gridx = 4;
/* 2388 */     gridBagConstraints.gridy = 2;
/* 2389 */     gridBagConstraints.gridwidth = 7;
/* 2390 */     gridBagConstraints.fill = 2;
/* 2391 */     gridBagConstraints.anchor = 18;
/* 2392 */     gridBagConstraints.weightx = 0.5D;
/* 2393 */     this.jPanel18.add(this.jTextField16, gridBagConstraints);
/*      */     
/* 2395 */     this.jLabel36.setFont(new Font("Cantarell", 0, 11));
/* 2396 */     this.jLabel36.setHorizontalAlignment(4);
/* 2397 */     this.jLabel36.setText("Cargo");
/* 2398 */     gridBagConstraints = new GridBagConstraints();
/* 2399 */     gridBagConstraints.gridx = 2;
/* 2400 */     gridBagConstraints.gridy = 4;
/* 2401 */     gridBagConstraints.anchor = 17;
/* 2402 */     gridBagConstraints.weightx = 0.2D;
/* 2403 */     this.jPanel18.add(this.jLabel36, gridBagConstraints);
/*      */     
/* 2405 */     this.jLabel40.setFont(new Font("Cantarell", 0, 11));
/* 2406 */     this.jLabel40.setHorizontalAlignment(4);
/* 2407 */     this.jLabel40.setText("Cargo Aut info");
/* 2408 */     gridBagConstraints = new GridBagConstraints();
/* 2409 */     gridBagConstraints.gridx = 2;
/* 2410 */     gridBagConstraints.gridy = 6;
/* 2411 */     gridBagConstraints.anchor = 17;
/* 2412 */     gridBagConstraints.weightx = 0.2D;
/* 2413 */     this.jPanel18.add(this.jLabel40, gridBagConstraints);
/*      */     
/* 2415 */     this.jLabel41.setFont(new Font("Cantarell", 0, 11));
/* 2416 */     this.jLabel41.setHorizontalAlignment(4);
/* 2417 */     this.jLabel41.setText("Cargo Aut Nextel ");
/* 2418 */     gridBagConstraints = new GridBagConstraints();
/* 2419 */     gridBagConstraints.gridx = 2;
/* 2420 */     gridBagConstraints.gridy = 0;
/* 2421 */     gridBagConstraints.anchor = 17;
/* 2422 */     gridBagConstraints.weightx = 0.2D;
/* 2423 */     this.jPanel18.add(this.jLabel41, gridBagConstraints);
/*      */     
/* 2425 */     this.jLabel42.setFont(new Font("Cantarell", 0, 11));
/* 2426 */     this.jLabel42.setHorizontalAlignment(4);
/* 2427 */     this.jLabel42.setText("Infonavit ");
/* 2428 */     gridBagConstraints = new GridBagConstraints();
/* 2429 */     gridBagConstraints.gridx = 2;
/* 2430 */     gridBagConstraints.gridy = 8;
/* 2431 */     gridBagConstraints.anchor = 17;
/* 2432 */     gridBagConstraints.weightx = 0.2D;
/* 2433 */     this.jPanel18.add(this.jLabel42, gridBagConstraints);
/*      */     
/* 2435 */     this.jLabel43.setFont(new Font("Cantarell", 0, 11));
/* 2436 */     this.jLabel43.setHorizontalAlignment(4);
/* 2437 */     this.jLabel43.setText("Cargo");
/* 2438 */     gridBagConstraints = new GridBagConstraints();
/* 2439 */     gridBagConstraints.gridx = 2;
/* 2440 */     gridBagConstraints.gridy = 10;
/* 2441 */     gridBagConstraints.anchor = 17;
/* 2442 */     gridBagConstraints.weightx = 0.2D;
/* 2443 */     this.jPanel18.add(this.jLabel43, gridBagConstraints);
/*      */     
/* 2445 */     this.jLabel44.setFont(new Font("Cantarell", 1, 11));
/* 2446 */     this.jLabel44.setHorizontalAlignment(4);
/* 2447 */     this.jLabel44.setText("Tipo de Empleado");
/* 2448 */     gridBagConstraints = new GridBagConstraints();
/* 2449 */     gridBagConstraints.gridx = 2;
/* 2450 */     gridBagConstraints.gridy = 12;
/* 2451 */     gridBagConstraints.anchor = 17;
/* 2452 */     gridBagConstraints.weightx = 0.2D;
/* 2453 */     this.jPanel18.add(this.jLabel44, gridBagConstraints);
/*      */     
/* 2455 */     this.jLabel45.setFont(new Font("Cantarell", 1, 11));
/* 2456 */     this.jLabel45.setHorizontalAlignment(4);
/* 2457 */     this.jLabel45.setText("Departamento");
/* 2458 */     gridBagConstraints = new GridBagConstraints();
/* 2459 */     gridBagConstraints.gridx = 2;
/* 2460 */     gridBagConstraints.gridy = 14;
/* 2461 */     gridBagConstraints.anchor = 17;
/* 2462 */     gridBagConstraints.weightx = 0.2D;
/* 2463 */     this.jPanel18.add(this.jLabel45, gridBagConstraints);
/*      */     
/* 2465 */     this.jRadioButton3.setSelected(true);
/* 2466 */     this.jRadioButton3.setText("No");
/* 2467 */     gridBagConstraints = new GridBagConstraints();
/* 2468 */     gridBagConstraints.gridx = 4;
/* 2469 */     gridBagConstraints.gridy = 0;
/* 2470 */     gridBagConstraints.anchor = 18;
/* 2471 */     this.jPanel18.add(this.jRadioButton3, gridBagConstraints);
/*      */     
/* 2473 */     this.jRadioButton4.setText("Si");
/* 2474 */     gridBagConstraints = new GridBagConstraints();
/* 2475 */     gridBagConstraints.gridx = 6;
/* 2476 */     gridBagConstraints.gridy = 0;
/* 2477 */     gridBagConstraints.anchor = 18;
/* 2478 */     this.jPanel18.add(this.jRadioButton4, gridBagConstraints);
/*      */     
/* 2480 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/* 2481 */     gridBagConstraints = new GridBagConstraints();
/* 2482 */     gridBagConstraints.gridx = 4;
/* 2483 */     gridBagConstraints.gridy = 4;
/* 2484 */     gridBagConstraints.gridwidth = 7;
/* 2485 */     gridBagConstraints.fill = 2;
/* 2486 */     gridBagConstraints.anchor = 18;
/* 2487 */     gridBagConstraints.weightx = 0.5D;
/* 2488 */     this.jPanel18.add(this.jFormattedTextField6, gridBagConstraints);
/*      */     
/* 2490 */     this.jRadioButton5.setSelected(true);
/* 2491 */     this.jRadioButton5.setText("No");
/* 2492 */     gridBagConstraints = new GridBagConstraints();
/* 2493 */     gridBagConstraints.gridx = 4;
/* 2494 */     gridBagConstraints.gridy = 6;
/* 2495 */     gridBagConstraints.anchor = 18;
/* 2496 */     this.jPanel18.add(this.jRadioButton5, gridBagConstraints);
/*      */     
/* 2498 */     this.jRadioButton6.setText("Si");
/* 2499 */     gridBagConstraints = new GridBagConstraints();
/* 2500 */     gridBagConstraints.gridx = 6;
/* 2501 */     gridBagConstraints.gridy = 6;
/* 2502 */     gridBagConstraints.anchor = 18;
/* 2503 */     this.jPanel18.add(this.jRadioButton6, gridBagConstraints);
/* 2504 */     gridBagConstraints = new GridBagConstraints();
/* 2505 */     gridBagConstraints.gridx = 4;
/* 2506 */     gridBagConstraints.gridy = 8;
/* 2507 */     gridBagConstraints.gridwidth = 7;
/* 2508 */     gridBagConstraints.fill = 2;
/* 2509 */     gridBagConstraints.anchor = 18;
/* 2510 */     gridBagConstraints.weightx = 0.5D;
/* 2511 */     this.jPanel18.add(this.jTextField15, gridBagConstraints);
/*      */     
/* 2513 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 2514 */     this.jFormattedTextField3.setText("$0.0");
/* 2515 */     gridBagConstraints = new GridBagConstraints();
/* 2516 */     gridBagConstraints.gridx = 4;
/* 2517 */     gridBagConstraints.gridy = 10;
/* 2518 */     gridBagConstraints.gridwidth = 7;
/* 2519 */     gridBagConstraints.fill = 2;
/* 2520 */     gridBagConstraints.anchor = 18;
/* 2521 */     gridBagConstraints.weightx = 0.5D;
/* 2522 */     this.jPanel18.add(this.jFormattedTextField3, gridBagConstraints);
/*      */     
/* 2524 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 2525 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "EMPLEADO", "FUNCIONARIO" }));
/* 2526 */     gridBagConstraints = new GridBagConstraints();
/* 2527 */     gridBagConstraints.gridx = 4;
/* 2528 */     gridBagConstraints.gridy = 12;
/* 2529 */     gridBagConstraints.gridwidth = 7;
/* 2530 */     gridBagConstraints.fill = 2;
/* 2531 */     gridBagConstraints.anchor = 18;
/* 2532 */     gridBagConstraints.weightx = 0.5D;
/* 2533 */     this.jPanel18.add(this.jComboBox5, gridBagConstraints);
/*      */     
/* 2535 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2536 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno..." }));
/* 2537 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2539 */             EmpleadosAgregar.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2542 */     gridBagConstraints = new GridBagConstraints();
/* 2543 */     gridBagConstraints.gridx = 4;
/* 2544 */     gridBagConstraints.gridy = 14;
/* 2545 */     gridBagConstraints.gridwidth = 5;
/* 2546 */     gridBagConstraints.fill = 2;
/* 2547 */     gridBagConstraints.weightx = 0.5D;
/* 2548 */     this.jPanel18.add(this.jComboBox1, gridBagConstraints);
/*      */     
/* 2550 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 2551 */     this.jButton4.setToolTipText("Administrar departamentos");
/* 2552 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2554 */             EmpleadosAgregar.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2557 */     gridBagConstraints = new GridBagConstraints();
/* 2558 */     gridBagConstraints.gridx = 10;
/* 2559 */     gridBagConstraints.gridy = 14;
/* 2560 */     this.jPanel18.add(this.jButton4, gridBagConstraints);
/*      */     
/* 2562 */     this.jPanel10.add(this.jPanel18);
/*      */     
/* 2564 */     GridBagLayout jPanel12Layout = new GridBagLayout();
/* 2565 */     jPanel12Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2566 */     jPanel12Layout.rowHeights = new int[] { 0, 5, 0 };
/* 2567 */     this.jPanel12.setLayout(jPanel12Layout);
/*      */     
/* 2569 */     this.jLabel46.setFont(new Font("Cantarell", 0, 11));
/* 2570 */     this.jLabel46.setHorizontalAlignment(4);
/* 2571 */     this.jLabel46.setText("Sexo");
/* 2572 */     gridBagConstraints = new GridBagConstraints();
/* 2573 */     gridBagConstraints.gridx = 2;
/* 2574 */     gridBagConstraints.gridy = 0;
/* 2575 */     gridBagConstraints.anchor = 17;
/* 2576 */     gridBagConstraints.weightx = 0.1D;
/* 2577 */     this.jPanel12.add(this.jLabel46, gridBagConstraints);
/*      */     
/* 2579 */     this.jLabel47.setFont(new Font("Cantarell", 0, 11));
/* 2580 */     this.jLabel47.setHorizontalAlignment(4);
/* 2581 */     this.jLabel47.setText("Correo Electrónico");
/* 2582 */     gridBagConstraints = new GridBagConstraints();
/* 2583 */     gridBagConstraints.gridx = 2;
/* 2584 */     gridBagConstraints.gridy = 2;
/* 2585 */     gridBagConstraints.anchor = 17;
/* 2586 */     gridBagConstraints.weightx = 0.1D;
/* 2587 */     this.jPanel12.add(this.jLabel47, gridBagConstraints);
/*      */     
/* 2589 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2590 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "MASCULINO", "FEMENINO" }));
/* 2591 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2593 */             EmpleadosAgregar.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2596 */     gridBagConstraints = new GridBagConstraints();
/* 2597 */     gridBagConstraints.gridx = 4;
/* 2598 */     gridBagConstraints.gridy = 0;
/* 2599 */     gridBagConstraints.fill = 2;
/* 2600 */     gridBagConstraints.anchor = 21;
/* 2601 */     gridBagConstraints.weightx = 0.2D;
/* 2602 */     this.jPanel12.add(this.jComboBox2, gridBagConstraints);
/*      */     
/* 2604 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2606 */             EmpleadosAgregar.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/* 2609 */     gridBagConstraints = new GridBagConstraints();
/* 2610 */     gridBagConstraints.gridx = 4;
/* 2611 */     gridBagConstraints.gridy = 2;
/* 2612 */     gridBagConstraints.fill = 2;
/* 2613 */     gridBagConstraints.anchor = 17;
/* 2614 */     gridBagConstraints.weightx = 0.2D;
/* 2615 */     this.jPanel12.add(this.jTextField10, gridBagConstraints);
/*      */     
/* 2617 */     this.jPanel10.add(this.jPanel12);
/*      */     
/* 2619 */     this.jTabbedPane1.addTab("tab2", this.jPanel10);
/*      */     
/* 2621 */     this.jPanel11.setLayout(new GridLayout(1, 2, 30, 0));
/*      */     
/* 2623 */     GridBagLayout jPanel23Layout = new GridBagLayout();
/* 2624 */     jPanel23Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2625 */     jPanel23Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2626 */     this.jPanel23.setLayout(jPanel23Layout);
/*      */     
/* 2628 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 2629 */     this.jLabel48.setHorizontalAlignment(4);
/* 2630 */     this.jLabel48.setText("Ultimo Ingreso");
/* 2631 */     gridBagConstraints = new GridBagConstraints();
/* 2632 */     gridBagConstraints.gridx = 2;
/* 2633 */     gridBagConstraints.gridy = 2;
/* 2634 */     gridBagConstraints.anchor = 17;
/* 2635 */     gridBagConstraints.weightx = 1.0D;
/* 2636 */     this.jPanel23.add(this.jLabel48, gridBagConstraints);
/*      */     
/* 2638 */     this.jLabel49.setFont(new Font("Cantarell", 0, 11));
/* 2639 */     this.jLabel49.setHorizontalAlignment(4);
/* 2640 */     this.jLabel49.setText("Días del contrato");
/* 2641 */     gridBagConstraints = new GridBagConstraints();
/* 2642 */     gridBagConstraints.gridx = 2;
/* 2643 */     gridBagConstraints.gridy = 4;
/* 2644 */     gridBagConstraints.anchor = 17;
/* 2645 */     gridBagConstraints.weightx = 1.0D;
/* 2646 */     this.jPanel23.add(this.jLabel49, gridBagConstraints);
/*      */     
/* 2648 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/* 2649 */     this.jLabel50.setHorizontalAlignment(4);
/* 2650 */     this.jLabel50.setText("Etiquetar ");
/* 2651 */     gridBagConstraints = new GridBagConstraints();
/* 2652 */     gridBagConstraints.gridx = 2;
/* 2653 */     gridBagConstraints.gridy = 6;
/* 2654 */     gridBagConstraints.anchor = 17;
/* 2655 */     gridBagConstraints.weightx = 1.0D;
/* 2656 */     this.jPanel23.add(this.jLabel50, gridBagConstraints);
/*      */     
/* 2658 */     this.jLabel51.setFont(new Font("Cantarell", 0, 11));
/* 2659 */     this.jLabel51.setHorizontalAlignment(4);
/* 2660 */     this.jLabel51.setText("Fecha de ingreso");
/* 2661 */     gridBagConstraints = new GridBagConstraints();
/* 2662 */     gridBagConstraints.gridx = 2;
/* 2663 */     gridBagConstraints.gridy = 0;
/* 2664 */     gridBagConstraints.anchor = 17;
/* 2665 */     gridBagConstraints.weightx = 1.0D;
/* 2666 */     this.jPanel23.add(this.jLabel51, gridBagConstraints);
/*      */     
/* 2668 */     this.jLabel52.setFont(new Font("Cantarell", 1, 11));
/* 2669 */     this.jLabel52.setHorizontalAlignment(4);
/* 2670 */     this.jLabel52.setText("Estado Civil ");
/* 2671 */     gridBagConstraints = new GridBagConstraints();
/* 2672 */     gridBagConstraints.gridx = 2;
/* 2673 */     gridBagConstraints.gridy = 8;
/* 2674 */     gridBagConstraints.anchor = 17;
/* 2675 */     gridBagConstraints.weightx = 1.0D;
/* 2676 */     this.jPanel23.add(this.jLabel52, gridBagConstraints);
/*      */     
/* 2678 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 2679 */     this.jLabel53.setHorizontalAlignment(4);
/* 2680 */     this.jLabel53.setText("Número de Hijos");
/* 2681 */     gridBagConstraints = new GridBagConstraints();
/* 2682 */     gridBagConstraints.gridx = 2;
/* 2683 */     gridBagConstraints.gridy = 10;
/* 2684 */     gridBagConstraints.anchor = 17;
/* 2685 */     gridBagConstraints.weightx = 1.0D;
/* 2686 */     this.jPanel23.add(this.jLabel53, gridBagConstraints);
/*      */     
/* 2688 */     this.jLabel54.setFont(new Font("Cantarell", 0, 11));
/* 2689 */     this.jLabel54.setHorizontalAlignment(4);
/* 2690 */     this.jLabel54.setText("Salario Nominal");
/* 2691 */     gridBagConstraints = new GridBagConstraints();
/* 2692 */     gridBagConstraints.gridx = 2;
/* 2693 */     gridBagConstraints.gridy = 12;
/* 2694 */     gridBagConstraints.anchor = 17;
/* 2695 */     gridBagConstraints.weightx = 1.0D;
/* 2696 */     this.jPanel23.add(this.jLabel54, gridBagConstraints);
/*      */     
/* 2698 */     this.jLabel55.setFont(new Font("Cantarell", 0, 11));
/* 2699 */     this.jLabel55.setHorizontalAlignment(4);
/* 2700 */     this.jLabel55.setText("Salario Real ");
/* 2701 */     gridBagConstraints = new GridBagConstraints();
/* 2702 */     gridBagConstraints.gridx = 2;
/* 2703 */     gridBagConstraints.gridy = 14;
/* 2704 */     gridBagConstraints.anchor = 17;
/* 2705 */     gridBagConstraints.weightx = 1.0D;
/* 2706 */     this.jPanel23.add(this.jLabel55, gridBagConstraints);
/*      */     
/* 2708 */     this.jDateChooser3.setBackground(new Color(218, 231, 246));
/* 2709 */     this.jDateChooser3.setDateFormatString("yyyy/MM/dd");
/* 2710 */     this.jDateChooser3.setIcon(this.icon);
/* 2711 */     this.jDateChooser3.setMaxSelectableDate(this.fechaActual);
/* 2712 */     this.jDateChooser3.setMinSelectableDate(new Date(-2208985701000L));
/* 2713 */     gridBagConstraints = new GridBagConstraints();
/* 2714 */     gridBagConstraints.gridx = 4;
/* 2715 */     gridBagConstraints.gridy = 0;
/* 2716 */     gridBagConstraints.fill = 2;
/* 2717 */     gridBagConstraints.ipadx = 1;
/* 2718 */     gridBagConstraints.anchor = 17;
/* 2719 */     gridBagConstraints.weightx = 3.0D;
/* 2720 */     this.jPanel23.add((Component)this.jDateChooser3, gridBagConstraints);
/*      */     
/* 2722 */     this.jDateChooser4.setBackground(new Color(218, 231, 246));
/* 2723 */     this.jDateChooser4.setDateFormatString("yyyy/MM/dd");
/* 2724 */     this.jDateChooser4.setIcon(this.icon);
/* 2725 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 2726 */     this.jDateChooser4.setMinSelectableDate(new Date(-2208985701000L));
/* 2727 */     gridBagConstraints = new GridBagConstraints();
/* 2728 */     gridBagConstraints.gridx = 4;
/* 2729 */     gridBagConstraints.gridy = 2;
/* 2730 */     gridBagConstraints.fill = 2;
/* 2731 */     gridBagConstraints.ipadx = 1;
/* 2732 */     gridBagConstraints.anchor = 17;
/* 2733 */     gridBagConstraints.weightx = 3.0D;
/* 2734 */     this.jPanel23.add((Component)this.jDateChooser4, gridBagConstraints);
/*      */     
/* 2736 */     this.jSpinner1.setModel(new SpinnerNumberModel(28, 28, 730, 1));
/* 2737 */     gridBagConstraints = new GridBagConstraints();
/* 2738 */     gridBagConstraints.gridx = 4;
/* 2739 */     gridBagConstraints.gridy = 4;
/* 2740 */     gridBagConstraints.fill = 2;
/* 2741 */     gridBagConstraints.ipadx = 1;
/* 2742 */     gridBagConstraints.anchor = 17;
/* 2743 */     gridBagConstraints.weightx = 3.0D;
/* 2744 */     this.jPanel23.add(this.jSpinner1, gridBagConstraints);
/*      */     
/* 2746 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 2747 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "VACÍO", "A PRUEBA", "MALO", "NO CONTRATABLE", "BUENO", "MUY BUENO", "EXCELENTE" }));
/* 2748 */     gridBagConstraints = new GridBagConstraints();
/* 2749 */     gridBagConstraints.gridx = 4;
/* 2750 */     gridBagConstraints.gridy = 6;
/* 2751 */     gridBagConstraints.fill = 2;
/* 2752 */     gridBagConstraints.ipadx = 1;
/* 2753 */     gridBagConstraints.anchor = 17;
/* 2754 */     gridBagConstraints.weightx = 3.0D;
/* 2755 */     this.jPanel23.add(this.jComboBox6, gridBagConstraints);
/*      */     
/* 2757 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 2758 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "SOLTERO", "CASADO", "DIVORSIADO", "VIUDO", "UNIÓN LIBRE" }));
/* 2759 */     gridBagConstraints = new GridBagConstraints();
/* 2760 */     gridBagConstraints.gridx = 4;
/* 2761 */     gridBagConstraints.gridy = 8;
/* 2762 */     gridBagConstraints.fill = 2;
/* 2763 */     gridBagConstraints.ipadx = 1;
/* 2764 */     gridBagConstraints.anchor = 17;
/* 2765 */     gridBagConstraints.weightx = 3.0D;
/* 2766 */     this.jPanel23.add(this.jComboBox7, gridBagConstraints);
/*      */     
/* 2768 */     this.jSpinner2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
/* 2769 */     gridBagConstraints = new GridBagConstraints();
/* 2770 */     gridBagConstraints.gridx = 4;
/* 2771 */     gridBagConstraints.gridy = 10;
/* 2772 */     gridBagConstraints.fill = 2;
/* 2773 */     gridBagConstraints.ipadx = 1;
/* 2774 */     gridBagConstraints.anchor = 17;
/* 2775 */     gridBagConstraints.weightx = 3.0D;
/* 2776 */     this.jPanel23.add(this.jSpinner2, gridBagConstraints);
/*      */     
/* 2778 */     this.jFormattedTextField7.setHorizontalAlignment(4);
/* 2779 */     gridBagConstraints = new GridBagConstraints();
/* 2780 */     gridBagConstraints.gridx = 4;
/* 2781 */     gridBagConstraints.gridy = 12;
/* 2782 */     gridBagConstraints.fill = 2;
/* 2783 */     gridBagConstraints.ipadx = 1;
/* 2784 */     gridBagConstraints.anchor = 17;
/* 2785 */     gridBagConstraints.weightx = 3.0D;
/* 2786 */     this.jPanel23.add(this.jFormattedTextField7, gridBagConstraints);
/*      */     
/* 2788 */     this.jFormattedTextField8.setHorizontalAlignment(4);
/* 2789 */     gridBagConstraints = new GridBagConstraints();
/* 2790 */     gridBagConstraints.gridx = 4;
/* 2791 */     gridBagConstraints.gridy = 14;
/* 2792 */     gridBagConstraints.fill = 2;
/* 2793 */     gridBagConstraints.ipadx = 1;
/* 2794 */     gridBagConstraints.anchor = 17;
/* 2795 */     gridBagConstraints.weightx = 3.0D;
/* 2796 */     this.jPanel23.add(this.jFormattedTextField8, gridBagConstraints);
/*      */     
/* 2798 */     this.jPanel11.add(this.jPanel23);
/*      */     
/* 2800 */     GridBagLayout jPanel13Layout = new GridBagLayout();
/* 2801 */     jPanel13Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2802 */     jPanel13Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2803 */     this.jPanel13.setLayout(jPanel13Layout);
/*      */     
/* 2805 */     this.jLabel56.setFont(new Font("Cantarell", 1, 11));
/* 2806 */     this.jLabel56.setHorizontalAlignment(4);
/* 2807 */     this.jLabel56.setText("Contratado por ");
/* 2808 */     gridBagConstraints = new GridBagConstraints();
/* 2809 */     gridBagConstraints.gridx = 2;
/* 2810 */     gridBagConstraints.gridy = 0;
/* 2811 */     gridBagConstraints.anchor = 17;
/* 2812 */     this.jPanel13.add(this.jLabel56, gridBagConstraints);
/*      */     
/* 2814 */     this.jLabel57.setFont(new Font("Cantarell", 0, 11));
/* 2815 */     this.jLabel57.setHorizontalAlignment(4);
/* 2816 */     this.jLabel57.setText("Testigo 1");
/* 2817 */     gridBagConstraints = new GridBagConstraints();
/* 2818 */     gridBagConstraints.gridx = 2;
/* 2819 */     gridBagConstraints.gridy = 2;
/* 2820 */     gridBagConstraints.anchor = 17;
/* 2821 */     this.jPanel13.add(this.jLabel57, gridBagConstraints);
/*      */     
/* 2823 */     this.jTextField25.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2825 */             EmpleadosAgregar.this.jTextField25KeyReleased(evt);
/*      */           }
/*      */         });
/* 2828 */     gridBagConstraints = new GridBagConstraints();
/* 2829 */     gridBagConstraints.gridx = 4;
/* 2830 */     gridBagConstraints.gridy = 0;
/* 2831 */     gridBagConstraints.fill = 2;
/* 2832 */     gridBagConstraints.anchor = 18;
/* 2833 */     gridBagConstraints.weightx = 1.0D;
/* 2834 */     this.jPanel13.add(this.jTextField25, gridBagConstraints);
/*      */     
/* 2836 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/* 2837 */     this.jLabel58.setHorizontalAlignment(4);
/* 2838 */     this.jLabel58.setText("Testigo 2 ");
/* 2839 */     gridBagConstraints = new GridBagConstraints();
/* 2840 */     gridBagConstraints.gridx = 2;
/* 2841 */     gridBagConstraints.gridy = 4;
/* 2842 */     gridBagConstraints.anchor = 17;
/* 2843 */     this.jPanel13.add(this.jLabel58, gridBagConstraints);
/*      */     
/* 2845 */     this.jTextField26.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2847 */             EmpleadosAgregar.this.jTextField26KeyReleased(evt);
/*      */           }
/*      */         });
/* 2850 */     gridBagConstraints = new GridBagConstraints();
/* 2851 */     gridBagConstraints.gridx = 4;
/* 2852 */     gridBagConstraints.gridy = 4;
/* 2853 */     gridBagConstraints.fill = 2;
/* 2854 */     gridBagConstraints.anchor = 18;
/* 2855 */     gridBagConstraints.weightx = 1.0D;
/* 2856 */     this.jPanel13.add(this.jTextField26, gridBagConstraints);
/*      */     
/* 2858 */     this.jLabel59.setFont(new Font("Cantarell", 0, 11));
/* 2859 */     this.jLabel59.setHorizontalAlignment(4);
/* 2860 */     this.jLabel59.setText("Recomendado por");
/* 2861 */     gridBagConstraints = new GridBagConstraints();
/* 2862 */     gridBagConstraints.gridx = 2;
/* 2863 */     gridBagConstraints.gridy = 6;
/* 2864 */     gridBagConstraints.anchor = 17;
/* 2865 */     this.jPanel13.add(this.jLabel59, gridBagConstraints);
/*      */     
/* 2867 */     this.jTextField27.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2869 */             EmpleadosAgregar.this.jTextField27KeyReleased(evt);
/*      */           }
/*      */         });
/* 2872 */     gridBagConstraints = new GridBagConstraints();
/* 2873 */     gridBagConstraints.gridx = 4;
/* 2874 */     gridBagConstraints.gridy = 6;
/* 2875 */     gridBagConstraints.fill = 2;
/* 2876 */     gridBagConstraints.anchor = 18;
/* 2877 */     gridBagConstraints.weightx = 1.0D;
/* 2878 */     this.jPanel13.add(this.jTextField27, gridBagConstraints);
/*      */     
/* 2880 */     this.jLabel60.setFont(new Font("Cantarell", 0, 11));
/* 2881 */     this.jLabel60.setHorizontalAlignment(0);
/* 2882 */     this.jLabel60.setText("Otros Datos");
/* 2883 */     gridBagConstraints = new GridBagConstraints();
/* 2884 */     gridBagConstraints.gridx = 2;
/* 2885 */     gridBagConstraints.gridy = 8;
/* 2886 */     gridBagConstraints.gridwidth = 3;
/* 2887 */     this.jPanel13.add(this.jLabel60, gridBagConstraints);
/*      */     
/* 2889 */     this.jTextField29.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2891 */             EmpleadosAgregar.this.jTextField29KeyReleased(evt);
/*      */           }
/*      */         });
/* 2894 */     gridBagConstraints = new GridBagConstraints();
/* 2895 */     gridBagConstraints.gridx = 4;
/* 2896 */     gridBagConstraints.gridy = 2;
/* 2897 */     gridBagConstraints.fill = 2;
/* 2898 */     gridBagConstraints.anchor = 18;
/* 2899 */     gridBagConstraints.weightx = 1.0D;
/* 2900 */     this.jPanel13.add(this.jTextField29, gridBagConstraints);
/*      */     
/* 2902 */     this.jTextArea1.setColumns(20);
/* 2903 */     this.jTextArea1.setRows(5);
/* 2904 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/* 2906 */     gridBagConstraints = new GridBagConstraints();
/* 2907 */     gridBagConstraints.gridx = 2;
/* 2908 */     gridBagConstraints.gridy = 10;
/* 2909 */     gridBagConstraints.gridwidth = 3;
/* 2910 */     gridBagConstraints.gridheight = 3;
/* 2911 */     gridBagConstraints.fill = 1;
/* 2912 */     gridBagConstraints.ipady = 26;
/* 2913 */     gridBagConstraints.anchor = 18;
/* 2914 */     this.jPanel13.add(this.jScrollPane2, gridBagConstraints);
/*      */     
/* 2916 */     this.jPanel11.add(this.jPanel13);
/*      */     
/* 2918 */     this.jTabbedPane1.addTab("tab3", this.jPanel11);
/*      */     
/* 2920 */     this.jPanel54.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2922 */     this.jPanel55.setBackground(this.lc.SECUNDARIO2);
/* 2923 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2925 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulDer.png")));
/* 2926 */     this.jButton12.setEnabled(false);
/* 2927 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2929 */             EmpleadosAgregar.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2932 */     this.jPanel55.add(this.jButton12);
/*      */     
/* 2934 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulIzq.png")));
/* 2935 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2937 */             EmpleadosAgregar.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2940 */     this.jPanel55.add(this.jButton13);
/*      */     
/* 2942 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/* 2943 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/* 2944 */     this.materialButton18.setMnemonic('L');
/* 2945 */     this.materialButton18.setText("Limpiar");
/* 2946 */     this.materialButton18.setToolTipText("Limpiar (Alt+L)");
/* 2947 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/* 2948 */     this.materialButton18.setHorizontalTextPosition(0);
/* 2949 */     this.materialButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2951 */             EmpleadosAgregar.this.materialButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2955 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/* 2956 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 2957 */     this.materialButton17.setMnemonic('G');
/* 2958 */     this.materialButton17.setText("Guardar");
/* 2959 */     this.materialButton17.setToolTipText("Guardar (Alt+G)");
/* 2960 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 2961 */     this.materialButton17.setHorizontalTextPosition(0);
/* 2962 */     this.materialButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2964 */             EmpleadosAgregar.this.materialButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2968 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/* 2969 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 2970 */     this.materialButton19.setMnemonic('I');
/* 2971 */     this.materialButton19.setText("Imprimir");
/* 2972 */     this.materialButton19.setToolTipText("Imprimir (Alt+I)");
/* 2973 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 2974 */     this.materialButton19.setHorizontalTextPosition(0);
/* 2975 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2977 */             EmpleadosAgregar.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2981 */     this.materialButton20.setBackground(this.lc.SECUNDARIO1);
/* 2982 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 2983 */     this.materialButton20.setMnemonic('R');
/* 2984 */     this.materialButton20.setText("Resteblecer");
/* 2985 */     this.materialButton20.setToolTipText("Restablecer (Alt+R)");
/* 2986 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 2987 */     this.materialButton20.setHorizontalTextPosition(0);
/* 2988 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2990 */             EmpleadosAgregar.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2994 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 2995 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 2996 */     this.materialButton21.setMnemonic('C');
/* 2997 */     this.materialButton21.setText("Cerrar");
/* 2998 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/* 2999 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 3000 */     this.materialButton21.setHorizontalTextPosition(0);
/* 3001 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3003 */             EmpleadosAgregar.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3007 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/* 3008 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 3009 */     this.materialButton22.setMnemonic('F');
/* 3010 */     this.materialButton22.setText("Foto");
/* 3011 */     this.materialButton22.setToolTipText("Foto (Alt+F)");
/* 3012 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 3013 */     this.materialButton22.setHorizontalTextPosition(0);
/* 3014 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3016 */             EmpleadosAgregar.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3020 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/* 3021 */     this.jPanel54.setLayout(jPanel54Layout);
/* 3022 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/* 3023 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3024 */         .addGroup(jPanel54Layout.createSequentialGroup()
/* 3025 */           .addContainerGap()
/* 3026 */           .addComponent(this.jPanel55, -2, 62, -2)
/* 3027 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3028 */           .addComponent((Component)this.materialButton22, -2, 105, -2)
/* 3029 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 139, 32767)
/* 3030 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/* 3031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3032 */           .addComponent((Component)this.materialButton20, -2, 105, -2)
/* 3033 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3034 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/* 3035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3036 */           .addComponent((Component)this.materialButton17, -2, 150, -2)
/* 3037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3038 */           .addComponent((Component)this.materialButton18, -2, 105, -2)));
/*      */     
/* 3040 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/* 3041 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3042 */         .addGroup(jPanel54Layout.createSequentialGroup()
/* 3043 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3044 */             .addComponent(this.jPanel55, -1, -1, 32767)
/* 3045 */             .addGroup(jPanel54Layout.createSequentialGroup()
/* 3046 */               .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3047 */                 .addComponent((Component)this.materialButton18, -2, 38, -2)
/* 3048 */                 .addComponent((Component)this.materialButton17, -2, 38, -2)
/* 3049 */                 .addComponent((Component)this.materialButton19, -2, 38, -2)
/* 3050 */                 .addComponent((Component)this.materialButton20, -2, 38, -2)
/* 3051 */                 .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 3052 */                 .addComponent((Component)this.materialButton22, -2, 38, -2))
/* 3053 */               .addGap(0, 0, 32767)))
/* 3054 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3057 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/* 3058 */     this.jPanel53.setLayout(jPanel53Layout);
/* 3059 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/* 3060 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3061 */         .addComponent(this.jPanel54, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 3062 */         .addComponent(this.jTabbedPane1)
/* 3063 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 3064 */           .addContainerGap()
/* 3065 */           .addComponent(this.jLabel11)));
/*      */     
/* 3067 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/* 3068 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3069 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 3070 */           .addComponent(this.jLabel11, -2, -1, -2)
/* 3071 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3072 */           .addComponent(this.jTabbedPane1, -2, 334, -2)
/* 3073 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3074 */           .addComponent(this.jPanel54, -2, -1, -2)
/* 3075 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3078 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 3079 */     this.jPanel4.setLayout(jPanel4Layout);
/* 3080 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 3081 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3082 */         .addComponent(this.jPanel53, -1, -1, 32767)
/* 3083 */         .addComponent(this.jPanel52, -1, -1, 32767));
/*      */     
/* 3085 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 3086 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3087 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 3088 */           .addComponent(this.jPanel52, -2, -1, -2)
/* 3089 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3090 */           .addComponent(this.jPanel53, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3093 */     GroupLayout layout = new GroupLayout(this);
/* 3094 */     setLayout(layout);
/* 3095 */     layout.setHorizontalGroup(layout
/* 3096 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3097 */         .addGap(0, 1301, 32767)
/* 3098 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3099 */           .addGroup(layout.createSequentialGroup()
/* 3100 */             .addGap(193, 193, 193)
/* 3101 */             .addComponent(this.jPanel4, -1, -1, 32767)
/* 3102 */             .addGap(194, 194, 194))));
/*      */     
/* 3104 */     layout.setVerticalGroup(layout
/* 3105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3106 */         .addGap(0, 487, 32767)
/* 3107 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3108 */           .addGroup(layout.createSequentialGroup()
/* 3109 */             .addGap(0, 0, 32767)
/* 3110 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 3111 */             .addGap(0, 0, 32767))));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 3117 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3118 */     this.fichas.remove(1);
/* 3119 */     this.datos.eliminar();
/*      */   }
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 3122 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 3125 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 3129 */     hayDatos(this.jTextField1);
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 3133 */     hayDatos(this.jTextField2);
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 3137 */     hayDatos(this.jTextField3);
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 3141 */     hayDatos(this.jTextField4);
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 3145 */     hayDatos(this.jTextField5);
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 3149 */     hayDatos(this.jTextField6);
/*      */   }
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 3153 */     hayDatos(this.jTextField7);
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/* 3157 */     hayDatos(this.jTextField8);
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 3161 */     hayDatos(this.jTextField10);
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 3165 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3166 */       this.datos.escribir();
/* 3167 */     } else if (this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField5.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jTextField10.getText().equals("") && this.jComboBox3.getSelectedIndex() == 0 && this.jComboBox1.getSelectedIndex() == 0) {
/* 3168 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3173 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3174 */       this.datos.escribir();
/* 3175 */     } else if (this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField5.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jTextField10.getText().equals("") && this.jComboBox3.getSelectedIndex() == 0 && this.jComboBox1.getSelectedIndex() == 0) {
/* 3176 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 3181 */     hayDatos(this.jTextField9);
/*      */   }
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 3185 */     hayDatos(this.jTextField11);
/*      */   }
/*      */   
/*      */   private void jTextField13KeyReleased(KeyEvent evt) {
/* 3189 */     hayDatos(this.jTextField13);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 3193 */     int cont = 0;
/* 3194 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 3195 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 3196 */       this.jFormattedTextField1.setValue("");
/* 3197 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 3198 */       String cadena = this.jFormattedTextField1.getText();
/* 3199 */       String cad1 = cadena.substring(0, 3);
/* 3200 */       String cad2 = cadena.substring(4, 7);
/* 3201 */       String cad3 = cadena.substring(8, 12);
/* 3202 */       String tel = cad1 + cad1 + cad2;
/* 3203 */       for (int i = 1; i < tel.length(); i++) {
/* 3204 */         char c = tel.charAt(i - 1);
/* 3205 */         char d = tel.charAt(i);
/* 3206 */         if (c != d) {
/* 3207 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 3211 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 3212 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 3213 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField2FocusLost(FocusEvent evt) {
/* 3218 */     int cont = 0;
/* 3219 */     if (this.jFormattedTextField2.getText().contains("_") && !this.jFormattedTextField2.getText().equals("___-___-____")) {
/* 3220 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un número incompleto.\nCelular: " + this.jFormattedTextField2.getText(), "Celular Incompleto", 0, this.ADVER);
/* 3221 */       this.jFormattedTextField2.setValue("");
/* 3222 */     } else if (!this.jFormattedTextField2.getText().contains("_")) {
/* 3223 */       String cadena = this.jFormattedTextField2.getText();
/* 3224 */       String cad1 = cadena.substring(0, 3);
/* 3225 */       String cad2 = cadena.substring(4, 7);
/* 3226 */       String cad3 = cadena.substring(8, 12);
/* 3227 */       String tel = cad1 + cad1 + cad2;
/* 3228 */       for (int i = 1; i < tel.length(); i++) {
/* 3229 */         char c = tel.charAt(i - 1);
/* 3230 */         char d = tel.charAt(i);
/* 3231 */         if (c != d) {
/* 3232 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 3236 */     if (cont == 0 && !this.jFormattedTextField2.getText().contains("_")) {
/* 3237 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 3238 */       this.jFormattedTextField2.setValue("");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 3247 */     this.jTextField12.setText("");
/* 3248 */     this.jTextArea2.setText("");
/* 3249 */     this.materialButton23.setText("Guardar");
/* 3250 */     this.materialButton23.setToolTipText("Guardar (Alt+G)");
/* 3251 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField12ActionPerformed(ActionEvent evt) {
/* 3255 */     guardarDepa();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 3259 */     boolean entra = validar();
/* 3260 */     if (entra) {
/* 3261 */       this.jButton12.setEnabled(true);
/* 3262 */       if (this.PANEL < 3) {
/* 3263 */         this.PANEL++;
/*      */       }
/* 3265 */       this.jTabbedPane1.removeAll();
/* 3266 */       if (this.PANEL == 0) {
/* 3267 */         this.jTabbedPane1.add("Datos Personales", this.jPanel9);
/* 3268 */         this.materialButton17.setEnabled(false);
/* 3269 */       } else if (this.PANEL == 1) {
/* 3270 */         this.jTabbedPane1.add("Cargos", this.jPanel10);
/* 3271 */         this.jButton12.setToolTipText("Datos Personales");
/* 3272 */         this.jButton13.setToolTipText("Ir a Contrato");
/* 3273 */         this.materialButton17.setEnabled(false);
/* 3274 */       } else if (this.PANEL == 2) {
/* 3275 */         this.jTabbedPane1.add("Contrato", this.jPanel11);
/* 3276 */         this.jButton13.setEnabled(false);
/* 3277 */         this.jButton12.setToolTipText("Ir a Cargos");
/* 3278 */         this.jButton13.setToolTipText((String)null);
/* 3279 */         this.materialButton17.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 3285 */     boolean entra = validar();
/* 3286 */     if (entra) {
/* 3287 */       this.materialButton17.setEnabled(false);
/* 3288 */       this.jButton13.setEnabled(true);
/* 3289 */       if (this.PANEL > 0) {
/* 3290 */         this.PANEL--;
/*      */       }
/* 3292 */       this.jTabbedPane1.removeAll();
/* 3293 */       if (this.PANEL == 0) {
/* 3294 */         this.jTabbedPane1.add("Datos Personales", this.jPanel9);
/* 3295 */         this.jButton12.setEnabled(false);
/* 3296 */         this.jButton12.setToolTipText((String)null);
/* 3297 */         this.jButton13.setToolTipText("Ir a Cargos");
/* 3298 */       } else if (this.PANEL == 1) {
/* 3299 */         this.jTabbedPane1.add("Cargos", this.jPanel10);
/* 3300 */         this.jButton12.setToolTipText("Ir a Datos Personales");
/* 3301 */         this.jButton13.setToolTipText("Ir a Contrato");
/* 3302 */       } else if (this.PANEL == 2) {
/* 3303 */         this.jButton12.setToolTipText("Ir a Cargos");
/* 3304 */         this.jTabbedPane1.add("Contrato", this.jPanel11);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField16KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField25KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField26KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField27KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField29KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel86MouseClicked(MouseEvent evt) {
/* 3330 */     this.jDateChooser8.setDate(new Date());
/* 3331 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, this.jPanel24, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 3332 */     if (res == 0) {
/* 3333 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3334 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 3335 */       String año = cadenaFecha1.substring(0, 4);
/* 3336 */       String mes = cadenaFecha1.substring(4, 6);
/* 3337 */       String dia = cadenaFecha1.substring(6, 8);
/* 3338 */       String mm = dameMes(mes);
/* 3339 */       this.jLabel86.setText("<html><b>Vigencia: </b>" + mm.toUpperCase() + " " + año + "</html>");
/* 3340 */       this.VIGENCIA = mm + " " + mm;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel86MouseEntered(MouseEvent evt) {
/* 3345 */     this.jLabel86.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel86MouseExited(MouseEvent evt) {
/* 3349 */     this.jLabel86.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3353 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 3357 */     ImprimirRigPass rig = new ImprimirRigPass();
/* 3358 */     rig.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3362 */     this.jDialog5.setVisible(false);
/* 3363 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel136MouseClicked(MouseEvent evt) {
/* 3367 */     this.jDateChooser8.setDate(new Date());
/* 3368 */     int res = JOptionPane.showConfirmDialog(this.jDialog5, this.jPanel24, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 3369 */     if (res == 0) {
/* 3370 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3371 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 3372 */       String año = cadenaFecha1.substring(0, 4);
/* 3373 */       String mes = cadenaFecha1.substring(4, 6);
/* 3374 */       String dia = cadenaFecha1.substring(6, 8);
/* 3375 */       String mm = dameMes(mes);
/* 3376 */       this.jLabel136.setText(mm.toUpperCase() + " " + mm.toUpperCase());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel136MouseEntered(MouseEvent evt) {
/* 3381 */     this.jLabel136.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel136MouseExited(MouseEvent evt) {
/* 3385 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 3393 */     limpiar();
/*      */   }
/*      */   
/*      */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 3397 */     boolean correcto = validar();
/* 3398 */     if (correcto) {
/* 3399 */       String sexo = "";
/* 3400 */       String año = "";
/* 3401 */       String mes = "";
/* 3402 */       String dia = "";
/* 3403 */       String AÑO = "";
/* 3404 */       String MES = "";
/* 3405 */       String DIA = "";
/* 3406 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3407 */       String cadenaFecha = "";
/* 3408 */       String cadenaFecha2 = "";
/*      */       
/* 3410 */       boolean mayor = true;
/* 3411 */       long diasC = 0L;
/*      */       
/* 3413 */       boolean fechaAct = false;
/* 3414 */       boolean cien = false;
/* 3415 */       Date fecha = this.jDateChooser1.getDate();
/* 3416 */       String fechaCompleta = "";
/* 3417 */       String fechaCompleta2 = "";
/*      */       
/* 3419 */       fecha = this.jDateChooser1.getDate();
/* 3420 */       cadenaFecha = formato.format(fecha);
/* 3421 */       AÑO = cadenaFecha.substring(0, 4);
/* 3422 */       MES = cadenaFecha.substring(4, 6);
/* 3423 */       DIA = cadenaFecha.substring(6, 8);
/* 3424 */       fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3425 */       cien = true;
/*      */       
/* 3427 */       int añoS = Integer.parseInt(AÑO);
/* 3428 */       int mesS = Integer.parseInt(MES);
/* 3429 */       int diaS = Integer.parseInt(DIA);
/* 3430 */       cadenaFecha = formato.format(this.fechaActual);
/* 3431 */       año = cadenaFecha.substring(0, 4);
/* 3432 */       mes = cadenaFecha.substring(4, 6);
/* 3433 */       dia = cadenaFecha.substring(6, 8);
/* 3434 */       int añoA = Integer.parseInt(año);
/* 3435 */       int mesA = Integer.parseInt(mes);
/* 3436 */       int diaA = Integer.parseInt(dia);
/* 3437 */       long dif = this.fechaActual.getTime() - fecha.getTime();
/* 3438 */       diasC = dif / 86400000L;
/* 3439 */       if (diasC < 6575L) {
/* 3440 */         mayor = false;
/*      */       }
/* 3442 */       if (añoA - añoS < 100) {
/* 3443 */         cien = true;
/*      */       } else {
/* 3445 */         cien = false;
/*      */       } 
/*      */       
/* 3448 */       if (this.jDateChooser3.getDate() != null) {
/* 3449 */         fecha = this.jDateChooser3.getDate();
/* 3450 */         cadenaFecha2 = formato.format(fecha);
/* 3451 */         String str1 = cadenaFecha2.substring(0, 4);
/* 3452 */         String str2 = cadenaFecha2.substring(4, 6);
/* 3453 */         String str3 = cadenaFecha2.substring(6, 8);
/* 3454 */         fechaCompleta2 = "'" + str1 + "-" + str2 + "-" + str3 + "'";
/*      */       } 
/*      */       
/* 3457 */       fecha = this.jDateChooser4.getDate();
/* 3458 */       cadenaFecha2 = formato.format(fecha);
/* 3459 */       String AA = cadenaFecha2.substring(0, 4);
/* 3460 */       String MM = cadenaFecha2.substring(4, 6);
/* 3461 */       String DD = cadenaFecha2.substring(6, 8);
/* 3462 */       String fechaCompleta3 = "'" + AA + "-" + MM + "-" + DD + "'";
/*      */       
/* 3464 */       String id = this.jTextField13.getText();
/* 3465 */       String estado = "";
/* 3466 */       int edo = 33;
/* 3467 */       if (this.jComboBox3.getItemCount() == 33) {
/* 3468 */         if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3469 */           estado = String.valueOf(this.jComboBox3.getSelectedItem());
/* 3470 */           edo = this.jComboBox3.getSelectedIndex();
/*      */         } else {
/* 3472 */           edo = 33;
/* 3473 */           estado = "";
/*      */         } 
/*      */       } else {
/* 3476 */         estado = String.valueOf(this.jComboBox3.getSelectedItem());
/* 3477 */         edo = this.jComboBox3.getSelectedIndex();
/* 3478 */         edo++;
/*      */       } 
/* 3480 */       boolean siVigen = false;
/* 3481 */       boolean siEsta = true;
/* 3482 */       boolean yaEsta = false;
/*      */       
/* 3484 */       this.con.consultar("departamentos.nombre", "usuarios,empleados,departamentos", "where usuarios.num_emp = empleados.clave_emp and empleados.clave_depa = departamentos.clave_depa and usuarios.nombre_usu = '" + this.USUARIO + "'");
/* 3485 */       String DEPARTAMENTO = this.con.Campo;
/*      */       
/* 3487 */       String departamento = String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem());
/* 3488 */       this.con.consultar("clave_depa", "departamentos", "where nombre = '" + departamento + "'");
/* 3489 */       String depa = this.con.Campo;
/*      */       
/* 3491 */       this.error.pasarModal(false);
/* 3492 */       this.val.pasarModal(Boolean.valueOf(false));
/* 3493 */       String clave = this.jTextField13.getText();
/* 3494 */       String nom = this.jTextField1.getText();
/* 3495 */       String pat = this.jTextField2.getText();
/* 3496 */       String mat = this.jTextField3.getText();
/* 3497 */       String calle = this.jTextField4.getText();
/* 3498 */       String num = this.jTextField5.getText();
/* 3499 */       String col = this.jTextField6.getText();
/* 3500 */       String cod = this.jTextField7.getText();
/* 3501 */       String ciudad = this.jTextField8.getText();
/* 3502 */       String correo = this.jTextField10.getText();
/* 3503 */       String tel1 = this.jFormattedTextField1.getText();
/* 3504 */       String tel2 = this.jFormattedTextField2.getText();
/*      */       
/* 3506 */       String cargoNextel = "No";
/* 3507 */       String cargoInfo = "No";
/*      */       
/* 3509 */       if (!this.jRadioButton3.isSelected()) {
/* 3510 */         cargoNextel = "Si";
/*      */       }
/* 3512 */       if (!this.jRadioButton5.isSelected()) {
/* 3513 */         cargoInfo = "Si";
/*      */       }
/*      */       
/* 3516 */       if (tel1.equals("___-___-____")) {
/* 3517 */         tel1 = "";
/*      */       }
/* 3519 */       if (tel2.equals("___-___-____")) {
/* 3520 */         tel2 = "";
/*      */       }
/*      */       
/* 3523 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 3524 */         sexo = this.jComboBox2.getSelectedItem().toString();
/*      */       }
/*      */       
/* 3527 */       this.con.consultar("clave_depa", "departamentos", "where nombre='" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 3528 */       this.CLAVEDEPA = this.con.Campo;
/* 3529 */       if (this.materialButton17.getText().equals("Modificar")) {
/* 3530 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la información del empleado?", "Modificar Empleado", 0, 1, this.PREG);
/* 3531 */         if (res == 0) {
/* 3532 */           String consul = "";
/* 3533 */           if (this.PRIVILEGIOS.equals("CAPTURISTA")) {
/* 3534 */             consul = "";
/*      */           } else {
/* 3536 */             consul = ",salarioReal='" + this.jFormattedTextField8.getText() + "'";
/*      */           } 
/* 3538 */           this.con.insertar("update empleados set nombre='" + nom.toUpperCase() + "', ap_pat='" + pat.toUpperCase() + "', ap_mat='" + mat.toUpperCase() + "', calle='" + calle.toUpperCase() + "', num='" + num.toUpperCase() + "', col='" + col.toUpperCase() + "', cp='" + cod + "', ciudad='" + ciudad.toUpperCase() + "',tel_casa='" + tel1 + "', celular='" + tel2 + "',fecha_nac=" + fechaCompleta + ",correo='" + this.jTextField10.getText().toUpperCase() + "',sexo='" + sexo + "',nss='" + this.jTextField9.getText() + "',rfc='" + this.jTextField11.getText().toUpperCase() + "',clave_depa=" + depa + ", id_edo=" + edo + ",ingreso=" + fechaCompleta2 + ",infonavit=" + String.valueOf(this.jFormattedTextField3.getValue()) + ", infonavitLetra ='" + this.jFormattedTextField3.getText() + "',numInfo='" + this.jTextField15.getText() + "',lugarNacimiento='" + this.jTextField14.getText().toUpperCase() + "',ultimoIngreso=" + fechaCompleta3 + ",cargoNextel='" + cargoNextel + "',Nextel='" + this.jTextField16.getText().toUpperCase() + "',cantNextel='" + this.jFormattedTextField6.getText() + "',cargoInfo='" + cargoInfo + "',hijos=" + String.valueOf(this.jSpinner2.getValue()) + ",diasContrato=" + String.valueOf(this.jSpinner1.getValue()) + ",etiqueta='" + String.valueOf(this.jComboBox6.getSelectedItem()) + "',estadoCivil='" + String.valueOf(this.jComboBox7.getSelectedItem()) + "',personaContrato='" + this.jTextField25.getText().toUpperCase() + "',testigo1='" + this.jTextField29.getText().toUpperCase() + "',testigo2='" + this.jTextField26.getText().toUpperCase() + "',recomendado='" + this.jTextField27.getText().toUpperCase() + "',salarioImss='" + this.jFormattedTextField7.getText() + "'" + consul + ",ultimaAct=now(),responsable='" + this.USUARIO + "',comentarios='" + this.jTextArea1.getText().toUpperCase() + "',tipoEmp='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "', rfcOriginal='" + this.jTextField17.getText().toUpperCase() + "' where clave_emp=" + id);
/* 3539 */           this.mensajeTry.guardarConf("Se ha modificado un empleado-" + this.jTextField1.getText().toUpperCase() + " " + this.jTextField2.getText().toUpperCase() + " " + this.jTextField3.getText().toUpperCase() + ", USUARIO: " + this.USUARIO, "Empleado Modificado (" + id + ")", "INFO", "Empleados");
/* 3540 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir el <b>Reporte del Empleado?</b></html>", "Imprimir Reporte", 0, 3, this.PREG);
/* 3541 */           if (res == 0) {
/* 3542 */             ImprimirDatos imp = new ImprimirDatos();
/* 3543 */             imp.recibeDatos();
/*      */           } 
/* 3545 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir el <b>Contrato de Forsis</b>?</html>", "Imprimir Contrato", 0, 3, this.PREG);
/* 3546 */           if (res == 0) {
/* 3547 */             this.con.consultar("actividades", "departamentos", "where clave_depa = " + this.CLAVEDEPA);
/* 3548 */             this.ACTIVIDADES = this.con.Campo;
/* 3549 */             ImprimirContrato imp = new ImprimirContrato();
/* 3550 */             imp.recibeDatos();
/*      */           } 
/* 3552 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir los <b>Gafetes</b>?</html>", "Imprimir de Gafetes", 0, 3, this.PREG);
/* 3553 */           if (res == 0) {
/* 3554 */             this.jDialog3.setVisible(true);
/*      */           }
/* 3556 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Modificó el empleado No: " + id + "','Nombre Completo: " + this.inf[1] + " " + this.inf[2] + " " + this.inf[3] + "\nDirección: " + this.inf[4] + " " + this.inf[5] + " " + this.inf[6] + " " + this.inf[7] + " " + this.inf[8] + "\nTeléfono: " + this.inf[10] + "\nCelular: " + this.inf[11] + "\nCorreo Electrónico: " + this.inf[12] + "\nFecha de Nacimiento: " + this.inf[13] + "\nNSS: " + this.inf[14] + "\nRFC: " + this.inf[15] + "\nSexo: " + this.inf[16] + "\nDepartamento: " + this.inf[17] + "')");
/* 3557 */           limpiar();
/* 3558 */           consultar();
/* 3559 */           this.fichas.remove(1);
/*      */         } 
/*      */       } else {
/* 3562 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas agregar un nuevo empleado?", "Agregar Empleado", 0, 1, this.PREG);
/* 3563 */         if (res == 0) {
/* 3564 */           this.con.insertar("insert into empleados(clave_emp,                 nombre,                                                 ap_pat,                                      ap_mat,                   calle,                                                num,                                      col,                                           cp,                                         ciudad,              tel_casa, celular,              correo,                               fecha_nac,       lugarNacimiento,                           nss,                                        rfc,                                   sexo,         ingreso,          ultimoIngreso,     cargoNextel,    nextel,                                                      cantNextel,        cargoInfo,                      infonavit,                 infonavitLetra,                     numInfo,                                    hijos,                    diasContrato,     etiqueta,                             estadoCivil,                             personaContrato,                         testigo1,                                testigo2,                                                  recomendado,                     salarioImss,                                      salarioreal,     ultimaAct,responsable,     comentarios,               tipoEmp,                     clave_depa,   id_edo,actual, rfcOriginal) values (" + this.jTextField13
/* 3565 */               .getText() + ",'" + this.jTextField1.getText().toUpperCase() + "','" + this.jTextField2.getText().toUpperCase() + "','" + this.jTextField3.getText().toUpperCase() + "','" + this.jTextField4.getText().toUpperCase() + "','" + this.jTextField5.getText().toUpperCase() + "','" + this.jTextField6.getText().toUpperCase() + "','" + this.jTextField7.getText().toUpperCase() + "','" + this.jTextField8.getText().toUpperCase() + "','" + tel1 + "','" + tel2 + "','" + this.jTextField10.getText().toUpperCase() + "'," + fechaCompleta + ",'" + this.jTextField14.getText().toUpperCase() + "','" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField11.getText().toUpperCase() + "','" + sexo + "'," + fechaCompleta2 + "," + fechaCompleta3 + ",'" + cargoNextel + "','" + this.jTextField16.getText().toUpperCase() + "','" + this.jFormattedTextField6.getText() + "','" + cargoInfo + "'," + String.valueOf(this.jFormattedTextField3.getValue()) + ",'" + this.jFormattedTextField3.getText() + "','" + this.jTextField15.getText().toUpperCase() + "'," + String.valueOf(this.jSpinner2.getValue()) + "," + String.valueOf(this.jSpinner1.getValue()) + ",'" + String.valueOf(this.jComboBox6.getSelectedItem()) + "','" + String.valueOf(this.jComboBox7.getSelectedItem()) + "','" + this.jTextField25.getText().toUpperCase() + "','" + this.jTextField29.getText().toUpperCase() + "','" + this.jTextField26.getText().toUpperCase() + "','" + this.jTextField27.getText().toUpperCase() + "','" + this.jFormattedTextField7.getText() + "','" + this.jFormattedTextField8.getText() + "',now(),'" + this.USUARIO + "','" + this.jTextArea1.getText().toUpperCase() + "','" + String.valueOf(this.jComboBox5.getSelectedItem()) + "'," + depa + "," + edo + ",0,'" + this.jTextField17.getText().toUpperCase() + "')");
/* 3566 */           this.mensajeTry.guardarConf("Se ha agregado un empleado-" + this.jTextField1.getText().toUpperCase() + " " + this.jTextField2.getText().toUpperCase() + " " + this.jTextField3.getText().toUpperCase() + ", USUARIO: " + this.USUARIO, "Nuevo Empleado (" + this.jTextField13.getText() + ")", "INFO", "Empleados");
/* 3567 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir el <b>Reporte del Empleado?</b></html>", "Imprimir Reporte", 0, 3, this.PREG);
/* 3568 */           if (res == 0) {
/* 3569 */             ImprimirDatos imp = new ImprimirDatos();
/* 3570 */             imp.recibeDatos();
/*      */           } 
/* 3572 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir el <b>Contrato de Forsis</b>?</html>", "Imprimir Contrato", 0, 3, this.PREG);
/* 3573 */           if (res == 0) {
/* 3574 */             this.con.consultar("actividades", "departamentos", "where clave_depa = " + this.CLAVEDEPA);
/* 3575 */             this.ACTIVIDADES = this.con.Campo;
/* 3576 */             ImprimirContrato imp = new ImprimirContrato();
/* 3577 */             imp.recibeDatos();
/*      */           } 
/* 3579 */           res = JOptionPane.showConfirmDialog(this.padre, "<html>¿Deseas imprimir los <b>Gafetes</b>?</html>", "Imprimir de Gafetes", 0, 3, this.PREG);
/* 3580 */           if (res == 0) {
/* 3581 */             this.jDialog3.setVisible(true);
/*      */           }
/* 3583 */           limpiar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 3590 */     ImprimirDatos imp = new ImprimirDatos();
/* 3591 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 3595 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 3599 */     this.fichas.remove(1);
/* 3600 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 3604 */     verFoto();
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 3608 */     guardarDepa();
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 3612 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 3624 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 3625 */     if (ind < 0) {
/* 3626 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un departamento para poder modificar los datos", "Selecciona un Departamento", 0, this.ERROR);
/*      */     } else {
/* 3628 */       this.materialButton23.setText("Modificar");
/* 3629 */       this.materialButton23.setToolTipText("Modificar Departamento (Alt+G)");
/* 3630 */       this.CLAVEDEPA = String.valueOf(this.rSTableMetro3.getValueAt(ind, 0));
/* 3631 */       this.con.consultar("actividades", "departamentos", "where clave_depa=" + this.CLAVEDEPA);
/* 3632 */       this.jTextField12.setText(String.valueOf(this.rSTableMetro3.getValueAt(ind, 1)));
/* 3633 */       this.jTextArea2.setText(this.con.Campo);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton26ActionPerformed(ActionEvent evt) {
/* 3638 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 3639 */     if (ind < 0) {
/* 3640 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un departamento para poder eliminar los datos", "Selecciona Un Departamento", 0, this.ERROR);
/*      */     } else {
/* 3642 */       this.encontrado = this.con.consultar("nombre", "empleados", " where clave_depa = " + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 3643 */       if (this.encontrado) {
/* 3644 */         JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el siguiente departamento " + String.valueOf(this.rSTableMetro3.getValueAt(ind, 1)) + ", porque existen empleados asignados a éste\nPara eliminarlo necesitas borrar primero todos los empleados que estén dentro.", "Error al Eliminar", 0, this.ERROR);
/*      */         return;
/*      */       } 
/* 3647 */       String valor = "<html><b>Clave del Departamento: </b>" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)) + "<br><b>Nombre: </b>" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 1)) + "<br></html>";
/* 3648 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Departamento", 0, 3, this.ELIMINAR);
/* 3649 */       if (res == 0) {
/* 3650 */         this.con.eliminar("departamentos", "where clave_depa=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/* 3651 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el departamento " + String.valueOf(this.rSTableMetro3.getValueAt(ind, 1)) + " definitivamente.','Clave del Departamento: " + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)) + "\nNombre: " + String.valueOf(this.rSTableMetro3.getValueAt(ind, 1)) + "')");
/* 3652 */         consultar1();
/* 3653 */         llenarCombo();
/*      */       } 
/*      */     } 
/*      */     
/* 3657 */     llenarCombo();
/*      */   }
/*      */   
/*      */   private void jLabel69MouseClicked(MouseEvent evt) {
/* 3661 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel69MouseExited(MouseEvent evt) {
/* 3665 */     this.jLabel69.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel69MouseEntered(MouseEvent evt) {
/* 3669 */     this.jLabel69.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 3673 */     this.xx = evt.getX();
/* 3674 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel1MouseDragged(MouseEvent evt) {
/* 3678 */     int x = evt.getXOnScreen();
/* 3679 */     int y = evt.getYOnScreen();
/* 3680 */     this.jDialog2.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void materialButton27ActionPerformed(ActionEvent evt) {
/* 3684 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void materialButton28ActionPerformed(ActionEvent evt) {
/* 3689 */     this.jDateChooser8.setDate(new Date());
/* 3690 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3691 */     String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 3692 */     String año = cadenaFecha1.substring(0, 4);
/* 3693 */     if (this.jRadioButton7.isSelected()) {
/* 3694 */       String clave = this.jTextField13.getText();
/* 3695 */       String nombre = this.jTextField2.getText() + " " + this.jTextField2.getText() + " " + this.jTextField3.getText();
/* 3696 */       String tipo = this.jFormattedTextField1.getText();
/* 3697 */       String nss = this.jTextField9.getText();
/* 3698 */       String curp = this.jTextField11.getText().toUpperCase();
/* 3699 */       this.jLabel82.setText(nombre);
/* 3700 */       this.jLabel84.setText("<html><b>TELÉFONO: </b>" + tipo + "</html>");
/* 3701 */       this.jLabel85.setText("<html><b>NSS: </b>" + nss + "</html>");
/* 3702 */       this.jLabel89.setText("<html><b>CURP: </b>" + curp + "</html>");
/* 3703 */       this.jLabel102.setText(nombre);
/* 3704 */       this.jLabel81.setText(String.valueOf(this.jComboBox1.getSelectedItem()));
/* 3705 */       this.VIGENCIA = "DICIEMBRE " + año;
/* 3706 */       this.jLabel86.setText("<html><b>Vigencia: </b>DICIEMBRE " + año + "</html>");
/* 3707 */       String claveOp = sacarClave(clave);
/* 3708 */       this.jLabel80.setText("EMP-" + claveOp);
/* 3709 */       this.CLAVEOP = (String)this.CAMPOSGENERALES.get("directiva") + "-EMP-" + (String)this.CAMPOSGENERALES.get("directiva");
/* 3710 */       String depa = this.jComboBox1.getSelectedItem().toString();
/* 3711 */       verFotos2();
/*      */ 
/*      */       
/* 3714 */       Gafete2020 gafete2020 = new Gafete2020(this.padre, true, this.CAMPOSGENERALES, new String[] { clave, this.CLAVEOP, nombre.toUpperCase(), this.VIGENCIA, nss.toUpperCase(), curp.toUpperCase(), depa });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3733 */       this.jLabel76.setText("<html><center>FOLIO: <b>" + this.CONFIG[1] + "-EM" + this.jTextField13.getText() + "-" + año + "</b></center></html>");
/* 3734 */       this.jLabel145.setText("<html><center>FOLIO: <b>" + this.CONFIG[1] + "-EM" + this.jTextField13.getText() + "-" + año + "</b></center></html>");
/* 3735 */       this.jLabel93.setText(this.jTextField2.getText().toUpperCase() + " " + this.jTextField2.getText().toUpperCase() + " " + this.jTextField3.getText().toUpperCase());
/* 3736 */       this.jSpinner1.setValue(Integer.valueOf(8));
/* 3737 */       String mes = cadenaFecha1.substring(4, 6);
/* 3738 */       String dia = cadenaFecha1.substring(6, 8);
/* 3739 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 3741 */       int aa = Integer.parseInt(año);
/* 3742 */       aa++;
/* 3743 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3744 */       String strFecha = "" + aa + "-" + aa + "-01";
/* 3745 */       Date fecha = null;
/*      */       try {
/* 3747 */         fecha = formatoDelTexto.parse(strFecha);
/* 3748 */       } catch (ParseException ex) {
/* 3749 */         ex.printStackTrace();
/*      */       } 
/* 3751 */       this.jDateChooser2.setDate(fecha);
/*      */       
/* 3753 */       this.jLabel143.setText(fechaCompleta);
/* 3754 */       this.jTextField30.setText(this.jComboBox1.getSelectedItem().toString());
/* 3755 */       this.jLabel149.setText(this.CONFIG[3]);
/* 3756 */       this.jLabel147.setText(this.CONFIG[2]);
/* 3757 */       verFotos2();
/* 3758 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton29ActionPerformed(ActionEvent evt) {
/* 3763 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton30ActionPerformed(ActionEvent evt) {
/* 3767 */     Date fecha = this.jDateChooser2.getDate();
/* 3768 */     if (fecha == null) {
/* 3769 */       JOptionPane.showMessageDialog(this, "Ingresa la fecha de la vigencia", "Falta la fecha de vigencia", 0, this.ERROR);
/* 3770 */     } else if (this.jTextField29.getText().equals("")) {
/* 3771 */       this.jTextField29.setBackground(Color.RED);
/* 3772 */       JOptionPane.showMessageDialog(this.jDialog9, "Falta ingresar la categoría de la persona, no la puedes dejar vacía", "Falta la categoria", 0, this.ERROR);
/*      */     } else {
/* 3774 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3775 */       String cadenaFecha1 = formato.format(new Date());
/*      */       try {
/* 3777 */         String foto = this.CONFIG[0] + "/" + this.CONFIG[0] + ".png";
/* 3778 */         String año = cadenaFecha1.substring(0, 4);
/* 3779 */         String mes = cadenaFecha1.substring(4, 6);
/* 3780 */         String dia = cadenaFecha1.substring(6, 8);
/* 3781 */         String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */         
/* 3783 */         Date fecha1 = this.jDateChooser2.getDate();
/* 3784 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 3785 */         String cadenaFecha = "";
/* 3786 */         cadenaFecha = formato.format(fecha1);
/* 3787 */         String AÑO = cadenaFecha.substring(0, 4);
/* 3788 */         String MES = cadenaFecha.substring(4, 6);
/* 3789 */         String DIA = cadenaFecha.substring(6, 8);
/* 3790 */         String fechaCompleta1 = dameMes(MES).toUpperCase() + " " + dameMes(MES).toUpperCase();
/* 3791 */         Map<Object, Object> datos = new HashMap<>();
/*      */         
/* 3793 */         datos.put("folio", this.CONFIG[1] + "-EM" + this.CONFIG[1] + "-" + this.jTextField13.getText());
/* 3794 */         datos.put("nombre", this.jLabel93.getText().toUpperCase());
/* 3795 */         datos.put("vigencia", fechaCompleta1);
/* 3796 */         datos.put("fecha", fechaCompleta);
/* 3797 */         datos.put("capacitador", this.CONFIG[3]);
/* 3798 */         datos.put("registro", this.CONFIG[2]);
/* 3799 */         datos.put("foto", foto);
/* 3800 */         datos.put("categoria", this.jComboBox1.getSelectedItem());
/* 3801 */         datos.put("horas", String.valueOf(this.jSpinner1.getValue()) + " HRS.");
/* 3802 */         JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/qhse/curso_basico.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 3803 */         JasperViewer visor = new JasperViewer(print, false);
/* 3804 */         visor.setTitle("Gafete " + this.jLabel93.getText().toUpperCase());
/* 3805 */         visor.setIconImage(this.iconoImprimir);
/* 3806 */         this.jDialog9.setVisible(false);
/* 3807 */         visor.setVisible(true);
/*      */       }
/* 3809 */       catch (JRException e) {
/* 3810 */         System.out.println(e.getMessage());
/* 3811 */         Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 3812 */         JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton31ActionPerformed(ActionEvent evt) {
/* 3818 */     this.jDialog9.setVisible(false);
/* 3819 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton32ActionPerformed(ActionEvent evt) {
/* 3823 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton33ActionPerformed(ActionEvent evt) {
/* 3827 */     ImprimirCredencial imp = new ImprimirCredencial();
/* 3828 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void materialButton34ActionPerformed(ActionEvent evt) {
/* 3832 */     this.jDialog4.setVisible(false);
/* 3833 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 3837 */     String mesLetra = "";
/* 3838 */     if (mes.equals("01")) {
/* 3839 */       mesLetra = "Enero";
/* 3840 */     } else if (mes.equals("02")) {
/* 3841 */       mesLetra = "Febrero";
/* 3842 */     } else if (mes.equals("03")) {
/* 3843 */       mesLetra = "Marzo";
/* 3844 */     } else if (mes.equals("04")) {
/* 3845 */       mesLetra = "Abril";
/* 3846 */     } else if (mes.equals("05")) {
/* 3847 */       mesLetra = "Mayo";
/* 3848 */     } else if (mes.equals("06")) {
/* 3849 */       mesLetra = "Junio";
/* 3850 */     } else if (mes.equals("07")) {
/* 3851 */       mesLetra = "Julio";
/* 3852 */     } else if (mes.equals("08")) {
/* 3853 */       mesLetra = "Agosto";
/* 3854 */     } else if (mes.equals("09")) {
/* 3855 */       mesLetra = "Septiembre";
/* 3856 */     } else if (mes.equals("10")) {
/* 3857 */       mesLetra = "Octubre";
/* 3858 */     } else if (mes.equals("11")) {
/* 3859 */       mesLetra = "Noviembre";
/* 3860 */     } else if (mes.equals("12")) {
/* 3861 */       mesLetra = "Diciembre";
/*      */     } 
/* 3863 */     return mesLetra;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void verFoto() {
/* 3869 */     String num = this.jTextField13.getText();
/*      */     
/* 3871 */     this.jLabel1.setText("Cargando...");
/* 3872 */     this.jLabel1.setIcon((Icon)null);
/* 3873 */     this.ind = new fotoIndividual(num);
/* 3874 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 3878 */     String mayor = clave;
/* 3879 */     int MAYOR = Integer.parseInt(mayor);
/* 3880 */     String clave1 = "";
/* 3881 */     if (MAYOR < 10) {
/* 3882 */       clave1 = "0000" + MAYOR;
/* 3883 */     } else if (MAYOR < 100) {
/* 3884 */       clave1 = "000" + MAYOR;
/* 3885 */     } else if (MAYOR < 1000) {
/* 3886 */       clave1 = "00" + MAYOR;
/* 3887 */     } else if (MAYOR < 10000) {
/* 3888 */       clave1 = "0" + MAYOR;
/*      */     } else {
/* 3890 */       clave1 = "OP-" + MAYOR;
/*      */     } 
/* 3892 */     return clave1;
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3896 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3900 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void verFotos2() {
/* 3904 */     int ind = this.jTable3.getSelectedRow();
/* 3905 */     String num = this.jTextField13.getText();
/* 3906 */     this.jLabel78.setText("Cargando...");
/* 3907 */     this.jLabel115.setText("Cargando...");
/* 3908 */     this.jLabel98.setText("Cargando...");
/* 3909 */     this.jLabel78.setIcon((Icon)null);
/* 3910 */     this.jLabel115.setIcon((Icon)null);
/* 3911 */     this.jLabel98.setIcon((Icon)null);
/* 3912 */     this.fotoC = new fotoCredencial(num);
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 3916 */     this.jTextField1.setText("");
/* 3917 */     this.jTextField2.setText("");
/* 3918 */     this.jTextField3.setText("");
/* 3919 */     this.jTextField4.setText("");
/* 3920 */     this.jTextField5.setText("");
/* 3921 */     this.jTextField6.setText("");
/* 3922 */     this.jTextField7.setText("");
/* 3923 */     this.jTextField8.setText("");
/* 3924 */     this.jTextField9.setText("");
/* 3925 */     this.jTextField10.setText("");
/* 3926 */     this.jTextField11.setText("");
/* 3927 */     this.jTextField14.setText("");
/* 3928 */     this.jTextField15.setText("");
/* 3929 */     this.jTextField16.setText("");
/* 3930 */     this.jTextField25.setText("");
/* 3931 */     this.jTextField29.setText("");
/* 3932 */     this.jTextField26.setText("");
/* 3933 */     this.jTextField27.setText("");
/* 3934 */     this.jTextField17.setText("");
/* 3935 */     this.jTextArea1.setText("");
/* 3936 */     this.jFormattedTextField1.setValue("");
/* 3937 */     this.jFormattedTextField2.setValue("");
/* 3938 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 3939 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 3940 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 3941 */     this.jFormattedTextField8.setValue(Integer.valueOf(0));
/* 3942 */     this.jComboBox1.setSelectedIndex(0);
/* 3943 */     this.jComboBox2.setSelectedIndex(0);
/* 3944 */     this.jComboBox3.setSelectedIndex(0);
/* 3945 */     this.jComboBox5.setSelectedIndex(0);
/* 3946 */     this.jComboBox6.setSelectedIndex(0);
/* 3947 */     this.jComboBox7.setSelectedIndex(0);
/* 3948 */     this.jDateChooser1.setDate(new Date());
/* 3949 */     crearInd();
/* 3950 */     if (this.materialButton17.getText().equals("Modificar")) {
/* 3951 */       this.jTextField13.setText(this.id);
/*      */     }
/* 3953 */     this.jRadioButton3.setSelected(true);
/* 3954 */     this.jRadioButton5.setSelected(true);
/* 3955 */     this.jDateChooser3.setDate(new Date());
/* 3956 */     this.jDateChooser4.setDate(new Date());
/* 3957 */     this.jSpinner1.setValue(Integer.valueOf(28));
/* 3958 */     this.jSpinner2.setValue(Integer.valueOf(0));
/* 3959 */     this.PANEL = 0;
/* 3960 */     this.jTabbedPane1.removeAll();
/* 3961 */     this.jTabbedPane1.add("Datos Personales", this.jPanel9);
/* 3962 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   public void empleados(String usua, String num) {
/* 3966 */     this.jDateChooser1.setDate(new Date());
/* 3967 */     this.jDateChooser3.setDate(new Date());
/* 3968 */     this.jDateChooser4.setDate(new Date());
/* 3969 */     this.jButton12.setEnabled(false);
/* 3970 */     this.jButton13.setEnabled(true);
/* 3971 */     this.PANEL = 0;
/* 3972 */     this.jTabbedPane1.removeAll();
/* 3973 */     this.jTabbedPane1.add("Datos Personales", this.jPanel9);
/* 3974 */     this.jFormattedTextField3.setEnabled(false);
/* 3975 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 3976 */     this.jTextField15.setEnabled(false);
/* 3977 */     this.jTextField15.setText("");
/* 3978 */     this.USUARIO = usua;
/* 3979 */     this.id = num;
/* 3980 */     this.panel.setViewportView(this);
/* 3981 */     this.materialButton17.setEnabled(false);
/*      */     
/* 3983 */     this.materialButton21.setVisible(false);
/* 3984 */     this.materialButton20.setVisible(false);
/*      */     
/* 3986 */     String[] datos = this.con.regresaReg("nombre,ap_pat,ap_mat,priv", "empleados,usuarios", "where clave_emp=num_emp and nombre_usu = '" + this.USUARIO + "'", 4);
/* 3987 */     this.NOMBRECOMPLETO = datos[1] + " " + datos[1] + " " + datos[2];
/* 3988 */     this.PRIVILEGIOS = datos[3];
/* 3989 */     if (this.fichas != null) {
/* 3990 */       cargarFormulario();
/* 3991 */       this.jTextField13.setText(num);
/* 3992 */       this.fichas.addTab("Modificar Empleados - [Clave: " + this.id + "]", this.panel);
/* 3993 */       this.materialButton17.setText("Modificar");
/*      */     } else {
/* 3995 */       Limpiar limpiar = new Limpiar();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean validar() {
/* 4000 */     String año = "";
/* 4001 */     String mes = "";
/* 4002 */     String dia = "";
/* 4003 */     String AÑO = "";
/* 4004 */     String MES = "";
/* 4005 */     String DIA = "";
/* 4006 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4007 */     String cadenaFecha = "";
/*      */     
/* 4009 */     boolean mayor = true;
/* 4010 */     long diasC = 0L;
/*      */     
/* 4012 */     boolean fechaAct = false;
/* 4013 */     boolean cien = false;
/* 4014 */     Date fecha = this.jDateChooser1.getDate();
/* 4015 */     String fechaCompleta = "";
/*      */     
/* 4017 */     if (this.jDateChooser1.getDate() != null) {
/* 4018 */       fecha = this.jDateChooser1.getDate();
/* 4019 */       cadenaFecha = formato.format(fecha);
/* 4020 */       AÑO = cadenaFecha.substring(0, 4);
/* 4021 */       MES = cadenaFecha.substring(4, 6);
/* 4022 */       DIA = cadenaFecha.substring(6, 8);
/* 4023 */       fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 4024 */       cien = true;
/*      */       
/* 4026 */       int añoS = Integer.parseInt(AÑO);
/* 4027 */       int mesS = Integer.parseInt(MES);
/* 4028 */       int diaS = Integer.parseInt(DIA);
/* 4029 */       cadenaFecha = formato.format(this.fechaActual);
/* 4030 */       año = cadenaFecha.substring(0, 4);
/* 4031 */       mes = cadenaFecha.substring(4, 6);
/* 4032 */       dia = cadenaFecha.substring(6, 8);
/* 4033 */       int añoA = Integer.parseInt(año);
/* 4034 */       int mesA = Integer.parseInt(mes);
/* 4035 */       int diaA = Integer.parseInt(dia);
/* 4036 */       long dif = this.fechaActual.getTime() - fecha.getTime();
/* 4037 */       diasC = dif / 86400000L;
/* 4038 */       if (diasC < 6575L) {
/* 4039 */         mayor = false;
/*      */       }
/* 4041 */       if (añoA - añoS < 100) {
/* 4042 */         cien = true;
/*      */       } else {
/* 4044 */         cien = false;
/*      */       } 
/*      */     } 
/*      */     
/* 4048 */     String estado = "";
/* 4049 */     int edo = 33;
/* 4050 */     if (this.jComboBox3.getItemCount() == 33) {
/* 4051 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 4052 */         estado = String.valueOf(this.jComboBox3.getSelectedItem());
/* 4053 */         edo = this.jComboBox3.getSelectedIndex();
/*      */       } else {
/* 4055 */         edo = 33;
/* 4056 */         estado = "";
/*      */       } 
/*      */     } else {
/* 4059 */       estado = String.valueOf(this.jComboBox3.getSelectedItem());
/* 4060 */       edo = this.jComboBox3.getSelectedIndex();
/* 4061 */       edo++;
/*      */     } 
/*      */     
/* 4064 */     boolean siVigen = false;
/* 4065 */     boolean siEsta = true;
/* 4066 */     boolean yaEsta = false;
/*      */     
/* 4068 */     this.con.consultar("departamentos.nombre", "usuarios,empleados,departamentos", "where usuarios.num_emp = empleados.clave_emp and empleados.clave_depa = departamentos.clave_depa and usuarios.nombre_usu = '" + this.USUARIO + "'");
/* 4069 */     String DEPARTAMENTO = this.con.Campo;
/* 4070 */     this.error.pasarModal(false);
/* 4071 */     this.val.pasarModal(Boolean.valueOf(false));
/*      */ 
/*      */     
/* 4074 */     String clave = this.jTextField13.getText();
/* 4075 */     String nom = this.jTextField1.getText();
/* 4076 */     String pat = this.jTextField2.getText();
/* 4077 */     String mat = this.jTextField3.getText();
/* 4078 */     String calle = this.jTextField4.getText();
/* 4079 */     String num = this.jTextField5.getText();
/* 4080 */     String col = this.jTextField6.getText();
/* 4081 */     String cod = this.jTextField7.getText();
/* 4082 */     String ciudad = this.jTextField8.getText();
/*      */     
/* 4084 */     String correo = this.jTextField10.getText();
/* 4085 */     String tel1 = this.jFormattedTextField1.getText();
/* 4086 */     String tel2 = this.jFormattedTextField2.getText();
/* 4087 */     String sexo = "";
/* 4088 */     if (tel1.equals("___-___-____")) {
/* 4089 */       tel1 = "";
/*      */     }
/* 4091 */     if (tel2.equals("___-___-____")) {
/* 4092 */       tel2 = "";
/*      */     }
/*      */     
/* 4095 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4096 */       sexo = this.jComboBox2.getSelectedItem().toString();
/*      */     }
/*      */     
/* 4099 */     if (this.PANEL == 0) {
/* 4100 */       if (this.jTextField13.getText().equals("")) {
/* 4101 */         this.error.cargarError(this.jTextField13, "050");
/* 4102 */         return false;
/* 4103 */       }  if (this.materialButton17.getText().equals("Guardar") && this.con.consultar("clave_emp", "empleados", "where clave_emp=" + this.jTextField13.getText())) {
/* 4104 */         JOptionPane.showMessageDialog(this.padre, "La clave del empleado ya está registrada en la base de datos.\nNecesitas cambiarla para guardar esta información.", "Clave Duplicada", 0, this.ADVER);
/* 4105 */         return false;
/* 4106 */       }  if (this.jTextField1.getText().equals("")) {
/* 4107 */         this.error.cargarError(this.jTextField1, "050");
/* 4108 */         return false;
/* 4109 */       }  if (this.jTextField2.getText().equals("")) {
/* 4110 */         this.error.cargarError(this.jTextField2, "050");
/* 4111 */         return false;
/* 4112 */       }  if (this.jTextField14.getText().equals("")) {
/* 4113 */         this.error.cargarError(this.jTextField14, "050");
/* 4114 */         return false;
/* 4115 */       }  if (this.jDateChooser1.getDate() == null) {
/* 4116 */         JOptionPane.showMessageDialog(this.padre, "No puedes dejar la fecha de ingreso de nacimiento por favor verifica tu información", "Falta fecha de nacimiento", 0, this.ERROR);
/* 4117 */         return false;
/* 4118 */       }  if (!this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText()) && 
/* 4119 */         this.materialButton17.getText().equals("Guardar") && this.con.consultar("clave_emp", "empleados", "where clave_emp=" + this.jTextField13.getText())) {
/* 4120 */         JOptionPane.showMessageDialog(this.padre, "La clave del empleado ya está registrada en la base de datos.\nNecesitas cambiarla para guardar esta información.", "Clave Duplicada", 0, this.ADVER);
/* 4121 */         return false;
/*      */       } 
/*      */       
/* 4124 */       if (!this.val.validarNombres(this.jTextField1, nom, "010") && 
/* 4125 */         !this.val.validarNombres(this.jTextField2, pat, "010") && 
/* 4126 */         !this.val.validarNombres(this.jTextField3, mat, "010") && 
/* 4127 */         !this.val.validarCalle(this.jTextField4, calle, "014")) {
/* 4128 */         if (!this.jTextField4.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField5.getText().equals("")) {
/* 4129 */           this.jTextField5.setBackground(new Color(255, 51, 51));
/* 4130 */           JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/* 4131 */         } else if (!this.val.validarNumero(this.jTextField5, num.toUpperCase(), "015")) {
/* 4132 */           if (!this.jTextField5.getText().equals("") && this.jTextField4.getText().equals("")) {
/* 4133 */             this.jTextField4.setBackground(new Color(255, 51, 51));
/* 4134 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/* 4135 */           } else if (!this.val.validarDireccion(this.jTextField6, col, "014")) {
/* 4136 */             if (!this.jTextField6.getText().equals("") && this.jTextField4.getText().equals("")) {
/* 4137 */               this.jTextField4.setBackground(new Color(255, 51, 51));
/* 4138 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/* 4139 */             } else if (!this.val.validarCodigoPostal(this.jTextField7, cod, "014") && 
/* 4140 */               !this.val.validarRegion(this.jTextField8, ciudad, "018") && 
/* 4141 */               !this.val.validarNss(this.jTextField9, this.jTextField9.getText()) && 
/* 4142 */               !this.val.validarRFC(this.jTextField11, this.jTextField11.getText()) && 
/* 4143 */               !this.val.validarApostrofe(this.jTextField14, this.jTextField14.getText(), "020")) {
/* 4144 */               if (fechaAct && !fecha.before(this.fechaActual)) {
/* 4145 */                 this.error.cargarError((JComponent)this.jDateChooser1, "021");
/* 4146 */                 return false;
/* 4147 */               }  if (!mayor) {
/* 4148 */                 this.error.cargarError((JComponent)this.jDateChooser1, "044");
/* 4149 */                 return false;
/* 4150 */               }  if (!cien) {
/* 4151 */                 this.error.cargarError((JComponent)this.jDateChooser1, "045");
/* 4152 */                 return false;
/*      */               } 
/* 4154 */               return true;
/*      */             
/*      */             }
/*      */ 
/*      */           
/*      */           }
/*      */ 
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/* 4166 */     else if (this.PANEL == 1) {
/* 4167 */       if (!this.val.validarApostrofe(this.jTextField16, this.jTextField16.getText(), "020")) {
/* 4168 */         if (this.jRadioButton4.isSelected() && this.jFormattedTextField6.getText().equals("$0.00")) {
/* 4169 */           this.jFormattedTextField6.setBackground(Color.RED);
/* 4170 */           JOptionPane.showMessageDialog(this.padre, "Si seleccionas cargo por automático de nextel, necesitas especificar la cantidad a descontar", "Falta Cantidad", 0, this.ADVER);
/* 4171 */           return false;
/*      */         } 
/* 4173 */         if (!this.val.validarDigitos(this.jTextField15, this.jTextField15.getText())) {
/* 4174 */           if (this.jRadioButton6.isSelected() && this.jFormattedTextField3.getText().equals("$0.00")) {
/* 4175 */             this.jFormattedTextField3.setBackground(Color.RED);
/* 4176 */             JOptionPane.showMessageDialog(this.padre, "Si seleccionas cargo por automático de infonavit, necesitas especificar la cantidad a descontar", "Falta Cantidad", 0, this.ADVER);
/* 4177 */             return false;
/* 4178 */           }  if (this.jComboBox1.getSelectedIndex() == 0) {
/* 4179 */             this.error.cargarError(this.jComboBox1, "050");
/* 4180 */             return false;
/*      */           } 
/* 4182 */           if (!this.val.validarApostrofe(this.jTextField10, this.jTextField10.getText(), "020")) {
/* 4183 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/* 4187 */     } else if (this.PANEL == 2) {
/* 4188 */       if (this.jDateChooser3.getDate() == null) {
/* 4189 */         JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacía la fecha de ingreso, por favor verifica tu información", "Falta fecha de ingreso", 0, this.ERROR);
/* 4190 */         return false;
/* 4191 */       }  if (this.jDateChooser4.getDate() == null) {
/* 4192 */         JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacía la fecha de último ingreso, por favor verifica tu información", "Falta fecha de último ingreso", 0, this.ERROR);
/* 4193 */         return false;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4203 */       if (this.jTextField25.getText().equals("")) {
/* 4204 */         this.error.cargarError(this.jTextField25, "050");
/* 4205 */       } else if (!this.val.validarApostrofe(this.jTextField25, this.jTextField25.getText(), "020") && 
/* 4206 */         !this.val.validarApostrofe(this.jTextField29, this.jTextField29.getText(), "020") && 
/* 4207 */         !this.val.validarApostrofe(this.jTextField26, this.jTextField26.getText(), "020") && 
/* 4208 */         !this.val.validarApostrofe(this.jTextField27, this.jTextField27.getText(), "020") && 
/* 4209 */         !this.val.validarTexto(this.jTextArea1, this.jTextArea1.getText(), "020")) {
/* 4210 */         return true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4217 */     return false;
/*      */   }
/*      */   
/*      */   public void pasarInd(int i) {
/* 4221 */     this.INDICE = i;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 4225 */     Date fecha = new Date();
/* 4226 */     Calendar ahoraCal = Calendar.getInstance();
/* 4227 */     ahoraCal.setTime(fecha);
/* 4228 */     String mesesito = "";
/* 4229 */     String hoy = "";
/* 4230 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 4231 */     hoy = "" + ahoraCal.get(5);
/* 4232 */     if (ahoraCal.get(2) + 1 < 10) {
/* 4233 */       mesesito = "0" + mesesito;
/*      */     }
/* 4235 */     if (ahoraCal.get(5) < 10) {
/* 4236 */       hoy = "0" + hoy;
/*      */     }
/* 4238 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 4242 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4244 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4248 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField17, evt);
/*      */           }
/*      */         });
/*      */     
/* 4252 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4254 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4258 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 4261 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4263 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4267 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 4270 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4272 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4276 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 4279 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4281 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4285 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 4288 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4290 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4294 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 4297 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4299 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4303 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 4306 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4308 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4312 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 4315 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4317 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4321 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 4324 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4326 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4330 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 4333 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4335 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4339 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 4342 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4344 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4348 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 4351 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4353 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4357 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 4360 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4362 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4366 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 4369 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4371 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4375 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 4378 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4380 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4384 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 4387 */     this.jTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4389 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField25, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4393 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField25, evt);
/*      */           }
/*      */         });
/* 4396 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4398 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField26, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4402 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField26, evt);
/*      */           }
/*      */         });
/* 4405 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4407 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4411 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 4414 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4416 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4420 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 4423 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4425 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4429 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 4432 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4434 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4438 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 4441 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4443 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4447 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 4450 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4452 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4456 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 4459 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4461 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4465 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 4468 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4470 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4474 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/* 4477 */     this.jFormattedTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4479 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4483 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField7, evt);
/*      */           }
/*      */         });
/* 4486 */     this.jFormattedTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4488 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jFormattedTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4492 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jFormattedTextField8, evt);
/*      */           }
/*      */         });
/* 4495 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4497 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4501 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 4504 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4506 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4510 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 4513 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4515 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4519 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 4522 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4524 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4528 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 4531 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4533 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4537 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 4540 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4542 */             EmpleadosAgregar.this.jTextGanado(EmpleadosAgregar.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4546 */             EmpleadosAgregar.this.jTextPerdido(EmpleadosAgregar.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public void cargarFormulario() {
/* 4553 */     this.materialButton21.setVisible(true);
/* 4554 */     this.materialButton20.setVisible(true);
/* 4555 */     this.materialButton17.setMnemonic('M');
/* 4556 */     this.materialButton17.setToolTipText("Modificar (Alt+M)");
/* 4557 */     String[] campos = this.con.regresaReg("clave_emp,empleados.nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,estados.estado,tel_casa,celular,correo,fecha_nac,nss,rfc,sexo,empleados.clave_depa,ingreso,infonavit,numInfo,lugarNacimiento,cargoNextel,Nextel,cantNextel,cargoInfo,tipoEmp,UltimoIngreso,diasContrato,etiqueta,estadoCivil,hijos,salarioImss,salarioReal,personaContrato,testigo1,testigo2,recomendado,comentarios,rfcOriginal", "empleados,departamentos,estados", "where empleados.id_edo = estados.id_edo and clave_emp=" + this.id, 40);
/* 4558 */     this.jTextField17.setText(campos[39]);
/* 4559 */     this.inf = campos;
/* 4560 */     this.jTextField13.setText(campos[0]);
/* 4561 */     this.jTextField1.setText(campos[1]);
/* 4562 */     this.jTextField2.setText(campos[2]);
/* 4563 */     this.jTextField3.setText(campos[3]);
/* 4564 */     this.jTextField4.setText(campos[4]);
/* 4565 */     this.jTextField5.setText(campos[5]);
/* 4566 */     this.jTextField6.setText(campos[6]);
/* 4567 */     this.jTextField8.setText(campos[8]);
/* 4568 */     this.jTextField8.setText(campos[8]);
/* 4569 */     if (!campos[16].equals("")) {
/* 4570 */       this.jComboBox2.removeAllItems();
/* 4571 */       this.jComboBox2.addItem("MASCULINO");
/* 4572 */       this.jComboBox2.addItem("FEMENINO");
/* 4573 */       this.jComboBox2.setSelectedItem(campos[16]);
/*      */     } else {
/* 4575 */       this.jComboBox2.removeAllItems();
/* 4576 */       this.jComboBox2.addItem("Selecciona uno...");
/* 4577 */       this.jComboBox2.addItem("MASCULINO");
/* 4578 */       this.jComboBox2.addItem("FEMENINO");
/*      */     } 
/* 4580 */     if (!campos[9].equals("")) {
/* 4581 */       this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/* 4582 */       this.jComboBox3.setSelectedItem(campos[9]);
/*      */     } else {
/* 4584 */       this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/*      */     } 
/* 4586 */     if (!campos[7].equals("0")) {
/* 4587 */       this.jTextField7.setText(campos[7]);
/*      */     } else {
/* 4589 */       this.jTextField7.setText("");
/*      */     } 
/* 4591 */     this.jTextField9.setText(campos[14]);
/* 4592 */     if (this.jTextField9.getText().equals("0")) {
/* 4593 */       this.jTextField9.setText("");
/*      */     }
/* 4595 */     this.jTextField11.setText(campos[15]);
/* 4596 */     this.jTextField10.setText(campos[12]);
/* 4597 */     this.con.consultar("nombre", "departamentos", "where clave_depa = " + campos[17]);
/* 4598 */     this.jComboBox1.setSelectedItem(this.con.Campo);
/* 4599 */     this.jFormattedTextField1.setText(campos[10]);
/* 4600 */     this.jFormattedTextField2.setText(campos[11]);
/*      */     
/* 4602 */     String año = campos[13].substring(0, 4);
/* 4603 */     String mes = campos[13].substring(5, 7);
/* 4604 */     String dia = campos[13].substring(8, 10);
/* 4605 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4606 */     String strFecha = año + "-" + año + "-" + mes;
/* 4607 */     Date fecha = null;
/*      */     try {
/* 4609 */       fecha = formatoDelTexto.parse(strFecha);
/* 4610 */     } catch (ParseException ex) {
/* 4611 */       ex.printStackTrace();
/*      */     } 
/* 4613 */     this.jDateChooser1.setDate(fecha);
/* 4614 */     año = campos[18].substring(0, 4);
/* 4615 */     mes = campos[18].substring(5, 7);
/* 4616 */     dia = campos[18].substring(8, 10);
/* 4617 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4618 */     strFecha = año + "-" + año + "-" + mes;
/* 4619 */     fecha = null;
/*      */     try {
/* 4621 */       fecha = formatoDelTexto.parse(strFecha);
/* 4622 */     } catch (ParseException ex) {
/* 4623 */       ex.printStackTrace();
/*      */     } 
/* 4625 */     this.jDateChooser3.setDate(fecha);
/*      */     
/* 4627 */     año = campos[27].substring(0, 4);
/* 4628 */     mes = campos[27].substring(5, 7);
/* 4629 */     dia = campos[27].substring(8, 10);
/* 4630 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4631 */     strFecha = año + "-" + año + "-" + mes;
/* 4632 */     fecha = null;
/*      */     try {
/* 4634 */       fecha = formatoDelTexto.parse(strFecha);
/* 4635 */     } catch (ParseException ex) {
/* 4636 */       ex.printStackTrace();
/*      */     } 
/* 4638 */     this.jDateChooser4.setDate(fecha);
/*      */ 
/*      */     
/* 4641 */     this.jTextField15.setText(campos[20]);
/* 4642 */     this.jTextField15.setEnabled(true);
/* 4643 */     this.jFormattedTextField3.setEnabled(true);
/* 4644 */     this.jFormattedTextField3.setValue(Float.valueOf(Float.parseFloat(campos[19])));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4652 */     this.jTextField14.setText(campos[21]);
/* 4653 */     if (campos[22].equals("No")) {
/* 4654 */       this.jRadioButton3.setSelected(true);
/*      */     } else {
/* 4656 */       this.jRadioButton4.setSelected(true);
/*      */     } 
/* 4658 */     this.jTextField16.setText(campos[23]);
/* 4659 */     String canti = campos[24];
/* 4660 */     String valorP = "";
/* 4661 */     for (int j = 0; j < canti.length(); j++) {
/* 4662 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4663 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4666 */     double vp = Double.parseDouble(valorP);
/* 4667 */     this.jFormattedTextField6.setValue(Double.valueOf(vp));
/*      */     
/* 4669 */     if (campos[25].equals("No")) {
/* 4670 */       this.jRadioButton5.setSelected(true);
/*      */     } else {
/* 4672 */       this.jRadioButton6.setSelected(true);
/*      */     } 
/* 4674 */     this.jComboBox5.setSelectedItem(campos[26]);
/* 4675 */     this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(campos[28])));
/*      */     
/* 4677 */     this.jComboBox6.setSelectedItem(campos[29]);
/* 4678 */     this.jComboBox7.setSelectedItem(campos[30]);
/* 4679 */     this.jSpinner2.setValue(Integer.valueOf(Integer.parseInt(campos[31])));
/*      */     
/* 4681 */     canti = campos[32];
/* 4682 */     valorP = ""; int i;
/* 4683 */     for (i = 0; i < canti.length(); i++) {
/* 4684 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 4685 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4688 */     vp = Double.parseDouble(valorP);
/* 4689 */     this.jFormattedTextField7.setValue(Double.valueOf(vp));
/*      */     
/* 4691 */     canti = campos[33];
/* 4692 */     valorP = "";
/* 4693 */     for (i = 0; i < canti.length(); i++) {
/* 4694 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 4695 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4698 */     vp = Double.parseDouble(valorP);
/* 4699 */     this.jFormattedTextField8.setValue(Double.valueOf(vp));
/*      */     
/* 4701 */     this.jTextField25.setText(campos[34]);
/* 4702 */     this.jTextField29.setText(campos[35]);
/* 4703 */     this.jTextField26.setText(campos[36]);
/* 4704 */     this.jTextField27.setText(campos[37]);
/* 4705 */     this.jTextArea1.setText(campos[38]);
/*      */     
/* 4707 */     this.jFormattedTextField8.setEnabled(true);
/* 4708 */     if (this.PRIVILEGIOS.equals("CAPTURISTA")) {
/* 4709 */       this.jFormattedTextField8.setValue(Integer.valueOf(0));
/* 4710 */       this.jFormattedTextField8.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4715 */     String clave = this.jTextField8.getText();
/* 4716 */     String tipo = "";
/* 4717 */     String clave_depa = "";
/* 4718 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4719 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/* 4720 */       this.con.consultar("clave_depa", "departamentos", "where nombre = '" + tipo + "'");
/* 4721 */       clave_depa = this.con.Campo;
/*      */     } 
/* 4723 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 4724 */           .buscarDatos(18, "clave_emp,empleados.nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,estado,tel_casa,celular,correo,fecha_nac,nss,rfc,sexo,departamentos.nombre", "empleados,estados,departamentos", "where clave_emp like '%" + this.jTextField8.getText() + "%' and empleados.nombre like '%" + this.jTextField5.getText() + "%' and ap_pat like '%" + this.jTextField6.getText() + "%' and ap_mat like '%" + this.jTextField7.getText() + "%' and empleados.id_edo = estados.id_edo and empleados.clave_depa = departamentos.clave_depa and departamentos.clave_depa like '%" + clave_depa + "%' order by clave_emp"), (Object[])new String[] { "Clave", "Nombre Completo", "Apellido Paterno", "Apellido Materno", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Correo", "Fecha de Nac.", "NSS", "RFC", "Sexo", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4729 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4734 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4737 */     this.jTable3.setShowVerticalLines(false);
/* 4738 */     eliminarColumna(2, 1, "Apellido Paterno");
/* 4739 */     eliminarColumna(2, 1, "Apellido Materno");
/* 4740 */     eliminarColumna(3, 2, "Número");
/* 4741 */     eliminarColumna(3, 2, "Colonia");
/* 4742 */     eliminarColumna(3, 2, "CP");
/* 4743 */     eliminarColumna(3, 2, "Ciudad");
/* 4744 */     eliminarColumna(3, 2, "Estado");
/*      */     
/* 4746 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4747 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4748 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(65);
/* 4749 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(65);
/* 4750 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(65);
/* 4751 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(65);
/* 4752 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(120);
/* 4753 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(120);
/* 4754 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(85);
/* 4755 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(85);
/* 4756 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(70);
/* 4757 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(70);
/* 4758 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(65);
/* 4759 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(65);
/* 4760 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 4761 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 4762 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(120);
/* 4763 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(120);
/* 4764 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/* 4765 */     this.jTable3.setSelectionMode(0);
/* 4766 */     this.jTable3.setAutoCreateRowSorter(true);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 4770 */     int cont = this.jTable3.getRowCount();
/* 4771 */     String[] registros = new String[cont]; int i;
/* 4772 */     for (i = 0; i < cont; i++) {
/* 4773 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*      */     }
/* 4775 */     for (i = 0; i < cont; i++) {
/* 4776 */       registros[i] = registros[i] + " " + registros[i];
/* 4777 */       this.jTable3.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4779 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 4780 */     this.jTable3.removeColumn(columna);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar1() {
/* 4786 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con
/* 4787 */           .buscarDatos(2, "clave_depa,nombre", "departamentos", "order by nombre"), (Object[])new String[] { "Clave", "Departamento" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4792 */           Class[] types = new Class[] { Object.class, Object.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4797 */             return this.types[columnIndex];
/*      */           }
/* 4799 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4804 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4807 */     this.rSTableMetro3.setShowVerticalLines(false);
/*      */     
/* 4809 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 4810 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(60);
/* 4811 */     this.rSTableMetro3.setSelectionMode(0);
/* 4812 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 4813 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */   
/*      */   public void hayDatos(JTextField texto) {
/* 4817 */     if (!texto.getText().isEmpty()) {
/* 4818 */       this.datos.escribir();
/* 4819 */     } else if (this.jTextField1.getText().equals("") && this.jTextField2.getText().equals("") && this.jTextField3.getText().equals("") && this.jTextField4.getText().equals("") && this.jTextField5.getText().equals("") && this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("") && this.jTextField10.getText().equals("") && this.jComboBox3.getSelectedIndex() == 0 && this.jComboBox1.getSelectedIndex() == 0) {
/* 4820 */       this.datos.eliminar();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCombo() {
/* 4826 */     String[] depa = this.con.regresaColIndex("nombre", "departamentos", "order by nombre");
/* 4827 */     this.jComboBox1.removeAllItems();
/* 4828 */     this.jComboBox1.addItem("Selecciona uno...");
/* 4829 */     for (int i = 0; i < depa.length; i++) {
/* 4830 */       this.jComboBox1.addItem(depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void crearInd() {
/* 4835 */     int id = 0;
/* 4836 */     this.con.consultar("count(clave_emp)", "empleados", "");
/* 4837 */     if (!this.con.Campo.equals("0")) {
/* 4838 */       this.con.consultar("max(clave_emp)", "empleados", "");
/* 4839 */       id = Integer.parseInt(this.con.Campo);
/* 4840 */       id++;
/* 4841 */       this.jTextField13.setText("" + id);
/*      */     } else {
/* 4843 */       id = 1;
/*      */     } 
/* 4845 */     this.jTextField13.setText("" + id);
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
/*      */   public void guardarDepa() {
/* 4864 */     this.error.pasarModal(true);
/* 4865 */     this.val.pasarModal(Boolean.valueOf(true));
/* 4866 */     String marca = this.jTextField12.getText().toUpperCase();
/* 4867 */     if (this.materialButton23.getText().equals("Guardar")) {
/* 4868 */       this.CLAVEDEPA = "0";
/*      */     }
/* 4870 */     if (marca.equals("")) {
/* 4871 */       this.error.cargarError(this.jTextField12, "050");
/* 4872 */     } else if (!this.val.validarApostrofe(this.jTextField12, marca, "020")) {
/* 4873 */       this.encontrado = this.con.consultar("nombre", "departamentos", "where nombre = '" + this.jTextField12.getText() + "' and clave_depa<>" + this.CLAVEDEPA);
/* 4874 */       if (this.encontrado) {
/* 4875 */         this.jTextField12.setBackground(Color.RED);
/* 4876 */         JOptionPane.showMessageDialog(this.padre, "No puedes crear el departamento porque ya existe en la base de datos", "Departamento Duplicado", 0, this.ERROR);
/* 4877 */       } else if (this.jTextArea2.getText().equals("")) {
/* 4878 */         this.jTextArea2.setBackground(Color.RED);
/* 4879 */         JOptionPane.showMessageDialog(this.padre, "Te falta agregar las actividades del departamento", "Faltan Actividades", 0, this.ERROR);
/* 4880 */       } else if (this.jTextArea2.getText().length() > 999) {
/* 4881 */         this.jTextArea2.setBackground(Color.RED);
/* 4882 */         JOptionPane.showMessageDialog(this.padre, "No puedes superar los 999 caracteres para colocar las actividades.", "Demasiados Caracteres", 0, this.ERROR);
/*      */       }
/* 4884 */       else if (this.materialButton23.getText().equals("Modificar")) {
/* 4885 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar el departamento?", "Modificar Departamento", 0, 1, this.PREG);
/* 4886 */         if (res == 0) {
/* 4887 */           this.con.inserSinMsj("update departamentos set nombre='" + this.jTextField12.getText().toUpperCase() + "', actividades='" + this.jTextArea2.getText().toUpperCase() + "' where clave_depa=" + this.CLAVEDEPA);
/* 4888 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo Departamento.','Nombre: " + this.jTextField12.getText() + "')");
/* 4889 */           llenarCombo();
/* 4890 */           this.materialButton23.setText("Guardar");
/* 4891 */           this.materialButton23.setToolTipText("Guardar (Alt+G)");
/* 4892 */           String var = this.jTextField12.getText().toUpperCase();
/* 4893 */           this.jComboBox1.setSelectedItem(var);
/* 4894 */           consultar1();
/* 4895 */           this.jTextField12.setText("");
/* 4896 */           this.jTextArea2.setText("");
/*      */         } 
/*      */       } else {
/* 4899 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas crear un nuevo departamento?", "Crear Departamento", 0, 1, this.PREG);
/* 4900 */         if (res == 0) {
/* 4901 */           this.con.insertar("insert into departamentos(nombre,actividades)values('" + marca + "','" + this.jTextArea2.getText().toUpperCase() + "')");
/* 4902 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo Departamento.','Nombre: " + this.jTextField12.getText() + "')");
/*      */           
/* 4904 */           llenarCombo();
/* 4905 */           String var = this.jTextField12.getText().toUpperCase();
/* 4906 */           this.jComboBox1.setSelectedItem(var);
/* 4907 */           consultar1();
/* 4908 */           this.jTextField12.setText("");
/* 4909 */           this.jTextArea2.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   class CeldaRender extends DefaultTableCellRenderer { int otro;
/*      */     int[] indices;
/*      */     
/*      */     CeldaRender() {
/* 4918 */       this.otro = -1;
/* 4919 */       this.indices = new int[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4922 */       setEnabled((table == null || table.isEnabled()));
/* 4923 */       if (comparar(row)) {
/* 4924 */         setBackground(Color.red);
/* 4925 */       } else if (row % 2 == 0 && (column == 3 || column == 4)) {
/* 4926 */         setBackground(new Color(120, 200, 104));
/* 4927 */       } else if (row % 2 == 0 && (column == 7 || column == 8)) {
/* 4928 */         setBackground(new Color(136, 191, 173));
/*      */       
/*      */       }
/* 4931 */       else if (row % 2 == 0) {
/* 4932 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/* 4934 */         setBackground((Color)null);
/*      */       } 
/* 4936 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4937 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(int[] ind) {
/* 4941 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(int reg) {
/* 4945 */       for (int i = 0; i < this.indices.length; i++) {
/* 4946 */         if (this.indices[i] == reg) {
/* 4947 */           return true;
/*      */         }
/*      */       } 
/* 4950 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public String direccion() {
/* 4955 */     JFileChooser fileChooser = new JFileChooser();
/* 4956 */     fileChooser.setFileSelectionMode(1);
/* 4957 */     String fileName = "";
/* 4958 */     int retVal = fileChooser.showSaveDialog(null);
/* 4959 */     if (retVal == 0) {
/* 4960 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 4961 */       return fileName;
/*      */     } 
/* 4963 */     return "no";
/*      */   }
/*      */   
/*      */   public class ImprimirDatos
/*      */     implements Printable {
/* 4968 */     String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 4969 */     int opc = 0;
/* 4970 */     Graphics g2 = null; public int print(Graphics g, PageFormat f, int pageIndex) { int ind; Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; ImageIcon tmpIcon; String op, c1, c2, cadenaFecha2, año, mes, dia, fechaCompleta, fecha1, estado, fecha, valor; int inicia, lineas;
/*      */       String[] DES;
/*      */       int i, cont, l, j;
/* 4973 */       this.g2 = g;
/* 4974 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 4980 */           ind = EmpleadosAgregar.this.jTable3.getSelectedRow();
/* 4981 */           fuente = new Font("Dialog", 1, 7);
/* 4982 */           g.setFont(fuente);
/* 4983 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 425, 25);
/* 4984 */           fuente = new Font("Dialog", 0, 7);
/* 4985 */           g.setFont(fuente);
/* 4986 */           this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA, KM 32.5", 425, 35);
/* 4987 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN 67451", 425, 45);
/* 4988 */           this.g2.drawString("FMF901004UZ9", 425, 55);
/* 4989 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4990 */           img = imagen.getImage();
/* 4991 */           this.g2.drawImage(img, 485, 52, 55, 55, null);
/* 4992 */           formato = new SimpleDateFormat("yyyyMMdd");
/*      */           
/* 4994 */           tmpIcon = new ImageIcon(EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png");
/* 4995 */           img = tmpIcon.getImage();
/* 4996 */           this.g2.drawImage(img, 20, 17, 68, 90, null);
/* 4997 */           this.g2.drawLine(415, 17, 415, 105);
/* 4998 */           fuente = new Font("Dialog", 1, 11);
/* 4999 */           this.g2.setFont(fuente);
/* 5000 */           this.g2.drawString("EMP-" + EmpleadosAgregar.this.jTextField13.getText().toUpperCase() + ": " + EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField3.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField1.getText().toUpperCase(), 105, 25);
/*      */           
/* 5002 */           this.g2.setColor(Color.RED);
/* 5003 */           this.g2.drawRect(105, 30, 300, 60);
/* 5004 */           this.g2.setColor(new Color(204, 0, 0));
/* 5005 */           this.g2.fillRect(106, 31, 90, 58);
/*      */           
/* 5007 */           fuente = new Font("Dialog", 1, 9);
/* 5008 */           this.g2.setFont(fuente);
/* 5009 */           this.g2.setColor(Color.WHITE);
/* 5010 */           this.g2.drawString("TELÉFONO", 107, 42);
/* 5011 */           this.g2.drawString("NSS", 107, 56);
/* 5012 */           this.g2.drawString("CATEGORÍA", 107, 69);
/* 5013 */           this.g2.drawString("FECHA DE IMP", 107, 82);
/*      */           
/* 5015 */           op = String.valueOf(EmpleadosAgregar.this.jComboBox1.getSelectedItem());
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5020 */           fuente = new Font("Dialog", 0, 9);
/* 5021 */           this.g2.setFont(fuente);
/* 5022 */           this.g2.setColor(Color.BLACK);
/* 5023 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField1.getText(), 205, 42);
/* 5024 */           this.g2.drawString(EmpleadosAgregar.this.jTextField9.getText().toUpperCase(), 205, 56);
/* 5025 */           this.g2.drawString(op, 205, 69);
/* 5026 */           this.g2.drawString(EmpleadosAgregar.this.cargarFechaHoy(), 205, 82);
/*      */           
/* 5028 */           this.g2.setColor(new Color(56, 93, 138));
/* 5029 */           this.g2.drawRoundRect(16, 15, 76, 94, 10, 10);
/*      */           
/* 5031 */           this.g2.setColor(Color.RED);
/* 5032 */           this.g2.fill3DRect(15, 112, 580, 7, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5042 */           this.g2.setColor(Color.RED);
/* 5043 */           this.g2.drawLine(125, 136, 125, 252);
/* 5044 */           this.g2.drawRect(15, 135, 285, 118);
/* 5045 */           this.g2.setColor(Color.GRAY);
/* 5046 */           this.g2.fillRect(16, 136, 18, 116);
/*      */ 
/*      */ 
/*      */           
/* 5050 */           fuente = new Font("Dialog", 1, 5);
/* 5051 */           this.g2.setFont(fuente);
/* 5052 */           this.g2.setColor(Color.WHITE);
/* 5053 */           this.g2.drawString("D", 19, 183);
/* 5054 */           this.g2.drawString("A", 19, 190);
/* 5055 */           this.g2.drawString("T", 19, 197);
/* 5056 */           this.g2.drawString("O", 19, 204);
/* 5057 */           this.g2.drawString("S", 19, 209);
/*      */           
/* 5059 */           this.g2.drawString("P", 26, 164);
/* 5060 */           this.g2.drawString("E", 26, 169);
/* 5061 */           this.g2.drawString("R", 26, 178);
/* 5062 */           this.g2.drawString("S", 26, 185);
/* 5063 */           this.g2.drawString("O", 26, 192);
/* 5064 */           this.g2.drawString("N", 26, 199);
/* 5065 */           this.g2.drawString("A", 26, 206);
/* 5066 */           this.g2.drawString("L", 26, 213);
/* 5067 */           this.g2.drawString("E", 26, 220);
/* 5068 */           this.g2.drawString("S", 26, 227);
/*      */           
/* 5070 */           fuente = new Font("Dialog", 1, 7);
/* 5071 */           this.g2.setFont(fuente);
/* 5072 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 5074 */           this.g2.drawString("FECHA DE NAC", 37, 145);
/* 5075 */           this.g2.drawString("LUGAR DE NACIMIENTO", 37, 158);
/* 5076 */           this.g2.drawString("NÚM DE SEG SOCIAL", 37, 171);
/* 5077 */           this.g2.drawString("CURP", 37, 184);
/*      */           
/* 5079 */           this.g2.drawString("CARGO AUTOM NEXTEL", 37, 197);
/* 5080 */           this.g2.drawString("NEXTEL", 37, 210);
/* 5081 */           this.g2.drawString("CARGO", 200, 210);
/* 5082 */           this.g2.drawString("CARGO AUTOM INFON", 37, 223);
/* 5083 */           this.g2.drawString("INFONAVIT", 37, 236);
/* 5084 */           this.g2.drawString("CARGO", 200, 236);
/* 5085 */           this.g2.drawString("TIPO", 37, 249);
/*      */           
/* 5087 */           fuente = new Font("Dialog", 0, 8);
/* 5088 */           this.g2.setFont(fuente);
/*      */           
/* 5090 */           c1 = "NO";
/* 5091 */           c2 = "NO";
/*      */           
/* 5093 */           if (!EmpleadosAgregar.this.jRadioButton3.isSelected()) {
/* 5094 */             c1 = "SI";
/*      */           }
/*      */           
/* 5097 */           if (!EmpleadosAgregar.this.jRadioButton5.isSelected()) {
/* 5098 */             c2 = "SI";
/*      */           }
/*      */           
/* 5101 */           cadenaFecha2 = formato.format(EmpleadosAgregar.this.jDateChooser1.getDate());
/* 5102 */           año = cadenaFecha2.substring(0, 4);
/* 5103 */           mes = cadenaFecha2.substring(4, 6);
/* 5104 */           dia = cadenaFecha2.substring(6, 8);
/* 5105 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5107 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5108 */           this.g2.drawString(fecha1, 130, 145);
/* 5109 */           this.g2.drawString(EmpleadosAgregar.this.jTextField14.getText().toUpperCase(), 130, 158);
/* 5110 */           this.g2.drawString(EmpleadosAgregar.this.jTextField9.getText().toUpperCase(), 130, 171);
/* 5111 */           this.g2.drawString(EmpleadosAgregar.this.jTextField11.getText().toUpperCase(), 130, 184);
/* 5112 */           this.g2.drawString(c1, 130, 197);
/* 5113 */           this.g2.drawString(EmpleadosAgregar.this.jTextField16.getText().toUpperCase(), 130, 210);
/* 5114 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField6.getText(), 233, 210);
/* 5115 */           this.g2.drawString(c2, 130, 223);
/* 5116 */           this.g2.drawString(EmpleadosAgregar.this.jTextField15.getText().toUpperCase(), 130, 236);
/* 5117 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField3.getText(), 233, 236);
/* 5118 */           this.g2.drawString(String.valueOf(EmpleadosAgregar.this.jComboBox5.getSelectedItem()), 130, 249);
/* 5119 */           this.g2.setColor(Color.RED);
/* 5120 */           this.g2.drawLine(125, 136, 125, 239);
/*      */           
/* 5122 */           this.g2.setColor(Color.WHITE);
/* 5123 */           this.g2.fillRect(301, 130, 80, 190);
/*      */           
/* 5125 */           this.g2.setColor(Color.RED);
/* 5126 */           this.g2.drawRect(310, 135, 285, 80);
/* 5127 */           this.g2.setColor(Color.GRAY);
/* 5128 */           this.g2.fillRect(311, 136, 18, 78);
/* 5129 */           this.g2.setColor(Color.WHITE);
/* 5130 */           this.g2.fillRect(329, 136, 85, 78);
/* 5131 */           this.g2.fillRect(414, 136, 180, 78);
/* 5132 */           fuente = new Font("Dialog", 1, 5);
/* 5133 */           this.g2.setFont(fuente);
/* 5134 */           this.g2.setColor(Color.WHITE);
/* 5135 */           this.g2.drawString("D", 318, 144);
/* 5136 */           this.g2.drawString("O", 318, 152);
/* 5137 */           this.g2.drawString("M", 318, 160);
/* 5138 */           this.g2.drawString("I", 318, 168);
/* 5139 */           this.g2.drawString("C", 318, 176);
/* 5140 */           this.g2.drawString("I", 318, 184);
/* 5141 */           this.g2.drawString("L", 318, 192);
/* 5142 */           this.g2.drawString("I", 318, 200);
/* 5143 */           this.g2.drawString("O", 318, 208);
/*      */           
/* 5145 */           fuente = new Font("Dialog", 1, 7);
/* 5146 */           this.g2.setFont(fuente);
/* 5147 */           this.g2.setColor(Color.BLACK);
/* 5148 */           this.g2.drawString("CALLE", 332, 145);
/* 5149 */           this.g2.drawString("NÚMERO", 332, 158);
/* 5150 */           this.g2.drawString("COLONIA", 332, 171);
/* 5151 */           this.g2.drawString("CIUDAD", 332, 184);
/* 5152 */           this.g2.drawString("CÓDIGO POSTAL", 332, 197);
/* 5153 */           this.g2.drawString("ESTADO", 332, 210);
/*      */ 
/*      */           
/* 5156 */           estado = String.valueOf(EmpleadosAgregar.this.jComboBox3.getSelectedItem()) + String.valueOf(EmpleadosAgregar.this.jComboBox3.getSelectedItem());
/* 5157 */           if (estado.equals("SELECCIONA UNO...")) {
/* 5158 */             estado = "";
/*      */           }
/* 5160 */           fuente = new Font("Dialog", 0, 8);
/* 5161 */           this.g2.setFont(fuente);
/* 5162 */           this.g2.setColor(Color.BLACK);
/* 5163 */           this.g2.drawString(EmpleadosAgregar.this.jTextField4.getText().toUpperCase(), 425, 145);
/* 5164 */           this.g2.drawString(EmpleadosAgregar.this.jTextField5.getText().toUpperCase(), 425, 158);
/* 5165 */           this.g2.drawString(EmpleadosAgregar.this.jTextField6.getText().toUpperCase(), 425, 171);
/* 5166 */           this.g2.drawString(EmpleadosAgregar.this.jTextField8.getText().toUpperCase(), 425, 184);
/* 5167 */           this.g2.drawString(EmpleadosAgregar.this.jTextField7.getText().toUpperCase(), 425, 197);
/* 5168 */           this.g2.drawString(estado, 425, 210);
/* 5169 */           this.g2.setColor(Color.RED);
/* 5170 */           this.g2.drawLine(420, 136, 420, 215);
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
/* 5223 */           this.g2.setColor(Color.RED);
/* 5224 */           this.g2.drawRect(310, 225, 285, 132);
/* 5225 */           this.g2.setColor(Color.GRAY);
/* 5226 */           this.g2.fillRect(311, 226, 18, 130);
/* 5227 */           this.g2.setColor(Color.WHITE);
/* 5228 */           this.g2.fillRect(329, 226, 85, 130);
/* 5229 */           this.g2.fillRect(414, 226, 180, 130);
/* 5230 */           fuente = new Font("Dialog", 1, 5);
/* 5231 */           this.g2.setFont(fuente);
/* 5232 */           this.g2.drawString("D", 314, 260);
/* 5233 */           this.g2.drawString("A", 314, 268);
/* 5234 */           this.g2.drawString("T", 314, 276);
/* 5235 */           this.g2.drawString("O", 314, 284);
/* 5236 */           this.g2.drawString("S", 314, 292);
/*      */           
/* 5238 */           this.g2.drawString("D", 314, 308);
/* 5239 */           this.g2.drawString("E", 314, 316);
/* 5240 */           this.g2.drawString("L", 314, 324);
/*      */           
/* 5242 */           this.g2.drawString("C", 321, 262);
/* 5243 */           this.g2.drawString("O", 321, 270);
/* 5244 */           this.g2.drawString("N", 321, 278);
/* 5245 */           this.g2.drawString("T", 321, 289);
/* 5246 */           this.g2.drawString("R", 321, 297);
/* 5247 */           this.g2.drawString("A", 321, 305);
/* 5248 */           this.g2.drawString("T", 321, 313);
/* 5249 */           this.g2.drawString("O", 321, 321);
/*      */           
/* 5251 */           fuente = new Font("Dialog", 1, 7);
/* 5252 */           this.g2.setFont(fuente);
/* 5253 */           this.g2.setColor(Color.BLACK);
/* 5254 */           this.g2.drawString("FECHA DE INGRESO", 332, 235);
/* 5255 */           this.g2.drawString("DÍAS DEL CONTRATO", 332, 248);
/* 5256 */           this.g2.drawString("DISTINTIVO", 332, 261);
/* 5257 */           this.g2.drawString("CONTRATADO POR", 332, 274);
/* 5258 */           this.g2.drawString("TESTIGO 1", 332, 287);
/* 5259 */           this.g2.drawString("TESTIGO 2", 332, 300);
/* 5260 */           this.g2.drawString("RECOMENDADO POR", 332, 313);
/* 5261 */           this.g2.drawString("SALARIO NOMINAL", 332, 326);
/*      */ 
/*      */           
/* 5264 */           this.g2.drawString("ÚLTIMO INGRESO", 332, 352);
/*      */           
/* 5266 */           fuente = new Font("Dialog", 0, 8);
/* 5267 */           this.g2.setFont(fuente);
/* 5268 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 5270 */           cadenaFecha2 = formato.format(EmpleadosAgregar.this.jDateChooser3.getDate());
/* 5271 */           año = cadenaFecha2.substring(0, 4);
/* 5272 */           mes = cadenaFecha2.substring(4, 6);
/* 5273 */           dia = cadenaFecha2.substring(6, 8);
/* 5274 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 5275 */           fecha = fechaCompleta;
/* 5276 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5277 */           this.g2.drawString(fecha1, 425, 235);
/* 5278 */           this.g2.drawString(String.valueOf(EmpleadosAgregar.this.jSpinner1.getValue()), 425, 248);
/* 5279 */           this.g2.drawString(String.valueOf(EmpleadosAgregar.this.jComboBox6.getSelectedItem()), 425, 261);
/* 5280 */           this.g2.drawString(EmpleadosAgregar.this.jTextField25.getText().toUpperCase(), 425, 274);
/* 5281 */           this.g2.drawString(EmpleadosAgregar.this.jTextField29.getText().toUpperCase(), 425, 287);
/* 5282 */           this.g2.drawString(EmpleadosAgregar.this.jTextField26.getText().toUpperCase(), 425, 300);
/* 5283 */           this.g2.drawString(EmpleadosAgregar.this.jTextField27.getText().toUpperCase(), 425, 313);
/* 5284 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField7.getText(), 425, 326);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5289 */           cadenaFecha2 = formato.format(EmpleadosAgregar.this.jDateChooser4.getDate());
/* 5290 */           año = cadenaFecha2.substring(0, 4);
/* 5291 */           mes = cadenaFecha2.substring(4, 6);
/* 5292 */           dia = cadenaFecha2.substring(6, 8);
/* 5293 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5295 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5296 */           this.g2.drawString(fecha1, 425, 352);
/* 5297 */           this.g2.setColor(Color.RED);
/* 5298 */           this.g2.drawLine(420, 225, 420, 357);
/*      */ 
/*      */           
/* 5301 */           this.g2.setColor(Color.RED);
/* 5302 */           this.g2.drawRect(15, 288, 285, 69);
/* 5303 */           this.g2.setColor(Color.GRAY);
/* 5304 */           this.g2.fillRect(16, 289, 18, 67);
/* 5305 */           this.g2.setColor(Color.WHITE);
/* 5306 */           this.g2.fillRect(34, 289, 85, 67);
/* 5307 */           this.g2.fillRect(119, 289, 180, 67);
/* 5308 */           fuente = new Font("Dialog", 1, 5);
/* 5309 */           this.g2.setFont(fuente);
/* 5310 */           this.g2.setColor(Color.WHITE);
/* 5311 */           this.g2.drawString("O", 19, 311);
/* 5312 */           this.g2.drawString("T", 19, 318);
/* 5313 */           this.g2.drawString("R", 19, 325);
/* 5314 */           this.g2.drawString("O", 19, 332);
/* 5315 */           this.g2.drawString("S", 19, 339);
/*      */           
/* 5317 */           this.g2.drawString("D", 26, 311);
/* 5318 */           this.g2.drawString("A", 26, 318);
/* 5319 */           this.g2.drawString("T", 26, 325);
/* 5320 */           this.g2.drawString("O", 26, 332);
/* 5321 */           this.g2.drawString("S", 26, 339);
/*      */           
/* 5323 */           fuente = new Font("Dialog", 1, 7);
/* 5324 */           this.g2.setFont(fuente);
/* 5325 */           this.g2.setColor(Color.BLACK);
/* 5326 */           this.g2.drawString("NÚMERO DE HIJOS", 37, 298);
/* 5327 */           this.g2.drawString("ESTADO CIVIL", 37, 311);
/* 5328 */           this.g2.drawString("TELÉFONO", 37, 324);
/* 5329 */           this.g2.drawString("CELULAR", 37, 337);
/* 5330 */           this.g2.drawString("CORREO", 37, 351);
/*      */           
/* 5332 */           fuente = new Font("Dialog", 0, 8);
/* 5333 */           this.g2.setFont(fuente);
/* 5334 */           this.g2.setColor(Color.BLACK);
/* 5335 */           this.g2.drawString(String.valueOf(EmpleadosAgregar.this.jSpinner2.getValue()), 130, 298);
/* 5336 */           this.g2.drawString(String.valueOf(EmpleadosAgregar.this.jComboBox7.getSelectedItem()), 130, 311);
/* 5337 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField1.getText(), 130, 324);
/* 5338 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField2.getText(), 130, 337);
/* 5339 */           this.g2.drawString(EmpleadosAgregar.this.jTextField10.getText().toUpperCase(), 130, 351);
/* 5340 */           this.g2.setColor(Color.RED);
/* 5341 */           this.g2.drawLine(125, 288, 125, 357);
/*      */ 
/*      */           
/* 5344 */           this.g2.setColor(Color.RED);
/* 5345 */           this.g2.drawRect(15, 367, 580, 140);
/* 5346 */           this.g2.setColor(Color.GRAY);
/* 5347 */           this.g2.fillRect(16, 368, 18, 138);
/* 5348 */           this.g2.setColor(Color.WHITE);
/* 5349 */           this.g2.fillRect(34, 368, 560, 138);
/*      */           
/* 5351 */           fuente = new Font("Dialog", 1, 5);
/* 5352 */           this.g2.setFont(fuente);
/* 5353 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 5355 */           this.g2.drawString("A", 19, 417);
/* 5356 */           this.g2.drawString("L", 19, 424);
/* 5357 */           this.g2.drawString("G", 19, 431);
/* 5358 */           this.g2.drawString("U", 19, 438);
/* 5359 */           this.g2.drawString("N", 19, 445);
/* 5360 */           this.g2.drawString("A", 19, 452);
/* 5361 */           this.g2.drawString("S", 19, 459);
/*      */           
/* 5363 */           this.g2.drawString("R", 26, 403);
/* 5364 */           this.g2.drawString("E", 26, 410);
/* 5365 */           this.g2.drawString("F", 26, 417);
/* 5366 */           this.g2.drawString("E", 26, 424);
/* 5367 */           this.g2.drawString("R", 26, 431);
/* 5368 */           this.g2.drawString("E", 26, 438);
/* 5369 */           this.g2.drawString("N", 26, 445);
/* 5370 */           this.g2.drawString("C", 26, 452);
/* 5371 */           this.g2.drawString("I", 26, 459);
/* 5372 */           this.g2.drawString("A", 26, 466);
/* 5373 */           this.g2.drawString("S", 26, 473);
/*      */ 
/*      */           
/* 5376 */           fuente = new Font("Dialog", 0, 7);
/* 5377 */           this.g2.setFont(fuente);
/* 5378 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5386 */           valor = EmpleadosAgregar.this.jTextArea1.getText().toUpperCase();
/*      */           
/* 5388 */           inicia = 377;
/* 5389 */           lineas = valor.length() / 150;
/* 5390 */           lineas += 2;
/* 5391 */           DES = new String[lineas];
/* 5392 */           for (i = 0; i < DES.length; i++) {
/* 5393 */             DES[i] = new String("");
/*      */           }
/* 5395 */           cont = 0;
/* 5396 */           l = 0;
/* 5397 */           for (j = 0; j < valor.length(); j++) {
/* 5398 */             if (cont <= 150) {
/* 5399 */               DES[l] = DES[l] + DES[l];
/* 5400 */               cont++;
/*      */             } else {
/* 5402 */               DES[l] = DES[l] + DES[l];
/* 5403 */               cont = 0;
/* 5404 */               l++;
/*      */             } 
/*      */           } 
/* 5407 */           for (j = 0; j < DES.length; j++) {
/* 5408 */             g.drawString(DES[j], 37, inicia);
/* 5409 */             inicia += 8;
/*      */           } 
/*      */           
/* 5412 */           this.g2.drawString("_________________________________________", 15, 565);
/* 5413 */           this.g2.drawString(EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField3.getText().toUpperCase(), 15, 575);
/* 5414 */           this.g2.drawString("EMPLEADO", 15, 585);
/*      */           
/* 5416 */           this.DATOS = EmpleadosAgregar.this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + EmpleadosAgregar.this.USUARIO + "'", 3);
/* 5417 */           this.g2.drawString("_________________________________________", 15, 645);
/* 5418 */           this.g2.drawString(this.DATOS[0] + " " + this.DATOS[0] + " " + this.DATOS[1], 15, 655);
/* 5419 */           this.g2.drawString("EMPRESA", 15, 665);
/*      */           
/* 5421 */           this.g2.setColor(Color.RED);
/* 5422 */           this.g2.drawRect(310, 517, 285, 150);
/* 5423 */           this.g2.setColor(Color.GRAY);
/* 5424 */           this.g2.fillRect(311, 518, 18, 148);
/* 5425 */           this.g2.setColor(Color.WHITE);
/* 5426 */           this.g2.fillRect(329, 517, 85, 148);
/* 5427 */           this.g2.fillRect(414, 517, 180, 148);
/*      */           
/* 5429 */           this.g2.setColor(Color.RED);
/* 5430 */           this.g2.drawLine(310, 592, 595, 592);
/*      */           
/* 5432 */           fuente = new Font("Dialog", 1, 7);
/* 5433 */           this.g2.setFont(fuente);
/* 5434 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 5436 */           this.g2.drawString("A", 318, 539);
/* 5437 */           this.g2.drawString("L", 318, 552);
/* 5438 */           this.g2.drawString("T", 318, 565);
/* 5439 */           this.g2.drawString("A", 318, 578);
/*      */           
/* 5441 */           this.g2.drawString("B", 318, 612);
/* 5442 */           this.g2.drawString("A", 318, 625);
/* 5443 */           this.g2.drawString("J", 318, 638);
/* 5444 */           this.g2.drawString("A", 318, 651);
/*      */           
/* 5446 */           fuente = new Font("Dialog", 1, 7);
/* 5447 */           this.g2.setFont(fuente);
/* 5448 */           this.g2.setColor(Color.BLACK);
/* 5449 */           this.g2.drawString("_____________________________________", 390, 567);
/* 5450 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 580);
/*      */           
/* 5452 */           this.g2.drawString("_____________________________________", 390, 640);
/* 5453 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 653);
/*      */           
/* 5455 */           this.g2.setColor(new Color(56, 93, 138));
/* 5456 */           this.g2.drawRect(15, 730, 580, 40);
/* 5457 */           fuente = new Font("Dialog", 1, 6);
/* 5458 */           this.g2.setFont(fuente);
/* 5459 */           this.g2.setColor(Color.BLACK);
/* 5460 */           this.g2.drawString("          EN COMPLETO USO DE MIS FACULTADES DECLARO BAJO PROTESTA DECIR VERDAD QUE LA INFORMACIÓN PROPORCIONADA EN EL PRESENTE ES CORRECTA Y ESTOY CONFORME", 17, 747);
/* 5461 */           this.g2.drawString("                                                                     CON LAS POLÍTICAS DE LA EMPRESA. QUEDANDO A SUS ÓRDENES DESDE EL PRIMER DÍA DEL CONTRATO", 26, 759);
/*      */           
/* 5463 */           return 0;
/*      */       } 
/* 5465 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5470 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5471 */       job.setPrintable(this);
/*      */       
/* 5473 */       PageFormat pf = job.defaultPage();
/* 5474 */       Paper papel = pf.getPaper();
/* 5475 */       papel.setSize(612.0D, 792.0D);
/* 5476 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5477 */       pf.setPaper(papel);
/* 5478 */       pf.setOrientation(1);
/* 5479 */       job.setPrintable(new ImprimirDatos(), pf);
/* 5480 */       job.defaultPage(pf);
/*      */       
/* 5482 */       boolean ok = job.printDialog();
/* 5483 */       if (ok) {
/*      */         try {
/* 5485 */           job.print();
/* 5486 */         } catch (PrinterException printerException) {}
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
/*      */   public class fotoIndividual
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
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
/* 5777 */     String num = "";
/*      */     
/*      */     fotoIndividual(String valor) {
/* 5780 */       this.t = new Thread(this);
/* 5781 */       this.num = valor;
/* 5782 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5789 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png");
/*      */       
/* 5791 */       EmpleadosAgregar.this.FOTO = EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png";
/* 5792 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(190, -1, 1));
/* 5793 */       EmpleadosAgregar.this.jLabel1.setText("");
/* 5794 */       if (temporal.getImageLoadStatus() == 4) {
/* 5795 */         EmpleadosAgregar.this.jLabel1.setText("Sin Fotogafía");
/*      */       } else {
/* 5797 */         EmpleadosAgregar.this.jLabel1.setText("");
/* 5798 */         EmpleadosAgregar.this.jLabel1.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   class Limpiar
/*      */     implements Runnable {
/*      */     Thread t;
/* 5806 */     String nom = EmpleadosAgregar.this.jTextField1.getText();
/* 5807 */     String pat = EmpleadosAgregar.this.jTextField2.getText();
/* 5808 */     String mat = EmpleadosAgregar.this.jTextField3.getText();
/* 5809 */     String calle = EmpleadosAgregar.this.jTextField4.getText();
/* 5810 */     String num = EmpleadosAgregar.this.jTextField5.getText();
/* 5811 */     String col = EmpleadosAgregar.this.jTextField6.getText();
/* 5812 */     String cod = EmpleadosAgregar.this.jTextField7.getText();
/* 5813 */     String ciudad = EmpleadosAgregar.this.jTextField8.getText();
/* 5814 */     String correo = EmpleadosAgregar.this.jTextField10.getText();
/* 5815 */     String tel1 = EmpleadosAgregar.this.jFormattedTextField1.getText();
/* 5816 */     String tel2 = EmpleadosAgregar.this.jFormattedTextField2.getText();
/* 5817 */     Date fecha = EmpleadosAgregar.this.jDateChooser1.getDate();
/* 5818 */     int sexo = EmpleadosAgregar.this.jComboBox1.getSelectedIndex();
/* 5819 */     int estado = EmpleadosAgregar.this.jComboBox3.getSelectedIndex();
/*      */     
/*      */     Limpiar() {
/* 5822 */       this.t = new Thread(this);
/* 5823 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5831 */         Thread.currentThread(); Thread.sleep(0L);
/* 5832 */         if (!this.nom.equals("") || !this.pat.equals("") || !this.mat.equals("") || !this.calle.equals("") || !this.num.equals("") || !this.col.equals("") || !this.cod.equals("") || !this.ciudad.equals("") || this.estado != 0 || !this.correo.equals("") || !this.tel1.equals("___-___-____") || !this.tel2.equals("___-___-____") || this.fecha != null || this.sexo != 0);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 5838 */       catch (InterruptedException interruptedException) {}
/*      */     }
/*      */   }
/*      */   
/*      */   class fotoCredencial
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 5846 */     String num = "";
/*      */     
/*      */     fotoCredencial(String valor) {
/* 5849 */       this.t = new Thread(this);
/* 5850 */       this.num = valor;
/* 5851 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5858 */       ImageIcon tmpIcon = new ImageIcon(EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png");
/* 5859 */       EmpleadosAgregar.this.FOTO = EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png";
/* 5860 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(98, -1, 1));
/* 5861 */       EmpleadosAgregar.this.jLabel78.setText("");
/* 5862 */       EmpleadosAgregar.this.jLabel115.setText("");
/* 5863 */       EmpleadosAgregar.this.jLabel98.setText("");
/* 5864 */       if (temporal.getImageLoadStatus() == 4) {
/* 5865 */         EmpleadosAgregar.this.jLabel78.setText("Sin fotografía");
/* 5866 */         EmpleadosAgregar.this.jLabel115.setText("Sin fotografía");
/* 5867 */         EmpleadosAgregar.this.jLabel98.setText("Sin fotografía");
/*      */       } else {
/* 5869 */         EmpleadosAgregar.this.jLabel78.setText("");
/* 5870 */         EmpleadosAgregar.this.jLabel115.setText("");
/* 5871 */         EmpleadosAgregar.this.jLabel98.setText("");
/* 5872 */         EmpleadosAgregar.this.jLabel78.setIcon(temporal);
/* 5873 */         EmpleadosAgregar.this.jLabel115.setIcon(temporal);
/* 5874 */         EmpleadosAgregar.this.jLabel98.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirCredencial
/*      */     implements Printable
/*      */   {
/* 5882 */     int opc = 0;
/* 5883 */     Graphics2D g2 = null; public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; ImageIcon tmpIcon; String nombre;
/*      */       int cuenta, esp3;
/*      */       String nombre1, nombre2;
/* 5886 */       this.g2 = (Graphics2D)g;
/* 5887 */       f.setOrientation(1);
/* 5888 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 5894 */           fuente = new Font("Dialog", 1, 12);
/* 5895 */           this.g2.setFont(fuente);
/* 5896 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5904 */           this.g2.setColor(Color.BLACK);
/* 5905 */           this.g2.drawRect(30, 45, 244, 154);
/* 5906 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 5908 */           fuente = new Font("Times New Roman", 1, 11);
/* 5909 */           this.g2.setFont(fuente);
/* 5910 */           this.g2.setColor(new Color(153, 0, 0));
/* 5911 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 34, 57);
/*      */           
/* 5913 */           fuente = new Font("Dialog", 1, 9);
/* 5914 */           this.g2.setFont(fuente);
/* 5915 */           this.g2.setColor(Color.BLACK);
/* 5916 */           this.g2.drawLine(35, 60, 255, 60);
/* 5917 */           this.g2.drawLine(45, 63, 265, 63);
/* 5918 */           this.g2.drawRect(32, 72, 68, 90);
/*      */           
/* 5920 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/mosaico.png"));
/* 5921 */           img = imagen.getImage();
/* 5922 */           this.g2.drawImage(img, 193, 80, 80, 85, null);
/*      */           
/* 5924 */           tmpIcon = new ImageIcon(EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png");
/* 5925 */           img = tmpIcon.getImage();
/* 5926 */           this.g2.drawImage(img, 33, 73, 66, 88, null);
/*      */           
/* 5928 */           fuente = new Font("Dialog", 1, 9);
/* 5929 */           this.g2.setFont(fuente);
/* 5930 */           this.g2.setColor(Color.BLACK);
/* 5931 */           nombre = EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField3.getText().toUpperCase();
/* 5932 */           cuenta = 0;
/* 5933 */           esp3 = 0;
/* 5934 */           nombre1 = "";
/* 5935 */           nombre2 = "";
/* 5936 */           if (nombre.length() > 26) {
/* 5937 */             for (int i = 0; i < nombre.length(); i++) {
/* 5938 */               if (nombre.charAt(i) == ' ') {
/* 5939 */                 cuenta++;
/*      */               }
/* 5941 */               if (cuenta < 3) {
/* 5942 */                 nombre1 = nombre1 + nombre1;
/*      */               } else {
/* 5944 */                 nombre2 = nombre2 + nombre2;
/*      */               } 
/*      */             } 
/*      */           } else {
/* 5948 */             nombre1 = nombre;
/*      */           } 
/* 5950 */           this.g2.drawString(nombre1, 105, 77);
/* 5951 */           this.g2.drawString(nombre2, 103, 88);
/*      */           
/* 5953 */           fuente = new Font("Dialog", 1, 8);
/* 5954 */           this.g2.setFont(fuente);
/*      */           
/* 5956 */           this.g2.drawString("TELÉFONO:", 105, 102);
/* 5957 */           this.g2.drawString("NSS:", 105, 126);
/* 5958 */           this.g2.drawString("CURP:", 105, 138);
/* 5959 */           this.g2.drawString("VIGENCIA:", 105, 151);
/*      */           
/* 5961 */           fuente = new Font("Dialog", 0, 9);
/* 5962 */           this.g2.setFont(fuente);
/*      */ 
/*      */           
/* 5965 */           this.g2.drawString(EmpleadosAgregar.this.jFormattedTextField1.getText(), 105, 112);
/* 5966 */           this.g2.drawString(EmpleadosAgregar.this.jTextField9.getText().toUpperCase(), 127, 126);
/* 5967 */           this.g2.drawString(EmpleadosAgregar.this.jTextField11.getText().toUpperCase(), 134, 138);
/* 5968 */           this.g2.drawString(EmpleadosAgregar.this.VIGENCIA, 105, 161);
/*      */           
/* 5970 */           fuente = new Font("DialogInput", 1, 10);
/* 5971 */           this.g2.setFont(fuente);
/* 5972 */           this.g2.drawString(EmpleadosAgregar.this.CLAVEOP, 39, 173);
/*      */           
/* 5974 */           this.g2.setColor(new Color(247, 150, 70));
/* 5975 */           this.g2.fill3DRect(102, 164, 170, 12, true);
/*      */           
/* 5977 */           this.g2.setColor(Color.BLACK);
/* 5978 */           this.g2.drawString(EmpleadosAgregar.this.jLabel81.getText(), 114, 173);
/*      */           
/* 5980 */           this.g2.setColor(new Color(153, 0, 0));
/* 5981 */           this.g2.fill3DRect(32, 180, 240, 18, true);
/*      */           
/* 5983 */           fuente = new Font("Dialog", 0, 7);
/* 5984 */           this.g2.setColor(Color.WHITE);
/* 5985 */           this.g2.setFont(fuente);
/* 5986 */           this.g2.drawString("Carretera México - Tuxpan Km. 8.5  Ejido Lázaro Cárdenas", 60, 187);
/* 5987 */           this.g2.drawString(" Tihuatlán, Veracruz México C.P. 92901 (01 782)-825-6455 al 58 ", 53, 195);
/*      */           
/* 5989 */           fuente = new Font("Dialog", 1, 10);
/* 5990 */           this.g2.setColor(Color.BLACK);
/* 5991 */           this.g2.drawString("|                                                         |", 58, 187);
/* 5992 */           this.g2.drawString("|                               |            |                  |                                       |", 53, 195);
/*      */ 
/*      */           
/* 5995 */           fuente = new Font("Times New Roman", 1, 11);
/* 5996 */           this.g2.setFont(fuente);
/* 5997 */           this.g2.setColor(new Color(153, 0, 0));
/* 5998 */           this.g2.drawString("POLÍTICAS DE LA EMPRESA", 325, 57);
/*      */           
/* 6000 */           fuente = new Font("Dialog", 1, 9);
/* 6001 */           this.g2.setFont(fuente);
/* 6002 */           this.g2.setColor(Color.BLACK);
/* 6003 */           this.g2.drawLine(285, 60, 505, 60);
/* 6004 */           this.g2.drawLine(290, 63, 515, 63);
/*      */ 
/*      */           
/* 6007 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/codigoBarras.png"));
/* 6008 */           img = imagen.getImage();
/* 6009 */           this.g2.drawImage(img, 492, 70, 30, 120, null);
/*      */           
/* 6011 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png"));
/* 6012 */           img = imagen.getImage();
/*      */           
/* 6014 */           this.g2.drawImage(img, 281, 100, 211, 60, null);
/*      */           
/* 6016 */           fuente = new Font("Dialog", 0, 5);
/* 6017 */           this.g2.setFont(fuente);
/* 6018 */           this.g2.drawString("•   Brindar trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos", 282, 73);
/* 6019 */           this.g2.drawString("     considerando que el fin de la empresa es el servicio del cliente.", 282, 79);
/* 6020 */           this.g2.drawString("•   Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo", 282, 88);
/* 6021 */           this.g2.drawString("     es mi responsabilidad.", 282, 94);
/* 6022 */           this.g2.drawString("•   Como integrante de la empresa debo mantener un comportamiento ético, desterrar", 282, 103);
/* 6023 */           this.g2.drawString("     toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de", 282, 109);
/* 6024 */           this.g2.drawString("     FORSIS y de todos los clientes.", 282, 115);
/* 6025 */           this.g2.drawString("•   Realizar evaluaciones periódicas, permanentes a todos los procesos donde se está", 282, 124);
/* 6026 */           this.g2.drawString("     involucrado mi desempeño.", 282, 130);
/* 6027 */           this.g2.drawString("•   Preservar el entorno ambiental y la seguridad de la comunidad en todo trabajo.", 282, 139);
/* 6028 */           this.g2.drawString("•   Difundir permanentemente la gestión de la empresa en forma interna y externa.", 282, 145);
/*      */           
/* 6030 */           fuente = new Font("Dialog", 1, 5);
/* 6031 */           this.g2.setFont(fuente);
/* 6032 */           this.g2.drawString(EmpleadosAgregar.this.jLabel82.getText(), 286, 165);
/* 6033 */           this.g2.drawString("ROGER GARZA CANTÚ", 420, 165);
/* 6034 */           this.g2.drawString("____________________________", 295, 185);
/* 6035 */           this.g2.drawString("____________________________", 410, 185);
/* 6036 */           this.g2.drawString(EmpleadosAgregar.this.jLabel81.getText().toUpperCase(), 305, 195);
/* 6037 */           this.g2.drawString("DIRECTOR", 438, 195);
/*      */           
/* 6039 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/firma.png"));
/* 6040 */           img = imagen.getImage();
/* 6041 */           this.g2.drawImage(img, 432, 159, 38, 38, null);
/*      */           
/* 6043 */           return 0;
/*      */       } 
/* 6045 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6050 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6051 */       job.setPrintable(this);
/*      */       
/* 6053 */       PageFormat pf = job.defaultPage();
/* 6054 */       Paper papel = pf.getPaper();
/* 6055 */       papel.setSize(612.0D, 792.0D);
/* 6056 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6057 */       pf.setPaper(papel);
/* 6058 */       pf.setOrientation(1);
/* 6059 */       ImprimirCredencial im = new ImprimirCredencial();
/* 6060 */       job.setPrintable(im, pf);
/* 6061 */       job.defaultPage(pf);
/*      */       
/* 6063 */       boolean ok = job.printDialog();
/* 6064 */       if (ok)
/*      */         try {
/* 6066 */           job.print();
/* 6067 */         } catch (PrinterException printerException) {} 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirRigPass implements Printable {
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     
/* 6075 */     public ImprimirRigPass() { this.opc = 0;
/* 6076 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen;
/*      */       Image img;
/*      */       ImageIcon tmpIcon;
/* 6079 */       this.g2 = (Graphics2D)g;
/* 6080 */       f.setOrientation(1);
/* 6081 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 6087 */           fuente = new Font("Dialog", 1, 12);
/* 6088 */           this.g2.setFont(fuente);
/* 6089 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6097 */           this.g2.setColor(Color.BLUE);
/* 6098 */           this.g2.drawRect(30, 45, 244, 154);
/* 6099 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 6101 */           fuente = new Font("Times New Roman", 1, 8);
/* 6102 */           this.g2.setFont(fuente);
/* 6103 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 82, 61);
/* 6104 */           this.g2.drawRoundRect(34, 49, 237, 147, 10, 10);
/* 6105 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisOriginal.png"));
/* 6106 */           img = imagen.getImage();
/* 6107 */           this.g2.drawImage(img, 37, 52, 36, 38, null);
/*      */           
/* 6109 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png"));
/* 6110 */           img = imagen.getImage();
/* 6111 */           this.g2.drawImage(img, 78, 65, 177, 19, null);
/*      */           
/* 6113 */           tmpIcon = new ImageIcon(EmpleadosAgregar.this.CONFIG[0] + "/" + EmpleadosAgregar.this.CONFIG[0] + ".png");
/* 6114 */           img = tmpIcon.getImage();
/* 6115 */           this.g2.drawImage(img, 39, 94, 56, 78, null);
/*      */           
/* 6117 */           this.g2.setColor(Color.BLACK);
/* 6118 */           this.g2.drawRect(38, 93, 58, 80);
/*      */           
/* 6120 */           fuente = new Font("Dialog", 0, 6);
/* 6121 */           this.g2.setFont(fuente);
/* 6122 */           this.g2.drawString("ACREDITA  A:", 155, 95);
/* 6123 */           this.g2.drawString("DE HABER TENIDO EL:", 150, 120);
/*      */           
/* 6125 */           this.g2.setColor(Color.BLUE);
/* 6126 */           fuente = new Font("Dialog", 1, 7);
/* 6127 */           this.g2.setFont(fuente);
/* 6128 */           this.g2.drawString(EmpleadosAgregar.this.jLabel113.getText(), 125, 105);
/* 6129 */           fuente = new Font("Dialog", 1, 8);
/* 6130 */           this.g2.setFont(fuente);
/* 6131 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 114, 130);
/* 6132 */           this.g2.drawString("____________________________", 114, 131);
/*      */           
/* 6134 */           fuente = new Font("Dialog", 1, 5);
/* 6135 */           this.g2.setFont(fuente);
/* 6136 */           this.g2.setColor(Color.BLACK);
/* 6137 */           this.g2.drawString("POR EL AGENTE CAPACITADOR:", 140, 138);
/* 6138 */           this.g2.drawString(EmpleadosAgregar.this.CONFIG[3], 135, 145);
/* 6139 */           this.g2.drawString(EmpleadosAgregar.this.CONFIG[2], 150, 152);
/*      */           
/* 6141 */           this.g2.drawString("Certificado por:", 160, 163);
/* 6142 */           this.g2.drawString("SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL", 114, 170);
/*      */           
/* 6144 */           fuente = new Font("Dialog", 0, 6);
/* 6145 */           this.g2.setFont(fuente);
/* 6146 */           this.g2.drawString("|Carretera México - Tuxpan Km. 8.5|Ejido Lázaro Cárdenas|", 70, 183);
/* 6147 */           this.g2.drawString("|Tihuatlán, Veracruz|México|C.P. 92901|(01 782)-825-6455 al 58|", 64, 192);
/*      */ 
/*      */           
/* 6150 */           this.g2.setColor(Color.BLUE);
/* 6151 */           this.g2.drawRoundRect(284, 49, 237, 147, 10, 10);
/* 6152 */           fuente = new Font("Dialog", 1, 8);
/* 6153 */           this.g2.setFont(fuente);
/* 6154 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 340, 61);
/* 6155 */           this.g2.drawString("____________________________", 340, 62);
/*      */           
/* 6157 */           this.g2.setColor(Color.BLACK);
/* 6158 */           fuente = new Font("Dialog", 0, 6);
/* 6159 */           this.g2.setFont(fuente);
/* 6160 */           this.g2.drawString("NOMBRE DEL EMPLEADO:", 290, 80);
/* 6161 */           this.g2.drawString("CURP:", 290, 95);
/* 6162 */           this.g2.drawString("IMSS:", 290, 110);
/* 6163 */           this.g2.drawString("VIGENCIA:", 290, 125);
/*      */           
/* 6165 */           this.g2.setColor(Color.BLUE);
/* 6166 */           fuente = new Font("Dialog", 1, 7);
/* 6167 */           this.g2.setFont(fuente);
/* 6168 */           this.g2.drawString(EmpleadosAgregar.this.jLabel113.getText().toUpperCase(), 370, 80);
/* 6169 */           this.g2.drawString(EmpleadosAgregar.this.jLabel129.getText().toUpperCase(), 370, 95);
/* 6170 */           this.g2.drawString(EmpleadosAgregar.this.jLabel134.getText().toUpperCase(), 370, 110);
/* 6171 */           this.g2.drawString(EmpleadosAgregar.this.jLabel136.getText().toUpperCase(), 370, 125);
/*      */           
/* 6173 */           this.g2.setColor(Color.BLACK);
/* 6174 */           this.g2.drawString("DE ACUERDO A LOS LINEAMIENTOS DE:", 333, 147);
/* 6175 */           this.g2.drawString("'INTERNATIONAL ASSOCIATION OF DRILLING CONTRACTORS'", 296, 157);
/*      */           
/* 6177 */           fuente = new Font("Dialog", 1, 5);
/* 6178 */           this.g2.setFont(fuente);
/* 6179 */           this.g2.drawString("Firma:______________________", 290, 188);
/*      */           
/* 6181 */           fuente = new Font("Dialog", 1, 8);
/* 6182 */           this.g2.setFont(fuente);
/* 6183 */           this.g2.drawString("F" + EmpleadosAgregar.this.CONFIG[1] + "-", 470, 190);
/*      */           
/* 6185 */           this.g2.setColor(Color.BLUE);
/* 6186 */           this.g2.drawString(EmpleadosAgregar.this.jLabel135.getText().toUpperCase(), 490, 190);
/*      */           
/* 6188 */           return 0;
/*      */       } 
/* 6190 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6195 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6196 */       job.setPrintable(this);
/*      */       
/* 6198 */       PageFormat pf = job.defaultPage();
/* 6199 */       Paper papel = pf.getPaper();
/* 6200 */       papel.setSize(612.0D, 792.0D);
/* 6201 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6202 */       pf.setPaper(papel);
/* 6203 */       pf.setOrientation(1);
/* 6204 */       ImprimirRigPass im = new ImprimirRigPass();
/* 6205 */       job.setPrintable(im, pf);
/* 6206 */       job.defaultPage(pf);
/*      */       
/* 6208 */       boolean ok = job.printDialog();
/* 6209 */       if (ok)
/*      */         try {
/* 6211 */           job.print();
/* 6212 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirContrato implements Printable { String[] DATOS; int opc; Graphics2D g2; NumerosALetras letras; boolean indeterminado;
/*      */     String INDETERMINADO;
/*      */     String TiempoINDETERMINADO;
/*      */     String diasContrato;
/*      */     
/*      */     public ImprimirContrato() {
/* 6220 */       this.DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 6221 */       this.opc = 0;
/* 6222 */       this.g2 = null;
/* 6223 */       this.letras = null;
/* 6224 */       this.indeterminado = false;
/* 6225 */       this.INDETERMINADO = "Determinada";
/* 6226 */       this.TiempoINDETERMINADO = "";
/* 6227 */       this.diasContrato = "";
/*      */     }
/*      */     public void titulo() {
/* 6230 */       Font fuente = new Font("Dialog", 1, 13);
/* 6231 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void subtitulo() {
/* 6235 */       Font fuente = new Font("Dialog", 1, 11);
/* 6236 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void contenido() {
/* 6240 */       Font fuente = new Font("Dialog", 0, 10);
/* 6241 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public String dameMes(String mes) {
/* 6245 */       String mesLetra = "";
/* 6246 */       if (mes.equals("01")) {
/* 6247 */         mesLetra = "Enero";
/* 6248 */       } else if (mes.equals("02")) {
/* 6249 */         mesLetra = "Febrero";
/* 6250 */       } else if (mes.equals("03")) {
/* 6251 */         mesLetra = "Marzo";
/* 6252 */       } else if (mes.equals("04")) {
/* 6253 */         mesLetra = "Abril";
/* 6254 */       } else if (mes.equals("05")) {
/* 6255 */         mesLetra = "Mayo";
/* 6256 */       } else if (mes.equals("06")) {
/* 6257 */         mesLetra = "Junio";
/* 6258 */       } else if (mes.equals("07")) {
/* 6259 */         mesLetra = "Julio";
/* 6260 */       } else if (mes.equals("08")) {
/* 6261 */         mesLetra = "Agosto";
/* 6262 */       } else if (mes.equals("09")) {
/* 6263 */         mesLetra = "Septiembre";
/* 6264 */       } else if (mes.equals("10")) {
/* 6265 */         mesLetra = "Octubre";
/* 6266 */       } else if (mes.equals("11")) {
/* 6267 */         mesLetra = "Noviembre";
/* 6268 */       } else if (mes.equals("12")) {
/* 6269 */         mesLetra = "Diciembre";
/*      */       } 
/* 6271 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { SimpleDateFormat formato; String cadenaFecha1, año1, año2; int años; String año, mes, dia, mesLetra; Calendar hoy; String añoTermina, mesTermina, diaTermina, otroMes; Font fuente; int linea; String nombres[], texto; int contarL; String[] Lineas;
/*      */       boolean entra;
/*      */       int esp;
/*      */       String letraTexto;
/* 6275 */       this.g2 = (Graphics2D)g;
/* 6276 */       f.setOrientation(1);
/*      */       
/* 6278 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 6284 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6285 */           cadenaFecha1 = formato.format(EmpleadosAgregar.this.jDateChooser1.getDate());
/* 6286 */           año1 = cadenaFecha1.substring(0, 4);
/*      */           
/* 6288 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6289 */           cadenaFecha1 = formato.format(new Date());
/* 6290 */           año2 = cadenaFecha1.substring(0, 4);
/* 6291 */           años = Integer.parseInt(año2) - Integer.parseInt(año1);
/*      */           
/* 6293 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6294 */           cadenaFecha1 = formato.format(EmpleadosAgregar.this.jDateChooser4.getDate());
/* 6295 */           año = cadenaFecha1.substring(0, 4);
/* 6296 */           mes = cadenaFecha1.substring(4, 6);
/* 6297 */           dia = cadenaFecha1.substring(6, 8);
/* 6298 */           mesLetra = dameMes(mes);
/*      */ 
/*      */           
/* 6301 */           hoy = Calendar.getInstance();
/* 6302 */           hoy.setTime(EmpleadosAgregar.this.jDateChooser4.getDate());
/* 6303 */           hoy.add(5, Integer.parseInt(String.valueOf(EmpleadosAgregar.this.jSpinner1.getValue())));
/*      */           
/* 6305 */           cadenaFecha1 = formato.format(hoy.getTime());
/* 6306 */           añoTermina = cadenaFecha1.substring(0, 4);
/* 6307 */           mesTermina = cadenaFecha1.substring(4, 6);
/* 6308 */           diaTermina = cadenaFecha1.substring(6, 8);
/*      */           
/* 6310 */           otroMes = dameMes(mesTermina);
/*      */ 
/*      */           
/* 6313 */           System.out.println("Val " + String.valueOf(EmpleadosAgregar.this.jSpinner1.getValue()));
/* 6314 */           if (EmpleadosAgregar.this.jSpinner1.getValue().toString().equals("9999")) {
/* 6315 */             this.indeterminado = true;
/* 6316 */             this.INDETERMINADO = "INDETERMINADA";
/* 6317 */             this.TiempoINDETERMINADO = "";
/* 6318 */             this.diasContrato = "Obra Indeterminada";
/*      */           } else {
/* 6320 */             this.TiempoINDETERMINADO = " y concluirá el día  " + diaTermina + " de " + otroMes + " de " + añoTermina + " ";
/* 6321 */             this.diasContrato = EmpleadosAgregar.this.jSpinner1.getValue().toString() + " días ";
/*      */           } 
/*      */           
/* 6324 */           fuente = new Font("Dialog", 1, 13);
/* 6325 */           this.g2.setFont(fuente);
/* 6326 */           titulo();
/* 6327 */           this.g2.drawString("                    CONTRATO INDIVIDUAL DE TRABAJO POR OBRA DETERMINADA", 15, 50);
/* 6328 */           subtitulo();
/* 6329 */           this.g2.drawString("A. PARTES CONTRATANTES:", 15, 90);
/* 6330 */           contenido();
/* 6331 */           this.g2.drawString("Como Patrón, la Empresa: FLETES Y MATERIALES FORSIS S.A. DE C.V.", 15, 120);
/* 6332 */           this.g2.drawString("Como Trabajador: " + EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField3.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField1.getText().toUpperCase(), 15, 133);
/* 6333 */           subtitulo();
/* 6334 */           this.g2.drawString("B. DECLARACIONES:", 15, 163);
/* 6335 */           contenido();
/* 6336 */           this.g2.drawString("I.-Declara la Empresa:", 15, 193);
/* 6337 */           this.g2.drawString("    a) Que es una Sociedad Mercantil Mexicana, constituída conforme a las leyes del país.", 15, 206);
/* 6338 */           this.g2.drawString("    b) Tener su domicilio social en la Autopista  Monterrey-Cadereyta  kilometro 32.5, Cadereyta Jiménez, N.L. ", 15, 219);
/* 6339 */           this.g2.drawString("    c) Estar dedicada conforme a su objeto social a: Servicio de Autotransporte de carga Federal", 15, 232);
/*      */           
/* 6341 */           this.g2.drawString("II.-Declara el Trabajador:", 15, 245);
/* 6342 */           this.g2.drawString("    a) Que es de nacionalidad  Mexicana, tener " + años + " años de edad, estado civil " + String.valueOf(EmpleadosAgregar.this.jComboBox7.getSelectedItem()) + ", con domicilio actual:", 15, 257);
/* 6343 */           fuente = new Font("Dialog", 0, 9);
/* 6344 */           this.g2.setFont(fuente);
/* 6345 */           this.g2.drawString("         " + EmpleadosAgregar.this.jTextField4.getText() + " " + EmpleadosAgregar.this.jTextField5.getText() + " " + EmpleadosAgregar.this.jTextField6.getText() + " " + EmpleadosAgregar.this.jTextField7.getText() + " " + EmpleadosAgregar.this.jTextField8.getText(), 15, 270);
/* 6346 */           contenido();
/* 6347 */           this.g2.drawString("    b) Que tiene los conocimientos y experiencia necesaria para prestar sus servicios a la Empresa, en la categoría de:", 15, 283);
/* 6348 */           this.g2.drawString("         " + String.valueOf(EmpleadosAgregar.this.jComboBox1.getSelectedItem()), 15, 296);
/* 6349 */           this.g2.drawString("III.-La Empresa y el Trabajador: ", 15, 309);
/*      */           
/* 6351 */           this.g2.drawString("    Están conformes en celebrar este Contrato por Obra " + this.INDETERMINADO + " de acuerdo a las condiciones que en él se pactan,", 15, 322);
/* 6352 */           this.g2.drawString("    a partir de ésta fecha " + dia + " de " + mesLetra + " de " + año + " " + this.TiempoINDETERMINADO + " , lapso aproximado en el cual", 15, 335);
/* 6353 */           this.g2.drawString("    se considera que termine el trabajador la obra determinada para que se le contrata. En esta fecha se dará por consiguiente", 15, 348);
/* 6354 */           this.g2.drawString("    terminado el presente contrato sin responsabilidad para las partes en los términos de los artículos 36 y 37, ", 15, 361);
/* 6355 */           this.g2.drawString("    fracción I y III de la Ley Federal del Trabajo en vigor.", 15, 374);
/* 6356 */           subtitulo();
/* 6357 */           this.g2.drawString("C. CONDICIONES DE TRABAJO:", 15, 404);
/* 6358 */           contenido();
/* 6359 */           this.g2.drawString("PRIMERA: El trabajador queda obligado a desempeñar las labores que corresponden al puesto de: " + String.valueOf(EmpleadosAgregar.this.jComboBox1.getSelectedItem()), 15, 434);
/* 6360 */           this.g2.drawString("cuyas labores consisten primordialmente en:", 15, 447);
/*      */           
/* 6362 */           linea = 460;
/* 6363 */           nombres = null;
/* 6364 */           texto = EmpleadosAgregar.this.ACTIVIDADES;
/* 6365 */           contarL = 0;
/* 6366 */           Lineas = new String[] { "", "", "", "", "", "", "", "", "", "", "", "" };
/* 6367 */           entra = false;
/* 6368 */           esp = 0;
/* 6369 */           if (texto.length() > 110) {
/* 6370 */             entra = true; int j;
/* 6371 */             for (j = 0; j < texto.length(); j++) {
/* 6372 */               if (texto.charAt(j) == ' ') {
/* 6373 */                 esp++;
/*      */               }
/*      */             } 
/* 6376 */             nombres = new String[esp + 1];
/* 6377 */             for (j = 0; j <= esp; j++) {
/* 6378 */               nombres[j] = "";
/*      */             }
/* 6380 */             esp = 0;
/*      */             
/* 6382 */             for (j = 0; j < texto.length(); j++) {
/* 6383 */               if (texto.charAt(j) == ' ') {
/* 6384 */                 esp++;
/*      */               } else {
/* 6386 */                 nombres[esp] = nombres[esp] + nombres[esp];
/*      */               } 
/*      */             } 
/* 6389 */             esp = 0;
/*      */             
/* 6391 */             for (j = 0; j < nombres.length; j++) {
/* 6392 */               contarL = Lineas[esp].length();
/* 6393 */               if (contarL < 110) {
/* 6394 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/*      */               } else {
/* 6396 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/* 6397 */                 esp++;
/*      */               } 
/*      */             } 
/* 6400 */             for (j = 0; j <= esp; j++) {
/* 6401 */               this.g2.drawString(Lineas[j].toLowerCase(), 15, linea);
/* 6402 */               linea += 13;
/*      */             } 
/*      */           } else {
/* 6405 */             this.g2.drawString(texto.toLowerCase(), 15, linea);
/* 6406 */             linea += 13;
/*      */           } 
/* 6408 */           this.g2.drawString("Toda vez que la enumeración de las labores anteriores es enunciativa, quedando por tanto obligado el trabajador a ejecutar", 15, linea);
/* 6409 */           this.g2.drawString("cualquier trabajo anexo o conexo con su labor principal, en el lugar que por la naturaleza de sus funciones le asigne la Empresa.", 15, linea + 13);
/*      */           
/* 6411 */           this.g2.drawString("SEGUNDA: La duración de la relación de trabajo será de " + this.diasContrato + ", tiempo que considera suficiente LA EMPRESA", 15, linea + 39);
/* 6412 */           linea += 52;
/* 6413 */           nombres = null;
/* 6414 */           texto = "para que concluya " + EmpleadosAgregar.this.ACTIVIDADES;
/* 6415 */           contarL = 0;
/* 6416 */           Lineas = new String[] { "", "", "", "", "", "", "", "", "", "", "", "" };
/* 6417 */           entra = false;
/* 6418 */           esp = 0;
/* 6419 */           if (texto.length() > 110) {
/* 6420 */             entra = true; int j;
/* 6421 */             for (j = 0; j < texto.length(); j++) {
/* 6422 */               if (texto.charAt(j) == ' ') {
/* 6423 */                 esp++;
/*      */               }
/*      */             } 
/* 6426 */             nombres = new String[esp + 1];
/* 6427 */             for (j = 0; j <= esp; j++) {
/* 6428 */               nombres[j] = "";
/*      */             }
/* 6430 */             esp = 0;
/*      */             
/* 6432 */             for (j = 0; j < texto.length(); j++) {
/* 6433 */               if (texto.charAt(j) == ' ') {
/* 6434 */                 esp++;
/*      */               } else {
/* 6436 */                 nombres[esp] = nombres[esp] + nombres[esp];
/*      */               } 
/*      */             } 
/* 6439 */             esp = 0;
/*      */             
/* 6441 */             for (j = 0; j < nombres.length; j++) {
/* 6442 */               contarL = Lineas[esp].length();
/* 6443 */               if (contarL < 110) {
/* 6444 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/*      */               } else {
/* 6446 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/* 6447 */                 esp++;
/*      */               } 
/*      */             } 
/* 6450 */             for (j = 0; j <= esp; j++) {
/* 6451 */               this.g2.drawString(Lineas[j].toLowerCase(), 15, linea);
/* 6452 */               linea += 13;
/*      */             } 
/*      */           } else {
/* 6455 */             this.g2.drawString(texto.toLowerCase(), 15, linea);
/* 6456 */             linea += 13;
/*      */           } 
/*      */           
/* 6459 */           this.g2.drawString("TERCERA: Por los servicios que preste EL TRABAJADOR a LA EMPRESA durante la relación de trabajo existente entre ambos,", 15, linea + 13);
/* 6460 */           this.letras = new NumerosALetras(Double.parseDouble(String.valueOf(EmpleadosAgregar.this.jFormattedTextField7.getValue())), "MXN");
/* 6461 */           letraTexto = this.letras.regresaNumero();
/* 6462 */           this.g2.drawString("percibirá un salario nominal de " + EmpleadosAgregar.this.jFormattedTextField7.getText() + " (" + letraTexto + "), misma que le será pagada al", 15, linea + 26);
/* 6463 */           this.g2.drawString("trabajador directamente por LA EMPRESA, en moneda del curso legal, en el lugar en donde preste sus servicios, durante las", 15, linea + 39);
/* 6464 */           this.g2.drawString("horas de trabajo.", 15, linea + 52);
/*      */           
/* 6466 */           this.g2.drawString("CUARTA: El pago de salario se verificará en forma, el último día hábil de cada semana laboral vencida.", 15, linea + 78);
/*      */           
/* 6468 */           this.g2.drawString("QUINTA: Atendiendo la naturaleza de la actividad contratada se establece la posibilidad de que la jornada laboral administre, con", 15, linea + 104);
/* 6469 */           this.g2.drawString("arreglos a los usos y costumbres que se suscitan en la práctica, disfrutando el trabajador de tiempo suficiente para tomar sus", 15, linea + 117);
/* 6470 */           this.g2.drawString("alimentos y descansar, en la forma prevista por la ley de la materia.", 15, linea + 130);
/* 6471 */           this.g2.drawString("_______________________________________________________________________________________________________", 15, 750);
/* 6472 */           fuente = new Font("Dialog", 1, 7);
/* 6473 */           this.g2.setFont(fuente);
/* 6474 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.                                                                                                                                                                                                        Página 1/2", 15, 763);
/* 6475 */           this.g2.drawString(EmpleadosAgregar.this.NOMBRECOMPLETO, 15, 774);
/* 6476 */           this.g2.drawString(EmpleadosAgregar.this.cargarFechaHoy(), 549, 774);
/* 6477 */           return 0;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 1:
/* 6483 */           contenido();
/* 6484 */           this.g2.drawString("SEXTA: En virtud  de que no es factible establecer un control de asistencias o puntualidad mediante tarjetas o listas de nómina,", 15, 90);
/* 6485 */           this.g2.drawString("no existe una determinación legal para laborar tiempo extra.", 15, 103);
/*      */           
/* 6487 */           this.g2.drawString("SEPTIMA: Serán días de descanso obligatorio, con goce de salario, cualesquiera de los siguientes días que se cumplan dentro del", 15, 133);
/* 6488 */           this.g2.drawString("término de vigencia de la relación de trabajo: 1o. de Enero, 5 de Febrero, 21 de Marzo, 1o. de Mayo, 16 de Septiembre,", 15, 146);
/* 6489 */           this.g2.drawString("20 de Noviembre, 25 de Diciembre de cada año y el 1o. de Diciembre cuando corresponda a la transmisión del", 15, 159);
/* 6490 */           this.g2.drawString("Poder Ejecutivo Federal.", 15, 172);
/*      */           
/* 6492 */           this.g2.drawString("OCTAVA: Son causas de terminación de la relación de trabajo las siguientes:", 15, 202);
/* 6493 */           this.g2.drawString("    a) La conclusión de la labor extraordinaria a que se refiere la cláusula décima segunda de éste documento, ya que tal labor es", 15, 215);
/* 6494 */           this.g2.drawString("    la causa que motiva y origina la celebración de éste contrato.", 15, 228);
/* 6495 */           this.g2.drawString("    b) El hecho que durante los primeros 30 días de prestación de servicio, la Empresa se percate que el trabajador carece de", 15, 241);
/* 6496 */           this.g2.drawString("    los conocimientos, experiencia y capacidad que ha manifestado tener para el trabajo que se le encomienda.", 15, 254);
/* 6497 */           this.g2.drawString("    c) Por rescisión de este contrato, por incumplimiento que cualesquiera de las partes dé al mismo en los términos y por las", 15, 267);
/* 6498 */           this.g2.drawString("    causas previstas en los artículos 46, 47 y 51 de la Ley Federal del Trabajo.", 15, 280);
/*      */           
/* 6500 */           this.g2.drawString("NOVENA: El Trabajador a la terminación de su contrato eventual será cubierto por la Empresa en forma proporcional de acuerdo", 15, 310);
/* 6501 */           this.g2.drawString("con el número de días trabajados, de los siguientes conceptos:", 15, 323);
/* 6502 */           this.g2.drawString("a) 6 días de vacaciones por 12 meses de servicios;", 15, 336);
/* 6503 */           this.g2.drawString("b) 15 días de salario por 12 meses de servicios por aguinaldo anual.", 15, 349);
/*      */           
/* 6505 */           this.g2.drawString("DECIMA: El Trabajador será capacitado o adiestrado en los términos de los planes y programas establecidos o que se establezcan", 15, 379);
/* 6506 */           this.g2.drawString("en la Empresa.", 15, 392);
/*      */           
/* 6508 */           this.g2.drawString("      a) DECIMA PRIMERA:  El trabajador deberá cumplir con las obligaciones y condiciones de trabajo establecidas en la empresa.", 15, 422);
/*      */           
/* 6510 */           this.g2.drawString("      b) DECIMA SEGUNDA: La obra determinada para la cual es contratado el trabajador consiste en: ", 15, 452);
/* 6511 */           linea = 465;
/* 6512 */           nombres = null;
/* 6513 */           texto = EmpleadosAgregar.this.ACTIVIDADES;
/* 6514 */           contarL = 0;
/* 6515 */           Lineas = new String[] { "", "", "", "", "", "", "", "", "", "", "", "" };
/* 6516 */           entra = false;
/* 6517 */           esp = 0;
/* 6518 */           if (texto.length() > 110) {
/* 6519 */             entra = true; int j;
/* 6520 */             for (j = 0; j < texto.length(); j++) {
/* 6521 */               if (texto.charAt(j) == ' ') {
/* 6522 */                 esp++;
/*      */               }
/*      */             } 
/* 6525 */             nombres = new String[esp + 1];
/* 6526 */             for (j = 0; j <= esp; j++) {
/* 6527 */               nombres[j] = "";
/*      */             }
/* 6529 */             esp = 0;
/* 6530 */             for (j = 0; j < texto.length(); j++) {
/* 6531 */               if (texto.charAt(j) == ' ') {
/* 6532 */                 esp++;
/*      */               } else {
/* 6534 */                 nombres[esp] = nombres[esp] + nombres[esp];
/*      */               } 
/*      */             } 
/* 6537 */             esp = 0;
/* 6538 */             for (j = 0; j < nombres.length; j++) {
/* 6539 */               contarL = Lineas[esp].length();
/* 6540 */               if (contarL < 110) {
/* 6541 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/*      */               } else {
/* 6543 */                 Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/* 6544 */                 esp++;
/*      */               } 
/*      */             } 
/* 6547 */             for (j = 0; j <= esp; j++) {
/* 6548 */               this.g2.drawString(Lineas[j].toLowerCase(), 15, linea);
/* 6549 */               linea += 13;
/*      */             } 
/*      */           } else {
/* 6552 */             this.g2.drawString(texto.toLowerCase(), 15, linea);
/* 6553 */             linea += 13;
/*      */           } 
/*      */           
/* 6556 */           titulo();
/* 6557 */           this.g2.drawString("CONFORMES", 260, 540);
/* 6558 */           contenido();
/* 6559 */           this.g2.drawString("EL PATRÓN", 100, 580);
/* 6560 */           this.g2.drawString("EL TRABAJADOR", 410, 580);
/* 6561 */           subtitulo();
/* 6562 */           this.g2.drawString(EmpleadosAgregar.this.jTextField25.getText().toUpperCase(), 50, 630);
/* 6563 */           this.g2.drawString(EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField2.getText().toUpperCase() + " " + EmpleadosAgregar.this.jTextField3.getText().toUpperCase(), 360, 630);
/* 6564 */           contenido();
/* 6565 */           this.g2.drawString("TESTIGO", 280, 670);
/* 6566 */           subtitulo();
/* 6567 */           this.g2.drawString(EmpleadosAgregar.this.jTextField29.getText().toUpperCase(), 215, 720);
/* 6568 */           contenido();
/* 6569 */           this.g2.drawString("_______________________________________________________________________________________________________", 15, 750);
/* 6570 */           fuente = new Font("Dialog", 1, 7);
/* 6571 */           this.g2.setFont(fuente);
/* 6572 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.                                                                                                                                                                                                        Página 2/2", 15, 763);
/* 6573 */           this.g2.drawString(EmpleadosAgregar.this.NOMBRECOMPLETO, 15, 774);
/* 6574 */           this.g2.drawString(EmpleadosAgregar.this.cargarFechaHoy(), 549, 774);
/* 6575 */           return 0;
/*      */       } 
/* 6577 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6582 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6583 */       job.setPrintable(this);
/*      */       
/* 6585 */       PageFormat pf = job.defaultPage();
/* 6586 */       Paper papel = pf.getPaper();
/* 6587 */       papel.setSize(612.0D, 792.0D);
/* 6588 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6589 */       pf.setPaper(papel);
/* 6590 */       pf.setOrientation(1);
/* 6591 */       ImprimirContrato im = new ImprimirContrato();
/* 6592 */       job.setPrintable(im, pf);
/* 6593 */       job.defaultPage(pf);
/*      */       
/* 6595 */       boolean ok = job.printDialog();
/* 6596 */       if (ok)
/*      */         try {
/* 6598 */           job.print();
/* 6599 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/EmpleadosAgregar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */