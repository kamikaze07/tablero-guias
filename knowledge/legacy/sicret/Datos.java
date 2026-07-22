/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.BufferedWriter;
/*      */ import java.text.DateFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.mail.Address;
/*      */ import javax.mail.internet.MimeMessage;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class Datos extends JPanel {
/*   42 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   43 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   44 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   45 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   46 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   47 */   Fuentes fuentes = new Fuentes();
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   51 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   52 */   Date fechaActual = new Date();
/*   53 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   54 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   JFrame padre;
/*   56 */   String USUARIO = "";
/*      */   JTabbedPane fichas;
/*      */   String id;
/*   59 */   Consultas con = new Consultas();
/*      */   String[] inf;
/*   61 */   cargarDatos datos = new cargarDatos("OperadorAgregar");
/*      */   
/*      */   ManifiestosAceite aceite;
/*      */   
/*      */   Color fondo;
/*      */   JTable jTable1;
/*      */   boolean encontrado = false;
/*   68 */   int INDICE = 0;
/*   69 */   Errores error = new Errores(false);
/*   70 */   Validaciones val = new Validaciones();
/*   71 */   Date fechaMax = null;
/*   72 */   Date fecha = null;
/*   73 */   String TABLA = "";
/*   74 */   String CLAVE = "";
/*      */   
/*      */   String[] clavesGene;
/*      */   
/*      */   String[] empresasGene;
/*      */   String[] ciudadesGene;
/*      */   String[] domicilioGene;
/*      */   String[] numeroGene;
/*      */   String[] coloniaGene;
/*      */   String[] rfcGene;
/*      */   String[] clavesDesti;
/*      */   String[] empresasDesti;
/*      */   String[] ciudadesDesti;
/*      */   String[] domicilioDesti;
/*      */   String[] numeroDesti;
/*      */   String[] coloniaDesti;
/*      */   String[] rfcDesti;
/*      */   String[] montoDesti;
/*      */   String[] letraDesti;
/*      */   String[] operadores;
/*      */   String[] EQUIPOS;
/*      */   String[] POZOS;
/*   96 */   String CLAVEOP = "";
/*   97 */   String NOMBRE = "";
/*   98 */   Calendar ahoraCal = Calendar.getInstance();
/*      */   ManifiestosAceite mAceite;
/*      */   ManifiestosAgua mAgua;
/*      */   ManifiestosEspecial mEspecial;
/*      */   declaracionRecortes declaracion;
/*      */   declaracionRecortesWTF declaracionWTF;
/*  104 */   double PESOESTIMADO = 24.5D;
/*  105 */   String CANTIDAD = "";
/*  106 */   String POZO = "";
/*  107 */   String POZOM = "";
/*      */   
/*  109 */   String[] PLACAS = new String[] { "", "", "", "", "" };
/*  110 */   int MAYOR = 0;
/*  111 */   int FECHAAÑO = 0;
/*  112 */   int FECHAMES = 0;
/*  113 */   int DIASVENCIDOS = 0;
/*  114 */   String CARPETA = "";
/*  115 */   String DIRECTIVA = "";
/*  116 */   String SEMARNAT = "";
/*  117 */   String PRIVILEGIO = "";
/*  118 */   String LINEA = "";
/*      */   
/*      */   boolean VENTANA1 = false;
/*  121 */   String NUMFORMA = "";
/*  122 */   MensajePop mensajeTry = null;
/*  123 */   CeldaRender3 celda3 = new CeldaRender3();
/*  124 */   PresionadoServicios presionadoServ = null;
/*  125 */   PresionadoUnidades presionadoUni = null;
/*  126 */   Cursor micursor2 = null;
/*  127 */   String RUTAENTRADA = "";
/*  128 */   String CERTIFICADO = "";
/*  129 */   String CODIGOPOSTAL = "";
/*  130 */   String SUCURSAL = "";
/*  131 */   String RUTA = "";
/*  132 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   boolean PRIMERA = false;
/*  135 */   Map<String, DatosEnviarCorreo> enviar = new TreeMap<>();
/*  136 */   int DIASVENCIMIENTO = 0; boolean entraCombo3 = false; private JButton jButton21; private JButton jButton22; private JButton jButton29; private JButton jButton30; private JButton jButton57; private JButton jButton58; private JCheckBox jCheckBox1; private JCheckBox jCheckBox2; private JCheckBox jCheckBox3; private JCheckBox jCheckBox4; private JComboBox jComboBox1; private JComboBox jComboBox16; private JComboBox jComboBox17; private JComboBox<String> jComboBox18; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser2; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog20; private JDialog jDialog21; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19;
/*      */   private JLabel jLabel2;
/*  138 */   Utilerias utilerias = new Utilerias(); private JLabel jLabel20; private JLabel jLabel207; private JLabel jLabel208; private JLabel jLabel209; private JLabel jLabel21; private JLabel jLabel210; private JLabel jLabel211; private JLabel jLabel212; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel69;
/*      */   
/*      */   public Datos(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  141 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  142 */     this.mensajeTry = mensajeTry;
/*  143 */     cargarPozos();
/*  144 */     this.USUARIO = usua;
/*      */ 
/*      */     
/*  147 */     this.NOMBRE = String.valueOf(CAMPOSGENERALES.get("empleados.nombre")) + " " + String.valueOf(CAMPOSGENERALES.get("empleados.nombre")) + " " + String.valueOf(CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*  149 */     this.PRIVILEGIO = CAMPOSGENERALES.get("priv");
/*      */     
/*  151 */     this.padre = padre;
/*  152 */     this.fichas = fichas;
/*  153 */     this.id = num;
/*  154 */     int aa = this.fechaActual.getYear() + 1901;
/*  155 */     int mm = this.fechaActual.getMonth() + 1;
/*  156 */     int dd = this.fechaActual.getDay();
/*      */     
/*  158 */     String año = "" + aa;
/*  159 */     String mes = "" + mm;
/*  160 */     String dia = "" + dd;
/*      */     
/*  162 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  163 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  165 */       this.fechaMax = formatoDelTexto.parse(strFecha);
/*  166 */     } catch (ParseException ex) {
/*  167 */       ex.printStackTrace();
/*      */     } 
/*  169 */     initComponents();
/*  170 */     this.jScrollPane19.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  171 */     this.jLabel45.setText(this.NOMBRE);
/*  172 */     panelito.setViewportView(this);
/*  173 */     this.panel = panelito;
/*  174 */     colorear();
/*  175 */     cargarPerfil();
/*  176 */     int hora = this.fechaActual.getHours();
/*  177 */     int min = this.fechaActual.getMinutes();
/*      */     
/*  179 */     String horita = "" + hora;
/*  180 */     String minuto = "" + min;
/*  181 */     if (hora < 10) {
/*  182 */       horita = "0" + horita;
/*      */     }
/*  184 */     if (min < 10) {
/*  185 */       minuto = "0" + minuto;
/*      */     }
/*  187 */     this.jTextField3.setText(horita + ":" + horita);
/*      */     
/*  189 */     int w = this.tama.width;
/*  190 */     int h = this.tama.height;
/*  191 */     int rw = (w - 20) / 2;
/*  192 */     int rh = (h - 650) / 2;
/*  193 */     this.jDialog1.setLocation(10, rh);
/*  194 */     this.jDialog1.setSize(995, 685);
/*  195 */     this.jDialog1.setVisible(false);
/*      */     
/*  197 */     rw = (w - 400) / 2;
/*  198 */     rh = (h - 470) / 2;
/*  199 */     this.jDialog2.setLocation(rw, rh);
/*  200 */     this.jDialog2.setSize(400, 370);
/*  201 */     this.jDialog2.setVisible(false);
/*  202 */     this.jDialog2.setResizable(false);
/*      */     
/*  204 */     rw = (w - 350) / 2;
/*  205 */     rh = (h - 100) / 2;
/*  206 */     this.jDialog3.setLocation(rw, rh);
/*  207 */     this.jDialog3.setSize(350, 100);
/*  208 */     this.jDialog3.setVisible(false);
/*  209 */     this.jDialog3.setResizable(false);
/*      */     
/*  211 */     rw = (w - 400) / 2;
/*  212 */     rh = (h - 440) / 2;
/*  213 */     this.jDialog4.setLocation(rw, rh);
/*  214 */     this.jDialog4.setSize(400, 392);
/*  215 */     this.jDialog4.setVisible(false);
/*  216 */     this.jDialog4.setResizable(false);
/*      */     
/*  218 */     rw = (w - 500) / 2;
/*  219 */     rh = (h - 440) / 2;
/*  220 */     this.jDialog5.setLocation(rw, rh);
/*  221 */     this.jDialog5.setSize(500, 392);
/*  222 */     this.jDialog5.setVisible(false);
/*  223 */     this.jDialog5.setResizable(false);
/*      */     
/*  225 */     rw = (w - 380) / 2;
/*  226 */     rh = (h - 260) / 2;
/*  227 */     this.jDialog7.setLocation(rw, rh);
/*  228 */     this.jDialog7.setSize(380, 260);
/*  229 */     this.jDialog7.setVisible(false);
/*  230 */     this.jDialog7.setResizable(false);
/*      */     
/*  232 */     rw = (w - 680) / 2;
/*  233 */     rh = (h - 252) / 2;
/*  234 */     this.jDialog8.setLocation(rw, rh);
/*  235 */     this.jDialog8.setSize(680, 252);
/*  236 */     this.jDialog8.setVisible(false);
/*  237 */     this.jDialog8.setResizable(false);
/*      */     
/*  239 */     rw = (w - 410) / 2;
/*  240 */     rh = (h - 225) / 2;
/*  241 */     this.jDialog9.setLocation(rw, rh);
/*  242 */     this.jDialog9.setSize(410, 225);
/*      */     
/*  244 */     rw = (w - 650) / 2;
/*  245 */     rh = (h - 340) / 2;
/*  246 */     this.jDialog20.setLocation(rw, rh);
/*  247 */     this.jDialog20.setSize(650, 340);
/*  248 */     this.jDialog20.setResizable(false);
/*      */     
/*  250 */     rw = (w - 650) / 2;
/*  251 */     rh = (h - 340) / 2;
/*  252 */     this.jDialog21.setLocation(rw, rh);
/*  253 */     this.jDialog21.setSize(650, 340);
/*  254 */     this.jDialog21.setResizable(false);
/*      */     
/*  256 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  257 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  258 */     this.jLabel55.setCursor(micursor);
/*  259 */     this.jLabel67.setCursor(micursor);
/*  260 */     this.jLabel66.setCursor(micursor);
/*  261 */     this.jLabel91.setCursor(micursor);
/*  262 */     this.jLabel95.setCursor(micursor);
/*  263 */     this.jLabel102.setCursor(micursor);
/*      */     
/*  265 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  266 */     this.micursor2 = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  267 */     this.jDialog1.setCursor(this.micursor2);
/*  268 */     this.jDialog2.setCursor(this.micursor2);
/*  269 */     this.jDialog3.setCursor(this.micursor2);
/*  270 */     this.jDialog4.setCursor(this.micursor2);
/*  271 */     this.jDialog5.setCursor(this.micursor2);
/*  272 */     this.jDialog7.setCursor(this.micursor2);
/*  273 */     this.jDialog8.setCursor(this.micursor2);
/*  274 */     this.jDialog9.setCursor(this.micursor2);
/*  275 */     this.rSTableMetro1.setCursor(this.micursor2);
/*  276 */     this.rSTableMetro2.setCursor(this.micursor2);
/*  277 */     this.rSTableMetro3.setCursor(this.micursor2);
/*  278 */     this.rSTableMetro4.setCursor(this.micursor2);
/*  279 */     this.rSTableMetro5.setCursor(this.micursor2);
/*  280 */     this.rSTableMetro6.setCursor(this.micursor2);
/*  281 */     this.rSTableMetro7.setCursor(this.micursor2);
/*  282 */     this.con.consultar("diasAvisos", "configuraciones", "");
/*  283 */     this.DIASVENCIMIENTO = Integer.parseInt(this.con.Campo);
/*      */     
/*  285 */     llenarCombo3();
/*      */     
/*  287 */     if (!entradaPrincipal) {
/*  288 */       consultar();
/*      */     }
/*      */     
/*  291 */     consultar3();
/*  292 */     consultar4();
/*  293 */     llenarCatServicios();
/*  294 */     llenarCatUnidades();
/*  295 */     this.jCheckBox1.setVisible(false);
/*  296 */     this.jCheckBox2.setVisible(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  306 */     this.DIRECTIVA = CAMPOSGENERALES.get("directiva");
/*  307 */     this.SEMARNAT = CAMPOSGENERALES.get("semarnat");
/*  308 */     this.RUTAENTRADA = CAMPOSGENERALES.get("factEntrada");
/*  309 */     this.CERTIFICADO = CAMPOSGENERALES.get("numCertificado");
/*  310 */     this.CODIGOPOSTAL = CAMPOSGENERALES.get("codigoPostal");
/*  311 */     this.SUCURSAL = CAMPOSGENERALES.get("sucursal");
/*  312 */     this.RUTA = CAMPOSGENERALES.get("rutaCompTraslado");
/*      */   }
/*      */   private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel8; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel138; private JPanel jPanel14; private JPanel jPanel141; private JPanel jPanel144; private JPanel jPanel145; private JPanel jPanel156; private JPanel jPanel157; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel44; private JPanel jPanel47; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JPasswordField jPasswordField1; private JScrollPane jScrollPane17; private JScrollPane jScrollPane18; private JScrollPane jScrollPane19; private JScrollPane jScrollPane20; private JScrollPane jScrollPane21; private JScrollPane jScrollPane22; private JScrollPane jScrollPane23; private JScrollPane jScrollPane6; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator7; private JSeparator jSeparator9; private JSlider jSlider1; private JSpinner jSpinner1; private JTextArea jTextArea1; private JTextField jTextField1; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField3; private JTextField jTextField89; private JTextField jTextField92; private JTextField jTextField94; private JTextField jTextField95; private JTextField jTextField96; private JTextField jTextField97; private MaterialButton materialButton10; private MaterialButton materialButton11; private MaterialButton materialButton12; private MaterialButton materialButton13; private MaterialButton materialButton14; private MaterialButton materialButton15; private MaterialButton materialButton16; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton3; private MaterialButton materialButton4; private MaterialButton materialButton5; private MaterialButton materialButton6; private MaterialButton materialButton7; private MaterialButton materialButton8; private MaterialButton materialButton9; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3; private RSTableMetro rSTableMetro4; private RSTableMetro rSTableMetro5; private RSTableMetro rSTableMetro6;
/*      */   private RSTableMetro rSTableMetro7;
/*      */   
/*      */   private void initComponents() {
/*  318 */     this.jDialog1 = new JDialog(this.padre);
/*  319 */     this.jPanel5 = new JPanel();
/*  320 */     this.jLabel22 = new JLabel();
/*  321 */     this.jLabel11 = new JLabel();
/*  322 */     this.jPanel21 = new JPanel();
/*  323 */     this.jLabel12 = new JLabel();
/*  324 */     this.jLabel13 = new JLabel();
/*  325 */     this.jLabel14 = new JLabel();
/*  326 */     this.jLabel17 = new JLabel();
/*  327 */     this.jPanel22 = new JPanel();
/*  328 */     this.jLabel18 = new JLabel();
/*  329 */     this.jLabel19 = new JLabel();
/*  330 */     this.jLabel20 = new JLabel();
/*  331 */     this.jLabel21 = new JLabel();
/*  332 */     this.jLabel23 = new JLabel();
/*  333 */     this.jComboBox6 = new JComboBox();
/*  334 */     this.jLabel34 = new JLabel();
/*  335 */     this.jLabel35 = new JLabel();
/*  336 */     this.jLabel36 = new JLabel();
/*  337 */     this.jLabel37 = new JLabel();
/*  338 */     this.jPanel23 = new JPanel();
/*  339 */     this.jLabel24 = new JLabel();
/*  340 */     this.jLabel25 = new JLabel();
/*  341 */     this.jLabel26 = new JLabel();
/*  342 */     this.jLabel27 = new JLabel();
/*  343 */     this.jLabel28 = new JLabel();
/*  344 */     this.jComboBox7 = new JComboBox();
/*  345 */     this.jLabel38 = new JLabel();
/*  346 */     this.jLabel39 = new JLabel();
/*  347 */     this.jLabel40 = new JLabel();
/*  348 */     this.jLabel41 = new JLabel();
/*  349 */     this.jPanel24 = new JPanel();
/*  350 */     this.jLabel29 = new JLabel();
/*  351 */     this.jLabel49 = new JLabel();
/*  352 */     this.jLabel95 = new JLabel();
/*  353 */     this.jPanel25 = new JPanel();
/*  354 */     this.jLabel30 = new JLabel();
/*  355 */     this.jLabel31 = new JLabel();
/*  356 */     this.jLabel32 = new JLabel();
/*  357 */     this.jLabel50 = new JLabel();
/*  358 */     this.jLabel51 = new JLabel();
/*  359 */     this.jLabel54 = new JLabel();
/*  360 */     this.jPanel26 = new JPanel();
/*  361 */     this.jLabel33 = new JLabel();
/*  362 */     this.jPanel27 = new JPanel();
/*  363 */     this.jComboBox8 = new JComboBox();
/*  364 */     this.jPanel11 = new JPanel();
/*  365 */     this.jLabel52 = new JLabel();
/*  366 */     this.jPanel138 = new JPanel();
/*  367 */     this.jTextField89 = new JTextField();
/*  368 */     this.jButton57 = new JButton();
/*  369 */     this.jLabel53 = new JLabel();
/*  370 */     this.jPanel141 = new JPanel();
/*  371 */     this.jTextField92 = new JTextField();
/*  372 */     this.jButton58 = new JButton();
/*  373 */     this.jPanel28 = new JPanel();
/*  374 */     this.jLabel42 = new JLabel();
/*  375 */     this.jLabel67 = new JLabel();
/*  376 */     this.jPanel29 = new JPanel();
/*  377 */     this.jLabel43 = new JLabel();
/*  378 */     this.jLabel66 = new JLabel();
/*  379 */     this.jPanel30 = new JPanel();
/*  380 */     this.jLabel44 = new JLabel();
/*  381 */     this.jLabel55 = new JLabel();
/*  382 */     this.jLabel91 = new JLabel();
/*  383 */     this.jPanel31 = new JPanel();
/*  384 */     this.jLabel45 = new JLabel();
/*  385 */     this.jPanel32 = new JPanel();
/*  386 */     this.jCheckBox3 = new JCheckBox();
/*  387 */     this.materialButton16 = new MaterialButton();
/*  388 */     this.materialButton17 = new MaterialButton();
/*  389 */     this.materialButton18 = new MaterialButton();
/*  390 */     this.jPanel33 = new JPanel();
/*  391 */     this.jLabel46 = new JLabel();
/*  392 */     this.jLabel47 = new JLabel();
/*  393 */     this.jTextField2 = new JTextField();
/*  394 */     this.jPanel34 = new JPanel();
/*  395 */     this.jLabel56 = new JLabel();
/*  396 */     this.jLabel59 = new JLabel();
/*  397 */     this.jLabel61 = new JLabel();
/*  398 */     this.jLabel64 = new JLabel();
/*  399 */     this.jCheckBox1 = new JCheckBox();
/*  400 */     this.jCheckBox2 = new JCheckBox();
/*  401 */     this.jCheckBox4 = new JCheckBox();
/*  402 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  403 */     this.jPanel7 = new JPanel();
/*  404 */     this.jLabel58 = new JLabel();
/*  405 */     this.jTextField12 = new JTextField();
/*  406 */     this.jLabel60 = new JLabel();
/*  407 */     this.jTextField13 = new JTextField();
/*  408 */     this.materialButton5 = new MaterialButton();
/*  409 */     this.materialButton11 = new MaterialButton();
/*  410 */     this.jScrollPane19 = new JScrollPane();
/*  411 */     this.rSTableMetro3 = new RSTableMetro();
/*  412 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  413 */     this.jPanel8 = new JPanel();
/*  414 */     this.jLabel63 = new JLabel();
/*  415 */     this.jTextField14 = new JTextField();
/*  416 */     this.materialButton6 = new MaterialButton();
/*  417 */     this.materialButton12 = new MaterialButton();
/*  418 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  419 */     this.jPanel9 = new JPanel();
/*  420 */     this.jLabel69 = new JLabel();
/*  421 */     this.jTextField15 = new JTextField();
/*  422 */     this.jLabel70 = new JLabel();
/*  423 */     this.materialButton7 = new MaterialButton();
/*  424 */     this.materialButton13 = new MaterialButton();
/*  425 */     this.jScrollPane20 = new JScrollPane();
/*  426 */     this.rSTableMetro4 = new RSTableMetro();
/*  427 */     this.jComboBox18 = new JComboBox<>();
/*  428 */     this.jPanel50 = new JPanel();
/*  429 */     this.jLabel125 = new JLabel();
/*  430 */     this.jLabel126 = new JLabel();
/*  431 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  432 */     this.jPanel10 = new JPanel();
/*  433 */     this.jPanel1 = new JPanel();
/*  434 */     this.jLabel72 = new JLabel();
/*  435 */     this.jTextField17 = new JTextField();
/*  436 */     this.jLabel73 = new JLabel();
/*  437 */     this.jTextField18 = new JTextField();
/*  438 */     this.jLabel74 = new JLabel();
/*  439 */     this.jTextField19 = new JTextField();
/*  440 */     this.materialButton8 = new MaterialButton();
/*  441 */     this.materialButton14 = new MaterialButton();
/*  442 */     this.jScrollPane21 = new JScrollPane();
/*  443 */     this.rSTableMetro5 = new RSTableMetro();
/*  444 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  445 */     this.jPanel17 = new JPanel();
/*  446 */     this.jLabel89 = new JLabel();
/*  447 */     this.jSeparator7 = new JSeparator();
/*  448 */     this.jLabel90 = new JLabel();
/*  449 */     this.jTextField20 = new JTextField();
/*  450 */     this.jButton21 = new JButton();
/*  451 */     this.jButton22 = new JButton();
/*  452 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  453 */     this.jPanel18 = new JPanel();
/*  454 */     this.jLabel94 = new JLabel();
/*  455 */     this.jScrollPane6 = new JScrollPane();
/*  456 */     this.jTextArea1 = new JTextArea();
/*  457 */     this.materialButton15 = new MaterialButton();
/*  458 */     this.jPanel19 = new JPanel();
/*  459 */     this.jLabel96 = new JLabel();
/*  460 */     this.jComboBox16 = new JComboBox();
/*  461 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  462 */     this.jPanel20 = new JPanel();
/*  463 */     this.jLabel97 = new JLabel();
/*  464 */     this.jSeparator9 = new JSeparator();
/*  465 */     this.jLabel98 = new JLabel();
/*  466 */     this.jLabel99 = new JLabel();
/*  467 */     this.jLabel100 = new JLabel();
/*  468 */     this.jLabel101 = new JLabel();
/*  469 */     this.jLabel102 = new JLabel();
/*  470 */     this.jLabel103 = new JLabel();
/*  471 */     this.jSeparator10 = new JSeparator();
/*  472 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  473 */     this.jPanel35 = new JPanel();
/*  474 */     this.jLabel104 = new JLabel();
/*  475 */     this.jLabel105 = new JLabel();
/*  476 */     this.jSeparator11 = new JSeparator();
/*  477 */     this.jPanel39 = new JPanel();
/*  478 */     this.jTextField1 = new JTextField();
/*  479 */     this.jLabel106 = new JLabel();
/*  480 */     this.jLabel107 = new JLabel();
/*  481 */     this.jPasswordField1 = new JPasswordField();
/*  482 */     this.jButton29 = new JButton();
/*  483 */     this.jButton30 = new JButton();
/*  484 */     this.jDialog20 = new CerrarVentana(this.padre);
/*  485 */     this.jPanel144 = new JPanel();
/*  486 */     this.jPanel145 = new JPanel();
/*  487 */     this.jTextField94 = new JTextField();
/*  488 */     this.jTextField95 = new JTextField();
/*  489 */     this.jLabel211 = new JLabel();
/*  490 */     this.jLabel212 = new JLabel();
/*  491 */     this.jLabel207 = new JLabel();
/*  492 */     this.jScrollPane22 = new JScrollPane();
/*  493 */     this.rSTableMetro6 = new RSTableMetro();
/*  494 */     this.jDialog21 = new CerrarVentana(this.padre);
/*  495 */     this.jPanel156 = new JPanel();
/*  496 */     this.jPanel157 = new JPanel();
/*  497 */     this.jLabel208 = new JLabel();
/*  498 */     this.jTextField96 = new JTextField();
/*  499 */     this.jLabel209 = new JLabel();
/*  500 */     this.jTextField97 = new JTextField();
/*  501 */     this.jLabel210 = new JLabel();
/*  502 */     this.jScrollPane23 = new JScrollPane();
/*  503 */     this.rSTableMetro7 = new RSTableMetro();
/*  504 */     this.jPanel3 = new JPanel();
/*  505 */     this.jScrollPane18 = new JScrollPane();
/*  506 */     this.rSTableMetro2 = new RSTableMetro();
/*  507 */     this.jPanel2 = new JPanel();
/*  508 */     this.jPanel4 = new JPanel();
/*  509 */     this.jLabel65 = new JLabel();
/*  510 */     this.jComboBox9 = new JComboBox();
/*  511 */     this.jLabel108 = new JLabel();
/*  512 */     this.jComboBox17 = new JComboBox();
/*  513 */     this.jLabel2 = new JLabel();
/*  514 */     this.jComboBox1 = new JComboBox();
/*  515 */     this.jLabel3 = new JLabel();
/*  516 */     this.jComboBox2 = new JComboBox();
/*  517 */     this.jLabel5 = new JLabel();
/*  518 */     this.jComboBox3 = new JComboBox();
/*  519 */     this.jLabel6 = new JLabel();
/*  520 */     this.jComboBox4 = new JComboBox();
/*  521 */     this.jLabel7 = new JLabel();
/*  522 */     this.jPanel47 = new JPanel();
/*  523 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  524 */     this.jTextField3 = new JTextField();
/*  525 */     this.jLabel8 = new JLabel();
/*  526 */     this.jSpinner1 = new JSpinner();
/*  527 */     this.jLabel9 = new JLabel();
/*  528 */     this.jPanel44 = new JPanel();
/*  529 */     this.jSlider1 = new JSlider();
/*  530 */     this.jLabel10 = new JLabel();
/*  531 */     this.jLabel1 = new JLabel();
/*  532 */     this.jLabel4 = new JLabel();
/*  533 */     this.materialButton3 = new MaterialButton();
/*  534 */     this.materialButton9 = new MaterialButton();
/*  535 */     this.jPanel14 = new JPanel();
/*  536 */     this.jLabel16 = new JLabel();
/*  537 */     this.jLabel15 = new JLabel();
/*  538 */     this.jLabel75 = new JLabel();
/*  539 */     this.jComboBox5 = new JComboBox();
/*  540 */     this.materialButton4 = new MaterialButton();
/*  541 */     this.materialButton10 = new MaterialButton();
/*  542 */     this.jScrollPane17 = new JScrollPane();
/*  543 */     this.rSTableMetro1 = new RSTableMetro();
/*      */     
/*  545 */     this.jDialog1.setDefaultCloseOperation(0);
/*  546 */     this.jDialog1.setModal(true);
/*  547 */     this.jDialog1.setUndecorated(true);
/*  548 */     this.jDialog1.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  550 */             Datos.this.jDialog1WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  554 */     this.jPanel5.setBackground(new Color(255, 255, 255));
/*  555 */     this.jPanel5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
/*      */     
/*  557 */     this.jLabel22.setFont(new Font("Tahoma", 1, 22));
/*  558 */     this.jLabel22.setHorizontalAlignment(0);
/*  559 */     this.jLabel22.setText("<HTML><CENTER>FLETES Y MATERIALES FORSIS,<BR> S.A. DE C.V.</CENTER></HTML>");
/*      */     
/*  561 */     this.jLabel11.setFont(new Font("Tahoma", 0, 9));
/*  562 */     this.jLabel11.setText("<HTML><CENTER>MATRIZ<BR>AUTOPISTA MONTERREY-CADEREYTA KM. 32.5<BR>A.P. 129 C.P. 67450 CADEREYTA JÍMENEZ N.L.<BR>TELS: 01(828) 284-4291, 284-4444, 284-4290 FAX:284-5671<BR> www.forsis.com &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; R.F.C. FMF-901004-UZ9</CENTER></HTML>");
/*      */     
/*  564 */     this.jPanel21.setBackground(new Color(255, 255, 255));
/*  565 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " FECHA ", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  567 */     this.jLabel12.setFont(new Font("Tahoma", 1, 12));
/*  568 */     this.jLabel12.setForeground(new Color(255, 0, 0));
/*  569 */     this.jLabel12.setHorizontalAlignment(0);
/*  570 */     this.jLabel12.setText("20/10/2009");
/*      */     
/*  572 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  573 */     this.jPanel21.setLayout(jPanel21Layout);
/*  574 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  575 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  576 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  577 */           .addContainerGap()
/*  578 */           .addComponent(this.jLabel12, -1, 148, 32767)
/*  579 */           .addContainerGap()));
/*      */     
/*  581 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  583 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  584 */           .addGap(19, 19, 19)
/*  585 */           .addComponent(this.jLabel12)
/*  586 */           .addContainerGap(24, 32767)));
/*      */ 
/*      */     
/*  589 */     this.jLabel13.setFont(new Font("Tahoma", 0, 8));
/*  590 */     this.jLabel13.setText("<HTML><CENTER><b>BASE VERACRUZ</b><BR>AUTOPISTA AUTOPISTA A CARDEL KM. 5.<BR>COL. VERGARA TARIMOYA<BR>VERACRUZ, VER. C.P. 91810<BR>TELÉFONOS: 01(229) 924-8601 AL 03</CENTER></HTML>");
/*      */     
/*  592 */     this.jLabel14.setFont(new Font("Tahoma", 0, 8));
/*  593 */     this.jLabel14.setText("<HTML><CENTER><b>BASE POZA RICA</b><BR>EMÍLIO CARRANZA No. 6<BR>COL. LÓPEZ MATEOS<BR>POZA RICA, VERACRUZ<BR>TEL. 01 (782) 825-0387</CENTER></HTML>");
/*      */     
/*  595 */     this.jLabel17.setFont(new Font("Tahoma", 0, 8));
/*  596 */     this.jLabel17.setText("<HTML><CENTER><b>BASE TABASCO</b><BR>TEL. 01 (993) 399-9095<BR>01 (993) 160-7498<BR>VILLA HERMOSA</CENTER></HTML>");
/*      */     
/*  598 */     this.jPanel22.setBackground(new Color(255, 255, 255));
/*  599 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  601 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/*  602 */     this.jLabel18.setText("ORIGEN");
/*      */     
/*  604 */     this.jLabel19.setFont(new Font("Tahoma", 1, 11));
/*  605 */     this.jLabel19.setText("REMITENTE");
/*      */     
/*  607 */     this.jLabel20.setFont(new Font("Tahoma", 1, 11));
/*  608 */     this.jLabel20.setText("DOMICILIO");
/*      */     
/*  610 */     this.jLabel21.setFont(new Font("Tahoma", 1, 11));
/*  611 */     this.jLabel21.setText("COLONIA");
/*      */     
/*  613 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/*  614 */     this.jLabel23.setText("R.F.C.");
/*      */     
/*  616 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  617 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  618 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  620 */             Datos.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  624 */     this.jLabel34.setFont(new Font("Tahoma", 1, 11));
/*  625 */     this.jLabel34.setForeground(new Color(255, 0, 0));
/*  626 */     this.jLabel34.setText("ORIGEN");
/*      */     
/*  628 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/*  629 */     this.jLabel35.setForeground(new Color(255, 0, 0));
/*  630 */     this.jLabel35.setText("ORIGEN");
/*      */     
/*  632 */     this.jLabel36.setFont(new Font("Tahoma", 1, 11));
/*  633 */     this.jLabel36.setForeground(new Color(255, 0, 0));
/*  634 */     this.jLabel36.setText("ORIGEN");
/*      */     
/*  636 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/*  637 */     this.jLabel37.setForeground(new Color(255, 0, 0));
/*  638 */     this.jLabel37.setText("ORIGEN");
/*      */     
/*  640 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  641 */     this.jPanel22.setLayout(jPanel22Layout);
/*  642 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  643 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  644 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  645 */           .addContainerGap()
/*  646 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  647 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  648 */               .addComponent(this.jLabel18, -2, 67, -2)
/*  649 */               .addGap(18, 18, 18)
/*  650 */               .addComponent(this.jLabel34, -1, 345, 32767))
/*  651 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  652 */               .addComponent(this.jLabel19, -2, 67, -2)
/*  653 */               .addGap(18, 18, 18)
/*  654 */               .addComponent(this.jComboBox6, 0, 345, 32767))
/*  655 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  656 */               .addComponent(this.jLabel20, -2, 67, -2)
/*  657 */               .addGap(18, 18, 18)
/*  658 */               .addComponent(this.jLabel35, -1, 345, 32767))
/*  659 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  660 */               .addComponent(this.jLabel21, -2, 67, -2)
/*  661 */               .addGap(18, 18, 18)
/*  662 */               .addComponent(this.jLabel36, -1, 345, 32767))
/*  663 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  664 */               .addComponent(this.jLabel23, -2, 67, -2)
/*  665 */               .addGap(18, 18, 18)
/*  666 */               .addComponent(this.jLabel37, -1, 345, 32767)))
/*  667 */           .addGap(22, 22, 22)));
/*      */     
/*  669 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  670 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  671 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  672 */           .addContainerGap(-1, 32767)
/*  673 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  674 */             .addComponent(this.jLabel18)
/*  675 */             .addComponent(this.jLabel34))
/*  676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  677 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  678 */             .addComponent(this.jLabel19)
/*  679 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  680 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  682 */             .addComponent(this.jLabel20)
/*  683 */             .addComponent(this.jLabel35))
/*  684 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  685 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  686 */             .addComponent(this.jLabel21)
/*  687 */             .addComponent(this.jLabel36))
/*  688 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  689 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  690 */             .addComponent(this.jLabel23)
/*  691 */             .addComponent(this.jLabel37))));
/*      */ 
/*      */     
/*  694 */     this.jPanel23.setBackground(new Color(255, 255, 255));
/*  695 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  697 */     this.jLabel24.setFont(new Font("Tahoma", 1, 11));
/*  698 */     this.jLabel24.setText("DESTINO");
/*      */     
/*  700 */     this.jLabel25.setFont(new Font("Tahoma", 1, 11));
/*  701 */     this.jLabel25.setText("DESTINATARIO");
/*      */     
/*  703 */     this.jLabel26.setFont(new Font("Tahoma", 1, 11));
/*  704 */     this.jLabel26.setText("DOMICILIO");
/*      */     
/*  706 */     this.jLabel27.setFont(new Font("Tahoma", 1, 11));
/*  707 */     this.jLabel27.setText("COLONIA");
/*      */     
/*  709 */     this.jLabel28.setFont(new Font("Tahoma", 1, 11));
/*  710 */     this.jLabel28.setText("R.F.C.");
/*      */     
/*  712 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  713 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  714 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  716 */             Datos.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  720 */     this.jLabel38.setFont(new Font("Tahoma", 1, 11));
/*  721 */     this.jLabel38.setForeground(new Color(255, 0, 0));
/*  722 */     this.jLabel38.setText("ORIGEN");
/*      */     
/*  724 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/*  725 */     this.jLabel39.setForeground(new Color(255, 0, 0));
/*  726 */     this.jLabel39.setText("ORIGEN");
/*      */     
/*  728 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/*  729 */     this.jLabel40.setForeground(new Color(255, 0, 0));
/*  730 */     this.jLabel40.setText("ORIGEN");
/*      */     
/*  732 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/*  733 */     this.jLabel41.setForeground(new Color(255, 0, 0));
/*  734 */     this.jLabel41.setText("ORIGEN");
/*      */     
/*  736 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/*  737 */     this.jPanel23.setLayout(jPanel23Layout);
/*  738 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/*  739 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  740 */         .addGroup(jPanel23Layout.createSequentialGroup()
/*  741 */           .addContainerGap()
/*  742 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  743 */             .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */               .addGroup(jPanel23Layout.createSequentialGroup()
/*  745 */                 .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  746 */                   .addComponent(this.jLabel26, -2, 67, -2)
/*  747 */                   .addComponent(this.jLabel27, -2, 67, -2)
/*  748 */                   .addComponent(this.jLabel25, -1, -1, 32767))
/*  749 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, -2))
/*  750 */               .addGroup(jPanel23Layout.createSequentialGroup()
/*  751 */                 .addComponent(this.jLabel28, -2, 67, -2)
/*  752 */                 .addGap(40, 40, 40)))
/*  753 */             .addGroup(jPanel23Layout.createSequentialGroup()
/*  754 */               .addComponent(this.jLabel24, -2, 67, -2)
/*  755 */               .addGap(40, 40, 40)))
/*  756 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  757 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
/*  758 */               .addComponent(this.jComboBox7, -2, 323, -2)
/*  759 */               .addGap(22, 22, 22))
/*  760 */             .addGroup(jPanel23Layout.createSequentialGroup()
/*  761 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  762 */                 .addComponent(this.jLabel38, GroupLayout.Alignment.LEADING, -1, 345, 32767)
/*  763 */                 .addComponent(this.jLabel39, -1, 345, 32767)
/*  764 */                 .addComponent(this.jLabel40, -1, 345, 32767)
/*  765 */                 .addComponent(this.jLabel41, -1, 345, 32767))
/*  766 */               .addContainerGap()))));
/*      */     
/*  768 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/*  769 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  770 */         .addGroup(jPanel23Layout.createSequentialGroup()
/*  771 */           .addContainerGap(-1, 32767)
/*  772 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  773 */             .addComponent(this.jLabel24)
/*  774 */             .addComponent(this.jLabel38))
/*  775 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  776 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  777 */             .addComponent(this.jLabel25)
/*  778 */             .addComponent(this.jComboBox7, -2, -1, -2))
/*  779 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  780 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  781 */             .addComponent(this.jLabel26)
/*  782 */             .addComponent(this.jLabel39))
/*  783 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  784 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  785 */             .addComponent(this.jLabel27)
/*  786 */             .addComponent(this.jLabel40))
/*  787 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  788 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  789 */             .addComponent(this.jLabel28)
/*  790 */             .addComponent(this.jLabel41))));
/*      */ 
/*      */     
/*  793 */     this.jPanel24.setBackground(new Color(255, 255, 255));
/*  794 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder(null, "¿QUÉ SE DICE QUE CONTIENE?", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  796 */     this.jLabel29.setFont(new Font("Times New Roman", 1, 18));
/*  797 */     this.jLabel29.setForeground(new Color(255, 0, 0));
/*  798 */     this.jLabel29.setHorizontalAlignment(0);
/*  799 */     this.jLabel29.setText("RECORTE BASE LODO");
/*      */     
/*  801 */     this.jLabel49.setFont(new Font("Tahoma", 1, 14));
/*  802 */     this.jLabel49.setForeground(Color.blue);
/*  803 */     this.jLabel49.setText("RECORTE BASE LODO");
/*      */     
/*  805 */     this.jLabel95.setFont(new Font("Tahoma", 1, 14));
/*  806 */     this.jLabel95.setHorizontalAlignment(0);
/*  807 */     this.jLabel95.setText("GÓNDOLA");
/*  808 */     this.jLabel95.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  810 */             Datos.this.jLabel95MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  813 */             Datos.this.jLabel95MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  816 */             Datos.this.jLabel95MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  820 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  821 */     this.jPanel24.setLayout(jPanel24Layout);
/*  822 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  824 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/*  825 */           .addComponent(this.jLabel49, -2, 202, -2)
/*  826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  827 */           .addComponent(this.jLabel95, -1, -1, 32767)
/*  828 */           .addGap(18, 18, 18)
/*  829 */           .addComponent(this.jLabel29, -2, 283, -2)
/*  830 */           .addContainerGap()));
/*      */     
/*  832 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  833 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  834 */         .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  835 */           .addComponent(this.jLabel29, -1, 47, 32767)
/*  836 */           .addComponent(this.jLabel49, -1, 36, 32767))
/*  837 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  838 */           .addGap(11, 11, 11)
/*  839 */           .addComponent(this.jLabel95, -1, 25, 32767)
/*  840 */           .addContainerGap()));
/*      */ 
/*      */     
/*  843 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/*  844 */     this.jPanel25.setBorder(BorderFactory.createTitledBorder(null, " COBRAR", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  846 */     this.jLabel30.setFont(new Font("Tahoma", 1, 11));
/*  847 */     this.jLabel30.setText("SUB-TOTAL");
/*      */     
/*  849 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/*  850 */     this.jLabel31.setText("I.V.A.");
/*      */     
/*  852 */     this.jLabel32.setFont(new Font("Tahoma", 1, 11));
/*  853 */     this.jLabel32.setText("TOTAL");
/*      */     
/*  855 */     this.jLabel50.setFont(new Font("Tahoma", 1, 12));
/*  856 */     this.jLabel50.setForeground(new Color(255, 0, 0));
/*  857 */     this.jLabel50.setHorizontalAlignment(4);
/*  858 */     this.jLabel50.setText("POZO ALEMÁN");
/*      */     
/*  860 */     this.jLabel51.setFont(new Font("Tahoma", 1, 12));
/*  861 */     this.jLabel51.setForeground(new Color(255, 0, 0));
/*  862 */     this.jLabel51.setHorizontalAlignment(4);
/*  863 */     this.jLabel51.setText("POZO ALEMÁN");
/*      */     
/*  865 */     this.jLabel54.setFont(new Font("Tahoma", 1, 12));
/*  866 */     this.jLabel54.setForeground(new Color(255, 0, 0));
/*  867 */     this.jLabel54.setHorizontalAlignment(4);
/*  868 */     this.jLabel54.setText("POZO ALEMÁN");
/*      */     
/*  870 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  871 */     this.jPanel25.setLayout(jPanel25Layout);
/*  872 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  873 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  874 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  875 */           .addContainerGap(14, 32767)
/*  876 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  877 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  878 */               .addComponent(this.jLabel30, GroupLayout.Alignment.TRAILING, -2, 67, -2)
/*  879 */               .addComponent(this.jLabel31, -2, 67, -2))
/*  880 */             .addComponent(this.jLabel32, -2, 67, -2))
/*  881 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  882 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  883 */             .addComponent(this.jLabel54, -1, -1, 32767)
/*  884 */             .addComponent(this.jLabel51, -1, -1, 32767)
/*  885 */             .addComponent(this.jLabel50, -1, 102, 32767))));
/*      */     
/*  887 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  889 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  890 */           .addContainerGap(-1, 32767)
/*  891 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  892 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  893 */               .addComponent(this.jLabel30)
/*  894 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  895 */               .addComponent(this.jLabel31)
/*  896 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  897 */               .addComponent(this.jLabel32))
/*  898 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  899 */               .addComponent(this.jLabel50)
/*  900 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  901 */               .addComponent(this.jLabel51)
/*  902 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  903 */               .addComponent(this.jLabel54)))));
/*      */ 
/*      */     
/*  906 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/*  907 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, " ENVIÓ", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  909 */     this.jLabel33.setFont(new Font("Tahoma", 1, 12));
/*  910 */     this.jLabel33.setForeground(new Color(255, 0, 0));
/*  911 */     this.jLabel33.setHorizontalAlignment(0);
/*  912 */     this.jLabel33.setText("POZO ALEMÁN");
/*      */     
/*  914 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  915 */     this.jPanel26.setLayout(jPanel26Layout);
/*  916 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  917 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  918 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  919 */           .addContainerGap()
/*  920 */           .addComponent(this.jLabel33, -1, 203, 32767)
/*  921 */           .addContainerGap()));
/*      */     
/*  923 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  924 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  925 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/*  926 */           .addContainerGap(81, 32767)
/*  927 */           .addComponent(this.jLabel33)
/*  928 */           .addContainerGap()));
/*      */ 
/*      */     
/*  931 */     this.jPanel27.setBackground(new Color(255, 255, 255));
/*  932 */     this.jPanel27.setBorder(BorderFactory.createTitledBorder(null, " OBSERVACIONES", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  934 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  935 */     this.jComboBox8.setFont(new Font("Times New Roman", 1, 15));
/*  936 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO...", "SERVICIO INTEGRAL", "FLETE", "RENTA", "SERVICIO DE RETRO", "ESTADIA", "CARGADA LATERAL", "MANIOBRA" }));
/*  937 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  939 */             Datos.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  943 */     this.jPanel11.setBackground(new Color(255, 255, 255));
/*  944 */     this.jPanel11.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  946 */     this.jLabel52.setFont(new Font("Dialog", 0, 11));
/*  947 */     this.jLabel52.setHorizontalAlignment(4);
/*  948 */     this.jLabel52.setText("Clave del servicio");
/*  949 */     this.jPanel11.add(this.jLabel52);
/*      */     
/*  951 */     this.jPanel138.setBackground(new Color(255, 255, 255));
/*      */     
/*  953 */     this.jTextField89.setEditable(false);
/*  954 */     this.jTextField89.setHorizontalAlignment(4);
/*      */     
/*  956 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  957 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  959 */             Datos.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  963 */     GroupLayout jPanel138Layout = new GroupLayout(this.jPanel138);
/*  964 */     this.jPanel138.setLayout(jPanel138Layout);
/*  965 */     jPanel138Layout.setHorizontalGroup(jPanel138Layout
/*  966 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  967 */         .addGroup(jPanel138Layout.createSequentialGroup()
/*  968 */           .addComponent(this.jTextField89, -1, 97, 32767)
/*  969 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  970 */           .addComponent(this.jButton57, -2, 18, -2)));
/*      */     
/*  972 */     jPanel138Layout.setVerticalGroup(jPanel138Layout
/*  973 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  974 */         .addGroup(jPanel138Layout.createSequentialGroup()
/*  975 */           .addGroup(jPanel138Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  976 */             .addComponent(this.jTextField89)
/*  977 */             .addComponent(this.jButton57, -2, 0, 32767))
/*  978 */           .addGap(0, 2, 32767)));
/*      */ 
/*      */     
/*  981 */     this.jPanel11.add(this.jPanel138);
/*      */     
/*  983 */     this.jLabel53.setFont(new Font("Dialog", 0, 11));
/*  984 */     this.jLabel53.setHorizontalAlignment(4);
/*  985 */     this.jLabel53.setText("Clave de la unidad");
/*  986 */     this.jPanel11.add(this.jLabel53);
/*      */     
/*  988 */     this.jPanel141.setBackground(new Color(255, 255, 255));
/*      */     
/*  990 */     this.jTextField92.setEditable(false);
/*      */     
/*  992 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  993 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  995 */             Datos.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  999 */     GroupLayout jPanel141Layout = new GroupLayout(this.jPanel141);
/* 1000 */     this.jPanel141.setLayout(jPanel141Layout);
/* 1001 */     jPanel141Layout.setHorizontalGroup(jPanel141Layout
/* 1002 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1003 */         .addGroup(jPanel141Layout.createSequentialGroup()
/* 1004 */           .addComponent(this.jTextField92, -1, 97, 32767)
/* 1005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1006 */           .addComponent(this.jButton58, -2, 18, -2)));
/*      */     
/* 1008 */     jPanel141Layout.setVerticalGroup(jPanel141Layout
/* 1009 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1010 */         .addGroup(jPanel141Layout.createSequentialGroup()
/* 1011 */           .addGroup(jPanel141Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1012 */             .addComponent(this.jTextField92)
/* 1013 */             .addComponent(this.jButton58, -2, 0, 32767))
/* 1014 */           .addGap(0, 2, 32767)));
/*      */ 
/*      */     
/* 1017 */     this.jPanel11.add(this.jPanel141);
/*      */     
/* 1019 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 1020 */     this.jPanel27.setLayout(jPanel27Layout);
/* 1021 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 1022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1023 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 1024 */           .addContainerGap()
/* 1025 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1026 */             .addComponent(this.jComboBox8, 0, -1, 32767)
/* 1027 */             .addComponent(this.jPanel11, -1, -1, 32767))
/* 1028 */           .addContainerGap()));
/*      */     
/* 1030 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 1031 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1032 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 1033 */           .addContainerGap()
/* 1034 */           .addComponent(this.jComboBox8, -2, -1, -2)
/* 1035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1036 */           .addComponent(this.jPanel11, -2, -1, -2)
/* 1037 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1040 */     this.jPanel28.setBackground(new Color(255, 255, 255));
/* 1041 */     this.jPanel28.setBorder(BorderFactory.createTitledBorder(null, " CAMIÓN   |   PLACAS", 2, 5, new Font("Tahoma", 1, 11)));
/*      */     
/* 1043 */     this.jLabel42.setFont(new Font("Tahoma", 1, 12));
/* 1044 */     this.jLabel42.setForeground(new Color(255, 0, 0));
/* 1045 */     this.jLabel42.setHorizontalAlignment(0);
/* 1046 */     this.jLabel42.setText("ECONÓMICO Y PLACAS");
/*      */     
/* 1048 */     this.jLabel67.setFont(new Font("Tahoma", 2, 11));
/* 1049 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1050 */     this.jLabel67.setText("<html><u>Cargar</u></html>");
/* 1051 */     this.jLabel67.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1053 */             Datos.this.jLabel67MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1056 */             Datos.this.jLabel67MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1059 */             Datos.this.jLabel67MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1063 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 1064 */     this.jPanel28.setLayout(jPanel28Layout);
/* 1065 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 1066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1067 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
/* 1068 */           .addContainerGap()
/* 1069 */           .addComponent(this.jLabel42, -1, 200, 32767)
/* 1070 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1071 */           .addComponent(this.jLabel67, -2, -1, -2)));
/*      */     
/* 1073 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 1074 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1075 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 1076 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1077 */             .addComponent(this.jLabel67, -2, -1, -2)
/* 1078 */             .addComponent(this.jLabel42))
/* 1079 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/* 1082 */     this.jPanel29.setBackground(new Color(255, 255, 255));
/* 1083 */     this.jPanel29.setBorder(BorderFactory.createTitledBorder(null, " CAJA   |   PLACAS", 2, 5, new Font("Tahoma", 1, 11)));
/*      */     
/* 1085 */     this.jLabel43.setFont(new Font("Tahoma", 1, 12));
/* 1086 */     this.jLabel43.setForeground(new Color(255, 0, 0));
/* 1087 */     this.jLabel43.setHorizontalAlignment(0);
/* 1088 */     this.jLabel43.setText("NÚMERO Y PLACAS");
/*      */     
/* 1090 */     this.jLabel66.setFont(new Font("Tahoma", 2, 11));
/* 1091 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/* 1092 */     this.jLabel66.setText("<html><u>Cargar</u></html>");
/* 1093 */     this.jLabel66.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1095 */             Datos.this.jLabel66MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1098 */             Datos.this.jLabel66MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1101 */             Datos.this.jLabel66MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1105 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1106 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1107 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1108 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1109 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1110 */           .addComponent(this.jLabel43, -1, 210, 32767)
/* 1111 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1112 */           .addComponent(this.jLabel66, -2, -1, -2)));
/*      */     
/* 1114 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1115 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1116 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1117 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1118 */             .addComponent(this.jLabel66, -2, -1, -2)
/* 1119 */             .addComponent(this.jLabel43))
/* 1120 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/* 1123 */     this.jPanel30.setBackground(new Color(255, 255, 255));
/* 1124 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder(null, " OPERADOR ", 2, 5, new Font("Tahoma", 1, 11)));
/*      */     
/* 1126 */     this.jLabel44.setFont(new Font("Tahoma", 1, 12));
/* 1127 */     this.jLabel44.setForeground(new Color(255, 0, 0));
/* 1128 */     this.jLabel44.setHorizontalAlignment(0);
/* 1129 */     this.jLabel44.setText("AQUÍ SE CARGA EL OPERADOR");
/*      */     
/* 1131 */     this.jLabel55.setFont(new Font("Tahoma", 2, 11));
/* 1132 */     this.jLabel55.setForeground(new Color(15, 87, 51));
/* 1133 */     this.jLabel55.setText("<html><u>Cargar</u></html>");
/* 1134 */     this.jLabel55.addMouseListener(new MouseAdapter() {
/*      */           public void mouseExited(MouseEvent evt) {
/* 1136 */             Datos.this.jLabel55MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1139 */             Datos.this.jLabel55MouseEntered(evt);
/*      */           }
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1142 */             Datos.this.jLabel55MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1146 */     this.jLabel91.setFont(new Font("Tahoma", 2, 11));
/* 1147 */     this.jLabel91.setForeground(new Color(15, 87, 51));
/* 1148 */     this.jLabel91.setText("<html><u>Otro</u></html>");
/* 1149 */     this.jLabel91.addMouseListener(new MouseAdapter() {
/*      */           public void mouseExited(MouseEvent evt) {
/* 1151 */             Datos.this.jLabel91MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1154 */             Datos.this.jLabel91MouseEntered(evt);
/*      */           }
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1157 */             Datos.this.jLabel91MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1161 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 1162 */     this.jPanel30.setLayout(jPanel30Layout);
/* 1163 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 1164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1165 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
/* 1166 */           .addContainerGap(-1, 32767)
/* 1167 */           .addComponent(this.jLabel91, -2, 30, -2)
/* 1168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1169 */           .addComponent(this.jLabel44, -2, 300, -2)
/* 1170 */           .addGap(18, 18, 18)
/* 1171 */           .addComponent(this.jLabel55, -2, -1, -2)
/* 1172 */           .addContainerGap()));
/*      */     
/* 1174 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 1175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1176 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 1177 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 1179 */               .addGap(5, 5, 5)
/* 1180 */               .addComponent(this.jLabel55, -2, -1, -2))
/* 1181 */             .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1182 */               .addComponent(this.jLabel44)
/* 1183 */               .addComponent(this.jLabel91, -2, -1, -2)))
/* 1184 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1187 */     this.jPanel31.setBackground(new Color(255, 255, 255));
/* 1188 */     this.jPanel31.setBorder(BorderFactory.createTitledBorder(null, "AUTORIZÓ", 2, 4, new Font("Tahoma", 1, 11)));
/*      */     
/* 1190 */     this.jLabel45.setFont(new Font("Tahoma", 1, 11));
/* 1191 */     this.jLabel45.setForeground(Color.blue);
/* 1192 */     this.jLabel45.setHorizontalAlignment(0);
/* 1193 */     this.jLabel45.setText("KOFUZ01");
/*      */     
/* 1195 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1196 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1197 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1199 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1200 */           .addContainerGap()
/* 1201 */           .addComponent(this.jLabel45, -1, 199, 32767)
/* 1202 */           .addContainerGap()));
/*      */     
/* 1204 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1205 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1206 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1207 */           .addComponent(this.jLabel45)
/* 1208 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1211 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/* 1213 */     this.jCheckBox3.setSelected(true);
/* 1214 */     this.jCheckBox3.setText("Semarnat");
/* 1215 */     this.jCheckBox3.setToolTipText("Activa la casilla si deseas que el sistema imprima el registro SEMARNAT");
/*      */     
/* 1217 */     this.materialButton16.setBackground(this.lc.SECUNDARIO1);
/* 1218 */     this.materialButton16.setForeground(new Color(255, 255, 255));
/* 1219 */     this.materialButton16.setMnemonic('S');
/* 1220 */     this.materialButton16.setText("Salir");
/* 1221 */     this.materialButton16.setToolTipText("Salir (Alt+S)");
/* 1222 */     this.materialButton16.setFont(new Font("Cantarell", 0, 12));
/* 1223 */     this.materialButton16.setHorizontalTextPosition(0);
/* 1224 */     this.materialButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1226 */             Datos.this.materialButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1230 */     this.materialButton17.setBackground(this.lc.SECUNDARIO1);
/* 1231 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 1232 */     this.materialButton17.setMnemonic('D');
/* 1233 */     this.materialButton17.setText("Desc.");
/* 1234 */     this.materialButton17.setToolTipText("Descripción (Alt+D)");
/* 1235 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 1236 */     this.materialButton17.setHorizontalTextPosition(0);
/* 1237 */     this.materialButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1239 */             Datos.this.materialButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1243 */     this.materialButton18.setBackground(this.lc.PRIMARIO1);
/* 1244 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/* 1245 */     this.materialButton18.setMnemonic('I');
/* 1246 */     this.materialButton18.setText("Imprimir");
/* 1247 */     this.materialButton18.setToolTipText("Imprimir Guía (Alt+I)");
/* 1248 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/* 1249 */     this.materialButton18.setHorizontalTextPosition(0);
/* 1250 */     this.materialButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1252 */             Datos.this.materialButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1256 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1257 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1258 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1259 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1260 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1261 */           .addContainerGap()
/* 1262 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1263 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1264 */               .addComponent((Component)this.materialButton18, -1, 119, 32767)
/* 1265 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1266 */               .addComponent((Component)this.materialButton17, -2, 110, -2)
/* 1267 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1268 */               .addComponent((Component)this.materialButton16, -2, 110, -2))
/* 1269 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1270 */               .addComponent(this.jCheckBox3)
/* 1271 */               .addGap(0, 0, 32767)))
/* 1272 */           .addContainerGap()));
/*      */     
/* 1274 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1276 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1277 */           .addComponent(this.jCheckBox3)
/* 1278 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1279 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1280 */             .addComponent((Component)this.materialButton16, -2, 38, -2)
/* 1281 */             .addComponent((Component)this.materialButton17, -2, 38, -2)
/* 1282 */             .addComponent((Component)this.materialButton18, -2, 38, -2))
/* 1283 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1286 */     this.jPanel33.setBackground(new Color(255, 255, 255));
/* 1287 */     this.jPanel33.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1289 */     this.jLabel46.setFont(new Font("Tahoma", 0, 9));
/* 1290 */     this.jLabel46.setHorizontalAlignment(0);
/* 1291 */     this.jLabel46.setText("<HTML><CENTER>PERMISO SEMARNAT<BR>19-09PS-I-02D-03<BR><BR>RENOVACIÓN<BR>19-09PS-I-021D-05<BR>REGISTRO SCT<BR>200045-CG-17</CENTER></HTML>");
/*      */     
/* 1293 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1294 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1295 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1296 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1297 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1298 */           .addContainerGap()
/* 1299 */           .addComponent(this.jLabel46, -1, 177, 32767)
/* 1300 */           .addContainerGap()));
/*      */     
/* 1302 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1303 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1304 */         .addComponent(this.jLabel46, -2, 78, 32767));
/*      */ 
/*      */     
/* 1307 */     this.jLabel47.setFont(new Font("Tahoma", 1, 11));
/* 1308 */     this.jLabel47.setHorizontalAlignment(0);
/* 1309 */     this.jLabel47.setText("FOLIO No.");
/*      */     
/* 1311 */     this.jTextField2.setEditable(false);
/* 1312 */     this.jTextField2.setFont(new Font("Tahoma", 1, 20));
/* 1313 */     this.jTextField2.setForeground(Color.blue);
/* 1314 */     this.jTextField2.setHorizontalAlignment(0);
/*      */     
/* 1316 */     this.jPanel34.setBackground(new Color(255, 255, 255));
/* 1317 */     this.jPanel34.setBorder(BorderFactory.createTitledBorder(null, "PESO ESTIMADO", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/* 1319 */     this.jLabel56.setFont(new Font("Tahoma", 1, 11));
/* 1320 */     this.jLabel56.setText("PESO");
/*      */     
/* 1322 */     this.jLabel59.setFont(new Font("Tahoma", 1, 12));
/* 1323 */     this.jLabel59.setForeground(new Color(255, 0, 0));
/* 1324 */     this.jLabel59.setHorizontalAlignment(4);
/* 1325 */     this.jLabel59.setText("0");
/*      */     
/* 1327 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1328 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1329 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1330 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1331 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1332 */           .addContainerGap(-1, 32767)
/* 1333 */           .addComponent(this.jLabel56, -2, 67, -2)
/* 1334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1335 */           .addComponent(this.jLabel59, -1, -1, 32767)
/* 1336 */           .addGap(4, 4, 4)));
/*      */     
/* 1338 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1339 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1340 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1341 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1342 */             .addComponent(this.jLabel56)
/* 1343 */             .addComponent(this.jLabel59))
/* 1344 */           .addContainerGap(13, 32767)));
/*      */ 
/*      */     
/* 1347 */     this.jLabel61.setFont(new Font("Tahoma", 1, 10));
/* 1348 */     this.jLabel61.setForeground(new Color(255, 0, 0));
/* 1349 */     this.jLabel61.setHorizontalAlignment(0);
/* 1350 */     this.jLabel61.setText("AQUÍ SE CARGA EL TEXTO");
/*      */     
/* 1352 */     this.jLabel64.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Forsis 190x.png")));
/*      */     
/* 1354 */     this.jCheckBox1.setText("Activar Nuevos Manifiestos");
/*      */     
/* 1356 */     this.jCheckBox2.setText("Activar Electrónicos");
/*      */     
/* 1358 */     this.jCheckBox4.setSelected(true);
/* 1359 */     this.jCheckBox4.setText("SEMARNAT");
/*      */     
/* 1361 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1362 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1363 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1364 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1365 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1366 */           .addContainerGap()
/* 1367 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1368 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1369 */               .addComponent(this.jLabel64, -2, 185, -2)
/* 1370 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1371 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1372 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1373 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1374 */                     .addComponent(this.jLabel22, -2, 421, -2)
/* 1375 */                     .addGroup(jPanel5Layout.createSequentialGroup()
/* 1376 */                       .addGap(31, 31, 31)
/* 1377 */                       .addComponent(this.jLabel13, -2, 174, -2)
/* 1378 */                       .addGap(51, 51, 51)
/* 1379 */                       .addComponent(this.jLabel14, -2, 125, -2))))
/* 1380 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1381 */                   .addGap(77, 77, 77)
/* 1382 */                   .addComponent(this.jLabel11, -2, 261, -2)))
/* 1383 */               .addGap(8, 8, 8)
/* 1384 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1385 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1386 */                   .addComponent(this.jLabel17, -2, 125, -2)
/* 1387 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1388 */                   .addComponent(this.jPanel33, -2, -1, -2))
/* 1389 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1390 */                   .addComponent(this.jPanel21, -2, -1, -2)
/* 1391 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1392 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1393 */                     .addComponent(this.jCheckBox4, -1, -1, 32767)
/* 1394 */                     .addComponent(this.jLabel47, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1395 */                     .addComponent(this.jTextField2))))
/* 1396 */               .addGap(49, 49, 49))
/* 1397 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1398 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1399 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1400 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1401 */                     .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1402 */                       .addGroup(jPanel5Layout.createSequentialGroup()
/* 1403 */                         .addComponent(this.jPanel26, -2, -1, -2)
/* 1404 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1405 */                         .addComponent(this.jPanel27, -1, -1, 32767))
/* 1406 */                       .addComponent(this.jPanel24, -1, -1, 32767))
/* 1407 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1408 */                     .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1409 */                       .addComponent(this.jPanel34, -1, -1, 32767)
/* 1410 */                       .addComponent(this.jPanel25, -2, -1, -2)))
/* 1411 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1412 */                     .addComponent(this.jPanel22, -2, -1, -2)
/* 1413 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1414 */                     .addComponent(this.jPanel23, -2, -1, -2)))
/* 1415 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1416 */                   .addGroup(jPanel5Layout.createSequentialGroup()
/* 1417 */                     .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1418 */                       .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 1419 */                         .addComponent(this.jCheckBox1, -2, 183, -2)
/* 1420 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1421 */                         .addComponent(this.jCheckBox2, -2, 136, -2)
/* 1422 */                         .addGap(36, 36, 36))
/* 1423 */                       .addGroup(jPanel5Layout.createSequentialGroup()
/* 1424 */                         .addComponent(this.jLabel61, -2, 278, -2)
/* 1425 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
/* 1426 */                     .addComponent(this.jPanel32, -2, -1, -2)
/* 1427 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1428 */                     .addComponent(this.jPanel31, -2, -1, -2))
/* 1429 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1430 */                     .addComponent(this.jPanel28, -2, -1, -2)
/* 1431 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1432 */                     .addComponent(this.jPanel29, -2, -1, -2)
/* 1433 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1434 */                     .addComponent(this.jPanel30, -1, -1, 32767))))
/* 1435 */               .addGap(39, 39, 39)))
/* 1436 */           .addContainerGap()));
/*      */     
/* 1438 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1440 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1441 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1442 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1443 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1444 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1445 */                   .addContainerGap()
/* 1446 */                   .addComponent(this.jLabel64, -1, -1, 32767))
/* 1447 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1448 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1449 */                     .addComponent(this.jLabel22, -2, 65, -2)
/* 1450 */                     .addGroup(jPanel5Layout.createSequentialGroup()
/* 1451 */                       .addContainerGap()
/* 1452 */                       .addComponent(this.jLabel47)
/* 1453 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1454 */                       .addComponent(this.jTextField2, -2, 44, -2)
/* 1455 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1456 */                       .addComponent(this.jCheckBox4))
/* 1457 */                     .addGroup(jPanel5Layout.createSequentialGroup()
/* 1458 */                       .addGap(29, 29, 29)
/* 1459 */                       .addComponent(this.jPanel21, -2, -1, -2)))
/* 1460 */                   .addGap(9, 9, 9)
/* 1461 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1462 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1463 */                       .addComponent(this.jLabel13, -2, 64, -2)
/* 1464 */                       .addComponent(this.jLabel14, -2, 58, -2)
/* 1465 */                       .addComponent(this.jLabel17, -2, 56, -2))
/* 1466 */                     .addComponent(this.jPanel33, -2, -1, -2))))
/* 1467 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1468 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1469 */                 .addComponent(this.jPanel23, 0, -1, 32767)
/* 1470 */                 .addComponent(this.jPanel22, -1, -1, 32767))
/* 1471 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1472 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1473 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1474 */                   .addComponent(this.jPanel24, -2, -1, -2)
/* 1475 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1476 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1477 */                     .addComponent(this.jPanel26, -1, -1, 32767)
/* 1478 */                     .addComponent(this.jPanel27, -1, -1, 32767)))
/* 1479 */                 .addGroup(jPanel5Layout.createSequentialGroup()
/* 1480 */                   .addComponent(this.jPanel34, -2, -1, -2)
/* 1481 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1482 */                   .addComponent(this.jPanel25, -2, -1, -2)))
/* 1483 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1484 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1485 */                 .addComponent(this.jPanel30, -2, -1, -2)
/* 1486 */                 .addComponent(this.jPanel29, -2, -1, -2)
/* 1487 */                 .addComponent(this.jPanel28, -2, -1, -2)))
/* 1488 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1489 */               .addContainerGap(72, 32767)
/* 1490 */               .addComponent(this.jLabel11, -2, 74, -2)
/* 1491 */               .addGap(434, 434, 434)))
/* 1492 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1493 */             .addComponent(this.jPanel32, -1, -1, 32767)
/* 1494 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1495 */               .addGap(18, 18, 18)
/* 1496 */               .addComponent(this.jPanel31, -2, -1, -2))
/* 1497 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1498 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1499 */                 .addComponent(this.jCheckBox1)
/* 1500 */                 .addComponent(this.jCheckBox2))
/* 1501 */               .addGap(23, 23, 23)
/* 1502 */               .addComponent(this.jLabel61)))
/* 1503 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1506 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1507 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1508 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1509 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1510 */         .addComponent(this.jPanel5, -2, 994, -2));
/*      */     
/* 1512 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1513 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1514 */         .addComponent(this.jPanel5, -2, -1, -2));
/*      */ 
/*      */     
/* 1517 */     this.jDialog2.setTitle("Búsqueda de Operadores");
/*      */     
/* 1519 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/* 1520 */     this.jLabel58.setHorizontalAlignment(4);
/* 1521 */     this.jLabel58.setText("Clave");
/*      */     
/* 1523 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1525 */             Datos.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1529 */     this.jLabel60.setFont(new Font("Cantarell", 0, 11));
/* 1530 */     this.jLabel60.setHorizontalAlignment(4);
/* 1531 */     this.jLabel60.setText("Nombre");
/*      */     
/* 1533 */     this.jTextField13.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1535 */             Datos.this.jTextField13KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1539 */     this.materialButton5.setBackground(this.lc.SECUNDARIO1);
/* 1540 */     this.materialButton5.setForeground(new Color(255, 255, 255));
/* 1541 */     this.materialButton5.setMnemonic('C');
/* 1542 */     this.materialButton5.setText("Cerrar");
/* 1543 */     this.materialButton5.setToolTipText("Cerrar (Alt+C)");
/* 1544 */     this.materialButton5.setFont(new Font("Cantarell", 0, 12));
/* 1545 */     this.materialButton5.setHorizontalTextPosition(0);
/* 1546 */     this.materialButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1548 */             Datos.this.materialButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1552 */     this.materialButton11.setBackground(this.lc.PRIMARIO1);
/* 1553 */     this.materialButton11.setForeground(new Color(255, 255, 255));
/* 1554 */     this.materialButton11.setMnemonic('A');
/* 1555 */     this.materialButton11.setText("Asignar");
/* 1556 */     this.materialButton11.setToolTipText("Asignar Viaje (Alt+A)");
/* 1557 */     this.materialButton11.setEnabled(false);
/* 1558 */     this.materialButton11.setFont(new Font("Cantarell", 0, 12));
/* 1559 */     this.materialButton11.setHorizontalTextPosition(0);
/* 1560 */     this.materialButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1562 */             Datos.this.materialButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1566 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1574 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1579 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1582 */     this.rSTableMetro3.setAltoHead(25);
/* 1583 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1584 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1585 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1586 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1587 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1588 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1589 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1590 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 11));
/* 1591 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 1592 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1593 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1594 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1595 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1596 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1597 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1598 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1600 */             Datos.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1603 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1605 */             Datos.this.rSTableMetro3KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1608 */             Datos.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1611 */     this.jScrollPane19.setViewportView((Component)this.rSTableMetro3);
/*      */     
/* 1613 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1614 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1615 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1616 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1617 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1618 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1619 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1620 */               .addContainerGap()
/* 1621 */               .addComponent(this.jScrollPane19, -2, 0, 32767))
/* 1622 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1623 */               .addContainerGap(-1, 32767)
/* 1624 */               .addComponent((Component)this.materialButton11, -2, 150, -2)
/* 1625 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1626 */               .addComponent((Component)this.materialButton5, -2, 110, -2))
/* 1627 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
/* 1628 */               .addGap(19, 19, 19)
/* 1629 */               .addComponent(this.jLabel58, -2, 40, -2)
/* 1630 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1631 */               .addComponent(this.jTextField12, -2, 70, -2)
/* 1632 */               .addGap(44, 44, 44)
/* 1633 */               .addComponent(this.jLabel60, -2, 45, -2)
/* 1634 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1635 */               .addComponent(this.jTextField13, -2, 134, -2)
/* 1636 */               .addGap(0, 63, 32767)))
/* 1637 */           .addContainerGap()));
/*      */     
/* 1639 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1641 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1642 */           .addContainerGap()
/* 1643 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1644 */             .addComponent(this.jLabel58)
/* 1645 */             .addComponent(this.jTextField12, -2, -1, -2)
/* 1646 */             .addComponent(this.jLabel60)
/* 1647 */             .addComponent(this.jTextField13, -2, -1, -2))
/* 1648 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1649 */           .addComponent(this.jScrollPane19, -1, 268, 32767)
/* 1650 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1651 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1652 */             .addComponent((Component)this.materialButton5, -2, 38, -2)
/* 1653 */             .addComponent((Component)this.materialButton11, -2, 38, -2))
/* 1654 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1657 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1658 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1659 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1660 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1661 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 1663 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1664 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1665 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 1668 */     this.jDialog3.setTitle("Cancelar Viaje");
/*      */     
/* 1670 */     this.jLabel63.setFont(new Font("Cantarell", 0, 11));
/* 1671 */     this.jLabel63.setText("Motivo");
/*      */     
/* 1673 */     this.jTextField14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1675 */             Datos.this.jTextField14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1678 */     this.jTextField14.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1680 */             Datos.this.jTextField14KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1684 */     this.materialButton6.setBackground(this.lc.SECUNDARIO1);
/* 1685 */     this.materialButton6.setForeground(new Color(255, 255, 255));
/* 1686 */     this.materialButton6.setMnemonic('C');
/* 1687 */     this.materialButton6.setText("Cerrar");
/* 1688 */     this.materialButton6.setToolTipText("Cerrar (Alt+C)");
/* 1689 */     this.materialButton6.setFont(new Font("Cantarell", 0, 12));
/* 1690 */     this.materialButton6.setHorizontalTextPosition(0);
/* 1691 */     this.materialButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1693 */             Datos.this.materialButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1697 */     this.materialButton12.setBackground(this.lc.PRIMARIO1);
/* 1698 */     this.materialButton12.setForeground(new Color(255, 255, 255));
/* 1699 */     this.materialButton12.setMnemonic('L');
/* 1700 */     this.materialButton12.setText("Cancelar Llamada");
/* 1701 */     this.materialButton12.setToolTipText("Cancelar Llamada (Alt+L)");
/* 1702 */     this.materialButton12.setFont(new Font("Cantarell", 0, 12));
/* 1703 */     this.materialButton12.setHorizontalTextPosition(0);
/* 1704 */     this.materialButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1706 */             Datos.this.materialButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1710 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1711 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1712 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1713 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1714 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1715 */           .addContainerGap()
/* 1716 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1718 */               .addComponent(this.jLabel63, -2, 58, -2)
/* 1719 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1720 */               .addComponent(this.jTextField14))
/* 1721 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1722 */               .addGap(0, 56, 32767)
/* 1723 */               .addComponent((Component)this.materialButton12, -2, 150, -2)
/* 1724 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1725 */               .addComponent((Component)this.materialButton6, -2, 110, -2)))
/* 1726 */           .addContainerGap()));
/*      */     
/* 1728 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1729 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1730 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1731 */           .addContainerGap()
/* 1732 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1733 */             .addComponent(this.jTextField14, -2, -1, -2)
/* 1734 */             .addComponent(this.jLabel63))
/* 1735 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767)
/* 1736 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1737 */             .addComponent((Component)this.materialButton6, -2, 38, -2)
/* 1738 */             .addComponent((Component)this.materialButton12, -2, 38, -2))));
/*      */ 
/*      */     
/* 1741 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1742 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1743 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1745 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1746 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 1747 */           .addGap(0, 0, 32767)));
/*      */     
/* 1749 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1750 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1751 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/* 1754 */     this.jDialog4.setTitle("Búsqueda de Tractores");
/* 1755 */     this.jDialog4.setModal(true);
/*      */     
/* 1757 */     this.jLabel69.setFont(new Font("Cantarell", 0, 11));
/* 1758 */     this.jLabel69.setText("Núm");
/*      */     
/* 1760 */     this.jTextField15.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1762 */             Datos.this.jTextField15KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1766 */     this.jLabel70.setFont(new Font("Cantarell", 0, 11));
/* 1767 */     this.jLabel70.setText("Estado");
/*      */     
/* 1769 */     this.materialButton7.setBackground(this.lc.SECUNDARIO1);
/* 1770 */     this.materialButton7.setForeground(new Color(255, 255, 255));
/* 1771 */     this.materialButton7.setMnemonic('C');
/* 1772 */     this.materialButton7.setText("Cerrar");
/* 1773 */     this.materialButton7.setToolTipText("Cerrar (Alt+C)");
/* 1774 */     this.materialButton7.setFont(new Font("Cantarell", 0, 12));
/* 1775 */     this.materialButton7.setHorizontalTextPosition(0);
/* 1776 */     this.materialButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1778 */             Datos.this.materialButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1782 */     this.materialButton13.setBackground(this.lc.PRIMARIO1);
/* 1783 */     this.materialButton13.setForeground(new Color(255, 255, 255));
/* 1784 */     this.materialButton13.setMnemonic('A');
/* 1785 */     this.materialButton13.setText("Asignar");
/* 1786 */     this.materialButton13.setToolTipText("Asignar Viaje (Alt+A)");
/* 1787 */     this.materialButton13.setEnabled(false);
/* 1788 */     this.materialButton13.setFont(new Font("Cantarell", 0, 12));
/* 1789 */     this.materialButton13.setHorizontalTextPosition(0);
/* 1790 */     this.materialButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1792 */             Datos.this.materialButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1796 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1804 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1809 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1812 */     this.rSTableMetro4.setAltoHead(25);
/* 1813 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1814 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1815 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1816 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1817 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1818 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1819 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1820 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 11));
/* 1821 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 1822 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1823 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1824 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1825 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1826 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1827 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1828 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1830 */             Datos.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1833 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1835 */             Datos.this.rSTableMetro4KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1838 */             Datos.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1841 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro4);
/*      */     
/* 1843 */     this.jComboBox18.setBackground(new Color(255, 255, 255));
/* 1844 */     this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 1845 */     this.jComboBox18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1847 */             Datos.this.jComboBox18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1851 */     this.jPanel50.setBackground(this.lc.SECUNDARIO2);
/* 1852 */     this.jPanel50.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1854 */     this.jLabel125.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1855 */     this.jLabel125.setForeground(this.lc.SECUNDARIO1);
/* 1856 */     this.jLabel125.setHorizontalAlignment(4);
/* 1857 */     this.jLabel125.setText("Total");
/* 1858 */     this.jPanel50.add(this.jLabel125);
/*      */     
/* 1860 */     this.jLabel126.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1861 */     this.jLabel126.setForeground(this.lc.PRIMARIO1);
/* 1862 */     this.jLabel126.setHorizontalAlignment(2);
/* 1863 */     this.jLabel126.setText("t");
/* 1864 */     this.jPanel50.add(this.jLabel126);
/*      */     
/* 1866 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1867 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1868 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1869 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1870 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1871 */           .addGap(18, 18, 18)
/* 1872 */           .addComponent(this.jLabel69, -2, 40, -2)
/* 1873 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1874 */           .addComponent(this.jTextField15, -2, 52, -2)
/* 1875 */           .addGap(54, 54, 54)
/* 1876 */           .addComponent(this.jLabel70, -2, 45, -2)
/* 1877 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1878 */           .addComponent(this.jComboBox18, -2, 157, -2)
/* 1879 */           .addContainerGap(-1, 32767))
/* 1880 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1881 */           .addContainerGap()
/* 1882 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1883 */             .addGroup(jPanel9Layout.createSequentialGroup()
/* 1884 */               .addComponent(this.jPanel50, -2, 105, -2)
/* 1885 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1886 */               .addComponent((Component)this.materialButton13, -2, 150, -2)
/* 1887 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1888 */               .addComponent((Component)this.materialButton7, -2, 110, -2))
/* 1889 */             .addComponent(this.jScrollPane20, -1, 500, 32767))
/* 1890 */           .addContainerGap()));
/*      */     
/* 1892 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1893 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1894 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1895 */           .addContainerGap()
/* 1896 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1897 */             .addComponent(this.jLabel69)
/* 1898 */             .addComponent(this.jTextField15, -2, -1, -2)
/* 1899 */             .addComponent(this.jLabel70)
/* 1900 */             .addComponent(this.jComboBox18, -2, -1, -2))
/* 1901 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1902 */           .addComponent(this.jScrollPane20, -1, 269, 32767)
/* 1903 */           .addGap(11, 11, 11)
/* 1904 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1905 */             .addComponent(this.jPanel50, -2, 37, -2)
/* 1906 */             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1907 */               .addComponent((Component)this.materialButton7, -2, 38, -2)
/* 1908 */               .addComponent((Component)this.materialButton13, -2, 38, -2)))
/* 1909 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1912 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1913 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1914 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1915 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1916 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 1918 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1919 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1920 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/* 1923 */     this.jDialog5.setTitle("Búsqueda de Remolques");
/* 1924 */     this.jDialog5.setModal(true);
/*      */     
/* 1926 */     this.jPanel1.setLayout(new GridLayout(1, 6, 8, 0));
/*      */     
/* 1928 */     this.jLabel72.setFont(new Font("Cantarell", 0, 11));
/* 1929 */     this.jLabel72.setHorizontalAlignment(4);
/* 1930 */     this.jLabel72.setText("Núm");
/* 1931 */     this.jPanel1.add(this.jLabel72);
/*      */     
/* 1933 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1935 */             Datos.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/* 1938 */     this.jPanel1.add(this.jTextField17);
/*      */     
/* 1940 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/* 1941 */     this.jLabel73.setHorizontalAlignment(4);
/* 1942 */     this.jLabel73.setText("Placas");
/* 1943 */     this.jPanel1.add(this.jLabel73);
/*      */     
/* 1945 */     this.jTextField18.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1947 */             Datos.this.jTextField18KeyReleased(evt);
/*      */           }
/*      */           public void keyTyped(KeyEvent evt) {
/* 1950 */             Datos.this.jTextField18KeyTyped(evt);
/*      */           }
/*      */         });
/* 1953 */     this.jPanel1.add(this.jTextField18);
/*      */     
/* 1955 */     this.jLabel74.setFont(new Font("Cantarell", 0, 11));
/* 1956 */     this.jLabel74.setHorizontalAlignment(4);
/* 1957 */     this.jLabel74.setText("Tipo");
/* 1958 */     this.jPanel1.add(this.jLabel74);
/*      */     
/* 1960 */     this.jTextField19.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1962 */             Datos.this.jTextField19KeyReleased(evt);
/*      */           }
/*      */         });
/* 1965 */     this.jPanel1.add(this.jTextField19);
/*      */     
/* 1967 */     this.materialButton8.setBackground(this.lc.SECUNDARIO1);
/* 1968 */     this.materialButton8.setForeground(new Color(255, 255, 255));
/* 1969 */     this.materialButton8.setMnemonic('C');
/* 1970 */     this.materialButton8.setText("Cerrar");
/* 1971 */     this.materialButton8.setToolTipText("Cerrar (Alt+C)");
/* 1972 */     this.materialButton8.setFont(new Font("Cantarell", 0, 12));
/* 1973 */     this.materialButton8.setHorizontalTextPosition(0);
/* 1974 */     this.materialButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1976 */             Datos.this.materialButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1980 */     this.materialButton14.setBackground(this.lc.PRIMARIO1);
/* 1981 */     this.materialButton14.setForeground(new Color(255, 255, 255));
/* 1982 */     this.materialButton14.setMnemonic('A');
/* 1983 */     this.materialButton14.setText("Asignar");
/* 1984 */     this.materialButton14.setToolTipText("Asignar Viaje (Alt+A)");
/* 1985 */     this.materialButton14.setEnabled(false);
/* 1986 */     this.materialButton14.setFont(new Font("Cantarell", 0, 12));
/* 1987 */     this.materialButton14.setHorizontalTextPosition(0);
/* 1988 */     this.materialButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1990 */             Datos.this.materialButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1994 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2002 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2007 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2010 */     this.rSTableMetro5.setAltoHead(25);
/* 2011 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2012 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/* 2013 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/* 2014 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2015 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/* 2016 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/* 2017 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/* 2018 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 11));
/* 2019 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 2020 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2021 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2022 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/* 2023 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/* 2024 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/* 2025 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/* 2026 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2028 */             Datos.this.rSTableMetro5MouseClicked(evt);
/*      */           }
/*      */         });
/* 2031 */     this.jScrollPane21.setViewportView((Component)this.rSTableMetro5);
/*      */     
/* 2033 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 2034 */     this.jPanel10.setLayout(jPanel10Layout);
/* 2035 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 2036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2037 */         .addComponent(this.jPanel1, -1, -1, 32767)
/* 2038 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2039 */           .addContainerGap()
/* 2040 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2041 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 2042 */               .addGap(0, 234, 32767)
/* 2043 */               .addComponent((Component)this.materialButton14, -2, 150, -2)
/* 2044 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2045 */               .addComponent((Component)this.materialButton8, -2, 110, -2))
/* 2046 */             .addComponent(this.jScrollPane21))
/* 2047 */           .addContainerGap()));
/*      */     
/* 2049 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 2050 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2051 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2052 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 2053 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2054 */           .addComponent(this.jScrollPane21, -1, 287, 32767)
/* 2055 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2056 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2057 */             .addComponent((Component)this.materialButton8, -2, 38, -2)
/* 2058 */             .addComponent((Component)this.materialButton14, -2, 38, -2))));
/*      */ 
/*      */     
/* 2061 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 2062 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 2063 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 2064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2065 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 2067 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 2068 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2069 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 2072 */     this.jDialog6.setTitle("Cancelar Llamada");
/*      */     
/* 2074 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*      */     
/* 2076 */     this.jLabel89.setFont(new Font("Tahoma", 1, 14));
/* 2077 */     this.jLabel89.setForeground(new Color(0, 102, 102));
/* 2078 */     this.jLabel89.setHorizontalAlignment(0);
/* 2079 */     this.jLabel89.setText("Motivo de la Cancelación");
/*      */     
/* 2081 */     this.jLabel90.setFont(new Font("Tahoma", 3, 11));
/* 2082 */     this.jLabel90.setForeground(new Color(15, 87, 51));
/* 2083 */     this.jLabel90.setHorizontalAlignment(4);
/* 2084 */     this.jLabel90.setText("Motivo");
/*      */     
/* 2086 */     this.jTextField20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2088 */             Datos.this.jTextField20ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2091 */     this.jTextField20.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2093 */             Datos.this.jTextField20KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2097 */     this.jButton21.setText("Cancelar Llamada");
/* 2098 */     this.jButton21.setToolTipText("Cancelar Llamada");
/* 2099 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2101 */             Datos.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2105 */     this.jButton22.setMnemonic('C');
/* 2106 */     this.jButton22.setText("Cerrar");
/* 2107 */     this.jButton22.setToolTipText("Cerrar (Alt+C)");
/* 2108 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2110 */             Datos.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2114 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2115 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2116 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2117 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2118 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2119 */           .addContainerGap()
/* 2120 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2121 */             .addComponent(this.jLabel89, -1, 279, 32767)
/* 2122 */             .addComponent(this.jSeparator7, -1, 279, 32767)
/* 2123 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2124 */               .addComponent(this.jLabel90, -2, 57, -2)
/* 2125 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2126 */               .addComponent(this.jTextField20, -1, 218, 32767))
/* 2127 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
/* 2128 */               .addComponent(this.jButton21)
/* 2129 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2130 */               .addComponent(this.jButton22)))
/* 2131 */           .addContainerGap()));
/*      */     
/* 2133 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2134 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2135 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2136 */           .addComponent(this.jLabel89)
/* 2137 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2138 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 2139 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2140 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2141 */             .addComponent(this.jLabel90)
/* 2142 */             .addComponent(this.jTextField20, -2, -1, -2))
/* 2143 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2144 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2145 */             .addComponent(this.jButton22)
/* 2146 */             .addComponent(this.jButton21))
/* 2147 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2150 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2151 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2152 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2153 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2154 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*      */     
/* 2156 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2157 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2158 */         .addComponent(this.jPanel17, -2, -1, -2));
/*      */ 
/*      */     
/* 2161 */     this.jDialog7.setTitle("Descripción del Viaje");
/*      */     
/* 2163 */     this.jLabel94.setFont(new Font("Cantarell", 0, 11));
/* 2164 */     this.jLabel94.setForeground(this.lc.PRIMARIO2);
/* 2165 */     this.jLabel94.setText("<html>Aquí puedes agregar alguna descripción corta del viaje, ruta a seguir, cantidades, objetivos, contenidos, descripciones, sólo por mencionar algunos.</html>");
/* 2166 */     this.jLabel94.setVerticalAlignment(1);
/*      */     
/* 2168 */     this.jTextArea1.setColumns(20);
/* 2169 */     this.jTextArea1.setLineWrap(true);
/* 2170 */     this.jTextArea1.setRows(5);
/* 2171 */     this.jScrollPane6.setViewportView(this.jTextArea1);
/*      */     
/* 2173 */     this.materialButton15.setBackground(this.lc.SECUNDARIO1);
/* 2174 */     this.materialButton15.setForeground(new Color(255, 255, 255));
/* 2175 */     this.materialButton15.setMnemonic('C');
/* 2176 */     this.materialButton15.setText("Cerrar");
/* 2177 */     this.materialButton15.setToolTipText("Cerrar (Alt+C)");
/* 2178 */     this.materialButton15.setFont(new Font("Cantarell", 0, 12));
/* 2179 */     this.materialButton15.setHorizontalTextPosition(0);
/* 2180 */     this.materialButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2182 */             Datos.this.materialButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2186 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 2187 */     this.jPanel18.setLayout(jPanel18Layout);
/* 2188 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 2189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2190 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 2191 */           .addContainerGap()
/* 2192 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2193 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.TRAILING, -1, 362, 32767)
/* 2194 */             .addComponent(this.jLabel94, -2, 0, 32767)
/* 2195 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
/* 2196 */               .addGap(0, 0, 32767)
/* 2197 */               .addComponent((Component)this.materialButton15, -2, 110, -2)))
/* 2198 */           .addContainerGap()));
/*      */     
/* 2200 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 2201 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2202 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 2203 */           .addComponent(this.jLabel94, -2, 49, -2)
/* 2204 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2205 */           .addComponent(this.jScrollPane6, -1, 119, 32767)
/* 2206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2207 */           .addComponent((Component)this.materialButton15, -2, 38, -2)));
/*      */ 
/*      */     
/* 2210 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2211 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2212 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2213 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2214 */         .addComponent(this.jPanel18, -1, -1, 32767));
/*      */     
/* 2216 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2217 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2218 */         .addComponent(this.jPanel18, -1, -1, 32767));
/*      */ 
/*      */     
/* 2221 */     this.jLabel96.setFont(new Font("Cantarell", 0, 11));
/* 2222 */     this.jLabel96.setText("Selecciona el tipo de Remolque:");
/*      */     
/* 2224 */     this.jComboBox16.setBackground(new Color(244, 244, 244));
/* 2225 */     this.jComboBox16.setModel(new DefaultComboBoxModel<>(new String[] { "Bulldozer", "Cama Baja", "Camioneta 350", "Camioneta Estaquita", "Camioneta Pick Up", "Camioneta Piloto", "Contenedor Marino", "Cuello de Ganzo", "Excavadora Oruga", "Góndola", "Hiab", "LowBoy", "Pipa", "Plana", "Plataforma", "Presas Metálicas", "Presión y Vacío", "Porta Contenedores", "Quinta Sencilla", "Quinta con Winche", "Quinta con Hiab", "Rabón", "Retroexcavadora", "Tiro Directo", "Tolva Granelera", "Tolva De Alumnio", "Tolva De Acero Inoxidable", "Tolva Presurizada", "Torton", "Utilitario", "Otro" }));
/* 2226 */     this.jComboBox16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2228 */             Datos.this.jComboBox16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2232 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 2233 */     this.jPanel19.setLayout(jPanel19Layout);
/* 2234 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 2235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */         .addComponent(this.jLabel96, -1, 252, 32767)
/* 2237 */         .addComponent(this.jComboBox16, 0, 252, 32767));
/*      */     
/* 2239 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 2240 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2241 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2242 */           .addComponent(this.jLabel96)
/* 2243 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2244 */           .addComponent(this.jComboBox16, -2, -1, -2)));
/*      */ 
/*      */     
/* 2247 */     this.jDialog8.setTitle("Licencia Vencida");
/* 2248 */     this.jDialog8.setModal(true);
/*      */     
/* 2250 */     this.jPanel20.setBackground(new Color(255, 255, 255));
/*      */     
/* 2252 */     this.jLabel97.setFont(new Font("Cantarell", 0, 22));
/* 2253 */     this.jLabel97.setForeground(this.lc.PRIMARIO1);
/* 2254 */     this.jLabel97.setHorizontalAlignment(0);
/* 2255 */     this.jLabel97.setText("Próximo Vencimiento de Licencia");
/*      */     
/* 2257 */     this.jLabel98.setFont(new Font("Cantarell", 0, 13));
/* 2258 */     this.jLabel98.setForeground(this.lc.SECUNDARIO2);
/* 2259 */     this.jLabel98.setHorizontalAlignment(0);
/* 2260 */     this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER</center></html>");
/*      */     
/* 2262 */     this.jLabel99.setFont(new Font("Cantarell", 0, 11));
/* 2263 */     this.jLabel99.setForeground(this.lc.PRIMARIO2);
/* 2264 */     this.jLabel99.setHorizontalAlignment(0);
/* 2265 */     this.jLabel99.setText("<html><center>La vigencia de la licencia se vencerá en menos de un mes, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/*      */     
/* 2267 */     this.jLabel100.setHorizontalAlignment(0);
/* 2268 */     this.jLabel100.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/escudo.png")));
/*      */     
/* 2270 */     this.jLabel101.setFont(new Font("Tahoma", 1, 11));
/* 2271 */     this.jLabel101.setText("|");
/*      */     
/* 2273 */     this.jLabel102.setFont(new Font("Tahoma", 1, 11));
/* 2274 */     this.jLabel102.setForeground(Color.red);
/* 2275 */     this.jLabel102.setHorizontalAlignment(0);
/* 2276 */     this.jLabel102.setText("<html><u>Cerrar</u></html>");
/* 2277 */     this.jLabel102.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2279 */             Datos.this.jLabel102MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2282 */             Datos.this.jLabel102MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2285 */             Datos.this.jLabel102MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2289 */     this.jLabel103.setFont(new Font("Tahoma", 1, 11));
/* 2290 */     this.jLabel103.setText("|");
/*      */     
/* 2292 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2293 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2294 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2295 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2296 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2297 */           .addContainerGap()
/* 2298 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2299 */             .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING, -1, 626, 32767)
/* 2300 */             .addComponent(this.jLabel97, GroupLayout.Alignment.LEADING, -1, 626, 32767)
/* 2301 */             .addGroup(jPanel20Layout.createSequentialGroup()
/* 2302 */               .addComponent(this.jLabel100, -1, 155, 32767)
/* 2303 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2304 */               .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2305 */                 .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2306 */                   .addComponent(this.jLabel99, GroupLayout.Alignment.TRAILING, 0, 0, 32767)
/* 2307 */                   .addComponent(this.jLabel98, GroupLayout.Alignment.TRAILING, -1, 466, 32767))
/* 2308 */                 .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 467, 32767)
/* 2309 */                 .addGroup(jPanel20Layout.createSequentialGroup()
/* 2310 */                   .addComponent(this.jLabel101)
/* 2311 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2312 */                   .addComponent(this.jLabel102, -2, 78, -2)
/* 2313 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2314 */                   .addComponent(this.jLabel103)))))
/* 2315 */           .addContainerGap()));
/*      */     
/* 2317 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2318 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2319 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2320 */           .addComponent(this.jLabel97)
/* 2321 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2322 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 2323 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2324 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2325 */             .addGroup(jPanel20Layout.createSequentialGroup()
/* 2326 */               .addComponent(this.jLabel98, -2, 69, -2)
/* 2327 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2328 */               .addComponent(this.jLabel99, -2, 56, -2)
/* 2329 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2330 */               .addComponent(this.jSeparator10, -2, 10, -2)
/* 2331 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2332 */               .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2333 */                 .addComponent(this.jLabel102, -2, -1, -2)
/* 2334 */                 .addComponent(this.jLabel101)
/* 2335 */                 .addComponent(this.jLabel103)))
/* 2336 */             .addComponent(this.jLabel100, -1, -1, 32767))
/* 2337 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2340 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2341 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2342 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2344 */         .addComponent(this.jPanel20, -1, -1, 32767));
/*      */     
/* 2346 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2348 */         .addComponent(this.jPanel20, -2, -1, -2));
/*      */ 
/*      */     
/* 2351 */     this.jDialog9.setTitle("Acceso Restringido");
/*      */     
/* 2353 */     this.jPanel35.setBackground(new Color(255, 255, 255));
/*      */     
/* 2355 */     this.jLabel104.setFont(new Font("Tahoma", 1, 14));
/* 2356 */     this.jLabel104.setForeground(new Color(51, 102, 255));
/* 2357 */     this.jLabel104.setHorizontalAlignment(0);
/* 2358 */     this.jLabel104.setText("Iniciar Sesión");
/*      */     
/* 2360 */     this.jLabel105.setFont(new Font("Arial", 0, 11));
/* 2361 */     this.jLabel105.setForeground(Color.darkGray);
/* 2362 */     this.jLabel105.setText("<html><center>NOTA: Para entrar al sistema es necesario que tengas una cuenta de usuario. Si aún no la tienes, contacta a los administradores.</center></html>");
/*      */     
/* 2364 */     this.jSeparator11.setOrientation(1);
/*      */     
/* 2366 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/* 2367 */     this.jPanel39.setBorder(BorderFactory.createTitledBorder(null, " Registro ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2369 */     this.jTextField1.setFont(new Font("Tahoma", 1, 12));
/* 2370 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2372 */             Datos.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2375 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 2377 */             Datos.this.jTextField1FocusLost(evt);
/*      */           }
/*      */           public void focusGained(FocusEvent evt) {
/* 2380 */             Datos.this.jTextField1FocusGained(evt);
/*      */           }
/*      */         });
/*      */     
/* 2384 */     this.jLabel106.setFont(new Font("Tahoma", 3, 11));
/* 2385 */     this.jLabel106.setForeground(new Color(15, 87, 51));
/* 2386 */     this.jLabel106.setText("Nombre");
/*      */     
/* 2388 */     this.jLabel107.setFont(new Font("Tahoma", 3, 11));
/* 2389 */     this.jLabel107.setForeground(new Color(15, 87, 51));
/* 2390 */     this.jLabel107.setText("Contraseña");
/*      */     
/* 2392 */     this.jPasswordField1.setToolTipText("Contraseña");
/* 2393 */     this.jPasswordField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2395 */             Datos.this.jPasswordField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2398 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2400 */             Datos.this.jPasswordField1FocusGained(evt);
/*      */           }
/*      */         });
/*      */     
/* 2404 */     this.jButton29.setMnemonic('S');
/* 2405 */     this.jButton29.setText("Salir");
/* 2406 */     this.jButton29.setToolTipText("Salir(Alt+S)");
/* 2407 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2409 */             Datos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2413 */     this.jButton30.setMnemonic('E');
/* 2414 */     this.jButton30.setText("Entrar");
/* 2415 */     this.jButton30.setToolTipText("Entrar (Alt+E)");
/* 2416 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2418 */             Datos.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2422 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 2423 */     this.jPanel39.setLayout(jPanel39Layout);
/* 2424 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 2425 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2426 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 2427 */           .addContainerGap()
/* 2428 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2429 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 2430 */               .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2431 */                 .addGroup(jPanel39Layout.createSequentialGroup()
/* 2432 */                   .addComponent(this.jLabel106, -1, -1, 32767)
/* 2433 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 2434 */                 .addGroup(jPanel39Layout.createSequentialGroup()
/* 2435 */                   .addComponent(this.jLabel107, -1, -1, 32767)
/* 2436 */                   .addGap(7, 7, 7)))
/* 2437 */               .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2438 */                 .addComponent(this.jPasswordField1, GroupLayout.Alignment.TRAILING)
/* 2439 */                 .addComponent(this.jTextField1, GroupLayout.Alignment.TRAILING, -1, 122, 32767)))
/* 2440 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 2441 */               .addComponent(this.jButton30, -2, 61, -2)
/* 2442 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2443 */               .addComponent(this.jButton29, -2, 53, -2)))
/* 2444 */           .addContainerGap()));
/*      */     
/* 2446 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 2447 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2448 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 2449 */           .addGap(11, 11, 11)
/* 2450 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2451 */             .addComponent(this.jLabel106)
/* 2452 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 2453 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2454 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2455 */             .addComponent(this.jLabel107)
/* 2456 */             .addComponent(this.jPasswordField1, -2, 20, -2))
/* 2457 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2458 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2459 */             .addComponent(this.jButton29)
/* 2460 */             .addComponent(this.jButton30))
/* 2461 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2464 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 2465 */     this.jPanel35.setLayout(jPanel35Layout);
/* 2466 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 2467 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2468 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 2469 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2470 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 2471 */               .addGap(61, 61, 61)
/* 2472 */               .addComponent(this.jLabel104, -2, 112, -2))
/* 2473 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 2474 */               .addGap(10, 10, 10)
/* 2475 */               .addComponent(this.jLabel105, -1, 121, 32767)
/* 2476 */               .addGap(7, 7, 7)
/* 2477 */               .addComponent(this.jSeparator11, -2, 6, -2)
/* 2478 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2479 */               .addComponent(this.jPanel39, -2, -1, -2)))
/* 2480 */           .addGap(23, 23, 23)));
/*      */     
/* 2482 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 2483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2484 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 2485 */           .addContainerGap()
/* 2486 */           .addComponent(this.jLabel104)
/* 2487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2488 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2489 */             .addComponent(this.jLabel105, -2, 127, -2)
/* 2490 */             .addComponent(this.jPanel39, -1, -1, 32767)
/* 2491 */             .addComponent(this.jSeparator11, -2, 130, -2))
/* 2492 */           .addGap(20, 20, 20)));
/*      */ 
/*      */     
/* 2495 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2496 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2497 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2498 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2499 */         .addComponent(this.jPanel35, -2, -1, -2));
/*      */     
/* 2501 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2502 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2503 */         .addComponent(this.jPanel35, -2, -1, -2));
/*      */ 
/*      */     
/* 2506 */     this.jDialog20.setTitle("Catálogo de productos y servicios");
/*      */     
/* 2508 */     this.jTextField94.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2510 */             Datos.this.jTextField94ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2513 */     this.jTextField94.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2515 */             Datos.this.jTextField94KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2519 */     this.jTextField95.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2521 */             Datos.this.jTextField95ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2524 */     this.jTextField95.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2526 */             Datos.this.jTextField95KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2530 */     this.jLabel211.setFont(new Font("Cantarell", 0, 11));
/* 2531 */     this.jLabel211.setText("Descripción");
/*      */     
/* 2533 */     this.jLabel212.setFont(new Font("Cantarell", 0, 11));
/* 2534 */     this.jLabel212.setText("Clave");
/*      */     
/* 2536 */     GroupLayout jPanel145Layout = new GroupLayout(this.jPanel145);
/* 2537 */     this.jPanel145.setLayout(jPanel145Layout);
/* 2538 */     jPanel145Layout.setHorizontalGroup(jPanel145Layout
/* 2539 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2540 */         .addGroup(jPanel145Layout.createSequentialGroup()
/* 2541 */           .addComponent(this.jLabel212, -2, 42, -2)
/* 2542 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2543 */           .addComponent(this.jTextField94, -2, 111, -2)
/* 2544 */           .addGap(85, 85, 85)
/* 2545 */           .addComponent(this.jLabel211, -2, 72, -2)
/* 2546 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2547 */           .addComponent(this.jTextField95, -2, 220, -2)));
/*      */     
/* 2549 */     jPanel145Layout.setVerticalGroup(jPanel145Layout
/* 2550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2551 */         .addGroup(jPanel145Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2552 */           .addComponent(this.jLabel211, -1, -1, 32767)
/* 2553 */           .addComponent(this.jTextField94, -2, 25, -2)
/* 2554 */           .addComponent(this.jLabel212, -1, -1, 32767))
/* 2555 */         .addGroup(jPanel145Layout.createSequentialGroup()
/* 2556 */           .addComponent(this.jTextField95, -2, 25, -2)
/* 2557 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 2560 */     this.jLabel207.setFont(new Font("Cantarell", 0, 11));
/* 2561 */     this.jLabel207.setForeground(this.lc.PRIMARIO1);
/* 2562 */     this.jLabel207.setText("jLabel207");
/*      */     
/* 2564 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2572 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2577 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2580 */     this.rSTableMetro6.setAltoHead(25);
/* 2581 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2582 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 2583 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 2584 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2585 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/* 2586 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/* 2587 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/* 2588 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 11));
/* 2589 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 2590 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2591 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2592 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 2593 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 2594 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 2595 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 2596 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2598 */             Datos.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 2601 */     this.jScrollPane22.setViewportView((Component)this.rSTableMetro6);
/*      */     
/* 2603 */     GroupLayout jPanel144Layout = new GroupLayout(this.jPanel144);
/* 2604 */     this.jPanel144.setLayout(jPanel144Layout);
/* 2605 */     jPanel144Layout.setHorizontalGroup(jPanel144Layout
/* 2606 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2607 */         .addComponent(this.jPanel145, -1, -1, 32767)
/* 2608 */         .addGroup(jPanel144Layout.createSequentialGroup()
/* 2609 */           .addComponent(this.jLabel207, -2, 244, -2)
/* 2610 */           .addGap(0, 0, 32767))
/* 2611 */         .addComponent(this.jScrollPane22));
/*      */     
/* 2613 */     jPanel144Layout.setVerticalGroup(jPanel144Layout
/* 2614 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2615 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel144Layout.createSequentialGroup()
/* 2616 */           .addComponent(this.jPanel145, -2, -1, -2)
/* 2617 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2618 */           .addComponent(this.jScrollPane22, -1, 237, 32767)
/* 2619 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2620 */           .addComponent(this.jLabel207)));
/*      */ 
/*      */     
/* 2623 */     GroupLayout jDialog20Layout = new GroupLayout(this.jDialog20.getContentPane());
/* 2624 */     this.jDialog20.getContentPane().setLayout(jDialog20Layout);
/* 2625 */     jDialog20Layout.setHorizontalGroup(jDialog20Layout
/* 2626 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2627 */         .addGap(0, 640, 32767)
/* 2628 */         .addGroup(jDialog20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2629 */           .addGroup(jDialog20Layout.createSequentialGroup()
/* 2630 */             .addComponent(this.jPanel144, -1, -1, 32767)
/* 2631 */             .addGap(0, 0, 0))));
/*      */     
/* 2633 */     jDialog20Layout.setVerticalGroup(jDialog20Layout
/* 2634 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2635 */         .addGap(0, 290, 32767)
/* 2636 */         .addGroup(jDialog20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2637 */           .addGroup(jDialog20Layout.createSequentialGroup()
/* 2638 */             .addComponent(this.jPanel144, -1, -1, 32767)
/* 2639 */             .addGap(0, 0, 0))));
/*      */ 
/*      */     
/* 2642 */     this.jDialog21.setTitle("Catálogo de unidades");
/*      */     
/* 2644 */     this.jLabel208.setFont(new Font("Cantarell", 0, 11));
/* 2645 */     this.jLabel208.setText("Clave");
/*      */     
/* 2647 */     this.jTextField96.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2649 */             Datos.this.jTextField96ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2652 */     this.jTextField96.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2654 */             Datos.this.jTextField96KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2658 */     this.jLabel209.setFont(new Font("Cantarell", 0, 11));
/* 2659 */     this.jLabel209.setText("Descripción");
/*      */     
/* 2661 */     this.jTextField97.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2663 */             Datos.this.jTextField97ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2666 */     this.jTextField97.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2668 */             Datos.this.jTextField97KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2672 */     GroupLayout jPanel157Layout = new GroupLayout(this.jPanel157);
/* 2673 */     this.jPanel157.setLayout(jPanel157Layout);
/* 2674 */     jPanel157Layout.setHorizontalGroup(jPanel157Layout
/* 2675 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2676 */         .addGroup(jPanel157Layout.createSequentialGroup()
/* 2677 */           .addComponent(this.jLabel208, -2, 62, -2)
/* 2678 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2679 */           .addComponent(this.jTextField96, -2, 111, -2)
/* 2680 */           .addGap(66, 66, 66)
/* 2681 */           .addComponent(this.jLabel209, -2, 84, -2)
/* 2682 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2683 */           .addComponent(this.jTextField97, -1, 288, 32767)
/* 2684 */           .addGap(17, 17, 17)));
/*      */     
/* 2686 */     jPanel157Layout.setVerticalGroup(jPanel157Layout
/* 2687 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2688 */         .addGroup(jPanel157Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2689 */           .addComponent(this.jLabel208)
/* 2690 */           .addComponent(this.jTextField96, -2, 25, -2)
/* 2691 */           .addComponent(this.jLabel209)
/* 2692 */           .addComponent(this.jTextField97, -2, 25, -2)));
/*      */ 
/*      */     
/* 2695 */     this.jLabel210.setFont(new Font("Cantarell", 0, 11));
/* 2696 */     this.jLabel210.setForeground(this.lc.PRIMARIO1);
/* 2697 */     this.jLabel210.setText("jLabel210");
/*      */     
/* 2699 */     this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2707 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2712 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2715 */     this.rSTableMetro7.setAltoHead(25);
/* 2716 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2717 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/* 2718 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/* 2719 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2720 */     this.rSTableMetro7.setColorFilasForeground1(new Color(102, 102, 102));
/* 2721 */     this.rSTableMetro7.setColorFilasForeground2(new Color(102, 102, 102));
/* 2722 */     this.rSTableMetro7.setColorSelBackgound(new Color(237, 107, 107));
/* 2723 */     this.rSTableMetro7.setFont(new Font("Cantarell", 0, 11));
/* 2724 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 2725 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2726 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2727 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/* 2728 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/* 2729 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/* 2730 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 2731 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2733 */             Datos.this.rSTableMetro7MouseClicked(evt);
/*      */           }
/*      */         });
/* 2736 */     this.jScrollPane23.setViewportView((Component)this.rSTableMetro7);
/*      */     
/* 2738 */     GroupLayout jPanel156Layout = new GroupLayout(this.jPanel156);
/* 2739 */     this.jPanel156.setLayout(jPanel156Layout);
/* 2740 */     jPanel156Layout.setHorizontalGroup(jPanel156Layout
/* 2741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2742 */         .addComponent(this.jPanel157, -1, -1, 32767)
/* 2743 */         .addGroup(jPanel156Layout.createSequentialGroup()
/* 2744 */           .addComponent(this.jLabel210, -2, 244, -2)
/* 2745 */           .addGap(0, 0, 32767))
/* 2746 */         .addComponent(this.jScrollPane23));
/*      */     
/* 2748 */     jPanel156Layout.setVerticalGroup(jPanel156Layout
/* 2749 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2750 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel156Layout.createSequentialGroup()
/* 2751 */           .addComponent(this.jPanel157, -2, -1, -2)
/* 2752 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2753 */           .addComponent(this.jScrollPane23, -1, 237, 32767)
/* 2754 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2755 */           .addComponent(this.jLabel210)));
/*      */ 
/*      */     
/* 2758 */     GroupLayout jDialog21Layout = new GroupLayout(this.jDialog21.getContentPane());
/* 2759 */     this.jDialog21.getContentPane().setLayout(jDialog21Layout);
/* 2760 */     jDialog21Layout.setHorizontalGroup(jDialog21Layout
/* 2761 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2762 */         .addGap(0, 640, 32767)
/* 2763 */         .addGroup(jDialog21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2764 */           .addGroup(jDialog21Layout.createSequentialGroup()
/* 2765 */             .addComponent(this.jPanel156, -1, -1, 32767)
/* 2766 */             .addGap(0, 0, 0))));
/*      */     
/* 2768 */     jDialog21Layout.setVerticalGroup(jDialog21Layout
/* 2769 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2770 */         .addGap(0, 290, 32767)
/* 2771 */         .addGroup(jDialog21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2772 */           .addGroup(jDialog21Layout.createSequentialGroup()
/* 2773 */             .addComponent(this.jPanel156, -1, -1, 32767)
/* 2774 */             .addGap(0, 0, 0))));
/*      */ 
/*      */     
/* 2777 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2785 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2790 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2793 */     this.rSTableMetro2.setAltoHead(40);
/* 2794 */     this.rSTableMetro2.setColorBackgoundHead(new Color(246, 60, 60));
/* 2795 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 2796 */     this.rSTableMetro2.setColorBordeHead(new Color(246, 60, 60));
/* 2797 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2798 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 2799 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 2800 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 2801 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 11));
/* 2802 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 2803 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2804 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2805 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 2806 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 2807 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 2808 */     this.jScrollPane18.setViewportView((Component)this.rSTableMetro2);
/*      */     
/* 2810 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 2811 */     this.jPanel3.setLayout(jPanel3Layout);
/* 2812 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 2813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2814 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 2815 */           .addGap(236, 236, 236)
/* 2816 */           .addComponent(this.jScrollPane18, -2, 281, -2)
/* 2817 */           .addContainerGap(332, 32767)));
/*      */     
/* 2819 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 2820 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2821 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 2822 */           .addContainerGap()
/* 2823 */           .addComponent(this.jScrollPane18, -2, 133, -2)
/* 2824 */           .addContainerGap(346, 32767)));
/*      */ 
/*      */     
/* 2827 */     setBackground(this.lc.PRIMARIO1);
/*      */     
/* 2829 */     this.jPanel2.setBackground(this.lc.PRIMARIO1);
/*      */     
/* 2831 */     this.jPanel4.setBackground(this.lc.PRIMARIO1);
/* 2832 */     GridBagLayout jPanel4Layout = new GridBagLayout();
/* 2833 */     jPanel4Layout.columnWidths = new int[] { 0, 5, 0 };
/* 2834 */     jPanel4Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 2835 */     this.jPanel4.setLayout(jPanel4Layout);
/*      */     
/* 2837 */     this.jLabel65.setFont(new Font("Cantarell", 1, 11));
/* 2838 */     this.jLabel65.setForeground(new Color(255, 255, 255));
/* 2839 */     this.jLabel65.setText("Cliente");
/* 2840 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 2841 */     gridBagConstraints.gridx = 0;
/* 2842 */     gridBagConstraints.gridy = 0;
/* 2843 */     gridBagConstraints.anchor = 21;
/* 2844 */     this.jPanel4.add(this.jLabel65, gridBagConstraints);
/*      */     
/* 2846 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 2847 */     this.jComboBox9.setFont(new Font("Tahoma", 1, 11));
/* 2848 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2850 */             Datos.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2853 */     gridBagConstraints = new GridBagConstraints();
/* 2854 */     gridBagConstraints.gridx = 2;
/* 2855 */     gridBagConstraints.gridy = 0;
/* 2856 */     gridBagConstraints.fill = 2;
/* 2857 */     gridBagConstraints.weightx = 0.1D;
/* 2858 */     this.jPanel4.add(this.jComboBox9, gridBagConstraints);
/*      */     
/* 2860 */     this.jLabel108.setFont(new Font("Cantarell", 1, 11));
/* 2861 */     this.jLabel108.setForeground(new Color(255, 255, 255));
/* 2862 */     this.jLabel108.setText("Línea");
/* 2863 */     this.jLabel108.setEnabled(false);
/* 2864 */     gridBagConstraints = new GridBagConstraints();
/* 2865 */     gridBagConstraints.gridx = 0;
/* 2866 */     gridBagConstraints.gridy = 2;
/* 2867 */     gridBagConstraints.anchor = 21;
/* 2868 */     this.jPanel4.add(this.jLabel108, gridBagConstraints);
/*      */     
/* 2870 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/* 2871 */     this.jComboBox17.setEnabled(false);
/* 2872 */     this.jComboBox17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2874 */             Datos.this.jComboBox17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2877 */     gridBagConstraints = new GridBagConstraints();
/* 2878 */     gridBagConstraints.gridx = 2;
/* 2879 */     gridBagConstraints.gridy = 2;
/* 2880 */     gridBagConstraints.fill = 2;
/* 2881 */     gridBagConstraints.weightx = 0.1D;
/* 2882 */     this.jPanel4.add(this.jComboBox17, gridBagConstraints);
/*      */     
/* 2884 */     this.jLabel2.setFont(new Font("Cantarell", 1, 11));
/* 2885 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 2886 */     this.jLabel2.setText("Equipo");
/* 2887 */     this.jLabel2.setEnabled(false);
/* 2888 */     gridBagConstraints = new GridBagConstraints();
/* 2889 */     gridBagConstraints.gridx = 0;
/* 2890 */     gridBagConstraints.gridy = 4;
/* 2891 */     gridBagConstraints.anchor = 21;
/* 2892 */     this.jPanel4.add(this.jLabel2, gridBagConstraints);
/*      */     
/* 2894 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2895 */     this.jComboBox1.setEnabled(false);
/* 2896 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2898 */             Datos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2901 */     gridBagConstraints = new GridBagConstraints();
/* 2902 */     gridBagConstraints.gridx = 2;
/* 2903 */     gridBagConstraints.gridy = 4;
/* 2904 */     gridBagConstraints.fill = 2;
/* 2905 */     this.jPanel4.add(this.jComboBox1, gridBagConstraints);
/*      */     
/* 2907 */     this.jLabel3.setFont(new Font("Cantarell", 1, 11));
/* 2908 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 2909 */     this.jLabel3.setText("Plataforma");
/* 2910 */     this.jLabel3.setEnabled(false);
/* 2911 */     gridBagConstraints = new GridBagConstraints();
/* 2912 */     gridBagConstraints.gridx = 0;
/* 2913 */     gridBagConstraints.gridy = 6;
/* 2914 */     gridBagConstraints.anchor = 21;
/* 2915 */     this.jPanel4.add(this.jLabel3, gridBagConstraints);
/*      */     
/* 2917 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2918 */     this.jComboBox2.setEnabled(false);
/* 2919 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2921 */             Datos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2924 */     gridBagConstraints = new GridBagConstraints();
/* 2925 */     gridBagConstraints.gridx = 2;
/* 2926 */     gridBagConstraints.gridy = 6;
/* 2927 */     gridBagConstraints.fill = 2;
/* 2928 */     this.jPanel4.add(this.jComboBox2, gridBagConstraints);
/*      */     
/* 2930 */     this.jLabel5.setFont(new Font("Cantarell", 1, 11));
/* 2931 */     this.jLabel5.setForeground(new Color(255, 255, 255));
/* 2932 */     this.jLabel5.setText("Pozo");
/* 2933 */     this.jLabel5.setEnabled(false);
/* 2934 */     gridBagConstraints = new GridBagConstraints();
/* 2935 */     gridBagConstraints.gridx = 0;
/* 2936 */     gridBagConstraints.gridy = 8;
/* 2937 */     gridBagConstraints.anchor = 21;
/* 2938 */     this.jPanel4.add(this.jLabel5, gridBagConstraints);
/*      */     
/* 2940 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2941 */     this.jComboBox3.setEnabled(false);
/* 2942 */     gridBagConstraints = new GridBagConstraints();
/* 2943 */     gridBagConstraints.gridx = 2;
/* 2944 */     gridBagConstraints.gridy = 8;
/* 2945 */     gridBagConstraints.fill = 2;
/* 2946 */     this.jPanel4.add(this.jComboBox3, gridBagConstraints);
/*      */     
/* 2948 */     this.jLabel6.setFont(new Font("Cantarell", 1, 11));
/* 2949 */     this.jLabel6.setForeground(new Color(255, 255, 255));
/* 2950 */     this.jLabel6.setText("Tipo de Residuo");
/* 2951 */     this.jLabel6.setEnabled(false);
/* 2952 */     gridBagConstraints = new GridBagConstraints();
/* 2953 */     gridBagConstraints.gridx = 0;
/* 2954 */     gridBagConstraints.gridy = 10;
/* 2955 */     gridBagConstraints.anchor = 21;
/* 2956 */     this.jPanel4.add(this.jLabel6, gridBagConstraints);
/*      */     
/* 2958 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 2959 */     this.jComboBox4.setFont(new Font("Tahoma", 1, 13));
/* 2960 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Recorte Base Aceite", "Recorte Base Agua", "Lodo Base Agua" }));
/* 2961 */     this.jComboBox4.setEnabled(false);
/* 2962 */     gridBagConstraints = new GridBagConstraints();
/* 2963 */     gridBagConstraints.gridx = 2;
/* 2964 */     gridBagConstraints.gridy = 10;
/* 2965 */     gridBagConstraints.fill = 2;
/* 2966 */     this.jPanel4.add(this.jComboBox4, gridBagConstraints);
/*      */     
/* 2968 */     this.jLabel7.setFont(new Font("Cantarell", 1, 11));
/* 2969 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 2970 */     this.jLabel7.setText("Fecha y hora");
/* 2971 */     this.jLabel7.setEnabled(false);
/* 2972 */     gridBagConstraints = new GridBagConstraints();
/* 2973 */     gridBagConstraints.gridx = 0;
/* 2974 */     gridBagConstraints.gridy = 12;
/* 2975 */     gridBagConstraints.anchor = 21;
/* 2976 */     this.jPanel4.add(this.jLabel7, gridBagConstraints);
/*      */     
/* 2978 */     this.jPanel47.setBackground(this.lc.PRIMARIO1);
/* 2979 */     this.jPanel47.setLayout(new BoxLayout(this.jPanel47, 2));
/*      */     
/* 2981 */     this.jDateChooser2.setDate(this.fechaActual);
/* 2982 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/* 2983 */     this.jDateChooser2.setEnabled(false);
/* 2984 */     this.jDateChooser2.setIcon(this.icon);
/* 2985 */     this.jDateChooser2.setMaxSelectableDate(this.fechaMax);
/* 2986 */     this.jDateChooser2.setMinSelectableDate(this.fechaActual);
/* 2987 */     this.jPanel47.add((Component)this.jDateChooser2);
/* 2988 */     this.jPanel47.add(this.jTextField3);
/*      */     
/* 2990 */     gridBagConstraints = new GridBagConstraints();
/* 2991 */     gridBagConstraints.gridx = 2;
/* 2992 */     gridBagConstraints.gridy = 12;
/* 2993 */     gridBagConstraints.fill = 2;
/* 2994 */     this.jPanel4.add(this.jPanel47, gridBagConstraints);
/*      */     
/* 2996 */     this.jLabel8.setFont(new Font("Cantarell", 1, 11));
/* 2997 */     this.jLabel8.setForeground(new Color(255, 255, 255));
/* 2998 */     this.jLabel8.setText("Núm. de Pedidos");
/* 2999 */     this.jLabel8.setEnabled(false);
/* 3000 */     gridBagConstraints = new GridBagConstraints();
/* 3001 */     gridBagConstraints.gridx = 0;
/* 3002 */     gridBagConstraints.gridy = 14;
/* 3003 */     gridBagConstraints.anchor = 21;
/* 3004 */     this.jPanel4.add(this.jLabel8, gridBagConstraints);
/*      */     
/* 3006 */     this.jSpinner1.setModel(new SpinnerNumberModel(1, 1, 9, 1));
/* 3007 */     gridBagConstraints = new GridBagConstraints();
/* 3008 */     gridBagConstraints.gridx = 2;
/* 3009 */     gridBagConstraints.gridy = 14;
/* 3010 */     gridBagConstraints.fill = 2;
/* 3011 */     this.jPanel4.add(this.jSpinner1, gridBagConstraints);
/*      */     
/* 3013 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/* 3014 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 3015 */     this.jLabel9.setText("Asignar prioridad ");
/* 3016 */     this.jLabel9.setEnabled(false);
/* 3017 */     gridBagConstraints = new GridBagConstraints();
/* 3018 */     gridBagConstraints.gridx = 0;
/* 3019 */     gridBagConstraints.gridy = 16;
/* 3020 */     gridBagConstraints.anchor = 21;
/* 3021 */     this.jPanel4.add(this.jLabel9, gridBagConstraints);
/*      */     
/* 3023 */     this.jPanel44.setBackground(this.lc.PRIMARIO1);
/* 3024 */     this.jPanel44.setLayout(new GridLayout(1, 2));
/*      */     
/* 3026 */     this.jSlider1.setMaximum(10);
/* 3027 */     this.jSlider1.setValue(5);
/* 3028 */     this.jSlider1.setEnabled(false);
/* 3029 */     this.jSlider1.addChangeListener(new ChangeListener() {
/*      */           public void stateChanged(ChangeEvent evt) {
/* 3031 */             Datos.this.jSlider1StateChanged(evt);
/*      */           }
/*      */         });
/* 3034 */     this.jPanel44.add(this.jSlider1);
/*      */     
/* 3036 */     this.jLabel10.setFont(new Font("Tahoma", 1, 11));
/* 3037 */     this.jLabel10.setForeground(new Color(15, 87, 51));
/* 3038 */     this.jLabel10.setHorizontalAlignment(0);
/* 3039 */     this.jLabel10.setText("5");
/* 3040 */     this.jLabel10.setEnabled(false);
/* 3041 */     this.jPanel44.add(this.jLabel10);
/*      */     
/* 3043 */     gridBagConstraints = new GridBagConstraints();
/* 3044 */     gridBagConstraints.gridx = 2;
/* 3045 */     gridBagConstraints.gridy = 16;
/* 3046 */     gridBagConstraints.fill = 2;
/* 3047 */     this.jPanel4.add(this.jPanel44, gridBagConstraints);
/*      */     
/* 3049 */     this.jLabel1.setBackground(new Color(102, 102, 102));
/* 3050 */     this.jLabel1.setFont(new Font("Cantarell", 1, 13));
/* 3051 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 3052 */     this.jLabel1.setText(" Recopilación de datos");
/*      */     
/* 3054 */     this.jLabel4.setFont(new Font("Cantarell", 0, 11));
/* 3055 */     this.jLabel4.setForeground(this.lc.SECUNDARIO1);
/* 3056 */     this.jLabel4.setText("<html>Aquí puedes agregar todos los datos referente al pedido de tipo de residuo.</html>");
/*      */     
/* 3058 */     this.materialButton3.setBackground(this.lc.SECUNDARIO1);
/* 3059 */     this.materialButton3.setForeground(new Color(255, 255, 255));
/* 3060 */     this.materialButton3.setMnemonic('L');
/* 3061 */     this.materialButton3.setText("Limpiar");
/* 3062 */     this.materialButton3.setToolTipText("Limpiar (Alt+L)");
/* 3063 */     this.materialButton3.setFont(new Font("Cantarell", 0, 12));
/* 3064 */     this.materialButton3.setHorizontalTextPosition(0);
/* 3065 */     this.materialButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3067 */             Datos.this.materialButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3071 */     this.materialButton9.setBackground(this.lc.PRIMARIO2);
/* 3072 */     this.materialButton9.setForeground(new Color(255, 255, 255));
/* 3073 */     this.materialButton9.setMnemonic('G');
/* 3074 */     this.materialButton9.setText("Guardar");
/* 3075 */     this.materialButton9.setToolTipText("Guardar (Alt+G)");
/* 3076 */     this.materialButton9.setFont(new Font("Cantarell", 0, 12));
/* 3077 */     this.materialButton9.setHorizontalTextPosition(0);
/* 3078 */     this.materialButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3080 */             Datos.this.materialButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3084 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 3085 */     this.jPanel2.setLayout(jPanel2Layout);
/* 3086 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 3087 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3088 */         .addComponent(this.jPanel4, -2, 312, -2)
/* 3089 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 3090 */           .addContainerGap()
/* 3091 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3092 */             .addComponent(this.jLabel4, -2, 0, 32767)
/* 3093 */             .addComponent(this.jLabel1, -1, -1, 32767)
/* 3094 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 3095 */               .addGap(0, 0, 32767)
/* 3096 */               .addComponent((Component)this.materialButton9, -2, 150, -2)
/* 3097 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3098 */               .addComponent((Component)this.materialButton3, -2, 110, -2)))
/* 3099 */           .addContainerGap()));
/*      */     
/* 3101 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 3102 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3103 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 3104 */           .addGap(12, 12, 12)
/* 3105 */           .addComponent(this.jLabel1)
/* 3106 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3107 */           .addComponent(this.jLabel4, -2, -1, -2)
/* 3108 */           .addGap(18, 18, 18)
/* 3109 */           .addComponent(this.jPanel4, -2, 313, -2)
/* 3110 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3111 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3112 */             .addComponent((Component)this.materialButton3, -2, 38, -2)
/* 3113 */             .addComponent((Component)this.materialButton9, -2, 38, -2))
/* 3114 */           .addContainerGap(42, 32767)));
/*      */ 
/*      */     
/* 3117 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3119 */     this.jLabel16.setFont(new Font("Cantarell", 1, 13));
/* 3120 */     this.jLabel16.setForeground(this.lc.SECUNDARIO1);
/* 3121 */     this.jLabel16.setText("Listado de Pedidos");
/*      */     
/* 3123 */     this.jLabel15.setFont(new Font("Cantarell", 0, 11));
/* 3124 */     this.jLabel15.setForeground(this.lc.PRIMARIO1);
/* 3125 */     this.jLabel15.setText("<html>A continuación se puede observar el listado de todas las llamadas. Recuerda que los primeros registros tienen mayor prioridad</html>");
/*      */     
/* 3127 */     this.jLabel75.setFont(new Font("Cantarell", 0, 11));
/* 3128 */     this.jLabel75.setText("Tipo de Guía");
/*      */     
/* 3130 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 3131 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "PIPAS", "GONDOLAS" }));
/* 3132 */     this.jComboBox5.setEnabled(false);
/* 3133 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3135 */             Datos.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3139 */     this.materialButton4.setBackground(this.lc.SECUNDARIO1);
/* 3140 */     this.materialButton4.setForeground(new Color(255, 255, 255));
/* 3141 */     this.materialButton4.setMnemonic('R');
/* 3142 */     this.materialButton4.setText("Cancelar");
/* 3143 */     this.materialButton4.setToolTipText("Cancelar (Alt+R)");
/* 3144 */     this.materialButton4.setFont(new Font("Cantarell", 0, 12));
/* 3145 */     this.materialButton4.setHorizontalTextPosition(0);
/* 3146 */     this.materialButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3148 */             Datos.this.materialButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3152 */     this.materialButton10.setBackground(this.lc.PRIMARIO1);
/* 3153 */     this.materialButton10.setForeground(new Color(255, 255, 255));
/* 3154 */     this.materialButton10.setMnemonic('A');
/* 3155 */     this.materialButton10.setText("Asignar");
/* 3156 */     this.materialButton10.setToolTipText("Asignar Viaje (Alt+A)");
/* 3157 */     this.materialButton10.setEnabled(false);
/* 3158 */     this.materialButton10.setFont(new Font("Cantarell", 0, 12));
/* 3159 */     this.materialButton10.setHorizontalTextPosition(0);
/* 3160 */     this.materialButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3162 */             Datos.this.materialButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3166 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3174 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3179 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3182 */     this.rSTableMetro1.setAltoHead(40);
/* 3183 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3184 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 3185 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 3186 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3187 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 3188 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 3189 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 3190 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 11));
/* 3191 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 9));
/* 3192 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3193 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3194 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 3195 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 3196 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 3197 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3198 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3200 */             Datos.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 3203 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3205 */             Datos.this.rSTableMetro1KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3208 */             Datos.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 3211 */     this.jScrollPane17.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 3213 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 3214 */     this.jPanel14.setLayout(jPanel14Layout);
/* 3215 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 3216 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3217 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 3218 */           .addContainerGap()
/* 3219 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3220 */             .addComponent(this.jLabel15, -1, 626, 32767)
/* 3221 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 3222 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3223 */                 .addComponent(this.jScrollPane17)
/* 3224 */                 .addGroup(jPanel14Layout.createSequentialGroup()
/* 3225 */                   .addComponent(this.jLabel16, -2, 231, -2)
/* 3226 */                   .addGap(0, 389, 32767))
/* 3227 */                 .addGroup(jPanel14Layout.createSequentialGroup()
/* 3228 */                   .addComponent(this.jLabel75, -2, 85, -2)
/* 3229 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3230 */                   .addComponent(this.jComboBox5, -2, 124, -2)
/* 3231 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3232 */                   .addComponent((Component)this.materialButton10, -2, 150, -2)
/* 3233 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3234 */                   .addComponent((Component)this.materialButton4, -2, 110, -2)))
/* 3235 */               .addContainerGap()))));
/*      */     
/* 3237 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 3238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3239 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 3240 */           .addGap(15, 15, 15)
/* 3241 */           .addComponent(this.jLabel16)
/* 3242 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3243 */           .addComponent(this.jLabel15, -2, -1, -2)
/* 3244 */           .addGap(45, 45, 45)
/* 3245 */           .addComponent(this.jScrollPane17, -2, 307, -2)
/* 3246 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3247 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3248 */             .addComponent(this.jLabel75)
/* 3249 */             .addComponent(this.jComboBox5, -2, -1, -2)
/* 3250 */             .addComponent((Component)this.materialButton4, -2, 38, -2)
/* 3251 */             .addComponent((Component)this.materialButton10, -2, 38, -2))
/* 3252 */           .addContainerGap(40, 32767)));
/*      */ 
/*      */     
/* 3255 */     GroupLayout layout = new GroupLayout(this);
/* 3256 */     setLayout(layout);
/* 3257 */     layout.setHorizontalGroup(layout
/* 3258 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3259 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 3260 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 3261 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3262 */           .addComponent(this.jPanel14, -1, -1, 32767)));
/*      */     
/* 3264 */     layout.setVerticalGroup(layout
/* 3265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3266 */         .addComponent(this.jPanel14, -1, -1, 32767)
/* 3267 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jSlider1StateChanged(ChangeEvent evt) {
/* 3272 */     this.jLabel10.setText("" + this.jSlider1.getValue());
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3276 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3277 */       this.jComboBox2.removeAllItems();
/* 3278 */       this.jComboBox2.setEnabled(false);
/* 3279 */       this.jComboBox3.removeAllItems();
/* 3280 */       this.jComboBox3.setEnabled(false);
/* 3281 */       limpiar();
/*      */     } else {
/* 3283 */       this.jComboBox2.removeAllItems();
/* 3284 */       llenarCombo2();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 3292 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 3293 */       this.TABLA = "llamadas_pipas";
/*      */     } else {
/* 3295 */       this.TABLA = "llamadas_gondolas";
/*      */     } 
/* 3297 */     if (this.jComboBox5.getItemCount() > 0 && this.PRIMERA == true) {
/* 3298 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 3303 */     if (this.jComboBox6.getSelectedIndex() > 0) {
/* 3304 */       int indice = this.jComboBox6.getSelectedIndex();
/* 3305 */       indice--;
/* 3306 */       this.jLabel34.setText(this.ciudadesGene[indice]);
/* 3307 */       this.jLabel35.setText(this.domicilioGene[indice] + " " + this.domicilioGene[indice]);
/* 3308 */       this.jLabel36.setText(this.coloniaGene[indice]);
/* 3309 */       this.jLabel37.setText(this.rfcGene[indice]);
/*      */     } else {
/* 3311 */       limpiar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel55MouseClicked(MouseEvent evt) {
/* 3316 */     if (this.PRIVILEGIO.equals("SUPER USUARIO") || this.USUARIO.equals("JESUS02")) {
/* 3317 */       consultar2();
/* 3318 */       this.jDialog2.setVisible(true);
/*      */     } else {
/* 3320 */       int selec = this.jComboBox8.getSelectedIndex();
/* 3321 */       if (selec == 3 || selec == 4) {
/* 3322 */         consultar2();
/* 3323 */         this.jDialog2.setVisible(true);
/*      */       } else {
/* 3325 */         this.jPasswordField1.setText("");
/* 3326 */         this.jTextField1.setText("");
/* 3327 */         this.VENTANA1 = false;
/* 3328 */         this.jDialog9.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel55MouseEntered(MouseEvent evt) {
/* 3334 */     this.jLabel55.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel55MouseExited(MouseEvent evt) {
/* 3338 */     this.jLabel55.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 3342 */     if (this.jComboBox7.getSelectedIndex() > 0) {
/* 3343 */       this.jLabel33.setText(this.POZO);
/* 3344 */       if (this.jLabel59.getText().equals("")) {
/* 3345 */         sacarToneladas();
/*      */       }
/* 3347 */       int indice = this.jComboBox7.getSelectedIndex();
/* 3348 */       indice--;
/* 3349 */       this.jLabel38.setText(this.ciudadesDesti[indice]);
/* 3350 */       this.jLabel39.setText(this.domicilioDesti[indice] + " " + this.domicilioDesti[indice]);
/* 3351 */       this.jLabel40.setText(this.coloniaDesti[indice]);
/* 3352 */       this.jLabel41.setText(this.rfcDesti[indice]);
/* 3353 */       this.jLabel50.setText(this.montoDesti[indice] + ".00");
/* 3354 */       this.jLabel61.setText(this.letraDesti[indice]);
/*      */       
/* 3356 */       float total = Float.parseFloat(this.montoDesti[indice]);
/* 3357 */       double subtotal = total / 1.16D;
/* 3358 */       double iva = total - subtotal;
/*      */       
/* 3360 */       this.jLabel54.setText(this.montoDesti[indice] + ".00");
/*      */       
/* 3362 */       String cant = "" + subtotal;
/* 3363 */       String SUB = "";
/* 3364 */       boolean punto = false; int i;
/* 3365 */       for (i = 0; i < cant.length() && 
/* 3366 */         cant.charAt(i) != '.'; i++) {
/* 3367 */         punto = true;
/* 3368 */         SUB = SUB + SUB;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 3373 */       this.jLabel50.setText(SUB + ".00");
/* 3374 */       cant = "" + iva;
/* 3375 */       SUB = "";
/* 3376 */       punto = false;
/* 3377 */       for (i = 0; i < cant.length() && 
/* 3378 */         cant.charAt(i) != '.'; i++) {
/* 3379 */         punto = true;
/* 3380 */         SUB = SUB + SUB;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 3385 */       this.jLabel51.setText(SUB + ".00");
/*      */     } else {
/* 3387 */       limpiar3();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {
/* 3392 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField13KeyReleased(KeyEvent evt) {
/* 3396 */     consultar2();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField14KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField14ActionPerformed(ActionEvent evt) {
/* 3404 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jLabel66MouseClicked(MouseEvent evt) {
/* 3408 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel66MouseEntered(MouseEvent evt) {
/* 3412 */     this.jLabel66.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel66MouseExited(MouseEvent evt) {
/* 3416 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel67MouseClicked(MouseEvent evt) {
/* 3420 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel67MouseEntered(MouseEvent evt) {
/* 3424 */     this.jLabel67.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel67MouseExited(MouseEvent evt) {
/* 3428 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jTextField15KeyReleased(KeyEvent evt) {
/* 3432 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {
/* 3436 */     consultar4();
/*      */   }
/*      */   
/*      */   private void jTextField18KeyReleased(KeyEvent evt) {
/* 3440 */     consultar4();
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 3444 */     int indice = this.jComboBox9.getSelectedIndex();
/* 3445 */     if (indice > 0) {
/* 3446 */       this.con.consultar("clave_gene", "emp_generadora", "where empresa ='" + String.valueOf(this.jComboBox9.getSelectedItem()) + "'");
/* 3447 */       this.jComboBox1.setEnabled(true);
/* 3448 */       this.jLabel2.setEnabled(true);
/* 3449 */       llenarCombo(this.con.Campo);
/*      */     }
/* 3451 */     else if (this.jComboBox1.getSelectedIndex() > 0) {
/* 3452 */       this.jComboBox1.setSelectedIndex(0);
/* 3453 */       this.jComboBox1.setEnabled(false);
/* 3454 */       this.jLabel2.setEnabled(false);
/* 3455 */       this.jComboBox1.removeAllItems();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField20ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField20KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3468 */     cancelar();
/*      */   }
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 3471 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel91MouseClicked(MouseEvent evt) {
/* 3475 */     if (this.PRIVILEGIO.equals("SUPER USUARIO") || this.USUARIO.equals("JESUS02")) {
/* 3476 */       String num = JOptionPane.showInputDialog(this.jDialog1, "Inserta el nombre del operador que no se encuentra\nen la base de datos", "Inserta el Nombre", 1);
/* 3477 */       if (num == null || num.equals("")) {
/* 3478 */         JOptionPane.showMessageDialog(this.jDialog1, "Debes insertar el nombre del operador", "Campo Vacío", 0, this.ERROR);
/*      */       } else {
/* 3480 */         this.CLAVEOP = "0";
/* 3481 */         this.jLabel44.setText(num.toUpperCase());
/* 3482 */         this.con.inserSinMsj("update formacion set activo=1 where num= " + this.NUMFORMA);
/* 3483 */         this.NUMFORMA = "0";
/*      */       } 
/*      */     } else {
/* 3486 */       this.VENTANA1 = true;
/* 3487 */       this.jPasswordField1.setText("");
/* 3488 */       this.jTextField1.setText("");
/* 3489 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel91MouseEntered(MouseEvent evt) {
/* 3494 */     this.jLabel91.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel91MouseExited(MouseEvent evt) {
/* 3498 */     this.jLabel91.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox16ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel95MouseClicked(MouseEvent evt) {
/* 3506 */     this.jComboBox16.setSelectedItem(this.jLabel95.getText());
/* 3507 */     JOptionPane.showMessageDialog(this.jDialog1, this.jPanel19, "Remolque", 0, this.INFO);
/* 3508 */     String eti = String.valueOf(this.jComboBox16.getSelectedItem());
/* 3509 */     this.jLabel95.setText(eti.toUpperCase());
/* 3510 */     this.jTextField19.setText(eti.toUpperCase());
/* 3511 */     consultar4();
/*      */   }
/*      */   
/*      */   private void jLabel95MouseEntered(MouseEvent evt) {
/* 3515 */     this.jLabel95.setBackground(Color.YELLOW);
/*      */   }
/*      */   
/*      */   private void jLabel95MouseExited(MouseEvent evt) {
/* 3519 */     this.jLabel95.setBackground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jLabel102MouseClicked(MouseEvent evt) {
/* 3523 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel102MouseEntered(MouseEvent evt) {
/* 3527 */     this.jLabel102.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel102MouseExited(MouseEvent evt) {
/* 3531 */     this.jLabel102.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jDialog1WindowClosing(WindowEvent evt) {
/* 3535 */     this.con.inserSinMsj("update " + this.TABLA + " set uso = 0");
/* 3536 */     consultar();
/* 3537 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 3541 */     entrada();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField1FocusGained(FocusEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField1FocusLost(FocusEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jPasswordField1ActionPerformed(ActionEvent evt) {
/* 3564 */     entrada();
/*      */   }
/*      */   
/*      */   private void jPasswordField1FocusGained(FocusEvent evt) {
/* 3568 */     if (this.jPasswordField1.getText().equals("Contraseña")) {
/* 3569 */       this.jPasswordField1.setText("");
/* 3570 */       this.jPasswordField1.setFont(new Font("Tahoma", 1, 12));
/* 3571 */       this.jPasswordField1.setForeground(Color.BLACK);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 3576 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 3580 */     entrada();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 3585 */     int selec = this.jComboBox8.getSelectedIndex();
/* 3586 */     if (this.PRIVILEGIO.equals("SUPER USUARIO") || this.USUARIO.equals("JESUS02")) {
/* 3587 */       this.jLabel91.setVisible(true);
/* 3588 */       this.jLabel55.setVisible(true);
/*      */     }
/* 3590 */     else if (selec == 2 || selec == 3 || selec == 4) {
/* 3591 */       this.jLabel91.setVisible(true);
/* 3592 */       this.jLabel55.setVisible(true);
/*      */     } else {
/* 3594 */       this.jLabel91.setVisible(false);
/* 3595 */       this.jLabel55.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 3605 */     this.jLabel207.setVisible(false);
/*      */ 
/*      */ 
/*      */     
/* 3609 */     this.jDialog20.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 3613 */     this.jLabel210.setVisible(false);
/*      */ 
/*      */ 
/*      */     
/* 3617 */     this.jDialog21.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField94ActionPerformed(ActionEvent evt) {
/* 3621 */     llenarCatServicios();
/*      */   }
/*      */   
/*      */   private void jTextField94KeyReleased(KeyEvent evt) {
/* 3625 */     String cadena = this.jTextField94.getText();
/* 3626 */     if (!cadena.equals("")) {
/* 3627 */       if (this.presionadoServ == null) {
/* 3628 */         this.presionadoServ = new PresionadoServicios();
/* 3629 */         this.presionadoServ.start();
/*      */       } else {
/* 3631 */         this.presionadoServ.detenerFuera();
/* 3632 */         this.presionadoServ = new PresionadoServicios();
/* 3633 */         this.presionadoServ.start();
/*      */       } 
/*      */     } else {
/* 3636 */       this.jTextField94.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField95ActionPerformed(ActionEvent evt) {
/* 3641 */     llenarCatServicios();
/*      */   }
/*      */   
/*      */   private void jTextField95KeyReleased(KeyEvent evt) {
/* 3645 */     String cadena = this.jTextField95.getText();
/* 3646 */     if (!cadena.equals("")) {
/* 3647 */       if (this.presionadoServ == null) {
/* 3648 */         this.presionadoServ = new PresionadoServicios();
/* 3649 */         this.presionadoServ.start();
/*      */       } else {
/* 3651 */         this.presionadoServ.detenerFuera();
/* 3652 */         this.presionadoServ = new PresionadoServicios();
/* 3653 */         this.presionadoServ.start();
/*      */       } 
/*      */     } else {
/* 3656 */       this.jTextField95.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField96ActionPerformed(ActionEvent evt) {
/* 3661 */     llenarCatUnidades();
/*      */   }
/*      */   
/*      */   private void jTextField96KeyReleased(KeyEvent evt) {
/* 3665 */     String cadena = this.jTextField96.getText();
/* 3666 */     if (!cadena.equals("")) {
/* 3667 */       if (this.presionadoUni == null) {
/* 3668 */         this.presionadoUni = new PresionadoUnidades();
/* 3669 */         this.presionadoUni.start();
/*      */       } else {
/* 3671 */         this.presionadoUni.detenerFuera();
/* 3672 */         this.presionadoUni = new PresionadoUnidades();
/* 3673 */         this.presionadoUni.start();
/*      */       } 
/*      */     } else {
/* 3676 */       this.jTextField96.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField97ActionPerformed(ActionEvent evt) {
/* 3681 */     llenarCatUnidades();
/*      */   }
/*      */   
/*      */   private void jTextField97KeyReleased(KeyEvent evt) {
/* 3685 */     String cadena = this.jTextField97.getText();
/* 3686 */     if (!cadena.equals("")) {
/* 3687 */       if (this.presionadoUni == null) {
/* 3688 */         this.presionadoUni = new PresionadoUnidades();
/* 3689 */         this.presionadoUni.start();
/*      */       } else {
/* 3691 */         this.presionadoUni.detenerFuera();
/* 3692 */         this.presionadoUni = new PresionadoUnidades();
/* 3693 */         this.presionadoUni.start();
/*      */       } 
/*      */     } else {
/* 3696 */       this.jTextField97.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton3ActionPerformed(ActionEvent evt) {
/* 3701 */     limpiar();
/* 3702 */     if (this.jComboBox17.getItemCount() > 0) {
/* 3703 */       this.jComboBox17.setSelectedIndex(0);
/*      */     }
/* 3705 */     this.fechaActual = new Date();
/* 3706 */     this.jDateChooser2.setDate(this.fechaActual);
/*      */   }
/*      */   
/*      */   private void materialButton9ActionPerformed(ActionEvent evt) {
/* 3710 */     this.error.pasarModal(false);
/* 3711 */     this.val.pasarModal(Boolean.valueOf(false));
/* 3712 */     String[] campos = { "Cliente", "Equipo", "Plataforma", "Pozo", "Tipo de Residuo", "Fecha del Pedido", "Prioridad", "Autorizó", "Núm. Pedidos" };
/* 3713 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3714 */     String año = "";
/* 3715 */     String mes = "";
/* 3716 */     String dia = "";
/* 3717 */     String fechaCompleta = "";
/* 3718 */     String nomEquipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 3719 */     String nomPlata = String.valueOf(this.jComboBox2.getSelectedItem());
/* 3720 */     String nomPozo = String.valueOf(this.jComboBox3.getSelectedItem());
/* 3721 */     String linea = "";
/*      */     
/* 3723 */     int pedidos = Integer.parseInt(String.valueOf(this.jSpinner1.getValue()));
/* 3724 */     if (this.jDateChooser2.getDate() != null) {
/* 3725 */       String cadenaFecha2 = formato.format(this.jDateChooser2.getDate());
/* 3726 */       año = cadenaFecha2.substring(0, 4);
/* 3727 */       mes = cadenaFecha2.substring(4, 6);
/* 3728 */       dia = cadenaFecha2.substring(6, 8);
/* 3729 */       fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */     } 
/* 3731 */     if (this.jComboBox9.getSelectedIndex() == 0) {
/* 3732 */       this.error.cargarError(this.jComboBox9, "050");
/* 3733 */     } else if (this.jComboBox4.getSelectedIndex() == 0) {
/* 3734 */       this.error.cargarError(this.jComboBox4, "050");
/* 3735 */     } else if (this.jDateChooser2.getDate() == null) {
/* 3736 */       JOptionPane.showMessageDialog(this.padre, "No puede dejar vacía la fecha de pedido, verifica tu información", "Fecha Vacía", 0, this.ERROR);
/* 3737 */     } else if (this.jTextField3.getText().equals("")) {
/* 3738 */       this.error.cargarError(this.jTextField3, "050");
/* 3739 */     } else if (pedidos < 1) {
/* 3740 */       JOptionPane.showMessageDialog(this.padre, "No puedes insertar menos de un pedido en la recopilación de datos", "Mínimo 1 Pedido", 0, this.ERROR);
/* 3741 */     } else if (pedidos > 9) {
/* 3742 */       JOptionPane.showMessageDialog(this.padre, "No puedes insertar más de nueve pedidos en la recopilación de datos", "Máximo 9 Pedido", 0, this.ERROR);
/* 3743 */     } else if (!this.val.validarHora(this.jTextField3, this.jTextField3.getText())) {
/* 3744 */       if (this.jComboBox17.isEnabled()) {
/* 3745 */         linea = String.valueOf(this.jComboBox17.getSelectedItem());
/*      */       }
/* 3747 */       if (this.jComboBox17.getSelectedIndex() == 0) {
/* 3748 */         linea = "";
/*      */       }
/*      */       
/* 3751 */       this.con.consultar("num_equipo", "equipos", "where equipo ='" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 3752 */       String equipo = this.con.Campo;
/* 3753 */       this.con.consultar("num_plata", "plataformas", "where plataforma ='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "'");
/* 3754 */       String plataforma = this.con.Campo;
/* 3755 */       this.con.consultar("num_pozo", "pozos", "where nombre ='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "'");
/* 3756 */       String pozo = this.con.Campo;
/* 3757 */       String nombrePozo = "";
/*      */       
/* 3759 */       nombrePozo = String.valueOf(this.jComboBox3.getSelectedItem());
/* 3760 */       if (nombrePozo.equals("")) {
/* 3761 */         pozo = "0";
/*      */       }
/* 3763 */       String[] info = { String.valueOf(this.jComboBox9.getSelectedItem()), String.valueOf(this.jComboBox1.getSelectedItem()), String.valueOf(this.jComboBox2.getSelectedItem()), nombrePozo, String.valueOf(this.jComboBox4.getSelectedItem()) + String.valueOf(this.jComboBox4.getSelectedItem()), año + "-" + año + "-" + mes + " " + dia + ":00", "" + this.jSlider1.getValue(), this.USUARIO, "" + pedidos };
/* 3764 */       int res = this.error.cargarDatos(campos, info);
/* 3765 */       if (res == 0) {
/* 3766 */         int indice1 = this.jComboBox9.getSelectedIndex();
/* 3767 */         indice1--;
/* 3768 */         for (int i = 0; i < pedidos; i++) {
/* 3769 */           this.con.inserSinMsj("insert into " + this.TABLA + "(residuo,fecha_ped,ingreso,prioridad,num_equipo,num_plata,num_pozo,nombre_usu,uso,clave_gene, linea)values('" + info[4] + "','" + info[5] + "',now()," + info[6] + "," + equipo + "," + plataforma + "," + pozo + ",'" + this.USUARIO + "',0," + this.clavesGene[indice1] + ",'" + linea + "' )");
/* 3770 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Agregó una llamada','Residuo: " + info[3] + "\nFecha del Pedido : " + info[4] + "\nFecha de Captura: " + String.valueOf(this.fechaActual) + "\nPrioridad: " + info[5] + "\nEquipo: " + info[0] + "\nPlataforma: " + info[1] + "\nPozo: " + info[2] + "\nAutorizó:" + info[6] + " ')");
/*      */         } 
/* 3772 */         limpiar();
/* 3773 */         this.fechaActual = new Date();
/* 3774 */         this.jDateChooser2.setDate(this.fechaActual);
/* 3775 */         this.jComboBox9.setSelectedIndex(0);
/* 3776 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton4ActionPerformed(ActionEvent evt) {
/* 3782 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 3783 */     if (indice < 0) {
/* 3784 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una llamada para cancelar el viaje", "Selecciona una llamada", 0, this.ERROR);
/*      */     } else {
/* 3786 */       this.CLAVE = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 3787 */       this.jTextField14.setText("");
/* 3788 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton10ActionPerformed(ActionEvent evt) {
/* 3793 */     cargarViaje();
/*      */   }
/*      */   
/*      */   private void materialButton5ActionPerformed(ActionEvent evt) {
/* 3797 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton11ActionPerformed(ActionEvent evt) {
/* 3801 */     cargarOperador();
/*      */   }
/*      */   
/*      */   private void materialButton6ActionPerformed(ActionEvent evt) {
/* 3805 */     this.jTextField14.setText("");
/* 3806 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton12ActionPerformed(ActionEvent evt) {
/* 3810 */     cancelar();
/*      */   }
/*      */   
/*      */   private void materialButton7ActionPerformed(ActionEvent evt) {
/* 3814 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void materialButton13ActionPerformed(ActionEvent evt) {
/* 3823 */     cargarEco();
/*      */   }
/*      */   
/*      */   private void materialButton8ActionPerformed(ActionEvent evt) {
/* 3827 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton14ActionPerformed(ActionEvent evt) {
/* 3831 */     String clave = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0));
/* 3832 */     String[] conte = this.con.regresaReg("num_rem,placas,tipo", "remolque", "where num_rem =" + clave, 3);
/* 3833 */     this.PLACAS[2] = conte[0];
/* 3834 */     this.PLACAS[3] = conte[1];
/* 3835 */     this.PLACAS[4] = conte[2];
/* 3836 */     this.jLabel43.setText("     " + conte[0] + "            " + conte[1]);
/* 3837 */     this.jLabel95.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4).toString());
/*      */   }
/*      */   
/*      */   private void materialButton15ActionPerformed(ActionEvent evt) {
/* 3841 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 3845 */     if (evt.getClickCount() == 2) {
/* 3846 */       cargarViaje();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 3859 */     if (evt.getClickCount() == 2) {
/* 3860 */       cargarOperador();
/*      */     } else {
/* 3862 */       this.materialButton11.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 3875 */     if (evt.getClickCount() == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3882 */       cargarEco();
/*      */     } else {
/* 3884 */       this.materialButton13.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/* 3897 */     if (evt.getClickCount() == 2) {
/* 3898 */       String clave = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0));
/* 3899 */       String[] conte = this.con.regresaReg("num_rem,placas,tipo", "remolque", "where num_rem =" + clave, 3);
/* 3900 */       this.PLACAS[2] = conte[0];
/* 3901 */       this.PLACAS[3] = conte[1];
/* 3902 */       this.PLACAS[4] = conte[2];
/* 3903 */       this.jLabel43.setText("     " + conte[0] + "            " + conte[1]);
/* 3904 */       this.jLabel95.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4).toString());
/* 3905 */       this.jDialog5.setVisible(false);
/*      */     } else {
/* 3907 */       this.materialButton14.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 3912 */     if (evt.getClickCount() == 2) {
/* 3913 */       String clave = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0).toString();
/* 3914 */       this.con.consultar("uso", "catproductos", "where clave='" + clave + "'");
/* 3915 */       int i = Integer.parseInt(this.con.Campo);
/* 3916 */       i++;
/* 3917 */       this.con.inserSinMsj("update catproductos set uso='" + i + "' where clave='" + clave + "'");
/* 3918 */       this.jTextField89.setText(clave);
/* 3919 */       this.jTextField89.setToolTipText(clave + " - " + clave);
/* 3920 */       this.jDialog20.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro7MouseClicked(MouseEvent evt) {
/* 3925 */     if (evt.getClickCount() == 2) {
/* 3926 */       String clave = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0).toString();
/* 3927 */       this.con.consultar("uso", "catunidades", "where clave_unidad='" + clave + "'");
/* 3928 */       int i = Integer.parseInt(this.con.Campo);
/* 3929 */       i++;
/* 3930 */       this.con.inserSinMsj("update catunidades set uso='" + i + "' where clave_unidad='" + clave + "'");
/* 3931 */       this.jTextField92.setText(clave);
/* 3932 */       this.jTextField92.setToolTipText(clave + " - " + clave);
/* 3933 */       this.jDialog21.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton16ActionPerformed(ActionEvent evt) {
/* 3938 */     this.con.inserSinMsj("update " + this.TABLA + " set uso = 0 where num_llama = " + this.CLAVE);
/* 3939 */     this.con.inserSinMsj("update formacion set activo=1 where num =" + this.NUMFORMA);
/* 3940 */     consultar();
/* 3941 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 3945 */     this.jDialog7.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 3949 */     this.con.consultar("estado", "tracto", "where num_tracto = " + this.PLACAS[0]);
/* 3950 */     String estado = this.con.Campo;
/* 3951 */     if (!this.PLACAS[0].equals("1")) {
/* 3952 */       this.enviar.put("ECO1", new DatosEnviarCorreo());
/*      */     }
/*      */ 
/*      */     
/* 3956 */     if (!this.jCheckBox3.isSelected()) {
/* 3957 */       this.SEMARNAT = "";
/*      */     }
/* 3959 */     this.PLACAS[4] = this.jLabel95.getText();
/* 3960 */     int indice1 = this.jComboBox6.getSelectedIndex();
/* 3961 */     indice1--;
/* 3962 */     int indice2 = this.jComboBox7.getSelectedIndex();
/* 3963 */     indice2--;
/*      */     
/* 3965 */     this.error.pasarModal(true);
/* 3966 */     this.val.pasarModal(Boolean.valueOf(true));
/* 3967 */     String guia = this.jTextField2.getText();
/* 3968 */     String valor = String.valueOf(this.jComboBox7.getSelectedItem());
/* 3969 */     if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3970 */       indice2 = 0;
/* 3971 */       this.clavesDesti[indice2] = "0";
/* 3972 */       this.jLabel38.setText("");
/* 3973 */       this.jLabel39.setText("");
/* 3974 */       this.jLabel40.setText("");
/* 3975 */       this.jLabel41.setText("");
/* 3976 */       valor = "";
/*      */       
/* 3978 */       this.jLabel50.setText("");
/* 3979 */       this.jLabel51.setText("");
/* 3980 */       this.jLabel54.setText("");
/* 3981 */       this.jLabel59.setText("");
/* 3982 */       if (this.jLabel33.getText().equals("POZO:")) {
/* 3983 */         this.jLabel33.setText("");
/*      */       }
/*      */     } else {
/* 3986 */       this.jLabel33.setText(this.POZO);
/*      */       
/* 3988 */       this.clavesDesti = this.con.regresaColIndex("clave_desti", "emp_destinataria", "where clave_desti<>0 order by empresa");
/*      */     } 
/* 3990 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/* 3991 */       this.error.cargarError(this.jComboBox8, "050"); return;
/*      */     } 
/* 3993 */     if (this.jLabel42.getText().equals("ECONÓMICO Y PLACAS")) {
/* 3994 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la información donde se coloca el número de Tractor", "Falta Información del Tractor", 0, this.ERROR); return;
/*      */     } 
/* 3996 */     if (this.jLabel43.getText().equals("NÚMERO Y PLACAS")) {
/* 3997 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la información donde se coloca el número de Remolque", "Falta Información del Remolque", 0, this.ERROR); return;
/*      */     } 
/* 3999 */     if (this.jLabel44.getText().equals("AQUÍ SE CARGA EL OPERADOR")) {
/* 4000 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la información donde se coloca el operador", "Falta Información del Operador", 0, this.ERROR); return;
/*      */     } 
/* 4002 */     if (this.jComboBox8.getSelectedIndex() == 1 && this.jComboBox7.getSelectedIndex() == 0) {
/* 4003 */       this.jComboBox7.setBackground(new Color(255, 51, 51));
/* 4004 */       JOptionPane.showMessageDialog(this.padre, "Si deseas imprimir manifiesto por favor selecciona la empresa destino", "Selecciona un destino", 0, this.ERROR); return;
/*      */     } 
/* 4006 */     if (this.jTextField89.getText().equals("")) {
/* 4007 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la información del producto o servicio", "Fala la clave", 0, this.ERROR);
/* 4008 */     } else if (this.jTextField92.getText().equals("")) {
/* 4009 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la información del de la unidad", "Fala la unidad", 0, this.ERROR);
/*      */     } else {
/* 4011 */       boolean bloqueado = false;
/* 4012 */       int DD = -1 * this.DIASVENCIDOS;
/* 4013 */       if (this.DIASVENCIDOS < 0 && this.DIASVENCIDOS > -31) {
/* 4014 */         bloqueado = false;
/* 4015 */         this.jDialog8.setTitle("Licencia está por vencerse");
/* 4016 */         this.jLabel97.setText("Próximo Vencimiento de Licencia");
/* 4017 */         this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER.</center></html>");
/* 4018 */         this.jLabel99.setText("<html><center>La vigencia de la licencia caducará en " + DD + " días, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/* 4019 */         this.jDialog8.setVisible(true);
/* 4020 */       } else if (this.DIASVENCIDOS > 0 && this.DIASVENCIDOS < 15) {
/* 4021 */         bloqueado = false;
/* 4022 */         this.jDialog8.setTitle("Licencia Vencida");
/* 4023 */         this.jLabel97.setText("Actualizar Licencia");
/* 4024 */         this.jLabel98.setText("<html><center>LA LICENCIA ESTÁ VENCIDA Y NECESITA ACTUALIZARLA.</center></html>");
/* 4025 */         this.jLabel99.setText("<html><center>El operador que seleccionaste cuenta con una licencia vencida, necesita actualizarla ya que sino lo hace, quedará bloquedo dentro de " + 15 - this.DIASVENCIDOS + " días.</center></html>");
/* 4026 */         this.jDialog8.setVisible(true);
/* 4027 */       } else if (this.DIASVENCIDOS > 15) {
/* 4028 */         bloqueado = true;
/* 4029 */         this.jDialog8.setTitle("Licencia Vencida");
/* 4030 */         this.jLabel97.setText("Operador Bloqueado");
/* 4031 */         this.jLabel98.setText("<html><center>LICENCIA VENCIDA.</center></html>");
/* 4032 */         this.jLabel99.setText("<html><center>El operador ha sido bloqueado por no actualizar su licencia, no se podrá dar viajes hasta que refrende éste documento.</center></html>");
/* 4033 */         this.jDialog8.setVisible(true);
/*      */       } 
/* 4035 */       if (!bloqueado) {
/* 4036 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>Asignarás viaje con los siguientes datos:<h1><font color =BLACK>" + this.EQUIPOS[0] + " - " + this.EQUIPOS[1] + " - " + this.EQUIPOS[2] + "</font></h1>¿Estás seguro que los datos son correctos?</html>", "Imprimir Guía", 0, 3, this.PREG);
/* 4037 */         if (res == 0) {
/* 4038 */           String tabla = "";
/* 4039 */           String componer = "";
/* 4040 */           boolean salir = false;
/* 4041 */           String cliente = String.valueOf(this.jComboBox6.getSelectedItem());
/* 4042 */           if (this.jComboBox7.getSelectedIndex() == 0 || cliente.equals("PERFORADORA MÉXICO, S.A. DE C.V.") || cliente.equals("CALFRAC S.A. DE C.V.")) {
/* 4043 */             this.jLabel50.setText("");
/* 4044 */             this.jLabel51.setText("");
/* 4045 */             this.jLabel54.setText("");
/* 4046 */             this.jLabel59.setText("");
/* 4047 */             this.CANTIDAD = "";
/* 4048 */             this.jLabel61.setText("");
/*      */           } 
/*      */           
/* 4051 */           String decla = "";
/* 4052 */           this.con.consultar("max(guias.num)", "guias,llamadas_historicas,pozos", "where pozos.num_pozo = llamadas_historicas.num_pozo and llamadas_historicas.num_llama = guias.num_llama and pozos.nombre = '" + this.EQUIPOS[2] + "'");
/*      */           
/* 4054 */           String[] info = this.con.regresaReg("tracto.num_tracto,remolque.num_rem,tracto.placas,remolque.placas", "operadores,remolque,TRACTO", "where operadores.num_tracto = tracto.num_tracto and remolque.num_rem = operadores.num_rem and num_ope = " + this.CLAVEOP, 4);
/* 4055 */           String todos = this.jTextArea1.getText().toUpperCase();
/* 4056 */           String[] llamadas = this.con.regresaReg("num_llama,residuo,fecha_ped,ingreso,prioridad,num_equipo,num_plata,num_pozo", this.TABLA, "where num_llama = " + this.CLAVE, 8);
/* 4057 */           sacarMayor();
/* 4058 */           this.con.inserSinMsj("insert into llamadas_historicas (residuo,fecha_ped,ingreso,prioridad,descrip,estado,comen,num_equipo,num_plata,num_pozo,nombre_usu,num_guia,num_ope,clave_gene,clave_desti,num_tracto,num_rem)values('" + llamadas[1] + "','" + llamadas[2] + "','" + llamadas[3] + "'," + llamadas[4] + ",'" + todos + "','ACTIVADA',''," + llamadas[5] + "," + llamadas[6] + "," + llamadas[7] + ",'" + this.USUARIO + "','" + this.jTextField2.getText() + "'," + this.CLAVEOP + "," + this.clavesGene[indice1] + "," + this.clavesDesti[indice2] + "," + this.PLACAS[0] + "," + this.PLACAS[2] + " )");
/* 4059 */           this.con.consultar("max(num_llama)", "llamadas_historicas", "");
/* 4060 */           this.con.inserSinMsj("insert into guias(num_guia,fecha,num_llama,estado,nombre,tipo,num_vale,diesel,servicio,estatus,comen_pre,factura,pedido,factimpresa,manifiesto,operador,prefactura, linea,km,folio_imp, claveproductoSat, claveUnidadSat)values('" + this.jTextField2.getText() + "',now()," + this.con.Campo + ",'ACTIVA','" + this.jLabel45.getText() + "','" + this.PLACAS[4] + "','','','" + String.valueOf(this.jComboBox8.getSelectedItem()) + "','<Asignada Al Operador>','',0,'','','','" + this.jLabel44.getText().toUpperCase() + "',0,'" + this.LINEA + "',0,'','" + this.jTextField89.getText() + "','" + this.jTextField92.getText() + "')");
/*      */           
/* 4062 */           this.con.inserSinMsj("update formacion set activo=0, guias='" + this.jTextField2.getText() + "',estatus='VIAJE EXPEDIDO' where num =" + this.NUMFORMA);
/*      */ 
/*      */           
/* 4065 */           Imprimir im = new Imprimir();
/* 4066 */           String resi = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */           
/* 4068 */           String[] campos = { this.jLabel12.getText(), this.jLabel34.getText(), String.valueOf(this.jComboBox6.getSelectedItem()), this.jLabel35.getText(), this.jLabel36.getText(), this.jLabel37.getText(), this.jLabel38.getText(), valor, this.jLabel39.getText(), this.jLabel40.getText(), this.jLabel41.getText(), this.PLACAS[4], this.jLabel29.getText().toUpperCase(), this.EQUIPOS[0], this.EQUIPOS[1], this.jLabel59.getText(), this.jLabel50.getText(), this.jLabel51.getText(), this.jLabel54.getText(), this.jLabel44.getText(), this.jLabel33.getText(), this.PLACAS[0], this.PLACAS[1], this.PLACAS[2], this.PLACAS[3], this.jLabel61.getText(), this.jLabel45.getText(), this.jTextField2.getText(), resi, todos, this.SEMARNAT, this.LINEA };
/* 4069 */           im.recibeDatos(campos);
/*      */           
/* 4071 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Creó la guía No: " + this.jTextField2.getText() + "','Fecha: " + this.jLabel12.getText() + "\nNúmero de Llamada: " + this.CLAVE + " Estado: Activa\nDetalles: " + todos + "\nToneladas: " + this.CANTIDAD + "\nSub-Total: " + this.jLabel50.getText() + "\nIva: " + this.jLabel51.getText() + "\nTotal: " + this.jLabel54.getText() + "\nOrigen: " + String.valueOf(this.jComboBox6.getSelectedItem()) + "\nDestino: " + valor + "')");
/* 4072 */           this.con.eliminar2(this.TABLA, "where num_llama = " + this.CLAVE);
/* 4073 */           if (this.jLabel29.getText().equals("RECORTE DE PERFORACION BASE ACEITE") || this.jLabel29.getText().equals("SANEAMIENTO") || this.jLabel29.getText().equals("SEDIMENTO") || this.jLabel29.getText().equals("SÓLIDOS CONTAMINADOS CON HIDROCARBUROS") || this.jLabel29.getText().equals("LODOS CONTAMINADOS PROVENIENTES DEL SIAC TAJÍN 5") || this.jLabel29.getText().equals("RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE") || this.jLabel29.getText().equals("RESIDUOS ADICIONALES A LA PERFORACION") || this.jLabel29.getText().equals("FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE PERFORACION") || this.jLabel29.getText().equals("TIERRA IMPREGNADA CON HIDROCARBUROS") || this.jLabel29.getText().equals("FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS") || this.jLabel29.getText().equals("TIERRA CONTAMINADA (SANEAMIENTO)") || this.jLabel29.getText().equals("AGUAS OLEOSAS") || this.jLabel29.getText().equals("LODOS ACEITOSOS") || this.jLabel29.getText().equals("SEDIMENTO DE LIMPIEZA DE PRESAS")) {
/* 4074 */             tabla = "manifiestos_recorteaceite";
/* 4075 */             componer = "FPR-";
/* 4076 */             salir = true;
/*      */           } else {
/* 4078 */             tabla = "manifiestos_lodoagua";
/* 4079 */             componer = "FPR-AG-";
/* 4080 */             salir = true;
/*      */           } 
/* 4082 */           if (this.jComboBox8.getSelectedIndex() == 1 && salir) {
/* 4083 */             String semar = "SEMARNAT";
/* 4084 */             String residuo = "";
/* 4085 */             residuo = this.jLabel29.getText();
/*      */             
/* 4087 */             if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.") && (residuo.contains("RECORTE") || residuo.contains("LODO"))) {
/* 4088 */               semar = "SEDEMA";
/*      */             }
/*      */             
/* 4091 */             if (this.jLabel29.getText().equals("RECORTE DE PERFORACION BASE ACEITE") || this.jLabel29.getText().equals("RECORTE BASE AGUA") || this.jLabel29.getText().equals("LODO BASE ACEITE"));
/*      */ 
/*      */             
/* 4094 */             decla = separarDeclaracion(decla);
/*      */             
/* 4096 */             this.con.inserSinMsj("insert into " + tabla + "(manifiesto,ubicacion,municipio,num_guia,id_edo)values('','','','" + this.jTextField2.getText() + "',33)");
/* 4097 */             this.con.consultar("max(num)", tabla, "");
/* 4098 */             componer = componer + componer;
/* 4099 */             this.con.inserSinMsj("update " + tabla + " set manifiesto = '" + componer + "' where num_guia = '" + this.jTextField2.getText() + "'");
/* 4100 */             this.con.inserSinMsj("update guias set manifiesto='" + componer + "' where num_guia = '" + this.jTextField2.getText() + "'");
/* 4101 */             String clienteS = String.valueOf(this.jComboBox6.getSelectedItem());
/* 4102 */             if (tabla.equals("manifiestos_recorteaceite")) {
/* 4103 */               String[] registros = this.con.regresaReg("semarnat,ruta,ciudad,telefono,bascula", "emp_destinataria", "where empresa = '" + String.valueOf(this.jComboBox7.getSelectedItem()) + "'", 5);
/* 4104 */               String[] otrosCampos = { this.EQUIPOS[0], this.EQUIPOS[2], this.EQUIPOS[1], componer, this.jLabel29.getText().toUpperCase(), this.PLACAS[4], "", this.jLabel44.getText(), this.PLACAS[0], this.PLACAS[2], this.PLACAS[1], this.PLACAS[3], String.valueOf(this.jComboBox7.getSelectedItem()), registros[0], this.jLabel39.getText() + " " + this.jLabel39.getText(), registros[1], this.SEMARNAT, semar, "ACEITE", this.jTextField2.getText(), registros[3], registros[4], decla };
/* 4105 */               if (clienteS.equals("DRAKE-MESA S DE RL DE CV")) {
/* 4106 */                 this.mEspecial = new ManifiestosEspecial(otrosCampos, "ACEITE");
/*      */               }
/* 4108 */               else if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.")) {
/* 4109 */                 this.declaracion = new declaracionRecortes(otrosCampos);
/* 4110 */               } else if (cliente.equals("WEATHERFORD DE MEXICO S DE RL DE CV") || cliente.equals("WEATHERFORD DE MEXICO S. DE R.L. DE C.V.") || cliente.equals("INTEGRIDAD MEXICANA DEL NORTE S DE RL DE CV")) {
/* 4111 */                 this.declaracionWTF = new declaracionRecortesWTF(otrosCampos);
/*      */               } else {
/* 4113 */                 this.mAceite = new ManifiestosAceite(otrosCampos);
/*      */               } 
/*      */             } else {
/*      */               
/* 4117 */               this.SEMARNAT = "";
/* 4118 */               String[] registros = this.con.regresaReg("semarnat,ruta,ciudad,telefono,bascula", "emp_destinataria", "where empresa = '" + String.valueOf(this.jComboBox7.getSelectedItem()) + "'", 5);
/* 4119 */               String[] otrosCampos = { this.EQUIPOS[0], this.EQUIPOS[2], this.EQUIPOS[1], componer, this.jLabel29.getText().toUpperCase(), this.PLACAS[4], "", this.jLabel44.getText(), this.PLACAS[0], this.PLACAS[2], this.PLACAS[1], this.PLACAS[3], String.valueOf(this.jComboBox7.getSelectedItem()), registros[0], this.jLabel39.getText() + " " + this.jLabel39.getText() + " " + this.jLabel40.getText(), registros[1], this.SEMARNAT, semar, "AGUA", this.jTextField2.getText(), registros[3], registros[4], decla };
/* 4120 */               if (clienteS.equals("DRAKE-MESA S DE RL DE CV")) {
/* 4121 */                 this.mEspecial = new ManifiestosEspecial(otrosCampos, "AGUA");
/*      */               }
/* 4123 */               else if (cliente.equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.")) {
/* 4124 */                 this.declaracion = new declaracionRecortes(otrosCampos);
/* 4125 */               } else if ((cliente.equals("WEATHERFORD DE MEXICO S DE RL DE CV") || cliente.equals("WEATHERFORD DE MEXICO S. DE R.L. DE C.V.") || cliente.equals("WEATHERFORD DE MEXICO S DE RL DE CV") || cliente.equals("INTEGRIDAD MEXICANA DEL NORTE S DE RL DE CV")) && residuo.equals("RECORTE BASE AGUA")) {
/*      */                 
/* 4127 */                 this.declaracionWTF = new declaracionRecortesWTF(otrosCampos);
/*      */               } else {
/* 4129 */                 this.mAgua = new ManifiestosAgua(otrosCampos);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*      */           try {
/* 4135 */             crearGuia(this.jTextField2.getText());
/* 4136 */           } catch (IOException ex) {
/* 4137 */             Logger.getLogger(Facturas33.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */           } 
/* 4139 */           limpiarGuia();
/* 4140 */           consultar();
/*      */           
/* 4142 */           this.SEMARNAT = this.CAMPOSGENERALES.get("semarnat");
/* 4143 */           this.jDialog1.setVisible(false);
/*      */           
/* 4145 */           if (((DatosEnviarCorreo)this.enviar.get("ECO1")).isEnviarCorreo()) {
/* 4146 */             String[] DIRECCIONES = { this.CAMPOSGENERALES.get("usuarios.correo") };
/* 4147 */             String[] COPIAS = { "qhse.poza@forsis.com.mx", "sistemas.poza@forsis.com.mx" };
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 4152 */             EnviandoCorreo enviandoCorreo = new EnviandoCorreo("ECO1", DIRECCIONES, COPIAS);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField18KeyTyped(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField19KeyReleased(KeyEvent evt) {
/* 4164 */     consultar4();
/*      */   }
/*      */   
/*      */   private void jComboBox18ActionPerformed(ActionEvent evt) {
/* 4168 */     if (this.entraCombo3)
/* 4169 */       consultar3(); 
/*      */   }
/*      */   
/*      */   public void datos(String usua, String num, Map<String, String> CAMPOSGENERALES) {
/* 4173 */     this.entraCombo3 = false;
/* 4174 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/* 4175 */     this.jLabel12.setText("" + this.ahoraCal.get(5) + "/" + this.ahoraCal.get(5) + "/" + this.ahoraCal.get(2) + 1);
/* 4176 */     this.USUARIO = usua;
/* 4177 */     this.NOMBRE = String.valueOf(CAMPOSGENERALES.get("empleados.nombre")) + " " + String.valueOf(CAMPOSGENERALES.get("empleados.nombre")) + " " + String.valueOf(CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4184 */     this.SEMARNAT = CAMPOSGENERALES.get("semarnat");
/* 4185 */     this.jLabel45.setText(this.NOMBRE);
/* 4186 */     this.fechaActual = new Date();
/* 4187 */     this.jDateChooser2.setDate(this.fechaActual);
/* 4188 */     this.panel.setViewportView(this);
/* 4189 */     this.id = num;
/*      */ 
/*      */     
/* 4192 */     this.PRIVILEGIO = CAMPOSGENERALES.get("priv");
/*      */     
/* 4194 */     llenarCombo3();
/* 4195 */     cargarPerfil();
/* 4196 */     consultar();
/* 4197 */     cargarPozos();
/* 4198 */     this.jComboBox17.removeAllItems();
/* 4199 */     this.jComboBox17.setEnabled(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void cargarEco() {
/* 4205 */     String[] conte = { this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0).toString(), this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString() };
/* 4206 */     String estado = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 4).toString();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4213 */     this.PLACAS[0] = conte[0];
/* 4214 */     this.PLACAS[1] = conte[1];
/* 4215 */     this.jLabel42.setText("  " + conte[0] + "        " + conte[1]);
/* 4216 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   public String separarDeclaracion(String ultimoFolio) {
/* 4220 */     String nuevoFolio = "";
/* 4221 */     String cadenaFecha = "";
/* 4222 */     SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/* 4223 */     Date fecha = new Date();
/* 4224 */     cadenaFecha = formato.format(fecha);
/* 4225 */     System.out.println("Cadenaaaa " + ultimoFolio);
/* 4226 */     if (ultimoFolio == null || ultimoFolio.equals("")) {
/* 4227 */       nuevoFolio = cadenaFecha.substring(0, 2) + cadenaFecha.substring(0, 2) + cadenaFecha.substring(3, 5) + "-001";
/*      */     } else {
/* 4229 */       String folio = ultimoFolio.substring(7, 10);
/* 4230 */       System.out.println("Ultimo Folio: " + folio);
/* 4231 */       int num = Integer.parseInt(folio);
/* 4232 */       num++;
/* 4233 */       nuevoFolio = "" + num;
/* 4234 */       if (num < 10) {
/* 4235 */         nuevoFolio = "00" + num;
/* 4236 */       } else if (num < 100) {
/* 4237 */         nuevoFolio = "0" + num;
/*      */       } else {
/* 4239 */         nuevoFolio = "" + num;
/*      */       } 
/* 4241 */       nuevoFolio = cadenaFecha.substring(0, 2) + cadenaFecha.substring(0, 2) + cadenaFecha.substring(3, 5) + "-" + cadenaFecha.substring(8, 10);
/*      */     } 
/* 4243 */     return nuevoFolio;
/*      */   }
/*      */   
/*      */   public void crearGuia(String nombre) throws IOException {
/* 4247 */     String[] fact = nombre.split("-");
/* 4248 */     String folio = "T" + fact[0] + fact[1];
/*      */ 
/*      */     
/* 4251 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.RUTA + "/" + this.RUTA + ".yaml"), "utf-8"));
/* 4252 */     out.write("\n");
/* 4253 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/* 4254 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/* 4255 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/* 4256 */     out.write("\n");
/* 4257 */     out.write("--- !diverza.com/v2.0\n\n");
/* 4258 */     out.write("#DATOS GENERALES\n");
/* 4259 */     out.write("Comprobante:\n\n");
/* 4260 */     out.write("  NombreCfdi: \"" + folio + "\"\n");
/* 4261 */     out.write("  RefId: \"" + folio + "\"\n");
/* 4262 */     out.write("  Version: \"3.3\"\n");
/* 4263 */     out.write("  Serie: \"T" + fact[0] + "\"\n");
/* 4264 */     out.write("  Folio: \"" + fact[1] + "\"\n");
/*      */     
/* 4266 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4267 */     String fecha = formato.format(new Date());
/* 4268 */     DateFormat hr = new SimpleDateFormat("HH:mm:ss");
/* 4269 */     String hora = hr.format(new Date());
/* 4270 */     String[] horario = hora.split(":");
/* 4271 */     System.out.println(hr.format(new Date()));
/* 4272 */     String año = fecha.substring(0, 4);
/* 4273 */     String mes = fecha.substring(4, 6);
/* 4274 */     String dia = fecha.substring(6, 8);
/*      */     
/* 4276 */     String hh = horario[0];
/* 4277 */     String mm = horario[1];
/* 4278 */     String ss = horario[2];
/* 4279 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/* 4280 */     out.write("  Sello: \"\"\n");
/* 4281 */     out.write("  NoCertificado: \"" + this.CERTIFICADO + "\"\n");
/* 4282 */     out.write("  Certificado: \"\"\n");
/* 4283 */     out.write("  SubTotal: \"0\"\n");
/* 4284 */     out.write("  Moneda: \"MXN\"\n");
/* 4285 */     out.write("  TipoCambio: \"1\"\n");
/* 4286 */     out.write("  Total: \"0\"\n");
/* 4287 */     out.write("  TipoDeComprobante: \"T\"\n");
/* 4288 */     out.write("  LugarExpedicion: \"" + this.CODIGOPOSTAL + "\"\n\n");
/* 4289 */     out.write("\n");
/* 4290 */     out.write("  Emisor:\n");
/* 4291 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/* 4292 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS, S.A. DE C.V.\"\n");
/* 4293 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*      */     
/* 4295 */     out.write("  Receptor: \n");
/* 4296 */     out.write("    Rfc: \"XAXX010101000\"\n");
/* 4297 */     out.write("    UsoCFDI: \"P01\"\n\n");
/*      */     
/* 4299 */     out.write("  Conceptos: \n");
/* 4300 */     out.write("    -\n");
/* 4301 */     out.write("      Concepto: \"\"\n");
/* 4302 */     out.write("      ClaveProdServ: \"" + this.jTextField89.getText() + "\"\n");
/* 4303 */     out.write("      NoIdentificacion: \"" + this.jTextField92.getText() + "\"\n");
/* 4304 */     out.write("      Cantidad: \"1\"\n");
/* 4305 */     out.write("      ClaveUnidad: \"" + this.jTextField92.getText() + "\"\n");
/* 4306 */     out.write("      Unidad: \"" + String.valueOf(this.jComboBox8.getSelectedItem()) + "\"\n");
/* 4307 */     out.write("      Descripcion: \"" + this.jLabel29.getText() + " - " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)) + "\"\n");
/* 4308 */     out.write("      ValorUnitario: \"0\"\n");
/* 4309 */     out.write("      Importe: \"0\"\n");
/*      */     
/* 4311 */     out.write("\n");
/* 4312 */     out.write("  Addenda: \n");
/* 4313 */     out.write("    Diverza: \n");
/* 4314 */     out.write("      Version: \"1.1\"\n\n");
/* 4315 */     out.write("      Generales: \n");
/*      */     
/* 4317 */     out.write("      DatosContactoE: \n");
/* 4318 */     out.write("        Telefono: \"01 782 825 6455 al 01 782 825 6458\"\n");
/* 4319 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*      */     
/* 4321 */     out.write("      Emisor: \n");
/* 4322 */     out.write("        DomicilioFiscalE: \n");
/* 4323 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/* 4324 */     out.write("          Numero: \"KM 32.5\"\n");
/* 4325 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/* 4326 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/* 4327 */     out.write("          Estado: \"NUEVO LEON\"\n");
/* 4328 */     out.write("          Pais: \"MEXICO\"\n");
/* 4329 */     out.write("          CodigoPostal: \"67483\"\n");
/* 4330 */     out.write("        SucursalE: \n");
/* 4331 */     out.write("          Alias: \"" + this.SUCURSAL + "\"\n");
/* 4332 */     out.write("          DomicilioSucursal: \n");
/* 4333 */     out.write("            Calle: \"CARRETERA POZA RICA A TIHUATLAN KM 8.5 \"\n");
/* 4334 */     out.write("            Ciudad: \"TIHUATLAN\"\n");
/* 4335 */     out.write("            Estado: \"VERACRUZ\"\n");
/* 4336 */     out.write("            Pais: \"MÉXICO\"\n");
/* 4337 */     out.write("            CodigoPostal: \"92900\"\n\n");
/*      */     
/* 4339 */     out.write("  LeyendasImpresion: \n");
/* 4340 */     out.write("    -\n");
/* 4341 */     out.write("      Atributo: \"SEMARNAT\"\n");
/* 4342 */     out.write("      Valor: \"PERMISO SEMARNAT 19-I-036D-10, PERMISO SCT CG20045\"\n");
/*      */     
/* 4344 */     out.write("      Atributo: \"IMPUESTO RETENIDO\"\n");
/* 4345 */     out.write("      Valor: \"IMPUESTO RETENIDO DE CONFORMIDAD CON LA LEY DEL IMPUESTO AL VALOR AGREGADO\"\n");
/* 4346 */     out.write("---");
/* 4347 */     out.close();
/*      */   }
/*      */   
/*      */   public void entrada() {
/* 4351 */     boolean encontrado = false;
/* 4352 */     String nombre = this.jTextField1.getText().toUpperCase();
/* 4353 */     String contra = this.jPasswordField1.getText().toUpperCase();
/* 4354 */     if (nombre.equals("") || contra.equals("")) {
/* 4355 */       JOptionPane.showMessageDialog(this, "Dejaste información sin contestar, por favor verifícala.", "Información Incompleta", 2, this.ADVER);
/*      */     } else {
/* 4357 */       boolean n1 = false;
/* 4358 */       boolean n2 = false;
/* 4359 */       encontrado = this.con.consultar("num_emp", "usuarios", " where nombre_usu = '" + nombre + "' and contra = '" + contra + "'");
/* 4360 */       if (this.con.Campo.equals("0")) {
/* 4361 */         if (this.VENTANA1) {
/* 4362 */           String num = JOptionPane.showInputDialog(this.jDialog1, "Inserta el nombre del operador que no se encuentra\nen la base de datos", "Inserta el Nombre", 1);
/* 4363 */           if (num == null || num.equals("")) {
/* 4364 */             JOptionPane.showMessageDialog(this.jDialog1, "Debes insertar el nombre del operador", "Campo Vacío", 0, this.ERROR);
/* 4365 */             this.jDialog9.setVisible(false);
/*      */           } else {
/* 4367 */             this.CLAVEOP = "0";
/* 4368 */             this.jLabel44.setText(num.toUpperCase());
/* 4369 */             this.jDialog9.setVisible(false);
/* 4370 */             this.con.inserSinMsj("update formacion set activo=1 where num= " + this.NUMFORMA);
/* 4371 */             this.NUMFORMA = "0";
/*      */           } 
/*      */         } else {
/* 4374 */           String depa = "SUPER USUARIO";
/* 4375 */           String priv = "";
/* 4376 */           setEnabled(true);
/* 4377 */           this.jDialog9.setVisible(false);
/* 4378 */           this.jDialog2.setVisible(true);
/*      */         } 
/* 4380 */       } else if (encontrado == true) {
/* 4381 */         String depa = this.con.Campo;
/*      */ 
/*      */         
/* 4384 */         depa = this.CAMPOSGENERALES.get("priv");
/* 4385 */         if (depa.equals("SUPER USUARIO")) {
/* 4386 */           if (this.VENTANA1) {
/* 4387 */             String num = JOptionPane.showInputDialog(this.jDialog1, "Inserta el nombre del operador que no se encuentra\nen la base de datos", "Inserta el Nombre", 1);
/* 4388 */             if (num == null || num.equals("")) {
/* 4389 */               JOptionPane.showMessageDialog(this.jDialog1, "Debes insertar el nombre del operador", "Campo Vacío", 0, this.ERROR);
/* 4390 */               this.jDialog9.setVisible(false);
/*      */             } else {
/* 4392 */               this.CLAVEOP = "0";
/* 4393 */               this.jLabel44.setText(num.toUpperCase());
/* 4394 */               this.jDialog9.setVisible(false);
/* 4395 */               this.con.inserSinMsj("update formacion set activo=1 where num= " + this.NUMFORMA);
/* 4396 */               this.NUMFORMA = "0";
/*      */             } 
/*      */           } else {
/* 4399 */             this.jDialog9.setVisible(false);
/* 4400 */             this.jPasswordField1.setText("");
/* 4401 */             this.jTextField1.setText("");
/* 4402 */             this.jDialog2.setVisible(true);
/* 4403 */             this.materialButton10.setEnabled(true);
/*      */           } 
/*      */         } else {
/* 4406 */           JOptionPane.showMessageDialog(this.jDialog9, "No puedes entrar a este módulo, ya que está restringido para todo personal\n que no tenga privilegios de super usuario.", "No Tiene Privilegios", 0, this.ERROR);
/*      */         } 
/*      */       } else {
/* 4409 */         n1 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu='" + nombre + "'");
/* 4410 */         n2 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu = '" + nombre + "' and contra='" + contra + "'");
/* 4411 */         if (!n1) {
/* 4412 */           JOptionPane.showMessageDialog(this.jDialog9, "El nombre de usuario no se encuentra registrado en la base de datos\nVerifica tu Información", "Usuario Incorrecto", 0, this.ERROR);
/* 4413 */           this.jTextField1.setText("");
/* 4414 */         } else if (!n2) {
/* 4415 */           JOptionPane.showMessageDialog(this.jDialog9, "La contraseña no coincide con el nombre de usuario.\nVerifica tu Información", "Usuario Incorrecto", 0, this.ERROR);
/* 4416 */           this.jPasswordField1.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCatServicios() {
/* 4423 */     this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 4424 */           .buscarDatos(2, "clave,descripcion", "catproductos", "where clave like '%" + this.jTextField94.getText() + "%' and descripcion like '%" + this.jTextField95.getText() + "%' order by uso desc,clave asc"), (Object[])new String[] { "Clave", "Descripción" })
/*      */         {
/*      */           
/* 4427 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4432 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4436 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 4437 */     this.jScrollPane22.setViewportView((Component)this.rSTableMetro6);
/*      */     
/* 4439 */     this.rSTableMetro6.setSelectionMode(0);
/* 4440 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 4441 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4443 */     this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 4444 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     
/* 4446 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 4447 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public void llenarCatUnidades() {
/* 4451 */     this.rSTableMetro7.setModel(new DefaultTableModel((Object[][])this.con
/* 4452 */           .buscarDatos(2, "clave_unidad,descripcion_unidad", "catunidades", "where clave_unidad like '%" + this.jTextField96.getText() + "%' and descripcion_unidad like '%" + this.jTextField97.getText() + "%' order by uso desc,descripcion_unidad asc"), (Object[])new String[] { "Clave", "Descripción" })
/*      */         {
/*      */           
/* 4455 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4460 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4464 */     this.rSTableMetro7.setShowVerticalLines(false);
/* 4465 */     this.jScrollPane23.setViewportView((Component)this.rSTableMetro7);
/*      */     
/* 4467 */     this.rSTableMetro7.setSelectionMode(0);
/* 4468 */     this.rSTableMetro7.setAutoCreateRowSorter(true);
/* 4469 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4471 */     this.rSTableMetro7.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 4472 */     this.rSTableMetro7.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     
/* 4474 */     this.rSTableMetro7.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 4475 */     this.rSTableMetro7.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public static int restarFechas(Date fechaInicial, Date fechaFinal) {
/* 4479 */     DateFormat df = DateFormat.getDateInstance(2);
/* 4480 */     String fechaInicioString = df.format(fechaInicial);
/*      */     try {
/* 4482 */       fechaInicial = df.parse(fechaInicioString);
/* 4483 */     } catch (ParseException parseException) {}
/*      */     
/* 4485 */     String fechaFinalString = df.format(fechaFinal);
/*      */     try {
/* 4487 */       fechaFinal = df.parse(fechaFinalString);
/* 4488 */     } catch (ParseException parseException) {}
/*      */     
/* 4490 */     long fechaInicialMs = fechaInicial.getTime();
/* 4491 */     long fechaFinalMs = fechaFinal.getTime();
/* 4492 */     long diferencia = fechaFinalMs - fechaInicialMs;
/* 4493 */     double dias = Math.floor((diferencia / 86400000L));
/* 4494 */     return (int)dias;
/*      */   }
/*      */   
/*      */   public void cargarOperador() {
/* 4498 */     this.con.inserSinMsj("update formacion set activo=1 where num= " + this.NUMFORMA);
/* 4499 */     this.NUMFORMA = "0";
/* 4500 */     String clave = String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0));
/* 4501 */     this.CLAVEOP = clave;
/* 4502 */     this.operadores = this.con.regresaReg("num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope =" + clave, 4);
/* 4503 */     this.con.consultar("fecha_licen", "operadores", "where num_ope=" + clave);
/* 4504 */     this.jLabel44.setText(this.operadores[1] + " " + this.operadores[1] + " " + this.operadores[2]);
/* 4505 */     this.jDialog2.setVisible(false);
/*      */     
/* 4507 */     String año = this.con.Campo.substring(0, 4);
/* 4508 */     String mes = this.con.Campo.substring(5, 7);
/* 4509 */     String dia = this.con.Campo.substring(8, 10);
/*      */     
/* 4511 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4512 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 4513 */     Date fechaLicen = null;
/*      */     try {
/* 4515 */       fechaLicen = formatoDelTexto.parse(strFecha);
/* 4516 */     } catch (ParseException ex) {
/* 4517 */       ex.printStackTrace();
/*      */     } 
/* 4519 */     Date fechaAc = new Date();
/* 4520 */     this.DIASVENCIDOS = restarFechas(fechaLicen, fechaAc);
/* 4521 */     int DD = -1 * this.DIASVENCIDOS;
/* 4522 */     if (this.DIASVENCIDOS < 0 && this.DIASVENCIDOS > -31) {
/* 4523 */       this.jDialog8.setTitle("Licencia está por vencerse");
/* 4524 */       this.jLabel97.setText("Próximo Vencimiento de Licencia");
/* 4525 */       this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER.</center></html>");
/* 4526 */       this.jLabel99.setText("<html><center>La vigencia de la licencia caducará en " + DD + " días, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/* 4527 */       this.jDialog8.setVisible(true);
/* 4528 */     } else if (this.DIASVENCIDOS > 0 && this.DIASVENCIDOS < 15) {
/* 4529 */       this.jDialog8.setTitle("Licencia Vencida");
/* 4530 */       this.jLabel97.setText("Actualizar Licencia");
/* 4531 */       this.jLabel98.setText("<html><center>LA LICENCIA ESTÁ VENCIDA Y NECESITA ACTUALIZARLA.</center></html>");
/* 4532 */       this.jLabel99.setText("<html><center>El operador que seleccionaste cuenta con una licencia vencida, necesita actualizarla ya que sino lo hace, quedará bloquedo dentro de " + 15 - this.DIASVENCIDOS + " días.</center></html>");
/* 4533 */       this.jDialog8.setVisible(true);
/* 4534 */     } else if (this.DIASVENCIDOS > 15) {
/* 4535 */       this.jDialog8.setTitle("Licencia Vencida");
/* 4536 */       this.jLabel97.setText("Operador Bloqueado");
/* 4537 */       this.jLabel98.setText("<html><center>LICENCIA VENCIDA.</center></html>");
/* 4538 */       this.jLabel99.setText("<html><center>El operador ha sido bloqueado por no actualizar su licencia, no se podrá dar viajes hasta que refrende éste documento.</center></html>");
/* 4539 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 4545 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4547 */             Datos.this.jTextGanado(Datos.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4551 */             Datos.this.jTextPerdido(Datos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 4554 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4556 */             Datos.this.jTextGanado(Datos.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4560 */             Datos.this.jTextPerdido(Datos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 4563 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4565 */             Datos.this.jTextGanado(Datos.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4569 */             Datos.this.jTextPerdido(Datos.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 4572 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4574 */             Datos.this.jTextGanado(Datos.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4578 */             Datos.this.jTextPerdido(Datos.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 4581 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4583 */             Datos.this.jTextGanado(Datos.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4587 */             Datos.this.jTextPerdido(Datos.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */     
/* 4591 */     this.jComboBox17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4593 */             Datos.this.jTextGanado(Datos.this.jComboBox17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4597 */             Datos.this.jTextPerdido(Datos.this.jComboBox17, evt);
/*      */           }
/*      */         });
/* 4600 */     this.jTextField94.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4602 */             Datos.this.jTextGanado(Datos.this.jTextField94, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4606 */             Datos.this.jTextPerdido(Datos.this.jTextField94, evt);
/*      */           }
/*      */         });
/*      */     
/* 4610 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4612 */             Datos.this.jTextGanado(Datos.this.jTextField19, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4616 */             Datos.this.jTextPerdido(Datos.this.jTextField19, evt);
/*      */           }
/*      */         });
/*      */     
/* 4620 */     this.jTextField95.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4622 */             Datos.this.jTextGanado(Datos.this.jTextField95, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4626 */             Datos.this.jTextPerdido(Datos.this.jTextField95, evt);
/*      */           }
/*      */         });
/* 4629 */     this.jTextField96.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4631 */             Datos.this.jTextGanado(Datos.this.jTextField96, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4635 */             Datos.this.jTextPerdido(Datos.this.jTextField96, evt);
/*      */           }
/*      */         });
/* 4638 */     this.jTextField97.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4640 */             Datos.this.jTextGanado(Datos.this.jTextField97, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4644 */             Datos.this.jTextPerdido(Datos.this.jTextField97, evt);
/*      */           }
/*      */         });
/*      */     
/* 4648 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4650 */             Datos.this.jTextGanado(Datos.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4654 */             Datos.this.jTextPerdido(Datos.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 4657 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4659 */             Datos.this.jTextGanado(Datos.this.jPasswordField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4663 */             Datos.this.jTextPerdido(Datos.this.jPasswordField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 4667 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4669 */             Datos.this.jTextGanado(Datos.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4673 */             Datos.this.jTextPerdido(Datos.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 4676 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4678 */             Datos.this.jTextGanado(Datos.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4682 */             Datos.this.jTextPerdido(Datos.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 4685 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4687 */             Datos.this.jTextGanado(Datos.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4691 */             Datos.this.jTextPerdido(Datos.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 4694 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4696 */             Datos.this.jTextGanado(Datos.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4700 */             Datos.this.jTextPerdido(Datos.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 4703 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4705 */             Datos.this.jTextGanado(Datos.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4709 */             Datos.this.jTextPerdido(Datos.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 4712 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4714 */             Datos.this.jTextGanado(Datos.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4718 */             Datos.this.jTextPerdido(Datos.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 4721 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4723 */             Datos.this.jTextGanado(Datos.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4727 */             Datos.this.jTextPerdido(Datos.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 4730 */     this.jComboBox18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4732 */             Datos.this.jTextGanado(Datos.this.jComboBox18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4736 */             Datos.this.jTextPerdido(Datos.this.jComboBox18, evt);
/*      */           }
/*      */         });
/* 4739 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4741 */             Datos.this.jTextGanado(Datos.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4745 */             Datos.this.jTextPerdido(Datos.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 4748 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4750 */             Datos.this.jTextGanado(Datos.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4754 */             Datos.this.jTextPerdido(Datos.this.jTextField18, evt);
/*      */           }
/*      */         });
/*      */     
/* 4758 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4760 */             Datos.this.jTextGanado(Datos.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4764 */             Datos.this.jTextPerdido(Datos.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 4767 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4769 */             Datos.this.jTextGanado(Datos.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4773 */             Datos.this.jTextPerdido(Datos.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 4776 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4778 */             Datos.this.jTextGanado(Datos.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4782 */             Datos.this.jTextPerdido(Datos.this.jComboBox8, evt);
/*      */           }
/*      */         });
/* 4785 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4787 */             Datos.this.jTextGanado(Datos.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4791 */             Datos.this.jTextPerdido(Datos.this.jComboBox9, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4797 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4801 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void llenarCombo(String clave) {
/* 4805 */     String consulta = "";
/* 4806 */     if (clave.equals("13") || clave.equals("5")) {
/* 4807 */       consulta = " (clave_gene = 13 || clave_gene=5)";
/* 4808 */     } else if (clave.equals("29") || clave.equals("39") || clave.equals("44")) {
/* 4809 */       consulta = " (clave_gene = 29 || clave_gene=39 || clave_gene=44)";
/* 4810 */     } else if (clave.equals("87") || clave.equals("136") || clave.equals("128")) {
/* 4811 */       consulta = " (clave_gene = 87 || clave_gene=136)";
/* 4812 */     } else if (clave.equals("85") || clave.equals("81") || clave.equals("86")) {
/* 4813 */       consulta = " (clave_gene = 85 || clave_gene=81 || clave_gene=86)";
/*      */     } else {
/* 4815 */       consulta = "clave_gene =  " + clave;
/*      */     } 
/*      */     
/* 4818 */     String[] plataformas = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 and " + consulta + " order by equipo");
/*      */     
/* 4820 */     this.jComboBox1.removeAllItems();
/* 4821 */     this.jComboBox1.addItem("Selecciona uno...");
/* 4822 */     for (int i = 0; i < plataformas.length; i++) {
/* 4823 */       this.jComboBox1.addItem(plataformas[i]);
/*      */     }
/*      */     
/* 4826 */     this.encontrado = this.con.consultar("count(numLinea)", "lineas", "where cliente ='" + String.valueOf(this.jComboBox9.getSelectedItem()) + "' and estatus='ACTIVA'");
/* 4827 */     if (!this.con.Campo.equals("0")) {
/* 4828 */       String[] lineas = this.con.regresaCol("Linea", "lineas", "where cliente ='" + String.valueOf(this.jComboBox9.getSelectedItem()) + "' and estatus='ACTIVA'", Integer.parseInt(this.con.Campo));
/* 4829 */       this.jComboBox17.removeAllItems();
/* 4830 */       this.jComboBox17.addItem("<VACÍA>");
/* 4831 */       for (int j = 0; j < lineas.length; j++) {
/* 4832 */         this.jComboBox17.addItem(lineas[j]);
/*      */       }
/* 4834 */       this.jComboBox17.setEnabled(true);
/* 4835 */       this.jLabel108.setEnabled(true);
/*      */     } else {
/* 4837 */       this.jComboBox17.setEnabled(false);
/* 4838 */       this.jLabel108.setEnabled(false);
/* 4839 */       this.jComboBox17.removeAllItems();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombo2() {
/* 4844 */     String equipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 4845 */     String num_equipo = "";
/* 4846 */     this.encontrado = this.con.consultar("equipos.num_equipo", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/* 4847 */     num_equipo = this.con.Campo;
/* 4848 */     if (equipo.equals("WEATHERFORD") || equipo.equals("PMX") || equipo.equals("Q-MAX") || equipo.equals("SLB") || equipo.equals("ZAPATA") || equipo.equals("CALFRAC") || equipo.equals("BAKER") || equipo.equals("HALLIBURTON") || equipo.equals("KOMLINE") || equipo.equals("BAKER") || equipo.equals("BAKER OP") || equipo.equals("BJ SERVICES") || equipo.equals("SAESA") || equipo.equals("MI SWACO") || equipo.equals("PETRO-SPM") || equipo.equals("DRAKE") || equipo.equals("CLEANMEX") || equipo.equals("KEY") || equipo.equals("PETROINTEGRAL") || equipo.equals("FORZA API") || equipo.equals("COMESA") || equipo.equals("INTERMODAL") || equipo.equals("OPERACIONES PETROLERAS SOLEDAD") || equipo.equals("EQUIPAMENTO LATINA") || equipo.equals("BASE LATINA") || equipo.equals("PERFORADORA LATINA") || equipo.equals("DIAVAZ CAMPO ÉBANO") || equipo.equals("DIAVAZ") || equipo.equals("SERVICIOS PJP4") || equipo.equals("AGMARK")) {
/* 4849 */       this.encontrado = this.con.consultar("num_plata", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/* 4850 */       if (this.encontrado) {
/* 4851 */         activar();
/*      */ 
/*      */         
/* 4854 */         if (equipo.equals("HALLIBURTON") || equipo.equals("SERVICIOS PJP4")) {
/* 4855 */           equipo = "'HALLIBURTON' or equipo='SERVICIOSPJP4')";
/*      */         } else {
/* 4857 */           equipo = "'" + equipo + "')";
/*      */         } 
/* 4859 */         String[] totR = this.con.regresaColIndex("plataforma", "plataformas,equipo_plataforma,equipos", "where equipo_plataforma.num_plata = plataformas.num_plata and equipo_plataforma.num_equipo = equipos.num_equipo and (equipo = " + equipo + " order by plataforma"); int i;
/* 4860 */         for (i = 0; i < totR.length; i++)
/*      */         {
/* 4862 */           this.jComboBox2.addItem(totR[i]);
/*      */         }
/* 4864 */         this.jComboBox3.removeAllItems();
/* 4865 */         for (i = 0; i < this.POZOS.length; i++) {
/* 4866 */           this.jComboBox3.addItem(this.POZOS[i]);
/*      */ 
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 4875 */         limpiar();
/*      */       } 
/*      */     } else {
/* 4878 */       this.encontrado = this.con.consultar("num_plata", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/* 4879 */       if (this.encontrado) {
/* 4880 */         this.con.consultar("plataforma", "plataformas", "where num_plata = " + this.con.Campo);
/* 4881 */         String plataforma = this.con.Campo;
/* 4882 */         this.jComboBox2.addItem(plataforma);
/* 4883 */         this.jComboBox2.setEnabled(true);
/* 4884 */         this.con.consultar("num_plata", "plataformas", "where plataforma = '" + plataforma + "'");
/* 4885 */         String num_plata = this.con.Campo;
/* 4886 */         this.encontrado = this.con.consultar("nombre", "pozos,equipo_plataforma", "where pozos.num = equipo_plataforma.num and estado ='EN PERFORACIÓN' and  num_plata = " + num_plata + " and num_equipo = " + num_equipo);
/* 4887 */         if (this.encontrado) {
/* 4888 */           this.jComboBox3.removeAllItems();
/* 4889 */           this.jComboBox3.addItem(this.con.Campo);
/* 4890 */           this.jComboBox3.setEnabled(true);
/* 4891 */           activar();
/*      */         } else {
/* 4893 */           this.jComboBox3.removeAllItems();
/* 4894 */           this.jComboBox3.setEnabled(false);
/* 4895 */           limpiar();
/*      */         } 
/*      */       } else {
/* 4898 */         limpiar();
/* 4899 */         if (this.jComboBox1.getSelectedIndex() > 0) {
/* 4900 */           JOptionPane.showMessageDialog(this.padre, "El equipo aún no tiene ninguna plataforma asignada por favor verifica tu información", "Plataforma No Asignada", 0, this.ERROR);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombo3() {
/* 4907 */     String[][] datos = this.con.buscarDatos(7, "clave_gene,empresa,calle,ciudad,num,col,rfc", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by empresa");
/* 4908 */     this.clavesGene = new String[datos.length];
/* 4909 */     this.empresasGene = new String[datos.length];
/* 4910 */     this.domicilioGene = new String[datos.length];
/* 4911 */     this.ciudadesGene = new String[datos.length];
/* 4912 */     this.numeroGene = new String[datos.length];
/* 4913 */     this.coloniaGene = new String[datos.length];
/* 4914 */     this.rfcGene = new String[datos.length]; int i;
/* 4915 */     for (i = 0; i < datos.length; i++) {
/* 4916 */       for (int k = 0; k < (datos[i]).length; k++) {
/* 4917 */         if (k == 0) {
/* 4918 */           this.clavesGene[i] = datos[i][k];
/*      */         }
/* 4920 */         if (k == 1) {
/* 4921 */           this.empresasGene[i] = datos[i][k];
/*      */         }
/* 4923 */         if (k == 2) {
/* 4924 */           this.domicilioGene[i] = datos[i][k];
/*      */         }
/* 4926 */         if (k == 3) {
/* 4927 */           this.ciudadesGene[i] = datos[i][k];
/*      */         }
/* 4929 */         if (k == 4) {
/* 4930 */           this.numeroGene[i] = datos[i][k];
/*      */         }
/* 4932 */         if (k == 5) {
/* 4933 */           this.coloniaGene[i] = datos[i][k];
/*      */         }
/* 4935 */         if (k == 6) {
/* 4936 */           this.rfcGene[i] = datos[i][k];
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 4941 */     datos = this.con.buscarDatos(9, "clave_desti,empresa,calle,num,col,ciudad,rfc,monto,letra", "emp_destinataria", "where clave_desti<>0 order by empresa");
/* 4942 */     this.clavesDesti = new String[datos.length];
/* 4943 */     this.empresasDesti = new String[datos.length];
/* 4944 */     this.domicilioDesti = new String[datos.length];
/* 4945 */     this.numeroDesti = new String[datos.length];
/* 4946 */     this.coloniaDesti = new String[datos.length];
/* 4947 */     this.ciudadesDesti = new String[datos.length];
/* 4948 */     this.rfcDesti = new String[datos.length];
/* 4949 */     this.montoDesti = new String[datos.length];
/* 4950 */     this.letraDesti = new String[datos.length];
/*      */     
/* 4952 */     for (i = 0; i < datos.length; i++) {
/* 4953 */       for (int k = 0; k < (datos[i]).length; k++) {
/* 4954 */         if (k == 0) {
/* 4955 */           this.clavesDesti[i] = datos[i][k];
/*      */         }
/* 4957 */         if (k == 1) {
/* 4958 */           this.empresasDesti[i] = datos[i][k];
/*      */         }
/* 4960 */         if (k == 2) {
/* 4961 */           this.domicilioDesti[i] = datos[i][k];
/*      */         }
/* 4963 */         if (k == 3) {
/* 4964 */           this.numeroDesti[i] = datos[i][k];
/*      */         }
/* 4966 */         if (k == 4) {
/* 4967 */           this.coloniaDesti[i] = datos[i][k];
/*      */         }
/* 4969 */         if (k == 5) {
/* 4970 */           this.ciudadesDesti[i] = datos[i][k];
/*      */         }
/* 4972 */         if (k == 6) {
/* 4973 */           this.rfcDesti[i] = datos[i][k];
/*      */         }
/* 4975 */         if (k == 7) {
/* 4976 */           this.montoDesti[i] = datos[i][k];
/*      */         }
/* 4978 */         if (k == 8) {
/* 4979 */           this.letraDesti[i] = datos[i][k];
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 4984 */     this.jComboBox6.removeAllItems();
/* 4985 */     this.jComboBox6.addItem("Selecciona uno...");
/* 4986 */     for (i = 0; i < this.clavesGene.length; i++) {
/* 4987 */       this.jComboBox6.addItem(this.empresasGene[i]);
/*      */     }
/*      */     
/* 4990 */     this.jComboBox9.removeAllItems();
/* 4991 */     this.jComboBox9.addItem("Selecciona uno...");
/* 4992 */     for (i = 0; i < this.clavesGene.length; i++) {
/* 4993 */       this.jComboBox9.addItem(this.empresasGene[i]);
/*      */     }
/*      */     
/* 4996 */     this.jComboBox7.removeAllItems();
/* 4997 */     this.jComboBox7.addItem("Selecciona uno...");
/* 4998 */     for (i = 0; i < this.clavesDesti.length; i++) {
/* 4999 */       this.jComboBox7.addItem(this.empresasDesti[i]);
/*      */     }
/*      */     
/* 5002 */     String[] estadosDif = this.con.regresaColIndex("distinct(estado)", "tracto", "order by estado");
/* 5003 */     this.jComboBox18.removeAllItems();
/* 5004 */     for (int j = 0; j < estadosDif.length; j++) {
/* 5005 */       this.jComboBox18.addItem(estadosDif[j]);
/*      */     }
/* 5007 */     this.jComboBox18.addItem("TODOS");
/* 5008 */     this.jComboBox18.setSelectedItem("ACTIVO");
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 5012 */     Date fecha = new Date();
/* 5013 */     int hora = fecha.getHours();
/* 5014 */     int min = fecha.getMinutes();
/* 5015 */     int seg = fecha.getSeconds();
/* 5016 */     String hh = "" + hora;
/* 5017 */     String mm = "" + min;
/* 5018 */     if (hora < 10) {
/* 5019 */       hh = "0" + hh;
/*      */     }
/* 5021 */     if (min < 10) {
/* 5022 */       mm = "0" + min;
/*      */     }
/* 5024 */     this.jTextField3.setText(hh + ":" + hh);
/*      */     
/* 5026 */     if (this.jComboBox1.getSelectedIndex() > 0) {
/* 5027 */       this.jComboBox1.setSelectedIndex(0);
/*      */     }
/*      */     
/* 5030 */     this.jComboBox2.removeAllItems();
/* 5031 */     this.jComboBox4.setSelectedIndex(0);
/* 5032 */     this.jComboBox2.setEnabled(false);
/* 5033 */     this.jComboBox3.removeAllItems();
/* 5034 */     this.jComboBox3.setEnabled(false);
/*      */     
/* 5036 */     this.jComboBox4.setEnabled(false);
/* 5037 */     this.jDateChooser2.setEnabled(false);
/* 5038 */     this.jTextField3.setEnabled(false);
/* 5039 */     this.jLabel10.setEnabled(false);
/* 5040 */     this.jLabel3.setEnabled(false);
/* 5041 */     this.jLabel5.setEnabled(false);
/* 5042 */     this.jLabel6.setEnabled(false);
/* 5043 */     this.jLabel7.setEnabled(false);
/* 5044 */     this.jLabel8.setEnabled(false);
/*      */     
/* 5046 */     this.jLabel9.setEnabled(false);
/* 5047 */     this.jSlider1.setEnabled(false);
/* 5048 */     this.jSlider1.setValue(5);
/* 5049 */     this.jTextField3.setEnabled(false);
/* 5050 */     this.jSpinner1.setEnabled(false);
/* 5051 */     this.jSpinner1.setValue(Integer.valueOf(1));
/*      */   }
/*      */   
/*      */   public void activar() {
/* 5055 */     this.jComboBox4.setEnabled(true);
/* 5056 */     this.jDateChooser2.setEnabled(true);
/* 5057 */     this.jTextField3.setEnabled(true);
/* 5058 */     this.jTextField3.setEnabled(true);
/*      */     
/* 5060 */     this.jLabel10.setEnabled(true);
/* 5061 */     this.jLabel3.setEnabled(true);
/* 5062 */     this.jLabel5.setEnabled(true);
/* 5063 */     this.jLabel6.setEnabled(true);
/* 5064 */     this.jLabel7.setEnabled(true);
/* 5065 */     this.jLabel9.setEnabled(true);
/* 5066 */     this.jLabel8.setEnabled(true);
/* 5067 */     this.jSlider1.setEnabled(true);
/* 5068 */     this.jSpinner1.setEnabled(true);
/* 5069 */     this.jComboBox3.setEnabled(true);
/* 5070 */     this.jComboBox2.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 5074 */     this.PRIMERA = true;
/* 5075 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 5076 */           .buscarDatos(11, "num_llama,equipo,plataforma,nombre,residuo,fecha_ped,ingreso,prioridad,empresa,linea,nombre_usu", "equipos," + this.TABLA + ",plataformas,pozos,emp_generadora", "where " + this.TABLA + ".clave_gene = emp_generadora.clave_gene and " + this.TABLA + ".num_equipo = equipos.num_equipo and " + this.TABLA + ".num_plata = plataformas.num_plata and " + this.TABLA + ".num_pozo = pozos.num_pozo and uso = 0 order by prioridad desc,num_llama asc"), (Object[])new String[] { "ID", "Equipo", "Plataforma", "Pozo", "Residuo", "F. del Pedido", "Ingreso", "Prioridad", "Cliente", "Linea", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 5081 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5086 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 5090 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 5091 */     this.jScrollPane17.setViewportView((Component)this.rSTableMetro1);
/* 5092 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 5093 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 5094 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 5095 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 5096 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(90);
/* 5097 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(90);
/* 5098 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 5099 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(70);
/* 5100 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(100);
/* 5101 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(100);
/* 5102 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(100);
/* 5103 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(100);
/* 5104 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(60);
/* 5105 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(60);
/*      */     
/* 5107 */     this.rSTableMetro1.setSelectionMode(0);
/* 5108 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 5109 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 5111 */     CeldaRender celda = new CeldaRender();
/* 5112 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(celda);
/* 5113 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(celda);
/* 5114 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(celda);
/* 5115 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(celda);
/* 5116 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(celda);
/* 5117 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(celda);
/* 5118 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(celda);
/* 5119 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(celda);
/* 5120 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(celda);
/* 5121 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(celda);
/* 5122 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(celda);
/* 5123 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar2() {
/* 5128 */     String consulta = "";
/* 5129 */     this.materialButton11.setEnabled(false);
/* 5130 */     String num_ope = this.jTextField12.getText();
/*      */     
/* 5132 */     if (this.PRIVILEGIO.equals("SUPER USUARIO")) {
/* 5133 */       consulta = "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField13.getText() + "%' and actual = 0 order by nombre";
/*      */     }
/* 5135 */     else if (this.jComboBox8.getSelectedIndex() == 2 || this.jComboBox8.getSelectedIndex() == 5 || this.jComboBox8.getSelectedIndex() == 6) {
/* 5136 */       consulta = "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField13.getText() + "%' and actual = 0  order by nombre";
/* 5137 */     } else if (this.jComboBox8.getSelectedIndex() == 3) {
/* 5138 */       consulta = "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField13.getText() + "%' and actual = 0 and asignacion='RENTAS' order by nombre";
/* 5139 */     } else if (this.jComboBox8.getSelectedIndex() == 4) {
/* 5140 */       consulta = "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField13.getText() + "%' and actual = 0 and asignacion='RETROS' order by nombre";
/*      */     } 
/*      */     
/* 5143 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con
/* 5144 */           .buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", consulta), (Object[])new String[] { "Núm", "Nombre", "Apellido Paterno", "Apellido Materno" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 5149 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5154 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5157 */     eliminarColumna(2, 1, "Apellido Paterno");
/* 5158 */     eliminarColumna(2, 1, "Apellido Materno");
/*      */     
/* 5160 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 5161 */     this.jScrollPane19.setViewportView((Component)this.rSTableMetro3);
/* 5162 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 5163 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 5165 */     this.rSTableMetro3.setSelectionMode(0);
/* 5166 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 5167 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 5169 */     CeldaRender2 celda = new CeldaRender2();
/* 5170 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(celda);
/* 5171 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(celda);
/* 5172 */     this.rSTableMetro3.setGridColor(new Color(200, 200, 200));
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 5176 */     this.entraCombo3 = true;
/* 5177 */     this.materialButton13.setEnabled(false);
/* 5178 */     String num_ope = this.jTextField15.getText();
/*      */ 
/*      */     
/* 5181 */     String estado = "";
/* 5182 */     if (!this.jComboBox18.getSelectedItem().toString().equals("TODOS")) {
/* 5183 */       estado = this.jComboBox18.getSelectedItem().toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5195 */     this.jLabel126.setText("" + this.rSTableMetro4.getRowCount());
/*      */   }
/*      */   
/*      */   public void consultar4() {
/* 5199 */     String tipo = "";
/* 5200 */     String combo = String.valueOf(this.jComboBox5.getSelectedItem());
/* 5201 */     tipo = this.jTextField19.getText();
/*      */     
/* 5203 */     this.materialButton14.setEnabled(false);
/* 5204 */     String num_ope = this.jTextField17.getText();
/* 5205 */     String placas = this.jTextField18.getText();
/* 5206 */     this.rSTableMetro5.setModel(new DefaultTableModel((Object[][])this.con
/* 5207 */           .buscarDatos(5, "num_rem,placas,modelo,no_serie,tipo", "remolque", "where num_rem<>0 and num_rem like '%" + num_ope + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%'"), (Object[])new String[] { "Núm", "Placas", "Modelo", "No. Serie", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 5212 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5217 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5220 */     this.rSTableMetro5.setShowVerticalLines(false);
/* 5221 */     this.jScrollPane21.setViewportView((Component)this.rSTableMetro5);
/* 5222 */     this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 5223 */     this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 5225 */     this.rSTableMetro5.getColumnModel().getColumn(2).setPreferredWidth(60);
/* 5226 */     this.rSTableMetro5.getColumnModel().getColumn(2).setMaxWidth(60);
/*      */     
/* 5228 */     this.rSTableMetro5.setSelectionMode(0);
/* 5229 */     this.rSTableMetro5.setAutoCreateRowSorter(true);
/* 5230 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 5232 */     CeldaRender2 celda = new CeldaRender2();
/* 5233 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(celda);
/* 5234 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(celda);
/* 5235 */     this.rSTableMetro5.getColumnModel().getColumn(2).setCellRenderer(celda);
/* 5236 */     this.rSTableMetro5.getColumnModel().getColumn(3).setCellRenderer(celda);
/* 5237 */     this.rSTableMetro5.getColumnModel().getColumn(4).setCellRenderer(celda);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 5241 */     int cont = this.rSTableMetro3.getRowCount();
/* 5242 */     String[] registros = new String[cont]; int i;
/* 5243 */     for (i = 0; i < cont; i++) {
/* 5244 */       registros[i] = this.rSTableMetro3.getValueAt(i, destino).toString();
/*      */     }
/* 5246 */     for (i = 0; i < cont; i++) {
/* 5247 */       registros[i] = registros[i] + " " + registros[i];
/* 5248 */       this.rSTableMetro3.setValueAt(registros[i], i, destino);
/*      */     } 
/* 5250 */     TableColumn columna = this.rSTableMetro3.getColumn(nombreCol);
/* 5251 */     this.rSTableMetro3.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void cargarPerfil() {
/* 5255 */     this.con.consultar("departamentos.nombre", "usuarios,empleados,departamentos", "where empleados.clave_depa = departamentos.clave_depa and empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 5256 */     if (this.con.Campo.equals("TRÁFICO PIPAS")) {
/* 5257 */       this.jComboBox5.removeAllItems();
/* 5258 */       this.jComboBox5.addItem("PIPA");
/* 5259 */       this.TABLA = "llamadas_pipas";
/* 5260 */       this.jComboBox5.setEnabled(false);
/* 5261 */       this.materialButton10.setEnabled(true);
/*      */       
/* 5263 */       this.jComboBox1.setEnabled(false);
/* 5264 */       this.jComboBox4.removeAllItems();
/* 5265 */       this.jComboBox4.addItem("SELECCIONA UNO...");
/* 5266 */       this.jComboBox4.addItem("ACEITE ESTABILIZADO");
/* 5267 */       this.jComboBox4.addItem("ACIDO CLORHIDRICO");
/* 5268 */       this.jComboBox4.addItem("ACIDOS VARIOS");
/* 5269 */       this.jComboBox4.addItem("AGUA DE FRACTURA");
/* 5270 */       this.jComboBox4.addItem("AGUA RESIDUAL");
/* 5271 */       this.jComboBox4.addItem("AGUA CONTAMINADA");
/* 5272 */       this.jComboBox4.addItem("AGUA CONTAMINADA C/HIDROCARBUROS");
/* 5273 */       this.jComboBox4.addItem("AGUAS OLEOSAS");
/* 5274 */       this.jComboBox4.addItem("AROMINA");
/* 5275 */       this.jComboBox4.addItem("BASURA CONTAMINADA");
/* 5276 */       this.jComboBox4.addItem("FLUIDO DE BAJA");
/* 5277 */       this.jComboBox4.addItem("FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE FORMACION");
/* 5278 */       this.jComboBox4.addItem("FLUIDO RECUPERADO");
/* 5279 */       this.jComboBox4.addItem("FLUIDO RECUPERADO C/TRAZAS DE ACEITE");
/* 5280 */       this.jComboBox4.addItem("FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS");
/* 5281 */       this.jComboBox4.addItem("HIDROCARBURO");
/* 5282 */       this.jComboBox4.addItem("MATERIAL QUIMICO");
/* 5283 */       this.jComboBox4.addItem("LODOS ACEITOSOS");
/* 5284 */       this.jComboBox4.addItem("LODO BASE ACEITE");
/* 5285 */       this.jComboBox4.addItem("LODO BASE AGUA");
/* 5286 */       this.jComboBox4.addItem("LODOS CONTAMINADOS PROVENIENTES DEL SIAC TAJÍN 5");
/* 5287 */       this.jComboBox4.addItem("LODOS RESIDUALES");
/* 5288 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION");
/* 5289 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE");
/* 5290 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE AGUA");
/* 5291 */       this.jComboBox4.addItem("REMANENTE");
/* 5292 */       this.jComboBox4.addItem("REMANENTE IMPREGNABLE");
/* 5293 */       this.jComboBox4.addItem("PRODUCTO QUIMICO MA-2");
/* 5294 */       this.jComboBox4.addItem("SALMUERA");
/* 5295 */       this.jComboBox4.addItem("SEDIMENTO DE LIMPIEZA DE PRESAS");
/* 5296 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON HIDROCARBUROS");
/* 5297 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON FLUIDO BASE AGUA");
/* 5298 */       this.jComboBox4.addItem("SOLVENTES");
/* 5299 */       this.jComboBox4.addItem("TIERRA IMPREGNADA CON HIDROCARBUROS");
/* 5300 */       this.jComboBox4.addItem("FLETES - VARIOS");
/* 5301 */     } else if (this.con.Campo.equals("TRÁFICO GÓNDOLAS")) {
/* 5302 */       this.jComboBox5.removeAllItems();
/* 5303 */       this.jComboBox5.addItem("GÓNDOLA");
/*      */       
/* 5305 */       this.TABLA = "llamadas_gondolas";
/*      */       
/* 5307 */       this.materialButton10.setEnabled(true);
/*      */       
/* 5309 */       this.jComboBox1.setEnabled(false);
/* 5310 */       this.jComboBox4.removeAllItems();
/* 5311 */       this.jComboBox4.addItem("SELECCIONA UNO...");
/* 5312 */       this.jComboBox4.addItem("ACEITE ESTABILIZADO");
/* 5313 */       this.jComboBox4.addItem("ACIDO CLORHIDRICO");
/* 5314 */       this.jComboBox4.addItem("ACIDOS VARIOS");
/* 5315 */       this.jComboBox4.addItem("AGUA CONTAMINADA");
/* 5316 */       this.jComboBox4.addItem("AGUA CONTAMINADA C/HIDROCARBUROS");
/* 5317 */       this.jComboBox4.addItem("AGUAS OLEOSAS");
/* 5318 */       this.jComboBox4.addItem("AROMINA");
/* 5319 */       this.jComboBox4.addItem("ARENA SILICA");
/* 5320 */       this.jComboBox4.addItem("BASURA CONTAMINADA");
/* 5321 */       this.jComboBox4.addItem("BARITA");
/* 5322 */       this.jComboBox4.addItem("CAJAS DE RECORTE DE PERFORACION");
/* 5323 */       this.jComboBox4.addItem("CEMENTO");
/* 5324 */       this.jComboBox4.addItem("FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE FORMACION");
/* 5325 */       this.jComboBox4.addItem("FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS");
/* 5326 */       this.jComboBox4.addItem("HERRAMIENTAS");
/* 5327 */       this.jComboBox4.addItem("HIDROCARBURO");
/* 5328 */       this.jComboBox4.addItem("MATERIAL QUIMICO");
/* 5329 */       this.jComboBox4.addItem("MINERAL HIERRO");
/* 5330 */       this.jComboBox4.addItem("LODOS ACEITOSOS");
/* 5331 */       this.jComboBox4.addItem("LODOS RESIDUALES");
/* 5332 */       this.jComboBox4.addItem("RECORTE DE PERFORACION BASE ACEITE");
/* 5333 */       this.jComboBox4.addItem("RECORTE BASE AGUA");
/* 5334 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION");
/* 5335 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE");
/* 5336 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE AGUA");
/* 5337 */       this.jComboBox4.addItem("REMANENTE");
/* 5338 */       this.jComboBox4.addItem("REMANENTE IMPREGNABLE");
/* 5339 */       this.jComboBox4.addItem("PRODUCTO QUIMICO MA-2");
/* 5340 */       this.jComboBox4.addItem("SANEAMIENTO");
/* 5341 */       this.jComboBox4.addItem("SEDIMENTO DE LIMPIEZA DE PRESAS");
/* 5342 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON HIDROCARBUROS");
/* 5343 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON FLUIDO BASE AGUA");
/* 5344 */       this.jComboBox4.addItem("SOLVENTES");
/* 5345 */       this.jComboBox4.addItem("TIERRA IMPREGNADA CON HIDROCARBUROS");
/* 5346 */       this.jComboBox4.addItem("TIERRA CONTAMINADA (SANEAMIENTO)");
/* 5347 */       this.jComboBox4.addItem("SEDIMENTO");
/* 5348 */       this.jComboBox4.addItem("TRANSPORTE");
/*      */       
/* 5350 */       this.jComboBox4.addItem("FLETES - VARIOS");
/*      */     } else {
/* 5352 */       this.jComboBox5.setEnabled(true);
/* 5353 */       this.jComboBox5.removeAllItems();
/* 5354 */       this.jComboBox5.addItem("PIPA");
/* 5355 */       this.jComboBox5.addItem("GÓNDOLA");
/* 5356 */       this.TABLA = "llamadas_pipas";
/* 5357 */       this.materialButton10.setEnabled(false);
/* 5358 */       this.jComboBox1.setEnabled(false);
/* 5359 */       this.jComboBox4.removeAllItems();
/* 5360 */       this.jComboBox4.addItem("SELECCIONA UNO...");
/* 5361 */       this.jComboBox4.addItem("ACEITE ESTABILIZADO");
/* 5362 */       this.jComboBox4.addItem("ACIDO CLORHIDRICO");
/* 5363 */       this.jComboBox4.addItem("ACIDOS VARIOS");
/* 5364 */       this.jComboBox4.addItem("AGUA DE FRACTURA");
/* 5365 */       this.jComboBox4.addItem("AGUA RESIDUAL");
/* 5366 */       this.jComboBox4.addItem("AGUA CONTAMINADA");
/* 5367 */       this.jComboBox4.addItem("AGUA CONTAMINADA C/HIDROCARBUROS");
/* 5368 */       this.jComboBox4.addItem("AGUAS OLEOSAS");
/* 5369 */       this.jComboBox4.addItem("ARENA SILICA");
/* 5370 */       this.jComboBox4.addItem("AROMINA");
/* 5371 */       this.jComboBox4.addItem("BASURA CONTAMINADA");
/* 5372 */       this.jComboBox4.addItem("BARITA");
/* 5373 */       this.jComboBox4.addItem("CAJAS DE RECORTE DE PERFORACION");
/* 5374 */       this.jComboBox4.addItem("CEMENTO");
/* 5375 */       this.jComboBox4.addItem("FLUIDO DE BAJA");
/* 5376 */       this.jComboBox4.addItem("FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE FORMACION");
/* 5377 */       this.jComboBox4.addItem("FLUIDO RECUPERADO");
/* 5378 */       this.jComboBox4.addItem("FLUIDO RECUPERADO C/TRAZAS DE ACEITE");
/* 5379 */       this.jComboBox4.addItem("FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS");
/* 5380 */       this.jComboBox4.addItem("HERRAMIENTAS");
/* 5381 */       this.jComboBox4.addItem("HIDROCARBURO");
/* 5382 */       this.jComboBox4.addItem("MATERIAL QUIMICO");
/* 5383 */       this.jComboBox4.addItem("LODOS ACEITOSOS");
/* 5384 */       this.jComboBox4.addItem("LODO BASE ACEITE");
/* 5385 */       this.jComboBox4.addItem("LODO BASE AGUA");
/* 5386 */       this.jComboBox4.addItem("LODOS CONTAMINADOS PROVENIENTES DEL SIAC TAJÍN 5");
/* 5387 */       this.jComboBox4.addItem("LODOS RESIDUALES");
/* 5388 */       this.jComboBox4.addItem("MINERAL HIERRO");
/* 5389 */       this.jComboBox4.addItem("RECORTE DE PERFORACION BASE ACEITE");
/* 5390 */       this.jComboBox4.addItem("RECORTE BASE AGUA");
/* 5391 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION");
/* 5392 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE");
/* 5393 */       this.jComboBox4.addItem("RESIDUOS ADICIONALES A LA PERFORACION DE AGUA");
/* 5394 */       this.jComboBox4.addItem("REMANENTE");
/* 5395 */       this.jComboBox4.addItem("REMANENTE IMPREGNABLE");
/* 5396 */       this.jComboBox4.addItem("PRODUCTO QUIMICO MA-2");
/* 5397 */       this.jComboBox4.addItem("SALMUERA");
/* 5398 */       this.jComboBox4.addItem("SANEAMIENTO");
/* 5399 */       this.jComboBox4.addItem("SEDIMENTO DE LIMPIEZA DE PRESAS");
/* 5400 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON HIDROCARBUROS");
/* 5401 */       this.jComboBox4.addItem("SÓLIDOS CONTAMINADOS CON FLUIDO BASE AGUA");
/* 5402 */       this.jComboBox4.addItem("SOLVENTES");
/* 5403 */       this.jComboBox4.addItem("TIERRA IMPREGNADA CON HIDROCARBUROS");
/* 5404 */       this.jComboBox4.addItem("TIERRA CONTAMINADA (SANEAMIENTO)");
/* 5405 */       this.jComboBox4.addItem("SEDIMENTO");
/* 5406 */       this.jComboBox4.addItem("TRANSPORTE");
/*      */ 
/*      */       
/* 5409 */       this.jComboBox4.addItem("FLETES - VARIOS");
/*      */     } 
/* 5411 */     this.jComboBox1.setEnabled(false);
/* 5412 */     this.materialButton10.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void limpiar2() {
/* 5417 */     this.jLabel34.setText("Aquí se muestra el origen");
/* 5418 */     this.jLabel35.setText("Aquí se muestra el domicilio");
/* 5419 */     this.jLabel36.setText("Aquí se muestra la colonia");
/* 5420 */     this.jLabel37.setText("Aquí se muestra el R.F.C");
/*      */   }
/*      */   
/*      */   public void limpiar3() {
/* 5424 */     this.jLabel38.setText("Aquí se muestra el origen");
/* 5425 */     this.jLabel39.setText("Aquí se muestra el domicilio");
/* 5426 */     this.jLabel40.setText("Aquí se muestra la colonia");
/* 5427 */     this.jLabel41.setText("Aquí se muestra el R.F.C");
/* 5428 */     this.jLabel50.setText("0.00");
/* 5429 */     this.jLabel51.setText("0.00");
/* 5430 */     this.jLabel54.setText("0.00");
/* 5431 */     this.jLabel61.setText("");
/*      */   }
/*      */   
/*      */   public void limpiarGuia() {
/* 5435 */     this.jTextField89.setText("");
/* 5436 */     this.jTextField92.setText("");
/* 5437 */     sacarMayor();
/* 5438 */     this.jLabel42.setText("ECONÓMICO Y PLACAS");
/* 5439 */     this.jLabel43.setText("NÚMERO Y PLACAS");
/* 5440 */     this.jLabel44.setText("AQUÍ SE CARGA EL OPERADOR");
/* 5441 */     this.jComboBox7.setSelectedIndex(0);
/* 5442 */     this.jComboBox8.setSelectedIndex(0);
/* 5443 */     this.jTextArea1.setText("");
/* 5444 */     limpiar3();
/*      */     
/* 5446 */     this.clavesDesti = this.con.regresaColIndex("clave_desti", "emp_destinataria", "where clave_desti<>0 order by empresa");
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 5450 */     String motivo = this.jTextField14.getText();
/* 5451 */     if (motivo.equals("")) {
/* 5452 */       this.error.cargarError(this.jTextField14, "050");
/* 5453 */     } else if (!this.val.validarApostrofe(this.jTextField14, motivo, "020")) {
/* 5454 */       int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cancelar la llamada?", "Cancelar Llamada", 0, 3, this.PREG);
/* 5455 */       if (res == 0) {
/* 5456 */         String todos = "NO ASIGNADO POR CANCELACIÓN";
/* 5457 */         String[] llamadas = this.con.regresaReg("num_llama,residuo,fecha_ped,ingreso,prioridad,num_equipo,num_plata,num_pozo,clave_gene", this.TABLA, "where num_llama = " + this.CLAVE, 9);
/* 5458 */         this.con.inserSinMsj("insert into llamadas_historicas (residuo,fecha_ped,ingreso,prioridad,descrip,estado,comen,num_equipo,num_plata,num_pozo,nombre_usu,num_guia,num_ope,clave_gene,clave_desti,num_tracto,num_rem)values('" + llamadas[1] + "','" + llamadas[2] + "','" + llamadas[3] + "'," + llamadas[4] + ",'" + todos + "','CANCELADA/" + this.USUARIO + " ','" + this.jTextField14.getText().toUpperCase() + "'," + llamadas[5] + "," + llamadas[6] + "," + llamadas[7] + ",'" + this.USUARIO + "', 0,0," + llamadas[8] + ",0,0,0)");
/* 5459 */         this.con.eliminar2(this.TABLA, "where num_llama = " + this.CLAVE);
/* 5460 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Canceló la llamada: " + this.CLAVE + "','')");
/* 5461 */         JOptionPane.showMessageDialog(this.jDialog3, "La llamada que seleccionaste se ha cancelado satisfactoriamente", "Llamadas Cancelada", 0, this.INFO);
/* 5462 */         consultar();
/* 5463 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarToneladas() {
/* 5469 */     if (this.PESOESTIMADO > 30.0D) {
/* 5470 */       this.PESOESTIMADO = 24.73D;
/*      */     } else {
/* 5472 */       this.PESOESTIMADO += 0.23D;
/*      */     } 
/* 5474 */     String reducir = "" + this.PESOESTIMADO;
/* 5475 */     String cantidad = "";
/* 5476 */     int cont = 0;
/* 5477 */     for (int i = 0; i < 5; i++) {
/* 5478 */       cantidad = cantidad + cantidad;
/*      */     }
/* 5480 */     this.jLabel59.setText(cantidad + " TONS.");
/* 5481 */     this.CANTIDAD = cantidad;
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 5485 */     this.con.consultar("max(num)", "guias", "");
/* 5486 */     String mayor = this.con.Campo;
/* 5487 */     int MAYOR = Integer.parseInt(mayor);
/* 5488 */     MAYOR++;
/* 5489 */     if (MAYOR < 100) {
/* 5490 */       this.jTextField2.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/* 5491 */     } else if (MAYOR < 1000) {
/* 5492 */       this.jTextField2.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/* 5493 */     } else if (MAYOR < 10000) {
/* 5494 */       this.jTextField2.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/* 5496 */       this.jTextField2.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   class CeldaRender extends DefaultTableCellRenderer { int otro; int[] indices;
/*      */     
/*      */     CeldaRender() {
/* 5502 */       this.otro = -1;
/* 5503 */       this.indices = new int[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5506 */       setEnabled((table == null || table.isEnabled()));
/* 5507 */       if (comparar(row)) {
/* 5508 */         setBackground(Color.red);
/* 5509 */       } else if (row % 2 == 0) {
/* 5510 */         setBackground((Color)null);
/*      */       } else {
/* 5512 */         setBackground(Datos.this.lc.FONDOTABLA);
/*      */       } 
/* 5514 */       setForeground(Datos.this.lc.SECUNDARIO1);
/* 5515 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5516 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(int[] ind) {
/* 5520 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(int reg) {
/* 5524 */       for (int i = 0; i < this.indices.length; i++) {
/* 5525 */         if (this.indices[i] == reg) {
/* 5526 */           return true;
/*      */         }
/*      */       } 
/* 5529 */       return false;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     int[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 5535 */       this.otro = -1;
/* 5536 */       this.indices = new int[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5539 */       setEnabled((table == null || table.isEnabled()));
/* 5540 */       if (row % 2 == 0) {
/* 5541 */         setBackground((Color)null);
/*      */       } else {
/* 5543 */         setBackground(Datos.this.lc.FONDOTABLA);
/*      */       } 
/* 5545 */       setForeground(Datos.this.lc.SECUNDARIO1);
/* 5546 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5547 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   public void cargarViaje() {
/* 5552 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 5553 */     if (indice < 0) {
/* 5554 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una llamada para que se pueda asignar el viaje", "Selecciona una llamada", 0, this.ERROR);
/*      */     } else {
/* 5556 */       this.CLAVE = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 5557 */       this.con.consultar("uso", this.TABLA, "where num_llama= " + this.CLAVE);
/* 5558 */       String uso = this.con.Campo;
/* 5559 */       if (uso.equals("1") || uso.equals(null)) {
/* 5560 */         JOptionPane.showMessageDialog(this.padre, "Selecciona otro pedido ya que fue expedido esta guía", "Seleeciona otro", 0, this.ADVER);
/*      */       } else {
/*      */         
/* 5563 */         this.jLabel91.setVisible(false);
/* 5564 */         this.jLabel55.setVisible(false);
/* 5565 */         this.jCheckBox1.setSelected(true);
/* 5566 */         this.jLabel95.setText(String.valueOf(this.jComboBox5.getSelectedItem()));
/* 5567 */         sacarMayor();
/* 5568 */         this.con.consultar("fecha_ped", this.TABLA, "where num_llama = " + this.CLAVE);
/* 5569 */         String año = this.con.Campo.substring(0, 4);
/* 5570 */         String mes = this.con.Campo.substring(5, 7);
/* 5571 */         String dia = this.con.Campo.substring(8, 10);
/* 5572 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 5573 */         String strFecha = dia + "-" + dia + "-" + mes;
/* 5574 */         Date fecha = null;
/*      */         try {
/* 5576 */           fecha = formatoDelTexto.parse(strFecha);
/* 5577 */         } catch (ParseException ex) {
/* 5578 */           ex.printStackTrace();
/*      */         } 
/* 5580 */         Calendar ahoraCal = Calendar.getInstance();
/* 5581 */         ahoraCal.setTime(fecha);
/* 5582 */         String mesesito = "";
/* 5583 */         String hoy = "";
/* 5584 */         mesesito = "" + ahoraCal.get(2) + 1;
/* 5585 */         hoy = "" + ahoraCal.get(5);
/* 5586 */         if (ahoraCal.get(2) + 1 < 10) {
/* 5587 */           mesesito = "0" + mesesito;
/*      */         }
/* 5589 */         if (ahoraCal.get(5) < 10) {
/* 5590 */           hoy = "0" + hoy;
/*      */         }
/* 5592 */         this.jLabel12.setText(hoy + "/" + hoy + "/" + mesesito);
/* 5593 */         this.FECHAAÑO = ahoraCal.get(1);
/* 5594 */         this.FECHAMES = Integer.parseInt(mesesito);
/* 5595 */         limpiar();
/* 5596 */         this.jComboBox6.setSelectedIndex(0);
/* 5597 */         this.jComboBox7.setSelectedIndex(0);
/*      */         
/* 5599 */         String tipo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */ 
/*      */         
/* 5602 */         String[] val = this.con.regresaReg("claveOP,operador,eco,num", "formacion", "where tipo='" + tipo + "' and activo=1 and estatus='EN ESPERA' order by num asc", 4);
/* 5603 */         this.NUMFORMA = val[3];
/*      */         
/* 5605 */         if (this.NUMFORMA == null) {
/* 5606 */           JOptionPane.showMessageDialog(this.jDialog1, "Te falta activar un operador dentro de la formación.", "Cambiar de estatus", 2, this.ERROR);
/*      */           
/*      */           return;
/*      */         } 
/* 5610 */         this.con.inserSinMsj("update " + this.TABLA + " set uso = 1 where num_llama = " + this.CLAVE);
/* 5611 */         this.con.consultar("residuo", this.TABLA, "where num_llama = " + this.CLAVE);
/* 5612 */         this.jLabel29.setText(this.con.Campo);
/* 5613 */         String todo = "";
/* 5614 */         todo = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/* 5615 */         todo = todo + " - " + todo;
/* 5616 */         this.EQUIPOS = new String[] { String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)), String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)), String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3)) };
/* 5617 */         this.jLabel49.setText(todo);
/* 5618 */         this.jLabel33.setText("POZO: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3)));
/* 5619 */         this.POZOM = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3));
/* 5620 */         this.POZO = this.jLabel33.getText();
/* 5621 */         sacarToneladas();
/* 5622 */         this.jComboBox6.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 8));
/* 5623 */         this.jComboBox6.setEnabled(false);
/* 5624 */         this.LINEA = String.valueOf(this.rSTableMetro1.getValueAt(indice, 9));
/* 5625 */         consultar();
/* 5626 */         consultar2();
/* 5627 */         consultar3();
/* 5628 */         consultar4();
/* 5629 */         limpiarGuia();
/* 5630 */         sacarMayor();
/* 5631 */         this.jLabel29.setToolTipText(this.jLabel29.getText());
/*      */         
/* 5633 */         this.CLAVEOP = val[0];
/* 5634 */         this.jLabel44.setText(val[1]);
/*      */         
/* 5636 */         String[] conte = this.con.regresaReg("num_tracto,placas", "tracto", "where num_tracto =" + val[2], 2);
/* 5637 */         this.PLACAS[0] = conte[0];
/* 5638 */         this.PLACAS[1] = conte[1];
/* 5639 */         this.jLabel42.setText("  " + conte[0] + "        " + conte[1]);
/*      */         
/* 5641 */         this.con.inserSinMsj("update formacion set activo=2 where num =" + this.NUMFORMA);
/* 5642 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String sacarNumManifiesto() {
/* 5648 */     String mesesito = "" + this.FECHAMES;
/* 5649 */     if (this.FECHAMES < 10) {
/* 5650 */       mesesito = "0" + mesesito;
/*      */     }
/* 5652 */     this.con.consultar("count(conse)", "manifiestos", "");
/* 5653 */     String numero = "";
/* 5654 */     this.con.consultar("max(conse)", "guias,manifiestos,llamadas_historicas", "where year(fecha_ped)= '" + this.FECHAAÑO + "' and month(fecha_ped)= '" + mesesito + "' and guias.num_guia = manifiestos.num_guia and guias.num_guia = llamadas_historicas.num_guia");
/* 5655 */     if (this.con.Campo == null) {
/* 5656 */       this.MAYOR = 0;
/*      */     } else {
/* 5658 */       this.MAYOR = Integer.parseInt(this.con.Campo);
/*      */     } 
/* 5660 */     this.MAYOR++;
/* 5661 */     if (this.MAYOR < 10) {
/* 5662 */       numero = "00" + this.MAYOR;
/* 5663 */     } else if (this.MAYOR < 100) {
/* 5664 */       numero = "0" + this.MAYOR;
/*      */     } else {
/* 5666 */       numero = "" + this.MAYOR;
/*      */     } 
/* 5668 */     int corto = this.ahoraCal.get(1);
/* 5669 */     corto -= 2000;
/* 5670 */     String componer = "" + corto + corto + "-" + mesesito;
/* 5671 */     this.CARPETA = "" + corto + corto;
/* 5672 */     return componer;
/*      */   }
/*      */   
/*      */   public void cargarPozos() {
/* 5676 */     this.POZOS = this.con.regresaColIndex("nombre", "pozos", "order by nombre");
/*      */   }
/*      */   
/*      */   public class CeldaRender3
/*      */     extends DefaultTableCellRenderer {
/* 5681 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5684 */       setEnabled((table == null || table.isEnabled()));
/* 5685 */       if (row % 2 == 0) {
/* 5686 */         setBackground((Color)null);
/*      */       } else {
/* 5688 */         setBackground(Datos.this.lc.FONDOTABLA);
/*      */       } 
/* 5690 */       setForeground(Datos.this.lc.SECUNDARIO1);
/* 5691 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5692 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class PresionadoServicios
/*      */     implements Runnable {
/*      */     Thread t;
/* 5699 */     int cont = 0;
/*      */     
/*      */     public PresionadoServicios() {
/* 5702 */       this.t = new Thread(this);
/* 5703 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5711 */         Datos.this.jLabel207.setVisible(true);
/* 5712 */         Datos.this.jLabel207.setText("Buscando datos, por favor espere...");
/* 5713 */         Datos.this.setCursor(new Cursor(3));
/* 5714 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5715 */         detener();
/* 5716 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 5721 */       Datos.this.llenarCatServicios();
/* 5722 */       Datos.this.setCursor(Datos.this.micursor2);
/* 5723 */       Datos.this.jLabel207.setVisible(false);
/* 5724 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 5728 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   public class PresionadoUnidades
/*      */     implements Runnable {
/*      */     Thread t;
/* 5735 */     int cont = 0;
/*      */     
/*      */     public PresionadoUnidades() {
/* 5738 */       this.t = new Thread(this);
/* 5739 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5747 */         Datos.this.jLabel210.setVisible(true);
/* 5748 */         Datos.this.jLabel210.setText("Buscando datos, por favor espere...");
/* 5749 */         Datos.this.setCursor(new Cursor(3));
/* 5750 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5751 */         detener();
/* 5752 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 5757 */       Datos.this.llenarCatUnidades();
/* 5758 */       Datos.this.setCursor(Datos.this.micursor2);
/* 5759 */       Datos.this.jLabel210.setVisible(false);
/* 5760 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 5764 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   class EnviandoCorreo
/*      */   {
/*      */     private String clave;
/*      */     private String[] DIRECCIONES;
/*      */     private String[] COPIAS;
/*      */     
/*      */     public EnviandoCorreo(String clave, String[] DIRECCIONES, String[] COPIAS) {
/* 5775 */       this.clave = clave;
/* 5776 */       this.DIRECCIONES = DIRECCIONES;
/* 5777 */       this.COPIAS = COPIAS;
/*      */       try {
/* 5779 */         Properties props = new Properties();
/*      */         
/* 5781 */         props.setProperty("mail.smtp.host", "smtp.gmail.com");
/* 5782 */         props.setProperty("mail.smtp.starttls.enable", "true");
/* 5783 */         props.setProperty("mail.smtp.port", "587");
/* 5784 */         props.setProperty("mail.smtp.user", "forsis4@gmail.com");
/* 5785 */         props.setProperty("mail.smtp.auth", "true");
/*      */         
/* 5787 */         MimeBodyPart mimeBodyPart = new MimeBodyPart();
/* 5788 */         mimeBodyPart.setContent(((DatosEnviarCorreo)Datos.this.enviar.get(clave)).getContenido(), "text/html");
/*      */         
/* 5790 */         Session session = Session.getDefaultInstance(props);
/*      */ 
/*      */         
/* 5793 */         MimeMessage message = new MimeMessage(session);
/* 5794 */         message.setFrom((Address)new InternetAddress("forsis4@gmail.com"));
/*      */         
/* 5796 */         MimeMultipart multiParte = new MimeMultipart();
/* 5797 */         multiParte.addBodyPart((BodyPart)mimeBodyPart);
/*      */ 
/*      */         
/* 5800 */         Address[] direccion = new Address[DIRECCIONES.length];
/* 5801 */         for (int i = 0; i < DIRECCIONES.length; i++) {
/* 5802 */           direccion[i] = (Address)new InternetAddress(DIRECCIONES[i]);
/*      */         }
/*      */         
/* 5805 */         Address[] copias = new Address[COPIAS.length];
/* 5806 */         for (int j = 0; j < COPIAS.length; j++) {
/* 5807 */           copias[j] = (Address)new InternetAddress(COPIAS[j]);
/*      */         }
/* 5809 */         message.addRecipients(Message.RecipientType.TO, direccion);
/* 5810 */         message.addRecipients(Message.RecipientType.CC, copias);
/*      */         
/* 5812 */         message.setSubject(((DatosEnviarCorreo)Datos.this.enviar.get(clave)).getAsunto());
/* 5813 */         message.setContent((Multipart)multiParte);
/*      */         
/* 5815 */         Transport t = session.getTransport("smtp");
/*      */         
/* 5817 */         t.connect("forsis4@gmail.com", "dpceabhsjgudkusm");
/* 5818 */         t.sendMessage((Message)message, message.getAllRecipients());
/* 5819 */         t.close();
/* 5820 */         System.out.println("Aviso Enviado!");
/* 5821 */       } catch (Exception e) {
/* 5822 */         e.printStackTrace();
/* 5823 */         System.out.println("ERROR al Enviar " + String.valueOf(e));
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Datos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */