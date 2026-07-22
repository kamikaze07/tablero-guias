/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class Liquidaciones extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   40 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   41 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   42 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   43 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   44 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   45 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   46 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   47 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   48 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   50 */   Validaciones val = new Validaciones();
/*   51 */   Consultas con = new Consultas();
/*   52 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   56 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   59 */   Date fechaActual = new Date();
/*   60 */   Date fecha = new Date();
/*   61 */   Date fechaInicio = null;
/*   62 */   Date fechaTermino = null;
/*   63 */   Date fechaMinimo = null;
/*   64 */   CeldaRender celda = new CeldaRender();
/*      */   
/*   66 */   CeldaRender3 celda3 = new CeldaRender3();
/*   67 */   String CLAVEOP = "";
/*   68 */   String AUXDIESEL = "";
/*      */   String[] operadores;
/*   70 */   String NOMBRE = "";
/*   71 */   String[] GUIAS = new String[100];
/*   72 */   String CLAVE = "";
/*      */   boolean CONCEPTO = false;
/*   74 */   int INDICE = 0;
/*   75 */   String[] DIRECTIVA = null;
/*   76 */   String[] REGISTROS = null;
/*   77 */   String OPERADOR = "";
/*   78 */   String cadFechaActual = "";
/*   79 */   DefaultTableModel MODELODIESEL = new DefaultTableModel();
/*   80 */   DefaultTableModel MODELOPREMIOS = new DefaultTableModel();
/*   81 */   DefaultTableModel MODELOGASTOS = new DefaultTableModel();
/*   82 */   DefaultTableModel MODELOVIAJES = new DefaultTableModel();
/*   83 */   double[] VALORDIESEL = new double[800];
/*   84 */   double[] VALORPREMIOS = new double[800];
/*   85 */   double[] VALORGASTOS = new double[800];
/*   86 */   double[] AUTOPISTAS = new double[800];
/*   87 */   double[] PROPINAS = new double[800];
/*   88 */   double[] LLANTAS = new double[800];
/*   89 */   double[] PRECIODIESEL = new double[800];
/*      */   
/*   91 */   double GASTOSASIG = 0.0D;
/*   92 */   double SUBTOTAL = 0.0D;
/*   93 */   double DIFGAST = 0.0D;
/*   94 */   double DIFGASTORIGINAL = 0.0D;
/*   95 */   double NETO = 0.0D;
/*   96 */   double SALDOTD = 0.0D;
/*   97 */   double SOLOGASTOS = 0.0D;
/*   98 */   double GASTOSTOTAL = 0.0D;
/*   99 */   double VIAJESFORANEOS = 0.0D;
/*  100 */   double IMPUESTOS = 0.0D;
/*  101 */   double RENTA = 0.0D;
/*  102 */   double DIESELCONTRA = 0.0D;
/*  103 */   double PREMIOS = 0.0D;
/*  104 */   double BAUTOPISTAS = 0.0D;
/*  105 */   double BLLANTAS = 0.0D;
/*  106 */   double BPROPINAS = 0.0D;
/*  107 */   double DIESEL = 0.0D;
/*      */   boolean esModifi = false;
/*      */   boolean ESMODIFICA = false;
/*  110 */   double[] RENDIMIENTOS = new double[20];
/*  111 */   double DIESELCONSUMIDO = 0.0D;
/*  112 */   double DIESELCOMPROBADO = 0.0D;
/*  113 */   double KMAUX = 0.0D;
/*      */   
/*  115 */   double KM = 0.0D;
/*  116 */   double KMLT = 0.0D;
/*  117 */   double LITROS = 0.0D;
/*  118 */   double TONS = 0.0D;
/*  119 */   String CLAVEORIGINAL = "";
/*  120 */   int NUMLINEAS = 0;
/*  121 */   String base = "";
/*  122 */   MensajePop mensajeTry = null;
/*  123 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   boolean consultarOperadores = false;
/*  126 */   Map<String, String> GUIASFECHA = new TreeMap<>(); private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton39; private JButton jButton4; private JButton jButton40; private JButton jButton41; private JButton jButton42; private JButton jButton43; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox7; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog12; private JDialog jDialog13; private JDialog jDialog14; private JDialog jDialog15; private JDialog jDialog16; private JDialog jDialog17; private JDialog jDialog18; private JDialog jDialog19; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField10; private JFormattedTextField jFormattedTextField11; private JFormattedTextField jFormattedTextField12; private JFormattedTextField jFormattedTextField13; private JFormattedTextField jFormattedTextField14; private JFormattedTextField jFormattedTextField15; private JFormattedTextField jFormattedTextField16; private JFormattedTextField jFormattedTextField17; private JFormattedTextField jFormattedTextField18; private JFormattedTextField jFormattedTextField19; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField20; private JFormattedTextField jFormattedTextField21; private JFormattedTextField jFormattedTextField22; private JFormattedTextField jFormattedTextField23; private JFormattedTextField jFormattedTextField24; private JFormattedTextField jFormattedTextField25; private JFormattedTextField jFormattedTextField26; private JFormattedTextField jFormattedTextField27; private JFormattedTextField jFormattedTextField28; private JFormattedTextField jFormattedTextField29; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField8; private JFormattedTextField jFormattedTextField9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel157; private JLabel jLabel158; private JLabel jLabel159; private JLabel jLabel16; private JLabel jLabel160; private JLabel jLabel161; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35;
/*      */   private JLabel jLabel36;
/*      */   private JLabel jLabel37;
/*      */   private JLabel jLabel38;
/*      */   
/*      */   public Liquidaciones(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  132 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  133 */     this.mensajeTry = mensajeTry;
/*  134 */     String año = "2010";
/*  135 */     String mes = "06";
/*  136 */     String dia = "01";
/*  137 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  138 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  140 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  141 */     } catch (ParseException ex) {
/*  142 */       ex.printStackTrace();
/*      */     } 
/*  144 */     this.padre = padre;
/*  145 */     this.fichas = fichas;
/*  146 */     initComponents();
/*  147 */     this.USUARIO = USUARIO;
/*  148 */     panelito.setViewportView(this);
/*  149 */     this.panel = panelito;
/*      */     
/*  151 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  152 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  153 */     this.jDialog1.setCursor(micursor);
/*  154 */     this.jDialog2.setCursor(micursor);
/*  155 */     this.jDialog3.setCursor(micursor);
/*  156 */     this.jDialog4.setCursor(micursor);
/*  157 */     this.jDialog5.setCursor(micursor);
/*  158 */     this.jDialog6.setCursor(micursor);
/*  159 */     this.jDialog11.setCursor(micursor);
/*  160 */     this.jDialog12.setCursor(micursor);
/*  161 */     this.jDialog13.setCursor(micursor);
/*      */     
/*  163 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  164 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  165 */     this.jLabel1.setCursor(micursor);
/*  166 */     this.jLabel7.setCursor(micursor);
/*  167 */     this.jLabel8.setCursor(micursor);
/*  168 */     this.jLabel9.setCursor(micursor);
/*  169 */     this.jLabel53.setCursor(micursor);
/*      */     
/*  171 */     int w = this.tama.width;
/*  172 */     int h = this.tama.height;
/*  173 */     int rw = (w - 810) / 2;
/*  174 */     int rh = (h - 650) / 2;
/*  175 */     this.jDialog1.setLocation(rw, rh);
/*  176 */     this.jDialog1.setSize(810, 650);
/*  177 */     this.jDialog1.setVisible(false);
/*  178 */     this.jDialog1.setResizable(false);
/*      */     
/*  180 */     rw = (w - 650) / 2;
/*  181 */     rh = (h - 380) / 2;
/*  182 */     this.jDialog2.setLocation(rw, rh);
/*  183 */     this.jDialog2.setSize(650, 380);
/*  184 */     this.jDialog2.setVisible(false);
/*  185 */     this.jDialog2.setResizable(false);
/*  186 */     colorear();
/*      */     
/*  188 */     rw = (w - 890) / 2;
/*  189 */     rh = (h - 400) / 2;
/*  190 */     this.jDialog3.setLocation(rw, rh);
/*  191 */     this.jDialog3.setSize(890, 400);
/*  192 */     this.jDialog3.setVisible(false);
/*  193 */     this.jDialog3.setResizable(false);
/*      */     
/*  195 */     rw = (w - 375) / 2;
/*  196 */     rh = (h - 590) / 2;
/*  197 */     this.jDialog4.setLocation(rw, rh);
/*  198 */     this.jDialog4.setSize(375, 457);
/*  199 */     this.jDialog4.setVisible(false);
/*  200 */     this.jDialog4.setResizable(false);
/*      */     
/*  202 */     rw = (w - 435) / 2;
/*  203 */     rh = (h - 350) / 2;
/*  204 */     this.jDialog5.setLocation(rw, rh);
/*  205 */     this.jDialog5.setSize(435, 350);
/*  206 */     this.jDialog5.setVisible(false);
/*  207 */     this.jDialog5.setResizable(false);
/*      */     
/*  209 */     rw = (w - 435) / 2;
/*  210 */     rh = (h - 300) / 2;
/*  211 */     this.jDialog6.setLocation(rw, rh);
/*  212 */     this.jDialog6.setSize(435, 300);
/*  213 */     this.jDialog6.setVisible(false);
/*  214 */     this.jDialog6.setResizable(false);
/*      */     
/*  216 */     rw = (w - 490) / 2;
/*  217 */     rh = (h - 355) / 2;
/*  218 */     this.jDialog7.setLocation(rw, rh);
/*  219 */     this.jDialog7.setSize(490, 355);
/*  220 */     this.jDialog7.setVisible(false);
/*  221 */     this.jDialog7.setResizable(false);
/*      */     
/*  223 */     rw = (w - 400) / 2;
/*  224 */     rh = (h - 270) / 2;
/*  225 */     this.jDialog11.setLocation(rw, rh);
/*  226 */     this.jDialog11.setSize(400, 270);
/*  227 */     this.jDialog11.setVisible(false);
/*  228 */     this.jDialog11.setResizable(false);
/*      */     
/*  230 */     rw = (w - 400) / 2;
/*  231 */     rh = (h - 270) / 2;
/*  232 */     this.jDialog12.setLocation(rw, rh);
/*  233 */     this.jDialog12.setSize(400, 270);
/*  234 */     this.jDialog12.setVisible(false);
/*  235 */     this.jDialog12.setResizable(false);
/*      */     
/*  237 */     rw = (w - 435) / 2;
/*  238 */     rh = (h - 380) / 2;
/*  239 */     this.jDialog13.setLocation(rw, rh);
/*  240 */     this.jDialog13.setSize(435, 380);
/*  241 */     this.jDialog13.setVisible(false);
/*  242 */     this.jDialog13.setResizable(false);
/*      */     
/*  244 */     rw = (w - 425) / 2;
/*  245 */     rh = (h - 380) / 2;
/*  246 */     this.jDialog14.setVisible(false);
/*  247 */     this.jDialog14.setLocation(rw, rh);
/*  248 */     this.jDialog14.setSize(425, 380);
/*      */     
/*  250 */     rw = (w - 425) / 2;
/*  251 */     rh = (h - 380) / 2;
/*  252 */     this.jDialog15.setVisible(false);
/*  253 */     this.jDialog15.setLocation(rw, rh);
/*  254 */     this.jDialog15.setSize(425, 380);
/*      */     
/*  256 */     rw = (w - 390) / 2;
/*  257 */     rh = (h - 120) / 2;
/*  258 */     this.jDialog16.setVisible(false);
/*  259 */     this.jDialog16.setLocation(rw, rh);
/*  260 */     this.jDialog16.setSize(390, 120);
/*      */     
/*  262 */     rw = (w - 390) / 2;
/*  263 */     rh = (h - 120) / 2;
/*  264 */     this.jDialog17.setVisible(false);
/*  265 */     this.jDialog17.setLocation(rw, rh);
/*  266 */     this.jDialog17.setSize(290, 120);
/*      */     
/*  268 */     rw = (w - 390) / 2;
/*  269 */     rh = (h - 230) / 2;
/*  270 */     this.jDialog19.setLocation(rw, rh);
/*  271 */     this.jDialog19.setSize(390, 230);
/*  272 */     this.jDialog19.setVisible(false);
/*  273 */     this.jDialog19.setResizable(false);
/*      */     
/*  275 */     rw = (w - 290) / 2;
/*  276 */     rh = (h - 620) / 2;
/*  277 */     this.jDialog18.setLocation(rw, rh);
/*  278 */     this.jDialog18.setSize(290, 630);
/*  279 */     this.jDialog18.setVisible(false);
/*  280 */     this.jDialog18.setResizable(false);
/*      */     
/*  282 */     this.jDialog8.setSize(435, 355);
/*  283 */     this.jDialog9.setSize(435, 355);
/*  284 */     this.jDialog10.setSize(435, 355);
/*      */     
/*  286 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  287 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  288 */     editFormat.setGroupingUsed(false);
/*  289 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  290 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  291 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  292 */     enFormat.setAllowsInvalid(true);
/*  293 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  294 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  295 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  296 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  297 */     this.jFormattedTextField5.setFormatterFactory(currFactory);
/*  298 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*  299 */     this.jFormattedTextField7.setFormatterFactory(currFactory);
/*  300 */     this.jFormattedTextField8.setFormatterFactory(currFactory);
/*  301 */     this.jFormattedTextField9.setFormatterFactory(currFactory);
/*  302 */     this.jFormattedTextField10.setFormatterFactory(currFactory);
/*  303 */     this.jFormattedTextField11.setFormatterFactory(currFactory);
/*  304 */     this.jFormattedTextField12.setFormatterFactory(currFactory);
/*  305 */     this.jFormattedTextField13.setFormatterFactory(currFactory);
/*  306 */     this.jFormattedTextField14.setFormatterFactory(currFactory);
/*      */     
/*  308 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  309 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  310 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  311 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*  312 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/*  313 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*  314 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/*  315 */     this.jFormattedTextField8.setValue(Integer.valueOf(0));
/*  316 */     this.jFormattedTextField9.setValue(Integer.valueOf(0));
/*  317 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*  318 */     this.jFormattedTextField11.setValue(Integer.valueOf(0));
/*  319 */     this.jFormattedTextField12.setValue(Integer.valueOf(0));
/*  320 */     this.jFormattedTextField13.setValue(Integer.valueOf(0));
/*  321 */     this.jFormattedTextField14.setValue(Integer.valueOf(0));
/*      */     
/*  323 */     if (!entradaPrincipal) {
/*  324 */       this.USUARIO = USUARIO;
/*  325 */       String[] nomComp = { CAMPOSGENERALES.get("empleados.nombre").toString(), CAMPOSGENERALES.get("empleados.ap_pat").toString(), CAMPOSGENERALES.get("empleados.ap_mat").toString() };
/*  326 */       this.NOMBRE = nomComp[0] + " " + nomComp[0] + " " + nomComp[1];
/*      */       
/*  328 */       consultarLiq();
/*      */     } 
/*  330 */     this.DIRECTIVA = new String[] { CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("diesel").toString(), CAMPOSGENERALES.get("renta").toString(), CAMPOSGENERALES.get("sucursal").toString() };
/*  331 */     this.AUXDIESEL = this.DIRECTIVA[1];
/*  332 */     cargarFechaHoy();
/*  333 */     this.MODELODIESEL = new DefaultTableModel();
/*  334 */     this.jTable1.setModel(this.MODELODIESEL);
/*  335 */     this.jTable6.setModel(this.MODELOPREMIOS);
/*  336 */     this.jTable4.setModel(this.MODELOVIAJES);
/*      */     
/*  338 */     this.MODELOPREMIOS.addColumn("Concepto");
/*  339 */     this.MODELOPREMIOS.addColumn("Cantidad");
/*      */     
/*  341 */     this.MODELOGASTOS.addColumn("Concepto");
/*  342 */     this.MODELOGASTOS.addColumn("Folio");
/*  343 */     this.MODELOGASTOS.addColumn("Fecha");
/*  344 */     this.MODELOGASTOS.addColumn("Cantidad");
/*  345 */     this.buttonGroup1.add(this.jRadioButton1);
/*  346 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  348 */     this.jTable7.setModel(this.MODELOGASTOS);
/*  349 */     this.jTable7.getColumnModel().getColumn(1).setMinWidth(85);
/*  350 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(85);
/*  351 */     this.jTable7.getColumnModel().getColumn(2).setMinWidth(80);
/*  352 */     this.jTable7.getColumnModel().getColumn(2).setMaxWidth(80);
/*  353 */     this.jTable7.getColumnModel().getColumn(3).setMinWidth(60);
/*  354 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(60);
/*      */     
/*  356 */     this.jTable6.getColumnModel().getColumn(1).setMinWidth(100);
/*  357 */     this.jTable6.getColumnModel().getColumn(1).setMaxWidth(100);
/*      */     
/*  359 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  360 */     String cadenaFecha2 = formato.format(this.fechaActual);
/*  361 */     año = cadenaFecha2.substring(0, 4);
/*  362 */     mes = cadenaFecha2.substring(4, 6);
/*  363 */     dia = cadenaFecha2.substring(6, 8);
/*  364 */     this.cadFechaActual = año + "-" + año + "-" + mes;
/*      */     
/*  366 */     this.buttonGroup2.add(this.jRadioButton3);
/*  367 */     this.buttonGroup2.add(this.jRadioButton4);
/*  368 */     llenarCombo2();
/*      */     
/*  370 */     this.RENTA = Double.parseDouble(this.DIRECTIVA[2]);
/*  371 */     this.jLabel6.setVisible(true);
/*  372 */     this.jLabel10.setVisible(true);
/*  373 */     this.jLabel11.setVisible(true);
/*      */     
/*  375 */     String[] rend = this.con.regresaReg("valor0,valor1,valor2,valor3,valor4,valor5,valor6,valor7,valor8,valor9,valor10,valor11,valor12,valor13", "rendimiento", "", 14);
/*  376 */     for (int i = 0; i < rend.length; i++) {
/*  377 */       this.RENDIMIENTOS[i] = Double.parseDouble(rend[i]);
/*      */     }
/*      */     
/*  380 */     this.base = this.DIRECTIVA[3];
/*      */     
/*  382 */     this.jFormattedTextField15.setValue(Double.valueOf(this.RENDIMIENTOS[0]));
/*  383 */     this.jFormattedTextField16.setValue(Double.valueOf(this.RENDIMIENTOS[1]));
/*  384 */     this.jFormattedTextField17.setValue(Double.valueOf(this.RENDIMIENTOS[2]));
/*  385 */     this.jFormattedTextField18.setValue(Double.valueOf(this.RENDIMIENTOS[3]));
/*  386 */     this.jFormattedTextField19.setValue(Double.valueOf(this.RENDIMIENTOS[4]));
/*  387 */     this.jFormattedTextField20.setValue(Double.valueOf(this.RENDIMIENTOS[5]));
/*  388 */     this.jFormattedTextField21.setValue(Double.valueOf(this.RENDIMIENTOS[6]));
/*  389 */     this.jFormattedTextField22.setValue(Double.valueOf(this.RENDIMIENTOS[7]));
/*  390 */     this.jFormattedTextField23.setValue(Double.valueOf(this.RENDIMIENTOS[8]));
/*  391 */     this.jFormattedTextField24.setValue(Double.valueOf(this.RENDIMIENTOS[9]));
/*  392 */     this.jFormattedTextField25.setValue(Double.valueOf(this.RENDIMIENTOS[10]));
/*  393 */     this.jFormattedTextField26.setValue(Double.valueOf(this.RENDIMIENTOS[11]));
/*  394 */     this.jFormattedTextField27.setValue(Double.valueOf(this.RENDIMIENTOS[12]));
/*  395 */     this.jFormattedTextField28.setValue(Double.valueOf(this.RENDIMIENTOS[13]));
/*  396 */     this.jFormattedTextField29.setValue(Double.valueOf(this.RENDIMIENTOS[14]));
/*  397 */     this.jButton18.setVisible(false);
/*      */     
/*  399 */     privilegios();
/*      */   }
/*      */   private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JScrollPane jScrollPane16; private JScrollPane jScrollPane17; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator12; private JSeparator jSeparator13; private JSeparator jSeparator14; private JSeparator jSeparator15; private JSeparator jSeparator19; private JSeparator jSeparator2; private JSeparator jSeparator20; private JSeparator jSeparator21; private JSeparator jSeparator22; private JSeparator jSeparator23; private JSeparator jSeparator24; private JSeparator jSeparator25; private JSeparator jSeparator26; private JSeparator jSeparator27; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTable jTable1; private JTable jTable10; private JTable jTable11; private JTable jTable12; private JTable jTable13; private JTable jTable14; private JTable jTable15; private JTable jTable16; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTable jTable7; private JTable jTable8; private JTable jTable9; private JTextArea jTextArea1; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  404 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  405 */     this.jPanel4 = new JPanel();
/*  406 */     this.jLabel1 = new JLabel();
/*  407 */     this.jSeparator1 = new JSeparator();
/*  408 */     this.jLabel68 = new JLabel();
/*  409 */     this.jTextField61 = new JTextField();
/*  410 */     this.jLabel71 = new JLabel();
/*  411 */     this.jLabel72 = new JLabel();
/*  412 */     this.jTextField2 = new JTextField();
/*  413 */     this.jPanel37 = new JPanel();
/*  414 */     this.jScrollPane4 = new JScrollPane();
/*  415 */     this.jTable4 = new JTable();
/*  416 */     this.jLabel6 = new JLabel();
/*  417 */     this.jLabel10 = new JLabel();
/*  418 */     this.jLabel11 = new JLabel();
/*  419 */     this.jLabel12 = new JLabel();
/*  420 */     this.jLabel14 = new JLabel();
/*  421 */     this.jLabel154 = new JLabel();
/*  422 */     this.jButton7 = new JButton();
/*  423 */     this.jButton9 = new JButton();
/*  424 */     this.jPanel38 = new JPanel();
/*  425 */     this.jButton10 = new JButton();
/*  426 */     this.jLabel94 = new JLabel();
/*  427 */     this.jLabel95 = new JLabel();
/*  428 */     this.jLabel96 = new JLabel();
/*  429 */     this.jLabel117 = new JLabel();
/*  430 */     this.jLabel155 = new JLabel();
/*  431 */     this.jPanel39 = new JPanel();
/*  432 */     this.jLabel15 = new JLabel();
/*  433 */     this.jLabel16 = new JLabel();
/*  434 */     this.jLabel17 = new JLabel();
/*  435 */     this.jLabel18 = new JLabel();
/*  436 */     this.jLabel19 = new JLabel();
/*  437 */     this.jLabel20 = new JLabel();
/*  438 */     this.jButton11 = new JButton();
/*  439 */     this.jLabel21 = new JLabel();
/*  440 */     this.jLabel22 = new JLabel();
/*  441 */     this.jSeparator2 = new JSeparator();
/*  442 */     this.jLabel23 = new JLabel();
/*  443 */     this.jLabel24 = new JLabel();
/*  444 */     this.jLabel25 = new JLabel();
/*  445 */     this.jLabel26 = new JLabel();
/*  446 */     this.jLabel27 = new JLabel();
/*  447 */     this.jSeparator5 = new JSeparator();
/*  448 */     this.jSeparator3 = new JSeparator();
/*  449 */     this.jLabel49 = new JLabel();
/*  450 */     this.jPanel40 = new JPanel();
/*  451 */     this.jButton12 = new JButton();
/*  452 */     this.jLabel29 = new JLabel();
/*  453 */     this.jLabel30 = new JLabel();
/*  454 */     this.jPanel1 = new JPanel();
/*  455 */     this.jLabel32 = new JLabel();
/*  456 */     this.jLabel33 = new JLabel();
/*  457 */     this.jLabel34 = new JLabel();
/*  458 */     this.jLabel35 = new JLabel();
/*  459 */     this.jLabel36 = new JLabel();
/*  460 */     this.jLabel37 = new JLabel();
/*  461 */     this.jLabel38 = new JLabel();
/*  462 */     this.jLabel39 = new JLabel();
/*  463 */     this.jLabel40 = new JLabel();
/*  464 */     this.jLabel41 = new JLabel();
/*  465 */     this.jSeparator4 = new JSeparator();
/*  466 */     this.jLabel42 = new JLabel();
/*  467 */     this.jLabel43 = new JLabel();
/*  468 */     this.jLabel44 = new JLabel();
/*  469 */     this.jLabel45 = new JLabel();
/*  470 */     this.jSeparator6 = new JSeparator();
/*  471 */     this.jLabel47 = new JLabel();
/*  472 */     this.jLabel48 = new JLabel();
/*  473 */     this.jSeparator7 = new JSeparator();
/*  474 */     this.jLabel51 = new JLabel();
/*  475 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  476 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  477 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  478 */     this.jLabel31 = new JLabel();
/*  479 */     this.jButton13 = new JButton();
/*  480 */     this.jButton14 = new JButton();
/*  481 */     this.jTextField8 = new JTextField();
/*  482 */     this.jButton15 = new JButton();
/*  483 */     this.jButton16 = new JButton();
/*  484 */     this.jRadioButton1 = new JRadioButton();
/*  485 */     this.jRadioButton2 = new JRadioButton();
/*  486 */     this.jTextField16 = new JTextField();
/*  487 */     this.jButton43 = new JButton();
/*  488 */     this.jPanel32 = new JPanel();
/*  489 */     this.jLabel161 = new JLabel();
/*  490 */     this.jTextField63 = new JTextField();
/*  491 */     this.jLabel69 = new JLabel();
/*  492 */     this.jTextField62 = new JTextField();
/*  493 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  494 */     this.jPanel7 = new JPanel();
/*  495 */     this.jLabel60 = new JLabel();
/*  496 */     this.jPanel36 = new JPanel();
/*  497 */     this.jScrollPane3 = new JScrollPane();
/*  498 */     this.jTable3 = new JTable();
/*  499 */     this.jButton20 = new JButton();
/*  500 */     this.jButton21 = new JButton();
/*  501 */     this.jLabel61 = new JLabel();
/*  502 */     this.jTextField9 = new JTextField();
/*  503 */     this.jLabel62 = new JLabel();
/*  504 */     this.jTextField10 = new JTextField();
/*  505 */     this.jSeparator8 = new JSeparator();
/*  506 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  507 */     this.jPanel8 = new JPanel();
/*  508 */     this.jLabel63 = new JLabel();
/*  509 */     this.jSeparator9 = new JSeparator();
/*  510 */     this.jScrollPane5 = new JScrollPane();
/*  511 */     this.jTable5 = new JTable();
/*  512 */     this.jTextField4 = new JTextField();
/*  513 */     this.jLabel50 = new JLabel();
/*  514 */     this.jButton19 = new JButton();
/*  515 */     this.jButton22 = new JButton();
/*  516 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  517 */     this.jPanel10 = new JPanel();
/*  518 */     this.jLabel64 = new JLabel();
/*  519 */     this.jSeparator10 = new JSeparator();
/*  520 */     this.jLabel65 = new JLabel();
/*  521 */     this.jTextField5 = new JTextField();
/*  522 */     this.jLabel66 = new JLabel();
/*  523 */     this.jTextField7 = new JTextField();
/*  524 */     this.jButton23 = new JButton();
/*  525 */     this.jLabel53 = new JLabel();
/*  526 */     this.jPanel3 = new JPanel();
/*  527 */     this.jLabel54 = new JLabel();
/*  528 */     this.jLabel67 = new JLabel();
/*  529 */     this.jLabel70 = new JLabel();
/*  530 */     this.jLabel55 = new JLabel();
/*  531 */     this.jLabel73 = new JLabel();
/*  532 */     this.jLabel74 = new JLabel();
/*  533 */     this.jLabel75 = new JLabel();
/*  534 */     this.jLabel76 = new JLabel();
/*  535 */     this.jPanel5 = new JPanel();
/*  536 */     this.jLabel77 = new JLabel();
/*  537 */     this.jScrollPane6 = new JScrollPane();
/*  538 */     this.jTextArea1 = new JTextArea();
/*  539 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  540 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  541 */     this.jPanel9 = new JPanel();
/*  542 */     this.jLabel78 = new JLabel();
/*  543 */     this.jPanel41 = new JPanel();
/*  544 */     this.jLabel28 = new JLabel();
/*  545 */     this.jComboBox3 = new JComboBox();
/*  546 */     this.jLabel52 = new JLabel();
/*  547 */     this.jSeparator12 = new JSeparator();
/*  548 */     this.jTextField11 = new JTextField();
/*  549 */     this.jLabel79 = new JLabel();
/*  550 */     this.jTextField12 = new JTextField();
/*  551 */     this.jLabel80 = new JLabel();
/*  552 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  553 */     this.jLabel81 = new JLabel();
/*  554 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  555 */     this.jScrollPane1 = new JScrollPane();
/*  556 */     this.jTable1 = new JTable();
/*  557 */     this.jLabel83 = new JLabel();
/*  558 */     this.jButton6 = new JButton();
/*  559 */     this.jButton17 = new JButton();
/*  560 */     this.jButton18 = new JButton();
/*  561 */     this.jButton26 = new JButton();
/*  562 */     this.jSeparator11 = new JSeparator();
/*  563 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  564 */     this.jPanel11 = new JPanel();
/*  565 */     this.jLabel84 = new JLabel();
/*  566 */     this.jPanel42 = new JPanel();
/*  567 */     this.jLabel86 = new JLabel();
/*  568 */     this.jTextField13 = new JTextField();
/*  569 */     this.jLabel88 = new JLabel();
/*  570 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  571 */     this.jScrollPane7 = new JScrollPane();
/*  572 */     this.jTable6 = new JTable();
/*  573 */     this.jLabel91 = new JLabel();
/*  574 */     this.jButton24 = new JButton();
/*  575 */     this.jButton25 = new JButton();
/*  576 */     this.jButton29 = new JButton();
/*  577 */     this.jLabel157 = new JLabel();
/*  578 */     this.jLabel158 = new JLabel();
/*  579 */     this.jSeparator14 = new JSeparator();
/*  580 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  581 */     this.jPanel12 = new JPanel();
/*  582 */     this.jLabel85 = new JLabel();
/*  583 */     this.jPanel43 = new JPanel();
/*  584 */     this.jLabel87 = new JLabel();
/*  585 */     this.jTextField14 = new JTextField();
/*  586 */     this.jLabel89 = new JLabel();
/*  587 */     this.jFormattedTextField8 = new JFormattedTextField();
/*  588 */     this.jScrollPane8 = new JScrollPane();
/*  589 */     this.jTable7 = new JTable();
/*  590 */     this.jLabel92 = new JLabel();
/*  591 */     this.jButton27 = new JButton();
/*  592 */     this.jButton28 = new JButton();
/*  593 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  594 */     this.jLabel90 = new JLabel();
/*  595 */     this.jLabel93 = new JLabel();
/*  596 */     this.jTextField15 = new JTextField();
/*  597 */     this.jButton30 = new JButton();
/*  598 */     this.jLabel159 = new JLabel();
/*  599 */     this.jLabel160 = new JLabel();
/*  600 */     this.jSeparator15 = new JSeparator();
/*  601 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  602 */     this.jPanel13 = new JPanel();
/*  603 */     this.jLabel97 = new JLabel();
/*  604 */     this.jScrollPane10 = new JScrollPane();
/*  605 */     this.jTable9 = new JTable();
/*  606 */     this.buttonGroup1 = new ButtonGroup();
/*  607 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  608 */     this.jPanel14 = new JPanel();
/*  609 */     this.jLabel98 = new JLabel();
/*  610 */     this.jScrollPane11 = new JScrollPane();
/*  611 */     this.jTable10 = new JTable();
/*  612 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  613 */     this.jPanel15 = new JPanel();
/*  614 */     this.jLabel99 = new JLabel();
/*  615 */     this.jScrollPane12 = new JScrollPane();
/*  616 */     this.jTable11 = new JTable();
/*  617 */     this.jDialog11 = new CerrarVentana(this.padre);
/*  618 */     this.jPanel16 = new JPanel();
/*  619 */     this.jLabel100 = new JLabel();
/*  620 */     this.jSeparator13 = new JSeparator();
/*  621 */     this.jScrollPane13 = new JScrollPane();
/*  622 */     this.jTable12 = new JTable();
/*  623 */     this.jButton32 = new JButton();
/*  624 */     this.jDialog12 = new CerrarVentana(this.padre);
/*  625 */     this.jPanel19 = new JPanel();
/*  626 */     this.jLabel101 = new JLabel();
/*  627 */     this.jSeparator19 = new JSeparator();
/*  628 */     this.jScrollPane14 = new JScrollPane();
/*  629 */     this.jTable13 = new JTable();
/*  630 */     this.jButton33 = new JButton();
/*  631 */     this.jDialog13 = new CerrarVentana(this.padre);
/*  632 */     this.jPanel20 = new JPanel();
/*  633 */     this.jLabel102 = new JLabel();
/*  634 */     this.jSeparator20 = new JSeparator();
/*  635 */     this.jLabel103 = new JLabel();
/*  636 */     this.jTextField17 = new JTextField();
/*  637 */     this.jLabel104 = new JLabel();
/*  638 */     this.jTextField18 = new JTextField();
/*  639 */     this.jLabel107 = new JLabel();
/*  640 */     this.jLabel108 = new JLabel();
/*  641 */     this.jComboBox7 = new JComboBox();
/*  642 */     this.jLabel105 = new JLabel();
/*  643 */     this.jFormattedTextField9 = new JFormattedTextField();
/*  644 */     this.jRadioButton3 = new JRadioButton();
/*  645 */     this.jRadioButton4 = new JRadioButton();
/*  646 */     this.jLabel109 = new JLabel();
/*  647 */     this.jSeparator21 = new JSeparator();
/*  648 */     this.jLabel110 = new JLabel();
/*  649 */     this.jFormattedTextField12 = new JFormattedTextField();
/*  650 */     this.jLabel111 = new JLabel();
/*  651 */     this.jLabel112 = new JLabel();
/*  652 */     this.jFormattedTextField13 = new JFormattedTextField();
/*  653 */     this.jLabel113 = new JLabel();
/*  654 */     this.jFormattedTextField14 = new JFormattedTextField();
/*  655 */     this.jSeparator22 = new JSeparator();
/*  656 */     this.jButton34 = new JButton();
/*  657 */     this.jTextField19 = new JTextField();
/*  658 */     this.jFormattedTextField10 = new JFormattedTextField();
/*  659 */     this.jTextField22 = new JTextField();
/*  660 */     this.buttonGroup2 = new ButtonGroup();
/*  661 */     this.jDialog14 = new CerrarVentana(this.padre);
/*  662 */     this.jPanel21 = new JPanel();
/*  663 */     this.jLabel106 = new JLabel();
/*  664 */     this.jSeparator23 = new JSeparator();
/*  665 */     this.jPanel22 = new JPanel();
/*  666 */     this.jTextField20 = new JTextField();
/*  667 */     this.jLabel114 = new JLabel();
/*  668 */     this.jButton36 = new JButton();
/*  669 */     this.jPanel23 = new JPanel();
/*  670 */     this.jScrollPane15 = new JScrollPane();
/*  671 */     this.jTable14 = new JTable();
/*  672 */     this.jButton37 = new JButton();
/*  673 */     this.jButton38 = new JButton();
/*  674 */     this.jDialog15 = new CerrarVentana(this.padre);
/*  675 */     this.jPanel24 = new JPanel();
/*  676 */     this.jLabel115 = new JLabel();
/*  677 */     this.jSeparator24 = new JSeparator();
/*  678 */     this.jPanel25 = new JPanel();
/*  679 */     this.jTextField21 = new JTextField();
/*  680 */     this.jLabel116 = new JLabel();
/*  681 */     this.jButton39 = new JButton();
/*  682 */     this.jPanel26 = new JPanel();
/*  683 */     this.jScrollPane16 = new JScrollPane();
/*  684 */     this.jTable15 = new JTable();
/*  685 */     this.jButton40 = new JButton();
/*  686 */     this.jButton41 = new JButton();
/*  687 */     this.jDialog16 = new CerrarVentana(this.padre);
/*  688 */     this.jPanel27 = new JPanel();
/*  689 */     this.jLabel118 = new JLabel();
/*  690 */     this.jSeparator25 = new JSeparator();
/*  691 */     this.jLabel119 = new JLabel();
/*  692 */     this.jButton42 = new JButton();
/*  693 */     this.jFormattedTextField11 = new JFormattedTextField();
/*  694 */     this.jDialog17 = new JDialog();
/*  695 */     this.jScrollPane9 = new JScrollPane();
/*  696 */     this.jTable8 = new JTable();
/*  697 */     this.jDialog18 = new CerrarVentana(this.padre);
/*  698 */     this.jPanel28 = new JPanel();
/*  699 */     this.jLabel121 = new JLabel();
/*  700 */     this.jSeparator26 = new JSeparator();
/*  701 */     this.jButton35 = new JButton();
/*  702 */     this.jPanel30 = new JPanel();
/*  703 */     this.jLabel13 = new JLabel();
/*  704 */     this.jLabel46 = new JLabel();
/*  705 */     this.jLabel122 = new JLabel();
/*  706 */     this.jLabel127 = new JLabel();
/*  707 */     this.jLabel128 = new JLabel();
/*  708 */     this.jLabel129 = new JLabel();
/*  709 */     this.jLabel130 = new JLabel();
/*  710 */     this.jLabel131 = new JLabel();
/*  711 */     this.jLabel132 = new JLabel();
/*  712 */     this.jLabel133 = new JLabel();
/*  713 */     this.jLabel134 = new JLabel();
/*  714 */     this.jLabel135 = new JLabel();
/*  715 */     this.jLabel136 = new JLabel();
/*  716 */     this.jLabel137 = new JLabel();
/*  717 */     this.jLabel138 = new JLabel();
/*  718 */     this.jLabel139 = new JLabel();
/*  719 */     this.jLabel140 = new JLabel();
/*  720 */     this.jLabel141 = new JLabel();
/*  721 */     this.jLabel142 = new JLabel();
/*  722 */     this.jLabel143 = new JLabel();
/*  723 */     this.jLabel144 = new JLabel();
/*  724 */     this.jLabel145 = new JLabel();
/*  725 */     this.jLabel146 = new JLabel();
/*  726 */     this.jLabel147 = new JLabel();
/*  727 */     this.jLabel148 = new JLabel();
/*  728 */     this.jLabel149 = new JLabel();
/*  729 */     this.jLabel150 = new JLabel();
/*  730 */     this.jLabel151 = new JLabel();
/*  731 */     this.jLabel152 = new JLabel();
/*  732 */     this.jLabel153 = new JLabel();
/*  733 */     this.jFormattedTextField15 = new JFormattedTextField();
/*  734 */     this.jFormattedTextField16 = new JFormattedTextField();
/*  735 */     this.jFormattedTextField17 = new JFormattedTextField();
/*  736 */     this.jFormattedTextField18 = new JFormattedTextField();
/*  737 */     this.jFormattedTextField19 = new JFormattedTextField();
/*  738 */     this.jFormattedTextField20 = new JFormattedTextField();
/*  739 */     this.jFormattedTextField21 = new JFormattedTextField();
/*  740 */     this.jFormattedTextField22 = new JFormattedTextField();
/*  741 */     this.jFormattedTextField23 = new JFormattedTextField();
/*  742 */     this.jFormattedTextField24 = new JFormattedTextField();
/*  743 */     this.jFormattedTextField25 = new JFormattedTextField();
/*  744 */     this.jFormattedTextField26 = new JFormattedTextField();
/*  745 */     this.jFormattedTextField27 = new JFormattedTextField();
/*  746 */     this.jFormattedTextField28 = new JFormattedTextField();
/*  747 */     this.jFormattedTextField29 = new JFormattedTextField();
/*  748 */     this.jDialog19 = new CerrarVentana(this.padre);
/*  749 */     this.jPanel29 = new JPanel();
/*  750 */     this.jLabel124 = new JLabel();
/*  751 */     this.jSeparator27 = new JSeparator();
/*  752 */     this.jLabel125 = new JLabel();
/*  753 */     this.jButton44 = new JButton();
/*  754 */     this.jButton45 = new JButton();
/*  755 */     this.jScrollPane18 = new JScrollPane();
/*  756 */     this.jTextArea5 = new JTextArea();
/*  757 */     this.jLabel126 = new JLabel();
/*  758 */     this.jPanel31 = new JPanel();
/*  759 */     this.jLabel2 = new JLabel();
/*  760 */     this.jDateChooser3 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  761 */     this.jLabel82 = new JLabel();
/*  762 */     this.jLabel156 = new JLabel();
/*  763 */     this.jDateChooser6 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*  764 */     this.jScrollPane17 = new JScrollPane();
/*  765 */     this.jTable16 = new JTable();
/*  766 */     this.jPanel6 = new JPanel();
/*  767 */     this.jLabel3 = new JLabel();
/*  768 */     this.jPanel2 = new JPanel();
/*  769 */     this.jButton3 = new JButton();
/*  770 */     this.jLabel4 = new JLabel();
/*  771 */     this.jLabel5 = new JLabel();
/*  772 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  773 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  774 */     this.jLabel7 = new JLabel();
/*  775 */     this.jLabel8 = new JLabel();
/*  776 */     this.jLabel9 = new JLabel();
/*  777 */     this.jPanel17 = new JPanel();
/*  778 */     this.jLabel56 = new JLabel();
/*  779 */     this.jTextField3 = new JTextField();
/*  780 */     this.jTextField6 = new JTextField();
/*  781 */     this.jLabel57 = new JLabel();
/*  782 */     this.jTextField1 = new JTextField();
/*  783 */     this.jLabel58 = new JLabel();
/*  784 */     this.jComboBox4 = new JComboBox();
/*  785 */     this.jLabel59 = new JLabel();
/*  786 */     this.jPanel18 = new JPanel();
/*  787 */     this.jScrollPane2 = new JScrollPane();
/*  788 */     this.jTable2 = new JTable();
/*  789 */     this.jButton1 = new JButton();
/*  790 */     this.jButton2 = new JButton();
/*  791 */     this.jButton4 = new JButton();
/*  792 */     this.jButton5 = new JButton();
/*  793 */     this.jLabel120 = new JLabel();
/*  794 */     this.jLabel123 = new JLabel();
/*  795 */     this.jButton8 = new JButton();
/*      */     
/*  797 */     this.jDialog1.setTitle("Nueva Liquidación");
/*  798 */     this.jDialog1.setModal(true);
/*      */     
/*  800 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*      */     
/*  802 */     this.jLabel1.setFont(new Font("Tahoma", 1, 16));
/*  803 */     this.jLabel1.setForeground(Color.blue);
/*  804 */     this.jLabel1.setText("NUEVA LIQUIDACIÓN");
/*  805 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  807 */             Liquidaciones.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  810 */             Liquidaciones.this.jLabel1MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  813 */             Liquidaciones.this.jLabel1MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  817 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/*  818 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/*  819 */     this.jLabel68.setHorizontalAlignment(4);
/*  820 */     this.jLabel68.setText("Folio:");
/*      */     
/*  822 */     this.jTextField61.setEditable(false);
/*  823 */     this.jTextField61.setFont(new Font("Tahoma", 1, 14));
/*  824 */     this.jTextField61.setText("PR-12302");
/*      */     
/*  826 */     this.jLabel71.setFont(new Font("Tahoma", 3, 11));
/*  827 */     this.jLabel71.setForeground(new Color(15, 87, 51));
/*  828 */     this.jLabel71.setHorizontalAlignment(4);
/*  829 */     this.jLabel71.setText("Nombre ");
/*      */     
/*  831 */     this.jLabel72.setFont(new Font("Tahoma", 3, 11));
/*  832 */     this.jLabel72.setForeground(new Color(15, 87, 51));
/*  833 */     this.jLabel72.setHorizontalAlignment(4);
/*  834 */     this.jLabel72.setText("Eco ");
/*      */     
/*  836 */     this.jTextField2.setFont(new Font("Tahoma", 1, 11));
/*  837 */     this.jTextField2.setForeground(Color.blue);
/*  838 */     this.jTextField2.setHorizontalAlignment(0);
/*      */     
/*  840 */     this.jPanel37.setBackground(new Color(146, 193, 134));
/*  841 */     this.jPanel37.setBorder(BorderFactory.createTitledBorder(null, "Listado de Viajes ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  843 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  844 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha", "Ruta", "Kms.", "Km/L", "Litros", "Tons.", "Tarifa", "Salario" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  852 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  854 */             Liquidaciones.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/*  857 */     this.jScrollPane4.setViewportView(this.jTable4);
/*  858 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/*  859 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(70);
/*  860 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(70);
/*  861 */       this.jTable4.getColumnModel().getColumn(1).setMinWidth(110);
/*  862 */       this.jTable4.getColumnModel().getColumn(1).setMaxWidth(110);
/*  863 */       this.jTable4.getColumnModel().getColumn(3).setMinWidth(35);
/*  864 */       this.jTable4.getColumnModel().getColumn(3).setMaxWidth(35);
/*  865 */       this.jTable4.getColumnModel().getColumn(4).setMinWidth(35);
/*  866 */       this.jTable4.getColumnModel().getColumn(4).setMaxWidth(35);
/*  867 */       this.jTable4.getColumnModel().getColumn(5).setMinWidth(50);
/*  868 */       this.jTable4.getColumnModel().getColumn(5).setMaxWidth(50);
/*  869 */       this.jTable4.getColumnModel().getColumn(6).setMinWidth(50);
/*  870 */       this.jTable4.getColumnModel().getColumn(6).setMaxWidth(50);
/*  871 */       this.jTable4.getColumnModel().getColumn(7).setMinWidth(50);
/*  872 */       this.jTable4.getColumnModel().getColumn(7).setMaxWidth(50);
/*  873 */       this.jTable4.getColumnModel().getColumn(8).setMinWidth(70);
/*  874 */       this.jTable4.getColumnModel().getColumn(8).setMaxWidth(70);
/*      */     } 
/*      */     
/*  877 */     this.jLabel6.setText("0");
/*      */     
/*  879 */     this.jLabel10.setText("0");
/*      */     
/*  881 */     this.jLabel11.setText("0");
/*      */     
/*  883 */     this.jLabel12.setFont(new Font("Tahoma", 1, 11));
/*  884 */     this.jLabel12.setText("Totales");
/*      */     
/*  886 */     this.jLabel14.setFont(new Font("Tahoma", 1, 11));
/*  887 */     this.jLabel14.setHorizontalAlignment(4);
/*  888 */     this.jLabel14.setText("0");
/*      */     
/*  890 */     this.jLabel154.setText("0");
/*      */     
/*  892 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/*  893 */     this.jPanel37.setLayout(jPanel37Layout);
/*  894 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/*  895 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  896 */         .addComponent(this.jScrollPane4, -1, 636, 32767)
/*  897 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
/*  898 */           .addContainerGap()
/*  899 */           .addComponent(this.jLabel12, -2, 70, -2)
/*  900 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 256, 32767)
/*  901 */           .addComponent(this.jLabel6, -2, 43, -2)
/*  902 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  903 */           .addComponent(this.jLabel10, -2, 40, -2)
/*  904 */           .addGap(14, 14, 14)
/*  905 */           .addComponent(this.jLabel11, -2, 55, -2)
/*  906 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  907 */           .addComponent(this.jLabel154, -2, 43, -2)
/*  908 */           .addGap(18, 18, 18)
/*  909 */           .addComponent(this.jLabel14, -2, 75, -2)));
/*      */     
/*  911 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/*  912 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  913 */         .addGroup(jPanel37Layout.createSequentialGroup()
/*  914 */           .addComponent(this.jScrollPane4, -2, 154, -2)
/*  915 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767)
/*  916 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  917 */             .addComponent(this.jLabel6)
/*  918 */             .addComponent(this.jLabel14)
/*  919 */             .addComponent(this.jLabel12)
/*  920 */             .addComponent(this.jLabel11)
/*  921 */             .addComponent(this.jLabel10)
/*  922 */             .addComponent(this.jLabel154))));
/*      */ 
/*      */     
/*  925 */     this.jButton7.setText("Agregar");
/*  926 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  928 */             Liquidaciones.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  932 */     this.jButton9.setText("Quitar");
/*  933 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  935 */             Liquidaciones.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  939 */     this.jPanel38.setBackground(new Color(146, 193, 134));
/*  940 */     this.jPanel38.setBorder(BorderFactory.createTitledBorder(null, "Gastos de Diesel ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  942 */     this.jButton10.setText("Registrar Vales de Diesel");
/*  943 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  945 */             Liquidaciones.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  949 */     this.jLabel94.setFont(new Font("Tahoma", 1, 11));
/*  950 */     this.jLabel94.setText("Vales Asignados");
/*      */     
/*  952 */     this.jLabel95.setFont(new Font("Tahoma", 1, 11));
/*  953 */     this.jLabel95.setHorizontalAlignment(4);
/*  954 */     this.jLabel95.setText("$0.00");
/*      */     
/*  956 */     this.jLabel96.setFont(new Font("Tahoma", 1, 11));
/*  957 */     this.jLabel96.setForeground(new Color(0, 0, 204));
/*  958 */     this.jLabel96.setHorizontalAlignment(4);
/*  959 */     this.jLabel96.setText("0");
/*      */     
/*  961 */     this.jLabel117.setFont(new Font("Tahoma", 1, 11));
/*  962 */     this.jLabel117.setText("Diferencia de Diesel");
/*      */     
/*  964 */     this.jLabel155.setFont(new Font("Tahoma", 1, 11));
/*  965 */     this.jLabel155.setForeground(Color.darkGray);
/*  966 */     this.jLabel155.setHorizontalAlignment(4);
/*  967 */     this.jLabel155.setText("0");
/*      */     
/*  969 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/*  970 */     this.jPanel38.setLayout(jPanel38Layout);
/*  971 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/*  972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */         .addGroup(jPanel38Layout.createSequentialGroup()
/*  974 */           .addContainerGap()
/*  975 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  976 */             .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */               .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/*  978 */                 .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  979 */                   .addComponent(this.jLabel94, -1, -1, 32767)
/*  980 */                   .addComponent(this.jButton10, -1, -1, 32767)
/*  981 */                   .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/*  982 */                     .addComponent(this.jLabel155, -1, -1, 32767)
/*  983 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  984 */                     .addComponent(this.jLabel96, -2, 67, -2)))
/*  985 */                 .addContainerGap())
/*  986 */               .addGroup(jPanel38Layout.createSequentialGroup()
/*  987 */                 .addComponent(this.jLabel117, -1, -1, 32767)
/*  988 */                 .addGap(20, 20, 20)))
/*  989 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/*  990 */               .addComponent(this.jLabel95, -2, 89, -2)
/*  991 */               .addContainerGap()))));
/*      */     
/*  993 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/*  994 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  995 */         .addGroup(jPanel38Layout.createSequentialGroup()
/*  996 */           .addComponent(this.jButton10)
/*  997 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  998 */           .addComponent(this.jLabel94)
/*  999 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1000 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1001 */             .addComponent(this.jLabel96)
/* 1002 */             .addComponent(this.jLabel155))
/* 1003 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1004 */           .addComponent(this.jLabel117)
/* 1005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1006 */           .addComponent(this.jLabel95)
/* 1007 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/* 1010 */     this.jPanel39.setBackground(new Color(146, 193, 134));
/* 1011 */     this.jPanel39.setBorder(BorderFactory.createTitledBorder(null, "Gastos del Viaje ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1013 */     this.jLabel15.setText("Autopistas");
/*      */     
/* 1015 */     this.jLabel16.setText("Otros Gastos");
/*      */     
/* 1017 */     this.jLabel17.setText("Llantas");
/*      */     
/* 1019 */     this.jLabel18.setHorizontalAlignment(4);
/* 1020 */     this.jLabel18.setText("$ 00.00");
/*      */     
/* 1022 */     this.jLabel19.setHorizontalAlignment(4);
/* 1023 */     this.jLabel19.setText("$ 00.00");
/*      */     
/* 1025 */     this.jLabel20.setHorizontalAlignment(4);
/* 1026 */     this.jLabel20.setText("$ 00.00");
/*      */     
/* 1028 */     this.jButton11.setText("Registrar Otros Gastos");
/* 1029 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1031 */             Liquidaciones.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1035 */     this.jLabel21.setText("Otros Gastos");
/*      */     
/* 1037 */     this.jLabel22.setHorizontalAlignment(4);
/* 1038 */     this.jLabel22.setText("$ 00.00");
/*      */     
/* 1040 */     this.jLabel23.setText("Total:");
/*      */     
/* 1042 */     this.jLabel24.setHorizontalAlignment(4);
/* 1043 */     this.jLabel24.setText("$ 00.00");
/*      */     
/* 1045 */     this.jLabel25.setText("Asignados");
/*      */     
/* 1047 */     this.jLabel26.setHorizontalAlignment(4);
/* 1048 */     this.jLabel26.setText("$ 00.00");
/*      */     
/* 1050 */     this.jLabel27.setForeground(new Color(0, 0, 204));
/* 1051 */     this.jLabel27.setText("Diferencia:");
/*      */     
/* 1053 */     this.jLabel49.setForeground(new Color(0, 0, 204));
/* 1054 */     this.jLabel49.setHorizontalAlignment(4);
/* 1055 */     this.jLabel49.setText("$ 00.00");
/*      */     
/* 1057 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 1058 */     this.jPanel39.setLayout(jPanel39Layout);
/* 1059 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 1060 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1061 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1062 */           .addContainerGap()
/* 1063 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1064 */             .addComponent(this.jSeparator3)
/* 1065 */             .addComponent(this.jSeparator5)
/* 1066 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1067 */               .addComponent(this.jLabel15, -2, 69, -2)
/* 1068 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1069 */               .addComponent(this.jLabel18, -2, 90, -2))
/* 1070 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 1071 */               .addComponent(this.jLabel16, -1, -1, 32767)
/* 1072 */               .addGap(18, 18, 18)
/* 1073 */               .addComponent(this.jLabel19, -2, 67, -2))
/* 1074 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1075 */               .addComponent(this.jLabel17, -2, 69, -2)
/* 1076 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1077 */               .addComponent(this.jLabel20, -2, 90, -2))
/* 1078 */             .addComponent(this.jSeparator2)
/* 1079 */             .addComponent(this.jButton11, -1, -1, 32767)
/* 1080 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 1081 */               .addComponent(this.jLabel21, -2, 81, -2)
/* 1082 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1083 */               .addComponent(this.jLabel22, -1, -1, 32767))
/* 1084 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1085 */               .addComponent(this.jLabel23, -2, 69, -2)
/* 1086 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1087 */               .addComponent(this.jLabel24, -2, 90, -2))
/* 1088 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1089 */               .addComponent(this.jLabel25, -2, 69, -2)
/* 1090 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1091 */               .addComponent(this.jLabel26, -2, 90, -2))
/* 1092 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1093 */               .addComponent(this.jLabel27, -2, 59, -2)
/* 1094 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1095 */               .addComponent(this.jLabel49, -1, -1, 32767)))
/* 1096 */           .addContainerGap()));
/*      */     
/* 1098 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 1099 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1101 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1102 */             .addComponent(this.jLabel15)
/* 1103 */             .addComponent(this.jLabel18))
/* 1104 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1105 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1106 */             .addComponent(this.jLabel16)
/* 1107 */             .addComponent(this.jLabel19))
/* 1108 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1109 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1110 */             .addComponent(this.jLabel17)
/* 1111 */             .addComponent(this.jLabel20))
/* 1112 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1113 */           .addComponent(this.jSeparator2, -2, 5, -2)
/* 1114 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1115 */           .addComponent(this.jButton11)
/* 1116 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1117 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1118 */             .addComponent(this.jLabel21)
/* 1119 */             .addComponent(this.jLabel22))
/* 1120 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1121 */           .addComponent(this.jSeparator5, -2, -1, -2)
/* 1122 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1123 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1124 */             .addComponent(this.jLabel23)
/* 1125 */             .addComponent(this.jLabel24))
/* 1126 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1127 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1128 */             .addComponent(this.jLabel25)
/* 1129 */             .addComponent(this.jLabel26))
/* 1130 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1131 */           .addComponent(this.jSeparator3, -2, -1, -2)
/* 1132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1133 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1134 */             .addComponent(this.jLabel27)
/* 1135 */             .addComponent(this.jLabel49))));
/*      */ 
/*      */     
/* 1138 */     this.jPanel40.setBackground(new Color(146, 193, 134));
/* 1139 */     this.jPanel40.setBorder(BorderFactory.createTitledBorder(null, "Premios", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1141 */     this.jButton12.setText("Registrar Premios");
/* 1142 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1144 */             Liquidaciones.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1148 */     this.jLabel29.setForeground(new Color(0, 0, 204));
/* 1149 */     this.jLabel29.setText("Premios:");
/*      */     
/* 1151 */     this.jLabel30.setForeground(new Color(0, 0, 204));
/* 1152 */     this.jLabel30.setHorizontalAlignment(4);
/* 1153 */     this.jLabel30.setText("$ 00.00");
/*      */     
/* 1155 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 1156 */     this.jPanel40.setLayout(jPanel40Layout);
/* 1157 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 1158 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1159 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1160 */           .addContainerGap()
/* 1161 */           .addGroup(jPanel40Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1162 */             .addComponent(this.jButton12, -1, -1, 32767)
/* 1163 */             .addGroup(jPanel40Layout.createSequentialGroup()
/* 1164 */               .addComponent(this.jLabel29, -2, 52, -2)
/* 1165 */               .addGap(18, 18, 18)
/* 1166 */               .addComponent(this.jLabel30, -1, -1, 32767)))
/* 1167 */           .addContainerGap()));
/*      */     
/* 1169 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 1170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1171 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
/* 1172 */           .addComponent(this.jButton12)
/* 1173 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1174 */           .addGroup(jPanel40Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1175 */             .addComponent(this.jLabel29)
/* 1176 */             .addComponent(this.jLabel30))));
/*      */ 
/*      */     
/* 1179 */     this.jPanel1.setBorder(new SoftBevelBorder(1));
/*      */     
/* 1181 */     this.jLabel32.setText("Sueldo del Operador");
/*      */     
/* 1183 */     this.jLabel33.setHorizontalAlignment(4);
/* 1184 */     this.jLabel33.setText("$ 00.00");
/*      */     
/* 1186 */     this.jLabel34.setText("Premios");
/*      */     
/* 1188 */     this.jLabel35.setHorizontalAlignment(4);
/* 1189 */     this.jLabel35.setText("$ 00.00");
/*      */     
/* 1191 */     this.jLabel36.setText("Diferencia de Diesel");
/*      */     
/* 1193 */     this.jLabel37.setHorizontalAlignment(4);
/* 1194 */     this.jLabel37.setText("$ 00.00");
/*      */     
/* 1196 */     this.jLabel38.setText("Diferencia de Gastos");
/*      */     
/* 1198 */     this.jLabel39.setHorizontalAlignment(4);
/* 1199 */     this.jLabel39.setText("$ 00.00");
/*      */     
/* 1201 */     this.jLabel40.setText("Adelanto Liquidación");
/*      */     
/* 1203 */     this.jLabel41.setHorizontalAlignment(4);
/* 1204 */     this.jLabel41.setText("$ 00.00");
/*      */     
/* 1206 */     this.jLabel42.setText("Subtotal");
/*      */     
/* 1208 */     this.jLabel43.setHorizontalAlignment(4);
/* 1209 */     this.jLabel43.setText("$ 00.00");
/*      */     
/* 1211 */     this.jLabel44.setText("Impuestos");
/*      */     
/* 1213 */     this.jLabel45.setHorizontalAlignment(4);
/* 1214 */     this.jLabel45.setText("$ 00.00");
/*      */     
/* 1216 */     this.jLabel47.setText("Saldo T.D.");
/*      */     
/* 1218 */     this.jLabel48.setText("Abono T.D");
/*      */     
/* 1220 */     this.jLabel51.setForeground(new Color(0, 0, 204));
/* 1221 */     this.jLabel51.setText("Neto a Liquidar");
/*      */     
/* 1223 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 1224 */     this.jFormattedTextField1.setFont(new Font("Tahoma", 1, 11));
/* 1225 */     this.jFormattedTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1227 */             Liquidaciones.this.jFormattedTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1231 */     this.jFormattedTextField3.setEditable(false);
/* 1232 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 1233 */     this.jFormattedTextField3.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 1235 */     this.jFormattedTextField4.setEditable(false);
/* 1236 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/* 1237 */     this.jFormattedTextField4.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 1239 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1240 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1241 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1242 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1243 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1244 */           .addContainerGap()
/* 1245 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1246 */             .addComponent(this.jSeparator7, GroupLayout.Alignment.TRAILING)
/* 1247 */             .addComponent(this.jSeparator6)
/* 1248 */             .addComponent(this.jSeparator4)
/* 1249 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1250 */               .addComponent(this.jLabel32, -2, 137, -2)
/* 1251 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1252 */               .addComponent(this.jLabel33, -2, 104, -2))
/* 1253 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1254 */               .addComponent(this.jLabel34, -2, 137, -2)
/* 1255 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1256 */               .addComponent(this.jLabel35, -2, 104, -2))
/* 1257 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1258 */               .addComponent(this.jLabel36, -2, 137, -2)
/* 1259 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1260 */               .addComponent(this.jLabel37, -2, 104, -2))
/* 1261 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1262 */               .addComponent(this.jLabel38, -2, 137, -2)
/* 1263 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1264 */               .addComponent(this.jLabel39, -2, 104, -2))
/* 1265 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1266 */               .addComponent(this.jLabel40, -2, 137, -2)
/* 1267 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1268 */               .addComponent(this.jLabel41, -2, 104, -2))
/* 1269 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1270 */               .addComponent(this.jLabel42, -2, 137, -2)
/* 1271 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1272 */               .addComponent(this.jLabel43, -2, 104, -2))
/* 1273 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1274 */               .addComponent(this.jLabel44, -2, 137, -2)
/* 1275 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1276 */               .addComponent(this.jLabel45, -2, 104, -2))
/* 1277 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1278 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1279 */                 .addComponent(this.jLabel47, -2, 137, -2)
/* 1280 */                 .addComponent(this.jFormattedTextField3, -2, 118, -2))
/* 1281 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1282 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1283 */                 .addComponent(this.jLabel48, -1, -1, 32767)
/* 1284 */                 .addComponent(this.jFormattedTextField1, -1, 118, 32767)))
/* 1285 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1286 */               .addComponent(this.jLabel51, -2, 94, -2)
/* 1287 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1288 */               .addComponent(this.jFormattedTextField4, -2, 118, -2)))
/* 1289 */           .addContainerGap()));
/*      */     
/* 1291 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1292 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1293 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1294 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1295 */             .addComponent(this.jLabel32)
/* 1296 */             .addComponent(this.jLabel33))
/* 1297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1298 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1299 */             .addComponent(this.jLabel34)
/* 1300 */             .addComponent(this.jLabel35))
/* 1301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1302 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1303 */             .addComponent(this.jLabel36)
/* 1304 */             .addComponent(this.jLabel37))
/* 1305 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1306 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1307 */             .addComponent(this.jLabel38)
/* 1308 */             .addComponent(this.jLabel39))
/* 1309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1310 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1311 */             .addComponent(this.jLabel40)
/* 1312 */             .addComponent(this.jLabel41))
/* 1313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1314 */           .addComponent(this.jSeparator4, -2, -1, -2)
/* 1315 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1316 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1317 */             .addComponent(this.jLabel42)
/* 1318 */             .addComponent(this.jLabel43))
/* 1319 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1320 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1321 */             .addComponent(this.jLabel44)
/* 1322 */             .addComponent(this.jLabel45))
/* 1323 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1324 */           .addComponent(this.jSeparator6, -2, -1, -2)
/* 1325 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1326 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1327 */             .addComponent(this.jLabel47)
/* 1328 */             .addComponent(this.jLabel48))
/* 1329 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1330 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1331 */             .addComponent(this.jFormattedTextField1, -2, -1, -2)
/* 1332 */             .addComponent(this.jFormattedTextField3, -2, -1, -2))
/* 1333 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1334 */           .addComponent(this.jSeparator7, -2, -1, -2)
/* 1335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1336 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1337 */             .addComponent(this.jLabel51)
/* 1338 */             .addComponent(this.jFormattedTextField4, -2, -1, -2))
/* 1339 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1342 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/* 1343 */     this.jLabel31.setText("TOTALES DE LIQUIDACIÓN");
/*      */     
/* 1345 */     this.jButton13.setMnemonic('C');
/* 1346 */     this.jButton13.setText("Cerrar");
/* 1347 */     this.jButton13.setToolTipText("Cerrar (Alt+C)");
/* 1348 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1350 */             Liquidaciones.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1354 */     this.jButton14.setMnemonic('O');
/* 1355 */     this.jButton14.setText("Consultar T.D.");
/* 1356 */     this.jButton14.setToolTipText("Consultar Tarjeta Deudor(Alt+O)");
/* 1357 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1359 */             Liquidaciones.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1363 */     this.jTextField8.setEditable(false);
/* 1364 */     this.jTextField8.setFont(new Font("Tahoma", 1, 11));
/* 1365 */     this.jTextField8.setForeground(Color.blue);
/*      */     
/* 1367 */     this.jButton15.setText("Cargar");
/* 1368 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1370 */             Liquidaciones.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1374 */     this.jButton16.setMnemonic('G');
/* 1375 */     this.jButton16.setText("Guardar");
/* 1376 */     this.jButton16.setToolTipText("Guardar (Alt+G)");
/* 1377 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1379 */             Liquidaciones.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1383 */     this.jRadioButton1.setFont(new Font("Tahoma", 1, 11));
/* 1384 */     this.jRadioButton1.setText("Evento");
/*      */     
/* 1386 */     this.jRadioButton2.setFont(new Font("Tahoma", 1, 11));
/* 1387 */     this.jRadioButton2.setText("Renta");
/* 1388 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1390 */             Liquidaciones.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1394 */     this.jTextField16.setEditable(false);
/* 1395 */     this.jTextField16.setFont(new Font("Tahoma", 1, 10));
/* 1396 */     this.jTextField16.setHorizontalAlignment(0);
/*      */     
/* 1398 */     this.jButton43.setText("Rendimientos");
/* 1399 */     this.jButton43.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1401 */             Liquidaciones.this.jButton43ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1405 */     this.jPanel32.setBackground(new Color(146, 193, 134));
/* 1406 */     this.jPanel32.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 1408 */     this.jLabel161.setFont(new Font("Tahoma", 3, 11));
/* 1409 */     this.jLabel161.setForeground(new Color(15, 87, 51));
/* 1410 */     this.jLabel161.setHorizontalAlignment(4);
/* 1411 */     this.jLabel161.setText("Primer Viaje");
/* 1412 */     this.jPanel32.add(this.jLabel161);
/*      */     
/* 1414 */     this.jTextField63.setEditable(false);
/* 1415 */     this.jTextField63.setFont(new Font("Tahoma", 1, 14));
/* 1416 */     this.jTextField63.setText("PR-12302");
/* 1417 */     this.jPanel32.add(this.jTextField63);
/*      */     
/* 1419 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/* 1420 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/* 1421 */     this.jLabel69.setHorizontalAlignment(4);
/* 1422 */     this.jLabel69.setText("Fecha de Liq:");
/* 1423 */     this.jPanel32.add(this.jLabel69);
/*      */     
/* 1425 */     this.jTextField62.setEditable(false);
/* 1426 */     this.jTextField62.setFont(new Font("Tahoma", 1, 14));
/* 1427 */     this.jTextField62.setText("PR-12302");
/* 1428 */     this.jPanel32.add(this.jTextField62);
/*      */     
/* 1430 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1431 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1432 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1433 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1434 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1435 */           .addContainerGap()
/* 1436 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1437 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 1438 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1439 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1440 */                   .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1441 */                     .addComponent(this.jPanel40, -1, -1, 32767)
/* 1442 */                     .addComponent(this.jPanel38, -1, -1, 32767))
/* 1443 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1444 */                   .addComponent(this.jPanel39, -2, -1, -2))
/* 1445 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1446 */                   .addComponent(this.jButton16, -2, 100, -2)
/* 1447 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1448 */                   .addComponent(this.jButton14, -2, 113, -2)
/* 1449 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1450 */                   .addComponent(this.jButton13, -2, 100, -2)))
/* 1451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1452 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1453 */                 .addComponent(this.jPanel1, -1, -1, 32767)
/* 1454 */                 .addComponent(this.jLabel31, -1, -1, 32767)))
/* 1455 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 1456 */               .addComponent(this.jPanel37, -2, -1, -2)
/* 1457 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1458 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1459 */                 .addComponent(this.jButton43, -1, -1, 32767)
/* 1460 */                 .addComponent(this.jButton9, -1, -1, 32767)
/* 1461 */                 .addComponent(this.jTextField16)
/* 1462 */                 .addComponent(this.jButton7, -1, -1, 32767)))
/* 1463 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 1464 */               .addComponent(this.jLabel71, -2, 52, -2)
/* 1465 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1466 */               .addComponent(this.jTextField8, -2, 284, -2)
/* 1467 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1468 */               .addComponent(this.jButton15)
/* 1469 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1470 */               .addComponent(this.jLabel72, -2, 36, -2)
/* 1471 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1472 */               .addComponent(this.jTextField2, -2, 66, -2)
/* 1473 */               .addGap(12, 12, 12)
/* 1474 */               .addComponent(this.jRadioButton1, -2, 84, -2)
/* 1475 */               .addGap(10, 10, 10)
/* 1476 */               .addComponent(this.jRadioButton2, -2, 87, -2))
/* 1477 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1478 */               .addGroup(jPanel4Layout.createSequentialGroup()
/* 1479 */                 .addComponent(this.jLabel1, -2, 192, -2)
/* 1480 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1481 */                 .addComponent(this.jLabel68, -2, 46, -2)
/* 1482 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1483 */                 .addComponent(this.jTextField61, -2, -1, -2)
/* 1484 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1485 */                 .addComponent(this.jPanel32, -1, -1, 32767))
/* 1486 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING, -2, 757, -2)))
/* 1487 */           .addGap(143, 143, 143)));
/*      */     
/* 1489 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1490 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1491 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1492 */           .addContainerGap()
/* 1493 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1494 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1495 */               .addComponent(this.jLabel1)
/* 1496 */               .addComponent(this.jLabel68)
/* 1497 */               .addComponent(this.jTextField61, -2, -1, -2))
/* 1498 */             .addComponent(this.jPanel32, -2, -1, -2))
/* 1499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1500 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1501 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1502 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1503 */             .addComponent(this.jLabel71)
/* 1504 */             .addComponent(this.jTextField8, -2, -1, -2)
/* 1505 */             .addComponent(this.jButton15)
/* 1506 */             .addComponent(this.jLabel72)
/* 1507 */             .addComponent(this.jRadioButton1)
/* 1508 */             .addComponent(this.jRadioButton2)
/* 1509 */             .addComponent(this.jTextField2, -2, -1, -2))
/* 1510 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1511 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1512 */             .addComponent(this.jPanel37, -2, -1, -2)
/* 1513 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1514 */               .addGap(38, 38, 38)
/* 1515 */               .addComponent(this.jButton7)
/* 1516 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1517 */               .addComponent(this.jButton9)
/* 1518 */               .addGap(29, 29, 29)
/* 1519 */               .addComponent(this.jButton43)
/* 1520 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1521 */               .addComponent(this.jTextField16, -2, -1, -2)
/* 1522 */               .addGap(3, 3, 3)))
/* 1523 */           .addGap(6, 6, 6)
/* 1524 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1525 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1526 */               .addGap(9, 9, 9)
/* 1527 */               .addComponent(this.jLabel31)
/* 1528 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1529 */               .addComponent(this.jPanel1, -2, -1, -2))
/* 1530 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1531 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1532 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1533 */                   .addComponent(this.jPanel38, -2, -1, -2)
/* 1534 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1535 */                   .addComponent(this.jPanel40, -1, -1, 32767))
/* 1536 */                 .addComponent(this.jPanel39, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 1537 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1538 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1539 */                 .addComponent(this.jButton13)
/* 1540 */                 .addComponent(this.jButton14)
/* 1541 */                 .addComponent(this.jButton16))))
/* 1542 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1545 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1546 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1547 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1548 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1549 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/* 1551 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1552 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1553 */         .addComponent(this.jPanel4, -2, -1, -2));
/*      */ 
/*      */     
/* 1556 */     this.jDialog2.setTitle("Búsqueda de Operadores");
/* 1557 */     this.jDialog2.setModal(true);
/*      */     
/* 1559 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/* 1561 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/* 1562 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/* 1563 */     this.jLabel60.setHorizontalAlignment(0);
/* 1564 */     this.jLabel60.setText("Busqueda de Operador");
/*      */     
/* 1566 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/* 1567 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Operadores ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1569 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1570 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1578 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1583 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1586 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1588 */             Liquidaciones.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1591 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1593 */     this.jButton20.setMnemonic('A');
/* 1594 */     this.jButton20.setText("Asignar");
/* 1595 */     this.jButton20.setToolTipText("Asignar (Alt+A)");
/* 1596 */     this.jButton20.setEnabled(false);
/* 1597 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1599 */             Liquidaciones.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1603 */     this.jButton21.setMnemonic('C');
/* 1604 */     this.jButton21.setText("Cerrar");
/* 1605 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 1606 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1608 */             Liquidaciones.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1612 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/* 1613 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 1614 */     this.jLabel61.setHorizontalAlignment(4);
/* 1615 */     this.jLabel61.setText("Clave");
/*      */     
/* 1617 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1619 */             Liquidaciones.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1623 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/* 1624 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 1625 */     this.jLabel62.setHorizontalAlignment(4);
/* 1626 */     this.jLabel62.setText("Nombre");
/*      */     
/* 1628 */     this.jTextField10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1630 */             Liquidaciones.this.jTextField10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1633 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1635 */             Liquidaciones.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1639 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1640 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1641 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1642 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1643 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1644 */           .addContainerGap()
/* 1645 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1646 */             .addComponent(this.jScrollPane3, -1, 482, 32767)
/* 1647 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 1648 */               .addComponent(this.jLabel61, -2, 40, -2)
/* 1649 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1650 */               .addComponent(this.jTextField9, -2, 52, -2)
/* 1651 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1652 */               .addComponent(this.jLabel62, -2, 57, -2)
/* 1653 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1654 */               .addComponent(this.jTextField10, -2, 182, -2))
/* 1655 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 1656 */               .addComponent(this.jButton20, -2, 92, -2)
/* 1657 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1658 */               .addComponent(this.jButton21, -2, 83, -2)))
/* 1659 */           .addContainerGap()));
/*      */     
/* 1661 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1663 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1664 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1665 */             .addComponent(this.jLabel61)
/* 1666 */             .addComponent(this.jTextField9, -2, -1, -2)
/* 1667 */             .addComponent(this.jLabel62)
/* 1668 */             .addComponent(this.jTextField10, -2, -1, -2))
/* 1669 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1670 */           .addComponent(this.jScrollPane3, -1, 222, 32767)
/* 1671 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1672 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1673 */             .addComponent(this.jButton21)
/* 1674 */             .addComponent(this.jButton20))
/* 1675 */           .addGap(12, 12, 12)));
/*      */ 
/*      */     
/* 1678 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1679 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1680 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1681 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1682 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1683 */           .addContainerGap()
/* 1684 */           .addComponent(this.jSeparator8, -1, 492, 32767)
/* 1685 */           .addContainerGap())
/* 1686 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1687 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 1688 */             .addGap(8, 8, 8)
/* 1689 */             .addComponent(this.jLabel60, -1, 494, 32767)
/* 1690 */             .addGap(10, 10, 10))
/* 1691 */           .addComponent(this.jPanel36, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
/*      */     
/* 1693 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1694 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1695 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1696 */           .addGap(31, 31, 31)
/* 1697 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1698 */           .addContainerGap(335, 32767))
/* 1699 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1700 */           .addGroup(jPanel7Layout.createSequentialGroup()
/* 1701 */             .addContainerGap()
/* 1702 */             .addComponent(this.jLabel60)
/* 1703 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1704 */             .addComponent(this.jPanel36, -1, -1, 32767))));
/*      */ 
/*      */     
/* 1707 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1708 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1709 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1711 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 1713 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1715 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 1718 */     this.jDialog3.setTitle("Administrar Tarjetas de Deudor");
/* 1719 */     this.jDialog3.setModal(true);
/*      */     
/* 1721 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/* 1723 */     this.jLabel63.setFont(new Font("Tahoma", 1, 16));
/* 1724 */     this.jLabel63.setHorizontalAlignment(0);
/* 1725 */     this.jLabel63.setText("Tarjeta de ");
/*      */     
/* 1727 */     this.jTable5.setFont(new Font("Tahoma", 0, 10));
/* 1728 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Cargo", "Abono", "Saldo", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1736 */     this.jTable5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1738 */             Liquidaciones.this.jTable5MouseClicked(evt);
/*      */           }
/*      */         });
/* 1741 */     this.jScrollPane5.setViewportView(this.jTable5);
/*      */     
/* 1743 */     this.jTextField4.setEditable(false);
/* 1744 */     this.jTextField4.setFont(new Font("Tahoma", 1, 14));
/* 1745 */     this.jTextField4.setForeground(Color.darkGray);
/* 1746 */     this.jTextField4.setHorizontalAlignment(4);
/* 1747 */     this.jTextField4.setText("$ 10000.00");
/*      */     
/* 1749 */     this.jLabel50.setFont(new Font("Tahoma", 1, 14));
/* 1750 */     this.jLabel50.setForeground(Color.darkGray);
/* 1751 */     this.jLabel50.setHorizontalAlignment(4);
/* 1752 */     this.jLabel50.setText("Saldo Actual");
/*      */     
/* 1754 */     this.jButton19.setMnemonic('C');
/* 1755 */     this.jButton19.setText("Cerrar");
/* 1756 */     this.jButton19.setToolTipText("Cerrar (Alt+C)");
/* 1757 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1759 */             Liquidaciones.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1763 */     this.jButton22.setMnemonic('G');
/* 1764 */     this.jButton22.setText("Guardar Reporte");
/* 1765 */     this.jButton22.setToolTipText("Guardar Reporte (Alt+G)");
/* 1766 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1768 */             Liquidaciones.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1772 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1773 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1774 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1775 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1776 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1777 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1778 */             .addComponent(this.jSeparator9, -1, 714, 32767)
/* 1779 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1780 */               .addContainerGap()
/* 1781 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1782 */                 .addComponent(this.jScrollPane5, -1, 704, 32767)
/* 1783 */                 .addComponent(this.jLabel63, -1, 704, 32767)
/* 1784 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1785 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1786 */                     .addGroup(jPanel8Layout.createSequentialGroup()
/* 1787 */                       .addGap(476, 476, 476)
/* 1788 */                       .addComponent(this.jLabel50, -1, -1, 32767))
/* 1789 */                     .addComponent(this.jButton22, -2, 120, -2))
/* 1790 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1791 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1792 */                     .addComponent(this.jButton19, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1793 */                     .addComponent(this.jTextField4, GroupLayout.Alignment.TRAILING, -1, 120, 32767))))))
/* 1794 */           .addContainerGap()));
/*      */     
/* 1796 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1798 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1799 */           .addComponent(this.jLabel63, -2, 20, -2)
/* 1800 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1801 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 1802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1803 */           .addComponent(this.jScrollPane5, -2, 248, -2)
/* 1804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1805 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1806 */             .addComponent(this.jTextField4, -2, 33, -2)
/* 1807 */             .addComponent(this.jLabel50, -2, 25, -2))
/* 1808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1809 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1810 */             .addComponent(this.jButton19)
/* 1811 */             .addComponent(this.jButton22))
/* 1812 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1815 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1816 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1817 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1819 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/* 1821 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1822 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1823 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */ 
/*      */     
/* 1826 */     this.jDialog4.setTitle("Vale de Caja Chica");
/* 1827 */     this.jDialog4.setModal(true);
/*      */     
/* 1829 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/* 1831 */     this.jLabel64.setFont(new Font("Tahoma", 1, 14));
/* 1832 */     this.jLabel64.setForeground(Color.blue);
/* 1833 */     this.jLabel64.setHorizontalAlignment(0);
/* 1834 */     this.jLabel64.setText("CONSULTA DEL MOVIMIENTO");
/*      */     
/* 1836 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/* 1837 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/* 1838 */     this.jLabel65.setHorizontalAlignment(4);
/* 1839 */     this.jLabel65.setText("Mov ");
/*      */     
/* 1841 */     this.jTextField5.setEditable(false);
/* 1842 */     this.jTextField5.setFont(new Font("Tahoma", 1, 11));
/* 1843 */     this.jTextField5.setForeground(Color.red);
/* 1844 */     this.jTextField5.setHorizontalAlignment(4);
/* 1845 */     this.jTextField5.setText("PR-00001");
/*      */     
/* 1847 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/* 1848 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/* 1849 */     this.jLabel66.setHorizontalAlignment(4);
/* 1850 */     this.jLabel66.setText("Fecha ");
/*      */     
/* 1852 */     this.jTextField7.setEditable(false);
/* 1853 */     this.jTextField7.setFont(new Font("Tahoma", 1, 11));
/* 1854 */     this.jTextField7.setForeground(Color.red);
/* 1855 */     this.jTextField7.setText("26/04/2010");
/*      */     
/* 1857 */     this.jButton23.setMnemonic('C');
/* 1858 */     this.jButton23.setText("Cerrar");
/* 1859 */     this.jButton23.setToolTipText("Cerrar (Alt+C)");
/* 1860 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1862 */             Liquidaciones.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1866 */     this.jLabel53.setFont(new Font("Tahoma", 3, 11));
/* 1867 */     this.jLabel53.setForeground(Color.red);
/* 1868 */     this.jLabel53.setText("<html><u>Click para ver el Estado</u></html>");
/* 1869 */     this.jLabel53.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1871 */             Liquidaciones.this.jLabel53MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1874 */             Liquidaciones.this.jLabel53MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1877 */             Liquidaciones.this.jLabel53MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1881 */     this.jPanel3.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1883 */     this.jLabel54.setFont(new Font("Tahoma", 1, 11));
/* 1884 */     this.jLabel54.setText("CARGO");
/*      */     
/* 1886 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/* 1887 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1888 */     this.jLabel67.setHorizontalAlignment(2);
/* 1889 */     this.jLabel67.setText("Tipo");
/*      */     
/* 1891 */     this.jLabel70.setFont(new Font("Tahoma", 3, 11));
/* 1892 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/* 1893 */     this.jLabel70.setHorizontalAlignment(2);
/* 1894 */     this.jLabel70.setText("Concepto ");
/*      */     
/* 1896 */     this.jLabel55.setFont(new Font("Tahoma", 1, 11));
/* 1897 */     this.jLabel55.setText("GASTOS POR COMPROBAR");
/*      */     
/* 1899 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/* 1900 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/* 1901 */     this.jLabel73.setHorizontalAlignment(2);
/* 1902 */     this.jLabel73.setText("Referencia ");
/*      */     
/* 1904 */     this.jLabel74.setFont(new Font("Tahoma", 1, 11));
/* 1905 */     this.jLabel74.setText("VALE: PR-00001");
/*      */     
/* 1907 */     this.jLabel75.setFont(new Font("Tahoma", 3, 11));
/* 1908 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/* 1909 */     this.jLabel75.setHorizontalAlignment(2);
/* 1910 */     this.jLabel75.setText("Cantidad ");
/*      */     
/* 1912 */     this.jLabel76.setFont(new Font("Tahoma", 1, 11));
/* 1913 */     this.jLabel76.setHorizontalAlignment(0);
/* 1914 */     this.jLabel76.setText("$200.00");
/*      */     
/* 1916 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1917 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1918 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1919 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1920 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1921 */           .addContainerGap()
/* 1922 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1923 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1924 */               .addComponent(this.jLabel67, -2, 36, -2)
/* 1925 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1926 */               .addComponent(this.jLabel54, -2, 233, -2))
/* 1927 */             .addComponent(this.jLabel70)
/* 1928 */             .addComponent(this.jLabel55, -2, 286, -2)
/* 1929 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1930 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1931 */                 .addComponent(this.jLabel74, -2, 184, -2)
/* 1932 */                 .addComponent(this.jLabel73))
/* 1933 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 1934 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1935 */                 .addComponent(this.jLabel76, -2, 88, -2)
/* 1936 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/* 1937 */                   .addGap(20, 20, 20)
/* 1938 */                   .addComponent(this.jLabel75)))))
/* 1939 */           .addContainerGap()));
/*      */     
/* 1941 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1942 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1943 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1944 */           .addContainerGap()
/* 1945 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1946 */             .addComponent(this.jLabel67)
/* 1947 */             .addComponent(this.jLabel54))
/* 1948 */           .addGap(18, 18, 18)
/* 1949 */           .addComponent(this.jLabel70)
/* 1950 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1951 */           .addComponent(this.jLabel55)
/* 1952 */           .addGap(18, 18, 18)
/* 1953 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1954 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1955 */               .addComponent(this.jLabel73)
/* 1956 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1957 */               .addComponent(this.jLabel74))
/* 1958 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1959 */               .addComponent(this.jLabel75)
/* 1960 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1961 */               .addComponent(this.jLabel76)))
/* 1962 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1965 */     this.jPanel5.setBorder(BorderFactory.createEtchedBorder(0));
/*      */     
/* 1967 */     this.jLabel77.setForeground(Color.darkGray);
/* 1968 */     this.jLabel77.setHorizontalAlignment(0);
/* 1969 */     this.jLabel77.setText("Observaciones:");
/*      */     
/* 1971 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1972 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1973 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1975 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1976 */           .addComponent(this.jLabel77, -1, 309, 32767)
/* 1977 */           .addContainerGap()));
/*      */     
/* 1979 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1981 */         .addComponent(this.jLabel77));
/*      */ 
/*      */     
/* 1984 */     this.jTextArea1.setColumns(20);
/* 1985 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 11));
/* 1986 */     this.jTextArea1.setLineWrap(true);
/* 1987 */     this.jTextArea1.setRows(5);
/* 1988 */     this.jTextArea1.setText("GASTOS PARA LA GUÍA PR-00001");
/* 1989 */     this.jTextArea1.setEnabled(false);
/* 1990 */     this.jScrollPane6.setViewportView(this.jTextArea1);
/*      */     
/* 1992 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1993 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1994 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1995 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1996 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1997 */           .addContainerGap()
/* 1998 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1999 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 2000 */               .addComponent(this.jLabel65, -2, 34, -2)
/* 2001 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2002 */               .addComponent(this.jTextField5, -2, 74, -2)
/* 2003 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, 32767)
/* 2004 */               .addComponent(this.jLabel66, -2, 42, -2)
/* 2005 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2006 */               .addComponent(this.jTextField7, -2, 82, -2)
/* 2007 */               .addGap(21, 21, 21))
/* 2008 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 2009 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2010 */                 .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 2011 */                 .addComponent(this.jLabel64, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 2012 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2013 */                   .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING)
/* 2014 */                   .addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 2015 */               .addContainerGap())
/* 2016 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 2017 */               .addComponent(this.jLabel53, -2, 143, -2)
/* 2018 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, 32767)
/* 2019 */               .addComponent(this.jButton23, -2, 102, -2)
/* 2020 */               .addGap(18, 18, 18))))
/* 2021 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2022 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 2023 */             .addContainerGap()
/* 2024 */             .addComponent(this.jPanel5, -2, -1, -2)
/* 2025 */             .addContainerGap(18, 32767))));
/*      */     
/* 2027 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 2028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2029 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2030 */           .addComponent(this.jLabel64)
/* 2031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2032 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2033 */             .addComponent(this.jLabel65)
/* 2034 */             .addComponent(this.jTextField5, -2, -1, -2)
/* 2035 */             .addComponent(this.jLabel66)
/* 2036 */             .addComponent(this.jTextField7, -2, -1, -2))
/* 2037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2038 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 2039 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2040 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 2041 */           .addGap(36, 36, 36)
/* 2042 */           .addComponent(this.jScrollPane6, -2, 136, -2)
/* 2043 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2044 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2045 */             .addComponent(this.jLabel53, -2, -1, -2)
/* 2046 */             .addComponent(this.jButton23))
/* 2047 */           .addContainerGap(24, 32767))
/* 2048 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2049 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 2050 */             .addGap(221, 221, 221)
/* 2051 */             .addComponent(this.jPanel5, -2, -1, -2)
/* 2052 */             .addContainerGap(195, 32767))));
/*      */ 
/*      */     
/* 2055 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 2056 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 2057 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 2058 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2059 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */     
/* 2061 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 2062 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2063 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */ 
/*      */     
/* 2066 */     this.jDialog5.setTitle("Búsqueda de Vales Diesel");
/* 2067 */     this.jDialog5.setModal(true);
/*      */     
/* 2069 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/* 2071 */     this.jLabel78.setFont(new Font("Tahoma", 1, 16));
/* 2072 */     this.jLabel78.setForeground(new Color(0, 102, 102));
/* 2073 */     this.jLabel78.setHorizontalAlignment(0);
/* 2074 */     this.jLabel78.setText("Búsqueda de Vales");
/*      */     
/* 2076 */     this.jPanel41.setBackground(new Color(146, 193, 134));
/* 2077 */     this.jPanel41.setBorder(BorderFactory.createTitledBorder(null, "Listado de Vales ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2079 */     this.jLabel28.setText("Vales Asignados");
/*      */     
/* 2081 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2082 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 2083 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2085 */             Liquidaciones.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2089 */     this.jLabel52.setText("Expedido por");
/*      */     
/* 2091 */     this.jLabel79.setText("Litros");
/*      */     
/* 2093 */     this.jTextField12.setHorizontalAlignment(4);
/* 2094 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2096 */             Liquidaciones.this.jTextField12FocusGained(evt);
/*      */           }
/*      */         });
/* 2099 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2101 */             Liquidaciones.this.jTextField12KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 2104 */             Liquidaciones.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2108 */     this.jLabel80.setText("Precio");
/*      */     
/* 2110 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/* 2111 */     this.jFormattedTextField5.setFont(new Font("Tahoma", 1, 11));
/* 2112 */     this.jFormattedTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2114 */             Liquidaciones.this.jFormattedTextField5KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 2117 */             Liquidaciones.this.jFormattedTextField5KeyReleased(evt);
/*      */           }
/*      */           public void keyTyped(KeyEvent evt) {
/* 2120 */             Liquidaciones.this.jFormattedTextField5KeyTyped(evt);
/*      */           }
/*      */         });
/*      */     
/* 2124 */     this.jLabel81.setText("Total");
/*      */     
/* 2126 */     this.jFormattedTextField6.setEditable(false);
/* 2127 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/* 2128 */     this.jFormattedTextField6.setFont(new Font("Tahoma", 1, 11));
/* 2129 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2131 */             Liquidaciones.this.jFormattedTextField6FocusGained(evt);
/*      */           }
/*      */         });
/*      */     
/* 2135 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 2136 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Expedido por", "Litros", "Precio", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2144 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2149 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2152 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 2154 */     this.jLabel83.setFont(new Font("Tahoma", 1, 11));
/* 2155 */     this.jLabel83.setText("Vales de Diesel Complementados:");
/*      */     
/* 2157 */     this.jButton6.setMnemonic('Q');
/* 2158 */     this.jButton6.setText("Quitar");
/* 2159 */     this.jButton6.setToolTipText("Quitar Vale (Alt+Q)");
/* 2160 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2162 */             Liquidaciones.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2166 */     this.jButton17.setMnemonic('G');
/* 2167 */     this.jButton17.setText("Guardar");
/* 2168 */     this.jButton17.setToolTipText("Guardar Vale (Alt+G)");
/* 2169 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2171 */             Liquidaciones.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2175 */     this.jButton18.setMnemonic('S');
/* 2176 */     this.jButton18.setText("Descontar Diesel");
/* 2177 */     this.jButton18.setToolTipText("Saldar Vale (Alt+S)");
/* 2178 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2180 */             Liquidaciones.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2184 */     this.jButton26.setMnemonic('C');
/* 2185 */     this.jButton26.setText("Cargar");
/* 2186 */     this.jButton26.setToolTipText("Cargar Vale (Alt+C)");
/* 2187 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2189 */             Liquidaciones.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2193 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 2194 */     this.jPanel41.setLayout(jPanel41Layout);
/* 2195 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 2196 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2197 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2198 */           .addContainerGap()
/* 2199 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2200 */             .addComponent(this.jScrollPane1, -2, 0, 32767)
/* 2201 */             .addGroup(jPanel41Layout.createSequentialGroup()
/* 2202 */               .addComponent(this.jLabel28, -2, 100, -2)
/* 2203 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2204 */               .addComponent(this.jComboBox3, -2, 112, -2))
/* 2205 */             .addComponent(this.jSeparator12)
/* 2206 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
/* 2207 */               .addComponent(this.jButton18, -2, 125, -2)
/* 2208 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2209 */               .addComponent(this.jButton17, -2, 92, -2)
/* 2210 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2211 */               .addComponent(this.jButton6, -2, 92, -2))
/* 2212 */             .addGroup(jPanel41Layout.createSequentialGroup()
/* 2213 */               .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2214 */                 .addGroup(jPanel41Layout.createSequentialGroup()
/* 2215 */                   .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2216 */                     .addComponent(this.jTextField11, -2, 136, -2)
/* 2217 */                     .addComponent(this.jLabel52, -2, 109, -2))
/* 2218 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2219 */                   .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2220 */                     .addComponent(this.jLabel79, -2, 37, -2)
/* 2221 */                     .addComponent(this.jTextField12, -2, 77, -2))
/* 2222 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2223 */                   .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2224 */                     .addComponent(this.jFormattedTextField5, -2, 71, -2)
/* 2225 */                     .addComponent(this.jLabel80, -2, 41, -2)))
/* 2226 */                 .addComponent(this.jLabel83, -2, 253, -2))
/* 2227 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2228 */               .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2229 */                 .addComponent(this.jButton26, -1, -1, 32767)
/* 2230 */                 .addComponent(this.jLabel81, -2, 53, -2)
/* 2231 */                 .addComponent(this.jFormattedTextField6))))
/* 2232 */           .addContainerGap()));
/*      */     
/* 2234 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 2235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2237 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2238 */             .addComponent(this.jLabel28)
/* 2239 */             .addComponent(this.jComboBox3, -2, -1, -2))
/* 2240 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2241 */           .addComponent(this.jSeparator12, -2, 10, -2)
/* 2242 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2243 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2244 */             .addGroup(jPanel41Layout.createSequentialGroup()
/* 2245 */               .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2246 */                 .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2247 */                   .addComponent(this.jLabel52)
/* 2248 */                   .addComponent(this.jLabel79))
/* 2249 */                 .addComponent(this.jLabel80))
/* 2250 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2251 */               .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2252 */                 .addComponent(this.jTextField11, -2, -1, -2)
/* 2253 */                 .addComponent(this.jTextField12, -2, -1, -2)
/* 2254 */                 .addComponent(this.jFormattedTextField5, -2, -1, -2)))
/* 2255 */             .addGroup(jPanel41Layout.createSequentialGroup()
/* 2256 */               .addComponent(this.jLabel81)
/* 2257 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2258 */               .addComponent(this.jFormattedTextField6, -2, -1, -2)))
/* 2259 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2260 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2261 */             .addComponent(this.jLabel83)
/* 2262 */             .addComponent(this.jButton26))
/* 2263 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2264 */           .addComponent(this.jScrollPane1, -2, 93, -2)
/* 2265 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2266 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2267 */             .addComponent(this.jButton6)
/* 2268 */             .addComponent(this.jButton17)
/* 2269 */             .addComponent(this.jButton18))
/* 2270 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2273 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 2274 */     this.jPanel9.setLayout(jPanel9Layout);
/* 2275 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 2276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2277 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2278 */           .addContainerGap()
/* 2279 */           .addComponent(this.jPanel41, -2, -1, -2)
/* 2280 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2281 */           .addComponent(this.jSeparator11, -1, 10, 32767)
/* 2282 */           .addGap(10, 10, 10))
/* 2283 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2284 */           .addGroup(jPanel9Layout.createSequentialGroup()
/* 2285 */             .addGap(8, 8, 8)
/* 2286 */             .addComponent(this.jLabel78, -2, 407, -2)
/* 2287 */             .addContainerGap(17, 32767))));
/*      */     
/* 2289 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 2290 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2291 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2292 */           .addGap(31, 31, 31)
/* 2293 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2294 */             .addComponent(this.jPanel41, -2, -1, -2)
/* 2295 */             .addComponent(this.jSeparator11, -2, 10, -2))
/* 2296 */           .addContainerGap(16, 32767))
/* 2297 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2298 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 2299 */             .addComponent(this.jLabel78, -2, 31, -2)
/* 2300 */             .addContainerGap(293, 32767))));
/*      */ 
/*      */     
/* 2303 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 2304 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 2305 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 2306 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2307 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */     
/* 2309 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 2310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2311 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */ 
/*      */     
/* 2314 */     this.jDialog6.setTitle("Agregar Premios");
/* 2315 */     this.jDialog6.setModal(true);
/*      */     
/* 2317 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/* 2319 */     this.jLabel84.setFont(new Font("Tahoma", 1, 16));
/* 2320 */     this.jLabel84.setForeground(new Color(0, 102, 102));
/* 2321 */     this.jLabel84.setHorizontalAlignment(0);
/* 2322 */     this.jLabel84.setText("Premios");
/*      */     
/* 2324 */     this.jPanel42.setBackground(new Color(146, 193, 134));
/* 2325 */     this.jPanel42.setBorder(BorderFactory.createTitledBorder(null, "Listado de Premios ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2327 */     this.jLabel86.setText("Concepto");
/*      */     
/* 2329 */     this.jLabel88.setText("Cantidad");
/*      */     
/* 2331 */     this.jFormattedTextField7.setHorizontalAlignment(4);
/* 2332 */     this.jFormattedTextField7.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 2334 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Concepto", "Cantidad" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2342 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2347 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2350 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/* 2352 */     this.jLabel91.setFont(new Font("Tahoma", 1, 11));
/* 2353 */     this.jLabel91.setText("Premios Registrados:");
/*      */     
/* 2355 */     this.jButton24.setMnemonic('Q');
/* 2356 */     this.jButton24.setText("Quitar");
/* 2357 */     this.jButton24.setToolTipText("Quitar Vale (Alt+Q)");
/* 2358 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2360 */             Liquidaciones.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2364 */     this.jButton25.setMnemonic('G');
/* 2365 */     this.jButton25.setText("Guardar");
/* 2366 */     this.jButton25.setToolTipText("Guardar Vale (Alt+G)");
/* 2367 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2369 */             Liquidaciones.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2373 */     this.jButton29.setMnemonic('C');
/* 2374 */     this.jButton29.setText("Cargar");
/* 2375 */     this.jButton29.setToolTipText("Cargar Vale (Alt+C)");
/* 2376 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2378 */             Liquidaciones.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2382 */     this.jLabel157.setText("Total:");
/*      */     
/* 2384 */     this.jLabel158.setFont(new Font("Tahoma", 1, 11));
/* 2385 */     this.jLabel158.setForeground(Color.blue);
/* 2386 */     this.jLabel158.setHorizontalAlignment(4);
/* 2387 */     this.jLabel158.setText("jLabel158");
/*      */     
/* 2389 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 2390 */     this.jPanel42.setLayout(jPanel42Layout);
/* 2391 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 2392 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2393 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 2394 */           .addContainerGap()
/* 2395 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2396 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 2397 */               .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2398 */                 .addComponent(this.jLabel86, -2, 71, -2)
/* 2399 */                 .addComponent(this.jTextField13, -1, 258, 32767))
/* 2400 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2401 */               .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2402 */                 .addComponent(this.jLabel88, -2, 73, -2)
/* 2403 */                 .addComponent(this.jFormattedTextField7, -2, 109, -2)))
/* 2404 */             .addComponent(this.jScrollPane7, -1, 373, 32767)
/* 2405 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
/* 2406 */               .addComponent(this.jLabel157, -2, 39, -2)
/* 2407 */               .addGap(18, 18, 18)
/* 2408 */               .addComponent(this.jLabel158, -1, 96, 32767)
/* 2409 */               .addGap(30, 30, 30)
/* 2410 */               .addComponent(this.jButton25, -2, 92, -2)
/* 2411 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2412 */               .addComponent(this.jButton24, -2, 92, -2))
/* 2413 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 2414 */               .addComponent(this.jLabel91, -2, 224, -2)
/* 2415 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, 32767)
/* 2416 */               .addComponent(this.jButton29)))
/* 2417 */           .addContainerGap()));
/*      */     
/* 2419 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 2420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2421 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 2422 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2423 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 2424 */               .addComponent(this.jLabel86)
/* 2425 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2426 */               .addComponent(this.jTextField13, -2, -1, -2))
/* 2427 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 2428 */               .addComponent(this.jLabel88)
/* 2429 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2430 */               .addComponent(this.jFormattedTextField7, -2, -1, -2)))
/* 2431 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2432 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2433 */             .addComponent(this.jLabel91)
/* 2434 */             .addComponent(this.jButton29))
/* 2435 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2436 */           .addComponent(this.jScrollPane7, -2, 93, -2)
/* 2437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2438 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2439 */             .addComponent(this.jButton24)
/* 2440 */             .addComponent(this.jButton25)
/* 2441 */             .addComponent(this.jLabel157)
/* 2442 */             .addComponent(this.jLabel158))
/* 2443 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2446 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2447 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2448 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 2449 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2450 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2451 */           .addContainerGap()
/* 2452 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 2453 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2454 */           .addComponent(this.jSeparator14, -1, 0, 32767)
/* 2455 */           .addGap(414, 414, 414))
/* 2456 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2457 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 2458 */             .addGap(8, 8, 8)
/* 2459 */             .addComponent(this.jLabel84, -2, 407, -2)
/* 2460 */             .addContainerGap(421, 32767))));
/*      */     
/* 2462 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 2463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2464 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2465 */           .addGap(31, 31, 31)
/* 2466 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2467 */             .addComponent(this.jPanel42, -2, -1, -2)
/* 2468 */             .addComponent(this.jSeparator14, -2, 10, -2))
/* 2469 */           .addContainerGap(-1, 32767))
/* 2470 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2471 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 2472 */             .addComponent(this.jLabel84, -2, 31, -2)
/* 2473 */             .addContainerGap(247, 32767))));
/*      */ 
/*      */     
/* 2476 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2477 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2478 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2479 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2480 */         .addComponent(this.jPanel11, -2, 425, -2));
/*      */     
/* 2482 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2484 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 2487 */     this.jDialog7.setTitle("Registrar Otros Gastos");
/* 2488 */     this.jDialog7.setModal(true);
/*      */     
/* 2490 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/* 2492 */     this.jLabel85.setFont(new Font("Tahoma", 1, 16));
/* 2493 */     this.jLabel85.setForeground(new Color(0, 102, 102));
/* 2494 */     this.jLabel85.setHorizontalAlignment(0);
/* 2495 */     this.jLabel85.setText("Otros Gastos");
/*      */     
/* 2497 */     this.jPanel43.setBackground(new Color(146, 193, 134));
/* 2498 */     this.jPanel43.setBorder(BorderFactory.createTitledBorder(null, "Listado de Vales ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2500 */     this.jLabel87.setText("Concepto");
/*      */     
/* 2502 */     this.jLabel89.setHorizontalAlignment(0);
/* 2503 */     this.jLabel89.setText("Folio o Referencia");
/*      */     
/* 2505 */     this.jFormattedTextField8.setHorizontalAlignment(4);
/* 2506 */     this.jFormattedTextField8.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 2508 */     this.jTable7.setFont(new Font("Tahoma", 0, 10));
/* 2509 */     this.jTable7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2517 */     this.jScrollPane8.setViewportView(this.jTable7);
/*      */     
/* 2519 */     this.jLabel92.setFont(new Font("Tahoma", 1, 11));
/* 2520 */     this.jLabel92.setText("Premios Registrados:");
/*      */     
/* 2522 */     this.jButton27.setMnemonic('Q');
/* 2523 */     this.jButton27.setText("Quitar");
/* 2524 */     this.jButton27.setToolTipText("Quitar Vale (Alt+Q)");
/* 2525 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2527 */             Liquidaciones.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2531 */     this.jButton28.setMnemonic('G');
/* 2532 */     this.jButton28.setText("Guardar");
/* 2533 */     this.jButton28.setToolTipText("Guardar Vale (Alt+G)");
/* 2534 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2536 */             Liquidaciones.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2540 */     this.jDateChooser2.setDate(this.fechaActual);
/* 2541 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/* 2542 */     this.jDateChooser2.setIcon(this.icon);
/*      */     
/* 2544 */     this.jLabel90.setText("Fecha");
/*      */     
/* 2546 */     this.jLabel93.setText("Cantidad");
/*      */     
/* 2548 */     this.jButton30.setMnemonic('C');
/* 2549 */     this.jButton30.setText("Cargar");
/* 2550 */     this.jButton30.setToolTipText("Cargar (Alt+C)");
/* 2551 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2553 */             Liquidaciones.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2557 */     this.jLabel159.setText("Total: ");
/*      */     
/* 2559 */     this.jLabel160.setFont(new Font("Tahoma", 1, 11));
/* 2560 */     this.jLabel160.setForeground(Color.blue);
/* 2561 */     this.jLabel160.setHorizontalAlignment(4);
/* 2562 */     this.jLabel160.setText("jLabel160");
/*      */     
/* 2564 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 2565 */     this.jPanel43.setLayout(jPanel43Layout);
/* 2566 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 2567 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2568 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2569 */           .addContainerGap()
/* 2570 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2571 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 2572 */               .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2573 */                 .addComponent(this.jTextField14)
/* 2574 */                 .addComponent(this.jLabel87, -2, 71, -2))
/* 2575 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2576 */               .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2577 */                 .addComponent(this.jLabel89, -1, -1, 32767)
/* 2578 */                 .addComponent(this.jTextField15, -2, 128, -2)))
/* 2579 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 2580 */               .addComponent((Component)this.jDateChooser2, -2, 102, -2)
/* 2581 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2582 */               .addComponent(this.jFormattedTextField8, -2, 109, -2)
/* 2583 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2584 */               .addComponent(this.jButton30, -2, 78, -2))
/* 2585 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 2586 */               .addComponent(this.jLabel90, -2, 71, -2)
/* 2587 */               .addGap(40, 40, 40)
/* 2588 */               .addComponent(this.jLabel93, -2, 75, -2))
/* 2589 */             .addComponent(this.jScrollPane8, -1, 484, 32767)
/* 2590 */             .addComponent(this.jLabel92, -2, 224, -2)
/* 2591 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 2592 */               .addComponent(this.jLabel159)
/* 2593 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2594 */               .addComponent(this.jLabel160, -2, 99, -2)
/* 2595 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2596 */               .addComponent(this.jButton28, -2, 92, -2)
/* 2597 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2598 */               .addComponent(this.jButton27, -2, 92, -2)))
/* 2599 */           .addContainerGap()));
/*      */     
/* 2601 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 2602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2603 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2604 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2605 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 2606 */               .addComponent(this.jLabel87)
/* 2607 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2608 */               .addComponent(this.jTextField14, -2, -1, -2))
/* 2609 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 2610 */               .addComponent(this.jLabel89)
/* 2611 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2612 */               .addComponent(this.jTextField15, -2, -1, -2)))
/* 2613 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2614 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2615 */             .addComponent(this.jLabel90)
/* 2616 */             .addComponent(this.jLabel93))
/* 2617 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2618 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2619 */             .addComponent((Component)this.jDateChooser2, -2, -1, -2)
/* 2620 */             .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2621 */               .addComponent(this.jFormattedTextField8, -2, -1, -2)
/* 2622 */               .addComponent(this.jButton30)))
/* 2623 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2624 */           .addComponent(this.jLabel92)
/* 2625 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2626 */           .addComponent(this.jScrollPane8, -2, 93, -2)
/* 2627 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2628 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2629 */             .addComponent(this.jButton27)
/* 2630 */             .addComponent(this.jButton28)
/* 2631 */             .addComponent(this.jLabel159)
/* 2632 */             .addComponent(this.jLabel160))
/* 2633 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2636 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 2637 */     this.jPanel12.setLayout(jPanel12Layout);
/* 2638 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 2639 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2640 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2641 */           .addContainerGap()
/* 2642 */           .addComponent(this.jPanel43, -1, -1, 32767)
/* 2643 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2644 */           .addComponent(this.jSeparator15)
/* 2645 */           .addContainerGap())
/* 2646 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2647 */           .addGroup(jPanel12Layout.createSequentialGroup()
/* 2648 */             .addGap(8, 8, 8)
/* 2649 */             .addComponent(this.jLabel85, -2, 470, -2)
/* 2650 */             .addContainerGap(59, 32767))));
/*      */     
/* 2652 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 2653 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2654 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2655 */           .addGap(31, 31, 31)
/* 2656 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2657 */             .addComponent(this.jPanel43, -1, -1, 32767)
/* 2658 */             .addComponent(this.jSeparator15, -2, 10, -2))
/* 2659 */           .addGap(24, 24, 24))
/* 2660 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2661 */           .addGroup(jPanel12Layout.createSequentialGroup()
/* 2662 */             .addComponent(this.jLabel85, -2, 31, -2)
/* 2663 */             .addContainerGap(305, 32767))));
/*      */ 
/*      */     
/* 2666 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2667 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2668 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2669 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2670 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 2672 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2674 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */ 
/*      */     
/* 2677 */     this.jDialog8.setTitle("Dialogo 1");
/* 2678 */     this.jDialog8.setModal(true);
/*      */     
/* 2680 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 2682 */     this.jLabel97.setFont(new Font("Tahoma", 1, 16));
/* 2683 */     this.jLabel97.setForeground(new Color(0, 102, 102));
/* 2684 */     this.jLabel97.setHorizontalAlignment(0);
/* 2685 */     this.jLabel97.setText("Otros Gastos");
/*      */     
/* 2687 */     this.jTable9.setFont(new Font("Tahoma", 0, 10));
/* 2688 */     this.jTable9.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2699 */     this.jScrollPane10.setViewportView(this.jTable9);
/*      */     
/* 2701 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2702 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2703 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2704 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2705 */         .addComponent(this.jScrollPane10, GroupLayout.Alignment.TRAILING, -1, 726, 32767)
/* 2706 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2707 */           .addGroup(jPanel13Layout.createSequentialGroup()
/* 2708 */             .addGap(8, 8, 8)
/* 2709 */             .addComponent(this.jLabel97, -2, 407, -2)
/* 2710 */             .addContainerGap(311, 32767))));
/*      */     
/* 2712 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2713 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2714 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2715 */           .addGap(31, 31, 31)
/* 2716 */           .addComponent(this.jScrollPane10, -2, 351, -2)
/* 2717 */           .addContainerGap(20, 32767))
/* 2718 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2719 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 2720 */             .addComponent(this.jLabel97, -2, 31, -2)
/* 2721 */             .addContainerGap(371, 32767))));
/*      */ 
/*      */     
/* 2724 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2725 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2726 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2727 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2728 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */     
/* 2730 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2731 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2732 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */ 
/*      */     
/* 2735 */     this.jDialog9.setTitle("Dialogo 2");
/*      */     
/* 2737 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/*      */     
/* 2739 */     this.jLabel98.setFont(new Font("Tahoma", 1, 16));
/* 2740 */     this.jLabel98.setForeground(new Color(0, 102, 102));
/* 2741 */     this.jLabel98.setHorizontalAlignment(0);
/* 2742 */     this.jLabel98.setText("Otros Gastos");
/*      */     
/* 2744 */     this.jTable10.setFont(new Font("Tahoma", 0, 10));
/* 2745 */     this.jTable10.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2756 */     this.jScrollPane11.setViewportView(this.jTable10);
/*      */     
/* 2758 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 2759 */     this.jPanel14.setLayout(jPanel14Layout);
/* 2760 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 2761 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2762 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2763 */           .addContainerGap()
/* 2764 */           .addComponent(this.jScrollPane11, -1, 699, 32767)
/* 2765 */           .addGap(21, 21, 21))
/* 2766 */         .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2767 */           .addGroup(jPanel14Layout.createSequentialGroup()
/* 2768 */             .addGap(8, 8, 8)
/* 2769 */             .addComponent(this.jLabel98, -2, 407, -2)
/* 2770 */             .addContainerGap(311, 32767))));
/*      */     
/* 2772 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 2773 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2774 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2775 */           .addGap(31, 31, 31)
/* 2776 */           .addComponent(this.jScrollPane11, -2, 351, -2)
/* 2777 */           .addContainerGap(20, 32767))
/* 2778 */         .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2779 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 2780 */             .addComponent(this.jLabel98, -2, 31, -2)
/* 2781 */             .addContainerGap(371, 32767))));
/*      */ 
/*      */     
/* 2784 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2785 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2786 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2787 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2788 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */     
/* 2790 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2792 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */ 
/*      */     
/* 2795 */     this.jDialog10.setTitle("Dialogo 3");
/*      */     
/* 2797 */     this.jPanel15.setBackground(new Color(146, 193, 134));
/*      */     
/* 2799 */     this.jLabel99.setFont(new Font("Tahoma", 1, 16));
/* 2800 */     this.jLabel99.setForeground(new Color(0, 102, 102));
/* 2801 */     this.jLabel99.setHorizontalAlignment(0);
/* 2802 */     this.jLabel99.setText("Otros Gastos");
/*      */     
/* 2804 */     this.jTable11.setFont(new Font("Tahoma", 0, 10));
/* 2805 */     this.jTable11.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2816 */     this.jScrollPane12.setViewportView(this.jTable11);
/*      */     
/* 2818 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 2819 */     this.jPanel15.setLayout(jPanel15Layout);
/* 2820 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 2821 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2822 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2823 */           .addContainerGap()
/* 2824 */           .addComponent(this.jScrollPane12, -1, 699, 32767)
/* 2825 */           .addGap(21, 21, 21))
/* 2826 */         .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2827 */           .addGroup(jPanel15Layout.createSequentialGroup()
/* 2828 */             .addGap(8, 8, 8)
/* 2829 */             .addComponent(this.jLabel99, -2, 407, -2)
/* 2830 */             .addContainerGap(311, 32767))));
/*      */     
/* 2832 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 2833 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2834 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2835 */           .addGap(31, 31, 31)
/* 2836 */           .addComponent(this.jScrollPane12, -2, 351, -2)
/* 2837 */           .addContainerGap(20, 32767))
/* 2838 */         .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2839 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/* 2840 */             .addComponent(this.jLabel99, -2, 31, -2)
/* 2841 */             .addContainerGap(371, 32767))));
/*      */ 
/*      */     
/* 2844 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2845 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2846 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2848 */         .addComponent(this.jPanel15, -1, -1, 32767));
/*      */     
/* 2850 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2851 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2852 */         .addComponent(this.jPanel15, -1, -1, 32767));
/*      */ 
/*      */     
/* 2855 */     this.jDialog11.setTitle("Gastos Asignados");
/* 2856 */     this.jDialog11.setModal(true);
/*      */     
/* 2858 */     this.jPanel16.setBackground(new Color(146, 193, 134));
/*      */     
/* 2860 */     this.jLabel100.setFont(new Font("Tahoma", 1, 16));
/* 2861 */     this.jLabel100.setHorizontalAlignment(0);
/* 2862 */     this.jLabel100.setText("Gastos Asignados");
/*      */     
/* 2864 */     this.jTable12.setFont(new Font("Tahoma", 0, 10));
/* 2865 */     this.jTable12.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2873 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2878 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2881 */     this.jTable12.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2883 */             Liquidaciones.this.jTable12MouseClicked(evt);
/*      */           }
/*      */         });
/* 2886 */     this.jScrollPane13.setViewportView(this.jTable12);
/*      */     
/* 2888 */     this.jButton32.setMnemonic('C');
/* 2889 */     this.jButton32.setText("Cerrar");
/* 2890 */     this.jButton32.setToolTipText("Cerrar (Alt+C)");
/* 2891 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2893 */             Liquidaciones.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2897 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2898 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2899 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 2900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2901 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/* 2902 */           .addContainerGap()
/* 2903 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2904 */             .addComponent(this.jScrollPane13, GroupLayout.Alignment.LEADING, -1, 492, 32767)
/* 2905 */             .addComponent(this.jSeparator13, -1, 492, 32767)
/* 2906 */             .addComponent(this.jButton32, -2, 83, -2))
/* 2907 */           .addContainerGap())
/* 2908 */         .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2909 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/* 2910 */             .addGap(8, 8, 8)
/* 2911 */             .addComponent(this.jLabel100, -1, 494, 32767)
/* 2912 */             .addGap(10, 10, 10))));
/*      */     
/* 2914 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 2915 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2916 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 2917 */           .addGap(31, 31, 31)
/* 2918 */           .addComponent(this.jSeparator13, -2, 10, -2)
/* 2919 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2920 */           .addComponent(this.jScrollPane13, -2, 158, -2)
/* 2921 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2922 */           .addComponent(this.jButton32)
/* 2923 */           .addContainerGap(-1, 32767))
/* 2924 */         .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2925 */           .addGroup(jPanel16Layout.createSequentialGroup()
/* 2926 */             .addComponent(this.jLabel100, -2, 31, -2)
/* 2927 */             .addContainerGap(219, 32767))));
/*      */ 
/*      */     
/* 2930 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 2931 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 2932 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 2933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2934 */         .addComponent(this.jPanel16, -1, -1, 32767));
/*      */     
/* 2936 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 2937 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2938 */         .addComponent(this.jPanel16, -2, -1, -2));
/*      */ 
/*      */     
/* 2941 */     this.jDialog12.setTitle("Saldo en Tarjeta Deudor");
/* 2942 */     this.jDialog12.setModal(true);
/*      */     
/* 2944 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*      */     
/* 2946 */     this.jLabel101.setFont(new Font("Tahoma", 1, 16));
/* 2947 */     this.jLabel101.setHorizontalAlignment(0);
/* 2948 */     this.jLabel101.setText("Saldo en Tarjeta Deudor");
/*      */     
/* 2950 */     this.jTable13.setFont(new Font("Tahoma", 0, 10));
/* 2951 */     this.jTable13.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2959 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2964 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2967 */     this.jTable13.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2969 */             Liquidaciones.this.jTable13MouseClicked(evt);
/*      */           }
/*      */         });
/* 2972 */     this.jScrollPane14.setViewportView(this.jTable13);
/*      */     
/* 2974 */     this.jButton33.setMnemonic('C');
/* 2975 */     this.jButton33.setText("Cerrar");
/* 2976 */     this.jButton33.setToolTipText("Cerrar (Alt+C)");
/* 2977 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2979 */             Liquidaciones.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2983 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 2984 */     this.jPanel19.setLayout(jPanel19Layout);
/* 2985 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 2986 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2987 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2988 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2989 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/* 2990 */               .addContainerGap()
/* 2991 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2992 */                 .addComponent(this.jScrollPane14, GroupLayout.Alignment.LEADING, -1, 492, 32767)
/* 2993 */                 .addComponent(this.jSeparator19, -1, 492, 32767)
/* 2994 */                 .addComponent(this.jButton33, -2, 83, -2)))
/* 2995 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/* 2996 */               .addGap(8, 8, 8)
/* 2997 */               .addComponent(this.jLabel101, -1, 494, 32767)))
/* 2998 */           .addContainerGap()));
/*      */     
/* 3000 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 3001 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3002 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 3003 */           .addGap(5, 5, 5)
/* 3004 */           .addComponent(this.jLabel101)
/* 3005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3006 */           .addComponent(this.jSeparator19, -2, 10, -2)
/* 3007 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3008 */           .addComponent(this.jScrollPane14, -2, 158, -2)
/* 3009 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3010 */           .addComponent(this.jButton33)
/* 3011 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3014 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/* 3015 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/* 3016 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/* 3017 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3018 */         .addGap(0, 512, 32767)
/* 3019 */         .addComponent(this.jPanel19, -1, -1, 32767));
/*      */     
/* 3021 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/* 3022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3023 */         .addGap(0, 250, 32767)
/* 3024 */         .addComponent(this.jPanel19, -2, -1, -2));
/*      */ 
/*      */     
/* 3027 */     this.jDialog13.setTitle("Descripción para el Viaje");
/* 3028 */     this.jDialog13.setModal(true);
/*      */     
/* 3030 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/*      */     
/* 3032 */     this.jLabel102.setFont(new Font("Tahoma", 1, 16));
/* 3033 */     this.jLabel102.setHorizontalAlignment(0);
/* 3034 */     this.jLabel102.setText("Descripción del Viaje");
/*      */     
/* 3036 */     this.jLabel103.setHorizontalAlignment(4);
/* 3037 */     this.jLabel103.setText("H.R.S.P.");
/*      */     
/* 3039 */     this.jLabel104.setHorizontalAlignment(4);
/* 3040 */     this.jLabel104.setText("Tipo Carga");
/*      */     
/* 3042 */     this.jLabel107.setHorizontalAlignment(4);
/* 3043 */     this.jLabel107.setText("Origen");
/*      */     
/* 3045 */     this.jLabel108.setHorizontalAlignment(4);
/* 3046 */     this.jLabel108.setText("Destino");
/*      */     
/* 3048 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 3049 */     this.jComboBox7.setFont(new Font("Tahoma", 1, 11));
/* 3050 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Elije uno...", "Carg y Tira", "Tirada" }));
/* 3051 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3053 */             Liquidaciones.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3057 */     this.jLabel105.setHorizontalAlignment(4);
/* 3058 */     this.jLabel105.setText("Tarifa");
/*      */     
/* 3060 */     this.jFormattedTextField9.setHorizontalAlignment(4);
/* 3061 */     this.jFormattedTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3063 */             Liquidaciones.this.jFormattedTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3067 */     this.jRadioButton3.setSelected(true);
/* 3068 */     this.jRadioButton3.setText("Viaje");
/* 3069 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3071 */             Liquidaciones.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3075 */     this.jRadioButton4.setText("Toneada");
/* 3076 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3078 */             Liquidaciones.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3082 */     this.jLabel109.setHorizontalAlignment(4);
/* 3083 */     this.jLabel109.setText("Total");
/*      */     
/* 3085 */     this.jLabel110.setText("Gastos del Viaje");
/*      */     
/* 3087 */     this.jFormattedTextField12.setHorizontalAlignment(4);
/*      */     
/* 3089 */     this.jLabel111.setHorizontalAlignment(0);
/* 3090 */     this.jLabel111.setText("Autopistas");
/*      */     
/* 3092 */     this.jLabel112.setHorizontalAlignment(0);
/* 3093 */     this.jLabel112.setText("Otros Gastos");
/*      */     
/* 3095 */     this.jFormattedTextField13.setHorizontalAlignment(4);
/*      */     
/* 3097 */     this.jLabel113.setHorizontalAlignment(0);
/* 3098 */     this.jLabel113.setText("Llantas");
/*      */     
/* 3100 */     this.jFormattedTextField14.setHorizontalAlignment(4);
/*      */     
/* 3102 */     this.jButton34.setMnemonic('G');
/* 3103 */     this.jButton34.setText("Guardar");
/* 3104 */     this.jButton34.setToolTipText("Guardar (Alt+G)");
/* 3105 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3107 */             Liquidaciones.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3111 */     this.jTextField19.setHorizontalAlignment(4);
/* 3112 */     this.jTextField19.setEnabled(false);
/* 3113 */     this.jTextField19.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3115 */             Liquidaciones.this.jTextField19KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3119 */     this.jFormattedTextField10.setEditable(false);
/* 3120 */     this.jFormattedTextField10.setForeground(Color.blue);
/* 3121 */     this.jFormattedTextField10.setHorizontalAlignment(4);
/* 3122 */     this.jFormattedTextField10.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 3124 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 3125 */     this.jPanel20.setLayout(jPanel20Layout);
/* 3126 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 3127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3128 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 3129 */           .addContainerGap()
/* 3130 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3131 */             .addGroup(jPanel20Layout.createSequentialGroup()
/* 3132 */               .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3133 */                 .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3134 */                   .addComponent(this.jSeparator22, GroupLayout.Alignment.LEADING)
/* 3135 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3136 */                     .addGap(295, 295, 295)
/* 3137 */                     .addComponent(this.jButton34, -2, 87, -2)))
/* 3138 */                 .addGroup(jPanel20Layout.createSequentialGroup()
/* 3139 */                   .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3140 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3141 */                       .addComponent(this.jLabel110, -2, 90, -2)
/* 3142 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3143 */                       .addComponent(this.jFormattedTextField12))
/* 3144 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3145 */                       .addGap(96, 96, 96)
/* 3146 */                       .addComponent(this.jLabel111, -2, 89, -2)))
/* 3147 */                   .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3148 */                     .addGroup(jPanel20Layout.createSequentialGroup()
/* 3149 */                       .addGap(12, 12, 12)
/* 3150 */                       .addComponent(this.jLabel112, -2, 89, -2))
/* 3151 */                     .addGroup(jPanel20Layout.createSequentialGroup()
/* 3152 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3153 */                       .addComponent(this.jFormattedTextField13)))
/* 3154 */                   .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3155 */                     .addGroup(jPanel20Layout.createSequentialGroup()
/* 3156 */                       .addGap(8, 8, 8)
/* 3157 */                       .addComponent(this.jLabel113, -2, 89, -2))
/* 3158 */                     .addGroup(jPanel20Layout.createSequentialGroup()
/* 3159 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3160 */                       .addComponent(this.jFormattedTextField14))))
/* 3161 */                 .addGroup(jPanel20Layout.createSequentialGroup()
/* 3162 */                   .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3163 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3164 */                       .addComponent(this.jLabel103, -2, 51, -2)
/* 3165 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3166 */                       .addComponent(this.jTextField17, -2, 91, -2)
/* 3167 */                       .addGap(18, 18, 18)
/* 3168 */                       .addComponent(this.jLabel104, -2, 65, -2)
/* 3169 */                       .addGap(18, 18, 18)
/* 3170 */                       .addComponent(this.jTextField18, -1, 120, 32767))
/* 3171 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3172 */                       .addComponent(this.jLabel108, -2, 51, -2)
/* 3173 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3174 */                       .addComponent(this.jComboBox7, 0, 312, 32767))
/* 3175 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3176 */                       .addGap(14, 14, 14)
/* 3177 */                       .addComponent(this.jLabel105, -2, 50, -2)
/* 3178 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3179 */                       .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3180 */                         .addGroup(jPanel20Layout.createSequentialGroup()
/* 3181 */                           .addComponent(this.jFormattedTextField9, -2, 75, -2)
/* 3182 */                           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3183 */                           .addComponent(this.jTextField19, -2, 84, -2)
/* 3184 */                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3185 */                           .addComponent(this.jFormattedTextField10, -1, 124, 32767))
/* 3186 */                         .addGroup(jPanel20Layout.createSequentialGroup()
/* 3187 */                           .addComponent(this.jRadioButton3, -2, 75, -2)
/* 3188 */                           .addGap(10, 10, 10)
/* 3189 */                           .addComponent(this.jRadioButton4, -2, 114, -2)
/* 3190 */                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3191 */                           .addComponent(this.jLabel109, -2, 59, -2))))
/* 3192 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
/* 3193 */                       .addComponent(this.jLabel107, -2, 51, -2)
/* 3194 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3195 */                       .addComponent(this.jTextField22, -1, 312, 32767)))
/* 3196 */                   .addGap(51, 51, 51))
/* 3197 */                 .addComponent(this.jSeparator20, -2, 382, -2))
/* 3198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
/* 3199 */             .addComponent(this.jSeparator21, -2, 369, -2))
/* 3200 */           .addContainerGap())
/* 3201 */         .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3202 */           .addGroup(jPanel20Layout.createSequentialGroup()
/* 3203 */             .addGap(8, 8, 8)
/* 3204 */             .addComponent(this.jLabel102, -2, 368, -2)
/* 3205 */             .addContainerGap(52, 32767))));
/*      */     
/* 3207 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 3208 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3209 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
/* 3210 */           .addGap(31, 31, 31)
/* 3211 */           .addComponent(this.jSeparator20, -2, 10, -2)
/* 3212 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3213 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3214 */             .addComponent(this.jLabel103)
/* 3215 */             .addComponent(this.jTextField17, -2, -1, -2)
/* 3216 */             .addComponent(this.jTextField18, -2, -1, -2)
/* 3217 */             .addComponent(this.jLabel104))
/* 3218 */           .addGap(12, 12, 12)
/* 3219 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3220 */             .addComponent(this.jLabel107)
/* 3221 */             .addComponent(this.jTextField22, -2, -1, -2))
/* 3222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3223 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3224 */             .addComponent(this.jLabel108)
/* 3225 */             .addComponent(this.jComboBox7, -2, -1, -2))
/* 3226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3227 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3228 */             .addComponent(this.jRadioButton3)
/* 3229 */             .addComponent(this.jRadioButton4)
/* 3230 */             .addComponent(this.jLabel109))
/* 3231 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3232 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3233 */             .addComponent(this.jFormattedTextField9, -2, -1, -2)
/* 3234 */             .addComponent(this.jTextField19, -2, -1, -2)
/* 3235 */             .addComponent(this.jFormattedTextField10, -2, -1, -2)
/* 3236 */             .addComponent(this.jLabel105))
/* 3237 */           .addGap(19, 19, 19)
/* 3238 */           .addComponent(this.jSeparator21, -2, 10, -2)
/* 3239 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3240 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3241 */             .addGroup(jPanel20Layout.createSequentialGroup()
/* 3242 */               .addComponent(this.jLabel111)
/* 3243 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3244 */               .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3245 */                 .addComponent(this.jLabel110)
/* 3246 */                 .addComponent(this.jFormattedTextField12, -2, -1, -2)
/* 3247 */                 .addComponent(this.jFormattedTextField13, -2, -1, -2)))
/* 3248 */             .addGroup(jPanel20Layout.createSequentialGroup()
/* 3249 */               .addComponent(this.jLabel113)
/* 3250 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3251 */               .addComponent(this.jFormattedTextField14, -2, -1, -2))
/* 3252 */             .addComponent(this.jLabel112))
/* 3253 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3254 */           .addComponent(this.jSeparator22, -2, 10, -2)
/* 3255 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3256 */           .addComponent(this.jButton34)
/* 3257 */           .addContainerGap(20, 32767))
/* 3258 */         .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3259 */           .addGroup(jPanel20Layout.createSequentialGroup()
/* 3260 */             .addComponent(this.jLabel102, -2, 31, -2)
/* 3261 */             .addContainerGap(298, 32767))));
/*      */ 
/*      */     
/* 3264 */     GroupLayout jDialog13Layout = new GroupLayout(this.jDialog13.getContentPane());
/* 3265 */     this.jDialog13.getContentPane().setLayout(jDialog13Layout);
/* 3266 */     jDialog13Layout.setHorizontalGroup(jDialog13Layout
/* 3267 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3268 */         .addComponent(this.jPanel20, -2, -1, -2));
/*      */     
/* 3270 */     jDialog13Layout.setVerticalGroup(jDialog13Layout
/* 3271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3272 */         .addComponent(this.jPanel20, -1, -1, 32767));
/*      */ 
/*      */     
/* 3275 */     this.jDialog14.setTitle("Organizar Rutas");
/* 3276 */     this.jDialog14.setModal(true);
/* 3277 */     this.jDialog14.setResizable(false);
/*      */     
/* 3279 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/*      */     
/* 3281 */     this.jLabel106.setFont(new Font("Tahoma", 1, 15));
/* 3282 */     this.jLabel106.setForeground(new Color(0, 102, 102));
/* 3283 */     this.jLabel106.setHorizontalAlignment(0);
/* 3284 */     this.jLabel106.setText("ORIGEN");
/*      */     
/* 3286 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 3287 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, " Agregar Rutas ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 3289 */     this.jTextField20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3291 */             Liquidaciones.this.jTextField20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3295 */     this.jLabel114.setFont(new Font("Tahoma", 3, 11));
/* 3296 */     this.jLabel114.setForeground(new Color(15, 87, 51));
/* 3297 */     this.jLabel114.setHorizontalAlignment(4);
/* 3298 */     this.jLabel114.setText("Nombre");
/*      */     
/* 3300 */     this.jButton36.setMnemonic('A');
/* 3301 */     this.jButton36.setText("Agregar");
/* 3302 */     this.jButton36.setToolTipText("Agregar (Alt+A)");
/* 3303 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3305 */             Liquidaciones.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3309 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 3310 */     this.jPanel22.setLayout(jPanel22Layout);
/* 3311 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 3312 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3313 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 3314 */           .addContainerGap()
/* 3315 */           .addComponent(this.jLabel114, -2, 65, -2)
/* 3316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3317 */           .addComponent(this.jTextField20, -2, 197, -2)
/* 3318 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3319 */           .addComponent(this.jButton36)
/* 3320 */           .addContainerGap(12, 32767)));
/*      */     
/* 3322 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 3323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3324 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 3325 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3326 */             .addComponent(this.jLabel114)
/* 3327 */             .addComponent(this.jTextField20, -2, -1, -2)
/* 3328 */             .addComponent(this.jButton36))
/* 3329 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3332 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/* 3333 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, "Contenido de Origenes ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 3335 */     this.jTable14.setFont(new Font("Tahoma", 0, 10));
/* 3336 */     this.jTable14.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3344 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3349 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3352 */     this.jScrollPane15.setViewportView(this.jTable14);
/*      */     
/* 3354 */     this.jButton37.setMnemonic('E');
/* 3355 */     this.jButton37.setText("Eliminar");
/* 3356 */     this.jButton37.setToolTipText("Eliminar (Alt+E)");
/* 3357 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3359 */             Liquidaciones.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3363 */     this.jButton38.setMnemonic('C');
/* 3364 */     this.jButton38.setText("Cerrar");
/* 3365 */     this.jButton38.setToolTipText("Cerrar (Alt+C)");
/* 3366 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3368 */             Liquidaciones.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3372 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 3373 */     this.jPanel23.setLayout(jPanel23Layout);
/* 3374 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 3375 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3376 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 3377 */           .addContainerGap()
/* 3378 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3379 */             .addComponent(this.jScrollPane15, -1, 351, 32767)
/* 3380 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 3381 */               .addComponent(this.jButton37, -2, 83, -2)
/* 3382 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3383 */               .addComponent(this.jButton38, -2, 85, -2)))
/* 3384 */           .addContainerGap()));
/*      */     
/* 3386 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 3387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3388 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 3389 */           .addComponent(this.jScrollPane15, -2, 156, -2)
/* 3390 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3391 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3392 */             .addComponent(this.jButton38)
/* 3393 */             .addComponent(this.jButton37))
/* 3394 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3397 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 3398 */     this.jPanel21.setLayout(jPanel21Layout);
/* 3399 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 3400 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3401 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 3402 */           .addContainerGap()
/* 3403 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3404 */             .addComponent(this.jPanel23, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 3405 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel21Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3406 */               .addComponent(this.jPanel22, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 3407 */               .addComponent(this.jSeparator23, GroupLayout.Alignment.LEADING)
/* 3408 */               .addComponent(this.jLabel106, GroupLayout.Alignment.LEADING, -1, 381, 32767)))
/* 3409 */           .addContainerGap(18, 32767)));
/*      */     
/* 3411 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 3412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3413 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 3414 */           .addContainerGap()
/* 3415 */           .addComponent(this.jLabel106)
/* 3416 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3417 */           .addComponent(this.jSeparator23, -2, 10, -2)
/* 3418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3419 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 3420 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3421 */           .addComponent(this.jPanel23, -2, -1, -2)
/* 3422 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3425 */     GroupLayout jDialog14Layout = new GroupLayout(this.jDialog14.getContentPane());
/* 3426 */     this.jDialog14.getContentPane().setLayout(jDialog14Layout);
/* 3427 */     jDialog14Layout.setHorizontalGroup(jDialog14Layout
/* 3428 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3429 */         .addGap(0, 411, 32767)
/* 3430 */         .addGroup(jDialog14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3431 */           .addGroup(jDialog14Layout.createSequentialGroup()
/* 3432 */             .addGap(0, 0, 32767)
/* 3433 */             .addComponent(this.jPanel21, -2, -1, -2)
/* 3434 */             .addGap(0, 0, 32767))));
/*      */     
/* 3436 */     jDialog14Layout.setVerticalGroup(jDialog14Layout
/* 3437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3438 */         .addGap(0, 353, 32767)
/* 3439 */         .addGroup(jDialog14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3440 */           .addGroup(jDialog14Layout.createSequentialGroup()
/* 3441 */             .addGap(0, 1, 32767)
/* 3442 */             .addComponent(this.jPanel21, -2, -1, -2)
/* 3443 */             .addGap(0, 1, 32767))));
/*      */ 
/*      */     
/* 3446 */     this.jDialog15.setTitle("Organizar Destinos");
/* 3447 */     this.jDialog15.setModal(true);
/* 3448 */     this.jDialog15.setResizable(false);
/*      */     
/* 3450 */     this.jPanel24.setBackground(new Color(146, 193, 134));
/*      */     
/* 3452 */     this.jLabel115.setFont(new Font("Tahoma", 1, 15));
/* 3453 */     this.jLabel115.setForeground(new Color(0, 102, 102));
/* 3454 */     this.jLabel115.setHorizontalAlignment(0);
/* 3455 */     this.jLabel115.setText("DESTINOS");
/*      */     
/* 3457 */     this.jPanel25.setBackground(new Color(146, 193, 134));
/* 3458 */     this.jPanel25.setBorder(BorderFactory.createTitledBorder(null, " Agregar Destinos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 3460 */     this.jTextField21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3462 */             Liquidaciones.this.jTextField21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3466 */     this.jLabel116.setFont(new Font("Tahoma", 3, 11));
/* 3467 */     this.jLabel116.setForeground(new Color(15, 87, 51));
/* 3468 */     this.jLabel116.setHorizontalAlignment(4);
/* 3469 */     this.jLabel116.setText("Nombre");
/*      */     
/* 3471 */     this.jButton39.setMnemonic('A');
/* 3472 */     this.jButton39.setText("Agregar");
/* 3473 */     this.jButton39.setToolTipText("Agregar (Alt+A)");
/* 3474 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3476 */             Liquidaciones.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3480 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 3481 */     this.jPanel25.setLayout(jPanel25Layout);
/* 3482 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 3483 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3484 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 3485 */           .addContainerGap()
/* 3486 */           .addComponent(this.jLabel116, -2, 65, -2)
/* 3487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3488 */           .addComponent(this.jTextField21, -2, 197, -2)
/* 3489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3490 */           .addComponent(this.jButton39)
/* 3491 */           .addContainerGap(12, 32767)));
/*      */     
/* 3493 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 3494 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3495 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 3496 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3497 */             .addComponent(this.jLabel116)
/* 3498 */             .addComponent(this.jTextField21, -2, -1, -2)
/* 3499 */             .addComponent(this.jButton39))
/* 3500 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3503 */     this.jPanel26.setBackground(new Color(146, 193, 134));
/* 3504 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, "Contenido de Destinos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 3506 */     this.jTable15.setFont(new Font("Tahoma", 0, 10));
/* 3507 */     this.jTable15.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3515 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3520 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3523 */     this.jScrollPane16.setViewportView(this.jTable15);
/*      */     
/* 3525 */     this.jButton40.setMnemonic('E');
/* 3526 */     this.jButton40.setText("Eliminar");
/* 3527 */     this.jButton40.setToolTipText("Eliminar (Alt+E)");
/* 3528 */     this.jButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3530 */             Liquidaciones.this.jButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3534 */     this.jButton41.setMnemonic('C');
/* 3535 */     this.jButton41.setText("Cerrar");
/* 3536 */     this.jButton41.setToolTipText("Cerrar (Alt+C)");
/* 3537 */     this.jButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3539 */             Liquidaciones.this.jButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3543 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 3544 */     this.jPanel26.setLayout(jPanel26Layout);
/* 3545 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 3546 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3547 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 3548 */           .addContainerGap()
/* 3549 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3550 */             .addComponent(this.jScrollPane16, -1, 351, 32767)
/* 3551 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/* 3552 */               .addComponent(this.jButton40, -2, 83, -2)
/* 3553 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3554 */               .addComponent(this.jButton41, -2, 85, -2)))
/* 3555 */           .addContainerGap()));
/*      */     
/* 3557 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 3558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3559 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 3560 */           .addComponent(this.jScrollPane16, -2, 156, -2)
/* 3561 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3562 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3563 */             .addComponent(this.jButton41)
/* 3564 */             .addComponent(this.jButton40))
/* 3565 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3568 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 3569 */     this.jPanel24.setLayout(jPanel24Layout);
/* 3570 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 3571 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3572 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 3573 */           .addContainerGap()
/* 3574 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3575 */             .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 3576 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3577 */               .addComponent(this.jPanel25, GroupLayout.Alignment.LEADING, 0, -1, 32767)
/* 3578 */               .addComponent(this.jSeparator24, GroupLayout.Alignment.LEADING)
/* 3579 */               .addComponent(this.jLabel115, GroupLayout.Alignment.LEADING, -1, 381, 32767)))
/* 3580 */           .addContainerGap(18, 32767)));
/*      */     
/* 3582 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 3583 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3584 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 3585 */           .addContainerGap()
/* 3586 */           .addComponent(this.jLabel115)
/* 3587 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3588 */           .addComponent(this.jSeparator24, -2, 10, -2)
/* 3589 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3590 */           .addComponent(this.jPanel25, -2, -1, -2)
/* 3591 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3592 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 3593 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3596 */     GroupLayout jDialog15Layout = new GroupLayout(this.jDialog15.getContentPane());
/* 3597 */     this.jDialog15.getContentPane().setLayout(jDialog15Layout);
/* 3598 */     jDialog15Layout.setHorizontalGroup(jDialog15Layout
/* 3599 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3600 */         .addGap(0, 411, 32767)
/* 3601 */         .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3602 */           .addGroup(jDialog15Layout.createSequentialGroup()
/* 3603 */             .addGap(0, 0, 32767)
/* 3604 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 3605 */             .addGap(0, 0, 32767))));
/*      */     
/* 3607 */     jDialog15Layout.setVerticalGroup(jDialog15Layout
/* 3608 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3609 */         .addGap(0, 353, 32767)
/* 3610 */         .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3611 */           .addGroup(jDialog15Layout.createSequentialGroup()
/* 3612 */             .addGap(0, 0, 32767)
/* 3613 */             .addComponent(this.jPanel24, -2, -1, -2)
/* 3614 */             .addGap(0, 0, 32767))));
/*      */ 
/*      */     
/* 3617 */     this.jDialog16.setTitle("Descontar Diesel");
/* 3618 */     this.jDialog16.setModal(true);
/* 3619 */     this.jDialog16.setResizable(false);
/*      */     
/* 3621 */     this.jPanel27.setBackground(new Color(146, 193, 134));
/*      */     
/* 3623 */     this.jLabel118.setFont(new Font("Tahoma", 1, 15));
/* 3624 */     this.jLabel118.setForeground(new Color(0, 102, 102));
/* 3625 */     this.jLabel118.setHorizontalAlignment(0);
/* 3626 */     this.jLabel118.setText("DESCONTAR DIESEL");
/*      */     
/* 3628 */     this.jLabel119.setFont(new Font("Tahoma", 3, 11));
/* 3629 */     this.jLabel119.setForeground(new Color(15, 87, 51));
/* 3630 */     this.jLabel119.setHorizontalAlignment(4);
/* 3631 */     this.jLabel119.setText("Cantidad ");
/*      */     
/* 3633 */     this.jButton42.setMnemonic('A');
/* 3634 */     this.jButton42.setText("Agregar");
/* 3635 */     this.jButton42.setToolTipText("Agregar (Alt+A)");
/* 3636 */     this.jButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3638 */             Liquidaciones.this.jButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3642 */     this.jFormattedTextField11.setHorizontalAlignment(4);
/* 3643 */     this.jFormattedTextField11.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 3645 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 3646 */     this.jPanel27.setLayout(jPanel27Layout);
/* 3647 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 3648 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3649 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 3650 */           .addContainerGap()
/* 3651 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3652 */             .addComponent(this.jSeparator25, GroupLayout.Alignment.LEADING)
/* 3653 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
/* 3654 */               .addComponent(this.jLabel119, -2, 65, -2)
/* 3655 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3656 */               .addComponent(this.jFormattedTextField11, -2, 191, -2)
/* 3657 */               .addGap(18, 18, 18)
/* 3658 */               .addComponent(this.jButton42))
/* 3659 */             .addComponent(this.jLabel118, GroupLayout.Alignment.LEADING, -2, 283, -2))
/* 3660 */           .addContainerGap(20, 32767)));
/*      */     
/* 3662 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 3663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3664 */         .addGroup(jPanel27Layout.createSequentialGroup()
/* 3665 */           .addContainerGap()
/* 3666 */           .addComponent(this.jLabel118)
/* 3667 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3668 */           .addComponent(this.jSeparator25, -2, 10, -2)
/* 3669 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3670 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3671 */             .addComponent(this.jLabel119)
/* 3672 */             .addComponent(this.jButton42)
/* 3673 */             .addComponent(this.jFormattedTextField11, -2, -1, -2))
/* 3674 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3677 */     GroupLayout jDialog16Layout = new GroupLayout(this.jDialog16.getContentPane());
/* 3678 */     this.jDialog16.getContentPane().setLayout(jDialog16Layout);
/* 3679 */     jDialog16Layout.setHorizontalGroup(jDialog16Layout
/* 3680 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3681 */         .addComponent(this.jPanel27, -2, -1, -2));
/*      */     
/* 3683 */     jDialog16Layout.setVerticalGroup(jDialog16Layout
/* 3684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3685 */         .addComponent(this.jPanel27, -2, -1, -2));
/*      */ 
/*      */     
/* 3688 */     this.jTable8.setFont(new Font("Tahoma", 0, 10));
/* 3689 */     this.jTable8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3697 */           boolean[] canEdit = new boolean[] { false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3702 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3705 */     this.jScrollPane9.setViewportView(this.jTable8);
/*      */     
/* 3707 */     GroupLayout jDialog17Layout = new GroupLayout(this.jDialog17.getContentPane());
/* 3708 */     this.jDialog17.getContentPane().setLayout(jDialog17Layout);
/* 3709 */     jDialog17Layout.setHorizontalGroup(jDialog17Layout
/* 3710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3711 */         .addGap(0, 452, 32767)
/* 3712 */         .addGroup(jDialog17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3713 */           .addGroup(jDialog17Layout.createSequentialGroup()
/* 3714 */             .addGap(0, 0, 32767)
/* 3715 */             .addComponent(this.jScrollPane9, -2, -1, -2)
/* 3716 */             .addGap(0, 0, 32767))));
/*      */     
/* 3718 */     jDialog17Layout.setVerticalGroup(jDialog17Layout
/* 3719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3720 */         .addGap(0, 427, 32767)
/* 3721 */         .addGroup(jDialog17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3722 */           .addGroup(jDialog17Layout.createSequentialGroup()
/* 3723 */             .addGap(0, 0, 32767)
/* 3724 */             .addComponent(this.jScrollPane9, -2, -1, -2)
/* 3725 */             .addGap(0, 0, 32767))));
/*      */ 
/*      */     
/* 3728 */     this.jDialog18.setTitle("Modificar Rendimientos");
/* 3729 */     this.jDialog18.setModal(true);
/*      */     
/* 3731 */     this.jPanel28.setBackground(new Color(146, 193, 134));
/*      */     
/* 3733 */     this.jLabel121.setFont(new Font("Tahoma", 1, 14));
/* 3734 */     this.jLabel121.setForeground(new Color(0, 102, 102));
/* 3735 */     this.jLabel121.setHorizontalAlignment(0);
/* 3736 */     this.jLabel121.setText("Rendimientos de la Unidad");
/*      */     
/* 3738 */     this.jButton35.setMnemonic('C');
/* 3739 */     this.jButton35.setText("Cerrar");
/* 3740 */     this.jButton35.setToolTipText("Cerrar (Alt+C)");
/* 3741 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3743 */             Liquidaciones.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3747 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/* 3748 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder("Modificar Rendimientos "));
/*      */     
/* 3750 */     this.jLabel13.setText("Vacío (Sin Carga)         -->");
/*      */     
/* 3752 */     this.jLabel46.setText("Km./Lt.");
/*      */     
/* 3754 */     this.jLabel122.setText("De 0.01 a 5 tons.         -->");
/*      */     
/* 3756 */     this.jLabel127.setText("Km./Lt.");
/*      */     
/* 3758 */     this.jLabel128.setText("De 5.1 a 10 tons.         -->");
/*      */     
/* 3760 */     this.jLabel129.setText("Km./Lt.");
/*      */     
/* 3762 */     this.jLabel130.setText("De 10.1 a 15 tons.       -->");
/*      */     
/* 3764 */     this.jLabel131.setText("Km./Lt.");
/*      */     
/* 3766 */     this.jLabel132.setText("De 15.1 a 20 tons.       -->");
/*      */     
/* 3768 */     this.jLabel133.setText("Km./Lt.");
/*      */     
/* 3770 */     this.jLabel134.setText("De 20.1 a 25 tons.       -->");
/*      */     
/* 3772 */     this.jLabel135.setText("Km./Lt.");
/*      */     
/* 3774 */     this.jLabel136.setText("De 25.1 a 30 tons.       -->");
/*      */     
/* 3776 */     this.jLabel137.setText("Km./Lt.");
/*      */     
/* 3778 */     this.jLabel138.setText("De 30.1 a 35 tons.       -->");
/*      */     
/* 3780 */     this.jLabel139.setText("Km./Lt.");
/*      */     
/* 3782 */     this.jLabel140.setText("De 35.1 a 40 tons.       -->");
/*      */     
/* 3784 */     this.jLabel141.setText("Km./Lt.");
/*      */     
/* 3786 */     this.jLabel142.setText("De 40.1 a 45 tons.       -->");
/*      */     
/* 3788 */     this.jLabel143.setText("Km./Lt.");
/*      */     
/* 3790 */     this.jLabel144.setText("De 45.1 a 50 tons.       -->");
/*      */     
/* 3792 */     this.jLabel145.setText("Km./Lt.");
/*      */     
/* 3794 */     this.jLabel146.setText("De 50.1 a 55 tons.       -->");
/*      */     
/* 3796 */     this.jLabel147.setText("Km./Lt.");
/*      */     
/* 3798 */     this.jLabel148.setText("De 55.1 a 60 tons.       -->");
/*      */     
/* 3800 */     this.jLabel149.setText("Km./Lt.");
/*      */     
/* 3802 */     this.jLabel150.setText("De 60.1 a 65 tons.       -->");
/*      */     
/* 3804 */     this.jLabel151.setText("Km./Lt.");
/*      */     
/* 3806 */     this.jLabel152.setText("De 65.1 a 70 tons.       -->");
/*      */     
/* 3808 */     this.jLabel153.setText("Km./Lt.");
/*      */     
/* 3810 */     this.jFormattedTextField15.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3811 */     this.jFormattedTextField15.setHorizontalAlignment(4);
/* 3812 */     this.jFormattedTextField15.setText("0.0");
/*      */     
/* 3814 */     this.jFormattedTextField16.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3815 */     this.jFormattedTextField16.setHorizontalAlignment(4);
/* 3816 */     this.jFormattedTextField16.setText("0.0");
/*      */     
/* 3818 */     this.jFormattedTextField17.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3819 */     this.jFormattedTextField17.setHorizontalAlignment(4);
/* 3820 */     this.jFormattedTextField17.setText("0.0");
/*      */     
/* 3822 */     this.jFormattedTextField18.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3823 */     this.jFormattedTextField18.setHorizontalAlignment(4);
/* 3824 */     this.jFormattedTextField18.setText("0.0");
/*      */     
/* 3826 */     this.jFormattedTextField19.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3827 */     this.jFormattedTextField19.setHorizontalAlignment(4);
/* 3828 */     this.jFormattedTextField19.setText("0.0");
/*      */     
/* 3830 */     this.jFormattedTextField20.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3831 */     this.jFormattedTextField20.setHorizontalAlignment(4);
/* 3832 */     this.jFormattedTextField20.setText("0.0");
/*      */     
/* 3834 */     this.jFormattedTextField21.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3835 */     this.jFormattedTextField21.setHorizontalAlignment(4);
/* 3836 */     this.jFormattedTextField21.setText("0.0");
/*      */     
/* 3838 */     this.jFormattedTextField22.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3839 */     this.jFormattedTextField22.setHorizontalAlignment(4);
/* 3840 */     this.jFormattedTextField22.setText("0.0");
/*      */     
/* 3842 */     this.jFormattedTextField23.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3843 */     this.jFormattedTextField23.setHorizontalAlignment(4);
/* 3844 */     this.jFormattedTextField23.setText("0.0");
/*      */     
/* 3846 */     this.jFormattedTextField24.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3847 */     this.jFormattedTextField24.setHorizontalAlignment(4);
/* 3848 */     this.jFormattedTextField24.setText("0.0");
/*      */     
/* 3850 */     this.jFormattedTextField25.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3851 */     this.jFormattedTextField25.setHorizontalAlignment(4);
/* 3852 */     this.jFormattedTextField25.setText("0.0");
/*      */     
/* 3854 */     this.jFormattedTextField26.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3855 */     this.jFormattedTextField26.setHorizontalAlignment(4);
/* 3856 */     this.jFormattedTextField26.setText("0.0");
/*      */     
/* 3858 */     this.jFormattedTextField27.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3859 */     this.jFormattedTextField27.setHorizontalAlignment(4);
/* 3860 */     this.jFormattedTextField27.setText("0.0");
/*      */     
/* 3862 */     this.jFormattedTextField28.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3863 */     this.jFormattedTextField28.setHorizontalAlignment(4);
/* 3864 */     this.jFormattedTextField28.setText("0.0");
/*      */     
/* 3866 */     this.jFormattedTextField29.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
/* 3867 */     this.jFormattedTextField29.setHorizontalAlignment(4);
/* 3868 */     this.jFormattedTextField29.setText("0.0");
/*      */     
/* 3870 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 3871 */     this.jPanel30.setLayout(jPanel30Layout);
/* 3872 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 3873 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3874 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 3875 */           .addContainerGap(-1, 32767)
/* 3876 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3877 */             .addComponent(this.jLabel130)
/* 3878 */             .addComponent(this.jLabel132)
/* 3879 */             .addComponent(this.jLabel134)
/* 3880 */             .addComponent(this.jLabel136)
/* 3881 */             .addComponent(this.jLabel138)
/* 3882 */             .addComponent(this.jLabel13)
/* 3883 */             .addComponent(this.jLabel128)
/* 3884 */             .addComponent(this.jLabel122)
/* 3885 */             .addComponent(this.jLabel140)
/* 3886 */             .addComponent(this.jLabel142)
/* 3887 */             .addComponent(this.jLabel144)
/* 3888 */             .addComponent(this.jLabel146)
/* 3889 */             .addComponent(this.jLabel148)
/* 3890 */             .addComponent(this.jLabel150)
/* 3891 */             .addComponent(this.jLabel152))
/* 3892 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3893 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3894 */             .addComponent(this.jFormattedTextField29, -2, 41, -2)
/* 3895 */             .addComponent(this.jFormattedTextField28, -2, 41, -2)
/* 3896 */             .addComponent(this.jFormattedTextField27, -2, 41, -2)
/* 3897 */             .addComponent(this.jFormattedTextField26, -2, 41, -2)
/* 3898 */             .addComponent(this.jFormattedTextField25, -2, 41, -2)
/* 3899 */             .addComponent(this.jFormattedTextField24, -2, 41, -2)
/* 3900 */             .addComponent(this.jFormattedTextField23, -2, 41, -2)
/* 3901 */             .addComponent(this.jFormattedTextField22, -2, 41, -2)
/* 3902 */             .addComponent(this.jFormattedTextField20, -2, 41, -2)
/* 3903 */             .addComponent(this.jFormattedTextField21, -2, 41, -2)
/* 3904 */             .addComponent(this.jFormattedTextField19, -2, 41, -2)
/* 3905 */             .addComponent(this.jFormattedTextField18, -2, 41, -2)
/* 3906 */             .addComponent(this.jFormattedTextField17, -2, 41, -2)
/* 3907 */             .addComponent(this.jFormattedTextField16, -2, 41, -2)
/* 3908 */             .addComponent(this.jFormattedTextField15, -2, 41, -2))
/* 3909 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3910 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3911 */               .addGap(2, 2, 2)
/* 3912 */               .addComponent(this.jLabel46, -2, 49, -2))
/* 3913 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3914 */               .addGap(2, 2, 2)
/* 3915 */               .addComponent(this.jLabel139, -2, 49, -2))
/* 3916 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3917 */               .addGap(2, 2, 2)
/* 3918 */               .addComponent(this.jLabel137, -2, 49, -2))
/* 3919 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3920 */               .addGap(2, 2, 2)
/* 3921 */               .addComponent(this.jLabel135, -2, 49, -2))
/* 3922 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3923 */               .addGap(2, 2, 2)
/* 3924 */               .addComponent(this.jLabel133, -2, 49, -2))
/* 3925 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3926 */               .addGap(2, 2, 2)
/* 3927 */               .addComponent(this.jLabel131, -2, 49, -2))
/* 3928 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3929 */               .addGap(2, 2, 2)
/* 3930 */               .addComponent(this.jLabel129, -2, 49, -2))
/* 3931 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3932 */               .addGap(2, 2, 2)
/* 3933 */               .addComponent(this.jLabel127, -2, 49, -2))
/* 3934 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3935 */               .addGap(4, 4, 4)
/* 3936 */               .addComponent(this.jLabel141, -2, 49, -2))
/* 3937 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3938 */               .addGap(4, 4, 4)
/* 3939 */               .addComponent(this.jLabel143, -2, 49, -2))
/* 3940 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3941 */               .addGap(4, 4, 4)
/* 3942 */               .addComponent(this.jLabel145, -2, 49, -2))
/* 3943 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3944 */               .addGap(4, 4, 4)
/* 3945 */               .addComponent(this.jLabel147, -2, 49, -2))
/* 3946 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3947 */               .addGap(4, 4, 4)
/* 3948 */               .addComponent(this.jLabel149, -2, 49, -2))
/* 3949 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3950 */               .addGap(4, 4, 4)
/* 3951 */               .addComponent(this.jLabel151, -2, 49, -2))
/* 3952 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 3953 */               .addGap(4, 4, 4)
/* 3954 */               .addComponent(this.jLabel153, -2, 49, -2)))));
/*      */     
/* 3956 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 3957 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3958 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 3959 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3960 */             .addComponent(this.jLabel13)
/* 3961 */             .addComponent(this.jLabel46)
/* 3962 */             .addComponent(this.jFormattedTextField15, -2, -1, -2))
/* 3963 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3964 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3965 */             .addComponent(this.jLabel122)
/* 3966 */             .addComponent(this.jLabel127)
/* 3967 */             .addComponent(this.jFormattedTextField16, -2, -1, -2))
/* 3968 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3969 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3970 */             .addComponent(this.jLabel128)
/* 3971 */             .addComponent(this.jLabel129)
/* 3972 */             .addComponent(this.jFormattedTextField17, -2, -1, -2))
/* 3973 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3974 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3975 */             .addComponent(this.jLabel130)
/* 3976 */             .addComponent(this.jLabel131)
/* 3977 */             .addComponent(this.jFormattedTextField18, -2, -1, -2))
/* 3978 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3979 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3980 */             .addComponent(this.jLabel132)
/* 3981 */             .addComponent(this.jLabel133)
/* 3982 */             .addComponent(this.jFormattedTextField19, -2, -1, -2))
/* 3983 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3984 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3985 */             .addComponent(this.jLabel134)
/* 3986 */             .addComponent(this.jLabel135)
/* 3987 */             .addComponent(this.jFormattedTextField20, -2, -1, -2))
/* 3988 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3989 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3990 */             .addComponent(this.jLabel136)
/* 3991 */             .addComponent(this.jLabel137)
/* 3992 */             .addComponent(this.jFormattedTextField21, -2, -1, -2))
/* 3993 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3994 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3995 */             .addComponent(this.jLabel138)
/* 3996 */             .addComponent(this.jLabel139)
/* 3997 */             .addComponent(this.jFormattedTextField22, -2, -1, -2))
/* 3998 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3999 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4000 */             .addComponent(this.jLabel140)
/* 4001 */             .addComponent(this.jLabel141)
/* 4002 */             .addComponent(this.jFormattedTextField23, -2, -1, -2))
/* 4003 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4004 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4005 */             .addComponent(this.jLabel142)
/* 4006 */             .addComponent(this.jLabel143)
/* 4007 */             .addComponent(this.jFormattedTextField24, -2, -1, -2))
/* 4008 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4009 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4010 */             .addComponent(this.jLabel144)
/* 4011 */             .addComponent(this.jLabel145)
/* 4012 */             .addComponent(this.jFormattedTextField25, -2, -1, -2))
/* 4013 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4014 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4015 */             .addComponent(this.jLabel146)
/* 4016 */             .addComponent(this.jLabel147)
/* 4017 */             .addComponent(this.jFormattedTextField26, -2, -1, -2))
/* 4018 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4019 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4020 */             .addComponent(this.jLabel148)
/* 4021 */             .addComponent(this.jLabel149)
/* 4022 */             .addComponent(this.jFormattedTextField27, -2, -1, -2))
/* 4023 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4024 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4025 */             .addComponent(this.jLabel150)
/* 4026 */             .addComponent(this.jLabel151)
/* 4027 */             .addComponent(this.jFormattedTextField28, -2, -1, -2))
/* 4028 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4029 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4030 */             .addComponent(this.jLabel152)
/* 4031 */             .addComponent(this.jLabel153)
/* 4032 */             .addComponent(this.jFormattedTextField29, -2, -1, -2))
/* 4033 */           .addContainerGap(12, 32767)));
/*      */ 
/*      */     
/* 4036 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 4037 */     this.jPanel28.setLayout(jPanel28Layout);
/* 4038 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 4039 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4040 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
/* 4041 */           .addContainerGap(187, 32767)
/* 4042 */           .addComponent(this.jButton35, -2, 84, -2)
/* 4043 */           .addContainerGap())
/* 4044 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 4045 */           .addContainerGap()
/* 4046 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4047 */             .addComponent(this.jPanel30, -2, -1, -2)
/* 4048 */             .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4049 */               .addComponent(this.jSeparator26)
/* 4050 */               .addComponent(this.jLabel121, -1, 259, 32767)))
/* 4051 */           .addContainerGap(12, 32767)));
/*      */     
/* 4053 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 4054 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4055 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 4056 */           .addComponent(this.jLabel121)
/* 4057 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4058 */           .addComponent(this.jSeparator26, -2, 10, -2)
/* 4059 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4060 */           .addComponent(this.jPanel30, -2, -1, -2)
/* 4061 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4062 */           .addComponent(this.jButton35)
/* 4063 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 4066 */     GroupLayout jDialog18Layout = new GroupLayout(this.jDialog18.getContentPane());
/* 4067 */     this.jDialog18.getContentPane().setLayout(jDialog18Layout);
/* 4068 */     jDialog18Layout.setHorizontalGroup(jDialog18Layout
/* 4069 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4070 */         .addComponent(this.jPanel28, -2, -1, -2));
/*      */     
/* 4072 */     jDialog18Layout.setVerticalGroup(jDialog18Layout
/* 4073 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4074 */         .addComponent(this.jPanel28, -1, -1, 32767));
/*      */ 
/*      */     
/* 4077 */     this.jDialog19.setTitle("Cancelar Liquidación");
/* 4078 */     this.jDialog19.setModal(true);
/*      */     
/* 4080 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 4082 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 4083 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 4084 */     this.jLabel124.setHorizontalAlignment(0);
/* 4085 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 4087 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 4088 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 4089 */     this.jLabel125.setHorizontalAlignment(4);
/* 4090 */     this.jLabel125.setText("Motivo");
/*      */     
/* 4092 */     this.jButton44.setMnemonic('A');
/* 4093 */     this.jButton44.setText("Cancelar Liquidación");
/* 4094 */     this.jButton44.setToolTipText("Cancelar Movimiento (Alt+A)");
/* 4095 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4097 */             Liquidaciones.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4101 */     this.jButton45.setMnemonic('C');
/* 4102 */     this.jButton45.setText("Cerrar");
/* 4103 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 4104 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4106 */             Liquidaciones.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4110 */     this.jTextArea5.setColumns(20);
/* 4111 */     this.jTextArea5.setLineWrap(true);
/* 4112 */     this.jTextArea5.setRows(5);
/* 4113 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 4115 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el movimiento");
/*      */     
/* 4117 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 4118 */     this.jPanel29.setLayout(jPanel29Layout);
/* 4119 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 4120 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4121 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 4122 */           .addContainerGap()
/* 4123 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4124 */             .addComponent(this.jLabel126, -2, 349, 32767)
/* 4125 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 4126 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 4127 */                 .addComponent(this.jButton44)
/* 4128 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4129 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 4130 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 4131 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 4132 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4133 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 4134 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 4135 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 4136 */               .addComponent(this.jSeparator27, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 4137 */           .addContainerGap()));
/*      */     
/* 4139 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 4140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4141 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 4142 */           .addComponent(this.jLabel124)
/* 4143 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4144 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 4145 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4146 */           .addComponent(this.jLabel126)
/* 4147 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4148 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4149 */             .addComponent(this.jLabel125)
/* 4150 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 4151 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4152 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4153 */             .addComponent(this.jButton45)
/* 4154 */             .addComponent(this.jButton44))
/* 4155 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 4158 */     GroupLayout jDialog19Layout = new GroupLayout(this.jDialog19.getContentPane());
/* 4159 */     this.jDialog19.getContentPane().setLayout(jDialog19Layout);
/* 4160 */     jDialog19Layout.setHorizontalGroup(jDialog19Layout
/* 4161 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4162 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 4164 */     jDialog19Layout.setVerticalGroup(jDialog19Layout
/* 4165 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4166 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 4169 */     this.jLabel2.setFont(new Font("Tahoma", 0, 12));
/* 4170 */     this.jLabel2.setText("Ingresa la fecha de la renta");
/*      */     
/* 4172 */     this.jDateChooser3.setDate(this.fechaActual);
/* 4173 */     this.jDateChooser3.setDateFormatString("yyyy/MM/dd");
/* 4174 */     this.jDateChooser3.setIcon(this.icon);
/* 4175 */     this.jDateChooser3.setMaxSelectableDate(this.fechaActual);
/* 4176 */     this.jDateChooser3.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4178 */     this.jLabel82.setText("De");
/*      */     
/* 4180 */     this.jLabel156.setText("Al");
/*      */     
/* 4182 */     this.jDateChooser6.setDate(this.fechaActual);
/* 4183 */     this.jDateChooser6.setDateFormatString("yyyy/MM/dd");
/* 4184 */     this.jDateChooser6.setIcon(this.icon);
/* 4185 */     this.jDateChooser6.setMaxSelectableDate(this.fechaActual);
/* 4186 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4188 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 4189 */     this.jPanel31.setLayout(jPanel31Layout);
/* 4190 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 4191 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4192 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 4193 */           .addContainerGap()
/* 4194 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4195 */             .addComponent(this.jLabel2, -1, 296, 32767)
/* 4196 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 4197 */               .addComponent(this.jLabel82, -2, 20, -2)
/* 4198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4199 */               .addComponent((Component)this.jDateChooser3, -2, 110, -2)
/* 4200 */               .addGap(18, 18, 18)
/* 4201 */               .addComponent(this.jLabel156, -2, 20, -2)
/* 4202 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4203 */               .addComponent((Component)this.jDateChooser6, -2, 105, -2)))
/* 4204 */           .addContainerGap()));
/*      */     
/* 4206 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 4207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4208 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 4209 */           .addContainerGap()
/* 4210 */           .addComponent(this.jLabel2)
/* 4211 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4212 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4213 */             .addComponent((Component)this.jDateChooser3, -1, -1, 32767)
/* 4214 */             .addComponent(this.jLabel82, -1, 20, 32767)
/* 4215 */             .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 4216 */               .addComponent(this.jLabel156, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 4217 */               .addComponent((Component)this.jDateChooser6, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 4218 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4221 */     this.jTable16.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4232 */     this.jScrollPane17.setViewportView(this.jTable16);
/*      */     
/* 4234 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 4235 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4237 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 4238 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 4239 */     this.jLabel3.setText("LIQUIDACIONES");
/*      */     
/* 4241 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 4242 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*      */     
/* 4244 */     this.jButton3.setMnemonic('F');
/* 4245 */     this.jButton3.setText("Filtrar");
/* 4246 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 4247 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4249 */             Liquidaciones.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4253 */     this.jLabel4.setFont(new Font("Tahoma", 1, 14));
/* 4254 */     this.jLabel4.setForeground(Color.red);
/* 4255 */     this.jLabel4.setHorizontalAlignment(0);
/* 4256 */     this.jLabel4.setText("AL");
/*      */     
/* 4258 */     this.jLabel5.setFont(new Font("Tahoma", 1, 14));
/* 4259 */     this.jLabel5.setForeground(Color.red);
/* 4260 */     this.jLabel5.setText(" VER LIQUIDACIONES DE");
/*      */     
/* 4262 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4263 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 4264 */     this.jDateChooser4.setIcon(this.icon);
/* 4265 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 4266 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4268 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4269 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 4270 */     this.jDateChooser5.setIcon(this.icon);
/* 4271 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 4272 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4274 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 4275 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 4276 */     this.jLabel7.setText("<html><u>Todos </u></html>");
/* 4277 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4279 */             Liquidaciones.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4282 */             Liquidaciones.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4285 */             Liquidaciones.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4289 */     this.jLabel8.setFont(new Font("Tahoma", 2, 12));
/* 4290 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/* 4291 */     this.jLabel8.setHorizontalAlignment(0);
/* 4292 */     this.jLabel8.setText("<html><u>Hoy</u></html>");
/* 4293 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4295 */             Liquidaciones.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4298 */             Liquidaciones.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4301 */             Liquidaciones.this.jLabel8MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4305 */     this.jLabel9.setFont(new Font("Tahoma", 2, 12));
/* 4306 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/* 4307 */     this.jLabel9.setText("<html><u>Ayer</u></html>");
/* 4308 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4310 */             Liquidaciones.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4313 */             Liquidaciones.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4316 */             Liquidaciones.this.jLabel9MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4320 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 4321 */     this.jPanel2.setLayout(jPanel2Layout);
/* 4322 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 4323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4324 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 4325 */           .addComponent(this.jLabel5, -2, 182, 32767)
/* 4326 */           .addGap(18, 18, 18)
/* 4327 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 4328 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4329 */           .addComponent(this.jLabel4, -2, 20, -2)
/* 4330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4331 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 4332 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4333 */           .addComponent(this.jButton3)
/* 4334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4335 */           .addComponent(this.jLabel7, -2, -1, -2)
/* 4336 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4337 */           .addComponent(this.jLabel8, -2, 31, -2)
/* 4338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4339 */           .addComponent(this.jLabel9, -2, 31, -2)
/* 4340 */           .addContainerGap()));
/*      */     
/* 4342 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 4343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4344 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 4345 */           .addContainerGap()
/* 4346 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4347 */             .addComponent(this.jLabel5)
/* 4348 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4349 */               .addComponent(this.jButton3)
/* 4350 */               .addComponent(this.jLabel7)
/* 4351 */               .addComponent(this.jLabel8)
/* 4352 */               .addComponent(this.jLabel9, -2, 15, -2))
/* 4353 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 4354 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 4355 */               .addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 4356 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 4357 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4360 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 4361 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Liquidaciones ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 4363 */     this.jLabel56.setFont(new Font("Tahoma", 3, 12));
/* 4364 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 4365 */     this.jLabel56.setHorizontalAlignment(0);
/* 4366 */     this.jLabel56.setText("Nombre del Operador");
/*      */     
/* 4368 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4370 */             Liquidaciones.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 4374 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4376 */             Liquidaciones.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 4380 */     this.jLabel57.setFont(new Font("Tahoma", 3, 12));
/* 4381 */     this.jLabel57.setForeground(new Color(15, 87, 51));
/* 4382 */     this.jLabel57.setHorizontalAlignment(0);
/* 4383 */     this.jLabel57.setText("Folio");
/*      */     
/* 4385 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4387 */             Liquidaciones.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 4391 */     this.jLabel58.setFont(new Font("Tahoma", 3, 12));
/* 4392 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/* 4393 */     this.jLabel58.setHorizontalAlignment(0);
/* 4394 */     this.jLabel58.setText("Unidad");
/*      */     
/* 4396 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 4397 */     this.jComboBox4.setFont(new Font("Tahoma", 1, 11));
/* 4398 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "<TODAS>", "<POR PAGAR>", "<PAGADA>", "<POR AUTORIZAR>", "<CANCELADA>" }));
/* 4399 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4401 */             Liquidaciones.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4405 */     this.jLabel59.setFont(new Font("Tahoma", 3, 12));
/* 4406 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 4407 */     this.jLabel59.setHorizontalAlignment(0);
/* 4408 */     this.jLabel59.setText("Estado-Liqudiaciones");
/*      */     
/* 4410 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 4411 */     this.jPanel17.setLayout(jPanel17Layout);
/* 4412 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 4413 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4414 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 4415 */           .addContainerGap()
/* 4416 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4417 */             .addComponent(this.jLabel57, -1, -1, 32767)
/* 4418 */             .addComponent(this.jTextField6, -2, 101, -2))
/* 4419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4420 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4421 */             .addComponent(this.jLabel56, -1, -1, 32767)
/* 4422 */             .addComponent(this.jTextField3, -2, 205, -2))
/* 4423 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4424 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4425 */             .addComponent(this.jLabel58, -1, -1, 32767)
/* 4426 */             .addComponent(this.jTextField1))
/* 4427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4428 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4429 */             .addComponent(this.jLabel59, -1, -1, 32767)
/* 4430 */             .addComponent(this.jComboBox4, -2, 173, -2))
/* 4431 */           .addGap(494, 494, 494)));
/*      */     
/* 4433 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 4434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4435 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 4436 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4437 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 4438 */               .addComponent(this.jTextField6, -2, -1, -2)
/* 4439 */               .addGap(8, 8, 8)
/* 4440 */               .addComponent(this.jLabel57))
/* 4441 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 4442 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 4443 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4444 */               .addComponent(this.jLabel56))
/* 4445 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 4446 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4447 */                 .addComponent(this.jComboBox4, -2, -1, -2)
/* 4448 */                 .addComponent(this.jTextField1, -2, -1, -2))
/* 4449 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4450 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4451 */                 .addComponent(this.jLabel58)
/* 4452 */                 .addComponent(this.jLabel59))))
/* 4453 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4456 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 4457 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 4459 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 4460 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Nombre Completo", "Unidad", "Documentó", "Estado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4468 */           boolean[] canEdit = new boolean[] { true, true, true, false, true, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4473 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4476 */     this.jTable2.setShowVerticalLines(false);
/* 4477 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4479 */             Liquidaciones.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 4482 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 4483 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 4484 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 4485 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4486 */       this.jTable2.getColumnModel().getColumn(1).setMinWidth(110);
/* 4487 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(110);
/* 4488 */       this.jTable2.getColumnModel().getColumn(3).setMinWidth(50);
/* 4489 */       this.jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
/* 4490 */       this.jTable2.getColumnModel().getColumn(4).setMinWidth(180);
/* 4491 */       this.jTable2.getColumnModel().getColumn(4).setMaxWidth(180);
/*      */     } 
/*      */     
/* 4494 */     this.jButton1.setMnemonic('N');
/* 4495 */     this.jButton1.setText("Nueva");
/* 4496 */     this.jButton1.setToolTipText("Nueva Liquidación (Alt +N)");
/* 4497 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4499 */             Liquidaciones.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4503 */     this.jButton2.setMnemonic('M');
/* 4504 */     this.jButton2.setText("Ver Detalle");
/* 4505 */     this.jButton2.setToolTipText("Modificar Liquidación (Alt+M)");
/* 4506 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4508 */             Liquidaciones.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4512 */     this.jButton4.setMnemonic('C');
/* 4513 */     this.jButton4.setText("Cancelar");
/* 4514 */     this.jButton4.setToolTipText("Cancelar Liquidación (Alt+C)");
/* 4515 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4517 */             Liquidaciones.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4521 */     this.jButton5.setMnemonic('A');
/* 4522 */     this.jButton5.setText("Autorizar");
/* 4523 */     this.jButton5.setToolTipText("Autorizar Liquidación (Alt+A)");
/* 4524 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4526 */             Liquidaciones.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4530 */     this.jLabel120.setFont(new Font("Tahoma", 1, 11));
/* 4531 */     this.jLabel120.setForeground(Color.red);
/* 4532 */     this.jLabel120.setHorizontalAlignment(0);
/* 4533 */     this.jLabel120.setText("t");
/* 4534 */     this.jLabel120.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 4536 */     this.jLabel123.setFont(new Font("Tahoma", 1, 11));
/* 4537 */     this.jLabel123.setForeground(Color.blue);
/* 4538 */     this.jLabel123.setHorizontalAlignment(0);
/* 4539 */     this.jLabel123.setText("t");
/* 4540 */     this.jLabel123.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 4542 */     this.jButton8.setMnemonic('A');
/* 4543 */     this.jButton8.setText("Guardar");
/* 4544 */     this.jButton8.setToolTipText("Autorizar Liquidación (Alt+A)");
/* 4545 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4547 */             Liquidaciones.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4551 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 4552 */     this.jPanel18.setLayout(jPanel18Layout);
/* 4553 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 4554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4555 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 4556 */           .addContainerGap()
/* 4557 */           .addComponent(this.jScrollPane2)
/* 4558 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4559 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4560 */             .addComponent(this.jLabel123, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 4561 */             .addComponent(this.jButton8, GroupLayout.Alignment.TRAILING, -1, 121, 32767)
/* 4562 */             .addComponent(this.jButton5, GroupLayout.Alignment.TRAILING, -1, 121, 32767)
/* 4563 */             .addComponent(this.jButton4, GroupLayout.Alignment.TRAILING, -1, 121, 32767)
/* 4564 */             .addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, 121, 32767)
/* 4565 */             .addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -1, 121, 32767)
/* 4566 */             .addComponent(this.jLabel120, -1, -1, 32767))
/* 4567 */           .addContainerGap()));
/*      */     
/* 4569 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 4570 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4571 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 4572 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4573 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 4574 */               .addComponent(this.jButton1)
/* 4575 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4576 */               .addComponent(this.jButton2)
/* 4577 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4578 */               .addComponent(this.jButton4)
/* 4579 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4580 */               .addComponent(this.jButton5)
/* 4581 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4582 */               .addComponent(this.jButton8)
/* 4583 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767)
/* 4584 */               .addComponent(this.jLabel123)
/* 4585 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4586 */               .addComponent(this.jLabel120))
/* 4587 */             .addComponent(this.jScrollPane2, -2, 0, 32767))
/* 4588 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4591 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 4592 */     this.jPanel6.setLayout(jPanel6Layout);
/* 4593 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 4594 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4595 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 4596 */           .addContainerGap()
/* 4597 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 4598 */             .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 4599 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 4600 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/* 4601 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 4602 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4603 */               .addComponent(this.jLabel3, -2, 443, -2)))
/* 4604 */           .addContainerGap()));
/*      */     
/* 4606 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 4607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4608 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 4609 */           .addContainerGap()
/* 4610 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4611 */             .addComponent(this.jPanel2, -1, -1, 32767)
/* 4612 */             .addComponent(this.jLabel3, -1, -1, 32767))
/* 4613 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4614 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 4615 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4616 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 4617 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4620 */     GroupLayout layout = new GroupLayout(this);
/* 4621 */     setLayout(layout);
/* 4622 */     layout.setHorizontalGroup(layout
/* 4623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4624 */         .addGap(0, 1166, 32767)
/* 4625 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4626 */           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 4627 */             .addContainerGap()
/* 4628 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 4629 */             .addContainerGap())));
/*      */     
/* 4631 */     layout.setVerticalGroup(layout
/* 4632 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4633 */         .addGap(0, 412, 32767)
/* 4634 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4635 */           .addGroup(layout.createSequentialGroup()
/* 4636 */             .addGap(3, 3, 3)
/* 4637 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 4638 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 4643 */     consultarLiq();
/*      */   }
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 4646 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 4647 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4648 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 4652 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 4656 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 4660 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4661 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4662 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 4666 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 4670 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 4674 */     Calendar ca = Calendar.getInstance();
/* 4675 */     Calendar fecha = Calendar.getInstance();
/* 4676 */     int aa = fecha.get(1);
/* 4677 */     int mm = fecha.get(2);
/* 4678 */     int dd = fecha.get(5);
/* 4679 */     if (dd == 1) {
/* 4680 */       if (mm == 0) {
/* 4681 */         mm = 11;
/* 4682 */         aa--;
/*      */       } else {
/* 4684 */         mm--;
/*      */       } 
/* 4686 */       int diasTotal = diasDelMes(mm, aa);
/* 4687 */       dd = diasTotal;
/*      */     } else {
/* 4689 */       dd--;
/*      */     } 
/* 4691 */     mm++;
/* 4692 */     String año = "" + aa;
/* 4693 */     String mes = "" + mm;
/* 4694 */     String dia = "" + dd;
/* 4695 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4696 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 4698 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 4699 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 4700 */     } catch (ParseException ex) {
/* 4701 */       ex.printStackTrace();
/*      */     } 
/* 4703 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 4707 */     this.jLabel9.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 4711 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 4715 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 4719 */     if (evt.getClickCount() == 2) {
/* 4720 */       cargarLiquidacion();
/*      */     } else {
/* 4722 */       int ind = this.jTable2.getSelectedRow();
/* 4723 */       this.jButton2.setEnabled(true);
/* 4724 */       this.jButton4.setEnabled(true);
/* 4725 */       this.jButton5.setEnabled(true);
/* 4726 */       privilegios();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 4731 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 4735 */     this.jDialog1.setTitle("Nueva Liquidación");
/* 4736 */     this.jTextField63.setText("");
/* 4737 */     this.DIRECTIVA[1] = this.AUXDIESEL;
/* 4738 */     this.jLabel1.setText("Nueva Liquidación");
/* 4739 */     this.jButton10.setEnabled(true);
/* 4740 */     this.jButton11.setEnabled(true);
/* 4741 */     this.jButton12.setEnabled(true);
/* 4742 */     this.jButton14.setEnabled(true);
/* 4743 */     this.jButton15.setEnabled(false);
/* 4744 */     this.jButton16.setEnabled(true);
/* 4745 */     this.jButton7.setEnabled(true);
/* 4746 */     this.jButton9.setEnabled(true);
/* 4747 */     this.jTextField2.setEnabled(true);
/* 4748 */     this.jFormattedTextField1.setEnabled(true);
/* 4749 */     this.jRadioButton2.setEnabled(true);
/* 4750 */     this.ESMODIFICA = true;
/*      */     
/* 4752 */     this.jButton15.setEnabled(true);
/* 4753 */     this.jRadioButton1.setEnabled(true);
/* 4754 */     this.jFormattedTextField1.setEnabled(true);
/* 4755 */     this.jRadioButton2.setEnabled(true);
/* 4756 */     this.jButton26.setEnabled(true);
/* 4757 */     this.jButton17.setEnabled(true);
/* 4758 */     this.jButton6.setEnabled(true);
/* 4759 */     this.jFormattedTextField11.setEnabled(true);
/* 4760 */     this.jButton42.setEnabled(true);
/* 4761 */     this.jButton29.setEnabled(true);
/* 4762 */     this.jButton24.setEnabled(true);
/* 4763 */     this.jButton25.setEnabled(true);
/* 4764 */     this.jButton7.setEnabled(true);
/* 4765 */     this.jButton9.setEnabled(true);
/* 4766 */     this.jButton27.setEnabled(true);
/* 4767 */     this.jButton28.setEnabled(true);
/* 4768 */     this.jButton30.setEnabled(true);
/*      */     
/* 4770 */     this.jButton14.setEnabled(true);
/* 4771 */     this.jButton16.setEnabled(true);
/* 4772 */     this.jTextField2.setEnabled(false);
/* 4773 */     cargarFechaHoy();
/* 4774 */     sacarMayor();
/* 4775 */     desactivar();
/* 4776 */     this.jButton16.setText("Guardar");
/* 4777 */     this.ESMODIFICA = false;
/* 4778 */     this.jButton15.setEnabled(true);
/* 4779 */     this.jRadioButton1.setSelected(true);
/* 4780 */     this.jRadioButton1.setEnabled(true);
/* 4781 */     this.jRadioButton2.setEnabled(true);
/* 4782 */     this.jTextField2.setEnabled(true);
/* 4783 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {}
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 4790 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 4794 */     consultarLiq();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 4798 */     if (this.jComboBox4.getItemCount() > 0) {
/* 4799 */       consultarLiq();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 4804 */     if (evt.getClickCount() == 2) {
/* 4805 */       cargarOperador();
/*      */     } else {
/* 4807 */       int ind = this.jTable3.getSelectedRow();
/* 4808 */       String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 4809 */       this.jButton20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 4813 */     cargarOperador();
/*      */   }
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 4816 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 4819 */     consultar();
/*      */   }
/*      */   private void jTextField10ActionPerformed(ActionEvent evt) {
/* 4822 */     this.jTable3.selectAll();
/* 4823 */     cargarOperador();
/*      */   }
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 4826 */     consultar();
/*      */   }
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 4829 */     if (!this.consultarOperadores) {
/* 4830 */       consultar();
/*      */     }
/* 4832 */     this.GUIASFECHA = new TreeMap<>();
/* 4833 */     this.jTextField63.setText("");
/* 4834 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 4838 */     String boton = this.jButton16.getText();
/* 4839 */     if (boton.equals("Imprimir")) {
/* 4840 */       ImprimirDocumento imp = new ImprimirDocumento();
/* 4841 */       imp.recibeDatos();
/*      */     } else {
/* 4843 */       boolean faltaDiesel = false;
/* 4844 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 4845 */         String valor = String.valueOf(this.jTable1.getValueAt(i, 1));
/* 4846 */         if (valor.equals("")) {
/* 4847 */           faltaDiesel = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 4851 */       if (faltaDiesel) {
/* 4852 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes guardar la liquidación porque te faltan complementar vales de diesel", "Falta Complementar", 0, this.ERROR);
/*      */       } else {
/* 4854 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas generar la siguiente liquidación?", "Generar Liquidación", 0, 3, this.PREG);
/* 4855 */         if (res == 0) {
/* 4856 */           String tipoLiq = "";
/* 4857 */           if (this.jRadioButton1.isSelected()) {
/* 4858 */             tipoLiq = "Evento";
/*      */           } else {
/* 4860 */             tipoLiq = "Renta";
/*      */           } 
/* 4862 */           if (this.ESMODIFICA) {
/* 4863 */             this.con.eliminar2("detliq", "where folio_liq='" + this.jTextField61.getText() + "'");
/* 4864 */             this.con.eliminar2("gastosliq", "where folio_liq='" + this.jTextField61.getText() + "'");
/* 4865 */             this.con.eliminar2("premiosliq", "where folio_liq='" + this.jTextField61.getText() + "'");
/*      */             
/* 4867 */             String insertar = ""; int j;
/* 4868 */             for (j = 0; j < this.jTable4.getRowCount(); j++) {
/* 4869 */               double auto = this.AUTOPISTAS[j];
/* 4870 */               double prop = this.PROPINAS[j];
/* 4871 */               double llantas = this.LLANTAS[j];
/* 4872 */               this.jFormattedTextField2.setValue(Double.valueOf(auto));
/* 4873 */               String autoLetra = this.jFormattedTextField2.getText();
/* 4874 */               String propLetra = this.jFormattedTextField2.getText();
/* 4875 */               String llantasLetra = this.jFormattedTextField2.getText();
/* 4876 */               insertar = insertar + "('" + insertar + "','" + String.valueOf(this.jTable4.getValueAt(j, 1)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 2)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 3)) + "'," + String.valueOf(this.jTable4.getValueAt(j, 8)) + "," + String.valueOf(this.jTable4.getValueAt(j, 4)) + "," + String.valueOf(this.jTable4.getValueAt(j, 5)) + "," + String.valueOf(this.jTable4.getValueAt(j, 6)) + "," + String.valueOf(this.jTable4.getValueAt(j, 7)) + ",'" + auto + "'," + autoLetra + ",'" + prop + "'," + propLetra + ",'" + llantas + "','" + llantasLetra + "','" + String.valueOf(this.jTable4.getValueAt(j, 9)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 0)) + "')";
/* 4877 */               if (j + 1 != this.jTable4.getRowCount()) {
/* 4878 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4881 */             if (this.jTable4.getRowCount() > 0) {
/* 4882 */               this.con.inserSinMsj("insert into detliq(tipoCarga,origen,destino,tipoPago,km,kmlt,litros,tons,autopistas,autopistasLetra,propinas,propinasLetra,llantas,llantasLetra,salarioLetra,folio_vale,folio_liq) values " + insertar);
/*      */             }
/* 4884 */             this.con.inserSinMsj("update liquidaciones set impuestos = " + this.IMPUESTOS + ", diesel = '" + this.jLabel96.getText() + "', premios = '" + this.jLabel30.getText() + "', autopistas = '" + this.jLabel18.getText() + "',propinas = '" + this.jLabel19.getText() + "',llantas='" + this.jLabel20.getText() + "', otrosGastos = '" + this.jLabel22.getText() + "',gastosTotal = '" + this.jLabel24.getText() + "',gastosAsig = '" + this.jLabel26.getText() + "',gastosDif='" + this.jLabel49.getText() + "',viajesForaneos='" + this.jLabel14.getText() + "',unidad='" + this.jTextField2.getText() + "',saldoTD=" + String.valueOf(this.jFormattedTextField3.getValue()) + ",abonoTD = " + String.valueOf(this.jFormattedTextField1.getValue()) + ",subtotal=" + this.SUBTOTAL + ",TOTAL =" + this.NETO + ",TOTALLETRA='" + this.jFormattedTextField4.getText() + "',dieselContra=" + this.DIESELCONTRA + ",dieselconsum=" + this.DIESELCONSUMIDO + " where folio_liq = '" + this.jTextField61.getText() + "'");
/*      */             
/* 4886 */             insertar = "";
/* 4887 */             for (j = 0; j < this.jTable6.getRowCount(); j++) {
/* 4888 */               this.jFormattedTextField2.setValue(Double.valueOf(this.VALORPREMIOS[j]));
/* 4889 */               insertar = insertar + "('" + insertar + "'," + String.valueOf(this.jTable6.getValueAt(j, 0)) + ",'" + this.VALORPREMIOS[j] + "','" + this.jFormattedTextField2.getText() + "')";
/* 4890 */               if (j + 1 != this.jTable6.getRowCount()) {
/* 4891 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4894 */             if (this.jTable6.getRowCount() > 0) {
/* 4895 */               this.con.inserSinMsj("insert into premiosliq(concepto,total,totalLetra,folio_liq) values " + insertar);
/*      */             }
/*      */             
/* 4898 */             insertar = "";
/* 4899 */             for (j = 0; j < this.jTable7.getRowCount(); j++) {
/* 4900 */               this.jFormattedTextField2.setValue(Double.valueOf(this.VALORGASTOS[j]));
/* 4901 */               insertar = insertar + "('" + insertar + "','" + String.valueOf(this.jTable7.getValueAt(j, 0)) + "','" + String.valueOf(this.jTable7.getValueAt(j, 1)) + "'," + String.valueOf(this.jTable7.getValueAt(j, 2)) + ",'" + this.VALORGASTOS[j] + "','" + this.jFormattedTextField2.getText() + "')";
/* 4902 */               if (j + 1 != this.jTable7.getRowCount()) {
/* 4903 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4906 */             if (this.jTable7.getRowCount() > 0) {
/* 4907 */               this.con.inserSinMsj("insert into gastosliq(concepto,referencia,fecha,total,totalLetra,folio_liq) values " + insertar);
/*      */             }
/*      */             
/* 4910 */             for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 4911 */               String folio = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 4912 */               this.con.inserSinMsj("update vales_diesel set EMPRESA = '" + String.valueOf(this.jTable1.getValueAt(j, 1)) + "',litros =" + String.valueOf(this.jTable1.getValueAt(j, 2)) + ",precioLitro=" + this.PRECIODIESEL[j] + ",precioLitroLetra ='" + String.valueOf(this.jTable1.getValueAt(j, 3)) + "',total = " + this.VALORDIESEL[j] + ",totalLetra='" + String.valueOf(this.jTable1.getValueAt(j, 4)) + "',folio_liq='" + this.jTextField61.getText() + "'  where folio = '" + folio + "'");
/*      */             } 
/*      */ 
/*      */             
/* 4916 */             res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas imprimir la liquidación?", "Imprimir Liquidación", 0, 3, this.PREG);
/* 4917 */             if (res == 0) {
/* 4918 */               ImprimirDocumento imp = new ImprimirDocumento();
/* 4919 */               imp.recibeDatos();
/*      */             } 
/* 4921 */             consultarLiq();
/*      */           } else {
/*      */             
/* 4924 */             sacarMayor();
/* 4925 */             String insertar = ""; int j;
/* 4926 */             for (j = 0; j < this.jTable4.getRowCount(); j++) {
/* 4927 */               double auto = this.AUTOPISTAS[j];
/* 4928 */               double prop = this.PROPINAS[j];
/* 4929 */               double llantas = this.LLANTAS[j];
/* 4930 */               this.jFormattedTextField2.setValue(Double.valueOf(auto));
/* 4931 */               String autoLetra = this.jFormattedTextField2.getText();
/* 4932 */               String propLetra = this.jFormattedTextField2.getText();
/* 4933 */               String llantasLetra = this.jFormattedTextField2.getText();
/* 4934 */               insertar = insertar + "('" + insertar + "','" + String.valueOf(this.jTable4.getValueAt(j, 1)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 2)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 3)) + "'," + String.valueOf(this.jTable4.getValueAt(j, 8)) + "," + String.valueOf(this.jTable4.getValueAt(j, 4)) + "," + String.valueOf(this.jTable4.getValueAt(j, 5)) + "," + String.valueOf(this.jTable4.getValueAt(j, 6)) + "," + String.valueOf(this.jTable4.getValueAt(j, 7)) + ",'" + auto + "'," + autoLetra + ",'" + prop + "'," + propLetra + ",'" + llantas + "','" + llantasLetra + "','" + String.valueOf(this.jTable4.getValueAt(j, 9)) + "','" + String.valueOf(this.jTable4.getValueAt(j, 0)) + "')";
/* 4935 */               if (j + 1 != this.jTable4.getRowCount()) {
/* 4936 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4939 */             if (this.jTable4.getRowCount() > 0) {
/* 4940 */               this.con.inserSinMsj("insert into detliq(tipoCarga,origen,destino,tipoPago,km,kmlt,litros,tons,autopistas,autopistasLetra,propinas,propinasLetra,llantas,llantasLetra,salarioLetra,folio_vale,folio_liq) values " + insertar);
/*      */             }
/*      */             
/* 4943 */             this.con.inserSinMsj("insert into liquidaciones(folio_liq,fecha,impuestos,diesel,premios,autopistas,propinas,llantas,otrosGastos,gastosTotal,gastosAsig,gastosDif,viajesForaneos,unidad,saldoTD,abonoTD,subtotal,total,totalLetra,dieselContra,tipoLiq,tipoTractor,estatus,motivo,usuario,tarjeta,dieselconsum, precioLitro, fechaPrimerViaje) values ('" + this.jTextField61
/* 4944 */                 .getText() + "',now()," + this.IMPUESTOS + ",'" + this.jLabel96.getText() + "','" + this.jLabel30.getText() + "','" + this.jLabel18.getText() + "','" + this.jLabel19.getText() + "','" + this.jLabel20.getText() + "','" + this.jLabel22.getText() + "','" + this.jLabel24.getText() + "','" + this.jLabel26.getText() + "','" + this.jLabel49.getText() + "','" + this.jLabel14.getText() + "','" + this.jTextField2.getText() + "'," + String.valueOf(this.jFormattedTextField3.getValue()) + "," + String.valueOf(this.jFormattedTextField1.getValue()) + "," + this.SUBTOTAL + "," + String.valueOf(this.jFormattedTextField4.getValue()) + ",'" + this.jFormattedTextField4.getText() + "'," + this.DIESELCONTRA + ",'" + tipoLiq + "','" + this.jTextField16.getText() + "','<Por Autorizar>','','" + this.USUARIO.toUpperCase() + "'," + this.CLAVEOP + "," + this.DIESELCONSUMIDO + ",'" + this.DIRECTIVA[1] + "','" + this.jTextField63.getText() + "')");
/*      */             
/* 4946 */             insertar = "";
/* 4947 */             for (j = 0; j < this.jTable6.getRowCount(); j++) {
/* 4948 */               this.jFormattedTextField2.setValue(Double.valueOf(this.VALORPREMIOS[j]));
/* 4949 */               insertar = insertar + "('" + insertar + "'," + String.valueOf(this.jTable6.getValueAt(j, 0)) + ",'" + this.VALORPREMIOS[j] + "','" + this.jFormattedTextField2.getText() + "')";
/* 4950 */               if (j + 1 != this.jTable6.getRowCount()) {
/* 4951 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4954 */             if (this.jTable6.getRowCount() > 0) {
/* 4955 */               this.con.inserSinMsj("insert into premiosliq(concepto,total,totalLetra,folio_liq) values " + insertar);
/*      */             }
/*      */             
/* 4958 */             insertar = "";
/* 4959 */             for (j = 0; j < this.jTable7.getRowCount(); j++) {
/* 4960 */               this.jFormattedTextField2.setValue(Double.valueOf(this.VALORGASTOS[j]));
/* 4961 */               insertar = insertar + "('" + insertar + "','" + String.valueOf(this.jTable7.getValueAt(j, 0)) + "','" + String.valueOf(this.jTable7.getValueAt(j, 1)) + "'," + String.valueOf(this.jTable7.getValueAt(j, 2)) + ",'" + this.VALORGASTOS[j] + "','" + this.jFormattedTextField2.getText() + "')";
/* 4962 */               if (j + 1 != this.jTable7.getRowCount()) {
/* 4963 */                 insertar = insertar + ",";
/*      */               }
/*      */             } 
/* 4966 */             if (this.jTable7.getRowCount() > 0) {
/* 4967 */               this.con.inserSinMsj("insert into gastosliq(concepto,referencia,fecha,total,totalLetra,folio_liq) values " + insertar);
/*      */             }
/*      */             
/* 4970 */             for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 4971 */               String folio = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 4972 */               this.con.inserSinMsj("update vales_diesel set EMPRESA = '" + String.valueOf(this.jTable1.getValueAt(j, 1)) + "',litros =" + String.valueOf(this.jTable1.getValueAt(j, 2)) + ",precioLitro=" + this.PRECIODIESEL[j] + ",precioLitroLetra ='" + String.valueOf(this.jTable1.getValueAt(j, 3)) + "',total = " + this.VALORDIESEL[j] + ",totalLetra='" + String.valueOf(this.jTable1.getValueAt(j, 4)) + "',folio_liq='" + this.jTextField61.getText() + "'  where folio = '" + folio + "'");
/*      */             } 
/* 4974 */             for (j = 0; j < this.jTable9.getRowCount(); j++) {
/* 4975 */               this.con.inserSinMsj("update vales set folio_liq1 = '" + this.jTextField61.getText() + "', folio_liq2='" + this.jTextField61.getText() + "' where num_vale = '" + String.valueOf(this.jTable9.getValueAt(j, 0)) + "'");
/*      */             }
/* 4977 */             for (j = 0; j < this.jTable10.getRowCount(); j++) {
/* 4978 */               this.con.inserSinMsj("update vales set folio_liq1 = '" + this.jTextField61.getText() + "' where num_vale = '" + String.valueOf(this.jTable10.getValueAt(j, 0)) + "'");
/*      */             }
/* 4980 */             for (j = 0; j < this.jTable11.getRowCount(); j++) {
/* 4981 */               this.con.inserSinMsj("update vales set folio_liq2 = '" + this.jTextField61.getText() + "' where num_vale = '" + String.valueOf(this.jTable11.getValueAt(j, 0)) + "'");
/*      */             }
/*      */             
/* 4984 */             res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas imprimir la liquidación?", "Imprimir Liquidación", 0, 3, this.PREG);
/* 4985 */             if (res == 0) {
/* 4986 */               ImprimirDocumento imp = new ImprimirDocumento();
/* 4987 */               imp.recibeDatos();
/*      */             } 
/* 4989 */             consultarLiq();
/*      */           } 
/* 4991 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 4998 */     this.jLabel63.setText("TARJETA DE " + this.jTextField8.getText());
/* 4999 */     consultar2();
/* 5000 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   private void jTable5MouseClicked(MouseEvent evt) {
/* 5003 */     if (evt.getClickCount() == 2) {
/* 5004 */       cargarMov();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 5009 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 5013 */     String[] datos = { "MOV.", "FECHA", "CONCEPTO", "REFERENCIA", "REPUESTO", "CARGO", "ABONO", "SALDO", "ESTATUS" };
/* 5014 */     this.esc = new EscribirReporte(this.jLabel63.getText().toUpperCase(), this.jTable5, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 5018 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel53MouseClicked(MouseEvent evt) {
/* 5022 */     this.con.consultar("motivo", "tarjeta_contenido", "where mov=" + this.jTextField5.getText());
/* 5023 */     if (this.con.Campo.equals("")) {
/* 5024 */       JOptionPane.showMessageDialog(this.jDialog1, "Este vale se encuentra totalmente activo", "Vale Activo", 0, this.INFO);
/*      */     } else {
/* 5026 */       JOptionPane.showMessageDialog(this.jDialog1, "Este es el motivo por el cual está cancelado el vale:\n<html><font color = red>" + this.con.Campo + "</font></html>", "Motivo de Cancelación", 0, this.INFO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel53MouseEntered(MouseEvent evt) {
/* 5031 */     this.jLabel53.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel53MouseExited(MouseEvent evt) {
/* 5035 */     this.jLabel53.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 5039 */     if (this.jButton26.isEnabled()) {
/* 5040 */       String vale = String.valueOf(this.jComboBox3.getSelectedItem());
/* 5041 */       this.con.consultar("litros", "vales_diesel", "where folio='" + vale + "'");
/* 5042 */       if (!this.con.Campo.equals("SISA") && !this.con.Campo.equals("LLENO")) {
/* 5043 */         double valor = Double.parseDouble(this.con.Campo);
/* 5044 */         if (valor != 0.0D) {
/* 5045 */           this.jTextField12.setText("" + valor);
/*      */         } else {
/* 5047 */           this.jTextField12.setText("");
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
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 5060 */     this.jTextField11.setText("");
/* 5061 */     this.jTextField12.setText("");
/* 5062 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 5063 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 5064 */     DefaultTableModel modelo = new DefaultTableModel();
/* 5065 */     modelo.addColumn(this.color);
/* 5066 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 5069 */     this.jTextField13.setText("");
/* 5070 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 5071 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 5075 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 5076 */       String valor = this.jTable1.getValueAt(i, 1).toString();
/* 5077 */       if (valor.equals("")) {
/* 5078 */         JOptionPane.showMessageDialog(this.jDialog5, "Te faltan vales de diesel por completar, verifica tu información", "Faltan Vales", 0, this.ERROR);
/*      */         return;
/*      */       } 
/*      */     } 
/* 5082 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 5086 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 5091 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 5095 */     this.jDialog7.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField12KeyPressed(KeyEvent evt) {
/* 5099 */     this.error.pasarModal(true);
/* 5100 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5101 */     String valor = this.jTextField12.getText();
/* 5102 */     if (!valor.equals("")) {
/* 5103 */       if (!this.val.validarDigitos(this.jTextField12, this.jTextField12.getText())) {
/* 5104 */         calculaPrecio();
/*      */       } else {
/* 5106 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } else {
/* 5109 */       this.jTextField12.setText("");
/* 5110 */       this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField5KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField5KeyTyped(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField6FocusGained(FocusEvent evt) {
/* 5122 */     this.error.pasarModal(true);
/* 5123 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5124 */     String valor = this.jTextField12.getText();
/* 5125 */     if (!valor.equals("")) {
/* 5126 */       if (!this.val.validarDigitos(this.jTextField12, this.jTextField12.getText())) {
/* 5127 */         calculaPrecio();
/*      */       } else {
/* 5129 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } else {
/* 5132 */       this.jTextField12.setText("");
/* 5133 */       this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField12FocusGained(FocusEvent evt) {
/* 5138 */     this.error.pasarModal(true);
/* 5139 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5140 */     String valor = this.jTextField12.getText();
/* 5141 */     if (!valor.equals("")) {
/* 5142 */       if (!this.val.validarDigitos(this.jTextField12, this.jTextField12.getText())) {
/* 5143 */         calculaPrecio();
/*      */       } else {
/* 5145 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } else {
/* 5148 */       this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField5KeyReleased(KeyEvent evt) {
/* 5153 */     this.error.pasarModal(true);
/* 5154 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5155 */     String valor = this.jTextField12.getText();
/* 5156 */     if (!valor.equals("")) {
/* 5157 */       if (!this.val.validarDigitos(this.jTextField12, this.jTextField12.getText())) {
/* 5158 */         calculaPrecio();
/*      */       } else {
/* 5160 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } else {
/* 5163 */       this.jTextField12.setText("");
/* 5164 */       this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 5169 */     pasarVale();
/* 5170 */     actualizarDiesel();
/* 5171 */     actualizaTabla2();
/* 5172 */     actualizarSaldos();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 5176 */     int ind = this.jTable1.getSelectedRow();
/* 5177 */     if (ind < 0) {
/* 5178 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas seleccionar un vale para poder quitarlo", "Selecciona un Vale", 0, this.ADVER);
/*      */     } else {
/* 5180 */       this.DIESELCOMPROBADO -= this.VALORDIESEL[ind];
/* 5181 */       this.jTable1.setValueAt("", ind, 1);
/* 5182 */       this.jTable1.setValueAt("", ind, 2);
/* 5183 */       this.jTable1.setValueAt("", ind, 3);
/* 5184 */       this.jTable1.setValueAt("", ind, 4);
/* 5185 */       this.VALORDIESEL[ind] = 0.0D;
/* 5186 */       this.MODELODIESEL.setValueAt("", ind, 1);
/* 5187 */       this.MODELODIESEL.setValueAt("", ind, 2);
/* 5188 */       this.MODELODIESEL.setValueAt("", ind, 3);
/* 5189 */       this.MODELODIESEL.setValueAt("", ind, 4);
/* 5190 */       sacarTotalDiesel();
/* 5191 */       actualizarDiesel();
/*      */     } 
/* 5193 */     actualizaTabla4();
/* 5194 */     actualizarSaldos();
/*      */   }
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {
/* 5198 */     this.error.pasarModal(true);
/* 5199 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5200 */     String valor = this.jTextField12.getText();
/* 5201 */     if (!valor.equals("")) {
/* 5202 */       if (!this.val.validarDigitos(this.jTextField12, this.jTextField12.getText())) {
/* 5203 */         calculaPrecio();
/*      */       } else {
/* 5205 */         this.jTextField12.setText("");
/*      */       } 
/*      */     } else {
/* 5208 */       this.jTextField12.setText("");
/* 5209 */       this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 5214 */     this.error.pasarModal(true);
/* 5215 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5216 */     if (this.jTextField13.getText().equals("")) {
/* 5217 */       this.error.cargarError(this.jTextField13, "050");
/* 5218 */     } else if (this.jFormattedTextField7.getText().equals("$0.00")) {
/* 5219 */       this.jFormattedTextField7.setBackground(Color.RED);
/* 5220 */       JOptionPane.showMessageDialog(this.jDialog6, "Te falta agregar la cantidad del premio", "Falta Cantidad", 0, this.ADVER);
/* 5221 */     } else if (!this.val.validarApostrofe(this.jTextField13, this.jTextField13.getText(), "020")) {
/* 5222 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas generar el siguiente premio?", "Completar Vale", 0, 3, this.PREG);
/* 5223 */       if (res == 0) {
/* 5224 */         Object[] reg = { this.jTextField13.getText(), this.jFormattedTextField7.getText() };
/* 5225 */         this.VALORPREMIOS[this.MODELOPREMIOS.getRowCount()] = Double.parseDouble(this.jFormattedTextField7.getValue().toString());
/* 5226 */         this.PREMIOS += Double.parseDouble(this.jFormattedTextField7.getValue().toString());
/* 5227 */         this.MODELOPREMIOS.addRow(reg);
/* 5228 */         this.jTextField13.setText("");
/* 5229 */         this.SUBTOTAL += Double.parseDouble(this.jFormattedTextField7.getValue().toString());
/* 5230 */         actualizarSaldos();
/* 5231 */         this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 5232 */         sacarTotalPremios();
/* 5233 */         actualizaTabla3();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 5238 */     int ind = this.jTable6.getSelectedRow();
/* 5239 */     if (ind < 0) {
/* 5240 */       JOptionPane.showMessageDialog(this.jDialog6, "Necesitas seleccionar un premio para poder quitarlo, verifica tu información", "Selecciona un Premio", 0, this.ERROR);
/*      */     } else {
/* 5242 */       double[] valores = new double[this.VALORPREMIOS.length];
/* 5243 */       int cont = 0;
/* 5244 */       double valor = 0.0D;
/* 5245 */       for (int i = 0; i < valores.length; i++) {
/* 5246 */         if (i != ind) {
/* 5247 */           valores[cont] = this.VALORPREMIOS[i];
/* 5248 */           cont++;
/*      */         } else {
/* 5250 */           valor = this.VALORPREMIOS[i];
/*      */         } 
/*      */       } 
/* 5253 */       this.PREMIOS -= valor;
/* 5254 */       this.SUBTOTAL -= valor;
/* 5255 */       this.VALORPREMIOS = valores;
/* 5256 */       this.MODELOPREMIOS.removeRow(ind);
/* 5257 */       actualizarSaldos();
/* 5258 */       sacarTotalPremios();
/* 5259 */       actualizaTabla3();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1KeyReleased(KeyEvent evt) {
/* 5264 */     if (!this.jFormattedTextField1.getText().equals("$0.00"))
/*      */     {
/*      */       
/* 5267 */       actualizaSub();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 5272 */     this.error.pasarModal(true);
/* 5273 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5274 */     if (this.jTextField14.getText().equals("")) {
/* 5275 */       this.error.cargarError(this.jTextField14, "050");
/* 5276 */     } else if (this.jTextField15.getText().equals("")) {
/* 5277 */       this.error.cargarError(this.jTextField15, "050");
/* 5278 */     } else if (this.jDateChooser2.getDate() == null) {
/* 5279 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas colocar la fecha del gasto para completar la información", "Falta Fecha", 0, this.ADVER);
/* 5280 */     } else if (this.jFormattedTextField8.getText().equals("$0.00")) {
/* 5281 */       this.jFormattedTextField8.setBackground(Color.RED);
/* 5282 */       JOptionPane.showMessageDialog(this.jDialog6, "Te falta agregar la cantidad del gasto", "Falta Cantidad", 0, this.ADVER);
/* 5283 */     } else if (!this.val.validarApostrofe(this.jTextField14, this.jTextField14.getText(), "020") && 
/* 5284 */       !this.val.validarApostrofe(this.jTextField15, this.jTextField15.getText(), "020")) {
/* 5285 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas generar el siguiente premio?", "Completar Vale", 0, 3, this.PREG);
/* 5286 */       if (res == 0) {
/* 5287 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5288 */         String cadenaFecha2 = formato.format(this.jDateChooser2.getDate());
/* 5289 */         String año = cadenaFecha2.substring(0, 4);
/* 5290 */         String mes = cadenaFecha2.substring(4, 6);
/* 5291 */         String dia = cadenaFecha2.substring(6, 8);
/* 5292 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 5293 */         Object[] reg = { this.jTextField14.getText().toUpperCase(), this.jTextField15.getText().toUpperCase(), año + "-" + año + "-" + mes, this.jFormattedTextField8.getText() };
/* 5294 */         this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = Double.parseDouble(this.jFormattedTextField8.getValue().toString());
/* 5295 */         this.MODELOGASTOS.addRow(reg);
/* 5296 */         this.jTextField14.setText("");
/* 5297 */         this.jTextField15.setText("");
/* 5298 */         this.SUBTOTAL += Double.parseDouble(this.jFormattedTextField8.getValue().toString());
/* 5299 */         this.SOLOGASTOS += Double.parseDouble(this.jFormattedTextField8.getValue().toString());
/* 5300 */         this.GASTOSTOTAL += Double.parseDouble(this.jFormattedTextField8.getValue().toString());
/* 5301 */         this.DIFGAST += Double.parseDouble(this.jFormattedTextField8.getValue().toString());
/* 5302 */         actualizarSaldos();
/* 5303 */         this.jFormattedTextField8.setValue(Integer.valueOf(0));
/* 5304 */         sacarTotalPremios();
/* 5305 */         actualizaTabla2();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 5311 */     int ind = this.jTable7.getSelectedRow();
/* 5312 */     if (ind < 0) {
/* 5313 */       JOptionPane.showMessageDialog(this.jDialog6, "Necesitas seleccionar un cargo para poder quitarlo, verifica tu información", "Selecciona un Cargo", 0, this.ERROR);
/*      */     } else {
/* 5315 */       double[] valores = new double[this.VALORGASTOS.length];
/* 5316 */       int cont = 0;
/* 5317 */       double valor = 0.0D;
/* 5318 */       for (int i = 0; i < valores.length; i++) {
/* 5319 */         if (i != ind) {
/* 5320 */           valores[cont] = this.VALORGASTOS[i];
/* 5321 */           cont++;
/*      */         } else {
/* 5323 */           valor = this.VALORGASTOS[i];
/*      */         } 
/*      */       } 
/* 5326 */       this.SUBTOTAL -= valor;
/* 5327 */       this.GASTOSTOTAL -= valor;
/* 5328 */       this.SOLOGASTOS -= valor;
/* 5329 */       this.DIFGAST -= valor;
/* 5330 */       this.VALORGASTOS = valores;
/* 5331 */       this.MODELOGASTOS.removeRow(ind);
/* 5332 */       actualizarSaldos();
/* 5333 */       actualizaTabla2();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable12MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable13MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 5354 */     if (this.jComboBox7.getItemCount() > 0) {
/* 5355 */       String destino = String.valueOf(this.jComboBox7.getSelectedItem());
/* 5356 */       if (this.jComboBox7.getSelectedIndex() != 0) {
/* 5357 */         this.jFormattedTextField9.setEnabled(true);
/* 5358 */         this.jRadioButton3.setEnabled(true);
/* 5359 */         this.jRadioButton4.setEnabled(true);
/* 5360 */         this.jTextField9.setEnabled(true);
/* 5361 */         String[] registro = this.con.regresaReg("viaje,tons,tipoPago,KM", "emp_destinataria", "where nombrecorto = '" + destino + "'", 4);
/* 5362 */         if (registro[2].equals("1")) {
/* 5363 */           this.jRadioButton3.setSelected(true);
/* 5364 */           this.jFormattedTextField9.setValue(Double.valueOf(Double.parseDouble(registro[0])));
/* 5365 */           this.jFormattedTextField10.setValue(Double.valueOf(Double.parseDouble(registro[0])));
/* 5366 */           this.jTextField19.setEnabled(false);
/* 5367 */           this.jTextField19.setText("");
/*      */         } else {
/* 5369 */           this.jRadioButton4.setSelected(true);
/* 5370 */           this.jFormattedTextField9.setValue(Double.valueOf(Double.parseDouble(registro[1])));
/* 5371 */           this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 5372 */           this.jTextField19.setEnabled(true);
/*      */         } 
/* 5374 */         this.KMAUX = Double.parseDouble(registro[3]);
/*      */       } else {
/* 5376 */         this.jTextField19.setEnabled(false);
/* 5377 */         this.jFormattedTextField9.setEnabled(false);
/* 5378 */         this.jRadioButton3.setEnabled(false);
/* 5379 */         this.jRadioButton4.setEnabled(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 5385 */     this.esModifi = false;
/* 5386 */     this.jTextField17.setText("");
/* 5387 */     this.jTextField18.setText("");
/* 5388 */     this.jTextField19.setText("");
/* 5389 */     this.jTextField22.setText("");
/* 5390 */     this.jFormattedTextField12.setValue(Integer.valueOf(0));
/* 5391 */     this.jFormattedTextField13.setValue(Integer.valueOf(0));
/* 5392 */     this.jFormattedTextField14.setValue(Integer.valueOf(0));
/* 5393 */     this.jComboBox7.setSelectedIndex(0);
/* 5394 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 5395 */     this.jFormattedTextField9.setValue(Integer.valueOf(0));
/* 5396 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 5397 */     this.jDialog13.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField20ActionPerformed(ActionEvent evt) {
/* 5401 */     guardarOrigen();
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 5405 */     guardarOrigen();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 5413 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField21ActionPerformed(ActionEvent evt) {
/* 5417 */     guardarDestino();
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 5421 */     guardarDestino();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton40ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton41ActionPerformed(ActionEvent evt) {
/* 5429 */     this.jDialog15.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 5433 */     this.jTextField19.setText("");
/* 5434 */     double valor = Double.parseDouble(String.valueOf(this.jFormattedTextField9.getValue()));
/* 5435 */     this.jFormattedTextField10.setValue(Double.valueOf(valor));
/* 5436 */     this.jTextField19.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 5440 */     this.jTextField19.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField9KeyReleased(KeyEvent evt) {
/* 5444 */     if (this.jRadioButton3.isSelected()) {
/* 5445 */       double cant = 0.0D;
/*      */       try {
/* 5447 */         cant = Double.parseDouble(this.jFormattedTextField9.getText());
/* 5448 */       } catch (NumberFormatException n) {
/* 5449 */         cant = Double.parseDouble(String.valueOf(this.jFormattedTextField9.getValue()));
/*      */       } 
/* 5451 */       this.jFormattedTextField10.setValue(Double.valueOf(cant));
/*      */     } else {
/* 5453 */       double cant = 0.0D;
/* 5454 */       double tons = 0.0D;
/*      */       try {
/* 5456 */         cant = Double.parseDouble(this.jFormattedTextField9.getText());
/* 5457 */         tons = Double.parseDouble(this.jTextField19.getText());
/* 5458 */         double total = cant * tons;
/* 5459 */         this.jFormattedTextField10.setValue(Double.valueOf(total));
/* 5460 */       } catch (NumberFormatException e) {
/* 5461 */         if (!this.jTextField19.getText().equals("")) {
/* 5462 */           this.jTextField19.setBackground(Color.RED);
/* 5463 */           JOptionPane.showMessageDialog(this.jDialog13, "No puedes colocar letras en este campo por favor verifica tu información", "Sólo Números", 0, this.ERROR);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void jTextField19KeyReleased(KeyEvent evt) {
/* 5469 */     if (!this.jTextField19.getText().equals("")) {
/* 5470 */       double cant = 0.0D;
/* 5471 */       double tons = 0.0D;
/*      */       try {
/* 5473 */         tons = Double.parseDouble(this.jTextField19.getText());
/* 5474 */         cant = Double.parseDouble(String.valueOf(this.jFormattedTextField9.getValue()));
/* 5475 */         double total = cant * tons;
/* 5476 */         this.jFormattedTextField10.setValue(Double.valueOf(total));
/* 5477 */       } catch (NumberFormatException e) {
/* 5478 */         if (this.jTextField19.getText().equals("")) {
/* 5479 */           this.jTextField19.setBackground(Color.RED);
/* 5480 */           JOptionPane.showMessageDialog(this.jDialog13, "No puedes colocar letras en este campo por favor verifica tu información", "Sólo Números", 0, this.ERROR);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 5484 */       this.jTextField9.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 5489 */     this.error.pasarModal(true);
/* 5490 */     this.val.pasarModal(Boolean.valueOf(true));
/* 5491 */     if (this.jComboBox7.getSelectedIndex() == 0) {
/* 5492 */       JOptionPane.showMessageDialog(this.jDialog13, "Necesitas seleccionar el destino del viaje", "Falta Destino", 0, this.ERROR);
/* 5493 */     } else if (!this.val.validarApostrofe(this.jTextField17, this.jTextField17.getText(), "020") && 
/* 5494 */       !this.val.validarApostrofe(this.jTextField18, this.jTextField18.getText(), "020") && 
/* 5495 */       !this.val.validarDosDecimales(this.jTextField19, this.jTextField19.getText()) && 
/* 5496 */       !this.val.validarApostrofe(this.jTextField22, this.jTextField22.getText(), "020")) {
/* 5497 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas generar el siguiente viaje?", "Generar Viaje", 0, 3, this.PREG);
/* 5498 */       if (res == 0) {
/* 5499 */         String tipoViaje = "";
/* 5500 */         String tonelada = "";
/* 5501 */         if (this.jRadioButton3.isSelected()) {
/* 5502 */           tipoViaje = "Viaje";
/* 5503 */           tonelada = "0";
/*      */         } else {
/* 5505 */           tipoViaje = "Tonelada";
/* 5506 */           tonelada = this.jTextField19.getText();
/*      */         } 
/* 5508 */         if (this.jTextField19.getText().equals("")) {
/* 5509 */           tonelada = "0";
/*      */         }
/* 5511 */         if (this.jTextField17.getText().equals("")) {
/* 5512 */           this.jTextField17.setText("<S/GUÍA>");
/*      */         }
/* 5514 */         if (this.jTextField18.getText().equals("")) {
/* 5515 */           this.jTextField18.setText("<Viaje>");
/*      */         }
/* 5517 */         if (this.jTextField22.getText().equals("")) {
/* 5518 */           this.jTextField22.setText("<POZO>");
/*      */         }
/* 5520 */         this.VIAJESFORANEOS += Double.parseDouble(String.valueOf(this.jFormattedTextField10.getValue()));
/* 5521 */         this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField10.getValue()));
/*      */         
/* 5523 */         this.AUTOPISTAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 5524 */         this.PROPINAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 5525 */         this.LLANTAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */         
/* 5527 */         this.BAUTOPISTAS += Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 5528 */         this.BPROPINAS += Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 5529 */         this.BLLANTAS += Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */         
/* 5531 */         this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 5532 */         this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 5533 */         this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */         
/* 5535 */         this.GASTOSTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 5536 */         this.GASTOSTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 5537 */         this.GASTOSTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */         
/* 5539 */         this.DIFGAST += Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 5540 */         this.DIFGAST += Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 5541 */         this.DIFGAST += Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */         
/* 5543 */         double km = this.KMAUX;
/* 5544 */         double tons = Double.parseDouble(tonelada);
/* 5545 */         double rendi = sacarRendi(tons);
/* 5546 */         double litros = 0.0D;
/* 5547 */         if (rendi == 0.0D) {
/* 5548 */           litros = 0.0D;
/*      */         } else {
/* 5550 */           litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */         } 
/* 5552 */         this.KM += this.KMAUX;
/* 5553 */         this.LITROS += litros;
/* 5554 */         this.KMLT += rendi;
/* 5555 */         this.TONS += tons;
/* 5556 */         Object[] reg = { this.jTextField17.getText().toUpperCase(), this.jTextField18.getText().toUpperCase(), this.jTextField22.getText().toUpperCase(), String.valueOf(this.jComboBox7.getSelectedItem()), Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Double.valueOf(tons), tipoViaje, this.jFormattedTextField10.getText() };
/* 5557 */         this.MODELOVIAJES.addRow(reg);
/* 5558 */         this.jDialog13.setVisible(false);
/* 5559 */         res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Deseas insertar el regreso del viaje con cero toneladas?", "Grabar Regreso", 0, 3, this.PREG);
/* 5560 */         if (res == 0) {
/* 5561 */           rendi = sacarRendi(0.0D);
/* 5562 */           if (rendi == 0.0D) {
/* 5563 */             litros = 0.0D;
/*      */           } else {
/* 5565 */             litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */           } 
/* 5567 */           this.KM += this.KMAUX;
/* 5568 */           this.LITROS += litros;
/* 5569 */           this.KMLT += rendi;
/* 5570 */           reg = new Object[] { this.jTextField17.getText().toUpperCase(), "Regreso", String.valueOf(this.jComboBox7.getSelectedItem()), this.base, Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Integer.valueOf(0), tipoViaje, "$0.00" };
/* 5571 */           this.MODELOVIAJES.addRow(reg);
/*      */         } 
/* 5573 */         actualizarDiesel();
/* 5574 */         calcularGastos();
/* 5575 */         actualizarSaldos();
/* 5576 */         actualizaTabla1();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 5584 */     int ind = this.jTable4.getSelectedRow();
/* 5585 */     double[] aux1 = new double[800];
/* 5586 */     double[] aux2 = new double[800];
/* 5587 */     double[] aux3 = new double[800];
/* 5588 */     if (ind > -1) {
/* 5589 */       String cant = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 9));
/* 5590 */       String valor = "";
/* 5591 */       for (int i = 0; i < cant.length(); i++) {
/* 5592 */         if (cant.charAt(i) != '$' && cant.charAt(i) != ',') {
/* 5593 */           valor = valor + valor;
/*      */         }
/*      */       } 
/* 5596 */       int cont = 0;
/* 5597 */       for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 5598 */         if (j != ind) {
/* 5599 */           aux1[cont] = this.AUTOPISTAS[j];
/* 5600 */           aux2[cont] = this.PROPINAS[j];
/* 5601 */           aux3[cont] = this.LLANTAS[j];
/* 5602 */           cont++;
/*      */         } else {
/* 5604 */           this.GASTOSTOTAL -= this.AUTOPISTAS[j];
/* 5605 */           this.GASTOSTOTAL -= this.PROPINAS[j];
/* 5606 */           this.GASTOSTOTAL -= this.LLANTAS[j];
/*      */           
/* 5608 */           this.DIFGAST -= this.AUTOPISTAS[j];
/* 5609 */           this.DIFGAST -= this.PROPINAS[j];
/* 5610 */           this.DIFGAST -= this.LLANTAS[j];
/*      */           
/* 5612 */           this.BAUTOPISTAS -= this.AUTOPISTAS[j];
/* 5613 */           this.BPROPINAS -= this.PROPINAS[j];
/* 5614 */           this.BLLANTAS -= this.LLANTAS[j];
/*      */           
/* 5616 */           this.SUBTOTAL -= this.AUTOPISTAS[j];
/* 5617 */           this.SUBTOTAL -= this.PROPINAS[j];
/* 5618 */           this.SUBTOTAL -= this.LLANTAS[j];
/*      */         } 
/*      */       } 
/* 5621 */       this.AUTOPISTAS = aux1;
/* 5622 */       this.PROPINAS = aux2;
/* 5623 */       this.LLANTAS = aux3;
/* 5624 */       calcularGastos();
/* 5625 */       double tot = Double.parseDouble(valor);
/* 5626 */       this.SUBTOTAL -= tot;
/* 5627 */       this.VIAJESFORANEOS -= tot;
/* 5628 */       this.MODELOVIAJES.removeRow(this.jTable4.getSelectedRow());
/* 5629 */       actualizarSaldos();
/* 5630 */       this.jFormattedTextField2.setValue(Double.valueOf(this.VIAJESFORANEOS));
/* 5631 */       String sumas = this.jFormattedTextField2.getText();
/* 5632 */       this.jLabel14.setText(sumas);
/* 5633 */       double quitar = Double.parseDouble(String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 6)));
/* 5634 */       this.LITROS -= quitar;
/* 5635 */       quitar = Double.parseDouble(String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 4)));
/* 5636 */       this.KM -= quitar;
/* 5637 */       quitar = Double.parseDouble(String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 5)));
/* 5638 */       this.KMLT -= quitar;
/* 5639 */       actualizaTabla1();
/* 5640 */       actualizarDiesel();
/*      */     } else {
/* 5642 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar un viaje para poder quitarlo", "Selecciona un Viaje", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 5647 */     this.VIAJESFORANEOS = 0.0D; int i;
/* 5648 */     for (i = 0; i < this.MODELOVIAJES.getRowCount(); i++) {
/* 5649 */       this.MODELOVIAJES.setValueAt("$0.00", i, 9);
/*      */     }
/* 5651 */     for (i = 0; i < this.MODELOGASTOS.getRowCount(); i++) {
/* 5652 */       this.MODELOGASTOS.setValueAt("$0.00", i, 3);
/*      */     }
/* 5654 */     for (i = 0; i < this.MODELOPREMIOS.getRowCount(); i++) {
/* 5655 */       this.MODELOPREMIOS.setValueAt("$0.00", i, 1);
/*      */     }
/* 5657 */     for (i = 0; i < this.VALORPREMIOS.length; i++) {
/* 5658 */       this.VALORPREMIOS[i] = 0.0D;
/* 5659 */       this.VALORGASTOS[i] = 0.0D;
/* 5660 */       this.VALORGASTOS[i] = 0.0D;
/*      */     } 
/* 5662 */     this.PREMIOS = 0.0D;
/* 5663 */     this.SOLOGASTOS = 0.0D;
/* 5664 */     this.GASTOSTOTAL = 0.0D;
/* 5665 */     this.GASTOSASIG = this.DIFGASTORIGINAL;
/* 5666 */     this.DIFGAST = this.DIFGASTORIGINAL;
/* 5667 */     this.SUBTOTAL = this.GASTOSASIG;
/* 5668 */     this.jRadioButton1.setEnabled(false);
/*      */     
/* 5670 */     this.jFormattedTextField2.setValue(Double.valueOf(this.RENTA));
/* 5671 */     JOptionPane.showMessageDialog(this.jDialog1, this.jPanel31, "Fechas de la Renta", 0, this.INFO);
/*      */     
/* 5673 */     Calendar ahoraCal = Calendar.getInstance();
/* 5674 */     ahoraCal.setTime(this.jDateChooser3.getDate());
/* 5675 */     String mesesito = "";
/* 5676 */     String hoy = "";
/* 5677 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 5678 */     hoy = "" + ahoraCal.get(5);
/* 5679 */     if (ahoraCal.get(2) + 1 < 10) {
/* 5680 */       mesesito = "0" + mesesito;
/*      */     }
/* 5682 */     if (ahoraCal.get(5) < 10) {
/* 5683 */       hoy = "0" + hoy;
/*      */     }
/* 5685 */     String fecha1 = hoy + "/" + hoy + "/" + mesesito;
/*      */     
/* 5687 */     ahoraCal = Calendar.getInstance();
/* 5688 */     ahoraCal.setTime(this.jDateChooser6.getDate());
/* 5689 */     mesesito = "";
/* 5690 */     hoy = "";
/* 5691 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 5692 */     hoy = "" + ahoraCal.get(5);
/* 5693 */     if (ahoraCal.get(2) + 1 < 10) {
/* 5694 */       mesesito = "0" + mesesito;
/*      */     }
/* 5696 */     if (ahoraCal.get(5) < 10) {
/* 5697 */       hoy = "0" + hoy;
/*      */     }
/* 5699 */     String fecha2 = hoy + "/" + hoy + "/" + mesesito;
/* 5700 */     Object[] reg = { "1 Renta del " + fecha1 + " al " + fecha2, "Pago de Renta", this.cadFechaActual, this.jFormattedTextField2.getText() };
/* 5701 */     this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = this.RENTA;
/* 5702 */     this.MODELOGASTOS.addRow(reg);
/* 5703 */     this.SUBTOTAL = this.SUBTOTAL + this.RENTA + this.DIESELCONTRA;
/* 5704 */     this.SOLOGASTOS += this.RENTA;
/* 5705 */     this.GASTOSTOTAL += this.RENTA;
/* 5706 */     this.DIFGAST += this.RENTA;
/*      */     
/* 5708 */     actualizarSaldos();
/* 5709 */     actualizaTabla1();
/* 5710 */     actualizaTabla2();
/* 5711 */     actualizaTabla3();
/* 5712 */     actualizaTabla4();
/* 5713 */     sacarTotalPremios();
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 5717 */     this.jDialog16.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton42ActionPerformed(ActionEvent evt) {
/* 5721 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas generar el siguiente cargo de diesel?", "Cargar Diesel", 0, 3, this.PREG);
/* 5722 */     if (res == 0) {
/* 5723 */       this.SUBTOTAL -= this.DIESELCONTRA;
/* 5724 */       this.DIESELCONTRA = Double.parseDouble(String.valueOf(this.jFormattedTextField11.getValue()));
/* 5725 */       this.jLabel95.setText("-" + this.jFormattedTextField11.getText());
/* 5726 */       this.jLabel37.setText("-" + this.jFormattedTextField11.getText());
/* 5727 */       this.SUBTOTAL = this.VIAJESFORANEOS + this.PREMIOS + this.DIFGAST - this.DIESELCONTRA;
/* 5728 */       actualizarSaldos();
/* 5729 */       this.jDialog16.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 5734 */     String[] liqui = this.con.regresaReg("gastosDif,abonoTD,total,tarjeta,gastosAsig,totalLetra,gastosTotal", "liquidaciones", "where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'", 7);
/* 5735 */     this.con.consultar("estatus", "liquidaciones", "where folio_liq='" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 5736 */     String estado = this.con.Campo;
/* 5737 */     String valorP = "";
/* 5738 */     String CLAVEOP = liqui[3];
/* 5739 */     boolean menor = false;
/* 5740 */     double abono = Double.parseDouble(liqui[1]);
/* 5741 */     double totalLiq = Double.parseDouble(liqui[2]);
/* 5742 */     double gastosAsig = 0.0D;
/* 5743 */     for (int i = 0; i < liqui[0].length(); i++) {
/* 5744 */       if (liqui[0].charAt(i) != '$' && liqui[0].charAt(i) != ',' && liqui[0].charAt(i) != '-') {
/* 5745 */         valorP = valorP + valorP;
/*      */       }
/* 5747 */       if (liqui[0].charAt(i) == '-') {
/* 5748 */         menor = true;
/*      */       }
/*      */     } 
/*      */     
/* 5752 */     double gastosDif = 0.0D;
/* 5753 */     if (menor) {
/* 5754 */       gastosDif = -Double.parseDouble(valorP);
/*      */     } else {
/* 5756 */       gastosDif = Double.parseDouble(valorP);
/*      */     } 
/* 5758 */     valorP = ""; int j;
/* 5759 */     for (j = 0; j < liqui[4].length(); j++) {
/* 5760 */       if (liqui[4].charAt(j) != '$' && liqui[4].charAt(j) != ',' && liqui[4].charAt(j) != '-') {
/* 5761 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 5764 */     gastosAsig = Double.parseDouble(valorP);
/*      */     
/* 5766 */     valorP = "";
/* 5767 */     for (j = 0; j < liqui[6].length(); j++) {
/* 5768 */       if (liqui[6].charAt(j) != '$' && liqui[6].charAt(j) != ',' && liqui[6].charAt(j) != '-') {
/* 5769 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 5772 */     this.GASTOSTOTAL = Double.parseDouble(valorP);
/* 5773 */     if (estado.equals("<Por Autorizar>")) {
/* 5774 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas autorizar la liquidación siguiente?", "Autorizar Liquidación", 0, 3, this.PREG);
/* 5775 */       if (res == 0) {
/* 5776 */         String estatus = "";
/* 5777 */         if (totalLiq < -0.1D) {
/* 5778 */           double total = totalLiq;
/* 5779 */           estatus = "<Pagada>";
/* 5780 */           if (gastosAsig > 0.0D) {
/* 5781 */             total = gastosAsig;
/* 5782 */             String[][] datosR = this.con.buscarDatos(3, "mov,importeRestante,importeSaldado", "tarjeta_contenido", "where (tipoConcep=1) and tarjeta = " + CLAVEOP + " and importeRestante>0 order by mov");
/* 5783 */             String[] movi = new String[datosR.length];
/* 5784 */             String[] restan = new String[datosR.length];
/* 5785 */             String[] saldado = new String[datosR.length];
/*      */             int m;
/* 5787 */             for (m = 0; m < datosR.length; m++) {
/* 5788 */               for (int n = 0; n < (datosR[m]).length; n++) {
/* 5789 */                 if (n == 0) {
/* 5790 */                   movi[m] = datosR[m][n];
/*      */                 }
/* 5792 */                 if (n == 1) {
/* 5793 */                   restan[m] = datosR[m][n];
/*      */                 }
/* 5795 */                 if (n == 2) {
/* 5796 */                   saldado[m] = datosR[m][n];
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             
/* 5801 */             for (m = 0; m < restan.length && 
/* 5802 */               total > 0.0D; m++)
/*      */             {
/*      */               
/* 5805 */               total = saldar(total, Double.parseDouble(restan[m]), Double.parseDouble(saldado[m]), movi[m]).doubleValue();
/*      */             }
/*      */             
/* 5808 */             this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5809 */             total = Double.parseDouble(this.con.Campo);
/* 5810 */             this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 5811 */             this.jFormattedTextField4.setValue(Double.valueOf(gastosAsig));
/* 5812 */             double d = Double.parseDouble(liqui[2]);
/*      */             
/* 5814 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'COMPROBACIÓN DE GASTOS','LIQ: " + 
/* 5815 */                 String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "',0,''," + this.GASTOSTOTAL + ",'" + this.jFormattedTextField4.getText() + "',0,0,'','<Aplicado>','',3,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + CLAVEOP + ")");
/*      */           } 
/*      */           
/* 5818 */           this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5819 */           total = Double.parseDouble(this.con.Campo);
/* 5820 */           this.jFormattedTextField2.setValue(Double.valueOf(totalLiq));
/* 5821 */           String cantLetra = this.jFormattedTextField2.getText();
/*      */           
/* 5823 */           valorP = ""; int k;
/* 5824 */           for (k = 0; k < cantLetra.length(); k++) {
/* 5825 */             if (cantLetra.charAt(k) != '$' && cantLetra.charAt(k) != ',' && cantLetra.charAt(k) != '-') {
/* 5826 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 5829 */           totalLiq = Double.parseDouble(valorP);
/* 5830 */           this.jFormattedTextField4.setValue(Double.valueOf(totalLiq));
/* 5831 */           this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5832 */           if (this.encontrado) {
/* 5833 */             this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5834 */             String saldoFinal = this.con.Campo;
/* 5835 */             total = Double.parseDouble(saldoFinal) + totalLiq;
/*      */           } 
/* 5837 */           this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 5838 */           this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),1,'CARGO DE LIQUIDACIÓN','LIQ: " + 
/* 5839 */               String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'," + totalLiq + ",'" + this.jFormattedTextField4.getText() + "',0,'',0," + totalLiq + ",'SALDO NEGATIVO EN LIQUIDACIÓN: " + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "','<Por Pagar>','',2,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + CLAVEOP + ")");
/*      */ 
/*      */           
/* 5842 */           valorP = "";
/* 5843 */           for (k = 0; k < liqui[5].length(); k++) {
/* 5844 */             if (liqui[5].charAt(k) != '$' && liqui[5].charAt(k) != ',' && liqui[5].charAt(k) != '-') {
/* 5845 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 5848 */           total = 0.0D;
/* 5849 */           double cant = Double.parseDouble(valorP);
/* 5850 */           this.jFormattedTextField2.setValue(Double.valueOf(cant));
/* 5851 */           cantLetra = this.jFormattedTextField2.getText();
/* 5852 */           this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5853 */           if (this.encontrado) {
/* 5854 */             this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5855 */             String saldoFinal = this.con.Campo;
/* 5856 */             total = Double.parseDouble(saldoFinal) + cant;
/*      */           } else {
/* 5858 */             total = cant;
/*      */           } 
/* 5860 */           if (abono > 0.0D) {
/* 5861 */             total = abono;
/* 5862 */             String[][] datosR = this.con.buscarDatos(3, "mov,importeRestante,importeSaldado", "tarjeta_contenido", "where tipoConcep=2 and tarjeta = " + CLAVEOP + " and importeRestante>0 order by mov");
/* 5863 */             String[] movi = new String[datosR.length];
/* 5864 */             String[] restan = new String[datosR.length];
/* 5865 */             String[] saldado = new String[datosR.length];
/*      */             int m;
/* 5867 */             for (m = 0; m < datosR.length; m++) {
/* 5868 */               for (int n = 0; n < (datosR[m]).length; n++) {
/* 5869 */                 if (n == 0) {
/* 5870 */                   movi[m] = datosR[m][n];
/*      */                 }
/* 5872 */                 if (n == 1) {
/* 5873 */                   restan[m] = datosR[m][n];
/*      */                 }
/* 5875 */                 if (n == 2) {
/* 5876 */                   saldado[m] = datosR[m][n];
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             
/* 5881 */             for (m = 0; m < restan.length && 
/* 5882 */               total > 0.0D; m++)
/*      */             {
/*      */               
/* 5885 */               total = saldar(total, Double.parseDouble(restan[m]), Double.parseDouble(saldado[m]), movi[m]).doubleValue();
/*      */             }
/*      */             
/* 5888 */             this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5889 */             total = Double.parseDouble(this.con.Campo);
/* 5890 */             this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 5891 */             this.jFormattedTextField4.setValue(Double.valueOf(abono));
/* 5892 */             cant = Double.parseDouble(liqui[2]);
/* 5893 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'ABONO A TARJETA DEUDOR','LIQ: " + 
/* 5894 */                 String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "',0,''," + abono + ",'" + this.jFormattedTextField4.getText() + "',0,0,'','<Aplicado>','',3,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + CLAVEOP + ")");
/*      */           } 
/*      */         } else {
/* 5897 */           double total = gastosAsig;
/* 5898 */           estatus = "<Por Pagar>";
/* 5899 */           if (gastosAsig > 0.0D) {
/* 5900 */             String[][] datosR = this.con.buscarDatos(3, "mov,importeRestante,importeSaldado", "tarjeta_contenido", "where (tipoConcep=1) and tarjeta = " + CLAVEOP + " and importeRestante>0 order by mov");
/* 5901 */             String[] movi = new String[datosR.length];
/* 5902 */             String[] restan = new String[datosR.length];
/* 5903 */             String[] saldado = new String[datosR.length];
/*      */             int k;
/* 5905 */             for (k = 0; k < datosR.length; k++) {
/* 5906 */               for (int m = 0; m < (datosR[k]).length; m++) {
/* 5907 */                 if (m == 0) {
/* 5908 */                   movi[k] = datosR[k][m];
/*      */                 }
/* 5910 */                 if (m == 1) {
/* 5911 */                   restan[k] = datosR[k][m];
/*      */                 }
/* 5913 */                 if (m == 2) {
/* 5914 */                   saldado[k] = datosR[k][m];
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             
/* 5919 */             for (k = 0; k < restan.length && 
/* 5920 */               total > 0.0D; k++)
/*      */             {
/*      */               
/* 5923 */               total = saldar(total, Double.parseDouble(restan[k]), Double.parseDouble(saldado[k]), movi[k]).doubleValue();
/*      */             }
/*      */             
/* 5926 */             this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5927 */             total = Double.parseDouble(this.con.Campo);
/* 5928 */             this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 5929 */             this.jFormattedTextField4.setValue(Double.valueOf(gastosAsig));
/* 5930 */             double cant = Double.parseDouble(liqui[2]);
/* 5931 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'COMPROBACIÓN DE GASTOS','LIQ: " + 
/* 5932 */                 String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "',0,''," + gastosAsig + ",'" + this.jFormattedTextField4.getText() + "',0,0,'','<Aplicado>','',3,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + CLAVEOP + ")");
/*      */           } 
/*      */           
/* 5935 */           if (abono > 0.0D) {
/* 5936 */             total = abono;
/* 5937 */             String[][] datosR = this.con.buscarDatos(3, "mov,importeRestante,importeSaldado", "tarjeta_contenido", "where tipoConcep=2 and tarjeta = " + CLAVEOP + " and importeRestante>0 order by mov");
/* 5938 */             String[] movi = new String[datosR.length];
/* 5939 */             String[] restan = new String[datosR.length];
/* 5940 */             String[] saldado = new String[datosR.length];
/*      */             int k;
/* 5942 */             for (k = 0; k < datosR.length; k++) {
/* 5943 */               for (int m = 0; m < (datosR[k]).length; m++) {
/* 5944 */                 if (m == 0) {
/* 5945 */                   movi[k] = datosR[k][m];
/*      */                 }
/* 5947 */                 if (m == 1) {
/* 5948 */                   restan[k] = datosR[k][m];
/*      */                 }
/* 5950 */                 if (m == 2) {
/* 5951 */                   saldado[k] = datosR[k][m];
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             
/* 5956 */             for (k = 0; k < restan.length && 
/* 5957 */               total > 0.0D; k++)
/*      */             {
/*      */               
/* 5960 */               total = saldar(total, Double.parseDouble(restan[k]), Double.parseDouble(saldado[k]), movi[k]).doubleValue();
/*      */             }
/*      */             
/* 5963 */             this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + CLAVEOP);
/* 5964 */             total = Double.parseDouble(this.con.Campo);
/* 5965 */             this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 5966 */             this.jFormattedTextField4.setValue(Double.valueOf(abono));
/* 5967 */             double cant = Double.parseDouble(liqui[2]);
/* 5968 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'ABONO A TARJETA DEUDOR','LIQ: " + 
/* 5969 */                 String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "',0,''," + abono + ",'" + this.jFormattedTextField4.getText() + "',0,0,'','<Aplicado>','',3,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + CLAVEOP + ")");
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 5974 */         this.encontrado = this.con.consultar("mov", "tarjeta_contenido", "where tarjeta = " + CLAVEOP + " ORDER by mov");
/* 5975 */         String[] saldos = null;
/* 5976 */         if (this.encontrado) {
/* 5977 */           saldos = this.con.regresaReg("saldoFinal,SaldoFinalLetra", "tarjeta_contenido", "where tarjeta = " + CLAVEOP + " ORDER by mov", 2);
/*      */         } else {
/* 5979 */           saldos = new String[] { "0", "$0.00" };
/*      */         } 
/*      */ 
/*      */         
/* 5983 */         this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'SE AUTORIZÓ LIQUIDACIÓN','LIQ: " + 
/* 5984 */             String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "',0,'----',0,'----',0,0,'SE REALIZÓ UNA LIQUIDACIÓN POR PARTE DEL EMPLEADO CON UN SALDO FINAL DE:   " + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6)) + "','<Aplicado>','',3,'',''," + saldos[0] + ",'" + saldos[1] + "'," + CLAVEOP + ")");
/*      */         
/* 5986 */         this.con.consultar("usuario", "liquidaciones", "where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 5987 */         this.con.inserSinMsj("update liquidaciones set usuario='" + this.con.Campo + " / " + this.USUARIO + "', estatus = '" + estatus + "' where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 5988 */         this.con.inserSinMsj("update tarjeta_deudor set f_creacion = now(), usuario_creo ='" + this.USUARIO + "', saldo='" + saldos[1] + "' where tarjeta=" + CLAVEOP);
/* 5989 */         consultarLiq();
/*      */       } 
/*      */     } else {
/* 5992 */       JOptionPane.showMessageDialog(this.padre, "No puedes autorizar esta liquidación porque se encuetra cancelada o autorizada", "Autorizada", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 5997 */     cargarLiquidacion();
/*      */   }
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 6000 */     actualizarRendimientos();
/* 6001 */     this.jDialog18.setVisible(false);
/*      */   }
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 6004 */     this.jTextArea5.setText("");
/* 6005 */     int indice = this.jTable2.getSelectedRow();
/* 6006 */     String estado = String.valueOf(this.jTable2.getValueAt(indice, 5));
/* 6007 */     if (estado.equals("<Por Autorizar>")) {
/* 6008 */       this.jDialog19.setVisible(true);
/*      */     } else {
/* 6010 */       JOptionPane.showMessageDialog(this.padre, "No puedes cancelar esta liquidación porque ya ha sido autorizada", "Liquidación Autorizada", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton43ActionPerformed(ActionEvent evt) {
/* 6015 */     this.jDialog18.setVisible(true);
/*      */   }
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 6018 */     cancelar();
/*      */   }
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 6021 */     this.jDialog19.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 6025 */     String[] datos = { "FOLIO", "FECHA", "NOMBRE COMPLETO", "UNIDAD", "ELABORÓ/AUTORIZÓ", "ESTATUS", "TOTAL" };
/* 6026 */     this.esc = new EscribirReporte("LIQUIDACIONES", this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel1MouseExited(MouseEvent evt) {
/* 6030 */     this.jLabel1.setForeground(Color.BLUE);
/*      */   }
/*      */   
/*      */   private void jLabel1MouseEntered(MouseEvent evt) {
/* 6034 */     this.jLabel1.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 6038 */     if (this.jLabel1.getText().equals("<Cancelada>")) {
/* 6039 */       this.con.consultar("motivo", "liquidaciones", "where folio_liq = '" + this.jTextField61.getText() + "'");
/* 6040 */       JOptionPane.showMessageDialog(this.jDialog1, "<html><font color = blue><B>ESTE ES EL MOTIVO DE LA CANCELACIÓN</font><hR><font color=RED>" + this.con.Campo + "</font></B></html>", "Motivo", 0, this.INFO);
/*      */     } 
/*      */   }
/*      */   public void cancelar() {
/* 6044 */     this.error.pasarModal(true);
/* 6045 */     this.val.pasarModal(Boolean.valueOf(true));
/* 6046 */     String motivo = this.jTextArea5.getText();
/* 6047 */     if (motivo.equals("")) {
/* 6048 */       this.error.cargarError(this.jTextArea5, "050");
/*      */     }
/* 6050 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas cancelar la liquidación que seleccionaste?", "Cancelar Liquidación", 0, 3, this.PREG);
/* 6051 */     if (res == 0) {
/* 6052 */       this.con.inserSinMsj("update liquidaciones set estatus = '<Cancelada>', motivo = '" + this.jTextArea5.getText() + "' where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 6053 */       this.jTable16.setModel(new DefaultTableModel((Object[][])this.con
/* 6054 */             .buscarDatos(8, "folio,empresa,litros,precioLitro,precioLitroLetra,total,totalLetra,folio_liq", "vales_diesel", "where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'"), (Object[])new String[] { "folio", "empresa", "litros", "precioLitro", "preciolitroLetra", "total", "totalLetra", "folio_liq" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 6059 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6063 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 6066 */       this.con.inserSinMsj("update vales_diesel set empresa = '', litros = 0, precioLitro = 0, precioLitroLetra = '', total = 0, totalLetra = '', folio_liq = '' where folio_liq = '" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 6067 */       for (int i = 0; i < this.jTable16.getRowCount(); i++) {
/* 6068 */         this.con.inserSinMsj("insert into vales_diesel_cancel(folio,empresa,litros,precioLitro,precioLitroletra,total,totalLetra,folio_liq) values('" + 
/* 6069 */             String.valueOf(this.jTable16.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable16.getValueAt(i, 1)) + "'," + String.valueOf(this.jTable16.getValueAt(i, 2)) + "," + String.valueOf(this.jTable16.getValueAt(i, 3)) + ",'" + String.valueOf(this.jTable16.getValueAt(i, 4)) + "'," + String.valueOf(this.jTable16.getValueAt(i, 5)) + ",'" + String.valueOf(this.jTable16.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable16.getValueAt(i, 7)) + "')");
/*      */       }
/* 6071 */       consultarLiq();
/* 6072 */       this.jTextArea5.setText("");
/* 6073 */       this.jDialog19.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 6078 */     if (this.USUARIO.contains("MAYRA")) {
/* 6079 */       this.jButton4.setEnabled(false);
/* 6080 */       this.jButton5.setEnabled(false);
/*      */     } else {
/* 6082 */       this.jButton4.setEnabled(true);
/* 6083 */       this.jButton5.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Double saldar(double valor, double res, double saldado, String mov) {
/* 6088 */     double restante = 0.0D;
/* 6089 */     if (res > valor) {
/* 6090 */       res -= valor;
/* 6091 */       saldado += valor;
/* 6092 */       this.jFormattedTextField2.setValue(Double.valueOf(saldado));
/* 6093 */       this.con.inserSinMsj("update tarjeta_contenido set importesaldado = " + saldado + ", estatus='<Abono:" + this.jFormattedTextField2.getText() + ">',importeRestante = " + res + " where mov=" + mov);
/* 6094 */       restante = 0.0D;
/*      */     } else {
/* 6096 */       restante = valor - res;
/* 6097 */       saldado += res;
/* 6098 */       this.jFormattedTextField2.setValue(Double.valueOf(saldado));
/* 6099 */       Date fecha = new Date();
/* 6100 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 6101 */       String cadenaFecha = "";
/* 6102 */       cadenaFecha = formato.format(fecha);
/* 6103 */       String AÑO = cadenaFecha.substring(0, 4);
/* 6104 */       String MES = cadenaFecha.substring(4, 6);
/* 6105 */       String DIA = cadenaFecha.substring(6, 8);
/* 6106 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 6107 */       this.con.inserSinMsj("update tarjeta_contenido set estatus = '<Pagado:" + fechaCompleta1 + ">', importeSaldado = " + saldado + ",importeRestante =0 where mov=" + mov);
/*      */     } 
/*      */     
/* 6110 */     return Double.valueOf(restante);
/*      */   }
/*      */   
/*      */   public void cargarLiquidacion() {
/* 6114 */     int indice = this.jTable2.getSelectedRow();
/* 6115 */     String estatus = String.valueOf(this.jTable2.getValueAt(indice, 5));
/* 6116 */     desactivar();
/* 6117 */     this.jDialog1.setTitle("Liquidación - " + String.valueOf(this.jTable2.getValueAt(indice, 0)));
/* 6118 */     this.jLabel1.setText(String.valueOf(this.jTable2.getValueAt(indice, 5)));
/* 6119 */     this.con.consultar("liquidaciones.tarjeta", "tarjeta_deudor,liquidaciones", "where tarjeta_deudor.tarjeta = liquidaciones.tarjeta and liquidaciones.folio_liq = '" + String.valueOf(this.jTable2.getValueAt(indice, 0)) + "'");
/* 6120 */     this.CLAVEOP = this.con.Campo;
/* 6121 */     if (estatus.equals("<Por Autorizar>")) {
/* 6122 */       this.jButton10.setEnabled(true);
/* 6123 */       this.jButton11.setEnabled(true);
/* 6124 */       this.jButton12.setEnabled(true);
/* 6125 */       this.jButton14.setEnabled(true);
/* 6126 */       this.jButton15.setEnabled(false);
/* 6127 */       this.jButton16.setEnabled(true);
/* 6128 */       this.jButton7.setEnabled(true);
/* 6129 */       this.jButton9.setEnabled(true);
/* 6130 */       this.jTextField2.setEnabled(true);
/* 6131 */       this.jFormattedTextField1.setEnabled(true);
/* 6132 */       this.jRadioButton2.setEnabled(false);
/* 6133 */       this.ESMODIFICA = true;
/*      */       
/* 6135 */       this.jButton15.setEnabled(false);
/* 6136 */       this.jRadioButton1.setEnabled(false);
/* 6137 */       this.jFormattedTextField1.setEnabled(true);
/* 6138 */       this.jRadioButton2.setEnabled(false);
/* 6139 */       this.jButton26.setEnabled(true);
/* 6140 */       this.jButton17.setEnabled(true);
/* 6141 */       this.jButton6.setEnabled(true);
/* 6142 */       this.jFormattedTextField11.setEnabled(true);
/* 6143 */       this.jButton42.setEnabled(true);
/* 6144 */       this.jButton29.setEnabled(true);
/* 6145 */       this.jButton24.setEnabled(true);
/* 6146 */       this.jButton25.setEnabled(true);
/* 6147 */       this.jButton7.setEnabled(true);
/* 6148 */       this.jButton9.setEnabled(true);
/* 6149 */       this.jButton27.setEnabled(true);
/* 6150 */       this.jButton28.setEnabled(true);
/* 6151 */       this.jButton30.setEnabled(true);
/* 6152 */       this.jButton43.setEnabled(true);
/*      */       
/* 6154 */       this.jButton14.setEnabled(true);
/* 6155 */       this.jButton16.setEnabled(true);
/* 6156 */       this.jTextField2.setEnabled(false);
/* 6157 */       this.jButton16.setText("Guardar");
/*      */     } else {
/* 6159 */       this.jTextField2.setEnabled(false);
/* 6160 */       this.ESMODIFICA = false;
/* 6161 */       this.jButton10.setEnabled(true);
/* 6162 */       this.jButton11.setEnabled(true);
/* 6163 */       this.jButton12.setEnabled(true);
/* 6164 */       this.jButton14.setEnabled(true);
/* 6165 */       this.jButton15.setEnabled(false);
/* 6166 */       this.jButton16.setEnabled(true);
/* 6167 */       this.jButton7.setEnabled(true);
/* 6168 */       this.jButton9.setEnabled(true);
/* 6169 */       this.jRadioButton1.setEnabled(false);
/* 6170 */       this.jFormattedTextField1.setEnabled(false);
/* 6171 */       this.jRadioButton2.setEnabled(false);
/* 6172 */       this.jButton26.setEnabled(false);
/* 6173 */       this.jButton17.setEnabled(false);
/* 6174 */       this.jButton6.setEnabled(false);
/* 6175 */       this.jFormattedTextField11.setEnabled(false);
/* 6176 */       this.jButton42.setEnabled(false);
/* 6177 */       this.jButton29.setEnabled(false);
/* 6178 */       this.jButton24.setEnabled(false);
/* 6179 */       this.jButton25.setEnabled(false);
/*      */       
/* 6181 */       this.jButton27.setEnabled(false);
/* 6182 */       this.jButton28.setEnabled(false);
/* 6183 */       this.jButton30.setEnabled(false);
/* 6184 */       this.jButton7.setEnabled(false);
/* 6185 */       this.jButton9.setEnabled(false);
/*      */       
/* 6187 */       this.jButton14.setEnabled(false);
/* 6188 */       this.jButton16.setText("Imprimir");
/*      */     } 
/* 6190 */     String[] datos = this.con.regresaReg("nombreCompleto,fecha,impuestos,diesel,premios,autopistas,propinas,llantas,otrosGastos,gastosTotal,gastosAsig,gastosDif,viajesForaneos,unidad,saldoTD,abonoTD,subtotal,total,dieselContra,tipoLiq,tipoTractor,folio_liq,dieselconsum,precioLitro, liquidaciones.fechaPrimerViaje", "tarjeta_deudor,liquidaciones", "where tarjeta_deudor.tarjeta = liquidaciones.tarjeta and liquidaciones.folio_liq = '" + String.valueOf(this.jTable2.getValueAt(indice, 0)) + "'", 25);
/* 6191 */     this.jTextField63.setText(datos[24]);
/* 6192 */     this.DIRECTIVA[1] = datos[23];
/* 6193 */     this.DIESELCONSUMIDO = Double.parseDouble(datos[22]);
/* 6194 */     this.jFormattedTextField2.setValue(Double.valueOf(this.DIESELCONSUMIDO));
/* 6195 */     this.jLabel155.setText(this.jFormattedTextField2.getText());
/* 6196 */     this.jFormattedTextField11.setValue(Double.valueOf(Double.parseDouble(datos[18])));
/* 6197 */     this.DIESELCONTRA = Double.parseDouble(datos[18]);
/* 6198 */     this.jTextField8.setText(datos[0]);
/* 6199 */     String año = datos[1].substring(0, 4);
/* 6200 */     String mes = datos[1].substring(5, 7);
/* 6201 */     String dia = datos[1].substring(8, 10);
/*      */     
/* 6203 */     this.jTextField62.setText(dia + "/" + dia + "/" + mes);
/*      */     
/* 6205 */     this.jTextField2.setText(datos[13]);
/* 6206 */     this.jLabel96.setText(datos[3]);
/* 6207 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(datos[18])));
/* 6208 */     if (Double.parseDouble(datos[18]) >= 0.0D) {
/* 6209 */       this.jLabel95.setForeground(Color.BLACK);
/*      */     } else {
/* 6211 */       this.jLabel95.setForeground(Color.RED);
/*      */     } 
/* 6213 */     this.jLabel95.setText(this.jFormattedTextField2.getText());
/* 6214 */     this.jLabel30.setText(datos[4]);
/* 6215 */     this.jLabel158.setText(datos[4]);
/* 6216 */     this.jLabel18.setText(datos[5]);
/* 6217 */     this.jLabel19.setText(datos[6]);
/* 6218 */     this.jLabel20.setText(datos[7]);
/* 6219 */     this.jLabel22.setText(datos[8]);
/* 6220 */     this.jLabel24.setText(datos[9]);
/* 6221 */     this.jLabel26.setText(datos[10]);
/* 6222 */     this.jLabel49.setText(datos[11]);
/* 6223 */     if (datos[19].equals("Evento")) {
/* 6224 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 6226 */       this.jRadioButton2.setSelected(true);
/*      */     } 
/* 6228 */     this.jTextField16.setText(datos[20]);
/* 6229 */     this.jLabel33.setText(datos[12]);
/* 6230 */     this.jLabel35.setText(datos[4]);
/* 6231 */     this.jLabel37.setText(this.jLabel95.getText());
/* 6232 */     this.jLabel39.setText(this.jLabel49.getText());
/* 6233 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(datos[16])));
/* 6234 */     this.jLabel43.setText(this.jFormattedTextField2.getText());
/* 6235 */     this.SUBTOTAL = Double.parseDouble(datos[16]);
/* 6236 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(datos[2])));
/* 6237 */     this.jLabel45.setText(this.jFormattedTextField2.getText());
/* 6238 */     this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(datos[14])));
/* 6239 */     this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(datos[15])));
/*      */     
/* 6241 */     if (Double.parseDouble(datos[17]) >= 0.0D) {
/* 6242 */       this.jFormattedTextField4.setForeground(Color.BLACK);
/*      */     } else {
/* 6244 */       this.jFormattedTextField4.setForeground(Color.RED);
/*      */     } 
/* 6246 */     this.jFormattedTextField4.setValue(Double.valueOf(Double.parseDouble(datos[17])));
/* 6247 */     this.jLabel14.setText(datos[12]);
/* 6248 */     this.jTextField61.setText(datos[21]);
/*      */ 
/*      */ 
/*      */     
/* 6252 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 6253 */           .buscarDatos(2, "concepto,totalLetra,total", "premiosliq", "where folio_liq = '" + datos[21] + "'"), (Object[])new String[] { "Concepto", "Cantidad" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6258 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6263 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6266 */     this.jTable6.setShowVerticalLines(false);
/* 6267 */     this.jTable6.setSelectionMode(0); int j;
/* 6268 */     for (j = 0; j < this.jTable6.getRowCount(); j++) {
/* 6269 */       String str1 = String.valueOf(this.jTable6.getValueAt(j, 1));
/* 6270 */       String str2 = "";
/* 6271 */       for (int i1 = 0; i1 < str1.length(); i1++) {
/* 6272 */         if (str1.charAt(i1) != '$' && str1.charAt(i1) != ',') {
/* 6273 */           str2 = str2 + str2;
/*      */         }
/*      */       } 
/* 6276 */       this.PREMIOS += Double.parseDouble(str2);
/* 6277 */       this.VALORPREMIOS[j] = Double.parseDouble(str2);
/*      */     } 
/* 6279 */     this.MODELOPREMIOS = (DefaultTableModel)this.jTable6.getModel();
/*      */     
/* 6281 */     this.jTable7.setModel(new DefaultTableModel((Object[][])this.con
/* 6282 */           .buscarDatos(4, "concepto,referencia,fecha,totalLetra", "gastosliq", "where folio_liq = '" + datos[21] + "'"), (Object[])new String[] { "Concepto", "Folio", "Fecha", "Cantidad" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6287 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6292 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6295 */     this.jTable7.setShowVerticalLines(false);
/* 6296 */     this.jTable7.setSelectionMode(0);
/* 6297 */     this.jTable7.getColumnModel().getColumn(1).setMinWidth(75);
/* 6298 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(75);
/* 6299 */     this.jTable7.getColumnModel().getColumn(2).setMinWidth(80);
/* 6300 */     this.jTable7.getColumnModel().getColumn(2).setMaxWidth(80);
/* 6301 */     this.jTable7.getColumnModel().getColumn(3).setMinWidth(60);
/* 6302 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(60);
/*      */     
/* 6304 */     for (j = 0; j < this.jTable7.getRowCount(); j++) {
/* 6305 */       String str1 = String.valueOf(this.jTable7.getValueAt(j, 3));
/* 6306 */       String str2 = "";
/* 6307 */       for (int i1 = 0; i1 < str1.length(); i1++) {
/* 6308 */         if (str1.charAt(i1) != '$' && str1.charAt(i1) != ',') {
/* 6309 */           str2 = str2 + str2;
/*      */         }
/*      */       } 
/* 6312 */       this.SOLOGASTOS += Double.parseDouble(str2);
/* 6313 */       this.VALORGASTOS[j] = Double.parseDouble(str2);
/* 6314 */       this.GASTOSTOTAL += Double.parseDouble(str2);
/*      */     } 
/* 6316 */     this.MODELOGASTOS = (DefaultTableModel)this.jTable7.getModel();
/*      */     
/* 6318 */     DefaultTableModel modelo = new DefaultTableModel();
/* 6319 */     modelo.addColumn("Folio");
/* 6320 */     modelo.addColumn("Estado");
/* 6321 */     this.jTable8.setModel(modelo);
/*      */     
/* 6323 */     String edo = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 5));
/* 6324 */     String tabla = "";
/* 6325 */     if (edo.equals("<Cancelada>")) {
/* 6326 */       tabla = "vales_diesel_Cancel";
/*      */     } else {
/* 6328 */       tabla = "vales_diesel";
/*      */     } 
/* 6330 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 6331 */           .buscarDatos(5, "folio,empresa,litros,precioLitroLetra,totalLetra", tabla, "where folio_liq = '" + datos[21] + "'"), (Object[])new String[] { "Folio", "Expedido Por", "Litros", "Precio", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6336 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6341 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6344 */     this.jTable1.setShowVerticalLines(false);
/* 6345 */     this.jTable1.setSelectionMode(0);
/*      */     
/* 6347 */     for (int k = 0; k < this.jTable1.getRowCount(); k++) {
/* 6348 */       this.jComboBox3.addItem(String.valueOf(this.jTable1.getValueAt(k, 0)));
/* 6349 */       String str1 = String.valueOf(this.jTable1.getValueAt(k, 3));
/* 6350 */       String str2 = "";
/*      */       int i1;
/* 6352 */       for (i1 = 0; i1 < str1.length(); i1++) {
/* 6353 */         if (str1.charAt(i1) != '$' && str1.charAt(i1) != ',') {
/* 6354 */           str2 = str2 + str2;
/*      */         }
/*      */       } 
/* 6357 */       this.PRECIODIESEL[k] = Double.parseDouble(str2);
/* 6358 */       str1 = String.valueOf(this.jTable1.getValueAt(k, 4));
/* 6359 */       str2 = "";
/* 6360 */       for (i1 = 0; i1 < str1.length(); i1++) {
/* 6361 */         if (str1.charAt(i1) != '$' && str1.charAt(i1) != ',') {
/* 6362 */           str2 = str2 + str2;
/*      */         }
/*      */       } 
/* 6365 */       this.VALORDIESEL[k] = Double.parseDouble(str2);
/* 6366 */       this.DIESELCOMPROBADO += Double.parseDouble(str2);
/*      */     } 
/*      */     
/* 6369 */     this.MODELODIESEL = (DefaultTableModel)this.jTable1.getModel();
/* 6370 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 6371 */           .buscarDatos(10, "folio_vale,tipoCarga,Origen,Destino,km,kmlt,litros,tons,tipoPago,salarioLetra", "detliq", "where folio_liq = '" + datos[21] + "' order by mov"), (Object[])new String[] { "H.R.S.P.", "Tipo Carga", "Orgien", "Destino", "Km", "Km/Lt", "Litros", "Peso", "Tipo", "Sub-Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6376 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6380 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6383 */     this.jTable4.getColumnModel().getColumn(0).setMinWidth(60);
/* 6384 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/* 6385 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(65);
/* 6386 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(65);
/*      */     
/* 6388 */     this.jTable4.getColumnModel().getColumn(4).setMinWidth(40);
/* 6389 */     this.jTable4.getColumnModel().getColumn(4).setMaxWidth(40);
/* 6390 */     this.jTable4.getColumnModel().getColumn(5).setMinWidth(40);
/* 6391 */     this.jTable4.getColumnModel().getColumn(5).setMaxWidth(40);
/* 6392 */     this.jTable4.getColumnModel().getColumn(6).setMinWidth(55);
/* 6393 */     this.jTable4.getColumnModel().getColumn(6).setMaxWidth(55);
/* 6394 */     this.jTable4.getColumnModel().getColumn(7).setMinWidth(40);
/* 6395 */     this.jTable4.getColumnModel().getColumn(7).setMaxWidth(40);
/* 6396 */     this.jTable4.getColumnModel().getColumn(8).setMinWidth(55);
/* 6397 */     this.jTable4.getColumnModel().getColumn(8).setMaxWidth(55);
/* 6398 */     this.jTable4.getColumnModel().getColumn(9).setMinWidth(60);
/* 6399 */     this.jTable4.getColumnModel().getColumn(9).setMaxWidth(60);
/* 6400 */     this.jTable4.setShowVerticalLines(false);
/* 6401 */     this.jTable4.setSelectionMode(0);
/*      */     
/* 6403 */     this.AUTOPISTAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 6404 */     this.PROPINAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 6405 */     this.LLANTAS[this.jTable4.getRowCount()] = Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */     
/* 6407 */     this.BAUTOPISTAS += Double.parseDouble(String.valueOf(this.jFormattedTextField12.getValue()));
/* 6408 */     this.BPROPINAS += Double.parseDouble(String.valueOf(this.jFormattedTextField13.getValue()));
/* 6409 */     this.BLLANTAS += Double.parseDouble(String.valueOf(this.jFormattedTextField14.getValue()));
/*      */     
/* 6411 */     this.encontrado = this.con.consultar("count(mov)", "detLiq", "where folio_liq = '" + datos[21] + "'");
/* 6412 */     String[][] ejemplo = this.con.buscarReg(3, Integer.parseInt(this.con.Campo), "autopistas,propinas,llantas", "detliq", "where folio_liq = '" + datos[21] + "'");
/* 6413 */     if (this.encontrado) {
/* 6414 */       for (int i1 = 0; i1 < ejemplo.length; i1++) {
/* 6415 */         this.AUTOPISTAS[i1] = Double.parseDouble(ejemplo[i1][0]);
/* 6416 */         this.PROPINAS[i1] = Double.parseDouble(ejemplo[i1][1]);
/* 6417 */         this.LLANTAS[i1] = Double.parseDouble(ejemplo[i1][2]);
/*      */         
/* 6419 */         this.GASTOSTOTAL += Double.parseDouble(ejemplo[i1][0]);
/* 6420 */         this.GASTOSTOTAL += Double.parseDouble(ejemplo[i1][1]);
/* 6421 */         this.GASTOSTOTAL += Double.parseDouble(ejemplo[i1][2]);
/*      */       } 
/*      */     }
/* 6424 */     for (int m = 0; m < datos[12].length(); m++) {
/* 6425 */       String str1 = datos[12];
/* 6426 */       String str2 = "";
/* 6427 */       for (int i1 = 0; i1 < str1.length(); i1++) {
/* 6428 */         if (str1.charAt(i1) != '$' && str1.charAt(i1) != ',') {
/* 6429 */           str2 = str2 + str2;
/*      */         }
/*      */       } 
/* 6432 */       this.VIAJESFORANEOS = Double.parseDouble(str2);
/*      */     } 
/* 6434 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 6435 */       Object[] reg = { String.valueOf(this.jTable4.getValueAt(i, 0)), String.valueOf(this.jTable4.getValueAt(i, 1)), String.valueOf(this.jTable4.getValueAt(i, 2)), String.valueOf(this.jTable4.getValueAt(i, 3)), String.valueOf(this.jTable4.getValueAt(i, 4)), String.valueOf(this.jTable4.getValueAt(i, 5)), String.valueOf(this.jTable4.getValueAt(i, 6)), this.jTable4.getValueAt(i, 7), this.jTable4.getValueAt(i, 8), String.valueOf(this.jTable4.getValueAt(i, 9)) };
/* 6436 */       this.MODELOVIAJES.addRow(reg);
/* 6437 */       this.KM += Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 4)));
/* 6438 */       this.KMLT += Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 5)));
/* 6439 */       this.LITROS += Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 6)));
/* 6440 */       this.TONS += Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 7)));
/*      */     } 
/* 6442 */     String canti = datos[10];
/* 6443 */     String valorP = ""; int n;
/* 6444 */     for (n = 0; n < canti.length(); n++) {
/* 6445 */       if (canti.charAt(n) != '$' && canti.charAt(n) != ',' && canti.charAt(n) != '-') {
/* 6446 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6449 */     this.GASTOSASIG = -Double.parseDouble(valorP);
/* 6450 */     this.jFormattedTextField2.setValue(Double.valueOf(this.GASTOSASIG));
/* 6451 */     this.jLabel26.setText(this.jFormattedTextField2.getText());
/* 6452 */     this.DIFGAST = this.GASTOSTOTAL + this.GASTOSASIG;
/* 6453 */     this.IMPUESTOS = Double.parseDouble(datos[2]);
/* 6454 */     calcularGastos();
/* 6455 */     actualizarDiesel();
/* 6456 */     actualizarSaldos();
/*      */     
/* 6458 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/* 6459 */       String peso = String.valueOf(this.jTable4.getValueAt(n, 7));
/* 6460 */       String kmL = String.valueOf(this.jTable4.getValueAt(n, 5));
/*      */       
/* 6462 */       double Tons = Double.parseDouble(peso);
/*      */       
/* 6464 */       if (Tons == 0.0D) {
/* 6465 */         this.jFormattedTextField15.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6466 */       } else if (Tons < 5.0D) {
/* 6467 */         this.jFormattedTextField16.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6468 */       } else if (Tons < 10.0D) {
/* 6469 */         this.jFormattedTextField17.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6470 */       } else if (Tons < 15.0D) {
/* 6471 */         this.jFormattedTextField18.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6472 */       } else if (Tons < 20.0D) {
/* 6473 */         this.jFormattedTextField19.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6474 */       } else if (Tons < 25.0D) {
/* 6475 */         this.jFormattedTextField20.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6476 */       } else if (Tons < 30.0D) {
/* 6477 */         this.jFormattedTextField21.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6478 */       } else if (Tons < 35.0D) {
/* 6479 */         this.jFormattedTextField22.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6480 */       } else if (Tons < 40.0D) {
/* 6481 */         this.jFormattedTextField23.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6482 */       } else if (Tons < 45.0D) {
/* 6483 */         this.jFormattedTextField24.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6484 */       } else if (Tons < 50.0D) {
/* 6485 */         this.jFormattedTextField25.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6486 */       } else if (Tons < 55.0D) {
/* 6487 */         this.jFormattedTextField26.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6488 */       } else if (Tons < 60.0D) {
/* 6489 */         this.jFormattedTextField27.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6490 */       } else if (Tons < 65.0D) {
/* 6491 */         this.jFormattedTextField28.setValue(Double.valueOf(Double.parseDouble(kmL)));
/* 6492 */       } else if (Tons < 70.0D) {
/* 6493 */         this.jFormattedTextField29.setValue(Double.valueOf(Double.parseDouble(kmL)));
/*      */       } 
/*      */     } 
/*      */     
/* 6497 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void calcularGastos() {
/* 6501 */     double autop = 0.0D;
/* 6502 */     double prop = 0.0D;
/* 6503 */     double llantas = 0.0D;
/* 6504 */     for (int i = 0; i < this.MODELOVIAJES.getRowCount(); i++) {
/* 6505 */       prop += this.PROPINAS[i];
/* 6506 */       autop += this.AUTOPISTAS[i];
/* 6507 */       llantas += this.LLANTAS[i];
/*      */     } 
/*      */     
/* 6510 */     this.jFormattedTextField2.setValue(Double.valueOf(autop));
/* 6511 */     this.jLabel18.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6513 */     this.jFormattedTextField2.setValue(Double.valueOf(prop));
/* 6514 */     this.jLabel19.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6516 */     this.jFormattedTextField2.setValue(Double.valueOf(llantas));
/* 6517 */     this.jLabel20.setText(this.jFormattedTextField2.getText());
/*      */   }
/*      */   
/*      */   public void guardarOrigen() {
/* 6521 */     this.error.pasarModal(true);
/* 6522 */     this.val.pasarModal(Boolean.valueOf(true));
/* 6523 */     String marca = this.jTextField20.getText().toUpperCase();
/* 6524 */     if (marca.equals("")) {
/* 6525 */       this.error.cargarError(this.jTextField20, "050");
/* 6526 */     } else if (!this.val.validarApostrofe(this.jTextField20, marca, "020")) {
/* 6527 */       this.encontrado = this.con.consultar("origen", "origenes", "where origen = '" + this.jTextField20.getText() + "'");
/* 6528 */       if (this.encontrado) {
/* 6529 */         JOptionPane.showMessageDialog(this.jDialog3, "No puedes crear el origen porque ya existe en la base de datos", "origen Duplicada", 0, this.ERROR);
/*      */       } else {
/* 6531 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas crear un nuevo origen?", "Crear Origen", 0, 1, this.PREG);
/* 6532 */         if (res == 0) {
/* 6533 */           this.con.insertar("insert into Origenes(origen)values('" + marca + "')");
/* 6534 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un Nuevo Origen.','Origen: " + this.jTextField20.getText() + "')");
/* 6535 */           consultar5();
/* 6536 */           this.jTextField20.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void guardarDestino() {
/* 6543 */     this.error.pasarModal(true);
/* 6544 */     this.val.pasarModal(Boolean.valueOf(true));
/* 6545 */     String marca = this.jTextField21.getText().toUpperCase();
/* 6546 */     if (marca.equals("")) {
/* 6547 */       this.error.cargarError(this.jTextField21, "050");
/* 6548 */     } else if (!this.val.validarApostrofe(this.jTextField21, marca, "020")) {
/* 6549 */       this.encontrado = this.con.consultar("destino", "destinos", "where destino = '" + this.jTextField21.getText() + "'");
/* 6550 */       if (this.encontrado) {
/* 6551 */         JOptionPane.showMessageDialog(this.jDialog15, "No puedes crear el destino porque ya existe en la base de datos", "origen Duplicada", 0, this.ERROR);
/*      */       } else {
/* 6553 */         int res = JOptionPane.showConfirmDialog(this.jDialog15, "¿Estás seguro que deseas crear un nuevo destino?", "Crear Destino", 0, 1, this.PREG);
/* 6554 */         if (res == 0) {
/* 6555 */           this.con.insertar("insert into destinos(destino)values('" + marca + "')");
/* 6556 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo Destino.','Destino: " + this.jTextField21.getText() + "')");
/* 6557 */           llenarCombo2();
/* 6558 */           consultar6();
/* 6559 */           this.jTextField21.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombo2() {
/* 6566 */     this.jComboBox7.removeAllItems();
/* 6567 */     String[] depa = this.con.regresaColIndex("nombrecorto", "emp_destinataria", "where clave_desti<>0 AND NOMBRECORTO<>'' order by nombrecorto");
/* 6568 */     this.jComboBox7.addItem("SELECCIONA UNO...");
/* 6569 */     for (int i = 0; i < depa.length; i++) {
/* 6570 */       this.jComboBox7.addItem(depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void sacarTotalPremios() {
/* 6575 */     double total = 0.0D;
/* 6576 */     for (int i = 0; i < this.VALORPREMIOS.length; i++) {
/* 6577 */       total += this.VALORPREMIOS[i];
/*      */     }
/* 6579 */     this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 6580 */     this.jLabel30.setText(this.jFormattedTextField2.getText());
/* 6581 */     this.jLabel158.setText(this.jFormattedTextField2.getText());
/* 6582 */     this.jLabel35.setText(this.jFormattedTextField2.getText());
/*      */   }
/*      */   
/*      */   public void actualizaSub() {
/* 6586 */     double abono = 0.0D;
/*      */     try {
/* 6588 */       abono = Double.parseDouble(this.jFormattedTextField1.getText());
/* 6589 */     } catch (NumberFormatException n) {
/* 6590 */       abono = Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()));
/*      */     } 
/* 6592 */     this.NETO = this.SUBTOTAL - this.IMPUESTOS;
/* 6593 */     this.NETO -= abono;
/* 6594 */     if (this.NETO >= 0.0D) {
/* 6595 */       this.jFormattedTextField4.setForeground(Color.BLACK);
/*      */     } else {
/* 6597 */       this.jFormattedTextField4.setForeground(Color.RED);
/*      */     } 
/* 6599 */     this.jFormattedTextField4.setValue(Double.valueOf(this.NETO));
/*      */   }
/*      */   
/*      */   public void pasarVale() {
/* 6603 */     String exp = this.jTextField11.getText();
/* 6604 */     String litros = this.jTextField12.getText();
/* 6605 */     String precio = this.jFormattedTextField5.getText();
/* 6606 */     if (this.jTextField11.getText().equals("")) {
/* 6607 */       this.error.cargarError(this.jTextField11, "050");
/* 6608 */     } else if (this.jTextField12.getText().equals("")) {
/* 6609 */       this.error.cargarError(this.jTextField12, "050");
/* 6610 */     } else if (precio.equals("$0.00")) {
/* 6611 */       this.jFormattedTextField5.setBackground(Color.RED);
/* 6612 */       JOptionPane.showMessageDialog(this.jDialog5, "Te falta agregar el precio por litro del diesel", "Falta Precio", 0, this.ADVER);
/* 6613 */     } else if (!this.val.validarApostrofe(this.jTextField11, this.jTextField11.getText(), "020")) {
/* 6614 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 6615 */         String valor = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 6616 */         String folio = String.valueOf(this.jComboBox3.getSelectedItem());
/* 6617 */         String column = String.valueOf(this.jTable1.getValueAt(i, 1));
/* 6618 */         if (valor.equals(folio) && !column.equals("")) {
/* 6619 */           this.jComboBox3.setBackground(Color.RED);
/* 6620 */           JOptionPane.showMessageDialog(this.jDialog5, "El vale " + folio + " ya ha sido complementado, selecciona otro vale", "Vale Complementado", 0, this.ADVER);
/*      */           return;
/*      */         } 
/*      */       } 
/* 6624 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas completar el vale de diesel?", "Completar Vale", 0, 3, this.PREG);
/* 6625 */       if (res == 0) {
/* 6626 */         Object[] reg = { this.jTextField11.getText(), this.jTextField12.getText(), this.jFormattedTextField5.getText(), this.jFormattedTextField6.getText() };
/* 6627 */         String folio = String.valueOf(this.jComboBox3.getSelectedItem());
/* 6628 */         this.jTable1.setValueAt(this.jTextField11.getText().toUpperCase(), this.jComboBox3.getSelectedIndex(), 1);
/* 6629 */         this.jTable1.setValueAt(this.jTextField12.getText(), this.jComboBox3.getSelectedIndex(), 2);
/* 6630 */         this.jTable1.setValueAt(this.jFormattedTextField5.getText(), this.jComboBox3.getSelectedIndex(), 3);
/* 6631 */         this.jTable1.setValueAt(this.jFormattedTextField6.getText(), this.jComboBox3.getSelectedIndex(), 4);
/* 6632 */         this.VALORDIESEL[this.jComboBox3.getSelectedIndex()] = Double.parseDouble(this.jFormattedTextField6.getValue().toString());
/* 6633 */         this.DIESELCOMPROBADO += Double.parseDouble(this.jFormattedTextField6.getValue().toString());
/* 6634 */         this.PRECIODIESEL[this.jComboBox3.getSelectedIndex()] = Double.parseDouble(this.jFormattedTextField5.getValue().toString());
/* 6635 */         String[] valores = { String.valueOf(this.jComboBox3.getSelectedItem()), this.jTextField11.getText(), this.jTextField12.getText(), this.jFormattedTextField5.getText(), this.jFormattedTextField6.getText() };
/* 6636 */         this.MODELODIESEL.setValueAt(this.jTextField11.getText(), this.jComboBox3.getSelectedIndex(), 1);
/* 6637 */         this.MODELODIESEL.setValueAt(this.jTextField12.getText(), this.jComboBox3.getSelectedIndex(), 2);
/* 6638 */         this.MODELODIESEL.setValueAt(this.jFormattedTextField5.getText(), this.jComboBox3.getSelectedIndex(), 3);
/* 6639 */         this.MODELODIESEL.setValueAt(this.jFormattedTextField6.getText(), this.jComboBox3.getSelectedIndex(), 4);
/* 6640 */         this.jTextField11.setText("");
/* 6641 */         this.jTextField12.setText("");
/* 6642 */         this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 6643 */         this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 6644 */         sacarTotalDiesel();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarTotalDiesel() {
/* 6650 */     double total = 0.0D;
/* 6651 */     for (int i = 0; i < this.VALORDIESEL.length; i++) {
/* 6652 */       total += this.VALORDIESEL[i];
/*      */     }
/* 6654 */     this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 6655 */     this.jLabel96.setText(this.jFormattedTextField2.getText());
/*      */   }
/*      */   
/*      */   public void calculaPrecio() {
/* 6659 */     String litros = this.jTextField12.getText();
/* 6660 */     double precio = 0.0D;
/*      */     try {
/* 6662 */       precio = Double.parseDouble(this.jFormattedTextField5.getText());
/* 6663 */     } catch (NumberFormatException n) {
/* 6664 */       precio = Double.parseDouble(String.valueOf(this.jFormattedTextField5.getValue()));
/*      */     } 
/* 6666 */     double total = Double.parseDouble(litros) * precio;
/* 6667 */     this.jFormattedTextField6.setValue(Double.valueOf(total));
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 6671 */     this.jTextField8.setText("");
/* 6672 */     this.CLAVEOP = "0";
/* 6673 */     this.jTextField2.setText("");
/* 6674 */     this.jButton7.setEnabled(false);
/* 6675 */     this.jButton9.setEnabled(false);
/* 6676 */     this.jButton10.setEnabled(false);
/* 6677 */     this.jButton43.setEnabled(false);
/* 6678 */     this.jButton11.setEnabled(false);
/* 6679 */     this.jButton12.setEnabled(false);
/* 6680 */     this.jButton14.setEnabled(false);
/* 6681 */     this.jButton16.setEnabled(false);
/* 6682 */     this.jFormattedTextField1.setEnabled(false);
/* 6683 */     this.jLabel18.setText("$0.00");
/* 6684 */     this.jLabel19.setText("$0.00");
/* 6685 */     this.jLabel20.setText("$0.00");
/* 6686 */     this.jLabel22.setText("$0.00");
/* 6687 */     this.jLabel24.setText("$0.00");
/* 6688 */     this.jLabel26.setText("$0.00");
/* 6689 */     this.jLabel30.setText("$0.00");
/* 6690 */     this.jLabel33.setText("$0.00");
/* 6691 */     this.jLabel35.setText("$0.00");
/* 6692 */     this.jLabel37.setText("$0.00");
/* 6693 */     this.jLabel39.setText("$0.00");
/* 6694 */     this.jLabel155.setText("$0.00");
/* 6695 */     this.jLabel41.setText("$0.00");
/* 6696 */     this.jLabel43.setText("$0.00");
/* 6697 */     this.jLabel45.setText("$0.00");
/* 6698 */     this.jLabel49.setText("$0.00");
/* 6699 */     this.jLabel14.setText("$0.00");
/* 6700 */     this.jLabel95.setText("$0.00");
/* 6701 */     this.jLabel96.setText("0 VALES");
/* 6702 */     this.jTextField11.setText("");
/* 6703 */     this.jTextField12.setText("");
/* 6704 */     this.jTextField16.setText("");
/* 6705 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 6706 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 6707 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 6708 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 6709 */     this.jFormattedTextField8.setValue(Integer.valueOf(0));
/* 6710 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 6711 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 6712 */     this.jFormattedTextField11.setValue(Integer.valueOf(0));
/* 6713 */     this.jFormattedTextField12.setValue(Integer.valueOf(0));
/* 6714 */     this.jFormattedTextField13.setValue(Integer.valueOf(0));
/* 6715 */     this.jFormattedTextField14.setValue(Integer.valueOf(0));
/* 6716 */     this.jTextField13.setText("");
/* 6717 */     this.jTextField14.setText("");
/* 6718 */     this.jTextField15.setText("");
/*      */     
/* 6720 */     this.jTextField17.setText("");
/* 6721 */     this.jTextField18.setText("");
/* 6722 */     this.jTextField22.setText("");
/*      */     
/* 6724 */     this.SUBTOTAL = 0.0D;
/* 6725 */     this.DIFGAST = 0.0D;
/* 6726 */     this.PREMIOS = 0.0D;
/*      */     
/* 6728 */     this.DIESELCONTRA = 0.0D;
/*      */     
/* 6730 */     this.MODELOPREMIOS = new DefaultTableModel();
/* 6731 */     this.MODELOGASTOS = new DefaultTableModel();
/*      */     
/* 6733 */     this.MODELODIESEL = new DefaultTableModel();
/*      */     
/* 6735 */     this.MODELOPREMIOS.addColumn("Concepto");
/* 6736 */     this.MODELOPREMIOS.addColumn("Cantidad");
/* 6737 */     this.jTable6.setModel(this.MODELOPREMIOS);
/* 6738 */     this.MODELOGASTOS.addColumn("Concepto");
/* 6739 */     this.MODELOGASTOS.addColumn("Folio");
/* 6740 */     this.MODELOGASTOS.addColumn("Fecha");
/* 6741 */     this.MODELOGASTOS.addColumn("Cantidad");
/* 6742 */     this.jTable7.setModel(this.MODELOGASTOS);
/* 6743 */     this.VALORPREMIOS = new double[800];
/* 6744 */     this.VALORGASTOS = new double[800];
/* 6745 */     this.VALORDIESEL = new double[800];
/*      */     
/* 6747 */     this.AUTOPISTAS = new double[800];
/* 6748 */     this.PROPINAS = new double[800];
/* 6749 */     this.LLANTAS = new double[800];
/*      */     
/* 6751 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Expedido por", "Litros", "Precio", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6757 */     this.jTable8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Completo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6763 */     this.jTable7.getColumnModel().getColumn(1).setMinWidth(75);
/* 6764 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(75);
/* 6765 */     this.jTable7.getColumnModel().getColumn(2).setMinWidth(80);
/* 6766 */     this.jTable7.getColumnModel().getColumn(2).setMaxWidth(80);
/* 6767 */     this.jTable7.getColumnModel().getColumn(3).setMinWidth(60);
/* 6768 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(60);
/*      */     
/* 6770 */     this.DIFGASTORIGINAL = 0.0D;
/* 6771 */     this.GASTOSASIG = 0.0D;
/* 6772 */     this.SUBTOTAL = 0.0D;
/* 6773 */     this.DIFGAST = 0.0D;
/* 6774 */     this.NETO = 0.0D;
/* 6775 */     this.SALDOTD = 0.0D;
/* 6776 */     this.SOLOGASTOS = 0.0D;
/* 6777 */     this.GASTOSTOTAL = 0.0D;
/* 6778 */     this.VIAJESFORANEOS = 0.0D;
/* 6779 */     this.DIESELCONSUMIDO = 0.0D;
/* 6780 */     this.DIESELCOMPROBADO = 0.0D;
/* 6781 */     this.TONS = 0.0D;
/* 6782 */     this.LITROS = 0.0D;
/* 6783 */     this.KM = 0.0D;
/* 6784 */     this.KMLT = 0.0D;
/*      */     
/* 6786 */     this.MODELOVIAJES = new DefaultTableModel();
/* 6787 */     this.MODELOVIAJES.addColumn("H.R.S.P.");
/*      */     
/* 6789 */     this.MODELOVIAJES.addColumn("Tipo Carga");
/* 6790 */     this.MODELOVIAJES.addColumn("Origen");
/* 6791 */     this.MODELOVIAJES.addColumn("Destino");
/* 6792 */     this.MODELOVIAJES.addColumn("Kms.");
/* 6793 */     this.MODELOVIAJES.addColumn("Km/Lt");
/* 6794 */     this.MODELOVIAJES.addColumn("Litros");
/* 6795 */     this.MODELOVIAJES.addColumn("Peso");
/* 6796 */     this.MODELOVIAJES.addColumn("Tipo");
/* 6797 */     this.MODELOVIAJES.addColumn("Sub-Total");
/* 6798 */     this.jTable4.setModel(this.MODELOVIAJES);
/*      */     
/* 6800 */     this.jTable4.getColumnModel().getColumn(0).setMinWidth(65);
/* 6801 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(65);
/* 6802 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(65);
/* 6803 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(65);
/* 6804 */     this.jTable4.getColumnModel().getColumn(2).setMinWidth(65);
/* 6805 */     this.jTable4.getColumnModel().getColumn(2).setMaxWidth(65);
/* 6806 */     this.jTable4.getColumnModel().getColumn(5).setMinWidth(50);
/* 6807 */     this.jTable4.getColumnModel().getColumn(5).setMaxWidth(50);
/* 6808 */     this.jTable4.getColumnModel().getColumn(6).setMinWidth(55);
/* 6809 */     this.jTable4.getColumnModel().getColumn(6).setMaxWidth(55);
/*      */     
/* 6811 */     this.jTable4.setEditingRow(0);
/* 6812 */     this.jTable4.setEditingRow(1);
/*      */     
/* 6814 */     this.jComboBox3.removeAllItems();
/*      */   }
/*      */   
/*      */   public void activar() {
/* 6818 */     this.encontrado = this.con.consultar("tipoConcep", "tarjeta_contenido", "where (tipoConcep=2 || tipoconcep =3) and tarjeta = " + this.CLAVEOP);
/* 6819 */     if (this.encontrado) {
/* 6820 */       this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where (tipoConcep=2 || tipoconcep =3) and tarjeta = " + this.CLAVEOP);
/* 6821 */       this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 6822 */       this.SALDOTD = Double.parseDouble(this.con.Campo);
/*      */     } else {
/* 6824 */       this.SALDOTD = 0.0D;
/* 6825 */       this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */     } 
/* 6827 */     this.encontrado = this.con.consultar("tipoConcep", "tarjeta_contenido", "where tipoConcep=1 and tarjeta = " + this.CLAVEOP);
/* 6828 */     if (this.encontrado) {
/* 6829 */       this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tipoConcep=1 and tarjeta = " + this.CLAVEOP);
/* 6830 */       this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 6831 */       this.SUBTOTAL -= Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 6832 */       this.DIFGAST -= Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 6833 */       this.GASTOSASIG = -Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 6834 */       this.DIFGASTORIGINAL = this.GASTOSASIG;
/* 6835 */       actualizarSaldos();
/*      */     } else {
/* 6837 */       actualizarSaldos();
/* 6838 */       this.jLabel26.setText("$0.00");
/*      */     } 
/* 6840 */     this.jButton7.setEnabled(true);
/* 6841 */     this.jButton9.setEnabled(true);
/* 6842 */     this.jButton10.setEnabled(true);
/* 6843 */     this.jButton11.setEnabled(true);
/* 6844 */     this.jButton12.setEnabled(true);
/* 6845 */     this.jButton14.setEnabled(true);
/* 6846 */     this.jButton16.setEnabled(true);
/* 6847 */     this.jButton43.setEnabled(true);
/* 6848 */     this.jFormattedTextField1.setEnabled(true);
/* 6849 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */     
/* 6851 */     this.jFormattedTextField15.setValue(Double.valueOf(this.RENDIMIENTOS[0]));
/* 6852 */     this.jFormattedTextField16.setValue(Double.valueOf(this.RENDIMIENTOS[1]));
/* 6853 */     this.jFormattedTextField17.setValue(Double.valueOf(this.RENDIMIENTOS[2]));
/* 6854 */     this.jFormattedTextField18.setValue(Double.valueOf(this.RENDIMIENTOS[3]));
/* 6855 */     this.jFormattedTextField19.setValue(Double.valueOf(this.RENDIMIENTOS[4]));
/* 6856 */     this.jFormattedTextField20.setValue(Double.valueOf(this.RENDIMIENTOS[5]));
/* 6857 */     this.jFormattedTextField21.setValue(Double.valueOf(this.RENDIMIENTOS[6]));
/* 6858 */     this.jFormattedTextField22.setValue(Double.valueOf(this.RENDIMIENTOS[7]));
/* 6859 */     this.jFormattedTextField23.setValue(Double.valueOf(this.RENDIMIENTOS[8]));
/* 6860 */     this.jFormattedTextField24.setValue(Double.valueOf(this.RENDIMIENTOS[9]));
/* 6861 */     this.jFormattedTextField25.setValue(Double.valueOf(this.RENDIMIENTOS[10]));
/* 6862 */     this.jFormattedTextField26.setValue(Double.valueOf(this.RENDIMIENTOS[11]));
/* 6863 */     this.jFormattedTextField27.setValue(Double.valueOf(this.RENDIMIENTOS[12]));
/* 6864 */     this.jFormattedTextField28.setValue(Double.valueOf(this.RENDIMIENTOS[13]));
/* 6865 */     this.jFormattedTextField29.setValue(Double.valueOf(this.RENDIMIENTOS[14]));
/*      */   }
/*      */   
/*      */   public void actualizarSaldos() {
/* 6869 */     this.IMPUESTOS = this.VIAJESFORANEOS * 0.07D;
/* 6870 */     this.jFormattedTextField2.setValue(Double.valueOf(this.IMPUESTOS));
/* 6871 */     this.jLabel45.setText("-" + this.jFormattedTextField2.getText());
/*      */     
/* 6873 */     this.jFormattedTextField2.setValue(Double.valueOf(this.VIAJESFORANEOS));
/* 6874 */     this.jLabel33.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6876 */     this.jFormattedTextField2.setValue(Double.valueOf(this.SOLOGASTOS));
/* 6877 */     this.jLabel22.setText(this.jFormattedTextField2.getText());
/* 6878 */     this.jLabel160.setText(this.jLabel22.getText());
/*      */     
/* 6880 */     this.jFormattedTextField2.setValue(Double.valueOf(this.GASTOSTOTAL));
/* 6881 */     this.jLabel24.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6883 */     this.jFormattedTextField2.setValue(Double.valueOf(this.SUBTOTAL));
/* 6884 */     this.jLabel43.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6886 */     this.jFormattedTextField2.setValue(Double.valueOf(this.GASTOSASIG));
/* 6887 */     this.jLabel26.setText(this.jFormattedTextField2.getText());
/*      */     
/* 6889 */     this.jFormattedTextField2.setValue(Double.valueOf(this.DIFGAST));
/* 6890 */     this.jLabel49.setText(this.jFormattedTextField2.getText());
/* 6891 */     this.jLabel39.setText(this.jLabel49.getText());
/*      */     
/* 6893 */     this.jFormattedTextField2.setValue(Double.valueOf(this.VIAJESFORANEOS));
/* 6894 */     String sumas = this.jFormattedTextField2.getText();
/* 6895 */     this.jLabel14.setText(sumas);
/* 6896 */     actualizaSub();
/*      */   }
/*      */   
/*      */   public void cargarMov() {
/* 6900 */     int indice = this.jTable5.getSelectedRow();
/* 6901 */     this.jTextField5.setText(String.valueOf(this.jTable5.getValueAt(indice, 0)));
/* 6902 */     this.jDialog4.setTitle("Movimiento - " + String.valueOf(this.jTable5.getValueAt(indice, 0)));
/* 6903 */     String fecha = String.valueOf(this.jTable5.getValueAt(indice, 1));
/* 6904 */     String año = fecha.substring(0, 4);
/* 6905 */     String mes = fecha.substring(5, 7);
/* 6906 */     String dia = fecha.substring(8, 10);
/* 6907 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 6908 */     String cargo = String.valueOf(this.jTable5.getValueAt(indice, 6));
/* 6909 */     this.jTextField7.setText(strFecha);
/* 6910 */     if (!cargo.equals("")) {
/* 6911 */       cargo = "ABONO";
/* 6912 */       this.jLabel55.setText(String.valueOf(this.jTable5.getValueAt(indice, 2)));
/* 6913 */       this.jLabel76.setText(String.valueOf(this.jTable5.getValueAt(indice, 6)));
/*      */     } else {
/* 6915 */       cargo = "CARGO";
/* 6916 */       this.jLabel55.setText(String.valueOf(this.jTable5.getValueAt(indice, 2)));
/* 6917 */       this.jLabel76.setText(String.valueOf(this.jTable5.getValueAt(indice, 5)));
/*      */     } 
/* 6919 */     this.jLabel54.setText(cargo);
/* 6920 */     this.jLabel74.setText(String.valueOf(this.jTable5.getValueAt(indice, 3)));
/* 6921 */     String estatus = String.valueOf(this.jTable5.getValueAt(indice, 8));
/* 6922 */     this.con.consultar("observaciones", "tarjeta_contenido", "where mov = " + String.valueOf(this.jTable5.getValueAt(indice, 0)));
/* 6923 */     this.jTextArea1.setText(this.con.Campo);
/* 6924 */     if (estatus.equals("<Cancelado>")) {
/* 6925 */       this.jLabel53.setVisible(true);
/*      */     } else {
/* 6927 */       this.jLabel53.setVisible(false);
/*      */     } 
/* 6929 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 6933 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 6934 */           .buscarDatos(9, "mov,fecha,concepto,referencia,repuesto,importeLetra,abonoLetra,saldoFinalLetra,estatus", "tarjeta_contenido", "where tarjeta=" + this.CLAVEOP + " order by mov desc"), (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Rep", "Importe", "Abono", "Saldo", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6939 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6944 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6947 */     if (this.jTable5.getRowCount() > 0) {
/* 6948 */       this.jTextField4.setText(String.valueOf(this.jTable5.getValueAt(0, 7)));
/*      */     } else {
/* 6950 */       this.jTextField4.setText("$0.00");
/*      */     } 
/* 6952 */     this.celda.pasarInd(this.con.revisarCol(this.jTable5, "<Por Pagar>", 0, 8, 0));
/* 6953 */     this.celda.pasarInd2(this.con.revisarCol(this.jTable5, "<Cancelado>", 0, 8, 0));
/*      */     
/* 6955 */     String[] arre = this.con.regresaColIndex("mov", "tarjeta_contenido", "where estatus <>'<Cancelado>' && estatus<>'<Por Pagar>' && estatus<>'<Aplicado>'and estatus not like '<pagado%' AND TARJETA=" + this.CLAVEOP);
/* 6956 */     this.celda.pasarInd3(arre);
/*      */     
/* 6958 */     this.jTable5.setShowVerticalLines(false);
/* 6959 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 6960 */     this.jTable5.setSelectionMode(0);
/*      */     
/* 6962 */     this.jTable5.setAutoCreateRowSorter(true);
/*      */     
/* 6964 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 6965 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(50);
/* 6966 */     this.jTable5.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 6967 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(110);
/* 6968 */     this.jTable5.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 6969 */     this.jTable5.getColumnModel().getColumn(4).setMaxWidth(30);
/* 6970 */     this.jTable5.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 6971 */     this.jTable5.getColumnModel().getColumn(5).setMaxWidth(70);
/* 6972 */     this.jTable5.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 6973 */     this.jTable5.getColumnModel().getColumn(6).setMaxWidth(70);
/* 6974 */     this.jTable5.getColumnModel().getColumn(7).setPreferredWidth(70);
/* 6975 */     this.jTable5.getColumnModel().getColumn(7).setMaxWidth(70);
/* 6976 */     this.jTable5.getColumnModel().getColumn(8).setPreferredWidth(130);
/* 6977 */     this.jTable5.getColumnModel().getColumn(8).setMaxWidth(130);
/*      */     
/* 6979 */     this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 6980 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 6981 */     this.jTable5.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 6982 */     this.jTable5.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 6983 */     this.jTable5.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 6984 */     this.jTable5.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 6985 */     this.jTable5.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 6986 */     this.jTable5.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 6987 */     this.jTable5.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void cargarOperador() {
/* 6991 */     desactivar();
/* 6992 */     this.jRadioButton1.setEnabled(true);
/* 6993 */     this.jRadioButton1.setSelected(true);
/* 6994 */     boolean operador = false;
/* 6995 */     int ind = this.jTable3.getSelectedRow();
/* 6996 */     String clave = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 6997 */     this.CLAVEOP = clave;
/* 6998 */     this.jTextField8.setText(String.valueOf(this.jTable3.getValueAt(ind, 1)));
/* 6999 */     String[] reg = this.con.regresaReg("tipo,num_ope", "tarjeta_deudor", "where tarjeta = " + this.CLAVEOP, 2);
/* 7000 */     if (reg[0].equals("OPERADOR")) {
/* 7001 */       operador = true;
/* 7002 */       this.OPERADOR = reg[1];
/* 7003 */       this.CLAVEORIGINAL = reg[1];
/* 7004 */       this.encontrado = this.con.consultar("num_tracto", "llamadas_historicas,tarjeta_deudor", "where llamadas_historicas.num_ope = tarjeta_deudor.num_ope and tarjeta = " + this.CLAVEOP);
/* 7005 */       String[] campos = this.con.regresaReg("num_tracto,remolque.num_rem,remolque.tipo", "remolque,llamadas_historicas,tarjeta_deudor", "where llamadas_historicas.num_ope = tarjeta_deudor.num_ope and llamadas_historicas.num_rem = remolque.num_rem and tarjeta = " + this.CLAVEOP + " order by num_llama desc", 3);
/* 7006 */       if (this.encontrado) {
/* 7007 */         this.jTextField2.setText(campos[0]);
/*      */       } else {
/* 7009 */         this.jTextField2.setText("");
/*      */       } 
/* 7011 */       this.jTextField16.setText(campos[2]);
/* 7012 */       cargarViajes();
/*      */     } else {
/* 7014 */       this.jTextField16.setText(reg[0]);
/* 7015 */       this.jTextField2.setText("");
/*      */     } 
/* 7017 */     this.jDialog2.setVisible(false);
/* 7018 */     activar();
/* 7019 */     cargarValeDiesel(operador);
/* 7020 */     actualizaTabla2();
/*      */   }
/*      */   
/*      */   public void cargarViajes() {
/* 7024 */     this.jTable9.setModel(new DefaultTableModel((Object[][])this.con
/* 7025 */           .buscarDatos(17, "vales.num_vale,vales.num_guia,plataforma,nombrecorto,peso,estadias,mov,mov,mov,viaje,tons,tipoPago,local,pozo,emp_destinataria.km,guias.servicio, guias.fecha", "guias,llamadas_historicas,plataformas,emp_destinataria,vales", "where f_expedicion1>'2012-06-01' and llamadas_historicas.num_guia = guias.num_guia and plataformas.num_plata = llamadas_historicas.num_plata and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and vales.num_guia = guias.num_guia and vales.folio_liq1 = '' and folio_liq2='' and vales.clave1 = " + this.CLAVEORIGINAL + " and clave2 = " + this.CLAVEORIGINAL + " order by vales.num_guia"), (Object[])new String[] { "H.R.S.P.", "GUÍA", "Origen", "Destino", "Peso", "Estadías", "Mov", "Ope Carga", "Ope Tira", "viaje", "tons", "Tipo Pago", "local", "pozo", "km", "Serv", "Fecha Viaje" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7031 */     this.jTable10.setModel(new DefaultTableModel((Object[][])this.con
/* 7032 */           .buscarDatos(15, "vales.num_vale,vales.num_guia,plataforma,nombrecorto,peso,estadias,mov,mov,mov,viaje,tons,tipoPago,local,emp_destinataria.km,guias.fecha", "guias,llamadas_historicas,plataformas,emp_destinataria,vales", "where f_expedicion1>'2012-06-01' and llamadas_historicas.num_guia = guias.num_guia and plataformas.num_plata = llamadas_historicas.num_plata and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and vales.num_guia = guias.num_guia and vales.folio_liq1 = '' and vales.clave1 = " + this.CLAVEORIGINAL + " and vales.clave2<>" + this.CLAVEORIGINAL), (Object[])new String[] { "H.R.S.P.", "Guía", "Origen", "Destino", "Peso", "Estadías", "Mov", "Carga", "Tira", "Viaje", "Tons", "Tipo Pago", "local", "km", "FechaViaje" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7038 */     this.jTable11.setModel(new DefaultTableModel((Object[][])this.con
/* 7039 */           .buscarDatos(15, "vales.num_vale,vales.num_guia,plataforma,nombrecorto,peso,estadias,mov,mov,mov,viaje,tons,tipopago,local,emp_destinataria.km, guias.fecha", "guias,llamadas_historicas,plataformas,emp_destinataria,vales", "where f_expedicion1>'2012-06-01' and llamadas_historicas.num_guia = guias.num_guia and plataformas.num_plata = llamadas_historicas.num_plata and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and vales.num_guia = guias.num_guia and  vales.folio_liq2 = '' and vales.clave1<>" + this.CLAVEORIGINAL + " and vales.clave2=" + this.CLAVEORIGINAL), (Object[])new String[] { "H.R.S.P.", "Guía", "Origen", "Destino", "Peso", "Estadías", "Mov", "Carga", "Tira", "Viaje", "Tons", "Tipo Pago", "local", "km", "Fecha Viaje" }));
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/* 7046 */     for (i = 0; i < this.jTable9.getRowCount(); i++)
/*      */     {
/* 7048 */       this.GUIASFECHA.put(this.jTable9.getValueAt(i, 16).toString(), this.jTable9.getValueAt(i, 1).toString());
/*      */     }
/*      */     
/* 7051 */     for (i = 0; i < this.jTable10.getRowCount(); i++)
/*      */     {
/* 7053 */       this.GUIASFECHA.put(this.jTable10.getValueAt(i, 14).toString(), this.jTable10.getValueAt(i, 1).toString());
/*      */     }
/*      */     
/* 7056 */     for (i = 0; i < this.jTable11.getRowCount(); i++)
/*      */     {
/* 7058 */       this.GUIASFECHA.put(this.jTable11.getValueAt(i, 14).toString(), this.jTable11.getValueAt(i, 1).toString());
/*      */     }
/*      */     
/* 7061 */     String FechaViaje = "";
/* 7062 */     this.GUIASFECHA.forEach((k, s) -> System.out.println(k + " " + k));
/* 7063 */     if (this.GUIASFECHA.size() > 0) {
/* 7064 */       Iterator<String> iterator = this.GUIASFECHA.keySet().iterator(); if (iterator.hasNext()) { String v = iterator.next();
/* 7065 */         FechaViaje = v; }
/*      */ 
/*      */       
/* 7068 */       String año = FechaViaje.substring(0, 4);
/* 7069 */       String mes = FechaViaje.substring(5, 7);
/* 7070 */       String dia = FechaViaje.substring(8, 10);
/* 7071 */       this.jTextField63.setText(dia + "/" + dia + "/" + mes);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7078 */     llenarTabla();
/*      */   }
/*      */   
/*      */   public void llenarTabla() {
/* 7082 */     int estadias = 0;
/* 7083 */     int movInter = 0;
/* 7084 */     String tipoTractor = this.jTextField16.getText(); int i;
/* 7085 */     for (i = 0; i < this.jTable9.getRowCount(); i++) {
/* 7086 */       String valor = String.valueOf(this.jTable9.getValueAt(i, 8));
/* 7087 */       String estad = String.valueOf(this.jTable9.getValueAt(i, 5));
/* 7088 */       String mov = String.valueOf(this.jTable9.getValueAt(i, 6));
/*      */       
/* 7090 */       if (!estad.equals("0")) {
/* 7091 */         estadias += Integer.parseInt(estad);
/*      */       }
/* 7093 */       if (!mov.equals("0")) {
/* 7094 */         movInter += Integer.parseInt(mov);
/*      */       }
/* 7096 */       if (valor.equals("MOVIMIENTO INTERNO")) {
/* 7097 */         movInter++;
/* 7098 */       } else if (valor.equals("MOVIMIENTO EN FALSO")) {
/* 7099 */         Object[] reg = { "Movimiento en Falso-(" + String.valueOf(this.jTable9.getValueAt(i, 2)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$200.00" };
/* 7100 */         this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 200.0D;
/* 7101 */         this.MODELOGASTOS.addRow(reg);
/* 7102 */         this.SUBTOTAL += 200.0D;
/* 7103 */         this.SOLOGASTOS += 200.0D;
/* 7104 */         this.GASTOSTOTAL += 200.0D;
/* 7105 */         this.DIFGAST += 200.0D;
/*      */       } else {
/* 7107 */         String tipoPago = String.valueOf(this.jTable9.getValueAt(i, 11));
/* 7108 */         String tipo = "";
/* 7109 */         String subLetra = "";
/* 7110 */         String sumas = "";
/* 7111 */         String pozo = String.valueOf(this.jTable9.getValueAt(i, 13));
/* 7112 */         String serv = String.valueOf(this.jTable9.getValueAt(i, 15));
/* 7113 */         if (!pozo.equals("SI") && !serv.equals("ESTADIA") && !serv.equals("CARGADA LATERAL") && !serv.equals("MANIOBRA")) {
/* 7114 */           if (tipoPago.equals("1")) {
/* 7115 */             tipo = "Viaje";
/* 7116 */             String pago = String.valueOf(this.jTable9.getValueAt(i, 9));
/*      */             
/* 7118 */             this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(pago)));
/* 7119 */             subLetra = this.jFormattedTextField2.getText();
/* 7120 */             this.VIAJESFORANEOS += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 7121 */             this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/*      */             
/* 7123 */             String local = String.valueOf(this.jTable9.getValueAt(i, 12));
/* 7124 */             if (local.equals("NO")) {
/* 7125 */               Object[] arrayOfObject = { "Cargada en Patio-(" + String.valueOf(this.jTable9.getValueAt(i, 2)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$350.00" };
/* 7126 */               this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 350.0D;
/* 7127 */               this.MODELOGASTOS.addRow(arrayOfObject);
/* 7128 */               this.SUBTOTAL += 350.0D;
/* 7129 */               this.SOLOGASTOS += 350.0D;
/* 7130 */               this.GASTOSTOTAL += 350.0D;
/* 7131 */               this.DIFGAST += 350.0D;
/*      */             } 
/*      */           } else {
/* 7134 */             tipo = "Tonelada";
/* 7135 */             String pago = String.valueOf(this.jTable9.getValueAt(i, 10));
/* 7136 */             String str1 = String.valueOf(this.jTable9.getValueAt(i, 4));
/* 7137 */             double tonelada = Double.parseDouble(str1);
/* 7138 */             if (tipoTractor.equals("GÓNDOLA")) {
/* 7139 */               if (tonelada > 32.0D) {
/* 7140 */                 tonelada = 32.0D;
/* 7141 */               } else if (tonelada < 20.0D) {
/* 7142 */                 tonelada = 20.0D;
/*      */               } 
/*      */             }
/* 7145 */             double tot = Double.parseDouble(pago) * tonelada;
/* 7146 */             this.jFormattedTextField2.setValue(Double.valueOf(tot));
/* 7147 */             subLetra = this.jFormattedTextField2.getText();
/* 7148 */             this.VIAJESFORANEOS += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 7149 */             this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/*      */           } 
/* 7151 */           this.jFormattedTextField2.setValue(Double.valueOf(this.VIAJESFORANEOS));
/* 7152 */           sumas = this.jFormattedTextField2.getText();
/* 7153 */           this.jLabel14.setText(sumas);
/* 7154 */           double km = Double.parseDouble(String.valueOf(this.jTable9.getValueAt(i, 14)));
/* 7155 */           double tons = Double.parseDouble(String.valueOf(this.jTable9.getValueAt(i, 4)));
/* 7156 */           double rendi = sacarRendi(tons);
/* 7157 */           double litros = 0.0D;
/* 7158 */           if (rendi == 0.0D) {
/* 7159 */             litros = 0.0D;
/*      */           } else {
/* 7161 */             litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */           } 
/* 7163 */           this.KM += km;
/* 7164 */           this.LITROS += litros;
/* 7165 */           this.KMLT += rendi;
/* 7166 */           this.TONS += tons;
/*      */           
/* 7168 */           Object[] reg = { this.jTable9.getValueAt(i, 0), "Carg y Tira", this.jTable9.getValueAt(i, 2), this.jTable9.getValueAt(i, 3), Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Double.valueOf(tons), tipo, subLetra };
/* 7169 */           this.MODELOVIAJES.addRow(reg);
/* 7170 */           rendi = sacarRendi(0.0D);
/* 7171 */           litros = 0.0D;
/* 7172 */           if (rendi == 0.0D) {
/* 7173 */             litros = 0.0D;
/*      */           } else {
/* 7175 */             litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */           } 
/* 7177 */           this.KM += km;
/* 7178 */           this.LITROS += litros;
/* 7179 */           this.KMLT += rendi;
/* 7180 */           reg = new Object[] { this.jTable9.getValueAt(i, 0), "Regreso", this.jTable9.getValueAt(i, 3), this.base, Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Integer.valueOf(0), tipo, "$0.00" };
/* 7181 */           this.MODELOVIAJES.addRow(reg);
/*      */         } else {
/* 7183 */           String val = String.valueOf(this.jTable9.getValueAt(i, 3));
/*      */           
/* 7185 */           if (val.equals("DESTINO DE RETRO")) {
/* 7186 */             Object[] reg = { "Viaje Local-(" + String.valueOf(this.jTable9.getValueAt(i, 3)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$350.00" };
/* 7187 */             this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 350.0D;
/* 7188 */             this.MODELOGASTOS.addRow(reg);
/* 7189 */             this.SUBTOTAL += 350.0D;
/* 7190 */             this.GASTOSTOTAL += 350.0D;
/* 7191 */             this.SOLOGASTOS += 350.0D;
/* 7192 */             this.DIFGAST += 350.0D;
/* 7193 */           } else if (serv.equals("CARGADA LATERAL")) {
/* 7194 */             Object[] reg = { "CARGADA LATERAL-(" + String.valueOf(this.jTable9.getValueAt(i, 3)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$475.00" };
/* 7195 */             this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 475.0D;
/* 7196 */             this.MODELOGASTOS.addRow(reg);
/* 7197 */             this.SUBTOTAL += 475.0D;
/* 7198 */             this.SOLOGASTOS += 475.0D;
/* 7199 */             this.GASTOSTOTAL += 475.0D;
/* 7200 */             this.DIFGAST += 475.0D;
/* 7201 */           } else if (serv.equals("ESTADIA")) {
/* 7202 */             Object[] reg = { "ESTADÍA-(" + String.valueOf(this.jTable9.getValueAt(i, 3)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$200.00" };
/* 7203 */             this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 200.0D;
/* 7204 */             this.MODELOGASTOS.addRow(reg);
/* 7205 */             this.SUBTOTAL += 200.0D;
/* 7206 */             this.SOLOGASTOS += 200.0D;
/* 7207 */             this.GASTOSTOTAL += 200.0D;
/* 7208 */             this.DIFGAST += 200.0D;
/* 7209 */           } else if (serv.equals("MANIOBRA")) {
/* 7210 */             Object[] reg = { "MANIOBRA-(" + String.valueOf(this.jTable9.getValueAt(i, 3)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$100.00" };
/* 7211 */             this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 100.0D;
/* 7212 */             this.MODELOGASTOS.addRow(reg);
/* 7213 */             this.SUBTOTAL += 100.0D;
/* 7214 */             this.SOLOGASTOS += 100.0D;
/* 7215 */             this.GASTOSTOTAL += 100.0D;
/* 7216 */             this.DIFGAST += 100.0D;
/*      */           } else {
/* 7218 */             Object[] reg = { "Viaje Local-(" + String.valueOf(this.jTable9.getValueAt(i, 3)) + ")", this.jTable9.getValueAt(i, 0), this.cadFechaActual, "$500.00" };
/* 7219 */             this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 500.0D;
/* 7220 */             this.MODELOGASTOS.addRow(reg);
/* 7221 */             this.SUBTOTAL += 500.0D;
/* 7222 */             this.SOLOGASTOS += 500.0D;
/* 7223 */             this.GASTOSTOTAL += 500.0D;
/* 7224 */             this.DIFGAST += 500.0D;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 7230 */     for (i = 0; i < this.jTable10.getRowCount(); i++) {
/* 7231 */       String valor = String.valueOf(this.jTable10.getValueAt(i, 8));
/* 7232 */       String estad = String.valueOf(this.jTable10.getValueAt(i, 5));
/* 7233 */       String mov = String.valueOf(this.jTable10.getValueAt(i, 6));
/* 7234 */       if (!estad.equals("0")) {
/* 7235 */         estadias += Integer.parseInt(estad);
/*      */       }
/* 7237 */       if (!mov.equals("0")) {
/* 7238 */         movInter += Integer.parseInt(mov);
/*      */       }
/* 7240 */       if (tipoTractor.equals("GÓNDOLA")) {
/* 7241 */         Object[] reg = { "Cargada en Patio-(" + String.valueOf(this.jTable10.getValueAt(i, 2)) + ")", this.jTable10.getValueAt(i, 0), this.cadFechaActual, "$475.00" };
/* 7242 */         this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 475.0D;
/* 7243 */         this.MODELOGASTOS.addRow(reg);
/* 7244 */         this.SUBTOTAL += 475.0D;
/* 7245 */         this.SOLOGASTOS += 475.0D;
/* 7246 */         this.GASTOSTOTAL += 475.0D;
/* 7247 */         this.DIFGAST += 475.0D;
/*      */       } else {
/* 7249 */         Object[] reg = { "Cargada en Patio-(" + String.valueOf(this.jTable10.getValueAt(i, 2)) + ")", this.jTable10.getValueAt(i, 0), this.cadFechaActual, "$350.00" };
/* 7250 */         this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 350.0D;
/* 7251 */         this.MODELOGASTOS.addRow(reg);
/* 7252 */         this.SUBTOTAL += 350.0D;
/* 7253 */         this.SOLOGASTOS += 350.0D;
/* 7254 */         this.GASTOSTOTAL += 350.0D;
/* 7255 */         this.DIFGAST += 350.0D;
/*      */       } 
/*      */     } 
/*      */     
/* 7259 */     for (i = 0; i < this.jTable11.getRowCount(); i++) {
/* 7260 */       boolean soloTir = false;
/* 7261 */       String valor = String.valueOf(this.jTable11.getValueAt(i, 8));
/* 7262 */       String estad = String.valueOf(this.jTable11.getValueAt(i, 5));
/* 7263 */       String mov = String.valueOf(this.jTable11.getValueAt(i, 6));
/* 7264 */       if (!estad.equals("0")) {
/* 7265 */         estadias += Integer.parseInt(estad);
/*      */       }
/* 7267 */       if (!mov.equals("0")) {
/* 7268 */         movInter += Integer.parseInt(mov);
/*      */       }
/* 7270 */       String local = String.valueOf(this.jTable11.getValueAt(i, 12));
/* 7271 */       String tipoPago = String.valueOf(this.jTable11.getValueAt(i, 11));
/* 7272 */       String tipo = "";
/* 7273 */       String subLetra = "";
/* 7274 */       String sumas = "";
/* 7275 */       if (tipoPago.equals("1")) {
/* 7276 */         tipo = "Viaje";
/* 7277 */         if (local.equals("SI")) {
/* 7278 */           soloTir = true;
/* 7279 */           Object[] reg = { "Tirada-( " + String.valueOf(this.jTable11.getValueAt(i, 3)) + ")", this.jTable11.getValueAt(i, 0), this.cadFechaActual, "$200.00" };
/* 7280 */           this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = 200.0D;
/* 7281 */           this.MODELOGASTOS.addRow(reg);
/* 7282 */           this.SUBTOTAL += 200.0D;
/* 7283 */           this.SOLOGASTOS += 200.0D;
/* 7284 */           this.GASTOSTOTAL += 200.0D;
/* 7285 */           this.DIFGAST += 200.0D;
/*      */         } else {
/* 7287 */           String pago = String.valueOf(this.jTable11.getValueAt(i, 9));
/* 7288 */           this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(pago)));
/* 7289 */           subLetra = this.jFormattedTextField2.getText();
/* 7290 */           this.VIAJESFORANEOS += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 7291 */           this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/*      */         } 
/*      */       } else {
/* 7294 */         tipo = "Tonelada";
/* 7295 */         String pago = String.valueOf(this.jTable11.getValueAt(i, 10));
/* 7296 */         String tons = String.valueOf(this.jTable11.getValueAt(i, 4));
/* 7297 */         double tonelada = Double.parseDouble(tons);
/* 7298 */         if (tipoTractor.equals("GÓNDOLA")) {
/* 7299 */           if (tonelada > 32.0D) {
/* 7300 */             tonelada = 32.0D;
/* 7301 */           } else if (tonelada < 20.0D) {
/* 7302 */             tonelada = 20.0D;
/*      */           } 
/*      */         }
/* 7305 */         double tot = Double.parseDouble(pago) * tonelada;
/* 7306 */         this.jFormattedTextField2.setValue(Double.valueOf(tot));
/* 7307 */         subLetra = this.jFormattedTextField2.getText();
/* 7308 */         this.VIAJESFORANEOS += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 7309 */         this.SUBTOTAL += Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/*      */       } 
/* 7311 */       if (!soloTir) {
/* 7312 */         this.jFormattedTextField2.setValue(Double.valueOf(this.VIAJESFORANEOS));
/* 7313 */         sumas = this.jFormattedTextField2.getText();
/* 7314 */         this.jLabel14.setText(sumas);
/* 7315 */         double km = Double.parseDouble(String.valueOf(this.jTable11.getValueAt(i, 13)));
/* 7316 */         double tons = Double.parseDouble(String.valueOf(this.jTable11.getValueAt(i, 4)));
/* 7317 */         double rendi = sacarRendi(tons);
/* 7318 */         double litros = 0.0D;
/* 7319 */         if (rendi == 0.0D) {
/* 7320 */           litros = 0.0D;
/*      */         } else {
/* 7322 */           litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */         } 
/* 7324 */         this.KM += km;
/* 7325 */         this.LITROS += litros;
/* 7326 */         this.KMLT += rendi;
/* 7327 */         this.TONS += tons;
/* 7328 */         Object[] reg = { this.jTable11.getValueAt(i, 0), "Tirada", this.jTable11.getValueAt(i, 2), this.jTable11.getValueAt(i, 3), Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Double.valueOf(tons), tipo, subLetra };
/* 7329 */         this.MODELOVIAJES.addRow(reg);
/*      */         
/* 7331 */         rendi = sacarRendi(0.0D);
/* 7332 */         litros = 0.0D;
/* 7333 */         if (rendi == 0.0D) {
/* 7334 */           litros = 0.0D;
/*      */         } else {
/* 7336 */           litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */         } 
/* 7338 */         this.KM += km;
/* 7339 */         this.LITROS += litros;
/* 7340 */         this.KMLT += rendi;
/* 7341 */         reg = new Object[] { this.jTable11.getValueAt(i, 0), "Regreso", this.jTable11.getValueAt(i, 3), this.base, Double.valueOf(km), Double.valueOf(rendi), Double.valueOf(litros), Integer.valueOf(0), tipo, "$0.00" };
/* 7342 */         this.MODELOVIAJES.addRow(reg);
/*      */       } 
/*      */     } 
/* 7345 */     if (movInter > 0) {
/* 7346 */       double result = (movInter * 100);
/* 7347 */       this.jFormattedTextField2.setValue(Double.valueOf(result));
/* 7348 */       Object[] reg = { "" + movInter + " Movimientos Internos", "Mov Inter", this.cadFechaActual, this.jFormattedTextField2.getText() };
/* 7349 */       this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = result;
/* 7350 */       this.MODELOGASTOS.addRow(reg);
/* 7351 */       this.SUBTOTAL += result;
/* 7352 */       this.SOLOGASTOS += result;
/* 7353 */       this.GASTOSTOTAL += result;
/* 7354 */       this.DIFGAST += result;
/*      */     } 
/* 7356 */     if (estadias > 0) {
/* 7357 */       double result = (estadias * 200);
/* 7358 */       this.jFormattedTextField2.setValue(Double.valueOf(result));
/* 7359 */       Object[] reg = { "" + estadias + " Estadías", "Estadías", this.cadFechaActual, this.jFormattedTextField2.getText() };
/* 7360 */       this.VALORGASTOS[this.MODELOGASTOS.getRowCount()] = result;
/* 7361 */       this.MODELOGASTOS.addRow(reg);
/* 7362 */       this.SUBTOTAL += result;
/* 7363 */       this.SOLOGASTOS += result;
/* 7364 */       this.GASTOSTOTAL += result;
/* 7365 */       this.DIFGAST += result;
/*      */     } 
/* 7367 */     actualizarDiesel();
/* 7368 */     actualizaTabla1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void actualizarDiesel() {
/* 7376 */     double precioDiesel = Double.parseDouble(this.DIRECTIVA[1]);
/* 7377 */     this.DIESELCONSUMIDO = this.LITROS * precioDiesel;
/* 7378 */     this.jFormattedTextField2.setValue(Double.valueOf(this.DIESELCONSUMIDO));
/* 7379 */     this.jLabel155.setText(this.jFormattedTextField2.getText());
/* 7380 */     this.jLabel6.setText("" + Math.rint(this.KM * 100.0D) / 100.0D);
/* 7381 */     this.jLabel10.setText("" + Math.rint(this.KMLT * 100.0D) / 100.0D);
/* 7382 */     this.jLabel11.setText("" + Math.rint(this.LITROS * 100.0D) / 100.0D);
/* 7383 */     this.jLabel154.setText("" + Math.rint(this.TONS * 100.0D) / 100.0D);
/* 7384 */     this.DIESELCONTRA = this.DIESELCONSUMIDO - this.DIESELCOMPROBADO;
/* 7385 */     this.jFormattedTextField2.setValue(Double.valueOf(this.DIESELCONTRA));
/* 7386 */     if (this.DIESELCONTRA >= 0.0D) {
/* 7387 */       this.jLabel95.setForeground(Color.BLACK);
/*      */     } else {
/* 7389 */       this.jLabel95.setForeground(Color.RED);
/*      */     } 
/* 7391 */     this.jLabel95.setText(this.jFormattedTextField2.getText());
/* 7392 */     this.jLabel37.setText(this.jFormattedTextField2.getText());
/* 7393 */     this.SUBTOTAL = this.VIAJESFORANEOS + this.PREMIOS + this.DIFGAST + this.DIESELCONTRA;
/* 7394 */     actualizarSaldos();
/*      */   }
/*      */   
/*      */   public void actualizarRendimientos() {
/* 7398 */     this.LITROS = 0.0D;
/* 7399 */     this.KMLT = 0.0D;
/* 7400 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 7401 */       double tons = Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 7)));
/* 7402 */       double km = Double.parseDouble(String.valueOf(this.jTable4.getValueAt(i, 4)));
/* 7403 */       double rendi = sacarRendi(tons);
/* 7404 */       double litros = 0.0D;
/* 7405 */       if (rendi == 0.0D) {
/* 7406 */         litros = 0.0D;
/*      */       } else {
/* 7408 */         litros = Math.rint(km / rendi * 100.0D) / 100.0D;
/*      */       } 
/* 7410 */       this.LITROS += litros;
/* 7411 */       this.KMLT += rendi;
/* 7412 */       this.jTable4.setValueAt(Double.valueOf(rendi), i, 5);
/* 7413 */       this.jTable4.setValueAt(Double.valueOf(litros), i, 6);
/*      */     } 
/* 7415 */     actualizarDiesel();
/*      */   }
/*      */   
/*      */   public double sacarRendi(double tons) {
/* 7419 */     double Tons = tons;
/* 7420 */     double rendi = 0.0D;
/* 7421 */     if (Tons == 0.0D)
/* 7422 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField15.getValue())); }
/* 7423 */     else if (Tons < 5.0D)
/* 7424 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField16.getValue())); }
/* 7425 */     else if (Tons < 10.0D)
/* 7426 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField17.getValue())); }
/* 7427 */     else if (Tons < 15.0D)
/* 7428 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField18.getValue())); }
/* 7429 */     else if (Tons < 20.0D)
/* 7430 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField19.getValue())); }
/* 7431 */     else if (Tons < 25.0D)
/* 7432 */     { rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField20.getValue())); }
/* 7433 */     else { if (Tons < 30.0D)
/* 7434 */         return Double.parseDouble(String.valueOf(this.jFormattedTextField21.getValue())); 
/* 7435 */       if (Tons < 35.0D) {
/* 7436 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField22.getValue()));
/* 7437 */       } else if (Tons < 40.0D) {
/* 7438 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField23.getValue()));
/* 7439 */       } else if (Tons < 45.0D) {
/* 7440 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField24.getValue()));
/* 7441 */       } else if (Tons < 50.0D) {
/* 7442 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField25.getValue()));
/* 7443 */       } else if (Tons < 55.0D) {
/* 7444 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField26.getValue()));
/* 7445 */       } else if (Tons < 60.0D) {
/* 7446 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField27.getValue()));
/* 7447 */       } else if (Tons < 65.0D) {
/* 7448 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField28.getValue()));
/* 7449 */       } else if (Tons < 70.0D) {
/* 7450 */         rendi = Double.parseDouble(String.valueOf(this.jFormattedTextField29.getValue()));
/*      */       }  }
/* 7452 */      return rendi;
/*      */   }
/*      */   
/*      */   public void actualizaTabla1() {
/* 7456 */     String[][] registros = new String[this.MODELOVIAJES.getRowCount()][this.MODELOVIAJES.getColumnCount()];
/* 7457 */     for (int i = 0; i < this.MODELOVIAJES.getRowCount(); i++) {
/* 7458 */       for (int j = 0; j < this.MODELOVIAJES.getColumnCount(); j++) {
/* 7459 */         registros[i][j] = String.valueOf(this.MODELOVIAJES.getValueAt(i, j));
/*      */       }
/*      */     } 
/* 7462 */     this.jTable4.setModel(new DefaultTableModel((Object[][])registros, (Object[])new String[] { "H.R.S.P.", "Tipo Carga", "Origen", "Destino", "Km", "Km/Lt", "Litros", "Peso", "Tipo", "Sub-Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7468 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7473 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 7477 */     this.jTable4.getColumnModel().getColumn(0).setMinWidth(60);
/* 7478 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/* 7479 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(65);
/* 7480 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(65);
/*      */     
/* 7482 */     this.jTable4.getColumnModel().getColumn(4).setMinWidth(40);
/* 7483 */     this.jTable4.getColumnModel().getColumn(4).setMaxWidth(40);
/* 7484 */     this.jTable4.getColumnModel().getColumn(5).setMinWidth(40);
/* 7485 */     this.jTable4.getColumnModel().getColumn(5).setMaxWidth(40);
/* 7486 */     this.jTable4.getColumnModel().getColumn(6).setMinWidth(55);
/* 7487 */     this.jTable4.getColumnModel().getColumn(6).setMaxWidth(55);
/* 7488 */     this.jTable4.getColumnModel().getColumn(7).setMinWidth(40);
/* 7489 */     this.jTable4.getColumnModel().getColumn(7).setMaxWidth(40);
/* 7490 */     this.jTable4.getColumnModel().getColumn(8).setMinWidth(55);
/* 7491 */     this.jTable4.getColumnModel().getColumn(8).setMaxWidth(55);
/* 7492 */     this.jTable4.getColumnModel().getColumn(9).setMinWidth(60);
/* 7493 */     this.jTable4.getColumnModel().getColumn(9).setMaxWidth(60);
/* 7494 */     this.jTable4.setShowVerticalLines(false);
/* 7495 */     this.jTable4.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void actualizaTabla2() {
/* 7499 */     String[][] registros = new String[this.MODELOGASTOS.getRowCount()][this.MODELOGASTOS.getColumnCount()];
/* 7500 */     for (int i = 0; i < this.MODELOGASTOS.getRowCount(); i++) {
/* 7501 */       for (int j = 0; j < this.MODELOGASTOS.getColumnCount(); j++) {
/* 7502 */         registros[i][j] = String.valueOf(this.MODELOGASTOS.getValueAt(i, j));
/*      */       }
/*      */     } 
/* 7505 */     this.jTable7.setModel(new DefaultTableModel((Object[][])registros, (Object[])new String[] { "Concepto", "Folio", "Fecha", "Cantidad" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7511 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7516 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7519 */     this.jTable7.setShowVerticalLines(false);
/* 7520 */     this.jTable7.setSelectionMode(0);
/*      */     
/* 7522 */     this.jTable7.getColumnModel().getColumn(1).setMinWidth(75);
/* 7523 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(75);
/* 7524 */     this.jTable7.getColumnModel().getColumn(2).setMinWidth(80);
/* 7525 */     this.jTable7.getColumnModel().getColumn(2).setMaxWidth(80);
/* 7526 */     this.jTable7.getColumnModel().getColumn(3).setMinWidth(60);
/* 7527 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(60);
/*      */   }
/*      */   
/*      */   public void actualizaTabla3() {
/* 7531 */     String[][] registros = new String[this.MODELOPREMIOS.getRowCount()][this.MODELOPREMIOS.getColumnCount()];
/* 7532 */     for (int i = 0; i < this.MODELOPREMIOS.getRowCount(); i++) {
/* 7533 */       for (int j = 0; j < this.MODELOPREMIOS.getColumnCount(); j++) {
/* 7534 */         registros[i][j] = String.valueOf(this.MODELOPREMIOS.getValueAt(i, j));
/*      */       }
/*      */     } 
/* 7537 */     this.jTable6.setModel(new DefaultTableModel((Object[][])registros, (Object[])new String[] { "Concepto", "Cantidad" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7543 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7548 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7551 */     this.jTable6.setShowVerticalLines(false);
/* 7552 */     this.jTable6.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void actualizaTabla4() {
/* 7556 */     String[][] registros = new String[this.MODELODIESEL.getRowCount()][this.MODELODIESEL.getColumnCount()];
/* 7557 */     for (int i = 0; i < this.MODELODIESEL.getRowCount(); i++) {
/* 7558 */       for (int j = 0; j < this.MODELODIESEL.getColumnCount(); j++) {
/* 7559 */         registros[i][j] = String.valueOf(this.MODELODIESEL.getValueAt(i, j));
/*      */       }
/*      */     } 
/* 7562 */     this.jTable1.setModel(new DefaultTableModel((Object[][])registros, (Object[])new String[] { "Folio", "Expedido Por", "Litros", "Precio", "total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7568 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7573 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7576 */     this.jTable1.setShowVerticalLines(false);
/* 7577 */     this.jTable1.setSelectionMode(0);
/*      */   }
/*      */   
/*      */   public void consultarLiq() {
/* 7581 */     this.jButton4.setEnabled(false);
/* 7582 */     this.jButton2.setEnabled(false);
/* 7583 */     this.jButton5.setEnabled(false);
/* 7584 */     boolean correcto = true;
/* 7585 */     if (this.jDateChooser4.getDate() == null) {
/* 7586 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 7587 */       if (res == 0) {
/* 7588 */         this.jDateChooser4.setDate(this.fechaActual);
/* 7589 */         correcto = true;
/*      */       } else {
/* 7591 */         correcto = false;
/*      */       } 
/* 7593 */     } else if (this.jDateChooser5.getDate() == null) {
/* 7594 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 7595 */       if (res == 0) {
/* 7596 */         this.jDateChooser5.setDate(this.fechaActual);
/* 7597 */         correcto = true;
/*      */       } else {
/* 7599 */         correcto = false;
/*      */       } 
/* 7601 */     } else if (correcto) {
/* 7602 */       Date fecha1 = this.jDateChooser4.getDate();
/* 7603 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 7605 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 7606 */       String cadenaFecha = "";
/* 7607 */       cadenaFecha = formato.format(fecha1);
/* 7608 */       String AÑO = cadenaFecha.substring(0, 4);
/* 7609 */       String MES = cadenaFecha.substring(4, 6);
/* 7610 */       String DIA = cadenaFecha.substring(6, 8);
/* 7611 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 7613 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 7614 */       cadenaFecha = "";
/* 7615 */       cadenaFecha = formato.format(fecha2);
/* 7616 */       AÑO = cadenaFecha.substring(0, 4);
/* 7617 */       MES = cadenaFecha.substring(4, 6);
/* 7618 */       DIA = cadenaFecha.substring(6, 8);
/* 7619 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */       
/* 7621 */       String estado = "";
/* 7622 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 7623 */         estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*      */       }
/* 7625 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 7626 */             .buscarDatos(7, "folio_liq,fecha,nombreCompleto,unidad,usuario,liquidaciones.estatus,totalLetra", "liquidaciones,tarjeta_deudor", "where tarjeta_deudor.tarjeta =liquidaciones.tarjeta and folio_liq like '%" + this.jTextField6.getText() + "%' and nombreCompleto like '%" + this.jTextField3.getText() + "%' and unidad like '%" + this.jTextField1.getText() + "%' and liquidaciones.estatus like '%" + estado + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by folio_liq desc"), (Object[])new String[] { "Folio", "Fecha", "Nombre Completo", "Unidad", "Elaboró / Autorizó", "Estatus", "Total" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 7631 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7636 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 7639 */       this.jLabel120.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable2.getRowCount() + "</HTML>");
/*      */       
/* 7641 */       double valor = 0.0D;
/* 7642 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 7643 */         String canti = String.valueOf(this.jTable2.getValueAt(i, 6));
/* 7644 */         String valorP = "";
/*      */         
/* 7646 */         for (int j = 0; j < canti.length(); j++) {
/* 7647 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7648 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 7651 */         valor += Double.parseDouble(valorP);
/*      */       } 
/* 7653 */       this.jFormattedTextField2.setValue(Double.valueOf(valor));
/* 7654 */       this.jLabel123.setText(this.jFormattedTextField2.getText());
/*      */       
/* 7656 */       this.celda3.pasarInd(this.con.revisarCol(this.jTable2, "<Por Pagar>", 0, 5, 0));
/* 7657 */       this.celda3.pasarInd2(this.con.revisarCol(this.jTable2, "<Cancelada>", 0, 5, 0));
/* 7658 */       this.celda3.pasarInd3(this.con.revisarCol(this.jTable2, "<Por Autorizar>", 0, 5, 0));
/*      */       
/* 7660 */       this.jTable2.setShowVerticalLines(false);
/* 7661 */       this.jScrollPane2.setViewportView(this.jTable2);
/* 7662 */       this.jTable2.setSelectionMode(0);
/* 7663 */       this.jTable2.setAutoCreateRowSorter(true);
/* 7664 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 7665 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 7666 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
/* 7667 */       this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 7668 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(120);
/* 7669 */       this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(300);
/* 7670 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(300);
/* 7671 */       this.jTable2.getColumnModel().getColumn(3).setPreferredWidth(60);
/* 7672 */       this.jTable2.getColumnModel().getColumn(3).setMaxWidth(60);
/* 7673 */       this.jTable2.getColumnModel().getColumn(4).setPreferredWidth(190);
/* 7674 */       this.jTable2.getColumnModel().getColumn(4).setMaxWidth(190);
/*      */       
/* 7676 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 7677 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 7678 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 7679 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 7680 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 7681 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 7682 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 7687 */     this.consultarOperadores = true;
/* 7688 */     this.jButton20.setEnabled(false);
/* 7689 */     String num_ope = this.jTextField9.getText();
/* 7690 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 7691 */           .buscarDatos(3, "tarjeta,nombreCompleto,tipo", "tarjeta_deudor", "where tarjeta like '%" + num_ope + "%' and nombreCompleto like '%" + this.jTextField10.getText() + "%' and estatus='<activa>' order by nombreCompleto"), (Object[])new String[] { "Clave", "Nombre Completo", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7696 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7701 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7704 */     this.jTable3.setShowVerticalLines(false);
/* 7705 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 7706 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 7707 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 7708 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(200);
/* 7709 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(200);
/*      */     
/* 7711 */     this.jTable3.setSelectionMode(0);
/* 7712 */     this.jTable3.setAutoCreateRowSorter(true);
/* 7713 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7715 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 7716 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 7717 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 7721 */     this.jTable12.setModel(new DefaultTableModel((Object[][])this.con
/* 7722 */           .buscarDatos(3, "referencia,importeLetra,estatus", "tarjeta_contenido", "where tipoConcep=1 and importeSaldado<>importe and tarjeta=" + this.CLAVEOP + " order by mov desc"), (Object[])new String[] { "Referencia", "Importe", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7727 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7732 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7735 */     this.jTable12.setShowVerticalLines(false);
/* 7736 */     this.jScrollPane13.setViewportView(this.jTable12);
/*      */     
/* 7738 */     this.jTable12.setSelectionMode(0);
/* 7739 */     this.jTable12.setAutoCreateRowSorter(true);
/* 7740 */     this.jTable12.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar4() {
/* 7746 */     this.jTable13.setModel(new DefaultTableModel((Object[][])this.con
/* 7747 */           .buscarDatos(3, "referencia,importeLetra,estatus", "tarjeta_contenido", "where tipoConcep=2 and importeSaldado<>importe and tarjeta=" + this.CLAVEOP + " order by mov desc"), (Object[])new String[] { "Referencia", "Importe", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7752 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7757 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7760 */     this.jTable13.setShowVerticalLines(false);
/* 7761 */     this.jScrollPane14.setViewportView(this.jTable13);
/*      */     
/* 7763 */     this.jTable13.setSelectionMode(0);
/* 7764 */     this.jTable13.setAutoCreateRowSorter(true);
/* 7765 */     this.jTable13.getTableHeader().setReorderingAllowed(false);
/* 7766 */     this.jTable13.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 7767 */     this.jTable13.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar5() {
/* 7773 */     this.jTable14.setModel(new DefaultTableModel((Object[][])this.con
/* 7774 */           .buscarDatos(2, "num,origen", "origenes", "order by origen"), (Object[])new String[] { "Núm", "Origen" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7779 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7784 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7787 */     this.jTable14.setShowVerticalLines(false);
/* 7788 */     this.jScrollPane15.setViewportView(this.jTable14);
/*      */     
/* 7790 */     this.jTable14.setSelectionMode(0);
/* 7791 */     this.jTable14.setAutoCreateRowSorter(true);
/* 7792 */     this.jTable14.getTableHeader().setReorderingAllowed(false);
/* 7793 */     this.jTable14.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 7794 */     this.jTable14.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar6() {
/* 7800 */     this.jTable13.setModel(new DefaultTableModel((Object[][])this.con
/* 7801 */           .buscarDatos(2, "num,destino", "destinos", "order by destino"), (Object[])new String[] { "Núm", "Origen" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7806 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7811 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7814 */     this.jTable15.setShowVerticalLines(false);
/* 7815 */     this.jScrollPane16.setViewportView(this.jTable15);
/*      */     
/* 7817 */     this.jTable15.setSelectionMode(0);
/* 7818 */     this.jTable15.setAutoCreateRowSorter(true);
/* 7819 */     this.jTable15.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 7823 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7825 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7829 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 7832 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7834 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7838 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 7841 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7843 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7847 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 7850 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7852 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7856 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 7859 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7861 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7865 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 7868 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7870 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7874 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/* 7877 */     this.jFormattedTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7879 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7883 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField7, evt);
/*      */           }
/*      */         });
/* 7886 */     this.jFormattedTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7888 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7892 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField8, evt);
/*      */           }
/*      */         });
/* 7895 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7897 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7901 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 7904 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7906 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7910 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 7913 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7915 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7919 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 7922 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7924 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7928 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 7931 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7933 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7937 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 7940 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7942 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7946 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 7949 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7951 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7955 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 7958 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7960 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7964 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 7967 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7969 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7973 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 7976 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7978 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7982 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 7985 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7987 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField19, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7991 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField19, evt);
/*      */           }
/*      */         });
/* 7994 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7996 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8000 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField20, evt);
/*      */           }
/*      */         });
/* 8003 */     this.jTextField21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8005 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8009 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField21, evt);
/*      */           }
/*      */         });
/* 8012 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8014 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextField22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8018 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextField22, evt);
/*      */           }
/*      */         });
/* 8021 */     this.jFormattedTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8023 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8027 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField9, evt);
/*      */           }
/*      */         });
/* 8030 */     this.jFormattedTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8032 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8036 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField10, evt);
/*      */           }
/*      */         });
/* 8039 */     this.jFormattedTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8041 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8045 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField12, evt);
/*      */           }
/*      */         });
/* 8048 */     this.jFormattedTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8050 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8054 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField13, evt);
/*      */           }
/*      */         });
/* 8057 */     this.jFormattedTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8059 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8063 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField14, evt);
/*      */           }
/*      */         });
/* 8066 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8068 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8072 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 8075 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8077 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8081 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 8084 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8086 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8090 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 8093 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8095 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8099 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 8102 */     this.jFormattedTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8104 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8108 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField15, evt);
/*      */           }
/*      */         });
/* 8111 */     this.jFormattedTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8113 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8117 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField16, evt);
/*      */           }
/*      */         });
/* 8120 */     this.jFormattedTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8122 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8126 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField17, evt);
/*      */           }
/*      */         });
/* 8129 */     this.jFormattedTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8131 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8135 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField18, evt);
/*      */           }
/*      */         });
/* 8138 */     this.jFormattedTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8140 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField19, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8144 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField19, evt);
/*      */           }
/*      */         });
/* 8147 */     this.jFormattedTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8149 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8153 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField20, evt);
/*      */           }
/*      */         });
/* 8156 */     this.jFormattedTextField21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8158 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8162 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField21, evt);
/*      */           }
/*      */         });
/* 8165 */     this.jFormattedTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8167 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8171 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField22, evt);
/*      */           }
/*      */         });
/* 8174 */     this.jFormattedTextField23.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8176 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField23, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8180 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField23, evt);
/*      */           }
/*      */         });
/* 8183 */     this.jFormattedTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8185 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField24, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8189 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField24, evt);
/*      */           }
/*      */         });
/* 8192 */     this.jFormattedTextField25.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8194 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField25, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8198 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField25, evt);
/*      */           }
/*      */         });
/* 8201 */     this.jFormattedTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8203 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField26, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8207 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField26, evt);
/*      */           }
/*      */         });
/* 8210 */     this.jFormattedTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8212 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8216 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField27, evt);
/*      */           }
/*      */         });
/* 8219 */     this.jFormattedTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8221 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField28, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8225 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField28, evt);
/*      */           }
/*      */         });
/* 8228 */     this.jFormattedTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 8230 */             Liquidaciones.this.jTextGanado(Liquidaciones.this.jFormattedTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 8234 */             Liquidaciones.this.jTextPerdido(Liquidaciones.this.jFormattedTextField29, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void cargarValeDiesel(boolean operador) {
/* 8240 */     DefaultTableModel modelo = new DefaultTableModel();
/* 8241 */     DefaultTableModel modelo2 = new DefaultTableModel();
/* 8242 */     this.jComboBox3.removeAllItems();
/* 8243 */     modelo.addColumn("Folio");
/* 8244 */     modelo.addColumn("Estado");
/* 8245 */     this.jTable8.setModel(modelo);
/* 8246 */     this.jTable1.setModel(modelo2);
/* 8247 */     String[] columnas1 = { "Folio", "Expedido Por", "Litros", "Precio", "Total" };
/* 8248 */     if (operador) {
/* 8249 */       this.encontrado = this.con.consultar("folio", "vales_diesel", "where num_ope = " + this.OPERADOR + " and folio_liq = '' and estado = 'ACTIVO'");
/*      */     }
/* 8251 */     if (this.encontrado && operador) {
/* 8252 */       String[] vales = this.con.regresaColIndex("folio", "vales_diesel", "where num_ope = " + this.OPERADOR + " and folio_liq ='' and estado = 'ACTIVO'");
/* 8253 */       modelo2.addColumn("Folio");
/* 8254 */       modelo2.addColumn("Expedido por");
/* 8255 */       modelo2.addColumn("Litros");
/* 8256 */       modelo2.addColumn("Precio");
/* 8257 */       modelo2.addColumn("Total");
/* 8258 */       for (int i = 0; i < vales.length; i++) {
/* 8259 */         Object[] reg = { vales[i], "INCOMPLETO" };
/* 8260 */         modelo.addRow(reg);
/* 8261 */         modelo2.addRow(new Object[] { vales[i], "", "", "", "" });
/* 8262 */         this.MODELODIESEL = modelo2;
/* 8263 */         this.jComboBox3.addItem(vales[i]);
/* 8264 */         this.jTable1.setValueAt(vales[i], i, 0);
/*      */       } 
/* 8266 */       this.jLabel96.setText("" + vales.length + " VALES");
/*      */     } else {
/* 8268 */       this.jButton10.setEnabled(false);
/* 8269 */       this.jTable1.setModel(modelo2);
/* 8270 */       this.jLabel96.setText("0 VALES");
/* 8271 */       this.jTable8.setModel(modelo);
/*      */     } 
/* 8273 */     actualizaTabla4();
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 8277 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 8281 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void liquidaciones(String usu) {
/* 8285 */     this.USUARIO = usu;
/* 8286 */     llenarCombo2();
/* 8287 */     consultarLiq();
/* 8288 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 8292 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 8300 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 8306 */         return 30;
/*      */       
/*      */       case 1:
/* 8309 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 8311 */           return 29;
/*      */         }
/* 8313 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 8317 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarMayor() {
/* 8322 */     this.con.consultar("max(mov)", "liquidaciones", "");
/* 8323 */     String mayor = this.con.Campo;
/* 8324 */     int MAYOR = 0;
/*      */     try {
/* 8326 */       MAYOR = Integer.parseInt(mayor);
/* 8327 */     } catch (NumberFormatException e) {
/* 8328 */       MAYOR = 0;
/*      */     } 
/* 8330 */     MAYOR++;
/* 8331 */     if (MAYOR < 10) {
/* 8332 */       this.jTextField61.setText(this.DIRECTIVA[0] + "-0000" + this.DIRECTIVA[0]);
/* 8333 */     } else if (MAYOR < 100) {
/* 8334 */       this.jTextField61.setText(this.DIRECTIVA[0] + "-000" + this.DIRECTIVA[0]);
/* 8335 */     } else if (MAYOR < 1000) {
/* 8336 */       this.jTextField61.setText(this.DIRECTIVA[0] + "-00" + this.DIRECTIVA[0]);
/* 8337 */     } else if (MAYOR < 10000) {
/* 8338 */       this.jTextField61.setText(this.DIRECTIVA[0] + "-0" + this.DIRECTIVA[0]);
/*      */     } else {
/* 8340 */       this.jTextField61.setText(this.DIRECTIVA[0] + "-" + this.DIRECTIVA[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarFechaHoy() {
/* 8345 */     Calendar ahoraCal = Calendar.getInstance();
/* 8346 */     ahoraCal.setTime(this.fecha);
/* 8347 */     String mesesito = "";
/* 8348 */     String hoy = "";
/* 8349 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 8350 */     hoy = "" + ahoraCal.get(5);
/* 8351 */     if (ahoraCal.get(2) + 1 < 10) {
/* 8352 */       mesesito = "0" + mesesito;
/*      */     }
/* 8354 */     if (ahoraCal.get(5) < 10) {
/* 8355 */       hoy = "0" + hoy;
/*      */     }
/* 8357 */     this.jTextField62.setText(hoy + "/" + hoy + "/" + mesesito);
/*      */   }
/*      */   
/*      */   class CeldaRender3
/*      */     extends DefaultTableCellRenderer {
/* 8362 */     int otro = -1;
/* 8363 */     String[] indices = new String[0];
/* 8364 */     String[] indices2 = new String[0];
/* 8365 */     String[] indices3 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8368 */       setEnabled((table == null || table.isEnabled()));
/* 8369 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 8370 */       if (comparar(comp)) {
/* 8371 */         setBackground((Color)null);
/* 8372 */         setForeground(Color.BLUE);
/* 8373 */         setHorizontalAlignment(2);
/* 8374 */       } else if (comparar2(comp)) {
/* 8375 */         setBackground(Color.LIGHT_GRAY);
/* 8376 */         setForeground(Color.red);
/* 8377 */         setHorizontalAlignment(2);
/* 8378 */       } else if (comparar3(comp)) {
/* 8379 */         setBackground(Color.ORANGE);
/* 8380 */         setForeground(Color.RED);
/* 8381 */         setHorizontalAlignment(2);
/*      */       } else {
/* 8383 */         setBackground((Color)null);
/* 8384 */         setForeground(Color.black);
/* 8385 */         setHorizontalAlignment(2);
/*      */       } 
/* 8387 */       if (column == 6) {
/* 8388 */         setHorizontalAlignment(4);
/*      */       }
/* 8390 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8391 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 8395 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 8399 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 8403 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 8407 */       for (int i = 0; i < this.indices.length; i++) {
/* 8408 */         if (this.indices[i].equals(reg)) {
/* 8409 */           return true;
/*      */         }
/*      */       } 
/* 8412 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 8416 */       for (int i = 0; i < this.indices2.length; i++) {
/* 8417 */         if (this.indices2[i].equals(reg)) {
/* 8418 */           return true;
/*      */         }
/*      */       } 
/* 8421 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 8425 */       for (int i = 0; i < this.indices3.length; i++) {
/* 8426 */         if (this.indices3[i].equals(reg)) {
/* 8427 */           return true;
/*      */         }
/*      */       } 
/* 8430 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 8436 */     int otro = -1;
/* 8437 */     String[] indices = new String[0];
/* 8438 */     String[] indices2 = new String[0];
/* 8439 */     String[] indices3 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8442 */       setEnabled((table == null || table.isEnabled()));
/* 8443 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 8445 */       if (comparar(comp)) {
/* 8446 */         setBackground((Color)null);
/* 8447 */         setForeground(Color.BLUE);
/* 8448 */         setHorizontalAlignment(2);
/* 8449 */       } else if (comparar2(comp)) {
/* 8450 */         setBackground(Color.LIGHT_GRAY);
/* 8451 */         setForeground(Color.red);
/* 8452 */         setHorizontalAlignment(2);
/* 8453 */       } else if (comparar3(comp)) {
/* 8454 */         setBackground((Color)null);
/* 8455 */         setForeground(Color.RED);
/* 8456 */         setHorizontalAlignment(2);
/*      */       } else {
/* 8458 */         setBackground((Color)null);
/* 8459 */         setForeground(Color.black);
/* 8460 */         setHorizontalAlignment(2);
/*      */       } 
/* 8462 */       if (column == 5 || column == 6 || column == 7) {
/* 8463 */         setHorizontalAlignment(4);
/*      */       }
/* 8465 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8466 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 8470 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 8474 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 8478 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 8482 */       for (int i = 0; i < this.indices.length; i++) {
/* 8483 */         if (this.indices[i].equals(reg)) {
/* 8484 */           return true;
/*      */         }
/*      */       } 
/* 8487 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 8491 */       for (int i = 0; i < this.indices2.length; i++) {
/* 8492 */         if (this.indices2[i].equals(reg)) {
/* 8493 */           return true;
/*      */         }
/*      */       } 
/* 8496 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 8500 */       for (int i = 0; i < this.indices3.length; i++) {
/* 8501 */         if (this.indices3[i].equals(reg)) {
/* 8502 */           return true;
/*      */         }
/*      */       } 
/* 8505 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public String[][] regresaLineas() {
/* 8510 */     int renglones = this.jTable4.getRowCount() + this.jTable7.getRowCount() + this.jTable6.getRowCount() + this.jTable1.getRowCount();
/* 8511 */     renglones += 20;
/* 8512 */     String[][] Lineas = new String[renglones][8];
/* 8513 */     int cuenta = 0;
/*      */     int i;
/* 8515 */     for (i = 0; i < Lineas.length; i++) {
/* 8516 */       for (int k = 0; k < (Lineas[i]).length; k++) {
/* 8517 */         Lineas[i][k] = "";
/*      */       }
/*      */     } 
/* 8520 */     cuenta++;
/* 8521 */     Lineas[0][0] = "• A continuación se enlistan los 'VIAJES FORANEOS': ";
/* 8522 */     cuenta++;
/* 8523 */     Lineas[1][2] = " ORIGENES";
/* 8524 */     Lineas[1][3] = " DESTINOS";
/* 8525 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 8526 */       Lineas[i + 2][0] = String.valueOf(this.jTable4.getValueAt(i, 0));
/* 8527 */       Lineas[i + 2][1] = String.valueOf(this.jTable4.getValueAt(i, 1));
/* 8528 */       Lineas[i + 2][2] = String.valueOf(this.jTable4.getValueAt(i, 2));
/* 8529 */       Lineas[i + 2][3] = String.valueOf(this.jTable4.getValueAt(i, 3));
/* 8530 */       Lineas[i + 2][4] = String.valueOf(this.jTable4.getValueAt(i, 4));
/* 8531 */       Lineas[i + 2][5] = String.valueOf(this.jTable4.getValueAt(i, 7));
/* 8532 */       Lineas[i + 2][6] = String.valueOf(this.jTable4.getValueAt(i, 8));
/* 8533 */       Lineas[i + 2][7] = String.valueOf(this.jTable4.getValueAt(i, 9));
/*      */       
/* 8535 */       cuenta = i + 1;
/*      */     } 
/* 8537 */     cuenta++;
/*      */     
/* 8539 */     double valor = this.SUBTOTAL;
/* 8540 */     String porcen = "15%";
/* 8541 */     if (this.jRadioButton1.isSelected()) {
/* 8542 */       porcen = "12%";
/*      */     }
/* 8544 */     double total = this.NETO;
/* 8545 */     total = this.NETO / 2.0D;
/* 8546 */     double ejemplo = total / 3.0D;
/*      */     
/* 8548 */     Lineas[cuenta][0] = "<Vacío>";
/* 8549 */     Lineas[cuenta][1] = this.jTextField62.getText();
/* 8550 */     Lineas[cuenta][2] = "ALIMENTACIÓN";
/* 8551 */     Lineas[cuenta][6] = "Viaje";
/* 8552 */     this.jFormattedTextField2.setValue(Double.valueOf(ejemplo * 2.0D));
/* 8553 */     Lineas[cuenta][7] = this.jFormattedTextField2.getText();
/*      */     
/* 8555 */     cuenta++;
/* 8556 */     Lineas[cuenta][0] = "<Vacío>";
/* 8557 */     Lineas[cuenta][1] = this.jTextField62.getText();
/* 8558 */     Lineas[cuenta][2] = "HOSPEDAJE";
/* 8559 */     Lineas[cuenta][6] = "Viaje";
/* 8560 */     this.jFormattedTextField2.setValue(Double.valueOf(ejemplo));
/* 8561 */     Lineas[cuenta][7] = this.jFormattedTextField2.getText();
/*      */     
/* 8563 */     Lineas[cuenta + 2][0] = "• A continuación se enlistan los 'GASTOS DEL VIAJE': ";
/* 8564 */     cuenta += 3; int j;
/* 8565 */     for (j = 0; j < this.jTable7.getRowCount(); j++) {
/* 8566 */       Lineas[cuenta][0] = String.valueOf(this.jTable7.getValueAt(j, 1));
/* 8567 */       Lineas[cuenta][2] = String.valueOf(this.jTable7.getValueAt(j, 2));
/* 8568 */       Lineas[cuenta][3] = String.valueOf(this.jTable7.getValueAt(j, 0));
/* 8569 */       Lineas[cuenta][7] = String.valueOf(this.jTable7.getValueAt(j, 3));
/* 8570 */       cuenta++;
/*      */     } 
/*      */     
/* 8573 */     cuenta++;
/* 8574 */     Lineas[cuenta][0] = "GASTOS POR COMPROBAR EN ESTA LIQUIDACIÓN";
/* 8575 */     Lineas[cuenta][7] = this.jLabel26.getText();
/*      */     
/* 8577 */     cuenta++;
/* 8578 */     Lineas[cuenta + 1][0] = "• A continuación se enlistan los 'OTROS GASTOS': ";
/* 8579 */     cuenta += 2;
/* 8580 */     Lineas[cuenta][0] = "AUTOPISTAS";
/* 8581 */     Lineas[cuenta][7] = this.jLabel18.getText();
/* 8582 */     cuenta++;
/* 8583 */     Lineas[cuenta][0] = "OTROS GASTOS";
/* 8584 */     Lineas[cuenta][7] = this.jLabel19.getText();
/* 8585 */     cuenta++;
/* 8586 */     Lineas[cuenta][0] = "LLANTAS";
/* 8587 */     Lineas[cuenta][7] = this.jLabel20.getText();
/*      */     
/* 8589 */     cuenta++;
/* 8590 */     Lineas[cuenta + 1][0] = "• A continuación se enlistan los 'PREMIOS': ";
/* 8591 */     cuenta += 2;
/* 8592 */     for (j = 0; j < this.jTable6.getRowCount(); j++) {
/* 8593 */       String premio = String.valueOf(this.jTable6.getValueAt(j, 0));
/* 8594 */       Lineas[cuenta][0] = premio.toUpperCase();
/* 8595 */       Lineas[cuenta][7] = String.valueOf(this.jTable6.getValueAt(j, 1));
/* 8596 */       cuenta++;
/*      */     } 
/*      */     
/* 8599 */     Lineas[cuenta + 1][0] = "• A continuación se enlistan los 'VALES DE DIESEL':";
/* 8600 */     cuenta += 2;
/* 8601 */     for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 8602 */       Lineas[cuenta][0] = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 8603 */       Lineas[cuenta][1] = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 8604 */       Lineas[cuenta][4] = String.valueOf(this.jTable1.getValueAt(j, 2)) + " lts.";
/* 8605 */       Lineas[cuenta][5] = String.valueOf(this.jTable1.getValueAt(j, 3));
/* 8606 */       Lineas[cuenta][6] = String.valueOf(this.jTable1.getValueAt(j, 4));
/* 8607 */       cuenta++;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 8612 */     this.NUMLINEAS = Lineas.length;
/* 8613 */     return Lineas;
/*      */   }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 8618 */       this.otro = -1;
/* 8619 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8622 */       setEnabled((table == null || table.isEnabled()));
/* 8623 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 8624 */       if (comparar(comp)) {
/* 8625 */         setBackground(Color.red);
/* 8626 */         setForeground(Color.white);
/* 8627 */       } else if (row % 2 == 0) {
/* 8628 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/* 8630 */         setBackground((Color)null);
/*      */       } 
/* 8632 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8633 */       return this;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 8637 */       for (int i = 0; i < this.indices.length; i++) {
/* 8638 */         if (this.indices[i].equals(reg)) {
/* 8639 */           return true;
/*      */         }
/*      */       } 
/* 8642 */       return false;
/*      */     } }
/*      */   public class ImprimirDocumento implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirDocumento() {
/* 8650 */       this.g2 = null;
/* 8651 */       this.Pag = 0;
/*      */       
/* 8653 */       this.linesPerPage = 50;
/* 8654 */       this.orientacion = 0;
/* 8655 */       this.X = 0.0D;
/* 8656 */       this.Y = 0.0D;
/* 8657 */       this.YINICIA = 75;
/* 8658 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 8659 */       this.NumLineas = 0;
/* 8660 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 8663 */       if (this.textLines == null) {
/* 8664 */         this.Lineas = Liquidaciones.this.regresaLineas();
/* 8665 */         int numLines = this.Lineas.length;
/* 8666 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 8671 */       Font font = new Font("Serif", 0, 8);
/* 8672 */       FontMetrics metrics = g.getFontMetrics(font);
/* 8673 */       int lineHeight = metrics.getHeight();
/* 8674 */       if (this.pageBreaks == null) {
/* 8675 */         initTextLines();
/* 8676 */         this.orientacion = pf.getOrientation();
/* 8677 */         if (pf.getOrientation() == 1) {
/* 8678 */           this.linesPerPage = 53;
/* 8679 */           this.X = pf.getWidth();
/* 8680 */           this.Y = pf.getHeight();
/*      */         } else {
/* 8682 */           this.linesPerPage = 38;
/* 8683 */           this.X = pf.getWidth();
/* 8684 */           this.Y = pf.getHeight();
/*      */         } 
/* 8686 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 8687 */         this.Pag = this.numBreaks;
/* 8688 */         this.pageBreaks = new int[this.numBreaks];
/* 8689 */         for (int b = 0; b < this.numBreaks; b++) {
/* 8690 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 8693 */       if (pageIndex > this.pageBreaks.length) {
/* 8694 */         return 1;
/*      */       }
/* 8696 */       Graphics2D g2d = (Graphics2D)g;
/* 8697 */       this.g2 = g;
/* 8698 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 8699 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 8700 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 8701 */       encabezado();
/* 8702 */       int y = this.YINICIA;
/* 8703 */       int lineas = 0;
/*      */       
/* 8705 */       Font fuente = new Font("Dialog", 0, 7);
/* 8706 */       this.g2.setFont(fuente);
/* 8707 */       int cont = 0;
/* 8708 */       for (int line = start; line < end; line++) {
/* 8709 */         y += 9;
/* 8710 */         int Xempe = 35;
/* 8711 */         String valor = "";
/* 8712 */         if (line < 9) {
/* 8713 */           valor = "0" + line + 1;
/*      */         } else {
/* 8715 */           valor = "" + line + 1;
/*      */         } 
/*      */         
/* 8718 */         if (line == 1) {
/* 8719 */           fuente = new Font("Dialog", 1, 8);
/* 8720 */           this.g2.setFont(fuente);
/*      */         } else {
/* 8722 */           fuente = new Font("Dialog", 0, 7);
/* 8723 */           this.g2.setFont(fuente);
/*      */         } 
/*      */         
/* 8726 */         g.drawString(this.Lineas[line][0], 15, y);
/* 8727 */         g.drawString(this.Lineas[line][1], 60, y);
/* 8728 */         g.drawString(this.Lineas[line][2], 130, y);
/* 8729 */         g.drawString(this.Lineas[line][3], 250, y);
/* 8730 */         g.drawString(this.Lineas[line][4], 375, y);
/* 8731 */         g.drawString(this.Lineas[line][5], 425, y);
/* 8732 */         g.drawString(this.Lineas[line][6], 465, y);
/* 8733 */         g.drawString(this.Lineas[line][7], 520, y);
/* 8734 */         y += 2;
/* 8735 */         lineas = y;
/*      */       } 
/* 8737 */       if (this.Pag == pageIndex) {
/* 8738 */         this.g2.setColor(Color.BLACK);
/* 8739 */         fuente = new Font("Dialog", 1, 7);
/* 8740 */         this.g2.setFont(fuente);
/* 8741 */         this.g2.drawString("ISO 9001:2015              ISO 14001:2015              ISO 37001:2016              ISO 45001:2018", 122, 767);
/*      */         
/* 8743 */         this.g2.setColor(new Color(204, 0, 0));
/* 8744 */         this.g2.drawRect(13, 660, 570, 100);
/*      */         
/* 8746 */         this.g2.fillRect(468, 662, 60, 95);
/* 8747 */         this.g2.setColor(Color.WHITE);
/* 8748 */         fuente = new Font("Arial", 1, 6);
/* 8749 */         this.g2.setFont(fuente);
/* 8750 */         this.g2.drawString("Viajes", 470, 672);
/* 8751 */         this.g2.drawString("Gastos", 470, 682);
/* 8752 */         this.g2.drawString("Premios", 470, 692);
/* 8753 */         this.g2.drawString("Diesel", 470, 702);
/* 8754 */         this.g2.drawString("Subtotal", 470, 720);
/* 8755 */         this.g2.drawString("Impuestos", 470, 730);
/* 8756 */         this.g2.drawString("Abono a T.D.", 470, 740);
/* 8757 */         this.g2.drawString("Total", 470, 755);
/*      */         
/* 8759 */         this.g2.setColor(Color.BLACK);
/* 8760 */         fuente = new Font("Dialog", 0, 7);
/* 8761 */         this.g2.setFont(fuente);
/*      */         
/* 8763 */         this.g2.drawString(Liquidaciones.this.jLabel33.getText(), 540, 672);
/* 8764 */         this.g2.drawString(Liquidaciones.this.jLabel39.getText(), 540, 682);
/* 8765 */         this.g2.drawString(Liquidaciones.this.jLabel35.getText(), 540, 692);
/* 8766 */         this.g2.drawString(Liquidaciones.this.jLabel37.getText(), 540, 702);
/* 8767 */         this.g2.drawLine(540, 710, 570, 710);
/* 8768 */         this.g2.drawString(Liquidaciones.this.jLabel43.getText(), 540, 720);
/* 8769 */         this.g2.drawString(Liquidaciones.this.jLabel45.getText(), 540, 730);
/* 8770 */         this.g2.drawString("-" + Liquidaciones.this.jFormattedTextField1.getText(), 540, 740);
/*      */         
/* 8772 */         fuente = new Font("Dialog", 1, 9);
/* 8773 */         this.g2.setFont(fuente);
/* 8774 */         this.g2.drawLine(540, 745, 570, 745);
/* 8775 */         String saldo = "";
/* 8776 */         if (Liquidaciones.this.NETO < 0.1D) {
/* 8777 */           saldo = "(SALDO NEGATIVO)";
/*      */         }
/* 8779 */         this.g2.drawString(Liquidaciones.this.jFormattedTextField4.getText(), 530, 755);
/* 8780 */         this.g2.drawString(saldo, 368, 755);
/*      */ 
/*      */         
/* 8783 */         fuente = new Font("Dialog", 0, 6);
/* 8784 */         this.g2.setFont(fuente);
/* 8785 */         this.g2.drawString("_____________________________", 20, 710);
/* 8786 */         this.g2.drawString("Nombre y Firma del Operador", 28, 720);
/*      */         
/* 8788 */         this.g2.drawString("_____________________________", 200, 710);
/* 8789 */         this.g2.drawString("Nombre y Firma de Elaborado", 208, 720);
/*      */         
/* 8791 */         this.g2.drawString("_____________________________", 360, 710);
/* 8792 */         this.g2.drawString("Nombre y Firma de Revisado", 372, 720);
/*      */       } 
/* 8794 */       fuente = new Font("Dialog", 0, 7);
/* 8795 */       this.g2.setFont(fuente);
/* 8796 */       g.drawString("Página " + pageIndex + 1, 520, 33);
/* 8797 */       this.g2.setColor(Color.WHITE);
/* 8798 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/* 8799 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 8803 */       Font fuente = new Font("Dialog", 0, 8);
/* 8804 */       this.g2.setFont(fuente);
/* 8805 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 8806 */       Image img = imagen.getImage();
/*      */       
/* 8808 */       this.g2.drawImage(img, 10, 12, 62, 62, null);
/* 8809 */       fuente = new Font("Dialog", 1, 15);
/* 8810 */       this.g2.setFont(fuente);
/* 8811 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 78, 30);
/* 8812 */       this.g2.drawLine(78, 35, 585, 35);
/* 8813 */       fuente = new Font("Dialog", 1, 12);
/* 8814 */       this.g2.setFont(fuente);
/* 8815 */       this.g2.drawString("BITÁCORA DE VIAJE:   " + Liquidaciones.this.jTextField8.getText() + "                ", 78, 48);
/* 8816 */       String placas = "";
/* 8817 */       if (!Liquidaciones.this.jTextField2.getText().equals("")) {
/* 8818 */         Liquidaciones.this.con.consultar("placas", "tracto", "where num_tracto=" + Liquidaciones.this.jTextField2.getText());
/* 8819 */         placas = Liquidaciones.this.con.Campo;
/*      */       } 
/*      */       
/* 8822 */       fuente = new Font("Dialog", 0, 11);
/* 8823 */       this.g2.setFont(fuente);
/* 8824 */       this.g2.drawString("No: " + Liquidaciones.this.jTextField61.getText(), 78, 65);
/* 8825 */       this.g2.drawString("Fecha 1er. Viaje: " + Liquidaciones.this.jTextField63.getText(), 168, 65);
/* 8826 */       this.g2.drawString("Fecha Liq: " + Liquidaciones.this.jTextField62.getText(), 340, 65);
/*      */       
/* 8828 */       this.g2.drawString("ECO:     " + Liquidaciones.this.jTextField2.getText(), 480, 48);
/* 8829 */       this.g2.drawString("PLACA: " + placas, 480, 65);
/*      */       
/* 8831 */       fuente = new Font("Dialog", 0, 9);
/* 8832 */       this.g2.setFont(fuente);
/* 8833 */       Calendar ahoraCal = Calendar.getInstance();
/* 8834 */       ahoraCal.setTime(Liquidaciones.this.fecha);
/* 8835 */       String mesesito = "";
/* 8836 */       String hoy = "";
/* 8837 */       mesesito = "" + ahoraCal.get(2) + 1;
/* 8838 */       hoy = "" + ahoraCal.get(5);
/* 8839 */       if (ahoraCal.get(2) + 1 < 10) {
/* 8840 */         mesesito = "0" + mesesito;
/*      */       }
/* 8842 */       if (ahoraCal.get(5) < 10) {
/* 8843 */         hoy = "0" + hoy;
/*      */       }
/* 8845 */       this.g2.drawString(hoy + "/" + hoy + "/" + mesesito, 520, 24);
/* 8846 */       this.g2.drawLine(10, 75, 585, 75);
/* 8847 */       this.g2.drawLine(10, 76, 585, 76);
/*      */       
/* 8849 */       this.g2.setColor(Color.BLACK);
/* 8850 */       fuente = new Font("Dialog", 0, 7);
/* 8851 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 8855 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 8856 */       job.setPrintable(this);
/*      */       
/* 8858 */       PageFormat pf = job.defaultPage();
/* 8859 */       Paper papel = pf.getPaper();
/* 8860 */       papel.setSize(612.0D, 792.0D);
/* 8861 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 8862 */       pf.setPaper(papel);
/* 8863 */       pf.setOrientation(1);
/* 8864 */       job.setPrintable(new ImprimirDocumento(), pf);
/* 8865 */       job.defaultPage(pf);
/*      */       
/* 8867 */       boolean ok = job.printDialog();
/* 8868 */       if (ok)
/*      */         try {
/* 8870 */           job.print();
/* 8871 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Liquidaciones.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */