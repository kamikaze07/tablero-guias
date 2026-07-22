/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ 
/*      */ public class PrefacturaCliente extends JPanel {
/*      */   JScrollPane panel;
/*   47 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   48 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   49 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   50 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   51 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   52 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   53 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   54 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   55 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   56 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   57 */   Validaciones val = new Validaciones();
/*   58 */   Consultas con = new Consultas();
/*   59 */   Errores error = new Errores(false);
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   63 */   Date fechaActual = new Date();
/*   64 */   Date fechaInicio = null;
/*   65 */   Date fecha = new Date();
/*   66 */   Tarifas[] jTarifas = null;
/*   67 */   CeldaRender celda = new CeldaRender();
/*   68 */   CeldaRender2 celda2 = new CeldaRender2();
/*   69 */   double IVA = 0.0D;
/*   70 */   double SUBTOTAL = 0.0D;
/*   71 */   double RET = 0.0D;
/*   72 */   double TOTAL = 0.0D;
/*   73 */   double RETENCION = 0.0D;
/*   74 */   double SUBIVA = 0.0D;
/*   75 */   double TONELADASTOTALES = 0.0D;
/*   76 */   double SUBTOTALD = 0.0D;
/*   77 */   double IVAD = 0.0D;
/*   78 */   double RETENCIOND = 0.0D;
/*   79 */   double TOTALD = 0.0D;
/*   80 */   double RETENCIONAPLICADO = 0.0D;
/*   81 */   double[] TONSRES = null;
/*      */   
/*      */   boolean TIENERETENCION = true;
/*      */   
/*      */   boolean VENTANA1 = false;
/*      */   boolean TONELADA = false;
/*      */   boolean VENTANA = false;
/*      */   boolean encontrado;
/*   89 */   String PREFACTURAINTERNA = "";
/*   90 */   String CAMPOSCON = "";
/*      */   String USUARIO;
/*   92 */   String USUPRE = "";
/*   93 */   String TONS = "";
/*   94 */   String NUMFAC = "";
/*   95 */   String TABLAS = "";
/*   96 */   String GENERAL = "";
/*   97 */   String leyenda = "";
/*   98 */   String DEPARTAMENTO = "";
/*   99 */   String PRIVILEGIOS = "";
/*  100 */   String PREORIGINAL = "";
/*  101 */   String[] RESIDUOS = null;
/*  102 */   String[] RESABREV = null;
/*  103 */   String[] CONFIGURACIONES = null;
/*  104 */   String[] DATOSGENERALES = null;
/*  105 */   String[] LINEAS = null;
/*  106 */   String[] NOMBRECOL = null;
/*  107 */   String[] PREFACTURAS = null;
/*  108 */   String[] CONTRESI = null;
/*  109 */   String[] COLUMNASTABLA = null;
/*  110 */   String[] CAMPOSTABLA = null;
/*  111 */   String[] COLTABLA = new String[] { "guias.num_guia", "guias.fecha", "servicio", "residuo", "emp_generadora.nombre_corto", "emp_destinataria.nombreCorto", "vales.ope_carga", "equipos.equipo", "plataformas.plataforma", "pozos.nombre", "vales.f_cargada", "vales.f_salida", "guias.pedido", "guias.tipo", "vales.ticket", "vales.peso", "llamadas_historicas.num_tracto", "llamadas_historicas.num_rem", "vales.rsp", "guias.Manifiesto", "otrosConcep", "preciou", "subTotal", "subtotal2" };
/*  112 */   String[] CAMPOS = new String[] { "guia", "fecha", "servicio", "residuo", "cliente", "destino", "operador", "equipo", "plataforma", "pozo", "F_Carga", "F_Descarga", "pedido", "tipo", "ticket", "tons", "tractor", "rem", "rsp", "Manifiesto", "preciou", "subTotal", "otrosConcep", "subTotal2" };
/*  113 */   String[] IMPRESION = new String[] { "Guia", "Fecha", "Servicio", "Residuo", "Cliente", "Destino", "Operador", "Equipo", "Plataforma", "Pozo", "F Carga", "F Desc", "Pedido", "Tipo", "Ticket", "Peso", "Tra", "Rem", "Rsp", "Manif", "P Unit", "Sub", "Otros $", "Subtotal2", "" };
/*  114 */   String[] COLNOMBRES = null;
/*  115 */   String[][] REGIS = null;
/*  116 */   String[][] DATOSOTROS = null;
/*  117 */   public JFormattedTextField cuadroPrecio = new JFormattedTextField();
/*  118 */   int POSICION = 0;
/*  119 */   int colExtra = 0;
/*  120 */   int colMani = 0;
/*  121 */   int colOtros = 0;
/*  122 */   int colTon = 0;
/*  123 */   int colResi = 0;
/*  124 */   int OPCRETENCION = 1;
/*  125 */   int INDICEOTROS = 0;
/*  126 */   int LINEASOTROSCONCEPTOS = 0;
/*  127 */   int[] COLTAMA = null;
/*  128 */   int[] COLIMPRESION = new int[] { 35, 35, 35, 65, 55, 68, 120, 60, 55, 60, 40, 40, 50, 45, 30, 30, 25, 25, 40, 50, 60, 60, 60, 60 };
/*  129 */   int[] TAMAÑOS = new int[] { 60, 110, 120, 0, 0, 0, 0, 0, 0, 0, 70, 70, 0, 0, 50, 50, 50, 50, 50, 75, 80, 80, 80, 80 };
/*  130 */   int[] tamañosCol = null;
/*  131 */   public int[] COLSELEC = null;
/*  132 */   String base = "";
/*      */   boolean PRIMERA = false;
/*  134 */   OtrosConceptos[] OTROS = null;
/*  135 */   NumerosALetras numLetra = null;
/*  136 */   MensajePop mensajeTry = null;
/*      */   boolean PRIMERAGUIAS = false;
/*  138 */   int contador = 0;
/*  139 */   Presionado presionado = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private ButtonGroup buttonGroup5; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton38; private JButton jButton39; private JButton jButton4; private JButton jButton40; private JButton jButton41; private JButton jButton42; private JButton jButton43; private JButton jButton44; private JButton jButton45; private JButton jButton46; private JButton jButton47; private JButton jButton48; private JButton jButton49; private JButton jButton5; private JButton jButton50; private JButton jButton51; private JButton jButton52; private JButton jButton53; private JButton jButton54; private JButton jButton55; private JButton jButton56; private JButton jButton57; private JButton jButton58; private JButton jButton59; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox<String> jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox12; private JComboBox jComboBox13; private JComboBox jComboBox14; private JComboBox jComboBox15; private JComboBox jComboBox16; private JComboBox jComboBox17; private JComboBox jComboBox2; private JComboBox jComboBox20; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser2; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog14; private JDialog jDialog15; private JDialog jDialog16; private JDialog jDialog17; private JDialog jDialog18; private JDialog jDialog19; private JDialog jDialog2; private JDialog jDialog20; private JDialog jDialog21; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField10; private JFormattedTextField jFormattedTextField11; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField7; private JFrame jFrame1; private JFrame jFrame2; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel128; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61;
/*      */   private JLabel jLabel62;
/*      */   private JLabel jLabel63;
/*      */   private JLabel jLabel64;
/*      */   
/*      */   public PrefacturaCliente(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  145 */     this.mensajeTry = mensajeTry;
/*  146 */     String año = "2010";
/*  147 */     String mes = "10";
/*  148 */     String dia = "10";
/*  149 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  150 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  152 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  153 */     } catch (ParseException ex) {
/*  154 */       ex.printStackTrace();
/*      */     } 
/*  156 */     padre = padre;
/*  157 */     fichas = fichas;
/*  158 */     initComponents();
/*      */     
/*  160 */     Image icono = this.tk.getImage(getClass().getResource("/entrada/Imagenes/calculator.png"));
/*  161 */     this.jFrame1.setIconImage(icono);
/*      */     
/*  163 */     this.USUARIO = USUARIO;
/*  164 */     panelito.setViewportView(this);
/*  165 */     this.panel = panelito;
/*      */     
/*  167 */     this.jFrame2.setExtendedState(6);
/*      */     
/*  169 */     int w = this.tama.width;
/*  170 */     int h = this.tama.height;
/*  171 */     int rw = (w - 450) / 2;
/*  172 */     int rh = (h - 300) / 2;
/*  173 */     this.jDialog2.setSize(500, 300);
/*  174 */     this.jDialog2.setLocation(rw, rh);
/*  175 */     this.jDialog2.setResizable(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  181 */     this.jDialog1.setLocationRelativeTo(null);
/*  182 */     this.jDialog1.setSize(900, 535);
/*  183 */     this.jDialog1.setLocation(rw, rh);
/*  184 */     this.jDialog1.setResizable(false);
/*      */     
/*  186 */     rw = (w - 750) / 2;
/*  187 */     rh = (h - 510) / 2;
/*  188 */     this.jDialog3.setLocation(rw, rh);
/*  189 */     this.jDialog3.setSize(750, 510);
/*  190 */     this.jDialog3.setVisible(false);
/*  191 */     this.jDialog3.setResizable(false);
/*      */     
/*  193 */     rw = (w - 270) / 2;
/*  194 */     rh = (h - 180) / 2;
/*  195 */     this.jDialog4.setLocation(rw, rh);
/*  196 */     this.jDialog4.setSize(268, 180);
/*  197 */     this.jDialog4.setVisible(false);
/*  198 */     this.jDialog4.setResizable(false);
/*      */     
/*  200 */     rw = (w - 270) / 2;
/*  201 */     rh = (h - 180) / 2;
/*  202 */     this.jDialog5.setLocation(rw, rh);
/*  203 */     this.jDialog5.setSize(268, 180);
/*  204 */     this.jDialog5.setVisible(false);
/*  205 */     this.jDialog5.setResizable(false);
/*      */     
/*  207 */     rw = (w - 705) / 2;
/*  208 */     rh = (h - 320) / 2;
/*  209 */     this.jDialog6.setLocation(rw, rh);
/*  210 */     this.jDialog6.setSize(705, 320);
/*  211 */     this.jDialog6.setVisible(false);
/*  212 */     this.jDialog6.setResizable(false);
/*      */     
/*  214 */     rw = (w - 300) / 2;
/*  215 */     rh = (h - 350) / 2;
/*  216 */     this.jDialog7.setLocation(rw, rh);
/*  217 */     this.jDialog7.setSize(300, 350);
/*  218 */     this.jDialog7.setVisible(false);
/*  219 */     this.jDialog7.setResizable(false);
/*      */     
/*  221 */     rw = (w - 300) / 2;
/*  222 */     rh = (h - 350) / 2;
/*  223 */     this.jDialog8.setLocation(rw, rh);
/*  224 */     this.jDialog8.setSize(340, 290);
/*  225 */     this.jDialog8.setVisible(false);
/*  226 */     this.jDialog8.setResizable(false);
/*      */     
/*  228 */     rw = (w - 468) / 2;
/*  229 */     rh = (h - 430) / 2;
/*  230 */     this.jDialog9.setLocation(rw, rh);
/*  231 */     this.jDialog9.setSize(468, 430);
/*  232 */     this.jDialog9.setVisible(false);
/*  233 */     this.jDialog9.setResizable(false);
/*      */     
/*  235 */     rw = (w - 390) / 2;
/*  236 */     rh = (h - 230) / 2;
/*  237 */     this.jDialog10.setLocation(rw, rh);
/*  238 */     this.jDialog10.setSize(390, 230);
/*  239 */     this.jDialog10.setVisible(false);
/*  240 */     this.jDialog10.setResizable(false);
/*      */     
/*  242 */     rw = (w - 330) / 2;
/*  243 */     rh = (h - 230) / 2;
/*  244 */     this.jDialog14.setLocation(rw, rh);
/*  245 */     this.jDialog14.setSize(330, 230);
/*  246 */     this.jDialog14.setVisible(false);
/*  247 */     this.jDialog14.setResizable(false);
/*      */     
/*  249 */     w = this.tama.width;
/*  250 */     h = this.tama.height;
/*  251 */     rw = (w - 1145) / 2;
/*  252 */     rh = (h - 600) / 2;
/*  253 */     this.jFrame1.setSize(1145, 600);
/*  254 */     this.jFrame1.setLocation(rw, rh);
/*      */     
/*  256 */     rw = (w - 262) / 2;
/*  257 */     rh = (h - 180) / 2;
/*  258 */     this.jDialog15.setLocation(rw, rh);
/*  259 */     this.jDialog15.setSize(262, 180);
/*  260 */     this.jDialog15.setVisible(false);
/*  261 */     this.jDialog15.setResizable(false);
/*      */     
/*  263 */     w = this.tama.width;
/*  264 */     h = this.tama.height;
/*  265 */     rw = (w - 340) / 2;
/*  266 */     rh = (h - 300) / 2;
/*  267 */     this.jDialog16.setSize(340, 300);
/*  268 */     this.jDialog16.setLocation(rw, rh);
/*  269 */     this.jDialog16.setResizable(false);
/*      */     
/*  271 */     w = this.tama.width;
/*  272 */     h = this.tama.height;
/*  273 */     rw = (w - 320) / 2;
/*  274 */     rh = (h - 410) / 2;
/*  275 */     this.jDialog17.setSize(320, 410);
/*  276 */     this.jDialog17.setLocation(rw, rh);
/*  277 */     this.jDialog17.setResizable(false);
/*      */     
/*  279 */     w = this.tama.width;
/*  280 */     h = this.tama.height;
/*  281 */     rw = (w - 475) / 2;
/*  282 */     rh = (h - 340) / 2;
/*  283 */     this.jDialog18.setSize(475, 340);
/*  284 */     this.jDialog18.setLocation(rw, rh);
/*  285 */     this.jDialog18.setResizable(false);
/*      */     
/*  287 */     w = this.tama.width;
/*  288 */     h = this.tama.height;
/*  289 */     rw = (w - 450) / 2;
/*  290 */     rh = (h - 372) / 2;
/*  291 */     this.jDialog19.setSize(450, 372);
/*  292 */     this.jDialog19.setLocation(rw, rh);
/*  293 */     this.jDialog19.setResizable(false);
/*      */     
/*  295 */     w = this.tama.width;
/*  296 */     h = this.tama.height;
/*  297 */     rw = (w - 300) / 2;
/*  298 */     rh = (h - 170) / 2;
/*  299 */     this.jDialog20.setSize(300, 170);
/*  300 */     this.jDialog20.setLocation(rw, rh);
/*  301 */     this.jDialog20.setResizable(false);
/*      */     
/*  303 */     rw = (w - 300) / 2;
/*  304 */     rh = (h - 180) / 2;
/*  305 */     this.jDialog21.setSize(300, 180);
/*  306 */     this.jDialog21.setLocation(rw, rh);
/*  307 */     this.jDialog21.setResizable(false);
/*  308 */     this.jFrame2.setSize(950, 500);
/*      */     
/*  310 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  311 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  312 */     this.jFrame2.setCursor(micursor);
/*  313 */     this.jDialog2.setCursor(micursor);
/*  314 */     this.jDialog3.setCursor(micursor);
/*  315 */     this.jDialog4.setCursor(micursor);
/*  316 */     this.jDialog5.setCursor(micursor);
/*  317 */     this.jDialog7.setCursor(micursor);
/*  318 */     this.jDialog6.setCursor(micursor);
/*  319 */     this.jDialog8.setCursor(micursor);
/*  320 */     this.jDialog9.setCursor(micursor);
/*  321 */     this.jDialog10.setCursor(micursor);
/*  322 */     this.jDialog16.setCursor(micursor);
/*  323 */     this.jDialog17.setCursor(micursor);
/*  324 */     this.jDialog18.setCursor(micursor);
/*  325 */     this.jDialog19.setCursor(micursor);
/*  326 */     this.jDialog20.setCursor(micursor);
/*  327 */     this.jDialog21.setCursor(micursor);
/*  328 */     this.jFrame1.setCursor(micursor);
/*      */     
/*  330 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  331 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  332 */     this.jLabel37.setCursor(micursor);
/*  333 */     this.jLabel38.setCursor(micursor);
/*  334 */     this.jLabel39.setCursor(micursor);
/*  335 */     this.jLabel24.setCursor(micursor);
/*  336 */     this.jLabel51.setCursor(micursor);
/*  337 */     this.jLabel69.setCursor(micursor);
/*  338 */     this.jLabel23.setCursor(micursor);
/*      */     
/*  340 */     colorear();
/*  341 */     llenarCombos();
/*  342 */     sacarDepa();
/*  343 */     consultarViajes();
/*  344 */     consultarTarifas();
/*  345 */     consultar();
/*      */     
/*  347 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance(Locale.US);
/*  348 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  349 */     editFormat.setGroupingUsed(false);
/*  350 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  351 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  352 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  353 */     enFormat.setAllowsInvalid(true);
/*  354 */     this.cantidad.setFormatterFactory(currFactory);
/*  355 */     this.cuadroPrecio.setFormatterFactory(currFactory);
/*  356 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  357 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  358 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  359 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  360 */     this.jFormattedTextField5.setFormatterFactory(currFactory);
/*  361 */     this.jFormattedTextField7.setFormatterFactory(currFactory);
/*  362 */     this.jFormattedTextField10.setFormatterFactory(currFactory);
/*  363 */     this.jFormattedTextField11.setFormatterFactory(currFactory);
/*  364 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  365 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/*  366 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/*  367 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*  368 */     this.jFormattedTextField11.setValue(Integer.valueOf(0));
/*  369 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/*  370 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  371 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  372 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*      */     
/*  374 */     privilegios();
/*  375 */     verHistorial();
/*      */     
/*  377 */     this.buttonGroup1.add(this.jRadioButton1);
/*  378 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  380 */     this.buttonGroup3.add(this.jRadioButton5);
/*  381 */     this.buttonGroup3.add(this.jRadioButton6);
/*      */     
/*  383 */     this.buttonGroup4.add(this.jRadioButton7);
/*  384 */     this.buttonGroup4.add(this.jRadioButton8);
/*  385 */     this.buttonGroup4.add(this.jRadioButton9);
/*  386 */     this.buttonGroup4.add(this.jRadioButton10);
/*      */     
/*  388 */     this.buttonGroup5.add(this.jRadioButton3);
/*  389 */     this.buttonGroup5.add(this.jRadioButton4);
/*      */     
/*  391 */     this.jTable12.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*  392 */     this.jTable12.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */     
/*  394 */     this.con.consultar("sucursal", "configuraciones", "");
/*  395 */     this.base = this.con.Campo;
/*      */   }
/*      */   private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9;
/*      */   
/*      */   private void initComponents() {
/*  400 */     this.jDialog2 = new CerrarVentana(this.jFrame2);
/*  401 */     this.jPanel3 = new JPanel();
/*  402 */     this.jLabel9 = new JLabel();
/*  403 */     this.jSeparator4 = new JSeparator();
/*  404 */     this.jButton5 = new JButton();
/*  405 */     this.jScrollPane4 = new JScrollPane();
/*  406 */     this.jTable4 = new JTable();
/*  407 */     this.jButton7 = new JButton();
/*  408 */     this.jLabel68 = new JLabel();
/*  409 */     this.jComboBox8 = new JComboBox();
/*  410 */     this.jFrame1 = new JFrame();
/*  411 */     this.jPanel50 = new JPanel();
/*  412 */     this.jPanel24 = new JPanel();
/*  413 */     this.jPanel27 = new JPanel();
/*  414 */     this.jPanel32 = new JPanel();
/*  415 */     this.jLabel10 = new JLabel();
/*  416 */     this.jComboBox11 = new JComboBox();
/*  417 */     this.jLabel14 = new JLabel();
/*  418 */     this.jTextField11 = new JTextField();
/*  419 */     this.jLabel12 = new JLabel();
/*  420 */     this.jTextField12 = new JTextField();
/*  421 */     this.jLabel13 = new JLabel();
/*  422 */     this.jTextField3 = new JTextField();
/*  423 */     this.jLabel17 = new JLabel();
/*  424 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  425 */     this.jPanel52 = new JPanel();
/*  426 */     this.jPanel53 = new JPanel();
/*  427 */     this.jButton49 = new JButton();
/*  428 */     this.jButton46 = new JButton();
/*  429 */     this.jLabel19 = new JLabel();
/*  430 */     this.jScrollPane5 = new JScrollPane();
/*  431 */     this.jTable5 = new JTable();
/*  432 */     this.jPanel54 = new JPanel();
/*  433 */     this.jPanel55 = new JPanel();
/*  434 */     this.jButton48 = new JButton();
/*  435 */     this.jButton52 = new JButton();
/*  436 */     this.jLabel91 = new JLabel();
/*  437 */     this.jScrollPane14 = new JScrollPane();
/*  438 */     this.jTable12 = new JTable();
/*  439 */     this.jPanel60 = new JPanel();
/*  440 */     this.jPanel56 = new JPanel();
/*  441 */     this.jScrollPane7 = new JScrollPane();
/*  442 */     this.jTextPane1 = new JTextPane();
/*  443 */     this.jLabel16 = new JLabel();
/*  444 */     this.jPanel57 = new JPanel();
/*  445 */     this.jPanel61 = new JPanel();
/*  446 */     this.jLabel63 = new JLabel();
/*  447 */     this.jScrollPane16 = new JScrollPane();
/*  448 */     this.jTextArea3 = new JTextArea();
/*  449 */     this.jPanel59 = new JPanel();
/*  450 */     this.jPanel48 = new JPanel();
/*  451 */     this.jButton8 = new JButton();
/*  452 */     this.jLabel69 = new JLabel();
/*  453 */     this.jButton9 = new JButton();
/*  454 */     this.jPanel58 = new JPanel();
/*  455 */     this.jPanel6 = new JPanel();
/*  456 */     this.jLabel20 = new JLabel();
/*  457 */     this.jLabel21 = new JLabel();
/*  458 */     this.jLabel22 = new JLabel();
/*  459 */     this.jLabel23 = new JLabel();
/*  460 */     this.jLabel24 = new JLabel();
/*  461 */     this.jLabel25 = new JLabel();
/*  462 */     this.jSeparator6 = new JSeparator();
/*  463 */     this.jLabel26 = new JLabel();
/*  464 */     this.jLabel27 = new JLabel();
/*  465 */     this.jLabel70 = new JLabel();
/*  466 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  467 */     this.jPanel9 = new JPanel();
/*  468 */     this.jScrollPane6 = new JScrollPane();
/*  469 */     this.jTable6 = new JTable();
/*  470 */     this.jFrame2 = new JFrame();
/*  471 */     this.jPanel20 = new JPanel();
/*  472 */     this.jPanel21 = new JPanel();
/*  473 */     this.jLabel5 = new JLabel();
/*  474 */     this.jPanel35 = new JPanel();
/*  475 */     this.jPanel37 = new JPanel();
/*  476 */     this.jLabel6 = new JLabel();
/*  477 */     this.jPanel38 = new JPanel();
/*  478 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  479 */     this.jLabel7 = new JLabel();
/*  480 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  481 */     this.jPanel39 = new JPanel();
/*  482 */     this.jButton28 = new JButton();
/*  483 */     this.jPanel41 = new JPanel();
/*  484 */     this.jLabel37 = new JLabel();
/*  485 */     this.jLabel38 = new JLabel();
/*  486 */     this.jLabel39 = new JLabel();
/*  487 */     this.jSeparator20 = new JSeparator();
/*  488 */     this.jPanel40 = new JPanel();
/*  489 */     this.jComboBox1 = new JComboBox();
/*  490 */     this.jComboBox9 = new JComboBox();
/*  491 */     this.jComboBox2 = new JComboBox();
/*  492 */     this.jComboBox3 = new JComboBox();
/*  493 */     this.jComboBox6 = new JComboBox();
/*  494 */     this.jComboBox7 = new JComboBox();
/*  495 */     this.jTextField1 = new JTextField();
/*  496 */     this.jTextField2 = new JTextField();
/*  497 */     this.jLabel46 = new JLabel();
/*  498 */     this.jLabel57 = new JLabel();
/*  499 */     this.jLabel47 = new JLabel();
/*  500 */     this.jLabel49 = new JLabel();
/*  501 */     this.jLabel64 = new JLabel();
/*  502 */     this.jLabel65 = new JLabel();
/*  503 */     this.jLabel15 = new JLabel();
/*  504 */     this.jLabel62 = new JLabel();
/*  505 */     this.jPanel18 = new JPanel();
/*  506 */     this.jScrollPane2 = new JScrollPane();
/*  507 */     this.jTable2 = new JTable();
/*  508 */     this.jButton4 = new JButton();
/*  509 */     this.jButton12 = new JButton();
/*  510 */     this.jButton29 = new JButton();
/*  511 */     this.jButton30 = new JButton();
/*  512 */     this.jPanel46 = new JPanel();
/*  513 */     this.jLabel8 = new JLabel();
/*  514 */     this.jLabel61 = new JLabel();
/*  515 */     this.jLabel66 = new JLabel();
/*  516 */     this.jLabel67 = new JLabel();
/*  517 */     this.jLabel48 = new JLabel();
/*  518 */     this.jButton13 = new JButton();
/*  519 */     this.jButton38 = new JButton();
/*  520 */     this.jButton40 = new JButton();
/*  521 */     this.cantidad = new JFormattedTextField();
/*  522 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  523 */     this.jPanel12 = new JPanel();
/*  524 */     this.jLabel89 = new JLabel();
/*  525 */     this.jSeparator7 = new JSeparator();
/*  526 */     this.jLabel29 = new JLabel();
/*  527 */     this.jLabel30 = new JLabel();
/*  528 */     this.jLabel31 = new JLabel();
/*  529 */     this.jLabel32 = new JLabel();
/*  530 */     this.jLabel33 = new JLabel();
/*  531 */     this.jScrollPane8 = new JScrollPane();
/*  532 */     this.jTextArea1 = new JTextArea();
/*  533 */     this.jLabel52 = new JLabel();
/*  534 */     this.jLabel51 = new JLabel();
/*  535 */     this.jLabel53 = new JLabel();
/*  536 */     this.jLabel98 = new JLabel();
/*  537 */     this.jLabel99 = new JLabel();
/*  538 */     this.jDialog4 = new CerrarVentana(this.jFrame1);
/*  539 */     this.jPanel10 = new JPanel();
/*  540 */     this.jLabel34 = new JLabel();
/*  541 */     this.jSeparator8 = new JSeparator();
/*  542 */     this.jLabel35 = new JLabel();
/*  543 */     this.jTextField4 = new JTextField();
/*  544 */     this.jSeparator9 = new JSeparator();
/*  545 */     this.jButton14 = new JButton();
/*  546 */     this.jButton15 = new JButton();
/*  547 */     this.jDialog5 = new CerrarVentana(this.jFrame1);
/*  548 */     this.jPanel11 = new JPanel();
/*  549 */     this.jLabel36 = new JLabel();
/*  550 */     this.jSeparator10 = new JSeparator();
/*  551 */     this.jLabel40 = new JLabel();
/*  552 */     this.jTextField5 = new JTextField();
/*  553 */     this.jSeparator11 = new JSeparator();
/*  554 */     this.jButton16 = new JButton();
/*  555 */     this.jButton17 = new JButton();
/*  556 */     this.jDialog6 = new CerrarVentana(this.jFrame1);
/*  557 */     this.jPanel13 = new JPanel();
/*  558 */     this.jLabel41 = new JLabel();
/*  559 */     this.jSeparator12 = new JSeparator();
/*  560 */     this.jSeparator13 = new JSeparator();
/*  561 */     this.jButton18 = new JButton();
/*  562 */     this.jButton19 = new JButton();
/*  563 */     this.jScrollPane9 = new JScrollPane();
/*  564 */     this.jTable7 = new JTable();
/*  565 */     this.jLabel42 = new JLabel();
/*  566 */     this.jComboBox4 = new JComboBox();
/*  567 */     this.jButton41 = new JButton();
/*  568 */     this.jDialog7 = new CerrarVentana(this.jFrame2);
/*  569 */     this.jPanel14 = new JPanel();
/*  570 */     this.jLabel43 = new JLabel();
/*  571 */     this.jSeparator14 = new JSeparator();
/*  572 */     this.jScrollPane10 = new JScrollPane();
/*  573 */     this.jTable8 = new JTable();
/*  574 */     this.jButton20 = new JButton();
/*  575 */     this.jButton21 = new JButton();
/*  576 */     this.jPanel15 = new JPanel();
/*  577 */     this.jLabel45 = new JLabel();
/*  578 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  579 */     this.jDialog8 = new CerrarVentana(this.jFrame1);
/*  580 */     this.jPanel16 = new JPanel();
/*  581 */     this.jLabel50 = new JLabel();
/*  582 */     this.jSeparator15 = new JSeparator();
/*  583 */     this.jButton22 = new JButton();
/*  584 */     this.jButton23 = new JButton();
/*  585 */     this.jRadioButton1 = new JRadioButton();
/*  586 */     this.jComboBox5 = new JComboBox();
/*  587 */     this.jRadioButton2 = new JRadioButton();
/*  588 */     this.jTextField6 = new JTextField();
/*  589 */     this.jSeparator16 = new JSeparator();
/*  590 */     this.buttonGroup1 = new ButtonGroup();
/*  591 */     this.jDialog9 = new CerrarVentana(this.jFrame1);
/*  592 */     this.jPanel19 = new JPanel();
/*  593 */     this.jLabel54 = new JLabel();
/*  594 */     this.jSeparator17 = new JSeparator();
/*  595 */     this.jButton24 = new JButton();
/*  596 */     this.jLabel55 = new JLabel();
/*  597 */     this.jLabel56 = new JLabel();
/*  598 */     this.jSeparator18 = new JSeparator();
/*  599 */     this.jScrollPane11 = new JScrollPane();
/*  600 */     this.jTable9 = new JTable();
/*  601 */     this.jButton25 = new JButton();
/*  602 */     this.jSpinner1 = new JSpinner();
/*  603 */     this.jTextField8 = new JTextField();
/*  604 */     this.jLabel58 = new JLabel();
/*  605 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  606 */     this.jLabel59 = new JLabel();
/*  607 */     this.jLabel60 = new JLabel();
/*  608 */     this.jSeparator19 = new JSeparator();
/*  609 */     this.jButton26 = new JButton();
/*  610 */     this.jDialog10 = new CerrarVentana(this.jFrame2);
/*  611 */     this.jPanel29 = new JPanel();
/*  612 */     this.jLabel124 = new JLabel();
/*  613 */     this.jSeparator27 = new JSeparator();
/*  614 */     this.jLabel125 = new JLabel();
/*  615 */     this.jButton44 = new JButton();
/*  616 */     this.jButton45 = new JButton();
/*  617 */     this.jScrollPane18 = new JScrollPane();
/*  618 */     this.jTextArea5 = new JTextArea();
/*  619 */     this.jLabel126 = new JLabel();
/*  620 */     this.buttonGroup2 = new ButtonGroup();
/*  621 */     this.jPanel30 = new JPanel();
/*  622 */     this.jScrollPane13 = new JScrollPane();
/*  623 */     this.jTable11 = new JTable();
/*  624 */     this.jDialog14 = new CerrarVentana(this.padre);
/*  625 */     this.jPanel26 = new JPanel();
/*  626 */     this.jLabel94 = new JLabel();
/*  627 */     this.jTextField39 = new JTextField();
/*  628 */     this.jLabel95 = new JLabel();
/*  629 */     this.jTextField40 = new JTextField();
/*  630 */     this.jLabel96 = new JLabel();
/*  631 */     this.jTextField41 = new JTextField();
/*  632 */     this.jLabel97 = new JLabel();
/*  633 */     this.jTextField42 = new JTextField();
/*  634 */     this.jButton39 = new JButton();
/*  635 */     this.jDialog15 = new CerrarVentana(this.jFrame1);
/*  636 */     this.jPanel34 = new JPanel();
/*  637 */     this.jLabel88 = new JLabel();
/*  638 */     this.jSeparator21 = new JSeparator();
/*  639 */     this.jLabel90 = new JLabel();
/*  640 */     this.jSeparator22 = new JSeparator();
/*  641 */     this.jButton42 = new JButton();
/*  642 */     this.jButton43 = new JButton();
/*  643 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  644 */     this.jDialog16 = new CerrarVentana(this.jFrame2);
/*  645 */     this.jPanel42 = new JPanel();
/*  646 */     this.jLabel92 = new JLabel();
/*  647 */     this.jSeparator29 = new JSeparator();
/*  648 */     this.jRadioButton5 = new JRadioButton();
/*  649 */     this.jLabel93 = new JLabel();
/*  650 */     this.jRadioButton6 = new JRadioButton();
/*  651 */     this.jLabel100 = new JLabel();
/*  652 */     this.jSeparator30 = new JSeparator();
/*  653 */     this.jButton50 = new JButton();
/*  654 */     this.jButton51 = new JButton();
/*  655 */     this.buttonGroup3 = new ButtonGroup();
/*  656 */     this.jDialog17 = new CerrarVentana(this.jFrame1);
/*  657 */     this.jPanel36 = new JPanel();
/*  658 */     this.jLabel122 = new JLabel();
/*  659 */     this.jSeparator31 = new JSeparator();
/*  660 */     this.jSeparator32 = new JSeparator();
/*  661 */     this.jButton53 = new JButton();
/*  662 */     this.jScrollPane15 = new JScrollPane();
/*  663 */     this.jTable13 = new JTable();
/*  664 */     this.jTextField29 = new JTextField();
/*  665 */     this.jButton54 = new JButton();
/*  666 */     this.jLabel11 = new JLabel();
/*  667 */     this.jDialog18 = new CerrarVentana(this.jFrame1);
/*  668 */     this.jPanel43 = new JPanel();
/*  669 */     this.jLabel101 = new JLabel();
/*  670 */     this.jSeparator33 = new JSeparator();
/*  671 */     this.jLabel102 = new JLabel();
/*  672 */     this.jLabel103 = new JLabel();
/*  673 */     this.jSeparator34 = new JSeparator();
/*  674 */     this.jButton55 = new JButton();
/*  675 */     this.jSpinner2 = new JSpinner();
/*  676 */     this.jLabel104 = new JLabel();
/*  677 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  678 */     this.jScrollPane17 = new JScrollPane();
/*  679 */     this.jTextArea2 = new JTextArea();
/*  680 */     this.jButton56 = new JButton();
/*  681 */     this.jLabel130 = new JLabel();
/*  682 */     this.jFormattedTextField11 = new JFormattedTextField();
/*  683 */     this.jDialog19 = new CerrarVentana(this.jFrame1);
/*  684 */     this.jPanel22 = new JPanel();
/*  685 */     this.jLabel44 = new JLabel();
/*  686 */     this.jPanel5 = new JPanel();
/*  687 */     this.jRadioButton8 = new JRadioButton();
/*  688 */     this.jLabel106 = new JLabel();
/*  689 */     this.jPanel8 = new JPanel();
/*  690 */     this.jRadioButton7 = new JRadioButton();
/*  691 */     this.jLabel105 = new JLabel();
/*  692 */     this.jPanel23 = new JPanel();
/*  693 */     this.jRadioButton9 = new JRadioButton();
/*  694 */     this.jLabel123 = new JLabel();
/*  695 */     this.jPanel25 = new JPanel();
/*  696 */     this.jRadioButton10 = new JRadioButton();
/*  697 */     this.jLabel128 = new JLabel();
/*  698 */     this.jPanel28 = new JPanel();
/*  699 */     this.jFormattedTextField10 = new JFormattedTextField();
/*  700 */     this.jPanel31 = new JPanel();
/*  701 */     this.jPanel33 = new JPanel();
/*  702 */     this.jButton57 = new JButton();
/*  703 */     this.jButton47 = new JButton();
/*  704 */     this.jSeparator5 = new JSeparator();
/*  705 */     this.buttonGroup4 = new ButtonGroup();
/*  706 */     this.jDialog20 = new CerrarVentana(this.jFrame2);
/*  707 */     this.jPanel45 = new JPanel();
/*  708 */     this.jLabel131 = new JLabel();
/*  709 */     this.jSeparator37 = new JSeparator();
/*  710 */     this.jSeparator38 = new JSeparator();
/*  711 */     this.jButton58 = new JButton();
/*  712 */     this.jButton59 = new JButton();
/*  713 */     this.jLabel140 = new JLabel();
/*  714 */     this.jTextField30 = new JTextField();
/*  715 */     this.jButton10 = new JButton();
/*  716 */     this.jButton11 = new JButton();
/*  717 */     this.jPanel4 = new JPanel();
/*  718 */     this.jLabel3 = new JLabel();
/*  719 */     this.jComboBox10 = new JComboBox<>();
/*  720 */     this.jLabel18 = new JLabel();
/*  721 */     this.jDialog21 = new CerrarVentana(this.jFrame2);
/*  722 */     this.jPanel2 = new JPanel();
/*  723 */     this.jPanel17 = new JPanel();
/*  724 */     this.jRadioButton3 = new JRadioButton();
/*  725 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  726 */     this.jRadioButton4 = new JRadioButton();
/*  727 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  728 */     this.jButton27 = new JButton();
/*  729 */     this.buttonGroup5 = new ButtonGroup();
/*  730 */     this.jDialog1 = new CerrarVentana(this.jFrame1);
/*  731 */     this.jPanel44 = new JPanel();
/*  732 */     this.jPanel47 = new JPanel();
/*  733 */     this.jPanel49 = new JPanel();
/*  734 */     this.jLabel71 = new JLabel();
/*  735 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  736 */     this.jLabel72 = new JLabel();
/*  737 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  738 */     this.jButton31 = new JButton();
/*  739 */     this.jPanel51 = new JPanel();
/*  740 */     this.jPanel62 = new JPanel();
/*  741 */     this.jLabel73 = new JLabel();
/*  742 */     this.jTextField7 = new JTextField();
/*  743 */     this.jLabel74 = new JLabel();
/*  744 */     this.jComboBox20 = new JComboBox();
/*  745 */     this.jLabel75 = new JLabel();
/*  746 */     this.jComboBox12 = new JComboBox();
/*  747 */     this.jLabel76 = new JLabel();
/*  748 */     this.jComboBox13 = new JComboBox();
/*  749 */     this.jLabel77 = new JLabel();
/*  750 */     this.jComboBox14 = new JComboBox();
/*  751 */     this.jLabel78 = new JLabel();
/*  752 */     this.jComboBox15 = new JComboBox();
/*  753 */     this.jLabel79 = new JLabel();
/*  754 */     this.jComboBox16 = new JComboBox();
/*  755 */     this.jLabel80 = new JLabel();
/*  756 */     this.jComboBox17 = new JComboBox();
/*  757 */     this.jLabel81 = new JLabel();
/*  758 */     this.jTextField9 = new JTextField();
/*  759 */     this.jScrollPane12 = new JScrollPane();
/*  760 */     this.jTable10 = new JTable();
/*  761 */     this.jLabel82 = new JLabel();
/*  762 */     this.jButton32 = new JButton();
/*  763 */     this.jPanel7 = new JPanel();
/*  764 */     this.jLabel4 = new JLabel();
/*  765 */     this.jSeparator1 = new JSeparator();
/*  766 */     this.jPanel1 = new JPanel();
/*  767 */     this.jLabel1 = new JLabel();
/*  768 */     this.jScrollPane1 = new JScrollPane();
/*  769 */     this.jTable1 = new JTable();
/*  770 */     this.jButton1 = new JButton();
/*  771 */     this.jButton2 = new JButton();
/*  772 */     this.jButton3 = new JButton();
/*  773 */     this.jSeparator2 = new JSeparator();
/*  774 */     this.jLabel2 = new JLabel();
/*  775 */     this.jScrollPane3 = new JScrollPane();
/*  776 */     this.jTable3 = new JTable();
/*  777 */     this.jButton6 = new JButton();
/*  778 */     this.jLabel28 = new JLabel();
/*      */     
/*  780 */     this.jDialog2.setTitle("Selecciona el reporte interno");
/*      */     
/*  782 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  784 */     this.jLabel9.setFont(new Font("Times New Roman", 1, 14));
/*  785 */     this.jLabel9.setHorizontalAlignment(0);
/*  786 */     this.jLabel9.setText("Reporte Interno");
/*      */     
/*  788 */     this.jButton5.setMnemonic('C');
/*  789 */     this.jButton5.setText("<<Atrás");
/*  790 */     this.jButton5.setToolTipText("Cancelar (Alt+C)");
/*  791 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  793 */             PrefacturaCliente.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  797 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  798 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  806 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  811 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  814 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  816 */             PrefacturaCliente.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/*  819 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/*  821 */     this.jButton7.setMnemonic('A');
/*  822 */     this.jButton7.setText("Siguiente>>");
/*  823 */     this.jButton7.setToolTipText("Aceptar (Alt+A)");
/*  824 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  826 */             PrefacturaCliente.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  830 */     this.jLabel68.setText("Estatus");
/*      */     
/*  832 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  833 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "Pendientes", "Cerradas", "Todas" }));
/*  834 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  836 */             PrefacturaCliente.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  840 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  841 */     this.jPanel3.setLayout(jPanel3Layout);
/*  842 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  843 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  844 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  845 */           .addContainerGap()
/*  846 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */             .addComponent(this.jScrollPane4, -1, 424, 32767)
/*  848 */             .addComponent(this.jLabel9, -1, 424, 32767)
/*  849 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING, -1, 424, 32767)
/*  850 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  851 */               .addComponent(this.jLabel68, -2, 58, -2)
/*  852 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  853 */               .addComponent(this.jComboBox8, -2, 113, -2)
/*  854 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767)
/*  855 */               .addComponent(this.jButton5, -2, 101, -2)
/*  856 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  857 */               .addComponent(this.jButton7, -2, 101, -2)))
/*  858 */           .addContainerGap()));
/*      */     
/*  860 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  862 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  863 */           .addContainerGap()
/*  864 */           .addComponent(this.jLabel9)
/*  865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  866 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  867 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  868 */           .addComponent(this.jScrollPane4, -2, 179, -2)
/*  869 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  870 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  871 */             .addComponent(this.jLabel68)
/*  872 */             .addComponent(this.jComboBox8, -2, -1, -2)
/*  873 */             .addComponent(this.jButton7)
/*  874 */             .addComponent(this.jButton5))
/*  875 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  878 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  879 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  880 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  881 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  882 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  884 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  886 */         .addComponent(this.jPanel3, -2, -1, -2));
/*      */ 
/*      */     
/*  889 */     this.jFrame1.setTitle("Prefactura para el cliente");
/*  890 */     this.jFrame1.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  892 */             PrefacturaCliente.this.jFrame1WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  896 */     this.jPanel50.setBackground(Color.white);
/*      */     
/*  898 */     this.jPanel24.setBackground(Color.white);
/*  899 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder("Datos generales"));
/*  900 */     this.jPanel24.setMaximumSize(new Dimension(567, 27));
/*  901 */     this.jPanel24.setLayout(new GridLayout(1, 0));
/*      */     
/*  903 */     this.jPanel27.setMaximumSize(new Dimension(567, 200));
/*  904 */     this.jPanel27.setLayout(new GridLayout(1, 10, 6, 0));
/*      */     
/*  906 */     this.jPanel32.setBackground(Color.white);
/*  907 */     this.jPanel32.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  909 */     this.jLabel10.setFont(new Font("Cantarell", 1, 13));
/*  910 */     this.jLabel10.setHorizontalAlignment(4);
/*  911 */     this.jLabel10.setText("Cliente:");
/*  912 */     this.jPanel32.add(this.jLabel10);
/*      */     
/*  914 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/*  915 */     this.jComboBox11.setFont(new Font("Tahoma", 0, 10));
/*  916 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  917 */     this.jComboBox11.setMaximumSize(new Dimension(67, 25));
/*  918 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  920 */             PrefacturaCliente.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/*  923 */     this.jPanel32.add(this.jComboBox11);
/*      */     
/*  925 */     this.jLabel14.setFont(new Font("Cantarell", 0, 13));
/*  926 */     this.jLabel14.setHorizontalAlignment(4);
/*  927 */     this.jLabel14.setText(" Equipo:");
/*  928 */     this.jPanel32.add(this.jLabel14);
/*  929 */     this.jPanel32.add(this.jTextField11);
/*      */     
/*  931 */     this.jLabel12.setFont(new Font("Cantarell", 0, 13));
/*  932 */     this.jLabel12.setHorizontalAlignment(4);
/*  933 */     this.jLabel12.setText(" Pozo:");
/*  934 */     this.jPanel32.add(this.jLabel12);
/*  935 */     this.jPanel32.add(this.jTextField12);
/*      */     
/*  937 */     this.jLabel13.setHorizontalAlignment(4);
/*  938 */     this.jLabel13.setText("Su pedido:");
/*  939 */     this.jPanel32.add(this.jLabel13);
/*  940 */     this.jPanel32.add(this.jTextField3);
/*      */     
/*  942 */     this.jLabel17.setFont(new Font("Cantarell", 1, 13));
/*  943 */     this.jLabel17.setHorizontalAlignment(4);
/*  944 */     this.jLabel17.setText("Fecha:");
/*  945 */     this.jPanel32.add(this.jLabel17);
/*      */     
/*  947 */     this.jDateChooser4.setDate(this.fechaActual);
/*  948 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/*  949 */     this.jDateChooser4.setIcon(this.icon);
/*  950 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  951 */     this.jDateChooser4.setMinSelectableDate(new Date(1257058862000L));
/*  952 */     this.jPanel32.add((Component)this.jDateChooser4);
/*      */     
/*  954 */     this.jPanel27.add(this.jPanel32);
/*      */     
/*  956 */     this.jPanel24.add(this.jPanel27);
/*      */     
/*  958 */     this.jPanel52.setBackground(Color.white);
/*  959 */     this.jPanel52.setBorder(BorderFactory.createTitledBorder("Listado de viajes"));
/*      */     
/*  961 */     this.jPanel53.setBackground(Color.white);
/*      */     
/*  963 */     this.jButton49.setText("Quitar Guía");
/*  964 */     this.jButton49.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  966 */             PrefacturaCliente.this.jButton49ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  970 */     this.jButton46.setText("Agregar Guía");
/*  971 */     this.jButton46.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  973 */             PrefacturaCliente.this.jButton46ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  977 */     this.jLabel19.setFont(new Font("Tahoma", 2, 11));
/*  978 */     this.jLabel19.setText("/*Ésta es la lista de todos los viajes con precios.*/        /*Doble clic sobre el contenido de las columnas para actualizar la información*/");
/*      */     
/*  980 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/*  981 */     this.jPanel53.setLayout(jPanel53Layout);
/*  982 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/*  983 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  984 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/*  985 */           .addComponent(this.jLabel19, -2, 1, 32767)
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */           .addComponent(this.jButton46, -2, 137, -2)
/*  988 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */           .addComponent(this.jButton49, -2, 137, -2)));
/*      */     
/*  991 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/*  992 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  993 */         .addGroup(jPanel53Layout.createSequentialGroup()
/*  994 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  995 */             .addComponent(this.jButton49)
/*  996 */             .addComponent(this.jButton46)
/*  997 */             .addComponent(this.jLabel19))
/*  998 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1001 */     this.jTable5.setFont(new Font("Tahoma", 0, 10));
/* 1002 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[0]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1010 */     this.jTable5.setColumnSelectionAllowed(true);
/* 1011 */     this.jTable5.setSelectionMode(0);
/* 1012 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 1013 */     this.jTable5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1015 */             PrefacturaCliente.this.jTable5MouseClicked(evt);
/*      */           }
/*      */         });
/* 1018 */     this.jTable5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1020 */             PrefacturaCliente.this.jTable5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1023 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 1024 */     this.jTable5.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/* 1026 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 1027 */     this.jPanel52.setLayout(jPanel52Layout);
/* 1028 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 1029 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1030 */         .addComponent(this.jPanel53, -1, -1, 32767)
/* 1031 */         .addComponent(this.jScrollPane5));
/*      */     
/* 1033 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 1034 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1035 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 1036 */           .addComponent(this.jPanel53, -2, -1, -2)
/* 1037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1038 */           .addComponent(this.jScrollPane5, -1, 49, 32767)
/* 1039 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1042 */     this.jPanel54.setBackground(Color.white);
/* 1043 */     this.jPanel54.setBorder(BorderFactory.createTitledBorder("Otros conceptos"));
/* 1044 */     this.jPanel54.setMaximumSize(new Dimension(302, 180));
/* 1045 */     this.jPanel54.setPreferredSize(new Dimension(462, 180));
/*      */     
/* 1047 */     this.jPanel55.setBackground(Color.white);
/*      */     
/* 1049 */     this.jButton48.setText("Agregar Concepto");
/* 1050 */     this.jButton48.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1052 */             PrefacturaCliente.this.jButton48ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1056 */     this.jButton52.setText("Quitar Concepto");
/* 1057 */     this.jButton52.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1059 */             PrefacturaCliente.this.jButton52ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1063 */     this.jLabel91.setFont(new Font("Tahoma", 2, 11));
/* 1064 */     this.jLabel91.setText("/*Ingresa otros conceptos como tiempos de espera, movimientos laterales, movimientos internos, entre otros.*/");
/*      */     
/* 1066 */     GroupLayout jPanel55Layout = new GroupLayout(this.jPanel55);
/* 1067 */     this.jPanel55.setLayout(jPanel55Layout);
/* 1068 */     jPanel55Layout.setHorizontalGroup(jPanel55Layout
/* 1069 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1070 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
/* 1071 */           .addComponent(this.jLabel91, -2, 1, 32767)
/* 1072 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1073 */           .addComponent(this.jButton48, -2, 137, -2)
/* 1074 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */           .addComponent(this.jButton52, -2, 137, -2)));
/*      */     
/* 1077 */     jPanel55Layout.setVerticalGroup(jPanel55Layout
/* 1078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1079 */         .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1080 */           .addComponent(this.jButton52)
/* 1081 */           .addComponent(this.jButton48)
/* 1082 */           .addComponent(this.jLabel91)));
/*      */ 
/*      */     
/* 1085 */     this.jTable12.setFont(new Font("Tahoma", 0, 10));
/* 1086 */     this.jTable12.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Concepto", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1094 */           boolean[] canEdit = new boolean[] { false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1099 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1102 */     this.jScrollPane14.setViewportView(this.jTable12);
/* 1103 */     if (this.jTable12.getColumnModel().getColumnCount() > 0) {
/* 1104 */       this.jTable12.getColumnModel().getColumn(0).setMinWidth(60);
/* 1105 */       this.jTable12.getColumnModel().getColumn(0).setMaxWidth(60);
/* 1106 */       this.jTable12.getColumnModel().getColumn(2).setMinWidth(90);
/* 1107 */       this.jTable12.getColumnModel().getColumn(2).setMaxWidth(90);
/* 1108 */       this.jTable12.getColumnModel().getColumn(3).setMinWidth(90);
/* 1109 */       this.jTable12.getColumnModel().getColumn(3).setMaxWidth(90);
/*      */     } 
/*      */     
/* 1112 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/* 1113 */     this.jPanel54.setLayout(jPanel54Layout);
/* 1114 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/* 1115 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1116 */         .addComponent(this.jPanel55, -1, -1, 32767)
/* 1117 */         .addComponent(this.jScrollPane14));
/*      */     
/* 1119 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/* 1120 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1121 */         .addGroup(jPanel54Layout.createSequentialGroup()
/* 1122 */           .addComponent(this.jPanel55, -2, -1, -2)
/* 1123 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1124 */           .addComponent(this.jScrollPane14, -1, 132, 32767)));
/*      */ 
/*      */     
/* 1127 */     this.jPanel60.setBackground(Color.white);
/* 1128 */     this.jPanel60.setBorder(BorderFactory.createTitledBorder("Resumen"));
/* 1129 */     this.jPanel60.setMaximumSize(new Dimension(567, 10));
/* 1130 */     this.jPanel60.setPreferredSize(new Dimension(628, 10));
/* 1131 */     this.jPanel60.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 1133 */     this.jPanel56.setBackground(Color.white);
/*      */     
/* 1135 */     this.jTextPane1.setEditable(false);
/* 1136 */     this.jTextPane1.setFont(new Font("Times New Roman", 0, 11));
/* 1137 */     this.jScrollPane7.setViewportView(this.jTextPane1);
/*      */     
/* 1139 */     this.jLabel16.setText("Totales:");
/*      */     
/* 1141 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/* 1142 */     this.jPanel56.setLayout(jPanel56Layout);
/* 1143 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/* 1144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1145 */         .addComponent(this.jScrollPane7, -1, 255, 32767)
/* 1146 */         .addComponent(this.jLabel16, -1, -1, 32767));
/*      */     
/* 1148 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/* 1149 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1150 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
/* 1151 */           .addComponent(this.jLabel16)
/* 1152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1153 */           .addComponent(this.jScrollPane7, -1, 109, 32767)));
/*      */ 
/*      */     
/* 1156 */     this.jPanel60.add(this.jPanel56);
/*      */     
/* 1158 */     this.jPanel57.setLayout(new GridLayout(1, 0));
/*      */     
/* 1160 */     this.jPanel61.setBackground(Color.white);
/*      */     
/* 1162 */     this.jLabel63.setText("Comentario para esta prefactura:");
/*      */     
/* 1164 */     this.jTextArea3.setColumns(20);
/* 1165 */     this.jTextArea3.setFont(new Font("Monospaced", 0, 11));
/* 1166 */     this.jTextArea3.setLineWrap(true);
/* 1167 */     this.jTextArea3.setRows(4);
/* 1168 */     this.jScrollPane16.setViewportView(this.jTextArea3);
/*      */     
/* 1170 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/* 1171 */     this.jPanel61.setLayout(jPanel61Layout);
/* 1172 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/* 1173 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1174 */         .addComponent(this.jLabel63, -1, -1, 32767)
/* 1175 */         .addComponent(this.jScrollPane16));
/*      */     
/* 1177 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/* 1178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1179 */         .addGroup(jPanel61Layout.createSequentialGroup()
/* 1180 */           .addComponent(this.jLabel63)
/* 1181 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1182 */           .addComponent(this.jScrollPane16)));
/*      */ 
/*      */     
/* 1185 */     this.jPanel57.add(this.jPanel61);
/*      */     
/* 1187 */     this.jPanel60.add(this.jPanel57);
/*      */     
/* 1189 */     this.jPanel59.setLayout(new GridLayout(1, 0));
/*      */     
/* 1191 */     this.jPanel48.setBackground(Color.white);
/*      */     
/* 1193 */     this.jButton8.setMnemonic('C');
/* 1194 */     this.jButton8.setText("Cerrar");
/* 1195 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/* 1196 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1198 */             PrefacturaCliente.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1202 */     this.jLabel69.setHorizontalAlignment(0);
/* 1203 */     this.jLabel69.setText("<html><u>Ver estatus<u></html>");
/* 1204 */     this.jLabel69.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1206 */             PrefacturaCliente.this.jLabel69MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1209 */             PrefacturaCliente.this.jLabel69MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1212 */             PrefacturaCliente.this.jLabel69MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1216 */     this.jButton9.setMnemonic('G');
/* 1217 */     this.jButton9.setText("Guardar");
/* 1218 */     this.jButton9.setToolTipText("Guardar Prefactura (Alt+G)");
/* 1219 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1221 */             PrefacturaCliente.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1225 */     GroupLayout jPanel48Layout = new GroupLayout(this.jPanel48);
/* 1226 */     this.jPanel48.setLayout(jPanel48Layout);
/* 1227 */     jPanel48Layout.setHorizontalGroup(jPanel48Layout
/* 1228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1229 */         .addGroup(jPanel48Layout.createSequentialGroup()
/* 1230 */           .addContainerGap(-1, 32767)
/* 1231 */           .addComponent(this.jButton9, -2, 110, -2)
/* 1232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1233 */           .addComponent(this.jButton8, -2, 110, -2)
/* 1234 */           .addContainerGap())
/* 1235 */         .addComponent(this.jLabel69));
/*      */     
/* 1237 */     jPanel48Layout.setVerticalGroup(jPanel48Layout
/* 1238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1239 */         .addGroup(jPanel48Layout.createSequentialGroup()
/* 1240 */           .addComponent(this.jLabel69, -2, -1, -2)
/* 1241 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1242 */           .addGroup(jPanel48Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1243 */             .addComponent(this.jButton8)
/* 1244 */             .addComponent(this.jButton9))));
/*      */ 
/*      */     
/* 1247 */     this.jPanel59.add(this.jPanel48);
/*      */     
/* 1249 */     this.jPanel60.add(this.jPanel59);
/*      */     
/* 1251 */     this.jPanel58.setLayout(new GridLayout(1, 1));
/*      */     
/* 1253 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/* 1254 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), null));
/*      */     
/* 1256 */     this.jLabel20.setHorizontalAlignment(4);
/* 1257 */     this.jLabel20.setText("Subtotal");
/*      */     
/* 1259 */     this.jLabel21.setFont(new Font("Tahoma", 1, 12));
/* 1260 */     this.jLabel21.setHorizontalAlignment(4);
/* 1261 */     this.jLabel21.setText("jLabel21");
/*      */     
/* 1263 */     this.jLabel22.setFont(new Font("Tahoma", 1, 12));
/* 1264 */     this.jLabel22.setHorizontalAlignment(4);
/* 1265 */     this.jLabel22.setText("jLabel21");
/*      */     
/* 1267 */     this.jLabel23.setHorizontalAlignment(4);
/* 1268 */     this.jLabel23.setText("Iva " + this.IVA + "%");
/* 1269 */     this.jLabel23.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1271 */             PrefacturaCliente.this.jLabel23MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1274 */             PrefacturaCliente.this.jLabel23MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1277 */             PrefacturaCliente.this.jLabel23MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1281 */     this.jLabel24.setHorizontalAlignment(4);
/* 1282 */     this.jLabel24.setText("Retención " + this.RET + "%");
/* 1283 */     this.jLabel24.setToolTipText("Cambiar retención");
/* 1284 */     this.jLabel24.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1286 */             PrefacturaCliente.this.jLabel24MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1289 */             PrefacturaCliente.this.jLabel24MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1292 */             PrefacturaCliente.this.jLabel24MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1296 */     this.jLabel25.setFont(new Font("Tahoma", 1, 12));
/* 1297 */     this.jLabel25.setHorizontalAlignment(4);
/* 1298 */     this.jLabel25.setText("jLabel21");
/*      */     
/* 1300 */     this.jLabel26.setHorizontalAlignment(4);
/* 1301 */     this.jLabel26.setText("Total");
/*      */     
/* 1303 */     this.jLabel27.setFont(new Font("Tahoma", 1, 12));
/* 1304 */     this.jLabel27.setHorizontalAlignment(4);
/* 1305 */     this.jLabel27.setText("jLabel21");
/*      */     
/* 1307 */     this.jLabel70.setHorizontalAlignment(4);
/* 1308 */     this.jLabel70.setText("Descuento");
/*      */     
/* 1310 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*      */     
/* 1312 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1313 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1314 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1316 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1317 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1318 */             .addComponent(this.jSeparator6)
/* 1319 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1320 */               .addContainerGap()
/* 1321 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1322 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1323 */                   .addComponent(this.jLabel23, -2, 80, -2)
/* 1324 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1325 */                   .addComponent(this.jLabel22, -2, 147, -2))
/* 1326 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1327 */                   .addComponent(this.jLabel24, -1, -1, 32767)
/* 1328 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1329 */                   .addComponent(this.jLabel25, -2, 147, -2))
/* 1330 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/* 1331 */                   .addComponent(this.jLabel26, -2, 80, -2)
/* 1332 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1333 */                   .addComponent(this.jLabel27, -2, 147, -2))
/* 1334 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1335 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/* 1336 */                     .addComponent(this.jLabel70, -2, 80, -2)
/* 1337 */                     .addGap(18, 18, 18)
/* 1338 */                     .addComponent(this.jFormattedTextField2))
/* 1339 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/* 1340 */                     .addComponent(this.jLabel20, -2, 80, -2)
/* 1341 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1342 */                     .addComponent(this.jLabel21, -2, 147, -2))))))
/* 1343 */           .addContainerGap()));
/*      */     
/* 1345 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1346 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1347 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1348 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1349 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1350 */               .addGap(1, 1, 1)
/* 1351 */               .addComponent(this.jLabel20))
/* 1352 */             .addComponent(this.jLabel21))
/* 1353 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1354 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1355 */             .addComponent(this.jLabel70)
/* 1356 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/* 1357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1358 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1359 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1360 */               .addGap(1, 1, 1)
/* 1361 */               .addComponent(this.jLabel23))
/* 1362 */             .addComponent(this.jLabel22))
/* 1363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1364 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1365 */             .addComponent(this.jLabel25)
/* 1366 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1367 */               .addGap(1, 1, 1)
/* 1368 */               .addComponent(this.jLabel24)))
/* 1369 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1370 */           .addComponent(this.jSeparator6, -2, 5, -2)
/* 1371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1372 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1373 */             .addComponent(this.jLabel27, -1, -1, 32767)
/* 1374 */             .addComponent(this.jLabel26, -2, 20, -2))
/* 1375 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1378 */     this.jPanel58.add(this.jPanel6);
/*      */     
/* 1380 */     this.jPanel60.add(this.jPanel58);
/*      */     
/* 1382 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 1383 */     this.jPanel50.setLayout(jPanel50Layout);
/* 1384 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 1385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1386 */         .addComponent(this.jPanel24, -2, 0, 32767)
/* 1387 */         .addComponent(this.jPanel52, -1, -1, 32767)
/* 1388 */         .addComponent(this.jPanel54, -1, 1048, 32767)
/* 1389 */         .addComponent(this.jPanel60, -1, 1048, 32767));
/*      */     
/* 1391 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 1392 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1393 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 1394 */           .addComponent(this.jPanel24, -2, -1, -2)
/* 1395 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1396 */           .addComponent(this.jPanel52, -1, -1, 32767)
/* 1397 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1398 */           .addComponent(this.jPanel54, -2, 191, -2)
/* 1399 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1400 */           .addComponent(this.jPanel60, -2, 152, -2)));
/*      */ 
/*      */     
/* 1403 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/* 1404 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/* 1405 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/* 1406 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1407 */         .addGroup(jFrame1Layout.createSequentialGroup()
/* 1408 */           .addComponent(this.jPanel50, -1, -1, 32767)
/* 1409 */           .addGap(0, 0, 0)));
/*      */     
/* 1411 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/* 1412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1413 */         .addComponent(this.jPanel50, -1, -1, 32767));
/*      */ 
/*      */     
/* 1416 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1427 */     this.jScrollPane6.setViewportView(this.jTable6);
/*      */     
/* 1429 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1430 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1431 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1432 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1433 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1434 */           .addContainerGap()
/* 1435 */           .addComponent(this.jScrollPane6, -2, 254, -2)
/* 1436 */           .addContainerGap(37, 32767)));
/*      */     
/* 1438 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1440 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1441 */           .addContainerGap()
/* 1442 */           .addComponent(this.jScrollPane6, -2, 77, -2)
/* 1443 */           .addContainerGap(38, 32767)));
/*      */ 
/*      */     
/* 1446 */     this.jFrame2.setTitle("Prefacturas de clientes");
/* 1447 */     this.jFrame2.setMinimumSize(new Dimension(950, 500));
/*      */     
/* 1449 */     this.jPanel20.setBackground(Color.white);
/*      */     
/* 1451 */     this.jPanel21.setBackground(Color.white);
/*      */     
/* 1453 */     this.jLabel5.setFont(new Font("Tahoma", 1, 15));
/* 1454 */     this.jLabel5.setHorizontalAlignment(0);
/* 1455 */     this.jLabel5.setText("PREFACTURAS DE CLIENTES");
/*      */     
/* 1457 */     this.jPanel35.setBackground(Color.white);
/* 1458 */     this.jPanel35.setLayout(new GridLayout(1, 3, 10, 0));
/*      */     
/* 1460 */     this.jPanel37.setBackground(Color.white);
/* 1461 */     this.jPanel37.setLayout(new GridLayout(1, 5, 6, 0));
/*      */     
/* 1463 */     this.jLabel6.setHorizontalAlignment(4);
/* 1464 */     this.jLabel6.setText("Filtrar fecha de");
/* 1465 */     this.jPanel37.add(this.jLabel6);
/*      */     
/* 1467 */     this.jPanel35.add(this.jPanel37);
/*      */     
/* 1469 */     this.jPanel38.setBackground(Color.white);
/* 1470 */     this.jPanel38.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1472 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1473 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 1474 */     this.jDateChooser11.setIcon(this.icon);
/* 1475 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 1476 */     this.jDateChooser11.setMinSelectableDate(new Date(1286690512000L));
/* 1477 */     this.jPanel38.add((Component)this.jDateChooser11);
/*      */     
/* 1479 */     this.jLabel7.setHorizontalAlignment(0);
/* 1480 */     this.jLabel7.setText("Al");
/* 1481 */     this.jPanel38.add(this.jLabel7);
/*      */     
/* 1483 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1484 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1485 */     this.jDateChooser12.setIcon(this.icon);
/* 1486 */     this.jDateChooser12.setMaxSelectableDate(this.fechaActual);
/* 1487 */     this.jDateChooser12.setMinSelectableDate(new Date(1286690512000L));
/* 1488 */     this.jPanel38.add((Component)this.jDateChooser12);
/*      */     
/* 1490 */     this.jPanel35.add(this.jPanel38);
/*      */     
/* 1492 */     this.jPanel39.setBackground(Color.white);
/* 1493 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1495 */     this.jButton28.setMnemonic('F');
/* 1496 */     this.jButton28.setText("Filtrar");
/* 1497 */     this.jButton28.setToolTipText("Filtrar Consulta (Alt+F)");
/* 1498 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1500 */             PrefacturaCliente.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1503 */     this.jPanel39.add(this.jButton28);
/*      */     
/* 1505 */     this.jPanel41.setBackground(Color.white);
/* 1506 */     this.jPanel41.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1508 */     this.jLabel37.setFont(new Font("Tahoma", 2, 12));
/* 1509 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/* 1510 */     this.jLabel37.setText("<html><u>Todos </u></html>");
/* 1511 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1513 */             PrefacturaCliente.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1516 */             PrefacturaCliente.this.jLabel37MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1519 */             PrefacturaCliente.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */         });
/* 1522 */     this.jPanel41.add(this.jLabel37);
/*      */     
/* 1524 */     this.jLabel38.setFont(new Font("Tahoma", 2, 12));
/* 1525 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 1526 */     this.jLabel38.setHorizontalAlignment(0);
/* 1527 */     this.jLabel38.setText("<html><u>Hoy</u></html>");
/* 1528 */     this.jLabel38.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1530 */             PrefacturaCliente.this.jLabel38MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1533 */             PrefacturaCliente.this.jLabel38MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1536 */             PrefacturaCliente.this.jLabel38MouseEntered(evt);
/*      */           }
/*      */         });
/* 1539 */     this.jPanel41.add(this.jLabel38);
/*      */     
/* 1541 */     this.jLabel39.setFont(new Font("Tahoma", 2, 12));
/* 1542 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 1543 */     this.jLabel39.setHorizontalAlignment(4);
/* 1544 */     this.jLabel39.setText("<html><u>Ayer</u></html>");
/* 1545 */     this.jLabel39.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1547 */             PrefacturaCliente.this.jLabel39MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1550 */             PrefacturaCliente.this.jLabel39MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1553 */             PrefacturaCliente.this.jLabel39MouseEntered(evt);
/*      */           }
/*      */         });
/* 1556 */     this.jPanel41.add(this.jLabel39);
/*      */     
/* 1558 */     this.jPanel39.add(this.jPanel41);
/*      */     
/* 1560 */     this.jPanel35.add(this.jPanel39);
/*      */     
/* 1562 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 1563 */     this.jPanel21.setLayout(jPanel21Layout);
/* 1564 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 1565 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1566 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 1567 */           .addComponent(this.jLabel5, -2, 320, -2)
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addComponent(this.jPanel35, -2, 0, 32767)));
/*      */     
/* 1571 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 1572 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1573 */         .addComponent(this.jPanel35, -1, -1, 32767)
/* 1574 */         .addComponent(this.jLabel5, -1, -1, 32767));
/*      */ 
/*      */     
/* 1577 */     this.jPanel40.setBackground(Color.white);
/* 1578 */     this.jPanel40.setBorder(BorderFactory.createTitledBorder(" Búsqueda de Prefacturas "));
/* 1579 */     this.jPanel40.setLayout(new GridLayout(2, 8, 6, 6));
/*      */     
/* 1581 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1582 */     this.jComboBox1.setFont(new Font("Tahoma", 0, 10));
/* 1583 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA", "TODAS" }));
/* 1584 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1586 */             PrefacturaCliente.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1589 */     this.jPanel40.add(this.jComboBox1);
/*      */     
/* 1591 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1592 */     this.jComboBox9.setFont(new Font("Tahoma", 0, 10));
/* 1593 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "POR FACTURAR", "FACTURADAS" }));
/* 1594 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1596 */             PrefacturaCliente.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1599 */     this.jPanel40.add(this.jComboBox9);
/*      */     
/* 1601 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1602 */     this.jComboBox2.setFont(new Font("Tahoma", 0, 10));
/* 1603 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1604 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1606 */             PrefacturaCliente.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1609 */     this.jPanel40.add(this.jComboBox2);
/*      */     
/* 1611 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1612 */     this.jComboBox3.setFont(new Font("Tahoma", 0, 10));
/* 1613 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1614 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1616 */             PrefacturaCliente.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1619 */     this.jPanel40.add(this.jComboBox3);
/*      */     
/* 1621 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1622 */     this.jComboBox6.setFont(new Font("Tahoma", 0, 10));
/* 1623 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1624 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1626 */             PrefacturaCliente.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1629 */     this.jPanel40.add(this.jComboBox6);
/*      */     
/* 1631 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1632 */     this.jComboBox7.setFont(new Font("Tahoma", 0, 10));
/* 1633 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1634 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1636 */             PrefacturaCliente.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1639 */     this.jPanel40.add(this.jComboBox7);
/*      */     
/* 1641 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1643 */             PrefacturaCliente.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1646 */     this.jPanel40.add(this.jTextField1);
/*      */     
/* 1648 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1650 */             PrefacturaCliente.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1653 */     this.jPanel40.add(this.jTextField2);
/*      */     
/* 1655 */     this.jLabel46.setHorizontalAlignment(0);
/* 1656 */     this.jLabel46.setText("Activa/Cancelada");
/* 1657 */     this.jPanel40.add(this.jLabel46);
/*      */     
/* 1659 */     this.jLabel57.setHorizontalAlignment(0);
/* 1660 */     this.jLabel57.setText("Estatus - Prefactura");
/* 1661 */     this.jPanel40.add(this.jLabel57);
/*      */     
/* 1663 */     this.jLabel47.setHorizontalAlignment(0);
/* 1664 */     this.jLabel47.setText("Responsable");
/* 1665 */     this.jPanel40.add(this.jLabel47);
/*      */     
/* 1667 */     this.jLabel49.setHorizontalAlignment(0);
/* 1668 */     this.jLabel49.setText("Cliente");
/* 1669 */     this.jPanel40.add(this.jLabel49);
/*      */     
/* 1671 */     this.jLabel64.setHorizontalAlignment(0);
/* 1672 */     this.jLabel64.setText("Equipo");
/* 1673 */     this.jPanel40.add(this.jLabel64);
/*      */     
/* 1675 */     this.jLabel65.setHorizontalAlignment(0);
/* 1676 */     this.jLabel65.setText("Pozo");
/* 1677 */     this.jPanel40.add(this.jLabel65);
/*      */     
/* 1679 */     this.jLabel15.setHorizontalAlignment(0);
/* 1680 */     this.jLabel15.setText("Folio Factura");
/* 1681 */     this.jPanel40.add(this.jLabel15);
/*      */     
/* 1683 */     this.jLabel62.setHorizontalAlignment(0);
/* 1684 */     this.jLabel62.setText("Referencia Prefactura");
/* 1685 */     this.jPanel40.add(this.jLabel62);
/*      */     
/* 1687 */     this.jPanel18.setBackground(Color.white);
/* 1688 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder("Resultado de la Búsqueda"));
/*      */     
/* 1690 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1691 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1699 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1704 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1707 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1709 */             PrefacturaCliente.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1712 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1714 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1715 */     this.jButton4.setMnemonic('N');
/* 1716 */     this.jButton4.setText("Nueva");
/* 1717 */     this.jButton4.setToolTipText("Nueva Prefactura (Alt+N)");
/* 1718 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1720 */             PrefacturaCliente.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1724 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1725 */     this.jButton12.setMnemonic('V');
/* 1726 */     this.jButton12.setText("Ver");
/* 1727 */     this.jButton12.setToolTipText("Ver Prefactura Detallada (Alt+V)");
/* 1728 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1730 */             PrefacturaCliente.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1734 */     this.jButton29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1735 */     this.jButton29.setMnemonic('G');
/* 1736 */     this.jButton29.setText("Guardar Reporte");
/* 1737 */     this.jButton29.setToolTipText("Guardar Reporte (Alt+G)");
/* 1738 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1740 */             PrefacturaCliente.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1744 */     this.jButton30.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1745 */     this.jButton30.setMnemonic('C');
/* 1746 */     this.jButton30.setText("Cancelar");
/* 1747 */     this.jButton30.setToolTipText("Ver Prefactura Detallada (Alt+V)");
/* 1748 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1750 */             PrefacturaCliente.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1754 */     this.jPanel46.setBackground(Color.white);
/*      */     
/* 1756 */     this.jLabel8.setFont(new Font("Tahoma", 0, 10));
/* 1757 */     this.jLabel8.setText("Cantidad acumulada:");
/*      */     
/* 1759 */     this.jLabel61.setFont(new Font("Tahoma", 1, 11));
/* 1760 */     this.jLabel61.setText("jLabel61");
/*      */     
/* 1762 */     this.jLabel66.setFont(new Font("Tahoma", 0, 10));
/* 1763 */     this.jLabel66.setText("Tons:");
/*      */     
/* 1765 */     this.jLabel67.setFont(new Font("Tahoma", 1, 11));
/* 1766 */     this.jLabel67.setText("jLabel67");
/*      */     
/* 1768 */     this.jLabel48.setFont(new Font("Tahoma", 1, 10));
/* 1769 */     this.jLabel48.setForeground(Color.red);
/* 1770 */     this.jLabel48.setHorizontalAlignment(0);
/* 1771 */     this.jLabel48.setText("t");
/* 1772 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1774 */     this.jButton13.setMnemonic('C');
/* 1775 */     this.jButton13.setText("Cerrar");
/* 1776 */     this.jButton13.setToolTipText("Cerrar (Alt+C)");
/* 1777 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1779 */             PrefacturaCliente.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1783 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 1784 */     this.jPanel46.setLayout(jPanel46Layout);
/* 1785 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 1786 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1787 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 1788 */           .addComponent(this.jLabel48, -2, 157, -2)
/* 1789 */           .addGap(28, 28, 28)
/* 1790 */           .addComponent(this.jLabel8, -2, 112, -2)
/* 1791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1792 */           .addComponent(this.jLabel61, -2, 182, -2)
/* 1793 */           .addGap(39, 39, 39)
/* 1794 */           .addComponent(this.jLabel66, -2, 48, -2)
/* 1795 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1796 */           .addComponent(this.jLabel67, -2, 203, -2)
/* 1797 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1798 */           .addComponent(this.jButton13, -2, 102, -2)));
/*      */     
/* 1800 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 1801 */         .createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1802 */         .addComponent(this.jLabel8, -2, 29, -2)
/* 1803 */         .addComponent(this.jLabel61, -2, 29, -2)
/* 1804 */         .addComponent(this.jLabel66, -2, 29, -2)
/* 1805 */         .addComponent(this.jLabel67, -1, -1, 32767)
/* 1806 */         .addComponent(this.jButton13, -1, -1, 32767)
/* 1807 */         .addComponent(this.jLabel48, -1, -1, 32767));
/*      */ 
/*      */     
/* 1810 */     this.jButton38.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1811 */     this.jButton38.setMnemonic('M');
/* 1812 */     this.jButton38.setText("Modificar");
/* 1813 */     this.jButton38.setToolTipText("Modificar Prefactura (Alt+M)");
/* 1814 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1816 */             PrefacturaCliente.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1820 */     this.jButton40.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/switch-user.png")));
/* 1821 */     this.jButton40.setMnemonic('A');
/* 1822 */     this.jButton40.setText("Cambiar de usuario");
/* 1823 */     this.jButton40.setToolTipText("Cambiar de usuario (Alt+A)");
/* 1824 */     this.jButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1826 */             PrefacturaCliente.this.jButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1830 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1831 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1832 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1833 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1834 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1835 */           .addContainerGap()
/* 1836 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1837 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING)
/* 1838 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 1839 */               .addComponent(this.jButton4, -2, 97, -2)
/* 1840 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1841 */               .addComponent(this.jButton12, -2, 100, -2)
/* 1842 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1843 */               .addComponent(this.jButton30)
/* 1844 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1845 */               .addComponent(this.jButton38)
/* 1846 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1847 */               .addComponent(this.jButton40, -2, 184, -2)
/* 1848 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1849 */               .addComponent(this.jButton29))
/* 1850 */             .addComponent(this.jPanel46, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 1851 */           .addContainerGap()));
/*      */     
/* 1853 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1855 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1856 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1857 */             .addComponent(this.jButton4, -1, -1, 32767)
/* 1858 */             .addComponent(this.jButton12, -1, -1, 32767)
/* 1859 */             .addComponent(this.jButton30, -1, -1, 32767)
/* 1860 */             .addComponent(this.jButton38, -1, -1, 32767)
/* 1861 */             .addComponent(this.jButton29, -1, -1, 32767)
/* 1862 */             .addComponent(this.jButton40, -1, -1, 32767))
/* 1863 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1864 */           .addComponent(this.jScrollPane2, -1, 313, 32767)
/* 1865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1866 */           .addComponent(this.jPanel46, -2, -1, -2)));
/*      */ 
/*      */     
/* 1869 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1870 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1871 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1872 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1873 */         .addComponent(this.jPanel21, -1, -1, 32767)
/* 1874 */         .addComponent(this.jSeparator20)
/* 1875 */         .addComponent(this.jPanel40, -2, 0, 32767)
/* 1876 */         .addComponent(this.jPanel18, -1, -1, 32767));
/*      */     
/* 1878 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1879 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1880 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1881 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 1882 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1883 */           .addComponent(this.jSeparator20, -2, 10, -2)
/* 1884 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1885 */           .addComponent(this.jPanel40, -2, -1, -2)
/* 1886 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1887 */           .addComponent(this.jPanel18, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1890 */     GroupLayout jFrame2Layout = new GroupLayout(this.jFrame2.getContentPane());
/* 1891 */     this.jFrame2.getContentPane().setLayout(jFrame2Layout);
/* 1892 */     jFrame2Layout.setHorizontalGroup(jFrame2Layout
/* 1893 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1894 */         .addGroup(jFrame2Layout.createSequentialGroup()
/* 1895 */           .addComponent(this.jPanel20, -1, -1, 32767)
/* 1896 */           .addGap(0, 0, 0)));
/*      */     
/* 1898 */     jFrame2Layout.setVerticalGroup(jFrame2Layout
/* 1899 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1900 */         .addGroup(jFrame2Layout.createSequentialGroup()
/* 1901 */           .addComponent(this.jPanel20, -1, -1, 32767)
/* 1902 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1905 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/* 1907 */     this.jDialog3.setTitle("Detalle de Guías");
/* 1908 */     this.jDialog3.setModal(true);
/*      */     
/* 1910 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/* 1912 */     this.jLabel89.setFont(new Font("Times New Roman", 1, 25));
/* 1913 */     this.jLabel89.setForeground(new Color(102, 102, 102));
/* 1914 */     this.jLabel89.setHorizontalAlignment(0);
/* 1915 */     this.jLabel89.setText("Detalles de la Guía");
/*      */     
/* 1917 */     this.jLabel29.setText("Guía: ");
/*      */     
/* 1919 */     this.jLabel30.setFont(new Font("Tahoma", 1, 11));
/* 1920 */     this.jLabel30.setText("PR-00001");
/*      */     
/* 1922 */     this.jLabel31.setText("Autorizó:");
/*      */     
/* 1924 */     this.jLabel32.setFont(new Font("Tahoma", 1, 11));
/* 1925 */     this.jLabel32.setText("PR-00001");
/*      */     
/* 1927 */     this.jLabel33.setFont(new Font("Tahoma", 3, 11));
/* 1928 */     this.jLabel33.setForeground(Color.red);
/* 1929 */     this.jLabel33.setText("A continuación se muestra toda la información de la guía hasta el momento");
/*      */     
/* 1931 */     this.jTextArea1.setColumns(20);
/* 1932 */     this.jTextArea1.setEditable(false);
/* 1933 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 12));
/* 1934 */     this.jTextArea1.setLineWrap(true);
/* 1935 */     this.jTextArea1.setRows(5);
/* 1936 */     this.jTextArea1.setText("Ejemplo del texto");
/* 1937 */     this.jScrollPane8.setViewportView(this.jTextArea1);
/*      */     
/* 1939 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/* 1940 */     this.jLabel52.setText("|");
/*      */     
/* 1942 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/* 1943 */     this.jLabel51.setForeground(Color.red);
/* 1944 */     this.jLabel51.setHorizontalAlignment(0);
/* 1945 */     this.jLabel51.setText("<html><u>Cerrar</u></html>");
/* 1946 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1948 */             PrefacturaCliente.this.jLabel51MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1951 */             PrefacturaCliente.this.jLabel51MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1954 */             PrefacturaCliente.this.jLabel51MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1958 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/* 1959 */     this.jLabel53.setText("|");
/*      */     
/* 1961 */     this.jLabel98.setFont(new Font("Times New Roman", 1, 12));
/* 1962 */     this.jLabel98.setText("ESTATUS:");
/*      */     
/* 1964 */     this.jLabel99.setFont(new Font("Times New Roman", 1, 12));
/* 1965 */     this.jLabel99.setForeground(new Color(0, 0, 102));
/* 1966 */     this.jLabel99.setText("jLabel99");
/*      */     
/* 1968 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1969 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1970 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1971 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1972 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1973 */           .addContainerGap()
/* 1974 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1975 */             .addComponent(this.jScrollPane8, -1, 660, 32767)
/* 1976 */             .addComponent(this.jLabel33, -1, 660, 32767)
/* 1977 */             .addComponent(this.jLabel89, -1, 660, 32767)
/* 1978 */             .addComponent(this.jSeparator7, -1, 660, 32767)
/* 1979 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1980 */               .addComponent(this.jLabel29, -2, 36, -2)
/* 1981 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1982 */               .addComponent(this.jLabel30, -2, 227, -2))
/* 1983 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1984 */               .addComponent(this.jLabel31, -2, 48, -2)
/* 1985 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1986 */               .addComponent(this.jLabel32, -1, 606, 32767))
/* 1987 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1988 */               .addComponent(this.jLabel98, -2, 69, -2)
/* 1989 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1990 */               .addComponent(this.jLabel99, -1, 264, 32767)
/* 1991 */               .addGap(259, 259, 259)
/* 1992 */               .addComponent(this.jLabel52)
/* 1993 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1994 */               .addComponent(this.jLabel51, -2, -1, -2)
/* 1995 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1996 */               .addComponent(this.jLabel53)))
/* 1997 */           .addContainerGap()));
/*      */     
/* 1999 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 2000 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2001 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2002 */           .addComponent(this.jLabel89)
/* 2003 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2004 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 2005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2006 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2007 */             .addComponent(this.jLabel29)
/* 2008 */             .addComponent(this.jLabel30))
/* 2009 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2010 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2011 */             .addComponent(this.jLabel31)
/* 2012 */             .addComponent(this.jLabel32))
/* 2013 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2014 */           .addComponent(this.jLabel33)
/* 2015 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2016 */           .addComponent(this.jScrollPane8, -2, 326, -2)
/* 2017 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2018 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2019 */             .addComponent(this.jLabel53)
/* 2020 */             .addComponent(this.jLabel51, -2, -1, -2)
/* 2021 */             .addComponent(this.jLabel52)
/* 2022 */             .addComponent(this.jLabel98)
/* 2023 */             .addComponent(this.jLabel99))
/* 2024 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2027 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 2028 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 2029 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 2030 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2031 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 2033 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 2034 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2035 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */ 
/*      */     
/* 2038 */     this.jDialog4.setTitle("Coloca el tractor");
/*      */     
/* 2040 */     this.jPanel10.setBackground(Color.white);
/*      */     
/* 2042 */     this.jLabel34.setFont(new Font("Times New Roman", 1, 14));
/* 2043 */     this.jLabel34.setHorizontalAlignment(0);
/* 2044 */     this.jLabel34.setText("Coloca el económico del tractor");
/*      */     
/* 2046 */     this.jLabel35.setText("Tractor");
/*      */     
/* 2048 */     this.jTextField4.setFont(new Font("Tahoma", 1, 14));
/* 2049 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2051 */             PrefacturaCliente.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2055 */     this.jButton14.setText("Cancelar");
/* 2056 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2058 */             PrefacturaCliente.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2062 */     this.jButton15.setText("Aceptar");
/* 2063 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2065 */             PrefacturaCliente.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2069 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 2070 */     this.jPanel10.setLayout(jPanel10Layout);
/* 2071 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 2072 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2073 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2074 */           .addContainerGap()
/* 2075 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2076 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2077 */               .addComponent(this.jSeparator8, GroupLayout.Alignment.LEADING)
/* 2078 */               .addComponent(this.jLabel34, GroupLayout.Alignment.LEADING, -1, 230, 32767))
/* 2079 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 2080 */               .addComponent(this.jLabel35, -2, 60, -2)
/* 2081 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2082 */               .addComponent(this.jTextField4, -1, 166, 32767))
/* 2083 */             .addComponent(this.jSeparator9, GroupLayout.Alignment.TRAILING, -1, 230, 32767)
/* 2084 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 2085 */               .addComponent(this.jButton15, -2, 83, -2)
/* 2086 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2087 */               .addComponent(this.jButton14, -2, 83, -2)))
/* 2088 */           .addContainerGap()));
/*      */     
/* 2090 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 2091 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2092 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2093 */           .addComponent(this.jLabel34)
/* 2094 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2095 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 2096 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2097 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2098 */             .addComponent(this.jLabel35, -2, 26, -2)
/* 2099 */             .addComponent(this.jTextField4, -2, 25, -2))
/* 2100 */           .addGap(33, 33, 33)
/* 2101 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 2102 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2103 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2104 */             .addComponent(this.jButton14)
/* 2105 */             .addComponent(this.jButton15))
/* 2106 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2109 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 2110 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 2111 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 2112 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2113 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */     
/* 2115 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 2116 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2117 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */ 
/*      */     
/* 2120 */     this.jDialog5.setTitle("Coloca el remolque");
/*      */     
/* 2122 */     this.jPanel11.setBackground(Color.white);
/*      */     
/* 2124 */     this.jLabel36.setFont(new Font("Times New Roman", 1, 14));
/* 2125 */     this.jLabel36.setHorizontalAlignment(0);
/* 2126 */     this.jLabel36.setText("Coloca el económico del remolque");
/*      */     
/* 2128 */     this.jLabel40.setText("Remolque");
/*      */     
/* 2130 */     this.jTextField5.setFont(new Font("Tahoma", 1, 14));
/* 2131 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2133 */             PrefacturaCliente.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2137 */     this.jButton16.setText("Cancelar");
/* 2138 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2140 */             PrefacturaCliente.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2144 */     this.jButton17.setText("Aceptar");
/* 2145 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2147 */             PrefacturaCliente.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2151 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2152 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2153 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 2154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2155 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2156 */           .addContainerGap()
/* 2157 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2158 */             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2159 */               .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING)
/* 2160 */               .addComponent(this.jLabel36, GroupLayout.Alignment.LEADING, -2, 230, 32767))
/* 2161 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 2162 */               .addComponent(this.jLabel40, -2, 60, -2)
/* 2163 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2164 */               .addComponent(this.jTextField5, -1, 166, 32767))
/* 2165 */             .addComponent(this.jSeparator11, GroupLayout.Alignment.TRAILING, -1, 230, 32767)
/* 2166 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 2167 */               .addComponent(this.jButton17, -2, 83, -2)
/* 2168 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2169 */               .addComponent(this.jButton16, -2, 83, -2)))
/* 2170 */           .addContainerGap()));
/*      */     
/* 2172 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 2173 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2174 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2175 */           .addComponent(this.jLabel36)
/* 2176 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2177 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 2178 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2179 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2180 */             .addComponent(this.jLabel40, -2, 26, -2)
/* 2181 */             .addComponent(this.jTextField5, -2, 25, -2))
/* 2182 */           .addGap(33, 33, 33)
/* 2183 */           .addComponent(this.jSeparator11, -2, 10, -2)
/* 2184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2185 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2186 */             .addComponent(this.jButton16)
/* 2187 */             .addComponent(this.jButton17))
/* 2188 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2191 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 2192 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 2193 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 2194 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2195 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */     
/* 2197 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 2198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2199 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 2202 */     this.jDialog6.setTitle("Selecciona la nueva tarifa");
/*      */     
/* 2204 */     this.jPanel13.setBackground(Color.white);
/*      */     
/* 2206 */     this.jLabel41.setFont(new Font("Times New Roman", 1, 14));
/* 2207 */     this.jLabel41.setHorizontalAlignment(0);
/* 2208 */     this.jLabel41.setText("Selecciona la nueva tarifa");
/*      */     
/* 2210 */     this.jButton18.setMnemonic('c');
/* 2211 */     this.jButton18.setText("Cerrar");
/* 2212 */     this.jButton18.setToolTipText("Cerrar (Alt+C)");
/* 2213 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2215 */             PrefacturaCliente.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2219 */     this.jButton19.setMnemonic('a');
/* 2220 */     this.jButton19.setText("Aceptar");
/* 2221 */     this.jButton19.setToolTipText("Aceptar (Alt+A)");
/* 2222 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2224 */             PrefacturaCliente.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2228 */     this.jTable7.setFont(new Font("Tahoma", 0, 10));
/* 2229 */     this.jTable7.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2240 */     this.jTable7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2242 */             PrefacturaCliente.this.jTable7MouseClicked(evt);
/*      */           }
/*      */         });
/* 2245 */     this.jScrollPane9.setViewportView(this.jTable7);
/*      */     
/* 2247 */     this.jLabel42.setText("Mostrar sólo");
/*      */     
/* 2249 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 2250 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2252 */             PrefacturaCliente.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2256 */     this.jButton41.setMnemonic('U');
/* 2257 */     this.jButton41.setText("Nueva");
/* 2258 */     this.jButton41.setToolTipText("Aceptar (Alt+U)");
/* 2259 */     this.jButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2261 */             PrefacturaCliente.this.jButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2265 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2266 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2267 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2269 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2270 */           .addContainerGap()
/* 2271 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2272 */             .addComponent(this.jLabel41, -1, 570, 32767)
/* 2273 */             .addComponent(this.jSeparator13, -1, 570, 32767)
/* 2274 */             .addComponent(this.jScrollPane9, GroupLayout.Alignment.TRAILING, -1, 570, 32767)
/* 2275 */             .addComponent(this.jSeparator12, GroupLayout.Alignment.TRAILING, -1, 570, 32767)
/* 2276 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 2277 */               .addComponent(this.jLabel42, -2, 77, -2)
/* 2278 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2279 */               .addComponent(this.jComboBox4, -2, 172, -2)
/* 2280 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767)
/* 2281 */               .addComponent(this.jButton41, -2, 83, -2)
/* 2282 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2283 */               .addComponent(this.jButton19, -2, 83, -2)
/* 2284 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2285 */               .addComponent(this.jButton18, -2, 83, -2)))
/* 2286 */           .addContainerGap()));
/*      */     
/* 2288 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2290 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2291 */           .addComponent(this.jLabel41)
/* 2292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2293 */           .addComponent(this.jSeparator12, -2, 10, -2)
/* 2294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2295 */           .addComponent(this.jScrollPane9, -2, 198, -2)
/* 2296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2297 */           .addComponent(this.jSeparator13, -2, 10, -2)
/* 2298 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2299 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2300 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2301 */               .addComponent(this.jButton18)
/* 2302 */               .addComponent(this.jButton19)
/* 2303 */               .addComponent(this.jButton41))
/* 2304 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2305 */               .addComponent(this.jLabel42)
/* 2306 */               .addComponent(this.jComboBox4, -2, -1, -2)))
/* 2307 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2310 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2311 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2312 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2314 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */     
/* 2316 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2318 */         .addComponent(this.jPanel13, -2, -1, -2));
/*      */ 
/*      */     
/* 2321 */     this.jDialog7.setTitle("Columnas a Imprimir");
/*      */     
/* 2323 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 2325 */     this.jLabel43.setFont(new Font("Tahoma", 1, 14));
/* 2326 */     this.jLabel43.setHorizontalAlignment(0);
/* 2327 */     this.jLabel43.setText("Selecciona las columnas a imprimir");
/*      */     
/* 2329 */     this.jTable8.setModel(new DefaultTableModel(new Object[][] { { "Guia", Boolean.TRUE }, , { "Fecha", Boolean.TRUE }, , { "Servicio", null }, , { "Residuo", Boolean.TRUE }, , { "Cliente", null }, , { "Destino", null }, , { "Operador", null }, , { "Equipo", null }, , { "Plataforma", null }, , { "Pozo", null }, , { "F Carga", null }, , { "F Desc", null }, , { "Pedido", null }, , { "Tipo", null }, , { "Ticket", null }, , { "Peso", null }, , { "Tra", Boolean.TRUE }, , { "Rem", null }, , { "Rsp", null }, , { "Manif", null }, , { "P Unit", Boolean.TRUE }, , { "Sub", Boolean.TRUE },  }, (Object[])new String[] { "Columna", "Visible" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2358 */           Class[] types = new Class[] { Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2363 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 2366 */     this.jScrollPane10.setViewportView(this.jTable8);
/*      */     
/* 2368 */     this.jButton20.setMnemonic('C');
/* 2369 */     this.jButton20.setText("<<Atrás");
/* 2370 */     this.jButton20.setToolTipText("Cancelar (Alt+C)");
/* 2371 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2373 */             PrefacturaCliente.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2377 */     this.jButton21.setMnemonic('A');
/* 2378 */     this.jButton21.setText("Finalizar");
/* 2379 */     this.jButton21.setToolTipText("Aceptar (Alt+A)");
/* 2380 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2382 */             PrefacturaCliente.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2386 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 2387 */     this.jPanel14.setLayout(jPanel14Layout);
/* 2388 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 2389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2390 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2391 */           .addContainerGap()
/* 2392 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2393 */             .addComponent(this.jScrollPane10, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 2394 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2395 */               .addComponent(this.jSeparator14, GroupLayout.Alignment.LEADING)
/* 2396 */               .addComponent(this.jLabel43, GroupLayout.Alignment.LEADING, -1, 281, 32767)))
/* 2397 */           .addContainerGap())
/* 2398 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 2399 */           .addGap(101, 101, 101)
/* 2400 */           .addComponent(this.jButton20, -2, 86, -2)
/* 2401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2402 */           .addComponent(this.jButton21, -2, 88, -2)
/* 2403 */           .addGap(24, 24, 24)));
/*      */     
/* 2405 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 2406 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2407 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2408 */           .addComponent(this.jLabel43, -2, 17, -2)
/* 2409 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2410 */           .addComponent(this.jSeparator14, -2, 10, -2)
/* 2411 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2412 */           .addComponent(this.jScrollPane10, -1, 283, 32767)
/* 2413 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2414 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2415 */             .addComponent(this.jButton21)
/* 2416 */             .addComponent(this.jButton20))
/* 2417 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2420 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2421 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2422 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2423 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2424 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */     
/* 2426 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2427 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2428 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */ 
/*      */     
/* 2431 */     this.jLabel45.setText("Coloca la fecha");
/*      */     
/* 2433 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2434 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2435 */     this.jDateChooser5.setIcon(this.icon);
/* 2436 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2437 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2439 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 2440 */     this.jPanel15.setLayout(jPanel15Layout);
/* 2441 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 2442 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2443 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2444 */           .addComponent(this.jLabel45, -2, 89, -2)
/* 2445 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2446 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2447 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2449 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 2450 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2451 */         .addComponent(this.jLabel45, -1, -1, 32767)
/* 2452 */         .addComponent((Component)this.jDateChooser5, -1, -1, 32767));
/*      */ 
/*      */     
/* 2455 */     this.jDialog8.setTitle("Cambiar Información");
/*      */     
/* 2457 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/*      */     
/* 2459 */     this.jLabel50.setFont(new Font("Tahoma", 1, 14));
/* 2460 */     this.jLabel50.setHorizontalAlignment(0);
/* 2461 */     this.jLabel50.setText("Cambiar Tarifa");
/*      */     
/* 2463 */     this.jButton22.setMnemonic('C');
/* 2464 */     this.jButton22.setText("Cancelar");
/* 2465 */     this.jButton22.setToolTipText("Cancelar (Alt+C)");
/* 2466 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2468 */             PrefacturaCliente.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2472 */     this.jButton23.setMnemonic('A');
/* 2473 */     this.jButton23.setText("Aceptar");
/* 2474 */     this.jButton23.setToolTipText("Aceptar (Alt+A)");
/* 2475 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2477 */             PrefacturaCliente.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2481 */     this.jRadioButton1.setSelected(true);
/* 2482 */     this.jRadioButton1.setText("<html>Modificar la tarifa a todos los datos que tengan la misma información en:</html>");
/* 2483 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2485 */             PrefacturaCliente.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2489 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 2490 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 2491 */     this.jComboBox5.setEnabled(false);
/*      */     
/* 2493 */     this.jRadioButton2.setText("Modificar sólo la información seleccionada");
/* 2494 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2496 */             PrefacturaCliente.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2500 */     this.jTextField6.setText("jTextField6");
/* 2501 */     this.jTextField6.setEnabled(false);
/*      */     
/* 2503 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2504 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2505 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 2506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2507 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 2508 */           .addContainerGap()
/* 2509 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2510 */             .addGroup(jPanel16Layout.createSequentialGroup()
/* 2511 */               .addComponent(this.jButton23, -2, 88, -2)
/* 2512 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2513 */               .addComponent(this.jButton22, -2, 86, -2))
/* 2514 */             .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2515 */               .addComponent(this.jSeparator15)
/* 2516 */               .addComponent(this.jRadioButton2, -1, -1, 32767)
/* 2517 */               .addComponent(this.jSeparator16)
/* 2518 */               .addComponent(this.jRadioButton1, -2, 0, 32767)
/* 2519 */               .addComponent(this.jLabel50, -1, -1, 32767)
/* 2520 */               .addGroup(jPanel16Layout.createSequentialGroup()
/* 2521 */                 .addGap(21, 21, 21)
/* 2522 */                 .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2523 */                   .addComponent(this.jTextField6, -2, 198, -2)
/* 2524 */                   .addComponent(this.jComboBox5, -2, 198, -2))
/* 2525 */                 .addGap(78, 78, 78))))
/* 2526 */           .addContainerGap(17, 32767)));
/*      */     
/* 2528 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 2529 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2530 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 2531 */           .addComponent(this.jLabel50, -2, 17, -2)
/* 2532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2533 */           .addComponent(this.jSeparator15, -2, 10, -2)
/* 2534 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2535 */           .addComponent(this.jRadioButton2)
/* 2536 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2537 */           .addComponent(this.jTextField6, -2, -1, -2)
/* 2538 */           .addGap(18, 18, 18)
/* 2539 */           .addComponent(this.jRadioButton1, -2, -1, -2)
/* 2540 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2541 */           .addComponent(this.jComboBox5, -2, -1, -2)
/* 2542 */           .addGap(18, 18, 18)
/* 2543 */           .addComponent(this.jSeparator16, -2, 10, -2)
/* 2544 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2545 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2546 */             .addComponent(this.jButton22)
/* 2547 */             .addComponent(this.jButton23))
/* 2548 */           .addContainerGap(37, 32767)));
/*      */ 
/*      */     
/* 2551 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2552 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2553 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2555 */         .addComponent(this.jPanel16, -1, -1, 32767));
/*      */     
/* 2557 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2559 */         .addComponent(this.jPanel16, -2, -1, -2));
/*      */ 
/*      */     
/* 2562 */     this.jDialog9.setTitle("Otros Conceptos");
/*      */     
/* 2564 */     this.jPanel19.setBackground(new Color(255, 255, 255));
/*      */     
/* 2566 */     this.jLabel54.setFont(new Font("Tahoma", 1, 14));
/* 2567 */     this.jLabel54.setHorizontalAlignment(0);
/* 2568 */     this.jLabel54.setText("Otros Conceptos");
/*      */     
/* 2570 */     this.jButton24.setMnemonic('C');
/* 2571 */     this.jButton24.setText("Cerrar");
/* 2572 */     this.jButton24.setToolTipText("Cerrar(Alt+C)");
/* 2573 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2575 */             PrefacturaCliente.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2579 */     this.jLabel55.setText("Seleccione la cantidad");
/*      */     
/* 2581 */     this.jLabel56.setText("Coloque el concepto");
/*      */     
/* 2583 */     this.jTable9.setFont(new Font("Tahoma", 0, 10));
/* 2584 */     this.jTable9.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Concepto", "Importe", "SubTotal" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2592 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2597 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2600 */     this.jScrollPane11.setViewportView(this.jTable9);
/* 2601 */     if (this.jTable9.getColumnModel().getColumnCount() > 0) {
/* 2602 */       this.jTable9.getColumnModel().getColumn(0).setMinWidth(45);
/* 2603 */       this.jTable9.getColumnModel().getColumn(0).setMaxWidth(45);
/* 2604 */       this.jTable9.getColumnModel().getColumn(2).setMinWidth(80);
/* 2605 */       this.jTable9.getColumnModel().getColumn(2).setMaxWidth(80);
/* 2606 */       this.jTable9.getColumnModel().getColumn(3).setMinWidth(80);
/* 2607 */       this.jTable9.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */     } 
/*      */     
/* 2610 */     this.jButton25.setMnemonic('A');
/* 2611 */     this.jButton25.setText("Agregar");
/* 2612 */     this.jButton25.setToolTipText("Agregar Conceptos (Alt+A)");
/* 2613 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2615 */             PrefacturaCliente.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2619 */     this.jSpinner1.setModel(new SpinnerNumberModel(1, 1, 100, 1));
/*      */     
/* 2621 */     this.jTextField8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2623 */             PrefacturaCliente.this.jTextField8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2627 */     this.jLabel58.setText("Coloque el importe");
/*      */     
/* 2629 */     this.jLabel59.setFont(new Font("Tahoma", 1, 14));
/* 2630 */     this.jLabel59.setHorizontalAlignment(4);
/* 2631 */     this.jLabel59.setText("$ 100,000.00");
/*      */     
/* 2633 */     this.jLabel60.setHorizontalAlignment(4);
/* 2634 */     this.jLabel60.setText("Total");
/*      */     
/* 2636 */     this.jButton26.setMnemonic('Q');
/* 2637 */     this.jButton26.setText("Quitar");
/* 2638 */     this.jButton26.setToolTipText("Quitar Concepto (Alt+Q)");
/* 2639 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2641 */             PrefacturaCliente.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2645 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 2646 */     this.jPanel19.setLayout(jPanel19Layout);
/* 2647 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 2648 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2649 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2650 */           .addContainerGap()
/* 2651 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2652 */             .addComponent(this.jButton24, GroupLayout.Alignment.TRAILING, -2, 104, -2)
/* 2653 */             .addComponent(this.jSeparator19, -1, 439, 32767)
/* 2654 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 2655 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2656 */                 .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2657 */                   .addComponent(this.jSeparator18, GroupLayout.Alignment.LEADING)
/* 2658 */                   .addComponent(this.jScrollPane11, GroupLayout.Alignment.LEADING, -1, 437, 32767))
/* 2659 */                 .addGroup(jPanel19Layout.createSequentialGroup()
/* 2660 */                   .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2661 */                     .addComponent(this.jLabel56, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2662 */                     .addComponent(this.jLabel55, GroupLayout.Alignment.LEADING, -2, 1, 32767)
/* 2663 */                     .addComponent(this.jLabel58, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2664 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2665 */                   .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2666 */                     .addGroup(jPanel19Layout.createSequentialGroup()
/* 2667 */                       .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2668 */                         .addComponent(this.jFormattedTextField1, GroupLayout.Alignment.LEADING)
/* 2669 */                         .addComponent(this.jTextField8, GroupLayout.Alignment.LEADING, -1, 197, 32767))
/* 2670 */                       .addGap(18, 18, 18)
/* 2671 */                       .addComponent(this.jButton25, -2, 85, -2))
/* 2672 */                     .addComponent(this.jSpinner1, -2, -1, -2)))
/* 2673 */                 .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2674 */                   .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2675 */                   .addComponent(this.jSeparator17, GroupLayout.Alignment.LEADING, -1, 427, 32767))
/* 2676 */                 .addGroup(jPanel19Layout.createSequentialGroup()
/* 2677 */                   .addComponent(this.jButton26, -2, 96, -2)
/* 2678 */                   .addGap(149, 149, 149)
/* 2679 */                   .addComponent(this.jLabel60, -2, 54, -2)
/* 2680 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2681 */                   .addComponent(this.jLabel59, -2, 118, -2)))
/* 2682 */               .addGap(2, 2, 2)))
/* 2683 */           .addContainerGap()));
/*      */     
/* 2685 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 2686 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2687 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2688 */           .addComponent(this.jLabel54)
/* 2689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2690 */           .addComponent(this.jSeparator17, -2, 10, -2)
/* 2691 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2692 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2693 */             .addComponent(this.jLabel55)
/* 2694 */             .addComponent(this.jSpinner1, -2, -1, -2))
/* 2695 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2696 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2697 */             .addComponent(this.jLabel56)
/* 2698 */             .addComponent(this.jTextField8, -2, -1, -2))
/* 2699 */           .addGap(9, 9, 9)
/* 2700 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2701 */             .addComponent(this.jLabel58)
/* 2702 */             .addComponent(this.jFormattedTextField1, -2, -1, -2)
/* 2703 */             .addComponent(this.jButton25))
/* 2704 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2705 */           .addComponent(this.jSeparator18, -2, 10, -2)
/* 2706 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2707 */           .addComponent(this.jScrollPane11, -2, 142, -2)
/* 2708 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2709 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2710 */             .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2711 */               .addComponent(this.jLabel59, -1, 35, 32767)
/* 2712 */               .addComponent(this.jLabel60, -1, 35, 32767))
/* 2713 */             .addComponent(this.jButton26))
/* 2714 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2715 */           .addComponent(this.jSeparator19, -2, 10, -2)
/* 2716 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2717 */           .addComponent(this.jButton24)
/* 2718 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2721 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2722 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2723 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2724 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2725 */         .addGroup(jDialog9Layout.createSequentialGroup()
/* 2726 */           .addComponent(this.jPanel19, -1, -1, 32767)
/* 2727 */           .addContainerGap()));
/*      */     
/* 2729 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2730 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2731 */         .addComponent(this.jPanel19, -2, -1, -2));
/*      */ 
/*      */     
/* 2734 */     this.jDialog10.setTitle("Cancelar prefactura");
/* 2735 */     this.jDialog10.setModal(true);
/*      */     
/* 2737 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 2739 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 2740 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 2741 */     this.jLabel124.setHorizontalAlignment(0);
/* 2742 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 2744 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 2745 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 2746 */     this.jLabel125.setHorizontalAlignment(4);
/* 2747 */     this.jLabel125.setText("Motivo");
/*      */     
/* 2749 */     this.jButton44.setMnemonic('A');
/* 2750 */     this.jButton44.setText("Cancelar prefactura");
/* 2751 */     this.jButton44.setToolTipText("Cancelar Factura (Alt+A)");
/* 2752 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2754 */             PrefacturaCliente.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2758 */     this.jButton45.setMnemonic('C');
/* 2759 */     this.jButton45.setText("Cerrar");
/* 2760 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 2761 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2763 */             PrefacturaCliente.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2767 */     this.jTextArea5.setColumns(20);
/* 2768 */     this.jTextArea5.setLineWrap(true);
/* 2769 */     this.jTextArea5.setRows(5);
/* 2770 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 2772 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar la factura");
/*      */     
/* 2774 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 2775 */     this.jPanel29.setLayout(jPanel29Layout);
/* 2776 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 2777 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2778 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 2779 */           .addContainerGap()
/* 2780 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2781 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 2782 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2783 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 2784 */                 .addComponent(this.jButton44, -2, 137, -2)
/* 2785 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2786 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 2787 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 2788 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 2789 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2790 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 2791 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2792 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2793 */               .addComponent(this.jSeparator27, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 2794 */           .addContainerGap()));
/*      */     
/* 2796 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 2797 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2798 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 2799 */           .addComponent(this.jLabel124)
/* 2800 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2801 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 2802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2803 */           .addComponent(this.jLabel126)
/* 2804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2805 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2806 */             .addComponent(this.jLabel125)
/* 2807 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 2808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2809 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2810 */             .addComponent(this.jButton45)
/* 2811 */             .addComponent(this.jButton44))
/* 2812 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2815 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2816 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2817 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2819 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 2821 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2822 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2823 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 2826 */     this.jTable11.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "F Serv", "Rspr", "Origen", "Destino", "No Doc.", "M3", "Peso", "Manifiesto", "P Unit", "Importe" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2834 */     this.jScrollPane13.setViewportView(this.jTable11);
/* 2835 */     if (this.jTable11.getColumnModel().getColumnCount() > 0) {
/* 2836 */       this.jTable11.getColumnModel().getColumn(0).setMinWidth(70);
/* 2837 */       this.jTable11.getColumnModel().getColumn(0).setMaxWidth(70);
/* 2838 */       this.jTable11.getColumnModel().getColumn(5).setMinWidth(60);
/* 2839 */       this.jTable11.getColumnModel().getColumn(5).setMaxWidth(60);
/* 2840 */       this.jTable11.getColumnModel().getColumn(6).setMinWidth(40);
/* 2841 */       this.jTable11.getColumnModel().getColumn(6).setMaxWidth(40);
/* 2842 */       this.jTable11.getColumnModel().getColumn(7).setMinWidth(40);
/* 2843 */       this.jTable11.getColumnModel().getColumn(7).setMaxWidth(40);
/*      */     } 
/*      */     
/* 2846 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2847 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2848 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2850 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2851 */           .addContainerGap()
/* 2852 */           .addComponent(this.jScrollPane13, -1, 794, 32767)
/* 2853 */           .addContainerGap()));
/*      */     
/* 2855 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2857 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2858 */           .addContainerGap()
/* 2859 */           .addComponent(this.jScrollPane13, -2, 326, -2)
/* 2860 */           .addContainerGap(14, 32767)));
/*      */ 
/*      */     
/* 2863 */     this.jDialog14.setTitle("Cobrar a");
/*      */     
/* 2865 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/* 2866 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder("Cobrar a"));
/*      */     
/* 2868 */     this.jLabel94.setText("Linea1:");
/*      */     
/* 2870 */     this.jLabel95.setText("Linea2:");
/*      */     
/* 2872 */     this.jLabel96.setText("Linea3:");
/*      */     
/* 2874 */     this.jLabel97.setText("Linea4:");
/*      */     
/* 2876 */     this.jButton39.setMnemonic('C');
/* 2877 */     this.jButton39.setText("Cerrar");
/* 2878 */     this.jButton39.setToolTipText("Cerrar (Alt+C)");
/* 2879 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2881 */             PrefacturaCliente.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2885 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 2886 */     this.jPanel26.setLayout(jPanel26Layout);
/* 2887 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 2888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2889 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 2890 */           .addContainerGap()
/* 2891 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2892 */             .addComponent(this.jLabel97, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2893 */             .addComponent(this.jLabel96, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2894 */             .addComponent(this.jLabel95, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2895 */             .addComponent(this.jLabel94, -2, 43, -2))
/* 2896 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2897 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2898 */             .addComponent(this.jTextField39, -1, 239, 32767)
/* 2899 */             .addComponent(this.jTextField40)
/* 2900 */             .addComponent(this.jTextField41)
/* 2901 */             .addComponent(this.jTextField42))
/* 2902 */           .addContainerGap(-1, 32767))
/* 2903 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/* 2904 */           .addContainerGap(211, 32767)
/* 2905 */           .addComponent(this.jButton39, -2, 98, -2)
/* 2906 */           .addContainerGap()));
/*      */     
/* 2908 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 2909 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2910 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 2911 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2912 */             .addComponent(this.jLabel94)
/* 2913 */             .addComponent(this.jTextField39))
/* 2914 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2915 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2916 */             .addComponent(this.jLabel95)
/* 2917 */             .addComponent(this.jTextField40))
/* 2918 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2919 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2920 */             .addComponent(this.jLabel96)
/* 2921 */             .addComponent(this.jTextField41))
/* 2922 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2923 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2924 */             .addComponent(this.jLabel97)
/* 2925 */             .addComponent(this.jTextField42))
/* 2926 */           .addGap(18, 18, 18)
/* 2927 */           .addComponent(this.jButton39)
/* 2928 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/* 2931 */     GroupLayout jDialog14Layout = new GroupLayout(this.jDialog14.getContentPane());
/* 2932 */     this.jDialog14.getContentPane().setLayout(jDialog14Layout);
/* 2933 */     jDialog14Layout.setHorizontalGroup(jDialog14Layout
/* 2934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2935 */         .addComponent(this.jPanel26, -2, -1, -2));
/*      */     
/* 2937 */     jDialog14Layout.setVerticalGroup(jDialog14Layout
/* 2938 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2939 */         .addComponent(this.jPanel26, -2, -1, -2));
/*      */ 
/*      */     
/* 2942 */     this.jDialog15.setTitle("Coloca el tractor");
/*      */     
/* 2944 */     this.jPanel34.setBackground(Color.white);
/*      */     
/* 2946 */     this.jLabel88.setFont(new Font("Times New Roman", 1, 14));
/* 2947 */     this.jLabel88.setHorizontalAlignment(0);
/* 2948 */     this.jLabel88.setText("Coloca la nueva cantidad");
/*      */     
/* 2950 */     this.jLabel90.setText("Cantidad");
/*      */     
/* 2952 */     this.jButton42.setText("Cancelar");
/* 2953 */     this.jButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2955 */             PrefacturaCliente.this.jButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2959 */     this.jButton43.setText("Aceptar");
/* 2960 */     this.jButton43.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2962 */             PrefacturaCliente.this.jButton43ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2966 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/* 2967 */     this.jFormattedTextField5.setFont(new Font("Tahoma", 1, 19));
/*      */     
/* 2969 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 2970 */     this.jPanel34.setLayout(jPanel34Layout);
/* 2971 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 2972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2973 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 2974 */           .addContainerGap()
/* 2975 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2976 */             .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2977 */               .addComponent(this.jSeparator21, GroupLayout.Alignment.LEADING)
/* 2978 */               .addComponent(this.jLabel88, GroupLayout.Alignment.LEADING, -1, 230, 32767))
/* 2979 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 2980 */               .addComponent(this.jLabel90, -2, 60, -2)
/* 2981 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2982 */               .addComponent(this.jFormattedTextField5, 0, 1, 32767))
/* 2983 */             .addComponent(this.jSeparator22, -1, 230, 32767)
/* 2984 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 2985 */               .addComponent(this.jButton43, -2, 83, -2)
/* 2986 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2987 */               .addComponent(this.jButton42, -2, 83, -2)))
/* 2988 */           .addContainerGap()));
/*      */     
/* 2990 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 2991 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2992 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 2993 */           .addComponent(this.jLabel88)
/* 2994 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2995 */           .addComponent(this.jSeparator21, -2, 10, -2)
/* 2996 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2997 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2998 */             .addComponent(this.jLabel90, -2, 41, -2)
/* 2999 */             .addComponent(this.jFormattedTextField5, -2, 41, -2))
/* 3000 */           .addGap(21, 21, 21)
/* 3001 */           .addComponent(this.jSeparator22, -2, 10, -2)
/* 3002 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3003 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3004 */             .addComponent(this.jButton42)
/* 3005 */             .addComponent(this.jButton43))
/* 3006 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3009 */     GroupLayout jDialog15Layout = new GroupLayout(this.jDialog15.getContentPane());
/* 3010 */     this.jDialog15.getContentPane().setLayout(jDialog15Layout);
/* 3011 */     jDialog15Layout.setHorizontalGroup(jDialog15Layout
/* 3012 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3013 */         .addComponent(this.jPanel34, -2, -1, -2));
/*      */     
/* 3015 */     jDialog15Layout.setVerticalGroup(jDialog15Layout
/* 3016 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3017 */         .addComponent(this.jPanel34, -2, -1, -2));
/*      */ 
/*      */     
/* 3020 */     this.jDialog16.setTitle("Selecciona el tipo de prefactura");
/*      */     
/* 3022 */     this.jPanel42.setBackground(new Color(255, 255, 255));
/*      */     
/* 3024 */     this.jLabel92.setFont(new Font("Times New Roman", 1, 14));
/* 3025 */     this.jLabel92.setHorizontalAlignment(0);
/* 3026 */     this.jLabel92.setText("Selecciona el tipo de prefactura");
/*      */     
/* 3028 */     this.jRadioButton5.setSelected(true);
/* 3029 */     this.jRadioButton5.setText("Inicial");
/*      */     
/* 3031 */     this.jLabel93.setText("<html>Selecciona esta opción si tienes creado un reporte en FORSIS</html>");
/*      */     
/* 3033 */     this.jRadioButton6.setText("A partir de reporte interno");
/*      */     
/* 3035 */     this.jLabel100.setText("<html>Selecciona esta opción para empezar la factura sin ningún viaje</html>");
/*      */     
/* 3037 */     this.jButton50.setText("Siguiente>>");
/* 3038 */     this.jButton50.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3040 */             PrefacturaCliente.this.jButton50ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3044 */     this.jButton51.setText("Cancelar");
/* 3045 */     this.jButton51.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3047 */             PrefacturaCliente.this.jButton51ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3051 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 3052 */     this.jPanel42.setLayout(jPanel42Layout);
/* 3053 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 3054 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3055 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 3056 */           .addContainerGap()
/* 3057 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3058 */             .addGroup(jPanel42Layout.createSequentialGroup()
/* 3059 */               .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3060 */                 .addComponent(this.jLabel92, -1, 320, 32767)
/* 3061 */                 .addComponent(this.jSeparator29)
/* 3062 */                 .addComponent(this.jRadioButton6, -2, 212, -2)
/* 3063 */                 .addComponent(this.jRadioButton5, -2, 208, -2))
/* 3064 */               .addContainerGap(-1, 32767))
/* 3065 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
/* 3066 */               .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3067 */                 .addComponent(this.jLabel93, GroupLayout.Alignment.TRAILING, -2, 280, -2)
/* 3068 */                 .addComponent(this.jLabel100, GroupLayout.Alignment.TRAILING, -2, 280, -2)
/* 3069 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
/* 3070 */                   .addComponent(this.jButton51, -2, 103, -2)
/* 3071 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3072 */                   .addComponent(this.jButton50, -2, 103, -2))
/* 3073 */                 .addComponent(this.jSeparator30, GroupLayout.Alignment.TRAILING, -1, 312, 32767))
/* 3074 */               .addGap(20, 20, 20)))));
/*      */     
/* 3076 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 3077 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3078 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 3079 */           .addComponent(this.jLabel92)
/* 3080 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3081 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 3082 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3083 */           .addComponent(this.jRadioButton5)
/* 3084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3085 */           .addComponent(this.jLabel100, -2, 44, -2)
/* 3086 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3087 */           .addComponent(this.jRadioButton6)
/* 3088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3089 */           .addComponent(this.jLabel93, -2, 44, -2)
/* 3090 */           .addGap(32, 32, 32)
/* 3091 */           .addComponent(this.jSeparator30, -2, 10, -2)
/* 3092 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3093 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3094 */             .addComponent(this.jButton50)
/* 3095 */             .addComponent(this.jButton51))
/* 3096 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3099 */     GroupLayout jDialog16Layout = new GroupLayout(this.jDialog16.getContentPane());
/* 3100 */     this.jDialog16.getContentPane().setLayout(jDialog16Layout);
/* 3101 */     jDialog16Layout.setHorizontalGroup(jDialog16Layout
/* 3102 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3103 */         .addComponent(this.jPanel42, -2, -1, -2));
/*      */     
/* 3105 */     jDialog16Layout.setVerticalGroup(jDialog16Layout
/* 3106 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3107 */         .addComponent(this.jPanel42, -2, -1, -2));
/*      */ 
/*      */     
/* 3110 */     this.jDialog17.setTitle("Ingresa la guía");
/*      */     
/* 3112 */     this.jPanel36.setBackground(new Color(255, 255, 255));
/*      */     
/* 3114 */     this.jLabel122.setFont(new Font("Times New Roman", 1, 14));
/* 3115 */     this.jLabel122.setHorizontalAlignment(0);
/* 3116 */     this.jLabel122.setText("Ingresa los datos de la guía");
/*      */     
/* 3118 */     this.jButton53.setMnemonic('A');
/* 3119 */     this.jButton53.setText("Agregar");
/* 3120 */     this.jButton53.setToolTipText("Agregar (Alt+A)");
/* 3121 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3123 */             PrefacturaCliente.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3127 */     this.jTable13.setFont(new Font("Tahoma", 0, 10));
/* 3128 */     this.jTable13.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Columnas", "Información" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3136 */           boolean[] canEdit = new boolean[] { false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3141 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3144 */     this.jScrollPane15.setViewportView(this.jTable13);
/* 3145 */     if (this.jTable13.getColumnModel().getColumnCount() > 0) {
/* 3146 */       this.jTable13.getColumnModel().getColumn(0).setMinWidth(90);
/* 3147 */       this.jTable13.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     } 
/*      */     
/* 3150 */     this.jTextField29.setToolTipText("Presiona enter para capturar los datos de la guía");
/* 3151 */     this.jTextField29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3153 */             PrefacturaCliente.this.jTextField29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3157 */     this.jButton54.setMnemonic('C');
/* 3158 */     this.jButton54.setText("Cancelar");
/* 3159 */     this.jButton54.setToolTipText("Cancelar (Alt+C)");
/* 3160 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3162 */             PrefacturaCliente.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3166 */     this.jLabel11.setText("Coloca la guía");
/*      */     
/* 3168 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 3169 */     this.jPanel36.setLayout(jPanel36Layout);
/* 3170 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 3171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3172 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 3173 */           .addContainerGap()
/* 3174 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3175 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 3176 */               .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3177 */                 .addComponent(this.jSeparator31, GroupLayout.Alignment.LEADING, -1, 293, 32767)
/* 3178 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
/* 3179 */                   .addComponent(this.jLabel11, -2, 115, -2)
/* 3180 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3181 */                   .addComponent(this.jTextField29, -1, 174, 32767))
/* 3182 */                 .addComponent(this.jSeparator32, GroupLayout.Alignment.LEADING, -1, 293, 32767)
/* 3183 */                 .addComponent(this.jScrollPane15, GroupLayout.Alignment.LEADING, -1, 293, 32767)
/* 3184 */                 .addComponent(this.jLabel122, GroupLayout.Alignment.LEADING, -1, 293, 32767))
/* 3185 */               .addGap(16, 16, 16))
/* 3186 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 3187 */               .addComponent(this.jButton53, -2, 108, -2)
/* 3188 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3189 */               .addComponent(this.jButton54, -2, 108, -2)
/* 3190 */               .addGap(48, 48, 48)))));
/*      */     
/* 3192 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 3193 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3194 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 3195 */           .addComponent(this.jLabel122)
/* 3196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3197 */           .addComponent(this.jSeparator31, -2, 10, -2)
/* 3198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3199 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3200 */             .addComponent(this.jTextField29, -2, -1, -2)
/* 3201 */             .addComponent(this.jLabel11))
/* 3202 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3203 */           .addComponent(this.jScrollPane15, -2, 247, -2)
/* 3204 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3205 */           .addComponent(this.jSeparator32, -2, 10, -2)
/* 3206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3207 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3208 */             .addComponent(this.jButton53)
/* 3209 */             .addComponent(this.jButton54))
/* 3210 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3213 */     GroupLayout jDialog17Layout = new GroupLayout(this.jDialog17.getContentPane());
/* 3214 */     this.jDialog17.getContentPane().setLayout(jDialog17Layout);
/* 3215 */     jDialog17Layout.setHorizontalGroup(jDialog17Layout
/* 3216 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3217 */         .addComponent(this.jPanel36, -1, -1, 32767));
/*      */     
/* 3219 */     jDialog17Layout.setVerticalGroup(jDialog17Layout
/* 3220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3221 */         .addGroup(jDialog17Layout.createSequentialGroup()
/* 3222 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 3223 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3226 */     this.jDialog18.setTitle("Otros Conceptos");
/*      */     
/* 3228 */     this.jPanel43.setBackground(new Color(255, 255, 255));
/*      */     
/* 3230 */     this.jLabel101.setFont(new Font("Tahoma", 1, 14));
/* 3231 */     this.jLabel101.setHorizontalAlignment(0);
/* 3232 */     this.jLabel101.setText("Otros Conceptos");
/*      */     
/* 3234 */     this.jLabel102.setText("Seleccione la cantidad");
/*      */     
/* 3236 */     this.jLabel103.setText("Coloque el concepto");
/*      */     
/* 3238 */     this.jButton55.setMnemonic('A');
/* 3239 */     this.jButton55.setText("Agregar");
/* 3240 */     this.jButton55.setToolTipText("Agregar Conceptos (Alt+A)");
/* 3241 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3243 */             PrefacturaCliente.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3247 */     this.jSpinner2.setModel(new SpinnerNumberModel(Float.valueOf(1.0F), Float.valueOf(1.0F), Float.valueOf(100.0F), Float.valueOf(1.0F)));
/*      */     
/* 3249 */     this.jLabel104.setText("Precio Unitario");
/*      */     
/* 3251 */     this.jFormattedTextField7.setHorizontalAlignment(4);
/*      */     
/* 3253 */     this.jTextArea2.setColumns(20);
/* 3254 */     this.jTextArea2.setLineWrap(true);
/* 3255 */     this.jTextArea2.setRows(5);
/* 3256 */     this.jScrollPane17.setViewportView(this.jTextArea2);
/*      */     
/* 3258 */     this.jButton56.setMnemonic('C');
/* 3259 */     this.jButton56.setText("Cancelar");
/* 3260 */     this.jButton56.setToolTipText("Cancelar (Alt+C)");
/* 3261 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3263 */             PrefacturaCliente.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3267 */     this.jLabel130.setText("Importe");
/*      */     
/* 3269 */     this.jFormattedTextField11.setEditable(false);
/* 3270 */     this.jFormattedTextField11.setHorizontalAlignment(4);
/*      */     
/* 3272 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 3273 */     this.jPanel43.setLayout(jPanel43Layout);
/* 3274 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 3275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3276 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 3277 */           .addContainerGap()
/* 3278 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3279 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 3280 */               .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3281 */                 .addComponent(this.jLabel103, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 3282 */                 .addComponent(this.jLabel102, GroupLayout.Alignment.LEADING, -2, 1, 32767))
/* 3283 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3284 */               .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3285 */                 .addComponent(this.jScrollPane17, -1, 309, 32767)
/* 3286 */                 .addComponent(this.jFormattedTextField7, -1, 309, 32767)
/* 3287 */                 .addComponent(this.jFormattedTextField11, -1, 309, 32767)
/* 3288 */                 .addComponent(this.jSpinner2, -2, 70, -2)))
/* 3289 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 3290 */               .addGap(0, 219, 32767)
/* 3291 */               .addComponent(this.jButton55, -2, 100, -2)
/* 3292 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3293 */               .addComponent(this.jButton56, -2, 100, -2))
/* 3294 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 3295 */               .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3296 */                 .addComponent(this.jSeparator34, -2, -1, -2)
/* 3297 */                 .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3298 */                   .addComponent(this.jLabel101, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 3299 */                   .addComponent(this.jSeparator33, GroupLayout.Alignment.LEADING, -1, 427, 32767))
/* 3300 */                 .addComponent(this.jLabel104, -2, 106, -2)
/* 3301 */                 .addComponent(this.jLabel130, -2, 80, -2))
/* 3302 */               .addGap(0, 0, 32767)))
/* 3303 */           .addContainerGap()));
/*      */     
/* 3305 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 3306 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3307 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 3308 */           .addComponent(this.jLabel101)
/* 3309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3310 */           .addComponent(this.jSeparator33, -2, 10, -2)
/* 3311 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3312 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3313 */             .addComponent(this.jLabel102)
/* 3314 */             .addComponent(this.jSpinner2, -2, -1, -2))
/* 3315 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3316 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3317 */             .addGroup(jPanel43Layout.createSequentialGroup()
/* 3318 */               .addComponent(this.jLabel103)
/* 3319 */               .addGap(38, 38, 38)
/* 3320 */               .addComponent(this.jSeparator34, -2, 10, -2))
/* 3321 */             .addComponent(this.jScrollPane17, -2, 119, -2))
/* 3322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3323 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3324 */             .addComponent(this.jLabel104)
/* 3325 */             .addComponent(this.jFormattedTextField7, -2, -1, -2))
/* 3326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3327 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3328 */             .addComponent(this.jLabel130)
/* 3329 */             .addComponent(this.jFormattedTextField11, -2, -1, -2))
/* 3330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767)
/* 3331 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3332 */             .addComponent(this.jButton56)
/* 3333 */             .addComponent(this.jButton55))
/* 3334 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3337 */     GroupLayout jDialog18Layout = new GroupLayout(this.jDialog18.getContentPane());
/* 3338 */     this.jDialog18.getContentPane().setLayout(jDialog18Layout);
/* 3339 */     jDialog18Layout.setHorizontalGroup(jDialog18Layout
/* 3340 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3341 */         .addComponent(this.jPanel43, -1, -1, 32767));
/*      */     
/* 3343 */     jDialog18Layout.setVerticalGroup(jDialog18Layout
/* 3344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3345 */         .addComponent(this.jPanel43, -1, -1, 32767));
/*      */ 
/*      */     
/* 3348 */     this.jPanel22.setBackground(Color.white);
/*      */     
/* 3350 */     this.jLabel44.setFont(new Font("Times New Roman", 1, 14));
/* 3351 */     this.jLabel44.setHorizontalAlignment(0);
/* 3352 */     this.jLabel44.setText("Aplicar Retención");
/*      */     
/* 3354 */     this.jPanel5.setBackground(Color.white);
/* 3355 */     this.jPanel5.setLayout(new GridLayout(2, 0));
/*      */     
/* 3357 */     this.jRadioButton8.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 3358 */     this.jRadioButton8.setText("Sólo Viajes");
/* 3359 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3361 */             PrefacturaCliente.this.jRadioButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3364 */     this.jPanel5.add(this.jRadioButton8);
/*      */     
/* 3366 */     this.jLabel106.setFont(new Font("Tahoma", 2, 11));
/* 3367 */     this.jLabel106.setText("<html>Selecciona esta opción si sólo quieres aplicar retención al apartado de viajes</html>");
/* 3368 */     this.jPanel5.add(this.jLabel106);
/*      */     
/* 3370 */     this.jPanel8.setBackground(Color.white);
/* 3371 */     this.jPanel8.setLayout(new GridLayout(2, 0));
/*      */     
/* 3373 */     this.jRadioButton7.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 3374 */     this.jRadioButton7.setText("A Subtotal");
/* 3375 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3377 */             PrefacturaCliente.this.jRadioButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3380 */     this.jPanel8.add(this.jRadioButton7);
/*      */     
/* 3382 */     this.jLabel105.setFont(new Font("Tahoma", 2, 11));
/* 3383 */     this.jLabel105.setText("<html>Selecciona esta opción para aplicar a la cantidad de Subtotal (Viajes y Otros conceptos)</html>");
/* 3384 */     this.jPanel8.add(this.jLabel105);
/*      */     
/* 3386 */     this.jPanel23.setBackground(Color.white);
/* 3387 */     this.jPanel23.setLayout(new GridLayout(2, 0));
/*      */     
/* 3389 */     this.jRadioButton9.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 3390 */     this.jRadioButton9.setText("Sólo Otros Conceptos");
/* 3391 */     this.jRadioButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3393 */             PrefacturaCliente.this.jRadioButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3396 */     this.jPanel23.add(this.jRadioButton9);
/*      */     
/* 3398 */     this.jLabel123.setFont(new Font("Tahoma", 2, 11));
/* 3399 */     this.jLabel123.setText("<html>Selecciona esta opción para aplicar retención a los datos de otros conceptos</html>");
/* 3400 */     this.jPanel23.add(this.jLabel123);
/*      */     
/* 3402 */     this.jPanel25.setBackground(Color.white);
/* 3403 */     this.jPanel25.setLayout(new GridLayout(3, 0));
/*      */     
/* 3405 */     this.jRadioButton10.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 3406 */     this.jRadioButton10.setText("Manual");
/* 3407 */     this.jRadioButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3409 */             PrefacturaCliente.this.jRadioButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3412 */     this.jPanel25.add(this.jRadioButton10);
/*      */     
/* 3414 */     this.jLabel128.setFont(new Font("Tahoma", 2, 11));
/* 3415 */     this.jLabel128.setText("<html>Ingresa la cantidad a la que se aplicará el porcentaje de retención</html>");
/* 3416 */     this.jPanel25.add(this.jLabel128);
/*      */     
/* 3418 */     this.jPanel28.setBackground(Color.white);
/* 3419 */     this.jPanel28.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 3421 */     this.jFormattedTextField10.setHorizontalAlignment(4);
/* 3422 */     this.jPanel28.add(this.jFormattedTextField10);
/*      */     
/* 3424 */     this.jPanel31.setBackground(Color.white);
/*      */     
/* 3426 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 3427 */     this.jPanel31.setLayout(jPanel31Layout);
/* 3428 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 3429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3430 */         .addGap(0, 163, 32767));
/*      */     
/* 3432 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 3433 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3434 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/* 3437 */     this.jPanel28.add(this.jPanel31);
/*      */     
/* 3439 */     this.jPanel33.setBackground(Color.white);
/*      */     
/* 3441 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 3442 */     this.jPanel33.setLayout(jPanel33Layout);
/* 3443 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 3444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3445 */         .addGap(0, 163, 32767));
/*      */     
/* 3447 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 3448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3449 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/* 3452 */     this.jPanel28.add(this.jPanel33);
/*      */     
/* 3454 */     this.jPanel25.add(this.jPanel28);
/*      */     
/* 3456 */     this.jButton57.setMnemonic('A');
/* 3457 */     this.jButton57.setText("Aceptar");
/* 3458 */     this.jButton57.setToolTipText("Cancelar (Alt+A)");
/* 3459 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3461 */             PrefacturaCliente.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3465 */     this.jButton47.setMnemonic('C');
/* 3466 */     this.jButton47.setText("Cancelar");
/* 3467 */     this.jButton47.setToolTipText("Cancelar (Alt+C)");
/* 3468 */     this.jButton47.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3470 */             PrefacturaCliente.this.jButton47ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3474 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 3475 */     this.jPanel22.setLayout(jPanel22Layout);
/* 3476 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 3477 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3478 */         .addComponent(this.jLabel44, -1, -1, 32767)
/* 3479 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 3480 */         .addComponent(this.jPanel8, -1, 502, 32767)
/* 3481 */         .addComponent(this.jPanel23, -1, -1, 32767)
/* 3482 */         .addComponent(this.jPanel25, -1, -1, 32767)
/* 3483 */         .addComponent(this.jSeparator5)
/* 3484 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
/* 3485 */           .addContainerGap(-1, 32767)
/* 3486 */           .addComponent(this.jButton57, -2, 99, -2)
/* 3487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3488 */           .addComponent(this.jButton47, -2, 99, -2)
/* 3489 */           .addContainerGap()));
/*      */     
/* 3491 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 3492 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3493 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 3494 */           .addComponent(this.jLabel44)
/* 3495 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3496 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 3497 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3498 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 3499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3500 */           .addComponent(this.jPanel23, -2, -1, -2)
/* 3501 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3502 */           .addComponent(this.jPanel25, -2, 81, -2)
/* 3503 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3504 */           .addComponent(this.jSeparator5, -1, 10, 32767)
/* 3505 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3506 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3507 */             .addComponent(this.jButton47, -1, -1, 32767)
/* 3508 */             .addComponent(this.jButton57, -1, -1, 32767))
/* 3509 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3512 */     GroupLayout jDialog19Layout = new GroupLayout(this.jDialog19.getContentPane());
/* 3513 */     this.jDialog19.getContentPane().setLayout(jDialog19Layout);
/* 3514 */     jDialog19Layout.setHorizontalGroup(jDialog19Layout
/* 3515 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3516 */         .addComponent(this.jPanel22, -1, -1, 32767));
/*      */     
/* 3518 */     jDialog19Layout.setVerticalGroup(jDialog19Layout
/* 3519 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3520 */         .addComponent(this.jPanel22, -1, -1, 32767));
/*      */ 
/*      */     
/* 3523 */     this.jDialog20.setTitle("Autorizar Factura");
/*      */     
/* 3525 */     this.jPanel45.setBackground(new Color(255, 255, 255));
/*      */     
/* 3527 */     this.jLabel131.setFont(new Font("Times New Roman", 1, 14));
/* 3528 */     this.jLabel131.setHorizontalAlignment(0);
/* 3529 */     this.jLabel131.setText("Autorizar Factura");
/*      */     
/* 3531 */     this.jButton58.setMnemonic('C');
/* 3532 */     this.jButton58.setText("Cancelar");
/* 3533 */     this.jButton58.setToolTipText("Cancelar (Alt+C)");
/* 3534 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3536 */             PrefacturaCliente.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3540 */     this.jButton59.setMnemonic('A');
/* 3541 */     this.jButton59.setText("Aceptar");
/* 3542 */     this.jButton59.setToolTipText("Cancelar (Alt+A)");
/* 3543 */     this.jButton59.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3545 */             PrefacturaCliente.this.jButton59ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3549 */     this.jLabel140.setText("Factura:");
/*      */     
/* 3551 */     this.jTextField30.setFont(new Font("Tahoma", 1, 14));
/*      */     
/* 3553 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/* 3554 */     this.jPanel45.setLayout(jPanel45Layout);
/* 3555 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/* 3556 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3557 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 3558 */           .addContainerGap()
/* 3559 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3560 */             .addComponent(this.jLabel131, -1, -1, 32767)
/* 3561 */             .addComponent(this.jSeparator37, GroupLayout.Alignment.TRAILING)
/* 3562 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 3563 */               .addComponent(this.jLabel140, -2, 67, -2)
/* 3564 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3565 */               .addComponent(this.jTextField30, -2, 195, -2))
/* 3566 */             .addComponent(this.jSeparator38)
/* 3567 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
/* 3568 */               .addComponent(this.jButton59, -2, 99, -2)
/* 3569 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3570 */               .addComponent(this.jButton58, -2, 99, -2)))
/* 3571 */           .addContainerGap()));
/*      */     
/* 3573 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/* 3574 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3575 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 3576 */           .addComponent(this.jLabel131)
/* 3577 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3578 */           .addComponent(this.jSeparator37, -2, 10, -2)
/* 3579 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3580 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3581 */             .addComponent(this.jLabel140)
/* 3582 */             .addComponent(this.jTextField30, -2, 32, -2))
/* 3583 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3584 */           .addComponent(this.jSeparator38, -2, 10, -2)
/* 3585 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3586 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3587 */             .addComponent(this.jButton58)
/* 3588 */             .addComponent(this.jButton59))
/* 3589 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3592 */     GroupLayout jDialog20Layout = new GroupLayout(this.jDialog20.getContentPane());
/* 3593 */     this.jDialog20.getContentPane().setLayout(jDialog20Layout);
/* 3594 */     jDialog20Layout.setHorizontalGroup(jDialog20Layout
/* 3595 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3596 */         .addComponent(this.jPanel45, -2, -1, -2));
/*      */     
/* 3598 */     jDialog20Layout.setVerticalGroup(jDialog20Layout
/* 3599 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3600 */         .addComponent(this.jPanel45, -2, -1, -2));
/*      */ 
/*      */     
/* 3603 */     this.jButton10.setFont(new Font("Tahoma", 1, 11));
/* 3604 */     this.jButton10.setForeground(Color.blue);
/* 3605 */     this.jButton10.setText("<");
/* 3606 */     this.jButton10.setToolTipText("Ver facturas menos recientes (Alt+I)");
/* 3607 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3609 */             PrefacturaCliente.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3613 */     this.jButton11.setFont(new Font("Tahoma", 1, 11));
/* 3614 */     this.jButton11.setForeground(Color.blue);
/* 3615 */     this.jButton11.setText(">");
/* 3616 */     this.jButton11.setToolTipText("Ver facturas más recientes (Alt+D)");
/* 3617 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3619 */             PrefacturaCliente.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3623 */     this.jLabel3.setText("Coloca el nuevo usuario:");
/*      */     
/* 3625 */     this.jComboBox10.setBackground(Color.white);
/* 3626 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*      */     
/* 3628 */     this.jLabel18.setText("¿Estás seguro que deseas cambiar de usuario la prefactura seleccionada?");
/*      */     
/* 3630 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 3631 */     this.jPanel4.setLayout(jPanel4Layout);
/* 3632 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 3633 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3634 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 3635 */           .addComponent(this.jLabel3, -1, -1, 32767)
/* 3636 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3637 */           .addComponent(this.jComboBox10, -2, 178, -2))
/* 3638 */         .addComponent(this.jLabel18, -1, -1, 32767));
/*      */     
/* 3640 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 3641 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3642 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 3643 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3644 */             .addComponent(this.jComboBox10, -2, -1, -2)
/* 3645 */             .addComponent(this.jLabel3))
/* 3646 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3647 */           .addComponent(this.jLabel18)));
/*      */ 
/*      */     
/* 3650 */     this.jDialog21.setTitle("Calcular IVA");
/*      */     
/* 3652 */     this.jRadioButton3.setText("Iva al 16%");
/* 3653 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3655 */             PrefacturaCliente.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3659 */     this.jFormattedTextField3.setEditable(false);
/* 3660 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 3661 */     this.jFormattedTextField3.setText("jFormattedTextField3");
/*      */     
/* 3663 */     this.jRadioButton4.setText("Manual");
/* 3664 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3666 */             PrefacturaCliente.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3670 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/* 3671 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/*      */     
/* 3673 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 3674 */     this.jPanel17.setLayout(jPanel17Layout);
/* 3675 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 3676 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3677 */         .addComponent(this.jRadioButton3, -1, -1, 32767)
/* 3678 */         .addComponent(this.jRadioButton4, -1, -1, 32767)
/* 3679 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
/* 3680 */           .addContainerGap(150, 32767)
/* 3681 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3682 */             .addComponent(this.jFormattedTextField4, GroupLayout.Alignment.TRAILING, -2, 215, -2)
/* 3683 */             .addComponent(this.jFormattedTextField3, GroupLayout.Alignment.TRAILING, -2, 215, -2))
/* 3684 */           .addContainerGap()));
/*      */     
/* 3686 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 3687 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3688 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 3689 */           .addComponent(this.jRadioButton3)
/* 3690 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3691 */           .addComponent(this.jFormattedTextField3, -2, -1, -2)
/* 3692 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3693 */           .addComponent(this.jRadioButton4)
/* 3694 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3695 */           .addComponent(this.jFormattedTextField4, -2, -1, -2)));
/*      */ 
/*      */     
/* 3698 */     this.jButton27.setMnemonic('A');
/* 3699 */     this.jButton27.setText("Aceptar");
/* 3700 */     this.jButton27.setToolTipText("Aceptar (Alt+A)");
/* 3701 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3703 */             PrefacturaCliente.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3707 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 3708 */     this.jPanel2.setLayout(jPanel2Layout);
/* 3709 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 3710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3711 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 3712 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 3713 */           .addContainerGap(-1, 32767)
/* 3714 */           .addComponent(this.jButton27, -2, 148, -2)
/* 3715 */           .addContainerGap()));
/*      */     
/* 3717 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 3718 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3719 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 3720 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 3721 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3722 */           .addComponent(this.jButton27)
/* 3723 */           .addContainerGap(9, 32767)));
/*      */ 
/*      */     
/* 3726 */     GroupLayout jDialog21Layout = new GroupLayout(this.jDialog21.getContentPane());
/* 3727 */     this.jDialog21.getContentPane().setLayout(jDialog21Layout);
/* 3728 */     jDialog21Layout.setHorizontalGroup(jDialog21Layout
/* 3729 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3730 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/* 3732 */     jDialog21Layout.setVerticalGroup(jDialog21Layout
/* 3733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3734 */         .addGroup(jDialog21Layout.createSequentialGroup()
/* 3735 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 3736 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 3739 */     this.jDialog1.setTitle("Agregar guías a la prefactura");
/* 3740 */     this.jDialog1.setModal(true);
/*      */     
/* 3742 */     this.jPanel47.setBorder(BorderFactory.createTitledBorder("Selecciona el periodo que deseas buscar"));
/* 3743 */     this.jPanel47.setMaximumSize(new Dimension(500, 22));
/* 3744 */     this.jPanel47.setMinimumSize(new Dimension(500, 22));
/* 3745 */     this.jPanel47.setPreferredSize(new Dimension(500, 22));
/* 3746 */     this.jPanel47.setLayout(new GridLayout(1, 0));
/*      */     
/* 3748 */     this.jPanel49.setLayout(new GridLayout(1, 6, 10, 0));
/*      */     
/* 3750 */     this.jLabel71.setText("Fecha");
/* 3751 */     this.jPanel49.add(this.jLabel71);
/*      */     
/* 3753 */     this.jDateChooser1.setDate(this.fecha);
/* 3754 */     this.jDateChooser1.setIcon(this.icon);
/* 3755 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/* 3756 */     this.jDateChooser1.setMinSelectableDate(new Date(1283320867000L));
/* 3757 */     this.jPanel49.add((Component)this.jDateChooser1);
/*      */     
/* 3759 */     this.jLabel72.setText("hasta");
/* 3760 */     this.jPanel49.add(this.jLabel72);
/*      */     
/* 3762 */     this.jDateChooser2.setDate(this.fecha);
/* 3763 */     this.jDateChooser2.setIcon(this.icon);
/* 3764 */     this.jDateChooser2.setMaxSelectableDate(this.fecha);
/* 3765 */     this.jDateChooser2.setMinSelectableDate(new Date(1283320867000L));
/* 3766 */     this.jPanel49.add((Component)this.jDateChooser2);
/*      */     
/* 3768 */     this.jButton31.setText("Clic para buscar");
/* 3769 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3771 */             PrefacturaCliente.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3774 */     this.jPanel49.add(this.jButton31);
/*      */     
/* 3776 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 3777 */     this.jPanel51.setLayout(jPanel51Layout);
/* 3778 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 3779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3780 */         .addGap(0, 97, 32767));
/*      */     
/* 3782 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 3783 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3784 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/* 3787 */     this.jPanel49.add(this.jPanel51);
/*      */     
/* 3789 */     this.jPanel47.add(this.jPanel49);
/*      */     
/* 3791 */     this.jPanel62.setBorder(BorderFactory.createTitledBorder("Filtra la búsqueda, con algún campo"));
/* 3792 */     this.jPanel62.setLayout(new GridLayout(3, 3, 10, 6));
/*      */     
/* 3794 */     this.jLabel73.setText("Guía");
/* 3795 */     this.jPanel62.add(this.jLabel73);
/*      */     
/* 3797 */     this.jTextField7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3799 */             PrefacturaCliente.this.jTextField7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3802 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3804 */             PrefacturaCliente.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/* 3807 */     this.jPanel62.add(this.jTextField7);
/*      */     
/* 3809 */     this.jLabel74.setText("Cliente");
/* 3810 */     this.jPanel62.add(this.jLabel74);
/*      */     
/* 3812 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/* 3813 */     this.jComboBox20.setFont(new Font("Tahoma", 0, 10));
/* 3814 */     this.jComboBox20.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 3815 */     this.jComboBox20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3817 */             PrefacturaCliente.this.jComboBox20ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3820 */     this.jPanel62.add(this.jComboBox20);
/*      */     
/* 3822 */     this.jLabel75.setText("Servicio");
/* 3823 */     this.jPanel62.add(this.jLabel75);
/*      */     
/* 3825 */     this.jComboBox12.setBackground(new Color(244, 244, 244));
/* 3826 */     this.jComboBox12.setFont(new Font("Tahoma", 0, 10));
/* 3827 */     this.jComboBox12.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "FLETE", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL", "SERVICIO INTEGRAL", "SERVICIO DE RETRO", "RENTA" }));
/* 3828 */     this.jComboBox12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3830 */             PrefacturaCliente.this.jComboBox12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3833 */     this.jPanel62.add(this.jComboBox12);
/*      */     
/* 3835 */     this.jLabel76.setText("Residuo");
/* 3836 */     this.jPanel62.add(this.jLabel76);
/*      */     
/* 3838 */     this.jComboBox13.setBackground(new Color(244, 244, 244));
/* 3839 */     this.jComboBox13.setFont(new Font("Tahoma", 0, 10));
/* 3840 */     this.jComboBox13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3842 */             PrefacturaCliente.this.jComboBox13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3845 */     this.jPanel62.add(this.jComboBox13);
/*      */     
/* 3847 */     this.jLabel77.setText("Tipo");
/* 3848 */     this.jPanel62.add(this.jLabel77);
/*      */     
/* 3850 */     this.jComboBox14.setBackground(new Color(244, 244, 244));
/* 3851 */     this.jComboBox14.setFont(new Font("Tahoma", 0, 10));
/* 3852 */     this.jComboBox14.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Bulldozer", "Cama Baja", "Contenedor Marino", "Cuello de Ganzo", "Excavadora Oruga", "Góndola", "Hiab", "LowBoy", "Pipa", "Plana", "Plataforma", "Presas Metálicas", "Presión y Vacío", "Porta Contenedores", "Retroexcavadora", "Tiro Directo", "Tolva Granelera", "Tolva De Alumnio", "Tolva De Acero Inoxidable", "Tolva Presurizada", "Otro" }));
/* 3853 */     this.jComboBox14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3855 */             PrefacturaCliente.this.jComboBox14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3858 */     this.jPanel62.add(this.jComboBox14);
/*      */     
/* 3860 */     this.jLabel78.setText("Equipo");
/* 3861 */     this.jPanel62.add(this.jLabel78);
/*      */     
/* 3863 */     this.jComboBox15.setBackground(new Color(244, 244, 244));
/* 3864 */     this.jComboBox15.setFont(new Font("Tahoma", 0, 10));
/* 3865 */     this.jComboBox15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3867 */             PrefacturaCliente.this.jComboBox15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3870 */     this.jPanel62.add(this.jComboBox15);
/*      */     
/* 3872 */     this.jLabel79.setText("Plat");
/* 3873 */     this.jPanel62.add(this.jLabel79);
/*      */     
/* 3875 */     this.jComboBox16.setBackground(new Color(244, 244, 244));
/* 3876 */     this.jComboBox16.setFont(new Font("Tahoma", 0, 10));
/* 3877 */     this.jComboBox16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3879 */             PrefacturaCliente.this.jComboBox16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3882 */     this.jPanel62.add(this.jComboBox16);
/*      */     
/* 3884 */     this.jLabel80.setText("Pozo");
/* 3885 */     this.jPanel62.add(this.jLabel80);
/*      */     
/* 3887 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/* 3888 */     this.jComboBox17.setFont(new Font("Tahoma", 0, 10));
/* 3889 */     this.jComboBox17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3891 */             PrefacturaCliente.this.jComboBox17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3894 */     this.jPanel62.add(this.jComboBox17);
/*      */     
/* 3896 */     this.jLabel81.setText("Eco");
/* 3897 */     this.jPanel62.add(this.jLabel81);
/*      */     
/* 3899 */     this.jTextField9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3901 */             PrefacturaCliente.this.jTextField9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3904 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3906 */             PrefacturaCliente.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/* 3909 */     this.jPanel62.add(this.jTextField9);
/*      */     
/* 3911 */     this.jTable10.setFont(new Font("Tahoma", 0, 10));
/* 3912 */     this.jTable10.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3923 */     this.jTable10.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3925 */             PrefacturaCliente.this.jTable10MouseClicked(evt);
/*      */           }
/*      */         });
/* 3928 */     this.jScrollPane12.setViewportView(this.jTable10);
/*      */     
/* 3930 */     this.jLabel82.setFont(new Font("Tahoma", 1, 11));
/* 3931 */     this.jLabel82.setForeground(Color.red);
/* 3932 */     this.jLabel82.setHorizontalAlignment(0);
/* 3933 */     this.jLabel82.setText("t");
/* 3934 */     this.jLabel82.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 3936 */     this.jButton32.setMnemonic('A');
/* 3937 */     this.jButton32.setText("Agregar Guía");
/* 3938 */     this.jButton32.setToolTipText("Agregar Guía (Alt+A)");
/* 3939 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3941 */             PrefacturaCliente.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3945 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 3946 */     this.jPanel44.setLayout(jPanel44Layout);
/* 3947 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 3948 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3949 */         .addComponent(this.jPanel47, -1, 642, 32767)
/* 3950 */         .addComponent(this.jPanel62, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
/* 3951 */         .addComponent(this.jScrollPane12)
/* 3952 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 3953 */           .addComponent(this.jLabel82, -2, 135, -2)
/* 3954 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3955 */           .addComponent(this.jButton32, -2, 116, -2)
/* 3956 */           .addContainerGap()));
/*      */     
/* 3958 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 3959 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3960 */         .addGroup(jPanel44Layout.createSequentialGroup()
/* 3961 */           .addComponent(this.jPanel47, -2, 49, -2)
/* 3962 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3963 */           .addComponent(this.jPanel62, -2, -1, -2)
/* 3964 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3965 */           .addComponent(this.jScrollPane12, -1, 155, 32767)
/* 3966 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3967 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3968 */             .addComponent(this.jLabel82)
/* 3969 */             .addComponent(this.jButton32))
/* 3970 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3973 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 3974 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 3975 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 3976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3977 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */     
/* 3979 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 3980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3981 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */ 
/*      */     
/* 3984 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/* 3985 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 3987 */     this.jLabel4.setFont(new Font("Times New Roman", 1, 22));
/* 3988 */     this.jLabel4.setHorizontalAlignment(0);
/* 3989 */     this.jLabel4.setText("PREFACTURACIÓN PARA LOS CLIENTES");
/*      */     
/* 3991 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*      */     
/* 3993 */     this.jLabel1.setText("Últimas prefacturas ingresadas");
/*      */     
/* 3995 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 3996 */     this.jTable1.setForeground(Color.gray);
/* 3997 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Periodo", "Elaboró", "Cliente", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4005 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4007 */             PrefacturaCliente.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/* 4010 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 4012 */     this.jButton1.setMnemonic('C');
/* 4013 */     this.jButton1.setText("Consultar");
/* 4014 */     this.jButton1.setToolTipText("Consulta la prefactura seleccionada (Alt+C)");
/* 4015 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4017 */             PrefacturaCliente.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4021 */     this.jButton2.setMnemonic('P');
/* 4022 */     this.jButton2.setText("Prefacuras");
/* 4023 */     this.jButton2.setToolTipText("Entra al módulo de Prefacuras (Alt+P)");
/* 4024 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4026 */             PrefacturaCliente.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4030 */     this.jButton3.setMnemonic('U');
/* 4031 */     this.jButton3.setText("Ver del Usuario");
/* 4032 */     this.jButton3.setToolTipText("Muestra las prefacturas creadas por el usuario seleccionado (Alt+U)");
/* 4033 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4035 */             PrefacturaCliente.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4039 */     this.jSeparator2.setOrientation(1);
/*      */     
/* 4041 */     this.jLabel2.setText("Viajes pendientes por prefacturar");
/*      */     
/* 4043 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 4044 */     this.jTable3.setForeground(Color.gray);
/* 4045 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guía", "Fecha", "Cliente", "Residuo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4053 */           boolean[] canEdit = new boolean[] { false, false, true, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4058 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4061 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4063 */             PrefacturaCliente.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 4066 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 4068 */     this.jButton6.setMnemonic('V');
/* 4069 */     this.jButton6.setText("Ver");
/* 4070 */     this.jButton6.setToolTipText("Ver detalle del viaje (Alt+V)");
/* 4071 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4073 */             PrefacturaCliente.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4077 */     this.jLabel28.setFont(new Font("Times New Roman", 1, 12));
/* 4078 */     this.jLabel28.setHorizontalAlignment(4);
/* 4079 */     this.jLabel28.setText("jLabel28");
/*      */     
/* 4081 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 4082 */     this.jPanel1.setLayout(jPanel1Layout);
/* 4083 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 4084 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4085 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 4086 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4087 */             .addComponent(this.jLabel1, -2, 234, -2)
/* 4088 */             .addComponent(this.jScrollPane1, -2, 447, -2))
/* 4089 */           .addGap(12, 12, 12)
/* 4090 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4091 */             .addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 4092 */             .addComponent(this.jButton1, -1, -1, 32767)
/* 4093 */             .addComponent(this.jButton3, -1, -1, 32767))
/* 4094 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4095 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 4096 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4097 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4098 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 4099 */               .addComponent(this.jLabel2, -2, 183, -2)
/* 4100 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4101 */               .addComponent(this.jLabel28, -2, 127, -2))
/* 4102 */             .addComponent(this.jScrollPane3, -2, 460, -2))
/* 4103 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4104 */           .addComponent(this.jButton6, -2, 74, -2)
/* 4105 */           .addContainerGap(-1, 32767)));
/*      */     
/* 4107 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 4108 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4109 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 4110 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4111 */             .addComponent(this.jLabel1)
/* 4112 */             .addComponent(this.jLabel2)
/* 4113 */             .addComponent(this.jLabel28))
/* 4114 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4115 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4116 */             .addComponent(this.jButton6)
/* 4117 */             .addComponent(this.jScrollPane3, -1, 254, 32767)
/* 4118 */             .addComponent(this.jSeparator2, -1, 254, 32767)
/* 4119 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 4120 */               .addComponent(this.jButton1)
/* 4121 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4122 */               .addComponent(this.jButton3)
/* 4123 */               .addGap(26, 26, 26)
/* 4124 */               .addComponent(this.jButton2))
/* 4125 */             .addComponent(this.jScrollPane1, -1, 282, 32767))
/* 4126 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4129 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 4130 */     this.jPanel7.setLayout(jPanel7Layout);
/* 4131 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 4132 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4133 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 4134 */           .addContainerGap()
/* 4135 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4136 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 4137 */             .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 4138 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/* 4139 */               .addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, 1155, 32767)))
/* 4140 */           .addContainerGap(-1, 32767)));
/*      */     
/* 4142 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 4143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4144 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 4145 */           .addComponent(this.jLabel4)
/* 4146 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4147 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 4148 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4149 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 4150 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4153 */     GroupLayout layout = new GroupLayout(this);
/* 4154 */     setLayout(layout);
/* 4155 */     layout.setHorizontalGroup(layout
/* 4156 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4157 */         .addGap(0, 1212, 32767)
/* 4158 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4159 */           .addGroup(layout.createSequentialGroup()
/* 4160 */             .addGap(0, 16, 32767)
/* 4161 */             .addComponent(this.jPanel7, -2, -1, -2)
/* 4162 */             .addGap(0, 16, 32767))));
/*      */     
/* 4164 */     layout.setVerticalGroup(layout
/* 4165 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4166 */         .addGap(0, 399, 32767)
/* 4167 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4168 */           .addGroup(layout.createSequentialGroup()
/* 4169 */             .addGap(11, 11, 11)
/* 4170 */             .addComponent(this.jPanel7, -1, -1, 32767)
/* 4171 */             .addGap(11, 11, 11))));
/*      */   }
/*      */   private JRadioButton jRadioButton1; private JRadioButton jRadioButton10; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JScrollPane jScrollPane16; private JScrollPane jScrollPane17; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator12; private JSeparator jSeparator13; private JSeparator jSeparator14; private JSeparator jSeparator15; private JSeparator jSeparator16; private JSeparator jSeparator17; private JSeparator jSeparator18; private JSeparator jSeparator19; private JSeparator jSeparator2; private JSeparator jSeparator20; private JSeparator jSeparator21; private JSeparator jSeparator22; private JSeparator jSeparator27; private JSeparator jSeparator29; private JSeparator jSeparator30; private JSeparator jSeparator31; private JSeparator jSeparator32; private JSeparator jSeparator33; private JSeparator jSeparator34; private JSeparator jSeparator37; private JSeparator jSeparator38; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JSeparator jSeparator9; private JSpinner jSpinner1; private JSpinner jSpinner2; private JTable jTable1; private JTable jTable10; private JTable jTable11; private JTable jTable12; private JTable jTable13; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTable jTable7; private JTable jTable8; private JTable jTable9; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField2; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 4176 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 4180 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 4181 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 4186 */     if (this.jComboBox2.getItemCount() > 0 && this.PRIMERA == true) {
/* 4187 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 4192 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/* 4193 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 4198 */     if (evt.getClickCount() == 2) {
/* 4199 */       this.TONELADA = false;
/* 4200 */       this.VENTANA = true;
/* 4201 */       this.jButton10.setVisible(false);
/* 4202 */       this.jButton11.setVisible(false);
/* 4203 */       this.jDateChooser4.setEnabled(false);
/* 4204 */       this.jTextField3.setEnabled(false);
/*      */       
/* 4206 */       this.jButton46.setEnabled(false);
/* 4207 */       this.jButton49.setEnabled(false);
/* 4208 */       this.jButton48.setEnabled(false);
/* 4209 */       this.jButton52.setEnabled(false);
/* 4210 */       this.jLabel91.setEnabled(false);
/* 4211 */       this.jComboBox11.setEnabled(false);
/* 4212 */       this.jTextArea3.setEnabled(false);
/*      */       
/* 4214 */       this.jTextField11.setEnabled(false);
/* 4215 */       this.jTextField12.setEnabled(false);
/* 4216 */       this.jLabel19.setEnabled(false);
/*      */       
/* 4218 */       this.jButton9.setText("Imprimir");
/* 4219 */       this.jButton9.setMnemonic('I');
/* 4220 */       this.jButton9.setToolTipText("Imprimir Prefactura (Alt+I)");
/* 4221 */       this.jComboBox11.setEnabled(false);
/* 4222 */       verPrefactura(String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/*      */     } else {
/* 4224 */       this.jButton12.setEnabled(true);
/* 4225 */       this.jButton30.setEnabled(true);
/*      */       
/* 4227 */       if (this.PRIVILEGIOS.equals("SUPER USUARIO") || this.PRIVILEGIOS.equals("ADMINISTRADOR")) {
/* 4228 */         this.jButton38.setEnabled(true);
/* 4229 */         this.jButton40.setEnabled(true);
/* 4230 */         this.jButton40.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 4236 */     this.jRadioButton5.setSelected(true);
/* 4237 */     limpiarTabla();
/* 4238 */     this.jDialog16.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 4242 */     int ind = this.jTable2.getSelectedRow();
/* 4243 */     if (ind < 0) {
/* 4244 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una prefactura para ver el detalle de los viajes", "Selecciona una Prefactura", 0, this.ERROR);
/*      */     } else {
/* 4246 */       this.jComboBox11.setEnabled(false);
/* 4247 */       this.jTextArea3.setEnabled(false);
/* 4248 */       this.VENTANA = true;
/* 4249 */       this.TONELADA = false;
/* 4250 */       this.jButton10.setVisible(false);
/* 4251 */       this.jButton11.setVisible(false);
/* 4252 */       this.jDateChooser4.setEnabled(false);
/* 4253 */       this.jTextField3.setEnabled(false);
/*      */       
/* 4255 */       this.jTextField11.setEnabled(false);
/* 4256 */       this.jTextField12.setEnabled(false);
/*      */       
/* 4258 */       this.jLabel19.setEnabled(false);
/* 4259 */       this.jLabel91.setEnabled(false);
/*      */       
/* 4261 */       this.jButton9.setText("Imprimir");
/* 4262 */       this.jButton9.setMnemonic('I');
/* 4263 */       this.jButton9.setToolTipText("Imprimir Prefactura (Alt+I)");
/* 4264 */       verPrefactura(String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 4269 */     this.jDateChooser11.setDate(this.fechaInicio);
/* 4270 */     this.jDateChooser12.setDate(this.fechaActual);
/* 4271 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 4275 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 4279 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseClicked(MouseEvent evt) {
/* 4283 */     this.jDateChooser11.setDate(this.fechaActual);
/* 4284 */     this.jDateChooser12.setDate(this.fechaActual);
/* 4285 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel38MouseEntered(MouseEvent evt) {
/* 4289 */     this.jLabel38.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseExited(MouseEvent evt) {
/* 4293 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseClicked(MouseEvent evt) {
/* 4297 */     Calendar ca = Calendar.getInstance();
/* 4298 */     Calendar fecha = Calendar.getInstance();
/* 4299 */     int aa = fecha.get(1);
/* 4300 */     int mm = fecha.get(2);
/* 4301 */     int dd = fecha.get(5);
/* 4302 */     if (dd == 1) {
/* 4303 */       if (mm == 0) {
/* 4304 */         mm = 11;
/* 4305 */         aa--;
/*      */       } else {
/* 4307 */         mm--;
/*      */       } 
/* 4309 */       int diasTotal = diasDelMes(mm, aa);
/* 4310 */       dd = diasTotal;
/*      */     } else {
/* 4312 */       dd--;
/*      */     } 
/* 4314 */     mm++;
/* 4315 */     String año = "" + aa;
/* 4316 */     String mes = "" + mm;
/* 4317 */     String dia = "" + dd;
/* 4318 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4319 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 4321 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 4322 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 4323 */     } catch (ParseException ex) {
/* 4324 */       ex.printStackTrace();
/*      */     } 
/* 4326 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel39MouseEntered(MouseEvent evt) {
/* 4330 */     this.jLabel39.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseExited(MouseEvent evt) {
/* 4334 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 4338 */     int ind = this.jTable1.getSelectedRow();
/* 4339 */     if (ind < 0) {
/* 4340 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una prefactura para ver el detalle de los viajes", "Selecciona una Prefactura", 0, this.ERROR);
/*      */     } else {
/* 4342 */       this.VENTANA = false;
/* 4343 */       this.jButton10.setVisible(true);
/* 4344 */       this.jButton11.setVisible(true);
/* 4345 */       this.jDateChooser4.setEnabled(false);
/* 4346 */       this.jTextField3.setEnabled(false);
/* 4347 */       this.jButton9.setText("Imprimir");
/* 4348 */       this.jButton9.setMnemonic('I');
/* 4349 */       this.jButton9.setToolTipText("Imprimir Prefactura (Alt+I)");
/* 4350 */       this.USUPRE = String.valueOf(this.jTable1.getValueAt(ind, 3));
/* 4351 */       this.TONELADA = false;
/* 4352 */       verPrefacturaCliente(this.USUPRE, String.valueOf(this.jTable1.getValueAt(ind, 4)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 4357 */     this.VENTANA = true;
/* 4358 */     consultar();
/* 4359 */     this.jFrame2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 4363 */     this.jFrame2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 4367 */     this.jDialog2.setVisible(false);
/* 4368 */     this.jDialog16.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 4372 */     int ind = this.jTable4.getSelectedRow();
/* 4373 */     if (ind < 0) {
/* 4374 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar una prefactura interna para poder ver los datos", "Selecciona los datos", 0, this.ADVER);
/*      */     } else {
/* 4376 */       this.jDialog2.setVisible(false);
/* 4377 */       this.jLabel19.setEnabled(true);
/* 4378 */       this.jDialog7.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 4383 */     this.jFrame1.setVisible(false);
/* 4384 */     if (this.VENTANA) {
/* 4385 */       this.jFrame2.setVisible(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jFrame1WindowClosing(WindowEvent evt) {
/* 4390 */     if (this.VENTANA) {
/* 4391 */       this.jFrame2.setVisible(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {
/* 4396 */     if (evt.getClickCount() == 2) {
/* 4397 */       limpiarTabla();
/* 4398 */       this.jDialog7.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable5MouseClicked(MouseEvent evt) {
/* 4403 */     String valor = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn()));
/* 4404 */     this.jTable5.setToolTipText("<html>" + this.jTable5.getColumnName(this.jTable5.getSelectedColumn()) + ": <b>" + valor + "</b></html>");
/* 4405 */     if (!this.jButton9.getText().equals("Imprimir")) {
/* 4406 */       if (evt.getClickCount() == 2) {
/* 4407 */         String col = this.jTable5.getColumnName(this.jTable5.getSelectedColumn());
/* 4408 */         if (col.equals("P Unit") && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4409 */           this.jDialog6.setVisible(true);
/* 4410 */         } else if ((col.equals("F Carga") || col.equals("F Desc")) && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4411 */           String fecha = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn()));
/* 4412 */           String fechaCorta = fecha.substring(0, 10);
/*      */           
/* 4414 */           String año = fechaCorta.substring(0, 4);
/* 4415 */           String mes = fechaCorta.substring(5, 7);
/* 4416 */           String dia = fechaCorta.substring(8, 10);
/* 4417 */           SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4418 */           String strFecha = dia + "-" + dia + "-" + mes;
/* 4419 */           Date fechaT = null;
/*      */           try {
/* 4421 */             fechaT = formatoDelTexto.parse(strFecha);
/* 4422 */             this.jDateChooser5.setDate(fechaT);
/* 4423 */           } catch (ParseException ex) {
/* 4424 */             ex.printStackTrace();
/*      */           } 
/* 4426 */           int res = JOptionPane.showConfirmDialog(this.jFrame1, this.jPanel15, "¿Guadar la nueva fecha?", 0, 3, this.PREG);
/* 4427 */           if (res == 0) {
/* 4428 */             SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4429 */             String cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 4430 */             año = cadenaFecha1.substring(0, 4);
/* 4431 */             mes = cadenaFecha1.substring(4, 6);
/* 4432 */             dia = cadenaFecha1.substring(6, 8);
/*      */             
/* 4434 */             this.jTable5.setValueAt(año + "-" + año + "-" + mes, this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/*      */           } 
/* 4436 */         } else if (col.equals("Tra") && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4437 */           this.jTextField4.setText(valor);
/* 4438 */           this.jDialog4.setVisible(true);
/* 4439 */         } else if (col.equals("Rem") && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4440 */           this.jTextField5.setText(valor);
/* 4441 */           this.jDialog5.setVisible(true);
/* 4442 */         } else if (col.equals("Otros $") && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4443 */           this.jSpinner1.setValue(Integer.valueOf(1));
/* 4444 */           this.jTextField8.setText("");
/* 4445 */           this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 4446 */           for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 4447 */             String valorO = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 0));
/* 4448 */             if (valorO.equals(this.OTROS[i].dameGuia())) {
/* 4449 */               this.INDICEOTROS = i;
/* 4450 */               this.jDialog9.setTitle("Otros conceptos para Guía - " + valorO);
/* 4451 */               this.jButton25.setEnabled(true);
/* 4452 */               this.jButton26.setEnabled(true);
/* 4453 */               this.OTROS[i].verDatos();
/*      */               return;
/*      */             } 
/*      */           } 
/* 4457 */         } else if ((col.equals("Peso") || col.equals("Pedido") || col.equals("Servicio") || col.equals("Residuo") || col.equals("Cliente") || col.equals("Destino") || col.equals("Operador") || col.equals("Equipo") || col.equals("Plataforma") || col.equals("Pozo") || col.equals("Tipo") || col.equals("Ticket") || col.equals("Rsp") || col.equals("Manif")) && (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar"))) {
/* 4458 */           JTextField txtCampo = new JTextField(String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn())));
/* 4459 */           JOptionPane.showMessageDialog(this.jFrame1, txtCampo, "Coloca el nuevo valor:", 0, this.GUARDAR);
/* 4460 */           String[] nombres = null;
/* 4461 */           int esp = 0;
/* 4462 */           String texto = txtCampo.getText();
/*      */           int i;
/* 4464 */           for (i = 0; i < texto.length(); i++) {
/* 4465 */             if (texto.charAt(i) == ' ') {
/* 4466 */               esp++;
/*      */             }
/*      */           } 
/* 4469 */           nombres = new String[esp + 1];
/* 4470 */           for (i = 0; i <= esp; i++) {
/* 4471 */             nombres[i] = "";
/*      */           }
/* 4473 */           esp = 0;
/* 4474 */           for (i = 0; i < texto.length(); i++) {
/* 4475 */             if (texto.charAt(i) == ' ') {
/* 4476 */               esp++;
/*      */             } else {
/* 4478 */               nombres[esp] = nombres[esp] + nombres[esp];
/*      */             } 
/*      */           } 
/* 4481 */           for (i = 0; i < nombres.length; i++) {
/* 4482 */             if (nombres[i].length() == 0) {
/* 4483 */               JOptionPane.showMessageDialog(this.jFrame1, "Tienes un espacio de más en los datos que tecleaste", "Error 031 - Espacio", 0, this.ERROR);
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/* 4488 */           if (col.equals("Peso")) {
/* 4489 */             this.TONELADASTOTALES += Double.parseDouble(texto);
/*      */           }
/* 4491 */           this.jTable5.setValueAt(texto.toUpperCase(), this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/* 4492 */           this.jTextPane1.setText("");
/* 4493 */           SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 4494 */           StyleConstants.setBold(attrs, true);
/* 4495 */           sacarResiduos();
/*      */           try {
/* 4497 */             for (int j = 0; j < this.RESABREV.length; j++) {
/* 4498 */               this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[j] + ":", attrs);
/* 4499 */               this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear(Float.parseFloat("" + this.TONSRES[j])) + "\n", null);
/*      */             } 
/* 4501 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 4502 */             if (this.TONELADA) {
/* 4503 */               this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/* 4504 */               this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + redondear(Float.parseFloat("" + this.TONELADASTOTALES)) + "\n", null);
/*      */             } 
/* 4506 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 4507 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + this.jTable5.getRowCount() + "\n", null);
/* 4508 */           } catch (BadLocationException ex) {
/* 4509 */             Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/* 4514 */       String columna = this.jTable5.getColumnName(this.jTable5.getSelectedColumn());
/* 4515 */       if (evt.getClickCount() == 2 && columna.equals("Otros $")) {
/* 4516 */         for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 4517 */           String valorO = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 0));
/* 4518 */           if (valorO.equals(this.OTROS[i].dameGuia())) {
/* 4519 */             this.INDICEOTROS = i;
/* 4520 */             this.jDialog9.setTitle("Otros conceptos para Guía - " + valorO);
/* 4521 */             this.jButton25.setEnabled(false);
/* 4522 */             this.jButton26.setEnabled(false);
/* 4523 */             this.OTROS[i].verDatos();
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       }
/* 4528 */       if (valor.equals("null")) {
/* 4529 */         this.jTable5.setToolTipText("<html>" + this.jTable5.getColumnName(this.jTable5.getSelectedColumn()) + ": Vacío</html>");
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable5KeyReleased(KeyEvent evt) {
/* 4535 */     int ind = this.jTable5.getSelectedRow();
/* 4536 */     if (ind > -1) {
/* 4537 */       String valor = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn()));
/* 4538 */       this.jTable5.setToolTipText("<html>" + this.jTable5.getColumnName(this.jTable5.getSelectedColumn()) + ": <b>" + valor + "</b></html>");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel24MouseClicked(MouseEvent evt) {
/* 4543 */     if (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar")) {
/* 4544 */       if (this.OPCRETENCION == 0) {
/* 4545 */         this.jRadioButton7.setSelected(true);
/* 4546 */         this.jFormattedTextField10.setEnabled(false);
/* 4547 */       } else if (this.OPCRETENCION == 1) {
/* 4548 */         this.jRadioButton8.setSelected(true);
/* 4549 */         this.jFormattedTextField10.setEnabled(false);
/* 4550 */       } else if (this.OPCRETENCION == 2) {
/* 4551 */         this.jRadioButton9.setSelected(true);
/* 4552 */         this.jFormattedTextField10.setEnabled(false);
/* 4553 */       } else if (this.OPCRETENCION == 3) {
/* 4554 */         this.jRadioButton10.setSelected(true);
/* 4555 */         this.jFormattedTextField10.setEnabled(true);
/* 4556 */         this.jFormattedTextField10.setValue(Double.valueOf(this.RETENCIONAPLICADO));
/*      */       } 
/* 4558 */       this.jDialog19.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel24MouseEntered(MouseEvent evt) {
/* 4563 */     this.jLabel24.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel24MouseExited(MouseEvent evt) {
/* 4567 */     this.jLabel24.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 4571 */     if (this.jButton9.getText().equals("Guardar")) {
/* 4572 */       limpiarTabla1();
/* 4573 */       this.jTextField39.setEnabled(true);
/* 4574 */       this.jTextField40.setEnabled(true);
/* 4575 */       this.jTextField41.setEnabled(true);
/* 4576 */       this.jTextField42.setEnabled(true);
/*      */       
/* 4578 */       String folio = this.jTextField3.getText();
/* 4579 */       this.encontrado = this.con.consultar("ref", "prefacturacliente", "where estado = 'ACTIVA' and folio = '" + folio + "'");
/* 4580 */       if (this.jComboBox11.getSelectedIndex() == 0) {
/* 4581 */         JOptionPane.showMessageDialog(this.jFrame1, "Te falta seleccionar la información del cliente", "Selecciona el cliente", 0, this.ADVER);
/* 4582 */       } else if (this.jLabel27.getText().equals("$0.00")) {
/* 4583 */         JOptionPane.showMessageDialog(this.jFrame1, "La factura no puede ser generada por $0.00 **(Cero pesos M.N./00)**", "Cero pesos", 0, this.ADVER);
/* 4584 */       } else if (this.encontrado && !this.jTextField3.getText().equals("")) {
/* 4585 */         this.jTextField3.setBackground(Color.RED);
/* 4586 */         JOptionPane.showMessageDialog(this.jFrame1, "La referencia que deseas insertar ya se encuentra almacenado en la base de datos.", "Folio duplicado", 0, this.ERROR);
/*      */       } else {
/* 4588 */         int tipoIva = 0;
/* 4589 */         if (this.jRadioButton4.isSelected()) {
/* 4590 */           tipoIva = 1;
/*      */         }
/*      */         
/* 4593 */         subTotal();
/* 4594 */         iva();
/* 4595 */         retencion();
/* 4596 */         total();
/* 4597 */         this.DATOSOTROS = new String[this.LINEASOTROSCONCEPTOS][5];
/* 4598 */         int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas guardar la prefactura?", "Guardar Prefactura", 0, 3, this.GUARDAR);
/* 4599 */         if (res == 0) {
/* 4600 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4601 */           String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 4602 */           String año = cadenaFecha1.substring(0, 4);
/* 4603 */           String mes = cadenaFecha1.substring(4, 6);
/* 4604 */           String dia = cadenaFecha1.substring(6, 8);
/* 4605 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 4606 */           String columnas = "";
/*      */           
/* 4608 */           for (int i = 0; i < this.jTable5.getColumnCount(); i++) {
/* 4609 */             columnas = columnas + "-" + columnas;
/*      */           }
/* 4611 */           this.con.inserSinMsj("update prefacturas set actual ='<Cerrada>' where numInterPre = " + this.PREFACTURAINTERNA);
/*      */           
/* 4613 */           String cliente = String.valueOf(this.jComboBox11.getSelectedItem());
/*      */           
/* 4615 */           this.con.inserSinMsj("insert into prefacturacliente(fecha,            ref,                                   folio,                                         cliente,                                      equipo,                                  pozo,                                            tons,                              numViajes,        iva,   ret,         totalTexto,        estado,     estatus,      usuario,        numInterPre,        columnas,              subTexto,            ivaTexto,                    retTexto,              leyenda,  comentario, descuentoTexto,tipoIva )values(" + fechaCompleta + ",'" + this.jTextField3
/* 4616 */               .getText().toUpperCase() + "','',                                        '" + cliente.toUpperCase() + "','" + this.jTextField11.getText().toUpperCase() + "','" + this.jTextField12.getText().toUpperCase() + "'," + redondear(Float.parseFloat("" + this.TONELADASTOTALES)) + "," + this.jTable5.getRowCount() + "," + this.IVA + "," + this.RET + ",'" + this.jLabel27.getText() + "','ACTIVA','<Por Facturar>','" + this.USUARIO + "'," + this.PREFACTURAINTERNA + ",'" + columnas + "','" + this.jLabel21.getText() + "',     '" + this.jLabel22.getText() + "','" + this.jLabel25.getText() + "','" + this.leyenda + "','" + this.jTextArea3.getText().toUpperCase() + "', '" + this.jFormattedTextField2.getText() + "'," + tipoIva + ")");
/*      */           
/* 4618 */           this.con.consultar("max(numFac)", "prefacturacliente", "");
/* 4619 */           this.NUMFAC = this.con.Campo;
/*      */           
/* 4621 */           String insertar1 = "";
/* 4622 */           for (int j = 0; j < this.jTable12.getRowCount(); j++) {
/* 4623 */             insertar1 = insertar1 + "(" + insertar1 + ",'" + String.valueOf(this.jTable12.getValueAt(j, 0)) + "','" + String.valueOf(this.jTable12.getValueAt(j, 1)) + "','" + String.valueOf(this.jTable12.getValueAt(j, 2)) + "'," + String.valueOf(this.jTable12.getValueAt(j, 3)) + ")";
/* 4624 */             if (j + 1 != this.jTable12.getRowCount()) {
/* 4625 */               insertar1 = insertar1 + ",";
/*      */             }
/*      */           } 
/* 4628 */           if (this.jTable12.getRowCount() > 0) {
/* 4629 */             this.con.inserSinMsj("insert into prefacturaotrosconcep(cant,concepto,p_unitario,importe,numPrefac)values " + insertar1);
/*      */           }
/*      */           
/* 4632 */           String insertarGuias = "";
/* 4633 */           for (int k = 0; k < this.jTable5.getRowCount(); k++) {
/* 4634 */             insertarGuias = insertarGuias + " num_guia = '" + insertarGuias + "' ";
/* 4635 */             if (k + 1 < this.jTable5.getRowCount()) {
/* 4636 */               insertarGuias = insertarGuias + " or ";
/*      */             }
/*      */           } 
/* 4639 */           if (this.jTable5.getRowCount() > 0) {
/* 4640 */             this.con.inserSinMsj("update guias set estatus='<En Prefactura Interna: " + this.jTextField3.getText().toUpperCase() + " " + cargarFechaHoy() + ">',prefactura=" + this.NUMFAC + " where " + insertarGuias);
/*      */           }
/* 4642 */           this.mensajeTry.guardarConf("Se ha creado un nueva prefactura, usuario: " + this.USUARIO, "Nueva Prefactura (" + this.NUMFAC + ")", "INFO", "Facturacion");
/*      */           
/* 4644 */           String valor = this.con.Campo;
/* 4645 */           String insertarGuiasPrefac = "";
/* 4646 */           for (int m = 0; m < this.jTable5.getRowCount(); m++) {
/* 4647 */             String[] REGIS = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 4648 */             int cuenta = 0;
/* 4649 */             for (int n = 0; n < this.jTable8.getRowCount(); n++) {
/* 4650 */               String obj = String.valueOf(this.jTable8.getValueAt(n, 1));
/* 4651 */               if (obj.equals("true")) {
/* 4652 */                 String columna = String.valueOf(this.jTable8.getValueAt(n, 0));
/* 4653 */                 REGIS[n] = String.valueOf(this.jTable5.getValueAt(m, cuenta));
/* 4654 */                 cuenta++;
/* 4655 */                 if (columna.equals("Otros $")) {
/* 4656 */                   REGIS[n + 1] = String.valueOf(this.jTable5.getValueAt(m, this.jTable5.getColumnCount() - 1));
/*      */                 }
/*      */               } else {
/* 4659 */                 REGIS[n] = "";
/*      */               } 
/*      */             } 
/* 4662 */             insertarGuiasPrefac = insertarGuiasPrefac + " ( '" + insertarGuiasPrefac + "','" + REGIS[0] + "','" + REGIS[1] + "','" + REGIS[2] + "',                 '" + REGIS[3] + "',           '" + REGIS[4] + "',        '" + REGIS[5] + "','" + REGIS[6] + "','" + REGIS[7] + "',                  '" + REGIS[8] + "','" + REGIS[9] + "','" + REGIS[10] + "','" + REGIS[11] + "','" + REGIS[12] + "','" + REGIS[13] + "','" + REGIS[14] + "','" + REGIS[15] + "','" + REGIS[16] + "','" + REGIS[17] + "','" + REGIS[18] + "','" + REGIS[19] + "','" + REGIS[20] + "','" + REGIS[21] + "',   '" + REGIS[22] + "',  " + REGIS[23] + ")";
/* 4663 */             if (m + 1 != this.jTable5.getRowCount()) {
/* 4664 */               insertarGuiasPrefac = insertarGuiasPrefac + ",";
/*      */             }
/*      */           } 
/*      */           
/* 4668 */           if (this.jTable5.getRowCount() > 0) {
/* 4669 */             this.con.inserSinMsj("insert into guiasfactura(guia,         fecha,           servicio,                residuo,               cliente,                 destino,         operador,       equipo,                     plataforma,                    pozo,              f_carga, f_descarga ,         pedido,                     tipo,                     ticket,                 tons,         tractor,             rem,          rsp,       manifiesto,         precioU,            subTotal,          otrosConcep,     subtotal2,        numFac )values" + insertarGuiasPrefac);
/*      */           }
/*      */           
/* 4672 */           res = JOptionPane.showConfirmDialog(this.jFrame1, "La prefactura ha sido guardada satisfactoriamente\n¿Deseas imprimir la información completa?", "Imprimir Prefactura", 0, 3, this.PREG);
/* 4673 */           if (res == 0) {
/* 4674 */             imprimir();
/*      */           }
/* 4676 */           this.jFrame1.setVisible(false);
/* 4677 */           consultar();
/* 4678 */           verHistorial();
/*      */         }
/*      */       
/*      */       } 
/* 4682 */     } else if (this.jButton9.getText().equals("Modificar")) {
/* 4683 */       int tipoIva = 0;
/* 4684 */       if (this.jRadioButton4.isSelected()) {
/* 4685 */         tipoIva = 1;
/*      */       }
/* 4687 */       limpiarTabla1();
/* 4688 */       this.jTextField39.setEnabled(true);
/* 4689 */       this.jTextField40.setEnabled(true);
/* 4690 */       this.jTextField41.setEnabled(true);
/* 4691 */       this.jTextField42.setEnabled(true);
/*      */       
/* 4693 */       String folio = this.jTextField3.getText();
/* 4694 */       if (this.jComboBox11.getSelectedIndex() == 0) {
/* 4695 */         JOptionPane.showMessageDialog(this.jFrame1, "Te falta seleccionar la información del cliente", "Selecciona el cliente", 0, this.ADVER);
/* 4696 */       } else if (this.jLabel27.getText().equals("$0.00")) {
/* 4697 */         JOptionPane.showMessageDialog(this.jFrame1, "La factura no puede ser generada por $0.00 **(Cero pesos M.N./00)**", "Cero pesos", 0, this.ADVER);
/*      */       } else {
/* 4699 */         subTotal();
/* 4700 */         iva();
/* 4701 */         retencion();
/* 4702 */         total();
/* 4703 */         this.DATOSOTROS = new String[this.LINEASOTROSCONCEPTOS][5];
/* 4704 */         int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas guardar la prefactura?", "Guardar Prefactura", 0, 3, this.GUARDAR);
/* 4705 */         if (res == 0) {
/* 4706 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4707 */           String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 4708 */           String año = cadenaFecha1.substring(0, 4);
/* 4709 */           String mes = cadenaFecha1.substring(4, 6);
/* 4710 */           String dia = cadenaFecha1.substring(6, 8);
/* 4711 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 4712 */           String columnas = "";
/*      */           
/* 4714 */           this.con.inserSinMsj("update guias set estatus ='<Pagada Al Operador>', prefactura=0 where prefactura = " + this.PREORIGINAL);
/* 4715 */           this.con.eliminar2("prefacturaotrosconcep", "where numPrefac = " + this.PREORIGINAL);
/* 4716 */           this.con.eliminar2("guiasfactura", "where numFac = " + this.PREORIGINAL);
/*      */           
/* 4718 */           for (int i = 0; i < this.jTable5.getColumnCount(); i++) {
/* 4719 */             columnas = columnas + "-" + columnas;
/*      */           }
/* 4721 */           this.con.inserSinMsj("update prefacturacliente set cliente = '" + String.valueOf(this.jComboBox11.getSelectedItem()) + "', fecha = " + fechaCompleta + ", ref = '" + this.jTextField3.getText().toUpperCase() + "', folio = '', equipo ='" + this.jTextField11.getText().toUpperCase() + "', pozo ='" + this.jTextField12.getText().toUpperCase() + "', tons= " + redondear(Float.parseFloat("" + this.TONELADASTOTALES)) + ", numViajes=" + this.jTable5.getRowCount() + ", iva= " + this.IVA + ", RET = " + this.RET + ", totalTexto='" + this.jLabel27.getText() + "', estado ='ACTIVA', estatus='<Por Facturar>', subTexto='" + this.jLabel21.getText() + "', ivaTexto='" + this.jLabel22.getText() + "', retTexto='" + this.jLabel25.getText() + "', Leyenda='" + this.leyenda + "', comentario = '" + this.jTextArea3.getText().toUpperCase() + "', descuentoTexto='" + this.jFormattedTextField2.getText() + "', tipoIva=" + tipoIva + " where numFac =" + this.PREORIGINAL);
/* 4722 */           this.NUMFAC = this.PREORIGINAL;
/*      */           
/* 4724 */           String insertar1 = "";
/* 4725 */           for (int j = 0; j < this.jTable12.getRowCount(); j++) {
/* 4726 */             insertar1 = insertar1 + "(" + insertar1 + ",'" + String.valueOf(this.jTable12.getValueAt(j, 0)) + "','" + String.valueOf(this.jTable12.getValueAt(j, 1)) + "','" + String.valueOf(this.jTable12.getValueAt(j, 2)) + "'," + String.valueOf(this.jTable12.getValueAt(j, 3)) + ")";
/* 4727 */             if (j + 1 != this.jTable12.getRowCount()) {
/* 4728 */               insertar1 = insertar1 + ",";
/*      */             }
/*      */           } 
/* 4731 */           if (this.jTable12.getRowCount() > 0) {
/* 4732 */             this.con.inserSinMsj("insert into prefacturaotrosconcep(cant,concepto,p_unitario,importe,numPrefac)values " + insertar1);
/*      */           }
/*      */ 
/*      */           
/* 4736 */           String insertarGuias = "";
/* 4737 */           for (int k = 0; k < this.jTable5.getRowCount(); k++) {
/* 4738 */             insertarGuias = insertarGuias + " num_guia = '" + insertarGuias + "' ";
/* 4739 */             if (k + 1 < this.jTable5.getRowCount()) {
/* 4740 */               insertarGuias = insertarGuias + " or ";
/*      */             }
/*      */           } 
/* 4743 */           if (this.jTable5.getRowCount() > 0) {
/* 4744 */             this.con.inserSinMsj("update guias set estatus='<En Prefactura Interna: " + this.jTextField3.getText().toUpperCase() + " " + cargarFechaHoy() + ">',prefactura=" + this.NUMFAC + " where " + insertarGuias);
/*      */           }
/*      */ 
/*      */           
/* 4748 */           String insertarGuiasPrefac = "";
/* 4749 */           for (int m = 0; m < this.jTable5.getRowCount(); m++) {
/* 4750 */             String[] REGIS = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 4751 */             int cuenta = 0;
/* 4752 */             for (int n = 0; n < this.jTable8.getRowCount(); n++) {
/* 4753 */               String obj = String.valueOf(this.jTable8.getValueAt(n, 1));
/* 4754 */               if (obj.equals("true")) {
/* 4755 */                 String columna = String.valueOf(this.jTable8.getValueAt(n, 0));
/* 4756 */                 REGIS[n] = String.valueOf(this.jTable5.getValueAt(m, cuenta));
/* 4757 */                 cuenta++;
/* 4758 */                 if (columna.equals("Otros $")) {
/* 4759 */                   REGIS[n + 1] = String.valueOf(this.jTable5.getValueAt(m, this.jTable5.getColumnCount() - 1));
/*      */                 }
/*      */               } else {
/* 4762 */                 REGIS[n] = "";
/*      */               } 
/*      */             } 
/* 4765 */             insertarGuiasPrefac = insertarGuiasPrefac + " ( '" + insertarGuiasPrefac + "','" + REGIS[0] + "','" + REGIS[1] + "','" + REGIS[2] + "',                 '" + REGIS[3] + "',           '" + REGIS[4] + "',        '" + REGIS[5] + "','" + REGIS[6] + "','" + REGIS[7] + "',                  '" + REGIS[8] + "','" + REGIS[9] + "','" + REGIS[10] + "','" + REGIS[11] + "','" + REGIS[12] + "','" + REGIS[13] + "','" + REGIS[14] + "','" + REGIS[15] + "','" + REGIS[16] + "','" + REGIS[17] + "','" + REGIS[18] + "','" + REGIS[19] + "','" + REGIS[20] + "','" + REGIS[21] + "',   '" + REGIS[22] + "',  " + REGIS[23] + ")";
/* 4766 */             if (m + 1 != this.jTable5.getRowCount()) {
/* 4767 */               insertarGuiasPrefac = insertarGuiasPrefac + ",";
/*      */             }
/*      */           } 
/*      */           
/* 4771 */           if (this.jTable5.getRowCount() > 0) {
/* 4772 */             this.con.inserSinMsj("insert into guiasfactura(guia,         fecha,           servicio,                residuo,               cliente,                 destino,         operador,       equipo,                     plataforma,                    pozo,              f_carga, f_descarga ,         pedido,                     tipo,                     ticket,                 tons,         tractor,             rem,          rsp,       manifiesto,         precioU,            subTotal,          otrosConcep,     subtotal2,        numFac )values" + insertarGuiasPrefac);
/*      */           }
/*      */           
/* 4775 */           res = JOptionPane.showConfirmDialog(this.jFrame1, "La prefactura ha sido guardada satisfactoriamente\n¿Deseas imprimir la información completa?", "Imprimir Prefactura", 0, 3, this.PREG);
/* 4776 */           if (res == 0) {
/* 4777 */             imprimir();
/*      */           }
/* 4779 */           this.mensajeTry.guardarConf("Se modificó una prefactura, usuario: " + this.USUARIO, "Prefactura Modificada (" + this.NUMFAC + ")", "INFO", "Facturacion");
/* 4780 */           this.jFrame1.setVisible(false);
/* 4781 */           consultar();
/* 4782 */           verHistorial();
/*      */         } 
/*      */       } 
/*      */     } else {
/* 4786 */       if (this.colOtros != 0) {
/* 4787 */         this.COLNOMBRES = new String[this.jTable5.getColumnCount() - 1];
/* 4788 */         this.DATOSOTROS = new String[this.LINEASOTROSCONCEPTOS][5];
/* 4789 */         for (int i = 0; i < this.jTable5.getColumnCount() - 1; i++) {
/* 4790 */           this.COLNOMBRES[i] = String.valueOf(this.jTable5.getColumnModel().getColumn(i).getIdentifier());
/*      */         }
/* 4792 */         int cont = 0;
/* 4793 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 4794 */           String valor = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 2));
/* 4795 */           if (!valor.equals("$0.00") && !valor.equals("-$0.00")) {
/* 4796 */             String guia = String.valueOf(this.jTable5.getValueAt(j, 0));
/* 4797 */             for (int k = 0; k < this.OTROS.length; k++) {
/* 4798 */               if (this.OTROS[k].dameGuia().equals(guia)) {
/* 4799 */                 for (int m = 0; m < (this.OTROS[k]).tabla.getRowCount(); m++) {
/* 4800 */                   this.DATOSOTROS[cont][0] = String.valueOf((this.OTROS[k]).tabla.getValueAt(m, 0));
/* 4801 */                   this.DATOSOTROS[cont][1] = String.valueOf((this.OTROS[k]).tabla.getValueAt(m, 1));
/* 4802 */                   this.DATOSOTROS[cont][2] = String.valueOf((this.OTROS[k]).tabla.getValueAt(m, 2));
/* 4803 */                   this.DATOSOTROS[cont][3] = String.valueOf((this.OTROS[k]).tabla.getValueAt(m, 3));
/* 4804 */                   this.DATOSOTROS[cont][4] = guia;
/* 4805 */                   cont++;
/*      */                 } 
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } else {
/* 4812 */         this.COLNOMBRES = new String[this.jTable5.getColumnCount()];
/* 4813 */         for (int i = 0; i < this.jTable5.getColumnCount(); i++) {
/* 4814 */           this.COLNOMBRES[i] = String.valueOf(this.jTable5.getColumnModel().getColumn(i).getIdentifier());
/*      */         }
/*      */       } 
/* 4817 */       imprimir();
/* 4818 */       if (this.colOtros != 0) {
/* 4819 */         int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Deseas imprimir el desglose de la columna 'Otros Conceptos'?", "Imprimir Conceptos", 0, 3, this.PREG);
/* 4820 */         if (res == 0) {
/* 4821 */           ImprimirConceptos imp = new ImprimirConceptos();
/* 4822 */           imp.recibeDatos();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 4829 */     if (evt.getClickCount() == 2) {
/* 4830 */       verGuia();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 4835 */     verGuia();
/*      */   }
/*      */   
/*      */   private void jLabel51MouseClicked(MouseEvent evt) {
/* 4839 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel51MouseEntered(MouseEvent evt) {
/* 4843 */     this.jLabel51.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel51MouseExited(MouseEvent evt) {
/* 4847 */     this.jLabel51.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 4851 */     if (evt.getClickCount() == 2) {
/* 4852 */       this.jButton10.setVisible(false);
/* 4853 */       this.jButton11.setVisible(false);
/* 4854 */       this.jDateChooser4.setEnabled(false);
/* 4855 */       this.jTextField3.setEnabled(false);
/* 4856 */       this.jButton9.setText("Imprimir");
/* 4857 */       this.jButton9.setMnemonic('I');
/*      */       
/* 4859 */       this.jButton46.setEnabled(false);
/* 4860 */       this.jButton49.setEnabled(false);
/* 4861 */       this.jButton48.setEnabled(false);
/* 4862 */       this.jButton52.setEnabled(false);
/* 4863 */       this.jLabel91.setEnabled(false);
/* 4864 */       this.jComboBox11.setEnabled(false);
/* 4865 */       this.jTextArea3.setEnabled(false);
/*      */       
/* 4867 */       this.jButton9.setToolTipText("Imprimir Prefactura (Alt+I)");
/* 4868 */       verPrefactura(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 4873 */     this.colOtros = 0;
/* 4874 */     this.LINEASOTROSCONCEPTOS = 0;
/* 4875 */     int ind = this.jTable1.getSelectedRow();
/* 4876 */     if (ind < 0) {
/* 4877 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una prefactura para ver el detalle de los viajes", "Selecciona una Prefactura", 0, this.ERROR);
/*      */     } else {
/* 4879 */       this.VENTANA = false;
/* 4880 */       this.jButton10.setVisible(false);
/* 4881 */       this.jButton11.setVisible(false);
/*      */       
/* 4883 */       this.jButton46.setEnabled(false);
/* 4884 */       this.jButton49.setEnabled(false);
/* 4885 */       this.jButton48.setEnabled(false);
/* 4886 */       this.jButton52.setEnabled(false);
/* 4887 */       this.jLabel91.setEnabled(false);
/* 4888 */       this.jComboBox11.setEnabled(false);
/* 4889 */       this.jTextArea3.setEnabled(false);
/*      */       
/* 4891 */       this.jDateChooser4.setEnabled(false);
/* 4892 */       this.jTextField3.setEnabled(false);
/* 4893 */       this.jButton9.setText("Imprimir");
/* 4894 */       this.jButton9.setMnemonic('I');
/* 4895 */       this.jButton9.setToolTipText("Imprimir Prefactura (Alt+I)");
/* 4896 */       this.TONELADA = false;
/* 4897 */       this.TONS = "";
/* 4898 */       verPrefactura(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 4903 */     this.VENTANA = false;
/* 4904 */     this.POSICION--;
/* 4905 */     this.LINEASOTROSCONCEPTOS = 0;
/* 4906 */     this.TONELADA = false;
/* 4907 */     if (this.POSICION == 0) {
/* 4908 */       this.jButton10.setEnabled(false);
/*      */     }
/* 4910 */     verPrefactura(this.PREFACTURAS[this.POSICION]);
/* 4911 */     this.jFrame1.setExtendedState(0);
/* 4912 */     this.jButton11.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 4916 */     this.POSICION++;
/* 4917 */     this.VENTANA = false;
/* 4918 */     this.LINEASOTROSCONCEPTOS = 0;
/* 4919 */     this.TONELADA = false;
/* 4920 */     if (this.POSICION + 1 == this.PREFACTURAS.length) {
/* 4921 */       this.jButton11.setEnabled(false);
/*      */     }
/* 4923 */     verPrefactura(this.PREFACTURAS[this.POSICION]);
/* 4924 */     this.jFrame1.setExtendedState(0);
/* 4925 */     this.jButton10.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 4929 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 4933 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 4937 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas modificar el tractor?", "Modificar Tractor", 0, 3, this.PREG);
/* 4938 */     if (res == 0) {
/* 4939 */       this.jTable5.setValueAt(this.jTextField4.getText(), this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/* 4940 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 4945 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas modificar el remolque?", "Modificar Remolque", 0, 3, this.PREG);
/* 4946 */     if (res == 0) {
/* 4947 */       this.jTable5.setValueAt(this.jTextField5.getText(), this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/* 4948 */       this.jDialog6.setVisible(false);
/* 4949 */       this.jDialog5.setVisible(false);
/*      */     } 
/*      */   }
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 4953 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 4956 */     cambiarTarifa();
/*      */   }
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {
/* 4959 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas modificar el tractor?", "Modificar Tractor", 0, 3, this.PREG);
/* 4960 */     if (res == 0) {
/* 4961 */       this.jTable5.setValueAt(this.jTextField4.getText(), this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/* 4962 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 4967 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas modificar el remolque?", "Modificar Remolque", 0, 3, this.PREG);
/* 4968 */     if (res == 0) {
/* 4969 */       this.jTable5.setValueAt(this.jTextField5.getText(), this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn());
/* 4970 */       this.jDialog5.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable7MouseClicked(MouseEvent evt) {
/* 4975 */     if (evt.getClickCount() == 2) {
/* 4976 */       cambiarTarifa();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 4981 */     consultarTarifas();
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 4985 */     if (!this.VENTANA1) {
/* 4986 */       this.jDialog7.setVisible(false);
/* 4987 */       this.jDialog2.setVisible(true);
/*      */     } else {
/* 4989 */       this.jDialog7.setVisible(false);
/* 4990 */       this.jDialog16.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 4995 */     this.CAMPOSCON = "";
/* 4996 */     this.colMani = 0;
/* 4997 */     this.colOtros = 0;
/* 4998 */     this.colExtra = 0;
/* 4999 */     int col = 0;
/* 5000 */     int columnas = 0;
/* 5001 */     this.TONELADA = false;
/* 5002 */     this.TIENERETENCION = true;
/* 5003 */     this.jLabel69.setVisible(false);
/* 5004 */     this.jLabel19.setEnabled(true);
/* 5005 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 5006 */       String obj = String.valueOf(this.jTable8.getValueAt(i, 1));
/* 5007 */       if (obj.equals("true")) {
/* 5008 */         if (i == 0 || i == 1 || i == 3 || i == 16 || i == 20 || i == 21) {
/* 5009 */           columnas++;
/*      */         }
/* 5011 */         if (i == 15) {
/* 5012 */           this.TONELADA = true;
/*      */         }
/* 5014 */         col++;
/*      */       } 
/*      */     } 
/* 5017 */     if (col < 1) {
/* 5018 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas seleccionar por lo menos las columnas generales", "Te faltan columnas", 0, this.ADVER);
/* 5019 */     } else if (columnas < 6) {
/* 5020 */       JOptionPane.showMessageDialog(this.jDialog7, "<html>Las siguientes columnas son obligatorias su selección: <br><b>1.- Guías<br>2.- Fecha<br>3.- Residuo<br>4.- Tractor<br>5.- Precio Unitario<br>6.- Importe</b></html>", "Faltan columnas obligatorias", 0, this.ADVER);
/*      */     } else {
/* 5022 */       this.COLUMNASTABLA = new String[col];
/* 5023 */       this.CAMPOSTABLA = new String[col];
/* 5024 */       this.tamañosCol = new int[col];
/* 5025 */       this.COLNOMBRES = new String[col];
/* 5026 */       this.COLSELEC = new int[col];
/* 5027 */       int cuenta = 36; int j;
/* 5028 */       for (j = 0; j < this.COLUMNASTABLA.length; j++) {
/* 5029 */         this.COLUMNASTABLA[j] = "";
/*      */       }
/* 5031 */       col = 0;
/* 5032 */       for (j = 0; j < this.jTable8.getRowCount(); j++) {
/* 5033 */         String obj = String.valueOf(this.jTable8.getValueAt(j, 1));
/* 5034 */         if (obj.equals("true")) {
/* 5035 */           if (j == 22) {
/* 5036 */             this.colOtros = col;
/* 5037 */             this.colExtra++;
/*      */           } 
/* 5039 */           if (j == 15) {
/* 5040 */             this.colTon = col;
/*      */           }
/* 5042 */           if (j == 3) {
/* 5043 */             this.colResi = col;
/*      */           }
/* 5045 */           if (j < 20) {
/* 5046 */             this.CAMPOSTABLA[col] = this.COLTABLA[j];
/* 5047 */             this.CAMPOSCON = this.CAMPOSCON + this.CAMPOSCON + ",";
/*      */           } 
/* 5049 */           this.COLUMNASTABLA[col] = String.valueOf(this.jTable8.getValueAt(j, 0));
/* 5050 */           this.tamañosCol[col] = this.TAMAÑOS[j];
/* 5051 */           this.COLSELEC[col] = this.COLIMPRESION[j];
/* 5052 */           this.COLNOMBRES[col] = this.IMPRESION[j];
/* 5053 */           cuenta += this.COLSELEC[col];
/* 5054 */           col++;
/*      */         } 
/*      */       } 
/* 5057 */       if (cuenta > 750) {
/* 5058 */         JOptionPane.showMessageDialog(this.jFrame1, "Existe información fuera de los márgenes, nesecitas quitar alguna columna", "Fuera de margen", 0, this.ADVER);
/*      */       } else {
/* 5060 */         this.jTable12.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Concepto", "P Unitario", "Importe" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 5066 */               boolean[] canEdit = new boolean[] { false, false, false, true };
/*      */ 
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5071 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 5074 */         this.jTable12.setShowVerticalLines(false);
/* 5075 */         this.jScrollPane14.setViewportView(this.jTable12);
/* 5076 */         this.jTable12.getColumnModel().getColumn(0).setMinWidth(60);
/* 5077 */         this.jTable12.getColumnModel().getColumn(0).setMaxWidth(60);
/* 5078 */         this.jTable12.getColumnModel().getColumn(2).setMinWidth(90);
/* 5079 */         this.jTable12.getColumnModel().getColumn(2).setMaxWidth(90);
/* 5080 */         this.jTable12.getColumnModel().getColumn(3).setMinWidth(90);
/* 5081 */         this.jTable12.getColumnModel().getColumn(3).setMaxWidth(90);
/*      */         
/* 5083 */         this.jTable12.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 5084 */         this.jTable12.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */         
/* 5086 */         this.jRadioButton8.setSelected(true);
/* 5087 */         this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 5088 */         this.jFormattedTextField10.setEnabled(false);
/* 5089 */         this.jFrame2.setVisible(false);
/* 5090 */         this.jDialog2.setVisible(false);
/* 5091 */         this.jDialog7.setVisible(false);
/* 5092 */         this.LINEASOTROSCONCEPTOS = 0;
/* 5093 */         this.OPCRETENCION = 1;
/* 5094 */         this.jRadioButton3.setSelected(true);
/* 5095 */         cargarPrefactura();
/*      */         
/* 5097 */         this.jButton46.setEnabled(true);
/* 5098 */         this.jButton49.setEnabled(true);
/* 5099 */         this.jButton48.setEnabled(true);
/* 5100 */         this.jButton52.setEnabled(true);
/* 5101 */         this.jLabel91.setEnabled(true);
/* 5102 */         this.jComboBox11.setEnabled(true);
/* 5103 */         this.jTextField11.setEnabled(true);
/* 5104 */         this.jTextField12.setEnabled(true);
/* 5105 */         this.jTextArea3.setEnabled(true);
/* 5106 */         this.jTextArea3.setText("");
/* 5107 */         this.jFormattedTextField2.setEnabled(true);
/*      */         
/* 5109 */         this.jDialog7.setVisible(false);
/* 5110 */         this.jFrame1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 5116 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 5120 */     if (this.jRadioButton1.isSelected()) {
/* 5121 */       String valor = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jComboBox5.getSelectedIndex()));
/* 5122 */       for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 5123 */         String regis = String.valueOf(this.jTable5.getValueAt(i, this.jComboBox5.getSelectedIndex()));
/* 5124 */         if (valor.equals(regis)) {
/* 5125 */           String valor1 = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 4));
/* 5126 */           String valor2 = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 5));
/* 5127 */           if (valor2.equals("Viaje")) {
/* 5128 */             if (this.colOtros != 0) {
/* 5129 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 4);
/* 5130 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 3);
/*      */             } else {
/* 5132 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 2);
/* 5133 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 1);
/*      */             } 
/*      */           } else {
/* 5136 */             this.SUBTOTAL = 0.0D;
/* 5137 */             String canti = valor1;
/* 5138 */             String valorP = "";
/* 5139 */             for (int j = 0; j < canti.length(); j++) {
/* 5140 */               if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 5141 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 5144 */             float PRECIO = Float.parseFloat(valorP);
/* 5145 */             float Ton = Float.parseFloat(String.valueOf(this.jTable5.getValueAt(i, this.colTon)));
/* 5146 */             if (this.colOtros != 0) {
/* 5147 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 4);
/* 5148 */               this.cuadroPrecio.setValue(Float.valueOf(PRECIO * Ton));
/* 5149 */               this.jTable5.setValueAt(this.cuadroPrecio.getText(), i, this.jTable5.getColumnCount() - 3);
/*      */             } else {
/* 5151 */               this.jTable5.setValueAt(valor1, i, this.jTable5.getColumnCount() - 2);
/* 5152 */               this.cuadroPrecio.setValue(Float.valueOf(PRECIO * Ton));
/* 5153 */               this.jTable5.setValueAt(this.cuadroPrecio.getText(), i, this.jTable5.getColumnCount() - 1);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/* 5159 */       String valor1 = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 4));
/* 5160 */       String valor2 = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 5));
/* 5161 */       if (valor2.equals("Viaje")) {
/* 5162 */         if (this.colOtros != 0) {
/* 5163 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 4);
/* 5164 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 3);
/*      */         } else {
/* 5166 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 2);
/* 5167 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 1);
/*      */         } 
/*      */       } else {
/* 5170 */         this.SUBTOTAL = 0.0D;
/* 5171 */         String canti = valor1;
/* 5172 */         String valorP = "";
/* 5173 */         for (int i = 0; i < canti.length(); i++) {
/* 5174 */           if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 5175 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 5178 */         float PRECIO = Float.parseFloat(valorP);
/* 5179 */         float Ton = Float.parseFloat(String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.colTon)));
/* 5180 */         if (this.colOtros != 0) {
/* 5181 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 4);
/* 5182 */           this.cuadroPrecio.setValue(Float.valueOf(PRECIO * Ton));
/* 5183 */           this.jTable5.setValueAt(this.cuadroPrecio.getText(), this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 3);
/*      */         } else {
/* 5185 */           this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 2);
/* 5186 */           this.cuadroPrecio.setValue(Float.valueOf(PRECIO * Ton));
/* 5187 */           this.jTable5.setValueAt(this.cuadroPrecio.getText(), this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 1);
/*      */         } 
/*      */       } 
/*      */     } 
/* 5191 */     if (this.colOtros != 0) {
/* 5192 */       for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 5193 */         String canti = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 3));
/* 5194 */         String valorP = "";
/*      */         
/* 5196 */         String canti2 = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 2));
/* 5197 */         String valorP2 = "";
/*      */         int i;
/* 5199 */         for (i = 0; i < canti.length(); i++) {
/* 5200 */           if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 5201 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/*      */         
/* 5205 */         for (i = 0; i < canti2.length(); i++) {
/* 5206 */           if (canti2.charAt(i) != '$' && canti2.charAt(i) != ',') {
/* 5207 */             valorP2 = valorP2 + valorP2;
/*      */           }
/*      */         } 
/*      */         
/* 5211 */         double valor = Double.parseDouble(valorP) + Double.parseDouble(valorP2);
/* 5212 */         this.cantidad.setValue(Double.valueOf(valor));
/* 5213 */         this.jTable5.setValueAt(this.cantidad.getText(), j, this.jTable5.getColumnCount() - 1);
/*      */       } 
/*      */     }
/*      */     
/* 5217 */     subTotal();
/* 5218 */     iva();
/* 5219 */     retencion();
/* 5220 */     total();
/* 5221 */     this.jDialog6.setVisible(false);
/* 5222 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 5226 */     this.jTextField6.setText("");
/* 5227 */     this.jComboBox5.setEnabled(true);
/* 5228 */     this.jComboBox5.setSelectedIndex(0);
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 5232 */     this.jTextField6.setText(String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn())));
/* 5233 */     this.jComboBox5.setEnabled(false);
/* 5234 */     this.jComboBox5.setSelectedIndex(0);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 5238 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 5242 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 5246 */     int selec = this.jTable9.getSelectedRow();
/* 5247 */     if (selec < 0) {
/* 5248 */       JOptionPane.showMessageDialog(this.jDialog9, "Necesitas seleccionar un registro para poder quitar la información", "Selecciona un concepto", 0, this.ADVER);
/*      */     } else {
/* 5250 */       this.OTROS[this.INDICEOTROS].quitarInf(selec);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField8ActionPerformed(ActionEvent evt) {
/* 5255 */     agregarConcepto();
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 5259 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 5263 */     String[] datos = { "NÚM INTER", "FECHA", "FOLIO", "REFERENCIA", "PEDIDO", "CLIENTE", "TONS", "TOTAL", "USUARIO", "ESTATUS" };
/* 5264 */     this.esc = new EscribirReporte("FACTURAS", this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 5268 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 5272 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERA == true) {
/* 5273 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 5278 */     if (this.jComboBox7.getItemCount() > 0 && this.PRIMERA == true) {
/* 5279 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 5284 */     int ind = this.jTable2.getSelectedRow();
/* 5285 */     if (ind < 0) {
/* 5286 */       JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un registros para poder cancelar los datos", "Selecciona un registro", 0, this.ERROR);
/*      */     } else {
/* 5288 */       String valor = String.valueOf(this.jTable2.getValueAt(ind, 2));
/* 5289 */       if (!valor.equals("")) {
/* 5290 */         JOptionPane.showMessageDialog(this.jFrame2, "No puedes cancelar la prefatura porque ya se encuentra amparada en una factura", "Amparada en Factura", 0, this.ERROR);
/*      */       }
/* 5292 */       else if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("FACTURACIÓN") || this.DEPARTAMENTO.equals("ADMINISTRADOR")) {
/* 5293 */         this.jTextArea5.setText("");
/* 5294 */         this.jDialog10.setVisible(true);
/*      */       } else {
/* 5296 */         JOptionPane.showMessageDialog(this.padre, "No tienes los privilegios para poder cancelar facturas", "Privilegios Insuficientes", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 5303 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 5307 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 5311 */     nueva();
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 5315 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton41ActionPerformed(ActionEvent evt) {
/* 5319 */     this.jDialog15.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton42ActionPerformed(ActionEvent evt) {
/* 5323 */     this.jDialog15.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton43ActionPerformed(ActionEvent evt) {
/* 5327 */     int res = JOptionPane.showConfirmDialog(this.jDialog15, "¿Estás seguro que deseas cambiar los datos con la nueva tarifa?", "Cambiar Tarifa", 0, 3, this.PREG);
/* 5328 */     if (res == 0) {
/* 5329 */       String valor1 = this.jFormattedTextField5.getText();
/* 5330 */       if (this.colOtros != 0) {
/* 5331 */         this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 4);
/* 5332 */         this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 3);
/*      */       } else {
/* 5334 */         this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 2);
/* 5335 */         this.jTable5.setValueAt(valor1, this.jTable5.getSelectedRow(), this.jTable5.getColumnCount() - 1);
/*      */       } 
/* 5337 */       subTotal();
/* 5338 */       iva();
/* 5339 */       retencion();
/* 5340 */       total();
/* 5341 */       this.jDialog15.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton51ActionPerformed(ActionEvent evt) {
/* 5346 */     this.jDialog16.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton50ActionPerformed(ActionEvent evt) {
/* 5350 */     this.jDialog16.setVisible(false);
/* 5351 */     if (this.jRadioButton6.isSelected()) {
/* 5352 */       this.VENTANA1 = false;
/* 5353 */       nueva();
/* 5354 */       this.jDialog2.setVisible(true);
/*      */     } else {
/* 5356 */       this.VENTANA1 = true;
/* 5357 */       this.jDialog7.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 5362 */     for (int j = 0; j < this.jTable13.getRowCount(); j++) {
/* 5363 */       String texto = String.valueOf(this.jTable13.getValueAt(j, 1));
/*      */       
/* 5365 */       if (!texto.equals("")) {
/* 5366 */         boolean correcto = false;
/* 5367 */         String[] nombres = null;
/* 5368 */         int esp = 0;
/*      */         int i;
/* 5370 */         for (i = 0; i < texto.length(); i++) {
/* 5371 */           if (texto.charAt(i) == ' ') {
/* 5372 */             esp++;
/*      */           }
/*      */         } 
/* 5375 */         nombres = new String[esp + 1];
/* 5376 */         for (i = 0; i <= esp; i++) {
/* 5377 */           nombres[i] = "";
/*      */         }
/* 5379 */         esp = 0;
/* 5380 */         for (i = 0; i < texto.length(); i++) {
/* 5381 */           if (texto.charAt(i) == ' ') {
/* 5382 */             esp++;
/*      */           } else {
/* 5384 */             nombres[esp] = nombres[esp] + nombres[esp];
/*      */           } 
/*      */         } 
/* 5387 */         for (i = 0; i < nombres.length; i++) {
/* 5388 */           if (nombres[i].length() == 0) {
/* 5389 */             JOptionPane.showMessageDialog(this.jFrame1, "Tienes un espacio de más en el siguiente dato:\n" + String.valueOf(this.jTable13.getValueAt(j, 0)) + " - " + texto + "_", "Error 031 - Espacio", 0, this.ERROR);
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 5396 */     int res = JOptionPane.showConfirmDialog(this.jDialog17, "¿Estás seguro que deseas agregar la nueva guía a la prefactura?", "Agregar Guía", 0, 3, this.GUARDAR);
/* 5397 */     if (res == 0) {
/* 5398 */       DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 5399 */       String[] arrayOfString = new String[this.jTable13.getRowCount() + 2];
/* 5400 */       for (int i = 0; i < this.jTable13.getRowCount(); i++) {
/* 5401 */         String dato = String.valueOf(this.jTable13.getValueAt(i, 1));
/* 5402 */         arrayOfString[i] = dato.toUpperCase();
/*      */       } 
/* 5404 */       arrayOfString[this.jTable13.getRowCount()] = "$0.0";
/* 5405 */       arrayOfString[this.jTable13.getRowCount() + 1] = "$0.0";
/* 5406 */       temp.addRow((Object[])arrayOfString);
/*      */       
/* 5408 */       String[][] datos = new String[this.COLUMNASTABLA.length - 2][2];
/* 5409 */       for (int k = 0; k < this.COLUMNASTABLA.length - 2; k++) {
/* 5410 */         datos[k][0] = this.COLUMNASTABLA[k];
/* 5411 */         datos[k][1] = "";
/*      */       } 
/* 5413 */       this.jTable13.setModel(new DefaultTableModel((Object[][])datos, (Object[])new String[] { "Columnas", "Información" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5419 */             boolean[] canEdit = new boolean[] { false, true };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5424 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 5427 */       this.jScrollPane15.setViewportView(this.jTable13);
/* 5428 */       this.jTable13.getColumnModel().getColumn(0).setMinWidth(90);
/* 5429 */       this.jTable13.getColumnModel().getColumn(0).setMaxWidth(90);
/* 5430 */       this.jTextField29.setText("");
/*      */       
/* 5432 */       this.jTextPane1.setText("");
/* 5433 */       SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 5434 */       StyleConstants.setBold(attrs, true);
/* 5435 */       sacarResiduos();
/* 5436 */       String cant = "";
/*      */       try {
/* 5438 */         for (int m = 0; m < this.RESABREV.length; m++) {
/* 5439 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[m] + ":", attrs);
/* 5440 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear(Float.parseFloat("" + this.TONSRES[m])) + "\n", null);
/*      */         } 
/* 5442 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 5443 */         if (this.TONELADA) {
/* 5444 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/* 5445 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + redondear(Float.parseFloat("" + this.TONELADASTOTALES)) + "\n", null);
/*      */         } 
/* 5447 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 5448 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + this.jTable5.getRowCount() + "\n", null);
/* 5449 */       } catch (BadLocationException ex) {
/* 5450 */         Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 5456 */     this.jDialog17.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton46ActionPerformed(ActionEvent evt) {
/* 5463 */     String[][] datos = new String[this.COLUMNASTABLA.length - 2][2];
/* 5464 */     for (int i = 0; i < this.COLUMNASTABLA.length - 2; i++) {
/* 5465 */       datos[i][0] = this.COLUMNASTABLA[i];
/* 5466 */       datos[i][1] = "";
/*      */     } 
/* 5468 */     this.jTable13.setModel(new DefaultTableModel((Object[][])datos, (Object[])new String[] { "Columnas", "Información" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5474 */           boolean[] canEdit = new boolean[] { false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5479 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5482 */     this.jScrollPane15.setViewportView(this.jTable13);
/* 5483 */     this.jTable13.getColumnModel().getColumn(0).setMinWidth(90);
/* 5484 */     this.jTable13.getColumnModel().getColumn(0).setMaxWidth(90);
/* 5485 */     this.jTextField29.setText("");
/* 5486 */     this.jDialog17.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 5490 */     if (this.jTextArea2.getText().equals("")) {
/* 5491 */       this.jTextArea2.setBackground(Color.RED);
/* 5492 */       JOptionPane.showMessageDialog(this.jDialog18, "Te falta agregar la información del concepto", "Falta información", 0, this.ADVER);
/*      */     } else {
/* 5494 */       String cant = String.valueOf(this.jSpinner2.getValue());
/* 5495 */       DefaultTableModel temp = (DefaultTableModel)this.jTable12.getModel();
/* 5496 */       String valor = String.valueOf(this.jFormattedTextField7.getValue());
/* 5497 */       String valorP = "";
/* 5498 */       for (int i = 0; i < valor.length(); i++) {
/* 5499 */         if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 5500 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 5504 */       double importe = Double.parseDouble(cant) * Double.parseDouble(valorP);
/* 5505 */       this.cantidad.setValue(Double.valueOf(importe));
/* 5506 */       this.jFormattedTextField11.setValue(Double.valueOf(importe));
/* 5507 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas agregar los datos?", "Guardar Datos", 0, 3, this.GUARDAR);
/* 5508 */       if (res == 0) {
/* 5509 */         Object[] nuevo = { this.jSpinner2.getValue(), this.jTextArea2.getText().toUpperCase(), this.jFormattedTextField7.getText(), this.jFormattedTextField11.getText() };
/* 5510 */         temp.addRow(nuevo);
/*      */         
/* 5512 */         this.jSpinner2.setValue(Integer.valueOf(1));
/* 5513 */         this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 5514 */         this.jFormattedTextField11.setValue(Integer.valueOf(0));
/* 5515 */         this.jTextArea2.setText("");
/*      */         
/* 5517 */         subTotal();
/* 5518 */         iva();
/* 5519 */         retencion();
/* 5520 */         total();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 5526 */     this.jDialog18.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton48ActionPerformed(ActionEvent evt) {
/* 5530 */     this.jSpinner2.setValue(Integer.valueOf(1));
/* 5531 */     this.jTextArea2.setText("");
/* 5532 */     this.jFormattedTextField7.setValue(Integer.valueOf(0));
/* 5533 */     this.jDialog18.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField29ActionPerformed(ActionEvent evt) {
/* 5537 */     String dato = this.jTextField29.getText();
/* 5538 */     boolean siCaptura = false;
/* 5539 */     if (!dato.equals("")) {
/* 5540 */       String cliente = String.valueOf(this.jComboBox11.getSelectedItem());
/* 5541 */       this.encontrado = this.con.consultar("estatus", "llamadas_historicas,emp_generadora,guias", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_guia = '" + dato + "'");
/* 5542 */       if (this.encontrado) {
/* 5543 */         String[] campos = this.con.regresaReg("estatus,nombre_corto", "llamadas_historicas,emp_generadora,guias", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_guia = '" + dato + "' ", 2);
/* 5544 */         if (!campos[0].contains("Pagada Al Operador")) {
/* 5545 */           int res = JOptionPane.showConfirmDialog(this.jFrame1, "La guía que seleccionaste se encuentra en estatus " + campos[0] + "\n¿Deseas capturar los datos de la guía " + dato.toUpperCase() + "?", "Guía en otro estatus", 0, 3, this.PREG);
/* 5546 */           if (res == 0) {
/* 5547 */             siCaptura = true;
/*      */           }
/* 5549 */         } else if (!campos[1].equals(cliente)) {
/* 5550 */           int res = JOptionPane.showConfirmDialog(this.jFrame1, "La guía que seleccionaste pertenece a otro cliente " + campos[1] + "\n¿Deseas capturar los datos de la guía " + dato.toUpperCase() + "?", "Guía de otro cliente", 0, 3, this.PREG);
/* 5551 */           if (res == 0) {
/* 5552 */             siCaptura = true;
/*      */           }
/*      */         } else {
/* 5555 */           siCaptura = true;
/*      */         } 
/* 5557 */         if (siCaptura) {
/* 5558 */           String[] datos = this.con.regresaReg(this.CAMPOSCON, this.TABLAS, "where " + this.GENERAL + " and guias.num_guia ='" + dato + "'", this.COLUMNASTABLA.length - 2);
/* 5559 */           for (int i = 0; i < this.jTable13.getRowCount(); i++) {
/* 5560 */             this.jTable13.setValueAt(datos[i], i, 1);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton49ActionPerformed(ActionEvent evt) {
/* 5568 */     int ind = this.jTable5.getSelectedRow();
/* 5569 */     if (ind < 0) {
/* 5570 */       JOptionPane.showMessageDialog(this.jFrame1, "Debes seleccionar una guía para poder quitar la información", "Selecciona un viaje", 0, this.ADVER);
/*      */     } else {
/* 5572 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar la información de la guía: " + String.valueOf(this.jTable5.getValueAt(ind, 0)) + " ?", "Quitar Guía", 0, 3, this.PREG);
/* 5573 */       if (res == 0) {
/* 5574 */         DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 5575 */         temp.removeRow(ind);
/* 5576 */         subTotal();
/* 5577 */         iva();
/* 5578 */         retencion();
/* 5579 */         total();
/*      */         
/* 5581 */         this.jTextPane1.setText("");
/* 5582 */         SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 5583 */         StyleConstants.setBold(attrs, true);
/* 5584 */         sacarResiduos();
/* 5585 */         String cant = "";
/*      */         
/*      */         try {
/* 5588 */           for (int i = 0; i < this.RESABREV.length; i++) {
/* 5589 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[i] + ":", attrs);
/* 5590 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear(Float.parseFloat("" + this.TONSRES[i])) + "\n", null);
/*      */           } 
/* 5592 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 5593 */           if (this.TONELADA) {
/* 5594 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/* 5595 */             this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + redondear(Float.parseFloat("" + this.TONELADASTOTALES)) + "\n", null);
/*      */           } 
/* 5597 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 5598 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + this.jTable5.getRowCount() + "\n", null);
/* 5599 */         } catch (BadLocationException ex) {
/* 5600 */           Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton47ActionPerformed(ActionEvent evt) {
/* 5607 */     this.jDialog19.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton52ActionPerformed(ActionEvent evt) {
/* 5611 */     int ind = this.jTable12.getSelectedRow();
/* 5612 */     if (ind < 0) {
/* 5613 */       JOptionPane.showMessageDialog(this.jFrame1, "Debes seleccionar un concepto para poder quitar la información", "Selecciona un concepto", 0, this.ADVER);
/*      */     } else {
/* 5615 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar la información del concepto: " + String.valueOf(this.jTable12.getValueAt(ind, 1)) + " ?", "Quitar concepto", 0, 3, this.PREG);
/* 5616 */       if (res == 0) {
/* 5617 */         DefaultTableModel temp = (DefaultTableModel)this.jTable12.getModel();
/* 5618 */         temp.removeRow(ind);
/* 5619 */         subTotal();
/* 5620 */         iva();
/* 5621 */         retencion();
/* 5622 */         total();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 5628 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas aplicar la retención que seleccionaste?", "Aplicar Retención", 0, 3, this.PREG);
/* 5629 */     if (res == 0) {
/* 5630 */       this.RETENCIONAPLICADO = 0.0D;
/* 5631 */       if (this.jRadioButton7.isSelected()) {
/* 5632 */         this.OPCRETENCION = 0;
/* 5633 */       } else if (this.jRadioButton8.isSelected()) {
/* 5634 */         this.OPCRETENCION = 1;
/* 5635 */       } else if (this.jRadioButton9.isSelected()) {
/* 5636 */         this.OPCRETENCION = 2;
/* 5637 */       } else if (this.jRadioButton10.isSelected()) {
/* 5638 */         this.OPCRETENCION = 3;
/*      */       } 
/* 5640 */       subTotal();
/* 5641 */       iva();
/* 5642 */       retencion();
/* 5643 */       total();
/* 5644 */       this.jDialog19.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 5649 */     this.jDialog20.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton59ActionPerformed(ActionEvent evt) {
/* 5653 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas autorizar la prefactura?", "Autorizar Prefactura", 0, 3, this.GUARDAR);
/* 5654 */     if (res == 0) {
/*      */       
/* 5656 */       String[] datos = this.con.regresaColIndex("guia", "guiasFactura", "where numFac = " + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/* 5657 */       for (int i = 0; i < datos.length; i++) {
/* 5658 */         this.con.inserSinMsj("update guias set estatus='<Facturada: " + this.jTextField30.getText().toUpperCase() + " " + cargarFechaHoy() + ">' where num_guia='" + datos[i] + "'");
/*      */       }
/* 5660 */       this.con.inserSinMsj("update prefacturacliente set folio='" + this.jTextField30.getText().toUpperCase() + "',estatus ='<Facturada: " + this.jTextField30.getText().toUpperCase() + " " + cargarFechaHoy() + ">' where numFac = " + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/* 5661 */       consultar();
/* 5662 */       this.jDialog20.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel69MouseClicked(MouseEvent evt) {
/* 5667 */     this.con.consultar("estado", "prefacturacliente", "where numFac=" + this.PREFACTURAINTERNA);
/* 5668 */     JOptionPane.showMessageDialog(this.jDialog2, "<html>Este es el estatus completo de la prefactura que seleccionaste:<p><b><font color='RED'>" + this.con.Campo + "</font></b></html>", "Estatus de la prefactura", 0, this.INFO);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel69MouseExited(MouseEvent evt) {
/* 5673 */     this.jLabel69.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jLabel69MouseEntered(MouseEvent evt) {
/* 5677 */     this.jLabel69.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 5681 */     String valor = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 8));
/* 5682 */     if (valor.contains("Por Facturar")) {
/* 5683 */       this.PREORIGINAL = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 5684 */       limpiarTabla();
/* 5685 */       this.jComboBox11.setEnabled(true);
/* 5686 */       this.jTextArea3.setEnabled(true);
/* 5687 */       this.VENTANA = true;
/* 5688 */       this.TONELADA = false;
/* 5689 */       this.jButton10.setVisible(false);
/* 5690 */       this.jButton11.setVisible(false);
/* 5691 */       this.jDateChooser4.setEnabled(true);
/* 5692 */       this.jTextField3.setEnabled(true);
/*      */       
/* 5694 */       this.jTextField11.setEnabled(true);
/* 5695 */       this.jTextField12.setEnabled(true);
/*      */       
/* 5697 */       this.jButton46.setEnabled(true);
/* 5698 */       this.jButton49.setEnabled(true);
/*      */       
/* 5700 */       this.jButton48.setEnabled(true);
/* 5701 */       this.jButton52.setEnabled(true);
/*      */       
/* 5703 */       this.jLabel19.setEnabled(true);
/*      */       
/* 5705 */       this.jButton9.setText("Modificar");
/* 5706 */       this.jButton9.setMnemonic('M');
/* 5707 */       this.jButton9.setToolTipText("Modificar Prefactura (Alt+M)");
/* 5708 */       verPrefactura(String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/* 5709 */       this.jLabel69.setVisible(false);
/* 5710 */       this.jFormattedTextField2.setEnabled(true);
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 5716 */       JOptionPane.showMessageDialog(this.jFrame2, "La prefactura no se puede modificar, ya que su estatus no es <Por Facturar>", "No se puede modificar", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 5721 */     if (this.jComboBox9.getItemCount() > 0 && this.PRIMERA == true) {
/* 5722 */       consultar();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton40ActionPerformed(ActionEvent evt) {
/* 5731 */     String[] usuarios = this.con.regresaColIndex("nombre_usu", "usuarios", "where contrasena<>'' order by nombre_usu");
/* 5732 */     this.jComboBox10.removeAllItems();
/* 5733 */     for (String usu : usuarios) {
/* 5734 */       this.jComboBox10.addItem(usu);
/*      */     }
/* 5736 */     int res = JOptionPane.showConfirmDialog(this.jFrame2, this.jPanel4, "Cambiar a nuevo usuario", 0, 3, this.PREG);
/* 5737 */     if (res == 0) {
/* 5738 */       this.con.insertar("update prefacturacliente set usuario='" + String.valueOf(this.jComboBox10.getSelectedItem()) + "' where numFac ='" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)) + "'");
/* 5739 */       this.jTable2.setValueAt(this.jComboBox10.getSelectedItem(), this.jTable2.getSelectedRow(), 7);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton10ActionPerformed(ActionEvent evt) {
/* 5744 */     this.jFormattedTextField10.setEnabled(true);
/* 5745 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jRadioButton9ActionPerformed(ActionEvent evt) {
/* 5749 */     this.jFormattedTextField10.setEnabled(false);
/* 5750 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jRadioButton7ActionPerformed(ActionEvent evt) {
/* 5754 */     this.jFormattedTextField10.setEnabled(false);
/* 5755 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jRadioButton8ActionPerformed(ActionEvent evt) {
/* 5759 */     this.jFormattedTextField10.setEnabled(false);
/* 5760 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jLabel23MouseEntered(MouseEvent evt) {
/* 5764 */     this.jLabel23.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel23MouseExited(MouseEvent evt) {
/* 5768 */     this.jLabel23.setForeground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jLabel23MouseClicked(MouseEvent evt) {
/* 5772 */     if (this.jButton9.getText().equals("Guardar") || this.jButton9.getText().equals("Modificar")) {
/* 5773 */       this.jRadioButton3.setText(this.jLabel23.getText());
/*      */       
/* 5775 */       String valorP = "";
/* 5776 */       for (int i = 0; i < this.jLabel22.getText().length(); i++) {
/* 5777 */         if (this.jLabel22.getText().charAt(i) != '$' && this.jLabel22.getText().charAt(i) != ',') {
/* 5778 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 5781 */       if (this.jRadioButton3.isSelected()) {
/* 5782 */         subTotal();
/*      */       }
/* 5784 */       this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(valorP)));
/* 5785 */       this.jDialog21.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 5790 */     subTotal();
/* 5791 */     iva();
/* 5792 */     retencion();
/* 5793 */     total();
/* 5794 */     this.jDialog21.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 5798 */     this.jFormattedTextField4.setEnabled(false);
/* 5799 */     iva();
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 5803 */     this.jFormattedTextField4.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 5807 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jTextField7ActionPerformed(ActionEvent evt) {
/* 5811 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 5815 */     String cadena = this.jTextField3.getText();
/* 5816 */     if (!cadena.equals("")) {
/* 5817 */       if (this.presionado == null) {
/* 5818 */         this.presionado = new Presionado();
/* 5819 */         this.presionado.start();
/*      */       } else {
/* 5821 */         this.presionado.detenerFuera();
/* 5822 */         this.presionado = new Presionado();
/* 5823 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 5826 */       this.jTextField3.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox20ActionPerformed(ActionEvent evt) {
/* 5831 */     if (this.jComboBox20.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5832 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox12ActionPerformed(ActionEvent evt) {
/* 5837 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5838 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox13ActionPerformed(ActionEvent evt) {
/* 5843 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5844 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox14ActionPerformed(ActionEvent evt) {
/* 5849 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5850 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox15ActionPerformed(ActionEvent evt) {
/* 5855 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5856 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox16ActionPerformed(ActionEvent evt) {
/* 5861 */     if (this.jComboBox8.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5862 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox17ActionPerformed(ActionEvent evt) {
/* 5867 */     if (this.jComboBox9.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 5868 */       consultarGuias();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField9ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 5877 */     String cadena = this.jTextField9.getText();
/* 5878 */     if (!cadena.equals("")) {
/* 5879 */       if (this.presionado == null) {
/* 5880 */         this.presionado = new Presionado();
/* 5881 */         this.presionado.start();
/*      */       } else {
/* 5883 */         this.presionado.detenerFuera();
/* 5884 */         this.presionado = new Presionado();
/* 5885 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 5888 */       this.jTextField9.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable10MouseClicked(MouseEvent evt) {
/* 5893 */     if (evt.getClickCount() != 2)
/*      */     {
/*      */ 
/*      */       
/* 5897 */       this.jButton7.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 5902 */     int indice = this.jTable3.getSelectedRow();
/* 5903 */     if (indice < 0) {
/* 5904 */       JOptionPane.showMessageDialog(this.jDialog1, "Debes seleccionar un viaje para poder agregarlo a la prefactura", "Agregar Viaje", 0, this.ADVER);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void limpiarTabla1() {
/* 5910 */     this.IVAD = 0.0D;
/* 5911 */     this.RETENCIOND = 0.0D;
/* 5912 */     this.SUBTOTALD = 0.0D;
/* 5913 */     this.TOTALD = 0.0D;
/*      */     
/* 5915 */     this.jTextField39.setText("");
/* 5916 */     this.jTextField40.setText("");
/* 5917 */     this.jTextField41.setText("");
/* 5918 */     this.jTextField42.setText("");
/*      */   }
/*      */   
/*      */   public void sacarTotales2() {
/* 5922 */     double descuento = Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 5923 */     this.cantidad.setValue(Double.valueOf(this.SUBTOTALD));
/* 5924 */     this.IVAD = this.SUBTOTALD * 0.01D * this.IVA;
/* 5925 */     this.cantidad.setValue(Double.valueOf(this.IVAD));
/* 5926 */     if (this.TIENERETENCION) {
/* 5927 */       this.RETENCIOND = this.SUBTOTALD * 0.01D * this.RET;
/* 5928 */       this.cantidad.setValue(Double.valueOf(this.RETENCIOND));
/*      */     } else {
/* 5930 */       this.RETENCIOND = 0.0D;
/*      */     } 
/* 5932 */     this.TOTALD = this.SUBTOTALD - descuento + this.IVAD - this.RETENCIOND;
/* 5933 */     this.cantidad.setValue(Double.valueOf(this.TOTALD));
/* 5934 */     this.numLetra = new NumerosALetras(this.TOTALD, "MXN");
/* 5935 */     this.jLabel27.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void consultarGuias() {
/* 5939 */     System.out.println("contador ---> " + this.contador);
/* 5940 */     this.contador++;
/* 5941 */     this.PRIMERAGUIAS = true;
/* 5942 */     Date fecha1 = this.jDateChooser1.getDate();
/* 5943 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5944 */     String cadenaFecha = "";
/* 5945 */     cadenaFecha = formato.format(fecha1);
/* 5946 */     String AÑO = cadenaFecha.substring(0, 4);
/* 5947 */     String MES = cadenaFecha.substring(4, 6);
/* 5948 */     String DIA = cadenaFecha.substring(6, 8);
/* 5949 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 5951 */     fecha1 = this.jDateChooser2.getDate();
/* 5952 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 5953 */     cadenaFecha = "";
/* 5954 */     cadenaFecha = formato.format(fecha1);
/* 5955 */     AÑO = cadenaFecha.substring(0, 4);
/* 5956 */     MES = cadenaFecha.substring(4, 6);
/* 5957 */     DIA = cadenaFecha.substring(6, 8);
/* 5958 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */     
/* 5960 */     String residuo = "";
/* 5961 */     String tipo = "";
/* 5962 */     String equipo = "";
/* 5963 */     String plat = "";
/* 5964 */     String pozo = "";
/* 5965 */     String cliente = "";
/* 5966 */     String servicio = "";
/*      */     
/* 5968 */     if (this.jComboBox13.getSelectedIndex() != 0) {
/* 5969 */       residuo = String.valueOf(this.jComboBox13.getSelectedItem());
/*      */     }
/* 5971 */     if (this.jComboBox14.getSelectedIndex() != 0) {
/* 5972 */       tipo = String.valueOf(this.jComboBox14.getSelectedItem());
/*      */     }
/* 5974 */     if (this.jComboBox15.getSelectedIndex() != 0) {
/* 5975 */       equipo = String.valueOf(this.jComboBox15.getSelectedItem());
/*      */     }
/* 5977 */     if (this.jComboBox16.getSelectedIndex() != 0) {
/* 5978 */       plat = String.valueOf(this.jComboBox16.getSelectedItem());
/*      */     }
/* 5980 */     if (this.jComboBox17.getSelectedIndex() != 0) {
/* 5981 */       pozo = String.valueOf(this.jComboBox17.getSelectedItem());
/*      */     }
/* 5983 */     if (this.jComboBox20.getSelectedIndex() != 0) {
/* 5984 */       cliente = String.valueOf(this.jComboBox20.getSelectedItem());
/*      */     }
/* 5986 */     if (this.jComboBox12.getSelectedIndex() != 0) {
/* 5987 */       servicio = String.valueOf(this.jComboBox12.getSelectedItem());
/*      */     }
/* 5989 */     this.jTable10.setModel(new DefaultTableModel((Object[][])this.con
/* 5990 */           .buscarDatos(15, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,guias.tipo,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,guias.estatus", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale = vales.num_vale and guias.num_guia like '%" + this.jTextField7
/*      */ 
/*      */ 
/*      */             
/* 5994 */             .getText() + "%' and residuo like '%" + residuo + "%' and emp_generadora.nombre_corto like '%" + cliente + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plat + "%' and pozos.nombre like '%" + pozo + "%' and guias.estado ='Activa' and guias.tipo like '%" + tipo + "%' and (estatus like '%<Pagada Al Operador%' || estatus like '%<Asignada Al Operador%' || estatus like '%Sólo Cargada: En Patio%') and guias.servicio like '%" + servicio + "%' and num_tracto like '%" + this.jTextField9
/*      */             
/* 5996 */             .getText() + "%' order by guias.num_guia desc"), (Object[])new String[] { 
/*      */             "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Tipo", "Equipo", "Plataforma", "Pozo", "R.S.P.", 
/*      */             "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Estatus" })
/*      */         {
/*      */           
/* 6001 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6006 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6009 */     this.jLabel82.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable10.getRowCount() + "</HTML>");
/* 6010 */     this.celda2.pasarInd(this.con.revisarCol(this.jTable10, "<Asignada Al Operador", 0, 14, 2));
/*      */     
/* 6012 */     this.jTable10.setSelectionMode(0);
/* 6013 */     this.jTable10.setAutoCreateRowSorter(true);
/* 6014 */     this.jTable10.getTableHeader().setReorderingAllowed(false);
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
/*      */   public void sacarDepa() {
/* 6034 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 6035 */     this.DEPARTAMENTO = this.con.Campo;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 6039 */     this.error.pasarModal(true);
/* 6040 */     this.val.pasarModal(Boolean.valueOf(true));
/* 6041 */     String motivo = this.jTextArea5.getText();
/* 6042 */     if (motivo.equals("")) {
/* 6043 */       this.error.cargarError(this.jTextArea5, "050");
/*      */       return;
/*      */     } 
/* 6046 */     int res = JOptionPane.showConfirmDialog(this.jDialog10, "¿Estás seguro que deseas cancelar la factura que seleccionaste?", "Cancelar Factura", 0, 3, this.PREG);
/* 6047 */     if (res == 0) {
/* 6048 */       String num = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 6049 */       this.con.inserSinMsj("update prefacturacliente set estado='CANCELADA: " + this.USUARIO + " " + cargarFechaHoy() + " /*" + this.jTextArea5.getText().toUpperCase() + "*/' where numFac=" + num);
/* 6050 */       this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>',prefactura=0 where prefactura=" + num);
/* 6051 */       this.mensajeTry.guardarConf("Se canceló una prefactura, USUARIO: " + this.USUARIO, "Prefactura Cancelada (" + num + ")", "ERROR", "Facturacion");
/* 6052 */       this.jDialog10.setVisible(false);
/* 6053 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 6058 */     int quitar = 4 * letras;
/* 6059 */     x -= quitar;
/* 6060 */     return x;
/*      */   }
/*      */   
/*      */   public void agregarConcepto() {
/* 6064 */     if (this.jTextField8.getText().equals("")) {
/* 6065 */       this.jTextField8.setBackground(Color.RED);
/* 6066 */       JOptionPane.showMessageDialog(this.jDialog9, "Te falta agregar el concepto", "Falta concepto", 0, this.ADVER);
/* 6067 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 6068 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 6069 */       JOptionPane.showMessageDialog(this.jDialog9, "Te falta agregar la cantidad del concepto", "Falta cantidad", 0, this.ADVER);
/*      */     } else {
/* 6071 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas agregar el nuevo concepto?", "Agregar Conceptos", 0, 3, this.GUARDAR);
/* 6072 */       if (res == 0) {
/* 6073 */         this.OTROS[this.INDICEOTROS].insertarConcepto(Integer.parseInt(String.valueOf(this.jSpinner1.getValue())), this.jTextField8.getText().toUpperCase(), Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue())));
/* 6074 */         this.jSpinner1.setValue(Integer.valueOf(1));
/* 6075 */         this.jTextField8.setText("");
/* 6076 */         this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void limpiarTabla() {
/* 6082 */     this.jTable8.setModel(new DefaultTableModel(new Object[][] { { "Guia", Boolean.TRUE }, , { "Fecha", Boolean.TRUE }, , { "Servicio", null }, , { "Residuo", Boolean.TRUE }, , { "Cliente", null }, , { "Destino", null }, , { "Operador", null }, , { "Equipo", null }, , { "Plataforma", null }, , { "Pozo", null }, , { "F Carga", null }, , { "F Desc", null }, , { "Pedido", null }, , { "Tipo", null }, , { "Ticket", null }, , { "Peso", null }, , { "Tra", Boolean.TRUE }, , { "Rem", null }, , { "Rsp", null }, , { "Manif", null }, , { "P Unit", Boolean.TRUE }, , { "Sub", Boolean.TRUE },  }, (Object[])new String[] { "Columna", "Visible" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6111 */           Class[] types = new Class[] { Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 6116 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 6119 */     this.jScrollPane10.setViewportView(this.jTable8);
/*      */   }
/*      */   
/*      */   public void diseñarFactura() {
/* 6123 */     sacarTotales2();
/* 6124 */     String[] datos = this.con.regresaReg("empresa,calle,num,col,cp,ciudad,rfc,estado", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and nombre_corto = '" + String.valueOf(this.jComboBox11.getSelectedItem()) + "'", 8);
/*      */   }
/*      */   
/*      */   public void nueva() {
/* 6128 */     this.jTextField11.setEnabled(true);
/* 6129 */     this.jTextField12.setEnabled(true);
/* 6130 */     String consul = "";
/* 6131 */     if (!this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 6132 */       consul = "and nombre_usu = '" + this.USUARIO + "'";
/*      */     }
/* 6134 */     String estatus = "";
/* 6135 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/* 6136 */       estatus = "<Prefactura Ingresada>";
/* 6137 */     } else if (this.jComboBox8.getSelectedIndex() == 1) {
/* 6138 */       estatus = "<Cerrada>";
/*      */     } 
/* 6140 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 6141 */           .buscarDatos(5, "numInterPre,fecha,cliente,nombre_usu,folio", "prefacturas", "where actual like '%" + estatus + "%' " + consul + " order by numInterPre desc"), (Object[])new String[] { "Núm", "Fecha", "Cliente", "Elaboró", "Folio" })
/*      */         {
/*      */ 
/*      */           
/* 6145 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6150 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6154 */     this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 6155 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/* 6156 */     this.jTable4.getColumnModel().getColumn(1).setPreferredWidth(60);
/* 6157 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(60);
/* 6158 */     this.jTable4.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 6159 */     this.jTable4.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */     
/* 6161 */     this.jTable4.setSelectionMode(0);
/* 6162 */     this.jTable4.setAutoCreateRowSorter(true);
/* 6163 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 6164 */     this.jTable4.setShowVerticalLines(false);
/*      */   }
/*      */   
/*      */   public void cambiarTarifa() {
/* 6168 */     this.jRadioButton2.setSelected(true);
/* 6169 */     this.jComboBox5.setEnabled(false);
/* 6170 */     boolean ton = false;
/* 6171 */     int colTon = 0;
/* 6172 */     String tipo = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 5)); int i;
/* 6173 */     for (i = 0; i < this.jTable5.getColumnCount(); i++) {
/* 6174 */       if (this.jTable5.getColumnName(i).equals("Peso")) {
/* 6175 */         ton = true;
/* 6176 */         colTon = i;
/*      */         break;
/*      */       } 
/*      */     } 
/* 6180 */     if (tipo.equals("Tonelada") && !ton) {
/* 6181 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes agregar esta tarifa debido a que se paga por tonelada\nNo tienes la columna 'PESO'", "Falta columna Tons", 0, this.ADVER);
/*      */     } else {
/* 6183 */       this.jComboBox5.removeAllItems();
/* 6184 */       for (i = 0; i < this.COLUMNASTABLA.length; i++) {
/* 6185 */         this.jComboBox5.addItem(this.COLUMNASTABLA[i]);
/*      */       }
/* 6187 */       this.jTextField6.setText(String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn())));
/* 6188 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verPrefacturaCliente(String usuario, String prefac) {
/* 6193 */     this.PREFACTURAS = this.con.regresaColIndex("numFac", "prefacturacliente", "where usuario='" + usuario + "' order by numFac asc");
/* 6194 */     for (int i = 0; i < this.PREFACTURAS.length; i++) {
/* 6195 */       if (this.PREFACTURAS[i].equals(prefac)) {
/* 6196 */         this.POSICION = i;
/*      */       }
/*      */     } 
/* 6199 */     if (this.POSICION + 1 == this.PREFACTURAS.length) {
/* 6200 */       this.jButton11.setEnabled(false);
/*      */     } else {
/* 6202 */       this.jButton11.setEnabled(true);
/*      */     } 
/* 6204 */     if (this.POSICION == 0) {
/* 6205 */       this.jButton10.setEnabled(false);
/*      */     } else {
/* 6207 */       this.jButton10.setEnabled(true);
/*      */     } 
/* 6209 */     verPrefactura(prefac);
/* 6210 */     this.jFrame1.setExtendedState(0);
/*      */   }
/*      */   
/*      */   public void consultarTarifas() {
/* 6214 */     String cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 6215 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 6216 */       cliente = "";
/*      */     }
/* 6218 */     this.jTable7.setModel(new DefaultTableModel((Object[][])this.con
/* 6219 */           .buscarDatos(6, "num,cliente,tarifa,descripcion,montoLetra,tipoCobro", "tarifas", "where cliente like '%" + cliente + "%' order by cliente"), (Object[])new String[] { "Núm", "Cliente", "Tarifa", "Descripcion", "Monto", "Tipo" })
/*      */         {
/*      */ 
/*      */           
/* 6223 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6228 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6231 */     this.jTable7.setSelectionMode(0);
/* 6232 */     this.jTable7.setAutoCreateRowSorter(true);
/* 6233 */     this.jTable7.getTableHeader().setReorderingAllowed(false);
/* 6234 */     this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 6235 */     this.jTable7.getColumnModel().getColumn(0).setMaxWidth(40);
/* 6236 */     this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(100);
/* 6237 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(100);
/* 6238 */     this.jTable7.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 6239 */     this.jTable7.getColumnModel().getColumn(4).setMaxWidth(100);
/* 6240 */     this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 6241 */     this.jTable7.getColumnModel().getColumn(5).setMaxWidth(70);
/* 6242 */     this.jTable7.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void imprimir() {
/* 6246 */     this.NOMBRECOL = this.COLNOMBRES;
/* 6247 */     int l = this.jTable5.getRowCount() + this.jTable12.getRowCount();
/* 6248 */     if (this.jTable12.getRowCount() > 0) {
/* 6249 */       l++;
/*      */     }
/* 6251 */     this.LINEAS = new String[l];
/* 6252 */     this.REGIS = new String[l][this.jTable5.getColumnCount()];
/* 6253 */     int contarLinea = 0;
/* 6254 */     for (int i = 0; i < this.REGIS.length; i++) {
/* 6255 */       for (int k = 0; k < (this.REGIS[i]).length; k++) {
/* 6256 */         this.REGIS[i][k] = "";
/*      */       }
/*      */     } 
/* 6259 */     int cuenta = 0; int j;
/* 6260 */     for (j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6261 */       cuenta = 0;
/* 6262 */       contarLinea++;
/* 6263 */       for (int k = 0; k < this.jTable5.getColumnCount(); k++) {
/* 6264 */         String tipo = String.valueOf(this.jTable5.getValueAt(j, k));
/* 6265 */         String col = String.valueOf(this.jTable5.getValueAt(j, k));
/* 6266 */         if (k == 1 || this.jTable5.getColumnName(k).equals("F Carga") || this.jTable5.getColumnName(k).equals("F Desc")) {
/* 6267 */           String fecha = col;
/* 6268 */           col = fecha;
/* 6269 */         } else if (col.equals("LODO BASE AGUA")) {
/* 6270 */           col = "L AGUA";
/* 6271 */         } else if (col.equals("PLATAFORMA")) {
/* 6272 */           col = "PLAT";
/* 6273 */         } else if (col.equals("RECORTE BASE ACEITE")) {
/* 6274 */           col = "R ACEITE";
/* 6275 */         } else if (col.equals("AGUA DE FRACTURA")) {
/* 6276 */           col = "A DE FRAC";
/* 6277 */         } else if (col.equals("FLUIDO RECUPERADO")) {
/* 6278 */           col = "F RECUP";
/* 6279 */         } else if (col.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/* 6280 */           col = "F RECUP/TRAZAS";
/* 6281 */         } else if (col.equals("SERVICIO INTEGRAL")) {
/* 6282 */           col = "SERV INT";
/* 6283 */         } else if (col.equals("MOVIMIENTO EN FALSO")) {
/* 6284 */           col = "MOV FALSO";
/* 6285 */         } else if (col.equals("MOVIMIENTO INTERNO")) {
/* 6286 */           col = "MOV INTER";
/* 6287 */         } else if (col.equals("MOVIMIENTO LATERAL")) {
/* 6288 */           col = "MOV LAT";
/* 6289 */         } else if (col.equals("RETROEXCAVADORA")) {
/* 6290 */           col = "RETRO";
/* 6291 */         } else if (col.equals("RECORTE BASE AGUA")) {
/* 6292 */           col = "R AGUA";
/* 6293 */         } else if (col.equals("SERVICIO DE RETRO")) {
/* 6294 */           col = "RETRO";
/* 6295 */         } else if (col.equals("FLETES - VARIOS")) {
/* 6296 */           col = "FLET VAR";
/* 6297 */         } else if (col.equals("AGUA RESIDUAL")) {
/* 6298 */           col = "A RESIDUAL";
/* 6299 */         } else if (col.equals("LODO BASE ACEITE")) {
/* 6300 */           col = "L ACEITE";
/* 6301 */         } else if (col.equals("TOLVA PRESURIZADA")) {
/* 6302 */           col = "TOLVA PRESU";
/* 6303 */         } else if (col.equals("CUELLO DE GANZO")) {
/* 6304 */           col = "C GANZO";
/* 6305 */         } else if (col.equals("CONTENEDOR MARINO")) {
/* 6306 */           col = "C MARINO";
/* 6307 */         } else if (col.equals("EXCAVADORA ORUGA")) {
/* 6308 */           col = "E ORUGA";
/* 6309 */         } else if (col.equals("PRESAS METÁLICAS")) {
/* 6310 */           col = "P METÁLICAS";
/* 6311 */         } else if (col.equals("PRESIÓN Y VACÍO")) {
/* 6312 */           col = "PYV";
/* 6313 */         } else if (col.equals("PORTA CONTENEDORES")) {
/* 6314 */           col = "PORTA CONTE";
/* 6315 */         } else if (col.equals("TIRO DIRECTO")) {
/* 6316 */           col = "T DIREC";
/* 6317 */         } else if (col.equals("TOLVA GRANELERA")) {
/* 6318 */           col = "T GRANELERA";
/* 6319 */         } else if (col.equals("TOLVA DE ALUMINIO")) {
/* 6320 */           col = "T ALUMNIO";
/* 6321 */         } else if (col.equals("TOLVA DE ACERO INOXIDABLE")) {
/* 6322 */           col = "T DE ACE INOX";
/* 6323 */         } else if (col.equals("CUELLO DE GANZO")) {
/* 6324 */           col = "C GANZO";
/*      */         } 
/* 6326 */         this.REGIS[j][cuenta] = col;
/* 6327 */         this.LINEAS[j] = this.LINEAS[j] + this.LINEAS[j] + " ";
/* 6328 */         cuenta++;
/*      */       } 
/*      */     } 
/* 6331 */     if (this.jTable12.getRowCount() > 0) {
/* 6332 */       this.REGIS[contarLinea][0] = "A continuación se desglosan otros cargos para esta prefactura:";
/* 6333 */       contarLinea++;
/*      */     } 
/* 6335 */     for (j = 0; j < this.jTable12.getRowCount(); j++) {
/* 6336 */       this.REGIS[contarLinea][0] = String.valueOf(this.jTable12.getValueAt(j, 0));
/* 6337 */       this.REGIS[contarLinea][1] = String.valueOf(this.jTable12.getValueAt(j, 1));
/* 6338 */       this.REGIS[contarLinea][this.jTable5.getColumnCount() - 2] = String.valueOf(this.jTable12.getValueAt(j, 2));
/* 6339 */       this.REGIS[contarLinea][this.jTable5.getColumnCount() - 1] = String.valueOf(this.jTable12.getValueAt(j, 3));
/* 6340 */       contarLinea++;
/*      */     } 
/* 6342 */     ImprimirFactura imprimir = new ImprimirFactura();
/* 6343 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 6347 */     Calendar ahoraCal = Calendar.getInstance();
/* 6348 */     ahoraCal.setTime(this.fecha);
/* 6349 */     String mesesito = "";
/* 6350 */     String hoy = "";
/* 6351 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 6352 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 6354 */     if (ahoraCal.get(2) + 1 < 10) {
/* 6355 */       mesesito = "0" + mesesito;
/*      */     }
/* 6357 */     if (ahoraCal.get(5) < 10) {
/* 6358 */       hoy = "0" + hoy;
/*      */     }
/* 6360 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void verHistorial() {
/* 6364 */     Calendar ca = Calendar.getInstance();
/* 6365 */     Calendar fecha = Calendar.getInstance();
/* 6366 */     int aa = fecha.get(1);
/* 6367 */     int mm = fecha.get(2);
/* 6368 */     int dd = fecha.get(5);
/* 6369 */     mm++;
/* 6370 */     if (mm == 1) {
/* 6371 */       mm = 11;
/* 6372 */       aa--;
/* 6373 */     } else if (mm == 2) {
/* 6374 */       mm = 12;
/* 6375 */       aa--;
/*      */     } else {
/* 6377 */       mm--;
/*      */     } 
/* 6379 */     String fechaComple = "'" + aa + "-" + mm + "-" + dd + "'";
/* 6380 */     JTable tabla = new JTable();
/*      */     
/* 6382 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 6383 */           .buscarDatos(5, "prefacturacliente.fecha,totalTexto,cliente,usuario,numFac", "prefacturacliente", "where estado='ACTIVA' and prefacturacliente.fecha>" + fechaComple + " order by prefacturacliente.numfac desc"), (Object[])new String[] { "Fecha", "Cantidad", "Cliente", "Usuario", "Folio Inter" })
/*      */         {
/*      */ 
/*      */           
/* 6387 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6392 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6395 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 6396 */       String dia = diaFecha(String.valueOf(this.jTable1.getValueAt(i, 0)));
/* 6397 */       this.jTable1.setValueAt(dia, i, 0);
/*      */     } 
/*      */     
/* 6400 */     this.jTable1.setSelectionMode(0);
/* 6401 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(115);
/* 6402 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(115);
/* 6403 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public String diaFecha(String fecha) {
/* 6407 */     Date fechaFac = null;
/* 6408 */     Date Hoy = new Date();
/* 6409 */     String fechaCorta = fecha.substring(0, 10);
/*      */     
/* 6411 */     String año = fechaCorta.substring(0, 4);
/* 6412 */     String mes = fechaCorta.substring(5, 7);
/* 6413 */     String dia = fechaCorta.substring(8, 10);
/* 6414 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6415 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 6417 */       fechaFac = formatoDelTexto.parse(strFecha);
/* 6418 */     } catch (ParseException ex) {
/* 6419 */       ex.printStackTrace();
/*      */     } 
/* 6421 */     DateFormat df = DateFormat.getDateInstance(2);
/* 6422 */     String fechaInicioString = df.format(fechaFac);
/*      */     try {
/* 6424 */       fechaFac = df.parse(fechaInicioString);
/* 6425 */     } catch (ParseException parseException) {}
/*      */     
/* 6427 */     String fechaFinalString = df.format(Hoy);
/*      */     try {
/* 6429 */       Hoy = df.parse(fechaFinalString);
/* 6430 */     } catch (ParseException parseException) {}
/*      */     
/* 6432 */     long fechaInicialMs = fechaFac.getTime();
/* 6433 */     long fechaFinalMs = Hoy.getTime();
/* 6434 */     long diferencia = fechaFinalMs - fechaInicialMs;
/* 6435 */     double dias = Math.floor((diferencia / 86400000L));
/*      */     
/* 6437 */     String fechas = "";
/* 6438 */     int diaT = (int)dias;
/* 6439 */     if (dias == 0.0D) {
/* 6440 */       fechas = "Hoy";
/* 6441 */     } else if (dias == 1.0D) {
/* 6442 */       fechas = "Ayer";
/* 6443 */     } else if (dias == 2.0D) {
/* 6444 */       fechas = "Hace dos días";
/* 6445 */     } else if (dias == 3.0D) {
/* 6446 */       fechas = "Hace tres días";
/* 6447 */     } else if (dias == 4.0D) {
/* 6448 */       fechas = "Hace cuatro días";
/* 6449 */     } else if (dias == 5.0D) {
/* 6450 */       fechas = "Hace cinco días";
/* 6451 */     } else if (dias == 6.0D) {
/* 6452 */       fechas = "Hace seis días";
/* 6453 */     } else if (dias >= 7.0D && dias < 14.0D) {
/* 6454 */       fechas = "Hace una semana";
/* 6455 */     } else if (dias >= 14.0D && dias < 21.0D) {
/* 6456 */       fechas = "Hace tres semanas";
/* 6457 */     } else if (dias >= 21.0D && dias < 28.0D) {
/* 6458 */       fechas = "Hace cuatro semanas";
/*      */     } else {
/* 6460 */       fechas = "Hace más de un mes";
/*      */     } 
/* 6462 */     return fechas;
/*      */   }
/*      */   
/*      */   public void verPrefactura(String prefactura) {
/* 6466 */     this.jFormattedTextField4.setEnabled(false);
/* 6467 */     this.TONELADA = false;
/* 6468 */     String[] datos2 = this.con.regresaReg("iva,ret,folio,leyenda,descuentoTexto,tipoIva", "prefacturacliente", "where numFac=" + prefactura, 6);
/* 6469 */     if (datos2[5].equals("0")) {
/* 6470 */       this.jRadioButton3.setSelected(true);
/* 6471 */       this.jLabel23.setText("Iva " + this.IVA + "%");
/*      */     } else {
/* 6473 */       this.jRadioButton4.setSelected(true);
/* 6474 */       this.jLabel23.setText("Iva");
/*      */     } 
/* 6476 */     this.IVA = Double.parseDouble(datos2[0]);
/* 6477 */     this.RET = Double.parseDouble(datos2[1]);
/*      */     
/* 6479 */     this.jLabel24.setText("Retención " + this.RET + "%");
/* 6480 */     this.jFormattedTextField2.setEnabled(false);
/*      */     
/* 6482 */     if (datos2[3].contains("sólo a viajes")) {
/* 6483 */       this.OPCRETENCION = 1;
/* 6484 */     } else if (datos2[3].contains("a Subtotal")) {
/* 6485 */       this.OPCRETENCION = 0;
/* 6486 */     } else if (datos2[3].contains("Otros Conceptos")) {
/* 6487 */       this.OPCRETENCION = 2;
/*      */     } else {
/* 6489 */       String canti = datos2[3].substring(23, datos2[3].length());
/* 6490 */       this.OPCRETENCION = 3;
/* 6491 */       this.jFormattedTextField10.setEnabled(true);
/*      */       
/* 6493 */       String str1 = "";
/* 6494 */       for (int j = 0; j < canti.length(); j++) {
/* 6495 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '-') {
/* 6496 */           str1 = str1 + str1;
/*      */         }
/*      */       } 
/* 6499 */       Double RETAUX = Double.valueOf(Double.parseDouble(str1));
/* 6500 */       this.RETENCIONAPLICADO = RETAUX.doubleValue();
/* 6501 */       this.jFormattedTextField10.setValue(RETAUX);
/*      */     } 
/*      */     
/* 6504 */     String valorP = "";
/* 6505 */     if (datos2[4].equals("")) {
/* 6506 */       datos2[4] = "$0.00";
/*      */     }
/* 6508 */     for (int i = 0; i < datos2[4].length(); i++) {
/* 6509 */       if (datos2[4].charAt(i) != '$' && datos2[4].charAt(i) != ',' && datos2[4].charAt(i) != '-') {
/* 6510 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6513 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(valorP)));
/*      */     
/* 6515 */     this.jTextPane1.setText("");
/* 6516 */     String[] datos = this.con.regresaReg("prefacturacliente.ref,prefacturacliente.fecha,prefacturacliente.cliente,equipo,pozo,tons,numViajes,subTexto,ivaTexto,retTexto,totalTexto,leyenda,comentario", "prefacturacliente", "where numFac = " + prefactura, 13);
/* 6517 */     this.RESIDUOS = this.con.regresaColIndex("distinct(residuo)", "guiasfactura", "where numFac = " + prefactura + " order by residuo");
/*      */     
/* 6519 */     this.jLabel21.setText(datos[7]);
/* 6520 */     this.jLabel22.setText(datos[8]);
/* 6521 */     this.jLabel25.setText(datos[9]);
/* 6522 */     this.jLabel27.setText(datos[10]);
/* 6523 */     this.leyenda = datos[11];
/* 6524 */     this.jTextArea3.setText(datos[12]);
/*      */     
/* 6526 */     String año = datos[1].substring(0, 4);
/* 6527 */     String mes = datos[1].substring(5, 7);
/* 6528 */     String dia = datos[1].substring(8, 10);
/* 6529 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6530 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 6531 */     Date fechaG = null;
/*      */     try {
/* 6533 */       fechaG = formatoDelTexto.parse(strFecha);
/* 6534 */       this.jDateChooser4.setDate(fechaG);
/* 6535 */     } catch (ParseException ex) {
/* 6536 */       ex.printStackTrace();
/*      */     } 
/* 6538 */     this.jTextField3.setText(datos[0]);
/* 6539 */     this.jComboBox11.setSelectedItem(datos[2]);
/* 6540 */     this.jTextField11.setText(datos[3]);
/* 6541 */     this.jTextField12.setText(datos[4]);
/*      */     
/* 6543 */     this.PREFACTURAINTERNA = prefactura;
/* 6544 */     consultarPrefacGuardada(prefactura);
/* 6545 */     this.jFrame2.setVisible(false);
/* 6546 */     this.jDialog2.setVisible(false);
/*      */     
/* 6548 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 6549 */     StyleConstants.setBold(attrs, true);
/* 6550 */     sacarResiduos();
/* 6551 */     this.TONS = datos[5];
/*      */     try {
/* 6553 */       for (int j = 0; j < this.RESABREV.length; j++) {
/* 6554 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[j] + ":", attrs);
/* 6555 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear((float)this.TONSRES[j]) + "\n", null);
/*      */       } 
/* 6557 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 6558 */       if (this.TONELADA) {
/* 6559 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/*      */         
/* 6561 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + datos[5] + "\n", null);
/*      */       } 
/* 6563 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 6564 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + datos[6] + "\n", null);
/* 6565 */     } catch (BadLocationException ex) {
/* 6566 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */     
/* 6569 */     this.jLabel69.setVisible(true);
/* 6570 */     this.jFrame1.setExtendedState(6);
/* 6571 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 6575 */     String mesLetra = "";
/* 6576 */     if (mes.equals("01")) {
/* 6577 */       mesLetra = "Enero";
/* 6578 */     } else if (mes.equals("02")) {
/* 6579 */       mesLetra = "Febrero";
/* 6580 */     } else if (mes.equals("03")) {
/* 6581 */       mesLetra = "Marzo";
/* 6582 */     } else if (mes.equals("04")) {
/* 6583 */       mesLetra = "Abril";
/* 6584 */     } else if (mes.equals("05")) {
/* 6585 */       mesLetra = "Mayo";
/* 6586 */     } else if (mes.equals("06")) {
/* 6587 */       mesLetra = "Junio";
/* 6588 */     } else if (mes.equals("07")) {
/* 6589 */       mesLetra = "Julio";
/* 6590 */     } else if (mes.equals("08")) {
/* 6591 */       mesLetra = "Agosto";
/* 6592 */     } else if (mes.equals("09")) {
/* 6593 */       mesLetra = "Septiembre";
/* 6594 */     } else if (mes.equals("10")) {
/* 6595 */       mesLetra = "Octubre";
/* 6596 */     } else if (mes.equals("11")) {
/* 6597 */       mesLetra = "Noviembre";
/* 6598 */     } else if (mes.equals("12")) {
/* 6599 */       mesLetra = "Diciembre";
/*      */     } 
/* 6601 */     return mesLetra;
/*      */   }
/*      */   
/*      */   public void verGuia() {
/* 6605 */     int indice = this.jTable3.getSelectedRow();
/* 6606 */     String[] DATOS = this.con.regresaReg("guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,emp_destinataria.nombrecorto,tracto.num_tracto,tracto.placas,remolque.num_rem,remolque.placas,equipo,plataforma,pozos.nombre,vales.num_vale,vales.ticket,vales.peso,guias.tipo,operadores.nombre,operadores.ap_pat,operadores.ap_mat,guias.nombre,guias.estado,descrip,estatus", "guias,llamadas_historicas,equipos,plataformas,pozos,operadores,emp_generadora,emp_destinataria,REMOLQUE,tracto, vales ", "where llamadas_historicas.num_rem=remolque.num_rem and llamadas_historicas.num_tracto=tracto.num_tracto and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.num_vale = vales.num_vale and guias.num_guia like '%" + 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6611 */         String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "%'", 24);
/* 6612 */     this.jTextArea1.setText("");
/* 6613 */     String guia = DATOS[0];
/* 6614 */     String desti = DATOS[4];
/* 6615 */     String pozo = DATOS[12];
/*      */     
/* 6617 */     if (desti.equals("")) {
/* 6618 */       desti = "SIN DESTINO HASTA EL MOMENTO";
/*      */     }
/* 6620 */     if (pozo.equals("")) {
/* 6621 */       pozo = "NO ESPECIFICADO";
/*      */     }
/* 6623 */     String estatus = DATOS[21];
/* 6624 */     if (estatus.equals("ACTIVA")) {
/* 6625 */       this.jLabel33.setForeground(Color.BLUE);
/*      */     } else {
/* 6627 */       this.jLabel33.setForeground(Color.RED);
/*      */     } 
/* 6629 */     this.jLabel33.setText(estatus);
/* 6630 */     this.jLabel32.setText(DATOS[20]);
/* 6631 */     this.jLabel30.setText(guia);
/* 6632 */     this.jTextArea1.setText("GUÍA:                                           " + guia);
/* 6633 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nFECHA Y HORA DE EXPEDICIÓN:      " + this.jTextArea1.getText());
/* 6634 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTIPO DEL SERVICIO:                      " + this.jTextArea1.getText());
/* 6635 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTIPO DE CARGA:                           " + this.jTextArea1.getText());
/* 6636 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nCLIENTE U ORIGEN:                       " + this.jTextArea1.getText());
/* 6637 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nDESTINO:                                     " + this.jTextArea1.getText());
/* 6638 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTRACTOR:                                    " + this.jTextArea1.getText() + "        PLACAS:       " + DATOS[6]);
/* 6639 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nREMOLQUE:                                  " + this.jTextArea1.getText() + "        PLACAS:       " + DATOS[8]);
/* 6640 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nEQUIPO:                                      " + this.jTextArea1.getText());
/* 6641 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nPLATAFORMA:                              " + this.jTextArea1.getText());
/* 6642 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nPOZO:                                         " + this.jTextArea1.getText());
/* 6643 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nHOJA DE RECEPCIÓN:                    " + this.jTextArea1.getText());
/* 6644 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTICKET:                                       " + this.jTextArea1.getText());
/* 6645 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTONELADAS:                                " + this.jTextArea1.getText());
/* 6646 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nTIPO DE TRANSPORTE:                 " + this.jTextArea1.getText());
/* 6647 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nOPERADOR:                                 " + this.jTextArea1.getText() + " " + DATOS[17] + " " + DATOS[18]);
/* 6648 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nAUTORIZÓ:                                  " + this.jTextArea1.getText());
/* 6649 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nESTATUS:                                    " + this.jTextArea1.getText());
/* 6650 */     this.jTextArea1.setText(this.jTextArea1.getText() + "\nDESCRIPCIÓN DE LA CARGA:           " + this.jTextArea1.getText());
/* 6651 */     this.jLabel99.setText(DATOS[23]);
/* 6652 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 6656 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 6657 */     this.PRIVILEGIOS = this.con.Campo;
/* 6658 */     if (this.con.Campo.equals("ADMINISTRADOR") || this.con.Campo.equals("FACTURACIÓN")) {
/* 6659 */       this.jComboBox2.setSelectedItem(this.USUARIO);
/*      */     } else {
/*      */       
/* 6662 */       this.jComboBox2.setEnabled(true);
/* 6663 */       this.jComboBox2.setSelectedIndex(0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void subTotal() {
/* 6668 */     this.SUBTOTAL = 0.0D; int j;
/* 6669 */     for (j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6670 */       String canti = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 1));
/* 6671 */       String valorP = "";
/* 6672 */       for (int i = 0; i < canti.length(); i++) {
/* 6673 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 6674 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6677 */       this.SUBTOTAL += Double.parseDouble(valorP);
/*      */     } 
/*      */     
/* 6680 */     for (j = 0; j < this.jTable12.getRowCount(); j++) {
/* 6681 */       String canti = String.valueOf(this.jTable12.getValueAt(j, this.jTable12.getColumnCount() - 1));
/* 6682 */       String valorP = "";
/* 6683 */       for (int i = 0; i < canti.length(); i++) {
/* 6684 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 6685 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6688 */       this.SUBTOTAL += Double.parseDouble(valorP);
/*      */     } 
/* 6690 */     this.cantidad.setValue(Double.valueOf(this.SUBTOTAL));
/* 6691 */     this.jLabel21.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void iva() {
/* 6695 */     if (this.jRadioButton3.isSelected()) {
/* 6696 */       this.SUBIVA = this.SUBTOTAL * 0.01D * this.IVA;
/* 6697 */       this.cantidad.setValue(Double.valueOf(this.SUBIVA));
/* 6698 */       this.jLabel22.setText(this.cantidad.getText());
/* 6699 */       this.jFormattedTextField3.setValue(Double.valueOf(this.SUBIVA));
/* 6700 */       this.jLabel23.setText("Iva " + this.IVA + "%");
/*      */     } else {
/*      */       
/* 6703 */       this.jFormattedTextField4.setEnabled(true);
/* 6704 */       this.SUBIVA = Double.parseDouble(this.jFormattedTextField4.getValue().toString());
/* 6705 */       this.cantidad.setValue(Double.valueOf(this.SUBIVA));
/* 6706 */       this.jLabel22.setText(this.cantidad.getText());
/* 6707 */       this.jLabel23.setText("Iva");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void retencion() {
/* 6712 */     this.RETENCIONAPLICADO = 0.0D;
/* 6713 */     if (this.OPCRETENCION == 0) {
/* 6714 */       this.RETENCIONAPLICADO = this.SUBTOTAL;
/* 6715 */       this.leyenda = "Retención aplicado a Subtotal";
/* 6716 */     } else if (this.OPCRETENCION == 1) {
/* 6717 */       for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6718 */         String canti = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 1));
/* 6719 */         String valorP = "";
/* 6720 */         for (int i = 0; i < canti.length(); i++) {
/* 6721 */           if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 6722 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 6725 */         this.RETENCIONAPLICADO += Double.parseDouble(valorP);
/*      */       } 
/* 6727 */       this.leyenda = "Retención aplicado sólo a viajes";
/* 6728 */     } else if (this.OPCRETENCION == 2) {
/* 6729 */       for (int j = 0; j < this.jTable12.getRowCount(); j++) {
/* 6730 */         String canti = String.valueOf(this.jTable12.getValueAt(j, this.jTable12.getColumnCount() - 1));
/* 6731 */         String valorP = "";
/* 6732 */         for (int i = 0; i < canti.length(); i++) {
/* 6733 */           if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 6734 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 6737 */         this.RETENCIONAPLICADO += Double.parseDouble(valorP);
/*      */       } 
/* 6739 */       this.leyenda = "Retención aplicado a Otros Conceptos";
/* 6740 */     } else if (this.OPCRETENCION == 3) {
/* 6741 */       String cantidad = String.valueOf(this.jFormattedTextField10.getValue());
/* 6742 */       this.RETENCIONAPLICADO = Double.parseDouble(cantidad);
/* 6743 */       this.leyenda = "Retención aplicado a : " + this.jFormattedTextField10.getText();
/*      */     } 
/* 6745 */     this.RETENCION = this.RETENCIONAPLICADO * 0.01D * this.RET;
/* 6746 */     this.cantidad.setValue(Double.valueOf(this.RETENCION));
/* 6747 */     this.jLabel25.setText("-" + this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void total() {
/* 6751 */     double descuento = Double.parseDouble(this.jFormattedTextField2.getValue().toString());
/* 6752 */     String canti = this.jLabel21.getText();
/* 6753 */     String valorP = ""; int i;
/* 6754 */     for (i = 0; i < canti.length(); i++) {
/* 6755 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 6756 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6759 */     this.SUBTOTAL = Double.parseDouble(valorP);
/*      */     
/* 6761 */     canti = this.jLabel22.getText();
/* 6762 */     valorP = "";
/* 6763 */     for (i = 0; i < canti.length(); i++) {
/* 6764 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 6765 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6768 */     this.SUBIVA = Double.parseDouble(valorP);
/*      */     
/* 6770 */     canti = this.jLabel25.getText();
/* 6771 */     valorP = "";
/* 6772 */     for (i = 0; i < canti.length(); i++) {
/* 6773 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 6774 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6777 */     this.RETENCION = Double.parseDouble(valorP);
/*      */     
/* 6779 */     this.TOTAL = this.SUBTOTAL - descuento + this.SUBIVA - this.RETENCION;
/* 6780 */     this.cantidad.setValue(Double.valueOf(this.TOTAL));
/* 6781 */     this.jLabel27.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void sacarResiduos() {
/* 6785 */     this.TONELADASTOTALES = 0.0D;
/* 6786 */     String[] otrosRes = new String[50];
/* 6787 */     int numR = 0; int i;
/* 6788 */     for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 6789 */       boolean esta = false;
/* 6790 */       String resi = String.valueOf(this.jTable5.getValueAt(i, this.colResi));
/* 6791 */       for (int j = 0; j < otrosRes.length; j++) {
/* 6792 */         if (resi.equals(otrosRes[j])) {
/* 6793 */           esta = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 6797 */       if (!esta) {
/* 6798 */         otrosRes[numR] = resi;
/* 6799 */         numR++;
/*      */       } 
/*      */     } 
/* 6802 */     this.CONTRESI = new String[numR];
/* 6803 */     this.TONSRES = new double[numR];
/* 6804 */     this.RESABREV = new String[numR];
/* 6805 */     for (i = 0; i < numR; i++) {
/* 6806 */       this.CONTRESI[i] = otrosRes[i];
/*      */     }
/* 6808 */     this.RESABREV = this.CONTRESI;
/* 6809 */     if (this.TONELADA) {
/* 6810 */       for (i = 0; i < this.RESABREV.length; i++) {
/* 6811 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6812 */           String valorT = String.valueOf(this.jTable5.getValueAt(j, this.colResi));
/* 6813 */           if (valorT.equals(this.RESABREV[i])) {
/* 6814 */             double peso = 0.0D;
/*      */             try {
/* 6816 */               peso = Double.parseDouble(String.valueOf(this.jTable5.getValueAt(j, this.colTon)));
/* 6817 */               this.TONSRES[i] = this.TONSRES[i] + peso;
/* 6818 */               this.TONELADASTOTALES += Double.parseDouble(String.valueOf(this.jTable5.getValueAt(j, this.colTon)));
/* 6819 */             } catch (NumberFormatException numberFormatException) {}
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/* 6825 */       for (i = 0; i < this.RESABREV.length; i++) {
/* 6826 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6827 */           String valorT = String.valueOf(this.jTable5.getValueAt(j, this.colResi));
/* 6828 */           if (valorT.equals(this.RESABREV[i])) {
/* 6829 */             this.TONSRES[i] = this.TONSRES[i] + 1.0D;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Float redondear(float pasar) {
/* 6837 */     NumberFormat nf = NumberFormat.getInstance();
/* 6838 */     nf.setMaximumFractionDigits(2);
/* 6839 */     String st = nf.format(pasar);
/* 6840 */     return Float.valueOf(Float.parseFloat("" + pasar));
/*      */   }
/*      */   
/*      */   public int dameInd(String residuo) {
/* 6844 */     for (int i = 0; i < this.RESIDUOS.length; i++) {
/* 6845 */       if (this.RESIDUOS[i].equals(residuo)) {
/* 6846 */         return i;
/*      */       }
/*      */     } 
/* 6849 */     return 0;
/*      */   }
/*      */   
/*      */   public void cargarPrefactura() {
/* 6853 */     this.jButton10.setVisible(false);
/* 6854 */     this.jButton11.setVisible(false);
/* 6855 */     this.jDateChooser4.setEnabled(true);
/* 6856 */     this.jDateChooser4.setDate(new Date());
/* 6857 */     this.jTextField3.setEnabled(true);
/* 6858 */     this.jButton9.setText("Guardar");
/* 6859 */     this.jButton9.setMnemonic('G');
/* 6860 */     this.jButton9.setToolTipText("Guardar Prefactura (Alt+G)");
/* 6861 */     this.CONFIGURACIONES = this.con.regresaReg("iva,retencion", "configuraciones", "", 2);
/* 6862 */     this.IVA = Double.parseDouble(this.CONFIGURACIONES[0]);
/* 6863 */     this.RET = Double.parseDouble(this.CONFIGURACIONES[1]);
/* 6864 */     this.jLabel23.setText("Iva " + this.IVA + "%");
/* 6865 */     this.jLabel24.setText("Retención " + this.RET + "%");
/*      */     
/* 6867 */     this.jTextPane1.setText("");
/* 6868 */     String prefac = "";
/* 6869 */     if (!this.VENTANA1) {
/* 6870 */       prefac = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0));
/*      */     } else {
/* 6872 */       prefac = "-1";
/* 6873 */       this.jComboBox11.setEnabled(true);
/*      */     } 
/* 6875 */     this.PREFACTURAINTERNA = prefac;
/* 6876 */     String[] datos = this.con.regresaReg("folio,fecha,cliente,equipo,pozo,tons,numViajes,plat,pedido", "prefacturas", "where numInterPre = " + prefac, 9);
/* 6877 */     this.DATOSGENERALES = datos;
/* 6878 */     this.jTextField3.setText(datos[0]);
/* 6879 */     if (datos[2] == null) {
/* 6880 */       this.jComboBox11.setSelectedItem("Selecciona uno...");
/*      */     } else {
/* 6882 */       this.jComboBox11.setSelectedItem(datos[2]);
/*      */     } 
/* 6884 */     this.jTextField11.setText(datos[3]);
/* 6885 */     this.jTextField12.setText(datos[4]);
/*      */     
/* 6887 */     consultarPrefac(prefac);
/* 6888 */     this.jFrame2.setVisible(false);
/* 6889 */     this.jDialog2.setVisible(false);
/*      */     
/* 6891 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 6892 */     StyleConstants.setBold(attrs, true);
/* 6893 */     sacarResiduos();
/* 6894 */     String cant = "";
/* 6895 */     this.TONS = datos[5];
/*      */     
/*      */     try {
/* 6898 */       for (int j = 0; j < this.RESABREV.length; j++) {
/* 6899 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[j] + ":", attrs);
/* 6900 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear(Float.parseFloat("" + this.TONSRES[j])) + "\n", null);
/*      */       } 
/* 6902 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 6903 */       if (this.TONELADA) {
/* 6904 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/* 6905 */         if (!this.VENTANA1) {
/* 6906 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + datos[5] + "\n", null);
/*      */         } else {
/* 6908 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "        0.0\n", null);
/*      */         } 
/*      */       } 
/* 6911 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 6912 */       if (!this.VENTANA1) {
/* 6913 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + datos[6] + "\n", null);
/*      */       } else {
/* 6915 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "     0\n", null);
/*      */       } 
/* 6917 */     } catch (BadLocationException ex) {
/* 6918 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/* 6920 */     String[] tarifas = this.con.regresaColIndex("contenido", "tarifas", "order by prioridad desc");
/*      */     
/* 6922 */     this.jTarifas = new Tarifas[tarifas.length];
/* 6923 */     for (int i = 0; i < tarifas.length; i++) {
/* 6924 */       this.jTarifas[i] = new Tarifas(tarifas[i], Integer.parseInt("5"), Float.parseFloat("0.0"), "Viaje");
/*      */     }
/* 6926 */     aplicarSaldos();
/* 6927 */     this.jFrame1.setExtendedState(6);
/* 6928 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   public String[] sacarViaje(int i) {
/* 6932 */     String[] viaje = new String[this.jTable5.getColumnCount()];
/* 6933 */     for (int j = 0; j < this.jTable5.getColumnCount(); j++) {
/* 6934 */       viaje[j] = this.jTable5.getColumnName(j);
/*      */     }
/* 6936 */     return viaje;
/*      */   }
/*      */   
/*      */   public void aplicarSaldos() {
/* 6940 */     for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 6941 */       String clienteF = String.valueOf(this.jComboBox11.getSelectedItem());
/* 6942 */       String[] viaje = sacarViaje(i);
/* 6943 */       for (int j = 0; j < this.jTarifas.length; j++) {
/*      */         
/* 6945 */         String clienteT = "";
/* 6946 */         if (clienteT.equals(clienteF)) {
/* 6947 */           if (this.jTarifas[j].comparar(viaje)) {
/* 6948 */             if (this.colOtros != 0) {
/* 6949 */               this.jTable5.setValueAt(this.jTarifas[j].precio(), i, this.jTable5.getColumnCount() - 4);
/* 6950 */               this.jTable5.setValueAt(this.jTarifas[j].subTotal(i), i, this.jTable5.getColumnCount() - 3); break;
/*      */             } 
/* 6952 */             if (this.colOtros != 0) {
/* 6953 */               this.jTable5.setValueAt(this.jTarifas[j].precio(), i, this.jTable5.getColumnCount() - 4);
/* 6954 */               this.jTable5.setValueAt(this.jTarifas[j].subTotal(i), i, this.jTable5.getColumnCount() - 3); break;
/*      */             } 
/* 6956 */             this.jTable5.setValueAt(this.jTarifas[j].precio(), i, this.jTable5.getColumnCount() - 2);
/* 6957 */             this.jTable5.setValueAt(this.jTarifas[j].subTotal(i), i, this.jTable5.getColumnCount() - 1);
/*      */             
/*      */             break;
/*      */           } 
/*      */           
/* 6962 */           if (this.colOtros != 0) {
/* 6963 */             this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 4);
/* 6964 */             this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 3);
/*      */           } else {
/* 6966 */             this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 2);
/* 6967 */             this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 1);
/*      */           }
/*      */         
/*      */         }
/* 6971 */         else if (this.colOtros != 0) {
/* 6972 */           this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 4);
/* 6973 */           this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 3);
/*      */         } else {
/* 6975 */           this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 2);
/* 6976 */           this.jTable5.setValueAt("$0.00", i, this.jTable5.getColumnCount() - 1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 6981 */     if (this.colOtros != 0) {
/* 6982 */       sacarSub2();
/*      */     }
/* 6984 */     subTotal();
/* 6985 */     this.RETENCIONAPLICADO = this.SUBTOTAL;
/* 6986 */     iva();
/* 6987 */     retencion();
/* 6988 */     total();
/*      */   }
/*      */   
/*      */   public void sacarSub2() {
/* 6992 */     int columna = 4;
/* 6993 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 6994 */       String canti = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 3));
/* 6995 */       String valorP = "";
/*      */       
/* 6997 */       String canti2 = String.valueOf(this.jTable5.getValueAt(j, this.jTable5.getColumnCount() - 2));
/* 6998 */       String valorP2 = "";
/*      */       int i;
/* 7000 */       for (i = 0; i < canti.length(); i++) {
/* 7001 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 7002 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 7006 */       for (i = 0; i < canti2.length(); i++) {
/* 7007 */         if (canti2.charAt(i) != '$' && canti2.charAt(i) != ',') {
/* 7008 */           valorP2 = valorP2 + valorP2;
/*      */         }
/*      */       } 
/*      */       
/* 7012 */       double valor = Double.parseDouble(valorP) + Double.parseDouble(valorP2);
/* 7013 */       this.cantidad.setValue(Double.valueOf(valor));
/* 7014 */       this.jTable5.setValueAt(this.cantidad.getText(), j, this.jTable5.getColumnCount() - 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 7019 */     this.PRIMERA = true;
/* 7020 */     boolean correcto = true;
/* 7021 */     if (this.jDateChooser11.getDate() == null) {
/* 7022 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 7023 */       if (res == 0) {
/* 7024 */         this.jDateChooser11.setDate(this.fechaActual);
/* 7025 */         correcto = true;
/*      */       } else {
/* 7027 */         correcto = false;
/*      */       } 
/* 7029 */     } else if (this.jDateChooser12.getDate() == null) {
/* 7030 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 7031 */       if (res == 0) {
/* 7032 */         this.jDateChooser12.setDate(this.fechaActual);
/* 7033 */         correcto = true;
/*      */       } else {
/* 7035 */         correcto = false;
/*      */       } 
/* 7037 */     } else if (correcto) {
/* 7038 */       Date fecha1 = this.jDateChooser11.getDate();
/* 7039 */       Date fecha2 = this.jDateChooser12.getDate();
/*      */       
/* 7041 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 7042 */       String cadenaFecha = "";
/* 7043 */       cadenaFecha = formato.format(fecha1);
/* 7044 */       String AÑO = cadenaFecha.substring(0, 4);
/* 7045 */       String MES = cadenaFecha.substring(4, 6);
/* 7046 */       String DIA = cadenaFecha.substring(6, 8);
/* 7047 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 7049 */       cadenaFecha = formato.format(fecha2);
/* 7050 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 7051 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 7052 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 7053 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 7054 */       String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */       
/* 7056 */       this.jButton12.setEnabled(false);
/* 7057 */       this.jButton30.setEnabled(false);
/* 7058 */       this.jButton38.setEnabled(false);
/* 7059 */       this.jButton40.setEnabled(false);
/*      */       
/* 7061 */       String estatus = "";
/* 7062 */       String usuario = "";
/* 7063 */       String cliente = "";
/* 7064 */       String equipo = "";
/* 7065 */       String pozo = "";
/*      */       
/* 7067 */       if (this.jComboBox1.getSelectedIndex() != 2) {
/* 7068 */         estatus = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 7070 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 7071 */         usuario = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */       }
/* 7073 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 7074 */         cliente = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */       }
/* 7076 */       if (this.jComboBox6.getSelectedIndex() != 0) {
/* 7077 */         equipo = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */       }
/* 7079 */       if (this.jComboBox7.getSelectedIndex() != 0) {
/* 7080 */         pozo = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */       }
/* 7082 */       String est = "";
/* 7083 */       if (this.jComboBox9.getSelectedIndex() == 0) {
/* 7084 */         est = "";
/* 7085 */       } else if (this.jComboBox9.getSelectedIndex() == 1) {
/* 7086 */         est = "<Por Facturar>";
/* 7087 */       } else if (this.jComboBox9.getSelectedIndex() == 2) {
/* 7088 */         est = "<Facturada";
/*      */       } 
/*      */       
/* 7091 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 7092 */             .buscarDatos(10, "prefacturacliente.numFac,prefacturacliente.fecha,prefacturacliente.folio,ref,cliente,tons,totalTexto,usuario,prefacturacliente.estatus,estado", "prefacturacliente", "where estado like '%" + estatus + "%' and usuario like '%" + usuario + "%' and prefacturacliente.folio like '%" + this.jTextField1.getText() + "%' and cliente like '%" + cliente + "%' and equipo like'%" + equipo + "%' and pozo like '%" + pozo + "%' and ref like '%" + this.jTextField2.getText() + "%' and prefacturacliente.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and estatus like '%" + est + "%' order by prefacturacliente.numFac desc"), (Object[])new String[] { "Núm", "Fecha", "Folio", "Referencia", "Cliente", "Tons", "Total", "Usuario", "Estatus", "Activa/Cancelada" })
/*      */           {
/*      */ 
/*      */             
/* 7096 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7101 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 7104 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable2.getRowCount() + "</HTML>");
/* 7105 */       String[] arre = this.con.regresaColIndex("numFac", "prefacturacliente", "where estatus ='<Por Facturar>' and estado='ACTIVA' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 7106 */       this.celda2.pasarInd3(arre);
/* 7107 */       this.celda2.pasarInd5(this.con.revisarCol(this.jTable2, "CANCELADA", 0, 9, 2));
/*      */       
/* 7109 */       this.jTable2.setSelectionMode(0);
/* 7110 */       this.jTable2.setAutoCreateRowSorter(true);
/* 7111 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 7113 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 7114 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
/* 7115 */       this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 7116 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(70);
/* 7117 */       this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 7118 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(70);
/* 7119 */       this.jTable2.getColumnModel().getColumn(5).setPreferredWidth(60);
/* 7120 */       this.jTable2.getColumnModel().getColumn(5).setMaxWidth(60);
/* 7121 */       this.jTable2.getColumnModel().getColumn(6).setPreferredWidth(90);
/* 7122 */       this.jTable2.getColumnModel().getColumn(6).setMaxWidth(90);
/* 7123 */       this.jTable2.getColumnModel().getColumn(7).setPreferredWidth(120);
/* 7124 */       this.jTable2.getColumnModel().getColumn(7).setMaxWidth(120);
/*      */       
/* 7126 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 7127 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 7128 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 7129 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 7130 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 7131 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 7132 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 7133 */       this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 7134 */       this.jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 7135 */       this.jTable2.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/*      */       
/* 7137 */       double valor = 0.0D;
/* 7138 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 7139 */         String canti = String.valueOf(this.jTable2.getValueAt(i, 6));
/* 7140 */         String valorP = "";
/*      */         
/* 7142 */         for (int j = 0; j < canti.length(); j++) {
/* 7143 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7144 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 7147 */         valor += Double.parseDouble(valorP);
/*      */       } 
/* 7149 */       this.cantidad.setValue(Double.valueOf(valor));
/* 7150 */       this.jLabel61.setText(this.cantidad.getText());
/*      */       
/* 7152 */       this.con.consultar("sum(tons)", "prefacturacliente", "where estado like '%" + estatus + "%' and usuario like '%" + usuario + "%' and prefacturacliente.folio like '%" + this.jTextField1.getText() + "%' and cliente like '%" + cliente + "%' and equipo like'%" + equipo + "%' and pozo like '%" + pozo + "%' and ref like '%" + this.jTextField2.getText() + "%' and prefacturacliente.fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 7153 */       if (this.con.Campo != null) {
/* 7154 */         this.jLabel67.setText("" + redondear(Float.parseFloat(this.con.Campo)));
/*      */       } else {
/* 7156 */         this.jLabel67.setText("0.0");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarViajes() {
/* 7162 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 7163 */           .buscarDatos(4, "num_guia,guias.fecha,tipo,operador", "guias", "where (estatus ='<Asignada al Operador>' || estatus='<Pagada Al Operador>' || estatus='<Sólo Cargada: En Patio>') and estado ='ACTIVA'and guias.fecha>'2011-01-01' order by num_guia"), (Object[])new String[] { "Guia", "Fecha", "Tipo", "Operador" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7168 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7173 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7176 */     this.jLabel28.setText("" + this.jTable3.getRowCount() + " Viajes");
/* 7177 */     this.jTable3.setSelectionMode(0);
/* 7178 */     this.jTable3.setAutoCreateRowSorter(true);
/* 7179 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7181 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 7182 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(110);
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarPrefac(String prefac) {
/* 7187 */     String llamadas = "";
/* 7188 */     String guias = "";
/* 7189 */     String vales = "";
/* 7190 */     String cliente = "";
/* 7191 */     String destino = "";
/* 7192 */     String equipo = "";
/* 7193 */     String plataforma = "";
/* 7194 */     String pozo = "";
/*      */     
/* 7196 */     String cond1 = "";
/* 7197 */     String cond2 = "";
/* 7198 */     String cond3 = "";
/* 7199 */     String cond4 = "";
/* 7200 */     String cond5 = "";
/* 7201 */     String cond6 = "";
/* 7202 */     String cond7 = "";
/* 7203 */     String cond8 = "";
/* 7204 */     String cond9 = "";
/*      */     
/* 7206 */     for (int i = 0; i < this.COLUMNASTABLA.length; i++) {
/* 7207 */       if (this.COLUMNASTABLA[i].equals("Guía") || this.COLUMNASTABLA[i].equals("Fecha") || this.COLUMNASTABLA[i].equals("Servicio") || this.COLUMNASTABLA[i].equals("Tipo") || this.COLUMNASTABLA[i].equals("Pedido") || this.COLUMNASTABLA[i].equals("Manif")) {
/* 7208 */         guias = "guias";
/*      */       }
/* 7210 */       if (this.COLUMNASTABLA[i].equals("Residuo")) {
/* 7211 */         llamadas = "llamadas_historicas";
/* 7212 */         cond1 = " llamadas_historicas.num_guia = guias.num_guia ";
/*      */       } 
/* 7214 */       if (this.COLUMNASTABLA[i].equals("Equipo")) {
/* 7215 */         llamadas = "llamadas_historicas";
/* 7216 */         equipo = "equipos";
/* 7217 */         cond2 = " llamadas_historicas.num_equipo = equipos.num_equipo ";
/*      */       } 
/* 7219 */       if (this.COLUMNASTABLA[i].equals("Plataforma")) {
/* 7220 */         llamadas = "llamadas_historicas";
/* 7221 */         plataforma = "plataformas";
/* 7222 */         cond3 = " llamadas_historicas.num_plata = plataformas.num_plata ";
/*      */       } 
/* 7224 */       if (this.COLUMNASTABLA[i].equals("Pozo")) {
/* 7225 */         llamadas = "llamadas_historicas";
/* 7226 */         pozo = "pozos";
/* 7227 */         cond4 = " llamadas_historicas.num_pozo = pozos.num_pozo ";
/*      */       } 
/* 7229 */       if (this.COLUMNASTABLA[i].equals("Cliente")) {
/* 7230 */         cliente = "emp_generadora";
/* 7231 */         llamadas = "llamadas_historicas";
/* 7232 */         cond5 = " llamadas_historicas.clave_gene = emp_generadora.clave_gene ";
/*      */       } 
/* 7234 */       if (this.COLUMNASTABLA[i].equals("Destino")) {
/* 7235 */         destino = "emp_destinataria";
/* 7236 */         llamadas = "llamadas_historicas";
/* 7237 */         cond6 = " llamadas_historicas.clave_desti = emp_destinataria.clave_desti ";
/*      */       } 
/* 7239 */       if (this.COLUMNASTABLA[i].equals("Ticket") || this.COLUMNASTABLA[i].equals("Peso") || this.COLUMNASTABLA[i].equals("Rsp") || this.COLUMNASTABLA[i].equals("Operador") || this.COLUMNASTABLA[i].equals("F Carga") || this.COLUMNASTABLA[i].equals("F Desc")) {
/* 7240 */         vales = "vales";
/* 7241 */         cond7 = " guias.num_guia = vales.num_guia ";
/*      */       } 
/* 7243 */       if (this.COLUMNASTABLA[i].equals("Manif")) {
/* 7244 */         cond8 = " guias.Manifiesto";
/*      */       }
/*      */     } 
/* 7247 */     String tablas = "";
/* 7248 */     String condicion = "";
/* 7249 */     String general = "";
/* 7250 */     if (!guias.equals("")) {
/* 7251 */       tablas = "guias,";
/*      */     }
/* 7253 */     if (!llamadas.equals("")) {
/* 7254 */       tablas = tablas + "llamadas_historicas,";
/* 7255 */       general = cond1;
/*      */     } 
/* 7257 */     if (!equipo.equals("")) {
/* 7258 */       tablas = tablas + "equipos,";
/* 7259 */       general = general + " and " + general;
/*      */     } 
/* 7261 */     if (!plataforma.equals("")) {
/* 7262 */       tablas = tablas + "plataformas,";
/* 7263 */       general = general + " and " + general;
/*      */     } 
/* 7265 */     if (!pozo.equals("")) {
/* 7266 */       tablas = tablas + "pozos,";
/* 7267 */       general = general + " and " + general;
/*      */     } 
/* 7269 */     if (!cliente.equals("")) {
/* 7270 */       tablas = tablas + "emp_generadora,";
/* 7271 */       general = general + " and " + general;
/*      */     } 
/* 7273 */     if (!destino.equals("")) {
/* 7274 */       tablas = tablas + "emp_destinataria,";
/* 7275 */       general = general + " and " + general;
/*      */     } 
/* 7277 */     if (!vales.equals("")) {
/* 7278 */       tablas = tablas + "vales,";
/* 7279 */       general = general + " and " + general;
/*      */     } 
/* 7281 */     if (!cond8.equals("")) {
/* 7282 */       cond8 = "";
/*      */     }
/* 7284 */     tablas = tablas.substring(0, tablas.length() - 1);
/* 7285 */     this.CAMPOSCON = this.CAMPOSCON.substring(0, this.CAMPOSCON.length() - 1);
/* 7286 */     this.TABLAS = tablas;
/* 7287 */     this.GENERAL = general;
/* 7288 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 7289 */           .buscarDatos(this.COLUMNASTABLA.length - 2 - this.colExtra, this.CAMPOSCON, tablas, "where " + general + " and guias.factura =" + prefac), (Object[])this.COLUMNASTABLA)
/*      */         {
/* 7291 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7296 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7299 */     this.jTable5.setAutoCreateRowSorter(true);
/* 7300 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7302 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 2).setCellRenderer(this.celda);
/* 7303 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 1).setCellRenderer(this.celda);
/*      */     
/* 7305 */     for (int j = 0; j < this.tamañosCol.length; j++) {
/* 7306 */       if (this.tamañosCol[j] != 0) {
/* 7307 */         this.jTable5.getColumnModel().getColumn(j).setPreferredWidth(this.tamañosCol[j]);
/* 7308 */         this.jTable5.getColumnModel().getColumn(j).setMaxWidth(this.tamañosCol[j]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarPrefacGuardada(String prefac) {
/* 7314 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 7315 */       this.jTable8.setValueAt(Boolean.valueOf(false), i, 1);
/*      */     }
/*      */     
/* 7318 */     this.con.consultar("columnas", "prefacturacliente", "where numFac=" + prefac);
/* 7319 */     String columnas = this.con.Campo;
/* 7320 */     int col = 0;
/* 7321 */     for (int j = 0; j < columnas.length(); j++) {
/* 7322 */       if (columnas.charAt(j) == '-') {
/* 7323 */         col++;
/*      */       }
/*      */     } 
/* 7326 */     columnas = columnas + "-";
/* 7327 */     String[] COLAUX = new String[col];
/* 7328 */     this.COLUMNASTABLA = new String[col];
/* 7329 */     for (int k = 0; k < this.COLUMNASTABLA.length; k++) {
/* 7330 */       this.COLUMNASTABLA[k] = "";
/* 7331 */       COLAUX[k] = "";
/*      */     } 
/* 7333 */     String campo = "";
/* 7334 */     int cont = 0;
/* 7335 */     for (int m = 1; m < columnas.length(); m++) {
/* 7336 */       char l = columnas.charAt(m);
/* 7337 */       if (l != '-') {
/* 7338 */         campo = campo + campo;
/*      */       } else {
/* 7340 */         COLAUX[cont] = campo;
/* 7341 */         cont++;
/* 7342 */         campo = "";
/*      */       } 
/*      */     } 
/* 7345 */     this.CAMPOSTABLA = new String[col];
/* 7346 */     this.tamañosCol = new int[col];
/* 7347 */     this.COLNOMBRES = new String[col];
/* 7348 */     this.COLSELEC = new int[col];
/* 7349 */     this.CAMPOSCON = "";
/* 7350 */     int cuenta = 0;
/* 7351 */     col = 0;
/* 7352 */     for (int n = 0; n < this.IMPRESION.length; n++) {
/* 7353 */       String obj = this.IMPRESION[n];
/* 7354 */       String campoSql = COLAUX[col];
/* 7355 */       if (obj.equals(campoSql)) {
/* 7356 */         if (campoSql.equals("Otros $")) {
/* 7357 */           this.colExtra++;
/* 7358 */           this.colOtros = col;
/*      */         } 
/* 7360 */         if (campoSql.equals("Peso")) {
/* 7361 */           this.colTon = col;
/* 7362 */           this.TONELADA = true;
/*      */         } 
/* 7364 */         if (campoSql.equals("Residuo")) {
/* 7365 */           this.colResi = col;
/*      */         }
/* 7367 */         this.COLUMNASTABLA[col] = campoSql;
/*      */         
/* 7369 */         this.CAMPOSCON = this.CAMPOSCON + this.CAMPOSCON + ",";
/*      */         
/* 7371 */         this.tamañosCol[col] = this.TAMAÑOS[n];
/* 7372 */         this.COLSELEC[col] = this.COLIMPRESION[n];
/* 7373 */         this.COLNOMBRES[col] = this.IMPRESION[n];
/* 7374 */         col++;
/*      */         
/* 7376 */         for (int i3 = 0; i3 < this.jTable8.getRowCount(); i3++) {
/* 7377 */           String valor = String.valueOf(this.jTable8.getValueAt(i3, 0));
/* 7378 */           if (valor.equals(campoSql)) {
/* 7379 */             this.jTable8.setValueAt(Boolean.valueOf(true), i3, 1);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 7384 */       if (col == COLAUX.length) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */     
/* 7389 */     String llamadas = "";
/* 7390 */     String guias = "";
/* 7391 */     String manifiestosAG = "";
/* 7392 */     String manifiestosAC = "";
/* 7393 */     String vales = "";
/* 7394 */     String cliente = "";
/* 7395 */     String destino = "";
/* 7396 */     String equipo = "";
/* 7397 */     String plataforma = "";
/* 7398 */     String pozo = "";
/*      */     
/* 7400 */     String cond1 = "";
/* 7401 */     String cond2 = "";
/* 7402 */     String cond3 = "";
/* 7403 */     String cond4 = "";
/* 7404 */     String cond5 = "";
/* 7405 */     String cond6 = "";
/* 7406 */     String cond7 = "";
/* 7407 */     String cond8 = "";
/* 7408 */     String cond9 = "";
/*      */     
/* 7410 */     String tablas = "";
/* 7411 */     String condicion = "";
/* 7412 */     String general = "";
/* 7413 */     if (!guias.equals("")) {
/* 7414 */       tablas = "guias,";
/*      */     }
/* 7416 */     if (!llamadas.equals("")) {
/* 7417 */       tablas = tablas + "llamadas_historicas,";
/* 7418 */       general = cond1;
/*      */     } 
/* 7420 */     if (!equipo.equals("")) {
/* 7421 */       tablas = tablas + "equipos,";
/* 7422 */       general = general + " and " + general;
/*      */     } 
/* 7424 */     if (!plataforma.equals("")) {
/* 7425 */       tablas = tablas + "plataformas,";
/* 7426 */       general = general + " and " + general;
/*      */     } 
/* 7428 */     if (!pozo.equals("")) {
/* 7429 */       tablas = tablas + "pozos,";
/* 7430 */       general = general + " and " + general;
/*      */     } 
/* 7432 */     if (!cliente.equals("")) {
/* 7433 */       tablas = tablas + "emp_generadora,";
/* 7434 */       general = general + " and " + general;
/*      */     } 
/* 7436 */     if (!destino.equals("")) {
/* 7437 */       tablas = tablas + "emp_destinataria,";
/* 7438 */       general = general + " and " + general;
/*      */     } 
/* 7440 */     if (!vales.equals("")) {
/* 7441 */       tablas = tablas + "vales,";
/* 7442 */       general = general + " and " + general;
/*      */     } 
/* 7444 */     this.CAMPOSCON = this.CAMPOSCON.substring(0, this.CAMPOSCON.length() - 1);
/* 7445 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 7446 */           .buscarDatos(this.COLUMNASTABLA.length, this.CAMPOSCON, "guiasfactura", "where numFac =" + prefac + " order by guiasfactura.num"), (Object[])this.COLUMNASTABLA)
/*      */         {
/* 7448 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7453 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7456 */     this.jTable5.setAutoCreateRowSorter(true);
/* 7457 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7459 */     for (int i1 = 0; i1 < this.tamañosCol.length; i1++) {
/* 7460 */       if (this.tamañosCol[i1] != 0) {
/* 7461 */         this.jTable5.getColumnModel().getColumn(i1).setPreferredWidth(this.tamañosCol[i1]);
/* 7462 */         this.jTable5.getColumnModel().getColumn(i1).setMaxWidth(this.tamañosCol[i1]);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 7467 */     this.CAMPOSCON = "";
/* 7468 */     this.colMani = 0;
/* 7469 */     this.colOtros = 0;
/* 7470 */     this.colExtra = 0;
/* 7471 */     col = 0;
/* 7472 */     int columnasL = 0;
/* 7473 */     this.TONELADA = false;
/* 7474 */     this.TIENERETENCION = true;
/* 7475 */     this.jLabel69.setVisible(false); int i2;
/* 7476 */     for (i2 = 0; i2 < this.jTable8.getRowCount(); i2++) {
/* 7477 */       String obj = String.valueOf(this.jTable8.getValueAt(i2, 1));
/* 7478 */       if (obj.equals("true")) {
/* 7479 */         if (i2 == 0 || i2 == 1 || i2 == 3 || i2 == 16 || i2 == 20 || i2 == 21) {
/* 7480 */           columnasL++;
/*      */         }
/* 7482 */         if (i2 == 15) {
/* 7483 */           this.TONELADA = true;
/*      */         }
/* 7485 */         col++;
/*      */       } 
/*      */     } 
/* 7488 */     if (col < 1) {
/* 7489 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas seleccionar por lo menos las columnas generales", "Te faltan columnas", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 7492 */       this.COLUMNASTABLA = new String[col];
/* 7493 */       this.CAMPOSTABLA = new String[col];
/* 7494 */       this.tamañosCol = new int[col];
/* 7495 */       this.COLNOMBRES = new String[col];
/* 7496 */       this.COLSELEC = new int[col];
/* 7497 */       cuenta = 36;
/* 7498 */       for (i2 = 0; i2 < this.COLUMNASTABLA.length; i2++) {
/* 7499 */         this.COLUMNASTABLA[i2] = "";
/*      */       }
/* 7501 */       col = 0;
/* 7502 */       for (i2 = 0; i2 < this.jTable8.getRowCount(); i2++) {
/* 7503 */         String obj = String.valueOf(this.jTable8.getValueAt(i2, 1));
/* 7504 */         if (obj.equals("true")) {
/* 7505 */           if (i2 == 22) {
/* 7506 */             this.colOtros = col;
/* 7507 */             this.colExtra++;
/*      */           } 
/* 7509 */           if (i2 == 15) {
/* 7510 */             this.colTon = col;
/*      */           }
/* 7512 */           if (i2 == 3) {
/* 7513 */             this.colResi = col;
/*      */           }
/* 7515 */           if (i2 < 20) {
/* 7516 */             this.CAMPOSTABLA[col] = this.COLTABLA[i2];
/* 7517 */             this.CAMPOSCON = this.CAMPOSCON + this.CAMPOSCON + ",";
/*      */           } 
/* 7519 */           this.COLUMNASTABLA[col] = String.valueOf(this.jTable8.getValueAt(i2, 0));
/* 7520 */           this.tamañosCol[col] = this.TAMAÑOS[i2];
/* 7521 */           this.COLSELEC[col] = this.COLIMPRESION[i2];
/* 7522 */           this.COLNOMBRES[col] = this.IMPRESION[i2];
/* 7523 */           cuenta += this.COLSELEC[col];
/* 7524 */           col++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 7529 */     llamadas = "";
/* 7530 */     guias = "";
/* 7531 */     manifiestosAG = "";
/* 7532 */     manifiestosAC = "";
/* 7533 */     vales = "";
/* 7534 */     cliente = "";
/* 7535 */     destino = "";
/* 7536 */     equipo = "";
/* 7537 */     plataforma = "";
/* 7538 */     pozo = "";
/*      */     
/* 7540 */     cond1 = "";
/* 7541 */     cond2 = "";
/* 7542 */     cond3 = "";
/* 7543 */     cond4 = "";
/* 7544 */     cond5 = "";
/* 7545 */     cond6 = "";
/* 7546 */     cond7 = "";
/* 7547 */     cond8 = "";
/* 7548 */     cond9 = "";
/*      */     
/* 7550 */     for (i2 = 0; i2 < this.COLUMNASTABLA.length; i2++) {
/* 7551 */       if (this.COLUMNASTABLA[i2].equals("Guía") || this.COLUMNASTABLA[i2].equals("Fecha") || this.COLUMNASTABLA[i2].equals("Servicio") || this.COLUMNASTABLA[i2].equals("Tipo") || this.COLUMNASTABLA[i2].equals("Pedido") || this.COLUMNASTABLA[i2].equals("Manif")) {
/* 7552 */         guias = "guias";
/*      */       }
/* 7554 */       if (this.COLUMNASTABLA[i2].equals("Residuo")) {
/* 7555 */         llamadas = "llamadas_historicas";
/* 7556 */         cond1 = " llamadas_historicas.num_guia = guias.num_guia ";
/*      */       } 
/* 7558 */       if (this.COLUMNASTABLA[i2].equals("Equipo")) {
/* 7559 */         llamadas = "llamadas_historicas";
/* 7560 */         equipo = "equipos";
/* 7561 */         cond2 = " llamadas_historicas.num_equipo = equipos.num_equipo ";
/*      */       } 
/* 7563 */       if (this.COLUMNASTABLA[i2].equals("Plataforma")) {
/* 7564 */         llamadas = "llamadas_historicas";
/* 7565 */         plataforma = "plataformas";
/* 7566 */         cond3 = " llamadas_historicas.num_plata = plataformas.num_plata ";
/*      */       } 
/* 7568 */       if (this.COLUMNASTABLA[i2].equals("Pozo")) {
/* 7569 */         llamadas = "llamadas_historicas";
/* 7570 */         pozo = "pozos";
/* 7571 */         cond4 = " llamadas_historicas.num_pozo = pozos.num_pozo ";
/*      */       } 
/* 7573 */       if (this.COLUMNASTABLA[i2].equals("Cliente")) {
/* 7574 */         cliente = "emp_generadora";
/* 7575 */         llamadas = "llamadas_historicas";
/* 7576 */         cond5 = " llamadas_historicas.clave_gene = emp_generadora.clave_gene ";
/*      */       } 
/* 7578 */       if (this.COLUMNASTABLA[i2].equals("Destino")) {
/* 7579 */         destino = "emp_destinataria";
/* 7580 */         llamadas = "llamadas_historicas";
/* 7581 */         cond6 = " llamadas_historicas.clave_desti = emp_destinataria.clave_desti ";
/*      */       } 
/* 7583 */       if (this.COLUMNASTABLA[i2].equals("Ticket") || this.COLUMNASTABLA[i2].equals("Peso") || this.COLUMNASTABLA[i2].equals("Rsp") || this.COLUMNASTABLA[i2].equals("Operador") || this.COLUMNASTABLA[i2].equals("F Carga") || this.COLUMNASTABLA[i2].equals("F Desc")) {
/* 7584 */         vales = "vales";
/* 7585 */         cond7 = " guias.num_vale = vales.num_vale ";
/*      */       } 
/* 7587 */       if (this.COLUMNASTABLA[i2].equals("Manif")) {
/* 7588 */         cond8 = " guias.Manifiesto";
/*      */       }
/*      */     } 
/* 7591 */     tablas = "";
/* 7592 */     condicion = "";
/* 7593 */     general = "";
/* 7594 */     if (!guias.equals("")) {
/* 7595 */       tablas = "guias,";
/*      */     }
/* 7597 */     if (!llamadas.equals("")) {
/* 7598 */       tablas = tablas + "llamadas_historicas,";
/* 7599 */       general = cond1;
/*      */     } 
/* 7601 */     if (!equipo.equals("")) {
/* 7602 */       tablas = tablas + "equipos,";
/* 7603 */       general = general + " and " + general;
/*      */     } 
/* 7605 */     if (!plataforma.equals("")) {
/* 7606 */       tablas = tablas + "plataformas,";
/* 7607 */       general = general + " and " + general;
/*      */     } 
/* 7609 */     if (!pozo.equals("")) {
/* 7610 */       tablas = tablas + "pozos,";
/* 7611 */       general = general + " and " + general;
/*      */     } 
/* 7613 */     if (!cliente.equals("")) {
/* 7614 */       tablas = tablas + "emp_generadora,";
/* 7615 */       general = general + " and " + general;
/*      */     } 
/* 7617 */     if (!destino.equals("")) {
/* 7618 */       tablas = tablas + "emp_destinataria,";
/* 7619 */       general = general + " and " + general;
/*      */     } 
/* 7621 */     if (!vales.equals("")) {
/* 7622 */       tablas = tablas + "vales,";
/* 7623 */       general = general + " and " + general;
/*      */     } 
/* 7625 */     if (!cond8.equals("")) {
/* 7626 */       cond8 = "";
/*      */     }
/* 7628 */     tablas = tablas.substring(0, tablas.length() - 1);
/* 7629 */     this.CAMPOSCON = this.CAMPOSCON.substring(0, this.CAMPOSCON.length() - 1);
/*      */     
/* 7631 */     this.TABLAS = tablas;
/* 7632 */     this.GENERAL = general;
/*      */ 
/*      */     
/* 7635 */     if (this.colOtros != 0) {
/* 7636 */       this.OTROS = new OtrosConceptos[this.jTable5.getRowCount()];
/* 7637 */       for (i2 = 0; i2 < this.jTable5.getRowCount(); i2++) {
/* 7638 */         this.OTROS[i2] = new OtrosConceptos();
/* 7639 */         this.OTROS[i2].definirGuia(String.valueOf(this.jTable5.getValueAt(i2, 0)));
/* 7640 */         this.OTROS[i2].consultar();
/*      */       } 
/* 7642 */       this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 4).setCellRenderer(this.celda);
/* 7643 */       this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 3).setCellRenderer(this.celda);
/* 7644 */       this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 2).setCellRenderer(this.celda);
/* 7645 */       this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 1).setCellRenderer(this.celda);
/*      */     } 
/* 7647 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 2).setCellRenderer(this.celda);
/* 7648 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 1).setCellRenderer(this.celda);
/* 7649 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 7650 */     this.jTable12.setModel(new DefaultTableModel((Object[][])this.con
/* 7651 */           .buscarDatos(4, "cant,concepto,p_unitario,importe", "prefacturaotrosconcep", "where numPreFac =" + prefac + " order by num"), (Object[])new String[] { "Clave", "Concepto", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */           
/* 7655 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7660 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 7664 */     this.jTable12.getColumnModel().getColumn(0).setMinWidth(60);
/* 7665 */     this.jTable12.getColumnModel().getColumn(0).setMaxWidth(60);
/* 7666 */     this.jTable12.getColumnModel().getColumn(2).setMinWidth(90);
/* 7667 */     this.jTable12.getColumnModel().getColumn(2).setMaxWidth(90);
/* 7668 */     this.jTable12.getColumnModel().getColumn(3).setMinWidth(90);
/* 7669 */     this.jTable12.getColumnModel().getColumn(3).setMaxWidth(90);
/*      */     
/* 7671 */     this.jTable12.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 7672 */     this.jTable12.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 7676 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7678 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7682 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 7685 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7687 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jFormattedTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7691 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/* 7694 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7696 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7700 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 7703 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7705 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7709 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 7712 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7714 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7718 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 7721 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7723 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7727 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 7730 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7732 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextArea3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7736 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 7739 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7741 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7745 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField11, evt);
/*      */           }
/*      */         });
/*      */     
/* 7749 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7751 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7755 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 7758 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7760 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7764 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField29, evt);
/*      */           }
/*      */         });
/*      */     
/* 7768 */     this.jTextField39.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7770 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField39, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7774 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField39, evt);
/*      */           }
/*      */         });
/*      */     
/* 7778 */     this.jTextField40.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7780 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField40, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7784 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField40, evt);
/*      */           }
/*      */         });
/*      */     
/* 7788 */     this.jTextField41.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7790 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField41, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7794 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField41, evt);
/*      */           }
/*      */         });
/*      */     
/* 7798 */     this.jTextField42.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7800 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextField42, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7804 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextField42, evt);
/*      */           }
/*      */         });
/*      */     
/* 7808 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7810 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7814 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */     
/* 7818 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7820 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7824 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 7828 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7830 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7834 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 7837 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7839 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7843 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 7846 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7848 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7852 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 7855 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7857 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7861 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 7864 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7866 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7870 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 7873 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7875 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7879 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*      */     
/* 7883 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7885 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7889 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox9, evt);
/*      */           }
/*      */         });
/*      */     
/* 7893 */     this.jComboBox10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7895 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7899 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox10, evt);
/*      */           }
/*      */         });
/*      */     
/* 7903 */     this.jComboBox11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7905 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jComboBox11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7909 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jComboBox11, evt);
/*      */           }
/*      */         });
/*      */     
/* 7913 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7915 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7919 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 7922 */     this.jFormattedTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7924 */             PrefacturaCliente.this.jTextGanado(PrefacturaCliente.this.jFormattedTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7928 */             PrefacturaCliente.this.jTextPerdido(PrefacturaCliente.this.jFormattedTextField7, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 7934 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 7938 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void jPintarTexto(JComponent campo) {
/* 7942 */     campo.setBackground(Color.ORANGE);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 7946 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 7954 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 7960 */         return 30;
/*      */       
/*      */       case 1:
/* 7963 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 7965 */           return 29;
/*      */         }
/* 7967 */         return 28;
/*      */     } 
/*      */     
/* 7970 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCombos() {
/* 7975 */     String[] datos = this.con.regresaColIndex("nombre_usu", "usuarios", "where (priv='SUPER USUARIO' || priv='FACTURACION') && nombre_usu !='USUARIOADMIN1' order by nombre_usu");
/* 7976 */     this.jComboBox2.removeAllItems();
/* 7977 */     this.jComboBox2.addItem("TODOS"); int i;
/* 7978 */     for (i = 0; i < datos.length; i++) {
/* 7979 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */ 
/*      */     
/* 7983 */     datos = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 order by equipo");
/* 7984 */     this.jComboBox6.removeAllItems();
/* 7985 */     this.jComboBox6.addItem("TODOS");
/* 7986 */     this.jComboBox15.removeAllItems();
/* 7987 */     this.jComboBox15.addItem("TODOS");
/* 7988 */     for (i = 0; i < datos.length; i++) {
/* 7989 */       this.jComboBox6.addItem(datos[i]);
/* 7990 */       this.jComboBox15.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7996 */     datos = this.con.regresaColIndex("plataforma", "plataformas", "where num_plata<>0 order by plataforma");
/* 7997 */     this.jComboBox16.removeAllItems();
/* 7998 */     this.jComboBox16.addItem("TODOS");
/* 7999 */     for (i = 0; i < datos.length; i++) {
/* 8000 */       this.jComboBox16.addItem(datos[i]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 8005 */     datos = this.con.regresaColIndex("nombre", "pozos", "order by nombre");
/* 8006 */     this.jComboBox7.removeAllItems();
/* 8007 */     this.jComboBox7.addItem("TODOS");
/* 8008 */     this.jComboBox17.removeAllItems();
/* 8009 */     this.jComboBox17.addItem("TODOS");
/* 8010 */     for (i = 0; i < datos.length; i++) {
/* 8011 */       this.jComboBox7.addItem(datos[i]);
/* 8012 */       this.jComboBox17.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 8016 */     datos = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 order by nombre_corto");
/*      */     
/* 8018 */     this.jComboBox3.removeAllItems();
/* 8019 */     this.jComboBox3.addItem("TODOS");
/* 8020 */     this.jComboBox4.addItem("TODOS");
/* 8021 */     for (i = 0; i < datos.length; i++) {
/* 8022 */       this.jComboBox3.addItem(datos[i]);
/* 8023 */       this.jComboBox4.addItem(datos[i]);
/*      */     } 
/* 8025 */     this.RESIDUOS = this.con.regresaColIndex("distinct(residuo)", "llamadas_historicas", "");
/* 8026 */     this.jComboBox13.removeAllItems();
/* 8027 */     this.jComboBox13.addItem("TODOS");
/* 8028 */     for (i = 0; i < this.RESIDUOS.length; i++) {
/* 8029 */       this.RESIDUOS[i] = this.RESIDUOS[i].toUpperCase();
/* 8030 */       this.jComboBox13.addItem(this.RESIDUOS[i].toUpperCase());
/*      */     } 
/*      */ 
/*      */     
/* 8034 */     this.jComboBox11.removeAllItems();
/* 8035 */     this.jComboBox20.removeAllItems();
/* 8036 */     this.jComboBox11.addItem("Selecciona uno...");
/* 8037 */     this.jComboBox20.addItem("TODOS");
/* 8038 */     String[] Datos1 = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 order by nombre_corto");
/* 8039 */     for (int j = 0; j < Datos1.length; j++) {
/* 8040 */       this.jComboBox11.addItem(Datos1[j]);
/* 8041 */       this.jComboBox20.addItem(Datos1[j]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String iniciales() {
/* 8046 */     String iniciales = "";
/* 8047 */     String[] nombres = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'", 3);
/* 8048 */     iniciales = "" + nombres[0].charAt(0) + " " + nombres[0].charAt(0) + " " + nombres[1].charAt(0);
/* 8049 */     return iniciales;
/*      */   }
/*      */   
/*      */   public void prefacturaCliente(String usu) {
/* 8053 */     this.USUARIO = usu;
/* 8054 */     this.panel.setViewportView(this);
/* 8055 */     sacarDepa();
/* 8056 */     consultarViajes();
/* 8057 */     privilegios();
/* 8058 */     verHistorial();
/*      */   }
/*      */   
/*      */   public final class Tarifas
/*      */   {
/* 8063 */     JTable tabla = null;
/* 8064 */     Object[] COLUMNAS = null;
/* 8065 */     Object[][] REGISTROS = null;
/* 8066 */     int PRIORIDAD = 0;
/* 8067 */     float PRECIO = 0.0F;
/* 8068 */     String TIPO = "";
/* 8069 */     JScrollPane panel = new JScrollPane();
/*      */     
/*      */     public Tarifas(String contenido, int prio, float precio, String tipo) {
/* 8072 */       sacarTarifa(contenido);
/* 8073 */       this.PRIORIDAD = prio;
/* 8074 */       this.PRECIO = precio;
/* 8075 */       this.TIPO = tipo;
/* 8076 */       this.tabla = new JTable();
/* 8077 */       this.tabla.setModel(new DefaultTableModel(this.REGISTROS, this.COLUMNAS));
/* 8078 */       this.panel.setViewportView(this.tabla);
/*      */     }
/*      */     
/*      */     public void verTabla() {
/* 8082 */       JOptionPane.showMessageDialog(null, this.panel, "Estos son los datos", 0, PrefacturaCliente.this.INFO);
/*      */     }
/*      */     
/*      */     public int prioridad() {
/* 8086 */       return this.PRIORIDAD;
/*      */     }
/*      */     
/*      */     public String precio() {
/* 8090 */       PrefacturaCliente.this.cuadroPrecio.setValue(Float.valueOf(this.PRECIO));
/* 8091 */       return PrefacturaCliente.this.cuadroPrecio.getText();
/*      */     }
/*      */     
/*      */     public String subTotal(int i) {
/* 8095 */       if (this.TIPO.equals("Viaje")) {
/* 8096 */         return PrefacturaCliente.this.cuadroPrecio.getText();
/*      */       }
/* 8098 */       for (int j = 0; j < PrefacturaCliente.this.jTable5.getColumnCount(); j++) {
/* 8099 */         String col = PrefacturaCliente.this.jTable5.getColumnName(j);
/* 8100 */         if (col.equals("Peso")) {
/* 8101 */           float Ton = Float.parseFloat(String.valueOf(PrefacturaCliente.this.jTable5.getValueAt(i, j)));
/* 8102 */           PrefacturaCliente.this.cuadroPrecio.setValue(Float.valueOf(this.PRECIO * Ton));
/*      */         } 
/*      */       } 
/*      */       
/* 8106 */       return PrefacturaCliente.this.cuadroPrecio.getText();
/*      */     }
/*      */     
/*      */     public String dameCliente() {
/* 8110 */       return String.valueOf(this.tabla.getValueAt(0, 0));
/*      */     }
/*      */     
/*      */     public boolean comparar(String[] viaje) {
/* 8114 */       int cont = 0;
/* 8115 */       for (int i = 1; i < this.tabla.getColumnCount(); i++) {
/* 8116 */         String columna = this.tabla.getColumnName(i);
/* 8117 */         String valorT = String.valueOf(this.tabla.getValueAt(0, i));
/* 8118 */         if (columna.equals("SERVICIO")) {
/* 8119 */           String valorV = viaje[2];
/* 8120 */           if (valorV.equals(valorT)) {
/* 8121 */             cont++;
/*      */           }
/*      */         } 
/* 8124 */         if (columna.equals("GUÍA")) {
/* 8125 */           String valorV = viaje[0];
/* 8126 */           if (valorV.equals(valorT)) {
/* 8127 */             cont++;
/*      */           }
/* 8129 */         } else if (columna.equals("RESIDUO")) {
/* 8130 */           String valorV = viaje[3];
/* 8131 */           if (valorV.equals(valorT)) {
/* 8132 */             cont++;
/*      */           }
/* 8134 */         } else if (columna.equals("EQUIPO")) {
/* 8135 */           String valorV = viaje[5];
/* 8136 */           if (valorV.equals(valorT)) {
/* 8137 */             cont++;
/*      */           }
/*      */         } 
/*      */       } 
/* 8141 */       if (cont == this.tabla.getColumnCount() - 1) {
/* 8142 */         return true;
/*      */       }
/* 8144 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void sacarTarifa(String contenido) {
/* 8149 */       String[] columnas = { "", "", "", "", "", "", "", "", "", "" };
/* 8150 */       String[] info = { "", "", "", "", "", "", "", "", "", "" };
/* 8151 */       String[] datos = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 8152 */       int colum = 0;
/* 8153 */       int ren = 0;
/* 8154 */       int cont = 0; int i;
/* 8155 */       for (i = 0; i < contenido.length(); i++) {
/* 8156 */         char letra = contenido.charAt(i);
/* 8157 */         if (letra == '\n') {
/* 8158 */           colum++;
/*      */         } else {
/* 8160 */           datos[colum] = datos[colum] + datos[colum];
/*      */         } 
/*      */       } 
/* 8163 */       for (i = 0; i < colum; i++) {
/* 8164 */         char letra = datos[i].charAt(0);
/* 8165 */         if (letra != '<') {
/* 8166 */           info[ren] = datos[i];
/* 8167 */           ren++;
/* 8168 */         } else if (datos[i].charAt(1) != '/') {
/* 8169 */           columnas[cont] = datos[i].substring(1, datos[i].length() - 1);
/* 8170 */           cont++;
/*      */         } 
/*      */       } 
/* 8173 */       this.REGISTROS = (Object[][])new String[1][cont];
/* 8174 */       for (i = 0; i < cont; i++) {
/* 8175 */         this.REGISTROS[0][i] = new String(info[i]);
/*      */       }
/* 8177 */       this.COLUMNAS = (Object[])new String[cont];
/* 8178 */       for (i = 0; i < cont; i++) {
/* 8179 */         this.COLUMNAS[i] = new String(columnas[i]);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public String[] regresaLineas() {
/* 8185 */     return this.LINEAS;
/*      */   }
/*      */   public class CeldaRender extends DefaultTableCellRenderer { String[] indices;
/*      */     
/*      */     public CeldaRender() {
/* 8190 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8193 */       setEnabled((table == null || table.isEnabled()));
/* 8194 */       setHorizontalAlignment(4);
/* 8195 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8196 */       return this;
/*      */     } }
/*      */   public class ImprimirConceptos implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirConceptos() {
/* 8204 */       this.g2 = null;
/* 8205 */       this.Pag = 0;
/*      */       
/* 8207 */       this.linesPerPage = 50;
/* 8208 */       this.orientacion = 0;
/* 8209 */       this.X = 0.0D;
/* 8210 */       this.Y = 0.0D;
/* 8211 */       this.YINICIA = 90;
/* 8212 */       this.PXCOL = new int[] { 40, 90, 130, 370, 440, 500, 370, 445, 505, 550, 580, 610, 665, 710 };
/*      */     }
/*      */     private void initTextLines() {
/* 8215 */       if (this.textLines == null) {
/* 8216 */         int num = PrefacturaCliente.this.LINEASOTROSCONCEPTOS;
/* 8217 */         int i = PrefacturaCliente.this.LINEASOTROSCONCEPTOS;
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 8222 */       Font font = new Font("Serif", 0, 8);
/* 8223 */       FontMetrics metrics = g.getFontMetrics(font);
/* 8224 */       int lineHeight = metrics.getHeight();
/* 8225 */       if (this.pageBreaks == null) {
/* 8226 */         initTextLines();
/* 8227 */         this.orientacion = pf.getOrientation();
/* 8228 */         if (pf.getOrientation() == 1) {
/* 8229 */           this.linesPerPage = 70;
/* 8230 */           this.X = pf.getWidth();
/* 8231 */           this.Y = pf.getHeight();
/*      */         } else {
/* 8233 */           this.linesPerPage = 38;
/* 8234 */           this.X = pf.getWidth();
/* 8235 */           this.Y = pf.getHeight();
/*      */         } 
/* 8237 */         int numBreaks = (PrefacturaCliente.this.LINEASOTROSCONCEPTOS - 1) / this.linesPerPage;
/* 8238 */         this.Pag = numBreaks;
/* 8239 */         this.pageBreaks = new int[numBreaks];
/* 8240 */         for (int b = 0; b < numBreaks; b++) {
/* 8241 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 8244 */       if (pageIndex > this.pageBreaks.length) {
/* 8245 */         return 1;
/*      */       }
/* 8247 */       Graphics2D g2d = (Graphics2D)g;
/*      */       
/* 8249 */       this.g2 = g;
/* 8250 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 8251 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 8252 */       int end = (pageIndex == this.pageBreaks.length) ? PrefacturaCliente.this.LINEASOTROSCONCEPTOS : this.pageBreaks[pageIndex];
/* 8253 */       encabezado();
/* 8254 */       int y = this.YINICIA + 5;
/* 8255 */       int lineas = y;
/*      */       
/* 8257 */       Font fuente = new Font("Dialog", 0, 6);
/* 8258 */       this.g2.setFont(fuente);
/*      */       
/* 8260 */       g.drawString("Página " + pageIndex + 1, 555, 745);
/* 8261 */       fuente = new Font("Dialog", 1, 9);
/* 8262 */       this.g2.setFont(fuente);
/* 8263 */       g.drawString("FACTURA: ", 18, 78);
/*      */       
/* 8265 */       int valorLinea = lineas;
/*      */       
/* 8267 */       valorLinea += 2;
/* 8268 */       fuente = new Font("Dialog", 0, 6);
/* 8269 */       this.g2.setFont(fuente);
/* 8270 */       boolean entra = true;
/* 8271 */       String guiaAnterior = "";
/* 8272 */       boolean cambio = false;
/* 8273 */       boolean bandera = false;
/*      */ 
/*      */       
/* 8276 */       this.g2.setColor(new Color(204, 0, 0));
/* 8277 */       this.g2.drawLine(19, valorLinea + 3, 586, valorLinea + 3);
/*      */ 
/*      */       
/* 8280 */       Color color = Color.WHITE;
/*      */       
/* 8282 */       for (int line = start; line < end; line++) {
/* 8283 */         this.g2.setColor(new Color(204, 0, 0));
/* 8284 */         this.g2.drawLine(19, valorLinea + 3, 19, valorLinea + 13);
/* 8285 */         this.g2.drawLine(586, valorLinea + 3, 586, valorLinea + 13);
/*      */         
/* 8287 */         String guia = PrefacturaCliente.this.DATOSOTROS[line][4];
/* 8288 */         if (guia.equals(guiaAnterior)) {
/* 8289 */           entra = true;
/* 8290 */           cambio = false;
/*      */         } else {
/* 8292 */           entra = false;
/* 8293 */           cambio = true;
/*      */         } 
/* 8295 */         if (cambio) {
/* 8296 */           if (color.equals(Color.ORANGE)) {
/* 8297 */             color = Color.WHITE;
/*      */           } else {
/* 8299 */             color = Color.ORANGE;
/*      */           } 
/*      */         }
/* 8302 */         this.g2.setColor(color);
/* 8303 */         this.g2.fillRect(20, valorLinea + 4, 565, 9);
/* 8304 */         String valor = "";
/* 8305 */         if (line < 9) {
/* 8306 */           valor = "0" + line + 1;
/*      */         } else {
/* 8308 */           valor = "" + line + 1;
/*      */         } 
/* 8310 */         fuente = new Font("Dialog", 0, 7);
/* 8311 */         this.g2.setFont(fuente);
/* 8312 */         this.g2.setColor(Color.BLACK);
/* 8313 */         this.g2.drawString(valor, 20, valorLinea + 10);
/* 8314 */         this.g2.drawString(PrefacturaCliente.this.DATOSOTROS[line][4], this.PXCOL[0], valorLinea + 10);
/* 8315 */         this.g2.drawString(PrefacturaCliente.this.DATOSOTROS[line][0], this.PXCOL[1], valorLinea + 10);
/* 8316 */         this.g2.drawString(PrefacturaCliente.this.DATOSOTROS[line][1], this.PXCOL[2], valorLinea + 10);
/* 8317 */         this.g2.drawString(PrefacturaCliente.this.DATOSOTROS[line][2], this.PXCOL[3], valorLinea + 10);
/* 8318 */         this.g2.drawString(PrefacturaCliente.this.DATOSOTROS[line][3], this.PXCOL[4], valorLinea + 10);
/*      */         
/* 8320 */         if (line < PrefacturaCliente.this.DATOSOTROS.length - 1) {
/* 8321 */           String guia1 = PrefacturaCliente.this.DATOSOTROS[line][4];
/* 8322 */           String guia2 = PrefacturaCliente.this.DATOSOTROS[line + 1][4];
/* 8323 */           if (!guia1.equals(guia2)) {
/* 8324 */             for (int j = 0; j < PrefacturaCliente.this.OTROS.length; j++) {
/* 8325 */               String dameguia = PrefacturaCliente.this.OTROS[j].dameGuia();
/* 8326 */               if (dameguia.equals(guia1)) {
/* 8327 */                 this.g2.setColor(Color.BLACK);
/* 8328 */                 this.g2.drawString(PrefacturaCliente.this.OTROS[j].dameTotal(), this.PXCOL[5], valorLinea + 10);
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } else {
/* 8334 */           String guia1 = PrefacturaCliente.this.DATOSOTROS[line][4];
/* 8335 */           for (int j = 0; j < PrefacturaCliente.this.OTROS.length; j++) {
/* 8336 */             String dameguia = PrefacturaCliente.this.OTROS[j].dameGuia();
/* 8337 */             if (dameguia.equals(guia1)) {
/* 8338 */               this.g2.setColor(Color.BLACK);
/* 8339 */               this.g2.drawString(PrefacturaCliente.this.OTROS[j].dameTotal(), this.PXCOL[5], valorLinea + 10);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 8344 */         valorLinea += 9;
/* 8345 */         guiaAnterior = PrefacturaCliente.this.DATOSOTROS[line][4];
/*      */       } 
/* 8347 */       this.g2.setColor(new Color(204, 0, 0));
/* 8348 */       this.g2.drawLine(19, valorLinea + 5, 586, valorLinea + 5);
/*      */       
/* 8350 */       this.g2.setColor(Color.WHITE);
/* 8351 */       this.g2.fillRect((int)this.X - 26, 0, (int)this.X - 26, lineas);
/* 8352 */       return 0;
/*      */     }
/*      */     
/*      */     public void pintar(int x, int y) {
/* 8356 */       this.g2.setColor(Color.WHITE);
/* 8357 */       this.g2.fillRect(x, y - 10, 40, 12);
/* 8358 */       this.g2.setColor(Color.BLACK);
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 8362 */       Font fuente = new Font("Dialog", 0, 8);
/* 8363 */       this.g2.setFont(fuente);
/* 8364 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 8365 */       Image img = imagen.getImage();
/* 8366 */       this.g2.drawImage(img, 35, 7, 50, 50, null);
/* 8367 */       fuente = new Font("Times New Roman", 1, 8);
/* 8368 */       this.g2.setFont(fuente);
/* 8369 */       this.g2.drawString("FORSIS (" + PrefacturaCliente.this.base + ")", 18, 65);
/*      */       
/* 8371 */       this.g2.setColor(new Color(204, 0, 0));
/* 8372 */       this.g2.fillRect(120, 7, 150, 10);
/* 8373 */       this.g2.fillRect(280, 7, 150, 10);
/* 8374 */       this.g2.fillRect(440, 7, 190, 10);
/*      */       
/* 8376 */       this.g2.setColor(Color.WHITE);
/* 8377 */       fuente = new Font("Arial", 1, 7);
/* 8378 */       this.g2.setFont(fuente);
/* 8379 */       this.g2.drawString("DATOS DEL PROVEEDOR", 146, 15);
/* 8380 */       this.g2.drawString("DATOS DEL CLIENTE", 320, 15);
/* 8381 */       this.g2.drawString("PREFACTURA", 490, 15);
/*      */       
/* 8383 */       this.g2.setColor(Color.BLACK);
/* 8384 */       fuente = new Font("Arial", 1, 6);
/* 8385 */       this.g2.setFont(fuente);
/* 8386 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 120, 27);
/* 8387 */       this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA", 120, 35);
/* 8388 */       this.g2.drawString("KM 32.5, COL. GRACIANO SANCHEZ", 120, 43);
/* 8389 */       this.g2.drawString("CADEREYTA JIMENES, NUEVO LEÓN 67451", 120, 51);
/* 8390 */       this.g2.drawString("MÉXICO", 120, 59);
/* 8391 */       this.g2.drawString("FMF901004UZ9", 120, 67);
/*      */       
/* 8393 */       String valor = String.valueOf(PrefacturaCliente.this.jComboBox11.getSelectedItem());
/* 8394 */       if (valor.equals("<GENERAL>")) {
/* 8395 */         this.g2.drawString("CLIENTE EN GENERAL", 280, 25);
/*      */       } else {
/* 8397 */         String[] info = PrefacturaCliente.this.con.regresaReg("empresa,calle,num,col,ciudad,cp,rfc", "emp_generadora", "where nombre_corto='" + String.valueOf(PrefacturaCliente.this.jComboBox11.getSelectedItem()) + "'", 7);
/* 8398 */         this.g2.drawString(info[0], 280, 27);
/* 8399 */         this.g2.drawString(info[1], 280, 35);
/* 8400 */         this.g2.drawString(info[2], 280, 43);
/* 8401 */         this.g2.drawString(info[3] + ", " + info[3] + " " + info[4], 280, 51);
/* 8402 */         this.g2.drawString("MÉXICO", 280, 59);
/* 8403 */         this.g2.drawString(info[6], 280, 67);
/*      */       } 
/* 8405 */       fuente = new Font("Arial", 0, 6);
/* 8406 */       this.g2.setFont(fuente);
/* 8407 */       this.g2.drawString("Referencia", 440, 27);
/* 8408 */       this.g2.drawString("Equipo", 440, 37);
/* 8409 */       this.g2.drawString("Pozo", 440, 47);
/* 8410 */       this.g2.drawString("Toneladas", 440, 57);
/* 8411 */       this.g2.drawString("Fecha de la Factura", 440, 67);
/* 8412 */       this.g2.drawString("Autorizó", 440, 77);
/*      */       
/* 8414 */       Date fecha1 = PrefacturaCliente.this.jDateChooser4.getDate();
/* 8415 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 8416 */       String cadenaFecha = "";
/* 8417 */       cadenaFecha = formato.format(fecha1);
/* 8418 */       String AÑO = cadenaFecha.substring(0, 4);
/* 8419 */       String MES = cadenaFecha.substring(4, 6);
/* 8420 */       String DIA = cadenaFecha.substring(6, 8);
/* 8421 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*      */       
/* 8423 */       this.g2.drawString(PrefacturaCliente.this.jTextField3.getText().toUpperCase(), 505, 27);
/* 8424 */       this.g2.drawString(PrefacturaCliente.this.jTextField11.getText().toUpperCase(), 505, 37);
/* 8425 */       this.g2.drawString(PrefacturaCliente.this.jTextField12.getText().toUpperCase(), 505, 47);
/* 8426 */       this.g2.drawString(PrefacturaCliente.this.TONS, 505, 57);
/* 8427 */       this.g2.drawString(fechaCompleta1, 505, 67);
/* 8428 */       this.g2.drawString(PrefacturaCliente.this.iniciales(), 505, 77);
/*      */       
/* 8430 */       this.g2.setColor(new Color(204, 0, 0));
/* 8431 */       this.g2.fillRect(18, this.YINICIA - 8, 750, 10);
/*      */       
/* 8433 */       this.g2.setColor(Color.WHITE);
/* 8434 */       fuente = new Font("Dialog", 0, 8);
/* 8435 */       this.g2.setFont(fuente);
/*      */       
/* 8437 */       this.g2.drawString("Guía", this.PXCOL[0], this.YINICIA);
/* 8438 */       this.g2.drawString("Cant", this.PXCOL[1], this.YINICIA);
/* 8439 */       this.g2.drawString("Concepto", this.PXCOL[2], this.YINICIA);
/* 8440 */       this.g2.drawString("Importe", this.PXCOL[3], this.YINICIA);
/* 8441 */       this.g2.drawString("Subtotal", this.PXCOL[4], this.YINICIA);
/* 8442 */       this.g2.drawString("Total", this.PXCOL[5], this.YINICIA);
/*      */       
/* 8444 */       this.g2.setColor(Color.BLACK);
/* 8445 */       fuente = new Font("Dialog", 0, 7);
/* 8446 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 8450 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 8451 */       job.setPrintable(this);
/*      */       
/* 8453 */       PageFormat pf = job.defaultPage();
/* 8454 */       Paper papel = pf.getPaper();
/* 8455 */       papel.setSize(612.0D, 792.0D);
/* 8456 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 8457 */       pf.setPaper(papel);
/* 8458 */       pf.setOrientation(1);
/* 8459 */       job.setPrintable(new ImprimirConceptos(), pf);
/* 8460 */       job.defaultPage(pf);
/*      */       
/* 8462 */       boolean ok = job.printDialog();
/* 8463 */       if (ok)
/*      */         try {
/* 8465 */           job.print();
/* 8466 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirFactura implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas;
/*      */     int linesPerPage;
/*      */     int orientacion;
/*      */     double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirFactura() {
/* 8477 */       this.g2 = null;
/* 8478 */       this.Pag = 0;
/*      */       
/* 8480 */       this.linesPerPage = 50;
/* 8481 */       this.orientacion = 0;
/* 8482 */       this.X = 0.0D;
/* 8483 */       this.Y = 0.0D;
/* 8484 */       this.YINICIA = 90;
/* 8485 */       this.PXCOL = new int[] { 34, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 665, 710 };
/*      */     }
/*      */     private void initTextLines() {
/* 8488 */       if (this.textLines == null) {
/* 8489 */         this.Lineas = PrefacturaCliente.this.regresaLineas();
/* 8490 */         int num = this.Lineas.length;
/* 8491 */         int numLines = this.Lineas.length;
/* 8492 */         this.textLines = new String[num];
/* 8493 */         for (int i = 0; i < num; i++) {
/* 8494 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 8500 */       Font font = new Font("Serif", 0, 8);
/* 8501 */       FontMetrics metrics = g.getFontMetrics(font);
/* 8502 */       int lineHeight = metrics.getHeight();
/* 8503 */       if (this.pageBreaks == null) {
/* 8504 */         initTextLines();
/* 8505 */         this.orientacion = pf.getOrientation();
/* 8506 */         if (pf.getOrientation() == 1) {
/* 8507 */           this.linesPerPage = 48;
/* 8508 */           this.X = pf.getWidth();
/* 8509 */           this.Y = pf.getHeight();
/*      */         } else {
/* 8511 */           this.linesPerPage = 38;
/* 8512 */           this.X = pf.getWidth();
/* 8513 */           this.Y = pf.getHeight();
/*      */         } 
/* 8515 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 8516 */         this.Pag = numBreaks;
/* 8517 */         this.pageBreaks = new int[numBreaks];
/* 8518 */         for (int b = 0; b < numBreaks; b++) {
/* 8519 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 8522 */       if (pageIndex > this.pageBreaks.length) {
/* 8523 */         return 1;
/*      */       }
/* 8525 */       Graphics2D g2d = (Graphics2D)g;
/*      */       
/* 8527 */       this.g2 = g;
/* 8528 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 8529 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 8530 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 8531 */       encabezado();
/* 8532 */       int y = this.YINICIA + 5;
/* 8533 */       int lineas = y;
/*      */       
/* 8535 */       Font fuente = new Font("Dialog", 0, 6);
/* 8536 */       this.g2.setFont(fuente);
/* 8537 */       for (int line = start; line < end; line++) {
/* 8538 */         y += 9;
/* 8539 */         int Xempe = 35;
/* 8540 */         String valor = "";
/* 8541 */         if (line < 9) {
/* 8542 */           valor = "0" + line + 1;
/*      */         } else {
/* 8544 */           valor = "" + line + 1;
/*      */         } 
/* 8546 */         g.drawString(valor, 18, y);
/* 8547 */         int unit = PrefacturaCliente.this.NOMBRECOL.length - 2;
/* 8548 */         int sub = PrefacturaCliente.this.NOMBRECOL.length - 1;
/* 8549 */         int cuenta = 36;
/* 8550 */         for (int j = 0; j < PrefacturaCliente.this.NOMBRECOL.length; j++) {
/* 8551 */           if (j == unit) {
/* 8552 */             this.g2.drawString(PrefacturaCliente.this.REGIS[line][j], this.PXCOL[12], y);
/* 8553 */           } else if (j == sub) {
/* 8554 */             this.g2.drawString(PrefacturaCliente.this.REGIS[line][j], this.PXCOL[13], y);
/*      */           } else {
/* 8556 */             if (line < PrefacturaCliente.this.jTable5.getRowCount()) {
/* 8557 */               pintar(cuenta - 4, y);
/*      */             }
/* 8559 */             this.g2.drawString(PrefacturaCliente.this.REGIS[line][j], cuenta, y);
/*      */           } 
/* 8561 */           cuenta += PrefacturaCliente.this.COLSELEC[j];
/*      */         } 
/* 8563 */         y += 2;
/* 8564 */         lineas = y;
/*      */       } 
/*      */       
/* 8567 */       g.drawString("Página " + pageIndex + 1, 717, 583);
/*      */       
/* 8569 */       fuente = new Font("Dialog", 1, 9);
/* 8570 */       this.g2.setFont(fuente);
/* 8571 */       g.drawString("FOLIO: ", 18, 78);
/*      */       
/* 8573 */       if (this.Pag == pageIndex) {
/* 8574 */         this.g2.setColor(new Color(204, 0, 0));
/* 8575 */         this.g2.fillRect(615, lineas + 10, 65, 50);
/*      */         
/* 8577 */         this.g2.drawRect(18, lineas + 8, 728, 55);
/* 8578 */         this.g2.setColor(Color.WHITE);
/* 8579 */         fuente = new Font("Arial", 1, 6);
/* 8580 */         this.g2.setFont(fuente);
/* 8581 */         this.g2.drawString("Subtotal", 620, lineas + 16);
/* 8582 */         this.g2.drawString("Descuento", 620, lineas + 25);
/* 8583 */         this.g2.drawString(PrefacturaCliente.this.jLabel23.getText(), 620, lineas + 34);
/* 8584 */         this.g2.drawString(PrefacturaCliente.this.jLabel24.getText(), 620, lineas + 43);
/* 8585 */         this.g2.drawString("Total", 620, lineas + 56);
/*      */         
/* 8587 */         this.g2.setColor(Color.BLACK);
/* 8588 */         fuente = new Font("Arial", 0, 6);
/* 8589 */         this.g2.setFont(fuente);
/* 8590 */         this.g2.drawString(PrefacturaCliente.this.jLabel21.getText(), PrefacturaCliente.this.alinearDer(748, PrefacturaCliente.this.jLabel21.getText().length()), lineas + 16);
/* 8591 */         this.g2.drawString(PrefacturaCliente.this.jFormattedTextField2.getText(), PrefacturaCliente.this.alinearDer(748, PrefacturaCliente.this.jFormattedTextField2.getText().length()), lineas + 25);
/* 8592 */         this.g2.drawString(PrefacturaCliente.this.jLabel22.getText(), PrefacturaCliente.this.alinearDer(748, PrefacturaCliente.this.jLabel22.getText().length()), lineas + 34);
/* 8593 */         this.g2.drawString(PrefacturaCliente.this.jLabel25.getText(), PrefacturaCliente.this.alinearDer(748, PrefacturaCliente.this.jLabel25.getText().length()), lineas + 43);
/* 8594 */         this.g2.drawString(PrefacturaCliente.this.jLabel27.getText(), PrefacturaCliente.this.alinearDer(748, PrefacturaCliente.this.jLabel27.getText().length()), lineas + 56);
/*      */         
/* 8596 */         String comentario = PrefacturaCliente.this.jTextArea3.getText().toUpperCase();
/* 8597 */         String comen1 = "";
/* 8598 */         String comen2 = "";
/* 8599 */         if (comentario.length() > 130) {
/* 8600 */           comen1 = comentario.substring(0, 130);
/* 8601 */           comen2 = comentario.substring(130, comentario.length() - 1);
/*      */         } else {
/* 8603 */           comen1 = comentario;
/*      */         } 
/*      */         
/* 8606 */         this.g2.drawString(PrefacturaCliente.this.leyenda, 22, lineas + 60);
/* 8607 */         this.g2.drawString(comen1, 142, lineas + 50);
/* 8608 */         this.g2.drawString(comen2, 142, lineas + 60);
/*      */         
/* 8610 */         fuente = new Font("Arial", 0, 5);
/* 8611 */         this.g2.setFont(fuente);
/* 8612 */         int xp = 22;
/* 8613 */         int yp = lineas + 20;
/* 8614 */         for (int i = 0; i < PrefacturaCliente.this.RESABREV.length; i++) {
/* 8615 */           if (i == 10 || i == 20) {
/* 8616 */             yp += 12;
/* 8617 */             xp = 22;
/*      */           } 
/* 8619 */           String valor = " " + PrefacturaCliente.this.RESABREV[i].toUpperCase();
/* 8620 */           String aux = "";
/* 8621 */           for (int k = 0; k < valor.length(); k++) {
/* 8622 */             if (valor.charAt(k) == ' ') {
/* 8623 */               aux = aux + aux;
/*      */             }
/*      */           } 
/* 8626 */           this.g2.drawString(aux + ":  " + aux, xp, yp);
/* 8627 */           xp += 60;
/*      */         } 
/*      */       } 
/* 8630 */       this.g2.setColor(Color.WHITE);
/* 8631 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/* 8632 */       return 0;
/*      */     }
/*      */     
/*      */     public void pintar(int x, int y) {
/* 8636 */       this.g2.setColor(Color.WHITE);
/* 8637 */       this.g2.fillRect(x, y - 10, 40, 12);
/* 8638 */       this.g2.setColor(Color.BLACK);
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 8642 */       Font fuente = new Font("Dialog", 0, 8);
/* 8643 */       this.g2.setFont(fuente);
/* 8644 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 8645 */       Image img = imagen.getImage();
/* 8646 */       this.g2.drawImage(img, 35, 7, 50, 50, null);
/* 8647 */       fuente = new Font("Times New Roman", 1, 8);
/* 8648 */       this.g2.setFont(fuente);
/* 8649 */       this.g2.drawString("FORSIS (" + PrefacturaCliente.this.base + ")", 18, 65);
/*      */       
/* 8651 */       this.g2.setColor(new Color(204, 0, 0));
/* 8652 */       this.g2.fillRect(120, 7, 210, 10);
/* 8653 */       this.g2.fillRect(340, 7, 210, 10);
/* 8654 */       this.g2.fillRect(560, 7, 190, 10);
/*      */       
/* 8656 */       this.g2.setColor(Color.WHITE);
/* 8657 */       fuente = new Font("Arial", 1, 7);
/* 8658 */       this.g2.setFont(fuente);
/* 8659 */       this.g2.drawString("DATOS DEL PROVEEDOR", 176, 15);
/* 8660 */       this.g2.drawString("DATOS DEL CLIENTE", 410, 15);
/* 8661 */       this.g2.drawString("PREFACTURA", 626, 15);
/*      */       
/* 8663 */       this.g2.setColor(Color.BLACK);
/* 8664 */       fuente = new Font("Arial", 1, 6);
/* 8665 */       this.g2.setFont(fuente);
/* 8666 */       this.g2.drawString("PROVEEDOR", 120, 27);
/* 8667 */       this.g2.drawString("CALLE", 120, 35);
/* 8668 */       this.g2.drawString("NÚMERO", 120, 43);
/* 8669 */       this.g2.drawString("COLONIA", 120, 51);
/* 8670 */       this.g2.drawString("PAÍS", 120, 59);
/* 8671 */       this.g2.drawString("RFC", 120, 67);
/*      */       
/* 8673 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 170, 27);
/* 8674 */       this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA", 170, 35);
/* 8675 */       this.g2.drawString("KM 32.5", 170, 43);
/* 8676 */       this.g2.drawString("CADEREYTA JIMENES, NUEVO LEÓN 67451", 170, 51);
/* 8677 */       this.g2.drawString("MÉXICO", 170, 59);
/* 8678 */       this.g2.drawString("FMF901004UZ9", 170, 67);
/*      */       
/* 8680 */       String valor = String.valueOf(PrefacturaCliente.this.jComboBox11.getSelectedItem());
/* 8681 */       if (valor.equals("<GENERAL>")) {
/* 8682 */         this.g2.drawString("CLIENTE EN GENERAL", 340, 25);
/*      */       } else {
/* 8684 */         String[] info = PrefacturaCliente.this.con.regresaReg("empresa,calle,num,col,ciudad,cp,rfc", "emp_generadora", "where nombre_corto='" + valor + "'", 7);
/* 8685 */         this.g2.drawString("PROVEEDOR", 340, 27);
/* 8686 */         this.g2.drawString("CALLE", 340, 35);
/* 8687 */         this.g2.drawString("NÚMERO", 340, 43);
/* 8688 */         this.g2.drawString("COLONIA", 340, 51);
/* 8689 */         this.g2.drawString("PAÍS", 340, 59);
/* 8690 */         this.g2.drawString("RFC", 340, 67);
/*      */         
/* 8692 */         this.g2.drawString(info[0], 390, 27);
/* 8693 */         this.g2.drawString(info[1], 390, 35);
/* 8694 */         this.g2.drawString(info[2], 390, 43);
/* 8695 */         this.g2.drawString(info[3] + ", " + info[3] + " " + info[4], 390, 51);
/* 8696 */         this.g2.drawString("MEXICO", 390, 59);
/* 8697 */         this.g2.drawString(info[6], 390, 67);
/*      */       } 
/* 8699 */       fuente = new Font("Arial", 0, 6);
/* 8700 */       this.g2.setFont(fuente);
/* 8701 */       this.g2.drawString("Referencia", 560, 27);
/* 8702 */       this.g2.drawString("Equipo", 560, 37);
/* 8703 */       this.g2.drawString("Pozo", 560, 47);
/* 8704 */       this.g2.drawString("Peso/Viajes", 560, 57);
/* 8705 */       this.g2.drawString("Fecha", 560, 67);
/* 8706 */       this.g2.drawString("Autorizó", 560, 77);
/*      */       
/* 8708 */       Date fecha1 = PrefacturaCliente.this.jDateChooser4.getDate();
/* 8709 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 8710 */       String cadenaFecha = "";
/* 8711 */       cadenaFecha = formato.format(fecha1);
/* 8712 */       String AÑO = cadenaFecha.substring(0, 4);
/* 8713 */       String MES = cadenaFecha.substring(4, 6);
/* 8714 */       String DIA = cadenaFecha.substring(6, 8);
/* 8715 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*      */       
/* 8717 */       this.g2.drawString(PrefacturaCliente.this.jTextField3.getText().toUpperCase(), 625, 27);
/* 8718 */       this.g2.drawString(PrefacturaCliente.this.jTextField11.getText().toUpperCase(), 625, 37);
/* 8719 */       this.g2.drawString(PrefacturaCliente.this.jTextField12.getText().toUpperCase(), 625, 47);
/* 8720 */       if (PrefacturaCliente.this.TONELADA) {
/* 8721 */         this.g2.drawString("" + PrefacturaCliente.this.redondear(Float.parseFloat("" + PrefacturaCliente.this.TONELADASTOTALES)) + "/" + PrefacturaCliente.this.redondear(Float.parseFloat("" + PrefacturaCliente.this.TONELADASTOTALES)), 625, 57);
/*      */       } else {
/* 8723 */         this.g2.drawString("?/" + PrefacturaCliente.this.jTable5.getRowCount(), 625, 57);
/*      */       } 
/* 8725 */       this.g2.drawString(fechaCompleta1, 625, 67);
/* 8726 */       this.g2.drawString(PrefacturaCliente.this.iniciales(), 625, 77);
/*      */       
/* 8728 */       this.g2.setColor(new Color(204, 0, 0));
/* 8729 */       this.g2.fillRect(18, this.YINICIA - 8, 750, 10);
/*      */       
/* 8731 */       this.g2.setColor(Color.WHITE);
/* 8732 */       fuente = new Font("Dialog", 0, 8);
/* 8733 */       this.g2.setFont(fuente);
/* 8734 */       int cuenta = 36;
/* 8735 */       for (int i = 0; i < PrefacturaCliente.this.NOMBRECOL.length - 2; i++) {
/* 8736 */         this.g2.drawString(PrefacturaCliente.this.NOMBRECOL[i], cuenta, this.YINICIA);
/* 8737 */         cuenta += PrefacturaCliente.this.COLSELEC[i];
/*      */       } 
/* 8739 */       this.g2.drawString(PrefacturaCliente.this.NOMBRECOL[PrefacturaCliente.this.NOMBRECOL.length - 2], this.PXCOL[12], this.YINICIA);
/* 8740 */       this.g2.drawString(PrefacturaCliente.this.NOMBRECOL[PrefacturaCliente.this.NOMBRECOL.length - 1], this.PXCOL[13], this.YINICIA);
/*      */       
/* 8742 */       this.g2.setColor(Color.BLACK);
/* 8743 */       fuente = new Font("Dialog", 0, 7);
/* 8744 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 8748 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 8749 */       job.setPrintable(this);
/*      */       
/* 8751 */       PageFormat pf = job.defaultPage();
/* 8752 */       Paper papel = pf.getPaper();
/* 8753 */       papel.setSize(612.0D, 792.0D);
/* 8754 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 8755 */       pf.setPaper(papel);
/* 8756 */       pf.setOrientation(0);
/* 8757 */       job.setPrintable(new ImprimirFactura(), pf);
/* 8758 */       job.defaultPage(pf);
/*      */       
/* 8760 */       boolean ok = job.printDialog();
/* 8761 */       if (ok) {
/*      */         try {
/* 8763 */           job.print();
/* 8764 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public class OtrosConceptos
/*      */   {
/* 8772 */     JTable tabla = new JTable();
/* 8773 */     String[][] VALORES = new String[0][0];
/* 8774 */     int REGISTROS = 0;
/* 8775 */     double SUELDO = 0.0D;
/* 8776 */     int REG = 0;
/* 8777 */     String CANTIDAD = "";
/* 8778 */     String GUIA = "";
/*      */     
/*      */     public OtrosConceptos() {
/* 8781 */       this.tabla = new JTable();
/* 8782 */       this.tabla.setFont(new Font("Tahoma", 0, 10));
/* 8783 */       this.tabla.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Concepto", "Importe", "SubTotal" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 8789 */             boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8794 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 8797 */       PrefacturaCliente.this.jScrollPane11.setViewportView(this.tabla);
/* 8798 */       this.tabla.getColumnModel().getColumn(0).setMinWidth(45);
/* 8799 */       this.tabla.getColumnModel().getColumn(0).setMaxWidth(45);
/* 8800 */       this.tabla.getColumnModel().getColumn(2).setMinWidth(80);
/* 8801 */       this.tabla.getColumnModel().getColumn(2).setMaxWidth(80);
/* 8802 */       this.tabla.getColumnModel().getColumn(3).setMinWidth(80);
/* 8803 */       this.tabla.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 8805 */       this.tabla.getColumnModel().getColumn(2).setCellRenderer(PrefacturaCliente.this.celda);
/* 8806 */       this.tabla.getColumnModel().getColumn(3).setCellRenderer(PrefacturaCliente.this.celda);
/* 8807 */       PrefacturaCliente.this.jTable9 = this.tabla;
/*      */     }
/*      */     
/*      */     public void verDatos() {
/* 8811 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(this.SUELDO));
/* 8812 */       PrefacturaCliente.this.jLabel59.setText(PrefacturaCliente.this.cantidad.getText());
/* 8813 */       PrefacturaCliente.this.jScrollPane11.setViewportView(this.tabla);
/* 8814 */       this.tabla.getColumnModel().getColumn(2).setCellRenderer(PrefacturaCliente.this.celda);
/* 8815 */       this.tabla.getColumnModel().getColumn(3).setCellRenderer(PrefacturaCliente.this.celda);
/*      */       
/* 8817 */       this.tabla.getColumnModel().getColumn(0).setMinWidth(45);
/* 8818 */       this.tabla.getColumnModel().getColumn(0).setMaxWidth(45);
/* 8819 */       this.tabla.getColumnModel().getColumn(2).setMinWidth(80);
/* 8820 */       this.tabla.getColumnModel().getColumn(2).setMaxWidth(80);
/* 8821 */       this.tabla.getColumnModel().getColumn(3).setMinWidth(80);
/* 8822 */       this.tabla.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 8824 */       this.tabla.getColumnModel().getColumn(2).setCellRenderer(PrefacturaCliente.this.celda);
/* 8825 */       this.tabla.getColumnModel().getColumn(3).setCellRenderer(PrefacturaCliente.this.celda);
/*      */       
/* 8827 */       PrefacturaCliente.this.jTable9 = this.tabla;
/* 8828 */       PrefacturaCliente.this.jDialog9.setVisible(true);
/*      */     }
/*      */     
/*      */     public void consultar() {
/* 8832 */       this.tabla.setModel(new DefaultTableModel((Object[][])PrefacturaCliente.this.con
/* 8833 */             .buscarDatos(4, "cant,concepto,importe,subtotal", "facturasotrosconceptos", "where guia='" + this.GUIA + "' order by num"), (Object[])new String[] { "Cant", "Concepto", "Importe", "Subtotal" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 8838 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8843 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 8846 */       PrefacturaCliente.this.LINEASOTROSCONCEPTOS += this.tabla.getRowCount();
/* 8847 */       this.SUELDO = 0.0D;
/* 8848 */       for (int i = 0; i < this.tabla.getRowCount(); i++) {
/* 8849 */         String canti = String.valueOf(this.tabla.getValueAt(i, 3));
/* 8850 */         String valorP = "";
/*      */         
/* 8852 */         for (int j = 0; j < canti.length(); j++) {
/* 8853 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 8854 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 8857 */         this.SUELDO += Double.parseDouble(valorP);
/*      */       } 
/*      */     }
/*      */     
/*      */     public String dameTotal() {
/* 8862 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(this.SUELDO));
/* 8863 */       return PrefacturaCliente.this.cantidad.getText();
/*      */     }
/*      */     
/*      */     public String dameGuia() {
/* 8867 */       return this.GUIA;
/*      */     }
/*      */     
/*      */     public void insertarConcepto(int cant, String concepto, double importe) {
/* 8871 */       PrefacturaCliente.this.LINEASOTROSCONCEPTOS++;
/* 8872 */       double subtotal = cant * importe;
/* 8873 */       DefaultTableModel temp = (DefaultTableModel)this.tabla.getModel();
/* 8874 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(importe));
/* 8875 */       PrefacturaCliente.this.cuadroPrecio.setValue(Double.valueOf(subtotal));
/*      */       
/* 8877 */       Object[] nuevo = { Integer.valueOf(cant), concepto, PrefacturaCliente.this.cantidad.getText(), PrefacturaCliente.this.cuadroPrecio.getText() };
/* 8878 */       this.SUELDO += subtotal;
/* 8879 */       temp.addRow(nuevo);
/*      */       
/* 8881 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(this.SUELDO));
/* 8882 */       PrefacturaCliente.this.jLabel59.setText(PrefacturaCliente.this.cantidad.getText());
/* 8883 */       PrefacturaCliente.this.jTable5.setValueAt(PrefacturaCliente.this.cantidad.getText(), PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getSelectedColumn());
/*      */       
/* 8885 */       String canti = String.valueOf(PrefacturaCliente.this.jTable5.getValueAt(PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 3));
/* 8886 */       String valorP = "";
/*      */       
/* 8888 */       String canti2 = String.valueOf(PrefacturaCliente.this.jTable5.getValueAt(PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 2));
/* 8889 */       String valorP2 = "";
/*      */       int i;
/* 8891 */       for (i = 0; i < canti.length(); i++) {
/* 8892 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 8893 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 8897 */       for (i = 0; i < canti2.length(); i++) {
/* 8898 */         if (canti2.charAt(i) != '$' && canti2.charAt(i) != ',') {
/* 8899 */           valorP2 = valorP2 + valorP2;
/*      */         }
/*      */       } 
/*      */       
/* 8903 */       double valor = Double.parseDouble(valorP) + Double.parseDouble(valorP2);
/* 8904 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(valor));
/* 8905 */       PrefacturaCliente.this.jTable5.setValueAt(PrefacturaCliente.this.cantidad.getText(), PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 1);
/* 8906 */       PrefacturaCliente.this.subTotal();
/* 8907 */       PrefacturaCliente.this.iva();
/* 8908 */       PrefacturaCliente.this.retencion();
/* 8909 */       PrefacturaCliente.this.total();
/*      */     }
/*      */     
/*      */     public void quitarInf(int indice) {
/* 8913 */       PrefacturaCliente.this.LINEASOTROSCONCEPTOS--;
/* 8914 */       DefaultTableModel temp = (DefaultTableModel)this.tabla.getModel();
/* 8915 */       String valor = String.valueOf(PrefacturaCliente.this.jTable9.getValueAt(PrefacturaCliente.this.jTable9.getSelectedRow(), 3));
/* 8916 */       String valorP = "";
/* 8917 */       for (int i = 0; i < valor.length(); i++) {
/* 8918 */         if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 8919 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 8922 */       this.SUELDO -= Double.parseDouble(valorP);
/* 8923 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(this.SUELDO));
/* 8924 */       PrefacturaCliente.this.jTable5.setValueAt(PrefacturaCliente.this.cantidad.getText(), PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getSelectedColumn());
/*      */       
/* 8926 */       String canti = String.valueOf(PrefacturaCliente.this.jTable5.getValueAt(PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 3));
/* 8927 */       valorP = "";
/*      */       
/* 8929 */       String canti2 = String.valueOf(PrefacturaCliente.this.jTable5.getValueAt(PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 2));
/* 8930 */       String valorP2 = "";
/*      */       int j;
/* 8932 */       for (j = 0; j < canti.length(); j++) {
/* 8933 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 8934 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 8938 */       for (j = 0; j < canti2.length(); j++) {
/* 8939 */         if (canti2.charAt(j) != '$' && canti2.charAt(j) != ',') {
/* 8940 */           valorP2 = valorP2 + valorP2;
/*      */         }
/*      */       } 
/*      */       
/* 8944 */       double valorD = Double.parseDouble(valorP) + Double.parseDouble(valorP2);
/* 8945 */       PrefacturaCliente.this.cantidad.setValue(Double.valueOf(valorD));
/* 8946 */       PrefacturaCliente.this.jTable5.setValueAt(PrefacturaCliente.this.cantidad.getText(), PrefacturaCliente.this.jTable5.getSelectedRow(), PrefacturaCliente.this.jTable5.getColumnCount() - 1);
/*      */       
/* 8948 */       PrefacturaCliente.this.subTotal();
/* 8949 */       PrefacturaCliente.this.iva();
/* 8950 */       PrefacturaCliente.this.retencion();
/* 8951 */       PrefacturaCliente.this.total();
/* 8952 */       verDatos();
/* 8953 */       temp.removeRow(indice);
/*      */     }
/*      */     
/*      */     public void definirGuia(String guia) {
/* 8957 */       this.GUIA = guia;
/*      */     }
/*      */     
/*      */     public boolean tieneDatos() {
/* 8961 */       boolean tiene = false;
/* 8962 */       if (this.tabla.getRowCount() == 0) {
/* 8963 */         return false;
/*      */       }
/* 8965 */       return true;
/*      */     }
/*      */     
/*      */     public String regresaCant()
/*      */     {
/* 8970 */       return this.CANTIDAD;
/*      */     }
/*      */   } class null extends DefaultTableModel { boolean[] canEdit; null(Object[][] arg0, Object[] arg1) { super(arg0, arg1); this.canEdit = new boolean[] { false, false, false, false }; } public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; } } class null extends DefaultTableModel { boolean[] canEdit; null(Object[][] arg0, Object[] arg1) { super(arg0, arg1); this.canEdit = new boolean[] { false, false, false, false, false, false, false, false }; }
/*      */     public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4; String[] indices5;
/* 8975 */     public CeldaRender2() { this.otro = -1;
/* 8976 */       this.indices = new String[0];
/* 8977 */       this.indices2 = new String[0];
/* 8978 */       this.indices3 = new String[0];
/* 8979 */       this.indices4 = new String[0];
/* 8980 */       this.indices5 = new String[0]; }
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8983 */       setEnabled((table == null || table.isEnabled()));
/* 8984 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 8985 */       if (comparar2(comp)) {
/* 8986 */         setBackground(new Color(153, 102, 0));
/* 8987 */         setForeground(Color.WHITE);
/* 8988 */       } else if (comparar3(comp)) {
/* 8989 */         setBackground(new Color(102, 153, 255));
/* 8990 */         setForeground(Color.BLUE);
/* 8991 */       } else if (comparar4(comp)) {
/* 8992 */         setBackground(Color.LIGHT_GRAY);
/* 8993 */         setForeground(Color.RED);
/* 8994 */       } else if (comparar5(comp)) {
/* 8995 */         setBackground(Color.RED);
/* 8996 */         setForeground(Color.WHITE);
/*      */       }
/* 8998 */       else if (column == 6) {
/* 8999 */         setBackground(new Color(120, 200, 104));
/* 9000 */         setForeground(Color.black);
/*      */       } else {
/* 9002 */         setBackground((Color)null);
/* 9003 */         setForeground(Color.black);
/*      */       } 
/*      */       
/* 9006 */       if (column == 5 || column == 6) {
/* 9007 */         setHorizontalAlignment(4);
/*      */       } else {
/* 9009 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 9012 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 9013 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 9017 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 9021 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 9025 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 9029 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 9033 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 9037 */       for (int i = 0; i < this.indices.length; i++) {
/* 9038 */         if (this.indices[i].equals(reg)) {
/* 9039 */           return true;
/*      */         }
/*      */       } 
/* 9042 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 9046 */       for (int i = 0; i < this.indices2.length; i++) {
/* 9047 */         if (this.indices2[i].equals(reg)) {
/* 9048 */           return true;
/*      */         }
/*      */       } 
/* 9051 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 9055 */       for (int i = 0; i < this.indices3.length; i++) {
/* 9056 */         if (this.indices3[i].equals(reg)) {
/* 9057 */           return true;
/*      */         }
/*      */       } 
/* 9060 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 9064 */       for (int i = 0; i < this.indices4.length; i++) {
/* 9065 */         if (this.indices4[i].equals(reg)) {
/* 9066 */           return true;
/*      */         }
/*      */       } 
/* 9069 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 9073 */       for (int i = 0; i < this.indices5.length; i++) {
/* 9074 */         if (this.indices5[i].equals(reg)) {
/* 9075 */           return true;
/*      */         }
/*      */       } 
/* 9078 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable {
/*      */     Thread t;
/* 9085 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 9088 */       this.t = new Thread(this);
/* 9089 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 9097 */         Thread.currentThread(); Thread.sleep(1000L);
/* 9098 */         detener();
/* 9099 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 9104 */       PrefacturaCliente.this.consultarGuias();
/* 9105 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 9109 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/PrefacturaCliente.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */