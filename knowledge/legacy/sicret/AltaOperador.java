/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import principal.MaterialButton;
/*      */ import utilerias.Tras_codigos;
/*      */ 
/*      */ public class AltaOperador extends JPanel {
/*   56 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   57 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   58 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   59 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   60 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   64 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   65 */   Date fechaActual = new Date();
/*   66 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*   68 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   70 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   71 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   74 */   Consultas con = new Consultas();
/*   75 */   Consultas2 con2 = new Consultas2();
/*      */   String[] inf;
/*   77 */   cargarDatos datos = new cargarDatos("OperadorAgregar");
/*      */   Color fondo;
/*      */   JTable jTable3;
/*      */   boolean encontrado = false;
/*   81 */   int INDICE = 0;
/*   82 */   Errores error = new Errores(false);
/*   83 */   Validaciones val = new Validaciones();
/*   84 */   Date fecha = null;
/*   85 */   Date fechaInicio = null;
/*   86 */   String FOTO = "";
/*   87 */   String NOMBRECOMPLETO = "";
/*   88 */   String VIGENCIA = "";
/*   89 */   String CLAVEOP = "";
/*   90 */   fotoCredencial fotoC = null;
/*   91 */   fotoIndividual ind = null;
/*   92 */   String[] CONFIG = null;
/*   93 */   MensajePop mensajeTry = null;
/*   94 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   95 */   SColores lc = new SColores();
/*   96 */   Fuentes fuentes = new Fuentes();
/*   97 */   int clicPanel = 0;
/*   98 */   int xx = 0;
/*   99 */   int xy = 0;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*  102 */   List<Tras_codigos> CODIGOSP = new ArrayList<>();
/*  103 */   ArrayList LISTACODIGOS = new ArrayList();
/*  104 */   ArrayList LISTAESTADOS = new ArrayList();
/*  105 */   ArrayList LISTACOLONIAS = new ArrayList();
/*  106 */   ArrayList LISTACIUDADES = new ArrayList();
/*      */   
/*  108 */   TextAutoCompleter com_ListaCodigos = null;
/*  109 */   TextAutoCompleter com_ListaEstados = null;
/*  110 */   TextAutoCompleter com_ListaColonias = null;
/*  111 */   TextAutoCompleter com_ListaCiudades = null;
/*      */   
/*  113 */   Utilerias utilerias = new Utilerias();
/*      */   
/*  115 */   Map<String, String> CLAVECATALOGO = new TreeMap<>(); private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton39; private JButton jButton40; private JButton jButton41; private JButton jButton7; private JButton jButton9; private JComboBox jComboBox10; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDialog jDialog1; private JDialog jDialog3; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel57; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63;
/*      */   private JLabel jLabel64;
/*      */   private JLabel jLabel65;
/*      */   private JLabel jLabel66;
/*      */   
/*      */   public AltaOperador(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*  121 */     this.mensajeTry = mensajeTry;
/*  122 */     this.USUARIO = usua;
/*  123 */     this.padre = padre;
/*  124 */     this.fichas = fichas;
/*  125 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  126 */     this.LISTACODIGOS = LISTACODIGOS;
/*  127 */     this.CODIGOSP = CODIGOSP;
/*  128 */     this.id = num;
/*  129 */     this.jTable3 = Tabla;
/*  130 */     this.con2.setBaseDatos("sicre2PR");
/*      */     try {
/*  132 */       this.formaTel = new MaskFormatter("###-###-####");
/*  133 */       this.formaTel2 = new MaskFormatter("###-###-####");
/*  134 */     } catch (Exception exception) {}
/*      */     
/*  136 */     this.formaTel.setPlaceholderCharacter('_');
/*  137 */     this.formaTel2.setPlaceholderCharacter('_');
/*      */     
/*  139 */     int aa = this.fechaActual.getYear() + 1911;
/*  140 */     int mm = this.fechaActual.getMonth();
/*  141 */     int dd = this.fechaActual.getDay();
/*      */     
/*  143 */     String año = "" + aa;
/*  144 */     String mes = "" + mm;
/*  145 */     String dia = "" + dd;
/*      */     
/*  147 */     String año1 = "1990";
/*  148 */     String mes1 = "01";
/*  149 */     String dia1 = "01";
/*  150 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  151 */     String strFecha = año1 + "-" + año1 + "-" + mes1;
/*      */     try {
/*  153 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  154 */     } catch (ParseException ex) {
/*  155 */       ex.printStackTrace();
/*      */     } 
/*  157 */     strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/*  159 */       this.fecha = formatoDelTexto.parse(strFecha);
/*  160 */     } catch (ParseException ex) {
/*  161 */       ex.printStackTrace();
/*      */     } 
/*  163 */     initComponents();
/*  164 */     limpiar();
/*  165 */     this.materialButton21.setVisible(false);
/*  166 */     crearInd();
/*      */     
/*  168 */     panelito.setViewportView(this);
/*  169 */     this.panel = panelito;
/*  170 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  171 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  172 */     this.jLabel86.setCursor(micursor);
/*  173 */     this.jLabel117.setCursor(micursor);
/*  174 */     this.jLabel81.setCursor(micursor);
/*  175 */     this.jLabel131.setCursor(micursor);
/*  176 */     this.jLabel136.setCursor(micursor);
/*      */     
/*  178 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  179 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  180 */     this.jDialog1.setCursor(micursor);
/*  181 */     this.jDialog5.setCursor(micursor);
/*  182 */     this.jDialog6.setCursor(micursor);
/*  183 */     this.jDialog7.setCursor(micursor);
/*      */     
/*  185 */     colorear();
/*  186 */     this.jLabel9.setVisible(false);
/*      */     
/*  188 */     int w = this.tama.width;
/*  189 */     int h = this.tama.height;
/*  190 */     int rw = (w - 360) / 2;
/*  191 */     int rh = (h - 245) / 2;
/*  192 */     this.jDialog1.setLocation(rw, rh);
/*  193 */     this.jDialog1.setSize(360, 245);
/*  194 */     this.jDialog1.setVisible(false);
/*  195 */     this.jDialog1.setResizable(false);
/*      */     
/*  197 */     rw = (w - 250) / 2;
/*  198 */     rh = (h - 365) / 2;
/*  199 */     this.jDialog3.setLocation(rw, rh);
/*  200 */     this.jDialog3.setSize(250, 365);
/*  201 */     this.jDialog3.setVisible(false);
/*  202 */     this.jDialog3.setResizable(false);
/*      */     
/*  204 */     rw = (w - 378) / 2;
/*  205 */     rh = (h - 225) / 2;
/*  206 */     this.jDialog5.setLocation(rw, rh);
/*  207 */     this.jDialog5.setSize(378, 225);
/*  208 */     this.jDialog5.setVisible(false);
/*  209 */     this.jDialog5.setResizable(false);
/*      */     
/*  211 */     rw = (w - 443) / 2;
/*  212 */     rh = (h - 615) / 2;
/*  213 */     this.jDialog6.setLocation(rw, rh);
/*  214 */     this.jDialog6.setSize(443, 640);
/*  215 */     this.jDialog6.setVisible(false);
/*  216 */     this.jDialog6.setResizable(false);
/*      */     
/*  218 */     rw = (w - 475) / 2;
/*  219 */     rh = (h - 690) / 2;
/*  220 */     this.jDialog7.setLocation(rw, rh);
/*  221 */     this.jDialog7.setSize(475, 690);
/*  222 */     this.jDialog7.setVisible(false);
/*  223 */     this.jDialog7.setResizable(false);
/*      */     
/*  225 */     rw = (w - 765) / 2;
/*  226 */     rh = (h - 550) / 2;
/*  227 */     this.jDialog9.setLocation(rw, rh);
/*  228 */     this.jDialog9.setSize(765, 550);
/*  229 */     this.jDialog9.setVisible(false);
/*  230 */     this.jDialog9.setResizable(false);
/*      */     
/*  232 */     this.buttonGroup3.add(this.jRadioButton5);
/*  233 */     this.buttonGroup3.add(this.jRadioButton6);
/*      */     
/*  235 */     this.buttonGroup4.add(this.jRadioButton7);
/*  236 */     this.buttonGroup4.add(this.jRadioButton8);
/*      */     
/*  238 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  239 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  240 */     editFormat.setGroupingUsed(false);
/*  241 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  242 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  243 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  244 */     enFormat.setAllowsInvalid(true);
/*  245 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  246 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*  247 */     this.jFormattedTextField7.setFormatterFactory(currFactory);
/*  248 */     this.jFormattedTextField9.setFormatterFactory(currFactory);
/*  249 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  250 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*  251 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/*  252 */     this.jFormattedTextField9.setValue(Integer.valueOf(0));
/*      */     
/*  254 */     String[] datos = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where clave_emp=num_emp and nombre_usu = '" + this.USUARIO + "'", 3);
/*  255 */     this.NOMBRECOMPLETO = datos[1] + " " + datos[1] + " " + datos[2];
/*      */     
/*  257 */     this.buttonGroup1.add(this.jRadioButton1);
/*  258 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  260 */     this.buttonGroup2.add(this.jRadioButton3);
/*  261 */     this.buttonGroup2.add(this.jRadioButton4);
/*  262 */     if (fichas != null) {
/*  263 */       this.materialButton20.setVisible(true);
/*  264 */       this.jLabel9.setVisible(true);
/*  265 */       cargarFormulario();
/*  266 */       this.jTextField19.setText(num);
/*  267 */       fichas.addTab("Modificar Operadores - [Clave: " + this.id + "]", this.panel);
/*  268 */       this.materialButton1.setText("Modificar");
/*  269 */       this.jLabel57.setText("Modificar Operadores");
/*  270 */       this.materialButton21.setVisible(true);
/*      */       
/*  272 */       this.jTextField20.setEnabled(true);
/*  273 */       this.jTextField21.setEnabled(true);
/*      */     } 
/*  275 */     this.CONFIG = this.con.regresaReg("fotosOperadores,directiva,capacitadorQHSE,nombreCapacitador", "configuraciones", "", 4);
/*  276 */     cargarPerfil();
/*      */ 
/*      */     
/*  279 */     llenarCodigos();
/*      */   }
/*      */   private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel7; private JPanel jPanel75; private JPanel jPanel76; private JPanel jPanel77; private JPanel jPanel78; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel82; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JScrollPane jScrollPane1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JTextArea jTextArea1; private JTextField jTextField1; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField33; private JTextField jTextField35; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private MaterialButton materialButton1; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22;
/*      */   public void pasarInd(int i) {
/*  283 */     this.INDICE = i;
/*      */   }
/*      */   
/*      */   public void crearInd() {
/*  287 */     int id = 0;
/*  288 */     this.con.consultar("count(num_ope)", "operadores", "");
/*  289 */     if (!this.con.Campo.equals("0")) {
/*  290 */       this.con.consultar("max(num_ope)", "operadores", "");
/*  291 */       id = Integer.parseInt(this.con.Campo);
/*  292 */       id++;
/*  293 */       this.jTextField19.setText("" + id);
/*      */     } else {
/*  295 */       id = 1;
/*      */     } 
/*  297 */     this.jTextField19.setText("" + id);
/*      */   }
/*      */   
/*      */   public void colorear() {
/*  301 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  303 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  307 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/*  310 */     this.jComboBox10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  312 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  316 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox10, evt);
/*      */           }
/*      */         });
/*  319 */     this.jTextField41.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  321 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField41, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  325 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField41, evt);
/*      */           }
/*      */         });
/*  328 */     this.jTextField42.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  330 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField42, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  334 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField42, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */     
/*  340 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  342 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  346 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField16, evt);
/*      */           }
/*      */         });
/*  349 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  351 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  355 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField17, evt);
/*      */           }
/*      */         });
/*  358 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  360 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  364 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField18, evt);
/*      */           }
/*      */         });
/*  367 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  369 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  373 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField20, evt);
/*      */           }
/*      */         });
/*  376 */     this.jTextField21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  378 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  382 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField21, evt);
/*      */           }
/*      */         });
/*  385 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  387 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  391 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField22, evt);
/*      */           }
/*      */         });
/*  394 */     this.jTextField23.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  396 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField23, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  400 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField23, evt);
/*      */           }
/*      */         });
/*  403 */     this.jTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  405 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField24, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  409 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField24, evt);
/*      */           }
/*      */         });
/*  412 */     this.jTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  414 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField25, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  418 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField25, evt);
/*      */           }
/*      */         });
/*  421 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  423 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField26, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  427 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField26, evt);
/*      */           }
/*      */         });
/*  430 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  432 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  436 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField27, evt);
/*      */           }
/*      */         });
/*  439 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  441 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField28, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  445 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField28, evt);
/*      */           }
/*      */         });
/*  448 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  450 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  454 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField29, evt);
/*      */           }
/*      */         });
/*  457 */     this.jTextField30.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  459 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField30, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  463 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField30, evt);
/*      */           }
/*      */         });
/*  466 */     this.jTextField33.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  468 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField33, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  472 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField33, evt);
/*      */           }
/*      */         });
/*  475 */     this.jTextField35.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  477 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField35, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  481 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField35, evt);
/*      */           }
/*      */         });
/*  484 */     this.jTextField37.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  486 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField37, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  490 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField37, evt);
/*      */           }
/*      */         });
/*  493 */     this.jTextField38.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  495 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField38, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  499 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField38, evt);
/*      */           }
/*      */         });
/*  502 */     this.jTextField39.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  504 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField39, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  508 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField39, evt);
/*      */           }
/*      */         });
/*  511 */     this.jTextField40.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  513 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField40, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  517 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField40, evt);
/*      */           }
/*      */         });
/*  520 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  522 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  526 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*  529 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  531 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  535 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*  538 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  540 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  544 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox6, evt);
/*      */           }
/*      */         });
/*  547 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  549 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  553 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*  556 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  558 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  562 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*  565 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  567 */             AltaOperador.this.jTextGanado(AltaOperador.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  571 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jComboBox9, evt);
/*      */           }
/*      */         });
/*  574 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  576 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  580 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/*  583 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  585 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  589 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/*  592 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  594 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  598 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/*  601 */     this.jFormattedTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  603 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  607 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField7, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  618 */     this.jFormattedTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  620 */             AltaOperador.this.jTextGanado(AltaOperador.this.jFormattedTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  624 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jFormattedTextField9, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  631 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  633 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  637 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextField15, evt);
/*      */           }
/*      */         });
/*  640 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  642 */             AltaOperador.this.jTextGanado(AltaOperador.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  646 */             AltaOperador.this.jTextPerdido(AltaOperador.this.jTextArea1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  652 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  656 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void operadores(String usua, String num) {
/*  660 */     this.USUARIO = usua;
/*  661 */     this.panel.setViewportView(this);
/*  662 */     this.id = num;
/*  663 */     cargarPerfil();
/*  664 */     limpiar();
/*  665 */     crearInd();
/*  666 */     this.jRadioButton5.setSelected(true);
/*  667 */     this.jRadioButton7.setSelected(true);
/*  668 */     this.CONFIG = this.con.regresaReg("fotosOperadores,directiva,capacitadorQHSE", "configuraciones", "", 3);
/*  669 */     if (this.fichas != null) {
/*  670 */       cargarFormulario();
/*  671 */       this.fichas.addTab("Modificar Operadores - [Num: " + this.id + "]", this.panel);
/*  672 */       this.materialButton1.setText("Modificar");
/*  673 */       this.jLabel57.setText("Modificar Operadores");
/*  674 */       this.materialButton21.setVisible(true);
/*  675 */       this.jTextField19.setText(this.id);
/*      */     } else {
/*  677 */       this.materialButton21.setVisible(false);
/*  678 */       this.jTextField20.setEnabled(false);
/*  679 */       this.jTextField21.setEnabled(false);
/*      */     } 
/*  681 */     cambioAutomatico(0);
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/*  685 */     Date fecha = new Date();
/*  686 */     Calendar ahoraCal = Calendar.getInstance();
/*  687 */     ahoraCal.setTime(fecha);
/*  688 */     String mesesito = "";
/*  689 */     String hoy = "";
/*  690 */     mesesito = "" + ahoraCal.get(2) + 1;
/*  691 */     hoy = "" + ahoraCal.get(5);
/*  692 */     if (ahoraCal.get(2) + 1 < 10) {
/*  693 */       mesesito = "0" + mesesito;
/*      */     }
/*  695 */     if (ahoraCal.get(5) < 10) {
/*  696 */       hoy = "0" + hoy;
/*      */     }
/*  698 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void cargarFormulario() {
/*  702 */     String[] campos = this.con.regresaReg("num_ope,nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,fecha_licen,tipo_licen,Num_licen,nss,rfc,estados.estado,num_tracto,num_rem,ingreso,operadores.tipo,infonavit,numinfo,nextel,diascontrato,etiqueta,estadocivil,hijos,personaContrato,testigo1,testigo2,recomendado,ultimafechaIngreso,salarioIMSS,otrosDatos,lugarNacimiento,cargoInfo,cargoNextel,cantNextel,asignacion,rfcOriginal, c_colonia, c_municipio, operadores.c_estado, c_localidad, localidad, seguroVida, edo", "operadores,estados", "where operadores.id_edo=estados.id_edo and num_ope = " + this.id, 49);
/*  703 */     this.jFormattedTextField1.setValue(Double.valueOf(this.utilerias.convertirCantTexto(campos[47])));
/*  704 */     this.inf = campos;
/*  705 */     this.jTextField4.setText(campos[45]);
/*  706 */     this.jTextField31.setText(campos[46]);
/*  707 */     this.materialButton1.setToolTipText("Modificar ( Alt+M )");
/*  708 */     this.materialButton1.setMnemonic('M');
/*  709 */     this.jTextField42.setText(campos[41]);
/*  710 */     this.jTextField1.setText(campos[42]);
/*  711 */     this.jTextField2.setText(campos[43]);
/*  712 */     this.jTextField3.setText(campos[44]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  719 */     this.jComboBox4.setSelectedItem(campos[48]);
/*      */     
/*  721 */     this.jTextField16.setText(campos[1]);
/*  722 */     this.jTextField17.setText(campos[2]);
/*  723 */     this.jTextField18.setText(campos[3]);
/*  724 */     this.jTextField20.setText(campos[4]);
/*  725 */     this.jTextField21.setText(campos[5]);
/*  726 */     this.jTextField22.setText(campos[6]);
/*  727 */     if (!campos[7].equals("0")) {
/*  728 */       this.jTextField23.setText(campos[7]);
/*      */     } else {
/*  730 */       this.jTextField23.setText("");
/*      */     } 
/*  732 */     this.jTextField24.setText(campos[8]);
/*  733 */     this.jTextField19.setText(campos[0]);
/*      */     
/*  735 */     if (!campos[18].equals("")) {
/*  736 */       this.jTextField30.setText(campos[18]);
/*      */     } else {
/*  738 */       this.jTextField30.setText("");
/*      */     } 
/*  740 */     if (!campos[19].equals("")) {
/*  741 */       this.jTextField35.setText(campos[19]);
/*      */     } else {
/*  743 */       this.jTextField35.setText("");
/*      */     } 
/*  745 */     this.jTextField25.setText(campos[15]);
/*  746 */     this.jTextField26.setText(campos[16]);
/*  747 */     this.jTextField27.setText(campos[14]);
/*  748 */     this.jComboBox5.setSelectedItem(campos[13]);
/*  749 */     this.jTextField19.setEditable(false);
/*  750 */     String año = campos[12].substring(0, 4);
/*  751 */     String mes = campos[12].substring(5, 7);
/*  752 */     String dia = campos[12].substring(8, 10);
/*  753 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  754 */     String strFecha = año + "-" + año + "-" + mes;
/*  755 */     Date fecha = null;
/*      */     try {
/*  757 */       fecha = formatoDelTexto.parse(strFecha);
/*  758 */     } catch (ParseException ex) {
/*  759 */       ex.printStackTrace();
/*      */     } 
/*  761 */     this.jDateChooser7.setDate(fecha);
/*  762 */     this.jFormattedTextField4.setText(campos[9]);
/*  763 */     this.jFormattedTextField5.setText(campos[10]);
/*  764 */     año = campos[11].substring(0, 4);
/*  765 */     mes = campos[11].substring(5, 7);
/*  766 */     dia = campos[11].substring(8, 10);
/*  767 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  768 */     strFecha = año + "-" + año + "-" + mes;
/*  769 */     fecha = null;
/*      */     try {
/*  771 */       fecha = formatoDelTexto.parse(strFecha);
/*  772 */       this.jDateChooser5.setDate(fecha);
/*  773 */     } catch (ParseException ex) {
/*  774 */       ex.printStackTrace();
/*      */     } 
/*  776 */     año = campos[20].substring(0, 4);
/*  777 */     mes = campos[20].substring(5, 7);
/*  778 */     dia = campos[20].substring(8, 10);
/*  779 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  780 */     strFecha = año + "-" + año + "-" + mes;
/*  781 */     fecha = null;
/*      */     try {
/*  783 */       fecha = formatoDelTexto.parse(strFecha);
/*  784 */       this.jDateChooser4.setDate(fecha);
/*  785 */     } catch (ParseException ex) {
/*  786 */       ex.printStackTrace();
/*      */     } 
/*  788 */     this.jTextField33.setText(campos[23]);
/*  789 */     this.jFormattedTextField6.setValue(Float.valueOf(Float.parseFloat(campos[22])));
/*  790 */     if (!campos[21].equals("")) {
/*  791 */       this.jComboBox8.setSelectedItem(campos[21]);
/*      */     } else {
/*  793 */       this.jComboBox8.setSelectedIndex(0);
/*      */     } 
/*  795 */     this.jTextField28.setText(campos[24]);
/*  796 */     this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(campos[25])));
/*  797 */     this.jComboBox7.setSelectedItem(campos[26]);
/*  798 */     this.jComboBox6.setSelectedItem(campos[27]);
/*  799 */     this.jSpinner2.setValue(Integer.valueOf(Integer.parseInt(campos[28])));
/*  800 */     this.jTextField40.setText(campos[29]);
/*  801 */     this.jTextField37.setText(campos[30]);
/*  802 */     this.jTextField38.setText(campos[31]);
/*  803 */     this.jTextField39.setText(campos[32]);
/*      */     
/*  805 */     año = campos[33].substring(0, 4);
/*  806 */     mes = campos[33].substring(5, 7);
/*  807 */     dia = campos[33].substring(8, 10);
/*  808 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  809 */     strFecha = año + "-" + año + "-" + mes;
/*  810 */     fecha = null;
/*      */     try {
/*  812 */       fecha = formatoDelTexto.parse(strFecha);
/*  813 */       this.jDateChooser6.setDate(fecha);
/*  814 */     } catch (ParseException ex) {
/*  815 */       ex.printStackTrace();
/*      */     } 
/*  817 */     this.jFormattedTextField7.setValue(Float.valueOf(Float.parseFloat(campos[34])));
/*      */     
/*  819 */     this.jTextArea1.setText(campos[35]);
/*  820 */     this.jTextField41.setText(campos[36]);
/*      */     
/*  822 */     if (campos[37].equals("No")) {
/*  823 */       this.jRadioButton7.setSelected(true);
/*      */     } else {
/*  825 */       this.jRadioButton8.setSelected(true);
/*      */     } 
/*  827 */     if (campos[38].equals("No")) {
/*  828 */       this.jRadioButton5.setSelected(true);
/*      */     } else {
/*  830 */       this.jRadioButton6.setSelected(true);
/*      */     } 
/*      */     
/*  833 */     String canti = campos[39];
/*  834 */     String valorP = "";
/*  835 */     for (int j = 0; j < canti.length(); j++) {
/*  836 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/*  837 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/*  840 */     double vp = Double.parseDouble(valorP);
/*  841 */     this.jFormattedTextField9.setValue(Double.valueOf(vp));
/*      */     
/*  843 */     this.jComboBox10.setSelectedItem(campos[40]);
/*  844 */     cargarPerfil();
/*      */   }
/*      */   
/*      */   public void llenarCodigos() {
/*  848 */     this.com_ListaCodigos = new TextAutoCompleter(this.jTextField23, this.LISTACODIGOS);
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
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/*  861 */     if (!datos.contains(valor)) {
/*  862 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiar() {
/*  867 */     this.jTextField1.setText("          ");
/*  868 */     this.jTextField2.setText("          ");
/*  869 */     this.jTextField3.setText("          ");
/*  870 */     this.jTextField4.setText("          ");
/*  871 */     this.jTextField31.setText("");
/*  872 */     this.jTextField16.setText("");
/*  873 */     this.jTextField42.setText("");
/*  874 */     this.jTextField17.setText("");
/*  875 */     this.jTextField18.setText("");
/*  876 */     this.jTextField20.setText("");
/*  877 */     this.jTextField21.setText("");
/*  878 */     this.jTextField22.setText("");
/*  879 */     this.jTextField23.setText("");
/*  880 */     this.jTextField24.setText("");
/*  881 */     this.jTextField25.setText("");
/*  882 */     this.jTextField26.setText("");
/*  883 */     this.jTextField27.setText("");
/*  884 */     this.jTextField28.setText("");
/*  885 */     this.jTextField30.setText("");
/*  886 */     this.jTextField33.setText("");
/*  887 */     this.jTextField35.setText("");
/*  888 */     this.jTextField37.setText("");
/*  889 */     this.jTextField38.setText("");
/*  890 */     this.jTextField39.setText("");
/*  891 */     this.jTextField40.setText("");
/*  892 */     this.jComboBox4.setSelectedIndex(0);
/*  893 */     this.jComboBox5.setSelectedIndex(0);
/*  894 */     this.jComboBox6.setSelectedIndex(0);
/*  895 */     this.jComboBox7.setSelectedIndex(0);
/*  896 */     this.jComboBox8.setSelectedIndex(0);
/*  897 */     this.jSpinner1.setValue(Integer.valueOf(28));
/*  898 */     this.jSpinner2.setValue(Integer.valueOf(0));
/*  899 */     this.jDateChooser4.setDate(new Date());
/*  900 */     this.jDateChooser5.setDate(new Date());
/*  901 */     this.jDateChooser6.setDate(new Date());
/*  902 */     this.jDateChooser7.setDate(new Date());
/*  903 */     this.jFormattedTextField4.setValue("");
/*  904 */     this.jFormattedTextField5.setValue("");
/*  905 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*  906 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/*  907 */     this.jTextArea1.setText("");
/*  908 */     if (!this.materialButton1.getText().equals("Modificar")) {
/*  909 */       crearInd();
/*      */     }
/*      */ 
/*      */     
/*  913 */     this.datos.eliminar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void initComponents() {
/*  919 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  920 */     this.jPanel8 = new JPanel();
/*  921 */     this.jLabel62 = new JLabel();
/*  922 */     this.jSeparator3 = new JSeparator();
/*  923 */     this.jPanel3 = new JPanel();
/*  924 */     this.jLabel63 = new JLabel();
/*  925 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  926 */     this.jRadioButton1 = new JRadioButton();
/*  927 */     this.jRadioButton2 = new JRadioButton();
/*  928 */     this.jLabel64 = new JLabel();
/*  929 */     this.jTextField15 = new JTextField();
/*  930 */     this.jButton9 = new JButton();
/*  931 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  932 */     this.jPanel6 = new JPanel();
/*  933 */     this.jLabel127 = new JLabel();
/*  934 */     this.jSeparator2 = new JSeparator();
/*  935 */     this.jLabel11 = new JLabel();
/*  936 */     this.jRadioButton3 = new JRadioButton();
/*  937 */     this.jRadioButton4 = new JRadioButton();
/*  938 */     this.jSeparator4 = new JSeparator();
/*  939 */     this.jButton7 = new JButton();
/*  940 */     this.jButton10 = new JButton();
/*  941 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  942 */     this.jPanel14 = new JPanel();
/*  943 */     this.jLabel44 = new JLabel();
/*  944 */     this.jSeparator7 = new JSeparator();
/*  945 */     this.jLabel47 = new JLabel();
/*  946 */     this.jPanel15 = new JPanel();
/*  947 */     this.jLabel12 = new JLabel();
/*  948 */     this.jLabel32 = new JLabel();
/*  949 */     this.jLabel38 = new JLabel();
/*  950 */     this.jLabel78 = new JLabel();
/*  951 */     this.jLabel80 = new JLabel();
/*  952 */     this.jLabel82 = new JLabel();
/*  953 */     this.jLabel83 = new JLabel();
/*  954 */     this.jLabel84 = new JLabel();
/*  955 */     this.jLabel85 = new JLabel();
/*  956 */     this.jLabel86 = new JLabel();
/*  957 */     this.jPanel9 = new JPanel();
/*  958 */     this.jLabel81 = new JLabel();
/*  959 */     this.jLabel87 = new JLabel();
/*  960 */     this.jPanel7 = new JPanel();
/*  961 */     this.jLabel88 = new JLabel();
/*  962 */     this.jLabel89 = new JLabel();
/*  963 */     this.jLabel51 = new JLabel();
/*  964 */     this.jButton16 = new JButton();
/*  965 */     this.jButton17 = new JButton();
/*  966 */     this.jButton18 = new JButton();
/*  967 */     this.jPanel16 = new JPanel();
/*  968 */     this.jLabel79 = new JLabel();
/*  969 */     this.jLabel90 = new JLabel();
/*  970 */     this.jLabel91 = new JLabel();
/*  971 */     this.jLabel94 = new JLabel();
/*  972 */     this.jLabel95 = new JLabel();
/*  973 */     this.jLabel96 = new JLabel();
/*  974 */     this.jLabel97 = new JLabel();
/*  975 */     this.jLabel99 = new JLabel();
/*  976 */     this.jLabel100 = new JLabel();
/*  977 */     this.jLabel102 = new JLabel();
/*  978 */     this.jLabel103 = new JLabel();
/*  979 */     this.jLabel104 = new JLabel();
/*  980 */     this.jLabel105 = new JLabel();
/*  981 */     this.jLabel92 = new JLabel();
/*  982 */     this.jLabel106 = new JLabel();
/*  983 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  984 */     this.jPanel10 = new JPanel();
/*  985 */     this.jLabel39 = new JLabel();
/*  986 */     this.jSeparator6 = new JSeparator();
/*  987 */     this.jLabel40 = new JLabel();
/*  988 */     this.jLabel41 = new JLabel();
/*  989 */     this.jButton12 = new JButton();
/*  990 */     this.jButton13 = new JButton();
/*  991 */     this.jButton14 = new JButton();
/*  992 */     this.jPanel18 = new JPanel();
/*  993 */     this.jLabel107 = new JLabel();
/*  994 */     this.jLabel108 = new JLabel();
/*  995 */     this.jLabel109 = new JLabel();
/*  996 */     this.jLabel111 = new JLabel();
/*  997 */     this.jLabel112 = new JLabel();
/*  998 */     this.jLabel113 = new JLabel();
/*  999 */     this.jLabel114 = new JLabel();
/* 1000 */     this.jLabel116 = new JLabel();
/* 1001 */     this.jLabel117 = new JLabel();
/* 1002 */     this.jLabel110 = new JLabel();
/* 1003 */     this.jLabel115 = new JLabel();
/* 1004 */     this.jLabel120 = new JLabel();
/* 1005 */     this.jPanel19 = new JPanel();
/* 1006 */     this.jLabel121 = new JLabel();
/* 1007 */     this.jLabel129 = new JLabel();
/* 1008 */     this.jLabel130 = new JLabel();
/* 1009 */     this.jLabel131 = new JLabel();
/* 1010 */     this.jLabel132 = new JLabel();
/* 1011 */     this.jLabel133 = new JLabel();
/* 1012 */     this.jLabel134 = new JLabel();
/* 1013 */     this.jLabel135 = new JLabel();
/* 1014 */     this.jLabel136 = new JLabel();
/* 1015 */     this.jLabel42 = new JLabel();
/* 1016 */     this.jLabel137 = new JLabel();
/* 1017 */     this.jLabel118 = new JLabel();
/* 1018 */     this.jLabel138 = new JLabel();
/* 1019 */     this.jLabel139 = new JLabel();
/* 1020 */     this.jPanel20 = new JPanel();
/* 1021 */     this.jLabel119 = new JLabel();
/* 1022 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 1023 */     this.buttonGroup1 = new ButtonGroup();
/* 1024 */     this.buttonGroup2 = new ButtonGroup();
/* 1025 */     this.jDialog3 = new CerrarVentana(this.padre);
/* 1026 */     this.jPanel2 = new JPanel();
/* 1027 */     this.jPanel59 = new JPanel();
/* 1028 */     this.jLabel156 = new JLabel();
/* 1029 */     this.jLabel1 = new JLabel();
/* 1030 */     this.buttonGroup3 = new ButtonGroup();
/* 1031 */     this.buttonGroup4 = new ButtonGroup();
/* 1032 */     this.jDialog9 = new CerrarVentana(this.padre);
/* 1033 */     this.jPanel13 = new JPanel();
/* 1034 */     this.jPanel37 = new JPanel();
/* 1035 */     this.jPanel12 = new JPanel();
/* 1036 */     this.jPanel27 = new JPanel();
/* 1037 */     this.jLabel77 = new JLabel();
/* 1038 */     this.jLabel122 = new JLabel();
/* 1039 */     this.jPanel30 = new JPanel();
/* 1040 */     this.jLabel123 = new JLabel();
/* 1041 */     this.jPanel38 = new JPanel();
/* 1042 */     this.jPanel39 = new JPanel();
/* 1043 */     this.jLabel124 = new JLabel();
/* 1044 */     this.jPanel40 = new JPanel();
/* 1045 */     this.jPanel41 = new JPanel();
/* 1046 */     this.jLabel125 = new JLabel();
/* 1047 */     this.jLabel126 = new JLabel();
/* 1048 */     this.jPanel42 = new JPanel();
/* 1049 */     this.jLabel128 = new JLabel();
/* 1050 */     this.jPanel43 = new JPanel();
/* 1051 */     this.jLabel140 = new JLabel();
/* 1052 */     this.jPanel44 = new JPanel();
/* 1053 */     this.jLabel141 = new JLabel();
/* 1054 */     this.jPanel45 = new JPanel();
/* 1055 */     this.jSpinner3 = new JSpinner();
/* 1056 */     this.jLabel146 = new JLabel();
/* 1057 */     this.jLabel142 = new JLabel();
/* 1058 */     this.jDateChooser1 = new JDateChooser();
/* 1059 */     this.jLabel143 = new JLabel();
/* 1060 */     this.jLabel144 = new JLabel();
/* 1061 */     this.jLabel145 = new JLabel();
/* 1062 */     this.jTextField29 = new JTextField();
/* 1063 */     this.jPanel46 = new JPanel();
/* 1064 */     this.jPanel47 = new JPanel();
/* 1065 */     this.jLabel147 = new JLabel();
/* 1066 */     this.jLabel148 = new JLabel();
/* 1067 */     this.jPanel48 = new JPanel();
/* 1068 */     this.jLabel149 = new JLabel();
/* 1069 */     this.jPanel49 = new JPanel();
/* 1070 */     this.jLabel154 = new JLabel();
/* 1071 */     this.jPanel50 = new JPanel();
/* 1072 */     this.jPanel51 = new JPanel();
/* 1073 */     this.jPanel52 = new JPanel();
/* 1074 */     this.jPanel53 = new JPanel();
/* 1075 */     this.jLabel150 = new JLabel();
/* 1076 */     this.jLabel151 = new JLabel();
/* 1077 */     this.jPanel54 = new JPanel();
/* 1078 */     this.jPanel55 = new JPanel();
/* 1079 */     this.jLabel152 = new JLabel();
/* 1080 */     this.jLabel153 = new JLabel();
/* 1081 */     this.jPanel56 = new JPanel();
/* 1082 */     this.jButton11 = new JButton();
/* 1083 */     this.jButton15 = new JButton();
/* 1084 */     this.jButton19 = new JButton();
/* 1085 */     this.jPanel11 = new JPanel();
/* 1086 */     this.jLabel20 = new JLabel();
/* 1087 */     this.jLabel34 = new JLabel();
/* 1088 */     this.jLabel48 = new JLabel();
/* 1089 */     this.jLabel21 = new JLabel();
/* 1090 */     this.jLabel35 = new JLabel();
/* 1091 */     this.jLabel49 = new JLabel();
/* 1092 */     this.jComboBox4 = new JComboBox();
/* 1093 */     this.jPanel57 = new JPanel();
/* 1094 */     this.jTextField24 = new JTextField();
/* 1095 */     this.jPanel58 = new JPanel();
/* 1096 */     this.jButton39 = new JButton();
/* 1097 */     this.jTextField22 = new JTextField();
/* 1098 */     this.jPanel60 = new JPanel();
/* 1099 */     this.jButton40 = new JButton();
/* 1100 */     this.jTextField23 = new JTextField();
/* 1101 */     this.jPanel61 = new JPanel();
/* 1102 */     this.jTextField20 = new JTextField();
/* 1103 */     this.jLabel2 = new JLabel();
/* 1104 */     this.jPanel64 = new JPanel();
/* 1105 */     this.jLabel3 = new JLabel();
/* 1106 */     this.jTextField21 = new JTextField();
/* 1107 */     this.jTextField1 = new JTextField();
/* 1108 */     this.jTextField2 = new JTextField();
/* 1109 */     this.jTextField3 = new JTextField();
/* 1110 */     this.jLabel54 = new JLabel();
/* 1111 */     this.jTextField4 = new JTextField();
/* 1112 */     this.jPanel65 = new JPanel();
/* 1113 */     this.jButton41 = new JButton();
/* 1114 */     this.jTextField31 = new JTextField();
/* 1115 */     this.jPanel33 = new JPanel();
/* 1116 */     this.jLabel74 = new JLabel();
/* 1117 */     this.jTextField40 = new JTextField();
/* 1118 */     this.jLabel29 = new JLabel();
/* 1119 */     this.jTextField37 = new JTextField();
/* 1120 */     this.jLabel75 = new JLabel();
/* 1121 */     this.jTextField38 = new JTextField();
/* 1122 */     this.jLabel76 = new JLabel();
/* 1123 */     this.jTextField39 = new JTextField();
/* 1124 */     this.jLabel30 = new JLabel();
/* 1125 */     this.jFormattedTextField7 = new JFormattedTextField();
/* 1126 */     this.jLabel71 = new JLabel();
/* 1127 */     this.jComboBox7 = new JComboBox();
/* 1128 */     this.jLabel27 = new JLabel();
/* 1129 */     this.jSpinner1 = new JSpinner();
/* 1130 */     this.jLabel61 = new JLabel();
/* 1131 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 1132 */     this.jLabel72 = new JLabel();
/* 1133 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 1134 */     this.jPanel28 = new JPanel();
/* 1135 */     this.jLabel50 = new JLabel();
/* 1136 */     this.jTextField27 = new JTextField();
/* 1137 */     this.jLabel23 = new JLabel();
/* 1138 */     this.jComboBox5 = new JComboBox();
/* 1139 */     this.jLabel37 = new JLabel();
/* 1140 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 1141 */     this.jLabel26 = new JLabel();
/* 1142 */     this.jComboBox8 = new JComboBox();
/* 1143 */     this.jLabel67 = new JLabel();
/* 1144 */     this.jTextField30 = new JTextField();
/* 1145 */     this.jTextField35 = new JTextField();
/* 1146 */     this.jLabel68 = new JLabel();
/* 1147 */     this.jLabel52 = new JLabel();
/* 1148 */     this.jComboBox9 = new JComboBox();
/* 1149 */     this.jLabel53 = new JLabel();
/* 1150 */     this.jComboBox10 = new JComboBox();
/* 1151 */     this.jLabel31 = new JLabel();
/* 1152 */     this.jScrollPane1 = new JScrollPane();
/* 1153 */     this.jTextArea1 = new JTextArea();
/* 1154 */     this.jPanel1 = new JPanel();
/* 1155 */     this.jPanel4 = new JPanel();
/* 1156 */     this.materialButton20 = new MaterialButton();
/* 1157 */     this.jPanel24 = new JPanel();
/* 1158 */     this.jPanel26 = new JPanel();
/* 1159 */     this.materialButton1 = new MaterialButton();
/* 1160 */     this.materialButton22 = new MaterialButton();
/* 1161 */     this.materialButton19 = new MaterialButton();
/* 1162 */     this.materialButton21 = new MaterialButton();
/* 1163 */     this.jPanel35 = new JPanel();
/* 1164 */     this.jPanel76 = new JPanel();
/* 1165 */     this.jLabel57 = new JLabel();
/* 1166 */     this.jLabel9 = new JLabel();
/* 1167 */     this.jPanel31 = new JPanel();
/* 1168 */     this.jPanel34 = new JPanel();
/* 1169 */     this.jLabel8 = new JLabel();
/* 1170 */     this.jPanel75 = new JPanel();
/* 1171 */     this.jPanel77 = new JPanel();
/* 1172 */     this.jLabel10 = new JLabel();
/* 1173 */     this.jPanel78 = new JPanel();
/* 1174 */     this.jPanel79 = new JPanel();
/* 1175 */     this.jLabel13 = new JLabel();
/* 1176 */     this.jPanel80 = new JPanel();
/* 1177 */     this.jPanel81 = new JPanel();
/* 1178 */     this.jLabel14 = new JLabel();
/* 1179 */     this.jPanel82 = new JPanel();
/* 1180 */     this.jPanel32 = new JPanel();
/* 1181 */     this.jPanel29 = new JPanel();
/* 1182 */     this.jPanel25 = new JPanel();
/* 1183 */     this.jLabel19 = new JLabel();
/* 1184 */     this.jTextField19 = new JTextField();
/* 1185 */     this.jLabel18 = new JLabel();
/* 1186 */     this.jTextField16 = new JTextField();
/* 1187 */     this.jLabel33 = new JLabel();
/* 1188 */     this.jTextField17 = new JTextField();
/* 1189 */     this.jLabel46 = new JLabel();
/* 1190 */     this.jLabel65 = new JLabel();
/* 1191 */     this.jFormattedTextField4 = new JFormattedTextField(this.formaTel);
/* 1192 */     this.jFormattedTextField5 = new JFormattedTextField(this.formaTel2);
/* 1193 */     this.jLabel66 = new JLabel();
/* 1194 */     this.jLabel43 = new JLabel();
/* 1195 */     this.jPanel62 = new JPanel();
/* 1196 */     this.jRadioButton5 = new JRadioButton();
/* 1197 */     this.jRadioButton6 = new JRadioButton();
/* 1198 */     this.jLabel25 = new JLabel();
/* 1199 */     this.jTextField28 = new JTextField();
/* 1200 */     this.jLabel98 = new JLabel();
/* 1201 */     this.jFormattedTextField9 = new JFormattedTextField();
/* 1202 */     this.jLabel93 = new JLabel();
/* 1203 */     this.jTextField41 = new JTextField();
/* 1204 */     this.jLabel24 = new JLabel();
/* 1205 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 1206 */     this.jLabel22 = new JLabel();
/* 1207 */     this.jTextField25 = new JTextField();
/* 1208 */     this.jTextField42 = new JTextField();
/* 1209 */     this.jLabel101 = new JLabel();
/* 1210 */     this.jLabel36 = new JLabel();
/* 1211 */     this.jTextField26 = new JTextField();
/* 1212 */     this.jLabel45 = new JLabel();
/* 1213 */     this.jPanel63 = new JPanel();
/* 1214 */     this.jRadioButton7 = new JRadioButton();
/* 1215 */     this.jRadioButton8 = new JRadioButton();
/* 1216 */     this.jLabel70 = new JLabel();
/* 1217 */     this.jTextField33 = new JTextField();
/* 1218 */     this.jLabel69 = new JLabel();
/* 1219 */     this.jFormattedTextField6 = new JFormattedTextField();
/* 1220 */     this.jLabel28 = new JLabel();
/* 1221 */     this.jComboBox6 = new JComboBox();
/* 1222 */     this.jSpinner2 = new JSpinner();
/* 1223 */     this.jLabel73 = new JLabel();
/* 1224 */     this.jTextField18 = new JTextField();
/* 1225 */     this.jLabel155 = new JLabel();
/* 1226 */     this.jFormattedTextField1 = new JFormattedTextField();
/*      */     
/* 1228 */     this.jDialog1.setTitle("Ingresa Otros Datos");
/* 1229 */     this.jDialog1.setModal(true);
/*      */     
/* 1231 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/* 1233 */     this.jLabel62.setFont(new Font("Tahoma", 1, 14));
/* 1234 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/* 1235 */     this.jLabel62.setHorizontalAlignment(0);
/* 1236 */     this.jLabel62.setText("INGRESA OTROS DATOS");
/*      */     
/* 1238 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/* 1239 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder("Infonavit"));
/*      */     
/* 1241 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/* 1242 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/* 1243 */     this.jLabel63.setHorizontalAlignment(4);
/* 1244 */     this.jLabel63.setText("Cant Infonavit");
/*      */     
/* 1246 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 1247 */     this.jFormattedTextField3.setText("$0.0");
/*      */     
/* 1249 */     this.jRadioButton1.setText("Si");
/* 1250 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1252 */             AltaOperador.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1256 */     this.jRadioButton2.setText("No");
/* 1257 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1259 */             AltaOperador.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1263 */     this.jLabel64.setFont(new Font("Tahoma", 3, 11));
/* 1264 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/* 1265 */     this.jLabel64.setHorizontalAlignment(4);
/* 1266 */     this.jLabel64.setText("No. Infornavit");
/*      */     
/* 1268 */     this.jTextField15.setHorizontalAlignment(4);
/* 1269 */     this.jTextField15.setEnabled(false);
/*      */     
/* 1271 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1272 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1273 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1274 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1275 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1276 */           .addContainerGap()
/* 1277 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1278 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1279 */               .addComponent(this.jRadioButton2, -2, 93, -2)
/* 1280 */               .addGap(13, 13, 13)
/* 1281 */               .addComponent(this.jRadioButton1, -2, 93, -2))
/* 1282 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1283 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1284 */                 .addComponent(this.jLabel63, -1, -1, 32767)
/* 1285 */                 .addComponent(this.jLabel64, -1, -1, 32767))
/* 1286 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1287 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1288 */                 .addComponent(this.jFormattedTextField3)
/* 1289 */                 .addComponent(this.jTextField15, -1, 154, 32767))))
/* 1290 */           .addContainerGap(48, 32767)));
/*      */     
/* 1292 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1293 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1294 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1295 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1296 */             .addComponent(this.jRadioButton1)
/* 1297 */             .addComponent(this.jRadioButton2))
/* 1298 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1299 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1300 */             .addComponent(this.jLabel64)
/* 1301 */             .addComponent(this.jTextField15, -2, -1, -2))
/* 1302 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1303 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1304 */             .addComponent(this.jFormattedTextField3, -2, -1, -2)
/* 1305 */             .addComponent(this.jLabel63))
/* 1306 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1309 */     this.jButton9.setMnemonic('G');
/* 1310 */     this.jButton9.setText("Guardar");
/* 1311 */     this.jButton9.setToolTipText("Guardar (Alt+G)");
/* 1312 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1314 */             AltaOperador.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1318 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1319 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1320 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1322 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1323 */           .addContainerGap()
/* 1324 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1325 */             .addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1326 */             .addComponent(this.jSeparator3, GroupLayout.Alignment.LEADING, -1, 319, 32767)
/* 1327 */             .addComponent(this.jLabel62, GroupLayout.Alignment.LEADING, -1, 319, 32767)
/* 1328 */             .addComponent(this.jButton9, -2, 93, -2))
/* 1329 */           .addContainerGap()));
/*      */     
/* 1331 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1333 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1334 */           .addComponent(this.jLabel62)
/* 1335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1336 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 1337 */           .addGap(1, 1, 1)
/* 1338 */           .addComponent(this.jPanel3, -1, -1, 32767)
/* 1339 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1340 */           .addComponent(this.jButton9)
/* 1341 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1344 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1345 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1346 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */     
/* 1350 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1352 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */ 
/*      */     
/* 1355 */     this.jDialog5.setTitle("Impresión de Gafetes");
/* 1356 */     this.jDialog5.setModal(true);
/*      */     
/* 1358 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*      */     
/* 1360 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/* 1361 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/* 1362 */     this.jLabel127.setHorizontalAlignment(0);
/* 1363 */     this.jLabel127.setText("Tipo de Gafete");
/*      */     
/* 1365 */     this.jLabel11.setText("<html>Selecciona el tipo de gafete que deseas crear y a continuación pulsa el botón siguiente</html>");
/*      */     
/* 1367 */     this.jRadioButton3.setBackground(new Color(146, 193, 134));
/* 1368 */     this.jRadioButton3.setSelected(true);
/* 1369 */     this.jRadioButton3.setText("Credencial Forsis");
/*      */     
/* 1371 */     this.jRadioButton4.setBackground(new Color(146, 193, 134));
/* 1372 */     this.jRadioButton4.setText("Curso Básico");
/* 1373 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1375 */             AltaOperador.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1379 */     this.jButton7.setMnemonic('C');
/* 1380 */     this.jButton7.setText("Cancelar");
/* 1381 */     this.jButton7.setToolTipText("Cancelar (Alt+C)");
/* 1382 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1384 */             AltaOperador.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1388 */     this.jButton10.setMnemonic('S');
/* 1389 */     this.jButton10.setText("Siguiente >");
/* 1390 */     this.jButton10.setToolTipText("Siguiente (Alt+S)");
/* 1391 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1393 */             AltaOperador.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1397 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1398 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1399 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1400 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1401 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1402 */           .addContainerGap()
/* 1403 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */             .addComponent(this.jLabel11, -1, 351, 32767)
/* 1405 */             .addComponent(this.jSeparator2, -1, 351, 32767)
/* 1406 */             .addComponent(this.jLabel127, -1, 351, 32767)
/* 1407 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1408 */               .addComponent(this.jRadioButton3, -2, 139, -2)
/* 1409 */               .addGap(40, 40, 40)
/* 1410 */               .addComponent(this.jRadioButton4, -2, 141, -2))
/* 1411 */             .addComponent(this.jSeparator4, -1, 351, 32767)
/* 1412 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1413 */               .addComponent(this.jButton10, -2, 96, -2)
/* 1414 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1415 */               .addComponent(this.jButton7, -2, 96, -2)))
/* 1416 */           .addContainerGap()));
/*      */     
/* 1418 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1420 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1421 */           .addContainerGap()
/* 1422 */           .addComponent(this.jLabel127)
/* 1423 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1424 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1425 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1426 */           .addComponent(this.jLabel11, -2, 42, -2)
/* 1427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1428 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1429 */             .addComponent(this.jRadioButton3)
/* 1430 */             .addComponent(this.jRadioButton4))
/* 1431 */           .addGap(18, 18, 18)
/* 1432 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1433 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1434 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1435 */             .addComponent(this.jButton7)
/* 1436 */             .addComponent(this.jButton10))
/* 1437 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1440 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1441 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1442 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1443 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1444 */         .addComponent(this.jPanel6, -2, -1, -2));
/*      */     
/* 1446 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1447 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1448 */         .addComponent(this.jPanel6, -2, -1, -2));
/*      */ 
/*      */     
/* 1451 */     this.jDialog6.setTitle("Impresión de Gafetes");
/* 1452 */     this.jDialog6.setModal(true);
/*      */     
/* 1454 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 1456 */     this.jLabel44.setFont(new Font("Times New Roman", 1, 20));
/* 1457 */     this.jLabel44.setHorizontalAlignment(0);
/* 1458 */     this.jLabel44.setText("Gafette para empleados");
/*      */     
/* 1460 */     this.jLabel47.setFont(new Font("Tahoma", 1, 12));
/* 1461 */     this.jLabel47.setForeground(new Color(153, 153, 153));
/* 1462 */     this.jLabel47.setText("Frente        Frente        Frente        Frente        Frente        Frente    ");
/*      */     
/* 1464 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/* 1465 */     this.jPanel15.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1466 */     this.jPanel15.setLayout((LayoutManager)null);
/*      */     
/* 1468 */     this.jLabel12.setFont(new Font("Times New Roman", 0, 19));
/* 1469 */     this.jLabel12.setForeground(new Color(153, 0, 0));
/* 1470 */     this.jLabel12.setText("Fletes y Materiales Forsis S.A. de C.V.");
/* 1471 */     this.jPanel15.add(this.jLabel12);
/* 1472 */     this.jLabel12.setBounds(40, 0, 330, 27);
/*      */     
/* 1474 */     this.jLabel32.setText("____________________________________________________");
/* 1475 */     this.jPanel15.add(this.jLabel32);
/* 1476 */     this.jLabel32.setBounds(40, 20, 370, 19);
/*      */     
/* 1478 */     this.jLabel38.setText("___________________________________________________");
/* 1479 */     this.jPanel15.add(this.jLabel38);
/* 1480 */     this.jLabel38.setBounds(20, 10, 370, 19);
/*      */     
/* 1482 */     this.jLabel78.setHorizontalAlignment(0);
/* 1483 */     this.jLabel78.setText("sin foto");
/* 1484 */     this.jLabel78.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1485 */     this.jPanel15.add(this.jLabel78);
/* 1486 */     this.jLabel78.setBounds(10, 40, 110, 130);
/*      */     
/* 1488 */     this.jLabel80.setFont(new Font("Tahoma", 1, 11));
/* 1489 */     this.jLabel80.setHorizontalAlignment(0);
/* 1490 */     this.jLabel80.setText("OP-00001");
/* 1491 */     this.jPanel15.add(this.jLabel80);
/* 1492 */     this.jLabel80.setBounds(10, 170, 110, 16);
/*      */     
/* 1494 */     this.jLabel82.setFont(new Font("Tahoma", 1, 10));
/* 1495 */     this.jLabel82.setText("Nombre Completo");
/* 1496 */     this.jPanel15.add(this.jLabel82);
/* 1497 */     this.jLabel82.setBounds(130, 40, 280, 14);
/*      */     
/* 1499 */     this.jLabel83.setText("Núm de Licen");
/* 1500 */     this.jPanel15.add(this.jLabel83);
/* 1501 */     this.jLabel83.setBounds(130, 70, 230, 19);
/*      */     
/* 1503 */     this.jLabel84.setText("Tipo");
/* 1504 */     this.jPanel15.add(this.jLabel84);
/* 1505 */     this.jLabel84.setBounds(130, 90, 230, 19);
/*      */     
/* 1507 */     this.jLabel85.setText("Nss");
/* 1508 */     this.jPanel15.add(this.jLabel85);
/* 1509 */     this.jLabel85.setBounds(130, 110, 230, 19);
/*      */     
/* 1511 */     this.jLabel86.setText("Vigencia");
/* 1512 */     this.jLabel86.setToolTipText("Clic para cambiar la vigencia");
/* 1513 */     this.jLabel86.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1515 */             AltaOperador.this.jLabel86MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1518 */             AltaOperador.this.jLabel86MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1521 */             AltaOperador.this.jLabel86MouseExited(evt);
/*      */           }
/*      */         });
/* 1524 */     this.jPanel15.add(this.jLabel86);
/* 1525 */     this.jLabel86.setBounds(130, 150, 230, 19);
/*      */     
/* 1527 */     this.jPanel9.setBackground(new Color(247, 150, 70));
/*      */     
/* 1529 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/* 1530 */     this.jLabel81.setHorizontalAlignment(0);
/* 1531 */     this.jLabel81.setText("Categoría del Empleado");
/* 1532 */     this.jLabel81.setToolTipText("Clic para cambiar la categoría");
/*      */     
/* 1534 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1535 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1536 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1537 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1538 */         .addComponent(this.jLabel81, -1, 280, 32767));
/*      */     
/* 1540 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1542 */         .addComponent(this.jLabel81, -1, 20, 32767));
/*      */ 
/*      */     
/* 1545 */     this.jPanel15.add(this.jPanel9);
/* 1546 */     this.jPanel9.setBounds(130, 170, 280, 20);
/*      */     
/* 1548 */     this.jLabel87.setHorizontalAlignment(0);
/* 1549 */     this.jLabel87.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisCreden.png")));
/* 1550 */     this.jPanel15.add(this.jLabel87);
/* 1551 */     this.jLabel87.setBounds(230, 40, 220, 150);
/*      */     
/* 1553 */     this.jPanel7.setBackground(new Color(153, 0, 0));
/*      */     
/* 1555 */     this.jLabel88.setFont(new Font("Tahoma", 0, 10));
/* 1556 */     this.jLabel88.setForeground(new Color(255, 255, 255));
/* 1557 */     this.jLabel88.setText("<html><center><font color=Black>|</font>Autopista a Cardel km 5<font color=Black>|</font>Colonia Vergara Tarimoya<font color=Black>|</font>Veracruz, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 91810<font color=Black>|</font>(01 229)-924-8600 al 03<font color=Black>|</font></center></html>");
/*      */     
/* 1559 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1560 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1561 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1562 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1563 */         .addComponent(this.jLabel88, -1, 400, 32767));
/*      */     
/* 1565 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1567 */         .addComponent(this.jLabel88, -1, 30, 32767));
/*      */ 
/*      */     
/* 1570 */     this.jPanel15.add(this.jPanel7);
/* 1571 */     this.jPanel7.setBounds(10, 200, 400, 30);
/*      */     
/* 1573 */     this.jLabel89.setText("Curp");
/* 1574 */     this.jPanel15.add(this.jLabel89);
/* 1575 */     this.jLabel89.setBounds(130, 130, 230, 19);
/*      */     
/* 1577 */     this.jLabel51.setFont(new Font("Tahoma", 1, 12));
/* 1578 */     this.jLabel51.setForeground(new Color(153, 153, 153));
/* 1579 */     this.jLabel51.setHorizontalAlignment(0);
/* 1580 */     this.jLabel51.setText("Reverso        Reverso        Reverso        Reverso        Reverso        ");
/*      */     
/* 1582 */     this.jButton16.setMnemonic('C');
/* 1583 */     this.jButton16.setText("Cancelar");
/* 1584 */     this.jButton16.setToolTipText("Cancelar (Alt+C)");
/* 1585 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1587 */             AltaOperador.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1591 */     this.jButton17.setMnemonic('I');
/* 1592 */     this.jButton17.setText("Imprimir");
/* 1593 */     this.jButton17.setToolTipText("Imprimir (Alt+I)");
/* 1594 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1596 */             AltaOperador.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1600 */     this.jButton18.setMnemonic('R');
/* 1601 */     this.jButton18.setText("< Regresar");
/* 1602 */     this.jButton18.setToolTipText("Regresar (Alt+R)");
/* 1603 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1605 */             AltaOperador.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1609 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/* 1610 */     this.jPanel16.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1611 */     this.jPanel16.setLayout((LayoutManager)null);
/*      */     
/* 1613 */     this.jLabel79.setFont(new Font("Times New Roman", 0, 19));
/* 1614 */     this.jLabel79.setForeground(new Color(153, 0, 0));
/* 1615 */     this.jLabel79.setHorizontalAlignment(0);
/* 1616 */     this.jLabel79.setText("Políticas de la empresa");
/* 1617 */     this.jPanel16.add(this.jLabel79);
/* 1618 */     this.jLabel79.setBounds(40, 0, 330, 27);
/*      */     
/* 1620 */     this.jLabel90.setText("____________________________________________________");
/* 1621 */     this.jPanel16.add(this.jLabel90);
/* 1622 */     this.jLabel90.setBounds(40, 20, 370, 19);
/*      */     
/* 1624 */     this.jLabel91.setText("___________________________________________________");
/* 1625 */     this.jPanel16.add(this.jLabel91);
/* 1626 */     this.jLabel91.setBounds(20, 10, 370, 19);
/*      */     
/* 1628 */     this.jLabel94.setFont(new Font("Tahoma", 0, 8));
/* 1629 */     this.jLabel94.setText("<html>•  Brindar  trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos considerando que el fin de la empresa es el servicio del cliente.</html>");
/* 1630 */     this.jPanel16.add(this.jLabel94);
/* 1631 */     this.jLabel94.setBounds(20, 40, 380, 20);
/*      */     
/* 1633 */     this.jLabel95.setFont(new Font("Tahoma", 0, 8));
/* 1634 */     this.jLabel95.setText("<html>• Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo, es mi responsabilidad.</html>");
/* 1635 */     this.jPanel16.add(this.jLabel95);
/* 1636 */     this.jLabel95.setBounds(20, 60, 400, 30);
/*      */     
/* 1638 */     this.jLabel96.setFont(new Font("Tahoma", 0, 8));
/* 1639 */     this.jLabel96.setText("<html>• Como integrante de la empresa debo mantener un comportamiento ético, desterrar toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de FORSIS y de todos los clientes.</html>");
/* 1640 */     this.jPanel16.add(this.jLabel96);
/* 1641 */     this.jLabel96.setBounds(20, 90, 390, 20);
/*      */     
/* 1643 */     this.jLabel97.setFont(new Font("Tahoma", 0, 10));
/* 1644 */     this.jLabel97.setHorizontalAlignment(0);
/* 1645 */     this.jLabel97.setText("Roger Garza Cantú");
/* 1646 */     this.jPanel16.add(this.jLabel97);
/* 1647 */     this.jLabel97.setBounds(300, 170, 110, 14);
/*      */     
/* 1649 */     this.jLabel99.setHorizontalAlignment(0);
/* 1650 */     this.jLabel99.setText("_______________");
/* 1651 */     this.jPanel16.add(this.jLabel99);
/* 1652 */     this.jLabel99.setBounds(300, 200, 110, 19);
/*      */     
/* 1654 */     this.jLabel100.setFont(new Font("Tahoma", 0, 10));
/* 1655 */     this.jLabel100.setHorizontalAlignment(0);
/* 1656 */     this.jLabel100.setText("Director");
/* 1657 */     this.jPanel16.add(this.jLabel100);
/* 1658 */     this.jLabel100.setBounds(310, 210, 100, 14);
/*      */     
/* 1660 */     this.jLabel102.setFont(new Font("Tahoma", 0, 10));
/* 1661 */     this.jLabel102.setHorizontalAlignment(0);
/* 1662 */     this.jLabel102.setText("Nombre Completo");
/* 1663 */     this.jPanel16.add(this.jLabel102);
/* 1664 */     this.jLabel102.setBounds(10, 170, 170, 14);
/*      */     
/* 1666 */     this.jLabel103.setHorizontalAlignment(0);
/* 1667 */     this.jLabel103.setText("_________________");
/* 1668 */     this.jPanel16.add(this.jLabel103);
/* 1669 */     this.jLabel103.setBounds(10, 200, 150, 19);
/*      */     
/* 1671 */     this.jLabel104.setFont(new Font("Tahoma", 0, 10));
/* 1672 */     this.jLabel104.setHorizontalAlignment(0);
/* 1673 */     this.jLabel104.setText("Categoría");
/* 1674 */     this.jPanel16.add(this.jLabel104);
/* 1675 */     this.jLabel104.setBounds(10, 210, 160, 14);
/*      */     
/* 1677 */     this.jLabel105.setFont(new Font("Tahoma", 0, 8));
/* 1678 */     this.jLabel105.setText("<html>• Como operador capacitado atender al cliente es mi responsabilidad, para lo cual debo conocer los procedimientos a fin de realizarlos con excelencia..</html>");
/* 1679 */     this.jPanel16.add(this.jLabel105);
/* 1680 */     this.jLabel105.setBounds(20, 120, 390, 20);
/* 1681 */     this.jPanel16.add(this.jLabel92);
/* 1682 */     this.jLabel92.setBounds(330, 170, 50, 60);
/*      */     
/* 1684 */     this.jLabel106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png")));
/* 1685 */     this.jLabel106.setText("l");
/* 1686 */     this.jPanel16.add(this.jLabel106);
/* 1687 */     this.jLabel106.setBounds(10, 60, 400, 120);
/*      */     
/* 1689 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1690 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1691 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1692 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1693 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1694 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1695 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1696 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/* 1697 */                 .addContainerGap()
/* 1698 */                 .addComponent(this.jSeparator7))
/* 1699 */               .addComponent(this.jLabel44, GroupLayout.Alignment.LEADING, -2, 423, -2))
/* 1700 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1701 */               .addContainerGap()
/* 1702 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1703 */                 .addComponent(this.jPanel15, -2, 419, -2)
/* 1704 */                 .addComponent(this.jLabel47, -1, -1, 32767)
/* 1705 */                 .addComponent(this.jPanel16, -2, 419, -2)
/* 1706 */                 .addComponent(this.jLabel51, -1, -1, 32767)
/* 1707 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1708 */                   .addGap(0, 0, 32767)
/* 1709 */                   .addComponent(this.jButton18, -2, 97, -2)
/* 1710 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1711 */                   .addComponent(this.jButton17, -2, 97, -2)
/* 1712 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1713 */                   .addComponent(this.jButton16, -2, 97, -2)))))
/* 1714 */           .addContainerGap()));
/*      */     
/* 1716 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1717 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1718 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1719 */           .addComponent(this.jLabel44, -2, 22, -2)
/* 1720 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1721 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1723 */           .addComponent(this.jLabel47)
/* 1724 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1725 */           .addComponent(this.jPanel15, -2, 235, -2)
/* 1726 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1727 */           .addComponent(this.jLabel51)
/* 1728 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1729 */           .addComponent(this.jPanel16, -2, 235, -2)
/* 1730 */           .addGap(18, 18, 18)
/* 1731 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1732 */             .addComponent(this.jButton16)
/* 1733 */             .addComponent(this.jButton17)
/* 1734 */             .addComponent(this.jButton18))
/* 1735 */           .addContainerGap(19, 32767)));
/*      */ 
/*      */     
/* 1738 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1739 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1740 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1742 */         .addComponent(this.jPanel14, -2, 437, -2));
/*      */     
/* 1744 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1745 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1746 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 1749 */     this.jDialog7.setTitle("Impresión de Gafetes");
/* 1750 */     this.jDialog7.setModal(true);
/*      */     
/* 1752 */     this.jPanel10.setBackground(new Color(255, 255, 255));
/*      */     
/* 1754 */     this.jLabel39.setFont(new Font("Times New Roman", 1, 20));
/* 1755 */     this.jLabel39.setHorizontalAlignment(0);
/* 1756 */     this.jLabel39.setText("Credencial RigPass para Locaciones");
/*      */     
/* 1758 */     this.jLabel40.setFont(new Font("Tahoma", 1, 12));
/* 1759 */     this.jLabel40.setForeground(new Color(153, 153, 153));
/* 1760 */     this.jLabel40.setText("Frente       Frente       Frente       Frente       Frente       Frente       Frente");
/*      */     
/* 1762 */     this.jLabel41.setFont(new Font("Tahoma", 1, 12));
/* 1763 */     this.jLabel41.setForeground(new Color(153, 153, 153));
/* 1764 */     this.jLabel41.setText("Reverso      Reverso      Reverso      Reverso      Reverso      Reverso ");
/*      */     
/* 1766 */     this.jButton12.setMnemonic('C');
/* 1767 */     this.jButton12.setText("Cancelar");
/* 1768 */     this.jButton12.setToolTipText("Cancelar (Alt+C)");
/* 1769 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1771 */             AltaOperador.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1775 */     this.jButton13.setMnemonic('I');
/* 1776 */     this.jButton13.setText("Imprimir");
/* 1777 */     this.jButton13.setToolTipText("Imprimir (Alt+I)");
/* 1778 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1780 */             AltaOperador.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1784 */     this.jButton14.setMnemonic('R');
/* 1785 */     this.jButton14.setText("< Regresar");
/* 1786 */     this.jButton14.setToolTipText("Regresar (Alt+R)");
/* 1787 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1789 */             AltaOperador.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1793 */     this.jPanel18.setBackground(new Color(255, 255, 255));
/* 1794 */     this.jPanel18.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1795 */     this.jPanel18.setLayout((LayoutManager)null);
/*      */     
/* 1797 */     this.jLabel107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis50.png")));
/* 1798 */     this.jPanel18.add(this.jLabel107);
/* 1799 */     this.jLabel107.setBounds(10, 10, 50, 50);
/*      */     
/* 1801 */     this.jLabel108.setFont(new Font("Tahoma", 1, 13));
/* 1802 */     this.jLabel108.setForeground(new Color(0, 51, 204));
/* 1803 */     this.jLabel108.setHorizontalAlignment(0);
/* 1804 */     this.jLabel108.setText("<html><u>CURSO DE SEGURIDAD BÁSICA</u></html>");
/* 1805 */     this.jPanel18.add(this.jLabel108);
/* 1806 */     this.jLabel108.setBounds(110, 120, 300, 20);
/*      */     
/* 1808 */     this.jLabel109.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png")));
/* 1809 */     this.jPanel18.add(this.jLabel109);
/* 1810 */     this.jLabel109.setBounds(70, 30, 350, 40);
/*      */     
/* 1812 */     this.jLabel111.setFont(new Font("Tahoma", 1, 14));
/* 1813 */     this.jLabel111.setForeground(new Color(0, 51, 204));
/* 1814 */     this.jLabel111.setHorizontalAlignment(0);
/* 1815 */     this.jLabel111.setText("FLETES Y MATERIALES FORSIS S.A. DE C.V.");
/* 1816 */     this.jPanel18.add(this.jLabel111);
/* 1817 */     this.jLabel111.setBounds(60, 10, 340, 20);
/*      */     
/* 1819 */     this.jLabel112.setFont(new Font("Tahoma", 1, 11));
/* 1820 */     this.jLabel112.setHorizontalAlignment(0);
/* 1821 */     this.jLabel112.setText("ACREDITA A:");
/* 1822 */     this.jPanel18.add(this.jLabel112);
/* 1823 */     this.jLabel112.setBounds(110, 70, 290, 16);
/*      */     
/* 1825 */     this.jLabel113.setFont(new Font("Tahoma", 1, 11));
/* 1826 */     this.jLabel113.setForeground(new Color(0, 51, 204));
/* 1827 */     this.jLabel113.setHorizontalAlignment(0);
/* 1828 */     this.jLabel113.setText("UZZIEL CONTRERAS PORTILLA");
/* 1829 */     this.jPanel18.add(this.jLabel113);
/* 1830 */     this.jLabel113.setBounds(110, 90, 300, 16);
/*      */     
/* 1832 */     this.jLabel114.setHorizontalAlignment(0);
/* 1833 */     this.jLabel114.setText("DE HABER:");
/* 1834 */     this.jPanel18.add(this.jLabel114);
/* 1835 */     this.jLabel114.setBounds(110, 110, 290, 19);
/*      */     
/* 1837 */     this.jLabel116.setHorizontalAlignment(0);
/* 1838 */     this.jLabel116.setText("<html><center>Certificado por:<br>SECRETARÍA DEL TRABAJO Y PREVISION SOCIAL\n</center></html>");
/* 1839 */     this.jPanel18.add(this.jLabel116);
/* 1840 */     this.jLabel116.setBounds(110, 190, 300, 30);
/*      */     
/* 1842 */     this.jLabel117.setHorizontalAlignment(0);
/* 1843 */     this.jLabel117.setText("VACJ 710806 TU8 0013");
/* 1844 */     this.jPanel18.add(this.jLabel117);
/* 1845 */     this.jLabel117.setBounds(110, 154, 300, 40);
/*      */     
/* 1847 */     this.jLabel110.setFont(new Font("Tahoma", 0, 10));
/* 1848 */     this.jLabel110.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/* 1849 */     this.jPanel18.add(this.jLabel110);
/* 1850 */     this.jLabel110.setBounds(0, 220, 450, 30);
/*      */     
/* 1852 */     this.jLabel115.setHorizontalAlignment(0);
/* 1853 */     this.jLabel115.setText("sin foto");
/* 1854 */     this.jLabel115.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1855 */     this.jPanel18.add(this.jLabel115);
/* 1856 */     this.jLabel115.setBounds(10, 80, 110, 130);
/*      */     
/* 1858 */     this.jLabel120.setHorizontalAlignment(0);
/* 1859 */     this.jLabel120.setText("AGENTE CAPACITADOR");
/* 1860 */     this.jPanel18.add(this.jLabel120);
/* 1861 */     this.jLabel120.setBounds(110, 140, 300, 19);
/*      */     
/* 1863 */     this.jPanel19.setBackground(new Color(255, 255, 255));
/* 1864 */     this.jPanel19.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1865 */     this.jPanel19.setLayout((LayoutManager)null);
/*      */     
/* 1867 */     this.jLabel121.setFont(new Font("Tahoma", 1, 14));
/* 1868 */     this.jLabel121.setForeground(new Color(0, 51, 204));
/* 1869 */     this.jLabel121.setHorizontalAlignment(0);
/* 1870 */     this.jLabel121.setText("CURSO DE SEGURIDAD BÁSICA");
/* 1871 */     this.jPanel19.add(this.jLabel121);
/* 1872 */     this.jLabel121.setBounds(60, 10, 340, 20);
/*      */     
/* 1874 */     this.jLabel129.setFont(new Font("Tahoma", 0, 12));
/* 1875 */     this.jLabel129.setForeground(new Color(0, 51, 153));
/* 1876 */     this.jLabel129.setText("COPU01087464");
/* 1877 */     this.jPanel19.add(this.jLabel129);
/* 1878 */     this.jLabel129.setBounds(160, 70, 260, 17);
/*      */     
/* 1880 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 1881 */     this.jLabel130.setText("CURP:");
/* 1882 */     this.jPanel19.add(this.jLabel130);
/* 1883 */     this.jLabel130.setBounds(10, 70, 140, 16);
/*      */     
/* 1885 */     this.jLabel131.setFont(new Font("Tahoma", 1, 11));
/* 1886 */     this.jLabel131.setText("NOMBRE DEL EMPLEADO:");
/* 1887 */     this.jPanel19.add(this.jLabel131);
/* 1888 */     this.jLabel131.setBounds(10, 40, 140, 16);
/*      */     
/* 1890 */     this.jLabel132.setFont(new Font("Tahoma", 0, 12));
/* 1891 */     this.jLabel132.setForeground(new Color(0, 51, 153));
/* 1892 */     this.jLabel132.setText("NOMBRE DEL EMPLEADO:");
/* 1893 */     this.jPanel19.add(this.jLabel132);
/* 1894 */     this.jLabel132.setBounds(160, 40, 260, 17);
/*      */     
/* 1896 */     this.jLabel133.setFont(new Font("Tahoma", 1, 11));
/* 1897 */     this.jLabel133.setText("IMSS:");
/* 1898 */     this.jPanel19.add(this.jLabel133);
/* 1899 */     this.jLabel133.setBounds(10, 100, 140, 16);
/*      */     
/* 1901 */     this.jLabel134.setFont(new Font("Tahoma", 0, 12));
/* 1902 */     this.jLabel134.setForeground(new Color(0, 51, 153));
/* 1903 */     this.jLabel134.setText("9837476276343");
/* 1904 */     this.jPanel19.add(this.jLabel134);
/* 1905 */     this.jLabel134.setBounds(160, 100, 260, 17);
/*      */     
/* 1907 */     this.jLabel135.setFont(new Font("Tahoma", 1, 11));
/* 1908 */     this.jLabel135.setForeground(new Color(0, 51, 153));
/* 1909 */     this.jLabel135.setText("00001");
/* 1910 */     this.jPanel19.add(this.jLabel135);
/* 1911 */     this.jLabel135.setBounds(380, 220, 60, 16);
/*      */     
/* 1913 */     this.jLabel136.setFont(new Font("Tahoma", 0, 12));
/* 1914 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/* 1915 */     this.jLabel136.setText("ENERO 2011");
/* 1916 */     this.jLabel136.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1918 */             AltaOperador.this.jLabel136MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1921 */             AltaOperador.this.jLabel136MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1924 */             AltaOperador.this.jLabel136MouseExited(evt);
/*      */           }
/*      */         });
/* 1927 */     this.jPanel19.add(this.jLabel136);
/* 1928 */     this.jLabel136.setBounds(160, 130, 260, 17);
/*      */     
/* 1930 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/* 1931 */     this.jLabel42.setHorizontalAlignment(0);
/* 1932 */     this.jLabel42.setText("<html><center>DE ACUERDO A LOS LINEAMIENTOS DE:<br>\"INTERNATIONAL ASSOCIATION OF DRILLI NG CONTRACTORS\"</center></html>");
/* 1933 */     this.jPanel19.add(this.jLabel42);
/* 1934 */     this.jLabel42.setBounds(10, 150, 420, 40);
/*      */     
/* 1936 */     this.jLabel137.setFont(new Font("Tahoma", 1, 11));
/* 1937 */     this.jLabel137.setText("VIGENCIA:");
/* 1938 */     this.jPanel19.add(this.jLabel137);
/* 1939 */     this.jLabel137.setBounds(10, 130, 140, 16);
/*      */     
/* 1941 */     this.jLabel118.setText("__________________");
/* 1942 */     this.jPanel19.add(this.jLabel118);
/* 1943 */     this.jLabel118.setBounds(60, 220, 160, 19);
/*      */     
/* 1945 */     this.jLabel138.setFont(new Font("Tahoma", 1, 11));
/* 1946 */     this.jLabel138.setText("Firma:");
/* 1947 */     this.jPanel19.add(this.jLabel138);
/* 1948 */     this.jLabel138.setBounds(10, 220, 50, 16);
/*      */     
/* 1950 */     this.jLabel139.setFont(new Font("Tahoma", 1, 11));
/* 1951 */     this.jLabel139.setHorizontalAlignment(4);
/* 1952 */     this.jLabel139.setText("FPR-");
/* 1953 */     this.jPanel19.add(this.jLabel139);
/* 1954 */     this.jLabel139.setBounds(320, 220, 50, 16);
/*      */     
/* 1956 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1957 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1958 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1959 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1960 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1961 */           .addContainerGap()
/* 1962 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1963 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1964 */               .addComponent(this.jButton14, -2, 97, -2)
/* 1965 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1966 */               .addComponent(this.jButton13, -2, 97, -2)
/* 1967 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1968 */               .addComponent(this.jButton12, -2, 97, -2))
/* 1969 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1970 */               .addComponent(this.jPanel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1971 */               .addComponent(this.jLabel41, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1972 */               .addComponent(this.jLabel39, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1973 */               .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING)
/* 1974 */               .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1975 */               .addComponent(this.jLabel40, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1976 */           .addContainerGap(23, 32767)));
/*      */     
/* 1978 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1979 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1980 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1981 */           .addComponent(this.jLabel39, -2, 34, -2)
/* 1982 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1983 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1984 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1985 */           .addComponent(this.jLabel40)
/* 1986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1987 */           .addComponent(this.jPanel18, -2, 248, -2)
/* 1988 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1989 */           .addComponent(this.jLabel41)
/* 1990 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1991 */           .addComponent(this.jPanel19, -2, 248, -2)
/* 1992 */           .addGap(18, 18, 18)
/* 1993 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1994 */             .addComponent(this.jButton12)
/* 1995 */             .addComponent(this.jButton13)
/* 1996 */             .addComponent(this.jButton14))
/* 1997 */           .addContainerGap(23, 32767)));
/*      */ 
/*      */     
/* 2000 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2001 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2002 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2003 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2004 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 2006 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2008 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 2011 */     this.jLabel119.setText("Coloca la vigencia");
/*      */     
/* 2013 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 2014 */     this.jDateChooser8.setIcon(this.icon);
/*      */     
/* 2016 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2017 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2018 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2019 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2020 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2021 */           .addContainerGap()
/* 2022 */           .addComponent(this.jLabel119, -2, 115, 32767)
/* 2023 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2024 */           .addComponent((Component)this.jDateChooser8, -2, 108, -2)
/* 2025 */           .addContainerGap()));
/*      */     
/* 2027 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2029 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2030 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2031 */             .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2032 */             .addComponent(this.jLabel119, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2033 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2036 */     this.jDialog3.setTitle("Foto");
/* 2037 */     this.jDialog3.setAlwaysOnTop(true);
/* 2038 */     this.jDialog3.setFocusable(false);
/* 2039 */     this.jDialog3.setUndecorated(true);
/*      */     
/* 2041 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 2042 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/* 2043 */     this.jPanel2.setLayout((LayoutManager)null);
/*      */     
/* 2045 */     this.jPanel59.setBackground(this.lc.PRIMARIO1);
/* 2046 */     this.jPanel59.setLayout(new GridLayout(1, 0));
/*      */     
/* 2048 */     this.jLabel156.setHorizontalAlignment(0);
/* 2049 */     this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 2050 */     this.jLabel156.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2052 */             AltaOperador.this.jLabel156MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2055 */             AltaOperador.this.jLabel156MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2058 */             AltaOperador.this.jLabel156MouseEntered(evt);
/*      */           }
/*      */         });
/* 2061 */     this.jPanel59.add(this.jLabel156);
/*      */     
/* 2063 */     this.jPanel2.add(this.jPanel59);
/* 2064 */     this.jPanel59.setBounds(219, 1, 30, 31);
/*      */     
/* 2066 */     this.jLabel1.setFont(new Font("Cantarell", 0, 13));
/* 2067 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 2068 */     this.jLabel1.setHorizontalAlignment(0);
/* 2069 */     this.jLabel1.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/* 2071 */             AltaOperador.this.jLabel1MouseDragged(evt);
/*      */           }
/*      */         });
/* 2074 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2076 */             AltaOperador.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */         });
/* 2079 */     this.jPanel2.add(this.jLabel1);
/* 2080 */     this.jLabel1.setBounds(0, 20, 253, 290);
/*      */     
/* 2082 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 2083 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 2084 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 2085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2086 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 2088 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 2089 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2090 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */ 
/*      */     
/* 2093 */     this.jDialog9.setTitle("Curso Básico de Seguridad");
/* 2094 */     this.jDialog9.setModal(true);
/*      */     
/* 2096 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 2098 */     this.jPanel37.setBackground(new Color(146, 193, 134));
/* 2099 */     this.jPanel37.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/* 2101 */     this.jPanel12.setBackground(Color.white);
/* 2102 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 2104 */     this.jPanel27.setBackground(Color.white);
/*      */     
/* 2106 */     this.jLabel77.setHorizontalAlignment(0);
/* 2107 */     this.jLabel77.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 2109 */     this.jLabel122.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 2111 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 2112 */     this.jPanel27.setLayout(jPanel27Layout);
/* 2113 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 2114 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2115 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 2116 */           .addComponent(this.jLabel77, -2, 127, -2)
/* 2117 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2118 */           .addComponent(this.jLabel122, -1, 239, 32767)));
/*      */     
/* 2120 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 2121 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2122 */         .addComponent(this.jLabel122)
/* 2123 */         .addComponent(this.jLabel77, -1, -1, 32767));
/*      */ 
/*      */     
/* 2126 */     this.jPanel30.setBackground(new Color(255, 0, 0));
/*      */     
/* 2128 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2129 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2130 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2131 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2132 */         .addGap(0, 0, 32767));
/*      */     
/* 2134 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2136 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 2139 */     this.jLabel123.setHorizontalAlignment(0);
/* 2140 */     this.jLabel123.setText("FOLIO");
/*      */     
/* 2142 */     this.jPanel38.setBackground(Color.white);
/* 2143 */     this.jPanel38.setLayout((LayoutManager)null);
/*      */     
/* 2145 */     this.jPanel39.setBackground(new Color(255, 0, 0));
/*      */     
/* 2147 */     this.jLabel124.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2148 */     this.jLabel124.setForeground(Color.white);
/* 2149 */     this.jLabel124.setHorizontalAlignment(0);
/* 2150 */     this.jLabel124.setText("<html><center>EL PORTADOR DE ESTA TARJETA A ACREDITADO UN CURSO DE ORIENTACIÓN BÁSICA DE SEGURIDAD PARA INGRESAR A INSTALACIONES PETROLERAS</center></html>");
/*      */     
/* 2152 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 2153 */     this.jPanel39.setLayout(jPanel39Layout);
/* 2154 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 2155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2156 */         .addComponent(this.jLabel124, -1, 340, 32767));
/*      */     
/* 2158 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 2159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2160 */         .addComponent(this.jLabel124, -1, 100, 32767));
/*      */ 
/*      */     
/* 2163 */     this.jPanel38.add(this.jPanel39);
/* 2164 */     this.jPanel39.setBounds(20, 10, 340, 0);
/*      */     
/* 2166 */     this.jPanel40.setBackground(new Color(177, 189, 188));
/*      */     
/* 2168 */     this.jPanel41.setBackground(new Color(177, 189, 188));
/* 2169 */     this.jPanel41.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2171 */     this.jLabel125.setHorizontalAlignment(0);
/* 2172 */     this.jLabel125.setText("NOMBRE:");
/* 2173 */     this.jPanel41.add(this.jLabel125);
/*      */     
/* 2175 */     this.jLabel126.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2176 */     this.jLabel126.setHorizontalAlignment(0);
/* 2177 */     this.jLabel126.setText("NOMBRE DEL EMPLEADO");
/* 2178 */     this.jPanel41.add(this.jLabel126);
/*      */     
/* 2180 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 2181 */     this.jPanel40.setLayout(jPanel40Layout);
/* 2182 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 2183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2184 */         .addComponent(this.jPanel41, -1, -1, 32767));
/*      */     
/* 2186 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 2187 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2188 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
/* 2189 */           .addContainerGap(64, 32767)
/* 2190 */           .addComponent(this.jPanel41, -2, -1, -2)
/* 2191 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2194 */     this.jPanel38.add(this.jPanel40);
/* 2195 */     this.jPanel40.setBounds(0, 60, 370, 120);
/*      */     
/* 2197 */     this.jPanel42.setBackground(new Color(177, 189, 188));
/* 2198 */     this.jPanel42.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2199 */     this.jPanel42.setLayout(new GridLayout(1, 0));
/*      */     
/* 2201 */     this.jLabel128.setHorizontalAlignment(0);
/* 2202 */     this.jPanel42.add(this.jLabel128);
/*      */     
/* 2204 */     this.jPanel43.setBackground(Color.white);
/*      */     
/* 2206 */     this.jLabel140.setBackground(new Color(255, 0, 0));
/* 2207 */     this.jLabel140.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2208 */     this.jLabel140.setForeground(new Color(255, 0, 0));
/* 2209 */     this.jLabel140.setText("CURSO BÁSICO DE SEGURIDAD");
/*      */     
/* 2211 */     this.jPanel44.setBackground(Color.white);
/* 2212 */     this.jPanel44.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/* 2214 */     this.jLabel141.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2215 */     this.jLabel141.setText("DURACIÓN:");
/* 2216 */     this.jPanel44.add(this.jLabel141);
/*      */     
/* 2218 */     this.jPanel45.setBackground(Color.white);
/* 2219 */     this.jPanel45.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2221 */     this.jSpinner3.setModel(new SpinnerNumberModel(8, 1, 480, 1));
/* 2222 */     this.jPanel45.add(this.jSpinner3);
/*      */     
/* 2224 */     this.jLabel146.setText("hrs.");
/* 2225 */     this.jPanel45.add(this.jLabel146);
/*      */     
/* 2227 */     this.jPanel44.add(this.jPanel45);
/*      */     
/* 2229 */     this.jLabel142.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2230 */     this.jLabel142.setText("VIGENCIA:");
/* 2231 */     this.jPanel44.add(this.jLabel142);
/*      */     
/* 2233 */     this.jDateChooser1.setIcon(this.icon);
/* 2234 */     this.jPanel44.add((Component)this.jDateChooser1);
/*      */     
/* 2236 */     this.jLabel143.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2237 */     this.jLabel143.setText("FECHA:");
/* 2238 */     this.jPanel44.add(this.jLabel143);
/*      */     
/* 2240 */     this.jLabel144.setText("jLabel143");
/* 2241 */     this.jPanel44.add(this.jLabel144);
/*      */     
/* 2243 */     this.jLabel145.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2244 */     this.jLabel145.setText("CATEGORÍA:");
/* 2245 */     this.jPanel44.add(this.jLabel145);
/*      */     
/* 2247 */     this.jTextField29.setText("jTextField29");
/* 2248 */     this.jPanel44.add(this.jTextField29);
/*      */     
/* 2250 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 2251 */     this.jPanel43.setLayout(jPanel43Layout);
/* 2252 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 2253 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2254 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 2255 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2256 */             .addComponent(this.jPanel44, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 2257 */             .addComponent(this.jLabel140, -1, -1, 32767))
/* 2258 */           .addContainerGap()));
/*      */     
/* 2260 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 2261 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2262 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2263 */           .addComponent(this.jLabel140)
/* 2264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2265 */           .addComponent(this.jPanel44, -1, 124, 32767)));
/*      */ 
/*      */     
/* 2268 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 2269 */     this.jPanel12.setLayout(jPanel12Layout);
/* 2270 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 2271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2272 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2273 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2274 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 2275 */               .addComponent(this.jPanel42, -2, 114, -2)
/* 2276 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2277 */               .addComponent(this.jPanel43, -1, -1, 32767))
/* 2278 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2279 */               .addComponent(this.jPanel30, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2280 */               .addComponent(this.jPanel27, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2281 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 2282 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2283 */                 .addComponent(this.jPanel38, GroupLayout.Alignment.LEADING, -1, 369, 32767)
/* 2284 */                 .addComponent(this.jLabel123, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2285 */               .addGap(3, 3, 3)))
/* 2286 */           .addGap(12, 12, 12)));
/*      */     
/* 2288 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 2289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2290 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2291 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 2292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2293 */           .addComponent(this.jPanel30, -2, -1, -2)
/* 2294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2295 */           .addComponent(this.jLabel123)
/* 2296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2297 */           .addComponent(this.jPanel38, -2, 178, -2)
/* 2298 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2299 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2300 */             .addComponent(this.jPanel43, -1, -1, 32767)
/* 2301 */             .addComponent(this.jPanel42, -1, -1, 32767))
/* 2302 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2305 */     this.jPanel37.add(this.jPanel12);
/*      */     
/* 2307 */     this.jPanel46.setBackground(Color.white);
/* 2308 */     this.jPanel46.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 2310 */     this.jPanel47.setBackground(Color.white);
/*      */     
/* 2312 */     this.jLabel147.setHorizontalAlignment(0);
/* 2313 */     this.jLabel147.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 2315 */     this.jLabel148.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 2317 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/* 2318 */     this.jPanel47.setLayout(jPanel47Layout);
/* 2319 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/* 2320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2321 */         .addGroup(jPanel47Layout.createSequentialGroup()
/* 2322 */           .addComponent(this.jLabel147, -2, 127, -2)
/* 2323 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2324 */           .addComponent(this.jLabel148, -1, 238, 32767)));
/*      */     
/* 2326 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/* 2327 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2328 */         .addComponent(this.jLabel148)
/* 2329 */         .addComponent(this.jLabel147, -1, -1, 32767));
/*      */ 
/*      */     
/* 2332 */     this.jPanel48.setBackground(new Color(255, 0, 0));
/*      */     
/* 2334 */     GroupLayout jPanel48Layout = new GroupLayout(this.jPanel48);
/* 2335 */     this.jPanel48.setLayout(jPanel48Layout);
/* 2336 */     jPanel48Layout.setHorizontalGroup(jPanel48Layout
/* 2337 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2338 */         .addGap(0, 0, 32767));
/*      */     
/* 2340 */     jPanel48Layout.setVerticalGroup(jPanel48Layout
/* 2341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2342 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 2345 */     this.jLabel149.setHorizontalAlignment(0);
/* 2346 */     this.jLabel149.setText("FOLIO");
/*      */     
/* 2348 */     this.jPanel49.setBackground(Color.white);
/* 2349 */     this.jPanel49.setLayout((LayoutManager)null);
/*      */     
/* 2351 */     this.jLabel154.setHorizontalAlignment(0);
/* 2352 */     this.jLabel154.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/FirmaQHSE.jpg")));
/* 2353 */     this.jPanel49.add(this.jLabel154);
/* 2354 */     this.jLabel154.setBounds(20, 10, 340, 90);
/*      */     
/* 2356 */     this.jPanel50.setBackground(new Color(255, 0, 0));
/*      */     
/* 2358 */     this.jPanel51.setBackground(Color.white);
/*      */     
/* 2360 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 2361 */     this.jPanel51.setLayout(jPanel51Layout);
/* 2362 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 2363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2364 */         .addGap(0, 316, 32767));
/*      */     
/* 2366 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 2367 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2368 */         .addGap(0, 88, 32767));
/*      */ 
/*      */     
/* 2371 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 2372 */     this.jPanel50.setLayout(jPanel50Layout);
/* 2373 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 2374 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2375 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2376 */           .addContainerGap()
/* 2377 */           .addComponent(this.jPanel51, -1, -1, 32767)
/* 2378 */           .addContainerGap()));
/*      */     
/* 2380 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 2381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2382 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2383 */           .addContainerGap()
/* 2384 */           .addComponent(this.jPanel51, -1, -1, 32767)
/* 2385 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2388 */     this.jPanel49.add(this.jPanel50);
/* 2389 */     this.jPanel50.setBounds(20, 10, 340, 100);
/*      */     
/* 2391 */     this.jPanel52.setBackground(new Color(177, 189, 188));
/*      */     
/* 2393 */     this.jPanel53.setBackground(new Color(177, 189, 188));
/* 2394 */     this.jPanel53.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2396 */     this.jLabel150.setHorizontalAlignment(0);
/* 2397 */     this.jLabel150.setText("AGENTE CAPACITADOR:");
/* 2398 */     this.jPanel53.add(this.jLabel150);
/*      */     
/* 2400 */     this.jLabel151.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2401 */     this.jLabel151.setHorizontalAlignment(0);
/* 2402 */     this.jLabel151.setText("NOMBRE DEL EMPLEADO");
/* 2403 */     this.jPanel53.add(this.jLabel151);
/*      */     
/* 2405 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 2406 */     this.jPanel52.setLayout(jPanel52Layout);
/* 2407 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 2408 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2409 */         .addComponent(this.jPanel53, -1, -1, 32767));
/*      */     
/* 2411 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 2412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2413 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
/* 2414 */           .addContainerGap(64, 32767)
/* 2415 */           .addComponent(this.jPanel53, -2, -1, -2)
/* 2416 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2419 */     this.jPanel49.add(this.jPanel52);
/* 2420 */     this.jPanel52.setBounds(0, 60, 370, 120);
/*      */     
/* 2422 */     this.jPanel54.setBackground(new Color(177, 189, 188));
/* 2423 */     this.jPanel54.setLayout(new GridLayout(1, 0));
/*      */     
/* 2425 */     this.jPanel55.setBackground(Color.white);
/*      */     
/* 2427 */     this.jLabel152.setBackground(new Color(255, 0, 0));
/* 2428 */     this.jLabel152.setText("<html><b><center>CAPACITACIÓN ACREDITADA ANTE LA SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL CON EL NÚMERO DE REGISTRO:</center><b></html>");
/*      */     
/* 2430 */     this.jLabel153.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2431 */     this.jLabel153.setHorizontalAlignment(0);
/* 2432 */     this.jLabel153.setText("jLabel147");
/*      */     
/* 2434 */     GroupLayout jPanel55Layout = new GroupLayout(this.jPanel55);
/* 2435 */     this.jPanel55.setLayout(jPanel55Layout);
/* 2436 */     jPanel55Layout.setHorizontalGroup(jPanel55Layout
/* 2437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2438 */         .addComponent(this.jLabel153, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2439 */         .addGroup(jPanel55Layout.createSequentialGroup()
/* 2440 */           .addComponent(this.jLabel152, -2, 248, -2)
/* 2441 */           .addGap(0, 0, 32767)));
/*      */     
/* 2443 */     jPanel55Layout.setVerticalGroup(jPanel55Layout
/* 2444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2445 */         .addGroup(jPanel55Layout.createSequentialGroup()
/* 2446 */           .addComponent(this.jLabel152, -2, 103, -2)
/* 2447 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2448 */           .addComponent(this.jLabel153)
/* 2449 */           .addGap(0, 21, 32767)));
/*      */ 
/*      */     
/* 2452 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 2453 */     this.jPanel46.setLayout(jPanel46Layout);
/* 2454 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 2455 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2456 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 2457 */           .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2458 */             .addGroup(jPanel46Layout.createSequentialGroup()
/* 2459 */               .addComponent(this.jPanel54, -2, 114, -2)
/* 2460 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2461 */               .addComponent(this.jPanel55, -1, -1, 32767))
/* 2462 */             .addGroup(jPanel46Layout.createSequentialGroup()
/* 2463 */               .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2464 */                 .addComponent(this.jPanel49, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2465 */                 .addComponent(this.jLabel149, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2466 */                 .addComponent(this.jPanel48, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2467 */                 .addComponent(this.jPanel47, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2468 */               .addGap(0, 0, 32767)))
/* 2469 */           .addGap(11, 11, 11)));
/*      */     
/* 2471 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 2472 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2473 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 2474 */           .addComponent(this.jPanel47, -2, -1, -2)
/* 2475 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2476 */           .addComponent(this.jPanel48, -2, -1, -2)
/* 2477 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2478 */           .addComponent(this.jLabel149)
/* 2479 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2480 */           .addComponent(this.jPanel49, -2, 178, -2)
/* 2481 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2482 */           .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2483 */             .addComponent(this.jPanel55, -1, -1, 32767)
/* 2484 */             .addComponent(this.jPanel54, -1, -1, 32767))
/* 2485 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2488 */     this.jPanel37.add(this.jPanel46);
/*      */     
/* 2490 */     this.jPanel56.setBackground(new Color(146, 193, 134));
/*      */     
/* 2492 */     this.jButton11.setMnemonic('C');
/* 2493 */     this.jButton11.setText("Cancelar");
/* 2494 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 2495 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2497 */             AltaOperador.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2501 */     this.jButton15.setMnemonic('I');
/* 2502 */     this.jButton15.setText("Imprimir");
/* 2503 */     this.jButton15.setToolTipText("Imprimir (Alt+I)");
/* 2504 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2506 */             AltaOperador.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2510 */     this.jButton19.setMnemonic('R');
/* 2511 */     this.jButton19.setText("< Regresar");
/* 2512 */     this.jButton19.setToolTipText("Regresar a la ventana anterior(Alt+R)");
/* 2513 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2515 */             AltaOperador.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2519 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/* 2520 */     this.jPanel56.setLayout(jPanel56Layout);
/* 2521 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/* 2522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2523 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
/* 2524 */           .addContainerGap(-1, 32767)
/* 2525 */           .addComponent(this.jButton19, -2, 102, -2)
/* 2526 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2527 */           .addComponent(this.jButton15, -2, 102, -2)
/* 2528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2529 */           .addComponent(this.jButton11, -2, 102, -2)
/* 2530 */           .addGap(14, 14, 14)));
/*      */     
/* 2532 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/* 2533 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2534 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
/* 2535 */           .addGap(0, 0, 32767)
/* 2536 */           .addGroup(jPanel56Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2537 */             .addComponent(this.jButton11)
/* 2538 */             .addComponent(this.jButton15)
/* 2539 */             .addComponent(this.jButton19))));
/*      */ 
/*      */     
/* 2542 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2543 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2544 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2546 */         .addComponent(this.jPanel56, -1, -1, 32767)
/* 2547 */         .addComponent(this.jPanel37, -1, 763, 32767));
/*      */     
/* 2549 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2551 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2552 */           .addComponent(this.jPanel37, -1, -1, 32767)
/* 2553 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2554 */           .addComponent(this.jPanel56, -1, -1, 32767)
/* 2555 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2558 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2559 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2560 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2561 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2562 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */     
/* 2564 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2565 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2566 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */ 
/*      */     
/* 2569 */     GridBagLayout jPanel11Layout = new GridBagLayout();
/* 2570 */     jPanel11Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2571 */     jPanel11Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2572 */     this.jPanel11.setLayout(jPanel11Layout);
/*      */     
/* 2574 */     this.jLabel20.setFont(new Font("Cantarell", 1, 11));
/* 2575 */     this.jLabel20.setText("Código Postal *");
/* 2576 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 2577 */     gridBagConstraints.gridx = 2;
/* 2578 */     gridBagConstraints.gridy = 0;
/* 2579 */     gridBagConstraints.fill = 2;
/* 2580 */     gridBagConstraints.ipadx = 40;
/* 2581 */     gridBagConstraints.weightx = 0.1D;
/* 2582 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2583 */     this.jPanel11.add(this.jLabel20, gridBagConstraints);
/*      */     
/* 2585 */     this.jLabel34.setFont(new Font("Cantarell", 1, 11));
/* 2586 */     this.jLabel34.setText("Calle *");
/* 2587 */     gridBagConstraints = new GridBagConstraints();
/* 2588 */     gridBagConstraints.gridx = 2;
/* 2589 */     gridBagConstraints.gridy = 2;
/* 2590 */     gridBagConstraints.fill = 2;
/* 2591 */     gridBagConstraints.ipadx = 40;
/* 2592 */     gridBagConstraints.weightx = 0.1D;
/* 2593 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2594 */     this.jPanel11.add(this.jLabel34, gridBagConstraints);
/*      */     
/* 2596 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 2597 */     this.jLabel48.setText("Número");
/* 2598 */     gridBagConstraints = new GridBagConstraints();
/* 2599 */     gridBagConstraints.gridx = 2;
/* 2600 */     gridBagConstraints.gridy = 4;
/* 2601 */     gridBagConstraints.fill = 2;
/* 2602 */     gridBagConstraints.ipadx = 40;
/* 2603 */     gridBagConstraints.weightx = 0.1D;
/* 2604 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2605 */     this.jPanel11.add(this.jLabel48, gridBagConstraints);
/*      */     
/* 2607 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/* 2608 */     this.jLabel21.setText("Colonia");
/* 2609 */     gridBagConstraints = new GridBagConstraints();
/* 2610 */     gridBagConstraints.gridx = 2;
/* 2611 */     gridBagConstraints.gridy = 6;
/* 2612 */     gridBagConstraints.fill = 2;
/* 2613 */     gridBagConstraints.ipadx = 40;
/* 2614 */     gridBagConstraints.weightx = 0.1D;
/* 2615 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2616 */     this.jPanel11.add(this.jLabel21, gridBagConstraints);
/*      */     
/* 2618 */     this.jLabel35.setFont(new Font("Cantarell", 0, 11));
/* 2619 */     this.jLabel35.setText("Ciudad o Municipio");
/* 2620 */     gridBagConstraints = new GridBagConstraints();
/* 2621 */     gridBagConstraints.gridx = 2;
/* 2622 */     gridBagConstraints.gridy = 10;
/* 2623 */     gridBagConstraints.fill = 2;
/* 2624 */     gridBagConstraints.ipadx = 40;
/* 2625 */     gridBagConstraints.weightx = 0.1D;
/* 2626 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2627 */     this.jPanel11.add(this.jLabel35, gridBagConstraints);
/*      */     
/* 2629 */     this.jLabel49.setFont(new Font("Cantarell", 1, 11));
/* 2630 */     this.jLabel49.setText("Estado *");
/* 2631 */     gridBagConstraints = new GridBagConstraints();
/* 2632 */     gridBagConstraints.gridx = 2;
/* 2633 */     gridBagConstraints.gridy = 12;
/* 2634 */     gridBagConstraints.fill = 2;
/* 2635 */     gridBagConstraints.ipadx = 40;
/* 2636 */     gridBagConstraints.weightx = 0.1D;
/* 2637 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2638 */     this.jPanel11.add(this.jLabel49, gridBagConstraints);
/*      */     
/* 2640 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 2641 */     this.jComboBox4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2642 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS", "CIUDAD DE MEXCO" }));
/* 2643 */     this.jComboBox4.setEnabled(false);
/* 2644 */     this.jComboBox4.setNextFocusableComponent(this.jTextField25);
/* 2645 */     gridBagConstraints = new GridBagConstraints();
/* 2646 */     gridBagConstraints.gridx = 6;
/* 2647 */     gridBagConstraints.gridy = 12;
/* 2648 */     gridBagConstraints.fill = 2;
/* 2649 */     gridBagConstraints.weightx = 0.5D;
/* 2650 */     this.jPanel11.add(this.jComboBox4, gridBagConstraints);
/*      */     
/* 2652 */     this.jTextField24.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2653 */     this.jTextField24.setText("ciud");
/* 2654 */     this.jTextField24.setEnabled(false);
/* 2655 */     this.jTextField24.setNextFocusableComponent(this.jComboBox4);
/* 2656 */     this.jTextField24.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2658 */             AltaOperador.this.jTextField24KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2662 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/* 2663 */     this.jPanel57.setLayout(jPanel57Layout);
/* 2664 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/* 2665 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2666 */         .addGroup(jPanel57Layout.createSequentialGroup()
/* 2667 */           .addComponent(this.jTextField24, -1, 198, 32767)
/* 2668 */           .addGap(26, 26, 26)));
/*      */     
/* 2670 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/* 2671 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2672 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
/* 2673 */           .addGap(4, 4, 4)
/* 2674 */           .addComponent(this.jTextField24, -2, -1, -2)));
/*      */ 
/*      */     
/* 2677 */     gridBagConstraints = new GridBagConstraints();
/* 2678 */     gridBagConstraints.gridx = 6;
/* 2679 */     gridBagConstraints.gridy = 10;
/* 2680 */     gridBagConstraints.fill = 2;
/* 2681 */     this.jPanel11.add(this.jPanel57, gridBagConstraints);
/*      */     
/* 2683 */     this.jButton39.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 2684 */     this.jButton39.setMnemonic('F');
/* 2685 */     this.jButton39.setToolTipText("Filtrar información (Alt+F)");
/* 2686 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2688 */             AltaOperador.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2692 */     this.jTextField22.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2693 */     this.jTextField22.setText("col");
/* 2694 */     this.jTextField22.setEnabled(false);
/* 2695 */     this.jTextField22.setNextFocusableComponent(this.jTextField24);
/* 2696 */     this.jTextField22.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2698 */             AltaOperador.this.jTextField22KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2702 */     GroupLayout jPanel58Layout = new GroupLayout(this.jPanel58);
/* 2703 */     this.jPanel58.setLayout(jPanel58Layout);
/* 2704 */     jPanel58Layout.setHorizontalGroup(jPanel58Layout
/* 2705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2706 */         .addGroup(jPanel58Layout.createSequentialGroup()
/* 2707 */           .addComponent(this.jTextField22, -1, 198, 32767)
/* 2708 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2709 */           .addComponent(this.jButton39, -2, 20, -2)
/* 2710 */           .addGap(0, 0, 0)));
/*      */     
/* 2712 */     jPanel58Layout.setVerticalGroup(jPanel58Layout
/* 2713 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2714 */         .addGroup(jPanel58Layout.createSequentialGroup()
/* 2715 */           .addGroup(jPanel58Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2716 */             .addComponent(this.jTextField22, -2, -1, -2)
/* 2717 */             .addComponent(this.jButton39, -2, 24, -2))
/* 2718 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/* 2721 */     gridBagConstraints = new GridBagConstraints();
/* 2722 */     gridBagConstraints.gridx = 6;
/* 2723 */     gridBagConstraints.gridy = 6;
/* 2724 */     gridBagConstraints.fill = 2;
/* 2725 */     this.jPanel11.add(this.jPanel58, gridBagConstraints);
/*      */     
/* 2727 */     this.jButton40.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 2728 */     this.jButton40.setMnemonic('F');
/* 2729 */     this.jButton40.setToolTipText("Filtrar información (Alt+F)");
/* 2730 */     this.jButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2732 */             AltaOperador.this.jButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2736 */     this.jTextField23.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2737 */     this.jTextField23.setText("cod");
/* 2738 */     this.jTextField23.setNextFocusableComponent(this.jTextField20);
/* 2739 */     this.jTextField23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2741 */             AltaOperador.this.jTextField23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2744 */     this.jTextField23.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2746 */             AltaOperador.this.jTextField23KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2750 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/* 2751 */     this.jPanel60.setLayout(jPanel60Layout);
/* 2752 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/* 2753 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2754 */         .addGroup(jPanel60Layout.createSequentialGroup()
/* 2755 */           .addComponent(this.jTextField23, -1, 271, 32767)
/* 2756 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2757 */           .addComponent(this.jButton40, -2, 20, -2)
/* 2758 */           .addGap(0, 0, 0)));
/*      */     
/* 2760 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/* 2761 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2762 */         .addGroup(jPanel60Layout.createSequentialGroup()
/* 2763 */           .addGroup(jPanel60Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2764 */             .addComponent(this.jTextField23, -2, -1, -2)
/* 2765 */             .addComponent(this.jButton40, -2, 24, -2))
/* 2766 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/* 2769 */     gridBagConstraints = new GridBagConstraints();
/* 2770 */     gridBagConstraints.gridx = 4;
/* 2771 */     gridBagConstraints.gridy = 0;
/* 2772 */     gridBagConstraints.gridwidth = 3;
/* 2773 */     gridBagConstraints.fill = 2;
/* 2774 */     this.jPanel11.add(this.jPanel60, gridBagConstraints);
/*      */     
/* 2776 */     this.jTextField20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2777 */     this.jTextField20.setText("calle");
/* 2778 */     this.jTextField20.setEnabled(false);
/* 2779 */     this.jTextField20.setNextFocusableComponent(this.jTextField21);
/* 2780 */     this.jTextField20.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2782 */             AltaOperador.this.jTextField20KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2786 */     this.jLabel2.setText(" ");
/*      */     
/* 2788 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/* 2789 */     this.jPanel61.setLayout(jPanel61Layout);
/* 2790 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/* 2791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2792 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
/* 2793 */           .addComponent(this.jTextField20, -1, 280, 32767)
/* 2794 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2795 */           .addComponent(this.jLabel2, -2, 11, -2)));
/*      */     
/* 2797 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/* 2798 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2799 */         .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2800 */           .addComponent(this.jTextField20, -2, -1, -2)
/* 2801 */           .addComponent(this.jLabel2)));
/*      */ 
/*      */     
/* 2804 */     gridBagConstraints = new GridBagConstraints();
/* 2805 */     gridBagConstraints.gridx = 4;
/* 2806 */     gridBagConstraints.gridy = 2;
/* 2807 */     gridBagConstraints.gridwidth = 3;
/* 2808 */     gridBagConstraints.fill = 2;
/* 2809 */     this.jPanel11.add(this.jPanel61, gridBagConstraints);
/*      */     
/* 2811 */     this.jLabel3.setText(" ");
/*      */     
/* 2813 */     this.jTextField21.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2814 */     this.jTextField21.setText("num");
/* 2815 */     this.jTextField21.setEnabled(false);
/* 2816 */     this.jTextField21.setNextFocusableComponent(this.jTextField22);
/* 2817 */     this.jTextField21.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2819 */             AltaOperador.this.jTextField21KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2823 */     GroupLayout jPanel64Layout = new GroupLayout(this.jPanel64);
/* 2824 */     this.jPanel64.setLayout(jPanel64Layout);
/* 2825 */     jPanel64Layout.setHorizontalGroup(jPanel64Layout
/* 2826 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2827 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
/* 2828 */           .addComponent(this.jTextField21, -1, 280, 32767)
/* 2829 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2830 */           .addComponent(this.jLabel3, -2, 11, -2)));
/*      */     
/* 2832 */     jPanel64Layout.setVerticalGroup(jPanel64Layout
/* 2833 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2834 */         .addGroup(jPanel64Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2835 */           .addComponent(this.jLabel3)
/* 2836 */           .addComponent(this.jTextField21, -2, -1, -2)));
/*      */ 
/*      */     
/* 2839 */     gridBagConstraints = new GridBagConstraints();
/* 2840 */     gridBagConstraints.gridx = 4;
/* 2841 */     gridBagConstraints.gridy = 4;
/* 2842 */     gridBagConstraints.gridwidth = 3;
/* 2843 */     gridBagConstraints.fill = 2;
/* 2844 */     this.jPanel11.add(this.jPanel64, gridBagConstraints);
/*      */     
/* 2846 */     this.jTextField1.setText("jTextField1");
/* 2847 */     this.jTextField1.setEnabled(false);
/* 2848 */     gridBagConstraints = new GridBagConstraints();
/* 2849 */     gridBagConstraints.gridx = 4;
/* 2850 */     gridBagConstraints.gridy = 6;
/* 2851 */     this.jPanel11.add(this.jTextField1, gridBagConstraints);
/*      */     
/* 2853 */     this.jTextField2.setText("jTextField2");
/* 2854 */     this.jTextField2.setEnabled(false);
/* 2855 */     gridBagConstraints = new GridBagConstraints();
/* 2856 */     gridBagConstraints.gridx = 4;
/* 2857 */     gridBagConstraints.gridy = 10;
/* 2858 */     this.jPanel11.add(this.jTextField2, gridBagConstraints);
/*      */     
/* 2860 */     this.jTextField3.setText("jTextField3");
/* 2861 */     this.jTextField3.setEnabled(false);
/* 2862 */     gridBagConstraints = new GridBagConstraints();
/* 2863 */     gridBagConstraints.gridx = 4;
/* 2864 */     gridBagConstraints.gridy = 12;
/* 2865 */     this.jPanel11.add(this.jTextField3, gridBagConstraints);
/*      */     
/* 2867 */     this.jLabel54.setFont(new Font("Cantarell", 1, 11));
/* 2868 */     this.jLabel54.setText("Localidad");
/* 2869 */     gridBagConstraints = new GridBagConstraints();
/* 2870 */     gridBagConstraints.gridx = 2;
/* 2871 */     gridBagConstraints.gridy = 8;
/* 2872 */     gridBagConstraints.fill = 2;
/* 2873 */     gridBagConstraints.ipadx = 40;
/* 2874 */     gridBagConstraints.weightx = 0.1D;
/* 2875 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2876 */     this.jPanel11.add(this.jLabel54, gridBagConstraints);
/*      */     
/* 2878 */     this.jTextField4.setText("jTextField4");
/* 2879 */     this.jTextField4.setEnabled(false);
/* 2880 */     gridBagConstraints = new GridBagConstraints();
/* 2881 */     gridBagConstraints.gridx = 4;
/* 2882 */     gridBagConstraints.gridy = 8;
/* 2883 */     this.jPanel11.add(this.jTextField4, gridBagConstraints);
/*      */     
/* 2885 */     this.jButton41.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 2886 */     this.jButton41.setMnemonic('F');
/* 2887 */     this.jButton41.setToolTipText("Filtrar información (Alt+F)");
/* 2888 */     this.jButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2890 */             AltaOperador.this.jButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2894 */     this.jTextField31.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2895 */     this.jTextField31.setText("localidad");
/* 2896 */     this.jTextField31.setEnabled(false);
/* 2897 */     this.jTextField31.setNextFocusableComponent(this.jTextField24);
/* 2898 */     this.jTextField31.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2900 */             AltaOperador.this.jTextField31KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2904 */     GroupLayout jPanel65Layout = new GroupLayout(this.jPanel65);
/* 2905 */     this.jPanel65.setLayout(jPanel65Layout);
/* 2906 */     jPanel65Layout.setHorizontalGroup(jPanel65Layout
/* 2907 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2908 */         .addGroup(jPanel65Layout.createSequentialGroup()
/* 2909 */           .addComponent(this.jTextField31, -1, 198, 32767)
/* 2910 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2911 */           .addComponent(this.jButton41, -2, 20, -2)
/* 2912 */           .addGap(0, 0, 0)));
/*      */     
/* 2914 */     jPanel65Layout.setVerticalGroup(jPanel65Layout
/* 2915 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2916 */         .addGroup(jPanel65Layout.createSequentialGroup()
/* 2917 */           .addGroup(jPanel65Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2918 */             .addComponent(this.jTextField31, -2, -1, -2)
/* 2919 */             .addComponent(this.jButton41, -2, 24, -2))
/* 2920 */           .addGap(1, 1, 1)));
/*      */ 
/*      */     
/* 2923 */     gridBagConstraints = new GridBagConstraints();
/* 2924 */     gridBagConstraints.gridx = 6;
/* 2925 */     gridBagConstraints.gridy = 8;
/* 2926 */     gridBagConstraints.fill = 2;
/* 2927 */     this.jPanel11.add(this.jPanel65, gridBagConstraints);
/*      */     
/* 2929 */     GridBagLayout jPanel33Layout = new GridBagLayout();
/* 2930 */     jPanel33Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2931 */     jPanel33Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2932 */     this.jPanel33.setLayout(jPanel33Layout);
/*      */     
/* 2934 */     this.jLabel74.setFont(new Font("Cantarell", 1, 11));
/* 2935 */     this.jLabel74.setText("Contratado por");
/* 2936 */     gridBagConstraints = new GridBagConstraints();
/* 2937 */     gridBagConstraints.gridx = 2;
/* 2938 */     gridBagConstraints.gridy = 2;
/* 2939 */     gridBagConstraints.fill = 2;
/* 2940 */     gridBagConstraints.anchor = 13;
/* 2941 */     gridBagConstraints.weightx = 0.1D;
/* 2942 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2943 */     this.jPanel33.add(this.jLabel74, gridBagConstraints);
/*      */     
/* 2945 */     this.jTextField40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2946 */     this.jTextField40.setNextFocusableComponent(this.jTextField37);
/* 2947 */     this.jTextField40.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2949 */             AltaOperador.this.jTextField40KeyReleased(evt);
/*      */           }
/*      */         });
/* 2952 */     gridBagConstraints = new GridBagConstraints();
/* 2953 */     gridBagConstraints.gridx = 4;
/* 2954 */     gridBagConstraints.gridy = 2;
/* 2955 */     gridBagConstraints.fill = 2;
/* 2956 */     gridBagConstraints.anchor = 17;
/* 2957 */     gridBagConstraints.weightx = 0.5D;
/* 2958 */     this.jPanel33.add(this.jTextField40, gridBagConstraints);
/*      */     
/* 2960 */     this.jLabel29.setFont(new Font("Cantarell", 0, 11));
/* 2961 */     this.jLabel29.setText("Testigo 1");
/* 2962 */     gridBagConstraints = new GridBagConstraints();
/* 2963 */     gridBagConstraints.gridx = 2;
/* 2964 */     gridBagConstraints.gridy = 4;
/* 2965 */     gridBagConstraints.fill = 2;
/* 2966 */     gridBagConstraints.weightx = 0.1D;
/* 2967 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2968 */     this.jPanel33.add(this.jLabel29, gridBagConstraints);
/*      */     
/* 2970 */     this.jTextField37.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2971 */     this.jTextField37.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2973 */             AltaOperador.this.jTextField37KeyReleased(evt);
/*      */           }
/*      */         });
/* 2976 */     gridBagConstraints = new GridBagConstraints();
/* 2977 */     gridBagConstraints.gridx = 4;
/* 2978 */     gridBagConstraints.gridy = 4;
/* 2979 */     gridBagConstraints.fill = 2;
/* 2980 */     gridBagConstraints.anchor = 17;
/* 2981 */     gridBagConstraints.weightx = 0.5D;
/* 2982 */     this.jPanel33.add(this.jTextField37, gridBagConstraints);
/*      */     
/* 2984 */     this.jLabel75.setFont(new Font("Cantarell", 0, 11));
/* 2985 */     this.jLabel75.setText("Testigo 2");
/* 2986 */     gridBagConstraints = new GridBagConstraints();
/* 2987 */     gridBagConstraints.gridx = 2;
/* 2988 */     gridBagConstraints.gridy = 6;
/* 2989 */     gridBagConstraints.fill = 2;
/* 2990 */     gridBagConstraints.weightx = 0.1D;
/* 2991 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 2992 */     this.jPanel33.add(this.jLabel75, gridBagConstraints);
/*      */     
/* 2994 */     this.jTextField38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2995 */     this.jTextField38.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2997 */             AltaOperador.this.jTextField38KeyReleased(evt);
/*      */           }
/*      */         });
/* 3000 */     gridBagConstraints = new GridBagConstraints();
/* 3001 */     gridBagConstraints.gridx = 4;
/* 3002 */     gridBagConstraints.gridy = 6;
/* 3003 */     gridBagConstraints.fill = 2;
/* 3004 */     gridBagConstraints.anchor = 17;
/* 3005 */     gridBagConstraints.weightx = 0.5D;
/* 3006 */     this.jPanel33.add(this.jTextField38, gridBagConstraints);
/*      */     
/* 3008 */     this.jLabel76.setFont(new Font("Cantarell", 0, 11));
/* 3009 */     this.jLabel76.setText("Recomendado por");
/* 3010 */     gridBagConstraints = new GridBagConstraints();
/* 3011 */     gridBagConstraints.gridx = 2;
/* 3012 */     gridBagConstraints.gridy = 8;
/* 3013 */     gridBagConstraints.fill = 2;
/* 3014 */     gridBagConstraints.weightx = 0.1D;
/* 3015 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3016 */     this.jPanel33.add(this.jLabel76, gridBagConstraints);
/*      */     
/* 3018 */     this.jTextField39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3019 */     this.jTextField39.setNextFocusableComponent(this.jFormattedTextField7);
/* 3020 */     this.jTextField39.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3022 */             AltaOperador.this.jTextField39KeyReleased(evt);
/*      */           }
/*      */         });
/* 3025 */     gridBagConstraints = new GridBagConstraints();
/* 3026 */     gridBagConstraints.gridx = 4;
/* 3027 */     gridBagConstraints.gridy = 8;
/* 3028 */     gridBagConstraints.fill = 2;
/* 3029 */     gridBagConstraints.anchor = 17;
/* 3030 */     gridBagConstraints.weightx = 0.5D;
/* 3031 */     this.jPanel33.add(this.jTextField39, gridBagConstraints);
/*      */     
/* 3033 */     this.jLabel30.setFont(new Font("Cantarell", 0, 11));
/* 3034 */     this.jLabel30.setText("Salario  Nominal");
/* 3035 */     gridBagConstraints = new GridBagConstraints();
/* 3036 */     gridBagConstraints.gridx = 2;
/* 3037 */     gridBagConstraints.gridy = 10;
/* 3038 */     gridBagConstraints.fill = 2;
/* 3039 */     gridBagConstraints.weightx = 0.1D;
/* 3040 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3041 */     this.jPanel33.add(this.jLabel30, gridBagConstraints);
/*      */     
/* 3043 */     this.jFormattedTextField7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3044 */     gridBagConstraints = new GridBagConstraints();
/* 3045 */     gridBagConstraints.gridx = 4;
/* 3046 */     gridBagConstraints.gridy = 10;
/* 3047 */     gridBagConstraints.fill = 2;
/* 3048 */     gridBagConstraints.anchor = 17;
/* 3049 */     gridBagConstraints.weightx = 0.5D;
/* 3050 */     this.jPanel33.add(this.jFormattedTextField7, gridBagConstraints);
/*      */     
/* 3052 */     this.jLabel71.setFont(new Font("Cantarell", 0, 11));
/* 3053 */     this.jLabel71.setText("Etiquetar");
/* 3054 */     gridBagConstraints = new GridBagConstraints();
/* 3055 */     gridBagConstraints.gridx = 2;
/* 3056 */     gridBagConstraints.gridy = 12;
/* 3057 */     gridBagConstraints.fill = 2;
/* 3058 */     gridBagConstraints.weightx = 0.1D;
/* 3059 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3060 */     this.jPanel33.add(this.jLabel71, gridBagConstraints);
/*      */     
/* 3062 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 3063 */     this.jComboBox7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3064 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "VACÍO", "A PRUEBA", "MALO", "NO CONTRATABLE", "BUENO", "MUY BUENO", "EXCELENTE" }));
/* 3065 */     this.jComboBox7.setNextFocusableComponent(this.jSpinner1);
/* 3066 */     gridBagConstraints = new GridBagConstraints();
/* 3067 */     gridBagConstraints.gridx = 4;
/* 3068 */     gridBagConstraints.gridy = 12;
/* 3069 */     gridBagConstraints.fill = 2;
/* 3070 */     gridBagConstraints.anchor = 17;
/* 3071 */     gridBagConstraints.weightx = 0.5D;
/* 3072 */     this.jPanel33.add(this.jComboBox7, gridBagConstraints);
/*      */     
/* 3074 */     this.jLabel27.setFont(new Font("Cantarell", 0, 11));
/* 3075 */     this.jLabel27.setText("Contratado por (Días)");
/* 3076 */     gridBagConstraints = new GridBagConstraints();
/* 3077 */     gridBagConstraints.gridx = 2;
/* 3078 */     gridBagConstraints.gridy = 14;
/* 3079 */     gridBagConstraints.fill = 2;
/* 3080 */     gridBagConstraints.weightx = 0.1D;
/* 3081 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3082 */     this.jPanel33.add(this.jLabel27, gridBagConstraints);
/*      */     
/* 3084 */     this.jSpinner1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3085 */     this.jSpinner1.setModel(new SpinnerNumberModel(28, 28, 730, 1));
/* 3086 */     gridBagConstraints = new GridBagConstraints();
/* 3087 */     gridBagConstraints.gridx = 4;
/* 3088 */     gridBagConstraints.gridy = 14;
/* 3089 */     gridBagConstraints.fill = 2;
/* 3090 */     gridBagConstraints.anchor = 17;
/* 3091 */     gridBagConstraints.weightx = 0.5D;
/* 3092 */     this.jPanel33.add(this.jSpinner1, gridBagConstraints);
/*      */     
/* 3094 */     this.jLabel61.setFont(new Font("Cantarell", 0, 11));
/* 3095 */     this.jLabel61.setText("Fecha de Ingreso");
/* 3096 */     gridBagConstraints = new GridBagConstraints();
/* 3097 */     gridBagConstraints.gridx = 2;
/* 3098 */     gridBagConstraints.gridy = 16;
/* 3099 */     gridBagConstraints.fill = 2;
/* 3100 */     gridBagConstraints.weightx = 0.1D;
/* 3101 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3102 */     this.jPanel33.add(this.jLabel61, gridBagConstraints);
/*      */     
/* 3104 */     this.jDateChooser4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3105 */     this.jDateChooser4.setIcon(this.icon);
/* 3106 */     this.jDateChooser4.setNextFocusableComponent(this.jFormattedTextField4);
/* 3107 */     gridBagConstraints = new GridBagConstraints();
/* 3108 */     gridBagConstraints.gridx = 4;
/* 3109 */     gridBagConstraints.gridy = 16;
/* 3110 */     gridBagConstraints.fill = 2;
/* 3111 */     gridBagConstraints.anchor = 17;
/* 3112 */     gridBagConstraints.weightx = 0.5D;
/* 3113 */     this.jPanel33.add((Component)this.jDateChooser4, gridBagConstraints);
/*      */     
/* 3115 */     this.jLabel72.setFont(new Font("Cantarell", 0, 11));
/* 3116 */     this.jLabel72.setText("Última fecha de ingreso");
/* 3117 */     gridBagConstraints = new GridBagConstraints();
/* 3118 */     gridBagConstraints.gridx = 2;
/* 3119 */     gridBagConstraints.gridy = 18;
/* 3120 */     gridBagConstraints.fill = 2;
/* 3121 */     gridBagConstraints.weightx = 0.1D;
/* 3122 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3123 */     this.jPanel33.add(this.jLabel72, gridBagConstraints);
/*      */     
/* 3125 */     this.jDateChooser6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3126 */     this.jDateChooser6.setIcon(this.icon);
/* 3127 */     this.jDateChooser6.setNextFocusableComponent(this.jComboBox6);
/* 3128 */     gridBagConstraints = new GridBagConstraints();
/* 3129 */     gridBagConstraints.gridx = 4;
/* 3130 */     gridBagConstraints.gridy = 18;
/* 3131 */     gridBagConstraints.fill = 2;
/* 3132 */     gridBagConstraints.anchor = 17;
/* 3133 */     gridBagConstraints.weightx = 0.5D;
/* 3134 */     this.jPanel33.add((Component)this.jDateChooser6, gridBagConstraints);
/*      */     
/* 3136 */     GridBagLayout jPanel28Layout = new GridBagLayout();
/* 3137 */     jPanel28Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 3138 */     jPanel28Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3139 */     this.jPanel28.setLayout(jPanel28Layout);
/*      */     
/* 3141 */     this.jLabel50.setFont(new Font("Cantarell", 1, 11));
/* 3142 */     this.jLabel50.setText("Número de Licencia");
/* 3143 */     gridBagConstraints = new GridBagConstraints();
/* 3144 */     gridBagConstraints.gridx = 2;
/* 3145 */     gridBagConstraints.gridy = 12;
/* 3146 */     gridBagConstraints.fill = 2;
/* 3147 */     gridBagConstraints.anchor = 21;
/* 3148 */     gridBagConstraints.weightx = 0.1D;
/* 3149 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3150 */     this.jPanel28.add(this.jLabel50, gridBagConstraints);
/*      */     
/* 3152 */     this.jTextField27.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3153 */     this.jTextField27.setNextFocusableComponent(this.jComboBox5);
/* 3154 */     this.jTextField27.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3156 */             AltaOperador.this.jTextField27KeyReleased(evt);
/*      */           }
/*      */         });
/* 3159 */     gridBagConstraints = new GridBagConstraints();
/* 3160 */     gridBagConstraints.gridx = 4;
/* 3161 */     gridBagConstraints.gridy = 12;
/* 3162 */     gridBagConstraints.fill = 2;
/* 3163 */     gridBagConstraints.weightx = 0.5D;
/* 3164 */     this.jPanel28.add(this.jTextField27, gridBagConstraints);
/*      */     
/* 3166 */     this.jLabel23.setFont(new Font("Cantarell", 0, 11));
/* 3167 */     this.jLabel23.setText("Tipo de Licencia");
/* 3168 */     gridBagConstraints = new GridBagConstraints();
/* 3169 */     gridBagConstraints.gridx = 2;
/* 3170 */     gridBagConstraints.gridy = 14;
/* 3171 */     gridBagConstraints.fill = 2;
/* 3172 */     gridBagConstraints.anchor = 21;
/* 3173 */     gridBagConstraints.weightx = 0.1D;
/* 3174 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3175 */     this.jPanel28.add(this.jLabel23, gridBagConstraints);
/*      */     
/* 3177 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 3178 */     this.jComboBox5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3179 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "E", "B", "BA", "BE", "OTRA" }));
/* 3180 */     this.jComboBox5.setNextFocusableComponent((Component)this.jDateChooser7);
/* 3181 */     gridBagConstraints = new GridBagConstraints();
/* 3182 */     gridBagConstraints.gridx = 4;
/* 3183 */     gridBagConstraints.gridy = 14;
/* 3184 */     gridBagConstraints.fill = 2;
/* 3185 */     gridBagConstraints.weightx = 0.5D;
/* 3186 */     this.jPanel28.add(this.jComboBox5, gridBagConstraints);
/*      */     
/* 3188 */     this.jLabel37.setFont(new Font("Cantarell", 0, 11));
/* 3189 */     this.jLabel37.setText("Vigencia de la Licencia");
/* 3190 */     gridBagConstraints = new GridBagConstraints();
/* 3191 */     gridBagConstraints.gridx = 2;
/* 3192 */     gridBagConstraints.gridy = 16;
/* 3193 */     gridBagConstraints.fill = 2;
/* 3194 */     gridBagConstraints.anchor = 21;
/* 3195 */     gridBagConstraints.weightx = 0.1D;
/* 3196 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3197 */     this.jPanel28.add(this.jLabel37, gridBagConstraints);
/*      */     
/* 3199 */     this.jDateChooser7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3200 */     this.jDateChooser7.setIcon(this.icon);
/* 3201 */     this.jDateChooser7.setNextFocusableComponent(this.jTextArea1);
/* 3202 */     gridBagConstraints = new GridBagConstraints();
/* 3203 */     gridBagConstraints.gridx = 4;
/* 3204 */     gridBagConstraints.gridy = 16;
/* 3205 */     gridBagConstraints.fill = 2;
/* 3206 */     gridBagConstraints.weightx = 0.5D;
/* 3207 */     this.jPanel28.add((Component)this.jDateChooser7, gridBagConstraints);
/*      */     
/* 3209 */     this.jLabel26.setFont(new Font("Cantarell", 0, 11));
/* 3210 */     this.jLabel26.setText("Especializado en");
/* 3211 */     gridBagConstraints = new GridBagConstraints();
/* 3212 */     gridBagConstraints.gridx = 2;
/* 3213 */     gridBagConstraints.gridy = 6;
/* 3214 */     gridBagConstraints.fill = 2;
/* 3215 */     gridBagConstraints.anchor = 21;
/* 3216 */     gridBagConstraints.weightx = 0.1D;
/* 3217 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3218 */     this.jPanel28.add(this.jLabel26, gridBagConstraints);
/*      */     
/* 3220 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 3221 */     this.jComboBox8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3222 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "GÓNDOLA", "PIPA", "BULLDOZER", "CAMA BAJA", "CAMIONETA", "CONTENEDOR MARINO", "CUELLO DE GANZO", "EXCAVADORA ORUGA", "HIAB", "LOWBOY", "PLANA", "PLATAFORMA", "PRESAS METÁLICAS", "PRESIÓN Y VACÍO", "PORTA CONTENEDORES", "RETROEXCAVADORA", "TIRO DIRECTO", "TOLVA GRANELERA", "TOLVA DE ALUMNIO", "TOLVA DE ACERO INOXIDABLE", "TOLVA PRESURIZADA", "UTILITARIO", "OTRO", "TODOS" }));
/* 3223 */     this.jComboBox8.setNextFocusableComponent(this.jTextField30);
/* 3224 */     gridBagConstraints = new GridBagConstraints();
/* 3225 */     gridBagConstraints.gridx = 4;
/* 3226 */     gridBagConstraints.gridy = 6;
/* 3227 */     gridBagConstraints.fill = 2;
/* 3228 */     gridBagConstraints.weightx = 0.5D;
/* 3229 */     this.jPanel28.add(this.jComboBox8, gridBagConstraints);
/*      */     
/* 3231 */     this.jLabel67.setFont(new Font("Cantarell", 0, 11));
/* 3232 */     this.jLabel67.setText("Tractor");
/* 3233 */     gridBagConstraints = new GridBagConstraints();
/* 3234 */     gridBagConstraints.gridx = 2;
/* 3235 */     gridBagConstraints.gridy = 8;
/* 3236 */     gridBagConstraints.fill = 2;
/* 3237 */     gridBagConstraints.anchor = 21;
/* 3238 */     gridBagConstraints.weightx = 0.1D;
/* 3239 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3240 */     this.jPanel28.add(this.jLabel67, gridBagConstraints);
/*      */     
/* 3242 */     this.jTextField30.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3243 */     this.jTextField30.setNextFocusableComponent(this.jComboBox10);
/* 3244 */     this.jTextField30.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3246 */             AltaOperador.this.jTextField30KeyReleased(evt);
/*      */           }
/*      */         });
/* 3249 */     gridBagConstraints = new GridBagConstraints();
/* 3250 */     gridBagConstraints.gridx = 4;
/* 3251 */     gridBagConstraints.gridy = 8;
/* 3252 */     gridBagConstraints.fill = 2;
/* 3253 */     gridBagConstraints.weightx = 0.5D;
/* 3254 */     this.jPanel28.add(this.jTextField30, gridBagConstraints);
/*      */     
/* 3256 */     this.jTextField35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3257 */     this.jTextField35.setNextFocusableComponent(this.jComboBox9);
/* 3258 */     this.jTextField35.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3260 */             AltaOperador.this.jTextField35KeyReleased(evt);
/*      */           }
/*      */         });
/* 3263 */     gridBagConstraints = new GridBagConstraints();
/* 3264 */     gridBagConstraints.gridx = 4;
/* 3265 */     gridBagConstraints.gridy = 2;
/* 3266 */     gridBagConstraints.fill = 2;
/* 3267 */     gridBagConstraints.weightx = 0.5D;
/* 3268 */     this.jPanel28.add(this.jTextField35, gridBagConstraints);
/*      */     
/* 3270 */     this.jLabel68.setFont(new Font("Cantarell", 0, 11));
/* 3271 */     this.jLabel68.setText("Remolque");
/* 3272 */     gridBagConstraints = new GridBagConstraints();
/* 3273 */     gridBagConstraints.gridx = 2;
/* 3274 */     gridBagConstraints.gridy = 2;
/* 3275 */     gridBagConstraints.fill = 2;
/* 3276 */     gridBagConstraints.anchor = 21;
/* 3277 */     gridBagConstraints.weightx = 0.1D;
/* 3278 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3279 */     this.jPanel28.add(this.jLabel68, gridBagConstraints);
/*      */     
/* 3281 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/* 3282 */     this.jLabel52.setText("Tipo");
/* 3283 */     gridBagConstraints = new GridBagConstraints();
/* 3284 */     gridBagConstraints.gridx = 2;
/* 3285 */     gridBagConstraints.gridy = 4;
/* 3286 */     gridBagConstraints.fill = 2;
/* 3287 */     gridBagConstraints.anchor = 21;
/* 3288 */     gridBagConstraints.weightx = 0.1D;
/* 3289 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3290 */     this.jPanel28.add(this.jLabel52, gridBagConstraints);
/*      */     
/* 3292 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 3293 */     this.jComboBox9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3294 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "OPERADOR", "FUNCIONARIO" }));
/* 3295 */     this.jComboBox9.setNextFocusableComponent(this.jComboBox8);
/* 3296 */     gridBagConstraints = new GridBagConstraints();
/* 3297 */     gridBagConstraints.gridx = 4;
/* 3298 */     gridBagConstraints.gridy = 4;
/* 3299 */     gridBagConstraints.fill = 2;
/* 3300 */     gridBagConstraints.weightx = 0.5D;
/* 3301 */     this.jPanel28.add(this.jComboBox9, gridBagConstraints);
/*      */     
/* 3303 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 3304 */     this.jLabel53.setText("Asignación");
/* 3305 */     gridBagConstraints = new GridBagConstraints();
/* 3306 */     gridBagConstraints.gridx = 2;
/* 3307 */     gridBagConstraints.gridy = 10;
/* 3308 */     gridBagConstraints.fill = 2;
/* 3309 */     gridBagConstraints.anchor = 21;
/* 3310 */     gridBagConstraints.weightx = 0.1D;
/* 3311 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3312 */     this.jPanel28.add(this.jLabel53, gridBagConstraints);
/*      */     
/* 3314 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 3315 */     this.jComboBox10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3316 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "FLETES", "RENTAS", "RETROS" }));
/* 3317 */     this.jComboBox10.setNextFocusableComponent(this.jTextField27);
/* 3318 */     gridBagConstraints = new GridBagConstraints();
/* 3319 */     gridBagConstraints.gridx = 4;
/* 3320 */     gridBagConstraints.gridy = 10;
/* 3321 */     gridBagConstraints.fill = 2;
/* 3322 */     gridBagConstraints.weightx = 0.5D;
/* 3323 */     this.jPanel28.add(this.jComboBox10, gridBagConstraints);
/*      */     
/* 3325 */     this.jLabel31.setFont(new Font("Cantarell", 0, 11));
/* 3326 */     this.jLabel31.setText("Ingresa otros datos:");
/* 3327 */     gridBagConstraints = new GridBagConstraints();
/* 3328 */     gridBagConstraints.gridx = 2;
/* 3329 */     gridBagConstraints.gridy = 18;
/* 3330 */     gridBagConstraints.fill = 2;
/* 3331 */     gridBagConstraints.anchor = 21;
/* 3332 */     gridBagConstraints.weightx = 0.1D;
/* 3333 */     gridBagConstraints.insets = new Insets(0, 15, 0, 0);
/* 3334 */     this.jPanel28.add(this.jLabel31, gridBagConstraints);
/*      */     
/* 3336 */     this.jTextArea1.setColumns(20);
/* 3337 */     this.jTextArea1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3338 */     this.jTextArea1.setLineWrap(true);
/* 3339 */     this.jTextArea1.setRows(3);
/* 3340 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*      */     
/* 3342 */     gridBagConstraints = new GridBagConstraints();
/* 3343 */     gridBagConstraints.gridx = 4;
/* 3344 */     gridBagConstraints.gridy = 18;
/* 3345 */     gridBagConstraints.gridheight = 5;
/* 3346 */     gridBagConstraints.fill = 1;
/* 3347 */     gridBagConstraints.ipady = 40;
/* 3348 */     gridBagConstraints.weightx = 0.5D;
/* 3349 */     this.jPanel28.add(this.jScrollPane1, gridBagConstraints);
/*      */     
/* 3351 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 3352 */     this.jPanel4.setLayout(jPanel4Layout);
/* 3353 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 3354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3355 */         .addGap(0, 455, 32767));
/*      */     
/* 3357 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 3358 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3359 */         .addGap(0, 203, 32767));
/*      */ 
/*      */     
/* 3362 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 3363 */     this.jPanel1.setLayout(jPanel1Layout);
/* 3364 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 3365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3366 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 3367 */           .addContainerGap()
/* 3368 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 3369 */           .addContainerGap(179, 32767)));
/*      */     
/* 3371 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 3372 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3373 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 3374 */           .addContainerGap()
/* 3375 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 3376 */           .addContainerGap(212, 32767)));
/*      */ 
/*      */     
/* 3379 */     this.materialButton20.setBackground(this.lc.SECUNDARIO1);
/* 3380 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 3381 */     this.materialButton20.setMnemonic('R');
/* 3382 */     this.materialButton20.setText("Resteblecer");
/* 3383 */     this.materialButton20.setToolTipText("Restablecer (Alt+R)");
/* 3384 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 3385 */     this.materialButton20.setHorizontalTextPosition(0);
/* 3386 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3388 */             AltaOperador.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3392 */     this.jPanel24.setBackground(this.lc.SECUNDARIO2);
/* 3393 */     this.jPanel24.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*      */     
/* 3395 */     this.jPanel26.setBackground(this.lc.SECUNDARIO2);
/* 3396 */     this.jPanel26.setMinimumSize(new Dimension(912, 44));
/* 3397 */     this.jPanel26.setPreferredSize(new Dimension(912, 44));
/*      */     
/* 3399 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 3400 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 3401 */     this.materialButton1.setMnemonic('G');
/* 3402 */     this.materialButton1.setText("Guardar");
/* 3403 */     this.materialButton1.setToolTipText("Guardar (Alt+G)");
/* 3404 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 3405 */     this.materialButton1.setHorizontalTextPosition(0);
/* 3406 */     this.materialButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3408 */             AltaOperador.this.materialButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3412 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/* 3413 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 3414 */     this.materialButton22.setMnemonic('F');
/* 3415 */     this.materialButton22.setText("Foto");
/* 3416 */     this.materialButton22.setToolTipText("Foto (Alt+F)");
/* 3417 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 3418 */     this.materialButton22.setHorizontalTextPosition(0);
/* 3419 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3421 */             AltaOperador.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3425 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/* 3426 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 3427 */     this.materialButton19.setMnemonic('I');
/* 3428 */     this.materialButton19.setText("Imprimir");
/* 3429 */     this.materialButton19.setToolTipText("Imprimir (Alt+I)");
/* 3430 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 3431 */     this.materialButton19.setHorizontalTextPosition(0);
/* 3432 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3434 */             AltaOperador.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3438 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 3439 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 3440 */     this.materialButton21.setMnemonic('C');
/* 3441 */     this.materialButton21.setText("Cerrar");
/* 3442 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/* 3443 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 3444 */     this.materialButton21.setHorizontalTextPosition(0);
/* 3445 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3447 */             AltaOperador.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3451 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 3452 */     this.jPanel26.setLayout(jPanel26Layout);
/* 3453 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 3454 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3455 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/* 3456 */           .addContainerGap()
/* 3457 */           .addComponent((Component)this.materialButton22, -2, 105, -2)
/* 3458 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3459 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/* 3460 */           .addGap(117, 117, 117)
/* 3461 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/* 3462 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3463 */           .addComponent((Component)this.materialButton1, -2, 150, -2)));
/*      */     
/* 3465 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 3466 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3467 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/* 3468 */           .addContainerGap(-1, 32767)
/* 3469 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3470 */             .addComponent((Component)this.materialButton1, -2, 38, -2)
/* 3471 */             .addComponent((Component)this.materialButton22, -2, 38, -2)
/* 3472 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/* 3473 */             .addComponent((Component)this.materialButton21, -2, 38, -2))
/* 3474 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3477 */     this.jPanel35.setBackground(new Color(255, 255, 255));
/*      */     
/* 3479 */     this.jPanel76.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 3481 */     this.jLabel57.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*      */     
/* 3483 */     this.jLabel57.setForeground(this.lc.PRIMARIO2);
/* 3484 */     this.jLabel57.setHorizontalAlignment(0);
/* 3485 */     this.jLabel57.setText("       Agregar Operadores");
/*      */     
/* 3487 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 3488 */     this.jLabel9.setToolTipText("Cerrar");
/* 3489 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3491 */             AltaOperador.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3494 */             AltaOperador.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3497 */             AltaOperador.this.jLabel9MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 3501 */     GroupLayout jPanel76Layout = new GroupLayout(this.jPanel76);
/* 3502 */     this.jPanel76.setLayout(jPanel76Layout);
/* 3503 */     jPanel76Layout.setHorizontalGroup(jPanel76Layout
/* 3504 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3505 */         .addGroup(jPanel76Layout.createSequentialGroup()
/* 3506 */           .addComponent(this.jLabel57, -1, -1, 32767)
/* 3507 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3508 */           .addComponent(this.jLabel9)
/* 3509 */           .addContainerGap()));
/*      */     
/* 3511 */     jPanel76Layout.setVerticalGroup(jPanel76Layout
/* 3512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3513 */         .addGroup(jPanel76Layout.createSequentialGroup()
/* 3514 */           .addContainerGap()
/* 3515 */           .addGroup(jPanel76Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3516 */             .addComponent(this.jLabel9, -1, 31, 32767)
/* 3517 */             .addComponent(this.jLabel57, -1, -1, 32767))
/* 3518 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3521 */     this.jPanel31.setBackground(this.lc.TERCERO1);
/* 3522 */     this.jPanel31.setLayout(new GridLayout(1, 6, 20, 0));
/*      */     
/* 3524 */     this.jPanel34.setBackground(this.lc.TERCERO1);
/* 3525 */     this.jPanel34.setLayout(new GridBagLayout());
/*      */     
/* 3527 */     this.jLabel8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*      */     
/* 3529 */     this.jLabel8.setHorizontalAlignment(0);
/* 3530 */     this.jLabel8.setText("Información Personal");
/* 3531 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3533 */             AltaOperador.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3536 */             AltaOperador.this.jLabel8MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3539 */             AltaOperador.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */         });
/* 3542 */     gridBagConstraints = new GridBagConstraints();
/* 3543 */     gridBagConstraints.gridx = 0;
/* 3544 */     gridBagConstraints.gridy = 0;
/* 3545 */     this.jPanel34.add(this.jLabel8, gridBagConstraints);
/*      */     
/* 3547 */     this.jPanel75.setBackground(this.lc.PRIMARIO1);
/* 3548 */     this.jPanel75.setMinimumSize(new Dimension(100, 4));
/* 3549 */     this.jPanel75.setPreferredSize(new Dimension(144, 4));
/*      */     
/* 3551 */     GroupLayout jPanel75Layout = new GroupLayout(this.jPanel75);
/* 3552 */     this.jPanel75.setLayout(jPanel75Layout);
/* 3553 */     jPanel75Layout.setHorizontalGroup(jPanel75Layout
/* 3554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3555 */         .addGap(0, 150, 32767));
/*      */     
/* 3557 */     jPanel75Layout.setVerticalGroup(jPanel75Layout
/* 3558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3559 */         .addGap(0, 4, 32767));
/*      */ 
/*      */     
/* 3562 */     gridBagConstraints = new GridBagConstraints();
/* 3563 */     gridBagConstraints.gridx = 0;
/* 3564 */     gridBagConstraints.gridy = 1;
/* 3565 */     gridBagConstraints.fill = 2;
/* 3566 */     this.jPanel34.add(this.jPanel75, gridBagConstraints);
/*      */     
/* 3568 */     this.jPanel31.add(this.jPanel34);
/*      */     
/* 3570 */     this.jPanel77.setBackground(this.lc.TERCERO1);
/* 3571 */     this.jPanel77.setLayout(new GridBagLayout());
/*      */     
/* 3573 */     this.jLabel10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 3575 */     this.jLabel10.setHorizontalAlignment(0);
/* 3576 */     this.jLabel10.setText("Dirección");
/* 3577 */     this.jLabel10.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3579 */             AltaOperador.this.jLabel10MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3582 */             AltaOperador.this.jLabel10MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3585 */             AltaOperador.this.jLabel10MouseEntered(evt);
/*      */           }
/*      */         });
/* 3588 */     gridBagConstraints = new GridBagConstraints();
/* 3589 */     gridBagConstraints.gridx = 0;
/* 3590 */     gridBagConstraints.gridy = 0;
/* 3591 */     this.jPanel77.add(this.jLabel10, gridBagConstraints);
/*      */     
/* 3593 */     this.jPanel78.setBackground(this.lc.TERCERO1);
/* 3594 */     this.jPanel78.setMinimumSize(new Dimension(100, 4));
/* 3595 */     this.jPanel78.setPreferredSize(new Dimension(144, 4));
/*      */     
/* 3597 */     GroupLayout jPanel78Layout = new GroupLayout(this.jPanel78);
/* 3598 */     this.jPanel78.setLayout(jPanel78Layout);
/* 3599 */     jPanel78Layout.setHorizontalGroup(jPanel78Layout
/* 3600 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3601 */         .addGap(0, 144, 32767));
/*      */     
/* 3603 */     jPanel78Layout.setVerticalGroup(jPanel78Layout
/* 3604 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3605 */         .addGap(0, 4, 32767));
/*      */ 
/*      */     
/* 3608 */     gridBagConstraints = new GridBagConstraints();
/* 3609 */     gridBagConstraints.gridx = 0;
/* 3610 */     gridBagConstraints.gridy = 1;
/* 3611 */     this.jPanel77.add(this.jPanel78, gridBagConstraints);
/*      */     
/* 3613 */     this.jPanel31.add(this.jPanel77);
/*      */     
/* 3615 */     this.jPanel79.setBackground(this.lc.TERCERO1);
/* 3616 */     this.jPanel79.setLayout(new GridBagLayout());
/*      */     
/* 3618 */     this.jLabel13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 3620 */     this.jLabel13.setHorizontalAlignment(0);
/* 3621 */     this.jLabel13.setText("Datos del Contrato");
/* 3622 */     this.jLabel13.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3624 */             AltaOperador.this.jLabel13MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3627 */             AltaOperador.this.jLabel13MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3630 */             AltaOperador.this.jLabel13MouseEntered(evt);
/*      */           }
/*      */         });
/* 3633 */     gridBagConstraints = new GridBagConstraints();
/* 3634 */     gridBagConstraints.gridx = 0;
/* 3635 */     gridBagConstraints.gridy = 0;
/* 3636 */     this.jPanel79.add(this.jLabel13, gridBagConstraints);
/*      */     
/* 3638 */     this.jPanel80.setBackground(this.lc.TERCERO1);
/* 3639 */     this.jPanel80.setMinimumSize(new Dimension(100, 4));
/* 3640 */     this.jPanel80.setPreferredSize(new Dimension(144, 4));
/*      */     
/* 3642 */     GroupLayout jPanel80Layout = new GroupLayout(this.jPanel80);
/* 3643 */     this.jPanel80.setLayout(jPanel80Layout);
/* 3644 */     jPanel80Layout.setHorizontalGroup(jPanel80Layout
/* 3645 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3646 */         .addGap(0, 144, 32767));
/*      */     
/* 3648 */     jPanel80Layout.setVerticalGroup(jPanel80Layout
/* 3649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3650 */         .addGap(0, 4, 32767));
/*      */ 
/*      */     
/* 3653 */     gridBagConstraints = new GridBagConstraints();
/* 3654 */     gridBagConstraints.gridx = 0;
/* 3655 */     gridBagConstraints.gridy = 1;
/* 3656 */     this.jPanel79.add(this.jPanel80, gridBagConstraints);
/*      */     
/* 3658 */     this.jPanel31.add(this.jPanel79);
/*      */     
/* 3660 */     this.jPanel81.setBackground(this.lc.TERCERO1);
/* 3661 */     this.jPanel81.setLayout(new GridBagLayout());
/*      */     
/* 3663 */     this.jLabel14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 3665 */     this.jLabel14.setHorizontalAlignment(0);
/* 3666 */     this.jLabel14.setText("Otros Datos");
/* 3667 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3669 */             AltaOperador.this.jLabel14MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3672 */             AltaOperador.this.jLabel14MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3675 */             AltaOperador.this.jLabel14MouseEntered(evt);
/*      */           }
/*      */         });
/* 3678 */     gridBagConstraints = new GridBagConstraints();
/* 3679 */     gridBagConstraints.gridx = 0;
/* 3680 */     gridBagConstraints.gridy = 0;
/* 3681 */     this.jPanel81.add(this.jLabel14, gridBagConstraints);
/*      */     
/* 3683 */     this.jPanel82.setBackground(this.lc.TERCERO1);
/* 3684 */     this.jPanel82.setMinimumSize(new Dimension(100, 4));
/* 3685 */     this.jPanel82.setPreferredSize(new Dimension(144, 4));
/*      */     
/* 3687 */     GroupLayout jPanel82Layout = new GroupLayout(this.jPanel82);
/* 3688 */     this.jPanel82.setLayout(jPanel82Layout);
/* 3689 */     jPanel82Layout.setHorizontalGroup(jPanel82Layout
/* 3690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3691 */         .addGap(0, 144, 32767));
/*      */     
/* 3693 */     jPanel82Layout.setVerticalGroup(jPanel82Layout
/* 3694 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3695 */         .addGap(0, 4, 32767));
/*      */ 
/*      */     
/* 3698 */     gridBagConstraints = new GridBagConstraints();
/* 3699 */     gridBagConstraints.gridx = 0;
/* 3700 */     gridBagConstraints.gridy = 1;
/* 3701 */     this.jPanel81.add(this.jPanel82, gridBagConstraints);
/*      */     
/* 3703 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 3704 */     this.jPanel32.setLayout(jPanel32Layout);
/* 3705 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 3706 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3707 */         .addGap(0, 0, 32767));
/*      */     
/* 3709 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 3710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3711 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/* 3714 */     this.jPanel81.add(this.jPanel32, new GridBagConstraints());
/*      */     
/* 3716 */     this.jPanel31.add(this.jPanel81);
/*      */     
/* 3718 */     GridBagLayout jPanel25Layout = new GridBagLayout();
/* 3719 */     jPanel25Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3720 */     jPanel25Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 3721 */     this.jPanel25.setLayout(jPanel25Layout);
/*      */     
/* 3723 */     this.jLabel19.setFont(new Font("Cantarell", 1, 11));
/* 3724 */     this.jLabel19.setText("Clave");
/* 3725 */     gridBagConstraints = new GridBagConstraints();
/* 3726 */     gridBagConstraints.gridx = 2;
/* 3727 */     gridBagConstraints.gridy = 0;
/* 3728 */     gridBagConstraints.anchor = 17;
/* 3729 */     this.jPanel25.add(this.jLabel19, gridBagConstraints);
/*      */     
/* 3731 */     this.jTextField19.setEditable(false);
/* 3732 */     this.jTextField19.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3733 */     this.jTextField19.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3735 */             AltaOperador.this.jTextField19KeyReleased(evt);
/*      */           }
/*      */         });
/* 3738 */     gridBagConstraints = new GridBagConstraints();
/* 3739 */     gridBagConstraints.gridx = 4;
/* 3740 */     gridBagConstraints.gridy = 0;
/* 3741 */     gridBagConstraints.fill = 2;
/* 3742 */     gridBagConstraints.anchor = 18;
/* 3743 */     gridBagConstraints.weightx = 0.6D;
/* 3744 */     this.jPanel25.add(this.jTextField19, gridBagConstraints);
/*      */     
/* 3746 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/* 3747 */     this.jLabel18.setText("Nombre");
/* 3748 */     gridBagConstraints = new GridBagConstraints();
/* 3749 */     gridBagConstraints.gridx = 2;
/* 3750 */     gridBagConstraints.gridy = 2;
/* 3751 */     gridBagConstraints.anchor = 17;
/* 3752 */     this.jPanel25.add(this.jLabel18, gridBagConstraints);
/*      */     
/* 3754 */     this.jTextField16.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3755 */     this.jTextField16.setNextFocusableComponent(this.jTextField17);
/* 3756 */     this.jTextField16.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3758 */             AltaOperador.this.jTextField16KeyReleased(evt);
/*      */           }
/*      */         });
/* 3761 */     gridBagConstraints = new GridBagConstraints();
/* 3762 */     gridBagConstraints.gridx = 4;
/* 3763 */     gridBagConstraints.gridy = 2;
/* 3764 */     gridBagConstraints.fill = 2;
/* 3765 */     gridBagConstraints.anchor = 18;
/* 3766 */     gridBagConstraints.weightx = 0.6D;
/* 3767 */     this.jPanel25.add(this.jTextField16, gridBagConstraints);
/*      */     
/* 3769 */     this.jLabel33.setFont(new Font("Cantarell", 1, 11));
/* 3770 */     this.jLabel33.setText("Apellido Paterno");
/* 3771 */     gridBagConstraints = new GridBagConstraints();
/* 3772 */     gridBagConstraints.gridx = 2;
/* 3773 */     gridBagConstraints.gridy = 4;
/* 3774 */     gridBagConstraints.fill = 2;
/* 3775 */     gridBagConstraints.anchor = 17;
/* 3776 */     this.jPanel25.add(this.jLabel33, gridBagConstraints);
/*      */     
/* 3778 */     this.jTextField17.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3779 */     this.jTextField17.setNextFocusableComponent(this.jTextField18);
/* 3780 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3782 */             AltaOperador.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/* 3785 */     gridBagConstraints = new GridBagConstraints();
/* 3786 */     gridBagConstraints.gridx = 4;
/* 3787 */     gridBagConstraints.gridy = 4;
/* 3788 */     gridBagConstraints.fill = 2;
/* 3789 */     gridBagConstraints.anchor = 18;
/* 3790 */     gridBagConstraints.weightx = 0.6D;
/* 3791 */     this.jPanel25.add(this.jTextField17, gridBagConstraints);
/*      */     
/* 3793 */     this.jLabel46.setFont(new Font("Cantarell", 0, 11));
/* 3794 */     this.jLabel46.setText("Apellido Materno");
/* 3795 */     gridBagConstraints = new GridBagConstraints();
/* 3796 */     gridBagConstraints.gridx = 2;
/* 3797 */     gridBagConstraints.gridy = 6;
/* 3798 */     gridBagConstraints.fill = 2;
/* 3799 */     gridBagConstraints.anchor = 17;
/* 3800 */     this.jPanel25.add(this.jLabel46, gridBagConstraints);
/*      */     
/* 3802 */     this.jLabel65.setFont(new Font("Cantarell", 0, 11));
/* 3803 */     this.jLabel65.setText("Teléfono");
/* 3804 */     gridBagConstraints = new GridBagConstraints();
/* 3805 */     gridBagConstraints.gridx = 2;
/* 3806 */     gridBagConstraints.gridy = 8;
/* 3807 */     gridBagConstraints.fill = 2;
/* 3808 */     gridBagConstraints.anchor = 17;
/* 3809 */     this.jPanel25.add(this.jLabel65, gridBagConstraints);
/*      */     
/* 3811 */     this.jFormattedTextField4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3812 */     this.jFormattedTextField4.setNextFocusableComponent(this.jFormattedTextField5);
/* 3813 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 3815 */             AltaOperador.this.jFormattedTextField4FocusLost(evt);
/*      */           }
/*      */         });
/* 3818 */     gridBagConstraints = new GridBagConstraints();
/* 3819 */     gridBagConstraints.gridx = 4;
/* 3820 */     gridBagConstraints.gridy = 8;
/* 3821 */     gridBagConstraints.fill = 2;
/* 3822 */     gridBagConstraints.anchor = 18;
/* 3823 */     gridBagConstraints.weightx = 0.6D;
/* 3824 */     this.jPanel25.add(this.jFormattedTextField4, gridBagConstraints);
/*      */     
/* 3826 */     this.jFormattedTextField5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3827 */     this.jFormattedTextField5.setNextFocusableComponent(this.jRadioButton5);
/* 3828 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 3830 */             AltaOperador.this.jFormattedTextField5FocusLost(evt);
/*      */           }
/*      */         });
/* 3833 */     gridBagConstraints = new GridBagConstraints();
/* 3834 */     gridBagConstraints.gridx = 4;
/* 3835 */     gridBagConstraints.gridy = 10;
/* 3836 */     gridBagConstraints.fill = 2;
/* 3837 */     gridBagConstraints.anchor = 18;
/* 3838 */     gridBagConstraints.weightx = 0.6D;
/* 3839 */     this.jPanel25.add(this.jFormattedTextField5, gridBagConstraints);
/*      */     
/* 3841 */     this.jLabel66.setFont(new Font("Cantarell", 0, 11));
/* 3842 */     this.jLabel66.setText("Celular");
/* 3843 */     gridBagConstraints = new GridBagConstraints();
/* 3844 */     gridBagConstraints.gridx = 2;
/* 3845 */     gridBagConstraints.gridy = 10;
/* 3846 */     gridBagConstraints.fill = 2;
/* 3847 */     gridBagConstraints.anchor = 17;
/* 3848 */     this.jPanel25.add(this.jLabel66, gridBagConstraints);
/*      */     
/* 3850 */     this.jLabel43.setFont(new Font("Cantarell", 0, 11));
/* 3851 */     this.jLabel43.setText("Cargo de Nextel");
/* 3852 */     this.jLabel43.setToolTipText("Selecciona 'SI' para que el sistema realice el cargo automáticamente.");
/* 3853 */     gridBagConstraints = new GridBagConstraints();
/* 3854 */     gridBagConstraints.gridx = 2;
/* 3855 */     gridBagConstraints.gridy = 12;
/* 3856 */     gridBagConstraints.fill = 2;
/* 3857 */     gridBagConstraints.anchor = 17;
/* 3858 */     this.jPanel25.add(this.jLabel43, gridBagConstraints);
/*      */     
/* 3860 */     this.jPanel62.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3862 */     this.jRadioButton5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3863 */     this.jRadioButton5.setSelected(true);
/* 3864 */     this.jRadioButton5.setText("No");
/* 3865 */     this.jRadioButton5.setNextFocusableComponent(this.jRadioButton6);
/* 3866 */     this.jPanel62.add(this.jRadioButton5);
/*      */     
/* 3868 */     this.jRadioButton6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3869 */     this.jRadioButton6.setText("Si");
/* 3870 */     this.jRadioButton6.setNextFocusableComponent(this.jTextField28);
/* 3871 */     this.jPanel62.add(this.jRadioButton6);
/*      */     
/* 3873 */     gridBagConstraints = new GridBagConstraints();
/* 3874 */     gridBagConstraints.gridx = 4;
/* 3875 */     gridBagConstraints.gridy = 12;
/* 3876 */     gridBagConstraints.fill = 2;
/* 3877 */     gridBagConstraints.weightx = 0.6D;
/* 3878 */     this.jPanel25.add(this.jPanel62, gridBagConstraints);
/*      */     
/* 3880 */     this.jLabel25.setFont(new Font("Cantarell", 0, 11));
/* 3881 */     this.jLabel25.setText("ID Nextel");
/* 3882 */     gridBagConstraints = new GridBagConstraints();
/* 3883 */     gridBagConstraints.gridx = 2;
/* 3884 */     gridBagConstraints.gridy = 14;
/* 3885 */     gridBagConstraints.fill = 2;
/* 3886 */     gridBagConstraints.anchor = 17;
/* 3887 */     this.jPanel25.add(this.jLabel25, gridBagConstraints);
/*      */     
/* 3889 */     this.jTextField28.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3890 */     this.jTextField28.setNextFocusableComponent(this.jFormattedTextField9);
/* 3891 */     this.jTextField28.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3893 */             AltaOperador.this.jTextField28KeyReleased(evt);
/*      */           }
/*      */         });
/* 3896 */     gridBagConstraints = new GridBagConstraints();
/* 3897 */     gridBagConstraints.gridx = 4;
/* 3898 */     gridBagConstraints.gridy = 14;
/* 3899 */     gridBagConstraints.fill = 2;
/* 3900 */     gridBagConstraints.anchor = 18;
/* 3901 */     gridBagConstraints.weightx = 0.6D;
/* 3902 */     this.jPanel25.add(this.jTextField28, gridBagConstraints);
/*      */     
/* 3904 */     this.jLabel98.setFont(new Font("Cantarell", 0, 11));
/* 3905 */     this.jLabel98.setText("Cargo de Nextel");
/* 3906 */     gridBagConstraints = new GridBagConstraints();
/* 3907 */     gridBagConstraints.gridx = 2;
/* 3908 */     gridBagConstraints.gridy = 16;
/* 3909 */     gridBagConstraints.fill = 2;
/* 3910 */     gridBagConstraints.anchor = 17;
/* 3911 */     this.jPanel25.add(this.jLabel98, gridBagConstraints);
/*      */     
/* 3913 */     this.jFormattedTextField9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3914 */     this.jFormattedTextField9.setNextFocusableComponent(this.jTextField41);
/* 3915 */     gridBagConstraints = new GridBagConstraints();
/* 3916 */     gridBagConstraints.gridx = 4;
/* 3917 */     gridBagConstraints.gridy = 16;
/* 3918 */     gridBagConstraints.fill = 2;
/* 3919 */     gridBagConstraints.anchor = 18;
/* 3920 */     gridBagConstraints.weightx = 0.6D;
/* 3921 */     this.jPanel25.add(this.jFormattedTextField9, gridBagConstraints);
/*      */     
/* 3923 */     this.jLabel93.setFont(new Font("Cantarell", 0, 11));
/* 3924 */     this.jLabel93.setText("Lugar de Nacimiento");
/* 3925 */     gridBagConstraints = new GridBagConstraints();
/* 3926 */     gridBagConstraints.gridx = 2;
/* 3927 */     gridBagConstraints.gridy = 18;
/* 3928 */     gridBagConstraints.fill = 2;
/* 3929 */     gridBagConstraints.anchor = 17;
/* 3930 */     this.jPanel25.add(this.jLabel93, gridBagConstraints);
/*      */     
/* 3932 */     this.jTextField41.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3933 */     this.jTextField41.setNextFocusableComponent((Component)this.jDateChooser5);
/* 3934 */     this.jTextField41.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3936 */             AltaOperador.this.jTextField41KeyReleased(evt);
/*      */           }
/*      */         });
/* 3939 */     gridBagConstraints = new GridBagConstraints();
/* 3940 */     gridBagConstraints.gridx = 4;
/* 3941 */     gridBagConstraints.gridy = 18;
/* 3942 */     gridBagConstraints.fill = 2;
/* 3943 */     gridBagConstraints.anchor = 18;
/* 3944 */     gridBagConstraints.weightx = 0.3D;
/* 3945 */     this.jPanel25.add(this.jTextField41, gridBagConstraints);
/*      */     
/* 3947 */     this.jLabel24.setFont(new Font("Cantarell", 1, 11));
/* 3948 */     this.jLabel24.setText("Fecha de Nacimiento");
/* 3949 */     gridBagConstraints = new GridBagConstraints();
/* 3950 */     gridBagConstraints.gridx = 8;
/* 3951 */     gridBagConstraints.gridy = 0;
/* 3952 */     gridBagConstraints.fill = 2;
/* 3953 */     gridBagConstraints.anchor = 17;
/* 3954 */     this.jPanel25.add(this.jLabel24, gridBagConstraints);
/*      */     
/* 3956 */     this.jDateChooser5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3957 */     this.jDateChooser5.setIcon(this.icon);
/* 3958 */     this.jDateChooser5.setNextFocusableComponent(this.jTextField25);
/* 3959 */     gridBagConstraints = new GridBagConstraints();
/* 3960 */     gridBagConstraints.gridx = 10;
/* 3961 */     gridBagConstraints.gridy = 0;
/* 3962 */     gridBagConstraints.fill = 2;
/* 3963 */     gridBagConstraints.anchor = 18;
/* 3964 */     gridBagConstraints.weightx = 0.3D;
/* 3965 */     this.jPanel25.add((Component)this.jDateChooser5, gridBagConstraints);
/*      */     
/* 3967 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/* 3968 */     this.jLabel22.setText("Núm Seg Social");
/* 3969 */     gridBagConstraints = new GridBagConstraints();
/* 3970 */     gridBagConstraints.gridx = 8;
/* 3971 */     gridBagConstraints.gridy = 2;
/* 3972 */     gridBagConstraints.fill = 2;
/* 3973 */     gridBagConstraints.anchor = 17;
/* 3974 */     this.jPanel25.add(this.jLabel22, gridBagConstraints);
/*      */     
/* 3976 */     this.jTextField25.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3977 */     this.jTextField25.setNextFocusableComponent(this.jTextField42);
/* 3978 */     this.jTextField25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3980 */             AltaOperador.this.jTextField25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3983 */     this.jTextField25.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3985 */             AltaOperador.this.jTextField25KeyReleased(evt);
/*      */           }
/*      */         });
/* 3988 */     gridBagConstraints = new GridBagConstraints();
/* 3989 */     gridBagConstraints.gridx = 10;
/* 3990 */     gridBagConstraints.gridy = 2;
/* 3991 */     gridBagConstraints.fill = 2;
/* 3992 */     gridBagConstraints.anchor = 18;
/* 3993 */     gridBagConstraints.weightx = 0.3D;
/* 3994 */     this.jPanel25.add(this.jTextField25, gridBagConstraints);
/*      */     
/* 3996 */     this.jTextField42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 3997 */     this.jTextField42.setNextFocusableComponent(this.jTextField26);
/* 3998 */     this.jTextField42.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4000 */             AltaOperador.this.jTextField42KeyReleased(evt);
/*      */           }
/*      */         });
/* 4003 */     gridBagConstraints = new GridBagConstraints();
/* 4004 */     gridBagConstraints.gridx = 10;
/* 4005 */     gridBagConstraints.gridy = 4;
/* 4006 */     gridBagConstraints.fill = 2;
/* 4007 */     gridBagConstraints.anchor = 18;
/* 4008 */     gridBagConstraints.weightx = 0.3D;
/* 4009 */     this.jPanel25.add(this.jTextField42, gridBagConstraints);
/*      */     
/* 4011 */     this.jLabel101.setFont(new Font("Cantarell", 0, 11));
/* 4012 */     this.jLabel101.setText("RFC");
/* 4013 */     gridBagConstraints = new GridBagConstraints();
/* 4014 */     gridBagConstraints.gridx = 8;
/* 4015 */     gridBagConstraints.gridy = 4;
/* 4016 */     gridBagConstraints.fill = 2;
/* 4017 */     gridBagConstraints.anchor = 17;
/* 4018 */     this.jPanel25.add(this.jLabel101, gridBagConstraints);
/*      */     
/* 4020 */     this.jLabel36.setFont(new Font("Cantarell", 0, 11));
/* 4021 */     this.jLabel36.setText("CURP");
/* 4022 */     gridBagConstraints = new GridBagConstraints();
/* 4023 */     gridBagConstraints.gridx = 8;
/* 4024 */     gridBagConstraints.gridy = 6;
/* 4025 */     gridBagConstraints.fill = 2;
/* 4026 */     gridBagConstraints.anchor = 17;
/* 4027 */     this.jPanel25.add(this.jLabel36, gridBagConstraints);
/*      */     
/* 4029 */     this.jTextField26.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4030 */     this.jTextField26.setNextFocusableComponent(this.jRadioButton7);
/* 4031 */     this.jTextField26.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4033 */             AltaOperador.this.jTextField26KeyReleased(evt);
/*      */           }
/*      */         });
/* 4036 */     gridBagConstraints = new GridBagConstraints();
/* 4037 */     gridBagConstraints.gridx = 10;
/* 4038 */     gridBagConstraints.gridy = 6;
/* 4039 */     gridBagConstraints.fill = 2;
/* 4040 */     gridBagConstraints.anchor = 18;
/* 4041 */     gridBagConstraints.weightx = 0.3D;
/* 4042 */     this.jPanel25.add(this.jTextField26, gridBagConstraints);
/*      */     
/* 4044 */     this.jLabel45.setFont(new Font("Cantarell", 0, 11));
/* 4045 */     this.jLabel45.setText("Cargo de Infonavit");
/* 4046 */     this.jLabel45.setToolTipText("Selecciona 'SI' para que el sistema realice el cargo automáticamente.");
/* 4047 */     gridBagConstraints = new GridBagConstraints();
/* 4048 */     gridBagConstraints.gridx = 8;
/* 4049 */     gridBagConstraints.gridy = 8;
/* 4050 */     gridBagConstraints.fill = 2;
/* 4051 */     gridBagConstraints.anchor = 17;
/* 4052 */     this.jPanel25.add(this.jLabel45, gridBagConstraints);
/*      */     
/* 4054 */     this.jPanel63.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 4056 */     this.jRadioButton7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4057 */     this.jRadioButton7.setSelected(true);
/* 4058 */     this.jRadioButton7.setText("No");
/* 4059 */     this.jRadioButton7.setNextFocusableComponent(this.jRadioButton8);
/* 4060 */     this.jPanel63.add(this.jRadioButton7);
/*      */     
/* 4062 */     this.jRadioButton8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4063 */     this.jRadioButton8.setText("Si");
/* 4064 */     this.jRadioButton8.setNextFocusableComponent(this.jTextField33);
/* 4065 */     this.jPanel63.add(this.jRadioButton8);
/*      */     
/* 4067 */     gridBagConstraints = new GridBagConstraints();
/* 4068 */     gridBagConstraints.gridx = 10;
/* 4069 */     gridBagConstraints.gridy = 8;
/* 4070 */     gridBagConstraints.fill = 2;
/* 4071 */     gridBagConstraints.weightx = 0.3D;
/* 4072 */     this.jPanel25.add(this.jPanel63, gridBagConstraints);
/*      */     
/* 4074 */     this.jLabel70.setFont(new Font("Cantarell", 0, 11));
/* 4075 */     this.jLabel70.setText("Número de infonavit");
/* 4076 */     gridBagConstraints = new GridBagConstraints();
/* 4077 */     gridBagConstraints.gridx = 8;
/* 4078 */     gridBagConstraints.gridy = 10;
/* 4079 */     gridBagConstraints.fill = 2;
/* 4080 */     gridBagConstraints.anchor = 17;
/* 4081 */     this.jPanel25.add(this.jLabel70, gridBagConstraints);
/*      */     
/* 4083 */     this.jTextField33.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4084 */     this.jTextField33.setText("infona");
/* 4085 */     this.jTextField33.setNextFocusableComponent(this.jFormattedTextField6);
/* 4086 */     this.jTextField33.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4088 */             AltaOperador.this.jTextField33KeyReleased(evt);
/*      */           }
/*      */         });
/* 4091 */     gridBagConstraints = new GridBagConstraints();
/* 4092 */     gridBagConstraints.gridx = 10;
/* 4093 */     gridBagConstraints.gridy = 10;
/* 4094 */     gridBagConstraints.fill = 2;
/* 4095 */     gridBagConstraints.anchor = 18;
/* 4096 */     gridBagConstraints.weightx = 0.1D;
/* 4097 */     this.jPanel25.add(this.jTextField33, gridBagConstraints);
/*      */     
/* 4099 */     this.jLabel69.setFont(new Font("Cantarell", 0, 11));
/* 4100 */     this.jLabel69.setText("Cargo de Infonavit");
/* 4101 */     gridBagConstraints = new GridBagConstraints();
/* 4102 */     gridBagConstraints.gridx = 8;
/* 4103 */     gridBagConstraints.gridy = 12;
/* 4104 */     gridBagConstraints.fill = 2;
/* 4105 */     this.jPanel25.add(this.jLabel69, gridBagConstraints);
/*      */     
/* 4107 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/* 4108 */     this.jFormattedTextField6.setText("cargo inf");
/* 4109 */     this.jFormattedTextField6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4110 */     this.jFormattedTextField6.setNextFocusableComponent(this.jComboBox6);
/* 4111 */     gridBagConstraints = new GridBagConstraints();
/* 4112 */     gridBagConstraints.gridx = 10;
/* 4113 */     gridBagConstraints.gridy = 12;
/* 4114 */     gridBagConstraints.fill = 2;
/* 4115 */     gridBagConstraints.anchor = 18;
/* 4116 */     gridBagConstraints.weightx = 0.1D;
/* 4117 */     this.jPanel25.add(this.jFormattedTextField6, gridBagConstraints);
/*      */     
/* 4119 */     this.jLabel28.setFont(new Font("Cantarell", 0, 11));
/* 4120 */     this.jLabel28.setText("Estado Civil");
/* 4121 */     gridBagConstraints = new GridBagConstraints();
/* 4122 */     gridBagConstraints.gridx = 8;
/* 4123 */     gridBagConstraints.gridy = 16;
/* 4124 */     gridBagConstraints.fill = 2;
/* 4125 */     gridBagConstraints.anchor = 17;
/* 4126 */     this.jPanel25.add(this.jLabel28, gridBagConstraints);
/*      */     
/* 4128 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 4129 */     this.jComboBox6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4130 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "SOLTERO", "CASADO", "DIVORSIADO", "VIUDO", "UNIÓN LIBRE" }));
/* 4131 */     this.jComboBox6.setNextFocusableComponent(this.jSpinner2);
/* 4132 */     gridBagConstraints = new GridBagConstraints();
/* 4133 */     gridBagConstraints.gridx = 10;
/* 4134 */     gridBagConstraints.gridy = 16;
/* 4135 */     gridBagConstraints.fill = 2;
/* 4136 */     gridBagConstraints.anchor = 18;
/* 4137 */     gridBagConstraints.weightx = 0.3D;
/* 4138 */     this.jPanel25.add(this.jComboBox6, gridBagConstraints);
/*      */     
/* 4140 */     this.jSpinner2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4141 */     this.jSpinner2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
/* 4142 */     gridBagConstraints = new GridBagConstraints();
/* 4143 */     gridBagConstraints.gridx = 10;
/* 4144 */     gridBagConstraints.gridy = 18;
/* 4145 */     gridBagConstraints.fill = 2;
/* 4146 */     gridBagConstraints.anchor = 18;
/* 4147 */     gridBagConstraints.weightx = 0.3D;
/* 4148 */     this.jPanel25.add(this.jSpinner2, gridBagConstraints);
/*      */     
/* 4150 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/* 4151 */     this.jLabel73.setText("Número de Hijos");
/* 4152 */     gridBagConstraints = new GridBagConstraints();
/* 4153 */     gridBagConstraints.gridx = 8;
/* 4154 */     gridBagConstraints.gridy = 18;
/* 4155 */     gridBagConstraints.fill = 2;
/* 4156 */     gridBagConstraints.anchor = 17;
/* 4157 */     this.jPanel25.add(this.jLabel73, gridBagConstraints);
/*      */     
/* 4159 */     this.jTextField18.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4160 */     this.jTextField18.setNextFocusableComponent(this.jFormattedTextField4);
/* 4161 */     this.jTextField18.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4163 */             AltaOperador.this.jTextField18KeyReleased(evt);
/*      */           }
/*      */         });
/* 4166 */     gridBagConstraints = new GridBagConstraints();
/* 4167 */     gridBagConstraints.gridx = 4;
/* 4168 */     gridBagConstraints.gridy = 6;
/* 4169 */     gridBagConstraints.fill = 2;
/* 4170 */     gridBagConstraints.weightx = 0.5D;
/* 4171 */     this.jPanel25.add(this.jTextField18, gridBagConstraints);
/*      */     
/* 4173 */     this.jLabel155.setFont(new Font("Cantarell", 0, 11));
/* 4174 */     this.jLabel155.setText("Seguro de Vida");
/* 4175 */     gridBagConstraints = new GridBagConstraints();
/* 4176 */     gridBagConstraints.gridx = 8;
/* 4177 */     gridBagConstraints.gridy = 14;
/* 4178 */     gridBagConstraints.fill = 2;
/* 4179 */     gridBagConstraints.anchor = 17;
/* 4180 */     this.jPanel25.add(this.jLabel155, gridBagConstraints);
/*      */     
/* 4182 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 4183 */     this.jFormattedTextField1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 4184 */     gridBagConstraints = new GridBagConstraints();
/* 4185 */     gridBagConstraints.gridx = 10;
/* 4186 */     gridBagConstraints.gridy = 14;
/* 4187 */     gridBagConstraints.fill = 2;
/* 4188 */     this.jPanel25.add(this.jFormattedTextField1, gridBagConstraints);
/*      */     
/* 4190 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 4191 */     this.jPanel29.setLayout(jPanel29Layout);
/* 4192 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 4193 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4194 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */     
/* 4196 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 4197 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4198 */         .addComponent(this.jPanel25, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */ 
/*      */     
/* 4201 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 4202 */     this.jPanel35.setLayout(jPanel35Layout);
/* 4203 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 4204 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4205 */         .addComponent(this.jPanel31, -1, -1, 32767)
/* 4206 */         .addComponent(this.jPanel76, -1, -1, 32767)
/* 4207 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */     
/* 4209 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 4210 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4211 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 4212 */           .addComponent(this.jPanel76, -2, -1, -2)
/* 4213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4214 */           .addComponent(this.jPanel31, -2, 46, -2)
/* 4215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4216 */           .addComponent(this.jPanel29, -1, -1, 32767)));
/*      */ 
/*      */     
/* 4219 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 4220 */     this.jPanel24.setLayout(jPanel24Layout);
/* 4221 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 4222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4223 */         .addComponent(this.jPanel35, -1, -1, 32767)
/* 4224 */         .addComponent(this.jPanel26, -2, 892, 32767));
/*      */     
/* 4226 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 4227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4228 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 4229 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 4230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4231 */           .addComponent(this.jPanel26, -2, 50, -2)
/* 4232 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4235 */     GroupLayout layout = new GroupLayout(this);
/* 4236 */     setLayout(layout);
/* 4237 */     layout.setHorizontalGroup(layout
/* 4238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4239 */         .addGap(0, 948, 32767)
/* 4240 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4241 */           .addGroup(layout.createSequentialGroup()
/* 4242 */             .addGap(0, 0, 32767)
/* 4243 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 4244 */             .addGap(0, 0, 32767))));
/*      */     
/* 4246 */     layout.setVerticalGroup(layout
/* 4247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4248 */         .addGap(0, 527, 32767)
/* 4249 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4250 */           .addGroup(layout.createSequentialGroup()
/* 4251 */             .addGap(0, 0, 32767)
/* 4252 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 4253 */             .addGap(0, 0, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 4258 */     if (this.jRadioButton1.isSelected() && this.jFormattedTextField3.getText().equals("$0.00")) {
/* 4259 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacío el campo para especificar la cantidad de infonavit", "Campo Vacío", 0, this.ADVER);
/*      */     } else {
/* 4261 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 4265 */     this.jFormattedTextField3.setEnabled(true);
/* 4266 */     this.jTextField15.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 4270 */     this.jFormattedTextField3.setEnabled(false);
/* 4271 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 4272 */     this.jTextField15.setEnabled(false);
/* 4273 */     this.jTextField15.setText("");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField16KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField18KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField19KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField20KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField21KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField22KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField23KeyReleased(KeyEvent evt) {
/* 4305 */     if (this.jTextField23.getText().length() < 5) {
/* 4306 */       this.jTextField20.setEnabled(false);
/* 4307 */       this.jTextField22.setEnabled(false);
/* 4308 */       this.jTextField24.setEnabled(false);
/* 4309 */       this.jComboBox4.setSelectedIndex(0);
/* 4310 */       this.jTextField24.setText("");
/* 4311 */       this.jTextField22.setText("");
/* 4312 */       this.jTextField1.setText("          ");
/* 4313 */       this.jTextField2.setText("          ");
/* 4314 */       this.jTextField3.setText("          ");
/* 4315 */       this.jTextField4.setText("          ");
/* 4316 */       this.jTextField31.setText("");
/*      */       
/* 4318 */       if (this.materialButton1.getText().equals("Guardar")) {
/* 4319 */         this.jTextField20.setEnabled(false);
/* 4320 */         this.jTextField21.setEnabled(false);
/*      */       } else {
/*      */         
/* 4323 */         this.jTextField20.setEnabled(true);
/* 4324 */         this.jTextField21.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField24KeyReleased(KeyEvent evt) {}
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
/*      */   
/*      */   private void jTextField33KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField28KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField30KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField35KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField37KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField38KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField39KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField4FocusLost(FocusEvent evt) {
/* 4374 */     int cont = 0;
/* 4375 */     if (this.jFormattedTextField4.getText().contains("_") && !this.jFormattedTextField4.getText().equals("___-___-____")) {
/* 4376 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField4.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 4377 */       this.jFormattedTextField4.setValue("");
/* 4378 */     } else if (!this.jFormattedTextField4.getText().contains("_")) {
/* 4379 */       String cadena = this.jFormattedTextField4.getText();
/* 4380 */       String cad1 = cadena.substring(0, 3);
/* 4381 */       String cad2 = cadena.substring(4, 7);
/* 4382 */       String cad3 = cadena.substring(8, 12);
/* 4383 */       String tel = cad1 + cad1 + cad2;
/* 4384 */       for (int i = 1; i < tel.length(); i++) {
/* 4385 */         char c = tel.charAt(i - 1);
/* 4386 */         char d = tel.charAt(i);
/* 4387 */         if (c != d) {
/* 4388 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 4392 */     if (cont == 0 && !this.jFormattedTextField4.getText().contains("_")) {
/* 4393 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 4394 */       this.jFormattedTextField4.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField5FocusLost(FocusEvent evt) {
/* 4399 */     int cont = 0;
/* 4400 */     if (this.jFormattedTextField5.getText().contains("_") && !this.jFormattedTextField5.getText().equals("___-___-____")) {
/* 4401 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField5.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 4402 */       this.jFormattedTextField5.setValue("");
/* 4403 */     } else if (!this.jFormattedTextField5.getText().contains("_")) {
/* 4404 */       String cadena = this.jFormattedTextField5.getText();
/* 4405 */       String cad1 = cadena.substring(0, 3);
/* 4406 */       String cad2 = cadena.substring(4, 7);
/* 4407 */       String cad3 = cadena.substring(8, 12);
/* 4408 */       String tel = cad1 + cad1 + cad2;
/* 4409 */       for (int i = 1; i < tel.length(); i++) {
/* 4410 */         char c = tel.charAt(i - 1);
/* 4411 */         char d = tel.charAt(i);
/* 4412 */         if (c != d) {
/* 4413 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 4417 */     if (cont == 0 && !this.jFormattedTextField5.getText().contains("_")) {
/* 4418 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 4419 */       this.jFormattedTextField5.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 4424 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 4429 */     this.jDateChooser8.setDate(new Date());
/* 4430 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4431 */     String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 4432 */     String año = cadenaFecha1.substring(0, 4);
/* 4433 */     if (this.jRadioButton3.isSelected()) {
/* 4434 */       String clave = this.jTextField19.getText();
/* 4435 */       String nombre = this.jTextField17.getText() + " " + this.jTextField17.getText() + " " + this.jTextField18.getText();
/* 4436 */       String licen = this.jTextField27.getText();
/* 4437 */       String tipo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */       
/* 4439 */       String nss = this.jTextField25.getText();
/* 4440 */       String curp = this.jTextField26.getText();
/* 4441 */       this.jLabel82.setText(nombre);
/* 4442 */       this.jLabel83.setText("<html><b>Licencia: </b>" + licen + "</html>");
/* 4443 */       this.jLabel84.setText("<html><b>Tipo: </b>" + tipo + "</html>");
/* 4444 */       this.jLabel85.setText("<html><b>NSS: </b>" + nss + "</html>");
/* 4445 */       this.jLabel89.setText("<html><b>CURP: </b>" + curp + "</html>");
/* 4446 */       this.jLabel102.setText(nombre);
/* 4447 */       this.jLabel81.setText("Operador de Quinta Rueda");
/* 4448 */       this.VIGENCIA = "DICIEMBRE " + año;
/* 4449 */       this.jLabel86.setText("<html><b>Vigencia: </b>DICIEMBRE " + año + "</html>");
/* 4450 */       String claveOp = sacarClave(clave);
/* 4451 */       this.jLabel80.setText("OP-" + claveOp);
/* 4452 */       this.CLAVEOP = (String)this.CAMPOSGENERALES.get("directiva") + "-OP-" + (String)this.CAMPOSGENERALES.get("directiva");
/* 4453 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA")) {
/* 4454 */         Gafete2020 gafete2020 = new Gafete2020(this.padre, true, this.CAMPOSGENERALES, new String[] { clave, this.CLAVEOP, nombre.toUpperCase(), this.VIGENCIA, nss.toUpperCase(), curp.toUpperCase(), "OPERADOR DE QUINTA RUEDA" });
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 4459 */         verFotos2();
/* 4460 */         this.jDialog6.setVisible(true);
/*      */       } 
/*      */     } else {
/* 4463 */       this.jLabel123.setText("<html><center>FOLIO: <b>" + this.CONFIG[1] + "-OP" + this.jTextField19.getText() + "-" + año + "</b></center></html>");
/* 4464 */       this.jLabel149.setText("<html><center>FOLIO: <b>" + this.CONFIG[1] + "-OP" + this.jTextField19.getText() + "-" + año + "</b></center></html>");
/* 4465 */       this.jLabel76.setText(this.jTextField17.getText().toUpperCase() + " " + this.jTextField17.getText().toUpperCase() + " " + this.jTextField18.getText().toUpperCase());
/* 4466 */       this.jSpinner1.setValue(Integer.valueOf(8));
/* 4467 */       String mes = cadenaFecha1.substring(4, 6);
/* 4468 */       String dia = cadenaFecha1.substring(6, 8);
/* 4469 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 4471 */       int aa = Integer.parseInt(año);
/* 4472 */       aa++;
/* 4473 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4474 */       String strFecha = "" + aa + "-" + aa + "-01";
/* 4475 */       Date fecha = null;
/*      */       try {
/* 4477 */         fecha = formatoDelTexto.parse(strFecha);
/* 4478 */       } catch (ParseException ex) {
/* 4479 */         ex.printStackTrace();
/*      */       } 
/* 4481 */       this.jDateChooser1.setDate(fecha);
/*      */       
/* 4483 */       this.jLabel144.setText(fechaCompleta);
/* 4484 */       this.jTextField29.setText("OPERADOR");
/* 4485 */       this.jLabel153.setText(this.CONFIG[3]);
/* 4486 */       this.jLabel151.setText(this.CONFIG[2]);
/* 4487 */       verFotos2();
/* 4488 */       this.jDialog9.setVisible(true);
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
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 4510 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 4514 */     ImprimirRigPass rig = new ImprimirRigPass();
/* 4515 */     rig.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 4519 */     this.jDialog7.setVisible(false);
/* 4520 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel136MouseClicked(MouseEvent evt) {
/* 4524 */     this.jDateChooser8.setDate(new Date());
/* 4525 */     int res = JOptionPane.showConfirmDialog(this.jDialog6, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 4526 */     if (res == 0) {
/* 4527 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4528 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 4529 */       String año = cadenaFecha1.substring(0, 4);
/* 4530 */       String mes = cadenaFecha1.substring(4, 6);
/* 4531 */       String dia = cadenaFecha1.substring(6, 8);
/* 4532 */       String mm = dameMes(mes);
/* 4533 */       this.jLabel136.setText(mm.toUpperCase() + " " + mm.toUpperCase());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel136MouseEntered(MouseEvent evt) {
/* 4538 */     this.jLabel136.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel136MouseExited(MouseEvent evt) {
/* 4542 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField25ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField41KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField42KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 4558 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 4562 */     Date fecha = this.jDateChooser1.getDate();
/* 4563 */     if (fecha == null) {
/* 4564 */       JOptionPane.showMessageDialog(this, "Ingresa la fecha de la vigencia", "Falta la fecha de vigencia", 0, this.ERROR);
/* 4565 */     } else if (this.jTextField29.getText().equals("")) {
/* 4566 */       this.jTextField29.setBackground(Color.RED);
/* 4567 */       JOptionPane.showMessageDialog(this.jDialog9, "Falta ingresar la categoría de la persona, no la puedes dejar vacía", "Falta la categoria", 0, this.ERROR);
/*      */     } else {
/* 4569 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4570 */       String cadenaFecha1 = formato.format(new Date());
/*      */       try {
/* 4572 */         String foto = this.CONFIG[0] + "/" + this.CONFIG[0] + ".png";
/* 4573 */         String año = cadenaFecha1.substring(0, 4);
/* 4574 */         String mes = cadenaFecha1.substring(4, 6);
/* 4575 */         String dia = cadenaFecha1.substring(6, 8);
/* 4576 */         String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */         
/* 4578 */         Date fecha1 = this.jDateChooser1.getDate();
/* 4579 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 4580 */         String cadenaFecha = "";
/* 4581 */         cadenaFecha = formato.format(fecha1);
/* 4582 */         String AÑO = cadenaFecha.substring(0, 4);
/* 4583 */         String MES = cadenaFecha.substring(4, 6);
/* 4584 */         String DIA = cadenaFecha.substring(6, 8);
/* 4585 */         String fechaCompleta1 = dameMes(MES).toUpperCase() + " " + dameMes(MES).toUpperCase();
/* 4586 */         Map<Object, Object> datos = new HashMap<>();
/*      */         
/* 4588 */         datos.put("folio", this.CONFIG[1] + "-OP" + this.CONFIG[1] + "-" + this.jTextField19.getText());
/* 4589 */         datos.put("nombre", this.jTextField17.getText() + " " + this.jTextField17.getText() + " " + this.jTextField18.getText());
/* 4590 */         datos.put("vigencia", fechaCompleta1);
/* 4591 */         datos.put("fecha", fechaCompleta);
/* 4592 */         datos.put("capacitador", this.CONFIG[3]);
/* 4593 */         datos.put("registro", this.CONFIG[2]);
/* 4594 */         datos.put("foto", foto);
/* 4595 */         datos.put("categoria", this.jTextField29.getText().toUpperCase());
/* 4596 */         datos.put("horas", String.valueOf(this.jSpinner1.getValue()) + " HRS.");
/* 4597 */         JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/qhse/curso_basico.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 4598 */         JasperViewer visor = new JasperViewer(print, false);
/* 4599 */         visor.setTitle("Gafete Curso Básico de Seguridad");
/* 4600 */         visor.setIconImage(this.iconoImprimir);
/* 4601 */         this.jDialog9.setVisible(false);
/* 4602 */         visor.setVisible(true);
/*      */       }
/* 4604 */       catch (JRException e) {
/* 4605 */         System.out.println(e.getMessage());
/* 4606 */         Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 4607 */         JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 4613 */     this.jDialog9.setVisible(false);
/* 4614 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 4622 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 4626 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 4630 */     this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 4631 */     this.fichas.remove(1);
/* 4632 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jLabel10MouseEntered(MouseEvent evt) {
/* 4636 */     ingresaMouse(this.jLabel10, this.jPanel78);
/*      */   }
/*      */   
/*      */   private void jLabel10MouseExited(MouseEvent evt) {
/* 4640 */     if (this.clicPanel != 1) {
/* 4641 */       saleMouse(this.jLabel10, this.jPanel78);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel13MouseEntered(MouseEvent evt) {
/* 4646 */     ingresaMouse(this.jLabel13, this.jPanel80);
/*      */   }
/*      */   
/*      */   private void jLabel13MouseExited(MouseEvent evt) {
/* 4650 */     if (this.clicPanel != 2) {
/* 4651 */       saleMouse(this.jLabel13, this.jPanel80);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel14MouseEntered(MouseEvent evt) {
/* 4656 */     ingresaMouse(this.jLabel14, this.jPanel82);
/*      */   }
/*      */   
/*      */   private void jLabel14MouseExited(MouseEvent evt) {
/* 4660 */     if (this.clicPanel != 3) {
/* 4661 */       saleMouse(this.jLabel14, this.jPanel82);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 4666 */     cambioPanel1();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 4670 */     ingresaMouse(this.jLabel8, this.jPanel75);
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 4674 */     if (this.clicPanel != 0) {
/* 4675 */       saleMouse(this.jLabel8, this.jPanel75);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel10MouseClicked(MouseEvent evt) {
/* 4680 */     cambioPanel2();
/*      */   }
/*      */   
/*      */   private void jLabel13MouseClicked(MouseEvent evt) {
/* 4684 */     cambioPanel3();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/* 4688 */     cambioPanel4();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField40KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 4696 */     int edo = 0;
/* 4697 */     String estado = this.jComboBox4.getSelectedItem().toString();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4712 */     if (this.jTextField19.getText().equals("")) {
/* 4713 */       this.error.cargarError(this.jTextField19, "050");
/* 4714 */     } else if (!this.val.validarSoloNum(this.jTextField19, this.jTextField19.getText())) {
/* 4715 */       if (this.jTextField16.getText().equals("")) {
/* 4716 */         cambioPanel1();
/* 4717 */         this.error.cargarError(this.jTextField16, "050");
/* 4718 */       } else if (!this.val.validarNombres(this.jLabel8, this.jTextField16.getText(), "010")) {
/* 4719 */         if (this.jTextField17.getText().equals("")) {
/* 4720 */           cambioPanel1();
/* 4721 */           this.error.cargarError(this.jTextField17, "050");
/* 4722 */         } else if (!this.val.validarNombres(this.jLabel8, this.jTextField17.getText(), "010") && 
/* 4723 */           !this.val.validarNombres(this.jLabel8, this.jTextField18.getText(), "010") && 
/* 4724 */           !this.val.validarCalle(this.jLabel10, this.jTextField20.getText(), "014")) {
/* 4725 */           if (this.jTextField24.getText().equals("") || this.jTextField20.getText().equals("") || this.jTextField1.getText().equals("          ")) {
/* 4726 */             cambioPanel2();
/* 4727 */             JOptionPane.showMessageDialog(this.padre, "Te falta especificar la dirección", "Coloca la dirección", 0, this.ADVER);
/*      */           }
/* 4729 */           else if (!this.jTextField20.getText().equals("") && this.jTextField22.getText().equals("") && this.jTextField21.getText().equals("")) {
/* 4730 */             cambioPanel2();
/* 4731 */             this.jTextField21.setBackground(new Color(255, 51, 51));
/* 4732 */             JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también el número", "Coloca el número", 0, this.ADVER);
/* 4733 */           } else if (!this.val.validarNumero(this.jLabel10, this.jTextField21.getText().toUpperCase(), "015")) {
/* 4734 */             if (!this.jTextField21.getText().equals("") && this.jTextField20.getText().equals("")) {
/* 4735 */               this.jTextField20.setBackground(new Color(255, 51, 51));
/* 4736 */               cambioPanel2();
/* 4737 */               JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle", "Coloca la calle", 0, this.ADVER);
/* 4738 */             } else if (!this.val.validarDireccion(this.jLabel10, this.jTextField22.getText(), "014")) {
/* 4739 */               if (!this.jTextField22.getText().equals("") && this.jTextField20.getText().equals("")) {
/* 4740 */                 this.jTextField20.setBackground(new Color(255, 51, 51));
/* 4741 */                 cambioPanel2();
/* 4742 */                 JOptionPane.showMessageDialog(this.padre, "Para que sea una dirección razonable necesitas especificar también la calle.", "Coloca la Calle", 0, this.ADVER);
/* 4743 */               } else if (!this.val.validarCodigoPostal(this.jLabel10, this.jTextField23.getText(), "014") && 
/* 4744 */                 !this.val.validarRegion(this.jLabel10, this.jTextField24.getText(), "018") && 
/* 4745 */                 !this.val.validarNss(this.jLabel8, this.jTextField25.getText()) && 
/* 4746 */                 !this.val.validarApostrofe(this.jLabel8, this.jTextField26.getText(), "020")) {
/* 4747 */                 if (this.jTextField27.getText().equals("")) {
/* 4748 */                   cambioAutomatico(3);
/* 4749 */                   this.error.cargarError(this.jTextField27, "050");
/* 4750 */                 } else if (!this.val.validarApostrofe(this.jLabel14, this.jTextField27.getText(), "020")) {
/* 4751 */                   if (this.jDateChooser7.getDate() == null) {
/* 4752 */                     cambioPanel4();
/* 4753 */                     JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacío el campo para especificar la vigencia de la licencia", "Vencimiento de la Licencia", 0, this.ADVER);
/* 4754 */                   } else if (this.fechaActual.getYear() + 10 < this.jDateChooser7.getDate().getYear()) {
/* 4755 */                     cambioPanel4();
/* 4756 */                     JOptionPane.showMessageDialog(null, "La fecha de vigencia de la licencia no puede exceder por más de diez años a la fecha actual", "Vigencia Larga", 0, this.ADVER);
/* 4757 */                   } else if (this.jDateChooser4.getDate() == null) {
/* 4758 */                     cambioPanel4();
/* 4759 */                     JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacío el campo para especificar la fecha de ingreso", "Fecha de Ingreso", 0, this.ADVER);
/* 4760 */                   } else if (this.jDateChooser5.getDate() == null) {
/* 4761 */                     cambioPanel1();
/* 4762 */                     JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacío el campo para especificar la fecha de nacimiento", "Fecha de Nacimiento", 0, this.ADVER);
/* 4763 */                   } else if (this.jFormattedTextField4.getText().equals(this.jFormattedTextField5.getText()) && !this.jFormattedTextField5.getText().equals("___-___-____")) {
/* 4764 */                     cambioPanel1();
/* 4765 */                     JOptionPane.showMessageDialog(this.padre, "Los números de teléfono y celular deben ser diferentes.", "Números Iguales", 0, this.ADVER);
/* 4766 */                     this.jFormattedTextField5.setValue("");
/*      */                   }
/* 4768 */                   else if (this.jTextField31.getText().equals("")) {
/* 4769 */                     cambioPanel2();
/* 4770 */                     JOptionPane.showMessageDialog(this.padre, "Necesitas ingresar la localidad en la dirección", "Falta localidad", 0, this.ADVER);
/* 4771 */                     this.jFormattedTextField5.setValue("");
/*      */                   }
/* 4773 */                   else if (!this.val.validarApostrofe(this.jLabel8, this.jTextField28.getText(), "020") && 
/* 4774 */                     !this.val.validarTexto(this.jLabel14, this.jTextField30.getText(), "020") && 
/* 4775 */                     !this.val.validarTexto(this.jLabel14, this.jTextField35.getText(), "020") && 
/* 4776 */                     !this.val.validarApostrofe(this.jLabel8, this.jTextField26.getText(), "020") && 
/* 4777 */                     !this.val.validarTexto(this.jLabel8, this.jTextField33.getText(), "020") && 
/* 4778 */                     !this.val.validarApostrofe(this.jLabel8, this.jTextField26.getText(), "020")) {
/* 4779 */                     if (this.jRadioButton6.isSelected() && this.jFormattedTextField9.getText().equals("$0.00")) {
/* 4780 */                       this.jFormattedTextField9.setBackground(Color.RED);
/* 4781 */                       cambioPanel1();
/* 4782 */                       JOptionPane.showMessageDialog(this.padre, "Si seleccionas cargo por automático de nextel, necesitas especificar la cantidad a descontar", "Falta Cantidad", 0, this.ADVER);
/*      */                       
/*      */                       return;
/*      */                     } 
/* 4786 */                     if (this.jRadioButton8.isSelected() && this.jFormattedTextField6.getText().equals("$0.00")) {
/* 4787 */                       this.jFormattedTextField6.setBackground(Color.RED);
/* 4788 */                       cambioPanel1();
/* 4789 */                       JOptionPane.showMessageDialog(this.padre, "Si seleccionas cargo por automático de infonavit, necesitas especificar la cantidad a descontar", "Falta Cantidad", 0, this.ADVER);
/*      */                       
/*      */                       return;
/*      */                     } 
/* 4793 */                     if (this.jDateChooser6.getDate() == null) {
/* 4794 */                       cambioPanel3();
/* 4795 */                       JOptionPane.showMessageDialog(this.padre, "No puedes dejar vacío el campo para especificar la última fecha de contratación", "Fecha de Contratación", 0, this.ADVER);
/* 4796 */                     } else if (this.jTextField40.getText().equals("")) {
/* 4797 */                       cambioAutomatico(2);
/* 4798 */                       this.error.cargarError(this.jTextField40, "050");
/* 4799 */                     } else if (!this.val.validarApostrofe(this.jLabel13, this.jTextField37.getText(), "020") && 
/* 4800 */                       !this.val.validarApostrofe(this.jLabel13, this.jTextField38.getText(), "020") && 
/* 4801 */                       !this.val.validarApostrofe(this.jLabel13, this.jTextField39.getText(), "020") && 
/* 4802 */                       !this.val.validarApostrofe(this.jLabel8, this.jTextField42.getText(), "020")) {
/* 4803 */                       if (this.jTextArea1.getText().length() > 9999) {
/* 4804 */                         cambioPanel4();
/* 4805 */                         this.jTextArea1.setBackground(Color.RED);
/* 4806 */                         JOptionPane.showMessageDialog(this.padre, "El tamaño de este campo sólo puede contener máximo 9999 caracteres", "Tamaño muy Grande", 0, this.ADVER);
/*      */                       } else {
/* 4808 */                         String cod = this.jTextField23.getText();
/* 4809 */                         String tel1 = this.jFormattedTextField4.getText();
/* 4810 */                         String tel2 = this.jFormattedTextField5.getText();
/* 4811 */                         String tipo = "";
/* 4812 */                         if (this.jComboBox8.getSelectedIndex() != 0) {
/* 4813 */                           tipo = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */                         }
/* 4815 */                         if (tel1.equals("___-___-____")) {
/* 4816 */                           tel1 = "";
/*      */                         }
/* 4818 */                         if (tel2.equals("___-___-____")) {
/* 4819 */                           tel2 = "";
/*      */                         }
/* 4821 */                         if (this.jTextField23.getText().equals("")) {
/* 4822 */                           cod = "";
/*      */                         }
/* 4824 */                         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4825 */                         String cadenaFecha = "";
/* 4826 */                         cadenaFecha = formato.format(this.jDateChooser7.getDate());
/* 4827 */                         String AÑO = cadenaFecha.substring(0, 4);
/* 4828 */                         String MES = cadenaFecha.substring(4, 6);
/* 4829 */                         String DIA = cadenaFecha.substring(6, 8);
/* 4830 */                         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */                         
/* 4832 */                         formato = new SimpleDateFormat("yyyyMMdd");
/* 4833 */                         cadenaFecha = "";
/* 4834 */                         cadenaFecha = formato.format(this.jDateChooser4.getDate());
/* 4835 */                         AÑO = cadenaFecha.substring(0, 4);
/* 4836 */                         MES = cadenaFecha.substring(4, 6);
/* 4837 */                         DIA = cadenaFecha.substring(6, 8);
/* 4838 */                         String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */                         
/* 4840 */                         formato = new SimpleDateFormat("yyyyMMdd");
/* 4841 */                         cadenaFecha = "";
/* 4842 */                         cadenaFecha = formato.format(this.jDateChooser5.getDate());
/* 4843 */                         AÑO = cadenaFecha.substring(0, 4);
/* 4844 */                         MES = cadenaFecha.substring(4, 6);
/* 4845 */                         DIA = cadenaFecha.substring(6, 8);
/* 4846 */                         String fechaCompleta3 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */                         
/* 4848 */                         formato = new SimpleDateFormat("yyyyMMdd");
/* 4849 */                         cadenaFecha = "";
/* 4850 */                         cadenaFecha = formato.format(this.jDateChooser4.getDate());
/* 4851 */                         AÑO = cadenaFecha.substring(0, 4);
/* 4852 */                         MES = cadenaFecha.substring(4, 6);
/* 4853 */                         DIA = cadenaFecha.substring(6, 8);
/* 4854 */                         String fechaCompleta4 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */                         
/* 4856 */                         formato = new SimpleDateFormat("yyyyMMdd");
/* 4857 */                         cadenaFecha = "";
/* 4858 */                         cadenaFecha = formato.format(this.jDateChooser6.getDate());
/* 4859 */                         AÑO = cadenaFecha.substring(0, 4);
/* 4860 */                         MES = cadenaFecha.substring(4, 6);
/* 4861 */                         DIA = cadenaFecha.substring(6, 8);
/* 4862 */                         String fechaCompleta5 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */                         
/* 4864 */                         String cargoNextel = "No";
/* 4865 */                         String cargoInfo = "No";
/* 4866 */                         if (this.jRadioButton6.isSelected()) {
/* 4867 */                           cargoNextel = "Si";
/*      */                         }
/*      */                         
/* 4870 */                         if (this.jRadioButton8.isSelected()) {
/* 4871 */                           cargoInfo = "Si";
/*      */                         }
/*      */                         
/* 4874 */                         if (this.materialButton1.getText().equals("Modificar")) {
/* 4875 */                           int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas modificar la información?", "Modificar Información", 0, 1, this.PREG);
/* 4876 */                           if (res == 0) {
/* 4877 */                             this.con.insertar("update operadores set nombre='" + this.jTextField16.getText().toUpperCase() + "', ap_pat='" + this.jTextField17.getText().toUpperCase() + "', ap_mat='" + this.jTextField18.getText().toUpperCase() + "', calle='" + this.jTextField20.getText().toUpperCase() + "', num='" + this.jTextField21.getText().toUpperCase() + "', col='" + this.jTextField22.getText().toUpperCase() + "', cp='" + cod + "', ciudad='" + this.jTextField24.getText().toUpperCase() + "',tel_casa='" + tel1 + "', celular='" + tel2 + "',fecha_nac=" + fechaCompleta3 + ",fecha_licen=" + fechaCompleta1 + ",tipo_licen='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "',num_licen='" + this.jTextField27.getText().toUpperCase() + "',nss='" + this.jTextField25.getText() + "',rfc='" + this.jTextField26.getText().toUpperCase() + "',id_edo=" + edo + ",num_tracto='" + this.jTextField30.getText().toUpperCase() + "',num_rem='" + this.jTextField35.getText().toUpperCase() + "',ingreso=" + fechaCompleta2 + ", tipo = '" + String.valueOf(this.jComboBox8.getSelectedItem()) + "',cargoInfo='" + cargoInfo + "',infonavit = " + String.valueOf(this.jFormattedTextField6.getValue()) + ",infonavitLetra = '" + this.jFormattedTextField6.getText() + "',numInfo='" + this.jTextField33.getText() + "',cargoNextel='" + cargoNextel + "', nextel='" + this.jTextField28.getText().toUpperCase() + "',cantNextel='" + this.jFormattedTextField9.getText() + "', diascontrato=" + String.valueOf(this.jSpinner1.getValue()) + ", etiqueta='" + String.valueOf(this.jComboBox7.getSelectedItem()) + "',estadoCivil='" + String.valueOf(this.jComboBox6.getSelectedItem()) + "',hijos=" + String.valueOf(this.jSpinner2.getValue()) + ",personaContrato='" + this.jTextField40.getText().toUpperCase() + "',testigo1='" + this.jTextField37.getText().toUpperCase() + "',testigo2='" + this.jTextField38.getText().toUpperCase() + "',recomendado='" + this.jTextField39.getText().toUpperCase() + "',ultimaFechaIngreso=" + fechaCompleta5 + ",salarioIMSS=" + String.valueOf(this.jFormattedTextField7.getValue()) + ",salarioIMSSLetra='" + this.jFormattedTextField7.getText() + "',otrosDatos='" + this.jTextArea1.getText().toUpperCase() + "',ultimaActualizacion=now(),usuario='" + this.USUARIO + "',lugarNacimiento='" + this.jTextField41.getText().toUpperCase() + "',tipoTrabajador='" + String.valueOf(this.jComboBox9.getSelectedItem()) + "',asignacion='" + String.valueOf(this.jComboBox10.getSelectedItem()) + "', rfcOriginal ='" + this.jTextField42.getText().toUpperCase() + "', c_colonia='" + this.jTextField1.getText() + "', c_municipio='" + this.jTextField2.getText() + "', c_estado='" + this.jTextField3.getText() + "', edo = '" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', c_localidad = '" + this.jTextField4.getText() + "', localidad = '" + this.jTextField31.getText() + "', seguroVida='" + this.jFormattedTextField1.getText() + "' where num_ope='" + this.id + "'");
/*      */                             
/* 4879 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el reporte de los datos del operador?", "Imprimir Datos", 0, 1, this.PREG);
/* 4880 */                             if (res == 0) {
/* 4881 */                               ImprimirDatos imp = new ImprimirDatos();
/* 4882 */                               imp.recibeDatos();
/*      */                             } 
/* 4884 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el contrato de Forsis?", "Imprimir Contrato", 0, 1, this.PREG);
/* 4885 */                             if (res == 0) {
/* 4886 */                               ImprimirContrato imp = new ImprimirContrato();
/* 4887 */                               imp.recibeDatos();
/*      */                             } 
/* 4889 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir gafetes?", "Imprimir Gafete", 0, 1, this.PREG);
/* 4890 */                             if (res == 0) {
/* 4891 */                               this.jDialog5.setVisible(true);
/*      */                             }
/* 4893 */                             limpiar();
/* 4894 */                             this.fichas.remove(1);
/*      */                           } 
/*      */                         } else {
/* 4897 */                           int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas guardar la nueva información?", "Guardar Nueva Información", 0, 1, this.PREG);
/* 4898 */                           if (res == 0) {
/* 4899 */                             this.con.insertar("insert into operadores(num_ope,nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,fecha_licen,tipo_licen,num_licen,nss,rfc,ingreso,id_edo,num_tracto,num_rem,actual,TIPO,cargoInfo,infonavit,infonavitLetra,numInfo,comentarios,cargoNextel,nextel,cantNextel,diascontrato,etiqueta,estadoCivil,hijos,personaContrato,testigo1,testigo2,recomendado,ultimaFechaIngreso,salarioImss,salarioimssletra,otrosDatos,ultimaActualizacion,usuario,lugarNacimiento,tipoTrabajador,asignacion, rfcOriginal, c_colonia, c_municipio, c_estado, edo, c_localidad, localidad, seguroVida)values(" + this.jTextField19
/* 4900 */                                 .getText().toUpperCase() + ",'" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "','" + this.jTextField18.getText().toUpperCase() + "','" + this.jTextField20.getText().toUpperCase() + "','" + this.jTextField21.getText().toUpperCase() + "','" + this.jTextField22.getText().toUpperCase() + "','" + cod + "','" + this.jTextField24.getText().toUpperCase() + "','" + tel1 + "','" + tel2 + "'," + fechaCompleta3 + "," + fechaCompleta1 + ",'" + String.valueOf(this.jComboBox5.getSelectedItem()) + "','" + this.jTextField27.getText().toUpperCase() + "','" + this.jTextField25.getText() + "','" + this.jTextField26.getText().toUpperCase() + "'," + fechaCompleta2 + "," + edo + ",'" + this.jTextField30.getText().toUpperCase() + "','" + this.jTextField35.getText().toUpperCase() + "','0','" + tipo + "','" + cargoInfo + "'," + String.valueOf(this.jFormattedTextField6.getValue()) + ",'" + this.jFormattedTextField6.getText() + "','" + this.jTextField33.getText() + "','','" + cargoNextel + "','" + this.jTextField28.getText().toUpperCase() + "','" + this.jFormattedTextField9.getText() + "'," + String.valueOf(this.jSpinner1.getValue()) + ",'" + String.valueOf(this.jComboBox7.getSelectedItem()) + "','" + String.valueOf(this.jComboBox6.getSelectedItem()) + "'," + String.valueOf(this.jSpinner2.getValue()) + ",'" + this.jTextField40.getText().toUpperCase() + "','" + this.jTextField37.getText().toUpperCase() + "','" + this.jTextField38.getText().toUpperCase() + "','" + this.jTextField39.getText().toUpperCase() + "'," + fechaCompleta5 + "," + String.valueOf(this.jFormattedTextField7.getValue()) + ",'" + this.jFormattedTextField7.getText() + "','" + this.jTextArea1.getText().toUpperCase() + "',now(),'" + this.USUARIO + "','" + this.jTextField41.getText().toUpperCase() + "','" + String.valueOf(this.jComboBox9.getSelectedItem()) + "','" + String.valueOf(this.jComboBox10.getSelectedItem()) + "', '" + this.jTextField42.getText().toUpperCase() + "', '" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "', '" + this.jTextField3.getText() + "', '" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', '" + this.jTextField4.getText() + "', '" + this.jTextField31.getText() + "', '" + this.jFormattedTextField1.getText() + "')");
/*      */                             
/* 4902 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el reporte de los datos del operador?", "Imprimir Datos", 0, 1, this.PREG);
/* 4903 */                             if (res == 0) {
/* 4904 */                               ImprimirDatos imp = new ImprimirDatos();
/* 4905 */                               imp.recibeDatos();
/*      */                             } 
/* 4907 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el contrato de Forsis?", "Imprimir Contrato", 0, 1, this.PREG);
/* 4908 */                             if (res == 0) {
/* 4909 */                               ImprimirContrato imp = new ImprimirContrato();
/* 4910 */                               imp.recibeDatos();
/*      */                             } 
/* 4912 */                             res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir gafetes?", "Imprimir Gafete", 0, 1, this.PREG);
/* 4913 */                             if (res == 0) {
/* 4914 */                               this.jDialog5.setVisible(true);
/*      */                             }
/* 4916 */                             limpiar();
/*      */                           } 
/*      */                         } 
/*      */                       } 
/*      */                     } 
/*      */                   } 
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
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 4945 */     verFotos();
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 4949 */     ImprimirDatos imp = new ImprimirDatos();
/* 4950 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 4954 */     cargarFormulario();
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 4958 */     this.fichas.remove(1);
/* 4959 */     this.datos.eliminar();
/*      */   }
/*      */   
/*      */   private void jLabel156MouseClicked(MouseEvent evt) {
/* 4963 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel156MouseExited(MouseEvent evt) {
/* 4967 */     this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel156MouseEntered(MouseEvent evt) {
/* 4971 */     this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 4975 */     this.xx = evt.getX();
/* 4976 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel1MouseDragged(MouseEvent evt) {
/* 4980 */     int x = evt.getXOnScreen();
/* 4981 */     int y = evt.getYOnScreen();
/* 4982 */     this.jDialog3.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel86MouseClicked(MouseEvent evt) {
/* 4986 */     this.jDateChooser8.setDate(new Date());
/* 4987 */     int res = JOptionPane.showConfirmDialog(this.jDialog6, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 4988 */     if (res == 0) {
/* 4989 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4990 */       String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 4991 */       String año = cadenaFecha1.substring(0, 4);
/* 4992 */       String mes = cadenaFecha1.substring(4, 6);
/* 4993 */       String dia = cadenaFecha1.substring(6, 8);
/* 4994 */       String mm = dameMes(mes);
/* 4995 */       this.jLabel86.setText("<html><b>Vigencia: </b>" + mm.toUpperCase() + " " + año + "</html>");
/* 4996 */       this.VIGENCIA = mm + " " + mm;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel86MouseEntered(MouseEvent evt) {
/* 5001 */     this.jLabel86.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel86MouseExited(MouseEvent evt) {
/* 5005 */     this.jLabel86.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 5009 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 5013 */     ImprimirCredencial imp = new ImprimirCredencial();
/* 5014 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 5018 */     this.jDialog6.setVisible(false);
/* 5019 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 5023 */     this.CLAVECATALOGO.clear();
/* 5024 */     new TrasColonias(null, true, this.jButton39, "tras_colonias", this.CLAVECATALOGO, this.jTextField23.getText(), true);
/* 5025 */     if (this.CLAVECATALOGO.size() > 0) {
/* 5026 */       this.jTextField1.setText(this.CLAVECATALOGO.get("1"));
/* 5027 */       this.jTextField22.setText(this.CLAVECATALOGO.get("2"));
/*      */     } 
/*      */     
/* 5030 */     String nuevoCod = this.CLAVECATALOGO.get("3");
/* 5031 */     String viejoCod = this.jTextField23.getText();
/*      */     
/* 5033 */     if (this.CLAVECATALOGO.size() > 0) {
/* 5034 */       if (!nuevoCod.equals(viejoCod)) {
/* 5035 */         this.jTextField23.setText(nuevoCod);
/* 5036 */         habilitarDir();
/*      */       } 
/* 5038 */       this.jTextField22.setToolTipText(this.jTextField22.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton40ActionPerformed(ActionEvent evt) {
/* 5043 */     this.CLAVECATALOGO = new TreeMap<>();
/* 5044 */     new TrasColonias(null, true, this.jButton39, "tras_codigos_postales", this.CLAVECATALOGO, "", true);
/* 5045 */     if (this.CLAVECATALOGO.size() > 0) {
/* 5046 */       this.jTextField23.setText(this.CLAVECATALOGO.get("2"));
/* 5047 */       this.jTextField1.setText("");
/* 5048 */       this.jTextField22.setText("");
/* 5049 */       habilitarDir();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField23ActionPerformed(ActionEvent evt) {
/* 5054 */     habilitarDir();
/*      */   }
/*      */   
/*      */   private void jButton41ActionPerformed(ActionEvent evt) {
/* 5058 */     this.CLAVECATALOGO.clear();
/* 5059 */     new TrasColonias(null, true, this.jButton39, "tras_localidades", this.CLAVECATALOGO, this.jTextField3.getText(), true);
/* 5060 */     if (this.CLAVECATALOGO.size() > 0) {
/* 5061 */       this.jTextField4.setText(this.CLAVECATALOGO.get("1"));
/* 5062 */       this.jTextField31.setText(this.CLAVECATALOGO.get("2"));
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
/*      */   private void jTextField31KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ingresaMouse(JLabel Etiqueta, JPanel Activador) {
/* 5082 */     Etiqueta.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 5083 */     Activador.setBackground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   public void habilitarDir() {
/* 5087 */     String cod = this.jTextField23.getText();
/* 5088 */     if (this.LISTACODIGOS.contains(cod)) {
/* 5089 */       this.jTextField20.setEnabled(true);
/* 5090 */       this.jTextField21.setEnabled(true);
/* 5091 */       this.jButton39.setEnabled(true);
/*      */       
/* 5093 */       Tras_codigos c = ((List<Tras_codigos>)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(this.jTextField23.getText())).collect(Collectors.toList())).get(0);
/* 5094 */       this.con2.consultar("estado", "tras_estados", "where c_estado = '" + c.getC_estado() + "'");
/* 5095 */       this.jComboBox4.setSelectedItem(this.con2.Campo);
/* 5096 */       ((List)this.CODIGOSP.stream().filter(x -> x.getCodigo().equals(this.jTextField23.getText())).collect(Collectors.toList())).forEach(x -> {
/*      */             this.jTextField2.setText(x.getC_Municipio());
/*      */             
/*      */             this.jTextField24.setText(x.getCiudad());
/*      */           });
/* 5101 */       this.jTextField3.setText(c.getC_estado());
/*      */     }
/*      */     else {
/*      */       
/* 5105 */       this.jTextField20.setEnabled(false);
/* 5106 */       this.jTextField21.setEnabled(false);
/* 5107 */       this.jTextField22.setEnabled(false);
/* 5108 */       this.jTextField24.setEnabled(false);
/* 5109 */       this.jButton39.setEnabled(false);
/* 5110 */       this.jTextField22.setText("");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void saleMouse(JLabel Etiqueta, JPanel Activador) {
/* 5117 */     Etiqueta.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/* 5118 */     Activador.setBackground(this.lc.TERCERO1);
/*      */   }
/*      */   
/*      */   public void cambioPanel1() {
/* 5122 */     this.clicPanel = 0;
/* 5123 */     clicMouse(this.jLabel8, this.jPanel75);
/* 5124 */     cambiarPanel(this.jPanel25);
/*      */   }
/*      */   
/*      */   public void cambioPanel2() {
/* 5128 */     this.clicPanel = 1;
/* 5129 */     clicMouse(this.jLabel10, this.jPanel78);
/* 5130 */     cambiarPanel(this.jPanel11);
/*      */   }
/*      */   
/*      */   public void cambioPanel3() {
/* 5134 */     this.clicPanel = 2;
/* 5135 */     clicMouse(this.jLabel13, this.jPanel80);
/* 5136 */     cambiarPanel(this.jPanel33);
/*      */   }
/*      */   
/*      */   public void cambioPanel4() {
/* 5140 */     this.clicPanel = 3;
/* 5141 */     clicMouse(this.jLabel14, this.jPanel82);
/* 5142 */     cambiarPanel(this.jPanel28);
/*      */   }
/*      */   
/*      */   public void cambioAutomatico(int valor) {
/* 5146 */     if (valor == 0) {
/* 5147 */       this.clicPanel = 0;
/* 5148 */       cambiarPanel(this.jPanel25);
/* 5149 */       clicMouse(this.jLabel18, this.jPanel75);
/* 5150 */     } else if (valor == 1) {
/* 5151 */       this.clicPanel = 1;
/* 5152 */       cambiarPanel(this.jPanel11);
/* 5153 */       clicMouse(this.jLabel10, this.jPanel78);
/* 5154 */     } else if (valor == 2) {
/* 5155 */       this.clicPanel = 2;
/* 5156 */       cambiarPanel(this.jPanel33);
/* 5157 */       clicMouse(this.jLabel13, this.jPanel80);
/*      */     } else {
/* 5159 */       this.clicPanel = 3;
/* 5160 */       cambiarPanel(this.jPanel28);
/* 5161 */       clicMouse(this.jLabel14, this.jPanel82);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void cambiarPanel(JPanel panelito) {
/* 5167 */     this.jPanel29.removeAll();
/* 5168 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 5169 */     this.jPanel29.setLayout(jPanel29Layout);
/* 5170 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 5171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 5172 */         .addComponent(panelito, -1, -1, 32767));
/*      */     
/* 5174 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 5175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 5176 */         .addComponent(panelito, GroupLayout.Alignment.TRAILING, -1, 346, 32767));
/*      */     
/* 5178 */     this.jPanel29.repaint();
/*      */   }
/*      */   
/*      */   public void clicMouse(JLabel Etiqueta, JPanel Activador) {
/* 5182 */     this.jLabel8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/* 5183 */     this.jLabel10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/* 5184 */     this.jLabel13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/* 5185 */     this.jLabel14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 5187 */     if (this.clicPanel != 0) {
/* 5188 */       this.jPanel75.setBackground(this.lc.TERCERO1);
/*      */     }
/*      */     
/* 5191 */     if (this.clicPanel != 1) {
/* 5192 */       this.jPanel78.setBackground(this.lc.TERCERO1);
/*      */     }
/*      */     
/* 5195 */     if (this.clicPanel != 2) {
/* 5196 */       this.jPanel80.setBackground(this.lc.TERCERO1);
/*      */     }
/*      */     
/* 5199 */     if (this.clicPanel != 3) {
/* 5200 */       this.jPanel82.setBackground(this.lc.TERCERO1);
/*      */     }
/*      */     
/* 5203 */     Etiqueta.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 5204 */     Activador.setBackground(this.lc.PRIMARIO1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void verFotos() {
/* 5209 */     String nombre = this.jTextField16.getText() + " " + this.jTextField16.getText() + " " + this.jTextField17.getText();
/* 5210 */     String num = this.jTextField19.getText();
/*      */     
/* 5212 */     this.jLabel1.setText("Cargando...");
/* 5213 */     this.jLabel1.setIcon((Icon)null);
/* 5214 */     this.ind = new fotoIndividual(num);
/* 5215 */     this.jDialog3.setVisible(true);
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
/*      */   public void consultar() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void verFotos2() {
/* 5277 */     int ind = this.jTable3.getSelectedRow();
/*      */     
/* 5279 */     String num = this.jTextField19.getText();
/* 5280 */     this.jLabel78.setText("Cargando...");
/* 5281 */     this.jLabel115.setText("Cargando...");
/* 5282 */     this.jLabel128.setText("Cargando...");
/* 5283 */     this.jLabel78.setIcon((Icon)null);
/* 5284 */     this.jLabel115.setIcon((Icon)null);
/* 5285 */     this.jLabel128.setIcon((Icon)null);
/* 5286 */     this.fotoC = new fotoCredencial(num);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 5290 */     int cont = this.jTable3.getRowCount();
/* 5291 */     String[] registros = new String[cont]; int i;
/* 5292 */     for (i = 0; i < cont; i++) {
/* 5293 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*      */     }
/* 5295 */     for (i = 0; i < cont; i++) {
/* 5296 */       registros[i] = registros[i] + " " + registros[i];
/* 5297 */       this.jTable3.setValueAt(registros[i], i, destino);
/*      */     } 
/* 5299 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 5300 */     this.jTable3.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 5304 */     String mesLetra = "";
/* 5305 */     if (mes.equals("01")) {
/* 5306 */       mesLetra = "Enero";
/* 5307 */     } else if (mes.equals("02")) {
/* 5308 */       mesLetra = "Febrero";
/* 5309 */     } else if (mes.equals("03")) {
/* 5310 */       mesLetra = "Marzo";
/* 5311 */     } else if (mes.equals("04")) {
/* 5312 */       mesLetra = "Abril";
/* 5313 */     } else if (mes.equals("05")) {
/* 5314 */       mesLetra = "Mayo";
/* 5315 */     } else if (mes.equals("06")) {
/* 5316 */       mesLetra = "Junio";
/* 5317 */     } else if (mes.equals("07")) {
/* 5318 */       mesLetra = "Julio";
/* 5319 */     } else if (mes.equals("08")) {
/* 5320 */       mesLetra = "Agosto";
/* 5321 */     } else if (mes.equals("09")) {
/* 5322 */       mesLetra = "Septiembre";
/* 5323 */     } else if (mes.equals("10")) {
/* 5324 */       mesLetra = "Octubre";
/* 5325 */     } else if (mes.equals("11")) {
/* 5326 */       mesLetra = "Noviembre";
/* 5327 */     } else if (mes.equals("12")) {
/* 5328 */       mesLetra = "Diciembre";
/*      */     } 
/* 5330 */     return mesLetra;
/*      */   }
/*      */   
/*      */   public void cargarPerfil() {
/* 5334 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 5335 */     if (this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("CAPTURISTA") || this.con.Campo.equals("RECURSOS HUMANOS") || this.con.Campo.equals("CONTRALORIA")) {
/* 5336 */       this.jTextField16.setEnabled(true);
/* 5337 */       this.jTextField17.setEnabled(true);
/* 5338 */       this.jTextField18.setEnabled(true);
/*      */       
/* 5340 */       this.jTextField23.setEnabled(true);
/*      */       
/* 5342 */       this.jTextField25.setEnabled(true);
/* 5343 */       this.jTextField26.setEnabled(true);
/* 5344 */       this.jTextField27.setEnabled(true);
/*      */       
/* 5346 */       this.jComboBox5.setEnabled(true);
/* 5347 */       this.jDateChooser7.setEnabled(true);
/* 5348 */       this.jDateChooser4.setEnabled(true);
/*      */       
/* 5350 */       this.jDateChooser5.setEnabled(true);
/* 5351 */       this.jFormattedTextField4.setEnabled(true);
/* 5352 */       this.jFormattedTextField5.setEnabled(true);
/*      */       
/* 5354 */       this.jRadioButton5.setEnabled(true);
/* 5355 */       this.jRadioButton6.setEnabled(true);
/* 5356 */       this.jTextField28.setEnabled(true);
/* 5357 */       this.jFormattedTextField9.setEnabled(true);
/*      */       
/* 5359 */       this.jRadioButton7.setEnabled(true);
/* 5360 */       this.jRadioButton8.setEnabled(true);
/* 5361 */       this.jTextField33.setEnabled(true);
/* 5362 */       this.jFormattedTextField6.setEnabled(true);
/*      */       
/* 5364 */       this.jComboBox6.setEnabled(true);
/* 5365 */       this.jTextField30.setEnabled(true);
/* 5366 */       this.jTextField35.setEnabled(true);
/*      */       
/* 5368 */       this.jSpinner1.setEnabled(true);
/* 5369 */       this.jComboBox7.setEnabled(true);
/* 5370 */       this.jDateChooser6.setEnabled(true);
/*      */       
/* 5372 */       this.jComboBox6.setEnabled(true);
/* 5373 */       this.jSpinner2.setEnabled(true);
/* 5374 */       this.jTextField40.setEnabled(true);
/*      */       
/* 5376 */       this.jTextField37.setEnabled(true);
/* 5377 */       this.jTextField38.setEnabled(true);
/* 5378 */       this.jTextField39.setEnabled(true);
/*      */       
/* 5380 */       this.jFormattedTextField7.setEnabled(true);
/* 5381 */       this.jTextField41.setEnabled(true);
/* 5382 */       this.jComboBox9.setEnabled(true);
/* 5383 */       this.jComboBox10.setEnabled(true);
/* 5384 */       this.jTextArea1.setEnabled(true);
/*      */     } else {
/*      */       
/* 5387 */       this.jTextField16.setEnabled(false);
/* 5388 */       this.jTextField17.setEnabled(false);
/* 5389 */       this.jTextField18.setEnabled(false);
/*      */       
/* 5391 */       this.jTextField20.setEnabled(false);
/* 5392 */       this.jTextField21.setEnabled(false);
/* 5393 */       this.jTextField22.setEnabled(false);
/*      */       
/* 5395 */       this.jTextField23.setEnabled(false);
/* 5396 */       this.jTextField24.setEnabled(false);
/* 5397 */       this.jComboBox4.setEnabled(false);
/*      */       
/* 5399 */       this.jTextField25.setEnabled(false);
/* 5400 */       this.jTextField26.setEnabled(false);
/* 5401 */       this.jTextField27.setEnabled(false);
/*      */       
/* 5403 */       this.jComboBox5.setEnabled(false);
/* 5404 */       this.jDateChooser7.setEnabled(false);
/* 5405 */       this.jDateChooser4.setEnabled(false);
/*      */       
/* 5407 */       this.jDateChooser5.setEnabled(false);
/* 5408 */       this.jFormattedTextField4.setEnabled(false);
/* 5409 */       this.jFormattedTextField5.setEnabled(false);
/*      */       
/* 5411 */       this.jRadioButton5.setEnabled(false);
/* 5412 */       this.jRadioButton6.setEnabled(false);
/* 5413 */       this.jTextField28.setEnabled(false);
/* 5414 */       this.jFormattedTextField9.setEnabled(false);
/*      */       
/* 5416 */       this.jRadioButton7.setEnabled(false);
/* 5417 */       this.jRadioButton8.setEnabled(false);
/* 5418 */       this.jTextField33.setEnabled(false);
/* 5419 */       this.jFormattedTextField6.setEnabled(false);
/*      */       
/* 5421 */       this.jComboBox8.setEnabled(false);
/* 5422 */       this.jTextField30.setEnabled(false);
/* 5423 */       this.jTextField35.setEnabled(false);
/*      */       
/* 5425 */       this.jSpinner1.setEnabled(false);
/* 5426 */       this.jComboBox7.setEnabled(false);
/* 5427 */       this.jDateChooser6.setEnabled(false);
/*      */       
/* 5429 */       this.jComboBox6.setEnabled(false);
/* 5430 */       this.jSpinner2.setEnabled(false);
/* 5431 */       this.jTextField40.setEnabled(false);
/*      */       
/* 5433 */       this.jTextField37.setEnabled(false);
/* 5434 */       this.jTextField38.setEnabled(false);
/* 5435 */       this.jTextField39.setEnabled(false);
/*      */       
/* 5437 */       this.jFormattedTextField7.setEnabled(false);
/* 5438 */       this.jTextField41.setEnabled(false);
/* 5439 */       this.jComboBox9.setEnabled(false);
/* 5440 */       this.jComboBox10.setEnabled(true);
/* 5441 */       this.jTextArea1.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 5446 */     String mayor = clave;
/* 5447 */     int MAYOR = Integer.parseInt(mayor);
/* 5448 */     String clave1 = "";
/* 5449 */     if (MAYOR < 10) {
/* 5450 */       clave1 = "0000" + MAYOR;
/* 5451 */     } else if (MAYOR < 100) {
/* 5452 */       clave1 = "000" + MAYOR;
/* 5453 */     } else if (MAYOR < 1000) {
/* 5454 */       clave1 = "00" + MAYOR;
/* 5455 */     } else if (MAYOR < 10000) {
/* 5456 */       clave1 = "0" + MAYOR;
/*      */     } else {
/* 5458 */       clave1 = "OP-" + MAYOR;
/*      */     } 
/* 5460 */     return clave1;
/*      */   }
/*      */   
/*      */   public String direccion() {
/* 5464 */     JFileChooser fileChooser = new JFileChooser();
/* 5465 */     fileChooser.setFileSelectionMode(1);
/*      */     
/* 5467 */     String fileName = "";
/* 5468 */     int retVal = fileChooser.showSaveDialog(null);
/* 5469 */     if (retVal == 0) {
/* 5470 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 5471 */       return fileName;
/*      */     } 
/* 5473 */     return "no";
/*      */   }
/*      */   
/*      */   class fotoCredencial
/*      */     implements Runnable {
/*      */     Thread t;
/* 5479 */     String num = "";
/*      */     
/*      */     fotoCredencial(String valor) {
/* 5482 */       this.t = new Thread(this);
/* 5483 */       this.num = valor;
/* 5484 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5491 */       ImageIcon tmpIcon = new ImageIcon(AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png");
/* 5492 */       AltaOperador.this.FOTO = AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png";
/* 5493 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(98, -1, 1));
/* 5494 */       AltaOperador.this.jLabel78.setText("");
/* 5495 */       AltaOperador.this.jLabel115.setText("");
/* 5496 */       AltaOperador.this.jLabel128.setText("");
/* 5497 */       if (temporal.getImageLoadStatus() == 4) {
/* 5498 */         AltaOperador.this.jLabel78.setText("Sin fotografía");
/* 5499 */         AltaOperador.this.jLabel115.setText("Sin fotografía");
/* 5500 */         AltaOperador.this.jLabel128.setText("Sin fotografía");
/*      */       } else {
/* 5502 */         AltaOperador.this.jLabel78.setText("");
/* 5503 */         AltaOperador.this.jLabel115.setText("");
/* 5504 */         AltaOperador.this.jLabel128.setText("");
/* 5505 */         AltaOperador.this.jLabel78.setIcon(temporal);
/* 5506 */         AltaOperador.this.jLabel115.setIcon(temporal);
/* 5507 */         AltaOperador.this.jLabel128.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirDatos
/*      */     implements Printable {
/* 5514 */     String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 5515 */     int opc = 0;
/* 5516 */     Graphics g2 = null; public int print(Graphics g, PageFormat f, int pageIndex) { int ind; Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; ImageIcon tmpIcon; String op, c1, c2, cadenaFecha2, año, mes, dia, fechaCompleta, fecha1, estado, valor; int inicia, lineas;
/*      */       String[] DES;
/*      */       int i, cont, l, j;
/* 5519 */       this.g2 = g;
/* 5520 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 5526 */           ind = AltaOperador.this.jTable3.getSelectedRow();
/* 5527 */           fuente = new Font("Dialog", 1, 7);
/* 5528 */           g.setFont(fuente);
/* 5529 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 15, 25);
/* 5530 */           fuente = new Font("Dialog", 0, 7);
/* 5531 */           g.setFont(fuente);
/* 5532 */           this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA, KM 32.5", 15, 35);
/* 5533 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN 67451", 15, 45);
/* 5534 */           this.g2.drawString("FMF901004UZ9", 15, 55);
/* 5535 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5536 */           img = imagen.getImage();
/* 5537 */           this.g2.drawImage(img, 64, 52, 55, 55, null);
/* 5538 */           formato = new SimpleDateFormat("yyyyMMdd");
/*      */           
/* 5540 */           tmpIcon = new ImageIcon(AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png");
/* 5541 */           img = tmpIcon.getImage();
/* 5542 */           this.g2.drawImage(img, 522, 17, 68, 90, null);
/* 5543 */           this.g2.drawLine(192, 17, 192, 105);
/* 5544 */           fuente = new Font("Dialog", 1, 11);
/* 5545 */           this.g2.setFont(fuente);
/* 5546 */           this.g2.drawString("OP-" + AltaOperador.this.jTextField19.getText().toUpperCase() + ": " + AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField18.getText().toUpperCase() + " " + AltaOperador.this.jTextField16.getText().toUpperCase(), 205, 25);
/*      */           
/* 5548 */           this.g2.setColor(Color.RED);
/* 5549 */           this.g2.drawRect(205, 30, 300, 60);
/* 5550 */           this.g2.setColor(new Color(204, 0, 0));
/* 5551 */           this.g2.fillRect(206, 31, 90, 58);
/*      */           
/* 5553 */           fuente = new Font("Dialog", 1, 9);
/* 5554 */           this.g2.setFont(fuente);
/* 5555 */           this.g2.setColor(Color.WHITE);
/* 5556 */           this.g2.drawString("TELÉFONO", 207, 42);
/* 5557 */           this.g2.drawString("NSS", 207, 56);
/* 5558 */           this.g2.drawString("CATEGORÍA", 207, 69);
/* 5559 */           this.g2.drawString("FECHA DE IMP", 207, 82);
/*      */           
/* 5561 */           op = "OPERADOR DE QUINTA RUEDA";
/*      */           
/* 5563 */           if (AltaOperador.this.jComboBox9.getSelectedIndex() != 0) {
/* 5564 */             op = "OPERADOR (FUNCIONARIO)";
/*      */           }
/*      */           
/* 5567 */           fuente = new Font("Dialog", 0, 9);
/* 5568 */           this.g2.setFont(fuente);
/* 5569 */           this.g2.setColor(Color.BLACK);
/* 5570 */           this.g2.drawString(AltaOperador.this.jFormattedTextField4.getText(), 305, 42);
/* 5571 */           this.g2.drawString(AltaOperador.this.jTextField25.getText().toUpperCase(), 305, 56);
/* 5572 */           this.g2.drawString(op, 305, 69);
/* 5573 */           this.g2.drawString(AltaOperador.this.cargarFechaHoy(), 305, 82);
/*      */           
/* 5575 */           this.g2.setColor(new Color(56, 93, 138));
/* 5576 */           this.g2.drawRoundRect(518, 15, 76, 94, 10, 10);
/*      */           
/* 5578 */           this.g2.setColor(Color.RED);
/* 5579 */           this.g2.fill3DRect(15, 112, 580, 7, true);
/*      */           
/* 5581 */           this.g2.setColor(Color.RED);
/* 5582 */           this.g2.drawLine(125, 136, 125, 239);
/* 5583 */           this.g2.drawRect(15, 135, 285, 105);
/* 5584 */           this.g2.setColor(Color.GRAY);
/* 5585 */           this.g2.fillRect(16, 136, 18, 103);
/* 5586 */           this.g2.setColor(Color.WHITE);
/* 5587 */           this.g2.fillRect(34, 136, 85, 103);
/* 5588 */           this.g2.fillRect(119, 136, 180, 103);
/* 5589 */           fuente = new Font("Dialog", 1, 5);
/* 5590 */           this.g2.setFont(fuente);
/* 5591 */           this.g2.setColor(Color.WHITE);
/* 5592 */           this.g2.drawString("D", 19, 177);
/* 5593 */           this.g2.drawString("A", 19, 184);
/* 5594 */           this.g2.drawString("T", 19, 191);
/* 5595 */           this.g2.drawString("O", 19, 198);
/* 5596 */           this.g2.drawString("S", 19, 205);
/*      */           
/* 5598 */           this.g2.drawString("P", 26, 158);
/* 5599 */           this.g2.drawString("E", 26, 165);
/* 5600 */           this.g2.drawString("R", 26, 172);
/* 5601 */           this.g2.drawString("S", 26, 179);
/* 5602 */           this.g2.drawString("O", 26, 186);
/* 5603 */           this.g2.drawString("N", 26, 193);
/* 5604 */           this.g2.drawString("A", 26, 200);
/* 5605 */           this.g2.drawString("L", 26, 207);
/* 5606 */           this.g2.drawString("E", 26, 214);
/* 5607 */           this.g2.drawString("S", 26, 221);
/*      */           
/* 5609 */           fuente = new Font("Dialog", 1, 7);
/* 5610 */           this.g2.setFont(fuente);
/* 5611 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 5613 */           this.g2.drawString("FECHA DE NAC", 37, 145);
/* 5614 */           this.g2.drawString("LUGAR DE NACIMIENTO", 37, 158);
/* 5615 */           this.g2.drawString("NÚM DE SEG SOCIAL", 37, 171);
/* 5616 */           this.g2.drawString("CURP", 37, 184);
/*      */           
/* 5618 */           this.g2.drawString("CARGO AUTOM NEXTEL", 37, 197);
/* 5619 */           this.g2.drawString("NEXTEL", 37, 210);
/* 5620 */           this.g2.drawString("CARGO", 200, 210);
/* 5621 */           this.g2.drawString("CARGO AUTOM INFON", 37, 223);
/* 5622 */           this.g2.drawString("INFONAVIT", 37, 236);
/* 5623 */           this.g2.drawString("CARGO", 200, 236);
/*      */           
/* 5625 */           fuente = new Font("Dialog", 0, 8);
/* 5626 */           this.g2.setFont(fuente);
/*      */           
/* 5628 */           c1 = "NO";
/* 5629 */           c2 = "NO";
/*      */           
/* 5631 */           if (!AltaOperador.this.jRadioButton5.isSelected()) {
/* 5632 */             c1 = "SI";
/*      */           }
/*      */           
/* 5635 */           if (!AltaOperador.this.jRadioButton7.isSelected()) {
/* 5636 */             c2 = "SI";
/*      */           }
/*      */           
/* 5639 */           cadenaFecha2 = formato.format(AltaOperador.this.jDateChooser5.getDate());
/* 5640 */           año = cadenaFecha2.substring(0, 4);
/* 5641 */           mes = cadenaFecha2.substring(4, 6);
/* 5642 */           dia = cadenaFecha2.substring(6, 8);
/* 5643 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5645 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5646 */           this.g2.drawString(fecha1, 130, 145);
/* 5647 */           this.g2.drawString(AltaOperador.this.jTextField41.getText().toUpperCase(), 130, 158);
/* 5648 */           this.g2.drawString(AltaOperador.this.jTextField25.getText().toUpperCase(), 130, 171);
/* 5649 */           this.g2.drawString(AltaOperador.this.jTextField26.getText().toUpperCase(), 130, 184);
/* 5650 */           this.g2.drawString(c1, 130, 197);
/* 5651 */           this.g2.drawString(AltaOperador.this.jTextField28.getText().toUpperCase(), 130, 210);
/* 5652 */           this.g2.drawString(AltaOperador.this.jFormattedTextField9.getText(), 233, 210);
/* 5653 */           this.g2.drawString(c2, 130, 223);
/* 5654 */           this.g2.drawString(AltaOperador.this.jTextField33.getText().toUpperCase(), 130, 236);
/* 5655 */           this.g2.drawString(AltaOperador.this.jFormattedTextField6.getText(), 233, 236);
/* 5656 */           this.g2.setColor(Color.RED);
/* 5657 */           this.g2.drawLine(125, 136, 125, 239);
/*      */           
/* 5659 */           this.g2.setColor(Color.WHITE);
/* 5660 */           this.g2.fillRect(301, 130, 80, 190);
/*      */           
/* 5662 */           this.g2.setColor(Color.RED);
/* 5663 */           this.g2.drawRect(310, 135, 285, 80);
/* 5664 */           this.g2.setColor(Color.GRAY);
/* 5665 */           this.g2.fillRect(311, 136, 18, 78);
/* 5666 */           this.g2.setColor(Color.WHITE);
/* 5667 */           this.g2.fillRect(329, 136, 85, 78);
/* 5668 */           this.g2.fillRect(414, 136, 180, 78);
/* 5669 */           fuente = new Font("Dialog", 1, 5);
/* 5670 */           this.g2.setFont(fuente);
/* 5671 */           this.g2.setColor(Color.WHITE);
/* 5672 */           this.g2.drawString("D", 318, 144);
/* 5673 */           this.g2.drawString("O", 318, 152);
/* 5674 */           this.g2.drawString("M", 318, 160);
/* 5675 */           this.g2.drawString("I", 318, 168);
/* 5676 */           this.g2.drawString("C", 318, 176);
/* 5677 */           this.g2.drawString("I", 318, 184);
/* 5678 */           this.g2.drawString("L", 318, 192);
/* 5679 */           this.g2.drawString("I", 318, 200);
/* 5680 */           this.g2.drawString("O", 318, 208);
/*      */           
/* 5682 */           fuente = new Font("Dialog", 1, 7);
/* 5683 */           this.g2.setFont(fuente);
/* 5684 */           this.g2.setColor(Color.BLACK);
/* 5685 */           this.g2.drawString("CALLE", 332, 145);
/* 5686 */           this.g2.drawString("NÚMERO", 332, 158);
/* 5687 */           this.g2.drawString("COLONIA", 332, 171);
/* 5688 */           this.g2.drawString("CIUDAD", 332, 184);
/* 5689 */           this.g2.drawString("CÓDIGO POSTAL", 332, 197);
/* 5690 */           this.g2.drawString("ESTADO", 332, 210);
/*      */ 
/*      */           
/* 5693 */           estado = String.valueOf(AltaOperador.this.jComboBox4.getSelectedItem()) + String.valueOf(AltaOperador.this.jComboBox4.getSelectedItem());
/* 5694 */           if (estado.equals("SELECCIONA UNO...")) {
/* 5695 */             estado = "";
/*      */           }
/* 5697 */           fuente = new Font("Dialog", 0, 8);
/* 5698 */           this.g2.setFont(fuente);
/* 5699 */           this.g2.setColor(Color.BLACK);
/* 5700 */           this.g2.drawString(AltaOperador.this.jTextField20.getText().toUpperCase(), 425, 145);
/* 5701 */           this.g2.drawString(AltaOperador.this.jTextField21.getText().toUpperCase(), 425, 158);
/* 5702 */           this.g2.drawString(AltaOperador.this.jTextField1.getText() + " - " + AltaOperador.this.jTextField1.getText(), 425, 171);
/* 5703 */           this.g2.drawString(AltaOperador.this.jTextField2.getText() + " - " + AltaOperador.this.jTextField2.getText(), 425, 184);
/* 5704 */           this.g2.drawString(AltaOperador.this.jTextField23.getText().toUpperCase(), 425, 197);
/* 5705 */           this.g2.drawString(AltaOperador.this.jTextField3.getText() + " - " + AltaOperador.this.jTextField3.getText(), 425, 210);
/* 5706 */           this.g2.setColor(Color.RED);
/* 5707 */           this.g2.drawLine(420, 136, 420, 215);
/*      */           
/* 5709 */           this.g2.setColor(Color.RED);
/* 5710 */           this.g2.drawRect(15, 250, 285, 28);
/* 5711 */           this.g2.setColor(Color.GRAY);
/* 5712 */           this.g2.fillRect(16, 251, 18, 26);
/* 5713 */           this.g2.setColor(Color.WHITE);
/* 5714 */           this.g2.fillRect(34, 251, 85, 26);
/* 5715 */           this.g2.fillRect(119, 251, 180, 26);
/* 5716 */           this.g2.fillRect(210, 251, 35, 26);
/* 5717 */           fuente = new Font("Dialog", 1, 5);
/* 5718 */           this.g2.setFont(fuente);
/* 5719 */           this.g2.setColor(Color.WHITE);
/* 5720 */           this.g2.drawString("L", 19, 257);
/* 5721 */           this.g2.drawString("I", 19, 263);
/* 5722 */           this.g2.drawString("C", 19, 269);
/* 5723 */           this.g2.drawString("E", 19, 275);
/*      */           
/* 5725 */           this.g2.drawString("N", 26, 257);
/* 5726 */           this.g2.drawString("C", 26, 263);
/* 5727 */           this.g2.drawString("I", 26, 269);
/* 5728 */           this.g2.drawString("A", 26, 275);
/*      */           
/* 5730 */           fuente = new Font("Dialog", 1, 7);
/* 5731 */           this.g2.setFont(fuente);
/* 5732 */           this.g2.setColor(Color.BLACK);
/* 5733 */           this.g2.drawString("VENCIMIENTO", 37, 260);
/* 5734 */           this.g2.drawString("NÚM DE LICENCIA", 37, 273);
/* 5735 */           this.g2.drawString("TIPO", 217, 266);
/*      */           
/* 5737 */           fuente = new Font("Dialog", 0, 8);
/* 5738 */           this.g2.setFont(fuente);
/* 5739 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 5741 */           cadenaFecha2 = formato.format(AltaOperador.this.jDateChooser7.getDate());
/* 5742 */           año = cadenaFecha2.substring(0, 4);
/* 5743 */           mes = cadenaFecha2.substring(4, 6);
/* 5744 */           dia = cadenaFecha2.substring(6, 8);
/* 5745 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5747 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5748 */           this.g2.drawString(fecha1, 130, 260);
/* 5749 */           this.g2.drawString(AltaOperador.this.jTextField27.getText().toUpperCase(), 130, 273);
/*      */           
/* 5751 */           fuente = new Font("Dialog", 0, 12);
/* 5752 */           this.g2.setFont(fuente);
/* 5753 */           this.g2.drawString(String.valueOf(AltaOperador.this.jComboBox5.getSelectedItem()), 265, 269);
/*      */           
/* 5755 */           this.g2.setColor(Color.RED);
/* 5756 */           this.g2.drawLine(125, 250, 125, 278);
/* 5757 */           this.g2.drawLine(245, 250, 245, 278);
/* 5758 */           this.g2.drawLine(207, 250, 207, 278);
/*      */ 
/*      */           
/* 5761 */           this.g2.setColor(Color.RED);
/* 5762 */           this.g2.drawRect(310, 225, 285, 132);
/* 5763 */           this.g2.setColor(Color.GRAY);
/* 5764 */           this.g2.fillRect(311, 226, 18, 130);
/* 5765 */           this.g2.setColor(Color.WHITE);
/* 5766 */           this.g2.fillRect(329, 226, 85, 130);
/* 5767 */           this.g2.fillRect(414, 226, 180, 130);
/* 5768 */           fuente = new Font("Dialog", 1, 5);
/* 5769 */           this.g2.setFont(fuente);
/* 5770 */           this.g2.drawString("D", 314, 260);
/* 5771 */           this.g2.drawString("A", 314, 268);
/* 5772 */           this.g2.drawString("T", 314, 276);
/* 5773 */           this.g2.drawString("O", 314, 284);
/* 5774 */           this.g2.drawString("S", 314, 292);
/*      */           
/* 5776 */           this.g2.drawString("D", 314, 308);
/* 5777 */           this.g2.drawString("E", 314, 316);
/* 5778 */           this.g2.drawString("L", 314, 324);
/*      */           
/* 5780 */           this.g2.drawString("C", 321, 262);
/* 5781 */           this.g2.drawString("O", 321, 270);
/* 5782 */           this.g2.drawString("N", 321, 278);
/* 5783 */           this.g2.drawString("T", 321, 289);
/* 5784 */           this.g2.drawString("R", 321, 297);
/* 5785 */           this.g2.drawString("A", 321, 305);
/* 5786 */           this.g2.drawString("T", 321, 313);
/* 5787 */           this.g2.drawString("O", 321, 321);
/*      */           
/* 5789 */           fuente = new Font("Dialog", 1, 7);
/* 5790 */           this.g2.setFont(fuente);
/* 5791 */           this.g2.setColor(Color.BLACK);
/* 5792 */           this.g2.drawString("FECHA DE INGRESO", 332, 235);
/* 5793 */           this.g2.drawString("DÍAS DEL CONTRATO", 332, 248);
/* 5794 */           this.g2.drawString("DISTINTIVO", 332, 261);
/* 5795 */           this.g2.drawString("CONTRATADO POR", 332, 274);
/* 5796 */           this.g2.drawString("TESTIGO 1", 332, 287);
/* 5797 */           this.g2.drawString("TESTIGO 2", 332, 300);
/* 5798 */           this.g2.drawString("RECOMENDADO POR", 332, 313);
/* 5799 */           this.g2.drawString("SALARIO NOMINAL", 332, 326);
/* 5800 */           this.g2.drawString("TELÉFONO", 332, 339);
/* 5801 */           this.g2.drawString("CELULAR", 495, 339);
/* 5802 */           this.g2.drawString("ÚLTIMO INGRESO", 332, 352);
/*      */           
/* 5804 */           fuente = new Font("Dialog", 0, 8);
/* 5805 */           this.g2.setFont(fuente);
/* 5806 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 5808 */           cadenaFecha2 = formato.format(AltaOperador.this.jDateChooser4.getDate());
/* 5809 */           año = cadenaFecha2.substring(0, 4);
/* 5810 */           mes = cadenaFecha2.substring(4, 6);
/* 5811 */           dia = cadenaFecha2.substring(6, 8);
/* 5812 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5814 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5815 */           this.g2.drawString(fecha1, 425, 235);
/* 5816 */           this.g2.drawString(String.valueOf(AltaOperador.this.jSpinner1.getValue()), 425, 248);
/* 5817 */           this.g2.drawString(String.valueOf(AltaOperador.this.jComboBox7.getSelectedItem()), 425, 261);
/* 5818 */           this.g2.drawString(AltaOperador.this.jTextField40.getText().toUpperCase(), 425, 274);
/* 5819 */           this.g2.drawString(AltaOperador.this.jTextField37.getText().toUpperCase(), 425, 287);
/* 5820 */           this.g2.drawString(AltaOperador.this.jTextField38.getText().toUpperCase(), 425, 300);
/* 5821 */           this.g2.drawString(AltaOperador.this.jTextField39.getText().toUpperCase(), 425, 313);
/* 5822 */           this.g2.drawString(AltaOperador.this.jFormattedTextField7.getText(), 425, 326);
/* 5823 */           this.g2.drawString(AltaOperador.this.jFormattedTextField4.getText(), 425, 339);
/* 5824 */           this.g2.drawString(AltaOperador.this.jFormattedTextField5.getText(), 532, 339);
/*      */ 
/*      */           
/* 5827 */           cadenaFecha2 = formato.format(AltaOperador.this.jDateChooser6.getDate());
/* 5828 */           año = cadenaFecha2.substring(0, 4);
/* 5829 */           mes = cadenaFecha2.substring(4, 6);
/* 5830 */           dia = cadenaFecha2.substring(6, 8);
/* 5831 */           fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 5833 */           fecha1 = dia + "/" + dia + "/" + mes;
/* 5834 */           this.g2.drawString(fecha1, 425, 352);
/* 5835 */           this.g2.setColor(Color.RED);
/* 5836 */           this.g2.drawLine(420, 225, 420, 357);
/*      */ 
/*      */           
/* 5839 */           this.g2.setColor(Color.RED);
/* 5840 */           this.g2.drawRect(15, 288, 285, 69);
/* 5841 */           this.g2.setColor(Color.GRAY);
/* 5842 */           this.g2.fillRect(16, 289, 18, 67);
/* 5843 */           this.g2.setColor(Color.WHITE);
/* 5844 */           this.g2.fillRect(34, 289, 85, 67);
/* 5845 */           this.g2.fillRect(119, 289, 180, 67);
/* 5846 */           fuente = new Font("Dialog", 1, 5);
/* 5847 */           this.g2.setFont(fuente);
/* 5848 */           this.g2.setColor(Color.WHITE);
/* 5849 */           this.g2.drawString("O", 19, 311);
/* 5850 */           this.g2.drawString("T", 19, 318);
/* 5851 */           this.g2.drawString("R", 19, 325);
/* 5852 */           this.g2.drawString("O", 19, 332);
/* 5853 */           this.g2.drawString("S", 19, 339);
/*      */           
/* 5855 */           this.g2.drawString("D", 26, 311);
/* 5856 */           this.g2.drawString("A", 26, 318);
/* 5857 */           this.g2.drawString("T", 26, 325);
/* 5858 */           this.g2.drawString("O", 26, 332);
/* 5859 */           this.g2.drawString("S", 26, 339);
/*      */           
/* 5861 */           fuente = new Font("Dialog", 1, 7);
/* 5862 */           this.g2.setFont(fuente);
/* 5863 */           this.g2.setColor(Color.BLACK);
/* 5864 */           this.g2.drawString("NÚMERO DE HIJOS", 37, 298);
/* 5865 */           this.g2.drawString("ESTADO CIVIL", 37, 311);
/* 5866 */           this.g2.drawString("TRACTOR", 37, 324);
/* 5867 */           this.g2.drawString("REMOLQUE", 37, 337);
/* 5868 */           this.g2.drawString("ESPECIALIZADO EN", 37, 351);
/*      */           
/* 5870 */           fuente = new Font("Dialog", 0, 8);
/* 5871 */           this.g2.setFont(fuente);
/* 5872 */           this.g2.setColor(Color.BLACK);
/* 5873 */           this.g2.drawString(String.valueOf(AltaOperador.this.jSpinner2.getValue()), 130, 298);
/* 5874 */           this.g2.drawString(String.valueOf(AltaOperador.this.jComboBox6.getSelectedItem()), 130, 311);
/* 5875 */           this.g2.drawString(AltaOperador.this.jTextField30.getText().toUpperCase(), 130, 324);
/* 5876 */           this.g2.drawString(AltaOperador.this.jTextField35.getText().toUpperCase(), 130, 337);
/* 5877 */           this.g2.drawString(String.valueOf(AltaOperador.this.jComboBox8.getSelectedItem()) + String.valueOf(AltaOperador.this.jComboBox8.getSelectedItem()), 130, 351);
/* 5878 */           this.g2.setColor(Color.RED);
/* 5879 */           this.g2.drawLine(125, 288, 125, 357);
/*      */ 
/*      */           
/* 5882 */           this.g2.setColor(Color.RED);
/* 5883 */           this.g2.drawRect(15, 367, 580, 140);
/* 5884 */           this.g2.setColor(Color.GRAY);
/* 5885 */           this.g2.fillRect(16, 368, 18, 138);
/* 5886 */           this.g2.setColor(Color.WHITE);
/* 5887 */           this.g2.fillRect(34, 368, 560, 138);
/*      */           
/* 5889 */           fuente = new Font("Dialog", 1, 5);
/* 5890 */           this.g2.setFont(fuente);
/* 5891 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 5893 */           this.g2.drawString("A", 19, 417);
/* 5894 */           this.g2.drawString("L", 19, 424);
/* 5895 */           this.g2.drawString("G", 19, 431);
/* 5896 */           this.g2.drawString("U", 19, 438);
/* 5897 */           this.g2.drawString("N", 19, 445);
/* 5898 */           this.g2.drawString("A", 19, 452);
/* 5899 */           this.g2.drawString("S", 19, 459);
/*      */           
/* 5901 */           this.g2.drawString("R", 26, 403);
/* 5902 */           this.g2.drawString("E", 26, 410);
/* 5903 */           this.g2.drawString("F", 26, 417);
/* 5904 */           this.g2.drawString("E", 26, 424);
/* 5905 */           this.g2.drawString("R", 26, 431);
/* 5906 */           this.g2.drawString("E", 26, 438);
/* 5907 */           this.g2.drawString("N", 26, 445);
/* 5908 */           this.g2.drawString("C", 26, 452);
/* 5909 */           this.g2.drawString("I", 26, 459);
/* 5910 */           this.g2.drawString("A", 26, 466);
/* 5911 */           this.g2.drawString("S", 26, 473);
/*      */ 
/*      */           
/* 5914 */           fuente = new Font("Dialog", 0, 7);
/* 5915 */           this.g2.setFont(fuente);
/* 5916 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5924 */           valor = AltaOperador.this.jTextArea1.getText().toUpperCase();
/*      */           
/* 5926 */           inicia = 377;
/* 5927 */           lineas = valor.length() / 150;
/* 5928 */           lineas += 2;
/* 5929 */           DES = new String[lineas];
/* 5930 */           for (i = 0; i < DES.length; i++) {
/* 5931 */             DES[i] = new String("");
/*      */           }
/* 5933 */           cont = 0;
/* 5934 */           l = 0;
/* 5935 */           for (j = 0; j < valor.length(); j++) {
/* 5936 */             if (cont <= 150) {
/* 5937 */               DES[l] = DES[l] + DES[l];
/* 5938 */               cont++;
/*      */             } else {
/* 5940 */               DES[l] = DES[l] + DES[l];
/* 5941 */               cont = 0;
/* 5942 */               l++;
/*      */             } 
/*      */           } 
/* 5945 */           for (j = 0; j < DES.length; j++) {
/* 5946 */             g.drawString(DES[j], 37, inicia);
/* 5947 */             inicia += 8;
/*      */           } 
/*      */           
/* 5950 */           this.g2.drawString("_________________________________________", 15, 565);
/* 5951 */           this.g2.drawString(AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField18.getText().toUpperCase(), 15, 575);
/* 5952 */           this.g2.drawString("EMPLEADO", 15, 585);
/*      */           
/* 5954 */           this.DATOS = AltaOperador.this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + AltaOperador.this.USUARIO + "'", 3);
/* 5955 */           this.g2.drawString("_________________________________________", 15, 645);
/* 5956 */           this.g2.drawString(this.DATOS[0] + " " + this.DATOS[0] + " " + this.DATOS[1], 15, 655);
/* 5957 */           this.g2.drawString("EMPRESA", 15, 665);
/*      */           
/* 5959 */           this.g2.setColor(Color.RED);
/* 5960 */           this.g2.drawRect(310, 517, 285, 150);
/* 5961 */           this.g2.setColor(Color.GRAY);
/* 5962 */           this.g2.fillRect(311, 518, 18, 148);
/* 5963 */           this.g2.setColor(Color.WHITE);
/* 5964 */           this.g2.fillRect(329, 517, 85, 148);
/* 5965 */           this.g2.fillRect(414, 517, 180, 148);
/*      */           
/* 5967 */           this.g2.setColor(Color.RED);
/* 5968 */           this.g2.drawLine(310, 592, 595, 592);
/*      */           
/* 5970 */           fuente = new Font("Dialog", 1, 7);
/* 5971 */           this.g2.setFont(fuente);
/* 5972 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 5974 */           this.g2.drawString("A", 318, 539);
/* 5975 */           this.g2.drawString("L", 318, 552);
/* 5976 */           this.g2.drawString("T", 318, 565);
/* 5977 */           this.g2.drawString("A", 318, 578);
/*      */           
/* 5979 */           this.g2.drawString("B", 318, 612);
/* 5980 */           this.g2.drawString("A", 318, 625);
/* 5981 */           this.g2.drawString("J", 318, 638);
/* 5982 */           this.g2.drawString("A", 318, 651);
/*      */           
/* 5984 */           fuente = new Font("Dialog", 1, 7);
/* 5985 */           this.g2.setFont(fuente);
/* 5986 */           this.g2.setColor(Color.BLACK);
/* 5987 */           this.g2.drawString("_____________________________________", 390, 567);
/* 5988 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 580);
/*      */           
/* 5990 */           this.g2.drawString("_____________________________________", 390, 640);
/* 5991 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 653);
/*      */           
/* 5993 */           this.g2.setColor(new Color(56, 93, 138));
/* 5994 */           this.g2.drawRect(15, 730, 580, 40);
/* 5995 */           fuente = new Font("Dialog", 1, 6);
/* 5996 */           this.g2.setFont(fuente);
/* 5997 */           this.g2.setColor(Color.BLACK);
/* 5998 */           this.g2.drawString("          EN COMPLETO USO DE MIS FACULTADES DECLARO BAJO PROTESTA DECIR VERDAD QUE LA INFORMACIÓN PROPORCIONADA EN EL PRESENTE ES CORRECTA Y ESTOY CONFORME", 17, 747);
/* 5999 */           this.g2.drawString("                                                                     CON LAS POLÍTICAS DE LA EMPRESA. QUEDANDO A SUS ÓRDENES DESDE EL PRIMER DÍA DEL CONTRATO", 26, 759);
/*      */           
/* 6001 */           return 0;
/*      */       } 
/* 6003 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6008 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6009 */       job.setPrintable(this);
/*      */       
/* 6011 */       PageFormat pf = job.defaultPage();
/* 6012 */       Paper papel = pf.getPaper();
/* 6013 */       papel.setSize(612.0D, 792.0D);
/* 6014 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6015 */       pf.setPaper(papel);
/* 6016 */       pf.setOrientation(1);
/* 6017 */       job.setPrintable(new ImprimirDatos(), pf);
/* 6018 */       job.defaultPage(pf);
/*      */       
/* 6020 */       boolean ok = job.printDialog();
/* 6021 */       if (ok)
/*      */         try {
/* 6023 */           job.print();
/* 6024 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirContrato implements Printable { String[] DATOS;
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     NumerosALetras letras;
/*      */     
/*      */     public ImprimirContrato() {
/* 6032 */       this.DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 6033 */       this.opc = 0;
/* 6034 */       this.g2 = null;
/* 6035 */       this.letras = null;
/*      */     }
/*      */     public void titulo() {
/* 6038 */       Font fuente = new Font("Dialog", 1, 13);
/* 6039 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void subtitulo() {
/* 6043 */       Font fuente = new Font("Dialog", 1, 11);
/* 6044 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void contenido() {
/* 6048 */       Font fuente = new Font("Dialog", 0, 10);
/* 6049 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public String dameMes(String mes) {
/* 6053 */       String mesLetra = "";
/* 6054 */       if (mes.equals("01")) {
/* 6055 */         mesLetra = "Enero";
/* 6056 */       } else if (mes.equals("02")) {
/* 6057 */         mesLetra = "Febrero";
/* 6058 */       } else if (mes.equals("03")) {
/* 6059 */         mesLetra = "Marzo";
/* 6060 */       } else if (mes.equals("04")) {
/* 6061 */         mesLetra = "Abril";
/* 6062 */       } else if (mes.equals("05")) {
/* 6063 */         mesLetra = "Mayo";
/* 6064 */       } else if (mes.equals("06")) {
/* 6065 */         mesLetra = "Junio";
/* 6066 */       } else if (mes.equals("07")) {
/* 6067 */         mesLetra = "Julio";
/* 6068 */       } else if (mes.equals("08")) {
/* 6069 */         mesLetra = "Agosto";
/* 6070 */       } else if (mes.equals("09")) {
/* 6071 */         mesLetra = "Septiembre";
/* 6072 */       } else if (mes.equals("10")) {
/* 6073 */         mesLetra = "Octubre";
/* 6074 */       } else if (mes.equals("11")) {
/* 6075 */         mesLetra = "Noviembre";
/* 6076 */       } else if (mes.equals("12")) {
/* 6077 */         mesLetra = "Diciembre";
/*      */       } 
/* 6079 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { SimpleDateFormat formato; String cadenaFecha1, año1, año2; int años; String año, mes, dia, mesLetra; Calendar hoy;
/*      */       String añoTermina, mesTermina, diaTermina, otroMes;
/*      */       Font fuente;
/*      */       String letraTexto;
/* 6083 */       this.g2 = (Graphics2D)g;
/* 6084 */       f.setOrientation(1);
/* 6085 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 6091 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6092 */           cadenaFecha1 = formato.format(AltaOperador.this.jDateChooser5.getDate());
/* 6093 */           año1 = cadenaFecha1.substring(0, 4);
/*      */           
/* 6095 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6096 */           cadenaFecha1 = formato.format(new Date());
/* 6097 */           año2 = cadenaFecha1.substring(0, 4);
/* 6098 */           años = Integer.parseInt(año2) - Integer.parseInt(año1);
/*      */           
/* 6100 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6101 */           cadenaFecha1 = formato.format(AltaOperador.this.jDateChooser6.getDate());
/* 6102 */           año = cadenaFecha1.substring(0, 4);
/* 6103 */           mes = cadenaFecha1.substring(4, 6);
/* 6104 */           dia = cadenaFecha1.substring(6, 8);
/* 6105 */           mesLetra = dameMes(mes);
/*      */ 
/*      */           
/* 6108 */           hoy = Calendar.getInstance();
/* 6109 */           hoy.setTime(AltaOperador.this.jDateChooser6.getDate());
/* 6110 */           hoy.add(5, Integer.parseInt(String.valueOf(AltaOperador.this.jSpinner1.getValue())));
/*      */           
/* 6112 */           cadenaFecha1 = formato.format(hoy.getTime());
/* 6113 */           añoTermina = cadenaFecha1.substring(0, 4);
/* 6114 */           mesTermina = cadenaFecha1.substring(4, 6);
/* 6115 */           diaTermina = cadenaFecha1.substring(6, 8);
/*      */           
/* 6117 */           otroMes = dameMes(mesTermina);
/*      */ 
/*      */           
/* 6120 */           fuente = new Font("Dialog", 1, 13);
/* 6121 */           this.g2.setFont(fuente);
/* 6122 */           titulo();
/* 6123 */           this.g2.drawString("                       CONTRATO INDIVIDUAL DE TRABAJO POR OBRA DETERMINADA", 15, 50);
/* 6124 */           subtitulo();
/* 6125 */           this.g2.drawString("A. PARTES CONTRATANTES:", 15, 90);
/* 6126 */           contenido();
/* 6127 */           this.g2.drawString("Como Patrón, la Empresa: FLETES Y MATERIALES FORSIS S.A. DE C.V.", 15, 120);
/* 6128 */           this.g2.drawString("Como Trabajador: " + AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField18.getText().toUpperCase() + " " + AltaOperador.this.jTextField16.getText().toUpperCase(), 15, 133);
/* 6129 */           subtitulo();
/* 6130 */           this.g2.drawString("B. DECLARACIONES:", 15, 163);
/* 6131 */           contenido();
/* 6132 */           this.g2.drawString("I.-Declara la Empresa:", 15, 193);
/* 6133 */           this.g2.drawString("    a) Que es una Sociedad Mercantil Mexicana, constituída conforme a las leyes del país.", 15, 206);
/* 6134 */           this.g2.drawString("    b) Tener su domicilio social en la Autopista  Monterrey-Cadereyta  kilómetro 32.5 en la Ciudad de Cadereyta Jiménez, N.L. ", 15, 219);
/* 6135 */           this.g2.drawString("    c) Estar dedicada conforme a su objeto social a: Servicio de Autotransporte de carga Federal", 15, 232);
/*      */           
/* 6137 */           this.g2.drawString("II.-Declara el Trabajador:", 15, 245);
/* 6138 */           this.g2.drawString("    a) Que es de nacionalidad  Mexicana, tener " + años + " años de edad, estado civil " + String.valueOf(AltaOperador.this.jComboBox6.getSelectedItem()) + ", con domicilio actual:", 15, 257);
/* 6139 */           fuente = new Font("Dialog", 0, 9);
/* 6140 */           this.g2.setFont(fuente);
/* 6141 */           this.g2.drawString("         " + AltaOperador.this.jTextField20.getText() + " " + AltaOperador.this.jTextField21.getText() + " " + AltaOperador.this.jTextField22.getText() + " " + AltaOperador.this.jTextField23.getText() + " " + AltaOperador.this.jTextField24.getText(), 15, 270);
/* 6142 */           contenido();
/* 6143 */           this.g2.drawString("    b) Que tiene los conocimientos y experiencia necesaria para prestar sus servicios a la Empresa, con la categoría de Operador", 15, 283);
/* 6144 */           this.g2.drawString("        de Tracto Camión, con licencia Federal No. " + AltaOperador.this.jTextField27.getText() + " Categoria " + String.valueOf(AltaOperador.this.jComboBox5.getSelectedItem()) + ", expedida por la Secretaría de Comunicaciones y", 15, 296);
/* 6145 */           this.g2.drawString("        Transportes en Veracruz, Ver.", 15, 309);
/* 6146 */           this.g2.drawString("III.-La Empresa y el Trabajador: ", 15, 322);
/* 6147 */           this.g2.drawString("    Están conformes en celebrar este Contrato por Obra Determinada de acuerdo a las condiciones que en el se pactan, a partir de", 15, 335);
/* 6148 */           this.g2.drawString("    esta fecha " + dia + " de " + mesLetra + " de " + año + " y concluirá el día  " + diaTermina + " de " + otroMes + " de " + añoTermina + ", lapso aproximado en el cual se considera", 15, 348);
/* 6149 */           this.g2.drawString("    concluirá el trabajador la obra determinada para que se le contrata. En esta fecha se dará por consiguiente terminado el", 15, 361);
/* 6150 */           this.g2.drawString("    presente contrato sin responsabilidad para las partes en los términos de los artículos 36 y 37, fracción I y III de la Ley Federal", 15, 374);
/* 6151 */           this.g2.drawString("    del Trabajo en vigor.", 15, 387);
/* 6152 */           subtitulo();
/* 6153 */           this.g2.drawString("C. CONDICIONES DE TRABAJO:", 15, 417);
/* 6154 */           contenido();
/* 6155 */           this.g2.drawString("PRIMERA: El trabajador queda obligado a desempeñar las labores que corresponden al puesto de Operador de Tracto Camión", 15, 447);
/* 6156 */           this.g2.drawString("Foráneo, cuyas labores consisten primordialmente en realizar los recorridos que la empresa le indique tomando en cuenta las", 15, 460);
/* 6157 */           this.g2.drawString("leyes y reglamentos que rigen el servicio federal público Federal de Autotransporte en todas las carreteras de la República", 15, 473);
/* 6158 */           this.g2.drawString("Mexicana y en general todas las que sean similares a dicha actividad, toda vez que la enumeración de las labores anteriores es", 15, 486);
/* 6159 */           this.g2.drawString("enunciativa, quedando por tanto obligado el trabajador a ejecutar cualquier trabajo anexo o conexo con su labor principal, en el", 15, 499);
/* 6160 */           this.g2.drawString("lugar que por la naturaleza de sus funciones le asigne la Empresa.", 15, 512);
/*      */           
/* 6162 */           this.g2.drawString("SEGUNDA: La duración de la relación de trabajo será de " + String.valueOf(AltaOperador.this.jSpinner1.getValue()) + " días, tiempo que considera suficiente LA EMPRESA para que", 15, 542);
/* 6163 */           this.g2.drawString("concluya el exceso de carga, traslado y descarga de materiales, que tiene en su departamento de Trafico, que sólo es posible", 15, 555);
/* 6164 */           this.g2.drawString("satisfacer por su carácter extraordinario, transitorio y temporal con personal eventual.", 15, 568);
/*      */           
/* 6166 */           this.g2.drawString("TERCERA: Por los servicios que preste EL TRABAJADOR a LA EMPRESA durante la relación de trabajo existente entre ambos,", 15, 598);
/* 6167 */           this.letras = new NumerosALetras(Double.parseDouble(String.valueOf(AltaOperador.this.jFormattedTextField7.getValue())), "M.N.");
/* 6168 */           letraTexto = this.letras.regresaNumero();
/* 6169 */           this.g2.drawString("percibirá un salario nominal de " + AltaOperador.this.jFormattedTextField7.getText() + " (" + letraTexto + "), misma que le será pagada al Trabajador", 15, 611);
/* 6170 */           this.g2.drawString("directamente por LA EMPRESA, en moneda del curso legal, en el lugar en donde preste sus servicios, durante las horas de trabajo", 15, 624);
/*      */           
/* 6172 */           this.g2.drawString("CUARTA: El pago de salario se verificará en forma, el último día hábil de cada semana laboral vencida.", 15, 654);
/*      */           
/* 6174 */           this.g2.drawString("QUINTA: Atendiendo la naturaleza de la actividad contratada se establece la posibilidad de que la jornada laboral administre, con", 15, 684);
/* 6175 */           this.g2.drawString("arreglos a los usos y costumbres que se suscitan en la práctica, disfrutando el trabajador de tiempo suficiente para tomar sus", 15, 697);
/* 6176 */           this.g2.drawString("alimentos y descansar, en la forma prevista por la ley de la materia.", 15, 710);
/* 6177 */           this.g2.drawString("_______________________________________________________________________________________________________", 15, 750);
/* 6178 */           fuente = new Font("Dialog", 1, 7);
/* 6179 */           this.g2.setFont(fuente);
/* 6180 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.                                                                                                                                                                                                        Página 1/2", 15, 763);
/* 6181 */           this.g2.drawString(AltaOperador.this.NOMBRECOMPLETO, 15, 774);
/* 6182 */           this.g2.drawString(AltaOperador.this.cargarFechaHoy(), 549, 774);
/* 6183 */           return 0;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 1:
/* 6189 */           contenido();
/* 6190 */           this.g2.drawString("SEXTA: En virtud  de que no es factible establecer un control de asistencias o puntualidad mediante tarjetas o listas de nómina,", 15, 90);
/* 6191 */           this.g2.drawString("no existe una determinación legal para laborar tiempo extra.", 15, 103);
/*      */           
/* 6193 */           this.g2.drawString("SEPTIMA: Serán días de descanso obligatorio, con goce de salario, cualesquiera de los siguientes días que se cumplan dentro del", 15, 133);
/* 6194 */           this.g2.drawString("término de vigencia de la relación de trabajo: 1o. de Enero, 5 de Febrero, 21 de Marzo, 1o. de Mayo, 16 de Septiembre", 15, 146);
/* 6195 */           this.g2.drawString("20 de Noviembre, 25 de Diciembre de cada año y el 1o. de Diciembre cuando corresponda a la transmisión del", 15, 159);
/* 6196 */           this.g2.drawString("Poder Ejecutivo Federal.", 15, 172);
/*      */           
/* 6198 */           this.g2.drawString("OCTAVA: Son causas de terminación de la relación de trabajo las siguientes:", 15, 202);
/* 6199 */           this.g2.drawString("    a) La conclusión de la labor extraordinaria a que se refiere la cláusula décima segunda de éste documento, ya que tal labor es", 15, 215);
/* 6200 */           this.g2.drawString("    la causa que motiva y origina la celebración de éste contrato.", 15, 228);
/* 6201 */           this.g2.drawString("    b) El hecho que durante los primeros 30 días de prestación de servicio, la Empresa se percate que el trabajador carece de", 15, 241);
/* 6202 */           this.g2.drawString("    los conocimientos, experiencia y capacidad que ha manifestado tener para el trabajo que se le encomienda.", 15, 254);
/* 6203 */           this.g2.drawString("    c) Por rescisión de este contrato, por incumplimiento que cualesquiera de las partes dé al mismo en los términos y por las", 15, 267);
/* 6204 */           this.g2.drawString("    causas previstas en los artículos 46, 47 y 51 de la Ley Federal del Trabajo.", 15, 280);
/*      */           
/* 6206 */           this.g2.drawString("NOVENA: El Trabajador a la terminación de su contrato eventual será cubierto por la Empresa en forma proporcional de acuerdo", 15, 310);
/* 6207 */           this.g2.drawString("con el número de días trabajados, de los siguientes conceptos:", 15, 323);
/* 6208 */           this.g2.drawString("a) 6 días de vacaciones por 12 meses de servicios;", 15, 336);
/* 6209 */           this.g2.drawString("b) 15 días de salario por 12 meses de servicios por aguinaldo anual.", 15, 349);
/*      */           
/* 6211 */           this.g2.drawString("DECIMA: El Trabajador será capacitado o adiestrado en los términos de los planes y programas establecidos o que se establezcan", 15, 379);
/* 6212 */           this.g2.drawString("en la Empresa.", 15, 392);
/*      */           
/* 6214 */           this.g2.drawString("      a) DECIMA PRIMERA:  El trabajador deberá cumplir con las obligaciones y condiciones de trabajo establecidas en la empresa.", 15, 422);
/*      */           
/* 6216 */           this.g2.drawString("      b) DECIMA SEGUNDA: La obra determinada para la cual es contratado el trabajador consiste en: exceso de carga, traslado", 15, 452);
/* 6217 */           this.g2.drawString("       y descarga de materiales.", 15, 465);
/*      */           
/* 6219 */           titulo();
/* 6220 */           this.g2.drawString("CONFORMES", 260, 515);
/* 6221 */           contenido();
/* 6222 */           this.g2.drawString("EL PATRÓN", 100, 555);
/* 6223 */           this.g2.drawString("EL TRABAJADOR", 410, 555);
/* 6224 */           subtitulo();
/* 6225 */           this.g2.drawString(AltaOperador.this.jTextField40.getText().toUpperCase(), 50, 605);
/* 6226 */           this.g2.drawString(AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField18.getText().toUpperCase(), 360, 605);
/* 6227 */           contenido();
/* 6228 */           this.g2.drawString("TESTIGO", 280, 645);
/* 6229 */           subtitulo();
/* 6230 */           this.g2.drawString(AltaOperador.this.jTextField37.getText().toUpperCase(), 215, 695);
/* 6231 */           contenido();
/* 6232 */           this.g2.drawString("_______________________________________________________________________________________________________", 15, 750);
/* 6233 */           fuente = new Font("Dialog", 1, 7);
/* 6234 */           this.g2.setFont(fuente);
/* 6235 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.                                                                                                                                                                                                        Página 2/2", 15, 763);
/* 6236 */           this.g2.drawString(AltaOperador.this.NOMBRECOMPLETO, 15, 774);
/* 6237 */           this.g2.drawString(AltaOperador.this.cargarFechaHoy(), 549, 774);
/* 6238 */           return 0;
/*      */       } 
/* 6240 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6245 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6246 */       job.setPrintable(this);
/*      */       
/* 6248 */       PageFormat pf = job.defaultPage();
/* 6249 */       Paper papel = pf.getPaper();
/* 6250 */       papel.setSize(612.0D, 792.0D);
/* 6251 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6252 */       pf.setPaper(papel);
/* 6253 */       pf.setOrientation(1);
/* 6254 */       ImprimirContrato im = new ImprimirContrato();
/* 6255 */       job.setPrintable(im, pf);
/* 6256 */       job.defaultPage(pf);
/*      */       
/* 6258 */       boolean ok = job.printDialog();
/* 6259 */       if (ok)
/*      */         try {
/* 6261 */           job.print();
/* 6262 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   
/*      */   public class ImprimirCredencial implements Printable {
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     
/* 6269 */     public ImprimirCredencial() { this.opc = 0;
/* 6270 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; ImageIcon tmpIcon; String nombre; int cuenta, esp3;
/*      */       String nombre1, nombre2;
/* 6272 */       this.g2 = (Graphics2D)g;
/* 6273 */       f.setOrientation(1);
/* 6274 */       switch (pageIndex) {
/*      */         case 0:
/* 6276 */           fuente = new Font("Dialog", 1, 12);
/* 6277 */           this.g2.setFont(fuente);
/* 6278 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6286 */           this.g2.setColor(Color.BLACK);
/* 6287 */           this.g2.drawRect(30, 45, 244, 154);
/* 6288 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 6290 */           fuente = new Font("Times New Roman", 1, 11);
/* 6291 */           this.g2.setFont(fuente);
/* 6292 */           this.g2.setColor(new Color(153, 0, 0));
/* 6293 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 34, 57);
/*      */           
/* 6295 */           fuente = new Font("Dialog", 1, 9);
/* 6296 */           this.g2.setFont(fuente);
/* 6297 */           this.g2.setColor(Color.BLACK);
/* 6298 */           this.g2.drawLine(35, 60, 255, 60);
/* 6299 */           this.g2.drawLine(45, 63, 265, 63);
/* 6300 */           this.g2.drawRect(32, 69, 68, 90);
/*      */           
/* 6302 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/mosaico.png"));
/* 6303 */           img = imagen.getImage();
/*      */           
/* 6305 */           this.g2.drawImage(img, 193, 80, 80, 85, null);
/*      */           
/* 6307 */           tmpIcon = new ImageIcon(AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png");
/* 6308 */           img = tmpIcon.getImage();
/* 6309 */           this.g2.drawImage(img, 33, 70, 66, 88, null);
/*      */           
/* 6311 */           fuente = new Font("Dialog", 1, 9);
/* 6312 */           this.g2.setFont(fuente);
/* 6313 */           this.g2.setColor(Color.BLACK);
/* 6314 */           nombre = AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField17.getText().toUpperCase() + " " + AltaOperador.this.jTextField18.getText().toUpperCase();
/* 6315 */           cuenta = 0;
/* 6316 */           esp3 = 0;
/* 6317 */           nombre1 = "";
/* 6318 */           nombre2 = "";
/* 6319 */           if (nombre.length() > 26) {
/* 6320 */             for (int i = 0; i < nombre.length(); i++) {
/* 6321 */               if (nombre.charAt(i) == ' ') {
/* 6322 */                 cuenta++;
/*      */               }
/* 6324 */               if (cuenta < 3) {
/* 6325 */                 nombre1 = nombre1 + nombre1;
/*      */               } else {
/*      */                 
/* 6328 */                 nombre2 = nombre2 + nombre2;
/*      */               } 
/*      */             } 
/*      */           } else {
/*      */             
/* 6333 */             nombre1 = nombre;
/*      */           } 
/* 6335 */           this.g2.drawString(nombre1, 105, 77);
/* 6336 */           this.g2.drawString(nombre2, 103, 88);
/*      */           
/* 6338 */           fuente = new Font("Dialog", 1, 8);
/* 6339 */           this.g2.setFont(fuente);
/* 6340 */           this.g2.drawString("LICENCIA:", 105, 102);
/* 6341 */           this.g2.drawString("TIPO:", 105, 114);
/* 6342 */           this.g2.drawString("NSS:", 105, 126);
/* 6343 */           this.g2.drawString("CURP:", 105, 138);
/* 6344 */           this.g2.drawString("VIGENCIA:", 105, 150);
/*      */           
/* 6346 */           fuente = new Font("Dialog", 0, 9);
/* 6347 */           this.g2.setFont(fuente);
/*      */           
/* 6349 */           this.g2.drawString(AltaOperador.this.jTextField27.getText().toUpperCase(), 149, 102);
/* 6350 */           this.g2.drawString(String.valueOf(AltaOperador.this.jComboBox5.getSelectedItem()), 130, 114);
/* 6351 */           this.g2.drawString(AltaOperador.this.jTextField25.getText().toUpperCase(), 127, 126);
/* 6352 */           this.g2.drawString(AltaOperador.this.jTextField26.getText().toUpperCase(), 134, 138);
/* 6353 */           this.g2.drawString(AltaOperador.this.VIGENCIA, 105, 161);
/*      */           
/* 6355 */           fuente = new Font("DialogInput", 1, 10);
/* 6356 */           this.g2.setFont(fuente);
/* 6357 */           this.g2.drawString(AltaOperador.this.CLAVEOP, 42, 173);
/*      */           
/* 6359 */           this.g2.setColor(new Color(247, 150, 70));
/* 6360 */           this.g2.fill3DRect(102, 164, 170, 12, true);
/*      */           
/* 6362 */           this.g2.setColor(Color.BLACK);
/* 6363 */           this.g2.drawString(AltaOperador.this.jLabel81.getText(), 114, 173);
/*      */           
/* 6365 */           this.g2.setColor(new Color(153, 0, 0));
/* 6366 */           this.g2.fill3DRect(32, 180, 240, 18, true);
/*      */           
/* 6368 */           fuente = new Font("Dialog", 0, 7);
/* 6369 */           this.g2.setColor(Color.WHITE);
/* 6370 */           this.g2.setFont(fuente);
/* 6371 */           this.g2.drawString("          Autpista a Cardel Km. 5 Col Vergara Tarimoya", 60, 187);
/* 6372 */           this.g2.drawString(" Veracruz, Veracruz México C.P. 91810 (01 229)-924-8600 al 03 ", 53, 195);
/*      */ 
/*      */ 
/*      */           
/* 6376 */           fuente = new Font("Dialog", 1, 10);
/* 6377 */           this.g2.setColor(Color.BLACK);
/* 6378 */           this.g2.drawString("          |                                                                           |", 58, 187);
/* 6379 */           this.g2.drawString("|                               |            |                  |                                       |", 53, 195);
/*      */ 
/*      */           
/* 6382 */           fuente = new Font("Times New Roman", 1, 11);
/* 6383 */           this.g2.setFont(fuente);
/* 6384 */           this.g2.setColor(new Color(153, 0, 0));
/* 6385 */           this.g2.drawString("POLÍTICAS DE LA EMPRESA", 325, 57);
/*      */           
/* 6387 */           fuente = new Font("Dialog", 1, 9);
/* 6388 */           this.g2.setFont(fuente);
/* 6389 */           this.g2.setColor(Color.BLACK);
/* 6390 */           this.g2.drawLine(285, 60, 505, 60);
/* 6391 */           this.g2.drawLine(290, 63, 515, 63);
/*      */ 
/*      */           
/* 6394 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/codigoBarras.png"));
/* 6395 */           img = imagen.getImage();
/* 6396 */           this.g2.drawImage(img, 492, 70, 30, 120, null);
/*      */           
/* 6398 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png"));
/* 6399 */           img = imagen.getImage();
/*      */           
/* 6401 */           this.g2.drawImage(img, 281, 100, 211, 60, null);
/*      */           
/* 6403 */           fuente = new Font("Dialog", 0, 5);
/* 6404 */           this.g2.setFont(fuente);
/* 6405 */           this.g2.drawString("•   Brindar trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos", 282, 73);
/* 6406 */           this.g2.drawString("     considerando que el fin de la empresa es el servicio del cliente.", 282, 79);
/* 6407 */           this.g2.drawString("•   Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo", 282, 88);
/* 6408 */           this.g2.drawString("     es mi responsabilidad.", 282, 94);
/* 6409 */           this.g2.drawString("•   Como integrante de la empresa debo mantener un comportamiento ético, desterrar", 282, 103);
/* 6410 */           this.g2.drawString("     toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de", 282, 109);
/* 6411 */           this.g2.drawString("     de FORSIS y de todos los clientes.", 282, 115);
/* 6412 */           this.g2.drawString("•   Realizar evaluaciones periódicas, permanentes a todos los procesos donde se está", 282, 124);
/* 6413 */           this.g2.drawString("     involucrado mi desempeño.", 282, 130);
/* 6414 */           this.g2.drawString("•   Preservar el entorno ambiental y la seguridad de la comunidad en todo trabajo.", 282, 139);
/* 6415 */           this.g2.drawString("•   Difundir permanentemente la gestión de la empresa en forma interna y externa.", 282, 145);
/*      */           
/* 6417 */           fuente = new Font("Dialog", 1, 5);
/* 6418 */           this.g2.setFont(fuente);
/* 6419 */           this.g2.drawString(AltaOperador.this.jLabel82.getText(), 290, 165);
/* 6420 */           this.g2.drawString("ROGER GARZA CANTÚ", 420, 165);
/* 6421 */           this.g2.drawString("____________________________", 295, 185);
/* 6422 */           this.g2.drawString("____________________________", 410, 185);
/* 6423 */           this.g2.drawString(AltaOperador.this.jLabel81.getText().toUpperCase(), 295, 195);
/* 6424 */           this.g2.drawString("DIRECTOR", 438, 195);
/*      */           
/* 6426 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/firma.png"));
/* 6427 */           img = imagen.getImage();
/* 6428 */           this.g2.drawImage(img, 432, 159, 38, 38, null);
/*      */           
/* 6430 */           return 0;
/* 6431 */       }  return 1; }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6435 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6436 */       job.setPrintable(this);
/*      */       
/* 6438 */       PageFormat pf = job.defaultPage();
/* 6439 */       Paper papel = pf.getPaper();
/* 6440 */       papel.setSize(612.0D, 792.0D);
/* 6441 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6442 */       pf.setPaper(papel);
/* 6443 */       pf.setOrientation(1);
/* 6444 */       ImprimirCredencial im = new ImprimirCredencial();
/* 6445 */       job.setPrintable(im, pf);
/* 6446 */       job.defaultPage(pf);
/*      */       
/* 6448 */       boolean ok = job.printDialog();
/* 6449 */       if (ok)
/*      */         try {
/* 6451 */           job.print();
/*      */         }
/* 6453 */         catch (PrinterException printerException) {} 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirRigPass implements Printable {
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     
/* 6461 */     public ImprimirRigPass() { this.opc = 0;
/* 6462 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen;
/*      */       Image img;
/*      */       ImageIcon tmpIcon;
/* 6465 */       this.g2 = (Graphics2D)g;
/* 6466 */       f.setOrientation(1);
/* 6467 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 6473 */           fuente = new Font("Dialog", 1, 12);
/* 6474 */           this.g2.setFont(fuente);
/* 6475 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6483 */           this.g2.setColor(Color.BLUE);
/* 6484 */           this.g2.drawRect(30, 45, 244, 154);
/* 6485 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 6487 */           fuente = new Font("Times New Roman", 1, 8);
/* 6488 */           this.g2.setFont(fuente);
/* 6489 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 82, 62);
/* 6490 */           this.g2.drawRoundRect(34, 49, 237, 147, 10, 10);
/* 6491 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisOriginal.png"));
/* 6492 */           img = imagen.getImage();
/* 6493 */           this.g2.drawImage(img, 37, 52, 36, 38, null);
/*      */           
/* 6495 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png"));
/* 6496 */           img = imagen.getImage();
/* 6497 */           this.g2.drawImage(img, 78, 65, 177, 19, null);
/*      */           
/* 6499 */           tmpIcon = new ImageIcon(AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png");
/* 6500 */           img = tmpIcon.getImage();
/* 6501 */           this.g2.drawImage(img, 39, 94, 56, 78, null);
/*      */           
/* 6503 */           this.g2.setColor(Color.BLACK);
/* 6504 */           this.g2.drawRect(38, 93, 58, 80);
/*      */           
/* 6506 */           fuente = new Font("Dialog", 0, 6);
/* 6507 */           this.g2.setFont(fuente);
/* 6508 */           this.g2.drawString("ACREDITA  A:", 155, 95);
/* 6509 */           this.g2.drawString("DE HABER TENIDO EL:", 150, 120);
/*      */           
/* 6511 */           this.g2.setColor(Color.BLUE);
/* 6512 */           fuente = new Font("Dialog", 1, 7);
/* 6513 */           this.g2.setFont(fuente);
/* 6514 */           this.g2.drawString(AltaOperador.this.jLabel113.getText(), 125, 105);
/* 6515 */           fuente = new Font("Dialog", 1, 8);
/* 6516 */           this.g2.setFont(fuente);
/* 6517 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 114, 130);
/* 6518 */           this.g2.drawString("____________________________", 114, 131);
/*      */           
/* 6520 */           fuente = new Font("Dialog", 1, 5);
/* 6521 */           this.g2.setFont(fuente);
/* 6522 */           this.g2.setColor(Color.BLACK);
/* 6523 */           this.g2.drawString("POR EL AGENTE CAPACITADOR", 140, 138);
/* 6524 */           this.g2.drawString(AltaOperador.this.CONFIG[3], 135, 145);
/* 6525 */           this.g2.drawString(AltaOperador.this.CONFIG[2], 150, 152);
/*      */           
/* 6527 */           this.g2.drawString("Certificado por:", 160, 163);
/* 6528 */           this.g2.drawString("SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL", 114, 170);
/*      */           
/* 6530 */           fuente = new Font("Dialog", 0, 6);
/* 6531 */           this.g2.setFont(fuente);
/* 6532 */           this.g2.drawString("|Carretera México - Tuxpan Km. 8.5|Ejido Lázaro Cárdenas|", 70, 183);
/* 6533 */           this.g2.drawString("|Tihuatlán, Veracruz|México|C.P. 92901|(01 782)-825-6455 al 58|", 64, 192);
/*      */ 
/*      */           
/* 6536 */           this.g2.setColor(Color.BLUE);
/* 6537 */           this.g2.drawRoundRect(284, 49, 237, 147, 10, 10);
/* 6538 */           fuente = new Font("Dialog", 1, 8);
/* 6539 */           this.g2.setFont(fuente);
/* 6540 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 340, 61);
/* 6541 */           this.g2.drawString("____________________________", 340, 62);
/*      */           
/* 6543 */           this.g2.setColor(Color.BLACK);
/* 6544 */           fuente = new Font("Dialog", 0, 6);
/* 6545 */           this.g2.setFont(fuente);
/* 6546 */           this.g2.drawString("NOMBRE DEL EMPLEADO:", 290, 80);
/* 6547 */           this.g2.drawString("CURP:", 290, 95);
/* 6548 */           this.g2.drawString("IMSS:", 290, 110);
/* 6549 */           this.g2.drawString("VIGENCIA:", 290, 125);
/*      */           
/* 6551 */           this.g2.setColor(Color.BLUE);
/* 6552 */           fuente = new Font("Dialog", 1, 7);
/* 6553 */           this.g2.setFont(fuente);
/* 6554 */           this.g2.drawString(AltaOperador.this.jLabel113.getText().toUpperCase(), 370, 80);
/* 6555 */           this.g2.drawString(AltaOperador.this.jLabel129.getText().toUpperCase(), 370, 95);
/* 6556 */           this.g2.drawString(AltaOperador.this.jLabel134.getText().toUpperCase(), 370, 110);
/* 6557 */           this.g2.drawString(AltaOperador.this.jLabel136.getText().toUpperCase(), 370, 125);
/*      */           
/* 6559 */           this.g2.setColor(Color.BLACK);
/* 6560 */           this.g2.drawString("DE ACUERDO A LOS LINEAMIENTOS DE:", 333, 147);
/* 6561 */           this.g2.drawString("'INTERNATIONAL ASSOCIATION OF DRILLING CONTRACTORS'", 296, 157);
/*      */           
/* 6563 */           fuente = new Font("Dialog", 1, 5);
/* 6564 */           this.g2.setFont(fuente);
/* 6565 */           this.g2.drawString("Firma:______________________", 290, 188);
/*      */           
/* 6567 */           fuente = new Font("Dialog", 1, 8);
/* 6568 */           this.g2.setFont(fuente);
/* 6569 */           this.g2.drawString("F" + AltaOperador.this.CONFIG[1] + "-", 470, 190);
/*      */           
/* 6571 */           this.g2.setColor(Color.BLUE);
/* 6572 */           this.g2.drawString(AltaOperador.this.jLabel135.getText().toUpperCase(), 490, 190);
/*      */           
/* 6574 */           return 0;
/*      */       } 
/* 6576 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6581 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6582 */       job.setPrintable(this);
/*      */       
/* 6584 */       PageFormat pf = job.defaultPage();
/* 6585 */       Paper papel = pf.getPaper();
/* 6586 */       papel.setSize(612.0D, 792.0D);
/* 6587 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6588 */       pf.setPaper(papel);
/* 6589 */       pf.setOrientation(1);
/* 6590 */       ImprimirRigPass im = new ImprimirRigPass();
/* 6591 */       job.setPrintable(im, pf);
/* 6592 */       job.defaultPage(pf);
/*      */       
/* 6594 */       boolean ok = job.printDialog();
/* 6595 */       if (ok) {
/*      */         try {
/* 6597 */           job.print();
/* 6598 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public class fotoIndividual
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 6607 */     String num = "";
/*      */     
/*      */     fotoIndividual(String valor) {
/* 6610 */       this.t = new Thread(this);
/* 6611 */       this.num = valor;
/* 6612 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 6619 */       ImageIcon tmpIcon = new ImageIcon(AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png");
/* 6620 */       AltaOperador.this.FOTO = AltaOperador.this.CONFIG[0] + "/" + AltaOperador.this.CONFIG[0] + ".png";
/* 6621 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(190, -1, 1));
/* 6622 */       AltaOperador.this.jLabel1.setText("");
/* 6623 */       if (temporal.getImageLoadStatus() == 4) {
/* 6624 */         AltaOperador.this.jLabel1.setText("Sin Fotogafía");
/*      */       } else {
/* 6626 */         AltaOperador.this.jLabel1.setText("");
/* 6627 */         AltaOperador.this.jLabel1.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   class tras_codigos
/*      */   {
/* 6634 */     private String num = "";
/* 6635 */     private String codigo = "";
/* 6636 */     private String c_Municipio = "";
/* 6637 */     private String ciudad = "";
/* 6638 */     private String c_estado = "";
/* 6639 */     private String estado = "";
/*      */     
/*      */     public tras_codigos(String num, String codigo, String c_Municipio, String ciudad, String c_estado, String estado) {
/* 6642 */       this.num = num;
/* 6643 */       this.codigo = codigo;
/* 6644 */       this.c_Municipio = c_Municipio;
/* 6645 */       this.ciudad = ciudad;
/* 6646 */       this.c_estado = c_estado;
/* 6647 */       this.estado = estado;
/*      */     }
/*      */     
/*      */     public String getNum() {
/* 6651 */       return this.num;
/*      */     }
/*      */     
/*      */     public void setNum(String num) {
/* 6655 */       this.num = num;
/*      */     }
/*      */     public String getCodigo() {
/* 6658 */       return this.codigo;
/*      */     }
/*      */     
/*      */     public void setCodigo(String codigo) {
/* 6662 */       this.codigo = codigo;
/*      */     }
/*      */     
/*      */     public String getC_Municipio() {
/* 6666 */       return this.c_Municipio;
/*      */     }
/*      */     
/*      */     public void setC_Municipio(String c_Municipio) {
/* 6670 */       this.c_Municipio = c_Municipio;
/*      */     }
/*      */     
/*      */     public String getCiudad() {
/* 6674 */       return this.ciudad;
/*      */     }
/*      */     
/*      */     public void setCiudad(String ciudad) {
/* 6678 */       this.ciudad = ciudad;
/*      */     }
/*      */     
/*      */     public String getC_estado() {
/* 6682 */       return this.c_estado;
/*      */     }
/*      */     
/*      */     public void setC_estado(String c_estado) {
/* 6686 */       this.c_estado = c_estado;
/*      */     }
/*      */     
/*      */     public String getEstado() {
/* 6690 */       return this.estado;
/*      */     }
/*      */     
/*      */     public void setEstado(String estado) {
/* 6694 */       this.estado = estado;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AltaOperador.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */